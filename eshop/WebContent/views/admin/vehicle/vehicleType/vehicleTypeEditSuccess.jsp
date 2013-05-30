<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.type.edited" />
</h1>

<label><s:message code="vehicle.type.name" /> : </label> ${vehicleType.name}
<br />
<br />
<h3><s:message code="vehicle.type.image" /> : </h3>
<label><s:message code="image.filename" /> : </label> ${vehicleType.image.mediaFileName}
<br />
<br />
<label><s:message code="image.name" /> : </label> ${vehicleType.image.mediaName}
<br />
<br />
<label><s:message code="image.thumbnailFileName" /> : </label> ${vehicleType.image.mediaThumbnailFileName}
