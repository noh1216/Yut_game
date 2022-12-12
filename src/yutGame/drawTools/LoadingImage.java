package yutGame.drawTools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LoadingImage{
	
	public JPanel loaded_img;
	
	public LoadingImage(String PATH) {
		loaded_img = new JPanel();
		loaded_img.setPreferredSize(new Dimension(30, 70));
		loaded_img.setBackground(Color.white);
		ImageIcon IntroImgIcon = new ImageIcon(PATH);
        Image getImg = IntroImgIcon.getImage();
        Image checkImg = getImg.getScaledInstance(20, 65, Image.SCALE_SMOOTH);
        ImageIcon checkIntroImg = new ImageIcon(checkImg);
        JLabel label = new JLabel(checkIntroImg);
        loaded_img.add(label);
	}
}