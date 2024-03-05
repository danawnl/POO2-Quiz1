import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class frmBuscar extends JFrame implements ActionListener {
    //todo############-Atributos-############
    //Buttons
    static JButton btnRegresar;

    //todo############-Action Listener-############
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)){
            frmPersona.ventana.setVisible(true);
            this.setVisible(false);
        }
    }

    //todo############-Constructor-############
    public frmBuscar(){
        //Creación de elementos
        btnRegresar=new JButton("Regresar");
        btnRegresar.setBounds(20,10,100,30);
        btnRegresar.addActionListener(this);

        //Añadir elementos
        add(btnRegresar);

        //Creación de ventana
        setLayout(null);
        setSize(500,500);
        setTitle("Buscar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.lightGray);


    }

}
