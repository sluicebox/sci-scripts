;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 946)
(include sci.sh)
(use System)

(class Polygon of Obj
	(properties
		sel_20 {Polygon}
		sel_86 0
		sel_87 0
		sel_31 1
		sel_248 0
	)

	(method (sel_110 param1 &tmp [temp0 2])
		(= sel_86 (/ argc 2))
		(= sel_87 (Memory memALLOC_CRIT (* 2 argc)))
		(StrCpy sel_87 @param1 (- (* argc 2)))
		(= sel_248 1)
	)

	(method (sel_111)
		(if (and sel_248 sel_87)
			(Memory memFREE sel_87)
		)
		(super sel_111:)
	)
)

