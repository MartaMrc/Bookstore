package org.example.util;

public enum BookType {

    INVALID(0),
    ADVENTURE(1),
    MYSTERY(2),
    HISTORICAL(3),
    POETRY(4),
    FAIRYTALE(5);

    private int id;

    BookType(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public static BookType bookType(int id){

        switch (id) {
            case 1:
                return BookType.ADVENTURE;
            case 2:
                return BookType.MYSTERY;
            case 3:
                return BookType.HISTORICAL;
            case 4:
                return BookType.POETRY;
            case 5:
                return BookType.FAIRYTALE;
            default:
                return BookType.INVALID;
        }
    }

}
