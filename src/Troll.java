public class Troll extends Personnage{

    public Troll(String nom) throws AttributPersonnageInvalideException {
        super(nom, new AttaqueALaHache(10), FORCE_VITALE_MAX);
    }

    public Troll(String nom, ModeDAttaque modeDAttaque, int forceVitale) throws AttributPersonnageInvalideException {
        super(nom, modeDAttaque, forceVitale);
    }
}
