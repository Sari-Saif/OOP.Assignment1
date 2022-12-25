package observer;

public class Human extends ConcreteMember
{
    private String _name;

    public Human(String name)
    {
        this._name = name;
    }

    public String get_name()
    {
        return _name;
    }
}
