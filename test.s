	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"-1"
	.align	2
.LS1:
	.string	" "
	.align	2
.LS2:
	.string	""
	.globl	.G0
	.section	.sbss,"aw",@nobits
	.align	2
	.type	.G0, @object
	.size	.G0, 4
.G0:
	.zero	4
	.globl	.G1
	.align	2
	.type	.G1, @object
	.size	.G1, 4
.G1:
	.zero	4
	.globl	.G2
	.align	2
	.type	.G2, @object
	.size	.G2, 4
.G2:
	.zero	4
	.globl	.G3
	.align	2
	.type	.G3, @object
	.size	.G3, 4
.G3:
	.zero	4
	.text
	.align	2
	.globl	EdgeList.init
	.type	EdgeList.init, @function
EdgeList.init:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	lw	a0,-20(s0)
	sw	a0,-28(s0)
	lw	a0,-20(s0)
	call	my_array_alloc
	sw	a0,-32(s0)
.LAB2:
	lw	a0,-28(s0)
	beq	a0,zero,.LAB3
	li	a0,12
	call	malloc
	lw	a1,-32(s0)
	lw	a2,-28(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-28(s0)
	addi	a0,a0,-1
	sw	a0,-28(s0)
	j	.LAB2
.LAB3:
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-32(s0)
	sw	a1,0(a0)
	lw	a0,-20(s0)
	sw	a0,-36(s0)
	lw	a0,-20(s0)
	call	my_array_alloc
	sw	a0,-40(s0)
.LAB4:
	lw	a0,-36(s0)
	beq	a0,zero,.LAB5
	lw	a0,-40(s0)
	lw	a1,-36(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-36(s0)
	addi	a0,a0,-1
	sw	a0,-36(s0)
	j	.LAB4
.LAB5:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-40(s0)
	sw	a1,0(a0)
	lw	a0,-16(s0)
	sw	a0,-44(s0)
	lw	a0,-16(s0)
	call	my_array_alloc
	sw	a0,-48(s0)
.LAB6:
	lw	a0,-44(s0)
	beq	a0,zero,.LAB7
	lw	a0,-48(s0)
	lw	a1,-44(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-44(s0)
	addi	a0,a0,-1
	sw	a0,-44(s0)
	j	.LAB6
.LAB7:
	li	a0,3
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	sw	a1,0(a0)
	li	a0,0
	sw	a0,-24(s0)
.LAB8:
	lw	a0,-24(s0)
	lw	a1,-20(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB9
	li	a0,1
	neg	a0,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB10:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB8
.LAB9:
	li	a0,0
	sw	a0,-24(s0)
.LAB11:
	lw	a0,-24(s0)
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB12
	li	a0,1
	neg	a0,a0
	li	a1,3
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB13:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB11
.LAB12:
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB1:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	EdgeList.init, .-EdgeList.init
	.text
	.align	2
	.globl	EdgeList.addEdge
	.type	EdgeList.addEdge, @function
EdgeList.addEdge:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	mv	a0,a3
	sw	a0,-24(s0)
	li	a0,12
	call	malloc
	sw	a0,-28(s0)
	li	a0,1
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
	li	a0,2
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	sw	a1,0(a0)
	li	a0,0
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	sw	a1,0(a0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,3
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,1
	lw	a3,-12(s0)
	slli	a2,a2,2
	add	a2,a3,a2
	lw	a2,0(a2)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,3
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-16(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
.LAB14:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	EdgeList.addEdge, .-EdgeList.addEdge
	.text
	.align	2
	.globl	EdgeList.nVertices
	.type	EdgeList.nVertices, @function
EdgeList.nVertices:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,3
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	size
	j	.LAB15
.LAB15:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	EdgeList.nVertices, .-EdgeList.nVertices
	.text
	.align	2
	.globl	EdgeList.nEdges
	.type	EdgeList.nEdges, @function
EdgeList.nEdges:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	size
	j	.LAB16
.LAB16:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	EdgeList.nEdges, .-EdgeList.nEdges
	.text
	.align	2
	.globl	Array_Node.Array_Node
	.type	Array_Node.Array_Node, @function
Array_Node.Array_Node:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,16
	mv	a1,a0
	sw	a1,-16(s0)
	call	my_array_alloc
	sw	a0,-20(s0)
.LAB18:
	lw	a0,-16(s0)
	beq	a0,zero,.LAB19
	li	a0,8
	call	malloc
	lw	a1,-20(s0)
	lw	a2,-16(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-16(s0)
	addi	a0,a0,-1
	sw	a0,-16(s0)
	j	.LAB18
.LAB19:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	sw	a1,0(a0)
.LAB17:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Array_Node.Array_Node, .-Array_Node.Array_Node
	.text
	.align	2
	.globl	Array_Node.push_back
	.type	Array_Node.push_back, @function
Array_Node.push_back:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	Array_Node.size
	mv	a6,a0
	sw	a6,-20(s0)
	li	a0,1
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	lw	a6,-20(s0)
	sub	a6,a6,a0
	seqz	a0,a6
	beq	a0,zero,.LAB21
	lw	a0,-12(s0)
	call	Array_Node.doubleStorage
.LAB21:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-16(s0)
	sw	a1,0(a0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
.LAB20:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Array_Node.push_back, .-Array_Node.push_back
	.text
	.align	2
	.globl	Array_Node.pop_back
	.type	Array_Node.pop_back, @function
Array_Node.pop_back:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,-1
	sw	a1,0(a0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB22
.LAB22:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.pop_back, .-Array_Node.pop_back
	.text
	.align	2
	.globl	Array_Node.back
	.type	Array_Node.back, @function
Array_Node.back:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,1
	lw	a1,0(a1)
	sub	a1,a1,a2
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB23
.LAB23:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.back, .-Array_Node.back
	.text
	.align	2
	.globl	Array_Node.front
	.type	Array_Node.front, @function
Array_Node.front:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB24
.LAB24:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.front, .-Array_Node.front
	.text
	.align	2
	.globl	Array_Node.size
	.type	Array_Node.size, @function
Array_Node.size:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	j	.LAB25
.LAB25:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.size, .-Array_Node.size
	.text
	.align	2
	.globl	Array_Node.resize
	.type	Array_Node.resize, @function
Array_Node.resize:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
.LAB27:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	size
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB28
	lw	a0,-12(s0)
	call	Array_Node.doubleStorage
	j	.LAB27
.LAB28:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
.LAB26:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.resize, .-Array_Node.resize
	.text
	.align	2
	.globl	Array_Node.get
	.type	Array_Node.get, @function
Array_Node.get:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB29
.LAB29:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.get, .-Array_Node.get
	.text
	.align	2
	.globl	Array_Node.set
	.type	Array_Node.set, @function
Array_Node.set:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	mv	a0,a2
	sw	a0,-16(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-16(s0)
	sw	a1,0(a0)
.LAB30:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Array_Node.set, .-Array_Node.set
	.text
	.align	2
	.globl	Array_Node.swap
	.type	Array_Node.swap, @function
Array_Node.swap:
	addi	sp,sp,-32
	sw	s0,28(sp)
	addi	s0,sp,32
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	mv	a0,a2
	sw	a0,-16(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-20(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,1
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-12(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-20(s0)
	sw	a1,0(a0)
.LAB31:
	lw	s0,28(sp)
	addi	sp,sp,32
	jr	ra
	.size	Array_Node.swap, .-Array_Node.swap
	.text
	.align	2
	.globl	Array_Node.doubleStorage
	.type	Array_Node.doubleStorage, @function
Array_Node.doubleStorage:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-20(s0)
	lw	a0,-16(s0)
	call	size
	li	a1,2
	mul	a0,a0,a1
	mv	a1,a0
	sw	a1,-24(s0)
	call	my_array_alloc
	sw	a0,-28(s0)
.LAB33:
	lw	a0,-24(s0)
	beq	a0,zero,.LAB34
	li	a0,8
	call	malloc
	lw	a1,-28(s0)
	lw	a2,-24(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-24(s0)
	addi	a0,a0,-1
	sw	a0,-24(s0)
	j	.LAB33
.LAB34:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB35:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-20(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB36
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	addi	a0,a0,1
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,0
	lw	a3,-12(s0)
	slli	a2,a2,2
	add	a2,a3,a2
	lw	a2,0(a2)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
.LAB37:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
	j	.LAB35
.LAB36:
.LAB32:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Array_Node.doubleStorage, .-Array_Node.doubleStorage
	.text
	.align	2
	.globl	Heap_Node.Heap_Node
	.type	Heap_Node.Heap_Node, @function
Heap_Node.Heap_Node:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,8
	call	malloc
	mv	a6,a0
	sw	a6,-16(s0)
	call	Array_Node.Array_Node
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a6,-16(s0)
	mv	a1,a6
	sw	a1,0(a0)
.LAB38:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.Heap_Node, .-Heap_Node.Heap_Node
	.text
	.align	2
	.globl	Heap_Node.push
	.type	Heap_Node.push, @function
Heap_Node.push:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	lw	a0,0(a0)
	call	Array_Node.push_back
	lw	a0,-12(s0)
	call	Heap_Node.size
	li	a1,1
	sub	a0,a0,a1
	sw	a0,-20(s0)
.LAB40:
	li	a0,0
	lw	a1,-20(s0)
	sgt	a0,a1,a0
	beq	a0,zero,.LAB41
	lw	a0,-20(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	Heap_Node.pnt
	sw	a0,-24(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	mv	a6,a0
	sw	a6,-28(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	lw	a6,-28(s0)
	slt	a0,a6,a0
	xori	a0,a0,1
	beq	a0,zero,.LAB42
	j	.LAB41
.LAB42:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	mv	a2,a1
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	Array_Node.swap
	lw	a0,-24(s0)
	sw	a0,-20(s0)
	j	.LAB40
.LAB41:
.LAB39:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Heap_Node.push, .-Heap_Node.push
	.text
	.align	2
	.globl	Heap_Node.pop
	.type	Heap_Node.pop, @function
Heap_Node.pop:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	Array_Node.front
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-20(s0)
	li	a6,0
	sw	a6,-24(s0)
	lw	a0,-12(s0)
	call	Heap_Node.size
	li	a1,1
	sub	a0,a0,a1
	mv	a2,a0
	lw	a6,-24(s0)
	mv	a1,a6
	lw	a6,-20(s0)
	lw	a0,0(a6)
	call	Array_Node.swap
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	Array_Node.pop_back
	li	a0,0
	mv	a1,a0
	lw	a0,-12(s0)
	call	Heap_Node.maxHeapify
	lw	a0,-16(s0)
	j	.LAB43
.LAB43:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Heap_Node.pop, .-Heap_Node.pop
	.text
	.align	2
	.globl	Heap_Node.top
	.type	Heap_Node.top, @function
Heap_Node.top:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	Array_Node.front
	j	.LAB44
.LAB44:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.top, .-Heap_Node.top
	.text
	.align	2
	.globl	Heap_Node.size
	.type	Heap_Node.size, @function
Heap_Node.size:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	Array_Node.size
	j	.LAB45
.LAB45:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.size, .-Heap_Node.size
	.text
	.align	2
	.globl	Heap_Node.lchild
	.type	Heap_Node.lchild, @function
Heap_Node.lchild:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	mul	a0,a1,a0
	li	a1,1
	add	a0,a0,a1
	j	.LAB46
.LAB46:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.lchild, .-Heap_Node.lchild
	.text
	.align	2
	.globl	Heap_Node.rchild
	.type	Heap_Node.rchild, @function
Heap_Node.rchild:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	mul	a0,a1,a0
	li	a1,2
	add	a0,a0,a1
	j	.LAB47
.LAB47:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.rchild, .-Heap_Node.rchild
	.text
	.align	2
	.globl	Heap_Node.pnt
	.type	Heap_Node.pnt, @function
Heap_Node.pnt:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,1
	lw	a1,-12(s0)
	sub	a0,a1,a0
	li	a1,2
	div	a0,a0,a1
	j	.LAB48
.LAB48:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Heap_Node.pnt, .-Heap_Node.pnt
	.text
	.align	2
	.globl	Heap_Node.maxHeapify
	.type	Heap_Node.maxHeapify, @function
Heap_Node.maxHeapify:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	Heap_Node.lchild
	sw	a0,-20(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	Heap_Node.rchild
	sw	a0,-24(s0)
	lw	a0,-16(s0)
	sw	a0,-28(s0)
	lw	a0,-12(s0)
	call	Heap_Node.size
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB51
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	mv	a6,a0
	sw	a6,-32(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	lw	a6,-32(s0)
	sgt	a0,a6,a0
	beq	a0,zero,.LAB51
	li	a0,1
	j	.LAB52
.LAB51:
	li	a0,0
.LAB52:
	beq	a0,zero,.LAB50
	lw	a0,-20(s0)
	sw	a0,-28(s0)
.LAB50:
	lw	a0,-12(s0)
	call	Heap_Node.size
	lw	a1,-24(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB54
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	mv	a6,a0
	sw	a6,-36(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	lw	a0,0(a0)
	call	Array_Node.get
	call	Node.key_
	lw	a6,-36(s0)
	sgt	a0,a6,a0
	beq	a0,zero,.LAB54
	li	a0,1
	j	.LAB55
.LAB54:
	li	a0,0
.LAB55:
	beq	a0,zero,.LAB53
	lw	a0,-24(s0)
	sw	a0,-28(s0)
.LAB53:
	lw	a0,-28(s0)
	lw	a1,-16(s0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB56
	j	.LAB49
.LAB56:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	mv	a2,a1
	lw	a1,-16(s0)
	lw	a0,0(a0)
	call	Array_Node.swap
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	Heap_Node.maxHeapify
.LAB49:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	Heap_Node.maxHeapify, .-Heap_Node.maxHeapify
	.text
	.align	2
	.globl	init
	.type	init, @function
init:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	call	getInt
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	call	getInt
	lui	a1,%hi(.G1)
	sw	a0,%lo(.G1)(a1)
	li	a0,16
	call	malloc
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
	lui	a0,%hi(.G1)
	lw	a0,%lo(.G1)(a0)
	mv	a2,a0
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	mv	a1,a0
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	EdgeList.init
	li	a0,0
	sw	a0,-16(s0)
.LAB58:
	lw	a0,-16(s0)
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB59
	call	getInt
	sw	a0,-20(s0)
	call	getInt
	sw	a0,-24(s0)
	call	getInt
	sw	a0,-28(s0)
	lw	a0,-28(s0)
	mv	a3,a0
	lw	a0,-24(s0)
	mv	a2,a0
	lw	a0,-20(s0)
	mv	a1,a0
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	EdgeList.addEdge
.LAB60:
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB58
.LAB59:
.LAB57:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	init, .-init
	.text
	.align	2
	.globl	Node.key_
	.type	Node.key_, @function
Node.key_:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	neg	a0,a0
	j	.LAB61
.LAB61:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Node.key_, .-Node.key_
	.text
	.align	2
	.globl	dijkstra
	.type	dijkstra, @function
dijkstra:
	addi	sp,sp,-80
	sw	s0,76(sp)
	sw	ra,72(sp)
	addi	s0,sp,80
	sw	a0,-16(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	sw	a0,-64(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	call	my_array_alloc
	sw	a0,-68(s0)
.LAB63:
	lw	a0,-64(s0)
	beq	a0,zero,.LAB64
	lw	a0,-68(s0)
	lw	a1,-64(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-64(s0)
	addi	a0,a0,-1
	sw	a0,-64(s0)
	j	.LAB63
.LAB64:
	lw	a0,-68(s0)
	sw	a0,-20(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	sw	a0,-72(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	call	my_array_alloc
	sw	a0,-76(s0)
.LAB65:
	lw	a0,-72(s0)
	beq	a0,zero,.LAB66
	lw	a0,-76(s0)
	lw	a1,-72(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-72(s0)
	addi	a0,a0,-1
	sw	a0,-72(s0)
	j	.LAB65
.LAB66:
	lw	a0,-76(s0)
	sw	a0,-24(s0)
	li	a0,0
	sw	a0,-28(s0)
.LAB67:
	lw	a0,-28(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB68
	lw	a0,-28(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lui	a1,%hi(.G3)
	lw	a1,%lo(.G3)(a1)
	sw	a1,0(a0)
	li	a0,0
	lw	a1,-28(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB69:
	lw	a0,-28(s0)
	addi	a0,a0,1
	sw	a0,-28(s0)
	j	.LAB67
.LAB68:
	li	a0,0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,4
	call	malloc
	mv	a6,a0
	sw	a6,-80(s0)
	call	Heap_Node.Heap_Node
	lw	a6,-80(s0)
	mv	a0,a6
	sw	a0,-32(s0)
	li	a0,8
	call	malloc
	sw	a0,-36(s0)
	li	a0,0
	li	a1,1
	lw	a2,-36(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	lw	a1,-36(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
	lw	a0,-36(s0)
	mv	a1,a0
	lw	a0,-32(s0)
	call	Heap_Node.push
.LAB70:
	lw	a0,-32(s0)
	call	Heap_Node.size
	li	a1,0
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB71
	lw	a0,-32(s0)
	call	Heap_Node.pop
	sw	a0,-40(s0)
	li	a0,0
	lw	a1,-40(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-44(s0)
	lw	a0,-44(s0)
	addi	a0,a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB72
	j	.LAB70
.LAB72:
	li	a0,1
	lw	a1,-44(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,3
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-44(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-48(s0)
.LAB73:
	li	a0,1
	neg	a0,a0
	lw	a1,-48(s0)
	sub	a1,a1,a0
	snez	a0,a1
	beq	a0,zero,.LAB74
	li	a0,2
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,2
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-52(s0)
	li	a0,2
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-56(s0)
	lw	a0,-44(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-56(s0)
	add	a0,a0,a1
	sw	a0,-60(s0)
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-60(s0)
	lw	a0,0(a0)
	slt	a0,a1,a0
	xori	a0,a0,1
	beq	a0,zero,.LAB76
	j	.LAB75
.LAB76:
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-60(s0)
	sw	a1,0(a0)
	li	a0,8
	call	malloc
	sw	a0,-40(s0)
	li	a0,0
	lw	a1,-40(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-52(s0)
	sw	a1,0(a0)
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-40(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	sw	a0,0(a1)
	lw	a0,-40(s0)
	mv	a1,a0
	lw	a0,-32(s0)
	call	Heap_Node.push
.LAB75:
	li	a0,0
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-48(s0)
	j	.LAB73
.LAB74:
	j	.LAB70
.LAB71:
	lw	a0,-24(s0)
	j	.LAB62
.LAB62:
	lw	s0,76(sp)
	lw	ra,72(sp)
	addi	sp,sp,80
	jr	ra
	.size	dijkstra, .-dijkstra
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	li	a0,10000000
	lui	a1,%hi(.G3)
	sw	a0,%lo(.G3)(a1)
	call	init
	li	a0,0
	sw	a0,-16(s0)
.LAB78:
	lw	a0,-16(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB79
	lw	a0,-16(s0)
	call	dijkstra
	sw	a0,-24(s0)
	li	a0,0
	sw	a0,-20(s0)
.LAB81:
	lw	a0,-20(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB82
	lw	a0,-20(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lui	a1,%hi(.G3)
	lw	a1,%lo(.G3)(a1)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB85
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	print
	j	.LAB84
.LAB85:
	lw	a0,-20(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	toString
	call	print
.LAB84:
	lui	a0,%hi(.LS1)
	addi	a0,a0,%lo(.LS1)
	call	print
.LAB83:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB81
.LAB82:
	lui	a0,%hi(.LS2)
	addi	a0,a0,%lo(.LS2)
	call	println
.LAB80:
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB78
.LAB79:
	li	a0,0
	j	.LAB77
.LAB77:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
