<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <p>Error from url : ${ url }</p>
        <p>Message : ${ exception.getMessage() }</p>
    </jsp:body>
</t:genericpage>