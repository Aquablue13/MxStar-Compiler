data:11
i:1
i:1
result:1
i:1
temp:1
i:1
temp:1
i:1
i:1
x:1
a:1
i:1
y:1
STRING(0) ( 
STRING(1) , 
STRING(2)  )
STRING(3) vector x: 
STRING(4) excited!
STRING(5) vector y: 
STRING(6) x + y: 
STRING(7) x * y: 
STRING(8) (1 << 3) * y: 
FUNC my_c_vector_init
	MOVE L0 10
	MOVE L1 11
	LOAD T1 i0
	EQ T0 L1 T1
	BNEQ(2) T0 0
	JUMP(1)
LABEL(2)
	MOVE P0 L1
	CALL my_array_size
	MOVE T2 10
	MOVE L3 T2
	MOVE T3 T2
	MOVE 10 T3
	CALL my_array_alloc
	MOVE L4 10
LABEL(3)
	BNEQ(4) L3 0
	INDEX T4 L4 L3
	MOVE *T4 0
	ADDI L3 L3 i-1
	JUMP(3)
LABEL(4)
	LOAD T5 i0
	INDEX T6 L0 T5
	MOVE *T6 L4
	LOAD T7 i0
	MOVE L2 T7
LABEL(5)
	MOVE P0 L1
	CALL my_array_size
	MOVE T9 10
	LE T8 L2 T9
	BNEQ(6) T8 0
	ADDI T10 L2 i1
	INDEX T11 L1 T10
	LOAD T12 i0
	INDEX T13 L0 T12
	ADDI T14 L2 i1
	INDEX T15 *T13 T14
	MOVE *T15 *T11
LABEL(7)
	ADDI L2 L2 i1
	JUMP(5)
LABEL(6)
FUNC my_c_vector_getDim
	MOVE L0 10
	LOAD T1 i0
	INDEX T2 L0 T1
	LOAD T3 i0
	EQ T0 *T2 T3
	BNEQ(9) T0 0
	LOAD T4 i0
	MOVE 10 T4
	JUMP(8)
LABEL(9)
	LOAD T5 i0
	INDEX T6 L0 T5
	MOVE P0 *T6
	CALL my_array_size
	MOVE T7 10
	MOVE 10 T7
	JUMP(8)
FUNC my_c_vector_dot
	MOVE L0 10
	MOVE L1 11
	LOAD T0 i0
	MOVE L2 T0
	LOAD T1 i0
	MOVE L3 T1
LABEL(11)
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T3 10
	LE T2 L2 T3
	BNEQ(12) T2 0
	LOAD T5 i0
	INDEX T6 L0 T5
	ADDI T7 L2 i1
	INDEX T8 *T6 T7
	LOAD T9 i0
	INDEX T10 L1 T9
	ADDI T11 L2 i1
	INDEX T12 *T10 T11
	MUL T4 *T8 *T12
	MOVE L3 T4
	ADDI L2 L2 i1
	JUMP(11)
LABEL(12)
	MOVE 10 L3
	JUMP(10)
FUNC my_c_vector_scalarInPlaceMultiply
	MOVE L0 10
	MOVE L1 11
	LOAD T1 i0
	INDEX T2 L0 T1
	LOAD T3 i0
	EQ T0 *T2 T3
	BNEQ(14) T0 0
	LOAD T4 i0
	MOVE 10 T4
	JUMP(13)
LABEL(14)
	LOAD T5 i0
	MOVE L2 T5
LABEL(15)
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T7 10
	LE T6 L2 T7
	BNEQ(16) T6 0
	LOAD T9 i0
	INDEX T10 L0 T9
	ADDI T11 L2 i1
	INDEX T12 *T10 T11
	MUL T8 L1 *T12
	LOAD T13 i0
	INDEX T14 L0 T13
	ADDI T15 L2 i1
	INDEX T16 *T14 T15
	MOVE *T16 T8
LABEL(17)
	ADDI L2 L2 i1
	JUMP(15)
LABEL(16)
	MOVE 10 L0
	JUMP(13)
FUNC my_c_vector_add
	MOVE L0 10
	MOVE L1 11
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T2 10
	MOVE P0 L1
	CALL my_c_vector_getDim
	MOVE T3 10
	NEQ T1 T2 T3
	BEQ(20) T1 0
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T5 10
	LOAD T6 i0
	EQ T4 T5 T6
	BEQ(20) T4 0
	LOAD T0 i0
	JUMP(21)
LABEL(20)
	LOAD T0 i1
LABEL(21)
	BNEQ(19) T0 0
	LOAD T7 i0
	MOVE 10 T7
	JUMP(18)
