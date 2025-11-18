<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white flex justify-center py-10">

<div class="w-3/4">

    <h1 class="text-4xl font-semibold text-center mb-10">Home Page</h1>

    <div class="mb-6 space-y-1">
        <a href="/products/new" class="text-blue-600 underline">New Product</a><br>
        <a href="/categories/new" class="text-blue-600 underline">New Category</a>
    </div>

    <div class="border border-gray-400 p-6 rounded-md">
        <table class="w-full border border-gray-300 table-fixed">
            <thead>
            <tr>
                <th class="w-1/2 border-b border-gray-300 py-3 text-xl font-semibold">
                    Products
                </th>
                <th class="w-1/2 border-b border-gray-300 py-3 text-xl font-semibold">
                    Categories
                </th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td class="align-top py-4">
                    <ul class="list-disc ml-6 space-y-1">
                        <c:forEach var="product" items="${products}">
                            <li>
                                <a href="/product/${product.id}" class="text-blue-600 underline hover:text-blue-800">
                                        ${product.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </td>

                <td class="align-top py-4">
                    <ul class="list-disc ml-6 space-y-1">
                        <c:forEach var="category" items="${categories}">
                            <li>
                                <a href="/category/${category.id}" class="text-blue-600 underline hover:text-blue-800">
                                        ${category.name}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
