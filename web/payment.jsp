<%@page import="com.tm.metrocab.beans.BankPayment"%>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="homecss.css">
        
        <style>
   
    
    
input[type=text],input[type=month] {
    width: 80%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 100%;
}
table{
    float: left;
}
p {
    font-size: 110%;
    color: sienna;
    
}
input[type=submit] {
    width: 30%;
    padding: 12px 20px;
    border: 1px solid #ccc;
    background-color: #99ff99;
}
input[type=text]:focus {
    border: 3px solid plum;
    color: black;
}

form{
    background-color: #f8b484;
}


</style>
        
<script>
 function myfun(){


var x1=document.getElementById("cardno").value;
var num= /^[0-9]+$/;
var nam= /^[a-zA-Z ]+$/; 
var x2=document.getElementById("cardname").value;
var x3=document.getElementById("validity").value;
var x4=document.getElementById("cvv").value;
var x5=document.getElementById("bankname").value;
var x6=document.getElementById("bookid").value;


       //validate bankname
        if(x5.length<1){
        document.getElementById("span5").innerHTML="bank name Cannot be empty";
        return false;
        }
        else if(x5.length>1){
        if(!x5.match(nam)){
        document.getElementById("span5").innerHTML="please do not type numbers";
        return false;
        }
        else{
            document.getElementById("span5").innerHTML="";

        }
        }


       //validate bookid
        if(x6.length<1){
        document.getElementById("span6").innerHTML="Booking ID Cannot be empty";
        return false;
        }
        else if(x6.length>5){
            document.getElementById("span6").innerHTML="Max Size of Booking ID is 5";
            return false;
        }
        else if(x6.length<6){
        if(!x6.match(num)){
        document.getElementById("span6").innerHTML="please provide only numbers";
        return false;
        }
        else{
            document.getElementById("span6").innerHTML="";
            
        }
        }

//validate card no.
if(x1.length<16){
    document.getElementById("span1").innerHTML="Size of cardno is 16";
      return false;
}
else if(x1.length<1){
document.getElementById("span1").innerHTML="cardno Cannot be empty";
return false;
}
else if(x1.length>16){
    document.getElementById("span1").innerHTML="Max Size of cardno is 16";
      return false;
}
else if(x1.length<17){
if(!x1.match(num)){
document.getElementById("span1").innerHTML="please provide only numbers";
return false;
}
else{
    document.getElementById("span1").innerHTML="";
    
}
}

//card name
if(x2.length<1){
document.getElementById("span2").innerHTML="card name Cannot be empty";
return false;
}
else if(x2.length>1){
if(!x2.match(nam)){
document.getElementById("span2").innerHTML="please do not type numbers";
return false;
}
else{
    document.getElementById("span2").innerHTML="";
    
}
}

//validity

if(x3.length<1){
    document.getElementById("span3").innerHTML="validity Cannot be empty";
    return false;
}
else{
document.getElementById("span3").innerHTML="";
}


//cvv
{
if(x4.length<3){
    document.getElementById("span4").innerHTML="Size of cvv is 3";
      return false;
}
}
if(x4.length<1){
document.getElementById("span4").innerHTML="cvv Cannot be empty";
return false;
}
if(x4.length>3){
    document.getElementById("span4").innerHTML="Max Size of cvv is 3";
      return false;
}
else if(x4.length<4){
if(!x4.match(num)){
document.getElementById("span4").innerHTML="please provide only numbers";
return false;
}
else{
    document.getElementById("span4").innerHTML="";
    return true;
}
}


}           
//action="PaymentCabController" method="post"           
</script>

    </head>
    <body>
        
        
    <center>
            <h1>WELCOME TO <% out.println(request.getAttribute("bankname")); %>ONLINE PORTAL</h1>
    </center>
    
        <BR>
        <BR>
        
        <form action="PaymentCabController" method="post">  
            
            <table>
            
            <tr>
            <td>BANK NAME</td>
            <td><input type="text" name="bankname" id="bankname" value="<% out.println(request.getAttribute("bankname")); %>"/></td>
            <td><span style="color:blue"  id=span5></span></td>
            </tr> 
            
            <tr>
            <td>YOUR BOOKING ID</td>
            <td><input type="text" name="bookid" id="bookid" value="<% out.println(request.getAttribute("bookingId")); %>"/><br></td>
            <td><span style="color:blue"  id=span6></span></td>
            </tr>
                
            <tr>
            <td>CARD NUMBER</td>
            <td><input type="text" name="cardno" id="cardno"  placeholder="Card Number " /></td>
            <td><span style="color:blue"  id=span1></span></td>
            </tr>
                
            <tr>
            <td>CARD HOLDER NAME</td>
            <td><input type="text" name="cardname" id="cardname" placeholder="Your name"/></td>
            <td><span style="color:blue"  id=span2></span></td>
            </tr>
                
            <tr>
            <td>VALIDITY</td>
            <td><INPUT type="month" name="validity" id="validity"  /></td>
            <td><span style="color:blue"  id=span3></span></td>
            </tr>
                
            <tr>
            <td>CVV</td>
            <td><input type="text" name="cvv"  id="cvv" placeholder="CVV"/><br></td>
            <td><span style="color:blue"  id=span4></span></td>
            </tr>
            
            </table>
            
            <center><input type="submit" value="Submit" onclick="return myfun()"/></center>
            
       </form>
    </body>
</html>
