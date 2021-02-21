

package org.acme.getting.started;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Objects;

//import static com.apollocurrency.dfs.api.v2.error.Error.OK;

@RegisterForReflection
public class BaseResponse {

    private int errorCode;

    private String errorDescriptionKey;

    @SuppressWarnings("unused")
    public int getErrorCode() {
        return errorCode;
    }

    @SuppressWarnings("unused")
    public String getErrorDescriptionKey() {
        return errorDescriptionKey;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDescriptionKey(String errorDescriptionKey) {
        this.errorDescriptionKey = errorDescriptionKey;
    }

//    public void setError(Error error) {
//        setErrorCode(error.getErrorCode());
//        setErrorDescriptionKey(error.getErrorDescriptionKey());
//    }

    @SuppressWarnings("unused")
//    public void setStatusOk() {
//        setError(OK);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return errorCode == that.errorCode &&
            Objects.equals(errorDescriptionKey, that.errorDescriptionKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorDescriptionKey);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
            "errorCode=" + errorCode +
            ", errorDescriptionKey='" + errorDescriptionKey + '\'' +
            '}';
    }

}
