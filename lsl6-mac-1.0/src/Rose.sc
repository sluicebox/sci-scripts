;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1805)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)

(public
	Rose 21
)

(instance Rose of LarryTalker
	(properties
		x 235
		y 6
		view 98
		talkWidth 145
		showTitle 1
		back 50
		textX -220
		textY 10
	)

	(method (init)
		(switch gCurRoomNum
			(390
				(= textX -143)
				(= textY -10)
				(= x 146)
				(= y 41)
				(= talkWidth 120)
				(= view 98)
				(tEyes view: 390 loop 2 cel 0 nsTop -9)
				(tMouth view: 390 loop 0 cel 0)
				(super init: 0 tEyes tMouth)
			)
			(320
				(= view 1830)
				(= winPosn 2)
				(tEyes view: 1390 loop: 2 cel: 0 nsTop: 38 nsLeft: 17)
				(tMouth view: 1390 loop: 0 nsTop: 48 cel: 0 nsLeft: 17)
				(tBust view: 1390 loop: 1 cel: 0 nsTop: 4 nsLeft: 4)
				(super init: tBust tEyes tMouth)
			)
			(else
				(super init: tBust tEyes tMouth)
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
		view 390
	)
)

(instance tEyes of Prop
	(properties
		nsTop -9
		view 390
		loop 2
	)
)

