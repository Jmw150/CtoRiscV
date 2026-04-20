package assembly.instructions;

/**
 * Convert/move an integer register value into a floating-point register.
 *
 * Models: imovf.s dest src # dest = (float) src
 */
public class IMovF extends Instruction {

    public IMovF(String src, String dest) {
        super();
        this.src1 = src;
        this.dest = dest;
        this.oc = OpCode.IMOVFS;
    }

    public String toString() {
        return this.oc + " " + this.dest + ", " + this.src1;
    }
}
