package observer;

public class Account extends ConcreteMember
{
    private String _name;

    public Account(String name)
    {
        this._name = name;
    }

    public String get_name()
    {
        return _name;
    }
}
