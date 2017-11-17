
function myfun(){
var x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,i;

x1=document.getElementById("city").value;
x4=document.getElementById("date").value;
x5=document.getElementById("time").value;
x6=document.getElementById("pickup").value;
x7=document.getElementById("drop").value;
x9=document.getElementById("name").value;
x10=document.getElementById("number").value;
x11=document.getElementById("person").value;
x12=document.getElementById("idcardtype").value;
x13=document.getElementById("idcardno").value;

//for date
var diff =new Date() - new Date(date);

//for time
var utime=document.getElementById("time").value;;
var d = new Date();
var time = d.toString();
var uhr= (utime[1]-'0')+(utime[0]-'0')*10;
var umin= (utime[4]-'0')+(utime[3]-'0')*10;
var shr= (time[17]-'0')+(time[16]-'0')*10;
var smin= (time[20]-'0')+(time[19]-'0')*10;



//to check city 
if(x1.length<1){
document.getElementById("span1").innerHTML="location Cant be empty";
return false;
}
else{
document.getElementById("span1").innerHTML="";
}

//to check a/c or non a/c
if(document.getElementById("service1").checked==false && document.getElementById
("service").checked==false ){
document.getElementById("span2").innerHTML="please select your service";
return false;
}
else{
document.getElementById("span2").innerHTML="";
}


//to check urgent or normal
if(document.getElementById("urgent").checked==false && document.getElementById
("normal").checked==false ){
document.getElementById("span3").innerHTML="please select your service";
return false;
}
else{
document.getElementById("span3").innerHTML="";
}

//to check date
//var today=new Date();

if(x4==""){
    document.getElementById("span4").innerHTML="please select the date!!!!!";
    return false;
}  
else if(new Date() - new Date(x4) > (99999999)){
       document.getElementById("span4").innerHTML="Invalid date, please select a date";
        return false;
    }
else{
document.getElementById("span4").innerHTML="";
}
//to check time
if(x5==""){
document.getElementById("span5").innerHTML="please a time date";
}
else if(uhr>shr){
document.getElementById("span5").innerHTML = "";
}
else if (uhr == shr && umin >= smin){
document.getElementById("span5").innerHTML = "";
}
else{
document.getElementById("span5").innerHTML = " Invalid time, please select a time ";
}

//to check drop location

if(x7.match(x6)){
   document.getElementById("span7").innerHTML="matched with pickup loaction,please change loaction"; 
   return false;
}
else if(x7==""){
document.getElementById("span7").innerHTML="location Cant be empty";
return false;
}
else{
document.getElementById("span7").innerHTML="";
}



//to check name
if(x9==""){
document.getElementById("span9").innerHTML="Name Cant be empty";
return false;
}
else if(x9.length>1){
for(i=0;i<x9.length;i++){
if(isNaN(x9[i])){
document.getElementById("span9").innerHTML="";
}
else{
document.getElementById("span9").innerHTML="please provide only alphabates";

break;
}
}
}



//to check mobile no.

if(x10==""){
document.getElementById("span10").innerHTML="mobile number Cant be empty";
return false;
}
else if(x10.length<10){
 document.getElementById("span10").innerHTML="Mobile NO. Should be 10 Digits";
}
else if(x10.length>1){
for(i=0;i<x10.length;i++){
if(x10[0]==0){
document.getElementById("span10").innerHTML="do not start with Zero";
return false;
}
else if (x10.length>10){
        document.getElementById("span10").innerHTML="please enter 10 digit mobile no";
        return false;
}
else if(isNaN(x10[i])){
document.getElementById("span10").innerHTML="please provide only numbers";
break;
}
else{
document.getElementById("span10").innerHTML="";
}
}
}


//to check max no is 4
{
if(x11.length<1){
document.getElementById("span11").innerHTML="NO of Persons cannot be empty";
return false;
}
else{
document.getElementById("span11").innerHTML="";
}
}
if(x11.length>0){
if(x11=="0"){
document.getElementById("span11").innerHTML=" NO. of Persons cannot be zero";
return false;
}
else if(x11>"4"){
document.getElementById("span11").innerHTML="max NO. of Persons is 4";
return false;
}
}
if(x11.length>1){
document.getElementById("span11").innerHTML=" max NO. of Persons is 4";
return false;
}

//to check id type
if(x12==""){
document.getElementById("span12").innerHTML="ID CARD TYPE cannot be empty";
return false;
}
else{
document.getElementById("span12").innerHTML="";
}

//to check IDCARD NO.
if(x13==""){
document.getElementById("span13").innerHTML="ID number Cant be empty";
return false;
}
else if(x13.length<7){
    document.getElementById("span13").innerHTML="Enter a valid ID no";
    return false;
}
else if(x13.length>1){
for(i=0;i<x13.length;i++){
if(x13[0]==0){
document.getElementById("span13").innerHTML="do not start with Zero";
return false;
}
else{
document.getElementById("span13").innerHTML="";
return true;
}
}
}


}

