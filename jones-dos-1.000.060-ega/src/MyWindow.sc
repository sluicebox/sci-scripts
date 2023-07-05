;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Game)

(class MyWindow of SysWindow
	(properties
		color 200
		back 41
		priority 50
		type 129
		underBits 0
		view 100
		vColor 100
		pPort 0
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp7 (CelHigh view 0 0))
		(= temp5 (CelHigh view 0 1))
		(= temp6 (CelHigh view 1 0))
		(= temp8 (CelWide view 0 0))
		(= pPort (GetPort))
		(SetPort 0)
		(= temp1 (- top 8))
		(= temp2 (- left 8))
		(= temp3 (+ bottom 8))
		(= temp4 (+ right 8))
		(= temp0 1)
		(= underBits (Graph grSAVE_BOX temp1 temp2 temp3 temp4 1))
		(Graph grFILL_BOX temp1 temp2 temp3 temp4 temp0 back priority)
		(DrawCel view 0 0 temp2 temp1 -1)
		(DrawCel view 0 1 temp2 (- temp3 temp5) -1)
		(DrawCel view 1 0 (- temp4 temp6) temp1 -1)
		(DrawCel view 1 2 (- temp4 temp6) (- temp3 temp5) -1)
		(Graph grDRAW_LINE temp1 (+ temp2 temp8) temp1 (- temp4 temp8) vColor -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 2)
			(+ temp2 temp8)
			(+ temp1 2)
			(- temp4 temp8)
			vColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 1)
			(+ temp2 temp8)
			(- temp3 1)
			(- temp4 temp8)
			vColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 3)
			(+ temp2 temp8)
			(- temp3 3)
			(- temp4 temp8)
			vColor
			-1
			-1
		)
		(Graph grDRAW_LINE (+ temp1 temp7) temp2 (- temp3 temp7) temp2 vColor -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(+ temp2 2)
			(- temp3 temp7)
			(+ temp2 2)
			vColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 1)
			(- temp3 temp7)
			(- temp4 1)
			vColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp7)
			(- temp4 3)
			(- temp3 temp7)
			(- temp4 3)
			vColor
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
		(Graph grUPDATE_BOX (- top 8) (- left 8) (+ bottom 8) (+ right 8) 1)
		(SetPort pPort)
		(DisposeWindow window)
		(DisposeClone self)
	)
)

