package com.zping.lib_thinking_in_java.t17_containers;//: containers/References.java
// Demonstrates Reference objects

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String id) {
        ident = id;
    }

    public String toString() {
        return ident;
    }

    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}

public class References {
    private static ReferenceQueue<VeryBig> sVeryBigReferenceQueue =
            new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = sVeryBigReferenceQueue.poll();
        if (inq != null) {
            System.out.println("In queue: " + inq.get());
        }
    }

    public static void main(String[] args) {
        int size = 3;
        // Or, choose size via the command line:
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            VeryBig veryBig = new VeryBig("Soft " + i);
            sa.add(new SoftReference<VeryBig>(veryBig, sVeryBigReferenceQueue));
            System.out.println("Just created SoftReference: " + sa.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wa =
                new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            VeryBig veryBig = new VeryBig("Weak " + i);
            wa.add(new WeakReference<VeryBig>(veryBig, sVeryBigReferenceQueue));
            System.out.println("Just created WeakReference: " + wa.getLast());
            checkQueue();
        }
        SoftReference<VeryBig> softReference = new SoftReference<VeryBig>(new VeryBig("Soft"));
        System.out.println("Just created sssss: " + softReference);
        WeakReference<VeryBig> weakReference = new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.out.println("Just created wwwww: " + weakReference);
        System.out.println("************** System.gc() *************");
        System.gc();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("************** checkQueue() begin *************");
        checkQueue();
        System.out.println("************** checkQueue() done *************");
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(
                    new VeryBig("Phantom " + i), sVeryBigReferenceQueue));
            System.out.println("Just created  PhantomReference : " + pa.getLast());
            checkQueue();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
} /* (Execute to see output) *///:~
