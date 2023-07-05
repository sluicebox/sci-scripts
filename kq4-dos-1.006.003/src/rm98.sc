;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	rm98 0
)

(local
	local0
)

(instance rm98 of Rm
	(properties
		picture 991
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gEgo
			view: 991
			setLoop: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ global222) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (< local0 (GetTime))
			(cond
				((<= global222 30)
					(= global223 0)
				)
				((<= global222 60)
					(= global223 1)
				)
				(else
					(= global223 2)
				)
			)
			(gGame setSpeed: 6)
			(HandsOn)
			(gCurRoom newRoom: 698)
		)
	)
)

