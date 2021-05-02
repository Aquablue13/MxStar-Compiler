	.text
	.align	2
	.globl	unsigned_shl
	.type	unsigned_shl, @function
unsigned_shl:
	addi	sp,sp,-16
	mv	a2,a0
	mv	a0,a1
	sll	a0,a2,a0
	j	.b0l1
.b0l1:
	addi	sp,sp,16
	jr	ra
	.size	unsigned_shl, .-unsigned_shl
	.text
	.align	2
	.globl	unsigned_shr
	.type	unsigned_shr, @function
unsigned_shr:
	addi	sp,sp,-16
	mv	a3,a0
	mv	a2,a1
	li	a0,-2147483648
	mv	a1,a0
	li	a0,0
	slt	a0,a3,a0
	xori	a0,a0,1
	beq	a0,zero,.b1l3
	sra	a0,a3,a2
	j	.b1l1
	j	.b1l2
.b1l3:
	li	a5,1
	li	a4,31
	sub	a4,a4,a2
	sll	a4,a5,a4
	xor	a1,a3,a1
	sra	a1,a1,a2
	or	a1,a4,a1
	mv	a0,a1
	j	.b1l1
.b1l2:
.b1l1:
	addi	sp,sp,16
	jr	ra
	.size	unsigned_shr, .-unsigned_shr
	.text
	.align	2
	.globl	test
	.type	test, @function
test:
	addi	sp,sp,-16
	sw	ra,12(sp)
	mv	a7,a0
	mv	t0,a1
	mv	a1,a2
	mv	a2,a3
	mv	a3,a4
	mv	t2,a5
	lw	a4,16(sp)
	lw	t1,20(sp)
	lw	a6,24(sp)
	lw	a5,28(sp)
	sub	t5,a7,t0
	seqz	a0,t5
	beq	a0,zero,.b3l3
	sub	t5,t0,a1
	snez	a0,t5
	bne	a0,zero,.b3l6
	sub	t5,a1,a2
	snez	a0,t5
	bne	a0,zero,.b3l6
	li	a0,0
	j	.b3l7
.b3l6:
	li	a0,1
.b3l7:
	beq	a0,zero,.b3l5
	mv	a0,a7
	sw	a0,4(sp)
	mv	a0,a5
	sw	a0,0(sp)
	mv	a7,a6
	mv	a6,t1
	mv	a5,a4
	mv	a4,t2
	mv	a0,t0
	call	test
	mv	a1,a0
	li	a0,1
	add	a0,a1,a0
	j	.b3l1
	j	.b3l4
.b3l5:
	li	t3,1
	sub	t3,t2,t3
	li	t2,2
	sub	t2,a4,t2
	mv	a4,a7
	sw	a4,4(sp)
	mv	a4,a5
	sw	a4,0(sp)
	mv	a7,a6
	mv	a6,t1
	mv	a5,t2
	mv	a4,t3
	mv	a0,t0
	call	test
	mv	a1,a0
	li	a0,2
	add	a0,a1,a0
	j	.b3l1
.b3l4:
	j	.b3l2
.b3l3:
	add	a1,a7,t0
	add	a1,a1,a7
	mv	a0,a1
	j	.b3l1
.b3l2:
.b3l1:
	lw	ra,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	test, .-test
	.text
	.align	2
	.globl	rng
	.type	rng, @function
rng:
	addi	sp,sp,-16
	mv	a1,a0
	li	a0,1073741823
	li	a2,13
	sll	a2,a1,a2
	j	.b2l2
.b2l2:
	xor	a1,a1,a2
	li	a5,17
	li	a2,-2147483648
	mv	a4,a2
	li	a2,0
	slt	a2,a1,a2
	xori	a2,a2,1
	beq	a2,zero,.b2l3
	sra	a2,a1,a5
	j	.b2l4
	j	.b2l5
.b2l3:
	li	a3,1
	li	a2,31
	sub	a2,a2,a5
	sll	a3,a3,a2
	xor	a2,a1,a4
	sra	a2,a2,a5
	or	a2,a3,a2
	j	.b2l4
.b2l5:
.b2l4:
	xor	a1,a1,a2
	li	a2,5
	sll	a2,a1,a2
	j	.b2l6
.b2l6:
	xor	a1,a1,a2
	and	a0,a1,a0
	j	.b2l1
