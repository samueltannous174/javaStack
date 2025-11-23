<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Collection</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap');
        body {
            font-family: 'Inter', sans-serif;
        }
    </style>
</head>
<body class="bg-gradient-to-br from-blue-50 to-indigo-100 min-h-screen ">
<nav class="bg-white border-b shadow-sm dark:bg-gray-900 dark:border-gray-700 w-full">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex justify-between h-16">

            <div class="flex items-center text-center justify-center">
                <a href="#" class="text-2xl font-bold text-gray-800 dark:text-white">
                    Brand
                </a>
            </div>

            <div class="hidden md:flex space-x-8 items-center">
                <a href="#" class="text-gray-700 hover:text-blue-600 dark:text-gray-300 dark:hover:text-white">
                    Home
                </a>
                <a href="#" class="text-gray-700 hover:text-blue-600 dark:text-gray-300 dark:hover:text-white">
                    About
                </a>
                <a href="#" class="text-gray-700 hover:text-blue-600 dark:text-gray-300 dark:hover:text-white">
                    Services
                </a>
                <a href="#" class="text-gray-700 hover:text-blue-600 dark:text-gray-300 dark:hover:text-white">
                    Contact
                </a>


            </div>
            <div class="ml-7 text-orange-100 flex items-center gap-9">
                <c:if test="${not empty logged}">
                    welcome ${logged.name}
                </c:if>
                <c:if test="${not empty logged}">
                    <form action="/logout" method="post">
                        <input type="submit" value="Logout">
                    </form>
                </c:if>


                <c:if test="${empty logged}">
                    <a href="/auth" class="text-blue-600">Login</a>
                </c:if>
            </div>

        </div>

    </div>

</nav>

</body>
</html>





<div class="max-w-6xl mx-auto mt-9">


    <div class="overflow-x-auto">
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-4 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    <div class="flex items-center">
                        <span>Type</span>
                        <i class="fas fa-sort ml-1 text-gray-400"></i>
                    </div>
                </th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">

            <c:forEach var="type" items="${types}">
                <tr class="hover:bg-gray-100 transition">
                    <td class="py-3 px-6"><a href="/type/${type.id}" class="text-blue-600 hover:underline">${type.name}</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>


        <a class="text-blue-400 mt-10 underline " href="/show_create_book"> Add New </a>
    </div>


</div>
</div>
