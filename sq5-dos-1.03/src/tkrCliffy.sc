;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1884)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	tkrCliffy 23
)

(instance tkrCliffy of Talker
	(properties
		x 10
		y 25
		view 1003
		talkWidth 150
		back 5
		textX 120
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(if (== gCurRoomNum 300)
			(self x: 200 y: 25 textX: -180)
		)
		(cliffyEyes setLoop: (Random 2 3))
		(super init: cliffyBust cliffyEyes cliffyMouth &rest)
	)
)

(instance cliffyBust of Prop
	(properties
		view 1003
	)
)

(instance cliffyEyes of Prop
	(properties
		nsTop 14
		nsLeft 58
		view 1003
		loop 2
	)
)

(instance cliffyMouth of Prop
	(properties
		nsTop 32
		nsLeft 52
		view 1003
		loop 1
	)
)

