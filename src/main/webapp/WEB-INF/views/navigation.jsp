<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>takeMyBook Navigation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="./style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>
<%@include file="header.jspf"%>
<main style="margin:auto">
    <h1 style="margin: auto">Navigation</h1>
    <div class="navigation_btns">
        <a href="profile" title="Your profile and your bookshelf.">
            <img src="../profile.png">
        </a>
        <a href="maps" title="See other Bookworms on the map.">
            <img src="../mapicon.png">
        </a>
        <a href="booksearch">
            <img src="../searchicon.png" title="Search for books.">
        </a>

    </div>

</main>

</body>
</html>