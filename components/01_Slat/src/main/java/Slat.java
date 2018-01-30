

public class Slat {
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    public Port port;

    public class Port implements main.java.ISlat {
        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int neutral() {
            return innerNeutral();
        }

        @Override
        public int fullDown() {
            return innerFullDown();
        }

        @Override
        public int down(int degree) {
            return innerDown(degree);
        }

        @Override
        public int up(int degree) {
            return innerUp(degree);
        }
    }

    private int innerUp(int innerDegree) {
        int tempDegree = degree + innerDegree;

        if(tempDegree>45){
            int tempOver = tempDegree-45;
            innerDegree-=tempOver;
        }
        for(int i = 1; i<=innerDegree;i++){
            //EVENT
        }
        degree+= innerDegree;
        return degree;
    }

    private int innerDown(int innerDegree) {
        degree-= innerDegree;
        if(degree<-45){
            degree=45;
        }
        return degree;
    }

    private int innerFullDown() {
        degree = -45;
        return degree;
    }

    private int innerNeutral() {
        degree = 0;
        return degree;
    }

    private Slat() {
        port = new Port();
    }

    private String innerVersion() {
        return "main.java.Slat XYZ";
    }
}