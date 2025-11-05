<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
</head>
<body>
<h2><c:out value="${name}"/></h2>
<h2><c:out value="${itemName}"/></h2>
<h2><c:out value="${price}"/></h2>
<h2><c:out value="${description}"/></h2>
<h2><c:out value="${vendor}"/></h2>

</body>
</html>