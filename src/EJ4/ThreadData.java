package EJ4;

public class ThreadData
{
    private int start;
    private int [] temp;

    public int getStart() {
        return start;
    }

    public int[] getTemp() {
        return temp;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTemp(int[] temp) {
        this.temp = temp;
    }

    public ThreadData(int start, int[] temp) {
        this.start = start;
        this.temp = temp;
    }
}
