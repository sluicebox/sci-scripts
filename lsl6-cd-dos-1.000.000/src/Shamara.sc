;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1816)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Shamara 14
)

(instance Shamara of LarryTalker
	(properties
		x 15
		y 25
		view 720
		loop 1
		showTitle 1
		back 63
	)

	(method (init)
		(switch gCurRoomNum
			(720
				(= x 166)
				(= y 21)
				(= textX -156)
				(= textY 51)
				(= talkWidth 290)
				(if (IsFlag 100)
					(super init:)
				else
					(super init: 0 tEyes tMouth)
				)
			)
			(730
				(= view 98)
				(super init:)
			)
			(else
				(super init: tBust tEyes tMouth)
			)
		)
	)
)

(instance tBust of View
	(properties
		nsTop -18
		nsLeft -11
		view 720
		loop 4
	)
)

(instance tMouth of Prop
	(properties
		nsTop 6
		view 720
	)
)

(instance tEyes of Prop
	(properties
		view 720
		loop 2
	)
)

