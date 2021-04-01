storage:11
beg:11
end:11
res:1
i:1
res:1
i:1
res:1
res:1
tail:1
n:1
m:1
n:1
a:1
i:1
STRING(0) Warning: Slice_int::slice: out of range
STRING(1) Warning: Slice_int::copy: size() < arr.size()
STRING(2)  
STRING(3) 
FUNC my_c_Slice_int_init
	MOVE L0 10
	MOVE L1 11
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE *T1 L1
	LOAD T2 i0
	LOAD T3 i1
	INDEX T4 L0 T3
	MOVE *T4 T2
	MOVE P0 L1
	CALL my_array_size
	MOVE T5 10
	LOAD T6 i2
	INDEX T7 L0 T6
	MOVE *T7 T5
FUNC my_c_Slice_int_size
	MOVE L0 10
	LOAD T1 i2
	INDEX T2 L0 T1
	LOAD T3 i1
	INDEX T4 L0 T3
	SUB T0 *T2 *T4
	MOVE 10 T0
	JUMP(2)
FUNC my_c_Slice_int_get
	MOVE L0 10
	MOVE L1 11
	LOAD T0 i0
	INDEX T1 L0 T0
	LOAD T3 i1
	INDEX T4 L0 T3
	ADD T2 *T4 L1
	ADDI T5 T2 i1
	INDEX T6 *T1 T5
	MOVE 10 *T6
	JUMP(3)
FUNC my_c_Slice_int_set
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	LOAD T0 i0
	INDEX T1 L0 T0
	LOAD T3 i1
	INDEX T4 L0 T3
	ADD T2 *T4 L1
	ADDI T5 T2 i1
	INDEX T6 *T1 T5
	MOVE *T6 L2
FUNC my_c_Slice_int_slice
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	LOAD 10 i12
	CALL malloc
	MOVE T0 10
	MOVE L3 T0
	LOAD T1 i0
	INDEX T2 L0 T1
	LOAD T3 i0
	INDEX T4 L3 T3
	MOVE *T4 *T2
	LOAD T6 i1
	INDEX T7 L0 T6
	ADD T5 *T7 L1
	LOAD T8 i1
	INDEX T9 L3 T8
	MOVE *T9 T5
	LOAD T11 i1
	INDEX T12 L0 T11
	ADD T10 *T12 L2
	LOAD T13 i2
	INDEX T14 L3 T13
	MOVE *T14 T10
	LOAD T17 i1
	INDEX T18 L3 T17
	LOAD T19 i0
	INDEX T20 L0 T19
	MOVE P0 *T20
	CALL my_array_size
	MOVE T21 10
	GE T16 *T18 T21
	BEQ(7) T16 0
	LOAD T23 i2
	INDEX T24 L3 T23
	LOAD T25 i0
	INDEX T26 L0 T25
	MOVE P0 *T26
	CALL my_array_size
	MOVE T27 10
	GE T22 *T24 T27
	BEQ(7) T22 0
	LOAD T15 i0
	JUMP(8)
LABEL(7)
	LOAD T15 i1
LABEL(8)
	BNEQ(6) T15 0
	LOADSTRING T28 S0
	MOVE P0 T28
	CALL println
	MOVE T29 10
LABEL(6)
	MOVE 10 L3
	JUMP(5)
FUNC my_c_Slice_int_tail
	MOVE L0 10
	LOAD T0 i1
	MOVE P0 L0
	CALL my_c_Slice_int_size
	MOVE T1 10
	MOVE P2 T1
	MOVE P1 T0
	MOVE P0 L0
	CALL my_c_Slice_int_slice
	MOVE T2 10
	MOVE 10 T2
	JUMP(9)
FUNC my_c_Slice_int_copy
	MOVE L0 10
	MOVE L1 11
	MOVE P0 L0
	CALL my_c_Slice_int_size
	MOVE T1 10
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T2 10
	LE T0 T1 T2
	BNEQ(11) T0 0
	LOADSTRING T3 S1
	MOVE P0 T3
	CALL println
	MOVE T4 10
