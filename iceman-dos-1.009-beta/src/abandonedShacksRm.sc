;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)

(public
	abandonedShacksRm 0
)

(local
	local0
)

(procedure (localproc_0)
	(return (and (== (gEgo onControl: 1) 2) (< (gEgo x:) 115) 1))
)

(instance abandonedShacksRm of Rm
	(properties
		picture 75
		east 74
		south 70
	)

	(method (init)
		(super init:)
		(gAddToPics add: shackRock eachElementDo: #init doit:)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 100 180 loop: 3)
			)
		)
		(gEgo init:)
		(self setRegions: 310 311) ; tunisia, guardfReg
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(if (localproc_0)
					(Print 75 0) ; "Looking around this dilapidated structure, the only thing you see is an old wooden crate in the corner."
				else
					(Print 75 1) ; "You see dilapidated buildings."
				)
			)
			((Said 'get/box')
				(if (localproc_0)
					(Print 75 2) ; "You don't need the crate."
				else
					(proc0_40) ; "You don't see that."
				)
			)
			((Said 'look<in/box')
				(cond
					((!= local0 1)
						(Print 75 3) ; "You'll have to open it first."
					)
					((== (gEgo view:) 84)
						(Print 75 4) ; "It's empty."
					)
					(else
						(Print 75 5) ; "It has clothing in it."
					)
				)
			)
			((Said 'look,open[<at]/box')
				(cond
					((not (localproc_0))
						(proc0_40) ; "You don't see that."
					)
					((== local0 1)
						(Print 75 6) ; "The box is already open."
					)
					((== (gEgo onControl: 1) 2)
						(Print 75 7) ; "You open the crate and see clothing."
						(= local0 1)
					)
				)
			)
			((Said 'look[<at]/clothes')
				(cond
					((not (localproc_0))
						(proc0_40) ; "You don't see that."
					)
					((== local0 0)
						(proc0_40) ; "You don't see that."
					)
					((== (gEgo view:) 84)
						(Print 75 8) ; "Without a mirror, you can only imagine what you look like in this strange outfit."
					)
					(else
						(Print 75 9) ; "You look at the clothes and think, "This has to be my disguise.""
					)
				)
			)
			((Said 'get,change,wear/clothes')
				(cond
					((== (gEgo view:) 84)
						(proc0_39) ; "You don't need to do that."
					)
					((not (localproc_0))
						(proc0_40) ; "You don't see that."
					)
					(else
						(Print 75 10) ; "You reach into the crate, pick up the clothes and change into them."
						(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
							(Print 75 11) ; "You wisely drop the fish and the map so they don't give you away."
						)
						(gEgo put: 3 put: 4 put: 5 view: 84) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(gGame changeScore: 2)
					)
				)
			)
			((Said 'get/map')
				(cond
					((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 75 12) ; "You already have a map."
					)
					((localproc_0)
						(Print 75 13) ; "Just leave it there in case you're stopped by a guard."
					)
					(else
						(proc0_40) ; "You don't see that."
					)
				)
			)
		)
	)
)

(instance shackRock of PV
	(properties
		y 135
		x 233
		view 75
		priority 9
		signal 16384
	)
)

