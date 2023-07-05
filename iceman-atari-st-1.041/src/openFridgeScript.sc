;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 362)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use Sight)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	openFridgeScript 0
	closeFridgeScript 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(Print 362 0) ; "Only one item at a time, please."
)

(instance openFridgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(HandsOn)
				(tunisia fridgeIs: 1)
				(inFridge init:)
				(ketchup init:)
				(milk init:)
				(butter init:)
				(if (== (tunisia cheezIs:) 1)
					(cheez init:)
				)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client stopUpd:)
				(inFridge dispose:)
				(milk dispose:)
				(cheez dispose:)
				(butter dispose:)
				(ketchup dispose:)
				(= cycles 2)
			)
			(4
				(self dispose:)
				(DisposeScript 362)
				(tunisia fridgeIs: 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< state 2) (CantBeSeen client gEgo 180))
			(self cue:)
		)
	)
)

(instance closeFridgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo script:)
					(gEgo cue:)
					(= local4 1)
				else
					(= cycles 1)
				)
			)
			(1
				(if (!= (gEgo heading:) 90)
					(gEgo heading: 90)
					((gEgo looper:) doit: gEgo (gEgo heading:) self)
				else
					(= cycles 1)
				)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client stopUpd:)
				(inFridge dispose:)
				(milk dispose:)
				(cheez dispose:)
				(butter dispose:)
				(ketchup dispose:)
				(= cycles 2)
			)
			(4
				(self dispose:)
				(DisposeScript 362)
				(tunisia fridgeIs: 0)
				(HandsOn)
			)
		)
	)
)

(instance milkActionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gEgo heading:) 90)
					(gEgo heading: 90)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 4)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: (if (== (= register (gEgo view:)) 84) 884 else 784)
					setLoop: 0
					setCel: 0
				)
				(if (== local0 2)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
				(milk hide:)
			)
			(2
				(if (== local0 2)
					(Print 362 1) ; "You drink the remaining milk."
				else
					(Print 362 2) ; "You get the milk, look at it, and return it."
				)
				(= seconds 2)
			)
			(3
				(if (== local0 2)
					(tunisia milkIs: 2)
				)
				(milk show:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: register
					loop: 0
					setPri: -1
					setLoop: -1
					cel: -1
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance cheezActionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gEgo heading:) 90)
					(gEgo heading: 90)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 4)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: (if (== (= register (gEgo view:)) 84) 884 else 784)
					setLoop: 1
					setCel: 0
				)
				(if (== local1 1)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: CT 4 1 self)
				)
				(cheez hide:)
			)
			(2
				(if (== local1 1)
					(Print 362 3) ; "Loving cheese as much as you do, you eat the entire block."
				else
					(Print 362 4) ; "You get the cheese, look at it, and return it."
				)
				(= seconds 2)
			)
			(3
				(if (== local1 1)
					(tunisia cheezIs: 2)
					(cheez dispose:)
				else
					(tunisia cheezIs: 1)
					(cheez show:)
				)
				(if (== local1 1)
					(= cycles 1)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(gEgo
					view: register
					loop: 0
					setPri: -1
					setLoop: -1
					cel: -1
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getButterScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceDirectionHandler add: self)
	)

	(method (dispose)
		(gIceDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gEgo heading:) 90)
					(gEgo heading: 90)
					((gEgo looper:) doit: gEgo (gEgo heading:))
					(= cycles 4)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: (if (== (= register (gEgo view:)) 84) 884 else 784)
					setLoop: 2
					setCel: 0
				)
				(gEgo setCycle: End self)
				(butter hide:)
			)
			(2
				(Print 362 5) ; "You pick up the butter dish."
				(User canInput: 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: register
					setPri: -1
					loop: 0
					setLoop: -1
					cel: -1
					setCycle: Walk
				)
				(butter show:)
				(HandsOn)
				(if (and local2 local3)
					(gEgo setMotion: MoveTo local2 local3)
				)
				(if local4
					(closeFridgeScript cue:)
				)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(super handleEvent: event)
		(= local2 0)
		(= local3 0)
		(switch (event type:)
			($0040 ; direction
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch (event message:)
					(JOY_NULL
						(= local2 temp0)
						(= local3 temp1)
					)
					(JOY_UP
						(= local2 temp0)
						(= local3 (- temp1 1000))
					)
					(JOY_UPRIGHT
						(= local2 (+ temp0 1000))
						(= local3 (- temp1 1000))
					)
					(JOY_RIGHT
						(= local2 (+ temp0 1000))
						(= local3 temp1)
					)
					(JOY_DOWNRIGHT
						(= local2 (+ temp0 1000))
						(= local3 (+ temp1 1000))
					)
					(JOY_DOWN
						(= local2 temp0)
						(= local3 (+ temp1 1000))
					)
					(JOY_DOWNLEFT
						(= local2 (- temp0 1000))
						(= local3 (+ temp1 1000))
					)
					(JOY_LEFT
						(= local2 (- temp0 1000))
						(= local3 temp1)
					)
					(JOY_UPLEFT
						(= local2 (- temp0 1000))
						(= local3 (- temp1 1000))
					)
				)
				(self cue:)
			)
			(evMOUSEBUTTON
				(= local2 (event x:))
				(= local3 (event y:))
				(self cue:)
			)
			(evSAID
				(cond
					(
						(or
							(Said 'detach/lid,top')
							(Said 'open/butterdish,butter,dish,(dish<butter)')
						)
						(Print 362 6) ; "You remove the lid and inside you discover..."
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							(Print 362 7) ; "Butter!"
						else
							(Print 362 8) ; "A plastic bag that appears to contain a folded piece of paper."
						)
					)
					((Said 'look/bag[<plastic]')
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							(event claimed: 1)
						else
							(Print 362 9) ; "It's an ordinary sandwich bag."
						)
					)
					((Said 'look/note,newspaper,letter')
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							(event claimed: 1)
						else
							(Print 362 10) ; "You need to get it out of the bag first."
						)
					)
					(
						(or
							(Said 'get,open/bag[<plastic]')
							(Said 'get,detach/newspaper,note,letter')
						)
						(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
							(event claimed: 1)
						else
							(Print 362 11) ; "You get the plastic bag and remove the folded piece of paper."
							(Print 362 12) ; "At the same time, you return the butter dish to the icebox."
							(gEgo get: 14) ; Sub: Code_Book | Tunisia: Note
							(self cue:)
						)
					)
				)
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance inFridge of View
	(properties
		y 76
		x 276
		view 284
		loop 2
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance milk of View
	(properties
		y 38
		x 288
		view 284
		loop 2
		cel 2
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 11)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/milk]>')
				(cond
					((Said 'look[<at]')
						(if (== (tunisia milkIs:) 2)
							(Print 362 13) ; "An empty quart of milk."
						else
							(Print 362 14) ; "A quart of milk."
						)
					)
					((Said 'get')
						(cond
							((gEgo script:)
								(localproc_0)
							)
							((== (tunisia milkIs:) 2)
								(Print 362 15) ; "You already drank the milk."
							)
							(else
								(= local0 0)
								(gEgo setScript: milkActionScript)
							)
						)
					)
					((Said 'drink')
						(cond
							((gEgo script:)
								(localproc_0)
							)
							((== (tunisia milkIs:) 2)
								(Print 362 15) ; "You already drank the milk."
							)
							(else
								(= local0 2)
								(gEgo setScript: milkActionScript)
							)
						)
					)
					((Said 'smell')
						(if (== (tunisia milkIs:) 2)
							(Print 362 15) ; "You already drank the milk."
						else
							(Print 362 16) ; "It smells fairly fresh."
						)
					)
				)
			)
		)
	)
)

