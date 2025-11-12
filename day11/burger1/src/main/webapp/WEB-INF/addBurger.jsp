<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<body class="flex p-7 flex-col gap-6 mx-auto">
<h1 class="text-4xl font-bold text-black-800">
    All Burgers
</h1>
<table class="border-black border">
    <thead>
    <tr>
        <th>Burger Name</th>
        <th>Restaurant Name</th>
        <th>Rating</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="burger" items="${burgers}">
        <tr>
            <td class="text-center">${burger.getBurgerName()}</td>
            <td class="text-center"> ${burger.getRestaurantName()}</td>
            <td class="text-center"> ${burger.getRating()}</td>
            <td class="text-center"> <a  class="text-blue-700 underline" href="/edit/${burger.getId()}"> edit </a></td>

        </tr>
    </c:forEach>

    </tbody>
</table>

<div class="flex w-3/4 mt-8">
<form:form action="/create_burger" method="post" cssClass="bg-gray-200 p-8 flex flex-col gap-9  mx-auto w-1/2" modelAttribute="burger">
    <div class="flex gap-4">
        <form:label path="BurgerName">BurgerName:</form:label>
        <form:errors path="BurgerName" cssClass="text-red-700"/>
        <form:input path="BurgerName"/>
    </div>

<div class="flex gap-4">
        <form:label  path="RestaurantName">RestaurantName:</form:label>
        <form:errors path="RestaurantName" cssClass="text-red-700"/>
        <form:input path="RestaurantName"/>
</div>
<div class="flex gap-4">
        <form:label  path="Rating">Rating:</form:label>
        <form:errors path="Rating" cssClass="text-red-700"/>
        <form:input path="Rating"/>
</div>
    <div class="flex gap-4">
        <form:label  path="notes">Notes:</form:label>
        <form:errors path="notes" cssClass="text-red-700"/>
        <form:textarea path="notes"/>
    </div>
    <input type="submit" value="Submit" class="w-1/2 mx-auto bg-blue-50 "/>

</form:form>
</div>


</body>
</html>
