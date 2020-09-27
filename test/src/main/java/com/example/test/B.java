package com.example.test;

public class B {
    public static void main(String[] args) {
        A a=new A();
        a.setOnClickListener(new A.OnClickListener1() {
            @Override
            public void onClick() {

            }
        });
    }
}
