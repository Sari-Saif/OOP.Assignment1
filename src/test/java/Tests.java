import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.Locale;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){

        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member_0 = new ConcreteMember();
        ConcreteMember member_1 = new ConcreteMember();
        admin.register(member_0);
        admin.register(member_1);
        String s1 = "Alice";
        String s2 = "Bob";
        admin.insert(0,s1);
        admin.append("and " + s2 + " love each other ! :)");


        logger.info(()->JvmUtilities.objectFootprint(admin));
        logger.info(()->JvmUtilities.objectFootprint(member_0,member_1));
        logger.info(()->JvmUtilities.objectTotalSize(member_0));
        logger.info(()->JvmUtilities.objectTotalSize(member_1));
        logger.info(()->JvmUtilities.objectTotalSize(admin));


        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    public void ConcreteMember_test()
    {

        UndoableStringBuilder str = new UndoableStringBuilder();
        ConcreteMember Bob_Alice = new ConcreteMember();
        for (int i = 0 ; i< 1000 ; i++)
        {
            str.append("Bob loves Alice loves ");
            Bob_Alice.update(new UndoableStringBuilder(str));
        }

        logger.info(()->JvmUtilities.objectFootprint(Bob_Alice , str));
        logger.info(()->JvmUtilities.objectTotalSize(Bob_Alice));

        for (int i = 0 ; i< 1000 ; i++)
        {
            str.undo();
            Bob_Alice.update(new UndoableStringBuilder(str));
        }

        logger.info(()->JvmUtilities.objectFootprint(Bob_Alice));
        logger.info(()->JvmUtilities.objectTotalSize(Bob_Alice));


        logger.info(() -> JvmUtilities.jvmInfo());

        // remember: we want more good runtime than memory


    }
    @Test
    public void UndoableStringBuilder_test()
    {

        UndoableStringBuilder str = new UndoableStringBuilder();
        for (int i = 0 ; i< 1000 ; i++)
        {
            str.append("shoshi is the best the best is  ");
        }

        logger.info(()->JvmUtilities.objectFootprint(str));
        logger.info(()->JvmUtilities.objectTotalSize(str));

        for (int i = 0 ; i< 1000 ; i++)
        {
            str.undo();
        }

        logger.info(()->JvmUtilities.objectFootprint(str));
        logger.info(()->JvmUtilities.objectTotalSize(str));


        logger.info(() -> JvmUtilities.jvmInfo());

        // remember: we want more good runtime than memory
    }
    @Test
    public void GroupAdmin_test()
    {

        GroupAdmin admin = new GroupAdmin();
        ArrayList<Member> members_list = new ArrayList<>();
        for (int i = 0 ; i< 1000 ; i++)
        {
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            members_list.add(member);
        }
        admin.append(" WOW how many members follow me ?!!");

        logger.info(()->JvmUtilities.objectFootprint(admin));
        logger.info(()->JvmUtilities.objectTotalSize(admin));

        for (int i = 0 ; i< 1000 ; i++)
        {

            admin.unregister(members_list.get(i));
        }

        logger.info(()->JvmUtilities.objectFootprint(admin));
        logger.info(()->JvmUtilities.objectTotalSize(admin));


        logger.info(() -> JvmUtilities.jvmInfo());

        // remember: we want more good runtime than memory
    }

}
