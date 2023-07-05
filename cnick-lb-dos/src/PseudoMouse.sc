;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 933)
(include sci.sh)
(use Main)
(use System)

(class PseudoMouse of Code
	(properties
		sel_20 {PseudoMouse}
		sel_410 2
		sel_411 2
		sel_412 20
		sel_313 0
		sel_413 5
	)

	(method (sel_132 param1)
		(if (and (gUser sel_321:) (& (param1 sel_31:) $0040))
			(= sel_313
				(if (or (not gTheIconBar) (!= ((gTheIconBar sel_210:) sel_37:) 1))
					(= sel_313 (param1 sel_37:))
				else
					(return)
				)
			)
			(= sel_410
				(if (& (param1 sel_31:) $0004)
					(if (& (param1 sel_61:) $0003) sel_411 else sel_412)
				else
					sel_413
				)
			)
			(cond
				((& (param1 sel_31:) $0004)
					(if sel_313
						(self sel_57:)
					else
						(param1 sel_73: 0)
						(return)
					)
				)
				(sel_313
					(self sel_133:)
				)
				(else
					(self sel_159:)
				)
			)
			(param1 sel_73: 1)
			(return)
		)
	)

	(method (sel_133 param1)
		(if argc
			(= sel_313 param1)
		)
		(gTheDoits sel_118: self)
	)

	(method (sel_159)
		(= sel_313 0)
		(gTheDoits sel_81: self)
	)

	(method (sel_57 &tmp temp0 temp1)
		(= temp0 (gLastEvent sel_1:))
		(= temp1 (gLastEvent sel_0:))
		(switch sel_313
			(1
				(-= temp1 sel_410)
			)
			(2
				(+= temp0 sel_410)
				(-= temp1 sel_410)
			)
			(3
				(+= temp0 sel_410)
			)
			(4
				(+= temp0 sel_410)
				(+= temp1 sel_410)
			)
			(5
				(+= temp1 sel_410)
			)
			(6
				(-= temp0 sel_410)
				(+= temp1 sel_410)
			)
			(7
				(-= temp0 sel_410)
			)
			(8
				(-= temp0 sel_410)
				(-= temp1 sel_410)
			)
		)
		(gGame sel_191: gTheCursor 1 temp0 temp1)
	)
)

