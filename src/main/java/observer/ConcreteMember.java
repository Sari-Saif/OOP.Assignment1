package observer;

public class ConcreteMember implements Member
{
    private UndoableStringBuilder _usb;

    public ConcreteMember()
    {
        this._usb = new UndoableStringBuilder();
    }

    @Override
    public void update(UndoableStringBuilder usb)
    {
        this._usb = usb;
        System.out.println("updated");
    }

    public UndoableStringBuilder get_usb()
    {
        return this._usb;
    }
}
