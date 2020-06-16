package tes.semarang.satelite;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SatelliteTest  extends TestCase {
    Satellite satellite = new Satellite();
    
    public static Test suite() {
        return new TestSuite( SatelliteTest.class );
    }

//    public void testSatellite() { //emptyTree() {
//        List<Character> preorder = new ArrayList<Character>();
//        List<Character> inorder = new ArrayList<Character>();
//
//        Tree tree = satellite.treeFromTraversals(preorder, inorder);
//
//        assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
//        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
//        assertThat(tree.postorder()).isEmpty();
//    }

    public void treeWithOneItem() {
        List<Character> preorder = new ArrayList<Character>();
        preorder.add('a');
        List<Character> inorder = new ArrayList<Character>();
        inorder.add('a');

        Tree tree = satellite.treeFromTraversals(preorder, inorder);

        assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
        assertThat(tree.postorder()).containsExactly('a');
    }

    public void testSatellite() { //treeWithManyItems() {
        List<Character> preorder = new ArrayList<Character>();
        preorder.add('a');
        preorder.add('i');
        preorder.add('x');
        preorder.add('f');
        preorder.add('r');
        		
        List<Character> inorder = new ArrayList<Character>();
        inorder.add('i');
        inorder.add('a');
        inorder.add('f');
        inorder.add('x');
        inorder.add('r');

        Tree tree = satellite.treeFromTraversals(preorder, inorder);

        //assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
       // assertThat(tree.postorder()).containsExactly('i', 'f', 'r', 'x', 'a');
    }


    public void rejectTraversalsOfDifferentLengths() {
        List<Character> preorder = new ArrayList<Character>();
        preorder.add('a');
        preorder.add('b');

        List<Character> inorder = new ArrayList<Character>();
        inorder.add('b');
        inorder.add('a');
        inorder.add('r');
        
        Throwable thrown = catchThrowable(() -> {
        	satellite.treeFromTraversals(preorder, inorder);
        });
        
        
//        IllegalArgumentException expected =
//            assertThrows(
//                IllegalArgumentException.class,
//                () -> satellite.treeFromTraversals(preorder, inorder));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("traversals must have the same length");
    }


    public void rejectInconsistentTraversalsOfSameLength() {
        List<Character> preorder = new ArrayList<Character>();
        preorder.add('x');
        preorder.add('y');
        preorder.add('z');

        List<Character> inorder = new ArrayList<Character>();
        inorder.add('a');
        inorder.add('b');
        inorder.add('c');
        
        Throwable thrown = catchThrowable(() -> {
        	satellite.treeFromTraversals(preorder, inorder);
        });

//        IllegalArgumentException expected =
//            assertThrows(
//                IllegalArgumentException.class,
//                () -> satellite.treeFromTraversals(preorder, inorder));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("traversals must have the same elements");
    }


    public void rejectTraversalsWithRepeatedItems() {
        List<Character> preorder = new ArrayList<Character>();
        preorder.add('a');
        preorder.add('b');
        preorder.add('a');

        List<Character> inorder = new ArrayList<Character>();
        inorder.add('b');
        inorder.add('a');
        inorder.add('a');
        
        Throwable thrown = catchThrowable(() -> {
        	satellite.treeFromTraversals(preorder, inorder);
        });

//        IllegalArgumentException expected =
//            assertThrows(
//                IllegalArgumentException.class,
//                () -> satellite.treeFromTraversals(preorder, inorder));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("traversals must contain unique items");
    }
}
