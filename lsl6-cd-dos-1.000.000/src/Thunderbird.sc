;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1803)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Thunderbird 11
)

(instance Thunderbird of LarryTalker
	(properties
		view 1830
		showTitle 1
		back 30
		winPosn 2
	)

	(method (init)
		(cond
			((IsFlag 92)
				(tBust view: 1431)
				(tEyes view: 1431)
				(tMouth view: 1431)
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 430)
				(= view 98)
				(= winPosn 0)
				(= x 125)
				(= y 27)
				(= textX -120)
				(= textY -10)
				(= talkWidth 100)
				(super init: tBust430 tEyes430 tMouth430)
			)
			((== gCurRoomNum 420)
				(tBust view: 1432)
				(tEyes view: 1432)
				(tMouth view: 1432)
				(super init: tBust tEyes tMouth)
			)
			(else
				(tBust view: 1430)
				(tEyes view: 1430)
				(tMouth view: 1430)
				(super init: tBust tEyes tMouth)
			)
		)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1430
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 41
		nsLeft 19
		view 1430
	)
)

(instance tEyes of Prop
	(properties
		nsTop 33
		nsLeft 19
		view 1430
		loop 2
	)
)

(instance tBust430 of View
	(properties
		x 20
		view 98
		loop 1
	)
)

(instance tMouth430 of Prop
	(properties
		nsTop 10
		nsLeft -3
		view 430
	)
)

(instance tEyes430 of Prop
	(properties
		nsTop 3
		nsLeft -3
		view 430
		loop 2
	)
)

