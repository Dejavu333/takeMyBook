<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>takeMyBook Navigation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>

<div style="display:flex;">
    <img src="../smolBook1.svg">
    <h1>Edit your book</h1>
</div>
<main>
    <form:form modelAttribute="bookForm" action="/editbook" method="post" cssClass="bookform" acceptCharset="utf-8">
        <form:hidden path="id"></form:hidden>

        <div>
            <form:label path="title">Title</form:label> <br>
            <form:input path="title"/>
            <form:errors cssClass="message" path="title"></form:errors>
        </div>
        <div>
            <form:label path="author">Author</form:label> <br>
            <form:input path="author"/>
            <form:errors cssClass="message" path="author"></form:errors>
        </div>
        <div>
            <form:label path="genre">Genre</form:label> <br>
            <form:checkboxes path="genre" items="${genre}"></form:checkboxes>
            <form:errors cssClass="message" path="genre"></form:errors>
        </div>
        <div>
            <form:label path="description">Description</form:label> <br>
            <form:textarea path="description" rows="5" cols="30" maxlength="800"/>
            <form:errors cssClass="message" path="description"></form:errors>
        </div>
        <div>
            <form:label path="activeTrade">Up for trade?</form:label> <br>
            <form:checkbox path="activeTrade"/>
        </div>
        <div>
            <form:label path="language">Language</form:label> <br>
            <form:select path="language">
                <form:options items="${language}"/>
            </form:select>
            <form:errors cssClass="message" path="language"></form:errors>
        </div>
        <div>
            <form:label path="condition">Physical condition</form:label> <br>
            <form:select path="condition">
                <form:options items="${condition}"/>
            </form:select>
            <form:errors cssClass="message" path="condition"></form:errors>
        </div>

        <div>
            <input type="submit" value="Save book" class="inputbutton">
            <input type="button" value="Cancel" onclick="window.location.href='/profile'" class="inputbutton">
        </div>
    </form:form>

</main>

</body>
</html>