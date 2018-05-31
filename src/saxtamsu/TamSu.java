package saxtamsu;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngova
 */
public class TamSu {
    private String title;
    private String description;
    private String pubDate;
    private String link;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TamSu() {
    }

    public TamSu(String title, String description, String pubDate, String link, String image) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
        this.image = image;
    }

    @Override
    public String toString() {
        return "TamSu{" + "title=" + title + ", description=" + description + ", pubDate=" + pubDate + ", link=" + link + ", image=" + image + '}';
    }
     public static void main(String[] args) {
        String des = "<a href=\"https://vnexpress.net/tin-tuc/cuoi/anh/nhung-tu-the-ngu-bat-chap-cua-nhieu-nguoi-3744570.html\"><img width=130 height=100 src=\"https://i-vnexpress.vnecdn.net/2018/05/03/ezgif52f4170199a-1525336337-8149-1525336777_180x108.gif\" ></a></br>Ngủ khi đi thang cuốn, trên bàn làm việc, ngoài đường phố... là những lựa chọn của một số người.";               
        
        Pattern p = Pattern.compile("<img[^>]*src=[\\\"']([^\\\"^']*)");
        
        Matcher m = p.matcher(des);
        while (m.find()) {
            String src = m.group();
//            System.out.println(src);
            int startIndex = src.indexOf("src=") + 5;
            String srcTag = src.substring(startIndex, src.length());
            System.out.println(srcTag);
        }
    }
}
