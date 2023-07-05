;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n821)
(use n954)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	storageRm 0
)

(synonyms
	(compartment cabinet)
)

(local
	local0
)

(instance storageRm of Rm
	(properties
		picture 35
		east 42
		west 36
	)

	(method (init)
		(Load rsVIEW 35)
		(Load rsVIEW 935)
		(super init:)
		(HandsOn)
		(self
			setRegions: 314 ; subMarine
			setFeatures:
				beansRF
				eggsRF
				milkRF
				meatRF
				applesRF
				potatoesRF
				flourRF
				greenBoxRF
				whiteBoxRF
				tpRF
				((Clone beansRF)
					nsLeft: 0
					nsRight: 23
					nsTop: 145
					nsBottom: 158
					yourself:
				)
				radiationSign
				therm
		)
		(door1 init: stopUpd:)
		(door2 init: stopUpd:)
		(scubaView init: cel: (if (== (subMarine suitRoom:) 38) 1 else 0))
		(scubaDoorLeft init: stopUpd:)
		(scubaDoorRight init: stopUpd:)
		(radDoor init: stopUpd:)
		(switch gPrevRoomNum
			(36 ; passagewayRm2
				(gEgo
					view: 135
					illegalBits: 0
					posn: -22 103
					ignoreActors: 1
					init:
					setScript: fryToDeathScript
				)
			)
			(else
				(gEgo
					posn: 245 102
					loop: 1
					heading: 90
					observeControl: 2
					init:
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(cond
					((Said '[<around,in][/room,scene]')
						(Print 35 0) ; "This is the storage and supply compartment. As you look around, you see multiple crates filled with perishable and nonperishable provisions."
					)
					((Said '[<around,in][/freezer]')
						(Print 35 1) ; "You see the inside of a freezer."
					)
					((Said 'box,provision')
						(Print 35 2) ; "The crates are full of anything from soup to nuts."
					)
					((Said 'soup,nut,food')
						(if local0
							(Print 35 3) ; "You don't need anything from the crates!"
						else
							(Print 35 4) ; "That's best left to the supply people who are responsible for keeping things stocked."
							(= local0 1)
						)
					)
				)
			)
		)
	)

	(method (doit)
		(if (> (gEgo x:) 277)
			(self newRoom: east)
			(gEgo ignoreControl: 2)
		else
			(if (& (gEgo onControl: 0) $0002)
				(self newRoom: west)
			)
			(super doit:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (gEgo script:))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance fryToDeathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(radDoor setCycle: End self)
			)
			(1
				(Print 35 5) ; "As you emerge from the reactor room, you begin to feel a little funny."
				(gEgo setMotion: MoveTo 10 103 self)
			)
			(2
				(gEgo setMotion: MoveTo 30 108 self)
			)
			(3
				(gEgo setMotion: MoveTo 50 103 self)
			)
			(4
				(gEgo setMotion: MoveTo 70 108 self)
			)
			(5
				(gEgo setMotion: MoveTo 90 103 self)
			)
			(6
				(Print 35 6) ; "You realize that entering the reactor area without protective clothing was a fatal mistake."
				(Print 35 7) ; "The searing radiation has already begun to turn your cells to jelly."
				(gEgo
					setLoop: 1
					setCel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
			)
			(7
				(gEgo cycleSpeed: 0 setCycle: End self)
			)
			(8
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 5)
			)
			(9
				(EgoDead 337 3 0 35 8) ; "Next time pay attention to radiation warnings."
			)
		)
	)
)

