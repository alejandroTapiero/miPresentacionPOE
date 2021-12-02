package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton mifoto, mihobby, misexpectativas;
    private JPanel panelBotones, panelDatos, panelMouse;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Titulos titulo;
    private Escucha escucha;
    private Boolean bool;


    //metodos
    public GUI_Presentacion(){
        initGUI();
        //Configuracion base de la ventana
        this.setTitle("Mi Presentacion");
        this.setSize(600, 540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI() {
        //A definir Container & Layout de JFrame
        //Crear objetos de Escucha y Control
        escucha = new Escucha();
        //Configurar JComponents
        titulo = new Titulos("Hola, soy Alejandro.", Color.BLUE);
        this.add(titulo, BorderLayout.NORTH);

        panelMouse = new JPanel();
        panelMouse.addMouseListener(escucha);
        panelMouse.addKeyListener(escucha);
        panelMouse.setPreferredSize(new Dimension(500,500));
        panelMouse.setFocusable(true);
        add(panelMouse, BorderLayout.CENTER);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Click para quién soy, doble click para mis hobbies, y pulsa M para mis expectativas",
                             TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                             new Font("Calibri", Font.PLAIN, 15), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        mifoto = new JButton("Este soy yo");
        mifoto.addActionListener(escucha);
        mihobby = new JButton ("Este es mi Hobby");
        mihobby.addActionListener(escucha);
        misexpectativas = new JButton ("Yo creo que...");
        misexpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(mifoto);
        panelBotones.add(mihobby);
        panelBotones.add(misexpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(4,12);
        bool = false;
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUI_Presentacion = new GUI_Presentacion();
            }
        });

    }

    private class Escucha implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //Confirmación de oprimir botón:
            //JOptionPane.showMessageDialog(null, "Mensaje orpimido");
            panelDatos.removeAll();
            if(e.getSource()==mifoto & bool == true){
                image = new ImageIcon(getClass().getResource("/recursos/foto.png"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }
            else{
                if(e.getSource()==mihobby & bool == true){
                    image = new ImageIcon(getClass().getResource("/recursos/hobby.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
                else{
                    if(bool == true){
                        textoExpectativas.setText("\n" + "Tengo relativamente poca experiencia programando en Java, \n" +
                                "pero al menos espero poder aprender tanto de sus funciones \n" +
                                "como de su práctica y de las experiencias compartidas \n" +
                                "sobre el mundo de la programación.");
                        textoExpectativas.setBackground(null);
                        textoExpectativas.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
                        panelDatos.add(textoExpectativas);
                    }
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1){
                bool = true;
            }
            else{
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    bool = true;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar()== KeyEvent.VK_M){
                bool = true;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
