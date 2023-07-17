;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
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
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 99
		style 100
	)

	(method (init)
		(ScriptID 882)
		(= local2 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 6 local2)
		(FileIO fiCLOSE local2)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 99
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
		(= local3 (if (IsFlag 2) 90 else 40))
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(if (< local1 local3)
				(= gHowFast 0)
				(gGame detailLevel: 1)
			else
				(= gHowFast 2)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
		(DisposeScript 882)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 255 100)
				(fred setMotion: 0)
				(= cycles 1)
			)
			(1
				(= gSpeed 2)
				(= cycles 1)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: global104)
			)
		)
	)
)

