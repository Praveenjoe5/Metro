<%-- 
    Document   : verification
    Created on : Jun 2, 2016, 12:10:42 PM
    Author     : techm
--%>

<%@page import="com.tm.metrocab.beans.AdminUpdate"%>
<%@page import="com.tm.metrocab.service.AdminUpdateServiceImpl"%>
<%@page import="com.tm.metrocab.service.AdminUpdateService"%>
<%@page import="com.tm.metrocab.util.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
Connection connection=JDBCUtil.getConnection();
 PreparedStatement ps=null;
  ps=connection.prepareStatement("select * from metro");
    ResultSet rs=ps.executeQuery();
   %>


<html>
    <head> 
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="homecss.css">
        
        <style>
        
            input[type=text],[type=date],select {
                
                width: 30%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            
            input[type=submit] {
                
                width: 25%;
                padding: 12px 20px;
                border: 1px solid #ccc;
                background-color: #99ff99;
            }
            
            body {
                
                background-image: url(ab4.jpg);
                -moz-background-size: cover;
                -webkit-background-size: cover;
                background-size: cover;
                background-position: top center !important;
                background-repeat: no-repeat !important;
                background-attachment: fixed;
                
            }
            
            table {
                            border-collapse: collapse;
                            width: 100%;
                        }

                        th{
                            padding: 8px;
                            text-align: left;
                            border-bottom: 1px solid #ddd;
                            background-color: greenyellow;
                            color:black ;
                            
                        }
                        tr{
                            color:whitesmoke;
                        }
                        td {
                            padding: 8px;
                            text-align: left;
                            border-bottom: 1px solid #ddd;
                        }

                        tr:hover{
                            background-color:whitesmoke;
                            color:black;
                        } 
                        
                        form{
                            color:whitesmoke;
                            font-size: 18px;
                        }
                        
                        .button {
                            background-color: green;
                            border: none;
                            color: white;
                            padding: 10px 10px;
                            text-align: center;
                            text-decoration: none;
                            display: inline-block;
                            font-size: 16px;
                            cursor: pointer;
                            width: 150px;
                            float: right;
                            border-radius: 0%;
                        }

                        .button:hover {
                            background-color: red;
                            color: whitesmoke;
                        }

        </style>
        <script>
        
        function myfun(){  
        
        
        var x1;
        var num= /^[0-9]+$/;
        
        x1=document.getElementById("delete").value;
          
        
        //validate bkid
        if(x1.length<1){
        document.getElementById("span1").innerHTML="Booking ID Cannot be empty";
        return false;
        }
        else if(x1.length>5){
            document.getElementById("span1").innerHTML="Max Size of Booking ID is 5";
           return false; 
        }
        else if(x1.length<6){
        if(!x1.match(num)){
        document.getElementById("span1").innerHTML="please provide only numbers";
        return false;
        }
        else{
            document.getElementById("span1").innerHTML="";
            return true;
        }
        }
      }
        function myfun1(){
        
        var x2;
        var num= /^[0-9]+$/;
        x2=document.getElementById("update").value;
        
        //validate bkid
        if(x2.length<1){
        document.getElementById("span2").innerHTML="Booking ID Cannot be empty";
        return false;
        }
        else if(x2.length>5){
            document.getElementById("span2").innerHTML="Max Size of Booking ID is 5";
            return false;
        }
        else if(x2.length<6){
        if(!x2.match(num)){
        document.getElementById("span2").innerHTML="please provide only numbers";
        return false;
        }
        else{
            document.getElementById("span2").innerHTML="";
            
        }
        }
        
        if(document.getElementById("accept").checked==false && document.getElementById
            ("decline").checked==false ){
            document.getElementById("span3").innerHTML="Please select a Status";
            return false;
            }
            else{
            document.getElementById("span3").innerHTML="";
            return true;
         }
       
        }

	   function myfun2(){
            
            var x1,x2;

            x1=document.getElementById("city").value;
            x2=document.getElementById("date").value;
            
            //to check city 
            if(x1.length<1){
            document.getElementById("span8").innerHTML="location Cant be empty";
            return false;
            }
            else{
            document.getElementById("span8").innerHTML="";
            }
            
            //to check date
            if(x2==""){
                document.getElementById("span9").innerHTML="please select the date";
                return false;
                
            }  
            else{
            document.getElementById("span9").innerHTML="";
            return true;
            }

        }
 
              //action="AdminUpdateController" method="post"
              //action="AdminUpdateController" method="post"
        </script>
        
    </head>
    <body>
        
        <header>
            <li> 
                
                <a href="HomePage.html">Home</a>
                                
             </li>
  
                          
            <li> 
                <a href="cabfeatures.html">Cab Features</a>
                
            </li>
  
            <li> 
                <a href="chargedetails.html" >Charge Details</a> 

            </li>
  

        </header>
        <%
        
        System.out.println("Enter....");
        session=request.getSession(false);
        System.out.println(request.getSession().getId());
      String id1=request.getSession().getId();
        System.out.println(session.isNew());
String id=(String)request.getAttribute("id");
if(id1.equals(id)){ %>
    <center><h2><a style="color: aliceblue"> LOGIN NEEDED</a></h2>
        <a href="adminlogin.html" style="text-decoration: none;color: aliceblue"><input type="button" value="LOGIN"/></a>
        </center><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        
        <%
        }
        else{
           System.out.println("Enter....");
           if(session.getAttribute("username")!=null && session.getAttribute("password")!=null){
            String user=(String)session.getAttribute("username");
            String pass=(String)session.getAttribute("password");
            System.out.println("Enter....");
            if(user.equalsIgnoreCase("admin") && pass.equals("admin123")){
                
        %>
        <br>
        
        <a href="logout.jsp">
                <button class="button" >  Logout
                </button>
        </a>
        <br><br>
        <br><br>
        <table border="1">
            <tr>
                <th>Booking Id</th>
                <th>City</th>
                <th>Service</th>
                <th>Service type</th>
                <th>Book date</th>
                <th>Book time</th>
                <th>Pickup place</th>
                <th>Destination</th>
                <th>Landmark</th>
                <th>Customer Name</th>
                <th>Customer Contact</th>
                <th>Person Travel</th>
                <th>Id Card type</th>
                <th>Id Card Number</th>
                <th>Status</th>
                
            </tr>
           
               <%  while(rs.next())
               { %>
                <tr>
                <td> <% out.println(rs.getString(1)); %> </td>
                <td> <% out.println(rs.getString(2)); %> </td>
                <td> <% out.println(rs.getString(3)); %> </td>
                <td> <% out.println(rs.getString(4)); %> </td>
                <td> <% out.println(rs.getString(5)); %> </td>
                <td> <% out.println(rs.getString(6)); %> </td>
                <td> <% out.println(rs.getString(7)); %> </td>
                <td> <% out.println(rs.getString(8)); %> </td>
                <td> <% out.println(rs.getString(9)); %> </td>
                <td> <% out.println(rs.getString(10)); %> </td>
                <td> <% out.println(rs.getString(11)); %> </td>
                <td> <% out.println(rs.getString(12)); %> </td>
                <td> <% out.println(rs.getString(13)); %> </td>
                <td> <% out.println(rs.getString(14)); %> </td>
                <td> <% out.println(rs.getString(15)); %> </td>
               </tr>
               <% }
     
            %>
      
            
                   
        </table>
               <br>
        <br>
            <form action="AdminUpdateController" method="post">
                Booking Id:&nbsp;&nbsp;&nbsp;<input type="text" name="bookid" id="delete"/>
                 <span style="color:yellow"  id=span1></span>
                <br>
                <br>
                <center><input type="submit" value="delete" id="delete"  onclick="return myfun()"/> </center>   
                <br>
                <br>
            </form>
        
        <br>
        
             <form action="AdminUpdateController" method="post">
                Booking Id:&nbsp;&nbsp;&nbsp;<input type="text" name="bookid" id="update"/>
                <span style="color:yellow"  id=span2></span>
                <br>
                <br>
                Status  :
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="status" id="accept" value="approved"/>Accept
                <br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="status" id="decline" value="declined"/>Decline &nbsp;&nbsp;&nbsp;&nbsp; <span style="color:yellow" id="span3" ></span>

                <br>
                <br>
                <center><input type="submit" value="update" id="update" onclick="return myfun1()" /></center>
             </form>
           <br><br>


        <br>
<form action="adminfeedback.jsp" >

            CITY:&nbsp;<select  name="city" id="city"  >
                            <option></option>
                            <option value='mumbai'>Mumbai</option>
                            <option value="delhi">Delhi</option>
                            <option value="kolkata">Kolkata</option>
                             <option value="chennai">Chennai</option>
                      </select> <span  style="color:yellow"  id=span8></span>
    <br>
    <br>
    DATE:&nbsp;<input type="date" name="date" id="date" /> <span  style="color:yellow" id=span9></span>
    <br>

    <center><input type="submit" value="view feedback" onclick="return myfun2()"/></center>
    </form>
<%            
            }
            else{%>
        <center><h2>INVALID USER..CANNOT ACCESS</h2>
        <a href="adminlogin.html" style="text-decoration: none;color: aliceblue"><input type="button" value="LOGIN"/></a>
        </center><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <% 
                
            } 
            
        }
        else{  %>
        <center><h2><a style="color: aliceblue">LOGIN REQUIRED</a></h2>
        <a href="adminlogin.html" style="text-decoration: none;color: aliceblue"><input type="button" value="LOGIN"/></a>
        </center><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <%  }
      }
    %>
<br><br>
<ul>

        <a href="aboutus.html"><footer>About Us</footer></a>
        <a href="contactus.html"><footer>Contact Us</footer></a>
        
</ul> 

    </body>
</html>
