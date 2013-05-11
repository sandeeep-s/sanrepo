<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.submodel.add" />
</h1>
<sf:form action="/eshop/vehiclesubmodel" method="POST" modelAttribute="vehicleSubModel">
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
	<label><s:message code="vehicle.submodel.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.submodel.add'/>">
</sf:form>
