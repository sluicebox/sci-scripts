;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1806)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Merrily 13
)

(instance Merrily of LarryTalker
	(properties
		x 133
		y 30
		talkWidth 110
		showTitle 1
		back 47
		view 98
		textX -130
		textY -19
	)

	(method (init)
		(if (== gCurRoomNum 250)
			(= fullFace 1)
			(= back 148)
			(= x 154)
			(= y 38)
		else
			(= winPosn 2)
			(= view 98)
			(= cel 1)
			(= fore 0)
			(= back 91)
			(tBust view: 1250 loop: 1 y: 0 x: 2)
			(tEyes view: 1250 x: 10 y: 14)
			(tMouth view: 1250 x: 10 y: 18)
		)
		(super init: tMouth tBust tEyes)
	)
)

(instance tBust of View
	(properties
		view 98
	)
)

(instance tMouth of Prop
	(properties
		x 3
		y 11
		view 250
	)
)

(instance tEyes of Prop
	(properties
		view 250
		loop 2
	)
)

