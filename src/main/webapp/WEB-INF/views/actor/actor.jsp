<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:body>
        <p>${ actor.firstName } ${ actor.lastName } <fmt:formatDate pattern="yyyy-MM-dd" value="${ actor.birthDate }" /></p>
    </jsp:body>
</t:genericpage>