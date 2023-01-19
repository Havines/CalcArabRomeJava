import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Converter converter = new Converter();

        String[] actions = {"+", "-", "/", "*"};
        String[] regActoins = {"\\+", "-", "/", "\\*"};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение в формате <2+2> или <X+X> без пробелов: ");
        String line = scanner.nextLine();

        int actionIndex =- 1;

        for (int i = 0; i < actions.length; i++)
        {
            if (line.contains(actions[i]))
            {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex==-1)
        {
            System.out.println("Неккоректный ввод");
            return;
        }

        String[] data = line.split(regActoins[actionIndex]);

        if (converter.isRoman(data[0]) == converter.isRoman(data[1]))
        {
            int a,b;

            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman)
            {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }
            else
            {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (actions[actionIndex])
            {
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if (isRoman)
            {
                System.out.println(converter.intToRoman(result));
            }
            else
            {
                System.out.println(result);
            }
        }
        else
        {
            System.out.println("Числа должны быть в одном формате");
        }
    }
}
