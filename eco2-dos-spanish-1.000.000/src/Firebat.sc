;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1619)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Firebat 0
)

(instance Firebat of Eco2Talker
	(properties
		x 5
		y 5
		view 1619
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 12
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: firebatBust firebatEyes firebatMouth &rest)
	)
)

(instance firebatMouth of Prop
	(properties
		nsTop 47
		nsLeft 21
		view 1619
	)
)

(instance firebatBust of Prop
	(properties
		view 1619
		loop 1
	)
)

(instance firebatEyes of Prop
	(properties
		nsTop 30
		nsLeft 20
		view 1619
		loop 2
	)
)

