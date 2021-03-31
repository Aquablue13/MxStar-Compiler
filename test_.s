GLOBAL(0) 0
GLOBAL(1) 0
GLOBAL(2) 0
GLOBAL(3) 0
FUNC main
	CALL getInt
	MOVE T0 10
	MOVE G0 T0
	LOAD T1 i0
	MOVE G2 T1
LABEL(2)
	LE T2 G2 G0
	BNEQ(3) T2 0
	CALL getString
	MOVE T3 10
	MOVE G3 T3
	MOVE P0 G3
	CALL my_c_string_length
	MOVE T4 10
	MOVE G1 T4
	LOAD T6 i10
	GE T5 G1 T6
	BNEQ(6) T5 0
	LOAD T9 i0
	LOAD T10 i1
	MOVE P2 T10
	MOVE P1 T9
	MOVE P0 G3
	CALL my_c_string_substring
	MOVE T11 10
	LOAD T13 i2
	SUB T12 G1 T13
	MOVE P0 T12
	CALL toString
	MOVE T14 10
	MOVE P1 T14
	MOVE P0 T11
	CALL my_string_plus
	MOVE T8 10
	LOAD T16 i1
	SUB T15 G1 T16
	MOVE P2 G1
	MOVE P1 T15
	MOVE P0 G3
	CALL my_c_string_substring
	MOVE T17 10
	MOVE P1 T17
	MOVE P0 T8
	CALL my_string_plus
	MOVE T7 10
	MOVE P0 T7
	CALL println
	MOVE T18 10
	JUMP(5)
LABEL(6)
	MOVE P0 G3
	CALL println
	MOVE T19 10
LABEL(5)
LABEL(4)
	ADDI G2 G2 i1
	JUMP(2)
LABEL(3)
	MOVE 10 0
	JUMP(1)
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
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	call	getInt
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	li	a0,0
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
.LAB2:
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB3
	call	getString
	lui	a1,%hi(.G3)
	sw	a0,%lo(.G3)(a1)
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	call	my_c_string_length
	lui	a1,%hi(.G1)
	sw	a0,%lo(.G1)(a1)
	li	a0,10
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	sgt	a0,a1,a0
	beq	a0,zero,.LAB6
	li	a0,0
	li	a1,1
	mv	a2,a1
	mv	a1,a0
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	call	my_c_string_substring
	mv	a6,a0
	sw	a6,-16(s0)
	li	a0,2
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	sub	a0,a1,a0
	call	toString
	mv	a1,a0
	lw	a6,-16(s0)
	mv	a0,a6
	call	my_string_plus
	mv	a6,a0
	sw	a6,-20(s0)
	li	a0,1
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	sub	a0,a1,a0
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	mv	a2,a1
	mv	a1,a0
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	call	my_c_string_substring
	mv	a1,a0
	lw	a6,-20(s0)
	mv	a0,a6
	call	my_string_plus
	call	println
	j	.LAB5
.LAB6:
	lui	a0,%hi(.G3)
	lw	a0,%lo(.G3)(a0)
	call	println
.LAB5:
.LAB4:
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	addi	a0,a0,1
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
	j	.LAB2
.LAB3:
	mv	a0,zero
	j	.LAB1
.LAB1:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
