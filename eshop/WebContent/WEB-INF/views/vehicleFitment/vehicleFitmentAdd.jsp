<%@page import="com.eshop.vehiclefitment.model.VehiclePosition"%>
<%@include file="../init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.fitment.add" />
</h1>
<sf:form action="/eshop/vehiclefitment" method="POST" modelAttribute="vehicleFitment">
	<label><s:message code="vehicle.model" /> : </label>
	<sf:select path="vehicleModel">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${vehicleModels}" var="vehicleModelVar">
			<sf:option value="${vehicleModelVar.id}">${vehicleModelVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleModel" />
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
	<sf:radiobutton path="originalEquipment" value="false" label="No" checked="true"/>
	<br />
	<br />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.fitment.add'/>">
</sf:form>
