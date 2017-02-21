import javax.swing.*;

/**
 * Created by tuchang on 21/02/2017.
 */
public class Window extends JFrame {
    static JButton jb = new JButton();



    public static void main(String[] args)
    {
        Window w = new Window();
        w.add(jb);
        w.pack();
        w.setVisible(true);
        w.setTitle("silhouette");
    }
}
