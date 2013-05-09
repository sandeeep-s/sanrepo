<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.model.edit" />
</h1>
<sf:form action="/eshop/vehiclemodel/${vehicleModel.id}" method="PUT" modelAttribute="vehicleModel">
	<label><s:message code="vehicle.make" /> : </label>
	<sf:select path="vehicleMake">
		<c:forEach items="${vehicleMakes}" var="vehicleMakeVar">
			<c:if test="${vehicleModel.vehicleMake.id == vehicleMakeVar.id}">
				<sf:option value="${vehicleMakeVar.id}" selected="true">${vehicleMakeVar.name}</sf:option>
			</c:if>
			<c:if test="${vehicleModel.vehicleMake.id != vehicleMakeVar.id}">
				<sf:option value="${vehicleMakeVar.id}">${vehicleMakeVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleMake" />
	<br />
	<br />
	<label><s:message code="vehicle.type" /> : </label>
	<sf:select path="vehicleType">
		<c:forEach items="${vehicleTypes}" var="vehicleTypeVar">
			<c:if test="${vehicleModel.vehicleType.id == vehicleTypeVar.id}">
				<sf:option value="${vehicleTypeVar.id}" selected="true">${vehicleTypeVar.name}</sf:option>
			</c:if>
			<c:if test="${vehicleModel.vehicleType.id != vehicleTypeVar.id}">
				<sf:option value="${vehicleTypeVar.id}">${vehicleTypeVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleType" />
	<br />
	<br />
	<label><s:message code="vehicle.model.name" /> : </label>
	<sf:input type="text" path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="vehicle.model.year" /> : </label>
	<sf:select path="manufacturingYear">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:if test="${vehicleModel.manufacturingYear == 2012}">
			<sf:option value="2012" selected="true">2012</sf:option>
		</c:if>
		<c:if test="${vehicleModel.manufacturingYear != 2012}">
			<sf:option value="2012" selected="true">2012</sf:option>
		</c:if>
		<c:if test="${vehicleModel.manufacturingYear == 2011}">
			<sf:option value="2011" selected="true">2011</sf:option>
		</c:if>
		<c:if test="${vehicleModel.manufacturingYear != 2011}">
			<sf:option value="2011" selected="true">2011</sf:option>
		</c:if>
	</sf:select>
	<sf:errors path="manufacturingYear" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.model.edit'/>">
</sf:form>
