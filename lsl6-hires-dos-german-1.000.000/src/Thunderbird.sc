;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1803)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryTalker)
(use Actor)

(public
	Thunderbird 11
)

(instance Thunderbird of LarryTalker
	(properties
		showTitle 1
		back 30
		view 98
		cel 1
		winPosn 2
	)

	(method (init)
		(cond
			((IsFlag 92)
				(tBust view: 1431)
				(tEyes view: 1431)
				(tMouth view: 1431)
				(super init: tMouth tBust tEyes)
			)
			((== gCurRoomNum 430)
				(= fullFace 1)
				(= view 98)
				(= winPosn 0)
				(= x 125)
				(= y 31)
				(super init: tMouth430 0 tEyes430)
			)
			((== gCurRoomNum 420)
				(tBust view: 1432)
				(tEyes view: 1432)
				(tMouth view: 1432)
				(super init: tMouth tBust tEyes)
			)
			(else
				(tBust view: 1430)
				(tEyes view: 1430)
				(tMouth view: 1430)
				(super init: tMouth tBust tEyes)
			)
		)
	)
)

(instance tBust of View
	(properties
		x 2
		view 1430
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		x 10
		y 16
		view 1430
	)
)

(instance tEyes of Prop
	(properties
		x 10
		y 12
		view 1430
		loop 2
	)
)

(instance tMouth430 of Prop
	(properties
		x -3
		y 9
		view 430
	)
)

(instance tEyes430 of Prop
	(properties
		x -4
		y 3
		view 430
		loop 2
	)
)

