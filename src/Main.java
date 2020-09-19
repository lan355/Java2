import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;


public class Main {

    final static List<Triangle> listN = new ArrayList<>();
    final static List<TriangleIsosceles> listM = new ArrayList<>();
    final static Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("Введите N треугольников");
        int N = readInt();
        System.out.println("Введите M равнобедренных треугольников");
        int M = readInt();

        System.out.println("Выводим треугольники:");
        float averSquare = 0;
        for(int i = 0; i < N; i++)
        {
            Triangle triangle = getRandTriangle();
            System.out.println(i + 1 + ".\n" + triangle.getInfoOfTriangle() + "\n");
            averSquare += triangle.getSquare();
            listN.add(triangle);
        }
        averSquare /= N;
        System.out.print("Средняя площадь треугольников: " + averSquare);
        System.out.println("\n");
        System.out.println("Выводим равнобедренные треугольники:");
        double maxSquare = 0;
        //TriangleIsosceles minSquareTriangleIsosceles = null;
        for(int i = 0; i < M; i++)
        {
            TriangleIsosceles isosceles = getRandTriangleIsosceles();
            System.out.println(i + 1 + ".\n" + isosceles.getInfoOfTriangle() + "\n");
            if(isosceles.getSquare() > maxSquare)
            {
                maxSquare = isosceles.getSquare();
            }
            listM.add(isosceles);
        }
        System.out.println("Треугольники равнобедренные с наибольшей площадью:" + maxSquare);

    }

    public static Triangle getRandTriangle()
    {

        return new Triangle((double) random.nextInt(10) + 1,(double) random.nextInt(10) + 1,(double) random.nextInt(10) + 1);
    }

    public static TriangleIsosceles getRandTriangleIsosceles()
    {
        return new TriangleIsosceles((double) random.nextInt(8) + 1,(double) random.nextInt(8) + 1,(double) random.nextInt(8) + 1,(double) random.nextInt(8) + 1);
    }

    public static int readInt()
    {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            try
            {
                int result = Integer.parseInt(input.next());
                if(result > 0) return result;
                else
                {
                    System.out.println("Число треугольников должно > 0");
                }
            }
            catch (Exception e)
            {
                System.out.println("Введите еще раз");
            }
        }
    }
}
