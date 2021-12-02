package miPresentacion;

import javax.swing.*;
import java.awt.*;

public class Titulos extends JLabel{
    public Titulos(String titulo, Color colorFondo){
        this.setText(titulo);
        this.setBackground(colorFondo);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.DIALOG, Font.BOLD+Font.ITALIC, 20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }

    public Titulos() {

    }
}
