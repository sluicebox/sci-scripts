;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1804)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Burgundy 6
)

(instance Burgundy of LarryTalker
	(properties
		x 151
		y 43
		view 98
		talkWidth 120
		showTitle 1
		back 20
		textX -143
		textY -10
	)

	(method (init)
		(cond
			((== gCurRoomNum 520)
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 510)
				(= view 1830)
				(tBust view: 1520 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1520 nsTop: 47 nsLeft: 21)
				(tEyes view: 1520 nsTop: 39 nsLeft: 22)
				(= winPosn 2)
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 370)
				(= view 1830)
				(tBust view: 1521 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1521 nsTop: 47 nsLeft: 21)
				(tEyes view: 1521 nsTop: 39 nsLeft: 22)
				(= y (= x 6))
				(= textX 168)
				(= textY 10)
				(= modeless 1)
				(super init: tBust tEyes tMouth)
			)
			(else
				(super init:)
			)
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
		nsTop 6
		nsLeft -3
		view 520
	)
)

(instance tEyes of Prop
	(properties
		view 520
		loop 2
	)
)

