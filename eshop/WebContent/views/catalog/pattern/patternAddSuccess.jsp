<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="pattern.added" />
</h1>
<label><s:message code="brand" /> : </label> ${pattern.brand.name}
<br />
<br />
<label><s:message code="pattern.name" /> : </label> ${pattern.name}
<br />
<br />
<label><s:message code="pattern.description" /> : </label> ${pattern.description}
<br />
<br />
<label><s:message code="pattern.warranty" /> : </label> ${pattern.warranty}
<br />
<br />
<label><s:message code="pattern.important.notes" /> : </label> ${pattern.importantNotes}
<br />
<br />
<c:forEach items="${pattern.images}" var="image" varStatus="status">
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
