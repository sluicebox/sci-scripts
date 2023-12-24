;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	speedTest 0
)

(local
	doneTime
	machineSpeed
	cfgHandle
	fastThreshold
	mediumThreshold
)

(instance fred of Actor
	(properties)
)

(instance speedTest of Rm
	(properties
		style 100
	)

	(method (init)
		(= cfgHandle (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 6 cfgHandle)
		(FileIO fiCLOSE cfgHandle)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 854
			x: 0
			y: 99
			setStep: 1 1
			setMotion: MoveTo 319 99
			setCycle: Walk
			init:
		)
		(= gSpeed 0)
		(= machineSpeed 0)
		(= fastThreshold (if (IsFlag 44) 90 else 60)) ; isVga
		(= mediumThreshold (if (IsFlag 44) 39 else 15)) ; isVga
	)

	(method (doit)
		(super doit:)
		(if (== (++ machineSpeed) 1)
			(Platform 0 2 0)
			(= doneTime (+ 60 (GetTime)))
		)
		(if (u< doneTime (GetTime))
			(Platform 0 2 1)
			(cond
				((> machineSpeed fastThreshold)
					(= global101 1)
					(gGame detailLevel: 3)
					(= gLarrySpeed (+ 1 global101))
					(= gSpeed 1)
				)
				((> machineSpeed mediumThreshold)
					(= global101 0)
					(gGame detailLevel: 2)
					(= gLarrySpeed (+ 1 global101))
					(= gSpeed 1)
				)
				(else
					(= global101 0)
					(gGame detailLevel: 1)
					(= gLarrySpeed (+ 1 global101))
					(= gSpeed 0)
				)
			)
			(gGame egoMoveSpeed: gLarrySpeed)
			(gEgo moveSpeed: gLarrySpeed cycleSpeed: gLarrySpeed)
			(gCurRoom newRoom: gRestartRoom)
		)
	)
)

