;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1811)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Char 12
)

(instance Char of LarryTalker
	(properties
		x 150
		y 20
		view 98
		talkWidth 110
		showTitle 1
		back 37
		textX -143
		textY -8
	)

	(method (init)
		(if (== gCurRoomNum 410)
			(= talkWidth (proc79_4 110 110 115 110 110))
			(super init: tBust tEyes tMouth)
		else
			(if (== gCurRoomNum 380)
				(= talkWidth 205)
				(= view 1830)
				(= textX 90)
				(= textY 10)
				(= y (= x 6))
			)
			(= view 1830)
			(tBust
				view: 1410
				cel: (if (== gCurRoomNum 400) 1 else 0)
				loop: 1
				nsTop: 4
				nsLeft: 4
			)
			(tMouth view: 1410 nsTop: 47 nsLeft: 20)
			(tEyes view: 1410 nsTop: 36 nsLeft: 22)
			(super init: tBust tEyes tMouth)
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
		nsTop 25
		view 410
	)
)

(instance tEyes of Prop
	(properties
		nsTop 11
		view 410
		loop 2
	)
)