LABEL(11)
	LOAD T5 i0
	MOVE L2 T5
LABEL(12)
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T7 10
	LE T6 L2 T7
	BNEQ(13) T6 0
	MOVE P1 L2
	MOVE P0 L1
	CALL my_c_Slice_int_get
	MOVE T8 10
	LOAD T9 i0
	INDEX T10 L0 T9
	LOAD T12 i1
	INDEX T13 L0 T12
	ADD T11 *T13 L2
	ADDI T14 T11 i1
	INDEX T15 *T10 T14
	MOVE *T15 T8
LABEL(14)
	ADDI L2 L2 i1
	JUMP(12)
LABEL(13)
FUNC my_c_Slice_int_cloneArray
	MOVE L0 10
	MOVE P0 L0
	CALL my_c_Slice_int_size
	MOVE T0 10
	MOVE L3 T0
	MOVE T1 T0
	MOVE 10 T1
	CALL my_array_alloc
	MOVE L4 10
LABEL(16)
	BNEQ(17) L3 0
	INDEX T2 L4 L3
	MOVE *T2 0
	ADDI L3 L3 i-1
	JUMP(16)
LABEL(17)
	MOVE L1 L4
	LOAD T3 i0
	MOVE L2 T3
LABEL(18)
	MOVE P0 L0
	CALL my_c_Slice_int_size
	MOVE T5 10
	LE T4 L2 T5
	BNEQ(19) T4 0
	LOAD T6 i0
	INDEX T7 L0 T6
	LOAD T9 i1
	INDEX T10 L0 T9
	ADD T8 *T10 L2
	ADDI T11 T8 i1
	INDEX T12 *T7 T11
	ADDI T13 L2 i1
	INDEX T14 L1 T13
	MOVE *T14 *T12
LABEL(20)
	ADDI L2 L2 i1
	JUMP(18)
LABEL(19)
	MOVE 10 L1
	JUMP(15)
FUNC makeSlice_int
	MOVE L1 10
	LOAD 10 i12
	CALL malloc
	MOVE T0 10
	MOVE L2 T0
	MOVE P1 L1
	MOVE P0 L2
	CALL my_c_Slice_int_init
	MOVE T1 10
	MOVE 10 L2
	JUMP(21)
FUNC merge
	MOVE L1 10
	MOVE L2 11
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T1 10
	LOAD T2 i0
	EQ T0 T1 T2
	BNEQ(23) T0 0
	MOVE P0 L2
	CALL my_c_Slice_int_cloneArray
	MOVE T3 10
	MOVE 10 T3
	JUMP(22)
LABEL(23)
	MOVE P0 L2
	CALL my_c_Slice_int_size
	MOVE T5 10
	LOAD T6 i0
	EQ T4 T5 T6
	BNEQ(24) T4 0
	MOVE P0 L1
	CALL my_c_Slice_int_cloneArray
	MOVE T7 10
	MOVE 10 T7
	JUMP(22)
LABEL(24)
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T9 10
	MOVE P0 L2
	CALL my_c_Slice_int_size
	MOVE T10 10
	ADD T8 T9 T10
	MOVE L5 T8
	MOVE T11 T8
	MOVE 10 T11
	CALL my_array_alloc
	MOVE L6 10
LABEL(25)
	BNEQ(26) L5 0
	INDEX T12 L6 L5
	MOVE *T12 0
	ADDI L5 L5 i-1
	JUMP(25)
