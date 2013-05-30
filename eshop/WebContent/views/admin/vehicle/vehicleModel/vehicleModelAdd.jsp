<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.model.add" />
</h1>
<sf:form action="/eshop/vehiclemodel" method="POST" modelAttribute="vehicleModel">
	<label><s:message code="vehicle.make" /> : </label>
	<sf:select path="vehicleMake">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${vehicleMakes}" var="vehicleMakeVar">
			<sf:option value="${vehicleMakeVar.id}">${vehicleMakeVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleMake" />
	<br />
	<br />

	<label><s:message code="vehicle.type" /> : </label>
	<sf:select path="vehicleType">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${vehicleTypes}" var="vehicleTypeVar">
			<sf:option value="${vehicleTypeVar.id}">${vehicleTypeVar.name}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="vehicleType" />
	<br />
	<br />

	<label><s:message code="vehicle.model.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />

	<label><s:message code="vehicle.model.year" /> : </label>
	<sf:select path="modelYear">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${modelYearsRefList}" var="modelYearRef">
			<sf:option value="${modelYearRef}">${modelYearRef}</sf:option>
		</c:forEach>
	</sf:select>
	<sf:errors path="modelYear" />
	<br />
	<br />

	<h3><s:message code="vehicle.model.image" /> : </h3>
	<c:forEach items="${vehicleModel.images}" var="image" varStatus="status">
		<s:message code="vehicle.model.image" /> ${status.count} :<br/>
		<sf:input type="hidden" path="images[${status.index}].mediaType" value="<%=MediaType.IMAGE%>"/>
		<label><s:message code="image.filename" /> : </label>
		<sf:input path="images[${status.index}].mediaFileName"/>
		<sf:errors path="images[${status.index}].mediaFileName"/>
		<br />
		<br />
		<label><s:message code="image.name" /> : </label>
		<sf:input path="images[${status.index}].mediaName"/>
		<sf:errors path="images[${status.index}].mediaName"/>
		<br />
		<br />
		<label><s:message code="image.thumbnailFileName" /> : </label>
		<sf:input path="images[${status.index}].mediaThumbnailFileName"/>
		<sf:errors path="images[${status.index}].mediaThumbnailFileName"/>
		<br />
		<br />
	</c:forEach>
	<input type="submit" value="<s:message code='vehicle.model.add'/>">
</sf:form>