//dropdown combo
function mycity(){
    
	var selbox= document.login.pickup;
	var selbox1= document.login.drop;
        selbox.options.length=0;
        selbox1.options.length=0;
        
	if(document.login.city.options[document.login.city.selectedIndex].value == "delhi")
	{
		document.login.service[1].disabled=false;
		document.login.service[0].disabled=false;
		
		selbox.disabled=false;
                selbox1.disabled=false;
		selbox.options[selbox.options.length]=new Option('qutb minar','qutb minar');
		selbox.options[selbox.options.length]=new Option('red fort','red fort');
		selbox.options[selbox.options.length]=new Option('lotus temple','lotus temple');
               selbox.options[selbox.options.length]=new Option('dwarka','dwarka');
               selbox1.options[selbox1.options.length]=new Option('qutb minar','qutb minar');
		selbox1.options[selbox1.options.length]=new Option('red fort','red fort');
		selbox1.options[selbox1.options.length]=new Option('lotus temple','lotus temple');
                selbox1.options[selbox1.options.length]=new Option('dwarka','dwarka');
	}
	else if(document.login.city.options[document.login.city.selectedIndex].value == 'mumbai')
	{
		document.login.service[1].disabled=false;
		document.login.service[0].disabled=true;
                
                selbox.disabled=false;
                selbox1.disabled=false;
		selbox.options[selbox.options.length]=new Option('gateway of india','gateway of india');
		selbox.options[selbox.options.length]=new Option('high court','high court');
		selbox.options[selbox.options.length]=new Option('crawfort market','crawfort market');
                selbox.options[selbox.options.length]=new Option('bandra','bandra');
                selbox1.options[selbox1.options.length]=new Option('gateway of india','gateway of india');
		selbox1.options[selbox1.options.length]=new Option('high court','high court');
		selbox1.options[selbox1.options.length]=new Option('crawfort market','crawfort market');
                selbox1.options[selbox1.options.length]=new Option('bandra','bandra');
	}
	else if(document.login.city.options[document.login.city.selectedIndex].value == 'kolkata')
	{
		document.login.service[1].disabled=false;
		document.login.service[0].disabled=true;
                
                selbox.disabled=false;
                selbox1.disabled=false;
		selbox.options[selbox.options.length]=new Option('bidhan nagar','bidhan nagar');
		selbox.options[selbox.options.length]=new Option('howrah','howrah');
		selbox.options[selbox.options.length]=new Option('new town','new town');
                selbox.options[selbox.options.length]=new Option('barrackpore','barrackpore');
                selbox1.options[selbox1.options.length]=new Option('bidhan nagar','bidhan nagar');
		selbox1.options[selbox1.options.length]=new Option('howrah','howrah');
		selbox1.options[selbox1.options.length]=new Option('new town','new town');
                selbox1.options[selbox1.options.length]=new Option('barrackpore','barrackpore');
	}
        else if(document.login.city.options[document.login.city.selectedIndex].value == 'chennai')
        {
                document.login.service[1].disabled=false;
		document.login.service[0].disabled=true;
                
                selbox.disabled=false;
                selbox1.disabled=false;
		selbox.options[selbox.options.length]=new Option('t.nagar','t.nagar');
		selbox.options[selbox.options.length]=new Option('egmore','egmore');
		selbox.options[selbox.options.length]=new Option('thambaram','thambaram');
                selbox.options[selbox.options.length]=new Option('sholinganallur','sholinganallur');
                selbox1.options[selbox1.options.length]=new Option('t.nagar','t.nagar');
		selbox1.options[selbox1.options.length]=new Option('egmore','egmore');
		selbox1.options[selbox1.options.length]=new Option('thambaram','thambaram');
                selbox1.options[selbox1.options.length]=new Option('sholinganallur','sholinganallur');
        }
        else
        {
                document.login.service[1].disabled=true;
		document.login.service[0].disabled=true;
                
                selbox.disabled="disabled";
                selbox1.disabled="disabled";
         }
        
        
}
//when to enable and disable date
function enableElement(elem) {
elem.disabled = false;
}
function disableElement(elem) {
elem.disabled = true;
}

