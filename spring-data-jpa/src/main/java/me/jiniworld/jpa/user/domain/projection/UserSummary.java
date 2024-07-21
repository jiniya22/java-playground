package me.jiniworld.jpa.user.domain.projection;

import org.springframework.beans.factory.annotation.Value;

public interface UserSummary {
    String getUsername();

    @Value("#{target.username}: #{target.email}")
    String getUserInfo();
}