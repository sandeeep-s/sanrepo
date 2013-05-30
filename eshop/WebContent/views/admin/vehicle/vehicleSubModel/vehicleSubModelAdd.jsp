<%@page import="com.eshop.common.model.MediaType"%>
<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.submodel.add" />
</h1>
<sf:form action="/eshop/vehiclesubmodel" method="POST" modelAttribute="vehicleSubModel">

	<div id="vehicleMakeDiv">
		<%@include file="/views/admin/vehicle/vehicleMakesFragment.jsp"%>
	</div>
	<br/>
	<br/>

	<div id="vehicleYearDiv">
	</div>
	<br/>
	<br/>

	<div id="vehicleModelDiv">
	</div>
	<sf:errors path="vehicleModel" />
	<br />
	<br />

	<label><s:message code="vehicle.submodel.name" /> : </label>
	<sf:input type="text" path="name"/>
	<sf:errors path="name" />
	<br />
	<br />

	<h3><s:message code="vehicle.submodel.image" /> : </h3>
	<c:forEach items="${vehicleSubModel.images}" var="image" varStatus="status">
		<s:message code="vehicle.model.image" /> ${status.count} :<br/>
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

	<input type="submit" value="<s:message code='vehicle.submodel.add'/>">
</sf:form>
<script>
function getModelYearsForMake(){
	var vehicleMakeId = $("#vehicleMakeId").val();
	$.ajax({
		type : "GET",
		url : "/eshop/vehiclemake/"+vehicleMakeId+"/modelyears",
		error : function (){
			alert("Error");
		},
		success : function(responseItems){
			$("#vehicleYearDiv").html(responseItems);
		}
	});
}

function getModelsForYear(){
	var vehicleMakeId = $("#vehicleMakeId").val();
	var modelYear = $("#modelYear").val();
	$.ajax({
		type : "GET",
		url : "/eshop/vehiclemodel/vehiclemake/"+vehicleMakeId+"/modelyear/"+modelYear,
		error : function (){
			alert("error");
		},
		success : function(responseItems){
			$("#vehicleModelDiv").html(responseItems);
		}
	});
}
</script>