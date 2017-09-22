/**
 * app.js
 */

window.onload = function() {
	console.log('Html Loaded with this app.js file')
	loadNavBar();
	loadUser();
}

function loadNavBar() {
	// make an ajax request to load the navbar html
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Loading navbar code');
			document.getElementById('navbar').innerHTML = xhr.responseText;
			document.getElementById('aboutMe').addEventListener('click', loadAboutMe, false);
			
			if(document.getElementById('reimbursements')){
				document.getElementById('reimbursements').addEventListener('click', loadReimbursementsPage, false);
			}
			
			if(document.getElementById('viewAllEmployees')){
				document.getElementById('viewAllEmployees').addEventListener('click', loadAllEmployeesPage, false);
			}
			
			
			if(document.getElementById('seeReimbursements')){
				document.getElementById('seeReimbursements').addEventListener('click', loadAllReimbursementsPage, false);
			}
			if(document.getElementById('managerViewReimbursements')){
				document.getElementById('managerViewReimbursements').addEventListener('click', loadManagerViewReimbursementsPage, false);
			}
			if(document.getElementById('approveOrDenyReimbursements')){
				document.getElementById('approveOrDenyReimbursements').addEventListener('click', loadapproveOrDenyReimbursementsPage, false);
			}
		}
	}
	xhr.open('GET', 'getNavBar', true); // true: asynchronize
	xhr.send();

}

function loadapproveOrDenyReimbursementsPage(){
	var xhr = new XMLHttpRequest();
	console.log('loadapproveOrDenyReimbursementsPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading loadapproveOrDenyReimbursementsPage');
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('recButton').style.display = 'none';
			document.getElementById('recButton').addEventListener('click', closeReceipt, false);
			approveOrDenyReimbursementsData();
		}
	}
	xhr.open('GET', 'getLoadapproveOrDenyReimbursementsPage', true);
	xhr.send();
}

function approveOrDenyReimbursementsData(){
	var xhr = new XMLHttpRequest();
	console.log('approveOrDenyReimbursementsData() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading only pending requests for manager table');
			var data = JSON.parse(xhr.responseText);
			document.getElementById('numberOfSelectsDiv').innerHTML = '<input type="text" name="numberOfSelects" value="' + data.length + '">';
			for(var i = 0; i < data.length; i++){
				var table = document.getElementById("approveOrDenyRembursementsTable");
			    var row = table.insertRow(i+1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    var cell5 = row.insertCell(4);
			    var cell6 = row.insertCell(5);
			    var cell7 = row.insertCell(6);
			    var cell8 = row.insertCell(7);
			    
			    cell1.innerHTML = data[i].reimbursementId;
			    cell2.innerHTML = data[i].author;
			    cell3.innerHTML = data[i].type;
			    cell4.innerHTML = data[i].timeSubmitted;
			    cell5.innerHTML = data[i].description;
			    cell6.innerHTML = data[i].amount;
			    
			    //only add the image link if it exists

		    	cell7.innerHTML = '<a id=sr' + data[i].reimbursementId + '>Click here for receipt</a>';
		    	document.getElementById('sr' + data[i].reimbursementId).addEventListener('click', showReceipt, false);

			    
			    
			    cell8.innerHTML = '<select name="' + i + '"><option value="3' + data[i].reimbursementId + '">Select One</option><option value="1' + data[i].reimbursementId + '">approve</option><option value="2' + data[i].reimbursementId + '">deny</option></select>';
				

			}
		}
		
	}
	xhr.open('GET', 'getApproveOrDenyReimbursementsData', true);
	xhr.send();
}

function showReceipt(){
	var xhr = new XMLHttpRequest();
	console.log('showReceipt() invoked');
	console.log('id of rembursement: ' + this.id.substr(2))
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading receipt');
			var response = JSON.parse(xhr.responseText);
			
			if(response.receiptData == null){
				window.alert('No receipt exists')
			}else{
				var img = new Image();
				img.src = 'data:image/png;base64,' + response.receiptData;
				
				// show the image
				document.getElementById('recImage').innerHTML = "";
				document.getElementById('recImage').appendChild(img);
				document.getElementById('recButton').style.display = 'block';
			}
		}
	}
	xhr.open('GET', 'getReceipt?id=' + this.id.substr(2), true);
	xhr.send();
	}

