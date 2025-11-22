<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>World Data</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin-bottom: 30px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        h2 { margin-top: 40px; }
    </style>
</head>
<body>
<h1>World Data</h1>

<h2>Countries Speaking Slovak</h2>
<table>
    <tr>
        <th>Country Name</th>
        <th>Language</th>
        <th>Percentage</th>
    </tr>
    <c:forEach var="c" items="${countriesSpeakingEnglish}">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
        </tr>
    </c:forEach>
</table>

<h2>City Counts per Country</h2>
<table>
    <tr>
        <th>Country</th>
        <th>Number of Cities</th>
    </tr>
    <c:forEach var="city" items="${cityCounts}">
        <tr>
            <td>${city[0]}</td>
            <td>${city[1]}</td>
        </tr>
    </c:forEach>

</table>


<h2>Mexican Cities with a population of greater than 500,000</h2>
<table>
    <tr>
        <th>City</th>
        <th>Population</th>
    </tr>
    <c:forEach var="city" items="${mexicanBigCities}">
        <tr>
            <td>${city.name}</td>
            <td>${city.population}</td>
        </tr>
    </c:forEach>
</table>

<h2> Language with more than 89 % </h2>
<table>
    <tr>
        <th>Country</th>
        <th>Language</th>
        <th>Percentage</th>
    </tr>
    <c:forEach var="language" items="${allLanguagesEachCountry}">
        <tr>
            <td>${language[0]}</td>
            <td>${language[1]}</td>
            <td>${language[2]}</td>
        </tr>
    </c:forEach>
</table>



<h2>Surface Area below 501 and Population greater than 100,000</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surface Area</th>
        <th>Population</th>
    </tr>
    <c:forEach var="c" items="${smallPopCountries}">
        <tr>
            <td>${c.name}</td>
            <td>${c.surfaceArea}</td>
            <td>${c.population}</td>
        </tr>
    </c:forEach>
</table>

<h2>Constitutional Monarchies</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surface Area</th>
        <th>Life Expectancy</th>
    </tr>
    <c:forEach var="c" items="${monarchies}">
        <tr>
            <td>${c.name}</td>
            <td>${c.surfaceArea}</td>
            <td>${c.lifeExpectancy}</td>
        </tr>
    </c:forEach>
</table>


<h2>Argentina Big Cities</h2>
<table>
    <tr>
        <th>Country</th>
        <th>City</th>
        <th>Area</th>
        <th>Population</th>

    </tr>
    <c:forEach var="c" items="${argentinaBigCities}">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
            <td>${c[3]}</td>

        </tr>
    </c:forEach>
</table>


<h2>Countries By Region</h2>
<table>
    <tr>
        <th>Region</th>
        <th>Number Of Countries</th>

    </tr>
    <c:forEach var="c" items="${countriesRegion}">
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>

        </tr>
    </c:forEach>
</table>


</body>
</html>
