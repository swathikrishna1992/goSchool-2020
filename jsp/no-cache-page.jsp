<%
if(request.getSession().getAttribute("Username").toString() == null)
{
response.setHeader("Cache-Control", "No-Cache");
response.setHeader("Cache-Control", "No-Store");
response.sendRedirect("login");
}
%>