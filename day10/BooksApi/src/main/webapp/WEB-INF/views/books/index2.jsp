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
    All Books
</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Language</th>
        <th>Number of Pages</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td class="text-center">${book.id}</td>

            <td class="text-center"><a href="/books/${book.id}"> ${book.title}</a></td>
            <td class="text-center">${book.language}</td>
            <td class="text-center" >${book.numberOfPages}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
