;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm27 0
)

(local
	confettiFalling
	numConfetti
)

(instance rm27 of Rm
	(properties
		picture 27
		east 28
	)

	(method (init)
		(Load rsVIEW 238)
		(super init:)
		(NormalEgo 0)
		(gEgo posn: 8 134 setPri: 13 init:)
		(self setScript: rm27Script)
	)
)

(instance rm27Script of Script
	(properties)

	(method (doit &tmp i)
		(super doit:)
		(if (and (not confettiFalling) (> (gEgo x:) 160))
			(Print 27 0) ; "It looks like you just made it; the ship is almost ready to leave!"
			(= confettiFalling 1)
			(cond
				((> gMachineSpeed 80)
					(= numConfetti 5)
				)
				((> gMachineSpeed 60)
					(= numConfetti 4)
				)
				((> gMachineSpeed 40)
					(= numConfetti 3)
				)
				((> gMachineSpeed 20)
					(= numConfetti 2)
				)
				(else
					(= numConfetti 1)
				)
			)
			(= numConfetti 4)
			(for ((= i 0)) (< i numConfetti) ((++ i))
				((Act new:)
					view: 238
					setPri: 14
					illegalBits: 0
					setStep: 1 5
					ignoreActors:
					ignoreHorizon:
					setCycle: Fwd
					init:
					setScript: (confettiScript new:)
				)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (and confettiFalling (Said '/confetti'))
				(Print 27 1) ; "Isn't it pretty!"
			)
			(if (Said '/hull,craft,boat,up')
				(Print 27 2) ; "The ship rises beside you."
			)
			(if (Said '/cup,hole')
				(Print 27 3) ; "Inside the ship, people are overeating."
			)
			(if (Said '[/airport,carpet]')
				(Print 27 4) ; "The massive hull of the ocean liner rises beside the gangplank. Above you, people are in a festive mood, anticipating the impending departure of the U.S.S. Love Tub."
				(if confettiFalling
					(Print 27 5) ; "Somebody up there is littering!"
				)
			)
		)
	)
)

(instance confettiScript of Script
	(properties)

	(method (changeState newState &tmp tmpX tmpLoop tmpCel)
		(switch (= state newState)
			(0
				(= tmpX (Random 2 300))
				(= tmpLoop (Random 0 7))
				(= tmpCel (Random 0 1))
				(client
					setPri: 14
					setLoop: tmpLoop
					cel: tmpCel
					setStep: -1 (Random 5 12)
					posn: tmpX (- 0 (CelHigh 238 tmpLoop tmpCel))
					show:
					setMotion: MoveTo tmpX 180 self
				)
			)
			(1
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

