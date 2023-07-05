;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1805)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Rose 21
)

(instance Rose of LarryTalker
	(properties
		showTitle 1
		back 50
		view 98
		winPosn 2
	)

	(method (init)
		(if (== gCurRoomNum 390)
			(= fullFace 1)
			(= y 46)
			(= x 146)
			(= textX -200)
			(= textY 150)
			(= winPosn 0)
			(super init: tMouth tBust tEyes)
		else
			(= winPosn 2)
			(= view 98)
			(= cel 1)
			(tBust view: 1390 setLoop: 1 y: 0 x: 2)
			(tMouth view: 1390 setLoop: 0 x: 9 y: 18)
			(tEyes view: 1390 setLoop: 2 x: 9 y: 14)
			(super init: tMouth tBust tEyes)
		)
	)
)

(instance tBust of View
	(properties
		view 98
	)
)

(instance tMouth of Prop
	(properties
		y 3
		view 390
	)
)

(instance tEyes of Prop
	(properties
		x -1
		y -6
		view 390
		loop 2
	)
)

