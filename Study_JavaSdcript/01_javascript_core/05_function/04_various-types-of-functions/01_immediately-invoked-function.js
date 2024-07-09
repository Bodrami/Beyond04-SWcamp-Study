/* 01. immediately-invoked-function(즉시 실행 함수) */
/* 함수 정의와 동시에 즉시 호출되는 함수로 단 한번만 호출되며 다시 호출할 수 없다. */

(function() {
    console.log('익명 즉시 실행 함수! 함수 정의와 동시에 호출!!');
})();

(function hello(name) {
    console.log('기명 즉시 실행함수! 함수 정의와 동시에 호출!!');
    console.log(`${name}님 안녕하세요!`);
})('홍load동');

// hello('홍load동'); 에러 발생

/* 즉시 실행 함수 내에 코드를 모아두면 혹시 있을 수도 있는 변수나 함수의 이름 출동 방지도 가능하다. */
/* 별도로 다시 호출할 일이 없는 함수일 경우 적용한다. */