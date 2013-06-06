<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category" />
</h1>

<label><s:message code="category.name" /> : </label> ${category.name}
<br />
<br />
<label><s:message code="category.description" /> : </label> ${category.description}
<br />
<br />
<h3><s:message code="category.image" /> : </h3>
<label><s:message code="image.filename" /> : </label> ${category.image.mediaFileName}
<br />
<br />
<label><s:message code="image.name" /> : </label> ${category.image.mediaName}
<br />
<br />
<label><s:message code="image.thumbnailFileName" /> : </label> ${category.image.mediaThumbnailFileName}
<br />
<br />
