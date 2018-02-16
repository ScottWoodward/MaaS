<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

</head>
<body>

    <form:form method="post" action="/v1/chain" modelAttribute="request">
        <form:input path="sources[0]"/>
        <form:input path="sources[1]"/>
        <form:input path="sources[2]"/>
        <input type="submit"/>
    </form:form>

    <div class="starter-template">
        <h1>Spring Boot Web JSP Example</h1>
        <h2>Message: ${message}</h2>
    </div>

</body>

</html>