;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1242)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Waitress 20
)

(instance Waitress of LarryTalker
	(properties
		view 1830
		loop 1
		showTitle 1
		back 45
		winPosn 2
	)

	(method (init)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of Prop
	(properties
		nsTop 4
		nsLeft 4
		view 1242
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 49
		nsLeft 19
		view 1242
	)
)

(instance tEyes of Prop
	(properties
		nsTop 39
		nsLeft 17
		view 1242
		loop 2
	)
)

