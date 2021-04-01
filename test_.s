storage:11
beg:11
end:11
res:1
copy:1
begCopy:1
endCopy:1
i:1
q:1
i:1
N:1
head:1
STRING(0) Warning: Queue_int::pop: empty queue
STRING(1) q.size() != N after pushes
STRING(2) Head != i
STRING(3) Failed: q.pop() != i
STRING(4) q.size() != N - i - 1
STRING(5) Passed tests.
FUNC my_c_Queue_int_Queue_int
	MOVE L0 10
	LOAD T0 i0
	LOAD T1 i1
	INDEX T2 L0 T1
	MOVE *T2 T0
	LOAD T3 i0
	LOAD T4 i2
	INDEX T5 L0 T4
	MOVE *T5 T3
	LOAD T6 i16
	MOVE L1 T6
	MOVE T7 T6
	MOVE 10 T7
	CALL my_array_alloc
	MOVE L2 10
LABEL(2)
	BNEQ(3) L1 0
	INDEX T8 L2 L1
	MOVE *T8 0
	ADDI L1 L1 i-1
	JUMP(2)
LABEL(3)
	LOAD T9 i0
	INDEX T10 L0 T9
	MOVE *T10 L2
FUNC my_c_Queue_int_push
	MOVE L0 10
	MOVE L1 11
	MOVE P0 L0
	CALL my_c_Queue_int_size
	MOVE T1 10
	LOAD T3 i0
	INDEX T4 L0 T3
	MOVE P0 *T4
	CALL my_array_size
	MOVE T5 10
	LOAD T6 i1
	SUB T2 T5 T6
	EQ T0 T1 T2
	BNEQ(5) T0 0
	MOVE P0 L0
	CALL my_c_Queue_int_doubleStorage
	MOVE T7 10
LABEL(5)
	LOAD T8 i0
	INDEX T9 L0 T8
	LOAD T10 i2
	INDEX T11 L0 T10
	ADDI T12 *T11 i1
	INDEX T13 *T9 T12
	MOVE *T13 L1
	LOAD T16 i2
	INDEX T17 L0 T16
	LOAD T18 i1
	ADD T15 *T17 T18
	LOAD T19 i0
	INDEX T20 L0 T19
	MOVE P0 *T20
	CALL my_array_size
	MOVE T21 10
	MOD T14 T15 T21
	LOAD T22 i2
	INDEX T23 L0 T22
	MOVE *T23 T14
FUNC my_c_Queue_int_top
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	LOAD T2 i1
	INDEX T3 L0 T2
	ADDI T4 *T3 i1
	INDEX T5 *T1 T4
	MOVE 10 *T5
	JUMP(6)
FUNC my_c_Queue_int_pop
	MOVE L0 10
	MOVE P0 L0
	CALL my_c_Queue_int_size
	MOVE T1 10
	LOAD T2 i0
	EQ T0 T1 T2
	BNEQ(8) T0 0
	LOADSTRING T3 S0
	MOVE P0 T3
	CALL println
	MOVE T4 10
LABEL(8)
	MOVE P0 L0
	CALL my_c_Queue_int_top
	MOVE T5 10
	MOVE L1 T5
	LOAD T8 i1
	INDEX T9 L0 T8
	LOAD T10 i1
	ADD T7 *T9 T10
	LOAD T11 i0
	INDEX T12 L0 T11
	MOVE P0 *T12
	CALL my_array_size
	MOVE T13 10
	MOD T6 T7 T13
	LOAD T14 i1
	INDEX T15 L0 T14
	MOVE *T15 T6
	MOVE 10 L1
	JUMP(7)
FUNC my_c_Queue_int_size
	MOVE L0 10
	LOAD T3 i2
	INDEX T4 L0 T3
	LOAD T5 i0
	INDEX T6 L0 T5
	MOVE P0 *T6
	CALL my_array_size
	MOVE T7 10
	ADD T2 *T4 T7
	LOAD T8 i1
	INDEX T9 L0 T8
	SUB T1 T2 *T9
	LOAD T10 i0
	INDEX T11 L0 T10
	MOVE P0 *T11
	CALL my_array_size
	MOVE T12 10
	MOD T0 T1 T12
	MOVE 10 T0
	JUMP(9)
