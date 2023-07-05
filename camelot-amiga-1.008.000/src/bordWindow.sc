;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 918)
(include sci.sh)
(use Save)

(class bordWindow of SysWindow
	(properties
		color 15
		back 8
		type 129
		underBits 0
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp7 (CelHigh 657 0 0))
		(= temp5 (CelHigh 657 0 1))
		(= temp6 (CelHigh 657 1 0))
		(= temp8 (CelWide 657 0 0))
		(SetPort 0)
		(= temp1 (- top 8))
		(= temp2 (- left 10))
		(= temp3 (+ bottom 8))
		(= temp4 (+ right 10))
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= underBits (Graph grSAVE_BOX temp1 temp2 temp3 temp4 temp0))
		(Graph grFILL_BOX temp1 temp2 temp3 temp4 temp0 back priority)
		(DrawCel 657 0 0 temp2 temp1 -1)
		(DrawCel 657 0 1 temp2 (- temp3 temp5) -1)
		(DrawCel 657 1 0 (- temp4 temp6) temp1 -1)
		(DrawCel 657 1 2 (- temp4 temp6) (- temp3 temp5) -1)
		(Graph
			grDRAW_LINE
			(+ temp1 2)
			(+ temp2 temp8)
			(+ temp1 2)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 3)
			(+ temp2 temp8)
			(+ temp1 3)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 3)
			(+ temp2 temp8)
			(- temp3 3)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 4)
			(+ temp2 temp8)
			(- temp3 4)
			(- temp4 temp8)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(+ temp2 2)
			(- temp3 temp7)
			(+ temp2 2)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(+ temp2 3)
			(- temp3 temp7)
			(+ temp2 3)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 3)
			(- temp3 temp7)
			(- temp4 3)
			31
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 4)
			(- temp3 temp7)
			(- temp4 4)
			31
			-1
			-1
		)
		(Graph grUPDATE_BOX temp1 temp2 temp3 temp4 1)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grREDRAW_BOX (- top 8) (- left 10) (+ bottom 8) (+ right 10))
		(DisposeWindow window)
		(DisposeClone self)
	)
)

