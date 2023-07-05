;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Motion)

(class MoveToEndLoop of MoveTo
	(properties
		sel_20 {MoveToEndLoop}
	)

	(method (sel_110 param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(if (>= argc 1)
			(= sel_42 param1)
			(if (>= argc 2)
				(= sel_1 param2)
				(if (>= argc 3)
					(= sel_0 param3)
					(if (>= argc 4)
						(= sel_142 param4)
					)
				)
			)
		)
		(= sel_229 (= sel_228 (= sel_45 (= sel_219 0))))
		(if (= temp3 (sel_42 sel_224:))
			(temp3 sel_149: 0)
		)
		(if
			(= temp4
				(GetDistance
					(= temp2 (sel_42 sel_1:))
					(= temp3 (sel_42 sel_0:))
					sel_1
					sel_0
				)
			)
			(sel_42 sel_232: (GetAngle temp2 temp3 sel_1 sel_0))
		)
		(= temp5 (sel_42 sel_225:))
		(sel_42
			sel_4: 0
			sel_306:
				(if (< (/ temp4 temp5) 1)
					1
				else
					(/ temp4 temp5)
				)
				(if (< (/ temp4 temp5) 1)
					1
				else
					(/ temp4 temp5)
				)
			sel_153: End
		)
		(InitBresen self)
	)
)

