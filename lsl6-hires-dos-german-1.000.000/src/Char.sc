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
		y 25
		talkWidth 110
		showTitle 1
		back 37
		view 98
		textX -143
		textY -8
	)

	(method (init)
		(if (== gCurRoomNum 410)
			(= fullFace 1)
			(super init: tMouth tBust tEyes)
		else
			(= winPosn 2)
			(= view 98)
			(if (== gCurRoomNum 400)
				(tBust cel: 1)
			else
				(tBust cel: 0)
			)
			(tBust view: 1410 loop: 1 y: 0 x: 2)
			(tMouth view: 1410 y: 18 x: 11)
			(tEyes view: 1410 y: 13 x: 11)
			(super init: tMouth tBust tEyes)
		)
	)

	(method (dispose)
		(if ((ScriptID 92 1) plane:) ; curTalkerbust
			(switch gCurRoomNum
				(400
					(UpdateScreenItem ((ScriptID 92 1) cel: 1)) ; curTalkerbust
				)
				(380
					(UpdateScreenItem ((ScriptID 92 1) cel: 0)) ; curTalkerbust
				)
			)
		)
		(super dispose:)
	)
)

(instance tBust of View
	(properties
		view 98
	)
)

(instance tMouth of Prop
	(properties
		x -2
		y 24
		view 410
	)
)

(instance tEyes of Prop
	(properties
		x -1
		y 13
		view 410
		loop 2
	)
)

