<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="tech.spec.property" />
</h1>

<label><s:message code="category" /> : </label> ${techSpecProperty.category.name}
<br />
<br />
<label><s:message code="tech.spec.property.name" /> : </label> ${techSpecProperty.name}
<br />
<br />
<label><s:message code="tech.spec.property.unit" /> : </label> ${techSpecProperty.unit}
<br />
<br />
<label><s:message code="tech.spec.property.description" /> : </label> ${techSpecProperty.description}
<br />
<br />
