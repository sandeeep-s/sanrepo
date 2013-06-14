<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.original.equipment"/>
</h1>
<br />
<br />

<c:forEach items="${tireFitmentForms}" var="tireFitmentForm" varStatus="tire">

<table>
	<tr>
		<th><s:message code="vehicle.fitment.position" /></th>
		<th><s:message code="vehicle.fitment.size" /></th>
	</tr>
	<c:forEach items="${tireFitmentForm.fitmentComponentForms}" var="fitmentComponentForm">
		<tr>
			<td>${fitmentComponentForm.position}</td>
			<td>${fitmentComponentForm.section}/${fitmentComponentForm.aspectRatio}-${fitmentComponentForm.diameter}</td>
			<td><a href="<c:url value='/product/category/tire/dimension/${fitmentComponentForm.section}/${fitmentComponentForm.aspectRatio}/${fitmentComponentForm.diameter}'/>"><s:message code="view.products.matching.size" /></a></td>
			<td><a href="<c:url value='/product/category/tire/dimension/${fitmentComponentForm.section}/${fitmentComponentForm.aspectRatio}/${fitmentComponentForm.diameter}/${vehicleModelId}'/>"><s:message code="view.original.equipment" /></a></td>
			
		</tr>	
	</c:forEach>
</table>
	
	
</c:forEach>
