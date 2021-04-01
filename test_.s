from:11
to:11
weight:11
edges:11
next:11
first:11
size:11
storage:11
sz:11
storage:11
node:11
dist:11
i:1
e:1
t:1
copy:1
szCopy:1
x:1
p:1
res:1
l:1
r:1
largest:1
n:2
m:2
g:2
INF:2
i:1
u:1
v:1
w:1
visited:1
d:1
i:1
q:1
src:1
node:1
u:1
k:1
v:1
w:1
alt:1
i:1
j:1
d:1
STRING(0) -1
STRING(1)  
STRING(2) 
GLOBAL(0) 0
GLOBAL(1) 0
GLOBAL(2) 0
GLOBAL(3) 0
FUNC my_c_EdgeList_init
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	MOVE L4 L2
	MOVE T0 L2
	MOVE 10 T0
	CALL my_array_alloc
	MOVE L5 10
LABEL(2)
	BNEQ(3) L4 0
	LOAD 10 i12
	CALL malloc
	MOVE T1 10
	INDEX T2 L5 L4
	MOVE *T2 T1
	ADDI L4 L4 i-1
	JUMP(2)
LABEL(3)
	LOAD T3 i0
	INDEX T4 L0 T3
	MOVE *T4 L5
	MOVE L6 L2
	MOVE T5 L2
	MOVE 10 T5
	CALL my_array_alloc
	MOVE L7 10
LABEL(4)
	BNEQ(5) L6 0
	INDEX T6 L7 L6
	MOVE *T6 0
	ADDI L6 L6 i-1
	JUMP(4)
LABEL(5)
	LOAD T7 i1
	INDEX T8 L0 T7
	MOVE *T8 L7
	MOVE L8 L1
	MOVE T9 L1
	MOVE 10 T9
	CALL my_array_alloc
	MOVE L9 10
LABEL(6)
	BNEQ(7) L8 0
	INDEX T10 L9 L8
	MOVE *T10 0
	ADDI L8 L8 i-1
	JUMP(6)
LABEL(7)
	LOAD T11 i2
	INDEX T12 L0 T11
	MOVE *T12 L9
	LOAD T13 i0
	MOVE L3 T13
LABEL(8)
	LE T14 L3 L2
	BNEQ(9) T14 0
	LOAD T15 i1
	NEG T16 T15
	LOAD T17 i1
	INDEX T18 L0 T17
	ADDI T19 L3 i1
	INDEX T20 *T18 T19
	MOVE *T20 T16
LABEL(10)
	ADDI L3 L3 i1
	JUMP(8)
LABEL(9)
	LOAD T21 i0
	MOVE L3 T21
LABEL(11)
	LE T22 L3 L1
	BNEQ(12) T22 0
	LOAD T23 i1
	NEG T24 T23
	LOAD T25 i2
	INDEX T26 L0 T25
	ADDI T27 L3 i1
	INDEX T28 *T26 T27
	MOVE *T28 T24
LABEL(13)
	ADDI L3 L3 i1
	JUMP(11)
LABEL(12)
	LOAD T29 i0
	LOAD T30 i3
	INDEX T31 L0 T30
	MOVE *T31 T29
FUNC my_c_EdgeList_addEdge
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	MOVE L3 13
	LOAD 10 i12
	CALL malloc
	MOVE T0 10
	MOVE L4 T0
	LOAD T1 i0
	INDEX T2 L4 T1
	MOVE *T2 L1
	LOAD T3 i1
	INDEX T4 L4 T3
	MOVE *T4 L2
	LOAD T5 i2
	INDEX T6 L4 T5
	MOVE *T6 L3
	LOAD T7 i0
	INDEX T8 L0 T7
	LOAD T9 i3
	INDEX T10 L0 T9
	ADDI T11 *T10 i1
	INDEX T12 *T8 T11
	MOVE *T12 L4
	LOAD T13 i2
	INDEX T14 L0 T13
	ADDI T15 L1 i1
	INDEX T16 *T14 T15
	LOAD T17 i1
	INDEX T18 L0 T17
	LOAD T19 i3
	INDEX T20 L0 T19
	ADDI T21 *T20 i1
	INDEX T22 *T18 T21
	MOVE *T22 *T16
	LOAD T23 i3
	INDEX T24 L0 T23
	LOAD T25 i2
	INDEX T26 L0 T25
	ADDI T27 L1 i1
	INDEX T28 *T26 T27
	MOVE *T28 *T24
	LOAD T29 i3
	INDEX T30 L0 T29
	ADDI *T30 *T30 i1
FUNC my_c_EdgeList_nVertices
	MOVE L0 10
	LOAD T0 i2
	INDEX T1 L0 T0
	MOVE P0 *T1
	CALL my_array_size
	MOVE T2 10
	MOVE 10 T2
	JUMP(15)
FUNC my_c_EdgeList_nEdges
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE P0 *T1
	CALL my_array_size
	MOVE T2 10
	MOVE 10 T2
	JUMP(16)
FUNC my_c_Array_Node_Array_Node
	MOVE L0 10
	LOAD T0 i0
	LOAD T1 i1
	INDEX T2 L0 T1
	MOVE *T2 T0
	LOAD T3 i16
	MOVE L1 T3
	MOVE T4 T3
	MOVE 10 T4
	CALL my_array_alloc
	MOVE L2 10
LABEL(18)
	BNEQ(19) L1 0
	LOAD 10 i8
	CALL malloc
	MOVE T5 10
	INDEX T6 L2 L1
	MOVE *T6 T5
	ADDI L1 L1 i-1
	JUMP(18)
LABEL(19)
	LOAD T7 i0
	INDEX T8 L0 T7
	MOVE *T8 L2
FUNC my_c_Array_Node_push_back
	MOVE L0 10
	MOVE L1 11
	MOVE P0 L0
	CALL my_c_Array_Node_size
	MOVE T1 10
	LOAD T2 i0
	INDEX T3 L0 T2
	MOVE P0 *T3
	CALL my_array_size
	MOVE T4 10
	EQ T0 T1 T4
	BNEQ(21) T0 0
	MOVE P0 L0
	CALL my_c_Array_Node_doubleStorage
	MOVE T5 10
LABEL(21)
	LOAD T6 i0
	INDEX T7 L0 T6
	LOAD T8 i1
	INDEX T9 L0 T8
	ADDI T10 *T9 i1
	INDEX T11 *T7 T10
	MOVE *T11 L1
	LOAD T12 i1
	INDEX T13 L0 T12
	ADDI *T13 *T13 i1
