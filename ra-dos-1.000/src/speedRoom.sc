;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use LoadMany)
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
		picture 780
	)

	(method (init)
		(LoadMany rsVIEW 104)
		(super init:)
		(gGame handsOff:)
		(gGame setSpeed: 0)
		(self setScript: speedTest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(for ((= temp0 0)) (< temp0 500) ((++ temp0))
		)
	)
)

(instance fred of Actor
	(properties
		view 104
	)
)

(instance speedTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fred
					setLoop: 0
					illegalBits: 0
					posn: 0 0
					setStep: 1 1
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
				(startGame doit:)
			)
		)
	)
)

(instance startGame of Code
	(properties)

	(method (doit &tmp [temp0 100])
		(cond
			((> local0 160)
				(= gHowFast 0)
			)
			((> local0 150)
				(= gHowFast 1)
			)
			((> local0 140)
				(= gHowFast 2)
			)
			((> local0 130)
				(= gHowFast 3)
			)
			((> local0 120)
				(= gHowFast 4)
			)
			((> local0 110)
				(= gHowFast 5)
			)
			((> local0 100)
				(= gHowFast 6)
			)
			((> local0 90)
				(= gHowFast 7)
			)
			((> local0 80)
				(= gHowFast 8)
			)
			((> local0 70)
				(= gHowFast 9)
			)
			((> local0 60)
				(= gHowFast 10)
			)
			((> local0 50)
				(= gHowFast 11)
			)
			((> local0 40)
				(= gHowFast 12)
			)
			((> local0 30)
				(= gHowFast 13)
			)
			((> local0 20)
				(= gHowFast 14)
			)
			(else
				(= gHowFast 15)
			)
		)
		(gGame
			detailLevel:
				(cond
					((<= gHowFast 3) 1)
					((<= gHowFast 10) 2)
					(else 3)
				)
		)
		(gGame setSpeed: 6)
		(= gEatMice global18)
		(gCurRoom newRoom: (if global110 29 else 105))
	)
)

