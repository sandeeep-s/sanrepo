<%@page import="com.eshop.vehiclefitment.model.VehiclePosition"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.fitment.edit" />
</h1>
<sf:form action="/eshop/vehiclefitment/${vehicleFitment.id}" method="PUT" modelAttribute="vehicleFitment">
	<sf:input type="hidden" path="id"/>
	<sf:input type="hidden" path="version"/>
	<label><s:message code="vehicle.model" /> : </label> ${vehicleFitment.vehicleModel.name}
	<sf:input type="hidden" path="vehicleModel" value="${vehicleFitment.vehicleModel.id}"/>
	<br />
	<br />
	<label><s:message code="vehicle.fitment.name" /> : </label>
	<c:forEach items="${vehicleFitment.fitmentComponents}" var="fitmentComponent" varStatus="status">
		<label><s:message code="vehicle.fitment.product" /> : </label>
		<sf:select path="fitmentComponents[${status.index}].product">
			<sf:options items="${products}" itemLabel="name" itemValue="id"/>
		</sf:select>
		<sf:errors path="fitmentComponents[${status.index}].product"/>
		<br />
		<br />
		<label><s:message code="vehicle.fitment.position" /> : </label>
		<sf:select path="fitmentComponents[${status.index}].position">
			<sf:option value="<%=VehiclePosition.ALL%>"><%=VehiclePosition.ALL%></sf:option>
		</sf:select>
		<sf:errors path="fitmentComponents[${status.index}].position"/>
		<br />
		<br />
	</c:forEach>
	<label><s:message code="vehicle.fitment.original.equipment" /> : </label>
	<sf:radiobutton path="originalEquipment" value="true" label="Yes" />
	<sf:radiobutton path="originalEquipment" value="false" label="No"/>
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.fitment.edit'/>">
</sf:form>