LABEL(19)
	LOAD 10 i4
	CALL malloc
	MOVE T8 10
	MOVE L2 T8
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T9 10
	MOVE L4 T9
	MOVE T10 T9
	MOVE 10 T10
	CALL my_array_alloc
	MOVE L5 10
LABEL(22)
	BNEQ(23) L4 0
	INDEX T11 L5 L4
	MOVE *T11 0
	ADDI L4 L4 i-1
	JUMP(22)
LABEL(23)
	LOAD T12 i0
	INDEX T13 L2 T12
	MOVE *T13 L5
	LOAD T14 i0
	MOVE L3 T14
LABEL(24)
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T16 10
	LE T15 L3 T16
	BNEQ(25) T15 0
	LOAD T18 i0
	INDEX T19 L0 T18
	ADDI T20 L3 i1
	INDEX T21 *T19 T20
	LOAD T22 i0
	INDEX T23 L1 T22
	ADDI T24 L3 i1
	INDEX T25 *T23 T24
	ADD T17 *T21 *T25
	LOAD T26 i0
	INDEX T27 L2 T26
	ADDI T28 L3 i1
	INDEX T29 *T27 T28
	MOVE *T29 T17
LABEL(26)
	ADDI L3 L3 i1
	JUMP(24)
LABEL(25)
	MOVE 10 L2
	JUMP(18)
FUNC my_c_vector_set
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T1 10
	LE T0 T1 L1
	BNEQ(28) T0 0
	LOAD T2 i0
	MOVE 10 T2
	JUMP(27)
LABEL(28)
	LOAD T3 i0
	INDEX T4 L0 T3
	ADDI T5 L1 i1
	INDEX T6 *T4 T5
	MOVE *T6 L2
	LOAD T7 i1
	MOVE 10 T7
	JUMP(27)
FUNC my_c_vector_tostring
	MOVE L0 10
	LOADSTRING T0 S0
	MOVE L1 T0
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T2 10
	LOAD T3 i0
	GE T1 T2 T3
	BNEQ(30) T1 0
	LOAD T5 i0
	INDEX T6 L0 T5
	LOAD T7 i0
	ADDI T8 T7 i1
	INDEX T9 *T6 T8
	MOVE P0 *T9
	CALL toString
	MOVE T10 10
	MOVE P1 T10
	MOVE P0 L1
	CALL my_string_plus
	MOVE T4 10
	MOVE L1 T4
LABEL(30)
	LOAD T11 i1
	MOVE L2 T11
LABEL(31)
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T13 10
	LE T12 L2 T13
	BNEQ(32) T12 0
	LOADSTRING T16 S1
	MOVE P1 T16
	MOVE P0 L1
	CALL my_string_plus
	MOVE T15 10
	LOAD T17 i0
	INDEX T18 L0 T17
	ADDI T19 L2 i1
	INDEX T20 *T18 T19
	MOVE P0 *T20
	CALL toString
	MOVE T21 10
	MOVE P1 T21
	MOVE P0 T15
	CALL my_string_plus
	MOVE T14 10
	MOVE L1 T14
LABEL(33)
	ADDI L2 L2 i1
	JUMP(31)
LABEL(32)
	LOADSTRING T23 S2
	MOVE P1 T23
	MOVE P0 L1
	CALL my_string_plus
	MOVE T22 10
	MOVE L1 T22
	MOVE 10 L1
	JUMP(29)
FUNC my_c_vector_copy
	MOVE L0 10
	MOVE L1 11
	LOAD T1 i0
	EQ T0 L1 T1
	BNEQ(35) T0 0
	LOAD T2 i0
	MOVE 10 T2
	JUMP(34)
LABEL(35)
	MOVE P0 L1
	CALL my_c_vector_getDim
	MOVE T4 10
	LOAD T5 i0
	EQ T3 T4 T5
	BNEQ(37) T3 0
	LOAD T6 i0
	LOAD T7 i0
	INDEX T8 L0 T7
	MOVE *T8 T6
	JUMP(36)
LABEL(37)
	MOVE P0 L1
	CALL my_c_vector_getDim
	MOVE T9 10
	MOVE L3 T9
	MOVE T10 T9
	MOVE 10 T10
	CALL my_array_alloc
	MOVE L4 10
LABEL(38)
	BNEQ(39) L3 0
	INDEX T11 L4 L3
	MOVE *T11 0
	ADDI L3 L3 i-1
	JUMP(38)
LABEL(39)
	LOAD T12 i0
	INDEX T13 L0 T12
	MOVE *T13 L4
	LOAD T14 i0
	MOVE L2 T14
