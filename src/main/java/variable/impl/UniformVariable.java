/*
 * EuroRisk Systems (c) Ltd. All rights reserved.
 */
package variable.impl;

import javax.xml.bind.annotation.XmlElement;
import variable.AbstractVariable;

/**
 *
 * @author sdaskalov
 */
public class UniformVariable extends AbstractVariable {

    private static final double defaultLowerBound = 0.0;
    private static final double defaultUpperBound = 1.0;

    @XmlElement(name = "lowerBound")
    private double lowerBound;
    @XmlElement(name = "upperBound")
    private double upperBound;

    public UniformVariable() {
        super();
        lowerBound = defaultLowerBound;
        upperBound = defaultUpperBound;
    }

    public UniformVariable(String id, long seed) {
        this(id, seed, defaultLowerBound, defaultUpperBound);
    }

    public UniformVariable(String id, long seed, double lowerBound, double upperBound) {
        super(id, seed);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public double sample() {
        return lowerBound + random.nextDouble() * (upperBound - lowerBound);
    }

}
