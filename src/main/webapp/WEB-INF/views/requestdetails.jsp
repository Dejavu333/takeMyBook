<%@ page import="com.elte.fsz.takemybook.domain.Bookworm" %>
<%@ page import="com.elte.fsz.takemybook.repository.BookRepository" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Bookworm bw = (Bookworm)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Details</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>


<section>
    <%@include file="header.jspf"%>
    <p class="message">${message}</p>
</section>
<h1 style="margin:1em">Details</h1>
<button type="button" value="Cancel" onclick="window.location.href='/requests'">Cancel</button>
<main id="details">

    <div style="display: flex; justify-content: space-around; align-items: center">
            <div class="requestbox">
                <h2>Your Book</h2>
                <p><b>Title:</b> ${request.getTrade().getGivenBook().getTitle()}</p>
                <p><b>Author:</b> ${request.getTrade().getGivenBook().getAuthor()}</p>
                <p><b>Genre: </b>
                    <c:forEach var="g" items="${request.getTrade().getGivenBook().getGenre()}">
                        <c:out value="${g.getName()} "/>
                    </c:forEach>
                </p>
                <p><b>Language:</b> ${request.getTrade().getGivenBook().getLanguage().getName()}</p>
                <p><b>Physical condition:</b> ${request.getTrade().getGivenBook().getCondition().getName()}</p>
                <p><b>Description:</b> ${request.getTrade().getGivenBook().getDescription()}</p>

            </div>
        
        <img src="../switch.png" style="height: 3em">

            <div class="requestbox">
                <h2>Offered Book</h2>
                <h3>by ${request.getBookworm().getNickName()}</h3>

                <p><b>Title:</b> ${request.getBook().getTitle()}</p>
                <p><b>Author:</b> ${request.getBook().getAuthor()}</p>
                <p><b>Genre: </b>
                    <c:forEach var="g" items="${request.getBook().getGenre()}">
                        <c:out value="${g.getName()} "/>
                    </c:forEach>
                </p>
                <p><b>Language:</b> ${request.getBook().getLanguage().getName()}</p>
                <p><b>Physical condition:</b> ${request.getBook().getCondition().getName()}</p>
                <p><b>Description:</b> ${request.getBook().getDescription()}</p>
            </div>
    </div>

    <hr>
    <div style="display: flex; justify-content: flex-end">
        <form method="post" action="/acceptrequest">
            <input type="hidden" name="acceptreq" value="${request.getId()}"/>
            <button type="submit">Accept request</button>
        </form>

        <form method="post" action="/rejectrequest">
            <input type="hidden" name="rejectreq" value="${request.getId()}"/>
            <button type="submit" style="background: #662828">Reject request</button>
        </form>


    </div>


</main>


</body>
</html>


