;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 817)
(include sci.sh)
(use Main)
(use Window)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
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

(class EcoWindow of SysWindow
	(properties
		back 0
		innerBordColor 0
		midBordColor 0
		outerBordColor 0
		leftUnderBits 0
		rightUnderBits 0
	)

	(method (open &tmp temp0 temp1 temp2)
		(= color global217)
		(= back global210)
		(= innerBordColor global207)
		(= midBordColor global204)
		(= outerBordColor global209)
		(= temp1 1)
		(if (!= priority -1)
			(|= temp1 $0002)
		)
		(= type 128)
		(= priority 15)
		(+= right 4)
		(if (<= top 8)
			(= temp2 (- 9 top))
			(= top 9)
			(+= bottom temp2)
		)
		(if (>= bottom 186)
			(= temp2 (- bottom 185))
			(= bottom 185)
			(-= top temp2)
		)
		(if (<= left 15)
			(= temp2 (- 16 left))
			(= left 16)
			(+= right temp2)
		)
		(if (>= right 305)
			(= temp2 (- right 304))
			(= right 304)
			(-= left temp2)
		)
		(= lsTop (- top 3))
		(= lsLeft (- left 3))
		(= lsRight (+ right 4))
		(= lsBottom (+ bottom 4))
		(= temp0 (GetPort))
		(SetPort 0)
		(= leftUnderBits
			(Graph grSAVE_BOX (- top 7) (- left 11) (+ top 10) (+ left 9) 1)
		)
		(= rightUnderBits
			(Graph grSAVE_BOX (- top 7) (- right 9) (+ top 10) (+ right 12) 1)
		)
		(SetPort temp0)
		(super open: &rest)
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
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grUPDATE_BOX (- top 7) (- right 15) (+ top 13) (+ right 8) 1)
		(Graph grUPDATE_BOX (- top 7) (- left 11) (+ top 13) (+ left 11) 1)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)

	(method (dispose &tmp temp0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX leftUnderBits)
		(Graph grRESTORE_BOX rightUnderBits)
		(Graph grUPDATE_BOX (- top 7) (- right 9) lsTop (+ right 12) 1)
		(Graph grUPDATE_BOX lsTop lsRight (+ top 10) (+ right 12) 1)
		(Graph grUPDATE_BOX (- top 7) (- left 11) lsTop (+ left 9) 1)
		(Graph grUPDATE_BOX lsTop (- left 11) (+ top 10) lsLeft 1)
		(SetPort temp0)
		(super dispose:)
	)
)

