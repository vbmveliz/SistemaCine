package ui;

import modelos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.time.LocalTime;

public class VentanaCine extends JFrame {

    private JComboBox<Funcion> comboFunciones;

    private JTextArea area;

    private JPanel panelBotones;

    private JLabel titulo;

    private Funcion funcionActual;

    public VentanaCine() {

        setTitle("Sistema Cine");

        setSize(1200, 750);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // ========= SALAS =========

        SalaVIP vip1 = new SalaVIP("VIP 1", 10);

        SalaVIP vip2 = new SalaVIP("VIP 2", 10);

        SalaNormal normal1 = new SalaNormal("Normal 1", 10);

        SalaNormal normal2 = new SalaNormal("Normal 2", 10);

        // ========= PELÍCULAS =========

        Pelicula avengers = new Pelicula("Avengers", 120);

        Pelicula batman = new Pelicula("Batman", 110);

        Pelicula spiderman = new Pelicula("Spiderman", 130);

        Pelicula thor = new Pelicula("Thor", 100);

        // ========= FUNCIONES =========

        Funcion f1 = new Funcion(
                avengers,
                vip1,
                LocalTime.of(20, 0),
                LocalTime.of(22, 0)
        );

        Funcion f2 = new Funcion(
                batman,
                vip2,
                LocalTime.of(22, 30),
                LocalTime.of(0, 20)
        );

        Funcion f3 = new Funcion(
                spiderman,
                normal1,
                LocalTime.of(18, 0),
                LocalTime.of(20, 10)
        );

        Funcion f4 = new Funcion(
                thor,
                normal2,
                LocalTime.of(21, 0),
                LocalTime.of(22, 40)
        );

        funcionActual = f1;

        // ========= COMBO FUNCIONES =========

        comboFunciones = new JComboBox<>();

        comboFunciones.addItem(f1);

        comboFunciones.addItem(f2);

        comboFunciones.addItem(f3);

        comboFunciones.addItem(f4);

        comboFunciones.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                funcionActual =
                        (Funcion) comboFunciones.getSelectedItem();

                actualizarVista();
            }
        });

        add(comboFunciones, BorderLayout.NORTH);

        // ========= TÍTULO =========

        titulo = new JLabel("", SwingConstants.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        add(titulo, BorderLayout.SOUTH);

        // ========= PANEL ASIENTOS =========

        panelBotones = new JPanel();

        add(panelBotones, BorderLayout.CENTER);

        // ========= LOG =========

        area = new JTextArea();

        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        scroll.setPreferredSize(new Dimension(350, 700));

        add(scroll, BorderLayout.EAST);

        actualizarVista();
    }

    private void actualizarVista() {

        Sala salaActual = funcionActual.getSala();

        titulo.setText(
                "Película: "
                + funcionActual.getPelicula().getNombre()
                + " | Sala: "
                + salaActual.getNombre()
                + " | Precio: S/. "
                + salaActual.getPrecio()
                + " | Horario: "
                + funcionActual.getInicio()
                + " - "
                + funcionActual.getFin()
        );

        panelBotones.removeAll();

        panelBotones.setLayout(new GridLayout(2, 5, 10, 10));

        for(Asiento a : salaActual.getAsientos()) {

            JButton boton = new JButton("A" + a.getNumero());

            boton.setFont(new Font("Arial", Font.BOLD, 18));

            boton.setFocusPainted(false);

            // ESTADO
            if(a.isOcupado()) {

                boton.setBackground(Color.RED);

                boton.setEnabled(false);
            }
            else {

                boton.setBackground(Color.GREEN);
            }

            boton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    if(!a.isOcupado()) {

                        a.reservar();

                        boton.setBackground(Color.RED);

                        boton.setEnabled(false);

                        area.append(
                                "Reservado asiento "
                                + a.getNumero()
                                + " | "
                                + funcionActual.getPelicula().getNombre()
                                + " | "
                                + salaActual.getNombre()
                                + "\n"
                        );

                        // BLOQUEO SEGÚN DURACIÓN
                        Timer timer = new Timer(
                                funcionActual.getDuracionMilis(),
                                new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        a.liberar();

                                        boton.setBackground(Color.GREEN);

                                        boton.setEnabled(true);

                                        area.append(
                                                "Asiento "
                                                + a.getNumero()
                                                + " liberado | "
                                                + salaActual.getNombre()
                                                + "\n"
                                        );
                                    }
                                }
                        );

                        timer.setRepeats(false);

                        timer.start();
                    }
                }
            });

            panelBotones.add(boton);
        }

        panelBotones.revalidate();

        panelBotones.repaint();
    }
}