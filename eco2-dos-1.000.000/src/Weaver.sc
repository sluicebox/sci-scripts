;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1359)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Weaver 0
)

(instance Weaver of Eco2Talker
	(properties
		x 5
		y 5
		view 1359
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: weaverBust weaverEyes weaverMouth &rest)
	)
)

(instance weaverMouth of Prop
	(properties
		nsTop 47
		nsLeft 24
		view 1359
	)
)

(instance weaverBust of Prop
	(properties
		view 1359
		loop 1
	)
)

(instance weaverEyes of Prop
	(properties
		nsTop 23
		nsLeft 34
		view 1359
		loop 2
	)
)

