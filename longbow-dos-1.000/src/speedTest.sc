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
	local0
	local1
	local2
	local3
	local4
)

(instance fred of Actor
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 803
		style 100
	)

	(method (init)
		(= local2 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 6 local2)
		(FileIO fiCLOSE local2)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 803
			x: 0
			y: 99
			setStep: 1 1
			setMotion: MoveTo 319 99
			setCycle: Walk
			init:
		)
		(= gMachineSpeedZeroOrSix 0)
		(= local1 0)
		(= local3 (if (IsFlag 0) 90 else 60))
		(= local4 (if (IsFlag 0) 59 else 30))
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(= gHowFast
				(cond
					((> local1 local3) 2)
					((> local1 local4) 1)
					(else 0)
				)
			)
			(gGame detailLevel: (+ gHowFast 1))
			(= global141 (+ gHowFast 4))
			(= gMachineSpeedZeroOrSix 6)
			(gGame egoMoveSpeed: global141)
			(gEgo moveSpeed: global141 cycleSpeed: global141)
			(gTheIconBar enable:)
			(gCurRoom newRoom: global147)
		)
	)
)

