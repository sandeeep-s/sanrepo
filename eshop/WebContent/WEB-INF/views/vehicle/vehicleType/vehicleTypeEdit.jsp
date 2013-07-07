<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.type.edit" />
</h1>
<sf:form action="/eshop/vehicletype/${vehicleType.id}" method="PUT" modelAttribute="vehicleType">
	<sf:input type="hidden" path="id" value="${vehicleType.id}" />
	<sf:input type="hidden" path="version" value="${vehicleType.version}" />
	<label><s:message code="vehicle.type.name" /> : </label>
	<sf:input type="text" path="name" value="${vehicleType.name}" />
	<br />
	<br />
	<h3><s:message code="vehicle.type.image" /> : </h3>
	<sf:input type="hidden" path="image.mediaType" value="${vehicleType.image.mediaType}"/>
	<br />
	<br />
	<label><s:message code="image.filename" /> : </label>
	<sf:input type="text" path="image.mediaFileName" value="${vehicleType.image.mediaFileName}" />
	<sf:errors path="image.mediaFileName" />
	<br />
	<br />
	<label><s:message code="image.name" /> : </label>
	<sf:input path="image.mediaName" value="${vehicleType.image.mediaName}"/>
	<sf:errors path="image.mediaName" />
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label>
	<sf:input path="image.mediaThumbnailFileName" value="${vehicleType.image.mediaThumbnailFileName}"/>
	<sf:errors path="image.mediaThumbnailFileName" />
	<br />
	<br />
	<input type="submit" value="<s:message code='vehicle.type.edit'/>">
</sf:form>
