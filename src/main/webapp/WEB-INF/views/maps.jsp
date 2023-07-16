<%@ page session = "true" %>
<%@ page import="com.elte.fsz.takemybook.domain.Bookworm" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<!--!head -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./style.css">
    <link rel="icon" href="../takeMyBookLogo.png">
    <title>takeMyBookMap</title>
    <style>
        a[href^="http://maps.google.com/maps"]{display:none !important}
        a[href^="https://maps.google.com/maps"]{display:none !important}
        
        .gmnoprint a, .gmnoprint span, .gm-style-cc {
            display:none;
        }
        .gmnoprint div {
            background:none !important;
        }
        body {
            overflow: hidden;
        }
    </style>
</head>

<!--!body -->
<body>
    <%@include file="header.jspf"%>
 
    <%
        try 
        {
            Bookworm bw = (Bookworm)session.getAttribute("user");
            %><span id="userNickName"><%out.print(bw.getNickName());%></span><%
            %><span hidden id="userId"><%out.print(bw.getId());%></span><%
        } 
        catch (Exception e) 
        {   
            out.print("Guest");
        }
    %>
    <button id="myTradeLocationBtn">Trade Location</button>

    <div id="googleMap" style="width:100%; height:90vh;"></div>
    
    <!--?scripts-->
    <!-- callback function definition -->
    <script src="./js/maps.js"></script>
    <!-- public key and callback function as url params -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHVDNFrs6Yp7tWZ4gZneLwLeb7E0ru3Ss&callback=takeMyBookMap"></script>
</body>

</html>