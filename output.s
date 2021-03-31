	.text
	.globl	.G0
	.section	.sbss,"aw",@nobits
	.align	2
	.type	.G0, @object
	.size	.G0, 4
.G0:
	.zero	4
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	li	a0,0
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	call	getInt
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	sw	a0,-32(s0)
	lw	a0,-16(s0)
	call	my_array_alloc
	sw	a0,-36(s0)
.LAB2:
	lw	a0,-32(s0)
	beq	a0,zero,.LAB3
	lw	a0,-36(s0)
	lw	a1,-32(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-32(s0)
	addi	a0,a0,-1
	sw	a0,-32(s0)
	j	.LAB2
.LAB3:
	lw	a0,-36(s0)
	sw	a0,-20(s0)
	li	a0,0
	sw	a0,-24(s0)
.LAB4:
	lw	a0,-24(s0)
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB5
	call	getString
	lw	a1,-24(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-24(s0)
	addi	a0,a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	length
	sw	a0,-28(s0)
.LAB6:
	lw	a0,-24(s0)
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB4
.LAB5:
	li	a0,0
	j	.LAB1
.LAB1:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	main, .-main
