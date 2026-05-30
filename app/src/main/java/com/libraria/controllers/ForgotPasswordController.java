package com.libraria.controllers;

import com.libraria.models.Member;
import com.libraria.views.ChangePasswordView;
import com.libraria.views.ForgotPasswordView;
import com.libraria.views.SecretQuestionView;

import javafx.application.Platform;
import javafx.stage.Stage;

public class ForgotPasswordController extends LoginBaseController implements Runnable {
    ForgotPasswordView forgotPasswordView = new ForgotPasswordView();
    SecretQuestionView secretQuestionView = new SecretQuestionView();
    ChangePasswordView changePasswordView = new ChangePasswordView();
    private Member member;
    private String email;
    private int attempts;
    private Stage stage;

    @Override
    public void show(Stage stage) {
        this.stage = stage;
        loadScene(stage, forgotPasswordView.getRoot(), "Libraria - Forgot Password");

        forgotPasswordView.getLoginLink().setOnAction(e -> {
            LoginController loginController = new LoginController();
            loginController.show(stage);
        });

        forgotPasswordView.getSignUpLink().setOnAction(e -> {
            CreateAccountController createAccountController = new CreateAccountController();
            createAccountController.show(stage);
        });

        forgotPasswordView.getSubmitButton().setOnAction(e -> {
            email = forgotPasswordView.getEmailField().getText().trim().toLowerCase();

            if (validator.isFieldNotEmpty(email)) {
                if (validator.isEmailValid(email)) {
                    if (data.isEmailExists(email)) {
                        showSecretQuestion(stage);
                    } else {
                        forgotPasswordView.getErrorLabel().setText("Email not found! Please make sure you have a registered email");
                        forgotPasswordView.getSignUpLink().setVisible(true);
                        forgotPasswordView.getSignUpLink().setManaged(true);
                    }
                } else {
                    forgotPasswordView.getErrorLabel().setText("Email is incorrect!");
                }
            } else {
                forgotPasswordView.getErrorLabel().setText("Enter your Email Address");
            }
        });

        forgotPasswordView.getEmailField().setOnAction(e -> {
            forgotPasswordView.getSubmitButton().fire();
        });
    }

    public void showSecretQuestion(Stage stage) {
        loadScene(stage, secretQuestionView.getRoot(), "Libraria - Secret Question");
        attempts = 3;
        member = new Member();
        member.setEmail(email);

        secretQuestionView.getQuestionLabel().setText(data.getSecretQuestion(member));

        secretQuestionView.getSubmitButton().setOnAction(e -> {
            String secretAnswer = secretQuestionView.getAnswerField().getText();
            member.setSecretanswer(secretAnswer);

            if (validator.isFieldNotEmpty(secretAnswer)) {
                if (data.isSecretAnswerExists(member)) {
                    showChangePassword(stage);
                } else {
                    attempts --;
                    if (attempts == 0) {
                        secretQuestionView.getErrorLabel().setText("Wrong Answer! You have no more attempts. Please create another account");
                        secretQuestionView.getSubmitButton().setText("Sign Up");
                        secretQuestionView.getSubmitButton().setOnAction(event -> {
                            CreateAccountController createAccountController = new CreateAccountController();
                            createAccountController.show(stage);
                        });
                    } else {
                        secretQuestionView.getErrorLabel().setText("Wrong Answer! Remaining attempts: " + attempts);
                    }
                }
            } else {
                secretQuestionView.getErrorLabel().setText("Enter your Answer");
            }
        });

        secretQuestionView.getFindUsernameLink().setOnAction(e -> {
            show(stage);
        });

        secretQuestionView.getAnswerField().setOnAction(e -> {
            secretQuestionView.getSubmitButton().fire();
        });
    }

    public void showChangePassword(Stage stage) {
        loadScene(stage, changePasswordView.getRoot(), "Libraria - Change Password");
        
        changePasswordView.getSubmitButton().setOnAction(e -> {
            String newPassword = changePasswordView.getPasswordText();
            String confirmPassowrd = changePasswordView.getConfirmPasswordText();
            String result = verifyNewPassword(newPassword, confirmPassowrd);

            if (result.equals("Success")) {
                member.setPassword(newPassword);
                if (data.changePassword(member)) {
                    changePasswordView.getErrorLabel().setManaged(false);
                    changePasswordView.getErrorLabel().setVisible(false);
                    changePasswordView.getSuccessLabel().setVisible(true);
                    changePasswordView.getSuccessLabel().setManaged(true);
                    changePasswordView.getSuccessLabel().setText("Change Password successful! Returning to login...");
                    Thread thread = new Thread(this);
                    thread.setDaemon(true);
                    thread.start();
                } else {
                    changePasswordView.getErrorLabel().setText("Change Password failed! Please try again.");
                }
            } else {
                changePasswordView.getErrorLabel().setText(result);
            }
        });

        changePasswordView.getPasswordVisible().setOnAction(e -> {
            if (changePasswordView.getConfirmPasswordVisible().isVisible()) {
                changePasswordView.getConfirmPasswordVisible().requestFocus();
            } else {
                changePasswordView.getConfirmPasswordField().requestFocus();
            }
        });

        changePasswordView.getConfirmPasswordVisible().setOnAction(e -> {
            changePasswordView.getSubmitButton().fire();
        });

        changePasswordView.getConfirmPasswordField().setOnAction(e -> {
            changePasswordView.getSubmitButton().fire();
        });
    }
    
    @Override
    public void run() {
        for (int i = 5; i >= 1; i--) {
            final int countdown = i;
            Platform.runLater(() -> {
                changePasswordView.getErrorLabel().setManaged(false);
                changePasswordView.getErrorLabel().setVisible(false);
                changePasswordView.getSuccessLabel().setVisible(true);
                changePasswordView.getSuccessLabel().setManaged(true);
                changePasswordView.getSuccessLabel().setText("Change Password successful! Returning to login in " + countdown + " seconds...");
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            LoginController loginController = new LoginController();
            loginController.show(stage);
        });
    }

    public String verifyNewPassword(String newPassword, String confirmPassowrd) {
        if (validator.isFieldNotEmpty(newPassword)) {
            if (validator.isFieldNotEmpty(confirmPassowrd)) {
                if (!validator.isPasswordContainsSpace(newPassword) && !validator.isPasswordContainsSpace(confirmPassowrd)) {
                    if (validator.isPasswordValid(newPassword) && validator.isPasswordValid(confirmPassowrd)) {
                        if (validator.isPasswordMatch(newPassword, confirmPassowrd)) {
                            return "Success";
                        } else {
                            return "Password does not match!";
                        }
                    } else {
                        return "Password must be at least 8 characters!";
                    }
                } else {
                    return "Enter your Password without any space!";
                }
            } else {
                return "Confirm your password";
            }
        } else {
            return "Enter your new Password";
        }
    }
}