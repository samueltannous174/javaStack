<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Register & Login</title>
</head>
<body class="bg-gray-100 flex flex-col items-center justify-center min-h-screen space-y-10">

<div class="w-full max-w-md bg-blue-200 rounded-lg shadow p-6">
    <h2 class="text-2xl font-semibold text-center mb-6">Register</h2>
    <form:form action="/register" method="post" cssClass="p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="newUser">
        <input type="hidden" name="id" value="${newUser.id}">
        <div class="flex flex-col gap-1">
            <form:label path="name" class="font-medium">Name :</form:label>
            <form:errors path="name" cssClass="text-red-600 text-sm"/>
            <form:input path="name" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="email" class="font-medium">Email :</form:label>
            <form:errors path="email" cssClass="text-red-600 text-sm"/>
            <form:input path="email" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="birthday" class="font-medium">Birthday:</form:label>
            <form:errors path="birthday" cssClass="text-red-600 text-sm"/>
            <form:input path="birthday" type="date"
                        class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400 w-full"/>
        </div>
        
        <div class="flex flex-col gap-1">
            <form:label path="password" class="font-medium">Password :</form:label>
            <form:errors path="password" cssClass="text-red-600 text-sm"/>
            <form:password path="password" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="confirm" class="font-medium">Confirm Password :</form:label>
            <form:errors path="confirm" cssClass="text-red-600 text-sm"/>
            <form:password path="confirm" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <input type="submit" value="Submit" class="bg-blue-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form></div>

<div class="w-full max-w-md bg-blue-200 rounded-lg shadow p-6">
    <h2 class="text-2xl font-semibold text-center mb-6">Log In</h2>
    <form:form action="/login" method="post" cssClass="p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="user">
        <div class="flex flex-col gap-1">
            <form:label path="loginEmail" class="font-medium">Email :</form:label>
            <form:errors path="loginEmail" cssClass="text-red-600 text-sm"/>
            <form:input path="loginEmail" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="loginPassword" class="font-medium">Password :</form:label>
            <form:errors path="loginPassword" cssClass="text-red-600 text-sm"/>
            <form:password path="loginPassword" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>


        <input type="submit" value="Submit" class="bg-blue-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form></div>

</div>



<form action="/logout" method="post" class="bg-blue-100 p-8">
    <input type="submit" value="Log Out" >
</form>

</body>
</html>
