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
    // The ability to add a child node
    public void addChildToNode() {

        Node parent = new Node();
        Node child = new Node();
        child.setLabel("addChildToNode Child");

        Assert.assertEquals(0, parent.getChildren().size());

        parent.addChild(child);
        Assert.assertEquals(1, parent.getChildren().size());
        Assert.assertEquals(child.getLabel(), parent.getChildren().get(0).getLabel());

    }

    @Test
    // The ability to add a parent node
    public void addParentToNode() {

        Node parent = new Node();
        parent.setLabel("addParentToNode Parent");

        Node child = new Node();

        Assert.assertEquals(0, parent.getParents().size());

        child.addParent(parent);
        Assert.assertEquals(1, child.getParents().size());
        Assert.assertEquals(parent.getLabel(), child.getParents().get(0).getLabel());
    }

    @Test
    // For any given node, return the nodes children
    public void getChildNode() {
        Node football = new Node();
        football.setLabel("football");

        Node competition = new Node();
        competition.setLabel("competition");

        Node player = new Node();
        player.setLabel("player");

        Assert.assertEquals(0, football.getChildren().size());

        football.addChild(competition);
        football.addChild(player);

        Assert.assertEquals(2, football.getChildren().size());
    }

    @Test
    // For any given node, return the list of all descendant nodes
    public void getDescendant() {
        Node graph = createDescendants();

        Assert.assertEquals(6, graph.getDescendant().size());
    }

    @Test
    public void getParents() {
        Node graph = createAscending();

        Assert.assertEquals(4, graph.getAscending().size());
    }


    private Node createDescendants() {

        Node football = new Node();
        football.setLabel("football");

        Node competition = new Node();
        competition.setLabel("competition");

        Node player = new Node();
        player.setLabel("player");

        Node premier = new Node();
        premier.setLabel("premier");

        Node champions = new Node();
        champions.setLabel("champions");

        Node manCity = new Node();
        manCity.setLabel("manCity");

        Node manUtd = new Node();
        manUtd.setLabel("manUtd");


        football.addChild(competition);
        football.addChild(player);

        competition.addChild(premier);
        competition.addChild(champions);

        premier.addChild(manCity);
        premier.addChild(manUtd);

        champions.addChild(manUtd);

        return football;
    }

    private Node createAscending() {

        Node football = new Node();
        football.setLabel("football");

        Node competition = new Node();
        competition.setLabel("competition");

        Node premier = new Node();
        premier.setLabel("premier");

        Node champions = new Node();
        champions.setLabel("champions");

        Node manUtd = new Node();
        manUtd.setLabel("manUtd");

        competition.addParent(football);

        premier.addParent(competition);
        champions.addParent(competition);

        manUtd.addParent(premier);
        manUtd.addParent(champions);

        return manUtd;
    }


}
