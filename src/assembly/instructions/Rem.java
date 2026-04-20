package assembly.instructions;

/**
 * Class corresponding to RISC-V REM instruction.
 *
 * Models: rem dest src1 src2 #dest = src1 % src2
 */
public class Rem extends Instruction3O {

    public Rem(String src1, String src2, String dest) {
        super(src1, src2, dest);
        this.oc = OpCode.REM;
    }
}
