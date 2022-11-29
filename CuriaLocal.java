public class CuriaLocal
{
    private String name;
    private String person;
    private boolean isRoot;

    public CuriaLocal(String name, String person, boolean isRoot)
    {
        this.name = name;
        this.person = person;
        this.isRoot = isRoot;
    }

    public String getName() {
        return name;
    }
    public String getPerson() {
        return person;
    }
    public boolean isRoot(){return isRoot;}

}