;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 888)
(include sci.sh)
(use Main)
(use Game)
(use User)

(class KQ5Room of Rm
	(properties)

	(method (init)
		(super init: &rest)
		(if (and (User canControl:) (User canInput:))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
	)

	(method (newRoom)
		(gGame setCursor: gWaitCursor 1)
		(super newRoom: &rest)
	)
)

