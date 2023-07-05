;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 981)
(include sci.sh)
(use SysWindow)

(class myWindow of SysWindow
	(properties
		back 7
		underBits 0
		lineColor 0
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp5 (CelHigh 944 0 0))
		(= temp6 (CelWide 944 0 0))
		(SetPort 0)
		(= temp1 (- top 8))
		(= temp2 (- left 8))
		(= temp3 (+ bottom 8))
		(= temp4 (+ right 8))
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= underBits (Graph grSAVE_BOX temp1 temp2 (+ temp3 2) (+ temp4 2) temp0))
		(Graph
			grFILL_BOX
			(+ temp1 2)
			(+ temp2 2)
			(+ temp3 2)
			(+ temp4 2)
			temp0
			0
			priority
		)
		(Graph grFILL_BOX temp1 temp2 temp3 temp4 temp0 back priority)
		(DrawCel 944 0 0 temp2 temp1 -1)
		(DrawCel 944 0 1 temp2 (- temp3 temp5) -1)
		(DrawCel 944 0 2 (- temp4 temp5) temp1 -1)
		(DrawCel 944 0 3 (- temp4 temp5) (- temp3 temp5) -1)
		(Graph grDRAW_LINE temp1 (+ temp2 temp6) temp1 (- temp4 temp6) lineColor -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 2)
			(+ temp2 temp6)
			(+ temp1 2)
			(- temp4 temp6)
			lineColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 1)
			(+ temp2 temp6)
			(- temp3 1)
			(- temp4 temp6)
			lineColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 3)
			(+ temp2 temp6)
			(- temp3 3)
			(- temp4 temp6)
			lineColor
			-1
			-1
		)
		(Graph grDRAW_LINE (+ temp1 temp5) temp2 (- temp3 temp5) temp2 lineColor -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(+ temp2 2)
			(- temp3 temp5)
			(+ temp2 2)
			lineColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(- temp4 1)
			(- temp3 temp5)
			(- temp4 1)
			lineColor
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(- temp4 3)
			(- temp3 temp5)
			(- temp4 3)
			lineColor
			-1
			-1
		)
		(Graph grUPDATE_BOX temp1 temp2 (+ temp3 2) (+ temp4 2) 1)
		(= type 129)
		(super open:)
		(= top temp1)
		(= left temp2)
		(= bottom (+ temp3 2))
		(= right (+ temp4 2))
	)

	(method (dispose)
		(SetPort 0)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(if eraseOnly
				(Graph grUPDATE_BOX top left bottom right 1)
			else
				(Graph grREDRAW_BOX top left bottom right 1)
			)
		)
		(super dispose:)
	)
)

