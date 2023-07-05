;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1812)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Shablee 10
)

(instance Shablee of LarryTalker
	(properties
		x 181
		y 38
		view 98
		talkWidth 120
		showTitle 1
		back 61
		textX -143
		textY -10
	)

	(method (init)
		(cond
			((== gCurRoomNum 590)
				(= textX (proc79_4 -163 -143 -143 -143 -143))
				(= talkWidth (proc79_4 140 120 120 120 120))
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 860)
				(= view 1830)
				(= textY (= y 10))
				(= x 230)
				(= textX -200)
				(= talkWidth 140)
				(tBust view: 1590 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1590 nsLeft: 14 nsTop: 52)
				(tEyes view: 1590 nsTop: 41 nsLeft: 12)
				(super init: tBust tEyes tMouth)
			)
			(else
				(= view 1830)
				(= y 20)
				(= textY 10)
				(tBust view: 1590 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1590 nsLeft: 14 nsTop: 52)
				(tEyes view: 1590 nsTop: 41 nsLeft: 12)
				(if (== gCurRoomNum 580)
					(tBust view: 1591)
					(tMouth view: 1591)
					(tEyes view: 1591)
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
		nsTop 11
		nsLeft 1
		view 590
	)
)

(instance tEyes of Prop
	(properties
		view 590
		loop 2
	)
)

