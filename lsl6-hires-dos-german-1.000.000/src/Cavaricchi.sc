;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1802)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Cavaricchi 3
)

(instance Cavaricchi of LarryTalker
	(properties
		x 139
		y 27
		talkWidth 120
		showTitle 1
		back 6
		view 98
		textX -143
		textY -10
	)

	(method (init)
		(if (gCurRoom inset:)
			(= winPosn 0)
			(= fullFace 1)
			(= talkWidth 120)
			(= view 98)
			(= x 139)
			(= y 31)
			(tBust view: 98)
			(tMouth view: 460 loop: 0 x: 0 y: 11)
			(tEyes view: 460 loop: 2 x: 0 y: 0)
			(super init: tMouth tBust tEyes)
		else
			(= fullFace 0)
			(= winPosn 2)
			(= view 98)
			(if (== gCurRoomNum 370)
				(tBust view: 1461 loop: 1 y: 0 x: 2)
				(tEyes view: 1461 x: 11 y: 11)
				(tMouth view: 1461 x: 12 y: 16)
			else
				(tBust view: 1460 loop: 1 y: 0 x: 2)
				(tEyes view: 1460 x: 11 y: 11)
				(tMouth view: 1460 x: 12 y: 16)
			)
			(super init: tMouth tBust tEyes)
		)
	)
)

(instance tBust of Prop
	(properties
		view 98
	)
)

(instance tMouth of Prop
	(properties
		view 460
	)
)

(instance tEyes of Prop
	(properties
		view 460
		loop 2
	)
)

