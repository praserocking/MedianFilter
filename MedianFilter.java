import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import javax.imageio.*;
/*
 * Author: Shenbaga Prasanna,IT,SASTRA University;
 * Program: Median Filter To Reduce Noice in Image
 * Date: 9/7/2013
 * Logic: Captures the colour of 8 pixels around the target pixel.Including the target pixel there will be 9 pixels.
 *        Isolate the R,G,B values of each pixels and put them in an array.Sort the arrays.Get the Middle value of the array
 *        Which will be the Median of the color values in those 9 pixels.Set the color to the Target pixel and move on!
 */
class MedianFilter{
    public static void main(String[] a)throws Throwable{
        File f=new File("photo.jpg");
        Color[] pixel=new Color[9];
        int[] R=new int[9];
        int[] B=new int[9];
        int[] G=new int[9];
        File output=new File("output.jpg");
        BufferedImage img=ImageIO.read(f);
        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
               pixel[0]=new Color(img.getRGB(i-1,j-1));
               pixel[1]=new Color(img.getRGB(i-1,j));
               pixel[2]=new Color(img.getRGB(i-1,j+1));
               pixel[3]=new Color(img.getRGB(i,j+1));
               pixel[4]=new Color(img.getRGB(i+1,j+1));
               pixel[5]=new Color(img.getRGB(i+1,j));
               pixel[6]=new Color(img.getRGB(i+1,j-1));
               pixel[7]=new Color(img.getRGB(i,j-1));
               pixel[8]=new Color(img.getRGB(i,j));
               for(int k=0;k<9;k++){
                   R[k]=pixel[k].getRed();
                   B[k]=pixel[k].getBlue();
                   G[k]=pixel[k].getGreen();
               }
               Arrays.sort(R);
               Arrays.sort(G);
               Arrays.sort(B);
               img.setRGB(i,j,new Color(R[4],B[4],G[4]).getRGB());
            }
        ImageIO.write(img,"jpg",output);
    }
}
