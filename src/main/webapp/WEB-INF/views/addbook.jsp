<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new book - takeMyBook</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<div style="display:flex;">
    <img src="../smolBook1.svg">
    <h1>Add a new book</h1>
</div>

<div>
    <form:form modelAttribute="addBook" action="addbook" method="post" cssClass="bookform" accept-charset="utf-8">
        <div style="display: flex">
        <div>
            <div>
                <form:label path="title">Title</form:label><br>
                <form:input path="title"></form:input>
                <form:errors cssClass="message" path="title"></form:errors>
            </div>
            <div>
                <form:label path="author">Author</form:label><br>
                <input type="text" id="author" name="author">
                <form:errors cssClass="message" path="author"></form:errors>
            </div>
            <div>
                <form:label path="genre">Genre</form:label><br>
                <form:checkboxes path="genre" items="${genre}"></form:checkboxes>
                <form:errors cssClass="message" path="genre"></form:errors>
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
                <form:select path="condition" multiple="true">
                    <form:options items="${condition}"/>
                </form:select>
                <form:errors cssClass="message" path="condition"></form:errors>
            </div>
        </div>
            <div>
            <div>
                <form:label path="description">Description</form:label>  <br>
                <form:textarea path="description" rows="5" cols="30" maxlength="800"/>
                <form:errors cssClass="message" path="description"></form:errors>
            </div>
            <div>
                <form:label path="activeTrade">Up for trade?</form:label>
                <form:checkbox path="activeTrade"/>
            </div>
            </div>
</div>
        <div di>
            <input type="submit" value="Save book" class="inputbutton">
            <input type="button" value="Cancel" onclick="window.location.href='/profile'"  class="inputbutton">
        </div>
    </form:form>

</div>

</body>
</html>