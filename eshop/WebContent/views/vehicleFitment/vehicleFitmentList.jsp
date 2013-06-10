<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.fitment.list" />
</h1>
<a href="<c:url value='/vehiclefitment/add'/>"><s:message code="vehicle.fitment.add" /></a>
<br />
<br />
<form id="fitmentSearchForm" name="fitmentSearchForm" method="GET">
	<label><s:message code="vehicle.model" /> : </label>
	<select id="vehicleModelId" name="vehicleModelId">
		<option value="-1">
			<s:message code="select" />
		</option>
		<c:forEach items="${vehicleModels}" var="vehicleModelVar">
			<option value="${vehicleModelVar.id}">${vehicleModelVar.name}</option>
		</c:forEach>
	</select>
	<input type="button" value="<s:message code='vehicle.fitment.add'/>" onclick="submitFitmentSearchForm();">
</form>
<table>
	<tr>
		<th><s:message code="vehicle.model.name" /></th>
		<th><s:message code="vehicle.fitment" /></th>
	</tr>
	<c:forEach items="${vehicleFitments}" var="vehicleFitment">
		<tr>
			<td>${vehicleFitment.vehicleModel.name}</td>
			<td>${vehicleFitment.id}</td>
			<td><a href="<c:url value='/vehiclefitment/${vehicleFitment.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehiclefitment/${vehicleFitment.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/vehiclefitment/${vehicleFitment.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>

<script type="text/javascript">
function submitFitmentSearchForm(){
	var vehicleModelId = $("#vehicleModelId").val();
	$("#fitmentSearchForm").attr("action","/eshop/vehiclefitment/vehiclemodel/"+vehicleModelId);
	$("#fitmentSearchForm").submit();
}	
</script>