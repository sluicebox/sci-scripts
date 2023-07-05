;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1817)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryTalker)
(use Actor)

(public
	You 28
)

(instance You of LarryTalker
	(properties
		x 10
		y 10
		showTitle 1
		back 74
		view 98
		loop 1
		textX 90
		textY 10
		winPosn 1
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(49 {Du})
				(33 {Tu})
				(else {You})
			)
		)
		(if (IsFlag 74)
			(tBust cel: 1)
		else
			(tBust cel: 0)
		)
		(super init: 0 tBust)
	)
)

(instance tBust of View
	(properties
		x -36
		y 2
		view 1903
	)
)

