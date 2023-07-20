package com.works.configs;

import com.works.entities.Customer;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class JpaConfig implements AuditorAware<String> {

    final HttpServletRequest req;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Rest.userOptional(req);
    }

}
