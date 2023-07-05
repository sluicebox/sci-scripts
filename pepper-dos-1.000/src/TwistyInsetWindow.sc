;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 889)
(include sci.sh)
(use TwistyWindow)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 &tmp temp0 temp1)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) param13 param5 param12)
	(-= param1 param10)
	(-= param2 param10)
	(+= param4 param10)
	(+= param3 param10)
	(Graph grFILL_BOX param1 param2 (+ param1 param10) param4 param13 param6 param12)
	(Graph grFILL_BOX (- param3 param10) param2 param3 param4 param13 param8 param12)
	(for ((= temp1 0)) (< temp1 param10) ((++ temp1))
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(+ param2 temp1)
			(- param3 (+ temp1 1))
			(+ param2 temp1)
			param7
			param12
			-1
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(- param4 (+ temp1 1))
			(- param3 (+ temp1 1))
			(- param4 (+ temp1 1))
			param9
			param12
			-1
		)
	)
	(if param11
		(Graph
			grFILL_BOX
			(+ param1 param11)
			param4
			(+ param3 param11)
			(+ param4 param11)
			param13
			0
			param12
		)
		(Graph
			grFILL_BOX
			param3
			(+ param2 param11)
			(+ param3 param11)
			param4
			param13
			0
			param12
		)
	)
	(SetPort temp0)
)

(procedure (localproc_1 param1 &tmp temp0 temp1) ; UNUSED
	(= temp1
		(cond
			((> (param1 bottom:) 185)
				(- 185 (param1 bottom:))
			)
			((< (param1 top:) 10)
				(- 10 (param1 top:))
			)
			(else 0)
		)
	)
	(= temp0
		(cond
			((> (param1 right:) 315)
				(- 315 (param1 right:))
			)
			((< (param1 left:) 5)
				(- 5 (param1 left:))
			)
			(else 0)
		)
	)
	(param1
		top: (+ (param1 top:) temp1)
		bottom: (+ (param1 bottom:) temp1)
		left: (+ (param1 left:) temp0)
		right: (+ (param1 right:) temp0)
	)
)

(class TwistyInsetWindow of TwistyWindow
	(properties
		ck 3
		topBordColor 5
		lftBordColor 4
		botBordColor 1
		rgtBordColor 2
		insideColor 2
		topBordColor2 0
		lftBordColor2 1
		botBordColor2 5
		rgtBordColor2 4
		topBordHgt 10
		botBordHgt 24
		sideBordWid 2
		shadWid 0
		bevWid 2
		bevelWid 3
		shadowWid 2
		xOffset 0
		yOffset 0
	)

	(method (open param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (and argc param1)
			(= temp6 1)
		else
			(= temp6 0)
		)
		(= temp0 1)
		(if (!= priority -1)
			(|= temp0 $0002)
		)
		(= temp2 top)
		(= temp3 left)
		(= temp4 bottom)
		(= temp5 right)
		(-= top (+ bevelWid topBordHgt))
		(-= left (+ bevelWid sideBordWid))
		(+= bottom (+ bevelWid botBordHgt))
		(+= right (+ bevelWid sideBordWid))
		(= xOffset (+ bevelWid sideBordWid))
		(= yOffset (+ bevelWid topBordHgt))
		(if (not temp6)
			(super open:)
		)
		(localproc_0
			temp2
			temp3
			temp4
			temp5
			insideColor
			topBordColor2
			lftBordColor2
			botBordColor2
			rgtBordColor2
			bevWid
			shadWid
			priority
			temp0
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- temp2 bevWid)
			(- temp3 bevWid)
			(+ temp4 bevWid)
			(+ temp5 bevWid)
			1
		)
		(SetPort temp1)
	)
)

