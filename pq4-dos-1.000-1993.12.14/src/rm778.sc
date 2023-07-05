;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 778)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm778 0
)

(local
	local0
	local1
	local2
)

(instance rm778 of Room
	(properties
		modNum 779
		picture 390
	)

	(method (init)
		(gTheIconBar disable:)
		(gTheCursor view: 996)
		(gGame setCursor: gTheCursor 1)
		(gGlobalSound0 number: 778 setLoop: -1 setPri: 5 play:)
		(super init: &rest)
		((= local0 (View new:))
			name: {katherine}
			view: 9397
			loop: 2
			cel: 0
			posn: 187 150
			setPri: 135
			init:
		)
		((= local2 (View new:))
			name: {sBlock}
			view: 399
			loop: 3
			cel: 0
			posn: 83 115
			scaleSignal: 1
			scaleX: 168
			scaleY: 168
			init:
		)
		((= local1 (View new:))
			name: {coun4}
			view: 399
			loop: 0
			cel: 0
			posn: 121 104
			init:
		)
		(gEgo
			view: 9396
			loop: 0
			cel: 0
			setScale: 0
			setSpeed: 6
			setPri: -1
			posn: 164 133
			init:
		)
		(chief view: 4000 loop: 0 cel: 0 posn: 150 132 init:)
		(valerie init:)
		(kristy init:)
		(barry init:)
		(self setScript: giveMedal)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance giveMedal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gMessager say: 1 2 0 0 self 779) ; "Detective Carey, for exceptional courage and integrity, above and beyond the call of duty, in the face of felonious criminal assaults on your person"
			)
			(2
				(= ticks 120)
			)
			(3
				(chief setCycle: End self)
			)
			(4
				(chief loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(valerie setCycle: End self)
			)
			(10
				(valerie loop: 1 cel: 0 setCycle: End self)
			)
			(11
				(= ticks 180)
			)
			(12
				(gGame fadeSpeed: 4)
				(gCurRoom newRoom: 779)
			)
		)
	)
)

(instance chief of Prop
	(properties)
)

(instance kristy of Prop
	(properties
		x 271
		y 97
		view 3901
	)
)

(instance barry of Prop
	(properties
		x 257
		y 96
		view 396
		loop 1
		cel 15
		signal 16385
	)
)

(instance valerie of Prop
	(properties
		x 187
		y 150
		priority 134
		fixPriority 1
		view 9397
	)
)

