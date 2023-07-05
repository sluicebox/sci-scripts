;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Interface)
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
		(HandsOff)
		(if (not global194)
			(= local2 (FOpen {version} 1))
			(FGets gVersion 6 local2)
			(FClose local2)
		)
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
		(TheMenuBar hide:)
		(SL disable:)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(cond
				((<= local1 30)
					(= global131 0)
				)
				((<= local1 60)
					(= global131 1)
				)
				(else
					(= global131 2)
				)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
		(User blocks: 0)
		(super dispose:)
		(HandsOn)
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
				(= gAniThreshold 20)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(= cycles 1)
			)
			(2
				(if global194
					(if (< gPrevRoomNum 199) ; intro
						(Print 99 0 #time 5) ; "Your game has been saved."
					)
					(gCurRoom newRoom: 199) ; intro
				else
					(gCurRoom newRoom: (if global133 199 else 96))
				)
			)
		)
	)
)

