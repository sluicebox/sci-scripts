;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1805)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Rose 21
)

(instance Rose of LarryTalker
	(properties
		view 98
		showTitle 1
		back 50
		winPosn 2
	)

	(method (init)
		(if (== gCurRoomNum 390)
			(= y 41)
			(= x 146)
			(= textX -143)
			(= textY (proc79_4 -15 -10 -10 -10 -10))
			(= talkWidth 120)
			(= winPosn 0)
			(super init: tBust tEyes tMouth)
		else
			(= textX -220)
			(= textY 10)
			(= x 235)
			(= talkWidth 145)
			(= view 1830)
			(= y 6)
			(= winPosn 0)
			(tBust view: 1390 setLoop: 1 nsTop: 4 nsLeft: 4)
			(tMouth view: 1390 setLoop: 0 nsTop: 48 nsLeft: 17)
			(tEyes view: 1390 setLoop: 2 nsTop: 38 nsLeft: 17)
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

