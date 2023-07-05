;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n821)
(use n954)
(use Chase)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	guardjReg 0
)

(local
	local0
)

(instance guardjReg of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 77 78 79 80 82 83)) ; roadToTownRm, townRm1, townRm2, agentsBuildingRm, townRm3, townRm4
		(= initialized 0)
		(super newRoom: &rest)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 472)
		(Load rsVIEW 476)
		(jeep
			setCycle: 0
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			init:
			hide:
		)
		(cond
			((== gCurRoomNum 80) ; agentsBuildingRm
				(if (tunisia bagBound:)
					(jeep setScript: 0)
				else
					(jeep setScript: fromEastScript)
				)
			)
			((OneOf gCurRoomNum 77 82) ; roadToTownRm, townRm3
				(straightScript seconds: 20)
				(jeep setScript: straightScript)
			)
			(else
				(fromWestScript seconds: 20)
				(jeep setScript: fromWestScript)
			)
		)
	)
)

(instance straightScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0)
			(1
				(if (> 140 (gEgo y:) 100)
					(= register 1)
					(HandsOff)
					(Print 312 0 #dispose #at 5 10) ; "You see a jeep coming from the east and move to avoid being run over."
					(if (< (gEgo y:) 120)
						(gEgo setMotion: MoveTo (gEgo x:) 99 self)
					else
						(gEgo setMotion: MoveTo (gEgo x:) 141 self)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(if (< (gEgo y:) 120)
						(gEgo heading: 180)
					else
						(gEgo heading: 0)
					)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 5)
				else
					(= cycles 1)
				)
			)
			(3
				(cond
					((< (gEgo x:) 30)
						(= temp0 (+ (gEgo x:) 30))
					)
					((> (gEgo x:) 290)
						(= temp0 (- (gEgo x:) 30))
					)
					(else
						(= temp0 (gEgo x:))
					)
				)
				(jeep
					posn: 380 120
					view: 476
					setLoop: 0
					setCel: 0
					show:
					setCycle: 0
					setStep: 8 8
					setMotion: MoveTo temp0 120 self
				)
			)
			(4
				(proc0_3)
				(jeep
					setStep: 6 6
					setMotion: MoveTo (- (jeep x:) 12) (jeep y:) self
				)
			)
			(5
				(jeep
					setStep: 4 4
					setMotion: MoveTo (- (jeep x:) 8) (jeep y:) self
				)
			)
			(6
				(jeep
					setStep: 2 2
					setMotion: MoveTo (- (jeep x:) 4) (jeep y:) self
				)
			)
			(7
				(jeep setStep: 0 0 loop: 4)
				(guard
					view: 476
					loop: 3
					cel: 0
					ignoreActors: 1
					posn: (jeep x:) (jeep y:)
					setPri: (jeep priority:)
					init:
					setCycle: End self
				)
			)
			(8
				(jeep ignoreActors: 0)
				(guard
					view: 472
					setPri: -1
					posn: (jeep x:) (- (jeep y:) 10)
					illegalBits: -32768
					ignoreActors: 0
					loop: 2
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					setAvoider: Avoid
					setMotion: Chase gEgo 20 self
				)
			)
			(9
				(self setScript: caughtEgoScript self)
			)
			(10
				(client setScript: driveAwayScript 0 -1)
			)
		)
	)
)

(instance fromWestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(if (gEgo inRect: 0 120 106 168)
					(= register 1)
					(HandsOff)
					(Print 312 1 #dispose #at 5 10) ; "You see a jeep coming from the west and move to avoid being run over."
					(gEgo setMotion: MoveTo 178 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(gEgo heading: 270)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 5)
				else
					(= cycles 1)
				)
			)
			(3
				(jeep
					posn: -4 120
					view: 476
					setLoop: 1
					setCel: 0
					show:
					setStep: 8 8
					setMotion: MoveTo 60 120 self
				)
			)
			(4
				(proc0_3)
				(jeep setStep: 4 4)
				(self setScript: uTurnScript self 1)
			)
			(5
				(jeep setLoop: 4)
				(guard
					view: 476
					loop: 3
					cel: 0
					ignoreActors: 1
					posn: (jeep x:) (jeep y:)
					setPri: (jeep priority:)
					init:
					setCycle: End self
				)
			)
			(6
				(jeep ignoreActors: 0)
				(guard
					view: 472
					posn: (+ (jeep x:) 6) (- (jeep y:) 2)
					illegalBits: -32768
					ignoreActors: 0
					setPri: -1
					loop: 2
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					setAvoider: Avoid
					setMotion: Chase gEgo 20 self
				)
			)
			(7
				(self setScript: caughtEgoScript self)
			)
			(8
				(client setScript: driveAwayScript 0 -1)
			)
		)
	)
)

(instance fromEastScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (gEgo inRect: 228 120 319 168)
					(= register 1)
					(HandsOff)
					(Print 312 0 #dispose #at 5 10) ; "You see a jeep coming from the east and move to avoid being run over."
					(gEgo setMotion: MoveTo 205 (gEgo y:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(gEgo heading: 90)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 5)
				else
					(= cycles 1)
				)
			)
			(3
				(jeep view: 476 setLoop: 0 setCel: 0 show: setStep: 8 8)
				(jeep posn: 360 120 setMotion: MoveTo 270 120 self)
			)
			(4
				(proc0_3)
				(jeep setStep: 4 4)
				(self setScript: uTurnScript self -1)
			)
			(5
				(jeep setLoop: 5)
				(guard
					view: 476
					loop: 2
					cel: 0
					ignoreActors: 1
					posn: (jeep x:) (jeep y:)
					setPri: (jeep priority:)
					init:
					setCycle: End self
				)
			)
			(6
				(jeep ignoreActors: 0)
				(guard
					view: 472
					posn: (- (jeep x:) 6) (- (jeep y:) 2)
					illegalBits: -32768
					ignoreActors: 0
					setPri: -1
					loop: 2
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					setAvoider: Avoid
					setMotion: Chase gEgo 20 self
				)
			)
			(7
				(self setScript: caughtEgoScript self)
			)
			(8
				(self setScript: driveAwayScript 0 1)
			)
		)
	)
)

