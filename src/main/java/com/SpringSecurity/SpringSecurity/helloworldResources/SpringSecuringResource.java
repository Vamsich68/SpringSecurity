package com.SpringSecurity.SpringSecurity.helloworldResources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
@RestController
public class SpringSecuringResource {
    @GetMapping("/csrfToken")
    public CsrfToken retriveCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
