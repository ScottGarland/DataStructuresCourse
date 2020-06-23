// Credit to https://www.geeksforgeeks.org/max-heap-in-java/ for help in understanding
// Referencing the lecture slides of Data Structures Week 6

package ca.ScottGarland.DataStructures;

public class Tutorial7 {
    private int[] Heap;
    private int size;
    private int maxSize;

    // Constructor for the Max Heap
    public Tutorial7(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    // Implementing the Parent(i) function
    private int parent(int position) {
        return (position / 2);
    }

    // Implementing the LeftChild(i) function
    private int leftChild(int position) {
        return (position * 2);
    }

    // Implementing the RightChild(i) function
    private int rightChild(int position) {
        return (position * 2 + 1);
    }

    // Implementing SiftUp(i)
    private void siftUp(int position) {
        while ((position > 1) && (Heap[parent(position)] < Heap[position])) {
            int tmp = Heap[parent(position)];
            Heap[parent(position)] = Heap[position];
            Heap[position] = tmp;
            position = parent(position);
        }
    }

    // Implementing SiftDown(i)
    private void siftDown(int position) {
        int maxIndex = position;
        int left = leftChild(position);
        int right = rightChild(position);

        if ((left <= size) && (Heap[left] > Heap[maxIndex])) {
            maxIndex = left;
        }

        if ((right <= size) && (Heap[right] > Heap[maxIndex])) {
            maxIndex = right;
        }

        if (position != maxIndex) {
            int tmp = Heap[position];
            Heap[position] = Heap[maxIndex];
            Heap[maxIndex] = tmp;
            siftDown(maxIndex);
        }
    }

    // Implementing Insert(p)
    private void Insert(int element) {
        if (size == maxSize) {
            System.out.println("Error");
        } else {
            size += 1;
            Heap[size] = element;
            siftUp(size);
        }
    }

    // Implementing Remove(i)
    private void Remove(int position) {
        Heap[position] = Integer.MAX_VALUE;
        siftUp(position);
        extractMax();
    }

    // Implementing ExtractMax()
    public int extractMax() {
        int result = Heap[1];
        Heap[1] = Heap[size];
        size -= 1;
        siftDown(1);
        return result;
    }

    // Prints the tree
    public void printHeap() {
        for (int i = 1; i <= (size/2); i++) {
            System.out.println("Parent: " + Heap[i] + "\n" + "Left: " + Heap[i*2] + "\n" + "Right: " + Heap[i*2 + 1] + "\n");
        }
    }

    // Main driving function
    public static void main(String[] args) {
	Tutorial7 maxHeap = new Tutorial7(11);
	maxHeap.Insert(16);
	maxHeap.Insert(10);
    maxHeap.Insert(14);
    maxHeap.Insert(9);
    maxHeap.Insert(7);
    maxHeap.Insert(1);
    maxHeap.Insert(4);
    maxHeap.Insert(2);
    maxHeap.Insert(8);
    maxHeap.Insert(3);

    maxHeap.printHeap();
    System.out.println("Extracted Max: " + maxHeap.extractMax() + "\n");

    System.out.println("After removing position 5: " + "\n");
    maxHeap.Remove(5);
    maxHeap.printHeap();
    System.out.println("Extracted Max: " + maxHeap.extractMax() + "\n");
    }
}
