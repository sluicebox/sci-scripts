;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm099 0
)

(local
	local0
	local1
)

(instance rm099 of Rm
	(properties
		picture 55
	)

	(method (init)
		(super init:)
		(= global327 0)
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
	(properties)
)

(instance speedTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 99)
				(= cycles 1)
			)
			(1
				(Platform 0 2 0)
				(= local1 (GetTime))
				(fred
					view: 99
					setLoop: 0
					illegalBits: 0
					posn: 20 99
					setStep: 1 1
					setCycle: Fwd
					init:
					setMotion: MoveTo 100 100 self
				)
			)
			(2
				(= local0 (- (GetTime) local1))
				(Platform 0 2 1)
				(startGame doit:)
			)
		)
	)
)

(instance startGame of Code
	(properties)

	(method (doit)
		(if
			(<=
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
				5
			)
			(SetFlag 114)
		)
		(= gHowFast
			(cond
				((> gHowFast 11) 2)
				((< gHowFast 4) 0)
				(else 1)
			)
		)
		(gGame
			detailLevel:
				(switch gHowFast
					(0 0)
					(1 2)
					(else 3)
				)
		)
		(User canControl: 1 canInput: 1)
		(gTheIconBar enable:)
		(= global102 0)
		(gGame setSpeed: 2)
		(Palette palSET_INTENSITY 0 255 100)
		(= gEatMice global18)
		(cond
			((and (not global327) global100)
				(proc0_19)
			)
			(global322
				(gEgo get: 28) ; Wand
				(gCurRoom newRoom: 1)
			)
			(else
				(= global287 (GetTime))
				(gCurRoom newRoom: 119) ; kq5Title
			)
		)
	)
)

