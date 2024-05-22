package com.uni_eventos.email_service;

import java.util.Random;

public class GeneradorCodigo {
    private static final int CODE_LENGTH = 10; // Define the length of the random code
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();
    private static String generatedCode;

    public static void generateRandomCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        generatedCode = code.toString();
    }

    public static String getGeneratedCode() {
        return generatedCode;
    }
}