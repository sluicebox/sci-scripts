;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Window)

(public
	BrainWindow 0
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0)
	(Graph grFILL_BOX param1 param2 param3 param4 param8 param5 param7)
	(Graph grDRAW_LINE param1 param2 param1 param4 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) param2 (+ param1 1) param4 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) param2 (+ param1 2) param4 17 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) param2 param3 param2 21 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) (+ param2 1) (- param3 1) (+ param2 1) 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 3) (+ param2 2) (- param3 2) (+ param2 2) 26 -1 -1)
	(Graph grDRAW_LINE param1 param4 param3 param4 18 -1 -1)
	(Graph grDRAW_LINE (+ param1 1) (- param4 1) (- param3 1) (- param4 1) 22 -1 -1)
	(Graph grDRAW_LINE (+ param1 2) (- param4 2) (- param3 2) (- param4 2) 20 -1 -1)
	(Graph grDRAW_LINE param3 param2 param3 (- param4 1) 17 -1 -1)
	(Graph grDRAW_LINE (- param3 1) (+ param2 1) (- param3 1) (- param4 2) 22 -1 -1)
	(Graph grDRAW_LINE (- param3 2) (+ param2 2) (- param3 2) (- param4 3) 21 -1 -1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp1
		(cond
			((> (param1 bottom:) 185)
				(- 185 (param1 bottom:))
			)
			((< (param1 top:) 5)
				(- 5 (param1 top:))
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

(class BrainWindow of SysWindow
	(properties
		color 25
		back 19
		underBits 0
		pUnderBits 0
		oldPort 0
		outerEdgeColor 19
		yOffset 0
	)

	(method (open &tmp temp0 temp1)
		(= temp1 1)
		(if (!= priority -1)
			(|= temp1 $0002)
		)
		(localproc_1 self)
		(-= top yOffset)
		(= lsTop top)
		(= lsLeft left)
		(= lsRight (+ right 1))
		(= lsBottom (+ bottom 1))
		(= type 128)
		(super open:)
		(= temp0 (GetPort))
		(SetPort 0)
		(localproc_0 top left bottom right back outerEdgeColor priority temp1)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(SetPort temp0)
	)
)

