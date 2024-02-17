public class Sorcier extends Personnage{

    public Sorcier(String nom) throws AttributPersonnageInvalideException {
        super(nom, new AttaqueParMagie(12, 5), FORCE_VITALE_MAX);
    }

    public Sorcier(String nom, ModeDAttaque modeDAttaque, int forceVitale) throws AttributPersonnageInvalideException {
        super(nom, modeDAttaque, forceVitale);
    }
}
