<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make" />
</h1>

<label><s:message code="vehicle.make.name" /> : </label> ${vehicleMake.name}
<br />
<br />
<h3><s:message code="vehicle.make.logo" /> : </h3>
<label><s:message code="image.filename" /> : </label> ${vehicleMake.logoImage.mediaFileName}
<br />
<br />
<label><s:message code="image.name" /> : </label> ${vehicleMake.logoImage.mediaName}
<br />
<br />
<label><s:message code="image.thumbnailFileName" /> : </label> ${vehicleMake.logoImage.mediaThumbnailFileName}
