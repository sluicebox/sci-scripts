;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8440)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8440 0
)

(instance rm8440 of ExitRoom
	(properties
		picture 8440
		south 8412 ; rm8412
	)

	(method (init)
		(super init: &rest)
		(cross init:)
	)
)

(instance cross of Feature
	(properties
		noun 15
		modNum 840
		nsLeft 240
		nsTop 9
		nsRight 340
		nsBottom 696
	)
)