LABEL(40)
	MOVE P0 L0
	CALL my_c_vector_getDim
	MOVE T16 10
	LE T15 L2 T16
	BNEQ(41) T15 0
	LOAD T17 i0
	INDEX T18 L1 T17
	ADDI T19 L2 i1
	INDEX T20 *T18 T19
	LOAD T21 i0
	INDEX T22 L0 T21
	ADDI T23 L2 i1
	INDEX T24 *T22 T23
	MOVE *T24 *T20
LABEL(42)
	ADDI L2 L2 i1
	JUMP(40)
LABEL(41)
LABEL(36)
	LOAD T25 i1
	MOVE 10 T25
	JUMP(34)
FUNC main
	LOAD 10 i4
	CALL malloc
	MOVE T0 10
	MOVE L1 T0
	LOAD T1 i10
	MOVE L5 T1
	MOVE T2 T1
	MOVE 10 T2
	CALL my_array_alloc
	MOVE L6 10
LABEL(44)
	BNEQ(45) L5 0
	INDEX T3 L6 L5
	MOVE *T3 0
	ADDI L5 L5 i-1
	JUMP(44)
LABEL(45)
	MOVE L2 L6
	LOAD T4 i0
	MOVE L3 T4
LABEL(46)
	LOAD T6 i10
	LE T5 L3 T6
	BNEQ(47) T5 0
	LOAD T8 i9
	SUB T7 T8 L3
	ADDI T9 L3 i1
	INDEX T10 L2 T9
	MOVE *T10 T7
LABEL(48)
	ADDI L3 L3 i1
	JUMP(46)
LABEL(47)
	MOVE P1 L2
	MOVE P0 L1
	CALL my_c_vector_init
	MOVE T11 10
	LOADSTRING T12 S3
	MOVE P0 T12
	CALL print
	MOVE T13 10
	MOVE P0 L1
	CALL my_c_vector_tostring
	MOVE T14 10
	MOVE P0 T14
	CALL println
	MOVE T15 10
	LOAD 10 i4
	CALL malloc
	MOVE T16 10
	MOVE L4 T16
	MOVE P1 L1
	MOVE P0 L4
	CALL my_c_vector_copy
	MOVE T17 10
	LOAD T18 i3
	LOAD T19 i817
	MOVE P2 T19
	MOVE P1 T18
	MOVE P0 L4
	CALL my_c_vector_set
	MOVE T20 10
	BNEQ(49) T20 0
	LOADSTRING T21 S4
	MOVE P0 T21
	CALL println
	MOVE T22 10
LABEL(49)
	LOADSTRING T23 S5
	MOVE P0 T23
	CALL print
	MOVE T24 10
	MOVE P0 L4
	CALL my_c_vector_tostring
	MOVE T25 10
	MOVE P0 T25
	CALL println
	MOVE T26 10
	LOADSTRING T27 S6
	MOVE P0 T27
	CALL print
	MOVE T28 10
	MOVE P1 L4
	MOVE P0 L1
	CALL my_c_vector_add
	MOVE T29 10
	MOVE P0 T29
	CALL my_c_vector_tostring
	MOVE T30 10
	MOVE P0 T30
	CALL println
	MOVE T31 10
	LOADSTRING T32 S7
	MOVE P0 T32
	CALL print
	MOVE T33 10
	MOVE P1 L4
	MOVE P0 L1
	CALL my_c_vector_dot
	MOVE T34 10
	MOVE P0 T34
	CALL toString
	MOVE T35 10
	MOVE P0 T35
	CALL println
	MOVE T36 10
	LOADSTRING T37 S8
	MOVE P0 T37
	CALL print
	MOVE T38 10
	LOAD T40 i1
	LOAD T41 i3
	SHL T39 T40 T41
	MOVE P1 T39
	MOVE P0 L4
	CALL my_c_vector_scalarInPlaceMultiply
	MOVE T42 10
	MOVE P0 T42
	CALL my_c_vector_tostring
	MOVE T43 10
	MOVE P0 T43
	CALL println
	MOVE T44 10
	LOAD T45 i0
	MOVE 10 T45
	JUMP(43)
	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"( "
	.align	2
.LS1:
	.string	", "
	.align	2
.LS2:
	.string	" )"
	.align	2
.LS3:
	.string	"vector x: "
	.align	2
.LS4:
	.string	"excited!"
	.align	2
.LS5:
	.string	"vector y: "
	.align	2
.LS6:
	.string	"x + y: "
	.align	2
.LS7:
	.string	"x * y: "
	.align	2
