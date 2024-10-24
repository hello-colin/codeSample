package hcl;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class 类加载器 {

    public class MyClassLoader extends URLClassLoader{

        public MyClassLoader(URL[] urls, ClassLoader classLoader) {
            super(urls, classLoader);
        }

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader classLoader, URLStreamHandlerFactory urlStreamHandlerFactory) {
            super(urls, classLoader, urlStreamHandlerFactory);
        }

        @Override
        public Class<?> loadClass(String s) throws ClassNotFoundException {
            return super.loadClass(s);
        }
    }
}
