import java.util.*;
public class Television {
    private ArrayList<Channel> channels = new ArrayList<>();
    private static int order;

    public boolean addChannel(Channel c) {
        for (Channel i : channels) {
            if (i.equals(c)) return false;
        }
        channels.add(c);
        return true;
    }

    public boolean swapChannels(Channel c1, Channel c2) {
        if (search(c1.getName()) == null || search(c2.getName()) == null) return false;
        int n = c1.getnChannel();
        int m = c2.getnChannel();

        ArrayList<Channel> result = new ArrayList<>();
        for (Channel i : channels) {
            if (i.equals(c1)) {
                c1.setnChannel(m);
                result.add(c2);
            } else if (i.equals(c2)) {
                c2.setnChannel(n);
                result.add(c1);
            } else {
                result.add(i);
            }
        }

        channels = result;
        return true;
    }

    public boolean removeChannel(String name) {
        for (Channel i : channels) {
            if (i.getName().equals(name)){
                channels.remove(i);
                return true;
            }
        }
        return false;
    }

    public Channel search(String name) {
        for (Channel i : channels) {
            if (i.getName().equals(name)) return i;
        }
        return null;
    }

    public void setOrder(int ord) {
        order = ord;
        Collections.sort(channels);
    }

    public static int getOrder() {
        return order;
    }

    public String toString() {
        String result = "";
        for (Channel i : channels) {
            result += i.toString() + "\n\n";
        }
        return result;
    }
}