.LS8:
	.string	"(1 << 3) * y: "
	.text
	.align	2
	.globl	my_c_vector_init
	.type	my_c_vector_init, @function
my_c_vector_init:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-16(s0)
	sub	a1,a1,a0
	seqz	a0,a1
	beq	a0,zero,.LAB2
	j	.LAB1
.LAB2:
	lw	a0,-16(s0)
	call	my_array_size
	mv	a1,a0
	sw	a1,-24(s0)
	call	my_array_alloc
	sw	a0,-28(s0)
.LAB3:
	lw	a0,-24(s0)
	beq	a0,zero,.LAB4
	lw	a0,-28(s0)
	lw	a1,-24(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-24(s0)
	addi	a0,a0,-1
	sw	a0,-24(s0)
	j	.LAB3
.LAB4:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,0
	sw	a0,-20(s0)
.LAB5:
	lw	a0,-16(s0)
	call	my_array_size
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB6
	lw	a0,-20(s0)
	addi	a0,a0,1
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-20(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
.LAB7:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB5
.LAB6:
.LAB1:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_init, .-my_c_vector_init
	.text
	.align	2
	.globl	my_c_vector_getDim
	.type	my_c_vector_getDim, @function
my_c_vector_getDim:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a0,0(a0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB9
	li	a0,0
	j	.LAB8
.LAB9:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_array_size
	j	.LAB8
.LAB8:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_vector_getDim, .-my_c_vector_getDim
	.text
	.align	2
	.globl	my_c_vector_dot
	.type	my_c_vector_dot, @function
my_c_vector_dot:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	li	a0,0
	sw	a0,-20(s0)
	li	a0,0
	sw	a0,-24(s0)
.LAB11:
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB12
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a2,-16(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-20(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	lw	a1,0(a1)
	mul	a0,a0,a1
	sw	a0,-24(s0)
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB11
.LAB12:
	lw	a0,-24(s0)
	j	.LAB10
.LAB10:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_dot, .-my_c_vector_dot
	.text
	.align	2
	.globl	my_c_vector_scalarInPlaceMultiply
	.type	my_c_vector_scalarInPlaceMultiply, @function
my_c_vector_scalarInPlaceMultiply:
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
	li	a1,0
	lw	a0,0(a0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB14
	li	a0,0
	j	.LAB13
.LAB14:
	li	a0,0
	sw	a0,-20(s0)
.LAB15:
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB16
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-16(s0)
	lw	a0,0(a0)
	mul	a0,a1,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-20(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB17:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB15
.LAB16:
	lw	a0,-12(s0)
	j	.LAB13
.LAB13:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_scalarInPlaceMultiply, .-my_c_vector_scalarInPlaceMultiply
	.text
	.align	2
	.globl	my_c_vector_add
	.type	my_c_vector_add, @function
my_c_vector_add:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	mv	a6,a0
	sw	a6,-36(s0)
	lw	a0,-16(s0)
	call	my_c_vector_getDim
	lw	a6,-36(s0)
	sub	a6,a6,a0
	snez	a0,a6
	bne	a0,zero,.LAB20
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	bne	a0,zero,.LAB20
	li	a0,0
	j	.LAB21
.LAB20:
	li	a0,1
.LAB21:
	beq	a0,zero,.LAB19
	li	a0,0
	j	.LAB18
.LAB19:
	li	a0,4
	call	malloc
	sw	a0,-20(s0)
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	mv	a1,a0
	sw	a1,-28(s0)
	call	my_array_alloc
	sw	a0,-32(s0)
.LAB22:
	lw	a0,-28(s0)
	beq	a0,zero,.LAB23
	lw	a0,-32(s0)
	lw	a1,-28(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-28(s0)
	addi	a0,a0,-1
	sw	a0,-28(s0)
	j	.LAB22
.LAB23:
	li	a0,0
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-32(s0)
	sw	a1,0(a0)
	li	a0,0
	sw	a0,-24(s0)
.LAB24:
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-24(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB25
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a2,-16(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	lw	a1,0(a1)
	add	a0,a0,a1
	li	a1,0
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB26:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB24
.LAB25:
	lw	a0,-20(s0)
	j	.LAB18
.LAB18:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	my_c_vector_add, .-my_c_vector_add
	.text
	.align	2
	.globl	my_c_vector_set
	.type	my_c_vector_set, @function
my_c_vector_set:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB28
	li	a0,0
	j	.LAB27
.LAB28:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-20(s0)
	sw	a1,0(a0)
	li	a0,1
	j	.LAB27
.LAB27:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_set, .-my_c_vector_set
	.text
	.align	2
	.globl	my_c_vector_tostring
	.type	my_c_vector_tostring, @function
my_c_vector_tostring:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	li	a1,0
	sgt	a0,a0,a1
	beq	a0,zero,.LAB30
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	call	toString
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_string_plus
	sw	a0,-16(s0)
.LAB30:
	li	a0,1
	sw	a0,-20(s0)
.LAB31:
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB32
	lui	a0,%hi(.LS1)
	addi	a0,a0,%lo(.LS1)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_string_plus
	mv	a6,a0
	sw	a6,-24(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	call	toString
	mv	a1,a0
	lw	a6,-24(s0)
	mv	a0,a6
	call	my_string_plus
	sw	a0,-16(s0)
.LAB33:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB31
.LAB32:
	lui	a0,%hi(.LS2)
	addi	a0,a0,%lo(.LS2)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_string_plus
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	j	.LAB29
.LAB29:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_tostring, .-my_c_vector_tostring
	.text
	.align	2
	.globl	my_c_vector_copy
	.type	my_c_vector_copy, @function
my_c_vector_copy:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-16(s0)
	sub	a1,a1,a0
	seqz	a0,a1
	beq	a0,zero,.LAB35
	li	a0,0
	j	.LAB34
.LAB35:
	lw	a0,-16(s0)
	call	my_c_vector_getDim
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB37
	li	a0,0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	j	.LAB36
.LAB37:
	lw	a0,-16(s0)
	call	my_c_vector_getDim
	mv	a1,a0
	sw	a1,-24(s0)
	call	my_array_alloc
	sw	a0,-28(s0)
.LAB38:
	lw	a0,-24(s0)
	beq	a0,zero,.LAB39
	lw	a0,-28(s0)
	lw	a1,-24(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-24(s0)
	addi	a0,a0,-1
	sw	a0,-24(s0)
	j	.LAB38
.LAB39:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,0
	sw	a0,-20(s0)
.LAB40:
	lw	a0,-12(s0)
	call	my_c_vector_getDim
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB41
	li	a0,0
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-20(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
.LAB42:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB40
.LAB41:
.LAB36:
	li	a0,1
	j	.LAB34
.LAB34:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_vector_copy, .-my_c_vector_copy
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	li	a0,4
	call	malloc
	sw	a0,-16(s0)
	li	a0,10
	mv	a1,a0
	sw	a1,-32(s0)
	call	my_array_alloc
	sw	a0,-36(s0)
.LAB44:
	lw	a0,-32(s0)
	beq	a0,zero,.LAB45
	lw	a0,-36(s0)
	lw	a1,-32(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-32(s0)
	addi	a0,a0,-1
	sw	a0,-32(s0)
	j	.LAB44
.LAB45:
	lw	a0,-36(s0)
	sw	a0,-20(s0)
	li	a0,0
	sw	a0,-24(s0)
.LAB46:
	li	a0,10
	lw	a1,-24(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB47
	li	a0,9
	lw	a1,-24(s0)
	sub	a0,a0,a1
	lw	a1,-24(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB48:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB46
.LAB47:
	lw	a0,-20(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_vector_init
	lui	a0,%hi(.LS3)
	addi	a0,a0,%lo(.LS3)
	call	print
	lw	a0,-16(s0)
	call	my_c_vector_tostring
	call	println
	li	a0,4
	call	malloc
	sw	a0,-28(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-28(s0)
	call	my_c_vector_copy
	li	a0,3
	li	a1,817
	mv	a2,a1
	mv	a1,a0
	lw	a0,-28(s0)
	call	my_c_vector_set
	beq	a0,zero,.LAB49
	lui	a0,%hi(.LS4)
	addi	a0,a0,%lo(.LS4)
	call	println
.LAB49:
	lui	a0,%hi(.LS5)
	addi	a0,a0,%lo(.LS5)
	call	print
	lw	a0,-28(s0)
	call	my_c_vector_tostring
	call	println
	lui	a0,%hi(.LS6)
	addi	a0,a0,%lo(.LS6)
	call	print
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_vector_add
	call	my_c_vector_tostring
	call	println
	lui	a0,%hi(.LS7)
	addi	a0,a0,%lo(.LS7)
	call	print
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_vector_dot
	call	toString
	call	println
	lui	a0,%hi(.LS8)
	addi	a0,a0,%lo(.LS8)
	call	print
	li	a0,1
	li	a1,3
	sll	a0,a0,a1
	mv	a1,a0
	lw	a0,-28(s0)
	call	my_c_vector_scalarInPlaceMultiply
	call	my_c_vector_tostring
	call	println
	li	a0,0
	j	.LAB43
.LAB43:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	main, .-main
