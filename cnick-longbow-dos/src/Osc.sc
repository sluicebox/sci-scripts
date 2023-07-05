;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 939)
(include sci.sh)
(use Motion)

(class Osc of Cycle
	(properties
		sel_20 {Osc}
		sel_460 -1
	)

	(method (sel_110 param1 param2 param3)
		(if (>= argc 2)
			(= sel_460 param2)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		)
		(super sel_110: param1)
	)

	(method (sel_57 &tmp temp0)
		(if (or (> (= temp0 (self sel_233:)) (sel_42 sel_238:)) (< temp0 0))
			(= sel_231 (- sel_231))
			(self sel_234:)
		else
			(sel_42 sel_4: temp0)
		)
	)

	(method (sel_234)
		(if sel_460
			(sel_42 sel_4: (self sel_233:))
			(if (> sel_460 0)
				(-- sel_460)
			)
		else
			(= sel_232 1)
			(self sel_235:)
		)
	)
)

