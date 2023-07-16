<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Profile - takeMyBook</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>


<section>
    <%@include file="header.jspf"%>
    <p class="message">${message}</p>
</section>
<main id="profile">

    <div id="profile_box">
        <img src="../reading.png">
        <div id="profile_info">
            <div style="display: flex;justify-content: space-between;align-items: center;">
                <h3 style="display: inline">@${bookworm.getNickName()}</h3>
                <a href="settings" style="height: inherit"><img class="button" src="../settings.png" style="height: 0.8em;margin: 0"></a>
            </div>
            <hr>
            <p>Rank: ${bookworm.getRank().getName()}</p>
            <p>Trade: ${bookworm.getSwitchedBooks()}</p>
            <p>Contact: ${bookworm.getEmail()}</p>
        </div>
        <span><i>Scores to next rank: ${bookworm.getScore()}</i></span>
    </div>

    <div id="bookshelf">
        <div id="bookshelf_header">
            <a href="addbook" style="display: inline">
                <img class="button" src="../addbookbutton.png" style="margin: 0.3em">
            </a>
            <h1>Bookshelf</h1>
            <a href="requests" style="display: inline">
                <img class="button" src="../notification.png" style="margin: 0.3em">
            </a>
        </div>
        <div class="table table-hover table-wrapper-scroll-y my-custom-scrollbar" style="display: flex; justify-content: center">

            <table>
                <tr>
                    <th>Status</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th>Condition</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <c:forEach items="${bookshelf}" var="book">
                    <tr>
                        <td>
                            <c:set var="active" scope="page" value="${book.isActiveTrade()}"/>
                                <c:if test="${active}">
                                    <c:out value="Up for trade"></c:out>
                                </c:if>
                                <c:if test="${!active}">
                                    <c:out value="Keep"></c:out>
                                </c:if>

                        </td>
                        <td>${book.getTitle()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>
                            <c:forEach items="${book.getGenre()}" var="g">
                                <c:out value="${g.getName()} "/>
                            </c:forEach>
                        </td>
                        <td>${book.getCondition().getName()}</td>
                        <td>${book.getDescription()}</td>
                        <td><a href="editbook/${book.getId()}">
                            <img class="button" src="edit-pencil.png" style="margin: 0.5em">
                        </a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

</main>

<hr>
<footer class="navigation_btns">
    <a href="maps">
        <img src="../mapicon.png">
    </a>
    <a href="booksearch">
        <img src="../searchicon.png">
    </a>
</footer>





</body>
</html>


