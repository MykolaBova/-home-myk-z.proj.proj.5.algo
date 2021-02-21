package org.acme.getting.started;

//import com.apollocurrency.dfs.service.AuthService;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import static javax.ws.rs.core.Response.Status.OK;

/**
 *   @author bova.mykola@gmail.com
 */
@Slf4j
@RequestScoped
public class AuthEndpoint implements AuthApiService {

//    @Inject
//    AuthService authService;

    @Override
    public Response loginUser(AuthRequest authRequest, SecurityContext securityContext) throws NotFoundException {
        log.debug("---> Received USER AUTH LOGIN request={}", authRequest);
        Response response;


        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken("access toke");
        authResponse.setRefreshToken("refresh token");
        authResponse.setUserId("User Id");
        authResponse.setErrorCode(0);
        authResponse.setErrorDescriptionKey("OK");

        response = Response.status(OK).entity(authResponse).build();

//        try {
//            response = Response.status(OK).entity(authService.loginUser(authRequest)).build();
//        } catch (Exception e) {
//            response = Response.status(UNAUTHORIZED).build();
//            log.error("<--- Authentication Error:{}, request={}", e.getMessage(), authRequest);
//        }

        log.error("<--- Authentication Response:{}{}, request={}", response, response.getEntity(),authRequest);

        return response;
    }

}
