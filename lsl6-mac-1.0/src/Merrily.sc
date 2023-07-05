;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1806)
(include sci.sh)
(use Main)
(use LarryTalker)
(use Actor)
(use System)

(public
	Merrily 13
)

(instance Merrily of LarryTalker
	(properties
		x 133
		y 30
		view 98
		talkWidth 110
		showTitle 1
		back 47
		textX -130
		textY -19
	)

	(method (init)
		(cond
			((== gCurRoomNum 260)
				(= back 36)
				(= textX -190)
				(= textY 10)
				(= x 200)
				(= y 10)
				(= view 1830)
				(tBust view: 1250 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1250 nsTop: 47 nsLeft: 19)
				(tEyes view: 1250 nsTop: 38 nsLeft: 19)
				(super init: tBust tEyes tMouth)
			)
			((OneOf gCurRoomNum 230 280)
				(= view 1830)
				(= back 36)
				(= textX 100)
				(= textY 68)
				(= talkWidth 175)
				(= color 0)
				(= y (= x 10))
				(= modeless 1)
				(tBust view: 1250 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1250 nsTop: 47 nsLeft: 19)
				(tEyes view: 1250 nsTop: 38 nsLeft: 19)
				(super init: tBust tEyes tMouth)
			)
			((== gCurRoomNum 250)
				(= view 98)
				(= x 133)
				(= y 30)
				(= back 148)
				(= textX -130)
				(= textY -18)
				(tMouth view: 250 loop: 0 nsTop: 15 nsLeft: 22)
				(tEyes view: 250 loop: 2 nsTop: 6 nsLeft: 22)
				(super init: 0 tEyes tMouth)
			)
			(else
				(= view 1830)
				(= textX 130)
				(= textY 3)
				(= color 0)
				(= back 91)
				(= y (= x 10))
				(tBust view: 1250 loop: 1 nsTop: 4 nsLeft: 4)
				(tMouth view: 1250 nsTop: 47 nsLeft: 19)
				(tEyes view: 1250 nsTop: 38 nsLeft: 19)
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
		nsTop 15
		nsLeft 22
		view 250
	)
)

(instance tEyes of Prop
	(properties
		nsTop 6
		nsLeft 22
		view 250
		loop 2
	)
)

