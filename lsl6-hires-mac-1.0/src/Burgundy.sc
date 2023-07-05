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
		x 152
		y 43
		talkWidth 120
		showTitle 1
		back 20
		view 98
		textX -143
		textY -10
	)

	(method (init)
		(cond
			((== gCurRoomNum 520)
				(= fullFace 1)
				(= x 148)
				(= y 51)
				(super init: tMouth tBust tEyes)
			)
			((or global189 (== gCurRoomNum 370))
				(= winPosn 2)
				(= view 98)
				(= cel 1)
				(tBust view: 1521 loop: 1 x: 2 y: 0)
				(tEyes view: 1521 x: 11 y: 15)
				(tMouth view: 1521 x: 11 y: 18)
				(= modeless 2)
				(super init: tMouth tBust tEyes)
			)
			(else
				(= view 98)
				(= cel 1)
				(tBust view: 1520 loop: 1 x: 2 y: 0)
				(tEyes view: 1520 x: 11 y: 15)
				(tMouth view: 1520 x: 11 y: 18)
				(= winPosn 2)
				(super init: tMouth tBust tEyes)
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
		view 520
	)
)

(instance tEyes of Prop
	(properties
		x 1
		y -6
		view 520
		loop 2
	)
)

