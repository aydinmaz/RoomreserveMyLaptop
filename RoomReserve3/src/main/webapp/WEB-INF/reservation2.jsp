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
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
   

    
    
    <title>Resrveation</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
    <style >
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
						   <td style="background-color:green" id="${m.hour1}"  onclick="content1(this)" >${m.hour1 }</td>
						   </c:when>
						  <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						   </c:choose>

						   <c:choose>
						     	<c:when test="${m.hour2confirm==false}">
						       <td style="background-color:green" id="${m.hour2 }" onclick="content1(this)">${m.hour2 },${m.hour2confirm } </td>
						     </c:when>
						     <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						     </c:choose>
						      
						      <c:choose>
						     	<c:when test="${m.hour3confirm==false}">
						     	  <td style="background-color:green" id="${m.hour3 }" onclick="content1(this)">${m.hour3 },${m.hour3confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						    
						      <c:choose>
						     	<c:when test="${m.hour4confirm==false}">
						     	  <td style="background-color:green" id="${m.hour4 }" onclick="content1(this)">${m.hour4 },${m.hour4confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						     
						      <c:choose>
						     	<c:when test="${m.hour5confirm==false}">
						     	  <td style="background-color:green" id="${m.hour5 }" onclick="content1(this)">${m.hour5 },${m.hour5confirm } </td>
						     	</c:when>
						      <c:otherwise> <td style="background-color:red"> Reserved</td> </c:otherwise>
						      </c:choose>
						
					         
					    </tr>
					    </c:forEach>
			    </tbody>
		  </table>
<br>
</div>
<br>


</body> 
<script >

// $(function() {
//     var token = $("meta[name='_csrf']").attr("content");
//     var header = $("meta[name='_csrf_header']").attr("content");
//     $(document).ajaxSend(function(e, xhr, options) {
//         if (options.type == "POST") {
//             xhr.setRequestHeader(header, token);
//         }
//     });
// });

var idt;
function content1(elem)
   {
	$(function() {
	    var token = $("meta[name='_csrf']").attr("content");
	    var header = $("meta[name='_csrf_header']").attr("content");
	    $(document).ajaxSend(function(e, xhr, options) {
	        if (options.type == "POST") {
	            xhr.setRequestHeader(header, token);
	        }
	    });
	});
	
	
	     idt=elem.id;
	 		
// 	     $.ajax({
		    
// 			url:"reservationTest",
//             type: 'POST',
//             data:  idt,             
//             dataType: "text",          
//             contentType: "application/json",
// 		           // mimeType: false,
//             success: function(response){ 
//                 console.log("work!");                   
//             } 
//         	});
		
	 			$.ajax({
			    	method : 'GET',
			    	url : 'reservationTest?room_id='+idt,
			    			
			  	})
	  
	}

// 		 $.ajax({
			    
// 			 url:"/reservation2",
// 		            type: 'POST',
// 		            data:  idt,             
// 		            dataType: "text",          
// 		            contentType: "text/plain",
// 		           // mimeType: false,
// 		            success: function(response){ 
// 		                console.log(data);              
// 		                return false;     
// 		            } 
// 		        });
//
// 
// $.ajax(
// 		{

//          url:"reservation2",
//                 type: 'POST',
//                 data:  {"idt": idt},             
//                 dataType: "json",          
//                 contentType: "application/json",
//                 success: function(response){ 
//                     console.log(data);              
//                     return false;     
//                 } 
//             });

// 	 elem.style.backgroundColor = "red";
// 		//alert(elem.innerHTML);
// 		elem.innerHTML=elem.id+'-'+true;//deghat kon ke inja faghat zaher jadval avaz mishe vali list rooms2 avaz nemishe	
// 		alert(elem.id);
		//alert(getElementsById("Rooms2")[0].hour1confirm);
		//console.log(${rooms2[0].hour1confirm});
		//${rooms2[0].hour1confirm=true};
		//window.alert(${rooms2[0].hour1confirm});
// }

</script>
</html>