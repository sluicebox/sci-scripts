;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1349)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Gardener 0
)

(instance Gardener of Eco2Talker
	(properties
		x 5
		y 5
		view 1349
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: gardenerBust gardenerEyes gardenerMouth &rest)
	)
)

(instance gardenerMouth of Prop
	(properties
		nsTop 43
		nsLeft 35
		view 1349
	)
)

(instance gardenerBust of Prop
	(properties
		view 1349
		loop 1
	)
)

(instance gardenerEyes of Prop
	(properties
		nsTop 32
		nsLeft 36
		view 1349
		loop 2
	)
)

