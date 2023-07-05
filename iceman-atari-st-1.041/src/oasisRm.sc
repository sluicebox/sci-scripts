;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use CyclingProp)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	oasisRm 0
	oasisFeat 1
)

(procedure (localproc_0)
	(cond
		((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
			(Print 76 0) ; "You already have the map."
		)
		((gEgo has: 2) ; ID_Card
			(gEgo get: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
			((gInventory at: 5) loop: 1 cel: 0) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
		)
		(else
			(Print 76 1) ; "Stacy hands a map to you and the key to her apartment. She also gives you a phony ID."
			(gEgo get: 5 6 2) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
			((gInventory at: 5) loop: 1 cel: 0) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
			(gGame changeScore: 1)
			((gInventory at: 2) view: 372 loop: 0 cel: 0) ; ID_Card
			(Print 76 2) ; "She then says, "Find your way to the apartment and I'll meet you there later.""
			(Print 76 3) ; ""I'm going to make contact with the USS Saratoga and let them know we're on schedule." she continues."
			(Print 76 4) ; "Another thing," she adds, "there are things in the apartment for you. You can find them in the kitchen."
		)
	)
)

(instance oasisRm of Rm
	(properties
		picture 76
		east 77
		picAngle 70
	)

	(method (init)
		(LoadMany rsVIEW 76 84 250 276 376 576)
		(Load rsSOUND 72)
		(HandsOn)
		(super init:)
		(gIceGlobalSound number: 72 owner: gGame priority: 1 loop: -1 play:)
		(water init:)
		(water4 init:)
		(water5 init:)
		(gEgo init:)
		(if (not (gEgo has: 2)) ; ID_Card
			(agent init:)
		)
		(if (> global132 1)
			(flamingo init:)
		)
		(gAddToPics add: palmTree treeTrunk rock1 rock2 rock3 doit:)
		(proc824_0)
		(if (== gPrevRoomNum 77) ; roadToTownRm
			(gEgo init: x: 311)
		else
			(gEgo view: 84 init: posn: 311 100)
		)
		(self setRegions: 310 311 setFeatures: building fallFeat pond oasisFeat) ; tunisia, guardfReg
	)

	(method (newRoom newRoomNumber)
		(gIceGlobalSound fade:)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene,oasis]')
				(if (gCast contains: agent)
					(Print 76 5) ; "Looking around, you see a beautiful oasis..."
					(Print 76 6) ; "A woman appears to be drawing water from the spring."
					(if global142
						(Print 76 7) ; "You think to yourself, "Strange, but I swear I've met this woman somewhere before.""
					)
				else
					(Print 76 8) ; "You see a beautiful oasis."
				)
			)
		)
	)

	(method (notify)
		(agent setScript: agentLeaveScript)
	)
)

(instance agentScript of Script
	(properties
		seconds 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(client setCycle: End)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/iceman,(man<ice)')
				(HandsOff)
				(proc310_1 gEgo)
				(client setScript: saidIceManScript)
				(self dispose:)
			)
			((Said 'look[<at][/woman,woman,agent]')
				(if global142
					(Print 76 7) ; "You think to yourself, "Strange, but I swear I've met this woman somewhere before.""
				else
					(Print 76 9) ; "The local woman appears to be drawing water."
				)
			)
			((Said '[/woman,woman,stacy,agent]')
				(proc310_1 gEgo)
				(Print 76 10 #at 100 40) ; "You try striking up a conversation with the woman. She looks at you and says:"
				(proc310_2)
				(proc310_1 agent)
				(Print 76 11) ; "I am not allowed to talk with strangers."
				(proc310_2)
			)
		)
	)
)

(instance saidIceManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (== (gEgo view:) 71)
					(Print 76 12 #at 100 40) ; "The woman casts you a furtive glance but otherwise ignores you."
					(proc310_2)
					(HandsOn)
					(client setScript: agentScript)
				else
					(= cycles 1)
				)
			)
			(2
				(proc310_2)
				(HandsOn)
				(Print 76 13 #at 100 40) ; "You blurt out the code name, "Iceman," and she surprises you by responding in English."
				(if global142
					(Print 76 14 #at 100 40) ; "Hello, John," she greets you, "Long way from Tahiti!"
				else
					(Print 76 15 #at 100 40) ; "How do you do," she says, "My name is Stacy, and I'm with the United States Central Intelligence Agency."
				)
				(Print 76 16 #at 100 40) ; "Stacy says, "I'm happy to see the mission is a success so far John. I wish you luck on the remainder of it.""
				(gGame changeScore: 1)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman,woman,stacy,agent]>')
				(cond
					((TurnIfSaid client event 'look/*'))
					((Said 'look[<at]')
						(Print 76 17) ; "She is beautiful, even in this getup."
					)
					((Said 'talk')
						(Print 76 18) ; "She doesn't have time for small talk."
					)
					((Said 'kiss')
						(Print 76 19) ; ""Not now," she says blushing."
					)
				)
			)
			((GoToIfSaid self event (+ (agent x:) 25) (- (agent y:) 3) 0 76 20))
			((Said 'get/map')
				(localproc_0)
			)
			((Said 'drop,throw,give,return/map')
				(if (and (gEgo has: 5) ((gInventory at: 5) loop:)) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map, Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					(Print 76 21) ; "To keep your cover intact, you hand the map back to the agent."
					(gEgo put: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					(SetScore tunisia 413 2 1)
				else
					(Print 76 22) ; "You don't have the map."
				)
			)
		)
	)
)

(instance agentLeaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (agent loop:) 1)
					(agent loop: 0 setCel: 16 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(agent
					view: 250
					setAvoider: Avoid
					setStep: 3 2
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 332 143 self
				)
			)
			(2
				(agent dispose:)
			)
		)
	)
)

