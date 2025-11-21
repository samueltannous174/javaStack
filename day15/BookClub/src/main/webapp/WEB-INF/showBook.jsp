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
<body class=" mx-auto bg-blue-100  rounded-3xl  border border-gray-200 flex flex-col ">
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


<h2 class="text-4xl font-extrabold mt-10     text-gray-800 mb-10 text-center tracking-tight">
    Book Details
</h2>


<div class="  p-6 bg-blue-50 shadow rounded  mx-auto w-3/4">

    <div class="flex justify-between items-start">
        <h1 class="text-4xl font-serif font-semibold">
            ${book.title}
        </h1>

        <div class="flex flex-col gap-3">


            <a href="/" class="text-blue-600 underline text-sm">
                back to the shelves
            </a>
        </div>
    </div>

    <p class="mt-4 text-lg">
        <span class="font-bold text-red-600">${book.user.name}</span>
        read
        <span class="text-purple-700 font-semibold">${book.title}</span>
        by
        <span class="text-green-600 font-semibold">${book.authorName}</span>.
    </p>

    <c:if test="${logged.id == book.user.id}">
        <p class="mt-6 text-xl font-semibold">
            Here are your thoughts:
        </p>
    </c:if>

    <c:if test="${logged.id != book.user.id}">
        <p class="mt-6 text-xl font-semibold">
            Here are ${book.user.name} thoughts:
        </p>
    </c:if>


        <div class="mt-4 border-y py-6 px-3 leading-relaxed text-gray-800">
        ${book.thoughts}
    </div>
    <c:if test="${logged.id == book.user.id}">

    <div class="mt-4 flex gap-4">
        <a href="/show_edit_book/${book.id}"
           class="px-4 py-2 bg-gray-700 text-white rounded hover:bg-black">
            edit
        </a>

        <form action="/delete_book" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="hidden" name="id" value="${book.id}">
            <button class="px-4 py-2 bg-red-600 text-white rounded hover:bg-red-700">
                delete
            </button>
        </form>
    </div>
    </c:if>


</div>




<div class="mt-10 text-center">
    <a href="/" class="inline-block px-10 py-3 bg-gradient-to-r from-blue-500 to-indigo-600 text-white font-semibold rounded-full shadow-lg transform transition hover:scale-105 hover:from-blue-600 hover:to-indigo-700 duration-300">
        Back to List
    </a>
</div>


</body>
</html>




<%--<table style="border-collapse: collapse; width: 100%;">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th style="border: 1px solid black; padding: 8px;">Title</th>--%>
<%--        <th style="border: 1px solid black; padding: 8px;">Author Name</th>--%>
<%--        <th style="border: 1px solid black; padding: 8px;">Thoughts</th>--%>
<%--        <th style="border: 1px solid black; padding: 8px;">Action</th>--%>

<%--    </tr>--%>
<%--    </thead>--%>

<%--    <tbody>--%>
<%--    <tr>--%>
<%--        <td style="border: 1px solid black; padding: 8px;"> ${book.title} </td>--%>
<%--        <td style="border: 1px solid black; padding: 8px;">${book.authorName}</td>--%>
<%--        <td style="border: 1px solid black; padding: 8px;">${book.thoughts}</td>--%>
<%--        <td style="border: 1px solid black; padding: 8px;">   <a href="/show_edit_book/${book.id}" class="inline-block px-10 py-3 bg-gradient-to-r from-blue-500 to-indigo-600 text-white font-semibold rounded-full shadow-lg transform transition hover:scale-105 hover:from-blue-600 hover:to-indigo-700 duration-300">--%>
<%--            Edit--%>
<%--        </a> </td>--%>

<%--    </tr>--%>
<%--    </tbody>--%>

<%--</table>--%>