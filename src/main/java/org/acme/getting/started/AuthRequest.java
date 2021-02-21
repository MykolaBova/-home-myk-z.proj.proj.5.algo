package org.acme.getting.started;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


public class AuthRequest   {
  private String login = null;  private String password = null;

  /**
   * The user
   **/
  
  @Schema(description = "The user")
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * The  password. Not used at a current version of prototype.
   **/
  
  @Schema(description = "The  password. Not used at a current version of prototype.")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthRequest authRequest = (AuthRequest) o;
    return Objects.equals(login, authRequest.login) &&
        Objects.equals(password, authRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthRequest {\n");
    
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
