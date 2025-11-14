<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="max-w-md mx-auto mt-16 bg-white shadow-xl rounded-3xl p-8 border border-gray-200">
    <h2 class="text-4xl font-extrabold text-gray-800 mb-10 text-center tracking-tight">
        Travel Details
    </h2>

    <div class="flex flex-col space-y-6 text-gray-700">
        <div>
            <span class="font-semibold text-gray-500 uppercase text-sm mb-1 block">Expense</span>
            <span class="text-gray-900 font-medium text-lg">${travel.expense}</span>
        </div>

        <div>
            <span class="font-semibold text-gray-500 uppercase text-sm mb-1 block">Amount</span>
            <span class="text-gray-900 font-medium text-lg">${travel.amount}</span>
        </div>

        <div>
            <span class="font-semibold text-gray-500 uppercase text-sm mb-1 block">Vendor</span>
            <span class="text-gray-900 font-medium text-lg">${travel.vendor}</span>
        </div>

        <div>
            <span class="font-semibold text-gray-500 uppercase text-sm mb-1 block">Description</span>
            <span class="text-gray-900 font-medium text-lg">${travel.description}</span>
        </div>
    </div>

    <div class="mt-10 text-center">
        <a href="/" class="inline-block px-10 py-3 bg-gradient-to-r from-blue-500 to-indigo-600 text-white font-semibold rounded-full shadow-lg transform transition hover:scale-105 hover:from-blue-600 hover:to-indigo-700 duration-300">
            Back to List
        </a>
    </div>
</body>


</html>
