;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm70 0
)

(local
	aBigEgo
	aBigEgoBottom
	aSparkle
)

(instance theSound of Sound
	(properties
		number 1
	)
)

(instance rm70 of Rm
	(properties
		picture 70
		horizon 1
	)

	(method (init)
		(Load rsVIEW 170)
		(Load rsSOUND 1)
		(theSound init:)
		(super init:)
		((= aSparkle (Prop new:))
			view: 170
			setLoop: 3
			setPri: 15
			posn: 120 123
			init:
			hide:
		)
		((= aBigEgo (Act new:))
			view: 170
			posn: 120 103
			setPri: 14
			illegalBits: 0
			init:
		)
		((= aBigEgoBottom (View new:)) view: 170 cel: 1 posn: 120 133 init:)
		(gEgo setMotion: 0)
		(User canControl: 0 canInput: 1)
		(= gCurrentStatus 20)
		(self setRegions: 700 setScript: rm70Script) ; rm700
	)
)

(instance rm70Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/parachute')
				(Print 70 0) ; "It's caught in the tree, and you're caught in it!"
			)
			(if (Said '[/airport,branch,palm,forest,bush]')
				(Print 70 1) ; "Now you're REALLY out on a limb!"
				(Print 70 2) ; "The ground is far below you, and you're stuck in a parachute you bought from a vending machine!"
			)
		)
		(if (Said 'swing')
			(Print 70 3) ; "Doobee doobee do."
		)
		(if (Said 'drain,(get<off),free,free,open,pull/cord,parachute,buckle')
			(Print 70 4) ; "You try your best, but the parachute harness' buckles are jammed."
		)
		(if (Said 'hop,carry,climb')
			(Print 70 5) ; "You try, but the parachute harness holds you safely in place."
		)
		(if (or (Said 'apply/gun') (Said 'cut/parachute,buckle,bathing'))
			(Print 70 6) ; "A good idea..."
			(if (gEgo has: 17) ; Knife
				(self changeState: 3)
			else
				(Print 70 7) ; "But, with what?"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gEgo has: 17)) ; Knife
					(= seconds 10)
				)
			)
			(1
				(Print 70 8) ; "Struggling to free yourself from the parachute harness, you realize the buckles are hopelessly jammed!"
				(Print 70 9) ; "Try as you might, you are unable to fix them, or free yourself."
				(= seconds 4)
			)
			(2
				(Print 70 10) ; "Although you often have fun by just hanging around, this time you'd prefer to cut yourself down."
				(Print 70 11) ; "That's what you get for buying a parachute from a vending machine!"
				(= gCurrentStatus 1001)
			)
			(3
				(User canInput: 0)
				(aBigEgo cycleSpeed: 2 setLoop: 1 setCycle: End self)
			)
			(4
				(aBigEgo cycleSpeed: 1 setLoop: 4 setCycle: Fwd)
				(= cycles 40)
			)
			(5
				(gGame changeScore: 8)
				(Print 70 12 #at -1 15 #width 280) ; "You saw away at the parachute harness with the dull cheese knife, eventually turning it into a mere thread supporting your entire body weight. Suddenly, you look down, and consider the consequences of falling to the jungle floor from this height!"
				(Print 70 13 #at -1 20) ; "But you don't consider it for long..."
				(aBigEgoBottom dispose:)
				(theSound play:)
				(aBigEgo
					setStep: 1 10
					setLoop: 2
					cel: 0
					setCycle: End
					setMotion: MoveTo (aBigEgo x:) 255 self
				)
			)
			(6
				(aSparkle show: setCycle: End self)
			)
			(7
				(aSparkle dispose:)
				(gCurRoom newRoom: 71)
			)
		)
	)
)

