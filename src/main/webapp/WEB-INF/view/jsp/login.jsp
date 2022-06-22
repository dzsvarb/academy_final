<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Personal bank manager</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <div class="wrapperLogin">
    <div class="welcomeText">Welcome to <br> <b>Personal Bank manager!</b>  <br>Please, authenticate!</div>
    <div class="formLog">
      <form action="<c:url value="/personalMain"/>">
        <p>Login: <br>
          <label>
            <input type="text" name="login" size="25" maxlength="20" autofocus required>
          </label><br>
          Password: <br>
          <label>
            <input type="password" name="password" size="25" maxlength="20" required>
          </label>
        </p><br>
        <p>
          <input type="submit" value="Submit">
        </p>
      </form>
    </div>

  </div>

  </body>
</html>
