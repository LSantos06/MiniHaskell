package Parser;
import Parser.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Exp */
    public R visit(Parser.Absyn.EAdd p, A arg) { return visitDefault(p, arg); }
    public R visit(Parser.Absyn.ESub p, A arg) { return visitDefault(p, arg); }

    public R visit(Parser.Absyn.EMul p, A arg) { return visitDefault(p, arg); }
    public R visit(Parser.Absyn.EDiv p, A arg) { return visitDefault(p, arg); }

    public R visit(Parser.Absyn.EInt p, A arg) { return visitDefault(p, arg); }

    public R visitDefault(Parser.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
