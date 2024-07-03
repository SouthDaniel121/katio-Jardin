package edu.eafit.katio.dtos;



//El dto es para poder hacer
//abstracción de datos eficientes al tiempo que promueven un acoplamiento flexible entre capas.
//Los getters and setters


public class LoginResponse {
    private String token;
    private long expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}