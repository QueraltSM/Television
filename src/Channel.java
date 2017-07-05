public class Channel implements Comparable<Channel> {
    private String name;
    private int nChannel;
    private static int nChannelMax = 1;


    public Channel(String name) {
        this.name = name;
        nChannel = nChannelMax++;
    }


    public int getnChannel() {
        return nChannel;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Channel c) {
        return c.getName().equals(getName());
    }

    public int compareTo(Channel c) {
        if (Television.getOrder() == 0) {
            if (c.getnChannel() < nChannel) {
                return 1;
            } else if (c.getnChannel() == nChannel) {
                return 0;
            }
            return -1;

        } else if (Television.getOrder() == 1) {

            if (c.getName().compareTo(getName())<0) {
                return 1;
            } else if (c.getName().compareTo(getName())==0) {
                return 0;
            }
            return -1;

        }
            return 0;
    }



    public void setnChannel(int n) {
        this.nChannel = n;
    }


    public String toString() {
        return getnChannel() + " - " + getName();
    }

}