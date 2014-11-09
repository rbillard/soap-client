<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:body>
    
        <p><c:out value="${ role.firstName }" /> <c:out value="${ role.lastName }" /></p>
        
        <p>
        	Actor : 
        	<a href="/${ context }/actor/${ role.actor.id }"><c:out value="${ role.actor.firstName }" /> <c:out value="${ role.actor.lastName }" /></a>
        </p>
        
        <p>
        	Movie : 
        	<a href="/${ context }/movie/${ role.movie.id }"><c:out value="${ role.movie.title }" /></a>
        </p>
        
    </jsp:body>
</t:genericpage>