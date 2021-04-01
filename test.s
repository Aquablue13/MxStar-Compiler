	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"Warning: Queue_int::pop: empty queue"
	.align	2
.LS1:
	.string	"q.size() != N after pushes"
	.align	2
.LS2:
	.string	"Head != i"
	.align	2
.LS3:
	.string	"Failed: q.pop() != i"
	.align	2
.LS4:
	.string	"q.size() != N - i - 1"
	.align	2
.LS5:
	.string	"Passed tests."
	.text
	.align	2
	.globl	Queue_int.Queue_int
	.type	Queue_int.Queue_int, @function
Queue_int.Queue_int:
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
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,16
	mv	a1,a0
	sw	a1,-16(s0)
	call	my_array_alloc
	sw	a0,-20(s0)
.LAB2:
	lw	a0,-16(s0)
	beq	a0,zero,.LAB3
	lw	a0,-20(s0)
	lw	a1,-16(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-16(s0)
	addi	a0,a0,-1
	sw	a0,-16(s0)
	j	.LAB2
.LAB3:
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	sw	a1,0(a0)
.LAB1:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Queue_int.Queue_int, .-Queue_int.Queue_int
	.text
	.align	2
	.globl	Queue_int.push
	.type	Queue_int.push, @function
Queue_int.push:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	Queue_int.size
	mv	a6,a0
	sw	a6,-20(s0)
	li	a0,2
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	li	a1,1
	sub	a0,a0,a1
	lw	a6,-20(s0)
	sub	a6,a6,a0
	seqz	a0,a6
	beq	a0,zero,.LAB5
	lw	a0,-12(s0)
	call	Queue_int.doubleStorage
.LAB5:
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
	lw	a1,-16(s0)
	sw	a1,0(a0)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	add	a6,a0,a1
	sw	a6,-24(s0)
	li	a0,2
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	lw	a6,-24(s0)
	rem	a0,a6,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB4:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Queue_int.push, .-Queue_int.push
	.text
	.align	2
	.globl	Queue_int.top
	.type	Queue_int.top, @function
Queue_int.top:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,2
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
	j	.LAB6
.LAB6:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	Queue_int.top, .-Queue_int.top
	.text
	.align	2
	.globl	Queue_int.pop
	.type	Queue_int.pop, @function
Queue_int.pop:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	lw	a0,-12(s0)
	call	Queue_int.size
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB8
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	println
.LAB8:
	lw	a0,-12(s0)
	call	Queue_int.top
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	add	a6,a0,a1
	sw	a6,-20(s0)
	li	a0,2
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	lw	a6,-20(s0)
	rem	a0,a6,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-16(s0)
	j	.LAB7
.LAB7:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Queue_int.pop, .-Queue_int.pop
	.text
	.align	2
	.globl	Queue_int.size
	.type	Queue_int.size, @function
Queue_int.size:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-16(s0)
	li	a0,2
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	lw	a6,-16(s0)
	lw	a1,0(a6)
	add	a0,a1,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	sub	a6,a0,a1
	sw	a6,-20(s0)
	li	a0,2
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	size
	lw	a6,-20(s0)
	rem	a0,a6,a0
	j	.LAB9
.LAB9:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	Queue_int.size, .-Queue_int.size
	.text
	.align	2
	.globl	Queue_int.doubleStorage
	.type	Queue_int.doubleStorage, @function
Queue_int.doubleStorage:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	li	a0,2
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
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-24(s0)
	lw	a0,-16(s0)
	call	size
	li	a1,2
	mul	a0,a0,a1
	mv	a1,a0
	sw	a1,-32(s0)
	call	my_array_alloc
	sw	a0,-36(s0)
.LAB11:
	lw	a0,-32(s0)
	beq	a0,zero,.LAB12
	lw	a0,-36(s0)
	lw	a1,-32(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-32(s0)
	addi	a0,a0,-1
	sw	a0,-32(s0)
	j	.LAB11
.LAB12:
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-36(s0)
	sw	a1,0(a0)
	li	a0,0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-20(s0)
	sw	a0,-28(s0)
.LAB13:
	lw	a0,-28(s0)
	lw	a1,-24(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB14
	lw	a0,-28(s0)
	addi	a0,a0,1
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,2
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
	lw	a1,0(a0)
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
	li	a0,1
	lw	a1,-28(s0)
	add	a6,a1,a0
	sw	a6,-40(s0)
	lw	a0,-16(s0)
	call	size
	lw	a6,-40(s0)
	rem	a0,a6,a0
	sw	a0,-28(s0)
	j	.LAB13
.LAB14:
.LAB10:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	Queue_int.doubleStorage, .-Queue_int.doubleStorage
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	li	a0,12
	call	malloc
	mv	a6,a0
	sw	a6,-32(s0)
	call	Queue_int.Queue_int
	lw	a6,-32(s0)
	mv	a0,a6
	sw	a0,-16(s0)
	li	a0,100
	sw	a0,-24(s0)
	li	a0,0
	sw	a0,-20(s0)
.LAB16:
	lw	a0,-20(s0)
	lw	a1,-24(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB17
	lw	a0,-20(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	Queue_int.push
.LAB18:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB16
.LAB17:
	lw	a0,-16(s0)
	call	Queue_int.size
	lw	a1,-24(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB19
	lui	a0,%hi(.LS1)
	addi	a0,a0,%lo(.LS1)
	call	println
	li	a0,1
	j	.LAB15
.LAB19:
	li	a0,0
	sw	a0,-20(s0)
.LAB20:
	lw	a0,-20(s0)
	lw	a1,-24(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB21
	lw	a0,-16(s0)
	call	Queue_int.top
	sw	a0,-28(s0)
	lw	a0,-28(s0)
	lw	a1,-20(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB23
	lui	a0,%hi(.LS2)
	addi	a0,a0,%lo(.LS2)
	call	println
	li	a0,1
	j	.LAB15
.LAB23:
	lw	a0,-16(s0)
	call	Queue_int.pop
	lw	a1,-20(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB24
	lui	a0,%hi(.LS3)
	addi	a0,a0,%lo(.LS3)
	call	println
	li	a0,1
	j	.LAB15
.LAB24:
	lw	a0,-16(s0)
	call	Queue_int.size
	lw	a1,-24(s0)
	lw	a2,-20(s0)
	sub	a1,a1,a2
	li	a2,1
	sub	a1,a1,a2
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB25
	lui	a0,%hi(.LS4)
	addi	a0,a0,%lo(.LS4)
	call	println
	li	a0,1
	j	.LAB15
.LAB25:
.LAB22:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB20
.LAB21:
	lui	a0,%hi(.LS5)
	addi	a0,a0,%lo(.LS5)
	call	println
	li	a0,0
	j	.LAB15
.LAB15:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
