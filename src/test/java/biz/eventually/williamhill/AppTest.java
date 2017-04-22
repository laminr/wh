package biz.eventually.williamhill;

import biz.eventually.williamhill.bean.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    // Set/Get label w/ or w/out the constructor
    public void getLabel() {
        final String LABEL  = "set Node Label";

        Node node = new Node();
        Assert.assertNull(node.getLabel());

        node.setLabel(LABEL);
        Assert.assertEquals(LABEL, node.getLabel());

        Node nodeWithLabel = new Node(LABEL);
        Assert.assertEquals(LABEL, nodeWithLabel.getLabel());
    }

    @Test
    // 3. The ability to add a child node
    public void addChildToNode() {

        Node parent = new Node();
        Node child = new Node();

        Assert.assertEquals(0, parent.getChildren().size());

        parent.addChild(child);
        Assert.assertEquals(1, parent.getChildren().size());
        Assert.assertEquals(child.getLabel(), parent.getChildren().get(0).getLabel());

    }

    @Test
    // 4. The ability to add a parent node
    public void addParentToNode() {

        Node parent = new Node("addParentToNode Parent");
        Node child = new Node();

        Assert.assertEquals(0, parent.getParents().size());

        child.addParent(parent);
        Assert.assertEquals(1, child.getParents().size());
        Assert.assertEquals(parent.getLabel(), child.getParents().get(0).getLabel());
    }

    @Test
    // 5. For any given node, return the nodes children
    public void getChildNode() {
        Node football = new Node("football");
        Node competition = new Node("competition");
        Node player = new Node("player");

        Assert.assertEquals(0, football.getChildren().size());

        football.addChild(competition);
        football.addChild(player);

        Assert.assertEquals(2, football.getChildren().size());
    }

    @Test
    // 6. For any given node, return the list of all descendant nodes
    public void getDescendant() {
        Node graph = createDescendants();

        Assert.assertEquals(6, graph.getDescendant().size());
    }

    @Test
    // 7. For any given node, return the list of all parent nodes
    public void getParents() {
        Node graph = createAscending();

        Assert.assertEquals(4, graph.getAscending().size());
    }


    /***
     *  Creates descending from Football
     * @return
     */
    private Node createDescendants() {

        Node football = new Node("football");
        Node competition = new Node("competition");
        Node player = new Node("player");
        Node premier = new Node("premier");
        Node champions = new Node("champions");
        Node manCity = new Node("manCity");
        Node manUtd = new Node("manUtd");

        football.addChild(competition);
        football.addChild(player);

        competition.addChild(premier);
        competition.addChild(champions);

        premier.addChild(manCity);
        premier.addChild(manUtd);

        champions.addChild(manUtd);

        return football;
    }

    /***
     * Creates Ascending from Man Utd and Up to Football
     * @return
     */
    private Node createAscending() {

        Node football = new Node("football");
        Node competition = new Node("competition");
        Node premier = new Node("premier");
        Node champions = new Node("champions");
        Node manUtd = new Node("manUtd");

        competition.addParent(football);

        premier.addParent(competition);
        champions.addParent(competition);

        manUtd.addParent(premier);
        manUtd.addParent(champions);

        return manUtd;
    }


}
