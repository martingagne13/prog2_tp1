public class AttaqueALEpe implements ModeDAttaque{

    private final int EFFORT;


    public AttaqueALEpe(int effort){
        if(effort < 0){
            this.EFFORT = 0;
        }else{
            this.EFFORT = effort;
        }
    }

    @Override
    public void attaquer(Personnage attaquant, Personnage victime) {
        if(attaquant == null || victime == null) {
            throw new NullPointerException();

        }else if(attaquant.getForceVitale() == 0){

        }else if(attaquant.getForceVitale() < EFFORT){
            victime.setForceVitale(victime.getForceVitale() - (attaquant.getForceVitale()) * 2);
            attaquant.setForceVitale(0);

        }else {
            attaquant.setForceVitale((attaquant.getForceVitale() - EFFORT));
            victime.setForceVitale((victime.getForceVitale() - (EFFORT * 2)));
        }
    }
}
