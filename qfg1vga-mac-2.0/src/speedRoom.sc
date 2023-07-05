;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use n814)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	speedRoom 0
)

(local
	local0
	local1
)

(instance speedRoom of Rm
	(properties
		picture 400
		style 6
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gEgo setSpeed: 0)
		(self setScript: speedTest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(for ((= temp0 0)) (< temp0 500) ((++ temp0))
		)
	)
)

(instance fred of Actor
	(properties)
)

(instance speedTest of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(= local1 (GetTime))
				(fred
					view: 99
					setLoop: 0
					setCel: 0
					illegalBits: 0
					posn: 0 0
					setStep: 1 1
					setSpeed: 0
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(1
				(= local1 (GetTime))
				(fred setMotion: MoveTo 320 190)
				(= cycles 50)
			)
			(2
				(= local0 (- (GetTime) local1))
				(= cycles 1)
			)
			(3
				(startGame doit:)
			)
		)
	)
)

(instance startGame of Code
	(properties)

	(method (doit &tmp [temp0 40])
		(= gHowFast
			(cond
				(
					(>
						(= gHowFast
							(cond
								((> local0 600) 0)
								((> local0 550) 1)
								((> local0 500) 2)
								((> local0 450) 3)
								((> local0 400) 4)
								((> local0 350) 5)
								((> local0 300) 6)
								((> local0 275) 7)
								((> local0 250) 8)
								((> local0 225) 9)
								((> local0 200) 10)
								((> local0 100) 11)
								((> local0 60) 12)
								((> local0 40) 13)
								((> local0 20) 14)
								(else 15)
							)
						)
						11
					)
					2
				)
				((< gHowFast 8) 0)
				(else 1)
			)
		)
		(gGame
			detailLevel:
				(switch gHowFast
					(0 0)
					(1 4)
					(else 6)
				)
		)
		(gEgo setSpeed: 7)
		(= global123 global100)
		(RedrawCast)
		(gCurRoom newRoom: global124)
	)
)

