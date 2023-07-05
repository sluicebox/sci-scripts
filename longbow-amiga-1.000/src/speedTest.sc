;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	speedTest 0
)

(local
	local0
	local1
	local2
	local3
)

(instance fred of Actor
	(properties
		x 20
		y 100
		view 803
		illegalBits 0
	)
)

(instance speedTest of Rm
	(properties
		picture 803
		style 100
	)

	(method (init)
		(= local3 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 6 local3)
		(FileIO fiCLOSE local3)
		(super init: &rest)
		(self setScript: speedScript)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(for ((= temp0 0)) (< temp0 500) ((++ temp0))
		)
	)
)

(instance speedScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 803)
				(gSounds eachElementDo: #stop)
				(= cycles 1)
			)
			(1
				(= local1 (GetTime))
				(fred
					setLoop: 0
					setStep: 1 1
					setCycle: Fwd
					init:
					setMotion: MoveTo 100 100 self
				)
			)
			(2
				(= gHowFast
					(cond
						(
							(>
								(= gHowFast
									(cond
										((> (= local0 (- (GetTime) local1)) 600) 0)
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
						((< gHowFast 4) 0)
						(else 1)
					)
				)
				(gGame
					detailLevel:
						(switch gHowFast
							(0 1)
							(1 2)
							(else 4)
						)
					setSpeed: (= temp0 (+ (* 2 gHowFast) 1))
				)
				(gEgo moveSpeed: temp0 cycleSpeed: temp0)
				(Palette palSET_INTENSITY 0 255 100)
				(= gEatMice global18)
				(gTheIconBar enable:)
				(gCurRoom newRoom: global147)
			)
		)
	)
)

