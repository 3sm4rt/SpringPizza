function order(){
	var map = new Map();
	
	var inputs = document.querySelectorAll('[data-product]');
	for(let input of inputs){
		map.set(input.dataset.product,input.value ? input.value : 0);
		
	}
	let xhr = new XMLHttpRequest();
	xhr.open ('POST', '/products/order');
	xhr.setRequestHeader ('Content-Type','application/json');
	xhr.onload = () =>{
		if(xhr.status === 200){
			alert(xhr.responseText);
		}
	}
	xhr.send(JSON.stringify(Object.fromEntries(map)))
}