(instance uTurnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jeep
					setMotion:
						MoveTo
						(+ (jeep x:) (* 6 register))
						(+ (jeep y:) 6)
						self
				)
			)
			(1
				(jeep setCel: (+ (jeep cel:) 1))
				(cond
					((== (jeep cel:) 4)
						(= local0 register)
						(= register 0)
						(self init:)
					)
					((== (jeep cel:) 5)
						(= register (- (* local0 2)))
						(self init:)
					)
					((== (jeep cel:) 8)
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
		)
	)
)

(instance driveAwayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard setMotion: MoveTo (+ (jeep x:) 6) (- (jeep y:) 12) self)
			)
			(1
				(guard
					setPri: (- (jeep priority:) 1)
					setAvoider: 0
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo (jeep x:) (jeep y:) self
				)
			)
			(2
				(guard
					view: 476
					setLoop: (if (== register 1) 2 else 3)
					setCel: 16
					setPri: (jeep priority:)
					ignoreActors: 1
					setCycle: Beg self
				)
			)
			(3
				(jeep dispose:)
				(guard
					view: 476
					ignoreActors: 0
					setLoop: (if (== register 1) 1 else 0)
					setCel: 0
					setStep: 2 2
					setMotion:
						MoveTo
						(+ (guard x:) (* 4 register))
						(guard y:)
						self
				)
			)
			(4
				(guard
					setStep: 4 4
					setMotion:
						MoveTo
						(+ (guard x:) (* 8 register))
						(guard y:)
						self
				)
			)
			(5
				(guard
					setStep: 6 6
					setMotion:
						MoveTo
						(+ (guard x:) (* 12 register))
						(guard y:)
						self
				)
			)
			(6
				(guard
					setStep: 8 8
					setMotion:
						MoveTo
						(if (== register 1) 380 else -60)
						(guard y:)
						self
				)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance caughtEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== register 0)
					(proc310_1 guard)
				)
				(= seconds 2)
			)
			(1
				(if (== register 0)
					(proc310_2)
					(Print 312 2) ; ""Halt," the guard yells."
					(gEgo
						heading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(guard x:)
								(guard y:)
							)
					)
					((gEgo looper:) doit: gEgo (gEgo heading:))
				)
				(= cycles 5)
			)
			(2
				(proc310_1 guard)
				(= seconds 1)
			)
			(3
				(proc310_2)
				(proc310_1 gEgo)
				(= seconds 1)
			)
			(4
				(proc310_2)
				(= cycles 1)
				(if (<= (++ register) 3)
					(self init:)
				)
			)
			(5
				(cond
					((== (gEgo view:) 71)
						(Print 312 3) ; "After questioning, you are unable to explain away the wet suit or provide identification."
						(= cycles 1)
					)
					((and (gEgo has: 5) ((gInventory at: 5) loop:)) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 312 4) ; "The guard searches you, finding the map to Stacy's apartment."
						(= cycles 1)
					)
					((gEgo has: 2) ; ID_Card
						(Print 312 5) ; "The guard demands identification."
						(Print 312 6) ; "Satisfied, the guard allows you to continue."
						(Print 312 7) ; "Whew," you think, "that was close!"
						(HandsOn)
						(self dispose:)
					)
					(else
						(Print 312 8) ; "Unable to produce identification..."
						(= cycles 1)
					)
				)
			)
			(6
				(EgoDead 970 0 0 312 9) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance guard of Act
	(properties
		view 476
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/guard,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (or (& signal $0008) (IsOffScreen self))
							(Print 312 10) ; "You don't see any guards, but you know they must be lurking around here somewhere."
						else
							(Print 312 11) ; "He's a pretty mean-looking guy."
							(event claimed: 1)
						)
					)
					((or (& signal $0008) (IsOffScreen self))
						(event claimed: 0)
					)
					((Said 'talk')
						(Print 312 12) ; "He's not in the mood for conversation."
					)
					((Said 'kiss,fuck,hug')
						(Print 312 13) ; "He'll rip your lungs out if you try anything like that!"
					)
					((Said 'kill,shoot')
						(if (gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
							(Print 312 14) ; "You almost use the weapon but decide to save your limited ammo for the compound guards."
						else
							(Print 312 15) ; "You don't have a weapon."
						)
					)
					((Said 'fight,kick,hit')
						(Print 312 16) ; "He's a pretty mean-looking guy. You probably don't want to tangle with him."
					)
					((Said 'greet')
						(Print 312 17) ; "He ignores your cheery salutation."
					)
				)
			)
		)
	)
)

(instance jeep of Act
	(properties
		view 476
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/jeep,car]>')
				(cond
					((IsOffScreen self))
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 312 18) ; "AMC Jeep circa 1958."
					)
				)
			)
		)
	)
)