(instance cheez of View
	(properties
		y 53
		x 288
		view 284
		loop 2
		cel 3
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 11)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/cheese]>')
				(cond
					((Said 'look[<at]')
						(Print 362 17) ; "A slab of cheese."
					)
					((Said 'get')
						(if (gEgo script:)
							(localproc_0)
						else
							(= local1 0)
							(gEgo setScript: cheezActionScript)
						)
					)
					((Said 'eat')
						(if (gEgo script:)
							(localproc_0)
						else
							(= local1 1)
							(gEgo setScript: cheezActionScript)
						)
					)
					((Said 'smell')
						(if (== (tunisia cheezIs:) 2)
							(Print 362 18) ; "You already ate the cheese."
						else
							(Print 362 16) ; "It smells fairly fresh."
						)
					)
				)
			)
		)
	)
)

(instance butter of View
	(properties
		y 23
		x 285
		view 284
		loop 2
		cel 4
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 11)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/(dish<butter),butter,butterdish]>')
				(cond
					((Said 'examine,look[<at,in]')
						(Print 362 19) ; "Looks like a normal butter dish with a lid."
					)
					((Said 'get')
						(if (gEgo script:)
							(Print 362 20) ; "You already have it."
						else
							(gEgo setScript: getButterScript)
						)
					)
					((Said 'adjust,drop')
						(if (gEgo script:)
							(gEgo cue:)
						else
							(Print 362 21) ; "You don't have it."
						)
					)
					((Said 'eat')
						(Print 362 22) ; "Come on, you can't be that hungry!"
					)
					((Said 'smell')
						(Print 362 16) ; "It smells fairly fresh."
					)
				)
			)
		)
	)
)

(instance ketchup of View
	(properties
		y 51
		x 291
		view 284
		loop 2
		cel 5
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 11)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/catsup]>')
				(cond
					((Said 'look[<at]')
						(Print 362 23) ; "A bottle of ketchup."
					)
					((Said 'get')
						(if (gEgo script:)
							(localproc_0)
						else
							(Print 362 24) ; "Picking up the ketchup bottle you think, "Yep, it's a bottle of ketchup." You then return it to the icebox."
						)
					)
					((Said 'eat,drink')
						(Print 362 22) ; "Come on, you can't be that hungry!"
					)
					((Said 'open')
						(Print 362 25) ; "Don't bother, it's just ketchup."
					)
					((Said 'smell')
						(Print 362 26) ; "It smells like ketchup."
					)
				)
			)
		)
	)
)

