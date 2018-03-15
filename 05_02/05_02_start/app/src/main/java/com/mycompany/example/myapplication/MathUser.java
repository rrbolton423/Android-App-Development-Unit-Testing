package com.mycompany.example.myapplication;

public class MathUser {

    // Create a math object
    private SimpleMath math;

    // Receive and save the math object passed into the MathUser constructor
    public MathUser(SimpleMath math){
        this.math = math;
    }

    // MathUser's doSomeMath() method adds the parameters 4 and 5,
    // calling the add() method
    public void doSomeMath(){
        math.add(4,5);
    }
}