FUNC my_c_Queue_int_doubleStorage
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE L1 *T1
	LOAD T2 i1
	INDEX T3 L0 T2
	MOVE L2 *T3
	LOAD T4 i2
	INDEX T5 L0 T4
	MOVE L3 *T5
	MOVE P0 L1
	CALL my_array_size
	MOVE T7 10
	LOAD T8 i2
	MUL T6 T7 T8
	MOVE L5 T6
	MOVE T9 T6
	MOVE 10 T9
	CALL my_array_alloc
	MOVE L6 10
LABEL(11)
	BNEQ(12) L5 0
	INDEX T10 L6 L5
	MOVE *T10 0
	ADDI L5 L5 i-1
	JUMP(11)
LABEL(12)
	LOAD T11 i0
	INDEX T12 L0 T11
	MOVE *T12 L6
	LOAD T13 i0
	LOAD T14 i1
	INDEX T15 L0 T14
	MOVE *T15 T13
	LOAD T16 i0
	LOAD T17 i2
	INDEX T18 L0 T17
	MOVE *T18 T16
	MOVE L4 L2
LABEL(13)
	NEQ T19 L4 L3
	BNEQ(14) T19 0
	ADDI T20 L4 i1
	INDEX T21 L1 T20
	LOAD T22 i0
	INDEX T23 L0 T22
	LOAD T24 i2
	INDEX T25 L0 T24
	ADDI T26 *T25 i1
	INDEX T27 *T23 T26
	MOVE *T27 *T21
	LOAD T28 i2
	INDEX T29 L0 T28
	MOVE T30 *T29
	ADDI *T29 *T29 i1
	LOAD T33 i1
	ADD T32 L4 T33
	MOVE P0 L1
	CALL my_array_size
	MOVE T34 10
	MOD T31 T32 T34
	MOVE L4 T31
	JUMP(13)
LABEL(14)
FUNC main
	LOAD 10 i12
	CALL malloc
	MOVE T0 10
	CALL my_c_Queue_int_Queue_int
	MOVE L1 T0
	LOAD T1 i100
	MOVE L3 T1
	LOAD T2 i0
	MOVE L2 T2
LABEL(16)
	LE T3 L2 L3
	BNEQ(17) T3 0
	MOVE P1 L2
	MOVE P0 L1
	CALL my_c_Queue_int_push
	MOVE T4 10
LABEL(18)
	ADDI L2 L2 i1
	JUMP(16)
LABEL(17)
	MOVE P0 L1
	CALL my_c_Queue_int_size
	MOVE T6 10
	NEQ T5 T6 L3
	BNEQ(19) T5 0
	LOADSTRING T7 S1
	MOVE P0 T7
	CALL println
	MOVE T8 10
	LOAD T9 i1
	MOVE 10 T9
	JUMP(15)
LABEL(19)
	LOAD T10 i0
	MOVE L2 T10
LABEL(20)
	LE T11 L2 L3
	BNEQ(21) T11 0
	MOVE P0 L1
	CALL my_c_Queue_int_top
	MOVE T12 10
	MOVE L4 T12
	NEQ T13 L4 L2
	BNEQ(23) T13 0
	LOADSTRING T14 S2
	MOVE P0 T14
	CALL println
	MOVE T15 10
	LOAD T16 i1
	MOVE 10 T16
	JUMP(15)
LABEL(23)
	MOVE P0 L1
	CALL my_c_Queue_int_pop
	MOVE T18 10
	NEQ T17 T18 L2
	BNEQ(24) T17 0
	LOADSTRING T19 S3
	MOVE P0 T19
	CALL println
	MOVE T20 10
	LOAD T21 i1
	MOVE 10 T21
	JUMP(15)
