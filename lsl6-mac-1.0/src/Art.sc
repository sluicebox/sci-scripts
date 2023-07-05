;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1813)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Art 16
)

(instance Art of LarryTalker
	(properties
		view 1830
		loop 1
		showTitle 1
		back 70
		winPosn 1
	)

	(method (init)
		(= winPosn 1)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of Prop
	(properties
		nsTop 4
		nsLeft 4
		view 1810
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 43
		nsLeft 16
		view 1810
	)
)

(instance tEyes of Prop
	(properties
		nsTop 44
		nsLeft 22
		view 98
		loop 2
	)
)

