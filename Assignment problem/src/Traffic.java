class TrafficLight {

    private String color;

    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {

        if (color.equals("RED")) {
            color = "GREEN";
        }
        else if (color.equals("GREEN")) {
            color = "YELLOW";
        }
        else if (color.equals("YELLOW")) {
            color = "RED";
        }

        return color;
    }

    public String getColor() {
        return color;
    }
}

public class Traffic {
    public static void main(String[] args) {

        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());

        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
