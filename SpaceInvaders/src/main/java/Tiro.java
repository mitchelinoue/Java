import java.awt.*;

public class Tiro {

    private int x;
    private int y;
    private int velocidadeTiro = 6;
    private int tamX = 3;
    private int tamY = 15;


    //quando crio o tiro
    public Tiro(int inicioX, int inicioY){

        this.x = inicioX;
        this.y = inicioY;

    }

    public void pintar(Graphics2D g){

        g.setColor(Color.red);
        g.fillRect(x, y, tamX, tamY);

    }

    public void atualiza() {
        y -= velocidadeTiro;
    }

    public boolean destroy(){
        return y < 0;   //retorna verdadeiro ou falso
    }

    public boolean colideCom(Inimigo inimigo) {

        if (x >= inimigo.getX() && x + tamX <= inimigo.getX() + inimigo.getTam() ){

            if (y <= inimigo.getY() + inimigo.getTam()){
                return true;
            }

        }
        return false;
    }
}
