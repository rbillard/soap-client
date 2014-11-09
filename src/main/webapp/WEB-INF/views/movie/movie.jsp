<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:body>
    
        <p><c:out value="${ movie.title }" /></p>
        
        <h4>Roles</h4>
        <ul>
	        <c:forEach var="role" items="${ movie.roles }">
	        	<li>
	        		<a href="/${ context }/role/${ role.actor.id }-${ movie.id }"><c:out value="${ role.firstName }" /> <c:out value="${ role.lastName }" /></a>
	        		- Actor : 
	        		<a href="/${ context }/actor/${ role.actor.id }"><c:out value="${ role.actor.firstName }" /> <c:out value="${ role.actor.lastName }" /></a>
	        	</li>
	        </c:forEach>
        </ul>
        
    </jsp:body>
</t:genericpage>