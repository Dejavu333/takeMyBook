<%@ page import="com.elte.fsz.takemybook.domain.Bookworm" %>
<%@ page import="com.elte.fsz.takemybook.domain.TradeRequestStatus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Bookworm bw = (Bookworm)session.getAttribute("user");
    TradeRequestStatus trs = TradeRequestStatus.PENDING;
%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>

<%@include file="header.jspf"%>
<section>

    <p class="message">${message}</p>
</section>
<main style="display:flex; justify-content: space-around">
    <div>
        <h1>Incoming Requests</h1>
        <p>These are the requests that you've got for your books. You can accept the trade on the details page.</p>
        <table>
            <tbody>
                <tr>
                    <th>My Book</th>
                    <th>Offered book</th>
                    <th>Details</th>
                </tr>
                <c:forEach items="${incoming}" var="request">
                    <tr>
                        <td>${request.getTrade().getGivenBook().getTitle()}</td>
                        <td>${request.getBook().getTitle()}</td>
                        <td><a href="requestdetails/${request.getId()}">
                            <img class="button" src="../next.png" style="height: 1em;margin: 0.5em">
                        </a></td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>
    </div>

    <div>
        <h1>Outgoing Requests</h1>
        <p>These are the requests that you've sent for other's book.</p>
        <table>
            <tbody>
            <tr>
                <th>My book</th>
                <th>Requested book</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${outgoing}" var="request">
                <tr>
                    <td>${request.getBook().getTitle()} -></td>
                    <td> ${request.getTrade().getGivenBook().getTitle()}</td>
                    <td>${request.getTradeRequestStatus()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</main>

<hr>
<footer class="navigation_btns">
    <a href="profile" title="Your profile and your bookshelf.">
        <img src="../profile.png">
    </a>
    <a href="maps" title="See other Bookworms on the map.">
        <img src="../mapicon.png">
    </a>
    <a href="booksearch">
        <img src="../searchicon.png" title="Search for books.">
    </a>
</footer>





</body>
</html>


