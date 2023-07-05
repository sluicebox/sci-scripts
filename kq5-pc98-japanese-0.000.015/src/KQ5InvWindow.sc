;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 757)
(include sci.sh)
(use Main)
(use KQ5Window)
(use BorderWindow)

(class KQ5InvWindow of InsetWindow
	(properties
		back 22
		priority -1
		topBordColor 22
		lftBordColor 22
		rgtBordColor 22
		botBordColor 22
		insideColor 22
		topBordColor2 22
		lftBordColor2 22
		botBordColor2 22
		rgtBordColor2 22
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(= color (KQ5Window color:))
		(= back (KQ5Window back:))
		(= insideColor (KQ5Window back:))
		(= topBordColor (KQ5Window back:))
		(= lftBordColor (KQ5Window back:))
		(= rgtBordColor (KQ5Window back:))
		(= botBordColor (KQ5Window back:))
		(= insideColor (KQ5Window back:))
		(= topBordColor2 (KQ5Window back:))
		(= lftBordColor2 (KQ5Window back:))
		(= botBordColor2 (KQ5Window back:))
		(= rgtBordColor2 (KQ5Window back:))
		(= shadowWid 0)
		(super open:)
		(= temp7 (KQ5Window lineColor:))
		(= temp5 (CelHigh 944 0 0))
		(= temp6 (CelWide 944 0 0))
		(= temp1 lsTop)
		(= temp2 lsLeft)
		(= temp3 lsBottom)
		(= temp4 lsRight)
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= temp8 (GetPort))
		(SetPort 0)
		(DrawCel 944 0 0 temp2 temp1 -1)
		(DrawCel 944 0 1 temp2 (- temp3 temp5) -1)
		(DrawCel 944 0 2 (- temp4 temp5) temp1 -1)
		(DrawCel 944 0 3 (- temp4 temp5) (- temp3 temp5) -1)
		(Graph grDRAW_LINE temp1 (+ temp2 temp6) temp1 (- temp4 temp6) temp7 -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 2)
			(+ temp2 temp6)
			(+ temp1 2)
			(- temp4 temp6)
			temp7
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 1)
			(+ temp2 temp6)
			(- temp3 1)
			(- temp4 temp6)
			temp7
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(- temp3 3)
			(+ temp2 temp6)
			(- temp3 3)
			(- temp4 temp6)
			temp7
			-1
			-1
		)
		(Graph grDRAW_LINE (+ temp1 temp5) temp2 (- temp3 temp5) temp2 temp7 -1 -1)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(+ temp2 2)
			(- temp3 temp5)
			(+ temp2 2)
			temp7
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(- temp4 1)
			(- temp3 temp5)
			(- temp4 1)
			temp7
			-1
			-1
		)
		(Graph
			grDRAW_LINE
			(+ temp1 temp5)
			(- temp4 3)
			(- temp3 temp5)
			(- temp4 3)
			temp7
			-1
			-1
		)
		(Graph grUPDATE_BOX temp1 temp2 (+ temp3 3) (+ temp4 3) 1)
		(SetPort temp8)
	)
)

