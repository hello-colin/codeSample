package hcl.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {
    public static void main(String[] args) throws MalformedURLException {
        ClassLoader classLoader=new ClassLoader() {
        };

        System.out.println(classLoader.getParent());

        URLClassLoader urlClassLoader=new URLClassLoader(new URL[]{new URL("1.jar")});

        System.out.println(urlClassLoader.getParent());
    }
}
