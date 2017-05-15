package br.pucpr.imagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Mostra como criar uma imagem vermelha no Java
 */
public class Exemplo1 {
    public static void main(String[] args) throws IOException {
        //Cria na memória uma imagem com 40 pixels de largura e 30 de altura
        BufferedImage img = new BufferedImage(40, 30, BufferedImage.TYPE_INT_RGB);

        //Percorre cada um dos pixels da imagem.
        for (int y = 0; y < img.getHeight(); y++) {     //Para cada linha
            for (int x = 0; x < img.getWidth(); x++) {  //Cada cada coluna
                //Define a cor vermelha para o pixel.
                img.setRGB(x, y, 0x00FF0000);
            }
        }

        //Salva a imagem no disco
        ImageIO.write(img, "jpg", new File("red.jpg"));
    }
}
