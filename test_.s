state:11
anger:11
init_anger:2
work_anger:2
!
!
!
!
!
mr:1
!
mars:1
STRING(0) , 
STRING(1)  enjoys this work. XD
STRING(2) , 
STRING(3)  wants to give up!!!!!
STRING(4) the leading TA
STRING(5) the striking TA
STRING(6) MR
STRING(7) Mars
STRING(8) Mars
GLOBAL(0) 0
GLOBAL(1) 0
FUNC work
	MOVE L1 10
	MOVE L2 11
	LOAD T1 i1
	INDEX T2 L2 T1
	LOAD T3 i100
	LEQ T0 *T2 T3
	BNEQ(3) T0 0
	LOADSTRING T7 S0
	MOVE P1 T7
	MOVE P0 L1
	CALL my_string_plus
	MOVE T6 10
	LOAD T8 i0
	INDEX T9 L2 T8
	MOVE P1 *T9
	MOVE P0 T6
	CALL my_string_plus
	MOVE T5 10
	LOADSTRING T10 S1
	MOVE P1 T10
	MOVE P0 T5
	CALL my_string_plus
	MOVE T4 10
	MOVE P0 T4
	CALL println
	MOVE T11 10
	JUMP(2)
LABEL(3)
	LOADSTRING T15 S2
	MOVE P1 T15
	MOVE P0 L1
	CALL my_string_plus
	MOVE T14 10
	LOAD T16 i0
	INDEX T17 L2 T16
	MOVE P1 *T17
	MOVE P0 T14
	CALL my_string_plus
	MOVE T13 10
	LOADSTRING T18 S3
	MOVE P1 T18
	MOVE P0 T13
	CALL my_string_plus
	MOVE T12 10
	MOVE P0 T12
	CALL println
	MOVE T19 10
LABEL(2)
	LOAD T21 i1
	INDEX T22 L2 T21
	ADD T20 *T22 G1
	LOAD T23 i1
	INDEX T24 L2 T23
	MOVE *T24 T20
FUNC main
	LOAD T0 i100
	MOVE G0 T0
	LOAD T1 i10
	MOVE G1 T1
	LOAD 10 i8
	CALL malloc
	MOVE T2 10
	MOVE L1 T2
	LOADSTRING T3 S4
	LOAD T4 i0
	INDEX T5 L1 T4
	MOVE *T5 T3
	LOAD T6 i0
	LOAD T7 i1
	INDEX T8 L1 T7
	MOVE *T8 T6
	LOAD 10 i8
	CALL malloc
	MOVE T9 10
	MOVE L2 T9
	LOADSTRING T10 S5
	LOAD T11 i0
	INDEX T12 L2 T11
	MOVE *T12 T10
	LOAD T13 i1
	INDEX T14 L2 T13
	MOVE *T14 G0
	LOADSTRING T15 S6
	MOVE P1 L1
	MOVE P0 T15
	CALL work
	MOVE T16 10
	LOADSTRING T17 S7
	MOVE P1 L2
	MOVE P0 T17
	CALL work
	MOVE T18 10
	LOADSTRING T19 S8
	MOVE P1 L2
	MOVE P0 T19
	CALL work
	MOVE T20 10
	LOAD T21 i0
	MOVE 10 T21
	JUMP(4)
	.text
	.section	.rodata
	.align	2
.LS0:
	.string	", "
	.align	2
.LS1:
	.string	" enjoys this work. XD"
	.align	2
.LS2:
	.string	", "
	.align	2
.LS3:
	.string	" wants to give up!!!!!"
	.align	2
.LS4:
	.string	"the leading TA"
	.align	2
.LS5:
	.string	"the striking TA"
	.align	2
.LS6:
	.string	"MR"
	.align	2
.LS7:
	.string	"Mars"
	.align	2
.LS8:
	.string	"Mars"
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
	.text
	.align	2
	.globl	work
	.type	work, @function
work:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-16(s0)
	mv	a0,a1
	sw	a0,-20(s0)
	li	a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,100
	lw	a0,0(a0)
	sgt	a0,a0,a1
	xori	a0,a0,1
	beq	a0,zero,.LAB3
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_string_plus
	li	a1,0
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	call	my_string_plus
	lui	a1,%hi(.LS1)
	addi	a1,a1,%lo(.LS1)
	call	my_string_plus
	call	println
	j	.LAB2
.LAB3:
	lui	a0,%hi(.LS2)
	addi	a0,a0,%lo(.LS2)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_string_plus
	li	a1,0
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	call	my_string_plus
	lui	a1,%hi(.LS3)
	addi	a1,a1,%lo(.LS3)
	call	my_string_plus
	call	println
.LAB2:
	li	a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	add	a0,a0,a1
	li	a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB1:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	work, .-work
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	li	a0,100
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	li	a0,10
	lui	a1,%hi(.G1)
	sw	a0,%lo(.G1)(a1)
	li	a0,8
	call	malloc
	sw	a0,-16(s0)
	lui	a0,%hi(.LS4)
	addi	a0,a0,%lo(.LS4)
	li	a1,0
	lw	a2,-16(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	li	a1,1
	lw	a2,-16(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,8
	call	malloc
	sw	a0,-20(s0)
	lui	a0,%hi(.LS5)
	addi	a0,a0,%lo(.LS5)
	li	a1,0
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	sw	a1,0(a0)
	lui	a0,%hi(.LS6)
	addi	a0,a0,%lo(.LS6)
	lw	a1,-16(s0)
	call	work
	lui	a0,%hi(.LS7)
	addi	a0,a0,%lo(.LS7)
	lw	a1,-20(s0)
	call	work
	lui	a0,%hi(.LS8)
	addi	a0,a0,%lo(.LS8)
	lw	a1,-20(s0)
	call	work
	li	a0,0
	j	.LAB4
.LAB4:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
