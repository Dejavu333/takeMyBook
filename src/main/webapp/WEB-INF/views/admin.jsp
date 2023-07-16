<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - takeMyBook</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
	<link rel="icon" href="../takeMyBookLogo.png">
    <style type="text/css">
		    button {
		  background: none!important;
		  border: none;
		  padding: 0!important;
		  /*optional*/
		  font-family: arial, sans-serif;
		  /*input has OS specific font-family*/
		  color: #069;
		  text-decoration: underline;
		  cursor: pointer;
		}
	</style>
</head>
<body>
<section>
	<%@include file="header.jspf"%>
</section>
<main id="profile">


<div id="bookshelf">
    <table>
    <thead>Delete book</thead>
        <tr>
            <th>Bookworm</th>
            <th>BookId</th>
            <th>Status</th>
            <th>Title</th>  
            <th>Author</th>
            <th>Genre</th>
            <th>Delete</th>
		</tr>
		<c:forEach items="${bookshelf}" var="book">
			<tr>
				<td>${book.getLoginName()}</td>
				<td>${book.getId()}</td>
				<td>${book.isActiveTrade()}</td>
				<td>${book.getTitle()}</td>
				<td>${book.getAuthor()}</td>
				<td>
					<c:forEach items="${book.getGenre()}" var="g">
						<c:out value="${g} "/>
					</c:forEach>
				</td>
				<td>
				<form method="post" action="/deletebook">
				<input type="hidden" name="id" type="number" value="${book.getId()}"/>
				 <button type="submit">Delete</button>
				</form>
			</tr>
		</c:forEach>
    </table>
</div>
<div id="booksworms">
	<table>
	<thead>Delete Bookworm</thead>
		<tr>
			<th>Bookworm</th>
			<th>Id</th>
			<th>Nickname</th>
			<th>Score</th>
			<th>Add to score</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${booksworms}" var="bookworm">
			<tr>
				<td>${bookworm.getLoginName()}</td>
				<td>${bookworm.getId()}</td>
				<td>${bookworm.getNickname()}</td>
				<td>${bookworm.getScore()}</td>
				<td>
				<form method="post" action="/modifyscore">
				<input type="hidden" name="id" type="number" value="${bookworm.getId()}"/>
				 <input name="score" type="number" max=1000 min=0/>
				 <button type="submit">Add to score</button>
				</form>
				</td>
				<td>
				<form method="post" action="/deletebookworm">
				<input type="hidden" name="id" type="number" value="${bookworm.getId()}"/>
				 <button type="submit">Delete</button>
				</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

</main>
</body>
</html>


