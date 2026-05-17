package ui;

import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import modelos.Asiento;
import modelos.Director;
import modelos.Genero;
import modelos.Pelicula;
import modelos.Persona;
import modelos.SalaNormal;
import modelos.SalaVIP;
import procesos.CineService;

public class VentanaCine extends JFrame {

    private static final long serialVersionUID = 1L;

    // =========================
    // COMPONENTES PELICULAS
    // =========================
    private JTextField txtNombre;
    private JTextField txtDirector;

    private JComboBox<String> comboDuracion;
    private JComboBox<Genero> comboGenero;

    private JButton btnAgregar;
    private JButton btnMostrar;

    // =========================
    // COMPONENTES CLIENTES
    // =========================
    private JTextField txtCliente;
    private JTextField txtApellido;

    private JButton btnSalaNormal;
    private JButton btnSalaVIP;
    private JButton btnMostrarReservas;

    // =========================
    // AREAS
    // =========================
    private JEditorPane areaPeliculas;
    private JEditorPane areaReservas;

    // =========================
    // SERVICIO
    // =========================
    private CineService service;

    // =========================
    // SALAS
    // =========================
    private SalaNormal salaNormal;
    private SalaVIP salaVIP;

    // =========================
    // CLIENTES
    // =========================
    private HashMap<Integer, Persona> clientesNormal;
    private HashMap<Integer, Persona> clientesVIP;

    // =========================
    // CONSTRUCTOR
    // =========================
    public VentanaCine() {

        service = new CineService();

        clientesNormal = new HashMap<>();
        clientesVIP = new HashMap<>();

        salaNormal = new SalaNormal(1, 20);
        salaVIP = new SalaVIP(2, 10, 15);

        service.agregarSala(salaNormal);
        service.agregarSala(salaVIP);

        setTitle("🎬 SISTEMA CINE VIP");
        setSize(1650, 950);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciarComponentes();
        eventos();
    }

    // =========================
    // INTERFAZ
    // =========================
    private void iniciarComponentes() {

        getContentPane().setBackground(new Color(15, 15, 15));
        setLayout(new BorderLayout(15, 15));

        // =====================================
        // PANEL IZQUIERDO
        // =====================================
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(15, 15, 15));
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setPreferredSize(new Dimension(520, 900));

        // =====================================
        // MODULO PELICULAS
        // =====================================
        JPanel panelPeliculas =
                crearPanelModulo("🎬 MODULO PELICULAS");

        txtNombre = crearTextField();
        txtDirector = crearTextField();

        comboDuracion = new JComboBox<>(new String[] {

                "30 min",
                "45 min",
                "60 min",
                "1h 15 min",
                "1h 30 min",
                "1h 45 min",
                "2h",
                "2h 15 min",
                "2h 30 min",
                "2h 45 min",
                "3h"

        });

        estilizarCombo(comboDuracion);

        comboGenero = new JComboBox<>(Genero.values());
        estilizarCombo(comboGenero);

        btnAgregar =
                crearBoton("Agregar Película");

        btnMostrar =
                crearBoton("Mostrar Películas");

        panelPeliculas.add(crearLabel("Película"));
        panelPeliculas.add(txtNombre);

        panelPeliculas.add(Box.createVerticalStrut(15));

        panelPeliculas.add(crearLabel("Director"));
        panelPeliculas.add(txtDirector);

        panelPeliculas.add(Box.createVerticalStrut(15));

        panelPeliculas.add(crearLabel("Duración"));
        panelPeliculas.add(comboDuracion);

        panelPeliculas.add(Box.createVerticalStrut(15));

        panelPeliculas.add(crearLabel("Género"));
        panelPeliculas.add(comboGenero);

        panelPeliculas.add(Box.createVerticalStrut(25));

        panelPeliculas.add(btnAgregar);

        panelPeliculas.add(Box.createVerticalStrut(15));

        panelPeliculas.add(btnMostrar);

        // =====================================
        // MODULO RESERVAS
        // =====================================
        JPanel panelReservas =
                crearPanelModulo("🎟 MODULO RESERVAS");

