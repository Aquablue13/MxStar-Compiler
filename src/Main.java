import AST.RootNode;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SymbolCollector;
import Frontend.TypeCollector;
import IR.BasicBlock;
import IR.BasicBlocks;
import IR.IRBuilder;
import Parser.MxStarLexer;
import Parser.MxStarParser;
import Util.MxErrorListener;
import Util.Error.Error;
import Util.Scope;
import Util.globalScope;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.InputStream;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception {

       InputStream input = System.in;

     //   String file_name = "D:/MxStar-Compiler/testcases/sema/function-package/function-4.mx";
     //   String file_name = "D:/MxStar-Compiler/testcases/misc-7.mx";//sema/string-package/string-1.mx";
     //   InputStream input = new FileInputStream(file_name);
        boolean onlySemantic = false, onlyIR = false;
        for (String arg : args) {
            switch (arg) {
                case "-semantic":
                    onlySemantic = true;
                    break;
            }
        }

        try {
            RootNode ASTRoot;
            MxStarLexer lexer = new MxStarLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxStarParser parser = new MxStarParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);
            globalScope global = new globalScope(null);
            new SymbolCollector(global).visit(ASTRoot);
            new TypeCollector(global).visit(ASTRoot);
            global.vars.clear();
            // new SemanticChecker(global).visit(ASTRoot);

            BasicBlocks Blocks = new BasicBlocks();
            new SemanticChecker(Blocks, global).visit(ASTRoot);
            if (!onlySemantic) {
                new IRBuilder(Blocks, global).visit(ASTRoot);
                //  Blocks.printIR();
                Blocks.init();
                Blocks.printout();
            }
        } catch (Error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}