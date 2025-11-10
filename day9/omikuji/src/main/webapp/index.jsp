<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script type="text/javascript" src="/js/logic.js"></script>
</head>
<body>
<h1>
    <div class="mx-auto w-1/4 flex flex-col gap-5">
        <h1 class="text-4xl font-bold text-black-800">Send an Omikuji </h1>
    <form action="/submit" method="post" class=" flex flex-col p-8 bg-blue-200 gap-6"  >
        <div class="flex flex-col ">
            <label>
                Pick any number 5 to 25 :
            </label>
            <select id="mySelect" name="selection">
                <c:forEach begin="5" end="25" varStatus="loop">
                    <option value=${loop.index}>Option ${loop.index}</option>
                </c:forEach>
            </select>
        </div>

        <div class="flex flex-col">
            <label>
                Enter The Name Of The City:
            </label>
            <input class=" p-4" type="text" name="city"/>
        </div>
        <div class="flex flex-col ">
            <label>
                Enter The Real Person:
            </label>
            <input class=" p-4" type="text" name="person"/>
        </div>
        <div class="flex flex-col ">
            <label>
                Enter The Hobby:
            </label>
            <input class="p-4" type="text" name="hobby"/>
        </div>
        <div class="flex flex-col p-4 " >
            <label>
                Enter The Hobby:
            </label>
            <textarea  class="p-4" name="nice" rows="5" cols="40" placeholder="Enter ...">

            </textarea><br>
        </div>
        <input type="submit" class="bg-gray-500 text-white"/>

    </form>
    </div>

</h1>
</body>
</html>