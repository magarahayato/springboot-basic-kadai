package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    // 入力画面表示
    @GetMapping("/form")
    public String showForm(Model model) {

        // redirect時のデータが無い場合のみ新規生成
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }

        return "contactFormView";
    }

    // 確認画面
    @PostMapping("/confirm")
    public String confirm(
            @Validated ContactForm contactForm,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        // バリデーションエラー時
        if (result.hasErrors()) {

            // 入力値保持
            redirectAttributes.addFlashAttribute(
                    "contactForm",
                    contactForm);

            // エラー情報保持
            redirectAttributes.addFlashAttribute(
                    BindingResult.MODEL_KEY_PREFIX
                            + Conventions.getVariableName(contactForm),
                    result);

            // /formへリダイレクト
            return "redirect:/form";
        }

        // 正常時は確認画面へ
        return "confirmView";
    }
}