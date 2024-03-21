
public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("����")
                .setSurname("�����")
                .setAge(31)
                .setAddress("������")
                .build();
        System.out.println(mom.toString());
        Person child = mom.newChildBuilder().setName("�����").setAge(1).build();

        System.out.println(child.toString());

        try {
            // �� ������� ������������ �����
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // ������� ������������
            new PersonBuilder().setName("������").setSurname("�������").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
