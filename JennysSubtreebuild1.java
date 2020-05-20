package Data_Structure;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JennysSubtreebuild1 {

    private static class Node {
        private final static int MOD = 2147483647;

        Collection<Node> neighbors = new LinkedList<>();
        boolean marked = false;

        private static class ConcatList {
            private class Entry {
                char bit;
                Entry next;

                Entry(char bit) {
                    this.bit = bit;
                }
            }

            int count;
            Entry first, last;

            ConcatList(char bit) {
                this.first = this.last = new Entry(bit);
                this.count = 1;
            }

            ConcatList concatenate(ConcatList other) {
                count += other.count;
                this.last.next = other.first;
                this.last = other.last;
                return this;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder(count);
                Entry e = this.first;
                do {
                    sb.append(e.bit);
                    e = e.next;
                } while (e != null);
                return sb.toString();
            }

            public int compareTo(ConcatList other) {
                int cmp = this.count - other.count;
                if (cmp != 0) {
                    return cmp;
                } else {
                    Entry e1 = this.first,
                          e2 = other.first;
                    while (e1 != null) {
                        cmp = e1.bit - e2.bit;
                        if (cmp != 0) {
                            return cmp;
                        }
                        e1 = e1.next;
                        e2 = e2.next;
                    }
                    return 0;
                }
            }
        }

        private ConcatList _ahu(Node parent) {
            ArrayList<ConcatList> childAhus = new ArrayList<>(neighbors.size());
            for (Node neighbor : this.neighbors) {
                if (neighbor.marked && neighbor != parent) {
                    childAhus.add(neighbor._ahu(this));
                }
            }
            if (childAhus.isEmpty()) {
                return new ConcatList('1').concatenate(new ConcatList('0')); // 10
            } else {
                ConcatList result = new ConcatList('1');
                childAhus.sort(ConcatList::compareTo);
                for (ConcatList cl : childAhus) {
                    result.concatenate(cl);
                }
                return result.concatenate(new ConcatList('0'));
            }
        }

        public String ahu() {
            return _ahu(null).toString();
        }

        private void markTree(final Node parent, final int r, Collection<Node> marked) {
            this.marked = true;
            marked.add(this);
            if (r > 0) {
                for (Node neighbor : this.neighbors) {
                    if (neighbor != parent) {
                        neighbor.markTree(this, r - 1, marked);
                    }
                }
            }
        }

        Shape markShape(final int r) {
            List<Node> marked = new ArrayList<>(3000);
            markTree(null, r, marked);
            return new Shape(marked);
        }

        void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        void unmark() {
            this.marked = false;
        }
    }

    static class NodeAndComputations {
        final Node node;
        final String ahu;

        NodeAndComputations(Node node, String ahu) {
            this.node = node;
            this.ahu = ahu;
        }
    }

    static class Shape {
        final NodeAndComputations root;
        final Collection<Node> nodes;

        Shape(List<Node> nodes) {
            this.root = findCenter(nodes.get(0));
            this.nodes = nodes;
        }

        static class NodeAndDist {
            final Node node;
            int dist;

            NodeAndDist(Node node, int dist) {
                this.node = node;
                this.dist = dist;
            }
        }

        static NodeAndDist findFurthest(final Node from, final Node parent) {
            NodeAndDist result = new NodeAndDist(from, -1);
            for (Node neighbor : from.neighbors) {
                if (neighbor.marked && neighbor != parent) {
                    NodeAndDist candidate = findFurthest(neighbor, from);
                    if (candidate.dist > result.dist) {
                        result = candidate;
                    }
                }
            }
            result.dist++;
            return result;
        }

        static LinkedList<Node> findLongestPath(final Node from, final Node parent) {
            LinkedList<Node> result = new LinkedList<>();
            for (Node neighbor : from.neighbors) {
                if (neighbor.marked && neighbor != parent) {
                    LinkedList<Node> candidate = findLongestPath(neighbor, from);
                    if (candidate.size() > result.size()) {
                        result = candidate;
                    }
                }
            }
            result.addFirst(from);
            return result;
        }

        private NodeAndComputations findCenter(final Node node) {
            NodeAndDist furthest = findFurthest(node, null);
            LinkedList<Node> diameter = findLongestPath(furthest.node, null);
            final int centerIdx = diameter.size() / 2;
            if (diameter.size() % 2 == 1) {
                Node center = diameter.get(centerIdx);
                return new NodeAndComputations(center, center.ahu());
            } else {
                Iterator<Node> it = diameter.listIterator(centerIdx - 1);
                Node center1 = it.next(),
                     center2 = it.next();
                String ahu1 = center1.ahu(),
                       ahu2 = center2.ahu();
                if (ahu1.compareTo(ahu2) >= 0) {
                    return new NodeAndComputations(center1, ahu1);
                } else {
                    return new NodeAndComputations(center2, ahu2);
                }
            }
        }

        private String ahu() {
            return root.ahu;
        }

        @Override
        public int hashCode() {
            return ahu().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            Shape other = (Shape) o; // ..
            return this.ahu().equals(other.ahu());
        }

        void unmark() {
            nodes.forEach(node -> node.unmark());
        }
    }

    private static int countVariousSubtrees(final Node[] tree, final int n, final int r) {
        Set<Shape> variousShapes = new HashSet<>(n);
        for (Node node : tree) {
            Shape shape = node.markShape(r);
            variousShapes.add(shape);
            shape.unmark();
        }
        return variousShapes.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt(),
                  r = in.nextInt();
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt(),
                y = in.nextInt();
            tree[x - 1].addNeighbor(tree[y - 1]);
        }
        System.out.println(countVariousSubtrees(tree, n, r));
    }
}
