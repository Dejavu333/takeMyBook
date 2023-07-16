<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search book - takeMyBook</title>
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>
<%@include file="header.jspf"%>
<div style="display:flex; margin: 1em">
    <img src="../smolBook1.svg">
    <h1>Search book</h1>
</div>

<main style="margin: 2em;">

<div>
    <form method="post" action="/booksearch" style="display:flex;">
        <div>

            <label>Title:</label>
            <input type="text" name="title">


            <label>Author:</label>
            <input type="text" name="author">


            <label>Genre:</label>
            <select name="genre" id="genre" multiple="multiple">
                <c:forEach var="g" items="${genre}" >
                    <option value="${g}">${g.getName()}</option>
                </c:forEach>
            </select>


            <label>Language:</label>
            <select name="language" id="language">
                <c:forEach var="g" items="${language}" >
                    <option value="${g}">${g.getName()}</option>
                </c:forEach>
            </select>

            <label>Physical condition:</label>

            <input type="radio" name="anyCondition" value="true">
            <span>Any</span>

            <input type="radio" name="anyCondition" value="false">
            <select name="condition" id="condition">
                <c:forEach var="g" items="${condition}" >
                    <option value="${g}">${g.getName()}</option>
                </c:forEach>
            </select>

        </div>


        <button type="submit">Search</button>
    </form>
<hr>
    <table class="table table-hover table-wrapper-scroll-y my-custom-scrollbar">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Condition</th>
            <th>Description</th>
            <th>Make request</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${searchedBooks}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>
                    <c:forEach items="${book.getGenre()}" var="genre">
                        <c:out value="${genre.getName()} "></c:out>
                    </c:forEach>
                </td>
                <td>${book.getCondition().getName()}</td>
                <td>${book.getDescription()}</td>
                <td>
                    <form method="post" action="/makerequest">
                        <input type="hidden" name="reqbook" value="${book.id}"/>
                        <button type="submit">Make request</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>


    </table>
</div>
</main>
    <hr>
    <footer class="navigation_btns">

        <a href="profile">
            <img src="../profile.png">
        </a>
        <a href="maps">
            <img src="../mapicon.png">
        </a>
    </footer>




</body>

</html>