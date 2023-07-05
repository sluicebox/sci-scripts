;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)

(public
	rm99 0
)

(local
	local0
)

(instance rm99 of Rm
	(properties
		picture 450
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gEgo
			view: 450
			setLoop: 0
			posn: 20 100
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= global110 0)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ global110) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (< local0 (GetTime))
			(if (IsFlag 167)
				(gGame setSpeed: 6)
				(MenuBar draw:)
				(SL enable:)
				(NormalEgo)
				(gCurRoom newRoom: 1)
			else
				(gCurRoom newRoom: 200) ; Introduction
			)
		)
	)
)

