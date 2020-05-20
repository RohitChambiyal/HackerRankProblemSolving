package Data_Structure;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class JennysSubtreebuild2 {
        static long sortingTime = 0L;
    static long bfsTime = 0L;
    static long queueTime = 0L;
    static List<TreeNode> tree;
    static long[] randValues;
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        InputParser inputParser = new InputParser();
        int[] arr = inputParser.readArrayOfInts(2, false);
        int n = arr[0];
        int r = arr[1];
        randValues = new long[n + 1];
        Random random = new Random(-1);
        for (int i = 0; i <= n; i++) {
           randValues[i] = random.nextLong();
        }
        Set<String> result = new HashSet<>();
        Set<Long> hashResult = new HashSet<>();
        tree = inputParser.readTree(n, () -> {return new TreeNode();}, true);
        for (TreeNode treeNode : tree) {
            treeNode.linksArray = new int[treeNode.links.size()];
            int idx = 0;
            for (Integer link : treeNode.links) {
                treeNode.linksArray[idx++] = link;
            }
        }
        int foundSubTrees = 0;

        for (int node = 0; node < tree.size(); node++) {
            int subTreeSize = 0;
            AhuNode[] ahuNodesArray = new AhuNode[n];
            int[] cameFroms = new int[n];
            int[] levels = new int[n];
            IntArrayQueue queue = new IntArrayQueue(n);
            //Queue<BfsNode> bfs = new LinkedList<>();
            IntArrayQueue bfs = new IntArrayQueue(n);
            bfs.add(node);
            cameFroms[node] = -1;
            levels[node] = 0;

            long bfsStart = System.currentTimeMillis();
            while (!bfs.isEmpty()) {
                int currentNode = bfs.poll();
                ahuNodesArray[currentNode] = new AhuNode(currentNode);
                subTreeSize++;
                if (levels[currentNode] < r) {
                    int[] links = tree.get(currentNode).linksArray;
                    if (links.length == 1) {
                        queue.add(currentNode);
                    }
                    for (int childIdx : links) {
                        if (childIdx != cameFroms[currentNode]) {
                            bfs.add(childIdx);
                            cameFroms[childIdx] = currentNode;
                            levels[childIdx] = levels[currentNode] + 1;
                        }
                    }
                } else {
                    queue.add(currentNode);
                }

            }
            bfsTime += (System.currentTimeMillis() - bfsStart);
            int processed = 0;
            while (processed++ < subTreeSize - 2) {
                int current = queue.poll();
                AhuNode currentAhuNode = ahuNodesArray[current];
                currentAhuNode.processed = true;
                long ahuHash = getAhuHash(currentAhuNode.ahuHsshes);
                for (int link : tree.get(current).linksArray) {
                    if ((ahuNodesArray[link] != null) && !(ahuNodesArray[link].processed)) {
                        ahuNodesArray[link].distance = Math.max(ahuNodesArray[link].distance, currentAhuNode.distance + 1);
                        ahuNodesArray[link].ahuHsshes.add(ahuHash);
                        if (--(ahuNodesArray[link].remainingLinks) == 1) {
                            queue.add(link);
                            continue;
                        }
                    }
                }
            }

            int firstDistance = ahuNodesArray[queue.first()].distance;
            int lastDistance = ahuNodesArray[queue.last()].distance;
            if (firstDistance == lastDistance) {
                @SuppressWarnings("unchecked") ArrayList<Long> firsClone =
                        (ArrayList<Long>)ahuNodesArray[queue.first()].ahuHsshes.clone();
                @SuppressWarnings("unchecked") ArrayList<Long> lastClone =
                        (ArrayList<Long>)ahuNodesArray[queue.last()].ahuHsshes.clone();
                ahuNodesArray[queue.first()].ahuHsshes.add(getAhuHash(ahuNodesArray[queue.last()].ahuHsshes));
                long firstAhuHash = getAhuHash(ahuNodesArray[queue.first()].ahuHsshes);
                lastClone.add(getAhuHash(firsClone));
                long secondAbuHash = getAhuHash(lastClone);
                if (!hashResult.contains(firstAhuHash) && !hashResult.contains(secondAbuHash)) {
                    foundSubTrees++;
                    //System.out.println(getSubTree(ahuNodesArray));
                }
                hashResult.add(firstAhuHash);
                hashResult.add(secondAbuHash);

            } else if (firstDistance < lastDistance){
                long ahuHash = getAhuHash(ahuNodesArray[queue.first()].ahuHsshes);
                ahuNodesArray[queue.last()].ahuHsshes.add(ahuHash);
                ahuHash = getAhuHash(ahuNodesArray[queue.last()].ahuHsshes);
                if (!hashResult.contains(ahuHash)) {
                    foundSubTrees++;
                    //System.out.println(getSubTree(ahuNodesArray));
                    hashResult.add(ahuHash);
                }
            } else {
                long ahuHash = getAhuHash(ahuNodesArray[queue.last()].ahuHsshes);
                ahuNodesArray[queue.first()].ahuHsshes.add(ahuHash);
                ahuHash = getAhuHash(ahuNodesArray[queue.first()].ahuHsshes);
                if (!hashResult.contains(ahuHash)) {
                    foundSubTrees++;
                    //System.out.println(getSubTree(ahuNodesArray));
                    hashResult.add(ahuHash);
                }
            }
        }
        System.out.println(foundSubTrees);
/*
        System.out.println("sorting: " + sortingTime + " ms");
        System.out.println("bfs: " + bfsTime + " ms");
        System.out.println("queue: " + queueTime + " ms");
        System.out.println("total: " + (System.currentTimeMillis() - start)+ " ms");
*/
    }

    private static String getSubTree(AhuNode[] ahuNodesArray) {
        String s = "";
        for (AhuNode ahuNode : ahuNodesArray) {
            if (ahuNode != null) {
                s += ahuNode.nodeId + " ";
            }
        }
        return s;
    }


    private static long getAhuHash(List<Long> hashes) {
        long queueStart = System.currentTimeMillis();
        hashes.sort(Long::compareTo);
        long result = randValues[randValues.length - 1];
        for (int i = 0; i < hashes.size(); i++) {
            result ^= (hashes.get(i) * randValues[i]);
        }
        queueTime += (System.currentTimeMillis() - queueStart);
        return result;
    }


    static class BfsNode {
        int idx;
        int cameFrom;
        int level;

        public BfsNode(int idx, int cameFrom, int level) {
            this.idx = idx;
            this.cameFrom = cameFrom;
            this.level = level;
        }
    }

    static class TreeNode implements TreeNodeHolder {
        Set<Integer> links;
        int[] linksArray;

        @Override
        public void add(int child) {
            links.add(child);
        }

        public TreeNode() {
            this.links = new HashSet<>();
        }
    }

    public interface TreeNodeHolder {
        void add(int child);
    }

    static class InputParser {
        BufferedReader bufferedReader;

        public InputParser(Class klazz, int caseNumber) throws Exception {
            this("src/main/cases/" + klazz.getSimpleName() + "/" + caseNumber);
        }

        public InputParser() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public InputParser(String fileName) throws Exception {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        }

        public int[] readArrayOfInts(int size, boolean decreaseByOne) throws Exception {
            int[] result = new int[size];
            String line = bufferedReader.readLine();
            int lastSpacePos = 0;
            for (int j = 0; j < size; j++) {
                int spacePos = line.indexOf(' ', lastSpacePos);
                if (spacePos < 0) spacePos = line.length();
                int value = Integer.parseInt(line.substring(lastSpacePos, spacePos)) - (decreaseByOne ? 1 : 0);
                result[j] = value;
                lastSpacePos = spacePos + 1;
            }
            return result;
        }

        public <T extends TreeNodeHolder> List<T> readTree(int nodesCount, Supplier<T> supplier, boolean decreaseByOne) throws Exception{
            List<T> result = new ArrayList<T>(nodesCount);
            for (int i = 0; i < nodesCount; i++) {
                result.add(supplier.get());
            }
            for (int i = 0; i < nodesCount - 1; i++) {
                int[] pair = readArrayOfInts(2, decreaseByOne);
                result.get(pair[0]).add(pair[1]);
                result.get(pair[1]).add(pair[0]);
            }
            return result;
        }

    }

    static class AhuNode{
        ArrayList<String> ahuStrings;
        ArrayList<Long> ahuHsshes;
        int distance;
        int remainingLinks;
        int nodeId;
        boolean processed;

        public AhuNode(int nodeId) {
            this.nodeId = nodeId;
            this.remainingLinks = tree.get(nodeId).links.size();
            this.ahuStrings = new ArrayList<>(this.remainingLinks);
            this.ahuHsshes = new ArrayList<>(this.remainingLinks);
            this.distance = 0;
            this.processed = false;
        }
    }

    static class IntArrayQueue {
        int[] arr;
        int currentPos = 0;
        int currentSize = 0;
        public IntArrayQueue(int size) {
            this.arr = new int[size];
            this.currentPos = 0;
            this.currentSize = 0;
        }

        public int poll() {
            if (currentSize <= 0) {
                throw new RuntimeException("Attempt to read from empty queue");
            }
            currentSize--;
            return arr[currentPos++];
        }

        public void add(int value) {
            arr[currentPos + currentSize++] = value;
        }

        public int first() {
            return arr[currentPos];
        }

        public int last() {
            return arr[currentPos + currentSize -1];
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }
    }
}
