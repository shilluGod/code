package demo2;

import org.apache.commons.io.FileUtils;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyRunnableToFile implements Runnable{

    private String name;
    private String url;

    public MyRunnableToFile(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了" + name);
    }

    public static void main(String[] args) {
        MyRunnableToFile myRunnableToFile1 = new MyRunnableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "1.jpg");
        new Thread(myRunnableToFile1).start();
        MyRunnableToFile myRunnableToFile2 = new MyRunnableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "2.jpg");
        new Thread(myRunnableToFile2).start();
        MyRunnableToFile myRunnableToFile3 = new MyRunnableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "3.jpg");
        new Thread(myRunnableToFile3).start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
