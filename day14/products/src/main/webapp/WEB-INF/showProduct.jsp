<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="w-3/4 mx-auto mt-16 bg-white shadow-xl rounded-3xl p-8 border border-gray-200">
<h2 class="text-4xl font-extrabold text-gray-800 mb-10 text-center tracking-tight">
    ${product.name}
</h2>

<a class="underline text-blue" href="/"> Home </a>

<h2 class="text-4xl font-extrabold text-gray-800 mb-10  tracking-tight">
    Categories
</h2>
    <ul>

    <c:forEach var="c" items="${productCategories}">
        <li value="${c.id}">${c.name}</li>
    </c:forEach>

    </ul>


<form action="/add_category" method="post">
    <input type="hidden" name="productId" value="${product.id}">

    <div class="flex flex-col gap-1">
        <label for="category" class="font-medium">Select Category:</label>
        <select name="category" id="category" class="border border-gray-300 rounded px-3 py-2 w-full">
            <c:forEach var="c" items="${categories}">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select>
    </div>

    <input type="submit" value="Add Category" class="bg-blue-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
</form>




</body>


</html>
