package edu.umb.cs680.hw04;

interface State {
	
	void login(EncryptedString pwd);
	void logout();
}
