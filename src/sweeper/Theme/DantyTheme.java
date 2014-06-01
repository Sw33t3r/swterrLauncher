package sweeper.Theme;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
public class DantyTheme {

	static boolean printTitleBar = false; /* Печатать заголовок сверху? true - печатать, false - наоборот. */
	static String PathToImgDir = "Theme/DantyTheme/img"; /* Путь к папке с картинками для этой темы */

	static Point mouseDownCompCoords;@SuppressWarnings("empty-statement")
	public void StartMainFrame(String header) {
		JFrame jfr = new JFrame(header); //Создаём JFrame
		mouseDownCompCoords = null; //Обнуляем координаты мыши (лютый бред)
		ImageIcon bgic = new ImageIcon(PathToImgDir + "/mainBg.png"); //Создаём ImageIcon для фона
		JLabel bg = new JLabel(bgic);
		jfr.setContentPane(bg); //Задаём наш фон ContentPane`ом
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint(); //Получаем центральную точку на мониторе
		int windowWidth = bgic.getIconWidth(); //Ширина формы по ширине фона
		int windowHeight = bgic.getIconHeight(); //Высота формы по высоте фона
		jfr.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth, windowHeight); //позиционируем и ставим размер
		jfr.setUndecorated(true); //убираем элементы управления - кнопки сверху и проч.
		jfr.setShape(new RoundRectangle2D.Double(0, 0, windowWidth, windowHeight, 7, 7)); //закругляем углы, задавая форму прямоугольника со скруглёнными углами
		JButton ExitBtn = new JButton(new ImageIcon(PathToImgDir + "/closeBtn.png")); //создаём обьект для кнопки закрытия
		ExitBtn.setBounds(windowWidth - 51, 0, 51, 27); //позиционируем и ставим размер
		ExitBtn.setBorder(null); //убираем обводку
		Component btn = jfr.add(ExitBtn); //добавляем на фрейм
		btn.addMouseListener(new MouseListener() { //добавляем MouseListener`a
			public void mouseClicked(MouseEvent e) { //если нажата кнопка...
				System.exit(0); //...то выходим
			}
			public void mousePressed(MouseEvent e) {} //костыль
			public void mouseReleased(MouseEvent e) {} //костыль
			public void mouseEntered(MouseEvent e) {} //костыль
			public void mouseExited(MouseEvent e) {} //костыль
		});
		System.out.println("Exit btn is added. Coordinates:  " + btn.getBounds().toString()); //оповещаем консольку о том, что вывели кнопку и даём координаты
		if (printTitleBar) { //если надо печатать заголовок
			Component titleBg = jfr.add(new JLabel((new ImageIcon(PathToImgDir + "/headerBg.png"))));
			titleBg.setBounds(0, 0, windowWidth, 27);
			System.out.println("Title background is added. Coordinates:  " + titleBg.getBounds().toString());
			Component title = jfr.add(new JLabel(header));
			title.setBounds(7, 0, windowWidth, 27);
			title.setForeground(Color.WHITE);
			System.out.println("Title is printed. Coordinates:  " + title.getBounds().toString());
		} else { //если не надо печатать заголовок
			Component title2 = jfr.add(new JLabel(header));
			title2.setBounds((jfr.getWidth() / 2) - 70 /* -70 == width of title:2 */ , ((jfr.getHeight() / 2) - 130) + 20, 140, 20);
			title2.setForeground(Color.WHITE);
			title2.setFont(new Font("There comes a name of font; The name of font is James Bond", Font.PLAIN, 19)); /* This is not joke. Really Bond.*/
			System.out.println("Title is printed. Coordinates:  " + title2.getBounds().toString());
		}


		Component LoginField = TextField(sweeper.Config.LoginPlaceholder, new Rectangle((jfr.getWidth() / 2) - 130 /* -60 == width of title:2 */ , ((jfr.getHeight() / 2) - 75) + 20, 260, 45), jfr);
		Component PasswordField = TextField(sweeper.Config.PasswordPlaceholder, new Rectangle((jfr.getWidth() / 2) - 130 /* -60 == width of title:2 */ , ((jfr.getHeight() / 2) +2) - 10, 260, 45), jfr);