FUNC my_c_Array_Node_pop_back
	MOVE L0 10
	LOAD T0 i1
	INDEX T1 L0 T0
	ADDI *T1 *T1 i-1
	LOAD T2 i0
	INDEX T3 L0 T2
	LOAD T4 i1
	INDEX T5 L0 T4
	ADDI T6 *T5 i1
	INDEX T7 *T3 T6
	MOVE 10 *T7
	JUMP(22)
FUNC my_c_Array_Node_back
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	LOAD T3 i1
	INDEX T4 L0 T3
	LOAD T5 i1
	SUB T2 *T4 T5
	ADDI T6 T2 i1
	INDEX T7 *T1 T6
	MOVE 10 *T7
	JUMP(23)
FUNC my_c_Array_Node_front
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	LOAD T2 i0
	ADDI T3 T2 i1
	INDEX T4 *T1 T3
	MOVE 10 *T4
	JUMP(24)
FUNC my_c_Array_Node_size
	MOVE L0 10
	LOAD T0 i1
	INDEX T1 L0 T0
	MOVE 10 *T1
	JUMP(25)
FUNC my_c_Array_Node_resize
	MOVE L0 10
	MOVE L1 11
LABEL(27)
	LOAD T1 i0
	INDEX T2 L0 T1
	MOVE P0 *T2
	CALL my_array_size
	MOVE T3 10
	LE T0 T3 L1
	BNEQ(28) T0 0
	MOVE P0 L0
	CALL my_c_Array_Node_doubleStorage
	MOVE T4 10
	JUMP(27)
LABEL(28)
	LOAD T5 i1
	INDEX T6 L0 T5
	MOVE *T6 L1
FUNC my_c_Array_Node_get
	MOVE L0 10
	MOVE L1 11
	LOAD T0 i0
	INDEX T1 L0 T0
	ADDI T2 L1 i1
	INDEX T3 *T1 T2
	MOVE 10 *T3
	JUMP(29)
FUNC my_c_Array_Node_set
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	LOAD T0 i0
	INDEX T1 L0 T0
	ADDI T2 L1 i1
	INDEX T3 *T1 T2
	MOVE *T3 L2
FUNC my_c_Array_Node_swap
	MOVE L0 10
	MOVE L1 11
	MOVE L2 12
	LOAD T0 i0
	INDEX T1 L0 T0
	ADDI T2 L1 i1
	INDEX T3 *T1 T2
	MOVE L3 *T3
	LOAD T4 i0
	INDEX T5 L0 T4
	ADDI T6 L2 i1
	INDEX T7 *T5 T6
	LOAD T8 i0
	INDEX T9 L0 T8
	ADDI T10 L1 i1
	INDEX T11 *T9 T10
	MOVE *T11 *T7
	LOAD T12 i0
	INDEX T13 L0 T12
	ADDI T14 L2 i1
	INDEX T15 *T13 T14
	MOVE *T15 L3
FUNC my_c_Array_Node_doubleStorage
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE L1 *T1
	LOAD T2 i1
	INDEX T3 L0 T2
	MOVE L2 *T3
	MOVE P0 L1
	CALL my_array_size
	MOVE T5 10
	LOAD T6 i2
	MUL T4 T5 T6
	MOVE L3 T4
	MOVE T7 T4
	MOVE 10 T7
	CALL my_array_alloc
	MOVE L4 10
LABEL(33)
	BNEQ(34) L3 0
	LOAD 10 i8
	CALL malloc
	MOVE T8 10
	INDEX T9 L4 L3
	MOVE *T9 T8
	ADDI L3 L3 i-1
	JUMP(33)
LABEL(34)
	LOAD T10 i0
	INDEX T11 L0 T10
	MOVE *T11 L4
	LOAD T12 i0
	LOAD T13 i1
	INDEX T14 L0 T13
	MOVE *T14 T12
LABEL(35)
	LOAD T16 i1
	INDEX T17 L0 T16
	NEQ T15 *T17 L2
	BNEQ(36) T15 0
	LOAD T18 i1
	INDEX T19 L0 T18
	ADDI T20 *T19 i1
	INDEX T21 L1 T20
	LOAD T22 i0
	INDEX T23 L0 T22
	LOAD T24 i1
	INDEX T25 L0 T24
	ADDI T26 *T25 i1
	INDEX T27 *T23 T26
	MOVE *T27 *T21
LABEL(37)
	LOAD T28 i1
	INDEX T29 L0 T28
	ADDI *T29 *T29 i1
	JUMP(35)
LABEL(36)
FUNC my_c_Heap_Node_Heap_Node
	MOVE L0 10
	LOAD 10 i8
	CALL malloc
	MOVE T0 10
	CALL my_c_Array_Node_Array_Node
	LOAD T1 i0
	INDEX T2 L0 T1
	MOVE *T2 T0
FUNC my_c_Heap_Node_push
	MOVE L0 10
	MOVE L1 11
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE P1 L1
	MOVE P0 *T1
	CALL my_c_Array_Node_push_back
	MOVE T2 10
	MOVE P0 L0
	CALL my_c_Heap_Node_size
	MOVE T4 10
	LOAD T5 i1
	SUB T3 T4 T5
	MOVE L2 T3
LABEL(40)
	LOAD T7 i0
	GE T6 L2 T7
	BNEQ(41) T6 0
	MOVE P1 L2
	MOVE P0 L0
	CALL my_c_Heap_Node_pnt
	MOVE T8 10
	MOVE L3 T8
	LOAD T10 i0
	INDEX T11 L0 T10
	MOVE P1 L3
	MOVE P0 *T11
	CALL my_c_Array_Node_get
	MOVE T12 10
	MOVE P0 T12
	CALL my_c_Node_key_
	MOVE T13 10
	LOAD T14 i0
	INDEX T15 L0 T14
	MOVE P1 L2
	MOVE P0 *T15
	CALL my_c_Array_Node_get
	MOVE T16 10
	MOVE P0 T16
	CALL my_c_Node_key_
	MOVE T17 10
	GEQ T9 T13 T17
	BNEQ(42) T9 0
	JUMP(41)
LABEL(42)
	LOAD T18 i0
	INDEX T19 L0 T18
	MOVE P2 L2
	MOVE P1 L3
	MOVE P0 *T19
	CALL my_c_Array_Node_swap
	MOVE T20 10
	MOVE L2 L3
	JUMP(40)