        txtCliente = crearTextField();
        txtApellido = crearTextField();

        btnSalaNormal =
                crearBoton("Sala Normal");

        btnSalaVIP =
                crearBoton("Sala VIP");

        btnMostrarReservas =
                crearBoton("Mostrar Reservas");

        panelReservas.add(crearLabel("Cliente"));
        panelReservas.add(txtCliente);

        panelReservas.add(Box.createVerticalStrut(15));

        panelReservas.add(crearLabel("Apellido"));
        panelReservas.add(txtApellido);

        panelReservas.add(Box.createVerticalStrut(25));

        panelReservas.add(btnSalaNormal);

        panelReservas.add(Box.createVerticalStrut(15));

        panelReservas.add(btnSalaVIP);

        panelReservas.add(Box.createVerticalStrut(15));

        panelReservas.add(btnMostrarReservas);

        // =====================================
        // AGREGAR PANELES
        // =====================================
        panelIzquierdo.add(panelPeliculas);
        panelIzquierdo.add(Box.createVerticalStrut(25));
        panelIzquierdo.add(panelReservas);

        // =====================================
        // CARTELERA
        // =====================================
        areaPeliculas = new JEditorPane();
        areaPeliculas.setContentType("text/html");
        areaPeliculas.setEditable(false);

        areaPeliculas.setBackground(new Color(8, 8, 8));
        areaPeliculas.setForeground(Color.WHITE);

        areaPeliculas.setFont(
                new Font("Consolas", Font.PLAIN, 18)
        );

        JScrollPane scrollPeliculas =
                new JScrollPane(areaPeliculas);

