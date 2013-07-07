<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="brand.edited" />
</h1>

<label><s:message code="brand.name" /> : </label> ${brand.name}
<br />
<br />
<h3><s:message code="brand.logo" /> : </h3>
<label><s:message code="image.filename" /> : </label> ${brand.logoImage.mediaFileName}
<br />
<br />
<label><s:message code="image.name" /> : </label> ${brand.logoImage.mediaName}
<br />
<br />
<label><s:message code="image.thumbnailFileName" /> : </label> ${brand.logoImage.mediaThumbnailFileName}
<br />
<br />
