;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7007)
(include sci.sh)
(use Main)
(use Location)
(use Feature)

(public
	octoAtriumMynieCU 0
)

(instance octoAtriumMynieCU of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 7028)
		(mynieCU init:)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance mynieCU of Feature
	(properties
		noun 23
		nsLeft 12
		nsTop 5
		nsRight 571
		nsBottom 277
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

