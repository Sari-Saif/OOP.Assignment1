package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register()
    {

      GroupAdmin admin = new GroupAdmin();
      for ( int i =0 ; i < 10; i ++)
      {
           ConcreteMember newmember = new ConcreteMember();
           admin.register(newmember);
      }
        for (:
             ) {
            
        }








    }

    @Test
    void unregister() {
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