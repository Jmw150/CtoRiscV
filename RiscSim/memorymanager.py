class MemoryManager :

    #startAddr: starting address to allocate from
    #size: amount of memory to allocate
    def __init__(self, startAddr, size) :
        self.freeList = FreeList(startAddr, size)
        self.allocatedBlocks = {}

    def malloc(self, size) :
        #print("DEBUG: Allocating " + str(size) + " bytes")
        bl = self.freeList.getBlock(size)
        self.allocatedBlocks[bl[0]] = bl[1]
        #print("DEBUG: allocated into " + str(bl[0]))
        #print(self)
        return bl[0]

    def free(self, addr) :
        #print("DEBUG: Freeing " + str(addr))
        assert addr in self.allocatedBlocks, "Freeing a block at address " + str(addr) + " that has not been allocated"
        self.freeList.releaseBlock(addr, self.allocatedBlocks[addr])
        del self.allocatedBlocks[addr]

        #print(self)

    def __str__(self) :
        return "Allocated Blocks: " + str(self.allocatedBlocks) + "\nFree list: " + str(self.freeList)


class FreeList :

    def __init__(self, startAddr, size) :
        self.freeList = [(startAddr, size)]

    def getBlock(self, size) :
        remBlock = None
        for block in self.freeList :
            if (block[1] >= size) :
                remBlock = block
                break
                
        if (remBlock != None) :
            self.freeList.remove(remBlock)
            retval = (remBlock[0], size)
            if (remBlock[1] != size) :
                self.releaseBlock(remBlock[0] + size, remBlock[1] - size)
            return retval
        else :
            raise RuntimeError("No free block available to allocate " + str(size) + " bytes")

    def releaseBlock(self, addr, size) :
        i = 0

        #find where to insert the new block
        while (i < len(self.freeList)) :
            if (self.freeList[i][0] > addr) :
                #print("Looking at block " + str(self.freeList[i]))
                break
            i += 1
        
        #first, check to see if this block "matches up" with the next block
        mergeNext = ((i < len(self.freeList)) and (self.freeList[i][0] == (addr + size)))
        #and check if this block "matches up" with the previous block
        mergePrev = ((i > 0) and (self.freeList[i - 1][0] + self.freeList[i - 1][1] == addr))

        #if mergeNext but not mergePrev, merge this block with the next block
        if ((mergeNext) and (not mergePrev)) :
            self.freeList[i] = (addr, size + self.freeList[i][1])
        #if mergePrev but not mergeNext, merge this block with the previous block
        elif ((mergePrev) and (not mergeNext)) :
            self.freeList[i - 1] = (self.freeList[i - 1][0], size + self.freeList[i - 1][1])
        #if mergeNext and mergePrev, merge this block with the previous block and the next block and remove the next block
        elif (mergePrev and mergeNext) :
            self.freeList[i - 1] = (self.freeList[i - 1][0], size + self.freeList[i - 1][1] + self.freeList[i][1])
            del(self.freeList[i])
        else : #otherwise, add a new block at the current position
            self.freeList.insert(i, (addr, size))

    def __str__ (self) :
        return str(self.freeList)

if __name__ == '__main__' :
    allocator = MemoryManager(0, 10)
    print(allocator)
    addr1 = allocator.malloc(4)
    addr2 = allocator.malloc(4)
    addr3 = allocator.malloc(2)
    print(allocator)
    allocator.free(addr3)
    print(allocator)
    allocator.free(addr2)
    print(allocator)
    allocator.free(addr1)
    print(allocator)