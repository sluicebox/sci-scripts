;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)

(public
	roJudge2Movie 0
)

(instance roJudge2Movie of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 224) ; oFlags
		(gCurRoom newRoom: 50500) ; roJailCell
	)

	(method (gimme))
)

