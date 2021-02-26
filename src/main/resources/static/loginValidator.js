function validate() {
    var login = document.forms["loginForm"]["login"].value;
    var pass = document.forms["loginForm"]["password"].value;


    var regex = new RegExp(/.{3}.*/);
    var flag = true;
    

    if(!regex.test(login)){
        document.forms["loginForm"]["login"].style.background = "#f2d9e6";
        flag = false;
    }else{
        document.forms["loginForm"]["login"].style.background = "white";
    }
    if(!regex.test(pass)){
        document.forms["loginForm"]["password"].style.background = "#f2d9e6";
        flag = false;
    }else{
        document.forms["loginForm"]["password"].style.background = "white";
    }
    return flag;
}