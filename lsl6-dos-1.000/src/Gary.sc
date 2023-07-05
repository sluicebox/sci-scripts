;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1807)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Gary_a 18
	Gary_b 27
)

(instance Gary_a of LarryTalker
	(properties
		name {Gary}
		x 152
		y 20
		view 1830
		showTitle 1
		back 63
		textY 10
	)

	(method (init)
		(cond
			((== gCurRoomNum 310)
				(= y 6)
				(= textY 10)
				(= x 235)
				(= textX -220)
				(= talkWidth 180)
			)
			((== gCurRoomNum 510)
				(= winPosn 2)
			)
			(else
				(= textX -202)
				(= x 210)
			)
		)
		(super init: tBust tMouth tEyes)
	)
)

(instance Gary_b of LarryTalker
	(properties
		name {Gary}
		x 200
		y 20
		view 98
		talkWidth 130
		showTitle 1
		back 19
		textX -185
		textY 10
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1311
		loop 1
	)
)

(instance tMouth of Prop
	(properties
		nsTop 52
		nsLeft 18
		view 1311
	)
)

(instance tEyes of Prop
	(properties
		nsTop 42
		nsLeft 23
		view 1311
		loop 2
	)
)

