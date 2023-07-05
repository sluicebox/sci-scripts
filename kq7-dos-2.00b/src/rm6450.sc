;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6450)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm6450 0
)

(local
	[local0 5]
)

(instance rm6450 of KQRoom
	(properties
		picture 6450
		east 6500
	)

	(method (init)
		(Load 140 6451) ; WAVE
		(Load rsVIEW 6451)
		(Load rsVIEW 6452)
		(Load rsVIEW 6453)
		(SetFlag 21)
		(super init:)
		(gEgo
			view: 6451
			x: 100
			y: 10
			setScale:
			scaleX: 128
			scaleY: 128
			ignoreActors:
		)
		(gGame handsOff:)
		(gKqMusic1 stop: number: 6450 setLoop: -1 play:)
		(if (IsFlag 213)
			(gCurRoom setScript: sAwake)
		else
			(gCurRoom setScript: sAsleep)
		)
	)
)

(instance sAsleep of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gGame handsOn:)
					(gCurRoom newRoom: 6500)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						init:
						setLoop: 0
						setCel: 0
						cycleSpeed: 14
						setCycle: CT 6 1 self
					)
				)
				(1
					(gEgo hide:)
					(water view: 6452 init: setCycle: End self)
				)
				(2
					(water setCel: 0 setLoop: 1 1 setCycle: End)
					(gEgo x: 100 y: 93 setLoop: 1 show: setCycle: End self)
				)
				(3
					(water
						setCel: 0
						setLoop: 2 1
						setMotion: MoveTo 325 93
						setCycle: Fwd
					)
					(gEgo
						cycleSpeed: 14
						setLoop: 2 1
						setCel: 0 1
						setCycle: Fwd
						setMotion: MoveTo 325 93 self
					)
				)
				(4
					(water dispose:)
					(gEgo dispose:)
					(= cycles 1)
				)
				(5
					(= cycles 1)
				)
				(6
					(gCurRoom newRoom: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sAwake of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gGame handsOn:)
					(gCurRoom newRoom: 6500)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						init:
						setLoop: 0
						setCel: 0
						cycleSpeed: 14
						setCycle: CT 6 1 self
					)
				)
				(1
					(gEgo hide:)
					(water view: 6453 init: setCycle: End)
					(gKqSound1 number: 6451 setLoop: 1 play: self)
				)
				(2
					(water setCel: 0 setLoop: 1 1 setCycle: End)
					(gEgo x: 100 y: 93 setLoop: 1 show: setCycle: End self)
				)
				(3
					(water
						setCel: 0
						setLoop: 2 1
						setMotion: MoveTo 325 93
						setCycle: Fwd
					)
					(gKqSound1 stop: number: 6453 setLoop: -1 play:)
					(gEgo
						cycleSpeed: 14
						setLoop: 2 1
						setCel: 0 1
						setCycle: Fwd
						setMotion: MoveTo 325 93 self
					)
				)
				(4
					(water dispose:)
					(gEgo dispose:)
					(= cycles 1)
				)
				(5
					(= cycles 1)
				)
				(6
					(gCurRoom newRoom: 6500)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance water of Actor
	(properties
		sightAngle 40
		x 100
		y 93
	)
)

