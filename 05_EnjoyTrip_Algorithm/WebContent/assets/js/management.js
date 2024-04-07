document.addEventListener("DOMContentLoaded", function () {
    var userList = document.getElementById("userList");

    var users = JSON.parse(localStorage.getItem("users")) || [];
    renderUserList(users);

    // 사용자 목록 렌더링
    function renderUserList(users) {
        userList.innerHTML = "";

        users.forEach(function (user) {
            var row = document.createElement("tr");

            var nameCell = document.createElement("td");
            nameCell.textContent = user.name;
            row.appendChild(nameCell);

            var emailCell = document.createElement("td");
            emailCell.textContent = user.email;
            row.appendChild(emailCell);

            var editCell = document.createElement("td");
            var editButton = document.createElement("button");
            editButton.className = "btn btn-warning btn-sm";
            editButton.textContent = "수정";
            editButton.addEventListener("click", function () {
                updateUser(user.email);
            });
            editCell.appendChild(editButton);
            row.appendChild(editCell);

            var deleteCell = document.createElement("td");
            var deleteButton = document.createElement("button");
            deleteButton.className = "btn btn-danger btn-sm";
            deleteButton.textContent = "삭제";
            deleteButton.addEventListener("click", function () {
                deleteUser(user.email);
            });
            deleteCell.appendChild(deleteButton);
            row.appendChild(deleteCell);

            userList.appendChild(row);
        });
    }

    // 사용자 정보 수정
    function updateUser(userEmail) {
        var newName = prompt("새 이름을 입력하세요:");
        if (newName === null) {
            return; // 취소를 누르면 아무 동작도 하지 않음
        }

        var foundUser = users.find(function (user) {
            return user.email === userEmail;
        });

        if (foundUser) {
            foundUser.name = newName;
            // 수정된 사용자 정보를 localStorage에 업데이트
            localStorage.setItem("users", JSON.stringify(users));
            renderUserList(users);
        }
    }

    // 사용자 정보 삭제
    function deleteUser(userEmail) {
        var confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            // 사용자 정보 배열에서 해당 사용자 제거
            users = users.filter(function (user) {
                return user.email !== userEmail;
            });
            // 삭제된 사용자 정보를 localStorage에 업데이트
            localStorage.setItem("users", JSON.stringify(users));
            renderUserList(users);
        }
    }
});