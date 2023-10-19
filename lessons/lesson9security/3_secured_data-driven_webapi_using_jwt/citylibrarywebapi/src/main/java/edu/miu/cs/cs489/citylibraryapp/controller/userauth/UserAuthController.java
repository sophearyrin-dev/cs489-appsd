package edu.miu.cs.cs489.citylibraryapp.controller.userauth;

import edu.miu.cs.cs489.citylibraryapp.dto.userauth.UserAuthRequest;
import edu.miu.cs.cs489.citylibraryapp.utils.service.JWTManagementUtilityService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/citylibrary/api/v1/service"})
public class UserAuthController {

    private JWTManagementUtilityService jwtManagementUtilityService;
    private AuthenticationManager authenticationManager;

    public UserAuthController(JWTManagementUtilityService jwtManagementUtilityService,
                              AuthenticationManager authenticationManager) {
        this.jwtManagementUtilityService = jwtManagementUtilityService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = {"/public/authenticate"})
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(),
                            userAuthRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            System.out.println("Invalid Username and/or Password!");
            throw ex;
        }
        // todo fetch all the user's info - firstName, lastName etc.
        return jwtManagementUtilityService.generateToken(userAuthRequest.getUsername());
    }
}
