<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java Final</title>
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
                    welcome ${logged.firstName}
                </c:if>
                <c:if test="${not empty logged}">
                    <form action="/logout" method="post">
                        <input type="submit" value="Logout">
                    </form>
                </c:if>


                <c:if test="${empty logged}">
                    <a href="/" class="text-blue-600">Login</a>
                </c:if>
            </div>

        </div>

    </div>

</nav>

<div class="max-w-6xl mx-auto mt-9 flex-col">

    <a class="text-blue-400 mt-10 underline " href="/newTask"> Add New Task + </a>


    <c:if test="${type.equals('Tag')}">
        <select name="tag" id="tag" onchange="if (this.value) window.location.href = '/dashboard?type=Tag&tag=' + encodeURIComponent(this.value);">
            <option value="">Select Tag</option>
            <c:forEach var="tag" items="${tags}">
                <option value="${tag.name}">${tag.name}</option>
            </c:forEach>
        </select>
    </c:if>



    <div class=" mt-8 flex gap-8  ">



        <c:forEach var="task" items="${tasks}">

        <div class="max-w-sm rounded-lg  shadow-lg bg-white">

            <div class="px-6 py-4">
                <div class="flex gap-8">
                    <div class="font-bold text-xl mb-2"> <a href="/task/${task.id}"> ${task.title} </a> </div>
                    <form action="/important" method="post">
                        <input type="hidden" name="id" value="${task.id}">
                        <c:if test="${importantTasks.contains(task)}">
                            <button class="text-red-400 text-2xl cursor-pointer" type="submit">
                                <svg class="w-5 h-5 text-fg-yellow" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24"><path d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z"/></svg>
                            </button>
                        </c:if>
                        <c:if test="${!importantTasks.contains(task)}">
                            <button class="text-gray-400 text-2xl cursor-pointer" type="submit">
                                <svg class="w-5 h-5 text-fg-yellow" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" viewBox="0 0 24 24"><path d="M13.849 4.22c-.684-1.626-3.014-1.626-3.698 0L8.397 8.387l-4.552.361c-1.775.14-2.495 2.331-1.142 3.477l3.468 2.937-1.06 4.392c-.413 1.713 1.472 3.067 2.992 2.149L12 19.35l3.897 2.354c1.52.918 3.405-.436 2.992-2.15l-1.06-4.39 3.468-2.938c1.353-1.146.633-3.336-1.142-3.477l-4.552-.36-1.754-4.17Z"/></svg>
                            </button>

                        </c:if>
                    </form>

                </div>
                <p class="text-gray-700 text-base">
                        ${task.moreDetails}
                </p>
            </div>


        </div>
        </c:forEach>
    </div>



</div>

<aside class="hidden md:block w-64 bg-white rounded-lg shadow p-4 h-[calc(100vh-6rem)   fixed left-0 ">
    <div class="mb-6">
    </div>

    <nav class="space-y-2">
        <a href="/dashboard?type=all" class="block px-3 py-2 rounded hover:bg-blue-50 hover:text-blue-700">To Do</a>
        <a href="/dashboard?type=InProgress" class="block px-3 py-2 rounded hover:bg-blue-50 hover:text-blue-700">In Progress</a>
        <a href="/dashboard?type=Done" class="block px-3 py-2 rounded hover:bg-blue-50 hover:text-blue-700">Done</a>
        <a href="/dashboard?type=Important" class="block px-3 py-2 rounded hover:bg-blue-50 hover:text-blue-700">Important</a>
        <a href="/dashboard?type=Tag" class="block px-3 py-2 rounded hover:bg-blue-50 hover:text-blue-700">Tag</a>

    </nav>

</aside>



</div>

</div>


</body>
</html>





