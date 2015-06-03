/**
 * 模态框插件，定义了模板，构造和析构函数
 */
define(["lib/jquery","util/juicer"],function($,juicer){
	/**
	  *	@constructor:ylDialog
	  *	@param opts{}
	  *	@returns {initDialog,fireDialog}
	  **/
	//dialog(opt);
	
	var dialog = {
			//全局模板
			"dialog_tpl":[
				         '<div id="${dialog_id}" class="dialog" >',
					         '<div class="dialog-header">',
					           '<h2>${dialog_tit}</h2>',
					           '<a href="javascript:;" class="dialog-close"></a>',
					         '</div>',
					         '<div class="dialog-body clearfix">$${dialog_body}</div>',
					         '<div class="dialog-footer">${dialog_footer}</div>',
				         '</div>',
				         '<div class="dialog-masklayer"></div>'
				         ].join(''),
		    //初始化方法
			"init":function(opt){
				//初始化弹框
				dialog.initDialog(opt);
				//销毁弹框
				dialog.fireDialog(opt);
			},
			//初始化弹框
			"initDialog":function(opts){
				
				 var optdef={
						 dialog_id:''	 
						,dialog_tit:''
						,dialog_body:'' //html_str
						,dialog_footer:''
						,dialog_theme : '' //主题
						,click_mask_fire:false
						,callback:null
					 },
					 opt=$.extend(optdef,opts),
					 dialog_html=juicer(this.dialog_tpl,opt);
					 if(opt.dialog_body){
						 /*
						  * 重复的dialog
						  */
						 var _dialog=$(".dialog");
						 if(_dialog.length>0)
							 {
							    _dialog.remove();
							 }
						
						//有主题
						 if(opt.dialog_theme  === "dialog-shadow"){ 
							 $(dialog_html).appendTo('body');
							var  _dialog =   $(".dialog");
							var  _mark   =   $(".dialog-masklayer");
								_dialog.addClass(opt.dialog_theme);
								_mark.addClass(opt.dialog_theme);
									 //位置设置
							 		dialog.reposition();
								 	_dialog.css({"top":0,"opacity":0});
								    _dialog.animate({"top":'40%',"opacity":1},100);
								 	//关闭事件
								 	$(this).find('#J-plugins-close').click(function(){
								 		  $(self).animate({"top":0,"opacity":0},100,function(){
								 			  $(this).css({"display":"none"});
								 			 $("#markbg").remove();
								 		  });
								 	})
								 	$("#markbg").click(function(){
								 		  $(self).animate({"top":0,"opacity":0},100,function(){
								 			  $(this).css({"display":"none"});
								 			 $("#markbg").remove();
								 		  });
								 	})
						 }else{
							 //位置设置
							 dialog.reposition();
						 }
						 if(opt.callback) opt.callback(); 
			   			
					  }
			},
			//销毁弹框
			"fireDialog":function(opt){
				var  dialog_close=$(".dialog-close")
			        ,dialog=$(".dialog")
			        ,dialog_mask=$(".dialog-masklayer");
			 
				dialog_close.on("click",function(){
					 //有主题
					 if(opt.dialog_theme  === "dialog-shadow"){
						 dialog.animate({"top":0,"opacity":0},100,function(){
						 	 dialog.remove();
			 			  	 dialog_mask.remove();
					 	 });
					 }else{
						 dialog.remove();
						 dialog_mask.remove(); 
					 }
					
					 if(opt.cancleCallback)opt.cancleCallback();
			   });
			 
			 //遮罩层单击关闭
			 if(opt.click_mask_fire)
				 {
				   dialog_mask.on("click",function(){
					   
					   //有主题
					   if(opt.dialog_theme === "dialog-shadow"){
							 dialog.animate({"top":0,"opacity":0},100,function(){
							 	 dialog.remove();
				 			  	 dialog_mask.remove();
						 	 });
						 }else{
							 dialog.remove();
		    				 dialog_mask.remove();
						 }
				 	});
				 }
			},
			//调整位置
			"reposition":function(){
				$(".dialog").css({
					marginTop: -($(".dialog").outerHeight() / 2) + 'px',
					marginLeft: -($(".dialog").outerWidth() / 2) + 'px'
				});
			},
			//窗口调整内部dialog自调整
			"maintainPosition":function(){
				switch(status) {
					case true:
						$(window).on('resize', function() {
							reposition();
						});
					break;
					case false:
						$(window).off('resize');
					break;
				}
			}
	};
	
	return dialog.init;
});