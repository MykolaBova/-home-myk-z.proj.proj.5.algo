package org.acme.getting.started;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public interface AuthApiService {
      Response loginUser(AuthRequest body,SecurityContext securityContext)
      throws NotFoundException;

}
