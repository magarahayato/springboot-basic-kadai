package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // 初期表示
    @GetMapping("/form")
    public String showForm(Model model) {

        model.addAttribute("contactForm", new ContactForm());

        return "contactFormView";
    }

    // 確認画面
    @PostMapping("/confirm")
    public String confirm(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult) {

        // エラーがある場合は入力画面へ戻る
        if (bindingResult.hasErrors()) {
            return "contactFormView";
        }

        return "confirmView";
    }
}