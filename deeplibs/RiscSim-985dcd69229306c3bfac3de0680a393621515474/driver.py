from memory import Memory
from registers import IRegister
from registers import FRegister
import timingmodel
import program
import config
import machine
import sys

if __name__ == '__main__' :

    if len(sys.argv) > 2 :
        if (int(sys.argv[2]) < 32) :
            print("Cannot initialize simulator with fewer than 32 registers")
            quit()
        print("Initializing machine with " + sys.argv[2] + " registers")
        config.machine = machine.Machine(numIntRegisters = int(sys.argv[2]), numFloatRegisters = int(sys.argv[2]), timingModel = timingmodel.basicTimingModel)
    else :
        print("Using default machine configuration with 256 registers")
            
    p = program.Program()
    p.buildCodeFromFile(sys.argv[1])
    
    config.machine.execProgram(p)