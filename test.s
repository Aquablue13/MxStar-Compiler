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
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	slli	ra,ra,2
	add	a0,a0,ra
	li	a1,100
	lw	a0,0(a0)
	sgt	a0,a0,a1
	xori	a0,a0,1
	beq	a0,zero,.LAB3
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_string_plus
	lw	a1,-16(s0)
	slli	zero,zero,2
	add	a1,a1,zero
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
	lw	a0,-12(s0)
	call	my_string_plus
	lw	a1,-16(s0)
	slli	zero,zero,2
	add	a1,a1,zero
	lw	a1,0(a1)
	call	my_string_plus
	lui	a1,%hi(.LS3)
	addi	a1,a1,%lo(.LS3)
	call	my_string_plus
	call	println
.LAB2:
	lw	a0,-16(s0)
	slli	ra,ra,2
	add	a0,a0,ra
	lw	a0,0(a0)
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	add	a0,a0,a1
	lw	a1,-16(s0)
	slli	ra,ra,2
	add	a1,a1,ra
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
	sw	a0,-20(s0)
	lui	a0,%hi(.LS4)
	addi	a0,a0,%lo(.LS4)
	lw	a1,-20(s0)
	slli	zero,zero,2
	add	a1,a1,zero
	sw	a0,0(a1)
	li	a0,0
	lw	a1,-20(s0)
	slli	ra,ra,2
	add	a1,a1,ra
	sw	a0,0(a1)
	li	a0,8
	call	malloc
	sw	a0,-24(s0)
	lui	a0,%hi(.LS5)
	addi	a0,a0,%lo(.LS5)
	lw	a1,-24(s0)
	slli	zero,zero,2
	add	a1,a1,zero
	sw	a0,0(a1)
	lw	a0,-24(s0)
	slli	ra,ra,2
	add	a0,a0,ra
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	sw	a1,0(a0)
	lui	a0,%hi(.LS6)
	addi	a0,a0,%lo(.LS6)
	lw	a1,-20(s0)
	call	work
	lui	a0,%hi(.LS7)
	addi	a0,a0,%lo(.LS7)
	lw	a1,-24(s0)
	call	work
	lui	a0,%hi(.LS8)
	addi	a0,a0,%lo(.LS8)
	lw	a1,-24(s0)
	call	work
	li	a0,0
	j	.LAB4
.LAB4:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
