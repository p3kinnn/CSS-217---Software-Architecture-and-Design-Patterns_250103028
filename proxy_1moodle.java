interface Image {
    void show();
}

class RealImage implements Image {
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    void loadFromDisk() {
        System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
    }

    public void show() {
        System.out.println("Displaying " + fileName + " on screen!");
    }
}

class ProxyImage implements Image {
    RealImage realImage;
    String fileName;

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    public void show() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        if (!userrole.equals("ADMIN")) {
            System.out.println("Access denied");
        }else{
            realImage.show();
        }
        realImage.show();
    }
}

public class Main {
    public static void main(String[] args) {
        Image photo = new ProxyImage("dog.png");
        System.out.println(photo.show());

        System.out.println("Step 1 done: Proxy created. Still zero disk activity.\n");

        System.out.println("Step 2: Calling show() for the FIRST time:");
        photo.show();

        System.out.println("\nStep 3: Calling show() for the SECOND time:");
        photo.show();
    }
}
