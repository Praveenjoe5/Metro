<%-- 
    Document   : adminfeedback
    Created on : Jun 5, 2016, 8:06:13 AM
    Author     : Raghuram
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.tm.metrocab.util.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adminfeedback</title>
         <link rel="stylesheet" type="text/css" href="homecss.css">
        
        <style>
        
            input[type=text] {
                
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
                color: whitesmoke;
                
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
                        .button1 {
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
                            float: left;
                            border-radius: 0%;
                        }


                        .button1:hover {
                            background-color: royalblue;
                            color: black;
                        }
                        
                        


        </style>
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
       <center>  <h1><% out.println(request.getParameter("city")); %> feedback details</h1></center>
       <%
Connection connection=JDBCUtil.getConnection();
 PreparedStatement ps=null;
  ps=connection.prepareStatement("select * from feedback where city=? and date=?");
  ps.setString(1, request.getParameter("city"));
  ps.setString(2, request.getParameter("date"));
    ResultSet rs=ps.executeQuery();
   %>
   <br>
        
        
        
        <table border="1">
            <tr>
                <th>Booking Id</th>
                <th>Date</th>
                <th>Feedback</th>
                <th>City</th>
                <th>Car Id</th>
                          </tr>
           
               <%  while(rs.next())
               { %>
                <tr>
                <td> <% out.println(rs.getString(1)); %> </td>
                <td> <% out.println(rs.getString(2)); %> </td>
                <td> <% out.println(rs.getString(3)); %> </td>
                <td> <% out.println(rs.getString(4)); %> </td>
                <td> <% out.println(rs.getString(5)); %> </td>
                
               </tr>
               <% }
     
                  %>
        </table>         
                  
                  <br><br><br>
                  
            <center><h1><% out.println("cab details");%></h1></center>
                     
          
                 <h1><% String abc=(String)request.getParameter("city"); %></h1>
                <br>
                 <%
String qq="select * from metro_"+abc+"_cardetails";
  PreparedStatement ps1=connection.prepareStatement(qq);  
    ResultSet rs2=ps1.executeQuery();
   %>
   
                <table border="1">
            <tr>
                <th>Car Id</th>
                <th>Cab Number</th>
                <th>Driver Name</th>
                <th>Employee Number</th>
                <th>Cab Color</th>
                <th>Driver Mobile Number</th>
                          </tr>
           
               <%  while(rs2.next())
               { %>
                <tr>
                <td> <% out.println(rs2.getString(1)); %> </td>
                <td> <% out.println(rs2.getString(2)); %> </td>
                <td> <% out.println(rs2.getString(3)); %> </td>
                <td> <% out.println(rs2.getString(4)); %> </td>
                <td> <% out.println(rs2.getString(5)); %> </td>
                 <td> <% out.println(rs2.getString(6)); %> </td>
               </tr>
               <% } %>
                
                      
                   
        </table>
               <br>
               
               <a href="admin.jsp"/><div class="button1">Back</div></a>

                <br>
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
                <br>
                
<ul>

        <a href="aboutus.html"><footer>About Us</footer></a>
        <a href="contactus.html"><footer>Contact Us</footer></a>
        

</ul>
                
    </body>
</html>
