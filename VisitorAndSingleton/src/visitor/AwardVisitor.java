package visitor;

public class AwardVisitor extends BaseVisitor {
    @Override
    public void visit(Worker worker) {
        super.visit(worker);
        worker.setName(worker.getName() + ", BSc.");
    }

    @Override
    public void visit(Manager manager) {
        super.visit(manager);
        manager.setName(manager.getName() + ", MSc.");
    }

    @Override
    public void visit(Boss boss) {
        super.visit(boss);
        boss.setName(boss.getName() + ", PhD.");
    }
}
