package com.elte.fsz.takemybook.application.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elte.fsz.takemybook.application.service.AuthenticationService;
import com.elte.fsz.takemybook.application.transformer.ProfileTransformer;
import com.elte.fsz.takemybook.application.webdomain.ProfileForm;
import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.repository.BookwormRepository;

@Controller
public class SettingsController {
    @Autowired
    private BookwormRepository bookwormRepository;
    @Autowired
    private ProfileTransformer profileTransformer;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private HttpSession session;
    @GetMapping("settings")
    public String showSettingsForms(ProfileForm profileForm) {
        Bookworm bw = (Bookworm)authenticationService.getUserFromSession(session);
        profileTransformer.transform(bw, profileForm);
        return "settings";
    }

    @PostMapping("saveprofile")
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Binding error.");
            return "settings";
        }

        Bookworm bw = bookwormRepository.findById(profileForm.getId()).get();
        profileTransformer.transform(profileForm, bw);
        bookwormRepository.save(bw);
        redirectAttributes.addFlashAttribute("message", "Profile successfully updated.");
        return "redirect:profile";

    }

}
