<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:body>

		<a href="/${ context }/role/add" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>
			Add role
		</a>

    	<table class="table">
    		
    		<thead>
    			<tr>
    				<th>Firstname</th>
    				<th>Lastname</th>
    				<th></th>
    				<th></th>
    				<th></th>
    			</tr>
    		</thead>
    		
    		<tbody>
    			<c:forEach var="role" items="${ roles }">
    				<tr>
    					<th><c:out value="${ role.firstName }" /></th>
    					<th><c:out value="${ role.lastName }" /></th>
    					<th><a href="/${ context }/role/${ role.id }">Show</a></th>
    					<th><a href="/${ context }/role/update/${ role.id }">Update</a></th>
    					<th><a href="/${ context }/role/delete/${ role.id }">Delete</a></th>
    				</tr>
    			</c:forEach>
    		</tbody>
    		
		</table>
		
    </jsp:body>
</t:genericpage>