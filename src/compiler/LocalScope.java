package compiler;

import java.util.LinkedHashMap;

	public class LocalScope extends Scope {
	
	static final private int startingLocalsOffset = -4;  //start local var offset with room for old frame pointer
	static final private int startingArgsOffset = 8; //start argument offset with room for old return address and return value
	static private int nextStorageAddress = 0x30000000;

	private int localsOffset;
	private int argsOffset;

	private int numLocals;
	private int numArgs;
	
	public LocalScope() {
		this(null);	
	}
	
	public LocalScope(Scope parent) {
		super(parent);
		numLocals = 0;
		numArgs = 0;
		name = "FUNCTION NAME NOT SET";
		localsOffset = startingLocalsOffset;
		argsOffset = startingArgsOffset;
	}

	public ErrorType addArgument(Scope.Type type, String name) {
		ErrorType retVal = checkSymbol(name);
		table.put(name, genArgument(type, name));
		return retVal;
	}

	protected SymbolTableEntry genArgument(Scope.Type type, String name) {
		int addr = nextStorageAddress;
		nextStorageAddress += 4;
		SymbolTableEntry ste = new SymbolTableEntry(type, name, addr, true);
		numArgs++;
		return ste;
	}

	@Override
	protected SymbolTableEntry genSymbol(compiler.Scope.Type type, String name) {
		int addr = nextStorageAddress;
		nextStorageAddress += 4;
		SymbolTableEntry ste = new SymbolTableEntry(type, name, addr, true);
		numLocals++;
		return ste;
	}

	@Override
	protected ArraySymbolTableEntry genArraySymbol(compiler.Scope.Type type, String name, int length) {
		int addr = nextStorageAddress;
		nextStorageAddress += 4 * length;
		ArraySymbolTableEntry ste = new ArraySymbolTableEntry(type, name, addr, length, true);
		numLocals += length;
		return ste;
	}

	@Override
	protected StringSymbolTableEntry genStringSymbol(compiler.Scope.Type type, String name, String value) {
		throw new Error("Should never try to create a string symbol in a local scope");
	}

	@Override
	protected SymbolTableEntry searchLocalScope(String name) {
		SymbolTableEntry retval = table.get(name);
		return retval;
	}

	public int getNumLocals() {
		return numLocals;
	}
	
}
