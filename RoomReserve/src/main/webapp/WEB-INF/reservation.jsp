<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Resrveation</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">   -->
    <!--   <link href="${contextPath}/resources/css/common.css" rel="stylesheet">          -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  

    <style type="text/css">
    
    
    td{
      /* width:auto; */
      vertical-align:middle;
    
      color: black;
      border: 2px solid black;
      
     /*   #idtr{
    background: red;
    } */
      </style>
      
    
</head>

<body>

<div class="container" align="center">

	    <form:form id = "roomTableForm" method="POST" action="${contextPath}/reservation">
	      
		  <input type="hidden" value="eccomi" id="room_id" name="room_id" />
		  <input type="hidden" value="eccomi" id="hour_id" name="hour_id" />
		  
<%-- 	     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
	    
	         <table  class="table table-bordered" >
			 <thead>
			    <tr>
				  <th>\Days \Hours</th>  <th>8 - 10</th>   
				  <th >10 - 12</th> <th >12 - 14</th> 
				  <th >14 - 16</th> <th >16 - 18</th> 
			    </tr>
			 </thead>
			    <tbody>
		
			   	
						<c:forEach items= "${rooms2}" var="m" >
						<tr>
							 <td style="background-color:OldLace">${m.day }</td>
						     <c:choose>
						     	<c:when test="${m.hour1confirm==false}">
						     	  <td style="background-color:green" id="id1Hour" onclick="content(${m.id},1)">free </td>
						     	</c:when>
						     <c:otherwise> <td style="background-color:red" id="id2Hour" onclick="content(${m.id},1)"> Reserved</td> </c:otherwise>
						     </c:choose>
						     
						      <c:choose>
						     	<c:when test="${m.hour2confirm==false}">
						     	  <td style="background-color:green" id="id1Hour" onclick="content(${m.id},2)">free </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red" id="id2Hour" onclick="content(${m.id},2)"> Reserved</td> </c:otherwise>
						      </c:choose>
						      
						      <c:choose>
						     	<c:when test="${m.hour3confirm==false}">
						     	  <td style="background-color:green" id="id1Hour" onclick="content(${m.id},3)">free </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red" id="id2Hour" onclick="content(${m.id},3)"> Reserved</td> </c:otherwise>
						      </c:choose>
						    
						      <c:choose>
						     	<c:when test="${m.hour4confirm==false}">
						     	  <td style="background-color:green" id="id1Hour" onclick="content(${m.id},4)">free </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red" id="id3Hour" onclick="content(${m.id},4)"> Reserved</td> </c:otherwise>
						      </c:choose>
						     
						      <c:choose>
						     	<c:when test="${m.hour5confirm==false}">
						     	  <td style="background-color:green" id="id1Hour" onclick="content(${m.id},5)">free </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red" id="id4Hour" onclick="content(${m.id},5)"> Reserved</td> </c:otherwise>
						      </c:choose>
						
					         
					    </tr>
					    </c:forEach>
			    </tbody>
		  </table>
		
    
<!-- 			 <button type="button" onclick="sendRoomID()">Invia</button> -->
	    </form:form>
		<h2> <a href="welcome">finished</a></h2>
		<button onclick="location.href='welcome'" type="button">Finish</button>
		<a href="welcome"> <button>Click me</button> </a>


</div>
<br>

  
<%-- document.getElementById("demo").innerHTML = "${rooms2[2]}".split(",")[2]; --%>


  <!-- /container -->
 <!--  in 2 tA SATR Paiini ro khodam ezafe kardam -->

<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  -->
<!--  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>   -->
</body> 

<script >

// printing in consol
/* $(document).ready(function() 
	{
	var rooms = "${rooms2}";
	<c:forEach items="${rooms2}" var="room">
		console.log("${room.getId()}"+" - "+"${room.getDay()}"+"-"+"${room.getHour1()}");
    </c:forEach> 
	 }); */
	 
//var idList="";

function content(id,hour)
{ 
 	 //elem.style.backgroundColor = "red";
// 		alert(elem.innerHTML);
// 		elem.innerHTML=elem.id+'-'+true;//deghat kon ke inja faghat zaher jadval avaz mishe vali list rooms2 avaz nemishe
	
// 		alert(elem.id);
		//alert(getElementsById("Rooms2")[0].hour1confirm);
	console.log(id);
	console.log(hour);
	document.getElementById("room_id").value = id;
	document.getElementById("hour_id").value = hour;
	document.forms["roomTableForm"].submit();
	//idList =idList+","+elem.id;
}			
	
function sendRoomID(){
	$('.roomID').each(function(index, value) {
	        //this.value = idList;
	        this.value = elem.room_id;
	    	});	 

		document.forms["roomTableForm"].submit();
}

/* $( "${rooms2}" ).each(function( index ) {
	  console.log( index + ": " + $( this ).text() );
	});	 */	

</script>
</html>