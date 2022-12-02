public class Inyector {

    static void inyectarAuto(Piloto piloto, TipoAuto tipoAuto){

        switch(tipoAuto){
            case NASCAR:
                piloto.setAuto(new Nascar("Team Penske"));
                break;
            case INDY:
                piloto.setAuto(new Indy("McLaren"));
                break;
            case FORMULA:
                piloto.setAuto(new Formula("Red Bull"));
                break;
            default:
                System.out.println("No se pudo inyectar el auto");
                break;
        }
    }
}
