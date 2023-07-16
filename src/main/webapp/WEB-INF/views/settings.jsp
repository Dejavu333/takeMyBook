<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>takeMyBook Profile Settings</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
</head>
<body>
<div style="display:flex;align-items: center;">
    <img src="../profile.png" style="height: 2em;margin:1em">
    <h1>Update your profile</h1>
</div>
<main>
    <h2>Profile information</h2>
    <form:form modelAttribute="profileForm" action="saveprofile">
        <form:hidden path="id"></form:hidden>

        <div>
            <form:label path="nickname">Nickname</form:label> <br>
            <form:input path="nickname"/>
            <form:errors cssClass="message" path="nickname"></form:errors>
        </div>
        <div>
            <form:label path="email">E-mail</form:label> <br>
            <form:input path="email"/>
            <form:errors cssClass="message" path="email"></form:errors>
        </div>
        <div>
            <form:label path="phone">Phone</form:label> <br>
            <form:input path="phone" items="${genre}"></form:input>
            <form:errors cssClass="message" path="phone"></form:errors>
        </div>

        <div>
            <input type="submit" value="Save profile" class="inputbutton">
            <input type="button" value="Cancel" onclick="window.location.href='/profile'" class="inputbutton">
        </div>
    </form:form>

</main>

</body>
</html>

