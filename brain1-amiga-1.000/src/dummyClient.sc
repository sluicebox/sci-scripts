;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use Inventory)
(use User)
(use System)

(public
	proc5_0 0
	proc5_1 1
	proc5_2 2
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
	proc5_16 16
	proc5_17 17
	proc5_18 18
	proc5_19 19
	proc5_20 20
	proc5_21 21
)

(local
	local0
	[local1 4]
)

(procedure (proc5_0 param1 param2 &tmp temp0 temp1)
	(if (not (= temp0 (IsFlag param1)))
		(= temp1 (if (> argc 1) param2 else global114))
		(SetFlag param1)
		(++ global115)
		(++ [global119 temp1])
		(if (not (gEgo has: 0))
			(gEgo get: 0)
		)
	)
	(return temp0)
)

(procedure (proc5_1)
	(if (not global122)
		(User canControl: 0 canInput: 0)
		(gTheIconBar disable:)
		(gGame setCursor: 50 1)
	)
	(++ global122)
)

(procedure (proc5_2 param1 &tmp temp0 temp1)
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
	(|= [global250 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global250 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (proc5_19 param1 param2 param3 param4 &tmp temp0 [temp1 100])
	(if (u< (= temp0 param4) 1000)
		(= temp0 @temp1)
		(Format @temp1 param4 &rest)
	)
	(if param1
		(= local0 (StrLen temp0))
	else
		(TextSize @[local1 0] temp0 param2 param3)
		(= global177 (- [local1 3] [local1 1]))
		(= global178 (- [local1 2] [local1 0]))
		(return global177)
	)
)

(procedure (proc5_8 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (>= argc 6)
		(= temp4 param6)
	else
		(= temp4 gUserFont)
	)
	(if (and (>= argc 5) (!= param5 -1))
		(proc5_19 0 temp4 0 param1)
		(= temp0 (+ param3 [local1 1]))
		(= temp1 (+ param4 [local1 0]))
		(= temp2 (+ param3 [local1 3] 1))
		(= temp3 (+ param4 [local1 2]))
		(Graph grFILL_BOX temp1 temp0 temp3 temp2 1 param5 -1 -1)
	)
	(if (IsFlag 0)
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
	)
	(Display param1 dsCOORD param3 param4 dsCOLOR param2 dsALIGN alLEFT dsFONT temp4 &rest)
)

(procedure (proc5_9)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Print &rest #at -1 12)
)

(procedure (proc5_14 &tmp [temp0 500])
	(Format @temp0 &rest)
	(Print @temp0 #at -1 12)
)

(procedure (proc5_10 param1)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Print &rest #at -1 12 #time param1 #dispose)
)

(procedure (proc5_11 param1 &tmp temp0)
	(proc5_19 0 gUserFont 0 param1 &rest)
	(= temp0 [local1 2])
	(Print param1 &rest #at -1 (- 170 temp0))
)

(procedure (proc5_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if (== argc 1)
		(Display 5 0 dsRESTOREPIXELS [param1 0])
	else
		(= temp4 (= temp5 -1))
		(= temp0 1)
		(= temp1 70)
		(= temp2 73)
		(= temp3 160)
		(= temp6 18)
		(= temp7 17)
		(for ((= temp8 1)) (< temp8 argc) ((++ temp8))
			(switch [param1 temp8]
				(30
					(= temp0 [param1 (++ temp8)])
				)
				(33
					(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
				)
				(70
					(= temp3 [param1 (++ temp8)])
				)
				(67
					(= temp4 [param1 (++ temp8)])
					(= temp5 [param1 (++ temp8)])
				)
				(28
					(= temp6 [param1 (++ temp8)])
				)
				(29
					(= temp7 [param1 (++ temp8)])
				)
			)
		)
		(= temp8
			(Display
				[param1 0]
				dsCOORD
				temp4
				temp5
				dsCOLOR
				temp7
				dsWIDTH
				temp3
				dsALIGN
				temp0
				dsFONT
				temp2
				dsSAVEPIXELS
			)
		)
		(Display
			[param1 0]
			dsCOORD
			temp4
			temp5
			dsCOLOR
			temp6
			dsWIDTH
			temp3
			dsALIGN
			temp0
			dsFONT
			temp1
		)
		(return temp8)
	)
)

(procedure (proc5_13 param1 &tmp temp0 temp1)
	(= temp1 (gTheIconBar useIconItem:))
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar enable: temp1)
	)
	(= temp0 (Inv at: param1))
	(gTheIconBar curInvIcon: temp0 select: temp1 curIcon: temp1)
	(temp1 cursor: (temp0 cursor:))
	(gGame setCursor: (temp0 cursor:) 1)
)

(procedure (proc5_15 param1 param2)
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

(procedure (proc5_16 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4)
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

(procedure (proc5_17 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
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

(procedure (proc5_18)
	(if
		(<
			(= gScore
				(-
					(= gScore
						(+
							(* global121 5)
							(* global120 4)
							(* global119 3)
							(* global115 2)
						)
					)
					global123
				)
			)
			0
		)
		(= global123 gScore)
		(= gScore 0)
	)
)

(procedure (proc5_20 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (CelWide (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp2 (CelHigh (param1 view:) (param1 loop:) (param1 cel:)))
	(= temp1 (+ (param1 nsLeft:) (/ temp0 2)))
	(= temp3 (- (+ (param1 nsTop:) temp2) 1))
	(gGame setCursor: gTheCursor 1 temp1 temp3)
)

(procedure (proc5_21 &tmp [temp0 500])
	(Format @temp0 &rest)
	(Print @temp0 #at -1 130)
)

(class dummyClient of Obj
	(properties
		script 0
	)
)

