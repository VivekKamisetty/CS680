package edu.umb.cs680.hw09;

interface State {

    void login(EncryptedString pwd);
    void logout();
}
