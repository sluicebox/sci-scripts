;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1801)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Gammie 2
)

(instance Gammie of LarryTalker
	(properties
		x 195
		talkWidth 120
		showTitle 1
		back 20
		view 98
		textX -173
	)

	(method (init)
		(cond
			((== gCurRoomNum 620)
				(super init:)
			)
			((== gCurRoomNum 210)
				(= fullFace 1)
				(= x 152)
				(= y 45)
				(super init: tMouth tBust tEyes)
			)
			(else
				(= winPosn 2)
				(= view 98)
				(= cel 1)
				(= textX -190)
				(= textY 11)
				(= talkWidth 160)
				(tBust view: 1210 loop: 1 x: 2 y: 0)
				(tEyes view: 1210 x: 12 y: 12)
				(tMouth view: 1210 x: 13 y: 17)
				(super init: tMouth tBust tEyes)
			)
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
		view 210
	)
)

(instance tEyes of Prop
	(properties
		y -10
		view 210
		loop 2
	)
)

