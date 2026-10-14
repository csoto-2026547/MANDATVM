package org.cristophersoto.system.model;

public class Usuario {

    private int idUsuario;
    private String userName;
    private boolean userStatus;

    public Usuario(int idUsuario, String userName, boolean userStatus) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.userStatus = userStatus;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isUserStatus() {
        return userStatus;
    }
}
