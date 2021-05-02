	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"no solution!\n"
	.text
	.align	2
	.globl	check
	.type	check, @function
check:
	addi	sp,sp,-16
	mv	a2,a0
	mv	a0,a1
	slt	a0,a2,a0
	beq	a0,zero,.b0l2
	li	a0,0
	slt	a0,a2,a0
	xori	a0,a0,1
	beq	a0,zero,.b0l2
	li	a0,1
	j	.b0l3
.b0l2:
	li	a0,0
.b0l3:
	j	.b0l1
.b0l1:
	addi	sp,sp,16
	jr	ra
	.size	check, .-check
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-64
	sw	s0,60(sp)
	sw	s1,56(sp)
	sw	s2,52(sp)
	sw	s3,48(sp)
	sw	s4,44(sp)
	sw	s5,40(sp)
	sw	s6,36(sp)
	sw	s7,32(sp)
	sw	s8,28(sp)
	sw	s9,24(sp)
	sw	s10,20(sp)
	sw	s11,16(sp)
	sw	ra,12(sp)
	call	getInt
	mv	t5,a0
	sw	t5,8(sp)
	li	a0,0
	mv	t5,a0
	sw	t5,4(sp)
	li	a0,0
	mv	s11,a0
	li	a0,0
	mv	s10,a0
	li	a0,0
	mv	s9,a0
	li	a0,1
	lw	t5,8(sp)
	sub	a0,t5,a0
	mv	s8,a0
	li	a0,1
	lw	t5,8(sp)
	sub	a0,t5,a0
	mv	s7,a0
	li	a0,0
	mv	s6,a0
	li	a0,0
	mv	s5,a0
	li	a0,0
	mv	s4,a0
	li	a0,0
	mv	s3,a0
	lw	t5,8(sp)
	lw	t6,8(sp)
	mul	a0,t5,t6
	call	my_array_alloc
	mv	s2,a0
	li	a0,0
	mv	a1,a0
.b1l2:
	lw	t5,8(sp)
	lw	t6,8(sp)
	mul	a0,t6,t5
	slt	a0,a1,a0
	beq	a0,zero,.b1l3
	li	a3,0
	addi	a0,a1,1
	slli	t6,a0,2
	add	a2,s2,t6
	mv	a0,a3
	sw	a0,0(a2)
.b1l4:
	addi	a1,a1,1
	j	.b1l2
.b1l3:
	lw	t5,8(sp)
	lw	t6,8(sp)
	mul	a0,t6,t5
	call	my_array_alloc
	mv	s1,a0
	li	a0,0
	mv	a1,a0
.b1l5:
	lw	t5,8(sp)
	lw	t6,8(sp)
	mul	a0,t6,t5
	slt	a0,a1,a0
	beq	a0,zero,.b1l6
	li	a3,0
	addi	a0,a1,1
	slli	t6,a0,2
	add	a2,s1,t6
	mv	a0,a3
	sw	a0,0(a2)
.b1l7:
	addi	a1,a1,1
	j	.b1l5
.b1l6:
	lw	t5,8(sp)
	mv	a0,t5
	call	my_array_alloc
	mv	s0,a0
	li	a0,0
	mv	s4,a0
.b1l8:
	lw	t5,8(sp)
	slt	a0,s4,t5
	beq	a0,zero,.b1l9
	lw	t5,8(sp)
	mv	a0,t5
	call	my_array_alloc
	addi	a1,s4,1
	slli	t6,a1,2
	add	a1,s0,t6
	sw	a0,0(a1)
	li	a0,0
	mv	a1,a0
.b1l11:
	lw	t5,8(sp)
	slt	a0,a1,t5
	beq	a0,zero,.b1l12
	li	a0,1
	neg	a3,a0
	addi	a0,s4,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a2,a1,1
	lw	a0,0(a0)
	slli	t6,a2,2
	add	a2,a0,t6
	mv	a0,a3
	sw	a0,0(a2)
.b1l13:
	addi	a1,a1,1
	j	.b1l11