LABEL(24)
	MOVE P0 L1
	CALL my_c_Queue_int_size
	MOVE T23 10
	SUB T25 L3 L2
	LOAD T26 i1
	SUB T24 T25 T26
	NEQ T22 T23 T24
	BNEQ(25) T22 0
	LOADSTRING T27 S4
	MOVE P0 T27
	CALL println
	MOVE T28 10
	LOAD T29 i1
	MOVE 10 T29
	JUMP(15)
LABEL(25)
LABEL(22)
	ADDI L2 L2 i1
	JUMP(20)
LABEL(21)
	LOADSTRING T30 S5
	MOVE P0 T30
	CALL println
	MOVE T31 10
	LOAD T32 i0
	MOVE 10 T32
	JUMP(15)
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
	.globl	my_c_Queue_int_Queue_int
	.type	my_c_Queue_int_Queue_int, @function
my_c_Queue_int_Queue_int:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	li	a1,2
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
	li	a0,0
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
	.size	my_c_Queue_int_Queue_int, .-my_c_Queue_int_Queue_int
	.text
	.align	2
	.globl	my_c_Queue_int_push
	.type	my_c_Queue_int_push, @function
my_c_Queue_int_push:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	my_c_Queue_int_size
	mv	a6,a0
	sw	a6,-20(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	li	a1,1
	sub	a0,a0,a1
	lw	a6,-20(s0)
	sub	a6,a6,a0
	seqz	a0,a6
	beq	a0,zero,.LAB5
	lw	a0,-12(s0)
	call	my_c_Queue_int_doubleStorage
.LAB5:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,2
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
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	add	a6,a0,a1
	sw	a6,-24(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-24(s0)
	rem	a0,a6,a0
	li	a1,2
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB4:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Queue_int_push, .-my_c_Queue_int_push
	.text
	.align	2
	.globl	my_c_Queue_int_top
	.type	my_c_Queue_int_top, @function
my_c_Queue_int_top:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
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
	.size	my_c_Queue_int_top, .-my_c_Queue_int_top
	.text
	.align	2
	.globl	my_c_Queue_int_pop
	.type	my_c_Queue_int_pop, @function
my_c_Queue_int_pop:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	lw	a0,-12(s0)
	call	my_c_Queue_int_size
	li	a1,0
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB8
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	println
.LAB8:
	lw	a0,-12(s0)
	call	my_c_Queue_int_top
	sw	a0,-16(s0)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	add	a6,a0,a1
	sw	a6,-20(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-20(s0)
	rem	a0,a6,a0
	li	a1,1
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
	.size	my_c_Queue_int_pop, .-my_c_Queue_int_pop
	.text
	.align	2
	.globl	my_c_Queue_int_size
	.type	my_c_Queue_int_size, @function
my_c_Queue_int_size:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-16(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-16(s0)
	lw	a1,0(a6)
	add	a0,a1,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	sub	a6,a0,a1
	sw	a6,-20(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-20(s0)
	rem	a0,a6,a0
	j	.LAB9
.LAB9:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Queue_int_size, .-my_c_Queue_int_size
	.text
	.align	2
	.globl	my_c_Queue_int_doubleStorage
	.type	my_c_Queue_int_doubleStorage, @function
my_c_Queue_int_doubleStorage:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-16(s0)
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-20(s0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-24(s0)
	lw	a0,-16(s0)
	call	my_array_size
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
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-36(s0)
	sw	a1,0(a0)
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	li	a1,2
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
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,2
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
	li	a0,2
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
	call	my_array_size
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
	.size	my_c_Queue_int_doubleStorage, .-my_c_Queue_int_doubleStorage
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
	call	my_c_Queue_int_Queue_int
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
	call	my_c_Queue_int_push
.LAB18:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB16
.LAB17:
	lw	a0,-16(s0)
	call	my_c_Queue_int_size
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
	call	my_c_Queue_int_top
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
	call	my_c_Queue_int_pop
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
	call	my_c_Queue_int_size
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
