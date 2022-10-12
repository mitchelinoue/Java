import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JogoDaVelha implements ActionListener{

    Random aleatorio = new Random();
    JFrame frame = new JFrame();
    JPanel painel_titulo = new JPanel();
    JPanel painel_botao = new JPanel();
    JLabel campoTexto = new JLabel();
    JButton[] botoes = new JButton[9];
    boolean turno_jogador1;

    JogoDaVelha(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        campoTexto.setBackground(new Color(25,25,25));
        campoTexto.setForeground(new Color(25,255,0));
        campoTexto.setFont(new Font("Ink Free", Font.BOLD, 75));
        campoTexto.setHorizontalAlignment(JLabel.CENTER);
        campoTexto.setText("Jogo-da-velha");
        campoTexto.setOpaque(true);

        painel_titulo.setLayout(new BorderLayout());
        painel_titulo.setBounds(0,0,800,100);

        painel_botao.setLayout(new GridLayout(3,3));
        painel_botao.setBackground(new Color(25,25,25));

        painel_titulo.add(campoTexto);
        frame.add(painel_titulo,BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
    public void primeiroTurno() {

    }

    public void check() {

    }

    public void xGanha(int a, int b, int c) {

    }
    public void oGanha(int a, int b, int c) {

    }
}
