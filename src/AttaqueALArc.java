public class AttaqueALArc implements ModeDAttaque {

    private final int DOMMAGE;


    public AttaqueALArc(int dommage){
        if(dommage<0){
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

        }else{
            victime.setForceVitale((victime.getForceVitale()-DOMMAGE));
            if(victime.getForceVitale() < 0){
                victime.setForceVitale(0);
            }
        }
    }
}
