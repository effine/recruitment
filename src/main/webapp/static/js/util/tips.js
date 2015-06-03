/**
 * 代替老旧的alert框，直接在屏幕最上方显示信息 
 * 
 * 
 **/
define(['lib/jquery'],function($){
	return {
			"successTpl":"<div class='successTpl tips_tpl' style='z-index:99999;text-align:center;height:0;line-height:40px;width:100%;font-size:18px;position:fixed;top:0;left:0;color:#fff;background:#00cca3;'></div>",
			"errorTpl":"<div class='errorTpl tips_tpl'  style='z-index:99999;text-align:center;height:0;line-height:40px;width:100%;font-size:18px;position:fixed;top:0;left:0;color:#fff;background:red;'></div>",
			"waitingTpl":"<div class='waitingTpl tips_tpl'  style='z-index:99999;text-align:center;height:0;line-height:40px;width:100%;font-size:18px;position:fixed;top:0;left:0;color:#fff;background:#00cca3;'></div>",
			"add":function(tpl,msg,tpl1){
				//清除以前的
				$(".tips_tpl").stop().css({"height":"0"});
				$(".tips_tpl").remove();
				$(tpl).appendTo("body");
				$("."+tpl1).html(msg);
				$("."+tpl1).animate({"height":"40px"},function(){
					$(this).animate({"opacity":"0"},3000,function(){
						$(this).css({"height":"0"});
					});
				});
			},
			"success":function(msg){
				this.add(this.successTpl,msg,"successTpl");			
			},
			"error":function(msg){
				this.add(this.errorTpl,msg,"errorTpl");
			},
			"waiting":function(msg){
				//清除以前的
				$(".tips_tpl").stop().css({"height":"0"});
				$(".tips_tpl").remove();
				$(this.waitingTpl).appendTo("body");
				$(".waitingTpl").html(msg);
				$(".waitingTpl").animate({"height":"40px"},function(){
					$(this).animate({"opacity":"1"},3000);
				});
			}
	}
});