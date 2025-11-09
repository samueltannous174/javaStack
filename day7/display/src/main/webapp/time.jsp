<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script type="text/javascript" src="/js/logic.js"></script>

</head>
<body onload="showAlert()">
<h1>
    <h1 class="blue"><c:out value="${time}"/></h1>
</h1>
</body>
</html>