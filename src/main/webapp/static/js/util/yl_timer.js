/**
 * 
 */
define(["lib/jquery"],function($){
	;$.fn.numeral = function() {     
        $(this).css("ime-mode", "disabled");     
        this.bind("keypress",function(e) {    
          var code = (e.keyCode ? e.keyCode : e.which);  //兼容火狐 IE
             if(!/msie/.test(navigator.userAgent.toLowerCase())&&(e.keyCode==0x8))  //火狐下不能使用退格键     
              {     
                  return ;     
                }     
                 return code >= 48 && code<= 57;     
         });    
         this.bind("blur", function() {     
            if(this.value.indexOf("\/")>-1)
            {
              var  year=this.value.replace(/(\d*)\/\d*/,"$1");
               var month=this.value.replace(/\d*\/(\d*)/,"$1");
               if(month=="") month="01";
               if(month.length==1) month="0"+month;
               $(this).val(year+"/"+month);
           }
            
       });     
 
         this.bind("keyup", function(e) {     
              var code = (e.keyCode ? e.keyCode : e.which);
               var val=this.value;
               if(!isNaN(parseInt(val))&&val.length==4)
               {
                  
                  if(code!=8)//增加
                  {

                    $(this).val(val+"/");
                  }
                  
               }else if(val.length>4)
               {

                 if(code==8&&val.indexOf("\/")&&val.length==5)//删除
                  {
                     $(this).val(val.substring(0,3));
                  }
                  if(val.indexOf("\/")==-1)
                  {
                      $(this).val(val.substring(0,4)+"/"+val.substring(4));
                  }
                  var _valLast=$(this).val();
                  if(_valLast.length>=8)
                	  {
                	  	$(this).val(_valLast.substring(0,7));
                	  }
               }
         });     
     };
});