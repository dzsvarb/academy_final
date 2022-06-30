<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add user</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand">Personal Bank Manager</a>
        <span class="navbar-text">
            <sec:authentication var="principal" property="principal" />
            <c:if test="${principal.roles == '[ROLE_ADMIN]'}">
                Administrator
            </c:if>
            <c:if test="${principal.roles == '[ROLE_CUSTOMER]'}">
                User
            </c:if>
                         |  ${principal.username}
                </span>
        <form class="d-flex" action="<c:url value="/logout"/>">
            <button class="btn btn-outline-success" type="submit">Log out</button>
        </form>
    </div>
</nav>

<div class="d-flex flex-column mb-3">
    <div class="p-2">
        <div class="vstack gap-1">
            <div class="bg-light border">User form</div>
            <c:if test="${error!=null}">
                <div class="bg-danger p-2" style="--bs-bg-opacity: .5;">${error}</div>
            </c:if>
        </div>
    </div>
    <div class="p-1">

        <div class="shadow-lg p-3 mb-5 ">
            <div class="p-2 bo">
                <form action="<c:url value="/admin/addSuccess"/>">
                    <fieldset>
                        <legend>Fill out the user form</legend>
                        <div class="mb-3">
                            <label class="form-label">Enter username
                                <input type="text" name="username" class="form-control" placeholder="Add username" size="45" maxlength="45"  autofocus required>
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter email
                                <input type="email" name="email" class="form-control" placeholder="youremail@example.com" size="45" maxlength="100" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter city
                                <input type="text" name="city" class="form-control" placeholder="Minsk" size="45" maxlength="45" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter street
                                <input type="text" name="street" class="form-control" placeholder="Dostoevskogo" size="45" maxlength="45" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter house number
                                <input type="number" name="house" class="form-control" placeholder="1" size="45" maxlength="6" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter room number
                                <input type="number" name="room" class="form-control" placeholder="1" size="45" maxlength="6" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Card number
                                <input type="number" name="cardNumber" class="form-control" placeholder="100" size="45" maxlength="45" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Card pay system
                                <input type="number" name="cardPaySystem" class="form-control" placeholder="500" size="45" maxlength="45" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Enter password
                                <input type="password" name="password" class="form-control" placeholder="Transferred to the client" size="30" maxlength="100" autofocus required >
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Confirm the password
                                <input type="password" name="passwordConf" class="form-control"  size="30" maxlength="100" autofocus required >
                            </label>
                        </div>
                        <div class="hstack gap-2">
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset"  class="btn btn-outline-secondary">Reset</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <div class="p-2">
        <div class="btn-group " role="group" aria-label="Basic example">
            <form>
                <div class="hstack gap-2" >
                    <button type="submit" class="btn btn-primary"  formaction="<c:url value="/admin"/>">Back</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>