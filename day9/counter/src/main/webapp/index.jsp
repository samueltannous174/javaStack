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
    <h1 class="blue"><c:out value="${counter}"/></h1>
    <form action="/reset">
        <button >
            Reset
        </button>
    </form>

</body>
</html>