LABEL(41)
FUNC my_c_Heap_Node_pop
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE P0 *T1
	CALL my_c_Array_Node_front
	MOVE T2 10
	MOVE L1 T2
	LOAD T3 i0
	INDEX T4 L0 T3
	LOAD T5 i0
	MOVE P0 L0
	CALL my_c_Heap_Node_size
	MOVE T7 10
	LOAD T8 i1
	SUB T6 T7 T8
	MOVE P2 T6
	MOVE P1 T5
	MOVE P0 *T4
	CALL my_c_Array_Node_swap
	MOVE T9 10
	LOAD T10 i0
	INDEX T11 L0 T10
	MOVE P0 *T11
	CALL my_c_Array_Node_pop_back
	MOVE T12 10
	LOAD T13 i0
	MOVE P1 T13
	MOVE P0 L0
	CALL my_c_Heap_Node_maxHeapify
	MOVE T14 10
	MOVE 10 L1
	JUMP(43)
FUNC my_c_Heap_Node_top
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE P0 *T1
	CALL my_c_Array_Node_front
	MOVE T2 10
	MOVE 10 T2
	JUMP(44)
FUNC my_c_Heap_Node_size
	MOVE L0 10
	LOAD T0 i0
	INDEX T1 L0 T0
	MOVE P0 *T1
	CALL my_c_Array_Node_size
	MOVE T2 10
	MOVE 10 T2
	JUMP(45)
FUNC my_c_Heap_Node_lchild
	MOVE L0 10
	MOVE L1 11
	LOAD T2 i2
	MUL T1 L1 T2
	LOAD T3 i1
	ADD T0 T1 T3
	MOVE 10 T0
	JUMP(46)
FUNC my_c_Heap_Node_rchild
	MOVE L0 10
	MOVE L1 11
	LOAD T2 i2
	MUL T1 L1 T2
	LOAD T3 i2
	ADD T0 T1 T3
	MOVE 10 T0
	JUMP(47)
FUNC my_c_Heap_Node_pnt
	MOVE L0 10
	MOVE L1 11
	LOAD T2 i1
	SUB T1 L1 T2
	LOAD T3 i2
	DIV T0 T1 T3
	MOVE 10 T0
	JUMP(48)
FUNC my_c_Heap_Node_maxHeapify
	MOVE L0 10
	MOVE L1 11
	MOVE P1 L1
	MOVE P0 L0
	CALL my_c_Heap_Node_lchild
	MOVE T0 10
	MOVE L2 T0
	MOVE P1 L1
	MOVE P0 L0
	CALL my_c_Heap_Node_rchild
	MOVE T1 10
	MOVE L3 T1
	MOVE L4 L1
	MOVE P0 L0
	CALL my_c_Heap_Node_size
	MOVE T4 10
	LE T3 L2 T4
	BNEQ(51) T3 0
	LOAD T6 i0
	INDEX T7 L0 T6
	MOVE P1 L2
	MOVE P0 *T7
	CALL my_c_Array_Node_get
	MOVE T8 10
	MOVE P0 T8
	CALL my_c_Node_key_
	MOVE T9 10
	LOAD T10 i0
	INDEX T11 L0 T10
	MOVE P1 L4
	MOVE P0 *T11
	CALL my_c_Array_Node_get
	MOVE T12 10
	MOVE P0 T12
	CALL my_c_Node_key_
	MOVE T13 10
	GE T5 T9 T13
	BNEQ(51) T5 0
	LOAD T2 i1
	JUMP(52)
LABEL(51)
	LOAD T2 i0
LABEL(52)
	BNEQ(50) T2 0
	MOVE L4 L2
LABEL(50)
	MOVE P0 L0
	CALL my_c_Heap_Node_size
	MOVE T16 10
	LE T15 L3 T16
	BNEQ(54) T15 0
	LOAD T18 i0
	INDEX T19 L0 T18
	MOVE P1 L3
	MOVE P0 *T19
	CALL my_c_Array_Node_get
	MOVE T20 10
	MOVE P0 T20
	CALL my_c_Node_key_
	MOVE T21 10
	LOAD T22 i0
	INDEX T23 L0 T22
	MOVE P1 L4
	MOVE P0 *T23
	CALL my_c_Array_Node_get
	MOVE T24 10
	MOVE P0 T24
	CALL my_c_Node_key_
	MOVE T25 10
	GE T17 T21 T25
	BNEQ(54) T17 0
	LOAD T14 i1
	JUMP(55)
LABEL(54)
	LOAD T14 i0
LABEL(55)
	BNEQ(53) T14 0
	MOVE L4 L3
LABEL(53)
	EQ T26 L4 L1
	BNEQ(56) T26 0
	JUMP(49)
LABEL(56)
	LOAD T27 i0
	INDEX T28 L0 T27
	MOVE P2 L4
	MOVE P1 L1
	MOVE P0 *T28
	CALL my_c_Array_Node_swap
	MOVE T29 10
	MOVE P1 L4
	MOVE P0 L0
	CALL my_c_Heap_Node_maxHeapify
	MOVE T30 10
FUNC init
	CALL getInt
	MOVE T0 10
	MOVE G0 T0
	CALL getInt
	MOVE T1 10
	MOVE G1 T1
	LOAD 10 i16
	CALL malloc
	MOVE T2 10
	MOVE G2 T2
	MOVE P2 G1
	MOVE P1 G0
	MOVE P0 G2
	CALL my_c_EdgeList_init
	MOVE T3 10
	LOAD T4 i0
	MOVE L1 T4
LABEL(58)
	LE T5 L1 G1
	BNEQ(59) T5 0
	CALL getInt
	MOVE T6 10
	MOVE L2 T6
	CALL getInt
	MOVE T7 10
	MOVE L3 T7
	CALL getInt
	MOVE T8 10
	MOVE L4 T8
	MOVE P3 L4
	MOVE P2 L3
	MOVE P1 L2
	MOVE P0 G2
	CALL my_c_EdgeList_addEdge
	MOVE T9 10
LABEL(60)
	ADDI L1 L1 i1
	JUMP(58)
LABEL(59)
FUNC my_c_Node_key_
	MOVE L0 10
	LOAD T0 i1
	INDEX T1 L0 T0
	NEG T2 *T1
	MOVE 10 T2
	JUMP(61)
