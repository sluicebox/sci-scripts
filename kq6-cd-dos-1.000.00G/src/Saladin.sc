;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1026)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Saladin 13
)

(instance Saladin of Kq6Talker
	(properties
		x 5
		y 5
		view 8921
		talkWidth 213
		textX 76
		textY 8
		raveName {SALADIN}
	)

	(method (init)
		(cond
			((and (== (gCurRoom curPic:) 165) (== gCurRoomNum 740))
				(self cel: 1 x: 1 y: 1 textX: 5 textY: 8 keepWindow: 0)
				(super init: 0 0 0 &rest)
			)
			((== gCurRoomNum 150)
				(self cel: 1 x: 288 y: 16 textX: -240 textY: -10 keepWindow: 0)
				(super init: 0 tEyesA tMouthA &rest)
			)
			((IsFlag 99)
				(self cel: 1 x: 10 y: 24 textX: 5 textY: 88)
				(super init: 0 0 wedMouth &rest)
			)
			(else
				(self
					view: 8921
					loop: 0
					cel: 0
					x: 5
					y: 5
					textX: 78
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
		view 8921
	)
)

(instance tEyes of Prop
	(properties
		nsTop 19
		nsLeft 31
		view 8921
		loop 2
	)
)

(instance tEyesA of Prop
	(properties
		nsTop -16
		nsLeft 4
		view 150
		loop 10
	)
)

(instance tMouth of Prop
	(properties
		nsTop 29
		nsLeft 25
		view 8921
		loop 1
	)
)

(instance tMouthA of Actor
	(properties
		view 150
		loop 4
	)
)

(instance wedMouth of Prop
	(properties
		view 161
		loop 1
	)
)

