package com.company;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static Callable<Void> callableForURL(String link, String dir)
    {
        return () -> {
            URL url = null;
            BufferedImage image;
            try
            {
                url = new URL(link);
            }
            catch (MalformedURLException e1)
            {
                e1.printStackTrace();
            }
            try
            {
                image = ImageIO.read(url);
                ImageIO.write(image, "jpg", new File(dir + Paths.get(url.getPath()).getFileName()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        };
    }

    static Callable<Void> callableForLocal(String path, String dir)
    {
        return () -> {
            File file = new File(path);
            BufferedImage image;
            try
            {
                image = ImageIO.read(file);
                ImageIO.write(image, "jpg", new File(dir+file.getName()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        };
    }

    public static void MultiThreadLocal(int n) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(n);

        String saveDir = "C:\\Users\\Nameless\\Pictures\\TEMP1Multi\\";
        List<Callable<Void>> callables = Arrays.asList(
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\krasivye_kollazh_na_temu_prirody_1920x1200.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\242624_565001.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\krasivye-kartinki-Priroda-2278640.jpeg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\wallpapers-nature-16.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\voshod_solnca_priroda_pole_mostik_4499x2231.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\v2.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_kartinki_foto_05.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_kartinki_foto_01.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_05.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_01.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\plitvickiye-ozera-1.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\maxresdefault-10.jpg", saveDir),
                callableForLocal("C:\\Users\\Nameless\\Pictures\\TEMP\\maxresdefault-1-4.jpg", saveDir)
        );

        long start = System.currentTimeMillis();

        executor.invokeAll(callables);
        executor.shutdown();

        long end = System.currentTimeMillis();

        System.out.println("Threads = " + n);
        System.out.println("Multi Local: " + (end - start));
    }

    public static void MultiThreadURL(int n) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(n);

        String saveDir = "C:\\Users\\Nameless\\Pictures\\TEMP2Multi\\";
        List<Callable<Void>> callables = Arrays.asList(
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/krasivye_kollazh_na_temu_prirody_1920x1200.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/242624_565001.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/voshod_solnca_priroda_pole_mostik_4499x2231.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/krasivye-kartinki-Priroda-2278640.jpeg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/v2.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/wallpapers-nature-16.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_05.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_01.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/priroda_05.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/priroda_01.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/plitvickiye-ozera-1.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-10.jpg", saveDir),
                callableForURL("https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-1-4.jpg", saveDir)
        );


        long start = System.currentTimeMillis();

        executor.invokeAll(callables);
        executor.shutdown();

        long end = System.currentTimeMillis();

        System.out.println("Threads = " + n);
        System.out.println("Multi URL: " + (end - start));
    }

    public static void SingleLocal() throws IOException {

        File file;
        BufferedImage temp;
        String[] images = {
                "C:\\Users\\Nameless\\Pictures\\TEMP\\242624_565001.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\krasivye_kollazh_na_temu_prirody_1920x1200.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\krasivye-kartinki-Priroda-2278640.jpeg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\maxresdefault-1-4.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\maxresdefault-10.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\plitvickiye-ozera-1.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_01.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_05.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_kartinki_foto_01.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\priroda_kartinki_foto_05.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\v2.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\voshod_solnca_priroda_pole_mostik_4499x2231.jpg",
                "C:\\Users\\Nameless\\Pictures\\TEMP\\wallpapers-nature-16.jpg",
        };

        long start = System.currentTimeMillis();

        for(String img: images) {

            file = new File(img);
            temp = ImageIO.read(file);
            ImageIO.write(temp, "jpg", new File("C:\\Users\\Nameless\\Pictures\\TEMP\\" + file.getName()));
        }

        long end = System.currentTimeMillis();

        System.out.println("Time localHardDrive: " + (end - start));
    }

    public static void SingleURL() throws IOException {
        URL url = null;
        BufferedImage temp;
        String[] URLs = {
                "https://bipbap.ru/wp-content/uploads/2017/04/krasivye_kollazh_na_temu_prirody_1920x1200.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/242624_565001.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/krasivye-kartinki-Priroda-2278640.jpeg",
                "https://bipbap.ru/wp-content/uploads/2017/04/wallpapers-nature-16.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/voshod_solnca_priroda_pole_mostik_4499x2231.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/v2.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_05.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/priroda_kartinki_foto_01.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/priroda_05.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/priroda_01.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/plitvickiye-ozera-1.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-10.jpg",
                "https://bipbap.ru/wp-content/uploads/2017/04/maxresdefault-1-4.jpg"
        };

        long start = System.currentTimeMillis();

        for (String link: URLs) {
            url = new URL(link);
            temp = ImageIO.read(url);
            ImageIO.write(temp, "jpg", new File("C:\\Users\\Nameless\\Pictures\\TEMP1\\"+ Paths.get(url.getPath()).getFileName()));
        }

        long end = System.currentTimeMillis();

        System.out.println("Time URL: " + (end - start));

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Single");
        SingleLocal();
        SingleURL();
        System.out.println("Multi");
        for (int i = 2; i < 12; i+=2) {
            MultiThreadURL(i);
            MultiThreadLocal(i);
        }
    }
}