<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle" />
</h1>

<label><s:message code="vehicle.model" /> : </label> ${vehicleFitment.vehicleModel.name}
<br />
<br />
<label><s:message code="vehicle.fitment" /> : </label>
<c:forEach items="${vehicleFitment.fitmentComponents}" var="fitmentComponent" varStatus="status">
	<label><s:message code="vehicle.fitment.product" /> : </label> ${fitmentComponent.product.name}
	<br />
	<br />
	<label><s:message code="vehicle.fitment.position" /> : </label> ${fitmentComponent.position}
	<br />
	<br />
</c:forEach>
<label><s:message code="vehicle.fitment.original.equipment" /> : </label> ${fitmentComponent.originalEquipment ? "Yes" : "No"}
<br />
<br />
<input type="submit" value="<s:message code='vehicle.fitment.add'/>">
