public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        x = Character.toLowerCase(x);
        y = Character.toLowerCase(y);
        return x + 1 == y || x - 1 == y || y - 1 == x || y + 1 == x;
    }

}
