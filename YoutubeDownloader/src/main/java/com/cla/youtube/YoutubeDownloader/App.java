package com.cla.youtube.YoutubeDownloader;

/**
 * Hello world!
 *
 */
import java.io.File;
import java.net.URL;

import com.github.axet.vget.VGet;

/**
 *
 * @author Manindar
 */
public class App {

    public static void main(String[] args) {
        try {
        	System.out.println("Iniciando");
//            String url = "https://www.youtube.com/watch?v=s10ARdfQUOY";
        	String url = "https://www.youtube.com/watch?v=QO6S7VCWQys";
            String path = "D:\\";
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
            System.out.println("OK");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
