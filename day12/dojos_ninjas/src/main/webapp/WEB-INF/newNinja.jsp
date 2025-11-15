<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 min-h-screen flex flex-col items-center p-8 gap-12">

<h1 class="text-4xl font-bold text-gray-800">New Dojo</h1>

<div class="flex w-full justify-center mt-8">
    <form:form action="/create_ninja" method="post" cssClass="bg-white shadow-lg p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="ninja">
        <form:select path="dojo">
            <c:forEach var="d" items="${dojos}">
                <form:option value="${d.id}">
                    <c:out value="${d.name}"/>
                </form:option>
            </c:forEach>
        </form:select>

        <div class="flex flex-col gap-1">
            <form:label path="first_name" class="font-medium">First Name:</form:label>
            <form:errors path="first_name" cssClass="text-red-600 text-sm"/>
            <form:input path="first_name" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>
        <div class="flex flex-col gap-1">
            <form:label path="last_name" class="font-medium">Last Name:</form:label>
            <form:errors path="last_name" cssClass="text-red-600 text-sm"/>
            <form:input path="last_name" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>
        <div class="flex flex-col gap-1">
            <form:label path="age" class="font-medium">Age:</form:label>
            <form:errors path="age" cssClass="text-red-600 text-sm"/>
            <form:input path="age" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>
        <input type="submit" value="Submit" class="bg-blue-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form>
</div>

</body>
</html>