(instance eggsRF of RFeature
	(properties
		y 79
		x 100
		nsTop 68
		nsLeft 89
		nsBottom 91
		nsRight 112
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/egg]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 9) ; "Eggs."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance milkRF of RFeature
	(properties
		y 76
		x 101
		nsTop 48
		nsLeft 91
		nsBottom 67
		nsRight 112
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/milk]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 10) ; "Milk."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance meatRF of RFeature
	(properties
		y 80
		x 214
		nsTop 70
		nsLeft 200
		nsBottom 91
		nsRight 228
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/pork,beef]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 11) ; "Meat."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance applesRF of RFeature
	(properties
		y 37
		x 301
		nsTop 23
		nsLeft 283
		nsBottom 52
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/apple]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 12) ; "Apples."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance beansRF of RFeature
	(properties
		y 174
		x 30
		nsTop 158
		nsBottom 190
		nsRight 61
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bean]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 13) ; "Beans."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance potatoesRF of RFeature
	(properties
		y 174
		x 129
		nsTop 159
		nsLeft 90
		nsBottom 190
		nsRight 168
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/potatoe]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 14) ; "Potatoes."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance flourRF of RFeature
	(properties
		y 115
		x 284
		nsTop 94
		nsLeft 248
		nsBottom 137
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flour]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 15) ; "Flour."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance greenBoxRF of RFeature
	(properties
		y 129
		x 116
		nsTop 111
		nsLeft 79
		nsBottom 148
		nsRight 153
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/juice]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 16) ; "Canned grape juice."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance whiteBoxRF of RFeature
	(properties
		y 130
		x 195
		nsTop 113
		nsLeft 154
		nsBottom 148
		nsRight 236
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/box]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 17) ; "A white box."
					)
					((Said 'get,open')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance tpRF of RFeature
	(properties
		y 74
		x 272
		nsTop 53
		nsLeft 225
		nsBottom 96
		nsRight 320
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/box]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 18) ; "Toilet paper."
					)
					((Said 'get')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		y 94
		x 112
		view 35
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,freezer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 19) ; "This is the refrigerator where perishables are kept."
					)
					((GoToIfSaid self event 94 106 0 35 20))
					((Said 'open')
						(if (not cel)
							(self setCycle: End self)
						else
							(proc0_31) ; "It is."
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance door2 of Prop
	(properties
		y 94
		x 201
		view 35
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,freezer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 21) ; "This is where frozen foods are kept."
					)
					((GoToIfSaid self event 221 106 0 35 20))
					((Said 'open')
						(if (not cel)
							(self setCycle: End self)
						else
							(proc0_31) ; "It is."
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance scubaDoorLeft of Prop
	(properties
		y 95
		x 29
		view 35
		loop 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,closet,compartment,compartment]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(cond
							((not cel)
								(Print 35 22) ; "A compartment."
							)
							((== (subMarine suitRoom:) 38)
								(Print 35 23) ; "The compartment is empty."
							)
							(else
								(Print 35 24) ; "Inside the compartment you see scuba gear."
							)
						)
					)
					((GoToIfSaid self event 52 106 0 35 20))
					((Said 'open,unlock,(look<in)')
						(cond
							(cel
								(proc0_31) ; "It is."
							)
							((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
								(Print 35 25) ; "Using the key, you unlock the compartment door."
								(self setCycle: End self)
								(scubaDoorRight setCycle: End scubaDoorRight)
								(if (!= (subMarine suitRoom:) 38)
									(willie
										illegalBits: 0
										init:
										setCycle: Walk
										setScript: willieScript
									)
									(gGame changeScore: 1)
								)
							)
							(else
								(Print 35 26) ; "This compartment is locked. The key is obtainable from the Machinists mate."
							)
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
							(scubaDoorRight setCycle: Beg scubaDoorRight)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
			((Said 'wear,get[/scuba,equipment,gear][/gear,equipment]')
				(cond
					((not cel)
						(Print 35 27) ; "The door is closed."
					)
					((== (subMarine suitRoom:) 38)
						(Print 35 28) ; "The scuba gear has been moved to the escape hatch."
					)
					(else
						(Print 35 29) ; "No use lugging that heavy gear all over the sub. One of the crewmen can help you when you're ready to disembark."
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance scubaDoorRight of Prop
	(properties
		y 95
		x 74
		view 35
		loop 4
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance radDoor of Prop
	(properties
		y 103
		x 10
		view 935
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,reactor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 30) ; "This is the door to the reactor room. A radiation symbol is stenciled on it."
					)
					((GoToIfSaid self event 28 107 0 35 20))
					((Said 'open')
						(if (not cel)
							(self setCycle: End self)
							(gEgo ignoreControl: 2)
						else
							(proc0_31) ; "It is."
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
							(gEgo observeControl: 2)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance scubaView of View
	(properties
		y 95
		x 51
		view 35
		loop 2
	)
)

(instance willie of Act
	(properties
		y 105
		x 275
		view 534
		loop 1
	)
)

(instance willieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
				)
				(willie setMotion: MoveTo 53 105 self)
			)
			(2
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:))
			)
			(3
				(Print 35 31) ; ""Let me take the scuba equipment to the escape hatch for you, Sir." says Petty Officer Johnson."
				(willie view: 234 loop: 1)
				(scubaView setCel: 1)
				(subMarine suitRoom: 38)
				(= seconds 2)
			)
			(4
				(willie setMotion: MoveTo 164 105 self)
			)
			(5
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 20) self
				)
				(willie setMotion: MoveTo 275 105 self)
			)
			(6
				(scubaDoorLeft setCycle: Beg scubaDoorLeft)
				(scubaDoorRight setCycle: Beg scubaDoorRight)
				(gEgo heading: 90)
				((gEgo looper:) doit: gEgo (gEgo heading:))
			)
			(7
				(HandsOn)
				(willie dispose:)
			)
		)
	)
)

(instance radiationSign of RFeature
	(properties
		y 106
		x 8
		z 40
		nsTop 54
		nsLeft 4
		nsBottom 62
		nsRight 12
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/sign,symbol]>')
				(cond
					((TurnIfSaid self event 'read,look[<at]/*'))
					((Said 'read,look[<at]')
						(Print 35 32) ; "The universal radiation symbol."
					)
				)
			)
		)
	)
)

(instance therm of RFeature
	(properties
		y 61
		x 149
		nsTop 55
		nsLeft 138
		nsBottom 67
		nsRight 160
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/thermometer,meter,gauge]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 35 33) ; "The thermometers for the refrigerator and freezer."
					)
					((GoToIfSaid self event 149 102 0 35 20))
					((Said 'read,check')
						(Print 35 34) ; "The thermometers are normal."
					)
				)
			)
		)
	)
)

