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
<body class="bg-gray-50 min-h-screen flex flex-col items-center p-8 gap-12">

<h1 class="text-4xl font-bold text-gray-800">All Travels</h1>

<div class="overflow-x-auto w-full max-w-6xl">
    <table class="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
        <thead class="bg-blue-600 text-white">
        <tr>
            <th class="py-3 px-6 text-left">Expense</th>
            <th class="py-3 px-6 text-left">Vendor</th>
            <th class="py-3 px-6 text-left">Amount</th>
            <th class="py-3 px-6 text-center">Actions</th>
        </tr>
        </thead>
        <tbody class="divide-y divide-gray-200">
        <c:forEach var="travel" items="${travels}">
            <tr class="hover:bg-gray-100 transition">
                <td class="py-3 px-6"><a href="/expenses/${travel.id}" class="text-blue-600 hover:underline">${travel.expense}</a></td>
                <td class="py-3 px-6">${travel.vendor}</td>
                <td class="py-3 px-6">${travel.amount}</td>
                <td class="py-3 px-6 text-center flex justify-center gap-2">
                    <a href="/show_edit/${travel.id}" class="text-blue-600 hover:underline">Edit</a>
                    <form action="/delete/${travel.id}" method="post" class="inline">
                        <input type="submit" value="Delete" class="text-red-600 hover:text-red-800 cursor-pointer bg-transparent border-none"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="flex w-full justify-center mt-8">
    <form:form action="/create_travel" method="post" cssClass="bg-white shadow-lg p-8 flex flex-col gap-6 w-full max-w-md rounded-lg" modelAttribute="travel">
        <div class="flex flex-col gap-1">
            <form:label path="expense" class="font-medium">Expense:</form:label>
            <form:errors path="expense" cssClass="text-red-600 text-sm"/>
            <form:input path="expense" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="vendor" class="font-medium">Vendor:</form:label>
            <form:errors path="vendor" cssClass="text-red-600 text-sm"/>
            <form:input path="vendor" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="amount" class="font-medium">Amount:</form:label>
            <form:errors path="amount" cssClass="text-red-600 text-sm"/>
            <form:input path="amount" type="number" step="0.01" min="0" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <div class="flex flex-col gap-1">
            <form:label path="description" class="font-medium">Description:</form:label>
            <form:errors path="description" cssClass="text-red-600 text-sm"/>
            <form:textarea path="description" class="border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"/>
        </div>

        <input type="submit" value="Submit" class="bg-blue-600 text-white rounded py-2 mt-4 hover:bg-blue-700 cursor-pointer"/>
    </form:form>
</div>

</body>
</html>
