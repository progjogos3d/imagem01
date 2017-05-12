import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Mostra como carregar uma imagem do disco e alterar sua cor utilizando a classe Color
 */
public class Exemplo2 {
    //Caminho onde a pasta de imagens está
    //Altere para o correspondente em sua máquina
    private static final File PATH = new File("/Users/vinigodoy/img");

    public static void main(String args[]) throws Exception {
        BufferedImage img = ImageIO.read(new File(PATH, "/cor/puppy.jpg"));

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Le o pixel da imagem
                Color p = new Color(img.getRGB(x,y));

                //Inverte os canais Blue e Red
                Color i = new Color(p.getBlue(), p.getGreen(), p.getRed());

                //Alteramos o pixel
                img.setRGB(x, y, i.getRGB());
            }
        }

        ImageIO.write(img, "jpg", new File("bgr_puppy.jpg"));
    }
}
