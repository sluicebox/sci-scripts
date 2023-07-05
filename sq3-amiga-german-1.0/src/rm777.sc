;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 777)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm777 0
)

(local
	local0
)

(instance fred of Actor
	(properties)
)

(instance rm777 of Rm
	(properties
		picture 777
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 778
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
		(= global123 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ global123) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond
				((<= global123 30)
					(= global124 0)
				)
				((<= global123 60)
					(= global124 1)
				)
				(else
					(= global124 2)
				)
			)
			(gGame setSpeed: 5)
			(RedrawCast)
			(HandsOn)
			(gCurRoom newRoom: global125)
		)
	)
)

