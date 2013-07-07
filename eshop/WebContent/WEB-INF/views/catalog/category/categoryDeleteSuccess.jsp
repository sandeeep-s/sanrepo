<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="category.deleted" />
</h1>

<label><s:message code="category.name" /> : </label> ${category.name}
<br />
<br />
<label><s:message code="category.description" /> : </label> ${category.description}
<br />
<br />
<h3><s:message code="category.image" /> : </h3>
<label><s:message code="image.filename" /> : </label> ${category.mediaFileName}
<br />
<br />
<label><s:message code="image.name" /> : </label> ${category.mediaName}
<br />
<br />
<label><s:message code="image.thumbnailFileName" /> : </label> ${category.mediaThumbnailFileName}
<br />
<br />
