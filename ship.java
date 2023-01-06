
public class ship

{
    public int lives;
    public int typeOfCat;
    public boolean rotate;

    public ship(int typeOfCat){
        this.typeOfCat = typeOfCat;
        lives = typeOfCat;

    }
    public boolean isSunk(){
        return lives > 0;
    }
    public void catHit(){
        lives = lives - 1;
    }



}
