import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class SpaceInvaders extends JPanel implements Runnable, KeyListener {

    private Font minhaFonte = new Font("Consolas", Font.BOLD, 20);
    private Nave nave;
    private int direcao = 0;
    private ArrayList<Tiro> tiros; //parecido com vetor, só que podemos adicionar e retirar elementos
    private ArrayList<Inimigo> inimigos;
    private PlanoDeFundo fundo;
    private boolean ganhou;
    private boolean perdeu;

    //construtor - é chamado quando fazemos o new Space Invaders
    public SpaceInvaders(){

        nave = new Nave();
        tiros = new ArrayList<Tiro>();
        inimigos = new ArrayList<Inimigo>();
        fundo = new PlanoDeFundo();
        ganhou = false;
        perdeu = false;

        BufferedImage imagemInimigo = null;

        try {
            imagemInimigo = ImageIO.read(new File("imagens/inimigo.png"));
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a imagem do inimigo");
            e.printStackTrace();
        }

        for (int i = 0; i < 60; i++){
            inimigos.add(new Inimigo(imagemInimigo, 50 + i % 20 * 50, 50 + i / 20 * 50, 1));
        }



        Thread lacoDoJogo = new Thread(this);
        lacoDoJogo.start();

    }

    @Override
    public void run() {
        while(true){

            long tempoInicial = System.currentTimeMillis();

            update();
            repaint();
            dorme();

            long tempoFinal = System.currentTimeMillis();
        }
    }

    private void update(){

        if (inimigos.size() == 0){
            ganhou = true;
        }

        nave.movimenta(direcao);

        for (int i = 0; i < inimigos.size(); i++){
            inimigos.get(i).atualizar();

            if (inimigos.get(i).getY() >= 668){
                perdeu = true;
            }
        }

        for(int i = 0; i < tiros.size();i++ ){
            tiros.get(i).atualiza();

            if(tiros.get(i).destroy()){
                tiros.remove(i);
                i--;
            } else {
                for (int j = 0; j < inimigos.size(); j++){
                   if(tiros.get(i).colideCom(inimigos.get(j))){

                       inimigos.remove(j);
                       j--;

                       tiros.remove(i);
                       break;
                   }
                }
            }

        }

        for (int i = 0; i < inimigos.size(); i++){
            if (inimigos.get(i).getX() <= 0 || inimigos.get(i).getX() >= 1366 - 50){
                for (int j = 0; j < inimigos.size(); j++){
                    inimigos.get(j).trocaDirecao();;
                }
                break;
            }
        }

    }

    int x = 0;
    public void paintComponent(Graphics g2){
        super.paintComponent(g2); //limpar a tela

        //copia e cola da internet - para ligar o anti aliasing
        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        fundo.pinta(g);

        //desenha os inimigos
        for (int i = 0; i < inimigos.size(); i++){
            inimigos.get(i).pintar(g);
        }

        //desenha as naves
        nave.pintar(g);

        //desenha os tiros
        for(int i = 0; i < tiros.size();i++ ){
            tiros.get(i).pintar(g);
        }

        if (ganhou){
            g.setColor(Color.white);
            g.setFont(minhaFonte);
            g.drawString("VOCÊ TERMINOU O JOGO!!!",1366/2 , 768/2);
        }
        if (perdeu){
            g.setColor(Color.white);
            g.setFont(minhaFonte);
            g.drawString("VOCÊ É MUITO RUIM!!!",1366/2 , 768/2);
        }

    }

    private void dorme(){

        try{
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 1;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && nave.podeAtirar()){
            tiros.add(nave.atirar());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
