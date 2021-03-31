	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"eternal!"
	.text
	.align	2
	.globl	solveAge
	.type	solveAge, @function
solveAge:
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
	.size	solveAge, .-solveAge
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
	call	solveAge
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
