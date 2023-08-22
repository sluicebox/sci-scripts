;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use Blk)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm50 0
)

(instance rm50 of Rm
	(properties
		picture 50
		horizon 48
		north 22
		east 51
	)

	(method (init)
		(LoadMany rsVIEW 251 274 701)
		(self
			style:
				(switch gPrevRoomNum
					(north 6)
					(east 2)
				)
		)
		(super init:)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 58 51 loop: 0)
			)
			(east
				(gEgo posn: 289 143)
			)
			(else
				(gEgo posn: 289 143)
			)
		)
		(gEgo init:)
		(if (not (IsFlag 82))
			(gAddToPics add: rock eachElementDo: #init doit:)
			(gEgo observeBlocks: rockBlock)
		)
		(if (IsFlag 2)
			(Print 50 0) ; "When the goat saw how dark it was in here, it decided not to stay around."
			(ClearFlag 2)
		)
		(drip1 init: setScript: doDrip1)
		(puddle1 init:)
		(drip2 init: setScript: doDrip2)
		(puddle2 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
					)
				)
				(if (and (== temp0 north) (== gPrevRoomNum 51) (IsFlag 82))
					(SetScore 99 2)
				)
				(gCurRoom newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/boulder,granite')
				(if (IsFlag 82)
					(Print 50 1) ; "The cave walls are hewn from the living rock of the mountain. They're dark, cold, and covered with a thin layer of slime."
				else
					(Print 50 2) ; "It is a huge piece of granite."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/cave,room]')
						(if (IsFlag 82)
							(Print 50 3) ; "This is a large, apparently vacant cave. Damp and cool, the cave is lit only by the sunlight streaming in through the cave's entrance to the west."
						else
							(Print 50 4) ; "A large boulder is blocking what may be another entrance to this cave."
						)
					)
					((Said '/stalactite,grass,wall')
						(Print 50 5) ; "It took millenniums for these stalagmites and stalactites to form."
					)
					((Said '/hole')
						(cond
							((gEgo inRect: 0 0 169 82)
								(Print 50 6) ; "Looking out the cave opening, you are able to admire the beautiful scenery outside."
							)
							((gEgo inRect: 200 105 321 191)
								(if (IsFlag 82)
									(Print 50 7) ; "It leads to another portion of the cave."
								else
									(Print 50 8) ; "This opening is blocked by a large boulder."
								)
							)
							(else
								(Print 50 9) ; "It is on the far side of the cave."
							)
						)
					)
				)
			)
			((Said 'get,get/boulder')
				(Print 50 10) ; "It is far too heavy to carry around."
			)
			((Said 'move,pull/boulder')
				(if (> (gEgo distanceTo: rock) 50)
					(Print 50 11) ; "You need to move closer to try that."
				else
					(Print 50 12) ; "It is impossible for you to move a boulder this large."
				)
			)
			((Said 'get,(pick<up)/slime')
				(Print 50 13) ; "Yeech. Fear not, you won't need it."
			)
			((Said 'climb,climb/boulder')
				(Print 50 14) ; "There is nothing of interest on top of the boulder."
			)
			((Said 'get,get,drink/water,puddle')
				(Print 50 15) ; "The brackish water would not be too satisfying. It may even make you sick."
			)
		)
	)
)

(instance rock of RPicView
	(properties
		x 311
		y 146
		view 251
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (IsFlag 82)
					(Print 50 1) ; "The cave walls are hewn from the living rock of the mountain. They're dark, cold, and covered with a thin layer of slime."
				else
					(Print 50 2) ; "It is a huge piece of granite."
				)
			)
		)
	)
)

(instance rockBlock of Blk
	(properties
		top 132
		left 276
		bottom 146
		right 346
	)
)

(instance drip1 of Prop
	(properties
		x 176
		y 51
		view 274
		loop 2
		priority 12
		signal 16400
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/drip')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 50 16) ; "Drops of brackish water fall from the stalactites."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drip2 of Prop
	(properties
		x 252
		y 65
		view 274
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 50 16) ; "Drops of brackish water fall from the stalactites."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance puddle1 of Prop
	(properties
		x 178
		y 165
		view 701
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/puddle,water')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 50 17) ; "Small puddles of water, acrid and unpleasant, collect beneath the dripping rock formations above."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance puddle2 of Prop
	(properties
		x 252
		y 179
		view 701
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 50 17) ; "Small puddles of water, acrid and unpleasant, collect beneath the dripping rock formations above."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doDrip1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random (* global101 10) (* global101 30)))
			)
			(1
				(drip1 setCycle: End self)
			)
			(2
				(drip1 stopUpd:)
				(puddle1 setCycle: End self)
			)
			(3
				(puddle1 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance doDrip2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random (* global101 10) (* global101 30)))
			)
			(1
				(drip2 setCycle: End self)
			)
			(2
				(drip2 stopUpd:)
				(puddle2 setCycle: End self)
			)
			(3
				(puddle2 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

