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
	.globl	.G3
	.align	2
	.type	.G3, @object
	.size	.G3, 4
.G3:
	.zero	4
	.globl	.G4
	.align	2
	.type	.G4, @object
	.size	.G4, 4
.G4:
	.zero	4
	.text
	.align	2
	.globl	abs
	.type	abs, @function
abs:
	addi	sp,sp,-16
	mv	a1,a0
	li	a0,0
	sgt	a0,a1,a0
	beq	a0,zero,.b0l2
	mv	a0,a1
	j	.b0l1
.b0l2:
	neg	a1,a1
	mv	a0,a1
	j	.b0l1
.b0l1:
	addi	sp,sp,16
	jr	ra
	.size	abs, .-abs
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	li	a0,0
	mv	a1,a0
	lui	a0,%hi(.G3)
	sw	a1,%lo(.G3)(a0)
.b1l2:
	li	a1,5
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	slt	a0,a0,a1
	beq	a0,zero,.b1l3
	li	a0,0
	mv	a1,a0
	lui	a0,%hi(.G4)
	sw	a1,%lo(.G4)(a0)
.b1l5:
	li	a1,5
	lui	a0,%hi(.G4)
	lw	a0,%lo(.G4)(a0)
	slt	a0,a0,a1
	beq	a0,zero,.b1l6
	call	getInt
	mv	a1,a0
	lui	a0,%hi(.G0)
	sw	a1,%lo(.G0)(a0)
	li	a1,1
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l8
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	mv	a1,a0
	lui	a0,%hi(.G1)
	sw	a1,%lo(.G1)(a0)
	lui	a0,%hi(.G4)
	lw	a0,%lo(.G4)(a0)
	mv	a1,a0
	lui	a0,%hi(.G2)
	sw	a1,%lo(.G2)(a0)
.b1l8:
.b1l7:
	lui	a0,%hi(.G4)
	lw	a0,%lo(.G4)(a0)
	lui	a0,%hi(.G4)
	lw	a0,%lo(.G4)(a0)
	addi	a1,a0,1
	lui	a0,%hi(.G4)
	sw	a1,%lo(.G4)(a0)
	j	.b1l5
.b1l6:
.b1l4:
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	addi	a1,a0,1
	lui	a0,%hi(.G3)
	sw	a1,%lo(.G3)(a0)
	j	.b1l2
.b1l3:
	li	a1,2
	lui	a0,%hi(.G1)
	lw	a0,%lo(.G1)(a0)
	sub	a0,a1,a0
	call	abs
	mv	s0,a0
	li	a1,2
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	sub	a0,a1,a0
	call	abs
	add	a0,s0,a0
	call	printInt
	li	a0,0
	j	.b1l1
.b1l1:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	main, .-main
