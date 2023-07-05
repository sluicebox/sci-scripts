;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7341)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm7341 0
)

(instance rm7341 of ExitRoom
	(properties
		picture 7341
		east 730 ; churchRm
		south 730 ; churchRm
		west 730 ; churchRm
	)

	(method (init)
		(stGeorge init:)
		(super init: &rest)
	)
)

(instance stGeorge of Feature
	(properties
		noun 1
		nsLeft 282
		nsRight 414
		nsBottom 333
		sightAngle 40
		approachX 328
		approachY 312
		x 348
		y 165
	)
)

