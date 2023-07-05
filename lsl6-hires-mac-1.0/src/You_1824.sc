;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1824)
(include sci.sh)
(use Main)
(use LarryTalker)

(public
	You 34
)

(instance You of LarryTalker
	(properties
		showTitle 1
		back 74
	)

	(method (init)
		(= font gUserFont)
		(= x -1)
		(= y 140)
		(= modeless 1)
		(super init: &rest)
	)
)

