;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 778)
(include sci.sh)
(use Main)
(use pqIconBar)
(use DText)
(use Str)
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
	local3
	local4
)

(instance rm778 of Room
	(properties
		modNum 779
		picture 390
	)

	(method (init)
		(thatOldScore init: pqIconBar)
		(= local4 (Str new:))
		(local4 format: {%d} gScore)
		(= local3 (DText new:))
		(local3
			font: gUserFont
			text: (KString 8 (local4 data:)) ; StrDup
			x: 250
			y: (if (IsHiRes) 183 else 181)
			fore: 22
			back: 254
			skip: 254
			setSize:
			setPri: 302
			init: pqIconBar
		)
		(gTheIconBar locked: 0 disable:)
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
		(local3 dispose:)
		(local4 dispose:)
		(thatOldScore dispose:)
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
				(gMessager say: 1 2 0 0 self 779) ; "Detective Carey, for exceptional courage and integrity, above and beyond the call of duty, in the face of felonious criminal assaults on your person..."
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
				(= ticks 30)
			)
			(10
				(self setScript: showValor self)
			)
			(11
				(valerie setCycle: End self)
			)
			(12
				(valerie loop: 1 cel: 0 setCycle: End self)
			)
			(13
				(= ticks 180)
			)
			(14
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

(instance valorMedal of Actor
	(properties
		x 158
		y 82
		priority 200
		fixPriority 1
		view 3925
	)

	(method (init)
		(if (IsHiRes)
			(= view 3913)
			(= y 120)
		)
		(super init: &rest)
	)
)

(instance showValor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(valorMedal scaleX: 1 scaleY: 1 init: setSpeed: 0)
				(= cycles 2)
			)
			(1
				(= ticks 110)
			)
			(2
				(valorMedal dispose:)
				(self dispose:)
			)
		)
	)
)

(instance thatOldScore of View
	(properties
		x 195
		y 192
		priority 301
		fixPriority 1
		view 984
	)

	(method (init)
		(if (IsHiRes)
			(= view 10984)
		else
			(= y 193)
		)
		(super init: &rest)
	)
)

