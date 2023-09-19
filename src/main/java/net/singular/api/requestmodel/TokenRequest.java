package net.singular.api.requestmodel;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String password;

    public TokenRequest(String username, String password) {
    }
}

