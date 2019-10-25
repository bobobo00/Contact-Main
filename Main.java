import javax.jws.soap.SOAPBinding;
import java.util.Scanner;



/**
 * @ClassName Main
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/24 21:25]
 * @Version 1.0
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Contact contact=new Contact();
        boolean flag=true;
        while(flag) {
            menu();
            int select=scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:add(contact,scanner); break;
                case 2:search(contact,scanner); break;
                case 3:delet(contact,scanner); break;
                case 4:update(contact,scanner); break;
                case 0:flag=false;break;
                default:
                    System.out.println("请正确输入指令");


            }
        }
    }

    private static void update(Contact contact, Scanner scanner) {
        System.out.println("请输入更新联系人姓名");
        String name=scanner.nextLine();
        if(contact.map.containsKey(name)){
            System.out.println("请输入更新联系人办公电话");
            String telephone=scanner.next();
            System.out.println("请输入更新联系人办公电话");
            String officetele=scanner.next();
            contact.updatePerson(name,telephone,officetele);
            System.out.println("更新联系人成功");
        }else {
            System.out.println("更新联系人失败，该联系不存在！");
        }
    }

    private static void delet(Contact contact, Scanner scanner) {
        System.out.println("请输入删除联系人姓名");
        String name = scanner.nextLine();
        try {
            contact.deletPerson(name);
            System.out.println("删除联系人成功");
        } catch (NullPointerPersonException e) {
            System.out.println("删除联系人失败，该联系不存在！");
        }
    }
        private static void search(Contact contact,Scanner scanner) {
        System.out.println("请输入查询联系人姓名");
        String name=scanner.nextLine();
        User person=contact.searchPerson(name);
        if(person!=null) {
            System.out.println(person);
            System.out.println("查询成功！");
        }else {
            System.out.println("查询失败，该联系人不存在！");
        }
    }
    private static void add(Contact contact, Scanner scanner){
        System.out.println("请输入联系人姓名");
        String name=scanner.nextLine();
        System.out.println("请输入联系人移动电话");
        String telephone=scanner.next();
        System.out.println("请输入联系人办公电话");
        String officetele=scanner.next();
        try {
            contact.addPerson(name,telephone,officetele);
            System.out.println("添加联系人成功");
        } catch (NameExistException e) {
            System.out.println("添加联系人失败，联系人已存在！");
        }
    }

    public static void menu(){
        System.out.println(" |    通讯录  | ");
        System.out.println(" |1：添加联系人| ");
        System.out.println(" |2：查看联系人| ");
        System.out.println(" |3：删除联系人| ");
        System.out.println(" |4：更新联系人| ");
        System.out.println(" |0：  退出   | ");
        System.out.println("请输入正确的指令：");
    }
}

