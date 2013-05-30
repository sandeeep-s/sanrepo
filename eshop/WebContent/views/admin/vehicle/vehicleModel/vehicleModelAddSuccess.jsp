<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.model.added" />
</h1>

<label><s:message code="vehicle.make" /> : </label> ${vehicleModel.vehicleMake.name}
<br />
<br />
<label><s:message code="vehicle.type" /> : </label> ${vehicleModel.vehicleType.name}
<br />
<br />
<label><s:message code="vehicle.model.name" /> : </label> ${vehicleModel.name}
<br />
<br />
<label><s:message code="vehicle.model.year" /> : </label> ${vehicleModel.modelYear}
<br />
<br />
<h3><s:message code="vehicle.model.image" /> : </h3>
<c:forEach items="${vehicleModel.images}" var="image" varStatus="status">
	<s:message code="vehicle.model.image" /> ${status.count} :<br/>
	<label><s:message code="image.filename" /> : </label> ${image.mediaFileName}
	<br />
	<br />
	<label><s:message code="image.name" /> : </label> ${image.mediaName}
	<br />
	<br />
	<label><s:message code="image.thumbnailFileName" /> : </label> ${image.mediaThumbnailFileName}
	<br />
	<br />
</c:forEach>
