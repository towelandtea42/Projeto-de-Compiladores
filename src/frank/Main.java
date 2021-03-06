package frank;
import frank.parser.*;
import frank.lexer.*;
import frank.node.*;
import java.io.*;

public class Main
{
 public static void main(String[] args)
 {
  try
  {
   String arquivo = "teste/calculo.stein";
  
   Parser p =
    new Parser(
    new Lexer(
    new PushbackReader(  
    new FileReader(arquivo), 1024))); 
   
   Start tree = p.parse();
   //Imprime árvore na saída padrão
   //tree.apply(new ASTPrinter());
   //Imprime árvore em interface gráfica
   tree.apply(new ASTDisplay());
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
 }
}