        scrollPeliculas.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(255, 215, 0), 3
                        ),
                        "🎞 CARTELERA",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 24),
                        Color.WHITE
                )
        );

        // =====================================
        // RESERVAS
        // =====================================
        areaReservas = new JEditorPane();
        areaReservas.setContentType("text/html");
        areaReservas.setEditable(false);

        areaReservas.setBackground(new Color(8, 8, 8));
        areaReservas.setForeground(Color.WHITE);

        areaReservas.setFont(
                new Font("Consolas", Font.PLAIN, 18)
        );

        JScrollPane scrollReservas =
                new JScrollPane(areaReservas);

        scrollReservas.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(0, 255, 255), 3
                        ),
                        "🎟 RESERVAS CLIENTES",
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font("Arial", Font.BOLD, 24),
                        Color.WHITE
                )
        );

        // =====================================
        // PANEL DERECHO
        // =====================================
        JPanel panelDerecho = new JPanel(
                new GridLayout(1, 2, 15, 15)
        );

        panelDerecho.setBackground(
                new Color(15, 15, 15)
        );

        panelDerecho.add(scrollPeliculas);
        panelDerecho.add(scrollReservas);

        // =====================================
        // AGREGAR TODO
        // =====================================
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    // =========================
    // EVENTOS
    // =========================
    private void eventos() {

        btnAgregar.addActionListener(e -> {

            if(txtNombre.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese nombre de película"
                );

                return;
            }

            if(txtDirector.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese director"
                );

                return;
            }

            try {

                String nombre =
                        txtNombre.getText();

                String director =
                        txtDirector.getText();

                String duracion =
                        comboDuracion
                                .getSelectedItem()
                                .toString();

                Genero genero =
                        (Genero)
                                comboGenero.getSelectedItem();

                Pelicula p =
                        new Pelicula(

                                nombre,
                                genero,

                                new Director(
                                        1,
                                        director,
                                        "Director",
                                        "Cine",
                                        director,
                                        LocalDate.of(
                                                1980,
                                                1,
                                                1
                                        ),
                                        "Peruana",
                                        "Cine"
                                ),

                                duracion
                        );

                service.agregarPelicula(p);

                JOptionPane.showMessageDialog(
                        null,
                        "Película agregada"
                );

                limpiarPeliculas();

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al agregar película"
                );
            }
        });

        btnMostrar.addActionListener(e -> {

            mostrarPeliculas();
        });

        btnSalaNormal.addActionListener(e -> {

            reservarAsiento(false);
        });

        btnSalaVIP.addActionListener(e -> {

            reservarAsiento(true);
        });

        btnMostrarReservas.addActionListener(e -> {

            mostrarReservas();
        });
    }

    // =========================
    // MOSTRAR PELICULAS
    // =========================
    private void mostrarPeliculas() {

        StringBuilder html = new StringBuilder();

        html.append("""
                <html>
                <body style='background:#050505;
                             color:white;
                             font-family:Arial;
                             padding:20px;'>
                """);

        for(Pelicula p : service.getPeliculas()) {

            html.append("""
                    <div style='
                    border:3px solid gold;
                    border-radius:20px;
                    padding:20px;
                    margin-bottom:25px;
                    background:#111;'>

                    <h1 style='color:#ff9800;'>
                    🎬 
                    """);

            html.append(p.getNombre());

            html.append("""
                    </h1>

                    <h2 style='color:#00e5ff;'>
                    🎭 GÉNERO:
                    <span style='color:white;'>
                    """);

            html.append(p.getGenero());

            html.append("""
                    </span></h2>

                    <h2 style='color:#00e5ff;'>
                    🎬 DIRECTOR:
                    <span style='color:white;'>
                    """);

            html.append(
                    p.getDirector()
                            .getNombres()
            );

            html.append("""
                    </span></h2>

                    <h2 style='color:#00e5ff;'>
                    ⏰ DURACIÓN:
                    <span style='color:white;'>
                    """);

            html.append(p.getDuracion());

            html.append("""
                    </span></h2>

                    <h2 style='color:#00ff99;'>
                    ⭐ ESTADO:
                    <span style='color:white;'>
                    EN CARTELERA
                    </span></h2>

                    </div>
                    """);
        }

        html.append("</body></html>");

        areaPeliculas.setText(
                html.toString()
        );
    }

    // =========================
    // RESERVAR
    // =========================
    private void reservarAsiento(boolean vip) {

        if(txtCliente.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese cliente"
            );

            return;
        }

        if(txtApellido.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese apellido"
            );

            return;
        }

        JPanel panel = new JPanel(
                new GridLayout(0, 5, 10, 10)
        );

        SalaNormal salaN = salaNormal;
        SalaVIP salaV = salaVIP;

        Asiento[] asientos =
                vip
                ? salaV.getAsientos()
                : salaN.getAsientos();

        for(Asiento a : asientos) {

            JButton boton =
                    new JButton(
                            String.valueOf(
                                    a.getNumero()
                            )
                    );

            boton.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            18
                    )
            );

            boton.setPreferredSize(
                    new Dimension(80, 60)
            );

            if(a.isOcupado()) {

                boton.setBackground(
                        Color.RED
                );

                boton.setText(
                        "X"
                );

            } else {

                boton.setBackground(
                        new Color(
                                0,
                                180,
                                0
                        )
                );
            }

            boton.setForeground(
                    Color.WHITE
            );

            boton.addActionListener(ev -> {

                if(a.isOcupado()) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Asiento ocupado"
                    );

                    return;
                }

                a.reservar();

                Persona cliente =
                        new Persona();

                cliente.setNombres(
                        txtCliente.getText()
                );

                cliente.setApePaterno(
                        txtApellido.getText()
                );

                if(vip) {

                    clientesVIP.put(
                            a.getNumero(),
                            cliente
                    );

                } else {

                    clientesNormal.put(
                            a.getNumero(),
                            cliente
                    );
                }

                boton.setBackground(
                        Color.RED
                );

                boton.setText("X");

                mostrarReservas();

                JOptionPane.showMessageDialog(
                        null,
                        "Reserva realizada"
                );
            });

            panel.add(boton);
        }

        JOptionPane.showMessageDialog(
                null,
                panel,
                vip
                ? "🎟 SALA VIP"
                : "🎟 SALA NORMAL",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    // =========================
    // MOSTRAR RESERVAS
    // =========================
    private void mostrarReservas() {

        StringBuilder html =
                new StringBuilder();

        html.append("""
                <html>
                <body style='background:#050505;
                             color:white;
                             font-family:Arial;
                             padding:20px;'>
                """);

        html.append("""
                <h1 style='color:#ffd600;'>
                🎟 SALA NORMAL
                </h1>
                """);

        for(Integer asiento :
                clientesNormal.keySet()) {

            Persona p =
                    clientesNormal
                            .get(asiento);

            html.append("""
                    <div style='
                    border:2px solid #00ff99;
                    border-radius:15px;
                    padding:15px;
                    margin-bottom:15px;
                    background:#111;'>

                    <h2 style='color:#00e5ff;'>
                    💺 ASIENTO N-
                    """);

            html.append(asiento);

            html.append("""
                    </h2>

                    <h2 style='color:white;'>
                    👤
                    """);

            html.append(
                    p.getNombres()
            );

            html.append(" ");

            html.append(
                    p.getApePaterno()
            );

            html.append("""
                    </h2>
                    </div>
                    """);
        }

        html.append("""
                <h1 style='color:#ba68c8;'>
                🌟 SALA VIP
                </h1>
                """);

        for(Integer asiento :
                clientesVIP.keySet()) {

            Persona p =
                    clientesVIP
                            .get(asiento);

            html.append("""
                    <div style='
                    border:2px solid #ba68c8;
                    border-radius:15px;
                    padding:15px;
                    margin-bottom:15px;
                    background:#111;'>

                    <h2 style='color:#ff80ab;'>
                    💺 ASIENTO VIP N-
                    """);

            html.append(asiento);

            html.append("""
                    </h2>

                    <h2 style='color:white;'>
                    👤
                    """);

            html.append(
                    p.getNombres()
            );

            html.append(" ");

            html.append(
                    p.getApePaterno()
            );

            html.append("""
                    </h2>
                    </div>
                    """);
        }

        html.append("""
                </body>
                </html>
                """);

        areaReservas.setText(
                html.toString()
        );
    }

    // =========================
    // LIMPIAR
    // =========================
    private void limpiarPeliculas() {

        txtNombre.setText("");
        txtDirector.setText("");
    }

    // =========================
    // PANEL MODULO
    // =========================
    private JPanel crearPanelModulo(String titulo) {

        JPanel panel = new JPanel();

        panel.setBackground(
                new Color(25, 25, 25)
        );

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        255,
                                        215,
                                        0
                                ),
                                3
                        ),
                        titulo,
                        TitledBorder.LEFT,
                        TitledBorder.TOP,
                        new Font(
                                "Arial",
                                Font.BOLD,
                                24
                        ),
                        Color.YELLOW
                )
        );

        return panel;
    }

    // =========================
    // LABEL
    // =========================
    private JLabel crearLabel(String texto) {

        JLabel lbl =
                new JLabel(texto);

        lbl.setForeground(
                Color.WHITE
        );

        lbl.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        lbl.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return lbl;
    }

    // =========================
    // TEXTFIELD
    // =========================
    private JTextField crearTextField() {

        JTextField txt =
                new JTextField();

        txt.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        60
                )
        );

        txt.setPreferredSize(
                new Dimension(
                        450,
                        60
                )
        );

        txt.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        24
                )
        );

        txt.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        return txt;
    }

    // =========================
    // BOTON
    // =========================
    private JButton crearBoton(String texto) {

        JButton btn =
                new JButton(texto);

        btn.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        65
                )
        );

        btn.setPreferredSize(
                new Dimension(
                        450,
                        65
                )
        );

        btn.setBackground(
                new Color(
                        45,
                        45,
                        45
                )
        );

        btn.setForeground(
                Color.WHITE
        );

        btn.setFocusPainted(false);

        btn.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        return btn;
    }

    // =========================
    // COMBO
    // =========================
    private void estilizarCombo(JComboBox<?> combo) {

        combo.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        60
                )
        );

        combo.setPreferredSize(
                new Dimension(
                        450,
                        60
                )
        );

        combo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        24
                )
        );
    }
}