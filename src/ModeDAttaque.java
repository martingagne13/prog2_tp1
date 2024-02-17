
/**
 * Cette interface contient la methode attaquer qui determine l'effet 
 * de l'attaque d'un attaquant sur une victime.
 * 
 * @author Melanie Lord
 * @version Hiver 2024
 */
public interface ModeDAttaque {
   
   /**
    * Applique l'effet sur la force vitale de l'attaquant et la victime
    * lors d'une attaque. Si force vitale de attaquant est 0, cette methode 
    * ne fait rien.
    * @param attaquant personnage qui attaque la victime
    * @param victime personnage qui se fait attaquer par l'attaquant
    */
   void attaquer(Personnage attaquant, Personnage victime);
   
}
