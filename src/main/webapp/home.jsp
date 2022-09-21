<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        To Get All Customers:
    <form action = "Customers"><br>
    <input type ="submit"><br>
    </form><br>



      To Add/Update Customers:
    <form action = "addCustomers">
    <input type = "text" name = "ID">ID<br>
    <input type ="text" name = "NAME">NAME<br>
    <input type ="text" name= "ADDRESS">ADDRESS<br>
    <input type="text" name="PHONE">PHONE<br>
    <input type ="submit"><br>
    </form><br>
     To Fetch Customers:
    <form action ="getCustomers">
   <input type = "text" name = "ID">ID<br>
     <input type ="submit"><br>
    </form><br>
     To Delete Customers:
    <form action ="deleteCustomers">
   <input type = "text" name = "ID">ID<br>
     <input type ="submit"><br>
    </form>
    
    <a href= "/logout">Logout</a>


</body>
</html>