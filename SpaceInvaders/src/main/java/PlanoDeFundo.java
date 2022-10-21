import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlanoDeFundo {

    private BufferedImage imagem;
    private int y;
    public PlanoDeFundo() {

        try{
            imagem = ImageIO.read(new File("imagens/fundo.png"));
        } catch (IOException e){
            System.out.println("Não foi possível carregar o plano de fundo");
            e.printStackTrace();
        }
        y = 0;
    }


    public void pinta(Graphics2D g){

        g.drawImage(imagem,0,y - 768, imagem.getWidth(), imagem.getHeight(),null);

        g.drawImage(imagem,0,y, imagem.getWidth(), imagem.getHeight(),null);

        g.drawImage(imagem,500,y - 768, imagem.getWidth(), imagem.getHeight(),null);

        g.drawImage(imagem,500,y, imagem.getWidth(), imagem.getHeight(),null);

        y += 3;

        if (y > 768){
            y = 0;
        }
    }

}


