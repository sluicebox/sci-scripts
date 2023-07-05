;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 949)
(include sci.sh)
(use System)

(class Blk of Obj
	(properties
		sel_20 {Blk}
		sel_194 0
		sel_195 0
		sel_196 0
		sel_197 0
	)

	(method (sel_57 param1)
		(return
			(or
				(<= (param1 sel_18:) sel_194)
				(> (param1 sel_16:) sel_196)
				(< (param1 sel_19:) sel_195)
				(>= (param1 sel_17:) sel_197)
			)
		)
	)
)

(class Cage of Blk
	(properties
		sel_20 {Cage}
	)

	(method (sel_57 param1)
		(return
			(and
				(>= (param1 sel_16:) sel_194)
				(>= (param1 sel_17:) sel_195)
				(<= (param1 sel_18:) sel_196)
				(<= (param1 sel_19:) sel_197)
			)
		)
	)
)

