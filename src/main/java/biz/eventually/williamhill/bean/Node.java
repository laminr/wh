package biz.eventually.williamhill.bean;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by laminr on 20/04/2017.
 */
@Getter
@Setter
@NoArgsConstructor
public class Node {

    private String label;

    private List<Node> children = new ArrayList<>();
    private List<Node> parents = new ArrayList<>();

    public Node(String label) {
        this.label = label;
    }

    private void addNode(List<Node> nodes, final Node node) {
        if (node != null) {
            nodes.add(node);
        }
    }

    public void addChild(final Node node) {
        addNode(children, node);
    }

    public void addParent(final Node node) {
        addNode(parents, node);
    }

    public List<Node> getAscending() {
        Set<Node> nodes = new HashSet<>();
        nodes.addAll(parents);

        parents.forEach(c  -> getRelatives(nodes, c::getParents, true));

        return new ArrayList<>(nodes);
    }

    public List<Node> getDescendant() {

        Set<Node> nodes = new HashSet<>();
        nodes.addAll(children);

        children.forEach(c  -> getRelatives(nodes, c::getChildren, false));

        return new ArrayList<>(nodes);
    }

    private void getRelatives(Set<Node> nodes, Supplier<List<Node>> relatives, boolean gettingUp) {

        relatives.get().forEach(c  -> {
            nodes.add(c);
            Supplier<List<Node>> s = gettingUp ? c::getParents : c::getChildren;
            getRelatives(nodes, s, gettingUp);
        });
    }

}
