<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="../init.jsp"%>

<h1 align="center">
	<s:message code="pattern.add" />
</h1>
<sf:form action="/eshop/pattern" method="POST" modelAttribute="pattern">
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<sf:options items="${brands}" itemLabel="name" itemValue="id"/>
	</sf:select>
	<sf:errors path="brand" />
	<br />
	<br />
	<label><s:message code="pattern.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="pattern.description" /> : </label>
	<sf:textarea type="text" path="description"/>
	<sf:errors path="description" />
	<br />
	<br />
	<label><s:message code="pattern.warranty" /> : </label>
	<sf:textarea type="text" path="warranty"/>
	<sf:errors path="warranty" />
	<br />
	<br />
	<label><s:message code="pattern.important.notes" /> : </label>
	<sf:textarea type="text" path="importantNotes"/>
	<sf:errors path="importantNotes" />
	<br />
	<br />
	<h3><s:message code="pattern.image" /> : </h3>
	<c:forEach items="${pattern.images}" var="image" varStatus="status">
		<s:message code="pattern.image" /> ${status.count} :<br/>
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
	<input type="submit" value="<s:message code='pattern.add'/>">
</sf:form>
