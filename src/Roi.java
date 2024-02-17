public class Roi extends Personnage{

    public Roi(String nom) throws AttributPersonnageInvalideException {
        super(nom, new AttaqueALEpe(5), FORCE_VITALE_MAX);
    }

    public Roi(String nom, ModeDAttaque modeDAttaque, int forceVitale) throws AttributPersonnageInvalideException {
        super(nom, modeDAttaque, forceVitale);
    }
}

