const body = document.body;
const inputCustName = body.querySelector("#custName");
const inputPhone = body.querySelector("#phone");
const inputAddress = body.querySelector("#address");
const inputJoinDate = body.querySelector("#joinDate");
const inputGrade = body.querySelector("#grade");
const inputCity = body.querySelector("#city");

const inputs = new Array();
inputs.push(inputCustName);
inputs.push(inputPhone);
inputs.push(inputAddress);
inputs.push(inputJoinDate);
inputs.push(inputGrade);
inputs.push(inputCity);

function submitCheck(form){
    let custName = inputCustName.value;
    let phone = inputPhone.value;
    let address = inputAddress.value;
    let joinDate = inputJoinDate.value;
    let grade = inputGrade.value;
    let city = inputCity.value;

    let check = true;
    inputs.forEach(e => {
        if (e.value === '')
            check = false;
    })

    if (check) {
        alert('회원등록이 완료되었습니다!');
        form.submit();
    } else {
        if(custName === '')
            alert('회원성명이 입력되지 않았습니다.');
        else if(phone === '')
            alert('전화번호가 입력되지 않았습니다.');
        else if(address === '')
            alert('주소가 입력되지 않았습니다.');
        else if(joinDate === '')
            alert('가입일이 입력되지 않았습니다.');
        else if(grade === '')
            alert('회원등급이 입력되지 않았습니다.');
        else if(city === '')
            alert('도시가 입력되지 않았습니다.');

        let url = "join.jsp?"

        if (custName !== '')
            url += `&custName=${custName}`;
        if (phone !== '')
            url += `&phone=${phone}`;
        if(phone !== '')
            url += `&phone=${phone}`;
        if (address !== '')
            url += `&address=${address}`;
        if (joinDate !== '')
            url += `&joinDate=${joinDate}`;
        if (grade !== '')
            url += `&grade=${grade}`;
        if (city !== '')
            url += `&city=${city}`;

        location.href = url;
    }

}