package util;

/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
import node.Node;
import node.impl.ConstantNode;
import node.impl.VariableNode;
import node.impl.binary.ExponentiationNode;
import node.impl.group.ProductNode;
import node.impl.group.SumNode;
import variable.impl.ExponentialVariable;
import variable.impl.GaussianVariable;
import variable.impl.UniformVariable;
import simulation.StochasticVariableRegistry;

/**
 *
 * @author sdaskalov
 */
public class TestHelper {

    public static StochasticVariableRegistry makeVariableRegistry(int variableCount) {
        StochasticVariableRegistry variables = new StochasticVariableRegistry();
        for (int i = 0; i < variableCount; i++) {
            double from = i * 10.0;
            double to = i * 10.0 + 10.0;
            variables.addVariable(new GaussianVariable("X" + i, 1L, (from + to) / 2.0, 1.0 / 3.0));
            variables.addVariable(new UniformVariable("Y" + i, 1L, from, to));
            variables.addVariable(new ExponentialVariable("Z" + i, 1L, 1.0));
        }
        return variables;
    }

    public static Node buildNodeTree(int treeScale) {
        SumNode rootNode = new SumNode();
        for (int i = 0; i < treeScale; i++) {
            ProductNode product = new ProductNode();
            product.addChild(new VariableNode("X" + i));
            product.addChild(new VariableNode("Y" + i));
            product.addChild(new ExponentiationNode(
                    new VariableNode("Z" + i),
                    new ConstantNode(2.0)
            ));
            rootNode.addChild(product);
        }
        rootNode.setDescription("This is the sum of all the trucks I give");
        return rootNode;
    }

    public static Node buildComplexNodeTree() {
        return null;
    }
}
