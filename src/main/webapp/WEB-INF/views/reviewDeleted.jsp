<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<title>Delete review</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="resources/main.css" rel="stylesheet" />
</head>
<body>

<div id="wrapper">
<div id="content">

<jsp:include page="${request.contextPath}/loginheader" />

<div id="content-inside">

<c:choose>
<c:when test="${fn:contains(referrerUrl, 'displaymovie')}">
	<c:set var="pageName" value="movie" />
</c:when>
<c:otherwise>
	<c:set var="pageName" value="user" />	
</c:otherwise>
</c:choose>

<h2>Review deleted</h2>
<p>Review has been successfully deleted.</p>
<p><a href="${referrerUrl}">Back to <c:out value="${pageName}"/> page</a></p>

</div>
<div id="content-inside"></div>

<jsp:include page="footer.jsp" />

</div>
</div>

</body>
</html>