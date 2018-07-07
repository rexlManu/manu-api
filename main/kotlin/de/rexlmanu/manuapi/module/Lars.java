/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.module;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 07.07.2018 / 08:39                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class Lars {

//    public static void main(String[] args) {
//        try {
//            final Module module = new Lars().loadModule(new File("E:\\Coding\\Workspace 2\\ManuAPI\\out\\production\\classes\\TestModule.class"));
//            System.out.println(module.getModuleDescription().getAuthor());
//            final JarFile jarFile = new JarFile("E:\\Coding\\Workspace 2\\ManuAPI\\out\\artifacts\\TestModule\\TestModule.jar");
//            jarFile.entries().nextElement().getCertificates().
////            URL url = new URL("jar:E:/Coding/Workspace 2/ManuAPI/out/artifacts/TestModule/TestModule.jar!/module.json");
////            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
////            String line;
////            while ((line = reader.readLine()) != null){
////                System.out.println(line);
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static void process(InputStream input) throws IOException {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String arg[]) throws Exception {
//        JarFile jarFile = new JarFile("E:\\Coding\\Workspace 2\\ManuAPI\\out\\artifacts\\TestModule\\TestModule.jar");

        File jarFile = new File("E:\\Coding\\Workspace 2\\ManuAPI\\out\\artifacts\\TestModule\\TestModule.jar");
        importJar(jarFile);
        final Class<?> cls = getMainClass();
        System.out.println("Test");
            System.out.println(cls.isAssignableFrom(Module.class));
            try {
                final Class<? extends Module> aClass = cls.asSubclass(Module.class);
                Module obj = (Module) cls.newInstance();
                // Call `loaded()` method.
                obj.start();
                System.out.println(obj.getModuleDescription().getDescription());
            } catch (ClassCastException ignored) {
                System.err.println("kein module");
            }
    }

    public static String getModuleJsonContent() throws Exception {
        JarFile jarFile = new JarFile("E:\\Coding\\Workspace 2\\ManuAPI\\out\\artifacts\\TestModule\\TestModule.jar");
        final Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            final JarEntry entry = entries.nextElement();
            if (entry.getName().contains(".")) {
                JarEntry fileEntry = jarFile.getJarEntry(entry.getName());
                if (entry.getName().contains(".json")) {
                    InputStream input = jarFile.getInputStream(fileEntry);
                    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                    return bufferedReader.readLine();
                }
            }
        }
        return "";
    }

    public static void importJar(File file) throws Exception {
        Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        addURL.setAccessible(true);
        addURL.invoke(URLClassLoader.getSystemClassLoader(), new Object[]{file.toURI().toURL()});
    }

    public static Class<?> getMainClass() throws Exception {
//        JarFile jar = new JarFile(file);
//        Enumeration<JarEntry> entries = jar.entries();
//        while (entries.hasMoreElements()) {
//            JarEntry entry = entries.nextElement();
//            String name = entry.getName();
//            if (name.endsWith(".class")) {
//                name = name.substring(0, name.lastIndexOf('.'));
//                Class<?> cls = Class.forName(name.replace("/", "."));
        Class<?> cls = Class.forName(getModuleJsonContent());
//            }
//        }
        return cls;
    }

    public Module loadModule(File file) throws Exception {
        final URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()}, Module.class.getClassLoader());
        return urlClassLoader.loadClass("TestModule").asSubclass(Module.class).getConstructor().newInstance();
    }

}
