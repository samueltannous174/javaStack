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
    Dojo Details
</h2>

<table style="border-collapse: collapse; width: 100%;">
    <thead>
    <tr>
        <th style="border: 1px solid black; padding: 8px;">First Name</th>
        <th style="border: 1px solid black; padding: 8px;">Last Name</th>
        <th style="border: 1px solid black; padding: 8px;">Age</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="ninja" items="${dojo.ninjas}">
        <tr>
            <td style="border: 1px solid black; padding: 8px;">${ninja.first_name}</td>
            <td style="border: 1px solid black; padding: 8px;">${ninja.last_name}</td>
            <td style="border: 1px solid black; padding: 8px;">${ninja.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<div class="mt-10 text-center">
    <a href="/" class="inline-block px-10 py-3 bg-gradient-to-r from-blue-500 to-indigo-600 text-white font-semibold rounded-full shadow-lg transform transition hover:scale-105 hover:from-blue-600 hover:to-indigo-700 duration-300">
        Back to List
    </a>
</div>
</body>


</html>
