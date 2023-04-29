

public class AutosarContainer implements Comparable<AutosarContainer> {
    private String uuid;
    private String shortNameTag;
    private String longNameTag;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShortNameTag() {
        return shortNameTag;
    }

    public void setShortNameTag(String shortNameTag) {
        this.shortNameTag = shortNameTag;
    }

    public String getLongNameTag() {
        return longNameTag;
    }

    public void setLongNameTag(String longNameTag) {
        this.longNameTag = longNameTag;
    }
    public AutosarContainer(){

    }
    @Override
    public String toString(){
        return "<CONTAINER"+ this.getUuid() + ">\n"
                + "<SHORT-NAME>" + this.getShortNameTag() +"</SHORT-NAME>\n"
                + "<LONG-NAME>" + this.getLongNameTag() + "</LONG-NAME>\n" ;
    }


    @Override
    public int compareTo(AutosarContainer other) {
        if(this.getShortNameTag().charAt(9) > other.getShortNameTag().charAt(9))
            return 1;
        else if (this.getShortNameTag().charAt(9) < other.getShortNameTag().charAt(9))
            return -1;
        else
            return 0;
    }
}