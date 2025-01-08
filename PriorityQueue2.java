package ics202;

public interface PriorityQueue2 extends Container
{

    public abstract void enqueue(Comparable comparable);

    public abstract Comparable findMax();

    public abstract Comparable dequeueMax();

}