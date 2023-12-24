;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Print)
(use Inventory)
(use User)
(use System)

(public
	proc5_0 0
	HandsOff 1
	HandsOn 2
	proc5_3 3
	proc5_4 4
	IsFlag 5
	SetFlag 6
	ClearFlag 7
	proc5_8 8
	proc5_9 9
	proc5_10 10
	proc5_11 11
	proc5_12 12
	proc5_13 13
	proc5_14 14
	proc5_15 15
)

(local
	local0
	[local1 4]
)

(procedure (HandsOff)
	(if (not global122)
		(User canControl: 0 canInput: 0)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
	)
	(++ global122)
)

(procedure (HandsOn param1 &tmp temp0 temp1)
	(if (or (and argc param1) (<= (-- global122) 0))
		(= global122 0)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable:)
		(= temp0
			(if (= temp1 (gTheIconBar curIcon:))
				(temp1 cursor:)
			else
				999
			)
		)
		(gGame setCursor: temp0 1)
	)
)

(procedure (proc5_3 param1)
	(return (u> (MemoryInfo 1) param1)) ; FreeHeap
)

(procedure (proc5_4 param1 param2) ; UNUSED
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (localproc_0 param1 param2) ; UNUSED
	(param1 param2: &rest)
)

(procedure (IsFlag param1)
	(return (& [global250 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global250 (/ param1 16)]
		(| [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
	)
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(= [global250 (/ param1 16)]
		(& [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	)
	(return temp0)
)

(procedure (proc5_13 param1 param2 param3 param4 &tmp temp0 [temp1 100])
	(if (u< (= temp0 param4) 1000)
		(= temp0 @temp1)
		(Format @temp1 param4 &rest)
	)
	(TextSize @[local1 0] temp0 param2 param3)
)

(procedure (proc5_8 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (>= argc 6)
		(= temp4 param6)
	else
		(= temp4 gUserFont)
	)
	(if (and (>= argc 5) (!= param5 -1))
		(proc5_13 0 temp4 0 param1)
		(= temp0 (+ param3 [local1 1]))
		(= temp1 (+ param4 [local1 0]))
		(= temp2 (+ param3 [local1 3] 1))
		(= temp3 (+ param4 [local1 2]))
		(Graph grFILL_BOX temp1 temp0 temp3 temp2 1 param5 -1 -1)
	)
	(Display
		param1
		dsCOORD
		(+ param3 1)
		param4
		dsCOLOR
		(+ param2 2)
		dsALIGN
		alLEFT
		dsFONT
		temp4
		&rest
	)
	(Display param1 dsCOORD param3 param4 dsCOLOR param2 dsALIGN alLEFT dsFONT temp4 &rest)
)

(procedure (proc5_10 param1) ; UNUSED
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Prints &rest 64 -1 12 22 param1 111)
)

(procedure (proc5_12 param1 &tmp temp0 temp1)
	(= temp1 (gTheIconBar useIconItem:))
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar enable: temp1)
	)
	(= temp0 (Inv at: param1))
	(gTheIconBar curInvIcon: temp0 select: temp1 curIcon: temp1)
	(temp1 cursor: (temp0 cursor:))
	(gGame setCursor: (temp0 cursor:) 1)
)

(procedure (proc5_14 param1 param2)
	(if (== argc 2)
		(param1 init: dummyClient 0 param2)
	else
		(param1 init: dummyClient 0 0)
	)
	(gTheIconBar disable:)
	(while (param1 client:)
		(param1 doit:)
		(gGame doit:)
	)
	(gTheIconBar enable:)
	(param1 dispose:)
)

(procedure (proc5_15 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4) ; UNUSED
	(= temp1 (Min param1 param3))
	(= temp0 (Min param2 param4))
	(= temp3 (Max param1 param3))
	(= temp2 (Max param2 param4))
	(if (<= param1 param3)
		(Graph grDRAW_LINE param2 param1 param4 param3 param5 -1 -1)
	else
		(Graph grDRAW_LINE param4 param3 param2 param1 param5 -1 -1)
	)
	(Graph grUPDATE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
)

(procedure (proc5_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(if (<= param1 param3)
		(Graph grDRAW_LINE param2 param1 param4 param3 0 -1 -1)
	else
		(Graph grDRAW_LINE param4 param3 param2 param1 0 -1 -1)
	)
	(= temp1 (Min param1 param3))
	(= temp0 (Min param2 param4))
	(= temp3 (Max param1 param3))
	(= temp2 (Max param2 param4))
	(Graph grUPDATE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
)

(procedure (proc5_11 &tmp temp0 temp1) ; UNUSED
	(= gScore 0)
	(for ((= temp0 0)) (< temp0 26) ((++ temp0))
		(= temp1 (/ [global135 temp0] 1000))
		(+= gScore temp1)
		(cond
			((== [global135 temp0] 0) 0)
			((<= temp1 5)
				(++ global119)
			)
			((<= temp1 10)
				(++ global120)
			)
			((<= temp1 15)
				(++ global121)
			)
		)
	)
)

(procedure (proc5_9 param1 &tmp temp0 temp1)
	(= temp0 (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
	(= temp1 (- (param1 nsBottom:) 1))
	(gGame setCursor: gTheCursor 1 temp0 temp1)
)

(class dummyClient of Obj
	(properties
		script 0
	)
)

