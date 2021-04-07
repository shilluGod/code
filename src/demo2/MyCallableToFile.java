package demo2;

import org.apache.commons.io.FileUtils;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class MyCallableToFile implements Callable {

    private String name;
    private String url;

    public MyCallableToFile(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     * 这里继承了Callable，重写的方法也变了
     * @return
     */
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableToFile myCallableToFile1 = new MyCallableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "1.jpg");
        MyCallableToFile myCallableToFile2 = new MyCallableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "2.jpg");
        MyCallableToFile myCallableToFile3 = new MyCallableToFile("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201311%2F17%2F174124tp3sa6vvckc25oc8.jpg&refer=http%3A%2F%2Fattach.bbs.miui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1620271150&t=25045116afc954281d68e144faa47a25", "3.jpg");

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> result1 = service.submit(myCallableToFile1);
        Future<Boolean> result2 = service.submit(myCallableToFile2);
        Future<Boolean> result3 = service.submit(myCallableToFile3);

        // 获取结果
        boolean rs1 = result1.get();
        boolean rs2 = result2.get();
        boolean rs3 = result3.get();

        // 关闭服务
        service.shutdown();

    }
}

