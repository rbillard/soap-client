<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:genericpage>
    <jsp:body>
    
    	<form:form modelAttribute="movie" method="POST" action="/${ context }/movie/" cssClass="form-horizontal">
    	
   			<form:hidden path="id" />
    		
    		<div class="form-group">
    			<form:label path="title" cssClass="col-sm-2 control-label">Title</form:label>
	    		<form:input path="title" />
    			<form:errors path="title" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<div class="col-sm-offset-2">
	    			<input type="submit" value="${ submit }" class="btn btn-default" />
	    		</div>
    		</div>
    	
    	</form:form>
    	
    </jsp:body>
</t:genericpage>