public class AttaqueParMagie implements ModeDAttaque{

    private final int EFFORT;
    private final int DOMMAGE;


    public AttaqueParMagie(int effort, int dommage){
        if(effort < 0){
            this.EFFORT = 0;

        }else{
            this.EFFORT = effort;
        }

        if(dommage < 0){
            this.DOMMAGE = 0;

        }else{
            this.DOMMAGE = dommage;
        }
    }

    @Override
    public void attaquer(Personnage attaquant, Personnage victime) {
        int effortReel;
        int dommageReel;

        if(attaquant == null || victime == null){
            throw new NullPointerException();

        }else{
            if(attaquant.getForceVitale() < EFFORT){
                effortReel = attaquant.getForceVitale();
                dommageReel = Math.round(effortReel * DOMMAGE / EFFORT);
                victime.setForceVitale(victime.getForceVitale() - dommageReel);
                attaquant.setForceVitale(0);

            }else{
                victime.setForceVitale(victime.getForceVitale() - DOMMAGE);
                attaquant.setForceVitale(attaquant.getForceVitale() - EFFORT);

            }
        }
    }
}
