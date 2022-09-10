package Model;

public class Elementoos {
    enum Elementos{ FICHAS("Ensamble, A1"), PIEZAS_METAL("Ensamble, B1"), ESFERAS("Movimiento, C1"),RUEDAS("Movimiento, C1");
        private String accion;

        public String getAccion() {
            return accion;
        }

        public void setAccion(String accion) {
            this.accion = accion;
        }

        Elementos(String accion) {
            this.accion = accion;
        }
    }
    public static void main(String[] args) {
        Elementos[] elementos = Elementos.values();
        for (Elementos elemento : elementos) {
            System.out.println("Elemento : " + elemento.name() +" -> " + elemento.getAccion() );
        }
    }
}
