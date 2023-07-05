;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 933)
(include sci.sh)
(use Main)
(use System)

(class PseudoMouse of Code
	(properties
		sel_20 {PseudoMouse}
		sel_515 2
		sel_516 2
		sel_517 20
		sel_336 0
		sel_518 5
	)

	(method (sel_133 param1 &tmp temp0 temp1 temp2)
		(= temp0 (param1 sel_31:))
		(= temp1 (param1 sel_37:))
		(= temp2 (param1 sel_61:))
		(if (& temp0 $0040)
			(if (or (not gTheIconBar) (!= (gTheIconBar sel_214:) (gTheIconBar sel_220:)))
				(= sel_336 temp1)
			else
				(return 0)
			)
			(= sel_515
				(if (& temp0 $0004)
					(if (& temp2 $0003) sel_516 else sel_517)
				else
					sel_518
				)
			)
			(cond
				((& temp0 $0004)
					(if sel_336
						(self sel_57:)
					else
						(return (param1 sel_73: 0))
					)
				)
				(sel_336
					(self sel_134:)
				)
				(else
					(self sel_168:)
				)
			)
			(return (param1 sel_73: 1))
		)
	)

	(method (sel_134 param1)
		(if argc
			(= sel_336 param1)
		)
		(gTheDoits sel_118: self)
	)

	(method (sel_168)
		(= sel_336 0)
		(gTheDoits sel_81: self)
	)

	(method (sel_57 &tmp temp0 temp1)
		(= temp0 (gLastEvent sel_1:))
		(= temp1 (gLastEvent sel_0:))
		(switch sel_336
			(1
				(-= temp1 sel_515)
			)
			(2
				(+= temp0 sel_515)
				(-= temp1 sel_515)
			)
			(3
				(+= temp0 sel_515)
			)
			(4
				(+= temp0 sel_515)
				(+= temp1 sel_515)
			)
			(5
				(+= temp1 sel_515)
			)
			(6
				(-= temp0 sel_515)
				(+= temp1 sel_515)
			)
			(7
				(-= temp0 sel_515)
			)
			(8
				(-= temp0 sel_515)
				(-= temp1 sel_515)
			)
		)
		(gGame sel_198: gTheCursor)
		(SetCursor temp0 temp1)
	)
)

