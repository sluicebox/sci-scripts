;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm64 0
)

(local
	numClouds
	aPlane
)

(instance rm64 of Rm
	(properties
		picture 64
		horizon 5
	)

	(method (init &tmp i cloud)
		(Load rsVIEW 162)
		(Load rsVIEW 511)
		(Load rsVIEW 620)
		(super init:)
		((= aPlane (Act new:))
			view: 511
			setLoop: 5
			setCel: 0
			posn: 155 7
			illegalBits: 0
			setStep: 3
			setMotion: MoveTo -20 8
			init:
		)
		(= numClouds (Random 2 6))
		(for ((= i 0)) (< i numClouds) ((++ i))
			((View new:)
				view: 620
				cel: (Random 0 10)
				ignoreActors:
				posn: (Random -10 330) (Random 5 188)
				addToPic:
			)
		)
		(gEgo
			view: 162
			posn: 160 8
			setCycle: Fwd
			loop: 0
			setStep: -1 3
			init:
		)
		(= gCurrentStatus 12)
		(self setScript: rm64Script)
		(User canInput: 1 canControl: 0)
	)
)

(instance rm64Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look')
			(if (== gCurrentStatus 12)
				(Print 64 0) ; "The view from this height is spectacular, but wobbly."
			else
				(Print 64 1) ; "The view from this height is spectacular."
			)
		)
		(if (Said 'apply,open,pull/cord,parachute')
			(if (!= gCurrentStatus 12)
				(Print 64 2) ; "Again?"
			else
				(Print 64 3) ; "Good idea, Larry!"
				(if (== gWearingParachute 1)
					(self changeState: 2)
				else
					(Print 64 4) ; "But you aren't wearing a parachute!"
				)
			)
		)
		(if (Said '(drop<on),wear,afix,buckle,afix/parachute')
			(cond
				((== gWearingParachute 1)
					(Print 64 5) ; "You are!"
				)
				((gEgo has: 24) ; Parachute
					(Print 64 6) ; "You valiently struggle with the balky straps. However even a macho stud like you is incapable of donning a parachute while plummeting through the atmosphere at terminal velocity."
				)
				(else
					(Print 64 7) ; "You don't seem to have one!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 144 208 self)
			)
			(1
				(gCurRoom newRoom: 65)
			)
			(2
				(gEgo
					loop: 1
					setStep: -1 1
					cycleSpeed: 4
					setMotion: MoveTo 144 208 self
				)
				(= gCurrentStatus 10)
				(Print 64 8 #draw) ; "The blessed parachute blossoms above you, jerking you around a lot, a feeling not wholly unfamiliar to you!"
			)
			(3
				(gCurRoom newRoom: 65)
			)
		)
	)
)

