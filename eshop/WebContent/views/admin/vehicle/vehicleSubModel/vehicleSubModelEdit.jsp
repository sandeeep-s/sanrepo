<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.submodel.edit" />
</h1>
<sf:form action="/eshop/vehiclesubmodel/${vehicleSubModel.id}" method="PUT" modelAttribute="vehicleSubModel">
	<label><s:message code="vehicle.model" /> : </label>
	<sf:select path="vehicleModel">
		<c:forEach items="${vehicleModels}" var="vehicleModelVar">
			<c:if test="${vehicleModel.vehicleModel.id == vehicleModelVar.id}">
				<sf:option value="${vehicleModelVar.id}" selected="true">${vehicleModelVar.name}</sf:option>
			</c:if>
			<c:if test="${vehicleModel.vehicleModel.id != vehicleModelVar.id}">
				<sf:option value="${vehicleModelVar.id}">${vehicleModelVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleModel" />
	<br />
	<br />
	<label><s:message code="vehicle.submodel.name" /> : </label>
	<sf:input type="text" path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.submodel.edit'/>">
</sf:form>
