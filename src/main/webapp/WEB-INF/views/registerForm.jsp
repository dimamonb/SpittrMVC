<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css" />
  </head>
  <body>
    <h1>Register</h1>

    <sf:form method="POST" commandName="spitter">
        <sf:errors path="*" element="div" cssClass="errors" />
      First Name: <sf:input path="firstName" />
        <sf:errors path="firstName" cssClass="error" /><br/>
      Last Name: <sf:input path="lastName" /><br/>
        <sf:errors path="lastName" cssClass="error" /><br/>
      Email: <sf:input path="email" type="email"/><br/>
        <sf:errors path="email" cssClass="error" /><br/>
      Username: <sf:input path="username" /><br/>
        <sf:errors path="username" cssClass="error" /><br/>
      Password: <sf:password path="password" /><br/>
        <sf:errors path="password" cssClass="error" /><br/>
      <input type="submit" value="Register" />
    </sf:form>
  </body>
</html>
