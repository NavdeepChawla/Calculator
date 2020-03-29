package com.navdeep.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity
{
    private Button zero,one,two,three,four,five,six,seven,eight,nine;
    private Button plus,minus,multiply,divide,dot;
    private Button leftBracket,rightBracket,equal,clear,delete;
    private TextView equation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewById();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null) {
            String eqn;
            eqn = bundle.getString("eqn", null);
            if (!(eqn == null)) {
                equation.setText(eqn);
            }
        }
        onclickListeners();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finish();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
           Intent intent=new Intent(MainActivity.this,MainActivity.class);
            String temp=equation.getText().toString();
            if(!temp.isEmpty())
            {
                intent.putExtra("eqn",temp);
            }
            startActivity(intent);
            super.onConfigurationChanged(newConfig);
    }

    void FindViewById()
    {
        zero=findViewById(R.id.buttonZero);
        one=findViewById(R.id.buttonOne);
        two=findViewById(R.id.buttonTwo);
        three=findViewById(R.id.buttonThree);
        four=findViewById(R.id.buttonFour);
        five=findViewById(R.id.buttonFive);
        six=findViewById(R.id.buttonSix);
        seven=findViewById(R.id.buttonSeven);
        eight=findViewById(R.id.buttonEight);
        nine=findViewById(R.id.buttonNine);

        plus=findViewById(R.id.buttonPlus);
        minus=findViewById(R.id.buttonMinus);
        multiply=findViewById(R.id.buttonMultiply);
        divide=findViewById(R.id.buttonDivide);

        leftBracket=findViewById(R.id.buttonLeftBracket);
        rightBracket=findViewById(R.id.buttonRightBracket);
        equal=findViewById(R.id.buttonEqual);
        clear=findViewById(R.id.buttonClear);
        delete=findViewById(R.id.buttonDelete);
        dot=findViewById(R.id.buttonDot);

        equation=findViewById(R.id.editTextEquation);
    }


    void onclickListeners()
    {
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"0";
                equation.setText(temp);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"1";
                equation.setText(temp);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"2";
                equation.setText(temp);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"3";
                equation.setText(temp);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"4";
                equation.setText(temp);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"5";
                equation.setText(temp);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"6";
                equation.setText(temp);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"7";
                equation.setText(temp);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"8";
                equation.setText(temp);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"9";
                equation.setText(temp);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"+";
                equation.setText(temp);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"-";
                equation.setText(temp);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"*";
                equation.setText(temp);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"/";
                equation.setText(temp);
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+".";
                equation.setText(temp);
            }
        });


        leftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+"(";
                equation.setText(temp);
            }
        });

        rightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                temp=temp+")";
                equation.setText(temp);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eqn=equation.getText().toString();
                String ans=Calculate(eqn);
                equation.setText(ans);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.setText(null);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp=equation.getText().toString();
                if(!temp.isEmpty()) {
                    int length = temp.length();
                    length = length - 1;
                    temp = (String) temp.subSequence(0, length);
                    equation.setText(temp);
                }
            }
        });
    }

    //Logic Using Rhino Dependency
    String Calculate(String eqn)
    {
        String ans="";
        Double answer;
        Object[] functionParams = new Object[]{eqn};
        String script = "function evaluate(arithmetic){  return eval(arithmetic)    ;} ";
        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();
            rhino.evaluateString(scope, script , "JavaScript", 1, null);
            Function function = (Function) scope.get("evaluate", scope);
            answer = (Double) function.call(rhino, scope, scope, functionParams);
            ans=Double.toString(answer);
            return ans;
        }
        catch (RhinoException e)
        {
            e.printStackTrace();
        }
        finally
        {
            Context.exit();
        }
        return ans;
    }
}

//Stack Logic
/*
    String Calculate(String equation)
    {
        final String postfix = infixToPostfix(equation);
        final String answer=postfixToInfix(postfix);
        return answer;
    }

    String postfixToInfix(String postfix)
    {
        Stack<Integer> answer=new Stack<>();
        char c;
        for(int i=0;i<postfix.length();i++)
        {
            c=postfix.charAt(i);
            if(!isOperator(c))
            {
                int ch=0;
                int value=0;
                while(ch==0)
                {
                    value=value*10+(c-48);
                    i++;
                    c=postfix.charAt(i);
                    if(c==' ')
                    {
                        ch=1;
                    }
                }
                System.out.println(value);
                answer.push(value);
            }
            else if(isOperator(c))
            {
                int val1=answer.pop();
                int val3=0;
                int val2=0;
                if(!answer.empty()) {
                    val2 = answer.pop();
                    switch (c) {
                        case '+':
                            val3 = val2 + val1;
                            break;
                        case '-':
                            val3 = val2 - val1;
                            break;
                        case '*':
                            val3 = val2 * val1;
                            break;
                        case '/':
                            val3 = val2 / val1;
                            break;
                        case '^':
                            val3 = 1;
                            for (int j = 0; j < val1; j++)
                                val3 *= val2;
                            break;
                    }
                }
                else{
                    val3=-val1;
                }
                answer.push(val3);
            }
        }
        String infix=Integer.toString(answer.pop());
        return infix;
    }


    String infixToPostfix(String infix)
    {
        Stack<Character> stack = new Stack<Character>();
        String postfix = "";
        char c;

        for (int i = 0; i < infix.length(); i++)
        {
            c = infix.charAt(i);

            if (!isOperator(c))
            {
                String operand="";
                int ch=0;
                int value=0;
                while(ch==0)
                {
                    value=value*10+(c-48);
                    i++;
                    if(i<infix.length())
                    {
                        c = infix.charAt(i);
                        if (isOperator(c))
                        {
                            i--;
                            ch=1;
                        }
                    }
                    else
                    {
                        i--;
                        ch=1;
                    }
                }
                operand=Integer.toString(value);
                postfix=postfix+operand+" ";
            }

            else
            {
                if (c == ')')
                {

                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        postfix+=(stack.pop());
                    }
                    if (!stack.isEmpty())
                    {
                        stack.pop();
                    }
                }

                else
                {
                    if (!stack.isEmpty() && !isLowerPrecedence(c, stack.peek()))
                    {
                        stack.push(c);
                    }
                    else
                    {
                        while (!stack.isEmpty() && isLowerPrecedence(c, stack.peek()))
                        {
                            Character pop = stack.pop();
                            if (c != '(')
                            {
                                if(pop!='('){
                                    postfix+=(pop);
                                }
                            }
                            else{
                                    c = pop;
                                }
                        }
                        stack.push(c);
                    }

                }
            }
        }
        while (!stack.isEmpty()) {
            postfix+=stack.pop();
        }
        return postfix.toString();
    }

    boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
                || c == '(' || c == ')';
    }

    boolean isLowerPrecedence(char op1, char op2)
    {
        switch (op1)
        {
            case '+':
            case '-':
                return !(op2 == '+' || op2 == '-');

            case '*':
            case '/':
                return op2 == '^' || op2 == '(';

            case '^':
                return op2 == '(';

            case '(':
                return true;

            default:
                return false;
        }
    }*/
