<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<h1>
    <div class="mx-auto w-3/4 flex flex-col gap-5 items-center mt-10">
        <div class="flex gap-9 self-start">
            <h1 class="text-4xl font-bold text-black-800">Your Gold : </h1>
            <div class="flex justify-center items-center ">
                <c:out value="${gold}"></c:out>
            </div>
        </div>

        <div class="flex  gap-9">
            <div class="flex flex-col gap-8 border-4 border-black p-10">
                <label>
                    Farm
                </label>
                <label>
                    (earns 10-20 gold)
                </label>

                <form action="/submit" method="post">
                    <input type="hidden" name="type" value="Farm"/>
                    <button class="border-2">
                        Find Gold!
                    </button>
                </form>
            </div>
            <div class="flex flex-col gap-8 border-4 border-black p-10">
                <label>
                    Cave
                </label>
                <label>
                    (earns 5-10 gold)
                </label>
                <form action="/submit" method="post">
                    <input type="hidden" name="type" value="Cave"/>
                    <button class="border-2">
                        Find Gold!
                    </button>
                </form>

            </div>
            <div class="flex flex-col gap-8 border-4 border-black p-10">
                <label>
                    House
                </label>
                <label>
                    (earns 2-5 gold)
                </label>
                <form action="/submit" method="post">
                    <input type="hidden" name="type" value="House"/>
                    <button class="border-2">
                        Find Gold!
                    </button>
                </form>
            </div>
            <div class="flex flex-col gap-8 border-4 border-black p-10">
                <label>
                    Quest
                </label>
                <label>
                    (earns 0-50 gold)
                </label>
                <form action="/submit" method="post">
                    <input type="hidden" name="type" value="Quest"/>
                    <button class="border-2">
                        Find Gold!
                    </button>
                </form>
            </div>

        </div>

        <div class="flex gap-9 self-start mt-9">
            <h1 class="text-4xl font-bold text-black-800 ">Activities: </h1>
        </div>

        <div class="w-full h-64 p-4 border rounded-md bg-gray-100 overflow-y-auto">
            <c:forEach var="item" items="${info}">
                <c:choose>
                    <c:when test="${fn:contains(item, 'earned')}">
                        <p class="text-green-600 mb-1"><c:out value="${item}" /></p>
                    </c:when>
                    <c:otherwise>
                        <p class="text-red-600 mb-1"><c:out value="${item}" /></p>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>




    </div>

</h1>
</body>
</html>