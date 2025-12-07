public class Smartphone {
    public static void main(String[] args) {
        SmartDevice s = new SmartDevice();
        s.clickphoto();
        s.makecall();
    }
}

interface Camera {
    void clickphoto();
}

interface phone {
    void makecall();
}

class SmartDevice implements Camera, phone {

    public void clickphoto() {
        System.out.println("Clicking Photo");
    }

    public void makecall() {
        System.out.println("Make Call");
    }
}
