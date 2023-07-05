;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Window)

(public
	GloryWindow 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph
		grFILL_BOX
		(- param1 3)
		(- param2 20)
		(+ param3 4)
		(+ param4 21)
		param10
		57
		param9
	)
	(Graph grDRAW_LINE (- param1 1) (+ param2 1) (- param1 1) (- param4 1) 58 -1 -1)
	(Graph grDRAW_LINE (- param1 3) param2 (- param1 3) param4 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 2) (- param3 10) (- param2 2) 58 -1 -1)
	(Graph grDRAW_LINE (- param1 2) (- param2 20) (+ param3 3) (- param2 20) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 3) (- param2 18) (- param3 3) (- param2 18) 58 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 14) (- param3 10) (- param2 14) 19 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 13) (- param3 10) (- param2 13) 20 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 12) (- param3 10) (- param2 12) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 11) (- param3 10) (- param2 11) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 10) (- param3 10) (- param2 10) 23 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 9) (- param3 10) (- param2 9) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 8) (- param3 10) (- param2 8) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 7) (- param3 10) (- param2 7) 20 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (- param2 6) (- param3 10) (- param2 6) 56 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 2) (- param3 10) (+ param4 2) 58 -1 -1)
	(Graph grDRAW_LINE (- param1 2) (+ param4 20) (+ param3 3) (+ param4 20) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 3) (+ param4 18) (- param3 3) (+ param4 18) 58 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 14) (- param3 10) (+ param4 14) 19 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 13) (- param3 10) (+ param4 13) 20 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 12) (- param3 10) (+ param4 12) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 11) (- param3 10) (+ param4 11) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 10) (- param3 10) (+ param4 10) 23 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 9) (- param3 10) (+ param4 9) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 8) (- param3 10) (+ param4 8) 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 7) (- param3 10) (+ param4 7) 20 -1 -1)
	(Graph grDRAW_LINE (+ param1 10) (+ param4 6) (- param3 10) (+ param4 6) 56 -1 -1)
	(Graph grDRAW_LINE (+ param3 1) (+ param2 1) (+ param3 1) (- param4 1) 58 -1 -1)
	(Graph grDRAW_LINE (+ param3 3) param2 (+ param3 3) param4 21 -1 -1)
	(DrawCel 935 0 0 (- param2 20) (- param1 3) -1)
	(DrawCel 935 0 1 (+ param4 1) (- param1 3) -1)
	(DrawCel 935 0 2 (- param2 20) (- param3 9) -1)
	(DrawCel 935 0 3 (+ param4 1) (- param3 9) -1)
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
		color 17
		back 57
		underBits 0
		pUnderBits 0
		innerBordColor 21
		midBordColor 58
		outerBordColor 53
		yOffset 0
		updateList 0
	)

	(method (open &tmp temp0 temp1 [temp2 3])
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
		(if (!= priority -1)
			(= pUnderBits (Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 2))
		)
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
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(+= bottom 4)
		(+= right 4)
		(= type 131)
		(if (not global449)
			(= global449 (PalVary pvGET_CURRENT_STEP))
		)
		(if (and (!= global449 0) (!= global449 64) (not (IsFlag 121)))
			(= gGloryWindow self)
			(SetFlag 121)
			(PalVary pvPAUSE_RESUME 1)
		)
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
		(if window
			(DisposeWindow window eraseOnly)
			(= window 0)
		)
		(if (and (== gGloryWindow self) global449)
			(PalVary pvPAUSE_RESUME 0)
			(= gGloryWindow 0)
			(ClearFlag 121)
			(= global449 0)
		)
		(DisposeClone self)
	)
)

