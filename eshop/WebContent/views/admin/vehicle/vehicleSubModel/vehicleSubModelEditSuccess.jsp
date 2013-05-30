<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.submodel.edited" />
</h1>
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
<br />
<br />
<label><s:message code="vehicle.model.year" /> : </label>
${vehicleSubModel.vehicleModel.modelYear}
<br />
<br />
<label><s:message code="vehicle.model" /> : </label>
${vehicleSubModel.vehicleModel.name}
<br />
<br />
<label><s:message code="vehicle.model.name" /> : </label>
${vehicleSubModel.name}
<br />
<br />

<h3><s:message code="vehicle.submodel.image" /> : </h3>
<c:forEach items="${vehicleSubModel.images}" var="image" varStatus="status">
	<s:message code="vehicle.submodel.image" /> ${status.count} :<br/>
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
