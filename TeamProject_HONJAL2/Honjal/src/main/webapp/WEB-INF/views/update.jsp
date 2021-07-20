<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form class="write_form" method=POST>
	<h2 class="board_title">글 수정</h2>
		<fieldset>
			<div class="write_top">
				<input name="content_title" class="write_title" value="${CONTENT.content_title}"/>
				<div class="file_box">
					<label for="ex_file">&#128190;</label> <input type="file" id="ex_file" />
				</div>
			</div>
			<textarea name="content_text" class="write_text" >${CONTENT.content_text}</textarea>
			
			<input name="content_num" type="hidden" value="${CONTENT.content_num}"/>
			<input name="member_num" type="hidden" value="${CONTENT.member_num}"/>
			<input name="member_nname" type="hidden" value="${CONTENT.member_nname}"/>
			<input name="board_code" type="hidden" value="${CONTENT.board_code}"/>
			<input name="content_date" type="hidden" value="${CONTENT.content_date}"/>
			<input name="content_time" type="hidden" value="${CONTENT.content_time}"/>
			<input name="content_view" type="hidden" value="${CONTENT.content_view}"/>
			<input name="content_good" type="hidden" value="${CONTENT.content_good}"/>
		</fieldset>
		<div class="write_bottom">
			<button id="btn_write" type="button">등록</button>
			<button id="btn_cancel" type="button">취소</button>
		</div>
</form>

<script>

let rootPath = "${rootPath}/board"
let input_title = document.querySelector("input[name='content_title']")
let input_text = document.querySelector("textarea[name='content_text']")

document.querySelector("#btn_write").addEventListener("click",(e)=>{
	let title = input_title.value
	let text = input_text.value
	if(title === "") {
		alert("제목을 입력해주세요")
		input_title.focus()
		return false
	}
	if(text === "") {
		alert("내용을 입력해주세요")
		input_text.focus()
		return false
	}
	if(confirm("수정하시겠습니까?")) {
		document.querySelector("form").submit()
	}
})

document.querySelector("#btn_cancel").addEventListener("click",(e)=> {
	if(confirm("글수정을 취소하시겠습니까?")) {
		location.href = rootPath + "/read?content_num=${CONTENT.content_num}";
	}
})



</script>