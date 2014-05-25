package sweeper.Theme;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class DantyTheme {
    static Point mouseDownCompCoords;
    static String PathToImgDir = "Theme/DantyTheme/img";;
public static void StartMainFrame(String header) {
    JFrame jfr = new JFrame(header);
    mouseDownCompCoords = null;
    ImageIcon bg = new ImageIcon(PathToImgDir+"/mainBg.png");
    jfr.setContentPane(new JLabel(bg));
    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    int windowWidth = bg.getIconWidth()/2;
    int windowHeight = bg.getIconHeight()/2;
    // set position and size
    jfr.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth,windowHeight);
    jfr.setUndecorated(true);
    jfr.setShape(new RoundRectangle2D.Double(0, 0, windowWidth, windowHeight, 7, 7));
    jfr.setVisible(true); // Display the window
    JButton ExitBtn = new JButton(new ImageIcon(PathToImgDir+"/closeBtn.png"));
    ExitBtn.setBounds(windowWidth-51, 0, 51, 27);
    ExitBtn.setBorder(null);
    Component btn = jfr.add(ExitBtn);
    btn.addMouseListener(new MouseListener(){public void mouseClicked(MouseEvent e) {System.exit(0);}public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}});
    System.out.println("Exit btn is added. Coordinates:  "+btn.getBounds().toString());
    Component titleBg = jfr.add(new JLabel((new ImageIcon(PathToImgDir+"/headerBg.png"))));
    titleBg.setBounds(0, 0, windowWidth,27);
    System.out.println("Title background is added. Coordinates:  "+titleBg.getBounds().toString());
    Component title = jfr.add(new JLabel(header));
    title.setBounds(7, 0, windowWidth,27);
    title.setForeground(Color.WHITE);
    System.out.println("Title text is printed. Coordinates:  "+title.getBounds().toString());
    Component loginBg = jfr.add(new JLabel((new ImageIcon(PathToImgDir+"/loginBg.png"))));
    loginBg.setBounds((windowWidth - 300) / 2, (windowHeight - 330) / 2, 300,330);
    System.out.println("Login background is added. Coordinates:  "+loginBg.getBounds().toString());
     jfr.addMouseListener(new MouseListener(){
           @Override public void mouseReleased(MouseEvent e) {mouseDownCompCoords = null;}
           @Override public void mousePressed(MouseEvent e) { mouseDownCompCoords = e.getPoint();}
           @Override public void mouseExited(MouseEvent e) {} @Override public void mouseEntered(MouseEvent e) {}@Override public void mouseClicked(MouseEvent e) {}
        });

        jfr.addMouseMotionListener(new MouseMotionListener(){
           @Override public void mouseMoved(MouseEvent e) {}
           @Override public void mouseDragged(MouseEvent e) {Point currCoords=e.getLocationOnScreen();jfr.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);}
        });
  }}
