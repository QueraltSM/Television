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
        c1.setnChannel(c2.getnChannel());
        c2.setnChannel(n);
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