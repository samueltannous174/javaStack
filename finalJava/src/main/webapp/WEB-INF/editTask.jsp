<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-blue-50 min-h-screen flex flex-col items-center gap-12">
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
                    welcome ${logged.firstName}
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

<h1 class="text-4xl font-bold text-gray-800">Edit Task</h1>



<div class="flex w-full justify-center mt-8">
    <form:form action="/edit_task" method="post" cssClass="bg-blue-100 shadow-lg p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="task">
        <input type="hidden" name="_method" value="PUT">

        <input type="hidden" name="id" value="${task.id}" />
        <input type="hidden" name="user" value="${task.user.id}" >
        <input type="hidden" name="type" value="${task.type}" >

        <div class="flex flex-col gap-1">
            <form:label path="title" class="font-medium">Title :</form:label>
            <form:errors path="title" cssClass="text-red-600 text-sm"/>
            <form:input path="title" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="moreDetails" class="font-medium">More Details :</form:label>
            <form:errors path="moreDetails" cssClass="text-red-600 text-sm"/>
            <form:textarea path="moreDetails" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="deadLine" class="font-medium">Dead Line:</form:label>
            <form:errors path="deadLine" cssClass="text-red-600 text-sm"/>
            <form:input path="deadLine" type="date" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400 w-full"/>
        </div>

        <c:forEach var="tag" items="${tags}">
            <div class="flex items-center">
                <input
                        id="option${tag.id}"
                        type="checkbox"
                        name="selectedTag"
                        value="${tag.id}"
                        class="h-4 w-4 text-blue-600 border-gray-300 rounded focus:ring-blue-500"
                />
                <label for="option${tag.id}" class="ml-2 text-gray-700">${tag.name}</label>
            </div>
        </c:forEach>
        <input type="submit" value="Submit" class="bg-purple-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form>
</div>

</body>
</html>
