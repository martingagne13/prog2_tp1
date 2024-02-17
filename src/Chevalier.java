public class Chevalier extends Personnage{

    public Chevalier(String nom) throws AttributPersonnageInvalideException {
        super(nom, new AttaqueALEpe(7), FORCE_VITALE_MAX);

    }

    public Chevalier(String nom, ModeDAttaque modeDAttaque, int forceVitale) throws AttributPersonnageInvalideException{
        super(nom, modeDAttaque, forceVitale);
    }


}
