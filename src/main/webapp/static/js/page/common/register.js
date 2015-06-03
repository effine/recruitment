/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2015-01-21 11:29:08
 * @version $Id$
 */
require.config({
	baseUrl:YL.STATIC_ROOT+"/js"
});
require(['lib/jquery','lib/jquery/Validform'],function($){
  var reg = {
  	    init : function () {
  	    	this.regTabs();
  	    	this.regRadio();
  	    	this.regValidate();
  	    },

  	    /*
  	     * form验证
  	     */
  	    regValidate : function () {
  	    	$(".reg-form").each(function(){
  	    		var _form = $(this);
  	    		_form.Validform({
  	    			//自定义验证
  	    			datatype :{
  	    				//example :13916752109或0712-3614072
						//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
						"m-t" : function(gets,obj,curform,regxp){
									var ipt_v = $.trim(gets);
									var tel_reg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;//电话
									var mobile_reg = /^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/;  //手机
									if(!mobile_reg.test(ipt_v) && !tel_reg.test(ipt_v)){
									   return "请输入正确的手机号码或电话号码!";
									}
									return true;
								}
							},

  	    			beforeSubmit : function () {
  	    				if(!_form.find(".reg-radio").hasClass("active")){
  	    					_form.find(".isagr").addClass("Validform_wrong").text("请勾选云路服务条款！");
  	    				}else{
  	    					_form.find(".isagr").removeClass("Validform_wrong").text("");
  	    				}
  	    			},
  	    			callback : function () {

  	    			},
					tiptype : function (msg,o,cssctl) {
							var objtip = o.obj.parent().next(".tips");
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
  	    	});
  	    }, 

  	    /*
  	     * 服务条款
  	     */
        regRadio : function () {
        	$(".reg-radio").click(function(){
        		$(this).toggleClass("active");
        	});
        },
  	    /*
  	     * 注册选项卡切换
  	     */
  		regTabs : function () {
  			var tabsA = $(".reg-tabs").find("a");
  			    tabsA.each(function(){
  				    var self = $(this); 
  				    self.click(function(){
						//var index=self.parent().index();
						var _form = self.attr("data-form");
						if(!/^(stu|tea|com)$/.test(_form)) return ;
	  					if(!self.hasClass("active")){
	  						tabsA.removeClass("active");
	  						self.addClass("active");
	  						//$(".reg-form").find(".reg-form-item").addClass("hide").eq(index).removeClass("hide");
	  						$("#reg-"+_form).removeClass("hide").siblings().addClass("hide");
  					   }
  				    });
  					
  			});
  		}
  };
  return reg.init();

});