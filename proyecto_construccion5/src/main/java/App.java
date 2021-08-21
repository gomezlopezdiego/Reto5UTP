import java.awt.EventQueue;

import view.VistaRequerimientosReto5;

public class App {
    public static void main(String[] args) {

        // Ejecutar Swing en otro hilo
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    VistaRequerimientosReto5 frame = new VistaRequerimientosReto5();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }

}
