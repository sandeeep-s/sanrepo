<%@include file="/views/init.jsp"%>
<label><s:message code="vehicle.model.year" /> : </label>
<select id="modelYear" name="modelYear" onchange="getModelsForYear()">
	<option value="-1">
		<s:message code="select" />
	</option>
	<c:forEach items="${modelYears}" var="modelYearVar">
		<option value="${modelYearVar}">${modelYearVar}</option>
	</c:forEach>
</select>
