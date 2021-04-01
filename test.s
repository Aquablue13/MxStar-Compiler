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
	.globl	init
	.type	init, @function
init:
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
	call	size
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
	call	size
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
	.size	init, .-init
	.text
	.align	2
	.globl	getDim
	.type	getDim, @function
getDim:
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
	call	size
	j	.LAB8
.LAB8:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	getDim, .-getDim
	.text
	.align	2
	.globl	dot
	.type	dot, @function
dot:
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
	call	getDim
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
	.size	dot, .-dot
	.text
	.align	2
	.globl	scalarInPlaceMultiply
	.type	scalarInPlaceMultiply, @function
scalarInPlaceMultiply:
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
	call	getDim
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
	.size	scalarInPlaceMultiply, .-scalarInPlaceMultiply
	.text
	.align	2
	.globl	add
	.type	add, @function
add:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	getDim
	mv	a6,a0
	sw	a6,-36(s0)
	lw	a0,-16(s0)
	call	getDim
	lw	a6,-36(s0)
	sub	a6,a6,a0
	snez	a0,a6
	bne	a0,zero,.LAB20
	lw	a0,-12(s0)
	call	getDim
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
	call	getDim
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
	call	getDim
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
	.size	add, .-add
	.text
	.align	2
	.globl	set
	.type	set, @function
set:
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
	call	getDim
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
	.size	set, .-set
	.text
	.align	2
	.globl	tostring
	.type	tostring, @function
tostring:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	getDim
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
	call	getDim
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
	.size	tostring, .-tostring
	.text
	.align	2
	.globl	copy
	.type	copy, @function
copy:
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
	call	getDim
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
	call	getDim
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
	call	getDim
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
	.size	copy, .-copy
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
	call	init
	lui	a0,%hi(.LS3)
	addi	a0,a0,%lo(.LS3)
	call	print
	lw	a0,-16(s0)
	call	tostring
	call	println
	li	a0,4
	call	malloc
	sw	a0,-28(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-28(s0)
	call	copy
	li	a0,3
	li	a1,817
	mv	a2,a1
	mv	a1,a0
	lw	a0,-28(s0)
	call	set
	beq	a0,zero,.LAB49
	lui	a0,%hi(.LS4)
	addi	a0,a0,%lo(.LS4)
	call	println
.LAB49:
	lui	a0,%hi(.LS5)
	addi	a0,a0,%lo(.LS5)
	call	print
	lw	a0,-28(s0)
	call	tostring
	call	println
	lui	a0,%hi(.LS6)
	addi	a0,a0,%lo(.LS6)
	call	print
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	add
	call	tostring
	call	println
	lui	a0,%hi(.LS7)
	addi	a0,a0,%lo(.LS7)
	call	print
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-16(s0)
	call	dot
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
	call	scalarInPlaceMultiply
	call	tostring
	call	println
	li	a0,0
	j	.LAB43
.LAB43:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	main, .-main
