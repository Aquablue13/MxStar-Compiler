age:11
!
!
i:1
!
j:1
!
k:1
!
!
mrJiang:1
STRING(0) eternal!
FUNC my_c_older_solveAge
	MOVE L0 10
	LOAD T0 i1
	MOVE L1 T0
LABEL(2)
	LOAD T2 i100
	LE T1 L1 T2
	BNEQ(3) T1 0
	LOAD T4 i1
	ADD T3 L1 T4
	MOVE L2 T3
LABEL(5)
	LOAD T6 i100
	LE T5 L2 T6
	BNEQ(6) T5 0
	LOAD T8 i1
	ADD T7 L2 T8
	MOVE L3 T7
LABEL(8)
	LOAD T10 i100
	LE T9 L3 T10
	BNEQ(9) T9 0
	SUB T21 L1 L1
	ADD T20 T21 L1
	ADD T19 T20 L2
	SUB T18 T19 L2
	ADD T17 T18 L2
	ADD T16 T17 L3
	SUB T15 T16 L3
	ADD T14 T15 L3
	LOAD T25 i100
	MUL T24 T25 L1
	LOAD T27 i10
	MUL T26 T27 L2
	ADD T23 T24 T26
	ADD T22 T23 L3
	MUL T13 T14 T22
	LOAD T28 i1926
	MOD T12 T13 T28
	LOAD T29 i0
	EQ T11 T12 T29
	BNEQ(11) T11 0
	SUB T38 L1 L1
	ADD T37 T38 L1
	ADD T36 T37 L2
	SUB T35 T36 L2
	ADD T34 T35 L2
	ADD T33 T34 L3
	SUB T32 T33 L3
	ADD T31 T32 L3
	LOAD T42 i100
	MUL T41 T42 L1
	LOAD T44 i10
	MUL T43 T44 L2
	ADD T40 T41 T43
	ADD T39 T40 L3
	MUL T30 T31 T39
	LOAD T45 i0
	INDEX T46 L0 T45
	MOVE *T46 T30
LABEL(11)
LABEL(10)
	MOVE T47 L3
	ADDI L3 L3 i1
	JUMP(8)
LABEL(9)
LABEL(7)
	MOVE T48 L2
	ADDI L2 L2 i1
	JUMP(5)
LABEL(6)
LABEL(4)
	MOVE T49 L1
	ADDI L1 L1 i1
	JUMP(2)
LABEL(3)
FUNC main
	LOAD 10 i4
	CALL malloc
	MOVE T0 10
	MOVE L1 T0
	MOVE P0 L1
	CALL my_c_older_solveAge
	MOVE T1 10
	LOAD T3 i0
	INDEX T4 L1 T3
	LOAD T5 i10000
	GE T2 *T4 T5
	BNEQ(13) T2 0
	LOADSTRING T6 S0
	MOVE P0 T6
	CALL println
	MOVE T7 10
LABEL(13)
	LOAD T8 i0
	MOVE 10 T8
	JUMP(12)
	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"eternal!"
	.text
	.align	2
	.globl	my_c_older_solveAge
	.type	my_c_older_solveAge, @function
my_c_older_solveAge:
	addi	sp,sp,-32
	sw	s0,28(sp)
	addi	s0,sp,32
	sw	a0,-8(s0)
	li	a0,1
	sw	a0,-12(s0)
.LAB2:
	li	a0,100
	lw	a1,-12(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB3
	li	a0,1
	lw	a1,-12(s0)
	add	a0,a1,a0
	sw	a0,-16(s0)
.LAB5:
	li	a0,100
	lw	a1,-16(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB6
	li	a0,1
	lw	a1,-16(s0)
	add	a0,a1,a0
	sw	a0,-20(s0)
.LAB8:
	li	a0,100
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB9
	lw	a0,-12(s0)
	lw	a1,-12(s0)
	sub	a0,a0,a1
	lw	a1,-12(s0)
	add	a0,a0,a1
	lw	a1,-16(s0)
	add	a0,a0,a1
	lw	a1,-16(s0)
	sub	a0,a0,a1
	lw	a1,-16(s0)
	add	a0,a0,a1
	lw	a1,-20(s0)
	add	a0,a0,a1
	lw	a1,-20(s0)
	sub	a0,a0,a1
	lw	a1,-20(s0)
	add	a0,a0,a1
	li	a1,100
	lw	a2,-12(s0)
	mul	a1,a1,a2
	li	a2,10
	lw	a3,-16(s0)
	mul	a2,a2,a3
	add	a1,a1,a2
	lw	a2,-20(s0)
	add	a1,a1,a2
	mul	a0,a0,a1
	li	a1,1926
	rem	a0,a0,a1
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB11
	lw	a0,-12(s0)
	lw	a1,-12(s0)
	sub	a0,a0,a1
	lw	a1,-12(s0)
	add	a0,a0,a1
	lw	a1,-16(s0)
	add	a0,a0,a1
	lw	a1,-16(s0)
	sub	a0,a0,a1
	lw	a1,-16(s0)
	add	a0,a0,a1
	lw	a1,-20(s0)
	add	a0,a0,a1
	lw	a1,-20(s0)
	sub	a0,a0,a1
	lw	a1,-20(s0)
	add	a0,a0,a1
	li	a1,100
	lw	a2,-12(s0)
	mul	a1,a1,a2
	li	a2,10
	lw	a3,-16(s0)
	mul	a2,a2,a3
	add	a1,a1,a2
	lw	a2,-20(s0)
	add	a1,a1,a2
	mul	a0,a0,a1
	li	a1,0
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB11:
.LAB10:
	lw	a0,-20(s0)
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB8
.LAB9:
.LAB7:
	lw	a0,-16(s0)
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB5
.LAB6:
.LAB4:
	lw	a0,-12(s0)
	lw	a0,-12(s0)
	addi	a0,a0,1
	sw	a0,-12(s0)
	j	.LAB2
.LAB3:
.LAB1:
	lw	s0,28(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_older_solveAge, .-my_c_older_solveAge
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	li	a0,4
	call	malloc
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	call	my_c_older_solveAge
	li	a0,0
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,10000
	lw	a0,0(a0)
	sgt	a0,a0,a1
	beq	a0,zero,.LAB13
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	println
.LAB13:
	li	a0,0
	j	.LAB12
.LAB12:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	main, .-main
