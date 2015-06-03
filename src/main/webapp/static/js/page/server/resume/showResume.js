/**
 * @desc:个人简历
 * @date : 2015-01-28
 * @author by zw
 */

/**
 * @des  简历
 */
require.config({
	baseUrl:YL.STATIC_ROOT+"/js",
});
require(function(common,$,juicer,tips,resumeTpl,loadImage,picJian,judgeLogin){
	
        /*skill Json*/
	    var skill_json=

    	
	    /*
		 *method findArr 递归调用
		 * intro : 封装json
		 * 仅仅针对单个父级封装val    根据后面调用动态分配数据key
		 */
			function findArr(d_this){
				d_this=(d_this instanceof jQuery) ? d_this : $(d_this);
				//第1层
				var info_arr=[];
					d_this.siblings(".resume-del").each(function(){
						//第2层

						/*限定在del子元素中循环*/
						var info_obj={};
								var del_this=$(this);
								var temp ="";
								del_this.children("input,select").each(function(){
									var _this=$(this);
									var info_name=_this.attr("name");
									if(_this.val() == _this.attr("placeholder")) _this.val("");
									    if("jobDescription"==info_name)
										{
										  temp+=_this.val()+"##";
										  if(info_name)
											{
										     	info_obj[info_name]=temp;
											}
										}else
											{
												if(info_name)
												{
											     	info_obj[info_name]=_this.val();
												}
											}
								});
								
								/*是否有子元素*/
									var resume_child=$(".resume-add",del_this);
									resume_child.each(function(){
										var info_inner=findArr($(this));
										
										if(info_inner.length>0)
										{
											info_obj["resume_child"]=info_inner;
										}
									});
									
    						if(info_obj)
    						{
    							 info_arr.push(info_obj);
    						}
					});
					return info_arr;
    		}
			//other 时间  elem_p:容器
		      $("input.resume-time").numeral();
		      
			/*验证*/
			function infocheck(fn_call){
				   var ajaxForm =  $("#J_resume_body_form").Validform({
	  					ajaxPost:true,
	  					callback:fn_call,
	  					tiptype:function(msg,o,cssctl){
	  						var objtip=$("#RegError");
	  						cssctl(objtip,o.type);
	  						if(o.type!=2) {
	  							$("#J_resume_body_form").attr("data-request","fail");
	  						}
	  						objtip.text(msg);
	  					}
	  				});
		  			   //配置当前表单提交地址
		  			   ajaxForm.config({
		  				    url:"/resumeAction/saveResume"
		  				});
	  			   }
    	
    	//显示影藏
    	function resumeToggle(e_this,e_mode,e_mode_str){
    		    var flag=e_this.hasClass("resume-btn-save");
    			var e_mode_elem=e_this.parents("."+e_mode);
    			var e_input=e_mode_elem.find("."+e_mode_str+"-input");
    			var e_from=e_mode_elem.find("."+e_mode_str+"-view");
    			/*
    			 * @pramter info_obj{json}  section{string}:当前模块
    			 */
				var _show=function(section,info_obj){
					
					//静态填充数据
					var sec_tpl = "",
					    sec_Html = "",
					    section_view ="";
					
					//个人信息
					if(section === "per-base-info") {
						$("#uploadStuProBtn").removeClass("hide");
						var birthDate="";
						e_input.find("input,select").each(function(){
							var name=$(this).attr("name");
							var tag=$(this)[0].tagName.toLowerCase();
							var val="";
							if(tag=="select" && !/^(year|month)$/.test(name))
								{
							 			  val= $("select[name='"+name+"']").find("option:selected").text();
								}else
									{
									  val=  $(this).val();
									  if(name=="gender")
										  {
										    if(val=="1") val="男";
										    if(val=="0") val="女";
										  }
									}
						   	$("[class='"+e_mode_str+"_"+name+"']",e_from).text(val);
						}); 
						//出生年月
						birthDate=$(".year",e_input).val()+"/"+$(".month",e_input).val();
							$("[class='"+e_mode_str+"_time']",e_from).text(birthDate);
						$("#uploadStuProBtn").addClass("hide");
					//教育经历
					}else if(section ==="per-edu-info") {
						 sec_tpl=resumeTpl.eduInfoTpl;
						 sec_Html=juicer(sec_tpl,info_obj);
						 section_view=section.replace(/^per\-/,"")+"-view";
						$("."+section_view).empty().html(sec_Html);
					//项目经历
					}else if(section ==="per-project-info") {
						 sec_tpl=resumeTpl.projectInfoTpl;
						 sec_Html=juicer(sec_tpl,info_obj);
						 section_view=section.replace(/^per\-/,"")+"-view";
						$("."+section_view).empty().html(sec_Html);
					
					//自我介绍
					}else if(section === "per-introself-info") {
						 section_view=section.replace(/^per\-/,"")+"-view";
						 sec_Html=$("#introself-textarea").val();
						 if(!$.trim(sec_Html)){
							 sec_Html="描述自己，让企业快速的了解你。你的故事、梦想、态度以及生活中的闪光点。";
						 }
						$("."+section_view).empty().html(sec_Html);
					}
					e_this.removeClass("resume-btn-save");
    				e_from.removeClass("hide");
    				e_input.addClass("hide"); 
				};
				//保存	
    			if(flag)
    			{
    				
    				//个人信息ajax
    				if(e_mode==="per-base-info")
    					 {
    				
    					infocheck(function(data){
	  						if(data.responseText=="success")
	  							{
	  							   $("#RegError").removeClass().empty();
	  							   $("#J_resume_body_form").attr("data-request","success");
	  							   _show(e_mode);
	  							}
	  						});
   	   			     		$("#J_resume_body_form").submit();
    	   			     	 
    			  } 
    				//教育-获奖ajax
   					if(e_mode==="per-edu-info")
   					{
   						//获取ajax json
   						var  one_first=$(".btn-first",e_input);
	    				var  info_obj={};
	    				for(var i=0;i<one_first.length;i++)
	    				{
	    					var title=$(one_first[i]).parent().attr("data-title");//需要改其它存储属性
	    					info_obj[title]=findArr($(one_first[i]));//调用数组对象
	    				}
	    				
	    				
	    				
   						var edu=[],edu_reward=[];
						
						
						 $.ajax({
   	   					  type : 'POST',
   	   					  url : "/resumeAction/saveEdu",
   	   			          data: {"edus":JSON.stringify(info_obj)},
   	   					  success : function() {
   	   						    // ylAlert("保存成功！");
   	   						   _show(e_mode,info_obj);
   	   					   }
   	   			     	 });
   					}
    				//项目ajax
    				if(e_mode==="per-project-info")
   					{
   						
    					//获取ajax json
    					var  one_first=$(".btn-first",e_input);
	    				var  info_obj={};
	    				for(var i=0;i<one_first.length;i++)
	    				{
	    					var title=$(one_first[i]).parent().attr("data-title");//需要改其它存储属性
	    					info_obj[title]=findArr($(one_first[i]));//调用数组对象
	    				}
	    				
	    				
	    				
	    				
	    				 $.ajax({
	   	   					  type : 'POST',
	   	   					  url : "/resumeAction/saveProject",
	   	   			          data:{"com":JSON.stringify(info_obj)},
	   	   					  success : function() {
	   	   						    // ylAlert("保存成功！");
	   	   						   _show(e_mode,info_obj);
	   	   					   }
	   	   			     	 }); 
    					
   					}
    				//自我描述ajax
    				if(e_mode==="per-introself-info")
   					{
    					
    					$.ajax({
  	   					  type : 'POST',
  	   					  url : "/resumeAction/saveResumeStmt",
  	   			          data:$('#J_resume_statement_form').serialize(),// 你的formid
  	   					  success : function() {
  	   						    // ylAlert("保存成功！");
  	   						    _show(e_mode);
  	   					   }
  	   			     	 });
   					}
    					
	    				/*ajax*/
	    				/*写入info中*/
    			//编辑
    			}else{
	    				e_this.addClass("resume-btn-save");
	    				e_from.addClass("hide");
	    				e_input.removeClass("hide");
	    				//修改图片
	    				if(e_mode==="per-base-info"){
	    				     $(".per-img").find(".per-upload-img").toggleClass("hide");
	    				}
	    				//默认表单
	    				
	    				
    			}
					/*
						e_this.toggleClass("resume-btn-save");
	    				e_from.toggleClass("hide");
	    				e_input.toggleClass("hide"); 
    				*/
    	}
    	//添加|删除
    	function resumeChange(e_this,e_mode){
    		//添加
    		if(e_mode=="resume-add"){
    			var mode_def=e_this.parent().siblings(".resume-def");
    			var mode_def_temp=mode_def.clone();
    			if(e_this.parent().parent().hasClass("pro-com-input"))
    			{
    				mode_def_temp.removeClass().addClass("resume-del pro-skills");
    			}else
    			{
    				mode_def_temp.removeClass().addClass("resume-del");
    			}
    			/*表单默认值*/
    			$(mode_def_temp).placeholder();
    			/*时间*/
    			$("input.resume-time",mode_def_temp).numeral();
    			mode_def.before(mode_def_temp);
    		}else if(e_mode=="resume-del")
    		{
    			$.ylMessager.confirm("确认删除该条信息？",null,function(res){
	   				if(res)
	   					{
		   					var delid=e_this.parent().attr("data-delid");
		       				if(!delid)
		       					{
		       					e_this.parent().remove();
		       					return ;
		       					}
		       				var e_type=e_this.parent().parent().attr("class");
		       				var url ="";
		       				//教育
		       				if(e_type=="edu-edu-input")
		       					{
		       					   url="/resumeAction/removeEdu.action";
		       					}
		       				//奖励
		       				if(e_type=="edu-reward-input")
		       					{
		       					   url="/resumeAction/removeHonor.action";
		       					}
		       				//公司
		       				if(e_type=="pro-com-input")
		       					{
		       					   url="/resumeAction/removeCom.action";
		       					}
		       				//项目
		       				if(e_type=="pro-pro-input")
		       					{
		       					   url="/resumeAction/removePro.action";
		       					}
		       				if(url==="") return;
		   	    				$.ajax({
		   	    					url:url,
		   	    					type:"post",
		   	    					data:{"id":delid},
		   	    					success:function(res){
		   	    						if(res){
		   	    	    					e_this.parent().remove();
		   	    						}
		   	
		   	    					}
		   	    				});
		   				 }
    			
    			});
    		}
    		

    	}
    	
    	
    	//入口
    	$("#J_per-resume").on('click',function(e) {
    		/* Act on the event */
    		var elem=$(e.target);
    		var e_mode=elem.attr("data-mode");
    		var e_this=$(elem);
    		switch(e_mode){
    			/*导出简历*/
    			case "resume-export":
    			//TODO 预留导出简历 fn
    				judgeLogin(function(){
    					var id_ = $("#J_resume_id").val();
        				if(id_){
        					 $.ajax({
     	    					url:"/resumeAction/removeChart",
     	    					type:"post",
     	    					success:function(){
//     	    						ExportMyChart();
     	    						//导出图片
     	    						 setTimeout(ExportMyChart(), 500);
     	    						//等待效果TODO
     	    						 setTimeout("window.location.href='/resumeAction/export.action'", 5000);
     	    					}
     	    				});
        				}else{
        					tips.error("请完善简历基本信息保存后再导出简历");
        				}
    				});
    			break;
    			case "per-base-info":
    			case "per-edu-info":
    			case "per-project-info":
    			case "per-introself-info":
    				/*表单默认值*/
    				if(e_mode!="per-base-info"){
    					e.preventDefault();
    					$("."+e_mode).placeholder();
    				 }
	    				if(e_mode.indexOf("per-")>-1)
	    	    		{
	    	    			/**
	    	    			 * 简历class非per-后缀
	    	    			 * 拼接通用的class统一方法
	    	    			 */
	    					var e_mode_str=e_mode.replace(/^per\-/,"");
	    	    		}
	    				judgeLogin(function(){resumeToggle(e_this,e_mode,e_mode_str);});
    			break;
    			case "resume-add":
    					judgeLogin(function(){resumeChange(e_this,e_mode);});
    			break;
    			case  "resume-del":
    					judgeLogin(function(){resumeChange(e_this,e_mode);});
    			break;

    		}
    		
    	});
    	//other
    	//外侧单击隐藏
    	$("#bd").click(function(e){
    		var elem=$(e.target);
    		if(elem.parents(".pro-skill").length>0||elem.parents(".page-skill-win").length>0||elem.hasClass("pro-skill")||elem.hasClass("page-skill-win"))
    			{
    				e.stopPropagation();
    			}else
    				{
    				 $(".page-skill-win").addClass("hide");
    				 $(".skill").removeClass("skill_cur");
    				}
    	});
    	
    	//自我描述
    	(function(){
    		    var text=$("#introself-textarea").val();
			        var counter=text.length;
			        $("#word_count").html(parseInt(200-counter));
			    $(document).keyup(function() {
			        var text=$("#introself-textarea").val();
			        var counter=text.length;
			        $("#word_count").html(parseInt(200-counter));
			    });	
    	})();
    					    
    	//other 性别切换
    	
    	$(".icon-radio").on("click",function(e){
    			e.preventDefault();
    			var elem=$(e.target);
    			var e_icon=elem.parents(".icon-radio");
    			var e_sb=elem.parent().siblings().children('i');
    			var e_val="";
    			if(e_icon&&elem.hasClass('icon-radio-nor'))
    			{
    				if(!elem.hasClass('icon-radio-cur'))
    				{
    					elem.addClass('icon-radio-cur');
    					if(elem.parent().hasClass("male")){
        						e_val="1";
    					}else if(elem.parent().hasClass("female"))
    						{
        						 e_val="0";
    						}
    				}
    				if(e_sb.hasClass('icon-radio-cur'))
    				{
    					e_sb.removeClass('icon-radio-cur');
    				}
    			}
    			
    			//J_gender_switch
    			$("#J_gender_switch").val(e_val);
    	}) ;
    	
    	//other 技能添加
    	$(".project-info").delegate(".skill", "click", function(e) {
    	    e.preventDefault();
    	    var elem = $(e.target);
    	    var tag = elem.hasClass("skill");
    	    var elem_p = elem.parent(".pro-skill");
    	    if (tag) {
    	    	/*刷新skill win 位置*/
                /*获取当前选项卡的坐标位置  */
                
                var offset_l=elem[0].offsetLeft;
                var offset_t=elem[0].offsetTop;
                var elem_w=elem.width();
                //当前元素标志
                if(!elem.hasClass("skill_cur"))
            	{
            	   elem.addClass("skill_cur").siblings().removeClass("skill_cur");
            	}else{
            		elem.removeClass("skill_cur");
            	}
    	        //动态生成技能块
    	        if (elem_p.length > 0 && elem_p.siblings(".page-skill-win").length == 0) {
    	        	var tpl_skill_win=resumeTpl.tpl_skill_win;
    	            var skill_html = juicer(tpl_skill_win, skill_json);
    	            elem_p.before(skill_html);
    	             var e_arr= elem_p.find(".skill-opt");
    	             e_arr.each(function(){
    	            	 var e_skill_n=$(this).text();
    	            	 //查找li-->a text相等元素
    	            	 elem_p.prev(".page-skill-win").find("dl dd li a").each(function(){
    	            		 if($(this).text()==e_skill_n)
    	            			 {
    	            			 	$(this).parent().addClass("active");
    	            			 }
    	            		 
    	            	 });
    	            	 
    	             });
    	              
    	        }
    	        //hide 同辈skill win
    	        elem.parent().parent().siblings().find(".page-skill-win").addClass("hide");
    	        //hide 父辈同辈skill win
    	        elem.parents(".pro-skills").siblings(".pro-skills").find(".page-skill-win").addClass("hide");
    	        //去除其他skill元素标志
    	        elem.parent().parent().siblings().find(".pro-skill").children().removeClass("skill_cur");

    	        var skill_win = elem.parent().siblings(".page-skill-win");
				
//     	        if (skill_win.hasClass("hide")) {
    	        	 if(!elem.hasClass("skill_cur"))
    	            	{
    	        		  skill_win.addClass("hide");
    	            	}else{
    	            		skill_win.removeClass("hide");
    	            	}
				    
				     var skill_win_w=skill_win.width();
				     var move_w=Math.floor((skill_win_w-elem_w)/2)-60;
				     skill_win.css({"left":offset_l,"top":offset_t+30});
    	            if (!$(".page-skill", skill_win).hasClass("mCustomScrollbar")) {

    	                $(".page-skill", skill_win).mCustomScrollbar({
    	                    scrollInertia: 150,
    	                });
    	                skill_win.find(".page-skill").mCustomScrollbar("update");
    	              
    	                /*绑定skill点击事件*/

    	                $(".tag-pane", skill_win).on("click", function(e) {
    	                    var elem = $(e.target);
    	                    var e_tag = elem[0].tagName.toLowerCase();
    	                    var e_id = -1;
    	                    var e_name = "";
    	                    if (e_tag == "a") {
    	                        e_id = elem.parent().attr("base-tag-id");
    	                        e_name = elem.text();


    	                        /*右侧技能更新*/
    	                        var skill_r = skill_win.siblings(".pro-skill");
    	                       // var elem_r_skill = $(".skillid" + e_id, elem_p);
    	                        var skill_r_arr = skill_r.children(".skill-opt");
    	                        var ishave=false;//是否
    	                        var i=0,len=skill_r_arr.length;
    	                        for(i;i<len;i++)
    	                        	{
    	                        	 		if($(skill_r_arr[i]).attr("data-name")==e_name)
    	                        	 			{
	    	                        	 			ishave=true;
	    	                        	 			break;
    	                        	 			}
    	                        	}
    	                        
    	                        if(ishave)
                      		  {
//	                        		  elem_r_skill.remove();
										$(skill_r_arr[i]).remove();
	    	                            elem.parent().removeClass("active");
	    	                            skill_r_arr = skill_r.children(".skill-opt");
	    	                            if (skill_r_arr.length == 0) {
	    	                                //防止而已删除加号
	    	                                if ($("strong.def", skill_r).length == 0) {
	    	                                    $("<strong class=\"skill def\">+</strong>").appendTo(skill_r);
	    	                                }
	    	                                $("strong.def", skill_r).removeClass("hide").show();
	    	                            }
	    	                            //add
	    	                   } else {
	    	                        	skill_r_arr = skill_r.children(".skill-opt");//重新获取jquery对象.实时刷新length
	    	                            //max 5
	    	                            if (skill_r_arr.length < 5) {
	    	                                elem.parent().addClass("active");
//	    	                                $("<strong class='skill skill-opt skillid" + e_id + "'>" + e_name + "</strong>").appendTo(skill_r);
												$("<strong class='skill skill-opt' data-name='"+e_name+"'>" + e_name + "</strong>").appendTo(skill_r);
	    	                                if (!skill_r.find(".def").hasClass("hide")) {
	    	                                    skill_r.find(".def").addClass("hide").hide();
	    	                                }
	    	                            }
	    	                        }
    	          
    	                        //添加到skills-input
    	                        var skill_input=skill_win.siblings("input.skill-list");
    	                        var skill_v="";
    	                        skill_r_arr = skill_r.children(".skill-opt");//重新获取jquery对象.实时刷新length
    	                        for(var i=0;i<skill_r_arr.length;i++)
    	                        	{
    	                        	  skill_v+=$(skill_r_arr[i]).text()+"，";
    	                        	}
    	                        skill_v=skill_v.replace(/，$/,"");	
    	                        skill_input.val(skill_v);
    	                    }
    	                });
    	            }

    	    }

    	});

    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
 			
 			
//other
 			/*
 			 * 简历技能图标
 			 */
 			 $("#J_know_station").change(function(){
 	 			  skill_chart($("#J_know_station").val());
 	 		   });
 	 		   
 	 		    function chart_t(knoCode){
 	 		    	
 	 			    knoCode= knoCode || $("#BruceDiv").attr("data-knowId");
 	 			    if(knoCode!=null&&knoCode!=""){
 	 			    	var bruceChart = new FusionCharts("/static/js/swf/Radar.swf",
 	 			    			"myChartId", "300", "260", "0", "1");
 	 			    	bruceChart.setXMLUrl("/usertestAction/getStatistics?knoId="+knoCode);
 	 			    	bruceChart.render("BruceDiv"); 
 	 			    }
 	 		   };
 	 		    chart_t();
 	 			function skill_chart(knoCode){
 	 				 chart_t(knoCode);
 	 	           
 	 				  $.ajax({
  	 	            	 url : "/resumeAction/getWENZI",
  	 	            	 data : {"knoId":knoCode},
  	 	            	 type : "post",
  	 	            	 success :function(data){
  	 	 	            	 if(data.list3.length  > 0) {
  	 	 	            		  var tpl_skill=resumeTpl.tpl_skill_score;
  	 	 	 		              var skill_html = juicer(tpl_skill,data);
  	 	 	 		              $("#J_skill-info").empty().html(skill_html);
  	 	 	            		 } else {
  	 	 	            			 $("#J_skill-info").empty().html('<p>您尚未测试过该岗位！</p>' +
  	 	 	            			 		'<a class="btn-indivi-test" href="/usertestAction/toTest?knoId='+knoCode+'" target="_blank">开始测试</a>');
  	 	 	            		 }
  	 	 	             }
  	 	            	 
  	 	             });
 	 			}
 	 			
 	 			 function ExportMyChart() {
 	 	             var chartObject = getChartFromId('myChartId');
 	 	             //chartObject.print();
 	 	             if(chartObject.hasRendered()){
 	 	            	 chartObject.exportChart({ exportAtClient: '0', exportFormat: 'JPEG' });
// 	 	            	 window.location.href='/resumeAction/export.action';
 	 	              }
 	 	         }
 	 			 
 	 			 
 	    /*
 	     * 头像上传
 	     */
 	 			var stuPro={
 	 				"profileCropWin":"",
 	 			  "init" : function() {
 	 				stuPro.uploadPic();
 	 				stuPro.uploadHeadPic();
 	 				stuPro.cutPic();
 	 				stuPro.sureCutPic();
// 	 				stuPro.save();
 	 			  },
			//打开，关闭上传新照片窗口，
				"uploadPic":function(){
					stuPro.profileCropWin = $("#profileCropWin").html();
					$('#uploadStuProBtn').on("click",function(e){
						judgeLogin(function(){
							$('#profileCropWin').toggleClass("hide");
						});
					});
					$('#profileCropWin').on('click',function(e){
						var targetObj = e.target;
						if($(targetObj).hasClass('btn-win-del')){
							$('#profileCropWin').toggleClass("hide");
						}
					});
				},
 	 			"uploadHeadPic":function(){
 					$("#J-stuInf-up")._ajaxfileupload({
 						 'url':"/cmn/file/upload/web",
 						 'data':
 						    {
 								"type": "user",
 								"id": -1
 							},
 						'callback':function(imgUrl){
 							picJian.jcrop_api.destroy();
 							$("#profileCropWin").html(stuPro.profileCropWin);
 							$(".jcrop-preview").attr("src",imgUrl);
 							stuPro.cutPic();
 							stuPro.uploadHeadPic();
 							stuPro.sureCutPic();
 						}

 					});
 				},
 				//裁剪图片
 				"cutPic":function(){
 					//保证图片能找到才能确定裁剪,如果图片404，那么显示默认图片
 					loadImage(
 							$('#albumedit_img').attr("src"),
 						    function (img) {
 						        if(img.type === "error") {
 						        	$('.jcrop-preview').attr("src","/static/images/resume-def.jpg");
 						        } 
 						        picJian.init({
 									"preview_pane": $('#exhibitionPreview'),
 									"preview_container":$('.preview-container'),
 									"img":$("#imageForCoverPreview"),
 									"target":"#albumedit_img",
 									"button":$("#submitCropBtn")
 								});
 						    }
 						);
 				},
 				//确定裁剪
 				"sureCutPic":function(){
 					$("#submitCropBtn").unbind().click(function(){
 						var self = this;
 						var win_img=$('#albumedit_img').attr('src');
 						if(win_img.indexOf("defaultphoto.jpg")>-1)
 							{
 							$.ylMessager.alert("请选择上传的图片!");
 							  return false;
 							}
 							if($("#submitCropBtn").attr("w") ==  undefined)
 							{
 								$.ylMessager.alert("请裁剪图片");
 								return false;
 							}
 						$.post('/cmn/user/imgCut',
 								{w:parseInt($(self).attr("w")),h:parseInt($(self).attr("h")),x:parseInt($(self).attr("x")),y:parseInt($(self).attr("y")),filename:$("#albumedit_img").attr("src")},function(data){
 							if(data){
 								$("#profileCropWin").toggleClass("hide");
 								picJian.jcrop_api.destroy();
 								$("#profileCropWin").html(stuPro.profileCropWin);
 								$(".jcrop-preview").attr("src",data);
 								$(".nav-pimg > img").attr("src",data);
 								$("#J_per-img").attr("src",data);
 								
 								$("#avatar").val(data);//保存到input
 								stuPro.cutPic();
 								stuPro.uploadHeadPic();
 								stuPro.sureCutPic();
 							}else{
 								$.ylMessager.alert("裁剪失败，请稍后再试!");
 							}
 						});
 					});
 				}
 	 		};
 	 			stuPro.init();
	
});