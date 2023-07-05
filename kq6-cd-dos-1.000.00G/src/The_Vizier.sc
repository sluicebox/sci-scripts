;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1029)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	The_Vizier 24
)

(instance The_Vizier of Kq6Talker
	(properties
		name {The Vizier}
		x 5
		y 5
		view 892
		talkWidth 213
		textX 76
		textY 8
		raveName {VIZIER}
	)

	(method (init)
		(cond
			((IsFlag 59)
				(self cel: 1)
				(super init: 0 0 0 &rest)
			)
			((IsFlag 99)
				(self cel: 1 x: 135 y: 43 talkWidth: 150 textX: -44 textY: 53)
				(super init: 0 0 wedMouth &rest)
			)
			((== gCurRoomNum 145)
				(self cel: 1 x: 42 y: 58 textX: -32 textY: -50)
				(tMouth view: 1466 loop: 2 nsLeft: 0 nsTop: 0)
				(super init: 0 0 tMouth &rest)
			)
			((== gCurRoomNum 150)
				(self
					cel: 1
					x: 54
					y: 48
					talkWidth: 160
					textX: -44
					textY: 53
					keepWindow: 0
				)
				(super init: 0 tEyes150 tMouth150 &rest)
			)
			(else
				(if (== gCurRoomNum 750)
					(= winPosn 0)
				)
				(self
					view: 892
					loop: 0
					cel: 0
					x: 5
					y: 5
					textX: 76
					textY: 8
					talkWidth: 213
				)
				(super init: tBust tEyes tMouth &rest)
			)
		)
	)
)

(instance tBust of Prop
	(properties
		view 892
	)

	(method (init)
		(if (IsFlag 59)
			(self cel: 1)
		)
		(super init: &rest)
	)
)

(instance tEyes of Prop
	(properties
		nsTop 32
		nsLeft 26
		view 892
		loop 2
	)

	(method (init)
		(if (IsFlag 59)
			(self cel: 1)
		)
		(super init: &rest)
	)
)

(instance tMouth of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 892
		loop 1
	)
)

(instance tMouth150 of Prop
	(properties
		view 150
		loop 3
	)
)

(instance wedMouth of Prop
	(properties
		view 161
		loop 2
	)
)

(instance tEyes150 of Prop
	(properties
		nsTop -7
		nsLeft -2
		view 150
		loop 8
	)
)