function closeReceipt(){
	document.getElementById('recImage').innerHTML = "";
	document.getElementById('recButton').style.display = 'none';
}


function loadManagerViewReimbursementsPage(){
	var xhr = new XMLHttpRequest();
	console.log('loadViewReimbursementsPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading loadViewReimbursementsPage');
			document.getElementById('view').innerHTML = xhr.responseText;
			if(document.getElementById('searchRequests')){
				document.getElementById('searchRequests').addEventListener('keyup', getManagerViewReimbursementsData, false);
				console.log('added eventListener for searchRequests')
			}
			getManagerViewReimbursementsData();
		}
	}
	xhr.open('GET', 'getManagerViewReimbursementsPage', true);
	xhr.send();
	
}

function getManagerViewReimbursementsData(){
	var xhr = new XMLHttpRequest();
	console.log('getManagerViewReimbursementsData()() invoked');
	var searchText = document.getElementById('searchRequests').value.toLowerCase();
	console.log(searchText);
	
	var table = document.getElementById("managerViewRembursementsTable");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading all employee reimbursements for manager to table');
			var data = JSON.parse(xhr.responseText);
			
			while(table.rows.length > 1){
				table.deleteRow(1);
			}
			
			var rowIndex = 1;
			for(var i = 0; i < data.length; i++){
				
				if( String(data[i].reimbursementId).includes(searchText) || 
						data[i].status.toLowerCase().includes( searchText ) || 
						data[i].resolver.toLowerCase().includes( searchText ) || 
						data[i].author.toLowerCase().includes( searchText ) || 
						data[i].type.toLowerCase().includes( searchText ) || 
						data[i].resolved.includes( searchText ) || 
						data[i].timeSubmitted.includes( searchText ) || 
						data[i].description.toLowerCase().includes( searchText ) || 
						String(data[i].amount).includes(searchText) || 
						searchText == ""){
//					var table = document.getElementById("managerViewRembursementsTable");
				    var row = table.insertRow(rowIndex);
				    var cell1 = row.insertCell(0);
				    var cell2 = row.insertCell(1);
				    var cell3 = row.insertCell(2);
				    var cell4 = row.insertCell(3);
				    var cell5 = row.insertCell(4);
				    var cell6 = row.insertCell(5);
				    var cell7 = row.insertCell(6);
				    var cell8 = row.insertCell(7);
				    var cell9 = row.insertCell(8);
				    
				    cell1.innerHTML = data[i].reimbursementId;
				    cell2.innerHTML = data[i].author;
				    cell3.innerHTML = data[i].type;
				    cell4.innerHTML = data[i].status;
				    cell5.innerHTML = data[i].resolver;
				    cell6.innerHTML = data[i].resolved;
				    cell7.innerHTML = data[i].timeSubmitted;
				    cell8.innerHTML = data[i].description;
				    cell9.innerHTML = data[i].amount;
				    
				    rowIndex++;
				}
			}
		}
		
	}
	xhr.open('GET', 'getManagerViewReimbursementsData', true);
	xhr.send();
	
	function loadRequestsBySearch(){
	console.log('Loading search results');
	var searchText = document.getElementById('searchRequests').value;
	for(var i = 0; i < data.length; i++){
		
		if( data.includes( searchText )){
			var table = document.getElementById("rembursementsTable");
		    var row = table.insertRow(i+1);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    var cell4 = row.insertCell(3);
		    var cell5 = row.insertCell(4);
		    var cell6 = row.insertCell(5);
		    cell1.innerHTML = data[i].reimbursementId;
		    cell2.innerHTML = data[i].type;
		    cell3.innerHTML = data[i].status;
		    cell4.innerHTML = data[i].resolver;
		    cell5.innerHTML = data[i].timeSubmitted;
		    cell6.innerHTML = data[i].description;
		}
	}
}
}

