;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Scaler)
(use Motion)
(use System)

(public
	startupScr 0
)

(instance startupScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 6
					posn: 173 133
					show:
					view: 201
					loop: 0
					cel: 0
					normal: 0
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(gMessager say: 1 0 1 1 self) ; "Alexander awakens to find himself on an unfamiliar beach. For a moment, he is too dazed to remember how he got here."
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo posn: 177 127 reset: 5 setScale: Scaler 100 50 112 57)
				(= ticks 20)
			)
			(4
				(gEgo loop: 2)
				(= cycles 2)
			)
			(5
				(gMessager say: 1 0 1 2 self) ; "Then he does remember. The shipwreck...the sea. Just as he had seen his men safely into the life boats, a gigantic wave picked him up and tossed him overboard, into the churning sea."
			)
			(6
				(gMessager say: 1 0 1 3 self oneOnly: 0) ; "That was the last he'd seen of his crew. Debris from the shipwreck is scattered along the shore, but of the life boats and his men, there is thankfully no trace."
			)
			(7
				(gGame handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 201)
	)
)

