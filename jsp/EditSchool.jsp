<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>vvvvvvvvvvvvvvvvvv</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  .menu{
  display: grid;
    grid-template-columns: 40% 60%;
width: 100%;
background-color:#3d4346;
}

.menu{
  display: grid;
    grid-template-columns: 40% 60%;
width: 100%;
background-color:#1d4d4f;
}



.name{
padding-top: 20px;
text-align:center;
padding-left: 700px;
font-weight: bold;
color: white;
font-size: 35px;
font-family: 'Montserrat', sans-serif;
}


.rightmenu{
padding-left: 80%;
}


.rightmenu ul li {
font-family: 'Montserrat', sans-serif;
display: inline-block;
list-style: none;
font-size: 16px;
color:white;
font-weight: bold;
line-height: 100px;
margin-left: 40px;
text-transform: uppercase;

}

.rightmenu ul li:hover{
color: white;
}
.welcome{
padding-left:650px;
padding-top:15px;
color: black;
font-size: 30px;
font-family: 'Montserrat', sans-serif;
}

#c2{
  display: grid;   
border-radius: 10px;
margin-top: 5px;
}

.bckimg{
background-image:url("bck.png");
}


.pemp{

    display: grid;
    justify-content: center;
    align-content: center;
    height: 80%;
    padding-left: 100pt;

}

button{
background-color:green;
color: white;
border-radius:20px;
width: 250px;
font-size:20px;
font-weight: bold;
}
.fixed-footer{
    width: 100%;
    position:fixed;
    background-color:#1d4d4f;
    padding-left:0px;
    padding-top:5px;
    font-size: 13px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;
	height:30px;
    bottom: 0;
    color:white;
	text-align:center
}

.sidenav {
  height: 85.5%;
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 11%;
  left: 0;
 font-weight: bold;
  background-color:#357376;
  overflow-x: hidden;
  padding-top: 80px;
  text-align: center;
}
.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #f8f2f2;
  display: block;
  font-weight: bold;
}

.sidenav a:hover {
  color: #f1f1f1;
}
  
  
  </style>
  
  
</head>
<body>

<div class= "container-fluid" style="margin: 0px;padding: 0px">

<div class="menu"style="height: 90px">

		<div class="name" style="color: white;font-family: 'Times New Roman', Times, serif"><h2><b>goSchool</b></h4></div>

		<div class="rightmenu">
			<ul>
				<c:if test="${sessionScope.Username!=null && sessionScope.userRole=='school'}">
				<br><b><a style="color: white;" href="logout"></a>
				
				</c:if>
				<c:if test="${sessionScope.Username==null}">
				<c:redirect url="login.jsp"></c:redirect>
				</c:if>
			
			</ul>
		</div>
	</div>
	</div>
	
	
	<div  class="sidenav" style="font-family: 'Times New Roman', Times, serif;">
    <br>
 
  <a href="loginProcess"><h4>SCHOOL DASHBOARD</a>
  </div>

<div class="container" style="padding-top: 30px;padding-left:120px ">
    <table class="table">
    <thead>
     <tr><th colspan="5"><h2><b>School LIST</th></tr>
				<tr>
					<th>School Name</th>
					<th>Address</th>	
					<th>Board</th>
					<th>Medium</th>
				</tr>
    </thead>
    <tbody>
				<tr>
					
					<td>${temp.name}</td>
					<td>${temp.address}</td>
					<td>${temp.board}</td>
					<td>${temp.medium}</td>
					<td><button class="btn btn-block" style="background-color:#6ba8a9 ;color:white;" onclick="window.location.href='schooledit'">EDIT</button><td>
					<td></tr>
					
			  
    </tbody>
  </table>

</div>
<div class="fixed-footer" style="height:30px">Copyright &copy; 2020 goSchool</div>
</body>
</html>