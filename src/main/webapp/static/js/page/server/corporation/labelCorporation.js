/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2015-01-21 11:29:08
 * @version $Id$
 */
require.config({
	baseUrl:YL.STATIC_ROOT+"/js"
});
require(['lib/jquery','util/jquery.placeholder'],function($){
  var com_base = {
  	    init : function () {
  	    	this.custome_tags();
          this.tags_handle();
          this.html5_attr();
  	    },

        /*
         * 自定义标签
         */
        custome_tags : function () {
            $(".btn-paste").click(function(){
                var _this = $(this);
                var tags_tit = _this.prev().val();
                var tags_len = tags_tit.length;
                var tags_tits = [];
                var tags_tips = $(".com-tags-ul").find(".com-tags-tips");
                $(".com-tags-ul").find(".tag-tit").each(function(){
                  return  tags_tits.push($.trim($(this).text()));
                });
                console.log(tags_tits);
                if(tags_len == 0){
                    _this.next(".tips").addClass("valid_wrong").text("标签名不能为空！");
                }else if(tags_tit.length > 6) {
                    _this.next(".tips").addClass("valid_wrong").text("标签名最多6个字符！");
                }else{
                    if ($.inArray($.trim(tags_tit),tags_tits) > -1 ) {
                      _this.next(".tips").addClass("valid_wrong").text("标签已存在,请更换！");
                    }else{
                       if(_this.next(".tips").hasClass("valid_wrong")) {
                          _this.next(".tips").removeClass("valid_wrong").text("");
                       }
                       var tags_ul = $(".com-tags-ul").find("ul").length === 0 ? ("<ul></ul").appendTo($(".com-tags-ul")) :  $(".com-tags-ul").find("ul") ;
                       if(tags_tips.length >= 1) {
                        tags_tips.remove();
                       }
                       tags_ul.append('<li><a class="tag active"><span class="tag-tit">'+tags_tit+'</span></a><i></i></li>');
                       $(".sys-tags-ul").find(".tag-tit").each(function(){
                          if($.trim(tags_tit) ===  $.trim($(this).text()) ){
                            $(this).parent().addClass("active");
                          }
                       });
                    }
              
                }
            });
        },

        /*
         * 标签事件
         */
         tags_handle : function () {
           // 点击删除图标
           $(".com-tags-ul").delegate('i','click',function(e){
                var tags_tit = $.trim($(this).parents("li").find(".tag-tit").text());
                $(this).parents("li").remove();
                $(".sys-tags-ul").find(".tag-tit").each(function(){
                    if($.trim(tags_tit) ===  $.trim($(this).text()) ){
                      $(this).parent().removeClass("active");
                    }
                });

                if($(".com-tags-ul").find("li").length === 0){
                        $(".com-tags-ul").prepend('<p class="com-tags-tips">请填写自定义标签或者点选系统标签构建公司标签</p>');
                  }
              });
           //点击系统图标
           $(".sys-tags-ul").find(".tag").click(function(){
              var _this = $(this); 
              var tags_tit = $.trim(_this.find("span").text());
              var tags_tits = [];
              var tags_tips = $(".com-tags-ul").find(".com-tags-tips");
              $(".com-tags-ul").find(".tag-tit").each(function(){
                  return  tags_tits.push($.trim($(this).text()));
                });
              //del
              if(_this.hasClass("active")){
                 _this.removeClass("active");
                 $(".com-tags-ul").find(".tag-tit").each(function(){
                    if($.trim($(this).text()) === tags_tit){
                      $(this).parents("li").remove();
                      if($(".com-tags-ul").find("li").length === 0){
                        $(".com-tags-ul").prepend('<p class="com-tags-tips">请填写自定义标签或者点选系统标签构建公司标签</p>');
                      }
                    }
                });
              //add
              }else{
                 _this.addClass("active");
                 var tags_ul = $(".com-tags-ul").find("ul").length === 0 ? ("<ul></ul").appendTo($(".com-tags-ul")) :  $(".com-tags-ul").find("ul") ;
                 if(tags_tips.length >= 1) {
                  tags_tips.remove();
                 }
                 //重复添加(自定义|系统)
                 if ($.inArray($.trim(tags_tit),tags_tits) > -1 ) {
                    return ;
                 }
                 tags_ul.append('<li><a class="tag active"><span class="tag-tit">'+tags_tit+'</span></a><i></i></li>');
              }
           })
         },

         /*
          * html 5 fix
          */
          html5_attr : function () {
            //placeholder
            $(".form-con").find("input").placeholder();
            //表单自动获取焦点
            /*var isOperaMini = Object.prototype.toString.call(window.operamini) == '[object OperaMini]';
            var isInputSupported = 'autofocus' in document.createElement('input') && !isOperaMini;
            if(!isInputSupported){
              $("#J-tag-paste").focus();
            }*/
          }

  };
  return com_base.init();

});

