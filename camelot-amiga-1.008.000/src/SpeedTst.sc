;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	SpeedTst 0
)

(local
	local0
	local1
)

(instance SpeedTst of Rm
	(properties
		picture 112
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gEgo
			view: 750
			setLoop: 0
			posn: 20 100
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= local1 0)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (< local0 (GetTime))
			(= global103
				(cond
					((< local1 30) 0)
					((< local1 60) 1)
					(else 2)
				)
			)
			(gCurRoom newRoom: 100) ; Title
		)
	)
)

