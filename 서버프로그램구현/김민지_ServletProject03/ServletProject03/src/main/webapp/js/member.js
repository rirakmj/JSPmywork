// for 유효성검사

$(document).ready(function(){
	var exp =/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/ // 전화번호 양식 지정
	$("#sendBtn").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
			if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		if($("#pwd").val() != $("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다")
			$("#pwd_check").focus();
			return false;
		}
		if($("#email").val()==""){
		alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
//		if(!$("#phone").val().match(exp)){
//		alert("전화번호 형식이 아닙니다");
//			$("#phone").focus();
//			return false;
//		} 패턴 뒤에 쓰는 형식
		if(!exp.test($("#phone").val())){
		alert("전화번호 형식이 아닙니다");
			$("#phone").focus();
			return false;
		}
		$("#frm").submit();
		
	}) //sendBtn
	
	$("#idCheckBtn").click(function(){
		window.open("idCheck.jsp","","width=400 height=300");
		})
	
	// idUseBtn 클릭하여 유효성 검사
	$("#idUseBtn").click(function(){
	  if($("#userid").val()==""){
		alert("아이디를 입력하세요")
		return;
	}
	$.ajax({
		type: 'post',
		url: "idCheckPro.jsp", // 입력받은 userid가 DB에 있나 없나 체크
		data: {"userid":$("#userid").val()},
		success:function(resp){
//			alert(resp.trim().length)
		if(resp.trim() == "yes"){
			alert("사용가능한 아이디입니다")
			$(opener.document).find("#userid").val($("#userid").val())
		    self.close()
		} else{
			alert("사용 불가능한 아이디입니다")
			$("#userid").val('')
			$("#userid").focus()
		}
		},
		error:function(e){
			alert(e+"error");
		}
		
	})	 //ajax
	}) //idUseBtn

	}) //document
	
	//삭제
	function del(userid, mode){ // userid 받아야
		if(mode=="관리자"){
			alert("관리자는 삭제할 수 없습니다")
			return; // return은 종료의 의미가 있다
		}
		if(confirm('정말 삭제할까요?')){
			$.getJSON("memberDeletePro.jsp",
								 {"userid":userid},
			function(resp){
			// alert(resp.countObj.count)
			var str="";
			$.each(resp.jarrObj, function(key,val){
				str += "<tr>"
				str += "<td>"+val.name+"</td>"
				str += "<td>"+val.userid+"</td>"
				str += "<td>"+val.email+"</td>"
				str += "<td>"+val.phone+"</td>"
				str += "<td>"+val.admin+"</td>"
//				str += "<td><a href='memberList.jsp'>삭제</a></td>"
				str += "<td><a href=javascript:del('"+val.userid+"','"+val.admin+"')>삭제</a></td>"
				str += "</tr>"
			}) // each
			$("table tbody").html(str);
			$("#cntSpan").text(resp.countObj.count)
			} // function
			) //getJSON
			} // if
			// 개수와 삭제된 내용이 화면에 표시
			// 비동기함수
		} // del
		