<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search Results</title>
</head>
<body>
<h1>The parking spot details  are</h1>
<form action="LogoutController" method="post">
<button type="submit" style="position:fixed;right:10px;top:5px" name="btnLogout">Logout</button>
</form>
<table border="1">
<tr>
<td>Parking Area Name	</td>&nbsp;
<td>Floor 	</td>&nbsp;
<td>Parking Type	</td>&nbsp;
<td>Parking Capacity </td>
</tr>
<c:forEach items = "${parkdet}" var ="park">
<tr>
<td> <c:out value= "${park.parkingAreaName}" /></td>
<td><c:out value = "${park.floor} "/></td>
<td><c:out value= "${park.parkingType}" /></td>
<td><c:out value = "${park.pcapacity} "/></td>
<td><button type="submit">Select </button></td>
</tr>
</c:forEach>

</table>
</body>
</html>