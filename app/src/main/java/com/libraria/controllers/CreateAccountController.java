package com.libraria.controllers;

import com.libraria.models.Member;
import com.libraria.views.CreateAccountView;
import javafx.application.Platform;
import javafx.stage.Stage;

public class CreateAccountController extends LoginBaseController implements Runnable {
    CreateAccountView createAccountView = new CreateAccountView();
    private Stage stage;

    @Override
    public void show(Stage stage) {
        this.stage = stage;
        loadScene(stage, createAccountView.getRoot(), "Libraria - Sign In");

        createAccountView.getLoginLink().setOnAction(e -> {
            LoginController loginController = new LoginController();
            loginController.show(stage);
        });

        createAccountView.getCreateButton().setOnAction(e -> {
            String email = createAccountView.getEmailField().getText().trim().toLowerCase();
            String password = createAccountView.getPasswordText();
            String secretQuestion = createAccountView.getSecretQuestionField().getText().trim();
            String secretAnswer = createAccountView.getSecretAnswerField().getText().trim();
            String result = verifyRegister(email, password, secretQuestion, secretAnswer);

            if (result.equals("Success")) {
                Member member = new Member(email, password, secretQuestion, secretAnswer);
                if (data.register(member)) {
                    createAccountView.getErrorLabel().setManaged(false);
                    createAccountView.getErrorLabel().setVisible(false);
                    createAccountView.getSuccessLabel().setVisible(true);
                    createAccountView.getSuccessLabel().setManaged(true);
                    createAccountView.getSuccessLabel().setText("Registration successful! Returning to login...");
                    Thread thread = new Thread(this);
                    thread.setDaemon(true);
                    thread.start();
                } else {
                    createAccountView.getErrorLabel().setText("Registration failed! Please try again.");
                }
            } else {
                createAccountView.getErrorLabel().setText(result);
            }
        });

        createAccountView.getEmailField().setOnAction(e -> {
            if (createAccountView.getPasswordVisible().isVisible()) {
                createAccountView.getPasswordVisible().requestFocus();
            } else {
                createAccountView.getPasswordField().requestFocus();
            }
        });

        createAccountView.getPasswordField().setOnAction(e -> {
            createAccountView.getSecretQuestionField().requestFocus();
        });

        createAccountView.getPasswordVisible().setOnAction(e -> {
            createAccountView.getSecretQuestionField().requestFocus();
        });

        createAccountView.getSecretQuestionField().setOnAction(e -> {
            createAccountView.getSecretAnswerField().requestFocus();
        });

        createAccountView.getSecretAnswerField().setOnAction(e -> {
            createAccountView.getCreateButton().fire();
        });
    }

    @Override
    public void run() {
        for (int i = 5; i >= 1; i--) {
            final int countdown = i;
            Platform.runLater(() -> {
                createAccountView.getErrorLabel().setManaged(false);
                createAccountView.getErrorLabel().setVisible(false);
                createAccountView.getSuccessLabel().setVisible(true);
                createAccountView.getSuccessLabel().setManaged(true);
                createAccountView.getSuccessLabel().setText("Registration successful! Returning in " + countdown + " seconds...");
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

    private String verifyRegister(String email, String password, String secretQuestion, String secretAnswer) {
        if (validator.isFieldNotEmpty(email)) {
            if (validator.isEmailValid(email)) {
                if (!data.isEmailExists(email)) {
                    if (validator.isFieldNotEmpty(password)) {
                        if (validator.isPasswordContainsSpace(password)) {
                            if (validator.isPasswordValid(password)) {
                                if (validator.isFieldNotEmpty(secretQuestion)) {
                                    if (validator.isSecretQuestionValid(secretQuestion)) {
                                        if (validator.isFieldNotEmpty(secretAnswer)) {
                                            return "Success";
                                        } else {
                                            return "Enter the answer of your Secret Question";
                                        }
                                    } else {
                                        return "Emter your Secret Question and must end with '?'";
                                    }
                                } else {
                                    return "Enter your Secret Question";
                                }
                            } else {
                                return "Password must be at least 8 characters!";
                            }
                        } else {
                            return "Enter your Password without any space!";
                        }
                    } else {
                        return "Enter your Password";
                    }
                } else {
                    return "Email already exists!";
                }
            } else {
                return "Email is incorrect";
            }
        } else {
            return "Enter your Email Address";
        }
    }
}