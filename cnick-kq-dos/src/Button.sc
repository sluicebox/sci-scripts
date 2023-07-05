;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 417)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class Button of Prop
	(properties
		sel_20 {Button}
	)

	(method (sel_110)
		(super sel_110: &rest)
		(gMouseDownHandler sel_118: self)
		(gKeyDownHandler sel_128: self)
	)

	(method (sel_111)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_132 param1 &tmp temp0)
		(= temp0 0)
		(if
			(and
				(or
					(& (param1 sel_31:) $0001)
					(and
						(& (param1 sel_31:) $0004)
						(& (param1 sel_37:) $000d)
						(= temp0 1)
					)
				)
				(self sel_200: param1)
				(self sel_436: temp0)
			)
			(self sel_277: ((gTheIconBar sel_210:) sel_37:))
			(param1 sel_73: 1)
			(return)
		else
			(super sel_132: param1)
		)
	)

	(method (sel_436 param1 &tmp temp0 temp1)
		(= temp1 0)
		(self sel_285:)
		(repeat
			(= temp0 (Event sel_109:))
			(temp0 sel_147:)
			(self sel_4: (super sel_200: temp0))
			(Animate (gCast sel_24:) 1)
			(breakif (or param1 (== (temp0 sel_31:) 2)))
			(temp0 sel_111:)
		)
		(self sel_4: 0 sel_283:)
		(Animate (gCast sel_24:) 1)
		(if (super sel_200: temp0)
			(= temp1 1)
		)
		(temp0 sel_111:)
		(return temp1)
	)
)

