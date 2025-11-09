<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="ml-10 mt-10">
<h1 class="text-rose-500">Fruit Store</h1>
<table class="border-4 border-rose-300 p-8 w-1/4" >
    <thead>
    <tr>
        <th>Fruit</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="fruit" items="${fruits}">
        <tr>
            <td class="text-center"><c:out value="${fruit.name}"/></td>
            <td class="text-center"><c:out value="${fruit.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
