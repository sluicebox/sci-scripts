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
		view 98
		talkWidth 120
		showTitle 1
		back 20
		textX -173
	)

	(method (init)
		(cond
			((== gCurRoomNum 210)
				(= view 98)
				(= textY -20)
				(= textX -150)
				(= x 152)
				(= y 41)
				(= talkWidth 120)
				(tEyes view: 210 loop: 2 nsTop: -10 nsLeft: -1)
				(tMouth view: 210 loop: 0 nsTop: 0 nsLeft: 0)
				(super init: 0 tEyes tMouth)
			)
			((== gCurRoomNum 620)
				(= view 98)
				(tBust view: 98)
				(tEyes view: 98)
				(tMouth view: 98)
				(= x 5)
				(= y 30)
				(= textY (= textX 0))
				(super init:)
			)
			(else
				(= view 1830)
				(= x 235)
				(= y 10)
				(= textX -190)
				(= textY 11)
				(= talkWidth 160)
				(tBust view: 1210 loop: 1 nsTop: 4 nsLeft: 4)
				(tEyes view: 1210 nsTop: 26 nsLeft: 27)
				(tMouth view: 1210 nsTop: 36 nsLeft: 30)
				(if (== gCurRoomNum 330)
					(= winPosn 2)
				)
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
		view 210
	)
)

(instance tEyes of Prop
	(properties
		nsTop -10
		nsLeft -1
		view 210
		loop 2
	)
)

