class DangerException extends Exception {
    public DangerException(String message) {
        super(message);
    }

    public void toShow() {
        System.out.println("DangerException: Goods is dangerous!");
    }
}

class Machine {
    void checkBag(Goods goods) throws DangerException {
        if (goods.getIsDanger()) {
            throw new DangerException("Goods is dangerous!");
        }
    }
}

class Goods {
    Boolean isDanger;

    public Goods(Boolean isDanger) {
        this.isDanger = isDanger;
    }

    public Boolean getIsDanger() {
        return isDanger;
    }
}

public class Main {
    public static void main(String[] args) {
        Goods goods1 = new Goods(false);
        Goods goods2 = new Goods(true);
        Machine machine = new Machine();

        try {
            machine.checkBag(goods1);
            System.out.println("goods1 is safe");
            machine.checkBag(goods2);
            System.out.println("goods2 is safe");
        } catch (DangerException e) {
            e.toShow();
        }
    }
}
