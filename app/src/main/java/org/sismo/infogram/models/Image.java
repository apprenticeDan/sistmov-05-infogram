package org.sismo.infogram.models;

public class Image {
    String urlImage;
    String userName;
    String cantidadDias;
    String canidadMeGusta;

    public Image(String urlImage, String userName, String cantidadDias, String canidadMeGusta) {
        this.urlImage = urlImage;
        this.userName = userName;
        this.cantidadDias = cantidadDias;
        this.canidadMeGusta = canidadMeGusta;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(String cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCanidadMeGusta() {
        return canidadMeGusta;
    }

    public void setCanidadMeGusta(String canidadMeGusta) {
        this.canidadMeGusta = canidadMeGusta;
    }
}
