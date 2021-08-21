package view;

import com.controller.ControladorRequerimientosReto5;

import vo.LideresMayorSalario;
import vo.LideresProyectosEmblematicos;
import vo.MaterialRankeadoImportado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//Vista
public class VistaRequerimientosReto5 extends JFrame {
    public static final com.controller.ControladorRequerimientosReto5 controlador = new ControladorRequerimientosReto5();

    // Mitigar errores de instancias serializable
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5");
        lbltitulo.setBounds(28, 6, 61, 16);
        contentPane.add(lbltitulo);

        // Dimensiona el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        // Proporciona una vista desplazable de un componente en una ventana grafica
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Requerimiento 1");
        btnConsuta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(20, 537, 133, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Requerimiento 2");
        btnConsuta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(157, 537, 133, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Requerimiento 3");
        btnConsuta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(294, 537, 133, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1() {
        try {
            ArrayList<LideresMayorSalario> rankingLideresMayorSalarios = controlador.consultarLideresMayorSalarios();
            String salida = "*** Lideres Mayor Salario *** \n\nID_Lider\tNombre\tPrimer_Apellido\tResidencia\n\n";
            for (LideresMayorSalario lideresMayorSalario : rankingLideresMayorSalarios) {
                salida += lideresMayorSalario.getIdLider();
                salida += "\t";
                salida += lideresMayorSalario.getNombre();
                salida += "\t";
                salida += lideresMayorSalario.getPrimerApellido();
                salida += "\t\t";
                salida += lideresMayorSalario.getCiudadResidencia();
                salida += "\n";
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2() {
        try {
            ArrayList<LideresProyectosEmblematicos> rankinglLideresProyectosEmblematicos = controlador
                    .consultarLideresProyectosEmblematicos();
            String salida = "*** Poyectos Emblematicos *** \n\nID_Lider\tID_Proyecto\t\tID_Tipo\n\n";
            for (LideresProyectosEmblematicos lideresProyectosEmblematicos : rankinglLideresProyectosEmblematicos) {
                salida += lideresProyectosEmblematicos.getIdLider();
                salida += "\t";
                salida += lideresProyectosEmblematicos.getIdProyecto();
                salida += lideresProyectosEmblematicos.getIdTipo() <= 130;
                salida += lideresProyectosEmblematicos.getIdTipo() < 135;
            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3() {
        try {
            ArrayList<MaterialRankeadoImportado> rankingMaterialRankeadoImportados = controlador
                    .consultarMaterialesRankeadosImportados();
            String salida = "*** Material Rankeado Importado *** \n\nID_MaterialConstruccion\tPrecio_Unidad\tImportado\n\n";
            for (MaterialRankeadoImportado materialRankeadoImportado : rankingMaterialRankeadoImportados) {
                salida += materialRankeadoImportado.getNombreMaterial();
                salida += "\t";
                salida += materialRankeadoImportado.getPrecioUnidad() < 1800;
                salida += "\t";
                salida += materialRankeadoImportado.getImportado();
                salida += "\t";

            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}
