package demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MyThreadToFile extends Thread{

    private String url;
    private String name;

    public MyThreadToFile(String url,String name){
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了" + name);
    }

    public static void main(String[] args) {
        MyThreadToFile myThreadToFile1 = new MyThreadToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25","1.jpg");
        myThreadToFile1.start();
        MyThreadToFile myThreadToFile2 = new MyThreadToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25","2.jpg");
        myThreadToFile2.start();
        MyThreadToFile myThreadToFile3 = new MyThreadToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25","3.jpg");
        myThreadToFile3.start();
    }
}


class WebDownloader {
    public void downloader(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}