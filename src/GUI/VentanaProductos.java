package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Ventana gráfica para el Registro y Gestión de Productos e Inventario.
 */
public class VentanaProductos extends JFrame {//inicio clase

    private final Color AZUL_PETROLEO = new Color(27, 59, 72);
    private final Color ARENA_CALIDO = new Color(247, 245, 242);
    private final Color AMBAR_OCRE = new Color(217, 155, 38);
    private final Color ESPRESSO = new Color(44, 34, 30);

    private JTextField txtNombreProducto;
    private JTextField txtCodigoProducto;
    private JComboBox<String> cbTipoProducto;
    private JTextField txtStockActual;
    private JTextField txtPrecioUnitario;
    private JTextArea txtDescripcion;
    private JButton btnGuardarProducto;
    private JButton btnLimpiar;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    public VentanaProductos() {//inicio constructor
        setTitle("FideCompro - Gestión de Productos");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
    }//fin constructor

    private void inicializarComponentes() {//inicio inicializar
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(ARENA_CALIDO);

        JLabel lblTitulo = new JLabel("Registro de Productos");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(AZUL_PETROLEO);
        lblTitulo.setBounds(30, 20, 300, 25);
        panelPrincipal.add(lblTitulo);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(30, 65, 390, 40);
        txtNombreProducto.setBackground(Color.WHITE);
        txtNombreProducto.setForeground(ESPRESSO);
        txtNombreProducto.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Nombre del producto"
            )
        );
        panelPrincipal.add(txtNombreProducto);

        txtCodigoProducto = new JTextField();
        txtCodigoProducto.setBounds(440, 65, 390, 40);
        txtCodigoProducto.setBackground(Color.WHITE);
        txtCodigoProducto.setForeground(ESPRESSO);
        txtCodigoProducto.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Código del producto"
            )
        );
        panelPrincipal.add(txtCodigoProducto);

        String[] tipos = {
            "Seleccionar tipo...", "Alimentos", 
            "Bebidas", "Limpieza", "Higiene", "Otros"
        };
        cbTipoProducto = new JComboBox<>(tipos);
        cbTipoProducto.setBounds(30, 120, 390, 40);
        cbTipoProducto.setBackground(Color.WHITE);
        cbTipoProducto.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Tipo de producto"
            )
        );
        panelPrincipal.add(cbTipoProducto);

        txtStockActual = new JTextField();
        txtStockActual.setBounds(440, 120, 390, 40);
        txtStockActual.setBackground(Color.WHITE);
        txtStockActual.setForeground(ESPRESSO);
        txtStockActual.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Stock actual"
            )
        );
        panelPrincipal.add(txtStockActual);

        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setBounds(30, 175, 390, 40);
        txtPrecioUnitario.setBackground(Color.WHITE);
        txtPrecioUnitario.setForeground(ESPRESSO);
        txtPrecioUnitario.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Precio unitario"
            )
        );
        panelPrincipal.add(txtPrecioUnitario);

        txtDescripcion = new JTextArea();
        JScrollPane scrollDesc = new JScrollPane(txtDescripcion);
        scrollDesc.setBounds(440, 175, 390, 65);
        scrollDesc.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Descripción (opcional)"
            )
        );
        panelPrincipal.add(scrollDesc);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(230, 250, 190, 35);
        btnLimpiar.setBackground(new Color(210, 205, 195));
        btnLimpiar.setForeground(ESPRESSO);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpiar.setFocusPainted(false);
        panelPrincipal.add(btnLimpiar);

        btnGuardarProducto = new JButton("Guardar producto");
        btnGuardarProducto.setBounds(440, 250, 390, 35);
        btnGuardarProducto.setBackground(AMBAR_OCRE);
        btnGuardarProducto.setForeground(ESPRESSO);
        btnGuardarProducto.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardarProducto.setFocusPainted(false);
        panelPrincipal.add(btnGuardarProducto);

        JLabel lblSubLista = new JLabel("Lista de Productos");
        lblSubLista.setFont(new Font("Arial", Font.BOLD, 14));
        lblSubLista.setForeground(AZUL_PETROLEO);
        lblSubLista.setBounds(30, 305, 200, 20);
        panelPrincipal.add(lblSubLista);

        String[] columnas = {
            "ID", "Nombre", "Tipo", 
            "Precio unitario", "Stock", "Acciones"
        };
        Object[][] datos = {
            {
                "1", "Café en grano 1kg", "Alimentos", 
                "¢ 2,500.00", "50", "Editar / Eliminar"
            },
            {
                "2", "Refresco 600ml", "Bebidas", 
                "¢ 1,200.00", "120", "Editar / Eliminar"
            },
            {
                "3", "Detergente líquido 1L", "Limpieza", 
                "¢ 1,800.00", "35", "Editar / Eliminar"
            }
        };

        modeloTabla = new DefaultTableModel(datos, columnas);
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setBounds(30, 335, 800, 260);
        panelPrincipal.add(scrollTabla);

        add(panelPrincipal, BorderLayout.CENTER);
    }//fin inicializar

    public static void main(String[] args) {//inicio main
        SwingUtilities.invokeLater(() -> {//inicio lambda
            new VentanaProductos().setVisible(true);
        });//fin lambda
    }//fin main

}//fin clase