;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 945)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class PolyPath of Motion
	(properties
		sel_20 {PolyPath}
		sel_74 2
		sel_87 0
		sel_249 0
		sel_250 0
		sel_251 0
	)

	(method (sel_110 param1 param2 param3 param4 param5 param6)
		(if argc
			(= sel_42 param1)
			(if (> argc 1)
				(cond
					((>= argc 6)
						(= sel_251 param6)
					)
					((not (IsObject sel_251))
						(= sel_251 (gCurRoom sel_251:))
					)
				)
				(if sel_87
					(Memory memFREE sel_87)
				)
				(= sel_87
					(AvoidPath
						(param1 sel_1:)
						(param1 sel_0:)
						(= sel_249 param2)
						(= sel_250 param3)
						(and sel_251 (sel_251 sel_24:))
						(and sel_251 (sel_251 sel_86:))
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3)
					(= sel_143 param4)
				)
			)
		)
		(self sel_243:)
		(super sel_110:)
	)

	(method (sel_111)
		(if sel_87
			(Memory memFREE sel_87)
		)
		(= sel_87 0)
		(super sel_111:)
	)

	(method (sel_243)
		(if (!= (WordAt sel_87 sel_74) 30583)
			(= sel_1 (WordAt sel_87 sel_74))
			(= sel_0 (WordAt sel_87 (++ sel_74)))
			(++ sel_74)
		)
	)

	(method (sel_97)
		(if (== (WordAt sel_87 sel_74) 30583)
			(super sel_97:)
		else
			(self sel_110:)
		)
	)
)

