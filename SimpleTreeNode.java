import java.util.*;

public class SimpleTreeNode<T>{
    private T data;
    private final List<SimpleTreeNode> children = new ArrayList<>();
    private SimpleTreeNode parent = null;

    public SimpleTreeNode(T data) {
        this.data = data;
    }

    public void addChild(SimpleTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        SimpleTreeNode<T> newChild = new SimpleTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<SimpleTreeNode> children) {
        for(SimpleTreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<SimpleTreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(SimpleTreeNode parent) {
        this.parent = parent;
    }

    public SimpleTreeNode getParent() {
        return parent;
    }

    public  String getParents(SimpleTreeNode node)
    {
        Deque stack = new LinkedList<SimpleTreeNode>();
        String path="";
        SimpleTreeNode parentNode = node.getParent();
        while (parentNode != null)
        {
            stack.push(parentNode);
            parentNode = parentNode.getParent();
        }
        Iterator<SimpleTreeNode> itr = stack.iterator();
        while (itr.hasNext()) {
            path = path + ((SimpleTreeNode) itr.next()).data + ":";
        }
        return path;
    }

    public int childCount()
    {
        return (int)getChildren().stream().count();
    }

    public void printChildren(SimpleTreeNode node)
    {
        if (node.parent != null)
        {
            CuriaLocal diocese = (CuriaLocal) node.getData();

            if(diocese.isRoot())
            {
                System.out.println("------{ " + diocese.getName() + " }------");
            }
            else
            {
                System.out.println("Office: " + diocese.getName() + " Administrator: " + diocese.getPerson());
            }

            if (node.children.size() != 0)
            {
                for(Object child : node.getChildren())
                {
                    SimpleTreeNode subCourse = (SimpleTreeNode) child;
                    if (subCourse.children.size() == 0)
                    {
                        CuriaLocal dioceseChild = (CuriaLocal) subCourse.getData();
                        System.out.println("Office: " + dioceseChild.getName() + " Administrator: " + dioceseChild.getPerson());
                    } else {
                        printChildren(subCourse);
                    }
                }
            }
        }
     //         System.out.println(node.data);
    }

    public static void main(String[] args)
    {
        SimpleTreeNode<CuriaLocal> root = new SimpleTreeNode<CuriaLocal>(new CuriaLocal("Bishop", "Michael Whitehead", true));

        SimpleTreeNode<CuriaLocal> judicialVicar = new SimpleTreeNode<>(new CuriaLocal("Judicial Vicar", "Gregory Bruce", true));
        judicialVicar.addChild(new CuriaLocal("Investigations Office", "Tobias Bussiek", false));
        judicialVicar.addChild(new CuriaLocal("Public Relations", "Mirvan Dinler", false));
        SimpleTreeNode<CuriaLocal> judicialA = new SimpleTreeNode<>(new CuriaLocal("Tribunals", "David Dorfman", true));
        judicialA.addChild(new CuriaLocal("Office of Parishioners", "Justin Drenth", false));
        judicialA.addChild(new CuriaLocal("Office of Priests", "Mrudula Esarapu", false));
        judicialVicar.addChild(judicialA);


        SimpleTreeNode<CuriaLocal> seminaryBishop = new SimpleTreeNode<>(new CuriaLocal("Seminary Aux Bishop", "Zachary Halsey", true));
        SimpleTreeNode<CuriaLocal> seminaryA = new SimpleTreeNode<>(new CuriaLocal("Dean of Student Affairs", "Vasilis Hughes", true));
        seminaryA.addChild(new CuriaLocal("Financial Aid Coordinator", "Caleb Jackson", false));
        seminaryA.addChild(new CuriaLocal("Registrar and Admissions", "Joshua Paul Keen", false));
        seminaryBishop.addChild(seminaryA);


        SimpleTreeNode<CuriaLocal> clergyVicar = new SimpleTreeNode<>(new CuriaLocal("Vicar for Clergy", "Nana Kyeremeh", true));
        SimpleTreeNode<CuriaLocal> clergyA = new SimpleTreeNode<>(new CuriaLocal("Director of Vocations", "Ambelion Latollari", true));
        clergyA.addChild(new CuriaLocal("Director of Seminarians", "William Martin", false));
        SimpleTreeNode<CuriaLocal> clergyB = new SimpleTreeNode<>(new CuriaLocal("Director Ongoing Formation", "Eric McCray", true));
        clergyB.addChild(new CuriaLocal("Director of Priests", "Aleksandr Mustyatse", false));
        SimpleTreeNode<CuriaLocal> clergyC = new SimpleTreeNode<>(new CuriaLocal("Director Diaconate", "Dosseh Noel Nador", false));
        clergyC.addChild(new CuriaLocal("Deacon Formations", "Phi Nguyen", false));
        clergyB.addChild(clergyC);
        clergyVicar.addChild(clergyA);
        clergyVicar.addChild(clergyB);

        SimpleTreeNode<CuriaLocal> curiaMod = new SimpleTreeNode<>(new CuriaLocal("Moderator of the Curia", "Joshua Onewo", true));
        SimpleTreeNode<CuriaLocal> curiaModA = new SimpleTreeNode<>(new CuriaLocal("Director of Cemeteries", "Madilyn Reed", true));
        curiaModA.addChild(new CuriaLocal("Director of Faith Formation", "Brittany Smith", false));
        SimpleTreeNode<CuriaLocal> curiaModB = new SimpleTreeNode<>(new CuriaLocal("Parish Services & Support", "Daniel Stein", true));
        curiaModB.addChild(new CuriaLocal("Coordinator Planning Initiatives", "Merhawi Tesfay", false));
        SimpleTreeNode<CuriaLocal> curiaModC = new SimpleTreeNode<>(new CuriaLocal("Office of Parishes", "Jonathan Alpizar", true));
        SimpleTreeNode<CuriaLocal> curiaModD = new SimpleTreeNode<>(new CuriaLocal("Local Parish Pastor", "Tom Judge", true));
        curiaModD.addChild(new CuriaLocal("Parish School", "Merhawi Tesfay", false));
        curiaModD.addChild(new CuriaLocal("Advisory Board", "Persons Name", false));//I ran out of people in the class
        SimpleTreeNode<CuriaLocal> curiaModE = new SimpleTreeNode<>(new CuriaLocal("Parish Councils", "Coordinator", true));
        curiaModE.addChild(new CuriaLocal("Finance Committee", "Persons Name", false));
        curiaModE.addChild(new CuriaLocal("Outreach Board", "Persons Name", false));
        curiaModE.addChild(new CuriaLocal("Liturgical Commission", "Persons Name", false));
        curiaModD.addChild(curiaModE);
        curiaModC.addChild(curiaModD);
        curiaModB.addChild(curiaModC);
        curiaMod.addChild(curiaModA);
        curiaMod.addChild(curiaModB);


        root.addChild(judicialVicar);
        root.addChild(seminaryBishop);
        root.addChild(clergyVicar);
        root.addChild(curiaMod);

        for (SimpleTreeNode child: root.getChildren())
        {
            root.printChildren(child);
        }
    }


}
