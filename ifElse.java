public class ifElse {
    public static void main(String[] args){

        int nota = 85;
        int media = 60;
        int faltas = 10;
        int maxFaltas = 5;
        
        if(nota >= media && faltas <= maxFaltas) {
            System.out.println("Aprovado");
        } else if(nota >= 40){
            System.out.println("Recuperacao");
        } else {
            System.out.println("Reprovado");
        }
        System.out.println("Fim do programa");
        



        String res;

        res = (nota >= media ? "Aprovado" : "Reprovado");
        System.out.println("O Resultado e: " + res);

        int resu;

        resu = (nota >= media ? 1 : 0);
        System.out.println("Resultado: " + (resu==1 ? "Aprovado" : "Reprovado"));





        String pos = "j";

        switch(pos) {
            case "a":
                System.out.println("Primeiro lugar");
                break;
            case "b":
                System.out.println("Segundo lugar");
                break; 
            case "c":
                System.out.println("Terceiro lugar");
                break;
            case "d": case "e": case "f":
                System.out.println("Premio de participacao");
                break;        
            default:
                System.out.println("Nao ganhou premio");
                break;
        }
    }
}
