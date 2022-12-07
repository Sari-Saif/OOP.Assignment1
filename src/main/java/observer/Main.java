package observer;


public class Main
{
    public static void main(String [] args)
    {

        // in our main we test all
        // we want not in format of Junit :)
        GroupAdmin ga = new GroupAdmin();
        ConcreteMember guest_0 = new ConcreteMember();
        ConcreteMember guest_1 = new ConcreteMember();
        ConcreteMember guest_2 = new ConcreteMember();

        ga.register(guest_0);
        ga.register(guest_1);
        ga.register(guest_2);

        ga.append("heyyyyyyyyyyyyyyy");

        System.out.println(guest_0.get_usb());
        System.out.println(guest_1.get_usb());
        System.out.println(guest_2.get_usb());

    }




}