LABEL(26)
	MOVE L3 L6
	MOVE P0 L3
	CALL makeSlice_int
	MOVE T13 10
	MOVE P0 T13
	CALL my_c_Slice_int_tail
	MOVE T14 10
	MOVE L4 T14
	LOAD T16 i0
	MOVE P1 T16
	MOVE P0 L1
	CALL my_c_Slice_int_get
	MOVE T17 10
	LOAD T18 i0
	MOVE P1 T18
	MOVE P0 L2
	CALL my_c_Slice_int_get
	MOVE T19 10
	LE T15 T17 T19
	BNEQ(28) T15 0
	LOAD T20 i0
	MOVE P1 T20
	MOVE P0 L1
	CALL my_c_Slice_int_get
	MOVE T21 10
	LOAD T22 i0
	ADDI T23 T22 i1
	INDEX T24 L3 T23
	MOVE *T24 T21
	MOVE P0 L1
	CALL my_c_Slice_int_tail
	MOVE T25 10
	MOVE P1 L2
	MOVE P0 T25
	CALL merge
	MOVE T26 10
	MOVE P0 T26
	CALL makeSlice_int
	MOVE T27 10
	MOVE P1 T27
	MOVE P0 L4
	CALL my_c_Slice_int_copy
	MOVE T28 10
	JUMP(27)
LABEL(28)
	LOAD T29 i0
	MOVE P1 T29
	MOVE P0 L2
	CALL my_c_Slice_int_get
	MOVE T30 10
	LOAD T31 i0
	ADDI T32 T31 i1
	INDEX T33 L3 T32
	MOVE *T33 T30
	MOVE P0 L2
	CALL my_c_Slice_int_tail
	MOVE T34 10
	MOVE P1 T34
	MOVE P0 L1
	CALL merge
	MOVE T35 10
	MOVE P0 T35
	CALL makeSlice_int
	MOVE T36 10
	MOVE P1 T36
	MOVE P0 L4
	CALL my_c_Slice_int_copy
	MOVE T37 10
LABEL(27)
	MOVE 10 L3
	JUMP(22)
FUNC mergeSort
	MOVE L1 10
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T1 10
	LOAD T2 i1
	EQ T0 T1 T2
	BNEQ(30) T0 0
	JUMP(29)
LABEL(30)
	MOVE P0 L1
	CALL my_c_Slice_int_size
	MOVE T3 10
	MOVE L2 T3
	LOAD T5 i2
	DIV T4 L2 T5
	MOVE L3 T4
	LOAD T6 i0
	MOVE P2 L3
	MOVE P1 T6
	MOVE P0 L1
	CALL my_c_Slice_int_slice
	MOVE T7 10
	MOVE P0 T7
	CALL mergeSort
	MOVE T8 10
	MOVE P2 L2
	MOVE P1 L3
	MOVE P0 L1
	CALL my_c_Slice_int_slice
	MOVE T9 10
	MOVE P0 T9
	CALL mergeSort
	MOVE T10 10
	LOAD T11 i0
	MOVE P2 L3
	MOVE P1 T11
	MOVE P0 L1
	CALL my_c_Slice_int_slice
	MOVE T12 10
	MOVE P2 L2
	MOVE P1 L3
	MOVE P0 L1
	CALL my_c_Slice_int_slice
	MOVE T13 10
	MOVE P1 T13
	MOVE P0 T12
	CALL merge
	MOVE T14 10
	MOVE P0 T14
	CALL makeSlice_int
	MOVE T15 10
	MOVE P1 T15
	MOVE P0 L1
	CALL my_c_Slice_int_copy
	MOVE T16 10
FUNC mergeSortInf
	MOVE L1 10
	MOVE P0 L1
	CALL makeSlice_int
	MOVE T0 10
	MOVE P0 T0
	CALL mergeSort
	MOVE T1 10
FUNC main
	CALL getInt
	MOVE T0 10
	MOVE L1 T0
	MOVE L4 L1
	MOVE T1 L1
	MOVE 10 T1
	CALL my_array_alloc
	MOVE L5 10
LABEL(33)
	BNEQ(34) L4 0
	INDEX T2 L5 L4
	MOVE *T2 0
	ADDI L4 L4 i-1
	JUMP(33)
LABEL(34)
	MOVE L2 L5
	LOAD T3 i0
	MOVE L3 T3
