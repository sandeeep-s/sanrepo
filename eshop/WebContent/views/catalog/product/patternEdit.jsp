<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="pattern.edit" />
</h1>
<sf:form action="/eshop/pattern/${pattern.id}" method="PUT" modelAttribute="pattern">
	<sf:input type="hidden" path="id" value="${pattern.id}" />
	<sf:input type="hidden" path="version" value="${pattern.version}" />
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<c:forEach items="${brands}" var="brandVar">
			<c:if test="${pattern.brand.id == brandVar.id}">
				<sf:option value="${brandVar.id}" selected="true">${brandVar.name}</sf:option>
			</c:if>
			<c:if test="${pattern.brand.id != brandVar.id}">
				<sf:option value="${brandVar.id}">${brandVar.name}</sf:option>
			</c:if>
		</c:forEach>
	</sf:select>
	<sf:errors path="brand" />
	<br />
	<br />
	<label><s:message code="pattern.name" /> : </label>
	<sf:input type="text" path="name" value="${pattern.name}"/>
	<sf:errors path="name" />
	<br />
	<br />
	<label><s:message code="pattern.description" /> : </label>
	<sf:textarea type="text" path="description" value="${pattern.description}"/>
	<sf:errors path="description" />
	<br />
	<br />
	<label><s:message code="pattern.warranty" /> : </label>
	<sf:textarea type="text" path="warranty" value="${pattern.warranty}"/>
	<sf:errors path="warranty" />
	<br />
	<br />
	<label><s:message code="pattern.important.notes" /> : </label>
	<sf:textarea type="text" path="importantNotes" value="${pattern.importantNotes}"/>
	<sf:errors path="importantNotes" />
	<br />
	<br />
	<h3><s:message code="pattern.image" /> : </h3>
		<c:forEach items="${pattern.images}" var="image" varStatus="status">
			<s:bind path="images[${status.index}].mediaType">
					<sf:input type="hidden" path="${status.expression}" value="<%=MediaType.IMAGE%>"/>
	 		</s:bind>
			<label><s:message code="image.filename" /> : </label>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:input path="${status.expression}" value="${image.mediaFileName}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.name" /> : </label>
			<s:bind path="images[${status.index}].mediaName">
					<sf:input path="${status.expression}" value="${image.mediaName}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.thumbnailFileName" /> : </label>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:input path="${status.expression}" value="${image.mediaThumbnailFileName}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
		</c:forEach>	
	<input type="submit" value="<s:message code='pattern.edit'/>">
</sf:form>
