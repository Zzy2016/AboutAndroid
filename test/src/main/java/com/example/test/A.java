package com.example.test;

public class A {

    public void setOnClickListener(OnClickListener1 onClickListener){
        onClickListener.onClick();
    }

    public interface OnClickListener1{
        public void onClick();
    }
}
