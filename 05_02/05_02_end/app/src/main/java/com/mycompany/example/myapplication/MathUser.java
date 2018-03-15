package com.mycompany.example.myapplication;

public class MathUser {

    private SimpleMath math;

    public MathUser(SimpleMath math){
        this.math = math;
    }

    public void doSomeMath(){
        math.add(4,5);
    }
}
