package neetcode150.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParentheses_22Test {

    @Test
    void generateParenthesis() {

        GenerateParentheses_22 g = new GenerateParentheses_22();
        List<String> ls =g.generateParenthesis(3);

        for(String s: ls){
            System.out.println(s);
        }
    }
}