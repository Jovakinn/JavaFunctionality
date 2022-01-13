package ua.univer.lesson05;

@FunctionalInterface
public interface IOperation {
    /**
     * @param x
     * @param y
     * @return integer that is the result of the operation
     * @author @Maksym_Khodakov
     */
    int oper(int x, int y);
}
