;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1810)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Bartender 22
)

(instance Bartender of LarryTalker
	(properties
		view 1830
		showTitle 1
		back 46
		winPosn 2
	)

	(method (init)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1513
		loop 1
	)
)

(instance tEyes of Prop
	(properties
		nsTop 40
		nsLeft 26
		view 1513
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 49
		nsLeft 22
		view 1513
	)
)

