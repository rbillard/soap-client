<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:body>

		<a href="/${ context }/movie/add" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>
			Add movie
		</a>

    	<table class="table">
    		
    		<thead>
    			<tr>
    				<th>Title</th>
    				<th></th>
    				<th></th>
    				<th></th>
    			</tr>
    		</thead>
    		
    		<tbody>
    			<c:forEach var="movie" items="${ movies }">
    				<tr>
    					<th><c:out value="${ movie.title }" /></th>
    					<th><a href="/${ context }/movie/${ movie.id }">Show</a></th>
    					<th><a href="/${ context }/movie/update/${ movie.id }">Update</a></th>
    					<th><a href="/${ context }/movie/delete/${ movie.id }">Delete</a></th>
    				</tr>
    			</c:forEach>
    		</tbody>
    		
		</table>
		
    </jsp:body>
</t:genericpage>