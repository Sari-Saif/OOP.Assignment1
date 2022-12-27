package observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest
{
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

        ga.register(guest_0);
        ga.append("heyyyyyyyyyyyyyyy");

        ga.unregister(guest_0);
        ga.append("1");
        assertNotEquals("heyyyyyyyyyyyyyyy1",guest_0.get_usb());
    }

    @Test
    void insert()
    {
        GroupAdmin leader = new GroupAdmin();
        ConcreteMember new_solder = new ConcreteMember();
        ConcreteMember new_solder1 = new ConcreteMember();
        ConcreteMember new_solder0 = new ConcreteMember();

        leader.register(new_solder);
        leader.register(new_solder0);
        leader.register(new_solder1);

        leader.insert(0,"every one to gather around me !!");
        assertEquals("every one to gather around me !!",new_solder.get_usb().toString());
        assertEquals("every one to gather around me !!",new_solder0.get_usb().toString());
        assertEquals("every one to gather around me !!",new_solder1.get_usb().toString());


        String check = " soldier number one died !!! ";
        leader.unregister(new_solder1);
        leader.insert(31,check);

        assertEquals("every one to gather around me ! soldier number one died !!! !",new_solder.get_usb().toString());
        assertEquals("every one to gather around me ! soldier number one died !!! !",new_solder0.get_usb().toString());
        assertNotEquals("every one to gather around me ! soldier number one died !!! !",new_solder1.get_usb().toString());
    }

    @Test
    void append()
    {
        GroupAdmin leader = new GroupAdmin();
        ConcreteMember new_solder = new ConcreteMember();
        ConcreteMember new_solder1 = new ConcreteMember();
        ConcreteMember new_solder0 = new ConcreteMember();

        leader.register(new_solder);
        leader.register(new_solder0);
        leader.register(new_solder1);

        leader.append("every one listen to me !! ");
        assertEquals("every one listen to me !! ",new_solder.get_usb().toString());
        assertEquals("every one listen to me !! ",new_solder0.get_usb().toString());
        assertEquals("every one listen to me !! ",new_solder1.get_usb().toString());

        leader.unregister(new_solder1);
        String check = "to be or not to be ";
        leader.append(check);

        assertEquals("every one listen to me !! to be or not to be ",new_solder.get_usb().toString());
        assertEquals("every one listen to me !! to be or not to be ",new_solder0.get_usb().toString());
        assertNotEquals("to me !! to be or not to be ",new_solder1.get_usb().toString());

    }

    @Test
    void delete()
    {
        GroupAdmin leader = new GroupAdmin();
        ConcreteMember new_solder = new ConcreteMember();
        ConcreteMember new_solder1 = new ConcreteMember();
        ConcreteMember new_solder0 = new ConcreteMember();

        leader.register(new_solder);
        leader.register(new_solder0);
        leader.register(new_solder1);

        leader.append("every one listen to me !! ");
        assertEquals("every one listen to me !! ",new_solder.get_usb().toString());
        assertEquals("every one listen to me !! ",new_solder0.get_usb().toString());
        assertEquals("every one listen to me !! ",new_solder1.get_usb().toString());

        leader.unregister(new_solder1);
        String check = "to be or not to be ";
        leader.append(check);
        leader.unregister(new_solder);
        leader.unregister(new_solder0);
        leader.delete(0,16);
        assertEquals("every one listen to me !! to be or not to be ",new_solder.get_usb().toString());
        assertEquals("every one listen to me !! to be or not to be ",new_solder0.get_usb().toString());
        assertEquals("every one listen to me !! ",new_solder1.get_usb().toString());


    }

    @Test
    void undo()
    {

        GroupAdmin admin= new GroupAdmin();
        ConcreteMember member_isalive = new ConcreteMember();
        admin.register(member_isalive);
        admin.append("hi ") ;
        admin.append("nanana");
        admin.undo();
        assertTrue("hi ".equals(member_isalive.get_usb().toString()));
    }
}