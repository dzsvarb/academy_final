<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Personal bank manager</title>

</head>
<body>
<div class="container">
    <h2>Welcome to <br> <b>Personal Bank manager!</b>  <br>Please, authenticate!</h2>
    <div class="card"></div>
        <div class="card-body">
            <form action="/main" method="get" >

            <div class=" form-group row">
                <label for="username" class="col-sm-2 col-form-label">User Name</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control" name="username"
                           placeholder="Enter user name">
                </div>
            </div>


            <div class="form-group row">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-7">
                    <input type="password" class="form-control" name="password"
                           placeholder="Enter Password">
                </div>
            </div>


            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </div>
</div>


</body>
</html>