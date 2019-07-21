package materialdesign.practice.com.recyclerfragment.Util;

public class ModelClass {

    String name;
    String title;
    String descp;
    String link;
    String time;

    public ModelClass() {
    }

    public ModelClass(String name, String title, String descp, String link, String time) {
        this.name = name;
        this.title = title;
        this.descp = descp;
        this.link = link;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
