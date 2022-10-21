import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.Random;

public class Nave {

    private BufferedImage desenho;
    private int x;
    private int velocidade;
    private boolean podeAtirar;
    private int recarregando;

    //construtor
    public Nave() {
        try {
            desenho = ImageIO.read(new File("imagens/nave.png"));
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a imagem da nave");
            e.printStackTrace();
        }

        x = 683;
        velocidade = 3;
        podeAtirar = true;
        recarregando = 0;
    }
    public void pintar(Graphics2D g) {
                                    //são para tela                                           //são da imagem original
                    //imagem  posx  posy      tamX          tamY      //toda a imagem
        g.drawImage(desenho, x, 600, x + 100, 600 + 100, 0, 0, desenho.getWidth(), desenho.getHeight(), null);

    }
    //a nave retorna um tiro na posição em que ela está
    public Tiro atirar(){
        podeAtirar = false;
        recarregando = 0;
                                    //49 é o meio da nave
        Tiro novoTiro = new Tiro(x + 49,600);
        return novoTiro;
    }

    public void movimenta(int valor){
        //se valor for negativo movimenta <<<
        //se valor for positivo movimenta >>>
        if(valor == 1){
            x += velocidade;
        } else if(valor == -1){
            x -= velocidade;
        }

        if(recarregando >= 10){
            podeAtirar = true;
            recarregando = 0;
        }

        recarregando++;
    }

    public boolean podeAtirar(){
        return podeAtirar;
    }
}




