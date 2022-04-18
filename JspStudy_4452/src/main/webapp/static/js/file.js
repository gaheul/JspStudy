const fileUpload = document.querySelector(".file-upload");
const previewImg = document.querySelector(".preview-img");

fileUpload.onchange = () => {//onchange : 수정될때 
	previewImg.innerHTML = "";
	
	
	for(let i=0; i<fileUpload.files.length; i++){
		if(!isImage(fileUpload.files[0])){
		alert((i+1) + "번 파일은 이미지가 아닙니다.");
		fileUpload.select();
		document.selection.clear();
		previewImg.innerHTML = "";
		return;
		} //이미지 체크
		const reader = new FileReader(); //reader객체 생성
	
		reader.onload = () => {
			const img = document.createElement("img");
			img.src = reader.result;
			previewImg.appendChild(img)
			//previewImg.src = reader.result; //result ->readAsDataURL한 결과
		
		}//이벤트 정의
		reader.readAsDataURL(fileUpload.files[i]);
	}
	
	//reader.readAsDataURL(fileUpload.files[0]); //먼저실행  readAsDataURL가 실행되고 나면 onload실행
}

function isImage(file){
	console.log(file.type);
	return file.type.indexOf('image') >= 0;
} //indexof : 인덱스 번호