function loadRequestsBySearch(){
	console.log('Loading search results');
	var searchText = document.getElementById('searchRequests').value;
	for(var i = 0; i < data.length; i++){
		
		if( data.includes( searchText )){
			var table = document.getElementById("managerViewRembursementsTable - search");
		    var row = table.insertRow(i+1);
		    var cell1 = row.insertCell(0);
		    var cell2 = row.insertCell(1);
		    var cell3 = row.insertCell(2);
		    var cell4 = row.insertCell(3);
		    var cell5 = row.insertCell(4);
		    var cell6 = row.insertCell(5);
		    var cell7 = row.insertCell(6);
		    var cell8 = row.insertCell(7);
		    var cell9 = row.insertCell(8);
		    
		    cell1.innerHTML = data[i].reimbursementId;
		    cell2.innerHTML = data[i].author;
		    cell3.innerHTML = data[i].type;
		    cell4.innerHTML = data[i].status;
		    cell5.innerHTML = data[i].resolver;
		    cell6.innerHTML = data[i].resolved;
		    cell7.innerHTML = data[i].timeSubmitted;
		    cell8.innerHTML = data[i].description;
		    cell9.innerHTML = data[i].amount;
		}
	}
}

function loadAllEmployees(){
	var xhr = new XMLHttpRequest();
	console.log('loadAllEmployees() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading all employees to table');
			var data = JSON.parse(xhr.responseText);
			for(var i = 0; i < data.length; i++){
				var table = document.getElementById("allEmployeesTable");
			    var row = table.insertRow(i+1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    
			    cell1.innerHTML = data[i].userId;
			    cell2.innerHTML = data[i].email;
			    cell3.innerHTML = data[i].firstName;
			    cell4.innerHTML = data[i].lastName;
			}
		}
		
	}
	xhr.open('GET', 'getAllEmployeesData', true);
	xhr.send();
}

function loadAllEmployeesPage(){
	var xhr = new XMLHttpRequest();
	console.log('loadAllEmployeesPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading allEmployeesPage');
			document.getElementById('view').innerHTML = xhr.responseText;
			loadAllEmployees();
		}
	}
	
	xhr.open('GET', 'getAllEmployeesPage', true);
	xhr.send();
}

function loadAllReimbursementsPage(){
	var xhr = new XMLHttpRequest();
	console.log('loadAllReimbursementsPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading allReimbursementsPage');
			document.getElementById('view').innerHTML = xhr.responseText;
			loadReimbursements();
		}
	}
	
	xhr.open('GET', 'getAllReimbursementsPage', true);
	xhr.send();
}

function loadReimbursements(){
	var xhr = new XMLHttpRequest();
	console.log('loadAllReimbursementsPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading allReimbursementsPage');
			var data = JSON.parse(xhr.responseText);
			for(var i = 0; i < data.length; i++){
				var table = document.getElementById("rembursementsTable");
			    var row = table.insertRow(i+1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    var cell5 = row.insertCell(4);
			    var cell6 = row.insertCell(5);
			    cell1.innerHTML = data[i].reimbursementId;
			    cell2.innerHTML = data[i].type;
			    cell3.innerHTML = data[i].status;
			    cell4.innerHTML = data[i].resolver;
			    cell5.innerHTML = data[i].timeSubmitted;
			    cell6.innerHTML = data[i].description;
			}
		}
	}
	
	xhr.open('GET', 'getAllReimbursements', true);
	xhr.send();
}

function loadRequestsBySearch(){
//	function loadRequestsBySearch(){
//	console.log('Loading search results');
//	var searchText = document.getElementById('searchRequests').value;
//	for(var i = 0; i < data.length; i++){
//		
//		if( data.includes( searchText )){
//			var table = document.getElementById("rembursementsTable");
//		    var row = table.insertRow(i+1);
//		    var cell1 = row.insertCell(0);
//		    var cell2 = row.insertCell(1);
//		    var cell3 = row.insertCell(2);
//		    var cell4 = row.insertCell(3);
//		    var cell5 = row.insertCell(4);
//		    var cell6 = row.insertCell(5);
//		    cell1.innerHTML = data[i].reimbursementId;
//		    cell2.innerHTML = data[i].type;
//		    cell3.innerHTML = data[i].status;
//		    cell4.innerHTML = data[i].resolver;
//		    cell5.innerHTML = data[i].timeSubmitted;
//		    cell6.innerHTML = data[i].description;
//		}
//	}
//}
}

