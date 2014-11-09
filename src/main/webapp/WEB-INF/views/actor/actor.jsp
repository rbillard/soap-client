<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:body>
    
        <p><c:out value="${ actor.firstName }" /> <c:out value="${ actor.lastName }" /> <fmt:formatDate pattern="yyyy-MM-dd" value="${ actor.birthDate }" /></p>
        
        <h4>Roles</h4>
        <ul>
	        <c:forEach var="role" items="${ actor.roles }">
	        	<li>
	        		<a href="/${ context }/role/${ role.id }"><c:out value="${ role.firstName }" /> <c:out value="${ role.lastName }" /></a>
	        		- Movie : 
	        		<a href="/${ context }/movie/${ role.movie.id }"><c:out value="${ role.movie.title }" /></a>
	        	</li>
	        </c:forEach>
        </ul>
        
    </jsp:body>
</t:genericpage>