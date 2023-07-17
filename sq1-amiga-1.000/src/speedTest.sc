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
	local4
)

(instance fred of Actor
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 99
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
			view: 902
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= gSpeed 0)
		(= local1 0)
		(= local4
			(cond
				((== global105 32) 60)
				((not (<= 2 global105 16)) 110)
				(else 50)
			)
		)
		(= local3
			(cond
				((== global105 32) 40)
				((not (<= 2 global105 16)) 65)
				(else 30)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(cond
				((< local1 local3)
					(= gHowFast 0)
					(gGame detailLevel: 1)
				)
				((< local1 local4)
					(= gHowFast 1)
					(gGame detailLevel: 2)
				)
				(else
					(= gHowFast 2)
					(gGame detailLevel: 3)
				)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
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
				(= gSpeed 1)
				(= cycles 1)
			)
			(2
				(if (== gHowFast 0)
					(gGame egoMoveSpeed: 0 setSpeed: 0)
				)
				(gCurRoom newRoom: global107)
			)
		)
	)
)

