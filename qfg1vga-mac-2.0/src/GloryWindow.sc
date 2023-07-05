;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 559)
(include sci.sh)
(use Window)

(public
	GloryWindow 0
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph
		grFILL_BOX
		param1
		(- param2 13)
		(+ param3 1)
		(+ param4 14)
		param10
		param5
		param9
	)
	(Graph grDRAW_LINE (- param1 1) param2 (- param1 1) param4 69 param9 -1)
	(Graph grDRAW_LINE (- param1 2) param2 (- param1 2) param4 66 param9 -1)
	(Graph grDRAW_LINE (- param1 3) param2 (- param1 3) param4 67 param9 -1)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 1)
		(- param3 10)
		(- param2 1)
		param6
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 2)
		(- param3 10)
		(- param2 2)
		param7
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 13)
		(- param3 10)
		(- param2 13)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 12)
		(- param3 10)
		(- param2 12)
		66
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 11)
		(- param3 10)
		(- param2 11)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 10)
		(- param3 10)
		(- param2 10)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(- param2 9)
		(- param3 10)
		(- param2 9)
		param7
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 1)
		(- param3 10)
		(+ param4 1)
		param6
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 2)
		(- param3 10)
		(+ param4 2)
		param7
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 13)
		(- param3 10)
		(+ param4 13)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 12)
		(- param3 10)
		(+ param4 12)
		66
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 11)
		(- param3 10)
		(+ param4 11)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 10)
		(- param3 10)
		(+ param4 10)
		67
		param9
		-1
	)
	(Graph
		grDRAW_LINE
		(+ param1 10)
		(+ param4 9)
		(- param3 10)
		(+ param4 9)
		param7
		param9
		-1
	)
	(Graph grDRAW_LINE (+ param3 1) param2 (+ param3 1) param4 69 param9 -1)
	(Graph grDRAW_LINE (+ param3 2) param2 (+ param3 2) param4 66 param9 -1)
	(Graph grDRAW_LINE (+ param3 3) param2 (+ param3 3) param4 67 param9 -1)
	(DrawCel 995 9 0 (- param2 20) (- param1 3) param9)
	(DrawCel 995 9 1 (+ param4 1) (- param1 3) param9)
	(DrawCel 995 9 2 (- param2 20) (- param3 9) param9)
	(DrawCel 995 9 3 (+ param4 1) (- param3 9) param9)
	(SetPort temp0)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
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

(class GloryWindow of SysWindow
	(properties
		color 66
		back 69
		underBits 0
		pUnderBits 0
		innerBordColor 68
		midBordColor 70
		outerBordColor 69
		yOffset 0
	)

	(method (open &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= priority -1)
			(|= temp1 $0002)
		)
		(localproc_1 self)
		(-= top yOffset)
		(= lsTop (- top 3))
		(= lsLeft (- left 20))
		(= lsRight (+ right 21))
		(= lsBottom (+ bottom 4))
		(= underBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 1))
		(= pUnderBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 2))
		(localproc_0
			top
			left
			bottom
			right
			back
			innerBordColor
			midBordColor
			outerBordColor
			priority
			temp1
		)
		(Graph grUPDATE_BOX (- top 7) (- right 11) (+ top 13) (+ right 12) 1)
		(Graph grUPDATE_BOX (- top 7) (- left 11) (+ top 13) (+ left 11) 1)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(+= bottom 4)
		(+= right 4)
		(= type 131)
		(super open:)
	)

	(method (dispose)
		(-= top 3)
		(-= right 3)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX pUnderBits)
		(if eraseOnly
			(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		else
			(Graph grREDRAW_BOX lsTop lsLeft lsBottom lsRight)
		)
		(Graph grUPDATE_BOX (- top 7) (- right 9) (+ top 13) (+ right 15) 1)
		(Graph grUPDATE_BOX (- top 7) (- left 11) (+ top 13) (+ left 9) 1)
		(if window
			(DisposeWindow window eraseOnly)
			(= window 0)
		)
		(DisposeClone self)
	)
)

