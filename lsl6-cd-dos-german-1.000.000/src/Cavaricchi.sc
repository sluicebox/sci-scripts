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
		view 98
		talkWidth 120
		showTitle 1
		back 74
		textX -143
		textY -10
	)

	(method (init)
		(cond
			((and (not (gCurRoom inset:)) (== gCurRoomNum 440))
				(= view 1830)
				(= x 235)
				(= y 10)
				(= textX -190)
				(= textY 11)
				(= talkWidth 160)
				(tBust view: 1460 loop: 1 nsTop: 4 nsLeft: 4)
				(tEyes view: 1460 nsLeft: 22 nsTop: 29)
				(tMouth view: 1460 nsLeft: 23 nsTop: 42)
				(super init: tBust tEyes tMouth)
			)
			((gCurRoom inset:)
				(= talkWidth 120)
				(= view 98)
				(= x 140)
				(= y 25)
				(= textX -134)
				(= textY -10)
				(tBust view: 98)
				(tEyes view: 460 nsTop: 0 nsLeft: 0)
				(tMouth view: 460 nsTop: 12 nsLeft: 0)
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 370)
				(= textX 168)
				(= textY 10)
				(= view 1830)
				(= y (= x 6))
				(tBust view: 1461 loop: 1 nsTop: 4 nsLeft: 4)
				(tEyes view: 1461 nsLeft: 22 nsTop: 29)
				(tMouth view: 1461 nsLeft: 23 nsTop: 42)
				(= modeless 1)
				(super init: tBust tEyes tMouth)
			)
			(else
				(= view 1830)
				(= x 40)
				(= y 10)
				(= textX 100)
				(= textY 70)
				(tBust view: 1460 loop: 1 nsTop: 4 nsLeft: 4)
				(tEyes view: 1460 nsLeft: 22 nsTop: 29)
				(tMouth view: 1460 nsLeft: 23 nsTop: 42)
				(super init: tBust tEyes tMouth)
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
		nsTop 12
		view 460
	)
)

(instance tEyes of Prop
	(properties
		view 460
		loop 2
	)
)

