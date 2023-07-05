;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1230)
(include sci.sh)
(use LarryTalker)
(use Actor)

(public
	Billy_Dee 17
)

(instance Billy_Dee of LarryTalker
	(properties
		name {Billy Dee}
		x 220
		y 20
		view 1830
		loop 1
		talkWidth 155
		showTitle 1
		back 46
		textX -195
		textY 10
		winPosn 1
	)

	(method (init)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of Prop
	(properties
		nsTop 4
		nsLeft 4
		view 1230
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 55
		nsLeft 20
		view 1230
	)
)

(instance tEyes of Prop
	(properties
		nsTop 44
		nsLeft 22
		view 1230
		loop 2
	)
)

