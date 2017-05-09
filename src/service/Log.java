package service;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by tc on 2017/5/9.
 */
public class Log implements MethodBeforeAdvice {
//    public void logRecord() {
//
//
//        String path = new Thread().currentThread().getContextClassLoader().getResource("") + "../../../Log/log.txt";
//        //获得当前路径后前面会有一段file: 需要去掉 不然mac端无法createNewFile
////        System.out.println(path);
//        if (path.contains("file:")) {
//            URL url = FileTest.class.getResource("");
//            try {
//                path = new File(url.toURI()).getAbsolutePath() + "/../../../../Log/log.txt";
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//        }
//
//        File outFile = new File(path);
//
//        String subject;
//        String behavior;
//        String parameter;
//        try {
//
//            if (!outFile.exists()) {
////                System.out.println(path);
//
//                outFile.createNewFile();
//
//            }
//            FileOutputStream fos = new FileOutputStream(outFile);
//            fos.write(lalalalalala);
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("hello");
        System.out.println(method);
        System.out.println(objects);
        System.out.println(o);

    }
}
