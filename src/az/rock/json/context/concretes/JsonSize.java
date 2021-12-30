package az.rock.json.context.concretes;

public enum JsonSize {
    VERY_SMALL(100)
    ,
    SMALL(1000)
    ,
    MEDIUM(3000)
    ,
    LARGE(30000)
    ,
    VERY_LARGE(300000)
    ;

    private final int initialCapacity;
    JsonSize(int size) {
        initialCapacity = size;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

}
