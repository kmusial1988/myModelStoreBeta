function validateAddBrand(){
    var name = document.forms["addBrandForm"]["name"].value;
    var Shortcut = document.forms["addBrandForm"]["Shortcut"].value;

     var regex = new RegExp(/.{2}.*/);
     var flag = true;

     if(!regex.test(name)){
             document.forms["addBrandForm"]["name"].style.background = "#f2d9e6";
             flag = false;
         }else{
             document.forms["addBrandForm"]["name"].style.background = "white";
         }
         if(!regex.test(Shortcut)){
             document.forms["addBrandForm"]["Shortcut"].style.background = "#f2d9e6";
             flag = false;
         }else{
             document.forms["addBrandForm"]["Shortcut"].style.background = "white";
         }
         return flag;
}