package BinarySearchTreeNode;
//Stanislav Alpatiev stal5991

/**
 *
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) Det är också den enda av klasserna ni
 * ska lämna in. Glöm inte att namn och användarnamn ska stå i en kommentar
 * högst upp, och att en eventuell paketdeklarationen måste plockas bort vid inlämningen för
 * att koden ska gå igenom de automatiska testerna.
 *
 * De ändringar som är tillåtna är begränsade av följande:
 * <ul>
 * <li>Ni får INTE byta namn på klassen.
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans. Detta gäller också alterntiv
 * till loopar, så som strömmar.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * <li>Ni får INTE låta NÅGON metod ta en parameter av typen
 * BinarySearchTreeNode. Enbart den generiska typen (T eller vad ni väljer att
 * kalla den), String, StringBuilder, StringBuffer, samt primitiva typer är
 * tillåtna.
 * </ul>
 *
 * @author henrikbe
 *
 * @param <T>
 */

public class BinarySearchTreeNode<T extends Comparable<T>> {

    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean add(T data) {
        int compareResult = data.compareTo(this.data);

        if (compareResult < 0) {
            if(left != null) {
                return left.add(data);
            } else {
                left = new BinarySearchTreeNode<T>(data);
                return true;
            }
        }

        if (compareResult > 0) {
            if(right != null) {
               return right.add(data);
            } else {
                right = new BinarySearchTreeNode<T>(data);
                return true;
            }
        }

        return false;
    }

    private T findMin() {
        if (left != null) {
            return left.findMin();
        }
        return data;
    }

    public BinarySearchTreeNode<T> remove(T data) {
        if (this.data == data) {
            if (right != null && left != null) {
                this.data = right.findMin();
                right = right.remove(this.data);
                return this;
            } else {
                if (right != null) {
                    return right;
                } else if (left != null) {
                    return left;
                } else {
                    return null;
                }
            }
        }

        int compareResult = data.compareTo(this.data);

        if (compareResult < 0) {
            if(left != null) {
                left = left.remove(data);
            }
        }

        if (compareResult > 0) {
            if(right != null) {
                right = right.remove(data);
            }
        }

        return this;
    }

    public boolean contains(T data) {
        int compareResult = data.compareTo(this.data);

        if (compareResult > 0) {
            if (right != null) {
                return right.contains(data);
            } else {
                return false;
            }
        } else if (compareResult < 0) {
            if (left != null) {
                return left.contains(data);
            } else {
                return false;
            }
        } else {
            return true; // Match
        }
    }

    public int size() {
        int size = 1;
        int leftSize = 0;
        int rightSize = 0;
        if (left == null && right == null) {
            return size;
        } else {
            if (left != null) {
                leftSize += left.size();
            }
            if (right != null) {
                rightSize += right.size();
            }
        }

        return size + leftSize + rightSize;
    }

    public int depth() {
        int depth = 0;
        int leftDepth = 0;
        int rightDepth = 0;

        if (left == null && right == null) {
            return depth;
        } else {
            if (left != null) {
                leftDepth += left.depth();
            }
            if (right != null) {
                rightDepth += right.depth();
            }
        }

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(left != null) {
            sb.append(left.toString());
            sb.append(", ");
        }

        sb.append(this.data);

        if(right != null) {
            sb.append(", ");
            sb.append(right.toString());
        }

        return sb.toString();
    }

}
