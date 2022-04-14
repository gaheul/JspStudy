const profileInputs = document.querySelectorAll('.profile-input');
const updateSubmitBtn = document.querySelector('.update-submit-btn');
const passwordUpdateBtn = document.querySelector('.password-update-btn');


const originPrincipal = {
	"name" : profileInputs[0].value,
	"email" : profileInputs[1].value
};
function isEmpty(str) {
	return str =="" || str ==null || str =="undefined";
}

updateSubmitBtn.onclick = () => {
	let name = profileInputs[0].value
	let email = profileInputs[1].value
	
	//1.빈값이 아니어야한다.
	//2.기존(originData랑 현재 data랑 변화가 있는지 체크)
	if(isEmpty(name)){
		alert("이름이 비었습니다.")
	}else if(isEmpty(email)){
		alert("이메일이 비었습니다.")
	}else if(originPrincipal.name ==name && originPrincipal.email == email){
		alert("수정할 정보가 없습니다")
	}else{
		document.querySelector("form").submit(); //submit버튼클릭과 동일
	}
	
	/*if(name == "" || name == null || typeof name == "undefined"){
		
	}else if(email == "" || email == null || typeof email == "undefined"){
		
	}*/

	/*if(isEmpty(profileInpust[0].value)){
		alert("이름이 비었습니다.")
	}else if(isEmpty(profileInputs[1].value)){
		alert("이메일이 비었습니다.")
	}else{
		alert("")
	}*/
	
	

	//1,2조건이 만족되면 submit()
	//alert("회원 정보 수정 요청");
	
	console.log(originPrincipal.name);
	console.log(originPrincipal.email);
	console.log(profileInputs[0].value);
	console.log(profileInputs[1].value);
	
}