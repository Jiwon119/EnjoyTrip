function login() {
  var loginForm = document.getElementById("loginForm");
  console.log("start");

  var inputEmail = document.getElementById("loginEmail").value;
  var inputPassword = document.getElementById("loginPassword").value;

  var users = JSON.parse(localStorage.getItem("users")) || [];

  console.log(inputEmail, inputPassword);
  var user = users.find((user) => user.email === inputEmail && user.password === inputPassword);

  if (user) {
    alert("로그인 성공!");
  } else {
    alert("이메일 또는 비밀번호가 올바르지 않습니다. 다시 시도하세요.");
    return;
  }
}
