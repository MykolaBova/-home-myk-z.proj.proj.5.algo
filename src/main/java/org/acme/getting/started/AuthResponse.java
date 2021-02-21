package org.acme.getting.started;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;


@RegisterForReflection
public class AuthResponse extends BaseResponse  {
  private String userId = null;  private String accessToken = null;  private String refreshToken = null;

  /**
   * User Id. Actually user name for now.
   **/
  
  @Schema(description = "User Id. Actually user name for now.")
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Access token
   **/
  
  @Schema(description = "Access token")
  @JsonProperty("accessToken")
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  /**
   * Refresh token
   **/
  
  @Schema(description = "Refresh token")
  @JsonProperty("refreshToken")
  public String getRefreshToken() {
    return refreshToken;
  }
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthResponse authResponse = (AuthResponse) o;
    return Objects.equals(userId, authResponse.userId) &&
        Objects.equals(accessToken, authResponse.accessToken) &&
        Objects.equals(refreshToken, authResponse.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, accessToken, refreshToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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
