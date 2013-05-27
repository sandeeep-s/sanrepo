<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="vehicle.submodel.add" />
</h1>
<sf:form action="/eshop/vehiclesubmodel" method="POST" modelAttribute="vehicleSubModel">
	<div id="vehicleMakeDiv">
		<label><s:message code="vehicle.make" /> : </label>
		<select id="vehicleMakeId" name="vehicleMakeId" onchange="getModelYearsForMake()">
			<option value="-1">
				<s:message code="select" />
			</option>
			<c:forEach items="${vehicleMakes}" var="vehicleMake">
				<option value="${vehicleMake.id}">${vehicleMake.name}</option>
			</c:forEach>
		</select>
		<br/>
		<br/>
	</div>
	<div id="vehicleYearDiv">
	</div>
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