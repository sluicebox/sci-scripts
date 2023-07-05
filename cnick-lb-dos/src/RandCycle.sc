;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 941)
(include sci.sh)
(use Main)
(use Motion)

(class RandCycle of Cycle
	(properties
		sel_20 {RandCycle}
		sel_391 -1
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(if (>= argc 2)
			(= sel_391 param2)
			(if (>= argc 3)
				(= sel_142 param3)
			)
		else
			(= sel_391 -1)
		)
	)

	(method (sel_57)
		(if (>= (Abs (- gGameTime sel_149)) (sel_42 sel_223:))
			(if sel_391
				(if (> sel_391 0)
					(-- sel_391)
				)
				(sel_42 sel_4: (self sel_220:))
				(= sel_149 gGameTime)
			else
				(self sel_221:)
			)
		)
	)

	(method (sel_220 &tmp temp0)
		(return
			(if (!= (NumCels sel_42) 1)
				(while
					(== (= temp0 (Random 0 (sel_42 sel_225:))) (sel_42 sel_4:))
				)
				temp0
			)
		)
	)

	(method (sel_221)
		(= sel_219 1)
		(if sel_142
			(= gDoMotionCue 1)
		else
			(self sel_222:)
		)
	)
)

