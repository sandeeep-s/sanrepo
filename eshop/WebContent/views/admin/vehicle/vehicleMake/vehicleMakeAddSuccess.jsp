<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.added" />
</h1>

<label><s:message code="vehicle.make.name" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
${requestScope.vehicleMake.name}
<br />
<br />
<label><s:message code="vehicle.make.logo" /> : </label>
<img src="<c:url value='/resources/images/${requestScope.vehicleMake.logoImage.mediaFileName}'/>" title="${requestScope.vehicleMake.name}">
