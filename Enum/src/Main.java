import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int continuar;
        do {
            Calculator operacion = new Calculator();
            try {
                operacion.setOperandos(Integer.parseInt((JOptionPane.showInputDialog("Digite el primer operando"))), Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo operando")));
            } catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
            }
            int oper;
            oper = JOptionPane.showOptionDialog(
                    null, "Seleccione opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,    // null para icono por defecto.
                    new Object[]{"Sumar", "Restar", "Multiplicar", "Dividir"}, "Sumar");
            switch (oper) {
                case 0:
                    try {
                        rango(operacion.sumar());
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.sumar());
                    }catch (ExcepcionNum e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }
                        break;
                case 1:
                    try {
                        rango(operacion.restar());
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.restar());
                    }catch (ExcepcionNum e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 2:
                    try {
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.multiplicar());
                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 3:
                    try {
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.dividir());
                    } catch (ArithmeticException ae) {
                        JOptionPane.showMessageDialog(null, "Division cero", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;

            }

            continuar = JOptionPane.showConfirmDialog(null, "Quieres continuar?", "Continuacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (continuar == 0);
    }

    static void rango(int num) throws ExcepcionNum {
        if (num <0) {
            throw new ExcepcionNum("Número negativo como resultado");
        }
    }
}