		Component EnterBtn = Button(sweeper.Config.EnterButtonText, jfr.getContentPane(), new Color(0, 176, 55), new Rectangle((jfr.getWidth() / 2) - 130 /* -60 == width of title:2 */ , ((jfr.getHeight() / 2) + 70) - 10, 260, 45), 17);
		EnterBtn.addMouseListener(new MouseListener() { //добавляем MouseListener`a
			public void mouseClicked(MouseEvent e) { //если нажата кнопка...
				JOptionPane.showMessageDialog(jfr, "EnterBtn is pressed. Who`s next?");
			}
			public void mousePressed(MouseEvent e) {} //костыль
			public void mouseReleased(MouseEvent e) {} //костыль
			public void mouseEntered(MouseEvent e) {} //костыль
			public void mouseExited(MouseEvent e) {} //костыль
		});

                Button("", jfr.getContentPane(), new Color(193, 193, 193), new Rectangle((jfr.getWidth()/2)-130,((jfr.getHeight() / 2) -10), 260, 1), 0);
                Button("", jfr.getContentPane(), new Color(255, 255, 255), new Rectangle((jfr.getWidth()/2)-130,(jfr.getHeight() / 2)-9, 260, 1), 0);

                JCheckBox remember = new JCheckBox(sweeper.Config.RememberText);
                remember.setBounds((jfr.getWidth() / 2) - 130  , ((jfr.getHeight() / 2) + 130) - 10, 260, 24);
                remember.setForeground(Color.WHITE);
		remember.setFont(new Font("There comes a name of font; The name of font is James Bond", Font.PLAIN, 14)); /* This is not joke. Really Bond.*/
                remember.setOpaque(false);
                remember.setBorder(null);
                remember.setIcon(new ImageIcon(PathToImgDir+"/checkboxUnchecked.png"));
                remember.setFocusPainted(false);
                remember.setSelectedIcon(new ImageIcon(PathToImgDir+"/checkboxChecked.png"));
                jfr.add(remember);
                
                
		jfr.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseReleased(e);
				bg.grabFocus();
			}@Override public void mouseReleased(MouseEvent e) {
				mouseDownCompCoords = null;
			}@Override public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}@Override public void mouseExited(MouseEvent e) {}@Override public void mouseEntered(MouseEvent e) {}
		});

		jfr.addMouseMotionListener(new MouseMotionListener() {@Override public void mouseMoved(MouseEvent e) {}@Override public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				jfr.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		jfr.setVisible(true); // Display the window
	}
	public JLabel TextField(String placeholderText, Rectangle pos, JFrame frame) {
		JTextField textField = new JTextField();
		textField.setOpaque(false);
		JLabel label = new JLabel(new ImageIcon(PathToImgDir + "/textField.png"));
		label.setLayout(new BorderLayout());
		label.add(textField);
		textField.setBounds(pos);
		label.setBounds(pos);
		textField.setBorder(null);
		textField.setFont(new Font("There comes a name of font; The name of font is James Bond", Font.PLAIN, 14)); /* This is not joke. Really Bond.*/
		textField.setBorder(BorderFactory.createCompoundBorder(
		textField.getBorder(),
		BorderFactory.createEmptyBorder(5, 17, 0, 0)));
		textField.setForeground(new Color(51, 51, 51));
		new sweeper.GhostText(textField, placeholderText);
		frame.add(label);
		return label;
	}
	public Component Button(String text, Container cont, Color color, Rectangle rect, int fontSize) {
		JButton enterBtn = new JButton(text);
		enterBtn.setBackground(color);
		enterBtn.setBounds(rect);
                enterBtn.setBorderPainted(false);
                enterBtn.setFocusPainted(false);
                enterBtn.setContentAreaFilled(false);
                enterBtn.setOpaque(true);
		enterBtn.setFont(new Font("There comes a name of font; The name of font is James Bond", Font.PLAIN, fontSize)); /* This is not joke. Really Bond.*/
		enterBtn.setForeground(Color.WHITE);
		System.out.println("btn is added. Coordinates:  " + enterBtn.getBounds().toString());
		return cont.add(enterBtn);
	}
}