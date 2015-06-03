define(function(){
	return{
		//评测分数模板
		 "tpl_skill_score":[
					'{@each list3 as s}',
						'<p>',
							'<span class="name">${s.skillName}</span>',	
							'<span class="dian">...........................</span>',	
							'<span class="result" style="color:#a6da1b">${s.skillLevel}</span>',	                    
						'</p>'	 , 
					'{@/each}'
			].join(""),
		//技能弹框模板
		 "tpl_skill_win":[
						'<div class="page-skill-win  hide">',
						  '<div class="skill_win_t"><i></i></div>',
						    '<div class="page-skill skill-content yl_skill">',
						        '<div class="tag-pane">',
						           ' <dl>',
						              '{@each skill as item}',
						                '<dt class="pane-category">${item.skill_type}</dt>',
						               ' <dd class="pane-list">',
						                    '<ul>',
						                       '{@each item.skill_opt as opt}',
						                       	 '<li base-tag-id="${opt.skillcode}" ><a href="javascript:void(0);">${opt.skillName}</a></li>',
						                       	 '{@/each}',
						                    '</ul>',
						                '</dd>',
						            '{@/each}',
						            '</dl>',
						        '</div>',
						    '</div>',
						'<div>'
				].join(''),
				
		//教育经历更新模板		
		"eduInfoTpl" :[
						'{@each edu as e}',
							'<ul>',
							     '<li>',
							          '<span class="base-info_enrollTime">${e.enrollTime}~${e.graduateTime}</span>',
							          '<span class="base-info_school">${e.school}</span>',
							          '<span class="base-info_major">${e.major}</span>',
							          '<span class="base-info_degree">${e.degree}</span>',
							     '</li>',
							'</ul>',
						'{@/each}',
						'<h2>奖励经历</h2>',
						'{@each ward as w}',
							'<ul>',
							     '<li>',
							          '<span class="base-info_honor">${w.honor}</span>',
							          '<span class="base-info_levels">${w.levels}</span>',
							          '<span class="base-info_prizeNum">${w.prizeNum}</span>',
							     '</li>',
							'</ul>',
						'{@/each}'
		               ].join(''),
		               
		//项目模块更新模板              
		"projectInfoTpl" :[
				  '{@each company as c}',
					   '<div class="pro-list">',
					        '<span class="base-info_entryTime">${c.entryTime}~${c.turnoverTime}</span>',
					        '<span class="base-info_company">${c.company}</span>',
					        '<span class="base-info_department">${c.department}</span>',
					        '<span class="base-info_positions">${c.positions}</span>',
					   '</div>',
				    '{@each c.resume_child as cc}',
					  '<div class="por-text">',
							'<dl>',
								'<dt><h2 class="base-info_prizeNum">${cc.project}</h2><span><label>使用技能 : </label><strong class="skill">${cc.skills}</strong></span></dt>',
								'<dd class="">${cc.jobDescription.split("##")[0]}</dd>',
								'<dd class="">${cc.jobDescription.split("##")[1]}</dd>',
								'<dd class="">${cc.jobDescription.split("##")[2]}</dd>',
							'</dl>',
					  '</div>',
				    '{@/each}',
				 '{@/each}'
		                   ].join(''),
	};
	
});