/**
 *
 */
define(['lib/jquery','./umeditor.config','./umeditor'],function($){
	/*UM 编辑器相关*/
	 var editor=function(){
		 //获取编辑器内容
   		 function getEditorCon(id){
				var arr = [];
				arr.push(UM.getEditor(id).getContent());
				return arr.join("\n");
			}
   		 //设置内容
   		 function setEditorCon(id,html){
   			    UM.getEditor(id).setContent(html);
			}
   	   //初始化编辑器
   		 function initEditor(id,opts){
				 var editor_URL=YL.STATIC_ROOT+"/js/modules/umeditor/";
					var optdef={
							UMEDITOR_HOME_URL:editor_URL
							,lang:"zh-cn"
							,langPath:editor_URL +"lang/"
							,fontsize:[12, 16, 18, 20, 24, 36]
//						    ,initialFrameWidth:"700px"
					};
					var opt=$.extend(optdef,opts||{});
					UM.getEditor(id,opt);
   		 }
   		 function delEditor(id)
   		 {
   			 UM.clearCache(id);
   			 UM.delEditor(id);
   		 }
   		 return {
   			 getEditorCon:getEditorCon,
   			 setEditorCon:setEditorCon,
   			 initEditor:initEditor,
   			 delEditor:delEditor
   		 }
	 }();
	 return editor;
});