	.text
	.align	2
	.globl	gcd
	.type	gcd, @function
gcd:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b0l3
	mv	a0,a2
	j	.b0l1
	j	.b0l2
.b0l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd5
	j	.b0l1
.b0l2:
.b0l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd, .-gcd
	.text
	.align	2
	.globl	gcd1
	.type	gcd1, @function
gcd1:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b1l3
	mv	a0,a2
	j	.b1l1
	j	.b1l2
.b1l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd
	j	.b1l1
.b1l2:
.b1l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd1, .-gcd1
	.text
	.align	2
	.globl	gcd2
	.type	gcd2, @function
gcd2:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b2l3
	mv	a0,a2
	j	.b2l1
	j	.b2l2
.b2l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd1
	j	.b2l1
.b2l2:
.b2l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd2, .-gcd2
	.text
	.align	2
	.globl	gcd3
	.type	gcd3, @function
gcd3:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b3l3
	mv	a0,a2
	j	.b3l1
	j	.b3l2
.b3l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd2
	j	.b3l1
.b3l2:
.b3l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd3, .-gcd3
	.text
	.align	2
	.globl	gcd4
	.type	gcd4, @function
gcd4:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b4l3
	mv	a0,a2
	j	.b4l1
	j	.b4l2
.b4l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd
	j	.b4l1
.b4l2:
.b4l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd4, .-gcd4
	.text
	.align	2
	.globl	gcd5
	.type	gcd5, @function
gcd5:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a3,a0
	mv	a2,a1
	rem	a1,a3,a2
	li	a0,0
	sub	t5,a1,a0
	seqz	a0,t5
	beq	a0,zero,.b5l3
	mv	a0,a2
	j	.b5l1
	j	.b5l2
.b5l3:
	rem	a1,a3,a2
	mv	a0,a2
	call	gcd2
	j	.b5l1
.b5l2:
.b5l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	gcd5, .-gcd5
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-16
	sw	ra,12(sp)
	li	a2,10
	li	a0,1
	mv	a1,a0
	mv	a0,a2
	call	gcd
	call	toString
	call	println
	li	a2,34986
	li	a0,3087
	mv	a1,a0
	mv	a0,a2
	call	gcd
	call	toString
	call	println
	li	a2,2907
	li	a0,1539
	mv	a1,a0
	mv	a0,a2
	call	gcd
	call	toString
	call	println
	li	a0,0
	j	.b6l1
.b6l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	main, .-main
