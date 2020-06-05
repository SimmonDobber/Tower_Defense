package engine;

public class Field
{
    protected double posX;
    protected double posY;
    protected int width;
    protected int height;
    protected Image img;
    public Field(double posX, double posY, int width, int height, int frame)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        img = new Image("/res/defaultField.png", width, height, frame);
    }
    public Field(Image image, double posX, double posY)
    {
        this.posX = posX;
        this.posY = posY;
        img = image;
        this.width = image.getW();
        this.height = image.getH();
    }
    public Field(String path, double posX, double posY, int width, int height, int frame)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        if(path == "")
            img = new Image("/res/blank.png", width, height, frame);
        else
        img = new Image(path, width, height, frame);
    }
    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Image getImg() {
        return img;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
