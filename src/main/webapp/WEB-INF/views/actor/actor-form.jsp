<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:genericpage>
    <jsp:body>
    
    	<form:form modelAttribute="actor" method="POST" action="/${ context }/actor/" cssClass="form-horizontal">
    	
   			<form:hidden path="id" />
    		
    		<div class="form-group">
    			<form:label path="id" cssClass="col-sm-2 control-label">Firstname</form:label>
	    		<form:input path="firstName" />
    			<form:errors path="firstName" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<form:label path="lastName" cssClass="col-sm-2 control-label">Lastname</form:label>
	    		<form:input path="lastName" />
	    		<form:errors path="lastName" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<form:label path="birthDate" cssClass="col-sm-2 control-label">Birthdate</form:label>
    			<form:input path="birthDate" placeholder="yyyy-MM-dd" />
    			<form:errors path="birthDate" cssClass="error" />
    		</div>
    		
    		<div class="form-group">
    			<div class="col-sm-offset-2">
	    			<input type="submit" value="${ submit }" class="btn btn-default" />
	    		</div>
    		</div>
    	
    	</form:form>
    	
    </jsp:body>
</t:genericpage>