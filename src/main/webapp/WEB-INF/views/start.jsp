<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 20.10.2021
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hi!!!!!</title>
</head>
<body>
<h1>TEstttttt!!!!!!!</h1>
<p>
    <%
        for (int i = 0; i < 2; i++) {
            out.println("<p>"+"hello "+i+"</p>");
        }
    %>
</p>
<p>
    <%
        out.println(request.getParameter("name"));
        out.println(request.getParameter("st"));
    %>

    <%
//        response.sendRedirect("/a.jsp");
    %>

    <%
        request.getRequestDispatcher("/a.jsp").forward(request, response);
    %>

</p>
</body>
</html>
