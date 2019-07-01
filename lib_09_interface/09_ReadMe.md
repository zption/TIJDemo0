1. interface 默认是 static 和final的。
2. interface的成员都是 static & final
3. interface中的方法默认是public的。

```java
interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final

    // Cannot have method definitions:
    void play(Note n); // Automatically public

    void adjust();
}
```

