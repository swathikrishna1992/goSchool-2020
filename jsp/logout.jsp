<%

 session.removeAttribute("user");
 session.invalidate();
 response.sendRedirect("login.jsp");


%>