public class LinkList {
    private Node head;

    public void add(Node node){
        if(this.head != null){
            Node lastNode = this.head;
            while(lastNode.getNext() != null){
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(node);
        }else{
            this.head = node;
        }
    }

    public void delete1(int value){

        if(this.head == null){
            return;
        }

        Node temp = this.head;
        Node previousNode = null;
        while (temp.getData() != value && temp != null){
            previousNode = temp;
            temp = temp.getNext();
        }

        if(temp.getNext() == null){// if value == last temp in link list; You know already that temp.next =null
            previousNode.setNext(null);
        }else if(temp == this.head){// if value == first temp in link list; You know already that temp == this.head
            this.head = temp.getNext();
        }else if(temp != null && previousNode != null){// if value == in between somewhere in link list; You know already that temp and previousNode is not null.
            previousNode.setNext(temp.getNext());
        }
    }

    public void delete2(int value){
        if(this.head != null){
            this.deleteRecursive(value, this.head, null);
        }
    }
    public void deleteRecursive(int value, Node currentNode, Node previousNode){
        if(value == currentNode.getData()){
            previousNode.setNext(currentNode.getNext());
            return;
        }
    }

    @Override
    public String toString() {
        return this.head != null ?this.head.toString():null;
    }

    public void reveres(){
        if(this.head != null){
            Node currentNode = this.head;
            Node previousNode = null;
            Node next = currentNode.getNext();
            while(currentNode != null) {
                next = currentNode.getNext();
                currentNode.setNext(previousNode);
                previousNode = currentNode;
                currentNode = next;
            }
            this.head = previousNode;
        }
    }
    public void reverseRecursive(){
        this.head = this.reversRecursive(this.head);
    }
    public Node reversRecursive(Node node){
        if(node == null || node.getNext() == null){
            return node;
        }
        Node rest = reversRecursive(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return rest;

    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(8));
        System.out.println(list);
//        System.out.println("Delete1 value 3");
//        list.delete1(3);
//        System.out.println(list);
//        System.out.println("Delete1 value 1");
//        list.delete1(1);
//        System.out.println(list);
//        System.out.println("Delete1 value 8");
//        list.delete1(8);
//        System.out.println(list);
//        System.out.println("Delete2 value 4");
//        list.delete1(4);
//        System.out.println(list);
//        System.out.println("Delete2 value 2");
//        list.delete1(2);
//        System.out.println(list);
//        System.out.println("Delete2 value 7");
//        list.delete1(7);
        list.reveres();
        System.out.println(list);
//        list.delete1(9);
        list.reverseRecursive();

        System.out.println(list);
    }
}
