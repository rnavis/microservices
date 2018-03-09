# Abstract Data Types (ADT)
    # Linked List
         - one Noded linked list
         - Each node will hold Data and next Node reference
         - add
            at first - o(1)
            at end - o(n)
         - remove o(n)
         - read o(n)
         - reverse logic
            ncn cnp pc cn
            head <- p
    
    # Doubly linked list
        - one noded linked list
        - Each node holds Data, previous and next node
        - rest all same as Linked list
    
    # Stack
        - Operations
            push() - o(1)
            pop() - o(1)
            top() - o(1)
            isEmpty() - o(1)
        - implementations
            - Array Backed
            - linked list Backed
                addAtFirst(data)
                removeAtFirst(data)
    
    # Queue
        - Operations
            enqueue() - o(1)
            dequeue() - o(1)
            front() - o(1)
            isEmpty() - o(1)
            isFull() - o(1) [array backed]
        - implementations
            - Array Backed
            - linked list Backed
                enqueue@rear(data)
                dequeue@front(data)