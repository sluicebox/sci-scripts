;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1815)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Mark 23
)

(instance Mark of LarryTalker
	(properties
		view 1830
		talkWidth 150
		showTitle 1
		back 50
	)

	(method (init)
		(if (== gCurRoomNum 620)
			(= y (= x 10))
			(= textX 120)
			(= talkWidth 150)
			(= textY 11)
			(= winPosn 0)
		else
			(= x 230)
			(= y 10)
			(= textX -220)
			(= textY 11)
		)
		(super init: tBust tEyes tMouth)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1619
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 48
		nsLeft 15
		view 1619
	)
)

(instance tEyes of Prop
	(properties
		nsTop 39
		nsLeft 22
		view 1619
		loop 2
	)
)

