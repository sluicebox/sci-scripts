;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 983)
(include sci.sh)
(use Interface)
(use Motion)

(class Path of MoveTo
	(properties
		sel_20 {Path}
		sel_385 0
		sel_74 0
	)

	(method (sel_110 param1 param2 param3)
		(= sel_42 param1)
		(= sel_142 (if (>= argc 2) param2 else 0))
		(= sel_385 (if (== argc 3) param3 else 0))
		(= sel_74 -1)
		(= sel_1 (sel_42 sel_1:))
		(= sel_0 (sel_42 sel_0:))
		(if (self sel_386:)
			(self sel_97:)
		else
			(self sel_65:)
			(super sel_110: sel_42 sel_1 sel_0)
		)
	)

	(method (sel_97)
		(if (self sel_386:)
			(super sel_97:)
		else
			(if sel_385
				(sel_385 sel_144: (/ sel_74 2))
			)
			(self sel_65:)
			(super sel_110: sel_42 sel_1 sel_0)
		)
	)

	(method (sel_65)
		(= sel_1 (self sel_64: (++ sel_74)))
		(= sel_0 (self sel_64: (++ sel_74)))
	)

	(method (sel_386)
		(return
			(or
				(== (self sel_64: (+ sel_74 1)) -32768)
				(== (self sel_64: (+ sel_74 2)) -32768)
			)
		)
	)

	(method (sel_64)
		(Printf 983 0 sel_20) ; "%s needs an 'at:' method."
		(return 0)
	)
)

(class RelPath of Path
	(properties
		sel_20 {RelPath}
	)

	(method (sel_65)
		(+= sel_1 (self sel_64: (++ sel_74)))
		(+= sel_0 (self sel_64: (++ sel_74)))
	)
)

