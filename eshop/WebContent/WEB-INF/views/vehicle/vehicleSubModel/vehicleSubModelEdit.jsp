<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.submodel.edit" />
</h1>
<sf:form action="/eshop/vehiclesubmodel/${vehicleSubModel.id}" method="PUT" modelAttribute="vehicleSubModel">
	<sf:input type="hidden" path="id" value="${vehicleSubModel.id}" />
	<sf:input type="hidden" path="version" value="${vehicleSubModel.version}" />
	<label><s:message code="vehicle.make" /> : </label>
	${vehicleSubModel.vehicleModel.vehicleMake.name}
	<br />
	<br />
	<label><s:message code="vehicle.type" /> : </label>
	${vehicleSubModel.vehicleModel.vehicleType.name}
	<br />
	<br />
	<label><s:message code="vehicle.model" /> : </label>
	${vehicleSubModel.vehicleModel.name}
	<sf:input type="hidden" path="vehicleModel" value="${vehicleSubModel.vehicleModel.id}"/>
	<br />
	<br />
	<label><s:message code="vehicle.model.year" /> : </label>
	${vehicleSubModel.vehicleModel.modelYear}
	<br />
	<br />
	<label><s:message code="vehicle.submodel.name" /> : </label>
	<sf:input type="text" path="name" />
	<sf:errors path="name" />
	<br />
	<br />
	<h3><s:message code="vehicle.submodel.image" /> : </h3>
	<c:forEach items="${vehicleSubModel.images}" var="image" varStatus="status">
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
	<input type="submit" value="<s:message code='vehicle.submodel.edit'/>">
</sf:form>
