/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
    String data = "",i;
    int a ,b;
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        BACKSPACE,   // ⌫
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL,  // MR
        MEM_CLEAR    // MC
    }
    
    public void appendDigit(int digit) {
        data += String.valueOf(digit);
        getDisplay();
    }
    
    public void appendDot() {
        // TODO code application logic here
    }
    
    public void performOperation(Operator operator) {
       switch (operator) {
            case PLUS:
               a = Integer.parseInt(data);
               data = "";
               getDisplay();
               i = "+";
                break;
            case MINUS:
               a = Integer.parseInt(data);
               data = "";
               getDisplay();
               i = "-";
                break;
            case TIMES:
               a = Integer.parseInt(data);
               data = "";
               getDisplay();
              i = "*";
                break;
            case OVER:
                a = Integer.parseInt(data);
               data = "";
               getDisplay();
               i = "/";
             case CLEAR:
               data = "";
               getDisplay();
                 break;
            case EQUAL:
           
                if(i == "+")
                {
                    b= Integer.parseInt(data);
                    data = String.valueOf(a+b);
                    System.out.print(data);
                    getDisplay();
                    data="";
                }
                 if(i == "-")
                {
                    b = Integer.parseInt(data);
                    data = String.valueOf(a-b);
                    System.out.print(data);
                    getDisplay();
                    data="";
                }
                  if(i == "*")
                {
                    b = Integer.parseInt(data);
                    data = String.valueOf(a*b);
                    System.out.print(data);
                    getDisplay();
                    data="";
                }
                   if(i == "/")
                {
                    b = Integer.parseInt(data);
                    data = String.valueOf(a/b);
                    System.out.print(data);
                    getDisplay();
                    data="";
                }
                   
                break;
        }
    }
    
    public String getDisplay() {
       setChanged();
       notifyObservers(data);
        return null;
    }
    public void  ss (String QQQQ)
    {
        if(QQQQ =="+") performOperation(Operator.PLUS);
        if(QQQQ =="-") performOperation(Operator.MINUS);
        if(QQQQ =="＊") performOperation(Operator.TIMES);
        if(QQQQ =="／") performOperation(Operator.OVER);
        if(QQQQ =="C") performOperation(Operator.CLEAR);  
        if(QQQQ =="=") performOperation(Operator.EQUAL);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Calculator model = new Calculator();
              NewJFrame view = new NewJFrame(model);
              view.setVisible(true);
              model.addObserver(view);
            }
        });
    }
    }


