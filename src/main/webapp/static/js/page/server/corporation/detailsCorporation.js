/**
 * 
 * @authors Your Name (you@example.org)
 * @date    2015-01-21 11:29:08
 * @version $Id$
 */
require.config({
	baseUrl:YL.STATIC_ROOT+"/js"
});
require(['lib/jquery','modules/umeditor/umeditor-u'],function($,umeditor){
  var com_detail = {
  	    init : function () {
  	        this.editor();
  	        this.save();
  	        this.word_count();
  	    },

        /*
         * 编辑器
         */
        editor : function () {
          /* 初始化editor   */
          umeditor.delEditor("curtext-editor");
          var opt_editor = {
              toolbar : [
                        'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor |',
                        'insertorderedlist insertunorderedlist |paragraph  fontfamily fontsize' ,
                        '| justifyleft justifycenter justifyright justifyjustify |',
                        'link unlink'
                    ],
              initialContent : "请填写公司介绍，可以为您争取到更多优秀入职人员！",
              autoClearinitialContent :  true,
              wordCount:true,
              maximumWords:1000
          }
          umeditor.delEditor("com-intro");
          umeditor.initEditor("com-intro",opt_editor);
        },
        
        /*
         * 保存介绍
         */
        save : function () {
        	$("#J-intro-save").click(function(){
        		var com_intro_html = $("#com-intro").html();
        		
        	});
        },
        
        /*
         * 字数检测
         */
        word_count : function () {
        	$("#com-intro").keyup(function(){
        		console.log("!!!!!");
        		var max_len = 1000;
        		var con_len = $("#com-intro").text();
        		var dif_len = max_len - con_len;
        		if(dif_len >=0 ){
        			$(".editor-tips").find("span").text(dif_len);
        		}
        	})
        }
  	   
  	  
  };
  return com_detail.init();

});

