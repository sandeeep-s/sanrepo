<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.add" />
</h1>
<sf:form action="/etyre-spring-rest/vehiclemake" method="POST" enctype="multipart/form-data" modelAttribute="vehicleMake">
	<label><s:message code="vehicle.make.name" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
	<sf:input path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="vehicle.make.logo" /> : </label>
	<input type="file" name="logoImage">
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.make.add'/>">
</sf:form>
