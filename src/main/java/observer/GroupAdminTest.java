package observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register()
    {
      GroupAdmin admin = new GroupAdmin();
      ArrayList<Member> members = new ArrayList<>();

      int number_of_members = 0;
      for ( int i =0 ; i < 10; i ++)
      {
           ConcreteMember newmember = new ConcreteMember();
           admin.register(newmember);
           members.add(newmember);
           number_of_members ++ ;
      }
      assertEquals(number_of_members , 10);

      // here we assert between to objects one is registered and
      // second is not one has already registered started to get
      // updates and the another initiation to be null
      // didn't have any effect from admin and the result be false
      GroupAdmin new_admin  = new GroupAdmin();
      ConcreteMember member0 = new ConcreteMember();
      ConcreteMember member1 = new ConcreteMember();;
      new_admin.append(" boker tov ");
      assertFalse(member0.get_usb().toString().equals(member1.get_usb()));


    }

    @Test
    void unregister()
    {
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

        ga.unregister(guest_0);
        ga.unregister(guest_2);
        ga.append("1");

       // assertFalse(,guest_0.get_usb().toString());
        System.out.println(guest_1.get_usb());
        System.out.println(guest_2.get_usb());
    }

    @Test
    void insert() {
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }
}