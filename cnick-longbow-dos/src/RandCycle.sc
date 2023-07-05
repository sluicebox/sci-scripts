;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 941)
(include sci.sh)
(use Main)
(use Motion)

(class RandCycle of Cycle
	(properties
		sel_20 {RandCycle}
		sel_458 -1
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_458 param2)
			(if (>= argc 3)
				(= sel_143 param3)
			)
		else
			(= sel_458 -1)
		)
	)

	(method (sel_57)
		(if (>= (Abs (- gGameTime sel_158)) (sel_42 sel_236:))
			(if sel_458
				(if (> sel_458 0)
					(-- sel_458)
				)
				(sel_42 sel_4: (self sel_233:))
				(= sel_158 gGameTime)
			else
				(self sel_234:)
			)
		)
	)

	(method (sel_233 &tmp temp0)
		(return
			(if (!= (NumCels sel_42) 1)
				(while
					(== (= temp0 (Random 0 (sel_42 sel_238:))) (sel_42 sel_4:))
				)
				temp0
			)
		)
	)

	(method (sel_234)
		(= sel_232 1)
		(if sel_143
			(= gDoMotionCue 1)
		else
			(self sel_235:)
		)
	)
)

