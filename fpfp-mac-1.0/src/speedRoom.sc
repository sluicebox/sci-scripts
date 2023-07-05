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

	(method (init &tmp temp0)
		(LoadMany rsVIEW 1000)
		(gTheIconBar disable:)
		(super init:)
		(gEgo setSpeed: 0)
		(gGame setCursor: 999 1)
		(= temp0 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 10 temp0)
		(FileIO fiCLOSE temp0)
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
				(gTheIconBar disable: 0 2 1 3 6)
				(Platform 0 4 3 9)
				(Platform 0 4 3 -1)
				(Load rsVIEW 99)
				(gGame setCursor: gNormalCursor)
				(= cycles 1)
			)
			(1
				(Platform 0 2 0)
				(= local1 (GetTime))
				(fred
					view: 1000
					setLoop: 0
					illegalBits: 0
					posn: 0 0
					setStep: 1 1
					setSpeed: 0
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(2
				(= local1 (GetTime))
				(fred setMotion: MoveTo 320 190)
				(= cycles 50)
			)
			(3
				(= local0 (- (GetTime) local1))
				(Platform 0 2 1)
				(= cycles 1)
			)
			(4
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
		(gEgo setSpeed: 7)
		(gCurRoom newRoom: 100)
	)
)