.b2l1:
	addi	sp,sp,16
	jr	ra
	.size	rng, .-rng
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	s1,24(sp)
	sw	ra,20(sp)
	li	a0,19260817
	mv	s1,a0
	li	a0,0
	mv	s0,a0
.b4l2:
	li	a0,1073741823
	mv	a2,s1
	li	a1,13
	sll	a1,a2,a1
	j	.b4l7
.b4l7:
	xor	a1,a2,a1
	mv	a5,a1
	li	a4,17
	li	a1,-2147483648
	mv	a3,a1
	li	a1,0
	slt	a1,a5,a1
	xori	a1,a1,1
	beq	a1,zero,.b4l8
	sra	a1,a5,a4
	j	.b4l9
	j	.b4l10
.b4l8:
	li	a2,1
	li	a1,31
	sub	a1,a1,a4
	sll	a2,a2,a1
	xor	a1,a5,a3
	sra	a1,a1,a4
	or	a1,a2,a1
	j	.b4l9
.b4l10:
.b4l9:
	xor	a1,a5,a1
	mv	a2,a1
	li	a1,5
	sll	a1,a2,a1
	j	.b4l11
.b4l11:
	xor	a1,a2,a1
	and	a0,a1,a0
	j	.b4l12
.b4l12:
	li	a1,1073741823
	mv	a3,a0
	li	a2,13
	sll	a2,a3,a2
	j	.b4l13
.b4l13:
	xor	a2,a3,a2
	mv	a6,a2
	li	a5,17
	li	a2,-2147483648
	mv	a4,a2
	li	a2,0
	slt	a2,a6,a2
	xori	a2,a2,1
	beq	a2,zero,.b4l14
	sra	a2,a6,a5
	j	.b4l15
	j	.b4l16
.b4l14:
	li	a3,1
	li	a2,31
	sub	a2,a2,a5
	sll	a3,a3,a2
	xor	a2,a6,a4
	sra	a2,a2,a5
	or	a2,a3,a2
	j	.b4l15
.b4l16:
.b4l15:
	xor	a2,a6,a2
	mv	a3,a2
	li	a2,5
	sll	a2,a3,a2
	j	.b4l17
.b4l17:
	xor	a2,a3,a2
	and	a1,a2,a1
	j	.b4l18
.b4l18:
	mv	a2,a1
	mv	a1,a2
	li	a3,255
	and	a3,a0,a3
	li	a0,255
	and	a0,a2,a0
	sub	t5,a3,a0
	snez	a0,t5
	beq	a0,zero,.b4l6
	li	a0,1073741823
	mv	a2,a1
	li	a1,13
	sll	a1,a2,a1
	j	.b4l19
.b4l19:
	xor	a1,a2,a1
	mv	a5,a1
	li	a4,17
	li	a1,-2147483648
	mv	a3,a1
	li	a1,0
	slt	a1,a5,a1
	xori	a1,a1,1
	beq	a1,zero,.b4l20
	sra	a1,a5,a4
	j	.b4l21
	j	.b4l22
.b4l20:
	li	a2,1
	li	a1,31
	sub	a1,a1,a4
	sll	a2,a2,a1
	xor	a1,a5,a3
	sra	a1,a1,a4
	or	a1,a2,a1
	j	.b4l21
.b4l22:
.b4l21:
	xor	a1,a5,a1
	mv	a2,a1
	li	a1,5
	sll	a1,a2,a1
	j	.b4l23
.b4l23:
	xor	a1,a2,a1
	and	a0,a1,a0
	j	.b4l24
.b4l24:
	mv	a3,a0
	li	a0,1073741823
	mv	a2,a3
	li	a1,13
	sll	a1,a2,a1
	j	.b4l25
.b4l25:
	xor	a1,a2,a1
	mv	a6,a1
	li	a5,17
	li	a1,-2147483648
	mv	a4,a1
	li	a1,0
	slt	a1,a6,a1
	xori	a1,a1,1
	beq	a1,zero,.b4l26
	sra	a1,a6,a5
	j	.b4l27
	j	.b4l28
.b4l26:
	li	a2,1
	li	a1,31
	sub	a1,a1,a5
	sll	a2,a2,a1
	xor	a1,a6,a4
	sra	a1,a1,a5
	or	a1,a2,a1
	j	.b4l27
.b4l28:
.b4l27:
	xor	a1,a6,a1
	mv	a2,a1
	li	a1,5
	sll	a1,a2,a1
	j	.b4l29
