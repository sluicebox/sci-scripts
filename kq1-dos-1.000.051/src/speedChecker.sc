;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 777)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	speedChecker 0
)

(local
	local0
)

(instance fred of Actor
	(properties)
)

(instance speedChecker of Rm
	(properties
		picture 777
		style 6
	)

	(method (init)
		(HandsOff)
		(Load rsVIEW 777)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) 64512)
		)
		(fred
			view: 777
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global100 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ global100) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond
				((<= global100 30)
					(= global101 0)
				)
				((<= global100 60)
					(= global101 1)
				)
				((<= global100 90)
					(= global101 2)
				)
				(else
					(= global101 3)
				)
			)
			(gGame
				setSpeed:
					(switch global101
						(1 3)
						(0 1)
						(else 5)
					)
			)
			(proc0_7)
			(HandsOn)
			(gCurRoom newRoom: global102)
		)
	)
)

