package ics202;

public interface PriorityQueue extends Container
{

    public abstract void enqueue(Comparable comparable);

    public abstract Comparable findMin();


    public abstract Comparable dequeueMin();

}