.b4l29:
	xor	a1,a2,a1
	and	a0,a1,a0
	j	.b4l30
.b4l30:
	mv	a1,a0
	li	a0,1073741823
	mv	a4,a1
	li	a2,13
	sll	a2,a4,a2
	j	.b4l31
.b4l31:
	xor	a2,a4,a2
	mv	a7,a2
	li	a6,17
	li	a2,-2147483648
	mv	a5,a2
	li	a2,0
	slt	a2,a7,a2
	xori	a2,a2,1
	beq	a2,zero,.b4l32
	sra	a2,a7,a6
	j	.b4l33
	j	.b4l34
.b4l32:
	li	a4,1
	li	a2,31
	sub	a2,a2,a6
	sll	a4,a4,a2
	xor	a2,a7,a5
	sra	a2,a2,a6
	or	a2,a4,a2
	j	.b4l33
.b4l34:
.b4l33:
	xor	a2,a7,a2
	mv	a4,a2
	li	a2,5
	sll	a2,a4,a2
	j	.b4l35
.b4l35:
	xor	a2,a4,a2
	and	a0,a2,a0
	j	.b4l36
.b4l36:
	li	a2,1073741823
	mv	a5,a0
	li	a4,13
	sll	a4,a5,a4
	j	.b4l37
.b4l37:
	xor	a4,a5,a4
	mv	t0,a4
	li	a7,17
	li	a4,-2147483648
	mv	a6,a4
	li	a4,0
	slt	a4,t0,a4
	xori	a4,a4,1
	beq	a4,zero,.b4l38
	sra	a4,t0,a7
	j	.b4l39
	j	.b4l40
.b4l38:
	li	a5,1
	li	a4,31
	sub	a4,a4,a7
	sll	a5,a5,a4
	xor	a4,t0,a6
	sra	a4,a4,a7
	or	a4,a5,a4
	j	.b4l39
.b4l40:
.b4l39:
	xor	a4,t0,a4
	mv	a5,a4
	li	a4,5
	sll	a4,a5,a4
	j	.b4l41
.b4l41:
	xor	a4,a5,a4
	and	a2,a4,a2
	j	.b4l42
.b4l42:
	li	a4,1073741823
	mv	a6,a2
	li	a5,13
	sll	a5,a6,a5
	j	.b4l43
.b4l43:
	xor	a5,a6,a5
	mv	t1,a5
	li	t0,17
	li	a5,-2147483648
	mv	a7,a5
	li	a5,0
	slt	a5,t1,a5
	xori	a5,a5,1
	beq	a5,zero,.b4l44
	sra	a5,t1,t0
	j	.b4l45
	j	.b4l46
.b4l44:
	li	a6,1
	li	a5,31
	sub	a5,a5,t0
	sll	a6,a6,a5
	xor	a5,t1,a7
	sra	a5,a5,t0
	or	a5,a6,a5
	j	.b4l45
.b4l46:
.b4l45:
	xor	a5,t1,a5
	mv	a6,a5
	li	a5,5
	sll	a5,a6,a5
	j	.b4l47
.b4l47:
	xor	a5,a6,a5
	and	a4,a5,a4
	j	.b4l48
.b4l48:
	mv	s1,a4
	li	a5,3
	and	t0,a3,a5
	li	a5,28
	sra	t1,a3,a5
	li	a3,1
	and	t2,a1,a3
	li	a3,29
	sra	a1,a1,a3
	li	a3,25
	sra	t4,a0,a3
	li	a3,31
	and	t3,a0,a3
	li	a0,15
	sra	a5,a2,a0
	li	a0,32767
	and	a3,a2,a0
	li	a0,15
	sra	a2,a4,a0
	li	a0,32767
	and	a0,a4,a0
	sw	a0,4(sp)
	mv	a0,a2
	sw	a0,0(sp)
	mv	a7,a3
	mv	a6,a5
	mv	a5,t3
	mv	a4,t4
	mv	a3,a1
	mv	a2,t2
	mv	a1,t1
	mv	a0,t0
	call	test
	xor	a0,s0,a0
	mv	s0,a0
	j	.b4l5
.b4l6:
	j	.b4l3
.b4l5:
.b4l4:
	j	.b4l2
.b4l3:
	li	a0,19
	sub	a0,s0,a0
	j	.b4l1
.b4l1:
	lw	s0,28(sp)
	lw	s1,24(sp)
	lw	ra,20(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
