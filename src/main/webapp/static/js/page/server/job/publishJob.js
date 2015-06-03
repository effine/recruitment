/**
 * 发布新职位
 * 
 * */

require.config({
	barseUrl:YL.STATIC_ROOT+'/js'
})

require(["lib/jquery","lib/jquery/jquery.placeholder","modules/umeditor/umeditor"],
		function($,placeholder,umeditor){
	
	var publishJob = {
			init:function(){
				//初始化文本编辑框
				publishJob.textEdiator();
			},
			//职位描述，文本编辑框
			textEdiator:function(){
				var toolbar = [
					            'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor |',
					            'insertorderedlist insertunorderedlist |paragraph  fontfamily fontsize' ,
					            '| justifyleft justifycenter justifyright justifyjustify |',
					            'link unlink'
					        ];
				umeditor.delEditor("editor");
				umeditor.initEditor("editor","");
			}
		
	}
	
})