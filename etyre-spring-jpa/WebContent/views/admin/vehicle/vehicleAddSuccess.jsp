<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.added" />
</h1>

<label><s:message code="vehicle.make" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
${vehicle.make.name}
<br />
<br />
<label><s:message code="vehicle.model" /> : </label>
${vehicle.model}
<br />
<br />
<label><s:message code="vehicle.submodel" /> : </label>
${vehicle.subModel}
<br />
<br />
<label><s:message code="vehicle.year" /> : </label>
${vehicle.manufacturingYear}
<br />
<br />
<label><s:message code="vehicle.image" /> : </label>
<img src="<c:url value='/resources/images/${vehicle.imageURL}'/>" title="${vehicle.model}" alt="${vehicle.model}"></img>
<br />
<br />
