<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="p" %>
<%@ include file="no-cache-page.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>   
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>     
<p:url var ="url_logout" value="/logout"></p:url>






<!DOCTYPE html>
<html>
<head>
<title>Homepage</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CPT+Serif:400,700,400italic' rel='stylesheet'>
 <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans" rel="stylesheet">
</head>

<style type="text/css">

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
color: brown;
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
    padding-left:20px;
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
  font-size: 22px;
  color: #f8f2f2;
  display: block;
  font-weight: bold;
}

.sidenav a:hover {
  color: #f1f1f1;
}


</style>
<body style="background-color: ">
<div class= "container-fluid" style="margin: 0px;padding: 0px">
<div class="menu"style="height: 90px">

<div class="name" style="color: white;font-family: 'Times New Roman', Times, serif"><h2><b>goSchool</b></h4></div>

<div class="rightmenu">
<ul>
<% if(request.getSession().getAttribute("Username")!=null){%>
<br>

<%}%>
<c:if test="${sessionScope.Username!=null && sessionScope.userRole=='admin'}">
<b><button class="btn btn-block" style="background-color:#6ba8a9 ;color:white;" onclick="window.location.href='logout'">Logout</button></b>
</c:if>
<c:if test="${sessionScope.Username==null}">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
</ul>
</div>
</div>
    <div  class="sidenav" style="font-family: 'Times New Roman', Times, serif;">
  <br><a href="adminstdlist"><h2>Manage Student</a>
  <a href="admSchoolList"><h2>Manage School</a>
  <a href="#clients"><h2>View Notification</a>
</div>
   
       

    </div>
<div class="fixed-footer" style="height:30px">Copyright &copy; 2020 goSchool</div>


 <script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</body>
</html>
