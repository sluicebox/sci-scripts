;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1812)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Shablee 10
)

(instance Shablee of LarryTalker
	(properties
		x 181
		y 42
		showTitle 1
		back 61
		view 98
	)

	(method (init)
		(if (== gCurRoomNum 590)
			(= fullFace 1)
			(= textX -200)
			(super init: tMouth tBust tEyes)
		else
			(= view 98)
			(= cel 1)
			(tBust view: 1590 loop: 1 y: 0 x: 2)
			(tEyes view: 1590 x: 6 y: 16)
			(tMouth view: 1590 x: 7 y: 20)
			(= winPosn 2)
			(if (== gCurRoomNum 580)
				(tBust view: 1591)
				(tMouth view: 1591)
				(tEyes view: 1591)
			)
			(super init: tMouth tBust tEyes)
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
		x 3
		y 14
		view 590
	)
)

(instance tEyes of Prop
	(properties
		x 1
		y 1
		view 590
		loop 2
	)
)

