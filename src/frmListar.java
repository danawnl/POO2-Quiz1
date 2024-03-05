import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmListar extends JFrame implements ActionListener {
    //todo############-Atributos-############
    static JTable tabla;
    static DefaultTableModel model;
    static JScrollPane scrollpane;
    //Buttons
    static JButton btnRegresar2;

    //todo############-Action Listener-############
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar2)){
            frmPersona.ventana.setVisible(true);
            this.setVisible(false);
        }
    }

    //todo############-Constructor-############
    public frmListar(){
        //Creación de elementos
        btnRegresar2=new JButton("Regresar");
        btnRegresar2.setBounds(20,10,100,30);
        btnRegresar2.addActionListener(this);
        model = new DefaultTableModel();
        tabla = new JTable(model);

        //Añadir elementos
        model.addColumn("Documento: ");
       model.addColumn("Nombre: ");
       model.addColumn("Apellido: ");
       model.addColumn("Edad: ");
        scrollpane = new JScrollPane(tabla);
        scrollpane.setLocation(40, 80);
        scrollpane.setSize(300, 300);
        add(btnRegresar2);
        this.add(scrollpane, "Center");
        Color c = new Color(217, 217, 214);
        this.getContentPane().setBackground(c);
        this.setLayout((LayoutManager)null);
        this.setSize(450, 350);

        this.setTitle("Lista de Propietarios");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(300, 200);

        LlenarTabla();

        //Crear ventana
        setLayout(null);
        setSize(500,500);
        setTitle("Listar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);
    }
    public void LlenarTabla(){
        DefaultTableModel model= new DefaultTableModel(new String[]{"Documento","Nombre","Apellido","Edad","ID"},frmPersona.listPropietarios.size());
        tabla.setModel(model);

        TableModel modeloDatos= tabla.getModel();
        for (int i = 0; i < frmPersona.listPropietarios.size(); i++) {
            Propietario propietario= frmPersona.listPropietarios.get(i);
            modeloDatos.setValueAt(propietario.getDocumento(),i,0);
            modeloDatos.setValueAt(propietario.getNombre(),i,1);
            modeloDatos.setValueAt(propietario.getApellido(),i,2);
            modeloDatos.setValueAt(propietario.getEdad(),i,3);
            modeloDatos.setValueAt(propietario.getIdPropietario(),i,4);
        }

    }
    public void actualizarTabla(ArrayList<Propietario> listaPropietarios) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        for (Propietario propietario : listaPropietarios) {
            model.addRow(new Object[]{propietario.getDocumento(), propietario.getNombre(), propietario.getApellido(), propietario.getEdad(), propietario.getIdPropietario()});
        }
    }

}




