<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.edit" />
</h1>
<sf:form action="/etyre-spring-rest/vehiclemake/${vehicleMake.id}" method="PUT" enctype="multipart/form-data"
	modelAttribute="vehicleMake">
	<label><s:message code="vehicle.make.name" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
	<sf:input type="text" path="name" value="${vehicleMake.name}" disabled="true" />
	<br />
	<br />
	<label><s:message code="vehicle.make.logo" /> : </label>
	<img src="<c:url value='/resources/images/${vehicleMake.logoURL}'/>" title="${vehicleMake.name}">
	<br />
	<br />
	<input type="file" name="logoImage">
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.make.edit'/>">
</sf:form>
