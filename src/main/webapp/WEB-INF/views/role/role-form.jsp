<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:genericpage>
    <jsp:body>
    
    	<form:form modelAttribute="role" method="POST" action="/${ context }/role/" cssClass="form-horizontal">
    	
   			<form:hidden path="id" />
   			
   			<div class="form-group">
    			<form:label path="firstName" cssClass="col-sm-2 control-label">Firstname</form:label>
	    		<form:input path="firstName" />
    			<form:errors path="firstName" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<form:label path="lastName" cssClass="col-sm-2 control-label">Lastname</form:label>
	    		<form:input path="lastName" />
	    		<form:errors path="lastName" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<form:label path="actor.id" cssClass="col-sm-2 control-label">Actor</form:label>
	    		<form:select path="actor.id" items="${ actors }" itemValue="id" itemLabel="fullName" />
	    		<form:errors path="actor.id" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<form:label path="movie.id" cssClass="col-sm-2 control-label">Movie</form:label>
	    		<form:select path="movie.id" items="${ movies }" itemValue="id" itemLabel="title" />
	    		<form:errors path="movie.id" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<div class="col-sm-offset-2">
	    			<input type="submit" value="${ submit }" class="btn btn-default" />
	    		</div>
    		</div>
    	
    	</form:form>
    	
    </jsp:body>
</t:genericpage>