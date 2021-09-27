import java.util.Scanner;

/**
 * Project name(项目名称)：商品信息查询 commodity_information_query
 * Package(包名): PACKAGE_NAME
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/9/27
 * Time(创建时间)： 20:03
 * Version(版本): 1.0
 * Description(描述)：
 * 假设在仓库系统中，每件商品都有 3 个库存信息，分别是入库量、出库量和当前库存量。
 * 定义一个一维数组来存储 5 件商品的名称，并定义一个二维数组来存储这 5 件商品的 3 个库存信息。
 * 用户可以根据商品名称查询该商品的所有库存，也可以查看某个类别库存下数量小于 100 的商品名单，
 * 并将该类别的所有库存量按从低到高的顺序排列。
 */

public class test
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String[] products = {"洗衣液", "牙膏", "牙刷", "洗洁精", "水"};
        int[][] amounts = {{60, 98, 57}, {99, 25, 47}, {66, 63, 52}, {58, 47, 22}, {65, 22, 23}};
        System.out.println("*************** 库存系统 ***************");
        System.out.println("请输入要查询库存信息的商品名称：");
        String name = input.next();
        for (int i = 0; i < products.length; i++)
        {
            if (products[i].equals(name))
            {
                System.out.println("商品【" + products[i] + "】的库存信息如下：");
                System.out.println("入库\t\t出库\t\t库存");
                for (int j = 0; j < 3; j++)
                {
                    System.out.print(amounts[i][j] + "\t\t");
                }
                break;
            }
        }
        System.out.println("\n*************** 查询库存不足 100 的商品 ***************");
        System.out.println("1.入库\t\t2.出库\t\t3.库存");
        System.out.println("请输入序号：");
        int no = input.nextInt();
        int[] temp = new int[5]; // 定义数组，存储该类别的所有商品
        System.out.println("该类别下数量较少的商品有：");
        for (int i = 0; i < 5; i++)
        {
            temp[i] = amounts[i][no - 1]; // 将指定类别的所有商品名称存储到temp数组中
            if (amounts[i][no - 1] < 60)
            {
                System.out.print(products[i] + "\t\t");
            }
        }
        // 使用冒泡排序，将商品的库存量以从低到高的顺序排列
        for (int i = 1; i < temp.length; i++)
        {
            for (int j = 0; j < temp.length - i; j++)
            {
                if (temp[j] > temp[j + 1])
                {
                    int x = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = x;
                }
            }
        }
        System.out.println("\n该类别的商品库存信息从低到高的排列如下：");
        for (int i = 0; i < temp.length; i++)
        {
            System.out.print(temp[i] + "\t\t");
        }
    }
}
