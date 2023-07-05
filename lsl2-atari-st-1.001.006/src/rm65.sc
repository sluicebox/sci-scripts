;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm65 0
)

(local
	work
	numClouds
)

(instance rm65 of Rm
	(properties
		picture 65
		horizon 5
	)

	(method (init &tmp i cloud)
		(Load rsVIEW 607)
		(Load rsVIEW 620)
		(super init:)
		((View new:)
			view: 607
			loop: 1
			cel: 0
			posn: 0 179
			setPri: 15
			ignoreActors:
			addToPic:
		)
		(= numClouds (Random 2 6))
		(for ((= i 0)) (< i numClouds) ((++ i))
			((View new:)
				view: 620
				cel: (Random 0 10)
				ignoreActors:
				posn: (Random -10 330) (Random 5 120)
				addToPic:
			)
		)
		(self setScript: rm65Script)
		(gEgo ignoreHorizon: posn: 144 -21)
		(if (== gCurrentStatus 12)
			(gEgo loop: 0 setStep: 3 4 init:)
			(rm65Script changeState: 0)
		else
			(= gCurrentStatus 10)
			(gEgo loop: 1 setStep: 1 1 cycleSpeed: 4 init:)
			(rm65Script changeState: 6)
		)
		(User canInput: 1 canControl: 0)
	)
)

(instance rm65Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/hill,island,hill')
				(if (== gCurrentStatus 12)
					(Print 65 0) ; "How you hope you will NOT land there!"
				else
					(Print 65 1) ; "How you hope you will land there!"
				)
			)
			(if (Said '/water,lagoon,lagoon')
				(Print 65 2) ; "It appears to be approaching!"
			)
			(if (Said '/cloud')
				(Print 65 3) ; "They appear to be receding!"
			)
			(if (Said '[/airport,around,cloud]')
				(if (== gCurrentStatus 12)
					(Print 65 4) ; "The view from this height is spectacular, but rather wobbly."
				else
					(Print 65 5) ; "The view from this height is spectacular."
				)
			)
		)
		(if (Said 'apply,open,pull/cord,parachute')
			(if (!= gCurrentStatus 12)
				(Print 65 6) ; "Again?"
			else
				(Print 65 7) ; "Good idea, Larry."
				(if (== gWearingParachute 1)
					(rm65Script changeState: 4)
				else
					(Print 65 8) ; "But you aren't wearing a parachute!"
				)
			)
		)
		(if (Said '(drop<on),wear,afix,buckle,afix/parachute')
			(cond
				((== gWearingParachute 1)
					(Print 65 9) ; "You are!"
				)
				((gEgo has: 24) ; Parachute
					(Print 65 10) ; "You valiently struggle with the balky straps. However even a macho stud like you is incapable of donning a parachute while plummeting through the atmosphere at terminal velocity."
				)
				(else
					(Print 65 11) ; "You don't seem to have one!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 144 177 self)
			)
			(1
				(gEgo
					view: 607
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo hide:)
				(= seconds 3)
			)
			(3
				(Print 65 12) ; "Larry, you must remember the old saying..."
				(if (Random 0 1)
					(Print 65 13) ; "Skydivers are good to the very last drop!"
				else
					(Print 65 14) ; "It don't mean a thing, if you don't pull that string!"
				)
				(= gCurrentStatus 1001)
			)
			(4
				(= gCurrentStatus 10)
				(= seconds (= cycles 0))
				(User canInput: 0)
				(Print 65 15) ; "The blessed parachute blossoms above you, jerking you around a lot, a feeling not wholly unfamiliar to you!"
				(gEgo
					loop: 1
					setStep: 1 1
					cycleSpeed: 4
					setMotion: MoveTo (- (gEgo x:) 20) 147 self
				)
			)
			(5
				(Print 65 16) ; "Unfortunately, you pulled a little too late to hit that island over there!"
				(gEgo setMotion: MoveTo (- (gEgo x:) 10) 177 self)
				(= state 0)
			)
			(6
				(= seconds (= cycles 0))
				(= gCurrentStatus 10)
				(User canInput: 0)
				(gEgo
					loop: 1
					setStep: 1 1
					setMotion: MoveTo 17 178 self
					setPri: 2
				)
			)
			(7
				(gEgo hide:)
				(= seconds 3)
			)
			(8
				(gCurRoom newRoom: 70)
			)
		)
	)
)

