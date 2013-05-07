<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.edit" />
</h1>
<sf:form action="/etyre-spring-rest/vehicle/${vehicle.id}" method="PUT" enctype="multipart/form-data" modelAttribute="vehicle">
	<label><s:message code="vehicle.make" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label>
	<sf:select path="make" disabled="true">
		<c:forEach items="${vehicleMakeSet}" var="vehicleMake">
			<c:if test="${vehicle.make.id == vehicleMake.id}">
				<sf:option value="${vehicleMake.id}" selected="true">${vehicleMake.name}</sf:option>
			</c:if>
			<c:if test="${vehicle.make.id != vehicleMake.id}">
				<sf:option value="${vehicleMake.id}">${vehicleMake.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="make" />
	<br />
	<br />
	<label><s:message code="vehicle.model" /> : </label>
	<sf:input type="text" path="model" disabled="true"/>
	<sf:errors path="model" />
	<br />
	<br />
	<label><s:message code="vehicle.submodel" /> : </label>
	<sf:input type="text" path="subModel"  disabled="true"/>
	<sf:errors path="subModel" />
	<br />
	<br />
	<label><s:message code="vehicle.year" /> : </label>
	<sf:select path="manufacturingYear" disabled="true">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:if test="${vehicle.manufacturingYear == 2012}">
			<sf:option value="2012" selected="true">2012</sf:option>
		</c:if>
		<c:if test="${vehicle.manufacturingYear != 2012}">
			<sf:option value="2012" selected="true">2012</sf:option>
		</c:if>
		<c:if test="${vehicle.manufacturingYear == 2011}">
			<sf:option value="2011" selected="true">2011</sf:option>
		</c:if>
		<c:if test="${vehicle.manufacturingYear != 2011}">
			<sf:option value="2011" selected="true">2011</sf:option>
		</c:if>
	</sf:select>
	<sf:errors path="manufacturingYear" />
	<br />
	<br />
	<label><s:message code="image" /> : </label>
	<input type="file" name="image">
	<img src="<c:url value='/resources/images/${vehicle.imageURL}'/>" title="${vehicle.model}" alt="${vehicle.model}"></img><br /> <br /> 
	<input type="submit" value="<s:message code='vehicle.edit'/>">
</sf:form>

