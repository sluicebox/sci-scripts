;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Game)
(use Actor)

(public
	abandonedShacksRm 0
	shackFeat 1
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
		(self
			setRegions: 310 311 ; tunisia, guardfReg
			setFeatures:
				lDoor
				rDoor
				windo
				((Clone windo)
					x: 231
					y: 49
					z: 0
					nsLeft: 219
					nsTop: 37
					nsRight: 244
					nsBottom: 62
					yourself:
				)
				((Clone windo)
					x: 290
					y: 50
					z: 0
					nsLeft: 277
					nsTop: 37
					nsRight: 304
					nsBottom: 63
					yourself:
				)
				building
				shackFeat
		)
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
			((Said 'move,get/box')
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
			((Said 'examine,look,open[<at]/box')
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
			((Said 'get,change,wear,(adjust<on)/clothes,disguise')
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
			((Said 'hide/gear[<scuba]')
				(if (== (gEgo view:) 84)
					(proc0_39) ; "You don't need to do that."
				else
					(Print 75 12) ; "You don't have any other clothes."
				)
			)
			((Said 'rip,destroy/map')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'get/map')
				(cond
					((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 75 13) ; "You already have a map."
					)
					((localproc_0)
						(Print 75 14) ; "Just leave it there in case you're stopped by a guard."
					)
					(else
						(proc0_40) ; "You don't see that."
					)
				)
			)
			((Said 'get/fish')
				(cond
					((gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 75 15) ; "You already have a fish."
					)
					((localproc_0)
						(Print 75 14) ; "Just leave it there in case you're stopped by a guard."
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

(instance building of RFeature
	(properties
		y 54
		x 159
		nsBottom 108
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 75 16) ; "These dilapidated dwellings have long since been abandoned."
					)
				)
			)
		)
	)
)

(instance windo of RFeature
	(properties
		y 56
		x 81
		nsTop 44
		nsLeft 68
		nsBottom 68
		nsRight 94
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 75 17) ; "A window."
					)
					((Said '(climb,look<(in,through)),open')
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
		)
	)
)

(instance lDoor of RFeature
	(properties
		y 87
		x 39
		nsTop 63
		nsLeft 22
		nsBottom 111
		nsRight 57
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 75 18) ; "A door."
					)
					((Said 'open')
						(Print 75 19) ; "It's already open."
					)
					((Said 'close')
						(Print 75 20) ; "It won't budge."
					)
				)
			)
		)
	)
)

(instance rDoor of RFeature
	(properties
		y 80
		x 180
		nsTop 53
		nsLeft 161
		nsBottom 108
		nsRight 199
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 75 21) ; "A doorless doorway."
					)
					((Said 'open')
						(Print 75 22) ; "It's just a hole, you can't open it."
					)
					((Said 'close')
						(Print 75 23) ; "It's just a hole, you can't close it."
					)
				)
			)
		)
	)
)

(instance shackFeat of RFeature
	(properties
		y 126
		x 331
		nsTop 125
		nsLeft 330
		nsBottom 127
		nsRight 332
	)
)

