public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int front;
    private int rear;
    private int refactor;


    /**
     * creates an empty list
     */

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = rear = -1;
        size = 0;
        refactor = 2;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            front = rear = 0;
            items[0] = item;
        } else {
            front = minusOne(front);
            items[front] = item;
        }
        resizingUpAnalysis(items);
        size++;
    }

    /* need resizing */
    public void addLast(T item) {

        if (isEmpty()) {
            front = rear = 0;
            items[0] = item;

        } else {
            rear = plusOne(rear);
            items[rear] = item;
        }
        resizingUpAnalysis(items);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("Output: ");
        if (front == rear) {
            System.out.println(items[0]);
        } else if (front > rear) {
            /* front to the end of array*/
            for (int i = front; i < items.length; i++) {
                System.out.print(items[i] + ", ");
            }
            /* beginning to rear */
            for (int i = 0; i <= rear; i++) {
                System.out.print(items[i] + ", ");
            }
        } else {
            /* from front to rear*/
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + ", ");
            }
        }
    }

    /*hello*/
    /* no resizing is needed */
    public T removeFirst() {

        if (isEmpty()) {
            size = 0;
            return null;
        } else {
            T removedItem = items[front];
            if (size == 1) {
                items[0] = null;
                size = 0;
            } else {
                items[front] = null;
                front = plusOne(front);
                size--;
            }
            resizingDownAnalysis(items);
            return removedItem;
        }
    }

    public T removeLast() {

        if (isEmpty()) {
            size = 0;
            return null;
        } else {
            T removedItem = items[rear];
            if (size == 1) {
                items[0] = null;
                size = 0;
            } else {
                items[rear] = null;
                rear = minusOne(rear);
                size--;
            }
            resizingDownAnalysis(items);
            return removedItem;
        }

    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            return null;
        } else {
            int current = (front + index) % items.length;
            return items[current];
        }

    }


    private ArrayDeque arrayDeque(ArrayDeque other) {
        ArrayDeque newArr = new ArrayDeque();
        if (other.isEmpty()) {
            return newArr;
        } else {
            for (int i = 0; i < other.items.length; i++) {
                newArr.items[i] = other.items[i];
            }
            return newArr;
        }
    }

    private int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }

    }

    private T[] resizingUpAnalysis(T[] other) {
        int nextFront = minusOne(front);
        int nextRear = plusOne(rear);

        if (nextFront == rear || nextRear == front) {
            return resizingUp(items);
        } else {
            return items;
        }
    }

    private T[] resizingUp(T[] other) {
        T[] newArr = (T[]) new Object[items.length * refactor];
        int ptr = 0;
        if (front > rear) {
            for (int i = front; i < items.length; i++) {
                newArr[ptr] = items[i];
                ptr++;
            }
            for (int i = 0; i <= rear; i++) {
                newArr[ptr] = items[i];
                ptr++;
            }
        } else { /* front < rear */
            for (int i = front; i <= rear; i++) {
                newArr[ptr] = items[i];
                ptr++;
            }
        }
        front = 0;
        rear = ptr - 1;
        items = newArr;
        return newArr;
    }


    private T[] resizingDownAnalysis(T[] other) {
        double sizeUsage = (double) size / items.length * 100;
        if (sizeUsage >= 25 || size == 0) {
            return items;
        } else {
            resizingDownHelper(items);
            return resizingDownAnalysis(items);
        }

    }


    private T[] resizingDownHelper(T[] other) {
        double sizeUsage = (double) size / items.length * 100;
        int tempRefactor = 2;
        T[] newArr = (T[]) new Object[items.length / tempRefactor];
        int ptr = 0;
        if (sizeUsage < 25) {
            if (front != rear) {
                resizingUp(items);
            } else {
                newArr[0] = items[front];
                items = newArr;
            }
            front = 0;
            rear = ptr - 1;
        }
        return items = newArr;
    }
}
