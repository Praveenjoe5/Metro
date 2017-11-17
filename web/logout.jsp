<%-- 
    Document   : fixed
    Created on : Jun 4, 2016, 12:28:50 PM
    Author     : techm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>
                
        <title>Request A Cab</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="homecss.css">
<style>
	input[type=text],input[type=date],input[type=time], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=submit] {
    width: 50%;
    padding: 12px 20px;
   
    border: 1px solid #ccc;
    
   
    background-color: #99ff99;
}

body {
    background-image: url("ab4.jpg");
    color: whitesmoke;
    
}
span{
    color: yellow;
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


 </head>    
    <body background="mainBG.jpg">

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
        if(!session.isNew())
                       {
        session.invalidate();
        System.out.println("session invalidated");
               }
        %>
    
       
       <br><br> <a href="adminlogin.html">
                <button class="button" >  Login
                </button>
        </a><br><br><br><br><br><br><br>
    <center><h1>LOGGED OUT SUCCESSFULLY</h1></center>
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<ul>

          <a href="aboutus.html"><footer>About Us</footer></a>
        <a href="contactus.html"><footer>Contact Us</footer></a>                                   
        Popular Cars : Mercedes Benz Taxi Cab, Toyota Innova Taxi Cab , 
        Tata Indica Taxi Cab , Chevrolet Tavera 
        
        <div class="ft">Copyright Â© 2016 Merto Technologies Pvt. Ltd. All rights reserved.
        </div>
        

</ul>



     </body>
    </html>
