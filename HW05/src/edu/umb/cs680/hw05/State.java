package edu.umb.cs680.hw05;

interface State {
	
	void login(EncryptedString pwd);
	void logout();
}
