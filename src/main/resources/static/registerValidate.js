function validateRegister(){
    var name = document.forms["registerForm"]["name"].value;
    var surname = document.forms["registerForm"]["surname"].value;
    var login = document.forms["registerForm"]["login"].value;
    var password = document.forms["registerForm"]["password"].value;
    var password2 = document.forms["registerForm"]["password2"].value;


     var regexNameSurname = new RegExp(/[A-Z]{1}[A-Za-z]*[0-9]*.{3}.*/);
     var regexLoginPass = new RegExp(/[A-Za-z]*[0-9]*.{3}.*/);



     var flag = true;

     if(!regexNameSurname.test(name)){
           document.forms["registerForm"]["name"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["registerForm"]["name"].style.background = "white";
         }
     if(!regexNameSurname.test(surname)){
           document.forms["registerForm"]["surname"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["registerForm"]["surname"].style.background = "white";
         }
     if(!regexLoginPass.test(login)){
           document.forms["registerForm"]["login"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["registerForm"]["login"].style.background = "white";
          }
     if(!regexLoginPass.test(password)){
           document.forms["registerForm"]["password"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["registerForm"]["password"].style.background = "white";
           }
     if(password != password2){
           document.forms["registerForm"]["password2"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["registerForm"]["password2"].style.background = "white";
           }
     return flag;
}