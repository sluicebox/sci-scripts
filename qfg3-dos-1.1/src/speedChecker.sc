;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
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
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 936
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global102 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ global102) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond
				((<= global102 25)
					(= gHowFast 0)
				)
				((<= global102 40)
					(= gHowFast 1)
				)
				((<= global102 60)
					(= gHowFast 2)
				)
				(else
					(= gHowFast 3)
				)
			)
			(gGame setSpeed: 5)
			(Animate (gCast elements:) 0)
			(gCurRoom newRoom: global207)
		)
	)
)

