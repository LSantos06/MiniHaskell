package Parser;
import Parser.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + 2;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       _n_ = _n_ - 2;
       backup();
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(Parser.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(Parser.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(Parser.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof Parser.Absyn.EAdd)
    {
       Parser.Absyn.EAdd _eadd = (Parser.Absyn.EAdd) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_eadd.exp_1, 0);
       render("+");
       pp(_eadd.exp_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Parser.Absyn.ESub)
    {
       Parser.Absyn.ESub _esub = (Parser.Absyn.ESub) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_esub.exp_1, 0);
       render("-");
       pp(_esub.exp_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof Parser.Absyn.EMul)
    {
       Parser.Absyn.EMul _emul = (Parser.Absyn.EMul) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_emul.exp_1, 1);
       render("*");
       pp(_emul.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof Parser.Absyn.EDiv)
    {
       Parser.Absyn.EDiv _ediv = (Parser.Absyn.EDiv) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_ediv.exp_1, 1);
       render("/");
       pp(_ediv.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof Parser.Absyn.EInt)
    {
       Parser.Absyn.EInt _eint = (Parser.Absyn.EInt) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }


  private static void sh(Parser.Absyn.Exp foo)
  {
    if (foo instanceof Parser.Absyn.EAdd)
    {
       Parser.Absyn.EAdd _eadd = (Parser.Absyn.EAdd) foo;
       render("(");
       render("EAdd");
       sh(_eadd.exp_1);
       sh(_eadd.exp_2);
       render(")");
    }
    if (foo instanceof Parser.Absyn.ESub)
    {
       Parser.Absyn.ESub _esub = (Parser.Absyn.ESub) foo;
       render("(");
       render("ESub");
       sh(_esub.exp_1);
       sh(_esub.exp_2);
       render(")");
    }
    if (foo instanceof Parser.Absyn.EMul)
    {
       Parser.Absyn.EMul _emul = (Parser.Absyn.EMul) foo;
       render("(");
       render("EMul");
       sh(_emul.exp_1);
       sh(_emul.exp_2);
       render(")");
    }
    if (foo instanceof Parser.Absyn.EDiv)
    {
       Parser.Absyn.EDiv _ediv = (Parser.Absyn.EDiv) foo;
       render("(");
       render("EDiv");
       sh(_ediv.exp_1);
       sh(_ediv.exp_2);
       render(")");
    }
    if (foo instanceof Parser.Absyn.EInt)
    {
       Parser.Absyn.EInt _eint = (Parser.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

