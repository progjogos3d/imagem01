package br.pucpr.imagem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Igual ao exemplo 2, mas usando funções.
 * Você pode usar esse arquivo como base para resolver os exercícios
 */
public class Exemplo3 {
    //Caminho onde a pasta de imagens está
    //Altere para o correspondente em sua máquina
    private static final File PATH = new File("/Users/vinigodoy/img");

    /**
     * Função para inverter os canais. Diferentemente do exemplo 2, esta função não altera a imagem original
     */
    public BufferedImage invertChannels(BufferedImage img) {
        //Cria na memória uma nova imagem, com largura e altura igual a img
        //Esta é uma boa prática.
        BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

        //Percorremos img e salvamos a alteração em out
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Le o pixel da imagem
                Color p = new Color(img.getRGB(x,y));

                //Inverte os canais Blue e Red
                Color i = new Color(p.getBlue(), p.getGreen(), p.getRed());

                //Guardamos a modificação no pixel correspondente de out
                out.setRGB(x, y, i.getRGB());
            }
        }

        //Retorna a imagem processada
        return out;
    }

    /**
     * Executa o programa
     */
    public void run() throws Exception {
        BufferedImage puppy = ImageIO.read(new File(PATH, "/cor/puppy.png"));
        BufferedImage bgrPuppy = invertChannels(puppy);
        ImageIO.write(bgrPuppy, "jpg", new File("bgr_puppy.jpg"));
    }

    /**
     * A função main é estática. Para que ela possa chamar funções não estáticas, ela deve criar um objeto da classe
     * br.pucpr.imagem.Exemplo3. Isso é feito utilizando o comando new, como no C++.
     */
    public static void main(String[] args) throws Exception  {
        new Exemplo3().run();
    }
}
