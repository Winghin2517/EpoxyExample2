package kwaai.com.exampleepoxy_hashcodeequals;

public class GraphData {

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long time;
    public float price;


    public GraphData(long time, float price) {
        this.time = time;
        this.price = price;
    }

    public GraphData() {
    }
}
