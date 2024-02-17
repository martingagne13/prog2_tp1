public abstract class Personnage  {

    public static final int FORCE_VITALE_MAX = 100;

    //Attributs d'instance

    private String nom;
    private int forceVitale;
    private ModeDAttaque modeDAttaque;

    // Constructeurs

    public Personnage(String nom, ModeDAttaque modeDAttaque, int forceVitale) throws AttributPersonnageInvalideException{
        if(nom == null || nom.isEmpty() || modeDAttaque == null) {
            throw new AttributPersonnageInvalideException();
        }else {
            this.nom = nom;
            this.modeDAttaque = modeDAttaque;
        }
        if(forceVitale < 0){
            this.forceVitale = 0;

        }else if(forceVitale > FORCE_VITALE_MAX){
            this.forceVitale = FORCE_VITALE_MAX;

        }else {
            this.forceVitale = forceVitale;
        }
    }

    // Getters

    public String getNom(){
        return this.nom;
    }

    public int getForceVitale(){
        return this.forceVitale;
    }

    public ModeDAttaque getModeDAttaque(){
        return this.modeDAttaque;
    }

    // Mutateurs

    public void setNom(String nom) throws AttributPersonnageInvalideException{
        if(nom == null || nom.isEmpty()){
            throw new AttributPersonnageInvalideException();
        }else {
            this.nom = nom;
        }
    }

    public void setForceVitale(int forceVitale){

        if(forceVitale < 0){
            this.forceVitale = 0;

        }else if(forceVitale > FORCE_VITALE_MAX){
            this.forceVitale = FORCE_VITALE_MAX;

        }else {
            this.forceVitale = forceVitale;
        }

    }

    public void setModeDAttaque(ModeDAttaque modeDAttaque) throws AttributPersonnageInvalideException{
        if(modeDAttaque == null){
            throw new AttributPersonnageInvalideException();
        }else {
            this.modeDAttaque = modeDAttaque;
        }
    }

    // Autres methodes

    public void attaquer(Personnage victime) throws NullPointerException{
        if(victime == null || forceVitale == 0){
            throw new NullPointerException();

        }else{
            modeDAttaque.attaquer(this, victime);
        }
    }

    public void seRevigorer(int forceVitale) {
        if(forceVitale <= 0) {

        }else if(this.forceVitale == 0 ){

        }else {
            this.forceVitale = this.forceVitale + forceVitale;

            if(this.forceVitale > FORCE_VITALE_MAX){
                this.forceVitale = FORCE_VITALE_MAX;
            }
        }

    }

    public boolean equals(Object autrePersonnage){

        if(this.nom == ((Personnage) autrePersonnage).getNom()){
            return true;
        }else{
            return false;
        }
    }

}
