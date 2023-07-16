package com.elte.fsz.takemybook.application.transformer;

import org.springframework.stereotype.Component;

import com.elte.fsz.takemybook.application.webdomain.ProfileForm;
import com.elte.fsz.takemybook.domain.Bookworm;

@Component
public class ProfileTransformer {
    public void transform(Bookworm bookworm, ProfileForm profileForm) {
        profileForm.setId(bookworm.getId());
        profileForm.setNickname(bookworm.getNickName());
        profileForm.setEmail(bookworm.getEmail());
        profileForm.setPhone(bookworm.getPhone());
    }

    public void transform(ProfileForm profileForm, Bookworm bookworm) {
        bookworm.setNickName(profileForm.getNickname());
        bookworm.setEmail(profileForm.getEmail());
        bookworm.setPhone(profileForm.getPhone());
    }
}
