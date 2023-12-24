;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use n001)
(use Motion)
(use Game)
(use Actor)

(public
	speedChecker 0
)

(local
	doneTime
	wasTeleporting
)

(instance fred of Actor
	(properties)
)

(instance speedChecker of Rm
	(properties
		picture 2
		style 6
	)

	(method (init)
		(HandsOff)
		(= wasTeleporting (IsFlag 28)) ; fTeleporting
		(super init:)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 98
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= gMachineSpeed 0)
	)

	(method (doit &tmp versionFile)
		(super doit:)
		(if (== (++ gMachineSpeed) 1)
			(= doneTime (+ 60 (GetTime)))
		)
		(if (u< doneTime (GetTime))
			(cond
				((<= gMachineSpeed 24)
					(= gHowFast 0)
				)
				((<= gMachineSpeed 44)
					(= gHowFast 1)
				)
				((<= gMachineSpeed 80)
					(= gHowFast 2)
				)
				(else
					(= gHowFast 3)
				)
			)
			(= gDftHowFast gHowFast)
			(= versionFile (FileIO fiOPEN {version} 1))
			(FileIO fiREAD_STRING gVersion 9 versionFile)
			(FileIO fiCLOSE versionFile)
			(gGame setSpeed: 5)
			(RedrawCast)
			(if wasTeleporting
				(SetFlag 28) ; fTeleporting
			)
			(gCurRoom newRoom: gTransferRoom)
		)
	)
)

