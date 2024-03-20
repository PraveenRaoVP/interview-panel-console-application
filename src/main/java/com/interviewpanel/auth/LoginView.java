package com.interviewpanel.auth;

import com.interviewpanel.InterviewPanelApplication;
import com.interviewpanel.MainMenu.MainMenuView;

import java.util.Scanner;

public class LoginView {
    private final LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    public void init() {
        loginModel.initLogin();
    }

    public void loginDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login:-");
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        if(loginModel.authenticateUser(username, password)){
            onLoginSuccess();
            System.exit(0);
        }
    }

    public void onLoginSuccess() {
        // proceed to main menu
        System.out.flush();
        System.out.println("Login successful");
        System.out.println("Welcome to the " + InterviewPanelApplication.getInstance().getAppName() + " v" + InterviewPanelApplication.getInstance().getAppVersion());

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.mainMenu();
    }
}
