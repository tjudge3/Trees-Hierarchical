
In this unit, we have examined binary trees for sorting and searching tree sets for modeling set data structures and operations.   These data structures use trees where nodes have at most two children (leaves).  General trees can have an arbitrary number of children as shown below.  

GenericTreee.JPG

Tree data structures are very useful for modeling for all kinds of applications in many domains,  from genealogical trees in biology to organization charts,  even restaurant menus are a type of tree, if you think about it:  appetizers, side dishes, main courses, desserts, with possible sub-categories of these.  

PhylogeneticTree.png	OrgChart
Before we dig into the details of the assignment,  let's look at how a general tree can be modeled in code.   Thinking a little bit about the problem,  it is not so difficult. 

Each node in a tree is as one might expect is a node.  All nodes are the same except the root. 


Links to an external site.
In the data structure below the nodes are called SimpleTreeNode.  Notice that nodes have a data attribute.  Data can be anything, but in most cases, it has at least a name but could be a class with any number of attributes, or even an image.   

 Here it is, a node in code (absolutely poetic) : 

public class SimpleTreeNode<T>{
   private T data = null; // name or other data about the particular node
   private List<SimpleTreeNode> children = new ArrayList<>();
   private SimpleTreeNode parent = null;  // only root has a null parent
}
The "T" is just a placeholder for a type, called a generic,  that is determined at runtime since data can be any type.   Our SimpleNode class uses a generic List,  so any type of list can be used, whether it be an ArrayList, LinkedList,  or whatever we choose for our implementation.   

You may be surprised that there is no data structure to store the nodes, other than the nodes themselves since we can go up the tree using the parent, (then the parent's parent),  and down the tree using the children attribute, (and the children's children) using just a SimpleTreeNode.   

Pretty cool!

 In this assignment, you will implement code to model a problem tree structure domain of your choice, whether it be an org chart, a restaurant menu (appetizers, main dishes, salads, desserts, etc),  group-types of animals, etc.  Be creative. 

Once you have your tree model,  you will use a Java graph component to visualize your model!

Don't worry, most of the code to do all this will be given to you.  You will just need to modify the existing code to fit your problem set.  You must implement something with a theme, that is a domain of your choice.  If you turn in something Root-Child-Grandchilde-GreatGrandchild, you will get very few points. 

Let's get to it.  

Step 1:  

 Download the JGraphX2.zip Download JGraphX2.zip file and extract it into your IntelliJ IdeaProjects home directory.  My IdeaProjects home directory is at c:\users\<myUserName>\IdeaProjects 
Open the project JGraphX2 in IntelliJ by navigating to that directory and using File/Open.  
 There are two executables of interest in this project all built for you:  SimpleTreeNode and JGraphX2.   Try SimpleTreeNode first by pressing the Run menu.  If the class does not appear in the Run menu, open the class in the editor, and press the second Run.  You should see all the available executables to choose from.  Select SimpleTreeNode.   This program will load a tree data structure and print out the data.    You should see something like this:
Root:Child1:Grandchild1
Root:Child1:Grandchild2
Root:Child2:Grandchild3
Root:Child3:GrandChild4
Root:Child4
Root:Child5
Root:Child6

As you can see, this tree has a root with 6 children.  Child1 has 2 children.  Child2 and Child3 have 1 child each.   This is the textual representation of our tree.  

4.  Now you can visualize this tree using the JGraphx library by running the executable JGraphX2.   You should see a graphical version of the sample tree like this: JGraphX2

Step 2:  

Now it's your turn.  Decide what problem domain you are going to use for your tree. 
Modify the SimpleTreeNode executable and get your tree working with your data to print a textual representation of your model, as we did above.   Your tree should contain at least 15 nodes and 3-5 levels. 
 Then modify JGraphX2 such that it models your data correctly.  If you see something anomalous, for example, a line from root directly to say the third level,  or an unconnected node, you have a coding error. 
Provide a paragraph narrative of your model and the relationships you are modeling and what it all means,  in case it's not obvious.  Please model something meaningful to you.   And in your narrative tell us what have you learned. 
Include your narrative in your submission comments or as a separate document.   Your narrative and your domain choice will be at least 20% of your grade. 
Extra Credit Opportunity 
You can receive extra credit for this assignment if your nodes use a Java class instead of just a String for your data component.  You should display at least two attributes of your data class in your tree nodes.  
