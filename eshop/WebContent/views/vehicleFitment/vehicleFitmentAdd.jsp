<%@page import="com.eshop.vehiclefitment.model.VehiclePosition"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.fitment.add" />
</h1>
<sf:form action="/eshop/vehiclefitment" method="POST" modelAttribute="vehicleFitment">
	<label><s:message code="vehicle.model" /> : </label>
	<sf:select path="vehicleModel">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.vehicleModels}" var="vehicleModelVar">
			<sf:option value="${vehicleModelVar.id}">${vehicleModelVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleModel" />
	<br />
	<br />
	<label><s:message code="vehicle.fitment.name" /> : </label>
	<c:forEach items="${vehicleFitment.fitments}" var="fitment" varStatus="fitmentStatus">
		<c:forEach items="${fitment.fitmentComponents}" var="fitmentComponent" varStatus="componentStatus">
			<label><s:message code="vehicle.fitment.product" /> : </label>
			<sf:select path="fitments[${fitmentStatus.index}].fitmentComponents[${componentStatus.index}].product">
				<sf:option value="-1">
					<s:message code="select" />
				</sf:option>
				<c:forEach items="${products}" var="product" varStatus="status">
					<sf:option value="${product.id}">${product.name}</sf:option>
				</c:forEach>
			</sf:select>
			<sf:errors path="fitments[${fitmentStatus.index}].fitmentComponents[${componentStatus.index}].product"/>
			<br />
			<br />
			<label><s:message code="vehicle.fitment.position" /> : </label>
			<sf:select path="fitments[${fitmentStatus.index}].fitmentComponents[${componentStatus.index}].position">
				<sf:option value="-1">
					<s:message code="select" />
				</sf:option>
				<sf:option value="<%=VehiclePosition.ALL%>"><%=VehiclePosition.ALL%></sf:option>
			</sf:select>
			<sf:errors path="fitments[${fitmentStatus.index}].fitmentComponents[${componentStatus.index}].position"/>
			<br />
			<br />
		</c:forEach>
		<label><s:message code="vehicle.fitment.original.equipment" /> : </label>
		<sf:radiobutton path="fitments[${fitmentStatus.index}].originalEquipment" value="true" label="Yes"/>
		<sf:radiobutton path="fitments[${fitmentStatus.index}].originalEquipment" value="false" label="No"/>
		<br />
		<br />
	</c:forEach>
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.fitment.add'/>">
</sf:form>
