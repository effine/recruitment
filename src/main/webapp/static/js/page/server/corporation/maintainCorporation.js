/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2015-01-21 11:29:08
 * @version $Id$
 */
require.config({
	baseUrl:YL.STATIC_ROOT+"/js"
});
require(['lib/jquery','lib/jquery/Validform','modules/upload/jquery-upload-pic'],function($){
  var com_base = {
  	    init : function () {
  	    	this.regValidate();
  	    	this.reviseLogoPic();
  	    },

  	    /*
  	     * form验证
  	     */
  	    regValidate : function () {
  	    	$(".form-base").Validform({
  	    		
  	    			callback : function () {

  	    			},
					tiptype : function (msg,o,cssctl) {
							var objtip = o.obj.next(".tips");
							    if(o.type==2){
								  cssctl(objtip,o.type);
								  objtip.text("").removeClass("Validform_right");
								}else{
								 cssctl(objtip,o.type);
								 objtip.text(msg);
								}
							},
  	    			ajaxPost : true
  	    		});
  	    },

  	    /*
  	     * 文件上传
  	     */
  	    reviseLogoPic : function(){
			/* 上传图片 */
			$("#J-btn-upload-pic")._ajaxfileupload({
				 'url':"",
				 'data': {
					
				 }
			});
		},
		
  	   
  	  
  };
  return com_base.init();

});

