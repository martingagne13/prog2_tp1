
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe modelise une liste de personnages indicee qui ne contient aucun 
 * element null et aucun doublon. 
 * 
 * Le constructeur par defaut permet de construire une liste de personnages vide.
 * 
 * @author <Martin Gagne GAGM24039801>
 * @version Hiver 2024
 */
public class ListePersonnages {
   
   //Liste servant a conserver les personnages
   private List<Personnage> personnages = new ArrayList<>();
   
   /**
    * Retourne le nombre de personnages dans cette liste.
    * 
    * @return le nombre de personnages dans cette liste.
    */
   public int taille() {
      int compteur = 0;

      for(Personnage e: personnages){
         if(e != null){
            compteur++;
         }
      }
      return compteur;
   }
   
   /**
    * Retourne l'indice, dans cette liste, du personnage donne en parametre, s'il existe. 
    * Sinon, retourne -1.
    * 
    * Pour rechercher le personnage dans cette liste, c'est la methode equals 
    * de la classe Personnage qui est utilisee pour tester l'egalite du personnage 
    * donne en parametre avec les personnages dans cette liste.
    * 
    * @param personnage le personnage dont on veut l'indice dans cette liste.
    * @return l'indice du personnage dans cette liste ou -1 si celui-ci n'existe pas.
    */
   public int indiceDe (Personnage personnage) {
      for (Personnage e: personnages) {
         if(e.equals(personnage)){
            return personnages.indexOf(e);

         }
      }

      return -1;
   }
   
   /**
    * Retourne true si le personnage donne en parametre existe dans cette liste,
    * retourne false sinon.
    * 
    * Pour rechercher le personnage dans cette liste, c'est la methode equals 
    * de la classe Personnage qui est utilisee pour tester l'egalite du personnage 
    * donne en parametre avec les personnages dans cette liste.
    * 
    * @param personnage le personnage dont on veut tester l'existence
    * @return true si le personnage donne en parametre existe dans cette liste,
    *         false sinon.
    */
   public boolean existe (Personnage personnage) {
      for(Personnage e: personnages){
         if(personnage.equals(e)){
            return true;

         }
      }

      return false;
   }
   
   /**
    * Permet d'obtenir le personnage a l'indice donne en parametre, dans cette liste.
    * 
    * @param indice l'indice du personnage qu'on veut obtenir.
    * @return le personnage a l'indice donne en parametre
    * @throws IndexOutOfBoundsException si l'indice donne n'existe pas dans cette liste.
    *         (indice < 0 || indice >= size())
    */
   public Personnage obtenir (int indice) {
      if((indice < 0 || indice >= personnages.size())){
         throw new IndexOutOfBoundsException();

      }else{
         return personnages.get(indice);

      }
   }
   
   /**
    * Permet d'ajouter le personnage donne en parametre a l'indice donne en 
    * parametre dans cette liste.
    * 
    * L'ajout n'est pas effectue si :
    *    - personnage est null
    *    - personnage existe deja dans cette liste (voir methode existe(Personnage))
    * 
    * @param personnage le personnage a ajouter a cette liste
    * @param indice l'indice de cette liste où l'on veut ajouter le personnage 
    * @return true si l'ajout a ete effectue, false sinon
    * @throws IndexOutOfBoundsException si l'indice donne n'est pas valide.
    *         (indice < 0 || indice > size())
    */
   public boolean ajouter (Personnage personnage, int indice) {
      if(personnage == null || existe(personnage)){
         return false;

      }else if(indice < 0 || indice > personnages.size()){
         throw new IndexOutOfBoundsException();

      }else{
         personnages.add(indice, personnage);
         return true;

      }
   }
   
   /**
    * Permet d'ajouter le personnage donne en parametre a la fin de cette liste.
    * 
    * L'ajout n'est pas effectue si :
    *    - personnage est null
    *    - personnage existe deja dans cette liste (voir methode existe(Personnage))
    * 
    * @param personnage le personnage a ajouter a la fin de cette liste
    * @return true si l'ajout a ete effectue, false sinon
    */
   public boolean ajouter (Personnage personnage) {
      if(personnage != null){
         personnages.add(personnage);
         return true;

      }else{
         return false;

      }
   }
   
   
   /**
    * Permet de supprimer de cette liste le personnage donne en parametre.
    * 
    * Si le personnage n'existe pas dans cette liste, la suppression n'est
    * pas effectuee. 
    * 
    * Pour rechercher le personnage a supprimer dans cette liste, c'est la methode 
    * equals de la classe Personnage qui est utilisee pour tester l'egalite du 
    * personnage donne en parametre avec les personnages dans cette liste.
    * 
    * @param personnage le personnage a supprimer de cette liste.
    * @return true si la suppression a ete effectuee, false sinon.
    */
   public boolean supprimer (Personnage personnage) {
      for(Personnage e: personnages){
         if(personnage.equals(e)){
            personnages.remove(e);
            return true;

         }
      }
      return false;
   }

