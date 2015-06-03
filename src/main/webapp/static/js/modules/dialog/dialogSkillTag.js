define(['lib/jquery','modules/dialog/dialog','util/juicer'],function($,dialog,juicer){
	var skillTag = {
			tpl : [
					'<div class="skill-tag-box ">',
						'<div class="box-item skill-tags clearfix" >',
						   '<label>常用标签：</label>',
						   '<ul class="tags-ul skill-tags-ul clearfix">',
						      '<li><a class="tag active"><span>C++</span><em></em></a></li>',
						      '<li><a class="tag "><span>C++</span><em></em></a></li>',
						      '<li><a class="tag "><span>C++</span><em></em></a></li>',
						   '</ul>',
						'</div>',
						'<div class="box-item skill-ipt clearfix">',
						  '<label>添加标签：</label>',
						  '<div class="ipt-box">',
						      '<input type="text" name="" class="ipt"/>',
						      '<p class="tags-tips">每个标签最多6个字符,多个标签请用";"分隔</p>',
						  '</div>',
						'</div>',
						'<div class="box-operate">',
						   '<a href="javascript:;" class="btn-sure">确定</a><a href="javascript:;" class="btn-cancel">取消</a>',
						'</div>',
					'</div>'
					].join(''),
			 /*
			  * @param opt.callback {fn}  opt.json {json} 
			  */
			init : function (opt) {
				var skillOpt = {
			             dialog_id:'J-skill-tag'       
			            ,dialog_tit:'添加技能标签'
			            ,dialog_body: opt.json ? juicer(skillTag.tpl,opt.json) : skillTag.tpl
			            ,dialog_theme : 'dialog-shadow'
			            ,click_mask_fire : true
			      };
				  if(opt.callback){
					  dialog(skillOpt,opt.callback);
				  }else{
					  dialog(skillOpt);
				  }
			      
			}
	}
	return skillTag.init;
	 
});