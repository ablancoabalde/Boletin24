package boletin24;

import java.awt.BasicStroke;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Logica extends JFrame implements ActionListener {

    JFrame marco;
    JPanel panel1;
    JTextField caja;
    JButton boton1;
    JButton boton2;
    private static Integer circulos=0;

    public Logica() {
        marco=new JFrame("CURSO DAM");
        panel1=new JPanel();
        caja=new JTextField(6);
        boton1=new JButton("Crear Circulos");
        boton2=new JButton("Limpiar");

        marco.add(panel1);
        panel1.setSize(800, 400);

        marco.setSize(800, 400);

        panel1.add(boton1);
        panel1.add(boton2);
        panel1.add(caja);

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(marco);
        marco.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i=0; i<circulos; i++) {

            Graphics2D circulo=(Graphics2D) g;
            circulo.setStroke(new BasicStroke(10.f));
            circulo.setPaint(Color.RED);
            float diametro=5*2;
            circulo.drawOval(getRandomPosition(0, 390), getRandomPosition(100, 390), (int) diametro, (int) diametro);
        }

    }

    public int getRandomPosition(int min, int max) {

        return (int) (Math.random()*(max-min)+min);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circulos=Integer.parseInt(caja.getText());
        JButton boton=(JButton) e.getSource();
        Graphics g=panel1.getGraphics();
        if (boton!=boton1) {
            circulos=0;
            caja.setText("");
            panel1.paint(g);
        } else {
            for (int i=0; i<circulos; i++) {

                Graphics2D circulo=(Graphics2D) g;
                circulo.setStroke(new BasicStroke(10.f));
                circulo.setPaint(Color.RED);
                float diametro=5*2;
                circulo.drawOval(getRandomPosition(0, 390), getRandomPosition(100, 390), (int) diametro, (int) diametro);
            }
        }

    }

}
