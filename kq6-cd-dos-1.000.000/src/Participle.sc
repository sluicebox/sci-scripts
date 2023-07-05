;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1007)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use Actor)

(public
	Participle 9
)

(instance Participle of Kq6Talker
	(properties)

	(method (init)
		(switch gCurRoomNum
			(500
				(self
					view: 479
					loop: 5
					x: 190
					y: 38
					textX: -70
					textY: 76
					talkWidth: 153
				)
				(super init: 0 0 tMouth &rest)
			)
			(460
				(self
					view: 468
					loop: 2
					x: 129
					y: 130
					textX: 0
					textY: 0
					talkWidth: 150
				)
				(tMouth view: 468 loop: 2)
				(super init: 0 0 tMouth &rest)
			)
			(else
				(self
					view: 970
					loop: 5
					cel: 0
					x: 129
					y: 130
					textX: -60
					textY: -100
					talkWidth: 150
				)
				(tMouth view: 970 loop: 5 cel: 0)
				(super init: 0 0 tMouth &rest)
			)
		)
	)
)

(instance tMouth of Actor
	(properties
		view 479
		loop 5
	)
)