LABEL(35)
	LE T4 L3 L1
	BNEQ(36) T4 0
	CALL getInt
	MOVE T5 10
	ADDI T6 L3 i1
	INDEX T7 L2 T6
	MOVE *T7 T5
LABEL(37)
	ADDI L3 L3 i1
	JUMP(35)
LABEL(36)
	MOVE P0 L2
	CALL mergeSortInf
	MOVE T8 10
	LOAD T9 i0
	MOVE L3 T9
LABEL(38)
	LE T10 L3 L1
	BNEQ(39) T10 0
	ADDI T12 L3 i1
	INDEX T13 L2 T12
	MOVE P0 *T13
	CALL toString
	MOVE T14 10
	LOADSTRING T15 S2
	MOVE P1 T15
	MOVE P0 T14
	CALL my_string_plus
	MOVE T11 10
	MOVE P0 T11
	CALL print
	MOVE T16 10
LABEL(40)
	ADDI L3 L3 i1
	JUMP(38)
LABEL(39)
	LOADSTRING T17 S3
	MOVE P0 T17
	CALL println
	MOVE T18 10
	LOAD T19 i0
	MOVE 10 T19
	JUMP(32)
	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"Warning: Slice_int::slice: out of range"
	.align	2
.LS1:
	.string	"Warning: Slice_int::copy: size() < arr.size()"
	.align	2
.LS2:
	.string	" "
	.align	2
.LS3:
	.string	""
	.text
	.align	2
	.globl	my_c_Slice_int_init
	.type	my_c_Slice_int_init, @function
my_c_Slice_int_init:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-16(s0)
	call	my_array_size
	li	a1,2
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB1:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Slice_int_init, .-my_c_Slice_int_init
	.text
	.align	2
	.globl	my_c_Slice_int_size
	.type	my_c_Slice_int_size, @function
my_c_Slice_int_size:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,2
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	lw	a1,0(a1)
	sub	a0,a0,a1
	j	.LAB2
.LAB2:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Slice_int_size, .-my_c_Slice_int_size
	.text
	.align	2
	.globl	my_c_Slice_int_get
	.type	my_c_Slice_int_get, @function
my_c_Slice_int_get:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	lw	a2,-12(s0)
	add	a1,a1,a2
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB3
.LAB3:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Slice_int_get, .-my_c_Slice_int_get
	.text
	.align	2
	.globl	my_c_Slice_int_set
	.type	my_c_Slice_int_set, @function
my_c_Slice_int_set:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	mv	a0,a2
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	lw	a2,-12(s0)
	add	a1,a1,a2
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-16(s0)
	sw	a1,0(a0)
.LAB4:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Slice_int_set, .-my_c_Slice_int_set
	.text
	.align	2
	.globl	my_c_Slice_int_slice
	.type	my_c_Slice_int_slice, @function
