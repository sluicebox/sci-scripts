;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 565)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm565 0
)

(local
	local0
)

(instance rm565 of Rm
	(properties
		picture 565
	)

	(method (init)
		(= local0 (gEgo moveSpeed:))
		(gEgo
			view: 566
			setLoop: 0
			x: 237
			y: 132
			signal: 16384
			cycleSpeed: 14
			moveSpeed: 14
			init:
		)
		(kenny setLoop: 0 cycleSpeed: 14 moveSpeed: 14 init:)
		(super init:)
		(if (IsFlag 60)
			(gCurRoom setScript: sFreddyShootsKenny)
		else
			(gCurRoom setScript: sKennyShootsFreddy)
		)
	)
)

(instance sKennyShootsFreddy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(kenny setCycle: End self)
				(gEgo loop: 1 cel: 0 setCycle: End)
			)
			(2
				(kenny loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(kenny
					loop: 2
					setStep: 6 4
					setCycle: Walk
					setMotion: MoveTo 230 132 self
				)
			)
			(4
				(kenny loop: 0 cel: 6)
				(= cycles 5)
			)
			(5
				(gEgo cycleSpeed: local0 moveSpeed: local0)
				(gCurRoom newRoom: 570)
				(self dispose:)
			)
		)
	)
)

(instance sFreddyShootsKenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(kenny loop: 1 cel: 0 setCycle: End self)
				(gEgo setCycle: End)
			)
			(2
				(kenny
					loop: 3
					setStep: 6 4
					setCycle: Walk
					setMotion: MoveTo 230 132 self
				)
			)
			(3
				(kenny loop: 1 cel: 8)
				(= cycles 5)
			)
			(4
				(gEgo cycleSpeed: local0 moveSpeed: local0)
				(gCurRoom newRoom: 570)
				(self dispose:)
			)
		)
	)
)

(instance kenny of Actor
	(properties
		x 73
		y 132
		view 565
		signal 16384
	)
)

