<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="pattern.add" />
</h1>
<sf:form action="/eshop/pattern" method="POST" modelAttribute="pattern">
	<label><s:message code="brand" /> : </label>
	<sf:select path="brand">
		<sf:option value="-1">
			<s:message code="select" />
		</sf:option>
		<c:forEach items="${requestScope.brands}" var="brandVar">
			<sf:option value="${brandVar.id}">${brandVar.name}</sf:option>
		</c:forEach>
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
			<s:bind path="images[${status.index}].mediaType">
					<sf:input type="hidden" path="${status.expression}" value="<%=MediaType.IMAGE%>"/>
	 		</s:bind>
			<label><s:message code="image.filename" /> : </label>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.name" /> : </label>
			<s:bind path="images[${status.index}].mediaName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
			<label><s:message code="image.thumbnailFileName" /> : </label>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:input path="${status.expression}"/>
	 		</s:bind>
			<s:bind path="images[${status.index}].mediaThumbnailFileName">
					<sf:errors path="${status.expression}"/>
	 		</s:bind>
			<br />
			<br />
		</c:forEach>	
	<input type="submit" value="<s:message code='pattern.add'/>">
</sf:form>
