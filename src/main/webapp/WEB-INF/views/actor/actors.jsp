<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:body>

		<a href="/${ context }/actor/add" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>
			Add actor
		</a>

    	<table class="table">
    		
    		<thead>
    			<tr>
    				<th>Firstname</th>
    				<th>Lastname</th>
    				<th>Birthdate</th>
    				<th></th>
    				<th></th>
    				<th></th>
    			</tr>
    		</thead>
    		
    		<tbody>
    			<c:forEach var="actor" items="${ actors }">
    				<tr>
    					<th>${ actor.firstName }</th>
    					<th>${ actor.lastName }</th>
    					<th><fmt:formatDate pattern="yyyy-MM-dd" value="${ actor.birthDate }" /></th>
    					<th><a href="/${ context }/actor/${ actor.id }">Show</a></th>
    					<th><a href="/${ context }/actor/update/${ actor.id }">Update</a></th>
    					<th><a href="/${ context }/actor/delete/${ actor.id }">Delete</a></th>
    				</tr>
    			</c:forEach>
    		</tbody>
    		
		</table>
		
    </jsp:body>
</t:genericpage>