.b1l12:
.b1l10:
	addi	s4,s4,1
	j	.b1l8
.b1l9:
	li	a0,0
	addi	a0,a0,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s10
	sw	a0,0(a1)
	li	a0,0
	addi	a0,a0,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s9
	sw	a0,0(a1)
	li	a2,0
	addi	a0,s10,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s9,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
.b1l14:
	lw	t5,4(sp)
	sgt	a0,t5,s11
	xori	a0,a0,1
	beq	a0,zero,.b1l15
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	lw	a0,0(a0)
	addi	a0,a0,1
	slli	t6,a0,2
	add	a2,s0,t6
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	lw	a0,0(a0)
	addi	a1,a0,1
	lw	a0,0(a2)
	slli	t6,a1,2
	add	a0,a0,t6
	lw	a0,0(a0)
	mv	s4,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,2
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l17
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l17
	li	a0,1
	j	.b1l18
.b1l17:
	li	a0,0
.b1l18:
	beq	a0,zero,.b1l19
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l19
	li	a0,1
	j	.b1l20
.b1l19:
	li	a0,0
.b1l20:
	beq	a0,zero,.b1l16
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l22
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l22
	li	a0,1
	j	.b1l23
.b1l22:
	li	a0,0
.b1l23:
	beq	a0,zero,.b1l21
	li	a0,1
	mv	s3,a0
.b1l21:
.b1l16:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,2
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l25
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l25
	li	a0,1
	j	.b1l26
.b1l25:
	li	a0,0
.b1l26:
	beq	a0,zero,.b1l27
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l27
	li	a0,1
	j	.b1l28
.b1l27:
	li	a0,0
.b1l28:
	beq	a0,zero,.b1l24
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l30
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l30
	li	a0,1
	j	.b1l31
.b1l30:
	li	a0,0
.b1l31:
	beq	a0,zero,.b1l29
	li	a0,1
	mv	s3,a0
.b1l29:
.b1l24:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,1
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,2
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l33
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l33
	li	a0,1
	j	.b1l34
.b1l33:
	li	a0,0
.b1l34:
	beq	a0,zero,.b1l35
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l35
	li	a0,1
	j	.b1l36
.b1l35:
	li	a0,0
.b1l36:
	beq	a0,zero,.b1l32
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l38
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l38
	li	a0,1
	j	.b1l39
.b1l38:
	li	a0,0
.b1l39:
	beq	a0,zero,.b1l37
	li	a0,1
	mv	s3,a0
.b1l37:
.b1l32:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,1
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,2
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l41
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l41
	li	a0,1
	j	.b1l42
.b1l41:
	li	a0,0
.b1l42:
	beq	a0,zero,.b1l43
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l43
	li	a0,1
	j	.b1l44
.b1l43:
	li	a0,0
.b1l44:
	beq	a0,zero,.b1l40
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l46
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l46
	li	a0,1
	j	.b1l47
.b1l46:
	li	a0,0
.b1l47:
	beq	a0,zero,.b1l45
	li	a0,1
	mv	s3,a0
.b1l45:
.b1l40:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,2
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l49
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l49
	li	a0,1
	j	.b1l50
.b1l49:
	li	a0,0
.b1l50:
	beq	a0,zero,.b1l51
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l51
	li	a0,1
	j	.b1l52
.b1l51:
	li	a0,0
.b1l52:
	beq	a0,zero,.b1l48
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l54
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l54
	li	a0,1
	j	.b1l55
.b1l54:
	li	a0,0
.b1l55:
	beq	a0,zero,.b1l53
	li	a0,1
	mv	s3,a0
.b1l53:
.b1l48:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,2
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,1
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l57
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l57
	li	a0,1
	j	.b1l58
.b1l57:
	li	a0,0
.b1l58:
	beq	a0,zero,.b1l59
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l59
	li	a0,1
	j	.b1l60
.b1l59:
	li	a0,0
.b1l60:
	beq	a0,zero,.b1l56
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l62
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l62
	li	a0,1
	j	.b1l63
