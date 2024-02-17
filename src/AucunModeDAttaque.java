public class AucunModeDAttaque implements ModeDAttaque{

    @Override
    public void attaquer(Personnage attaquant, Personnage victime) {
        if(attaquant == null || victime == null){
            throw new NullPointerException();

        }
    }
}
