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

<body class="bg-gray-100 flex flex-col   min-h-screen">
<nav class="bg-white border-b shadow-sm dark:bg-gray-600 dark:border-gray-700 w-full">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex justify-between h-16">

            <div class="flex items-center text-center justify-center">
                <img src="https://www.sam.biz/wp-content/uploads/2023/09/SAM_TM_color_rgb.png"  class="text-2xl text-gray-200 font-bold w-25 h-10  "/>
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
                    <a href="/auth" class="text-blue-200">Login</a>
                </c:if>
            </div>

        </div>

    </div>

</nav>




<div class="bg-gray-100 flex gap-8 items-center justify-center  space-y-10 mt-9">

<div class="w-full max-w-md bg-blue-200 rounded-lg shadow p-6">
    <h2 class="text-2xl font-semibold text-center mb-6">Register</h2>
    <form:form action="/register" method="post" cssClass="p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="newUser">
        <input type="hidden" name="id" value="${newUser.id}">
        <div class="flex flex-col gap-1">
            <form:label path="firstName" class="font-medium">First Name :</form:label>
            <form:errors path="firstName" cssClass="text-red-600 text-sm"/>
            <form:input path="firstName" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="lastName" class="font-medium">Last Name :</form:label>
            <form:errors path="lastName" cssClass="text-red-600 text-sm"/>
            <form:input path="lastName" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="email" class="font-medium">Email :</form:label>
            <form:errors path="email" cssClass="text-red-600 text-sm"/>
            <form:input path="email" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
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

        <input type="submit" value="Submit" class="bg-gray-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
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


        <input type="submit" value="Submit" class="bg-gray-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form></div>

</div>
</body>

</html>
