<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.edited" />
</h1>

<label><s:message code="vehicle.make.name" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
${requestScope.vehicleMake.name}
<br />
<br />
<label><s:message code="vehicle.make.logo" /> : </label>
${requestScope.vehicleMake.logoURL}
