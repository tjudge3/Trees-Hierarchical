public class CuriaLocal
{
    private String name;

    private String person;
    private boolean isParent;

    public CuriaLocal(String name, String person, boolean isParent)
    {
        this.name = name;
        this.person = person;
        this.isParent = isParent;
    }

    @Override
    public String toString() {return "Office: '" + name + '\'' +", Administrator: '" + person + '\'' + isParent +'}';
    }

    public String getName() {
        return name;
    }
    public String getPerson() {
        return person;
    }
    public boolean isParent(){return isParent;}

}
