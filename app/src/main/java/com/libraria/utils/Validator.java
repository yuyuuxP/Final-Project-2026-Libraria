package com.libraria.utils;

public class Validator {
    public boolean isEmailValid(String email) {
        if (email.contains("@")) {
            String[] parts = email.split("@");

            if (parts.length == 2 && !parts[0].isEmpty()) {
                if (email.endsWith("@gmail.com") || email.endsWith("@libraria.com")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        return false;
    }

    public boolean isSecretQuestionValid(String SecretQuestion) {
        if (SecretQuestion.length() > 1 && SecretQuestion.endsWith("?")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFieldNotEmpty(String text) {
        if (text.isEmpty()) {
            return false;
        }else {
            return true;
        }
    }

    public boolean isPasswordMatch(String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isPasswordValid(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }
}