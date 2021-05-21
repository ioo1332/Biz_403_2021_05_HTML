// js에서의 true false

console.log("a" == "b");
console.log("a" == "a");

let num = 3;
// java같은경우는 if문에서 single EQ(=)를 사용하면 syntax error발생
// if(num=3)
// 하지만 다음과같은코드는 논리적으로 문제가없다
// if((num=method()==3)

/*  while(reader=buffer.readLine())!=null)
    
    while(true){
    reder=buffer.readLine();
    if(reader==null) break;
    }
*/
// js에서는 다음과같은코드가 논리적으로는 문제가 될수있지만
// 문법적으로는 정당하다
// if((num=5)==true)
if ((num = 5)) {
  console.log("같은값");
}
// js에서는 숫자 0,false,null,undefind,NaN 을 제외한 모든것은
// boolean에서 true로 취급된다
// if(값)명령을 사용할때
// 값에 위에 나열한 type데이터가 나타나면
// 논리적으로 false가 인식되고
// 그 외는 무조건 true이다
if (0) {
  console.log(true);
} else {
  console.log(false);
}

if ("") {
  console.log(true);
} else {
  console.log(false);
}

let num1 = 3;
let num2 = "3";
/* 
두값이 같은지 비교를 하는 연산자
주로 if while등에서 사용
동등 연산자(==)
    자동으로 형변환이 발생한다
    0=='0'을 비교하면 문자열 '0'을
    숫자 0으로 자동형변환을 해버린다
    문자열과 숫자의 비교지만 내용만 같으면
    같은것으로 true값이 된다
일치연산자(===)
    무조건 자신의 형(type)을 유지하면서 비교
    0==='0'을 비교하면 
    1.두값의 type이 일치하는지 비교
    같으면 true 다르면 무조건 false
    2.두값의 type이 같으면 
    실제값을 비교하여
    같으면 true 다르면 false
*/
console.log(num1 == num2);
console.log(num1 === num2);
//문자열 ""과 문자열"0"을 비교
console.log("" == "0"); // false
//문자열 ""을 숫자0으로 변환하고
//0==0으로 비교 =>true
console.log("" == 0);
//boolean true 를 문자열""
console.log("ture" == true);
console.log("fasle" == false);
//문자열 "0"을 숫자0으로 변환
console.log("0" == false);
//숫자0은 당연히 false이므로 결과는 true
//숫자0이 false냐 =>true
console.log(0 == false);
//동등연산자에서는 null하고 undefined를
//null==undefined할때만 true 로 인식하고
//다른 이외의값과 비교할때는 무조건 false
//숫자0,null,undefined등은
//if에서 false로 인식하지만
//동등연산자에서는
console.log(null == undefined);
console.log(null == false);
console.log(undefined == false);
console.log(null == 0);
console.log(undefined == 0);
console.log(NaN == false);
// 어떤 변수에 담긴값이 null인가 확인하고싶을때
// 1번 이나 2번처럼 코드를 사용해야한다
// 3번 처럼 사용하면 논리적 오류를 낼수있다
let un1 = null;
//1번코드
if (un1) {
}
//2번코드
if (un1 == null) {
}
//3번코드
if (un1 == false) {
}

// 일반적으로 숫자형,문자형 데이터가 같은지(일치하는지)알아보고 싶을때는
// 일치 연산자를 사용하는것이 좋다

console.log("3" === 3);
//parseInt문자열혈 숫자를 실제숫자로 변환하는 js함수
//type이 다른 두값을 비교하고자 할때는 코드가 다소 복잡해지지만
//강제 형변환을 하고 일치연산자로 비교하는것이 논리적오류를 막을수있다
console.log(parseInt("3") == 3);
//isNaN(값)
//값이 숫자로 변환할수 없냐?
//할수없으면 true 있으면 false
console.log(isNaN("3"));
console.log(isNaN(3));
if (isNaN("3")) {
  console.log(true);
} else {
  console.log(false);
}
//문자열 "A"를 숫자로 바꿀수있냐? 할수없음 true
console.log(isNaN("A")); //true
//값비교가 아니라 type비교라 false
console.log("A" == NaN);
