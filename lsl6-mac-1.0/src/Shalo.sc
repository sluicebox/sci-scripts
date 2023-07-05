;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1146)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Shalo 25
)

(instance Shalo of LarryTalker
	(properties
		view 1830
		loop 1
		showTitle 1
		back 50
		winPosn 2
	)

	(method (init)
		(= winPosn 2)
		(if (== gCurRoomNum 140)
			(= x 235)
			(= y 6)
			(= textX -230)
			(= textY 11)
			(= talkWidth 208)
			(= winPosn 0)
		)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of Prop
	(properties
		nsTop 4
		nsLeft 4
		view 1146
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 46
		nsLeft 15
		view 1146
	)
)

(instance tEyes of Prop
	(properties
		nsTop 36
		nsLeft 16
		view 1146
		loop 2
	)
)

