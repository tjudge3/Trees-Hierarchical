//tjudge
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.*;
import javax.swing.*;
import java.io.Serial;
//The below imports are for experiments - not needed
import java.io.IOException;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxImage;
import com.mxgraph.view.mxStylesheet;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.awt.image.BufferedImage;
import java.io.File;

public class JGraphX2 extends JFrame {

    @Serial
    private static final long serialVersionUID = -2707712944901661771L;
    SimpleTreeNode<CuriaLocal> root = createSimpleTreeNode();


    //The default shape is cool and all, but I figured I'd try spice things up a bit by using ellipses and a rhombus
    public void fillGraphFromModel(mxGraph graph) {
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            CuriaLocal patriarchalCuria = createSimpleTreeNode().getData();
            Object vRoot = graph.insertVertex(parent, null, patriarchalCuria.getName(), 80, 0, 80, 30, "shape=rhombus;perimeter=rhombusPerimeter");

            CreateGraphPoints(graph, parent, vRoot, createSimpleTreeNode());
            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());


//This is so we can save a copy of our image - I was just experimenting with the assignment
//        BufferedImage image = mxCellRenderer.createBufferedImage(graph, null, 1, Color.WHITE, true, null);
//        try {
//            ImageIO.write(image, "PNG", new File("resources/tree.png"));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void CreateGraphPoints(mxGraph graph, Object parent, Object vRoot, SimpleTreeNode<CuriaLocal> parentNode) {
        for (SimpleTreeNode child : parentNode.getChildren()) {
            CuriaLocal diocese = (CuriaLocal) child.getData();
            //Arg's for scale and sizing
            Object curiaRoot = graph.insertVertex(parent, null, diocese.getName() + "\n" + diocese.getPerson(), 50, 30, 160, 140, "shape=ellipse;perimeter=ellipsePerimeter");
            graph.insertEdge(parent, null, "", vRoot, curiaRoot);

            if (child.childCount() > 0) {
                CreateGraphPoints(graph, parent, curiaRoot, child);
            }
        }
    }


    //I did some minor additions just for a little bit of fun.
    // But if future classes want to have some fun too, (or maybe extra credit?) the documentation of mxGraphComponent is at
    //https://jgraph.github.io/mxgraph/java/docs/com/mxgraph/swing/mxGraphComponent.html
    //Adding the various options and features definitely can add some individuality to the assignment

    public JGraphX2() {
        super("Diocesan curia");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
        graphComponent.getViewport().setOpaque(true);
        graphComponent.getViewport().setBackground(Color.PINK);
        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());
    }

    public SimpleTreeNode<CuriaLocal> createSimpleTreeNode() {
        root = new SimpleTreeNode<>(new CuriaLocal("Bishop", "Michael Whitehead", true));

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


        for (SimpleTreeNode child : root.getChildren()) {
            root.printChildren(child);
        }
        return root;
    }

    public void graphUpdate() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Object vDogsRoot = graph.insertVertex(parent, null, "Whale", 80, 0, 80, 30);
            Object v2 = graph.insertVertex(parent, null, "Shar Pei", 0, 0, 80, 30);
            Object v3 = graph.insertVertex(parent, null, "Pug", 0, 0, 80, 30);
            Object v4 = graph.insertVertex(parent, null, "Cocker Spaniel", 0, 0, 80, 30);
            Object v5 = graph.insertVertex(parent, null, "Pit Bull", 0, 0, 80, 30);
            Object v6 = graph.insertVertex(parent, null, "Chihuahua", 0, 0, 80, 30);
            Object v7 = graph.insertVertex(null, null, "GrandPuppy", 0, 0, 90, 30);
            Object v8 = graph.insertVertex(null, null, "GrandPuppy2", 0, 0, 90, 30);
            Object v9 = graph.insertVertex(null, null, "GrandPuppy3", 0, 0, 90, 30);
            graph.insertEdge(parent, null, "", vDogsRoot, v2);
            graph.insertEdge(parent, null, "", vDogsRoot, v3);
            graph.insertEdge(parent, null, "", vDogsRoot, v4);
            graph.insertEdge(parent, null, "", vDogsRoot, v5);
            graph.insertEdge(parent, null, "", vDogsRoot, v6);
            graph.insertEdge(v6, null, "", v6, v7);
            graph.insertEdge(v6, null, "", v6, v8);
            graph.insertEdge(v6, null, "", v6, v9);

            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);

            layout.execute(parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }


    public static void main(String[] args) {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 420);
        frame.setVisible(true);
    }
}