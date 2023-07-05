;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	speedTest 0
)

(local
	local0
	local1
	local2
)

(instance fred of Act
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 99
		style 6
	)

	(method (init)
		(MenuBar state: 0)
		(HandsOff)
		(= local2 (FOpen {version} 1))
		(FGets gVersion 6 local2)
		(FClose local2)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 799
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= local1 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(cond
				((<= local1 30)
					(= global132 0)
				)
				((<= local1 60)
					(= global132 1)
				)
				(else
					(= global132 2)
				)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
		(HandsOn)
		(User blocks: 0)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame setSpeed: 6)
				(= cycles 1)
			)
			(2
				(MenuBar state: 1)
				((ScriptID 950) doit: @global70 0) ; sysLogger
				(gCurRoom newRoom: 100) ; introRm
			)
		)
	)
)

