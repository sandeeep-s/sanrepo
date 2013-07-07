<label><s:message code="vehicle.make" /> : </label>
<select id="vehicleMakeId" name="vehicleMakeId" onchange="getModelYearsForMake()">
	<option value="-1">
		<s:message code="select" />
	</option>
	<c:forEach items="${vehicleMakes}" var="vehicleMake">
		<option value="${vehicleMake.id}">${vehicleMake.name}</option>
	</c:forEach>
</select>
