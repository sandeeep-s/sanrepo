<%@include file="../init.jsp"%>

<label><s:message code="vehicle.model" /> : </label>
<select id="vehicleModel" name="vehicleModel">
	<option value="-1">
		<s:message code="select" />
	</option>
	<c:forEach items="${vehicleModels}" var="vehicleModelVar">
		<option value="${vehicleModelVar.id}">${vehicleModelVar.name}</option>
	</c:forEach>
</select>
