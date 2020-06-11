package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidTokenException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField expressionTextField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
            "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
            "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[buttonText.length];

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 28));

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button tempButtonReference;
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            tempButtonReference = new Button(buttonText[i]);
            tempButtonReference.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = tempButtonReference;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     *
     * @param actionEventObject Event object generated when a
     *                          button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {
        String buttonPressed = actionEventObject.getActionCommand();
        String text = this.expressionTextField.getText();
       if("1".equals (buttonPressed)){
           this.expressionTextField.setText(text+"1");
       }
        if("2".equals (buttonPressed)){
            this.expressionTextField.setText(text+"2");
        }
        if("3".equals (buttonPressed)){
            this.expressionTextField.setText(text+"3");
        }
        if("4".equals (buttonPressed)){
            this.expressionTextField.setText(text+"4");
        }
        if("5".equals (buttonPressed)){
            this.expressionTextField.setText(text+"5");
        }
        if("6".equals (buttonPressed)){
            this.expressionTextField.setText(text+"6");
        }
        if("7".equals (buttonPressed)){
            this.expressionTextField.setText(text+"7");
        }
        if("8".equals (buttonPressed)){
            this.expressionTextField.setText(text+"8");
        }
        if("9".equals (buttonPressed)){
            this.expressionTextField.setText(text+"9");
        }
        if("0".equals (buttonPressed)){
            this.expressionTextField.setText(text+"0");
        }
        if("+".equals (buttonPressed)){
            this.expressionTextField.setText(text+"+");
        }
        if("-".equals (buttonPressed)){
            this.expressionTextField.setText(text+"-");
        }
        if("*".equals (buttonPressed)){
            this.expressionTextField.setText(text+"*");
        }
        if("/".equals (buttonPressed)){
            this.expressionTextField.setText(text+"/");
        }
        if("C".equals (buttonPressed)){
            this.expressionTextField.setText(null);
        }
        if("CE".equals (buttonPressed)){
            this.expressionTextField.setText(text);
        }
        if("(".equals (buttonPressed)){
            this.expressionTextField.setText(text+"(");
        }
        if(")".equals (buttonPressed)){
            this.expressionTextField.setText(text+")");
        }
        if("=".equals (buttonPressed)) {
            try {
                Evaluator calculate = new Evaluator();
                this.expressionTextField.setText(Integer.toString(calculate.evaluateExpression(text)));
            }catch (InvalidTokenException e){
                this.expressionTextField.setText(null);
            }
        }
    }


}

