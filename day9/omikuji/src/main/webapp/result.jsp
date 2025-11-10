<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<h1>
    <div class="mx-auto w-1/4 flex flex-col gap-5">
        <h1 class="text-4xl font-bold text-black-800">Send an Omikuji </h1>

        <div class="flex flex-col  ">
            <div>
                <c:out value="${city}"></c:out>
            </div>
           <div>
               <c:out value="${person}"></c:out>
           </div>
            <div>
                <c:out value="${hobby}"></c:out>
            </div>
            <div>
                <c:out value="${nice}"></c:out>
            </div>

        </div>
    </div>

</h1>
</body>
</html>