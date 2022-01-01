public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                if (currentItem.next() != null) currentItem = currentItem.next();
                else {
                    currentItem.setNext(item);
                    return true;
                }

            } else if (comparison > 0) {
                if (currentItem.previous() != null) currentItem = currentItem.previous();
                else {
                    currentItem.setPrevious(item);
                    return true;
                }
            } else {
                System.out.println(item.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        } else {
            System.out.println("The list doesn't contain any items");
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // code to remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to the left tree (which may be null)
            if (parent.next() == item) {
                // item is the right child of the parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // item is the left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to the right tree (which may be null)
            if (parent.next() == item) {
                // item is the right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is the left child of its parent
                parent.setPrevious(item.next());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = item.next();
            }
        } else {
//            neither the left nor right are null, deletion is now a lot trickier!
//            From the right subtree, find the smallest value (i.e., the leftmost node).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // now put the smallest value into the node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was not the leftmost node, so 'current' points to the smallest node (the one to be deleted)
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to the smallest node's right child (which may be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
