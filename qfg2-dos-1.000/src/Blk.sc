;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 949)
(include sci.sh)
(use System)

(class Blk of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
	)

	(method (doit theObj)
		(return
			(or
				(<= (theObj brBottom:) top)
				(> (theObj brTop:) bottom)
				(< (theObj brRight:) left)
				(>= (theObj brLeft:) right)
			)
		)
	)
)

(class Cage of Blk
	(properties)

	(method (doit theObj)
		(return
			(and
				(>= (theObj brTop:) top)
				(>= (theObj brLeft:) left)
				(<= (theObj brBottom:) bottom)
				(<= (theObj brRight:) right)
			)
		)
	)
)

