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
	      
		  <input type="hidden" class="roomID" name="room_id" />
		  
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
						     	  <td style="background-color:green" id="${m.hour1 }" onclick="content(this)">${m.hour1},${m.hour1confirm } </td>
						     	</c:when>
						     <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						     </c:choose>
						     
						      <c:choose>
						     	<c:when test="${m.hour2confirm==false}">
						     	  <td style="background-color:green" id="${m.hour2 }" onclick="content(this)">${m.hour2 },${m.hour2confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						      
						      <c:choose>
						     	<c:when test="${m.hour3confirm==false}">
						     	  <td style="background-color:green" id="${m.hour3 }" onclick="content(this)">${m.hour3 },${m.hour3confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						    
						      <c:choose>
						     	<c:when test="${m.hour4confirm==false}">
						     	  <td style="background-color:green" id="${m.hour4 }" onclick="content(this)">${m.hour4 },${m.hour4confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						     
						      <c:choose>
						     	<c:when test="${m.hour5confirm==false}">
						     	  <td style="background-color:green" id="${m.hour5 }" onclick="content(this)">${m.hour5 },${m.hour5confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						
					         
					    </tr>
					    </c:forEach>
			    </tbody>
		  </table>
		
    
			<button type="button" onclick="sendRoomID()">Invia</button>
	    </form:form>
		


</div>
<br>

  
<%-- document.getElementById("demo").innerHTML = "${rooms2[2]}".split(",")[2]; --%>


  <!-- /container -->
 <!--  in 2 tA SATR Paiini ro khodam ezafe kardam -->

<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  -->
<!--  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>   -->
</body> 

<script >

var idList="";

function content(elem)
{
 	 elem.style.backgroundColor = "red";
// 		alert(elem.innerHTML);
// 		elem.innerHTML=elem.id+'-'+true;//deghat kon ke inja faghat zaher jadval avaz mishe vali list rooms2 avaz nemishe
		
// 		alert(elem.id);
		//alert(getElementsById("Rooms2")[0].hour1confirm);
	 idList =idList+","+elem.id;
}			
	
function sendRoomID(){
	$('.roomID').each(function(index, value) {
	        this.value = idList;
	    	});	 

		document.forms["roomTableForm"].submit();
}

		
// 	   if (elem.style.backgroundColor == "green";)
// 		     {
// 			 // console.log(${rooms2});
// 			    elem.style.backgroundColor = "red";
// 				alert(elem.innerHTML);
// 				alert(elem.id);
// 				//alert(getElementsById("Rooms2")[0].hour1confirm);
// 				alert(${rooms2[0].hour1confirm});
// 				console.log(${rooms2[0].hour1confirm});
// 				${rooms2[0].hour1confirm=true};
// 				window.alert(${rooms2[0].hour1confirm});
// 		     }
// 		else 
// 			{
// 				elem.style.backgroundColor = "green";
// 				alert(elem.innerHTML);
// 				alert(elem.id);
// 				//alert(getElementsById("Rooms2")[0].hour1confirm);
// 				alert(${rooms2[0].hour1confirm});
// 				console.log(${rooms2[0].hour1confirm});
// 				${rooms2[0].hour1confirm=true};
// 				window.alert(${rooms2[0].hour1confirm});
// 			}	

	
	
	//elem.innerHTML = "Reserved";
	//alert(elem.innerHTML);
	//alert(elem);
	
// 	var person = {"id":"elem.id"};
// 		   $.ajax({
//            url:"/reservation",
//            type: 'POST',
//            data:  person,             
//            dataType: "html",          
//            contentType: 'application/json',
//            mimeType: 'application/json',
//            success: function(data)
//            	{ 
//                console.log(data);              
//                return false;     
//             } 
//        			});
		   
	//rooms2[0,1]=true;
	//console.log(rooms2);
	/* var p = document.getElementById("para");
	p.innerHTML ='you clicked on cell' + '' + elem.innerText;
	rooms2.(hour+"id"+confirm)= true;
	alert(rooms2); */
// 	alert("reserved");
	//}

</script>
</html>