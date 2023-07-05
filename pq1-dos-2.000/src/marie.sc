;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1272)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)
(use System)

(public
	marie 0
)

(instance marie of Talker
	(properties
		x 222
		y 93
		view 1272
		priority 15
		signal 16400
		talkWidth 150
		font 4
		textX -180
	)

	(method (init)
		(if
			(OneOf
				gCurRoomNum
				10
				11
				12
				13
				14
				15
				16
				17
				18
				19
				20
				21
				34
				35
				34
				35
				33
			)
			(self
				name: {marie}
				view: 1272
				loop: 0
				cel: 0
				x: 222
				y: 93
				textX: -180
				textY: 0
				talkWidth: 150
				disposeWhenDone: 1
				priority: 15
				signal: 16400
			)
			(marieMouth
				view: 1272
				loop: 1
				nsLeft: 32
				nsTop: 38
				priority: 15
				signal: 16400
			)
		else
			(self
				name: {marie}
				view: 1450
				loop: 0
				cel: 0
				x: 222
				y: 93
				textX: -180
				textY: 0
				talkWidth: 150
				disposeWhenDone: 1
				priority: 15
				signal: 16400
			)
			(marieMouth
				view: 1450
				loop: 1
				nsLeft: 33
				nsTop: 38
				priority: 15
				signal: 16400
			)
		)
		(super init: 0 0 marieMouth &rest)
	)
)

(instance marieMouth of Prop
	(properties
		nsTop 13
		nsLeft 23
		view 1272
		loop 1
		priority 15
		signal 16400
	)
)

