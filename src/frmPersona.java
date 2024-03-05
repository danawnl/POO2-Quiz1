import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class frmPersona extends JFrame implements ActionListener {
    //todo############-Atributos-############
    //Constantes
    int X=40, Y=10, width=100, espaciadoY=40; //Espaciado>=30px
    //Labels
    static JLabel llPropietario, llDocumento, llNombre, llApellido,llEdad,ll_idPropietario, llStateUser, llNoti;
    //Text fields
    static JTextField txDocumento, txNombre, txApellido, txEdad, tx_idPropietario;
    //Buttons
    static JButton btnGuardar, btnBuscar, btnListar;
    //Img
    static ImageIcon imgUser;
    //Statics classes
    static frmPersona ventana;
    static frmBuscar ventanaBuscar;
    public static frmListar ventanaListar;

    //ArrayList
    static ArrayList<Propietario> listPropietarios=new ArrayList<>();

    //todo############-Constructor-############
    public frmPersona(){
        //Creación de ventanas extranjeras
        ventanaBuscar=new frmBuscar();
        ventanaListar=new frmListar();

        //Creación de elementos (Y=Yanterior+40)
        llPropietario=new JLabel("PROPIETARIO");
        llPropietario.setBounds(X-20,Y,width,30);
        llDocumento=new JLabel("Documento");
        llDocumento.setBounds(X,Y+espaciadoY,width,30);
        llNombre=new JLabel("Nombre");
        llNombre.setBounds(X,Y+espaciadoY*2,width,30);
        llApellido=new JLabel("Apellido");
        llApellido.setBounds(X,Y+espaciadoY*3,width,30);
        llEdad=new JLabel("Edad");
        llEdad.setBounds(X,Y+espaciadoY*4,width,30);
        ll_idPropietario=new JLabel("Id propietario");
        ll_idPropietario.setBounds(X,Y+espaciadoY*5,width,30);
        llNoti=new JLabel("Datos sin guardar");
        llNoti.setBounds(300,Y+espaciadoY*5,width,30);

        txDocumento=new JTextField();
        txDocumento.setBounds(X*4,Y+espaciadoY,width,30);
        txNombre=new JTextField();
        txNombre.setBounds(X*4,Y+espaciadoY*2,width,30);
        txApellido=new JTextField();
        txApellido.setBounds(X*4,Y+espaciadoY*3,width,30);
        txEdad=new JTextField();
        txEdad.setBounds(X*4,Y+espaciadoY*4,width,30);
        tx_idPropietario=new JTextField();
        tx_idPropietario.setBounds(X*4,Y+espaciadoY*5,width,30);

        imgUser=new ImageIcon(".\\IMG\\User.png");
        llStateUser=new JLabel(imgUser);
        llStateUser.setLocation(300,40);
        llStateUser.setSize(imgUser.getIconWidth(),imgUser.getIconHeight());

        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(300,Y+espaciadoY*4,imgUser.getIconWidth(),30);
        btnGuardar.setBackground(Color.cyan);
        btnGuardar.addActionListener(this);

        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(X,Y+espaciadoY*7,100,30);
        btnBuscar.addActionListener(this);

        btnListar=new JButton("Listar");
        btnListar.setBounds(X*4,Y+espaciadoY*7,100,30);
        btnListar.addActionListener(this);

        //Añadir elementos
        add(llPropietario);
        add(llDocumento);
        add(llNombre);
        add(llApellido);
        add(llEdad);
        add(ll_idPropietario);
        add(txDocumento);
        add(txNombre);
        add(txApellido);
        add(txEdad);
        add(tx_idPropietario);
        add(llStateUser);
        add(btnGuardar);
        add(btnBuscar);
        add(btnListar);
        add(llNoti);

        //Creación de ventana
        setLayout(null);
        setSize(500,500);
        setTitle("Registro propietario");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }
    //todo############-Action Listener-############
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnGuardar)){
            int  docProp=Integer.parseInt(txDocumento.getText());
            String nombProp=txNombre.getText();
            String apeProp=txApellido.getText();
            int edadProp=Integer.parseInt(txEdad.getText());
            String idProp=tx_idPropietario.getText();
            listPropietarios.add(new Propietario(docProp,nombProp,apeProp,edadProp,idProp));
            llNoti.setText("¡Datos guardados!");

            ventanaListar.actualizarTabla(listPropietarios);

        }
        if (e.getSource().equals(btnListar)){
            ventanaListar.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnBuscar)){
            ventanaBuscar.setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args)  {
        ventana=new frmPersona();
        ventana.setVisible(true);
        ventana.getContentPane().setBackground(Color.lightGray);
    }
}