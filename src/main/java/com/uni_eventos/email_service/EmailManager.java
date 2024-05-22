package com.uni_eventos.email_service;

import javax.mail.MessagingException;

public class EmailManager {
    public static EmailService email = new EmailService("uqunieventos@gmail.com", "ynsf wlno spjm vxad");

    public static void enviarCorreoConfirmacion(String para) {
        GeneradorCodigo.generateRandomCode();
        try {
            email.sendEmail(para, "CODIGO DE VERIFCACION UNIEVENTOS",
                    "Creaste una cuenta en UniEvento, aqui esta el codigo de verificacion:\n" + " "
                            + GeneradorCodigo.getGeneratedCode());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void enviarCuponBienvenida(String para, int codigoCupon) {
        try {
            email.sendEmail(para, "CUPON DE REGALO",
                    "Tienes un cupon de regalo para redimir por un valor del 15%:\n" + Integer.toString(codigoCupon));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void enviarCuponPrimeraCompra(String para, int codigoCupon) {
        try {
            email.sendEmail(para, "CUPON DE REGALO",
                    "Tienes un cupon de regalo para redimir por haber comprado por primera vez por un valor 10%:\n"
                            + Integer.toString(codigoCupon));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}