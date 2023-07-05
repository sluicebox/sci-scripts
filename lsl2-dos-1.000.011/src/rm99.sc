;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Menu)

(public
	rm99 0
)

(local
	doneTime
)

(instance rm99 of Rm
	(properties
		picture 178
		style 6
	)

	(method (init)
		(HandsOff)
		(super init:)
		(gEgo
			view: 253
			setLoop: 2
			posn: 20 100
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(gGame setSpeed: 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ gMachineSpeed) 1)
			(= doneTime (+ 60 (GetTime)))
		)
		(if (< doneTime (GetTime))
			(if gLogging
				(Print (Format @gString 99 0 gMachineSpeed)) ; "Attention QA: this machine has an Al Lowe speed rating of %d. Please write down the number and the type of machine you're on."
				(Print 99 1 #at -1 152) ; "(Note: your mileage may vary.)"
			)
			(gGame setSpeed: 6)
			(TheMenuBar draw:)
			(SL enable:)
			(gCurRoom newRoom: 23)
		)
	)
)

