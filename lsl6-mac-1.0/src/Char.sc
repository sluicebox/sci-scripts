;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1811)
(include sci.sh)
(use Main)
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
			(= textX -147)
			(= textY -7)
			(= view 98)
			(tEyes view: 410 loop: 2 nsTop: 11 nsLeft: 0)
			(tMouth view: 410 loop: 0 nsTop: 25 nsLeft: 0)
			(super init: 0 tEyes tMouth)
		else
			(if (== gCurRoomNum 380)
				(= talkWidth 205)
				(= view 1830)
				(= textX 90)
				(= textY 10)
				(= y (= x 6))
			)
			(= view 1830)
			(tBust view: 1410 loop: 1 nsTop: 4 nsLeft: 4)
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

