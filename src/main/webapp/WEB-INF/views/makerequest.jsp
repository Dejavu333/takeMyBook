<%@ page import="com.elte.fsz.takemybook.domain.Bookworm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Bookworm bw = (Bookworm)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Choose book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>
<%@include file="header.jspf"%>

<h1>Sending a request</h1>
<section>
    <p>Choose from your books</p>
</section>
<main>
    <div>
        <h2>The book you want</h2>
        <ul>
            <li>Owner: ${tradeBook.getBookworm().getNickName()}</li>
            <li>Title: ${tradeBook.getTitle()}</li>
            <li>Author: ${tradeBook.getAuthor()}</li>
            <li> Genre:
                <c:forEach items="${tradeBook.getGenre()}" var="g">
                    <c:out value="${g} "/>
                </c:forEach>
            </li>
            <li>Description: ${tradeBook.getDescription()}</li>
            <li>Language: ${tradeBook.getLanguage()}</li>
            <li>Condition:${tradeBook.getCondition()}</li>
        </ul>
    </div>
    <div id="bookshelf">
            <table class="table table-hover">
             <thead>My books</thead>
                <tr>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Description</th>
                    <th scope="col">Condition</th>
                    <th scope="col">Make Request</th>
                </tr>
                <c:forEach items="${bookshelf}" var="book">
                    <tr>
                        <td>${book.getTitle()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getDescription()}</td>
                        <td>${book.getCondition()}</td>
                        <td>
                        <form method="post" action="/makerequestfinal">
                        <input type="hidden" name="gibook" value="${book.id}"/>
						<input type="hidden" name="reqbook" value="${reqbook}"/>
							 <input type="image" src="../addbookbutton.png" alt="Submit button"  style="height: 3em; width: auto;">
						</form>
                        </td>
                    </tr>
                </c:forEach>
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
        <a href="booksearch">
            <img src="../searchicon.png">
        </a>
</footer>





</body>
</html>


