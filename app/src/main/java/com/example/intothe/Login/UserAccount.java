package com.example.intothe.Login;

// 사용자 계정 정보 모델 클래스
public class UserAccount {
    private String idToken;   // Firebase Uid (고유 토큰정보)
    private String emailId;   // 이메일 아이디
    private String password;   // 비밀번호
    private String userName;   // 사용자 이름
    private String userBirth;   // 사용자 생년월일

    public UserAccount() { }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }
}