FUNC dijkstra
	MOVE L1 10
	MOVE L13 G0
	MOVE T0 G0
	MOVE 10 T0
	CALL my_array_alloc
	MOVE L14 10
LABEL(63)
	BNEQ(64) L13 0
	INDEX T1 L14 L13
	MOVE *T1 0
	ADDI L13 L13 i-1
	JUMP(63)
LABEL(64)
	MOVE L2 L14
	MOVE L15 G0
	MOVE T2 G0
	MOVE 10 T2
	CALL my_array_alloc
	MOVE L16 10
LABEL(65)
	BNEQ(66) L15 0
	INDEX T3 L16 L15
	MOVE *T3 0
	ADDI L15 L15 i-1
	JUMP(65)
LABEL(66)
	MOVE L3 L16
	LOAD T4 i0
	MOVE L4 T4
LABEL(67)
	LE T5 L4 G0
	BNEQ(68) T5 0
	ADDI T6 L4 i1
	INDEX T7 L3 T6
	MOVE *T7 G3
	LOAD T8 i0
	ADDI T9 L4 i1
	INDEX T10 L2 T9
	MOVE *T10 T8
LABEL(69)
	ADDI L4 L4 i1
	JUMP(67)
LABEL(68)
	LOAD T11 i0
	ADDI T12 L1 i1
	INDEX T13 L3 T12
	MOVE *T13 T11
	LOAD 10 i4
	CALL malloc
	MOVE T14 10
	CALL my_c_Heap_Node_Heap_Node
	MOVE L5 T14
	LOAD 10 i8
	CALL malloc
	MOVE T15 10
	MOVE L6 T15
	LOAD T16 i0
	LOAD T17 i1
	INDEX T18 L6 T17
	MOVE *T18 T16
	LOAD T19 i0
	INDEX T20 L6 T19
	MOVE *T20 L1
	MOVE P1 L6
	MOVE P0 L5
	CALL my_c_Heap_Node_push
	MOVE T21 10
LABEL(70)
	MOVE P0 L5
	CALL my_c_Heap_Node_size
	MOVE T23 10
	LOAD T24 i0
	NEQ T22 T23 T24
	BNEQ(71) T22 0
	MOVE P0 L5
	CALL my_c_Heap_Node_pop
	MOVE T25 10
	MOVE L7 T25
	LOAD T26 i0
	INDEX T27 L7 T26
	MOVE L8 *T27
	ADDI T29 L8 i1
	INDEX T30 L2 T29
	LOAD T31 i1
	EQ T28 *T30 T31
	BNEQ(72) T28 0
	JUMP(70)
LABEL(72)
	LOAD T32 i1
	ADDI T33 L8 i1
	INDEX T34 L2 T33
	MOVE *T34 T32
	LOAD T35 i2
	INDEX T36 G2 T35
	ADDI T37 L8 i1
	INDEX T38 *T36 T37
	MOVE L9 *T38
LABEL(73)
	LOAD T40 i1
	NEG T41 T40
	NEQ T39 L9 T41
	BNEQ(74) T39 0
	LOAD T42 i0
	INDEX T43 G2 T42
	ADDI T44 L9 i1
	INDEX T45 *T43 T44
	LOAD T46 i1
	INDEX T47 *T45 T46
	MOVE L10 *T47
	LOAD T48 i0
	INDEX T49 G2 T48
	ADDI T50 L9 i1
	INDEX T51 *T49 T50
	LOAD T52 i2
	INDEX T53 *T51 T52
	MOVE L11 *T53
	ADDI T55 L8 i1
	INDEX T56 L3 T55
	ADD T54 *T56 L11
	MOVE L12 T54
	ADDI T58 L10 i1
	INDEX T59 L3 T58
	GEQ T57 L12 *T59
	BNEQ(76) T57 0
	JUMP(75)
LABEL(76)
	ADDI T60 L10 i1
	INDEX T61 L3 T60
	MOVE *T61 L12
	LOAD 10 i8
	CALL malloc
	MOVE T62 10
	MOVE L7 T62
	LOAD T63 i0
	INDEX T64 L7 T63
	MOVE *T64 L10
	ADDI T65 L10 i1
	INDEX T66 L3 T65
	LOAD T67 i1
	INDEX T68 L7 T67
	MOVE *T68 *T66
	MOVE P1 L7
	MOVE P0 L5
	CALL my_c_Heap_Node_push
	MOVE T69 10
LABEL(75)
	LOAD T70 i1
	INDEX T71 G2 T70
	ADDI T72 L9 i1
	INDEX T73 *T71 T72
	MOVE L9 *T73
	JUMP(73)
LABEL(74)
	JUMP(70)
LABEL(71)
	MOVE 10 L3
	JUMP(62)
FUNC main
	LOAD T0 i10000000
	MOVE G3 T0
	CALL init
	MOVE T1 10
	LOAD T2 i0
	MOVE L1 T2
LABEL(78)
	LE T3 L1 G0
	BNEQ(79) T3 0
	MOVE P0 L1
	CALL dijkstra
	MOVE T4 10
	MOVE L3 T4
	LOAD T5 i0
	MOVE L2 T5
LABEL(81)
	LE T6 L2 G0
	BNEQ(82) T6 0
	ADDI T8 L2 i1
	INDEX T9 L3 T8
	EQ T7 *T9 G3
	BNEQ(85) T7 0
	LOADSTRING T10 S0
	MOVE P0 T10
	CALL print
	MOVE T11 10
	JUMP(84)
LABEL(85)
	ADDI T12 L2 i1
	INDEX T13 L3 T12
	MOVE P0 *T13
	CALL toString
	MOVE T14 10
	MOVE P0 T14
	CALL print
	MOVE T15 10
LABEL(84)
	LOADSTRING T16 S1
	MOVE P0 T16
	CALL print
	MOVE T17 10
LABEL(83)
	ADDI L2 L2 i1
	JUMP(81)
LABEL(82)
	LOADSTRING T18 S2
	MOVE P0 T18
	CALL println
	MOVE T19 10
LABEL(80)
	ADDI L1 L1 i1
	JUMP(78)
LABEL(79)
	LOAD T20 i0
	MOVE 10 T20
	JUMP(77)
	.text
	.section	.rodata
	.align	2
.LS0:
	.string	"-1"
	.align	2
.LS1:
	.string	" "
	.align	2
