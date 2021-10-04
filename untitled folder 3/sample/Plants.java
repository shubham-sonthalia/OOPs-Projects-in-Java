package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class Plants {
    private ImageView image;
    private int PosX;
    private int PosY;
    private int Price;
    private int Health;
    public Plants(int x, int y) {
        PosX = x;
        PosY = y;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getHealth() {
        return Health;
    }

    public int getPosX() {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }

    public int getPrice() {
        return Price;
    }

    public void setPosX(int posX) {
        PosX = posX;
    }

    public void setPosY(int posY) {
        PosY = posY;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
    public ImageView getImage()
    {
        return image;
    }

    public void attack(){

    }
}
