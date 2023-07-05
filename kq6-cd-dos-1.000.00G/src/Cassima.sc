;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1005)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use n913)
(use Actor)

(public
	Cassima 28
)

(instance Cassima of Kq6Talker
	(properties
		x 5
		y 5
		view 891
		talkWidth 213
		textX 79
		textY 8
		raveName {CASSIMA}
	)

	(method (init)
		(cond
			((and (IsFlag 59) (== gCurRoomNum 140))
				(= cel 1)
				(self x: 94 y: 87 textX: -60 textY: 30)
				(super init: 0 0 tMouth140 &rest)
			)
			((IsFlag 59)
				(= cel 1)
				(super init: 0 0 0 &rest)
			)
			((and (== (gCurRoom curPic:) 165) (== gCurRoomNum 740))
				(self cel: 1 x: 214 y: 78 textX: -60 textY: 50 talkWidth: 120)
				(super init: 0 tEyes740 tMouth740 &rest)
			)
			((IsFlag 99)
				(self cel: 1 x: 172 y: 54 talkWidth: 135 textX: -2 textY: 58)
				(super init: 0 0 wedMouth &rest)
			)
			((IsFlag 102)
				(self cel: 1 x: 132 y: 67 textX: -112 textY: -47 talkWidth: 92)
				(tEyes view: 7832 loop: 10 cel: 0 nsLeft: 0 nsTop: 0)
				(tMouth view: 7832 loop: 9 cel: 0 nsLeft: -4 nsTop: 3)
				(super init: 0 tEyes tMouth &rest)
			)
			((== gCurRoomNum 870)
				(self cel: 1 textX: 58 textY: 57 talkWidth: 100)
				(super init: 0 0 0 &rest)
			)
			(else
				(if (or (== gCurRoomNum 750) (== gCurRoomNum 740))
					(= winPosn 0)
				)
				(self
					view: 891
					loop: 0
					cel: 0
					x: 5
					y: 5
					textX: 79
					textY: 8
					talkWidth: 213
				)
				(tEyes view: 891 loop: 2 nsTop: 30 nsLeft: 26)
				(tMouth view: 891 loop: 1 nsTop: 40 nsLeft: 27)
				(super init: tBust tEyes tMouth &rest)
			)
		)
	)
)

(instance tBust of Prop
	(properties
		view 891
	)
)

(instance tEyes of Prop
	(properties
		nsTop 30
		nsLeft 26
		view 891
		loop 2
	)
)

(instance tMouth of Prop
	(properties
		nsTop 40
		nsLeft 27
		view 891
		loop 1
	)
)

(instance wedMouth of Prop
	(properties
		view 161
	)
)

(instance tMouth740 of Prop
	(properties
		view 165
		loop 3
	)
)

(instance tEyes740 of Prop
	(properties
		nsTop -11
		nsLeft 2
		view 165
		loop 2
	)
)

(instance tMouth140 of Prop
	(properties
		view 142
		loop 3
	)
)

(instance tEyes140 of Prop ; UNUSED
	(properties
		nsTop -11
		nsLeft 1
		view 142
		loop 4
	)
)

