package com.example.inew.Registeration;

 interface IRegistPresenter {
    void createNewUser(String email,String Password);
    void updateUserToFireBase(String email,String password);
     void intializeFields();
}