   /**
    * Permet de supprimer de cette liste le personnage a l'indice donne en parametre.
    * 
    * Si l'indice n'existe pas dans cette liste, la suppression n'est pas effectuee.
    * 
    * @param indice l'indice du personnage a supprimer de cette liste
    * @return true si la suppression a ete effectuee, false sinon.
    */
   public boolean supprimer (int indice) {
      if(indice > personnages.size() || indice < 0){
         return false;

      }else {
         personnages.remove(indice);
         return true;

      }
   }
   
   /**
    * Execute une attaque du personnage à l'indiceAttaquant sur le personnage
    * a l'indiceVictime. Cette methode appelle la methode attaquer sur le personnage
    * qui est l'attaquant.
    * 
    * Apres l'attaque : 
    * - si la victime est morte (sa force vitale est 0), on la retire de cette liste.
    * - si l'attaquant est mort (sa force vitale est 0), on le retire de cette liste.
    * 
    * @param indiceAttaquant l'indice du personnage qui attaque
    * @param indiceVictime l'indice du personnage qui est victime de l'attaque, 
    * @throws IndexOutOfBoundsException si indiceAttaquant ou indiceVictime n'existe
    *         pas dans cette liste (indice < 0 || indice >= size())        
    */
   public void attaquer (int indiceAttaquant, int indiceVictime) {


   }
   
   /**
    * Permet d'ajouter de la force vitale au personnage a l'indice donne, dans cette liste.
    * Consiste a appeler la methode seRevigorer sur le personnage a l'indice donne.
    * 
    * @param indice l'indice du personnage a revigorer
    * @param forceVitale la force vitale a ajouter a la force vitale du personnage
    *                    a l'indice donne dans cette liste
    * @throws IndexOutOfBoundsException si indice n'existe pas dans cette liste 
    *         (indice < 0 || indice >= size())  
    */
//   public void revigorer (int indice, int forceVitale) {
//      // A COMPLETER
//   }
   
   /**
    * Permet de modifier le mode d'attaque du personnage a l'indice donne dans cette liste.
    * 
    * Note sur les exceptions levees : 
    *   Dans le cas où l'indice donne est invalide et le nouveauModeAttaque est 
    *   null, c'est l'exception IndexOutOfBoundsException qui est levee.
    * 
    * @param indice l'indice du personnage dont on veut modifier le mode d'attaque
    * @param nouveauModeAttaque le nouveau mode d'attaque a assigner a ce personnage
    * @throws IndexOutOfBoundsException si indice n'existe pas dans cette liste 
    *         (indice < 0 || indice >= size()) 
    * @throws AttributPersonnageInvalideException si nouveauModeAttaque est null.  
    */
//   public void modifierModeDAttaque (int indice, ModeDAttaque nouveauModeAttaque)
//         throws AttributPersonnageInvalideException {
//      // A COMPLETER
//   }
   
   /**
    * Permet d'obtenir tous les personnages de cette liste du type donne en parametre 
    * (tous les chevaliers ou tous les trolls ou ...).
    * 
    * - La liste retournee doit conserver l'ordre des personnages dans cette liste.
    * - Si aucun personnage du type donne n'existe dans cette liste, la liste 
    *   retournee est vide.
    * 
    * @param type le type (la classe) des personnages qu'on veut obtenir
    * @return la liste de tous les personnages du type donne en parametre
    * @throws NullPointerException si type est null
    */
//   public ListePersonnages obtenirTousLesPersonnages(Class type) {
//      // A COMPLETER
//   }
   
   /**
    * Redefinition de la methode equals (voir Javadoc dans la classe Object). 
    * Deux listes de personnages l1 et l2 sont considerees egales si l1 a la meme
    * taille que l2, et que pour tout i, le personnage a l'indice i dans l1 est egal
    * au personnage a l'indice i dans l2. C'est la methode equals de la classe 
    * Personnage qui est utilisee pour tester l'egalite entre deux personnages.
    * 
    * @param autreListePersonnages la liste de personnages a comparer avec cette liste
    *                              de personnages.
    * @return true si cette liste de personnages est egale a autreListePersonnages, 
    *         false sinon.
    */   
//   @Override
//   public boolean equals (Object autreListePersonnages) {
//       // A COMPLETER
//   }
   
}
