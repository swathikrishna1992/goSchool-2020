<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>about Us</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
    font: 400 15px Lato, sans-serif;
    line-height: 1.8;
    color: #e5dfdf;
  }

  .sidenav {
  height: 86.5%;
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 75px;
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
  h2 {
    font-size: 24px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;
    margin-bottom: 30px;
    
  }
  h4 {
    font-size: 19px;
    line-height: 1.375em;
    color: #303030;
    font-weight: 400;
    margin-bottom: 30px;

  }  
  .jumbotron {
    background-color: #f4511e;
    color: #fff;
    padding: 100px 25px;
    font-family: Montserrat, sans-serif;
  }
  .container-fluid {
    padding: 60px 50px;
  }
  .bg-grey {
    background-color: #f6f6f6;
  }
  .logo-small {
    color: #f4511e;
    font-size: 50px;
  }
  .logo {
    color: #f4511e;
    font-size: 200px;
  }
  .thumbnail {
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
  }
  .thumbnail img {
    width: 100%;
    height: 100%;
    margin-bottom: 10px;
  }
  .carousel-control.right, .carousel-control.left {
    background-image: none;
    color: #f4511e;
  }
  .carousel-indicators li {
    border-color: #f4511e;
  }
  .carousel-indicators li.active {
    background-color: #f4511e;
  }
  .item h4 {
    font-size: 19px;
    line-height: 1.375em;
    font-weight: 400;
    font-style: italic;
    margin: 70px 0;
  }
  .item span {
    font-style: normal;
  }
  .panel {
    border: 1px solid #f4511e; 
    border-radius:0 !important;
    transition: box-shadow 0.5s;
  }
  .panel:hover {
    box-shadow: 5px 0px 40px rgba(0,0,0, .2);
  }
  .panel-footer .btn:hover {
    border: 1px solid #f4511e;
    background-color: #fff !important;
    color: #f4511e;
  }
  .panel-heading {
    color: #fff !important;
    background-color: #f4511e !important;
    padding: 25px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 0px;
    border-top-right-radius: 0px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 0px;
  }
  .panel-footer {
    background-color: white !important;
  }
  .panel-footer h3 {
    font-size: 32px;
  }
  .panel-footer h4 {
    color: #aaa;
    font-size: 14px;
  }
  .panel-footer .btn {
    margin: 15px 0;
    background-color: #f4511e;
    color: #fff;
  }
  .navbar {
    margin-bottom: 0;
    background-color: #f4511e;
    z-index: 9999;
    border: 0;
    font-size: 12px !important;
    line-height: 1.42857143 !important;
    letter-spacing: 4px;
    border-radius: 0;
    font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
    color: #fff !important;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
    color: #f4511e !important;
    background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
    border-color: transparent;
    color: #fff !important;
  }
  .menu{
  display: grid;
    grid-template-columns: 40% 60%;
width: 120%;
background-color:#1d4d4f;
color: white;
}

  footer .glyphicon {
    font-size: 20px;
    margin-bottom: 20px;
    color: #f4511e;
  
  }
  

.name{
padding-top: 20px;
text-align:center;
padding-left: 700px;
font-weight: bold;
color: white;
font-size: 35px;
font-family: 'Montserrat', sans-serif;




  padding: 30px 16px;
  background-color:#1d4d4f;
  color: #f1f1f1;
  position: fixed;
  top: 0;
  width: 100%;

}
.rightmenu{
padding-left: 80%;
color: white;
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
color: white;
font-size: 30px;
font-family: 'Montserrat', sans-serif;
}
  .slideanim {visibility:hidden;}
  .slide {
    animation-name: slide;
    -webkit-animation-name: slide;
    animation-duration: 1s;
    -webkit-animation-duration: 1s;
    visibility: visible;
    margin-left: 200px;
    margin-top: 100px;
  }
  @keyframes slide {
    0% {
      opacity: 0;
      transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      transform: translateY(0%);
    }
  }
  @-webkit-keyframes slide {
    0% {
      opacity: 0;
      -webkit-transform: translateY(70%);
    } 
    100% {
      opacity: 1;
      -webkit-transform: translateY(0%);
    }
  }
  @media screen and (max-width: 768px) {
    .col-sm-4 {
      text-align: center;
      margin: 25px 0;
    }
    .btn-lg {
      width: 100%;
      margin-bottom: 35px;
    }
  }

  

.fixed-footer{
    width: 100%;
    position:fixed;
    background-color:#3d4346;
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
  @media screen and (max-width: 480px) {
    .logo {
      font-size: 150px;
    }
  }
  </style>
</head>

   
<body style="background-color: #e5dfdf">
    
    <div class="row" style="padding-left: 50%;background-color: #1d4d4f">
        <h2 style="color: white;">goSchool</h2>
    
      </div>
     <div class="sidenav" style="font-family: 'Times New Roman', Times, serif;background-color: #357376">
        <div  class="sidenav" style="font-family: 'Times New Roman', Times, serif;background-color: #357376;">
            <br><a href="/springmvc-user-reg-login/">HOME</a>
            <a href="aboutus">ABOUT US</a>
            <a href="contactus">CONTACT US</a>
          </div>
        


     </div>
  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
  
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"A Building With Four Walls And Tomorrow Inside!"<br><br><span>Home Of Quality Schools Where Students Come First...!</span></h4>
      </div>
      <div class="item">
        <h4>"Working collaboratively to ensure every student achieves academically, socially, and emotionally."<br><br><span>We Work Best When We Work Together!</span></h4>
      </div>
      <div class="item">
        <h4>"The Place To Be"<br><br><span>Your dreams are tied with a key, School unlocks it</span>
            <span><span>Your dreams are tied with a key, School unlocks it</span></span>
        </h4>
      </div>
    </div>
    
     <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div class="fixed-footer" style="height:30px;background-color:#1d4d4f">Copyright &copy; 2020 goSchool</div>	
		

</body>


</html>