	.text
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
	.text
	.align	2
	.globl	jud
	.type	jud, @function
jud:
	addi	sp,sp,-32
	sw	s0,28(sp)
	addi	s0,sp,32
	sw	a0,-8(s0)
	li	a0,0
	sw	a0,-12(s0)
.LAB2:
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	lw	a1,-8(s0)
	div	a0,a0,a1
	lw	a1,-12(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB3
	li	a0,0
	sw	a0,-20(s0)
	li	a0,0
	sw	a0,-16(s0)
.LAB5:
	li	a0,1
	lw	a1,-8(s0)
	sub	a0,a1,a0
	lw	a1,-16(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB6
	lw	a0,-12(s0)
	lw	a1,-8(s0)
	mul	a0,a0,a1
	lw	a1,-16(s0)
	add	a0,a0,a1
	addi	a0,a0,1
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-12(s0)
	lw	a2,-8(s0)
	mul	a1,a1,a2
	lw	a2,-16(s0)
	add	a1,a1,a2
	li	a2,1
	add	a1,a1,a2
	addi	a1,a1,1
	lui	a2,%hi(.G1)
	lw	a2,%lo(.G1)(a2)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	lw	a1,0(a1)
	sgt	a0,a0,a1
	beq	a0,zero,.LAB8
	li	a0,1
	sw	a0,-20(s0)
.LAB8:
.LAB7:
	lw	a0,-16(s0)
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB5
.LAB6:
	lw	a0,-20(s0)
	seqz	a0,a0
	beq	a0,zero,.LAB9
	li	a0,1
	j	.LAB1
.LAB9:
.LAB4:
	lw	a0,-12(s0)
	lw	a0,-12(s0)
	addi	a0,a0,1
	sw	a0,-12(s0)
	j	.LAB2
.LAB3:
	li	a0,0
	j	.LAB1
.LAB1:
	lw	s0,28(sp)
	addi	sp,sp,32
	jr	ra
	.size	jud, .-jud
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	li	a0,20
	mv	a1,a0
	sw	a1,-28(s0)
	call	my_array_alloc
	sw	a0,-32(s0)
.LAB11:
	lw	a0,-28(s0)
	beq	a0,zero,.LAB12
	lw	a0,-32(s0)
	lw	a1,-28(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-28(s0)
	addi	a0,a0,-1
	sw	a0,-28(s0)
	j	.LAB11
.LAB12:
	lw	a0,-32(s0)
	lui	a1,%hi(.G1)
	sw	a0,%lo(.G1)(a1)
	call	getInt
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	li	a0,0
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
.LAB13:
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB14
	call	getInt
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	addi	a1,a1,1
	lui	a2,%hi(.G1)
	lw	a2,%lo(.G1)(a2)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB15:
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	addi	a0,a0,1
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
	j	.LAB13
.LAB14:
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
.LAB16:
	li	a0,0
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	sgt	a0,a1,a0
	beq	a0,zero,.LAB17
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	jud
	li	a1,0
	sgt	a0,a0,a1
	beq	a0,zero,.LAB19
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	toString
	call	print
	li	a0,0
	j	.LAB10
.LAB19:
.LAB18:
	li	a0,2
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	div	a0,a1,a0
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
	j	.LAB16
.LAB17:
	li	a0,0
	j	.LAB10
.LAB10:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
