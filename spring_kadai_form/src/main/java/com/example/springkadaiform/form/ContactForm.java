package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactForm {

    @NotBlank(message = "お名前を入力してください。")
    private String name;

    @Email(message = "メールアドレスの入力形式が正しくありません。")
    @NotBlank(message = "メールアドレスを入力してください。")
    private String email;

    @NotBlank(message = "お問い合わせ内容を入力してください。")
    private String inquiry;

    // getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }
}