(instance flamingoDriver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(flamingo
					setMotion: 0
					loop: (+ (flamingo loop:) 2)
					cel: 0
					setCycle: End
				)
				(= seconds (Random 3 7))
				(= register (Random 0 1))
			)
			(2
				(if register
					(flamingo
						loop: (+ (flamingo loop:) 2)
						cel: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if register
					(flamingo loop: (+ (flamingo loop:) 2) setCycle: Fwd)
					(= seconds (Random 3 7))
				else
					(= cycles 1)
				)
			)
			(4
				(if register
					(flamingo
						loop: (- (flamingo loop:) 2)
						setCel: 16
						setCycle: Beg self
					)
				else
					(= cycles 1)
				)
			)
			(5
				(flamingo
					loop:
						(if register
							(- (flamingo loop:) 2)
						else
							(flamingo loop:)
						)
					setCel: 16
					setCycle: Beg self
				)
			)
			(6
				(flamingo loop: (- (flamingo loop:) 2) setCycle: Walk)
				(if (> (flamingo x:) 130)
					(flamingo setMotion: MoveTo 65 156)
				else
					(flamingo setMotion: MoveTo 150 156)
				)
				(self init:)
			)
		)
	)
)

(instance agent of Act
	(properties
		y 143
		x 207
		heading 180
		view 376
		loop 2
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self illegalBits: 0 setCycle: Walk setScript: agentScript stopUpd:)
	)
)

(instance flamingo of Act
	(properties
		y 156
		x 45
		view 276
	)

	(method (init)
		(super init:)
		(self
			illegalBits: 0
			setCycle: Walk
			loop: 0
			cycleSpeed: 1
			moveSpeed: 1
			setScript: flamingoDriver
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bird,flamingo]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 76 23) ; "Maybe it escaped from the Tunisian zoo."
					)
					((Said 'catch,scare,kill')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance water of CyclingProp
	(properties
		y 145
		x 103
		view 76
		priority 10
	)
)

(instance water4 of CyclingProp
	(properties
		y 108
		x 29
		view 76
		loop 3
		priority 7
	)
)

(instance water5 of CyclingProp
	(properties
		y 173
		x 27
		view 76
		loop 4
		priority 12
	)
)

(instance palmTree of RPicView
	(properties
		y 33
		x 53
		view 576
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/palm<palm]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 76 24) ; "A Tunisian palm tree."
					)
				)
			)
		)
	)
)

(instance treeTrunk of RPicView
	(properties
		y 95
		x 42
		view 576
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/palm<palm]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 76 24) ; "A Tunisian palm tree."
					)
				)
			)
		)
	)
)

(instance rock1 of PV
	(properties
		y 99
		x 214
		view 576
		loop 2
		cel 1
	)
)

(instance rock2 of PV
	(properties
		y 84
		x 270
		view 576
		loop 2
		cel 2
	)
)

(instance rock3 of PV
	(properties
		y 96
		x 138
		view 576
		loop 2
		cel 2
	)
)

(instance fallFeat of RFeature
	(properties
		y 127
		x 100
		nsTop 113
		nsLeft 77
		nsBottom 141
		nsRight 123
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/waterfall]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 76 25) ; "A sparkling waterfall."
					)
				)
			)
		)
	)
)

(instance building of RFeature
	(properties
		y 38
		x 206
		nsTop 28
		nsLeft 173
		nsBottom 48
		nsRight 239
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 76 26) ; "A building in the distance."
					)
				)
			)
		)
	)
)

(instance pond of RFeature
	(properties
		y 156
		x 144
		nsTop 143
		nsLeft 40
		nsBottom 169
		nsRight 248
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/water,pond]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 76 27) ; "The water looks inviting but you have important work to do."
					)
					((Said 'get,swim,drink')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance oasisFeat of RFeature
	(properties
		y 126
		x 331
		nsTop 125
		nsLeft 330
		nsBottom 127
		nsRight 332
	)
)

