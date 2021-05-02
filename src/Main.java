import AST.RootNode;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Frontend.SemanticCheckerBef;
import Frontend.SymbolCollector;
import Frontend.TypeCollector;
import IR.*;
import Backend.*;
import ASM.*;
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
import java.io.File;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {

       InputStream input = System.in;

    //    File file = new File("test.s");
        File file = new File("output.s");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

    //    String file_name = "D:/MxStar-Compiler/testcases/sema/function-package/function-4.mx";/*codegen/t14.mx";*/
    //    String file_name = "D:/MxStar-Compiler/testcases/codegen/shortest_path/dijkstra.mx";
    //    String file_name = "D:/MxStar-Compiler/testcases/codegen/std/queue.mt";
    //    String file_name = "D:/MxStar-Compiler/tmp/a.mx";
    //    String file_name = "D:/MxStar-Compiler/testcases/codegen/t55.mx";
    //    String file_name = "D:/git__/Compiler-2021-testcases/optim-new/const.mx";
     //   InputStream input = new FileInputStream(file_name);
        boolean onlySemantic = false, codegen = true;
        for (String arg : args) {
            switch (arg) {
                case "-semantic":
                    onlySemantic = true;
                    break;
                case "-codegen":
                    codegen = true;
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

            IR Blocks = new IR();
            new SemanticCheckerBef(Blocks, global).visit(ASTRoot);

            global = new globalScope(null);
            new SymbolCollector(global).visit(ASTRoot);
            new TypeCollector(global).visit(ASTRoot);
            Blocks = new IR();
            new SemanticChecker(Blocks, global).visit(ASTRoot);

            if (!onlySemantic && codegen) {
                new IRBuilder(Blocks, global).visit(ASTRoot);
       //         Blocks.print();
                ASM asm = new ASM(Blocks);
                asm.trans();
                new InstSelector().run(asm);
            }
        } catch (Error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}
