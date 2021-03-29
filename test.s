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
	sw	a0,-12(s0)
	li	a0,0
	j	.LAB1
.LAB1:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	main, .-main
