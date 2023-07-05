;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n821)
(use Chase)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	guardfReg 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance guardfReg of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 73 74 75 76)) ; cliffsRm, pathToRoadRm, abandonedShacksRm, oasisRm
		(= initialized 0)
		(super newRoom: &rest)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 472)
		(guard setAvoider: Avoid setCycle: Walk init: hide:)
		(cond
			(
				(and
					(== gCurRoomNum 75) ; abandonedShacksRm
					(gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					(not ((gInventory at: 5) loop:)) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
				)
				(= local4 30)
				(guard setScript: hiddenScript)
			)
			((and (== gCurRoomNum 74) (== gPrevRoomNum 75)) ; pathToRoadRm, abandonedShacksRm
				(= local4 20)
				(guard setScript: roomChaseScript)
			)
			((== gCurRoomNum 76) ; oasisRm
				(if (and (gEgo has: 5) ((gInventory at: 5) loop:)) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					(= local4 10)
				else
					(= local4 40)
				)
				(guard setScript: roomChaseScript)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(= local2 (gEgo loop:))
			)
			(else
				(if (== gCurRoomNum 73) ; cliffsRm
					(= local4 2)
				)
				(guard setScript: roomChaseScript)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(= local2 (gEgo loop:))
			)
		)
	)
)

(instance hiddenScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(> state 1)
				(not (CantBeSeen gEgo guard 100))
				(!= (gEgo onControl: 1) 2)
			)
			(guard setScript: rm75ChaseScript)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 12)
			)
			(1
				(guard
					view: 472
					show:
					posn: 328 139
					setMotion: MoveTo 277 139 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(guard setMotion: MoveTo 263 153 self)
			)
			(4
				(guard setMotion: MoveTo 152 153 self)
			)
			(5
				(guard setMotion: MoveTo 62 243 self)
			)
			(6
				(= seconds 18)
			)
			(7
				(self init:)
			)
		)
	)
)

(instance rm75ChaseScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== (gEgo onControl: 1) 4)
			(guard setScript: rm75FoundScript)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard setMotion: Chase gEgo 20 self)
			)
			(1
				(if (and (gEgo has: 3) (not (gEgo has: 4))) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(client setScript: caughtWithFishScript)
				else
					(client setScript: caughtEgoScript)
				)
			)
		)
	)
)

(instance rm75FoundScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(Print 311 0) ; ""Halt!" the guard yells."
					(HandsOff)
					(= local5 (= register 1))
				)
				(= cycles 1)
			)
			(1
				(cond
					((guard inRect: 121 150 319 209)
						(guard setMotion: MoveTo 120 153 self)
					)
					((guard inRect: 94 143 120 153)
						(guard setMotion: MoveTo 110 139 self)
					)
					((guard inRect: 54 176 121 209)
						(guard setMotion: MoveTo 120 175 self)
					)
					((and (gEgo inRect: 67 154 120 175) (> (gEgo x:) 100))
						(guard setMotion: MoveTo 110 139 self)
					)
					((guard inRect: 121 143 181 149)
						(guard setMotion: MoveTo 110 135 self)
					)
					((guard inRect: 236 128 319 148)
						(guard setMotion: MoveTo 307 127 self)
					)
					((guard inRect: 287 110 319 127)
						(guard setMotion: MoveTo 286 115 self)
					)
					((guard inRect: 226 110 286 127)
						(guard setMotion: MoveTo 225 115 self)
					)
					(else
						(guard setMotion: Chase gEgo 20 self)
						(= register 2)
					)
				)
			)
			(2
				(if (== register 2)
					(if (and (gEgo has: 3) (not (gEgo has: 4))) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(client setScript: caughtWithFishScript)
					else
						(client setScript: caughtEgoScript)
					)
				else
					(self init:)
				)
			)
		)
	)
)

(instance roomChaseScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== gCurRoomNum 75) (> state 0) (== (gEgo onControl: 1) 4)) ; abandonedShacksRm
			(guard setMotion: 0 setScript: rm75FoundScript)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local4 0)
					(= local4 8)
				)
				(= local4 (- (= seconds local4) 2))
			)
			(1
				(if (and (== gCurRoomNum 76) (> (gEgo y:) 154)) ; oasisRm
					(= temp0 330)
					(= temp1 170)
				else
					(= temp0 local0)
					(= temp1 local1)
				)
				(if
					(and
						(< (Abs (- (gEgo x:) temp0)) 25)
						(< (Abs (- (gEgo y:) temp1)) 25)
					)
					(+= local4 2)
					(self init:)
				else
					(guard
						show:
						loop: local2
						posn: temp0 temp1
						setMotion: Chase gEgo 20 self
					)
				)
			)
			(2
				(if (and (gEgo has: 3) (not (gEgo has: 4))) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(client setScript: caughtWithFishScript)
				else
					(client setScript: caughtEgoScript)
				)
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
					(if (not local5)
						(Print 311 0) ; ""Halt!" the guard yells."
					)
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
				(= cycles 2)
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
						(Print 311 1) ; "After questioning, you are unable to explain away the wet suit or provide identification."
						(= cycles 1)
					)
					((and (gEgo has: 5) ((gInventory at: 5) loop:)) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 311 2) ; "The guard searches you, finding the map to Stacy's apartment."
						(= cycles 1)
					)
					((gEgo has: 2) ; ID_Card
						(client setScript: hasIDScript)
					)
					(else
						(Print 311 3) ; "Unable to produce identification..."
						(= cycles 1)
					)
				)
			)
			(6
				(EgoDead 970 0 0 311 4) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance caughtWithFishScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard setMotion: Chase gEgo 20 self)
			)
			(1
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
				(= cycles 2)
			)
			(2
				(proc310_1 guard)
				(= seconds 1)
			)
			(3
				(proc310_1 gEgo)
				(= seconds 1)
			)
			(4
				(Print 311 5) ; "The guard grabs the fish out of your hand and finds the map to your disguise."
				(EgoDead 970 0 0 311 4) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance hasIDScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 311 6) ; "The guard demands identification."
				(= cycles 1)
			)
			(1
				(Print 311 7) ; "Satisfied, the guard allows you to continue..."
				(Print 311 8) ; "Whew," you think, "that was close!"
				(HandsOn)
			)
		)
	)
)

(instance guard of Act
	(properties
		view 472
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/guard]')
				(Print 311 9) ; "Looks like alien scum to me."
				(event claimed: 1)
			)
		)
	)
)

