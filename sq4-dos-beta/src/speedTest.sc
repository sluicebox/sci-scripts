;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
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
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 803
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= global170 (Random 0 9))
		(= gSpeed 0)
		(= local1 0)
		(= local3 (if (IsFlag 23) 90 else 40))
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(if (< local1 local3)
				(= global101 0)
				(gGame detailLevel: 1)
			else
				(= global101 2)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
		(User blocks: 0)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= gSpeed 6)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: global107)
			)
		)
	)
)

