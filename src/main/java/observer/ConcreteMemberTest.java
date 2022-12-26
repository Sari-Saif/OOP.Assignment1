package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update()
    {
        ConcreteMember number_one = new ConcreteMember();
        UndoableStringBuilder und = new UndoableStringBuilder();
        und.append("borntoday");
        number_one.update(und);
        assertEquals("borntoday",number_one.get_usb().toString());
    }

    @Test
    void get_usb()
    {
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember f = new ConcreteMember();
        admin.register(f);
        admin.append(" vamos meesi !!");
        assertEquals(" vamos meesi !!",f.get_usb().toString());
    }
}