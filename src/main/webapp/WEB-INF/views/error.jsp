<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>


<section>
    <img class="logo" src="../takeMyBookLogo.png">
</section>
<main>
    <h1>Error page</h1>
    <c:if test="${not empty errorCode}">
        ${errorCode} : ${errorMessage}
    </c:if>

    <c:if test="${empty errorCode}">
        System error.
    </c:if>
</main>

<hr>
<footer class="navigation_btns">
    <a href="profile">
        <img src="../profile.png">
    </a>
    <a href="maps">
        <img src="../mapicon.png">
    </a>
    <a href="booksearch">
        <img src="../searchicon.png">
    </a>
</footer>





</body>
</html>


