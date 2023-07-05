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
		(gKeyDownHandler sel_129: self)
	)

	(method (sel_111)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
	)

	(method (sel_133 param1)
		(if
			(and
				(& (param1 sel_31:) $0004)
				(& (param1 sel_37:) $000d)
				(<= sel_7 (param1 sel_1:) sel_9)
				(<= sel_6 (param1 sel_0:) sel_8)
			)
			(if (self sel_209: param1)
				(self sel_292: ((gTheIconBar sel_214:) sel_37:))
			)
			(param1 sel_73: 1)
			(return)
		else
			(super sel_133: param1)
		)
	)

	(method (sel_209 param1)
		(if (super sel_209: param1)
			(self sel_567: (& (param1 sel_31:) $0004))
			(return)
		)
	)

	(method (sel_567 param1 &tmp temp0 temp1)
		(= temp1 0)
		(self sel_306:)
		(while (!= ((= temp0 (Event sel_109:)) sel_31:) (if param1 8 else 2))
			(temp0 sel_148:)
			(self sel_4: (super sel_209: temp0))
			(Animate (gCast sel_24:) 1)
			(temp0 sel_111:)
		)
		(self sel_4: 0 sel_304:)
		(Animate (gCast sel_24:) 1)
		(temp0 sel_148:)
		(if (super sel_209: temp0)
			(= temp1 1)
		)
		(temp0 sel_111:)
		(return temp1)
	)
)

