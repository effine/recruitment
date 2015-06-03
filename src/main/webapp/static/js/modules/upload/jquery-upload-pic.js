define(["lib/jquery","util/tips","lib/jquery/ajaxfileupload"],function(jQuery,tips){
	(function($){     
		$.fn.extend({    
			/*
			 * 图片上传插件：
			 * 
			 * file：文件选择框input--"ID"或者jq对象(注意：file必须得用name属性)
	+		 * callback
			 * author:吉鹏 
			 * opt = {
			 *  "url":url,
			 *  "data":data "参数"
			 * }
			 * */
			_ajaxfileupload:function(opt){		
				$(this).click(function(){  			 
					var url = opt.url || "",
				    data= opt.data || {data:""},
				    file = $(this).attr("data-file")? "#"+$(this).attr("data-file") : "",
				    preview = $(this).attr("data-preview") ? "#"+$(this).attr("data-preview") : "";
				    /* 获取上传前展示图片路径 */
				    var fullName=$(this).parent().find("div>img").attr("src");
				    if(/\?+/.test(url)){
				    	url += "?type="+data.type+"&id="+data.id;
				    }else{
				    	url += "?type="+data.type+"&id="+data.id;
				    }	
				   	if(file == ""){
				   		if(window.console) console.log("没有给上传按钮制定:data-file属性");
				   		return;
				   	}	 
	         		$(file).click();
	         	    $(file).change(function(){
	         	    	
	         	    	 if( $(file).val() != ""){   
	         	    		 if(!/\.jpg$|\.jpeg$|\.gif$|\.png$/i.test($(file).val())){
	         	    			 tips.error("上传图片格式不正确,请确保是gif,png,jpeg,jpg图片");
	         	    		 }
	             	    	 $.ajaxFileUpload({
	                              url:url,            //需要链接到服务器地址
	                              secureuri:false,
	                              fileElementId:$(file).attr("id"),   //文件选择框的id属性
	                              dataType:"text",
	                              success: function(data){
	                            	    $(preview).attr("src",data);
	                            	    tips.success("上传成功");
	                            	    if(opt.callback){
	                            	    	opt.callback(data);
	                            	    }
	                              },
	                              error: function (data, status, e)            
	                              {
	                            	  tips.error("上传失败:"+e);
	                              }
	                        });
	         	    	 }
	         	    });    
				});
			}
		});
	})(jQuery);   
});
  