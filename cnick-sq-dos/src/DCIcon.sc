;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 967)
(include sci.sh)
(use Interface)
(use Motion)

(class DCIcon of DIcon
	(properties
		sel_20 {DCIcon}
		sel_237 0
		sel_236 6
		sel_14 0
	)

	(method (sel_110)
		((= sel_237 (Fwd sel_109:)) sel_110: self)
	)

	(method (sel_187 &tmp temp0)
		(if sel_237
			(= temp0 sel_4)
			(sel_237 sel_57:)
			(if (!= sel_4 temp0)
				(self sel_80:)
			)
		)
	)

	(method (sel_111)
		(if sel_237
			(sel_237 sel_111:)
		)
		(super sel_111:)
	)

	(method (sel_238)
		(return (- (NumCels self) 1))
	)
)

