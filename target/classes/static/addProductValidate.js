function validateAddProduct(){
    var name = document.forms["addProductForm"]["name"].value;
    var barcode = document.forms["addProductForm"]["barcode"].value;
    var pieces = document.forms["addProductForm"]["pieces"].value;
    var price = document.forms["addProductForm"]["price"].value;


     var regexName = new RegExp(/[A-Za-z]*.{2}.*/);
     var regexBarcode = new RegExp(/[0-9]*.{4}.*/);
     var regexPieces = new RegExp(/[0-9]*.{1}.*/);
     var regexPrice = new RegExp(/[0-9].[0-9]/);


     var flag = true;

     if(!regexName.test(name)){
           document.forms["addProductForm"]["name"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["addProductForm"]["name"].style.background = "white";
         }
     if(!regexBarcode.test(barcode)){
           document.forms["addProductForm"]["barcode"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["addProductForm"]["barcode"].style.background = "white";
         }
     if(!regexPieces.test(pieces)){
           document.forms["addProductForm"]["pieces"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["addProductForm"]["pieces"].style.background = "white";
          }
     if(!regexPrice.test(price)){
           document.forms["addProductForm"]["price"].style.background = "#f2d9e6";
           flag = false;
     }else{
           document.forms["addProductForm"]["price"].style.background = "white";
           }
     return flag;
}