my_c_Slice_int_slice:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	li	a0,12
	call	malloc
	sw	a0,-24(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-16(s0)
	add	a0,a0,a1
	li	a1,1
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-20(s0)
	add	a0,a0,a1
	li	a1,2
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-28(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-28(s0)
	lw	a1,0(a6)
	sgt	a0,a1,a0
	bne	a0,zero,.LAB7
	li	a0,2
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-32(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-32(s0)
	lw	a1,0(a6)
	sgt	a0,a1,a0
	bne	a0,zero,.LAB7
	li	a0,0
	j	.LAB8
.LAB7:
	li	a0,1
.LAB8:
	beq	a0,zero,.LAB6
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	println
.LAB6:
	lw	a0,-24(s0)
	j	.LAB5
.LAB5:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Slice_int_slice, .-my_c_Slice_int_slice
	.text
	.align	2
	.globl	my_c_Slice_int_tail
	.type	my_c_Slice_int_tail, @function
my_c_Slice_int_tail:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a6,1
	sw	a6,-16(s0)
	lw	a0,-12(s0)
	call	my_c_Slice_int_size
	mv	a2,a0
	lw	a6,-16(s0)
	mv	a1,a6
	lw	a0,-12(s0)
	call	my_c_Slice_int_slice
	j	.LAB9
.LAB9:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Slice_int_tail, .-my_c_Slice_int_tail
	.text
	.align	2
	.globl	my_c_Slice_int_copy
	.type	my_c_Slice_int_copy, @function
my_c_Slice_int_copy:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	my_c_Slice_int_size
	mv	a6,a0
	sw	a6,-24(s0)
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	lw	a6,-24(s0)
	slt	a0,a6,a0
	beq	a0,zero,.LAB11
	lui	a0,%hi(.LS1)
	addi	a0,a0,%lo(.LS1)
	call	println
.LAB11:
	li	a0,0
	sw	a0,-20(s0)
.LAB12:
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB13
	lw	a0,-20(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_get
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,1
	lw	a3,-12(s0)
	slli	a2,a2,2
	add	a2,a3,a2
	lw	a2,0(a2)
	lw	a3,-20(s0)
	add	a2,a2,a3
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB14:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB12
.LAB13:
.LAB10:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Slice_int_copy, .-my_c_Slice_int_copy
	.text
	.align	2
	.globl	my_c_Slice_int_cloneArray
	.type	my_c_Slice_int_cloneArray, @function
my_c_Slice_int_cloneArray:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	lw	a0,-12(s0)
	call	my_c_Slice_int_size
	mv	a1,a0
	sw	a1,-24(s0)
	call	my_array_alloc
	sw	a0,-28(s0)
.LAB16:
	lw	a0,-24(s0)
	beq	a0,zero,.LAB17
	lw	a0,-28(s0)
	lw	a1,-24(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-24(s0)
	addi	a0,a0,-1
	sw	a0,-24(s0)
	j	.LAB16
.LAB17:
	lw	a0,-28(s0)
	sw	a0,-16(s0)
	li	a0,0
	sw	a0,-20(s0)
.LAB18:
	lw	a0,-12(s0)
	call	my_c_Slice_int_size
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB19
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	lw	a2,-20(s0)
	add	a1,a1,a2
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-20(s0)
	addi	a1,a1,1
	lw	a2,-16(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	sw	a0,0(a1)
.LAB20:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB18
.LAB19:
	lw	a0,-16(s0)
	j	.LAB15
.LAB15:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Slice_int_cloneArray, .-my_c_Slice_int_cloneArray
	.text
	.align	2
	.globl	makeSlice_int
	.type	makeSlice_int, @function
makeSlice_int:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-16(s0)
	li	a0,12
	call	malloc
	sw	a0,-20(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-20(s0)
	call	my_c_Slice_int_init
	lw	a0,-20(s0)
	j	.LAB21
.LAB21:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	makeSlice_int, .-makeSlice_int
	.text
	.align	2
	.globl	merge
	.type	merge, @function
merge:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-16(s0)
	mv	a0,a1
	sw	a0,-20(s0)
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB23
	lw	a0,-20(s0)
	call	my_c_Slice_int_cloneArray
	j	.LAB22
.LAB23:
	lw	a0,-20(s0)
	call	my_c_Slice_int_size
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB24
	lw	a0,-16(s0)
	call	my_c_Slice_int_cloneArray
	j	.LAB22
.LAB24:
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	mv	a6,a0
	sw	a6,-40(s0)
	lw	a0,-20(s0)
	call	my_c_Slice_int_size
	lw	a6,-40(s0)
	add	a0,a6,a0
	mv	a1,a0
	sw	a1,-32(s0)
	call	my_array_alloc
	sw	a0,-36(s0)
.LAB25:
	lw	a0,-32(s0)
	beq	a0,zero,.LAB26
	lw	a0,-36(s0)
	lw	a1,-32(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-32(s0)
	addi	a0,a0,-1
	sw	a0,-32(s0)
	j	.LAB25
.LAB26:
	lw	a0,-36(s0)
	sw	a0,-24(s0)
	lw	a0,-24(s0)
	call	makeSlice_int
	call	my_c_Slice_int_tail
	sw	a0,-28(s0)
	li	a0,0
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_get
	mv	a6,a0
	sw	a6,-44(s0)
	li	a0,0
	mv	a1,a0
	lw	a0,-20(s0)
	call	my_c_Slice_int_get
	lw	a6,-44(s0)
	slt	a0,a6,a0
	beq	a0,zero,.LAB28
	li	a0,0
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_get
	li	a1,0
	addi	a1,a1,1
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-16(s0)
	call	my_c_Slice_int_tail
	lw	a1,-20(s0)
	call	merge
	call	makeSlice_int
	mv	a1,a0
	lw	a0,-28(s0)
	call	my_c_Slice_int_copy
	j	.LAB27
.LAB28:
	li	a0,0
	mv	a1,a0
	lw	a0,-20(s0)
	call	my_c_Slice_int_get
	li	a1,0
	addi	a1,a1,1
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	lw	a0,-20(s0)
	call	my_c_Slice_int_tail
	mv	a1,a0
	lw	a0,-16(s0)
	call	merge
	call	makeSlice_int
	mv	a1,a0
	lw	a0,-28(s0)
	call	my_c_Slice_int_copy
.LAB27:
	lw	a0,-24(s0)
	j	.LAB22
.LAB22:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	merge, .-merge
	.text
	.align	2
	.globl	mergeSort
	.type	mergeSort, @function
mergeSort:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	li	a1,1
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB30
	j	.LAB29
.LAB30:
	lw	a0,-16(s0)
	call	my_c_Slice_int_size
	sw	a0,-20(s0)
	li	a0,2
	lw	a1,-20(s0)
	div	a0,a1,a0
	sw	a0,-24(s0)
	li	a0,0
	lw	a1,-24(s0)
	mv	a2,a1
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_slice
	call	mergeSort
	lw	a0,-20(s0)
	mv	a2,a0
	lw	a0,-24(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_slice
	call	mergeSort
	li	a0,0
	lw	a1,-24(s0)
	mv	a2,a1
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_slice
	mv	a6,a0
	sw	a6,-28(s0)
	lw	a0,-20(s0)
	mv	a2,a0
	lw	a0,-24(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_slice
	mv	a1,a0
	lw	a6,-28(s0)
	mv	a0,a6
	call	merge
	call	makeSlice_int
	mv	a1,a0
	lw	a0,-16(s0)
	call	my_c_Slice_int_copy
.LAB29:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	mergeSort, .-mergeSort
	.text
	.align	2
	.globl	mergeSortInf
	.type	mergeSortInf, @function
mergeSortInf:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	call	makeSlice_int
	call	mergeSort
.LAB31:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	mergeSortInf, .-mergeSortInf
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
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	sw	a0,-28(s0)
	lw	a0,-16(s0)
	call	my_array_alloc
	sw	a0,-32(s0)
.LAB33:
	lw	a0,-28(s0)
	beq	a0,zero,.LAB34
	lw	a0,-32(s0)
	lw	a1,-28(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-28(s0)
	addi	a0,a0,-1
	sw	a0,-28(s0)
	j	.LAB33
.LAB34:
	lw	a0,-32(s0)
	sw	a0,-20(s0)
	li	a0,0
	sw	a0,-24(s0)
.LAB35:
	lw	a0,-24(s0)
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB36
	call	getInt
	lw	a1,-24(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB37:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB35
.LAB36:
	lw	a0,-20(s0)
	call	mergeSortInf
	li	a0,0
	sw	a0,-24(s0)
.LAB38:
	lw	a0,-24(s0)
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB39
	lw	a0,-24(s0)
	addi	a0,a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	toString
	lui	a1,%hi(.LS2)
	addi	a1,a1,%lo(.LS2)
	call	my_string_plus
	call	print
.LAB40:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB38
.LAB39:
	lui	a0,%hi(.LS3)
	addi	a0,a0,%lo(.LS3)
	call	println
	li	a0,0
	j	.LAB32
.LAB32:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