.b1l62:
	li	a0,0
.b1l63:
	beq	a0,zero,.b1l61
	li	a0,1
	mv	s3,a0
.b1l61:
.b1l56:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,2
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l65
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l65
	li	a0,1
	j	.b1l66
.b1l65:
	li	a0,0
.b1l66:
	beq	a0,zero,.b1l67
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l67
	li	a0,1
	j	.b1l68
.b1l67:
	li	a0,0
.b1l68:
	beq	a0,zero,.b1l64
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l70
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l70
	li	a0,1
	j	.b1l71
.b1l70:
	li	a0,0
.b1l71:
	beq	a0,zero,.b1l69
	li	a0,1
	mv	s3,a0
.b1l69:
.b1l64:
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s2,t6
	li	a1,2
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s6,a0
	lw	t5,4(sp)
	addi	a0,t5,1
	slli	t6,a0,2
	add	a0,s1,t6
	li	a1,1
	lw	a0,0(a0)
	add	a0,a0,a1
	mv	s5,a0
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s6
	call	check
	beq	a0,zero,.b1l73
	lw	t5,8(sp)
	mv	a1,t5
	mv	a0,s5
	call	check
	beq	a0,zero,.b1l73
	li	a0,1
	j	.b1l74
.b1l73:
	li	a0,0
.b1l74:
	beq	a0,zero,.b1l75
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a2,a0,t6
	li	a0,1
	neg	a1,a0
	lw	a0,0(a2)
	sub	t5,a0,a1
	seqz	a0,t5
	beq	a0,zero,.b1l75
	li	a0,1
	j	.b1l76
.b1l75:
	li	a0,0
.b1l76:
	beq	a0,zero,.b1l72
	li	a0,1
	add	a0,s11,a0
	mv	s11,a0
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s2,t6
	mv	a0,s6
	sw	a0,0(a1)
	addi	a0,s11,1
	slli	t6,a0,2
	add	a1,s1,t6
	mv	a0,s5
	sw	a0,0(a1)
	li	a0,1
	add	a2,s4,a0
	addi	a0,s6,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s5,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a1,a0,t6
	mv	a0,a2
	sw	a0,0(a1)
	sub	t5,s6,s8
	seqz	a0,t5
	beq	a0,zero,.b1l78
	sub	t5,s5,s7
	seqz	a0,t5
	beq	a0,zero,.b1l78
	li	a0,1
	j	.b1l79
.b1l78:
	li	a0,0
.b1l79:
	beq	a0,zero,.b1l77
	li	a0,1
	mv	s3,a0
.b1l77:
.b1l72:
	li	a0,1
	sub	t5,s3,a0
	seqz	a0,t5
	beq	a0,zero,.b1l80
	j	.b1l15
.b1l80:
	li	a0,1
	lw	t5,4(sp)
	add	a0,t5,a0
	mv	t5,a0
	sw	t5,4(sp)
	j	.b1l14
.b1l15:
	li	a0,1
	sub	t5,s3,a0
	seqz	a0,t5
	beq	a0,zero,.b1l82
	addi	a0,s8,1
	slli	t6,a0,2
	add	a0,s0,t6
	addi	a1,s7,1
	lw	a0,0(a0)
	slli	t6,a1,2
	add	a0,a0,t6
	lw	a0,0(a0)
	call	toString
	call	println
	j	.b1l81
.b1l82:
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	print
.b1l81:
	li	a0,0
	j	.b1l1
.b1l1:
	lw	s0,60(sp)
	lw	s1,56(sp)
	lw	s2,52(sp)
	lw	s3,48(sp)
	lw	s4,44(sp)
	lw	s5,40(sp)
	lw	s6,36(sp)
	lw	s7,32(sp)
	lw	s8,28(sp)
	lw	s9,24(sp)
	lw	s10,20(sp)
	lw	s11,16(sp)
	lw	ra,12(sp)
	addi	sp,sp,64
	jr	ra
	.size	main, .-main
