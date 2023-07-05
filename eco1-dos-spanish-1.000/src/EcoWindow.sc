;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 817)
(include sci.sh)
(use Window)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grFILL_BOX param1 (- param2 3) param3 (+ param4 4) 2 -1 15)
	(Graph grFILL_BOX (- param1 3) param2 (+ param3 4) param4 2 -1 15)
	(Graph grFILL_BOX param1 param2 (+ param3 1) (+ param4 1) param10 param5 param9)
	(Graph grDRAW_LINE (- param1 1) (+ param2 7) (- param1 1) (- param4 3) param6 -1 -1)
	(Graph grDRAW_LINE (- param1 2) (+ param2 7) (- param1 2) (- param4 3) param7 -1 -1)
	(Graph grDRAW_LINE (- param1 3) (+ param2 7) (- param1 3) (- param4 3) param8 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 1) (- param3 5) (- param2 1) param6 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 2) (- param3 5) (- param2 2) param7 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 3) (- param3 5) (- param2 3) param8 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 1) (- param3 5) (+ param4 1) param6 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 2) (- param3 5) (+ param4 2) param7 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 3) (- param3 5) (+ param4 3) param8 -1 -1)
	(Graph grDRAW_LINE (+ param3 1) (+ param2 5) (+ param3 1) (- param4 3) param6 -1 -1)
	(Graph grDRAW_LINE (+ param3 2) (+ param2 5) (+ param3 2) (- param4 3) param7 -1 -1)
	(Graph grDRAW_LINE (+ param3 3) (+ param2 5) (+ param3 3) (- param4 3) param8 -1 -1)
	(DrawCel 955 0 0 (- param2 11) (- param1 7) -1)
	(DrawCel 955 1 0 (- param4 7) (- param1 7) -1)
	(DrawCel 955 0 1 (- param2 3) (- param3 4) -1)
	(DrawCel 955 1 1 (- param4 4) (- param3 4) -1)
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
			((> (param1 right:) 307)
				(- 307 (param1 right:))
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

(class EcoWindow of SysWindow
	(properties
		back 5
		underBits 0
		pUnderBits 0
		leftUnderBits 0
		rightUnderBits 0
		innerBordColor 7
		midBordColor 6
		outerBordColor 4
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
	)

	(method (open &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= priority -1)
			(|= temp1 $0002)
		)
		(localproc_1 self)
		(= lsTop (- top 3))
		(= lsLeft (- left 3))
		(= lsRight (+ right 4))
		(= lsBottom (+ bottom 4))
		(= underBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 1))
		(= rightUnderBits
			(Graph grSAVE_BOX (- top 7) (- right 9) (+ top 10) (+ right 12) 1)
		)
		(= leftUnderBits
			(Graph grSAVE_BOX (- top 7) (- left 11) (+ top 10) (+ left 9) 1)
		)
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
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(-= top 3)
		(-= right 3)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX leftUnderBits)
		(Graph grRESTORE_BOX rightUnderBits)
		(Graph grRESTORE_BOX pUnderBits)
		(if eraseOnly
			(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		else
			(Graph grREDRAW_BOX lsTop lsLeft lsBottom lsRight)
		)
		(Graph grUPDATE_BOX (- top 7) (- right 9) (+ top 13) (+ right 12) 1)
		(Graph grUPDATE_BOX (- top 7) (- left 11) (+ top 13) (+ left 9) 1)
		(if window
			(DisposeWindow window eraseOnly)
			(= window 0)
		)
		(DisposeClone self)
	)
)

