<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
        <p>Communication error with the server hosting web services.</p>
        <ul>
        	<li>Is the server started ?</li>
        	<li>The server address is : ${ soapServerAddress }, is that correct ?</li>
        </ul>
    </jsp:body>
</t:genericpage>