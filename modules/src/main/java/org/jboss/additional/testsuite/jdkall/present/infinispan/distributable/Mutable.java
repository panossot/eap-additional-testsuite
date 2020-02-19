package org.jboss.additional.testsuite.jdkall.present.infinispan.distributable;

import java.io.IOException;
import java.io.Serializable;
import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

/**
 * A simple class to be used by the servlet in order to generate values 
 * to be stored by the session.
 */
@EapAdditionalTestsuite({"modules/testcases/jdkAll/Wildfly/infinispan/src/main/java#19.0.0.Beta1","modules/testcases/jdkAll/Eap7/infinispan/src/main/java#3.0.0","modules/testcases/jdkAll/Eap72x/infinispan/src/main/java#7.2.8","modules/testcases/jdkAll/Eap72x-Proposed/infinispan/src/main/java#7.2.8"})
public class Mutable implements Serializable {

    private static final long serialVersionUID = -5129400250276547619L;
    private transient boolean serialized = false;
    private int value;

    public Mutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void increment() {
        this.value += 1;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean wasSerialized() {
        return this.serialized;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        this.serialized = true;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.serialized = true;
    }
}
