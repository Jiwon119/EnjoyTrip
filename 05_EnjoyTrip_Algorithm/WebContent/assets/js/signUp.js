function signUp() {
  var signupForm = document.getElementById("signupForm");

  console.log("start");

  console.log("회원 가입 시작합니다.");
  // event.preventDefault(); // 기본 제출 동작 방지

  // 입력된 정보 가져오기
  var name = document.getElementById("signupName").value;
  var email = document.getElementById("signupEmail").value;
  var password = document.getElementById("signupPassword").value;

  // 사용자 객체 생성
  var user = {
    name: name,
    email: email,
    password: password,
  };

  // console.log(user);
  // 사용자 정보를 localStorage에 저장
  saveUser(user);

  // 회원가입 양식 초기화
  signupForm.reset();

  alert("회원가입이 완료되었습니다.");
}

// 사용자 정보를 localStorage에 저장하는 함수
function saveUser(user) {
  var users = JSON.parse(localStorage.getItem("users")) || [];

  users.push(user);

  localStorage.setItem("users", JSON.stringify(users));
  var storage = localStorage.getItem("users");
  console.log(storage);
}
