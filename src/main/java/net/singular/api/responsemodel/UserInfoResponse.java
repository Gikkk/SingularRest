package net.singular.api.responsemodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class UserInfoResponse {
    private int code;
    private String message;
    private UserData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        private String name;
        private String status;
    }
}