function loadReimbursementsPage(){
	var xhr = new XMLHttpRequest();
	console.log('loadReimbursementsPage() invoked');
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading reimbursementsPage');
			document.getElementById('view').innerHTML = xhr.responseText;
			//document.getElementById('submitRequest').addEventListener('click', submitRequest, false);
		}
	}
	
	xhr.open('GET', 'getReimbursementPage', true);
	xhr.send();
}

function submitRequest(){
	var xhr = new XMLHttpRequest();
	console.log('submitRequest() invoked');
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Submitting request');
			
		}
	}
	xhr.open('GET', 'submitReimbursementRequest', true);
	xhr.send();
}

function loadUser() {
	var xhr = new XMLHttpRequest();
	console.log('loadUser() invoked');
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Loading user home page');
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	xhr.open('GET', 'getUser', true);
	xhr.send();

}

function addedListeners(){
	var aboutMe = document.getElementById('id="aboutMe"');
								
							//1st Argument = type of event as a STRING
							//2nd Argument = the Function that will be invoked upon the event triggering
							//3rd Argument = true/false for useCapture
	var useCapture = false;
	aboutMe.addEventListener('click', loadAboutMe, useCapture);
}

function loadAboutMe(){
	var xhr = new XMLHttpRequest();
	console.log('loadAboutMe() invoked');
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Loading user aboutMe Page');
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('updateInfo').addEventListener('click', loadChangeInfoPage, false);
			loadUserInformation();
		}
	}
	xhr.open('GET', 'getAboutMe', true);
	xhr.send();
}

function loadChangeInfoPage(){
	var xhr = new XMLHttpRequest();
		
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('Loading user aboutMe Page');
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('emailCheckBox').addEventListener('click', loadDefaultInfoPage, false);
			document.getElementById('passwordCheckBox').addEventListener('click', loadDefaultInfoPage, false);
			document.getElementById('firstNameCheckBox').addEventListener('click', loadDefaultInfoPage, false);
			document.getElementById('lastNameCheckBox').addEventListener('click', loadDefaultInfoPage, false);
			loadDefaultInfoPage();
		}
	}
	xhr.open('GET', 'getChangeInfoPage', true);
	xhr.send();
}

function loadDefaultInfoPage(){
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('Loading user information to aboutMe page');
			var data = JSON.parse(xhr.responseText);
			
			if(document.getElementById('emailCheckBox').checked){
				document.getElementById('emailUpdate').value = data.email;
				document.getElementById('emailUpdate').readOnly = true;
			}else{
				document.getElementById('emailUpdate').readOnly = false;
				document.getElementById('emailUpdate').value = "";
			}
			
			if(document.getElementById('passwordCheckBox').checked){
				document.getElementById('passwordUpdate').value = data.password;
				document.getElementById('passwordUpdate').readOnly = true;
			}else{
				document.getElementById('passwordUpdate').readOnly = false;
				document.getElementById('passwordUpdate').value = "";
			}
			
			if(document.getElementById('firstNameCheckBox').checked){
				document.getElementById('firstNameUpdate').value = data.firstName;
				document.getElementById('firstNameUpdate').readOnly = true;

			}else{
				document.getElementById('firstNameUpdate').readOnly = false;
				document.getElementById('firstNameUpdate').value = "";
			}
			
			if(document.getElementById('lastNameCheckBox').checked){
				document.getElementById('lastNameUpdate').value = data.lastName;
				document.getElementById('lastNameUpdate').readOnly = true;

			}else{
				document.getElementById('lastNameUpdate').readOnly = false;
				document.getElementById('lastNameUpdate').value = "";
			}
			
		}
	}
	
	xhr.open('GET', 'getUserInfo', true);
	xhr.send();
}

function loadUserInformation(){
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('Loading user information to aboutMe page');
			var data = JSON.parse(xhr.responseText);
			document.getElementById('email').innerHTML = data.email;
			document.getElementById('password').innerHTML = data.password;
			document.getElementById('firstName').innerHTML = data.firstName;
			document.getElementById('lastName').innerHTML = data.lastName;
		}
	}
	
	xhr.open('GET', 'getUserInfo', true);
	xhr.send();
}
