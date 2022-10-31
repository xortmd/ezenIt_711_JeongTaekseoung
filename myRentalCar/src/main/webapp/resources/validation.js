function checkForm(form) { // form element 전체 요소를 들고와줌
    console.log(form);
    console.log(form.id);
    console.log(form.id.value);

    if(form.id.value === "") {
        alert('id를 입력하세요.');
    } else if(form.pw.value === "") {
        alert('pw를 입력하세요.');
    } else {
        // id, pw를 가지고 -> ajax 호출
        // 서블릿 페이지를 통한 response 얻기 (JSON)
        // 반환값: user 객체에 대한 json 데이터

        // 
        form.submit();
    }
}