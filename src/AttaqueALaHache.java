public class AttaqueALaHache implements ModeDAttaque{

    private final int DOMMAGE;


    public AttaqueALaHache(int dommage){
        if(dommage < 0){
            this.DOMMAGE = 0;

        }else {
            this.DOMMAGE = dommage;

        }
    }

    @Override
    public void attaquer(Personnage attaquant, Personnage victime) {
        if(attaquant == null || victime == null){
            throw new NullPointerException();

        }else if(attaquant.getForceVitale() == 0){

        }else if(attaquant.getForceVitale() < (DOMMAGE / 3)){
            victime.setForceVitale((victime.getForceVitale() - ((DOMMAGE / 3) * 3)));
            attaquant.setForceVitale(0);

        }else {
            victime.setForceVitale((victime.getForceVitale() - DOMMAGE));
            attaquant.setForceVitale(attaquant.getForceVitale() - (DOMMAGE / 3));

        }
    }
}