.LS2:
	.string	""
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
	.globl	.G2
	.align	2
	.type	.G2, @object
	.size	.G2, 4
.G2:
	.zero	4
	.globl	.G3
	.align	2
	.type	.G3, @object
	.size	.G3, 4
.G3:
	.zero	4
	.text
	.align	2
	.globl	my_c_EdgeList_init
	.type	my_c_EdgeList_init, @function
my_c_EdgeList_init:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	lw	a0,-20(s0)
	sw	a0,-28(s0)
	lw	a0,-20(s0)
	call	my_array_alloc
	sw	a0,-32(s0)
.LAB2:
	lw	a0,-28(s0)
	beq	a0,zero,.LAB3
	li	a0,12
	call	malloc
	lw	a1,-32(s0)
	lw	a2,-28(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-28(s0)
	addi	a0,a0,-1
	sw	a0,-28(s0)
	j	.LAB2
.LAB3:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-32(s0)
	sw	a1,0(a0)
	lw	a0,-20(s0)
	sw	a0,-36(s0)
	lw	a0,-20(s0)
	call	my_array_alloc
	sw	a0,-40(s0)
.LAB4:
	lw	a0,-36(s0)
	beq	a0,zero,.LAB5
	lw	a0,-40(s0)
	lw	a1,-36(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-36(s0)
	addi	a0,a0,-1
	sw	a0,-36(s0)
	j	.LAB4
.LAB5:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-40(s0)
	sw	a1,0(a0)
	lw	a0,-16(s0)
	sw	a0,-44(s0)
	lw	a0,-16(s0)
	call	my_array_alloc
	sw	a0,-48(s0)
.LAB6:
	lw	a0,-44(s0)
	beq	a0,zero,.LAB7
	lw	a0,-48(s0)
	lw	a1,-44(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-44(s0)
	addi	a0,a0,-1
	sw	a0,-44(s0)
	j	.LAB6
.LAB7:
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	sw	a1,0(a0)
	li	a0,0
	sw	a0,-24(s0)
.LAB8:
	lw	a0,-24(s0)
	lw	a1,-20(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB9
	li	a0,1
	neg	a0,a0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB10:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB8
.LAB9:
	li	a0,0
	sw	a0,-24(s0)
.LAB11:
	lw	a0,-24(s0)
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB12
	li	a0,1
	neg	a0,a0
	li	a1,2
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-24(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
.LAB13:
	lw	a0,-24(s0)
	addi	a0,a0,1
	sw	a0,-24(s0)
	j	.LAB11
.LAB12:
	li	a0,0
	li	a1,3
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB1:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	my_c_EdgeList_init, .-my_c_EdgeList_init
	.text
	.align	2
	.globl	my_c_EdgeList_addEdge
	.type	my_c_EdgeList_addEdge, @function
my_c_EdgeList_addEdge:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	mv	a0,a2
	sw	a0,-20(s0)
	mv	a0,a3
	sw	a0,-24(s0)
	li	a0,12
	call	malloc
	sw	a0,-28(s0)
	li	a0,0
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
	li	a0,1
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	sw	a1,0(a0)
	li	a0,2
	lw	a1,-28(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	sw	a1,0(a0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,3
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a1,0(a1)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,3
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
	li	a0,3
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,2
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-16(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,3
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
.LAB14:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_EdgeList_addEdge, .-my_c_EdgeList_addEdge
	.text
	.align	2
	.globl	my_c_EdgeList_nVertices
	.type	my_c_EdgeList_nVertices, @function
my_c_EdgeList_nVertices:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_array_size
	j	.LAB15
.LAB15:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_EdgeList_nVertices, .-my_c_EdgeList_nVertices
	.text
	.align	2
	.globl	my_c_EdgeList_nEdges
	.type	my_c_EdgeList_nEdges, @function
my_c_EdgeList_nEdges:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_array_size
	j	.LAB16
.LAB16:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_EdgeList_nEdges, .-my_c_EdgeList_nEdges
	.text
	.align	2
	.globl	my_c_Array_Node_Array_Node
	.type	my_c_Array_Node_Array_Node, @function
my_c_Array_Node_Array_Node:
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
	li	a0,16
	mv	a1,a0
	sw	a1,-16(s0)
	call	my_array_alloc
	sw	a0,-20(s0)
.LAB18:
	lw	a0,-16(s0)
	beq	a0,zero,.LAB19
	li	a0,8
	call	malloc
	lw	a1,-20(s0)
	lw	a2,-16(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-16(s0)
	addi	a0,a0,-1
	sw	a0,-16(s0)
	j	.LAB18
.LAB19:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	sw	a1,0(a0)
.LAB17:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Array_Node_Array_Node, .-my_c_Array_Node_Array_Node
	.text
	.align	2
	.globl	my_c_Array_Node_push_back
	.type	my_c_Array_Node_push_back, @function
my_c_Array_Node_push_back:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-12(s0)
	call	my_c_Array_Node_size
	mv	a6,a0
	sw	a6,-20(s0)
	li	a0,0
	lw	a2,-12(s0)
	slli	a0,a0,2
	add	a0,a2,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a6,-20(s0)
	sub	a6,a6,a0
	seqz	a0,a6
	beq	a0,zero,.LAB21
	lw	a0,-12(s0)
	call	my_c_Array_Node_doubleStorage
.LAB21:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
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
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
.LAB20:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Array_Node_push_back, .-my_c_Array_Node_push_back
	.text
	.align	2
	.globl	my_c_Array_Node_pop_back
	.type	my_c_Array_Node_pop_back, @function
my_c_Array_Node_pop_back:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,-1
	sw	a1,0(a0)
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
	j	.LAB22
.LAB22:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_pop_back, .-my_c_Array_Node_pop_back
	.text
	.align	2
	.globl	my_c_Array_Node_back
	.type	my_c_Array_Node_back, @function
my_c_Array_Node_back:
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
	li	a2,1
	lw	a1,0(a1)
	sub	a1,a1,a2
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB23
.LAB23:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_back, .-my_c_Array_Node_back
	.text
	.align	2
	.globl	my_c_Array_Node_front
	.type	my_c_Array_Node_front, @function
my_c_Array_Node_front:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB24
.LAB24:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_front, .-my_c_Array_Node_front
	.text
	.align	2
	.globl	my_c_Array_Node_size
	.type	my_c_Array_Node_size, @function
my_c_Array_Node_size:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	j	.LAB25
.LAB25:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_size, .-my_c_Array_Node_size
	.text
	.align	2
	.globl	my_c_Array_Node_resize
	.type	my_c_Array_Node_resize, @function
my_c_Array_Node_resize:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
.LAB27:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_array_size
	lw	a1,-16(s0)
	slt	a0,a0,a1
	beq	a0,zero,.LAB28
	lw	a0,-12(s0)
	call	my_c_Array_Node_doubleStorage
	j	.LAB27
.LAB28:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
.LAB26:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_resize, .-my_c_Array_Node_resize
	.text
	.align	2
	.globl	my_c_Array_Node_get
	.type	my_c_Array_Node_get, @function
my_c_Array_Node_get:
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
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	j	.LAB29
.LAB29:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_get, .-my_c_Array_Node_get
	.text
	.align	2
	.globl	my_c_Array_Node_set
	.type	my_c_Array_Node_set, @function
my_c_Array_Node_set:
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
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-16(s0)
	sw	a1,0(a0)
.LAB30:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Array_Node_set, .-my_c_Array_Node_set
	.text
	.align	2
	.globl	my_c_Array_Node_swap
	.type	my_c_Array_Node_swap, @function
my_c_Array_Node_swap:
	addi	sp,sp,-32
	sw	s0,28(sp)
	addi	s0,sp,32
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	mv	a0,a2
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-12(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-20(s0)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,0
	lw	a2,-8(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a2,-12(s0)
	addi	a2,a2,1
	lw	a1,0(a1)
	slli	a2,a2,2
	add	a1,a1,a2
	lw	a0,0(a0)
	sw	a0,0(a1)
	li	a0,0
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a1,-20(s0)
	sw	a1,0(a0)
.LAB31:
	lw	s0,28(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Array_Node_swap, .-my_c_Array_Node_swap
	.text
	.align	2
	.globl	my_c_Array_Node_doubleStorage
	.type	my_c_Array_Node_doubleStorage, @function
my_c_Array_Node_doubleStorage:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
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
	lw	a0,-16(s0)
	call	my_array_size
	li	a1,2
	mul	a0,a0,a1
	mv	a1,a0
	sw	a1,-24(s0)
	call	my_array_alloc
	sw	a0,-28(s0)
.LAB33:
	lw	a0,-24(s0)
	beq	a0,zero,.LAB34
	li	a0,8
	call	malloc
	lw	a1,-28(s0)
	lw	a2,-24(s0)
	slli	a2,a2,2
	add	a1,a1,a2
	sw	a0,0(a1)
	lw	a0,-24(s0)
	addi	a0,a0,-1
	sw	a0,-24(s0)
	j	.LAB33
.LAB34:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	sw	a1,0(a0)
	li	a0,0
	li	a1,1
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB35:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-20(s0)
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB36
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	addi	a0,a0,1
	lw	a1,-16(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,0
	lw	a2,-12(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	li	a2,1
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
.LAB37:
	li	a0,1
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,0(a0)
	addi	a1,a1,1
	sw	a1,0(a0)
	j	.LAB35
.LAB36:
.LAB32:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Array_Node_doubleStorage, .-my_c_Array_Node_doubleStorage
	.text
	.align	2
	.globl	my_c_Heap_Node_Heap_Node
	.type	my_c_Heap_Node_Heap_Node, @function
my_c_Heap_Node_Heap_Node:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,8
	call	malloc
	mv	a6,a0
	sw	a6,-16(s0)
	call	my_c_Array_Node_Array_Node
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a6,-16(s0)
	mv	a1,a6
	sw	a1,0(a0)
.LAB38:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_Heap_Node, .-my_c_Heap_Node_Heap_Node
	.text
	.align	2
	.globl	my_c_Heap_Node_push
	.type	my_c_Heap_Node_push, @function
my_c_Heap_Node_push:
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
	lw	a1,-16(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_push_back
	lw	a0,-12(s0)
	call	my_c_Heap_Node_size
	li	a1,1
	sub	a0,a0,a1
	sw	a0,-20(s0)
.LAB40:
	li	a0,0
	lw	a1,-20(s0)
	sgt	a0,a1,a0
	beq	a0,zero,.LAB41
	lw	a0,-20(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_c_Heap_Node_pnt
	sw	a0,-24(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	mv	a6,a0
	sw	a6,-28(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	lw	a6,-28(s0)
	slt	a0,a6,a0
	xori	a0,a0,1
	beq	a0,zero,.LAB42
	j	.LAB41
.LAB42:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	mv	a2,a1
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_swap
	lw	a0,-24(s0)
	sw	a0,-20(s0)
	j	.LAB40
.LAB41:
.LAB39:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Heap_Node_push, .-my_c_Heap_Node_push
	.text
	.align	2
	.globl	my_c_Heap_Node_pop
	.type	my_c_Heap_Node_pop, @function
my_c_Heap_Node_pop:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_c_Array_Node_front
	sw	a0,-16(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a6,a1,a0
	sw	a6,-20(s0)
	li	a6,0
	sw	a6,-24(s0)
	lw	a0,-12(s0)
	call	my_c_Heap_Node_size
	li	a1,1
	sub	a0,a0,a1
	mv	a2,a0
	lw	a6,-24(s0)
	mv	a1,a6
	lw	a6,-20(s0)
	lw	a0,0(a6)
	call	my_c_Array_Node_swap
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_c_Array_Node_pop_back
	li	a0,0
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_c_Heap_Node_maxHeapify
	lw	a0,-16(s0)
	j	.LAB43
.LAB43:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	my_c_Heap_Node_pop, .-my_c_Heap_Node_pop
	.text
	.align	2
	.globl	my_c_Heap_Node_top
	.type	my_c_Heap_Node_top, @function
my_c_Heap_Node_top:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_c_Array_Node_front
	j	.LAB44
.LAB44:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_top, .-my_c_Heap_Node_top
	.text
	.align	2
	.globl	my_c_Heap_Node_size
	.type	my_c_Heap_Node_size, @function
my_c_Heap_Node_size:
	addi	sp,sp,-16
	sw	s0,12(sp)
	sw	ra,8(sp)
	addi	s0,sp,16
	sw	a0,-12(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	my_c_Array_Node_size
	j	.LAB45
.LAB45:
	lw	s0,12(sp)
	lw	ra,8(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_size, .-my_c_Heap_Node_size
	.text
	.align	2
	.globl	my_c_Heap_Node_lchild
	.type	my_c_Heap_Node_lchild, @function
my_c_Heap_Node_lchild:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	mul	a0,a1,a0
	li	a1,1
	add	a0,a0,a1
	j	.LAB46
.LAB46:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_lchild, .-my_c_Heap_Node_lchild
	.text
	.align	2
	.globl	my_c_Heap_Node_rchild
	.type	my_c_Heap_Node_rchild, @function
my_c_Heap_Node_rchild:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,2
	lw	a1,-12(s0)
	mul	a0,a1,a0
	li	a1,2
	add	a0,a0,a1
	j	.LAB47
.LAB47:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_rchild, .-my_c_Heap_Node_rchild
	.text
	.align	2
	.globl	my_c_Heap_Node_pnt
	.type	my_c_Heap_Node_pnt, @function
my_c_Heap_Node_pnt:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	mv	a0,a1
	sw	a0,-12(s0)
	li	a0,1
	lw	a1,-12(s0)
	sub	a0,a1,a0
	li	a1,2
	div	a0,a0,a1
	j	.LAB48
.LAB48:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Heap_Node_pnt, .-my_c_Heap_Node_pnt
	.text
	.align	2
	.globl	my_c_Heap_Node_maxHeapify
	.type	my_c_Heap_Node_maxHeapify, @function
my_c_Heap_Node_maxHeapify:
	addi	sp,sp,-48
	sw	s0,44(sp)
	sw	ra,40(sp)
	addi	s0,sp,48
	sw	a0,-12(s0)
	mv	a0,a1
	sw	a0,-16(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_c_Heap_Node_lchild
	sw	a0,-20(s0)
	lw	a0,-16(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_c_Heap_Node_rchild
	sw	a0,-24(s0)
	lw	a0,-16(s0)
	sw	a0,-28(s0)
	lw	a0,-12(s0)
	call	my_c_Heap_Node_size
	lw	a1,-20(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB51
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-20(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	mv	a6,a0
	sw	a6,-32(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	lw	a6,-32(s0)
	sgt	a0,a6,a0
	beq	a0,zero,.LAB51
	li	a0,1
	j	.LAB52
.LAB51:
	li	a0,0
.LAB52:
	beq	a0,zero,.LAB50
	lw	a0,-20(s0)
	sw	a0,-28(s0)
.LAB50:
	lw	a0,-12(s0)
	call	my_c_Heap_Node_size
	lw	a1,-24(s0)
	slt	a0,a1,a0
	beq	a0,zero,.LAB54
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-24(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	mv	a6,a0
	sw	a6,-36(s0)
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_get
	call	my_c_Node_key_
	lw	a6,-36(s0)
	sgt	a0,a6,a0
	beq	a0,zero,.LAB54
	li	a0,1
	j	.LAB55
.LAB54:
	li	a0,0
.LAB55:
	beq	a0,zero,.LAB53
	lw	a0,-24(s0)
	sw	a0,-28(s0)
.LAB53:
	lw	a0,-28(s0)
	lw	a1,-16(s0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB56
	j	.LAB49
.LAB56:
	li	a0,0
	lw	a1,-12(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-28(s0)
	mv	a2,a1
	lw	a1,-16(s0)
	lw	a0,0(a0)
	call	my_c_Array_Node_swap
	lw	a0,-28(s0)
	mv	a1,a0
	lw	a0,-12(s0)
	call	my_c_Heap_Node_maxHeapify
.LAB49:
	lw	s0,44(sp)
	lw	ra,40(sp)
	addi	sp,sp,48
	jr	ra
	.size	my_c_Heap_Node_maxHeapify, .-my_c_Heap_Node_maxHeapify
	.text
	.align	2
	.globl	init
	.type	init, @function
init:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	call	getInt
	lui	a1,%hi(.G0)
	sw	a0,%lo(.G0)(a1)
	call	getInt
	lui	a1,%hi(.G1)
	sw	a0,%lo(.G1)(a1)
	li	a0,16
	call	malloc
	lui	a1,%hi(.G2)
	sw	a0,%lo(.G2)(a1)
	lui	a0,%hi(.G1)
	lw	a0,%lo(.G1)(a0)
	mv	a2,a0
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	mv	a1,a0
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	my_c_EdgeList_init
	li	a0,0
	sw	a0,-16(s0)
.LAB58:
	lw	a0,-16(s0)
	lui	a1,%hi(.G1)
	lw	a1,%lo(.G1)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB59
	call	getInt
	sw	a0,-20(s0)
	call	getInt
	sw	a0,-24(s0)
	call	getInt
	sw	a0,-28(s0)
	lw	a0,-28(s0)
	mv	a3,a0
	lw	a0,-24(s0)
	mv	a2,a0
	lw	a0,-20(s0)
	mv	a1,a0
	lui	a0,%hi(.G2)
	lw	a0,%lo(.G2)(a0)
	call	my_c_EdgeList_addEdge
.LAB60:
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB58
.LAB59:
.LAB57:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	init, .-init
	.text
	.align	2
	.globl	my_c_Node_key_
	.type	my_c_Node_key_, @function
my_c_Node_key_:
	addi	sp,sp,-16
	sw	s0,12(sp)
	addi	s0,sp,16
	sw	a0,-8(s0)
	li	a0,1
	lw	a1,-8(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	neg	a0,a0
	j	.LAB61
.LAB61:
	lw	s0,12(sp)
	addi	sp,sp,16
	jr	ra
	.size	my_c_Node_key_, .-my_c_Node_key_
	.text
	.align	2
	.globl	dijkstra
	.type	dijkstra, @function
dijkstra:
	addi	sp,sp,-80
	sw	s0,76(sp)
	sw	ra,72(sp)
	addi	s0,sp,80
	sw	a0,-16(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	sw	a0,-64(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	call	my_array_alloc
	sw	a0,-68(s0)
.LAB63:
	lw	a0,-64(s0)
	beq	a0,zero,.LAB64
	lw	a0,-68(s0)
	lw	a1,-64(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-64(s0)
	addi	a0,a0,-1
	sw	a0,-64(s0)
	j	.LAB63
.LAB64:
	lw	a0,-68(s0)
	sw	a0,-20(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	sw	a0,-72(s0)
	lui	a0,%hi(.G0)
	lw	a0,%lo(.G0)(a0)
	call	my_array_alloc
	sw	a0,-76(s0)
.LAB65:
	lw	a0,-72(s0)
	beq	a0,zero,.LAB66
	lw	a0,-76(s0)
	lw	a1,-72(s0)
	slli	a1,a1,2
	add	a0,a0,a1
	mv	a1,zero
	sw	a1,0(a0)
	lw	a0,-72(s0)
	addi	a0,a0,-1
	sw	a0,-72(s0)
	j	.LAB65
.LAB66:
	lw	a0,-76(s0)
	sw	a0,-24(s0)
	li	a0,0
	sw	a0,-28(s0)
.LAB67:
	lw	a0,-28(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB68
	lw	a0,-28(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lui	a1,%hi(.G3)
	lw	a1,%lo(.G3)(a1)
	sw	a1,0(a0)
	li	a0,0
	lw	a1,-28(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
.LAB69:
	lw	a0,-28(s0)
	addi	a0,a0,1
	sw	a0,-28(s0)
	j	.LAB67
.LAB68:
	li	a0,0
	lw	a1,-16(s0)
	addi	a1,a1,1
	lw	a2,-24(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,4
	call	malloc
	mv	a6,a0
	sw	a6,-80(s0)
	call	my_c_Heap_Node_Heap_Node
	lw	a6,-80(s0)
	mv	a0,a6
	sw	a0,-32(s0)
	li	a0,8
	call	malloc
	sw	a0,-36(s0)
	li	a0,0
	li	a1,1
	lw	a2,-36(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,0
	lw	a1,-36(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-16(s0)
	sw	a1,0(a0)
	lw	a0,-36(s0)
	mv	a1,a0
	lw	a0,-32(s0)
	call	my_c_Heap_Node_push
.LAB70:
	lw	a0,-32(s0)
	call	my_c_Heap_Node_size
	li	a1,0
	sub	a0,a0,a1
	snez	a0,a0
	beq	a0,zero,.LAB71
	lw	a0,-32(s0)
	call	my_c_Heap_Node_pop
	sw	a0,-40(s0)
	li	a0,0
	lw	a1,-40(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	sw	a0,-44(s0)
	lw	a0,-44(s0)
	addi	a0,a0,1
	lw	a1,-20(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a0,0(a0)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB72
	j	.LAB70
.LAB72:
	li	a0,1
	lw	a1,-44(s0)
	addi	a1,a1,1
	lw	a2,-20(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	sw	a0,0(a1)
	li	a0,2
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-44(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-48(s0)
.LAB73:
	li	a0,1
	neg	a0,a0
	lw	a1,-48(s0)
	sub	a1,a1,a0
	snez	a0,a1
	beq	a0,zero,.LAB74
	li	a0,0
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-52(s0)
	li	a0,0
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	li	a1,2
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-56(s0)
	lw	a0,-44(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lw	a1,-56(s0)
	add	a0,a0,a1
	sw	a0,-60(s0)
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-60(s0)
	lw	a0,0(a0)
	slt	a0,a1,a0
	xori	a0,a0,1
	beq	a0,zero,.LAB76
	j	.LAB75
.LAB76:
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-60(s0)
	sw	a1,0(a0)
	li	a0,8
	call	malloc
	sw	a0,-40(s0)
	li	a0,0
	lw	a1,-40(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-52(s0)
	sw	a1,0(a0)
	lw	a0,-52(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	li	a1,1
	lw	a2,-40(s0)
	slli	a1,a1,2
	add	a1,a2,a1
	lw	a0,0(a0)
	sw	a0,0(a1)
	lw	a0,-40(s0)
	mv	a1,a0
	lw	a0,-32(s0)
	call	my_c_Heap_Node_push
.LAB75:
	li	a0,1
	lui	a1,%hi(.G2)
	lw	a1,%lo(.G2)(a1)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a1,-48(s0)
	addi	a1,a1,1
	lw	a0,0(a0)
	slli	a1,a1,2
	add	a0,a0,a1
	lw	a0,0(a0)
	sw	a0,-48(s0)
	j	.LAB73
.LAB74:
	j	.LAB70
.LAB71:
	lw	a0,-24(s0)
	j	.LAB62
.LAB62:
	lw	s0,76(sp)
	lw	ra,72(sp)
	addi	sp,sp,80
	jr	ra
	.size	dijkstra, .-dijkstra
	.text
	.align	2
	.globl	main
	.type	main, @function
main:
	addi	sp,sp,-32
	sw	s0,28(sp)
	sw	ra,24(sp)
	addi	s0,sp,32
	li	a0,10000000
	lui	a1,%hi(.G3)
	sw	a0,%lo(.G3)(a1)
	call	init
	li	a0,0
	sw	a0,-16(s0)
.LAB78:
	lw	a0,-16(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB79
	lw	a0,-16(s0)
	call	dijkstra
	sw	a0,-24(s0)
	li	a0,0
	sw	a0,-20(s0)
.LAB81:
	lw	a0,-20(s0)
	lui	a1,%hi(.G0)
	lw	a1,%lo(.G0)(a1)
	slt	a0,a0,a1
	beq	a0,zero,.LAB82
	lw	a0,-20(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	lui	a1,%hi(.G3)
	lw	a1,%lo(.G3)(a1)
	sub	a0,a0,a1
	seqz	a0,a0
	beq	a0,zero,.LAB85
	lui	a0,%hi(.LS0)
	addi	a0,a0,%lo(.LS0)
	call	print
	j	.LAB84
.LAB85:
	lw	a0,-20(s0)
	addi	a0,a0,1
	lw	a1,-24(s0)
	slli	a0,a0,2
	add	a0,a1,a0
	lw	a0,0(a0)
	call	toString
	call	print
.LAB84:
	lui	a0,%hi(.LS1)
	addi	a0,a0,%lo(.LS1)
	call	print
.LAB83:
	lw	a0,-20(s0)
	addi	a0,a0,1
	sw	a0,-20(s0)
	j	.LAB81
.LAB82:
	lui	a0,%hi(.LS2)
	addi	a0,a0,%lo(.LS2)
	call	println
.LAB80:
	lw	a0,-16(s0)
	addi	a0,a0,1
	sw	a0,-16(s0)
	j	.LAB78
.LAB79:
	li	a0,0
	j	.LAB77
.LAB77:
	lw	s0,28(sp)
	lw	ra,24(sp)
	addi	sp,sp,32
	jr	ra
	.size	main, .-main
