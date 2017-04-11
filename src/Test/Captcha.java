package Test;

/**
 * Created by tuchang on 11/04/2017.
 */
/**
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author WenLiang
 */
public class Captcha {

    public String sRand = "";
    public static String code = null;//!!

    public String sgbRand = "";

    public Color getRandColor(int fc, int bc) { //给定范围获得随机颜色
        Random random = new Random();

        if (fc > 255)

            fc = 255;

        if (bc > 255)

            bc = 255;

        int r = fc + random.nextInt(bc - fc);

        int g = fc + random.nextInt(bc - fc);

        int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);

    }

    public BufferedImage creatImage() {

        // 在内存中创建图象

        int width = 60, height = 20;

        BufferedImage image = new BufferedImage(width, height,

                BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文

        Graphics g = image.getGraphics();

        //生成随机类

        Random random = new Random();

        // 设定背景色

        g.setColor(getRandColor(100, 250));

        g.fillRect(0, 0, width, height);

        //设定字体

        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

        //画边框

        //g.setColor(new Color(0,0,0));

        //g.drawRect(0,0,width-1,height-1);

        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到

        g.setColor(getRandColor(160, 200));

        for (int i = 0; i < 155; i++) {

            int x = random.nextInt(width);

            int y = random.nextInt(height);

            int xl = random.nextInt(12);

            int yl = random.nextInt(12);

            g.drawLine(x, y, x + xl, y + yl);

        }

        // 取随机产生的认证码(4位数字)

        for (int i = 0; i < 4; i++) {

            String rand = String.valueOf(random.nextInt(10));

            sRand += rand;

            // 将验证码显示到图象中

            g.setColor(new Color(20 + random.nextInt(110),

                    20 + random.nextInt(110),

                    20 + random.nextInt(110)));

            g.drawString(rand, 13 * i + 6, 16);

        }
//        System.out.println("sRand:"+sRand);
        code = sRand;
        System.out.println("code:"+code);
        // 图象生效

        g.dispose();

//        System.out.println("sRand:"+sRand);
        return image;

    }

    public JLabel getCaptchaImage()
    {
        Captcha img = new Captcha();
        ImageIcon ii = new ImageIcon(img.creatImage());
//        System.out.println("sRand:"+sRand);
        System.out.println("code:"+code);
        JLabel jl = new JLabel(ii);
//        System.out.println("sRand:"+sRand);
        return jl;
    }
    public String getCaptchaCode()
    {
//        System.out.println("sRand:"+sRand);
//        return sRand;
        return code;
    }

    public static void main(String[] args) {

        Captcha img = new Captcha();
        JFrame jf = new JFrame();
        jf.setSize(200,300);

        Container ct = jf.getContentPane();
        ImageIcon ii = new ImageIcon(img.creatImage());
        JLabel jl = new JLabel(ii);
        ct.add(jl);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


}