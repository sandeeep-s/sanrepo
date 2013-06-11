<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.select" />
</h1>
<br />
<br />
<form id="vehicleSelectionForm" name="vehicleSelectionForm" method="GET">
	<label><s:message code="vehicle.model" /> : </label>
	<select id="vehicleModelId" name="vehicleModelId">
		<option value="-1">
			<s:message code="select" />
		</option>
		<c:forEach items="${vehicleModels}" var="vehicleModelVar">
			<option value="${vehicleModelVar.id}">${vehicleModelVar.name}</option>
		</c:forEach>
	</select>
	<input type="button" value="<s:message code='search'/>" onclick="submitFitmentSearchForm();">
</form>

<script type="text/javascript">
function submitFitmentSearchForm(){
	var vehicleModelId = $("#vehicleModelId").val();
	$("#vehicleSelectionForm").attr("action","/eshop/tirefitment/original/category/1/vehiclemodel/"+vehicleModelId);
	$("#vehicleSelectionForm").submit();
}	
</script>