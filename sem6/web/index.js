var led=new Array();
  		  			function _(e) {
  						return document.getElementById(e);
  					}

						
  		  			function trainer() {
  		  				led[0]=_('c4');
  						led[1]=_('c3');
  						led[2]=_('c2');
  						led[3]=_('c1');
  						led[4]=_('d2');
  						led[5]=_('d1');
  					}
  		  			
  		  			
  		  			window.onload=function(){
  		  				trainer();
  		  	  			
  		  	  			display('friend');
  		  			}
  		  			
  		  			
  		  			
  		  			function display(s){
  		  				var i=0;
  		  				for(i=0;i<s.length;i++){
  		  					led[i].innerHTML=s[i];
  		  				}
  		  				while(i<led.length){
  		  					led[i].innerHTML=" ";
  		  					i++;
  		  				}
  		  				
  		  				
  		  			}
  		  			
  		  			