package observer;

import java.util.ArrayList;

public class GroupAdmin  implements Sender
{
    private ArrayList<Member> _members;
    private UndoableStringBuilder _usb;

    public GroupAdmin()
    {
        this._members = new ArrayList<Member>();
        this._usb = new UndoableStringBuilder();
    }

    @Override
    public void register(Member newMember)
    {
        this._members.add(newMember);
    }

    @Override
    public void unregister(Member oldMmber)
    {
        this._members.remove(oldMmber);
    }

    @Override
    public void insert(int offset, String str)
    {
        this._usb.insert(offset, str);
        push();
    }

    @Override
    public void append(String str)
    {
        this._usb.append(str);
        push();
    }

    @Override
    public void delete(int start, int end)
    {
        this._usb.delete(start,end);
        push();
    }

    @Override
    public void undo()
    {
        this._usb.undo();
        push();
    }

    private void push()
    {
        for(int i=0; i< this._members.size(); i++)
        {
            this._members.get(i).update(new UndoableStringBuilder(this._usb));
        }
    }
}
