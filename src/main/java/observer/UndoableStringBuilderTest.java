package observer;

import org.junit.jupiter.api.Test;


class UndoableStringBuilderTest
{
    @Test
    void append()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        String check = "to be or not to be ";
        usb.append(check);
        assert usb.toString().equals((check));
    }

    @Test
    void delete()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        String before = "to be or not to be";
        String  after = "to be or to be";
        usb.append(before);

        // delete the word "not"
        usb.delete(9,13);
        assert usb.toString().equals(after) ;
    }

    @Test
    void insert()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        String before = "to be or to be";
        String  after = "to be or not to be";

        usb.append(before);

        // insert the word "not"
        usb.insert(9,"not ");
        assert usb.toString().equals(after) ;
    }

    @Test
    void replace()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        String before = "Game Of Life!";
        String  after = "Game Of Death!";

        usb.append(before);

        // replace the word "Life"
        usb.replace(8,before.length()-1,"Death");
        assert usb.toString().equals(after) ;
    }

    @Test
    void reverse()
    {
        UndoableStringBuilder usb0 = new UndoableStringBuilder();
        UndoableStringBuilder usb1 = new UndoableStringBuilder();

        String before0 = "sari";
        String  after0 = "iras";
        String palindrom = "abcdcba";

        usb0.append(before0);
        usb1.append(palindrom);

        usb0.reverse();
        usb1.reverse();

        assert usb0.toString().equals(after0) ;
        assert usb1.toString().equals(palindrom) ;
    }

    @Test
    void undo()
    {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be") ;
        assert usb.toString().equals("to be or not to be");

        usb.replace(3, 5, "eat") ;
        assert usb.toString().equals("to eat or not to be");

        usb.replace(17, 19, "eat") ;
        assert usb.toString().equals("to eat or not to eat");

        usb.reverse();
        assert usb.toString().equals("tae ot ton ro tae ot");

        usb.undo();
        assert usb.toString().equals("to eat or not to eat");

        usb.undo();
        assert usb.toString().equals("to eat or not to be");

        usb.undo();
        assert usb.toString().equals("to be or not to be");
    }
}
