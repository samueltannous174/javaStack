<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex p-7 flex-col gap-6">
        <h1 class="text-4xl font-bold text-black-800">
            <c:out value="${book.getTitle()}"></c:out>
        </h1>
        <p>
       Description :     <c:out value="${book.getDescription()}"></c:out>

        </p>
    <p>
        Number Of Pages :   <c:out value="${book.getNumberOfPages()}"></c:out>

    </p>
        <p>
            Language :   <c:out value="${book.getLanguage()}"></c:out>

        </p>


</body>
</html>
