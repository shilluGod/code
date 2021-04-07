package demo0;

public class Parcel {

    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    /**
     * 这里就是外部类中有一个方法，该方法返回了一个指向内部类的引用
     * @param s
     * @return
     */
    public Destination to(String s) {
        // 把s的值直接返回Destination类中去，所以得new
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        // 这里我也想过是否可以声明Parcel来调用to()，问题很明显，这样无法继续调用Destination里的方法了;
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.ship("Tasmania");
        Parcel q = new Parcel();
        Parcel.Contents c = q.contents();
        Parcel.Destination d = q.to("Borneo");
    }
}
