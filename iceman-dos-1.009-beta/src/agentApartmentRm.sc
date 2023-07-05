;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	agentApartmentRm 0
)

(synonyms
	(cabinet cupboard)
	(canister jar can)
)

(local
	[local0 20]
	local20 = 10000
	local21
	local22
)

(procedure (localproc_0 param1)
	(switch param1
		(0
			(gEgo put: 9 put: 10 put: 11) ; Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Washer | Tunisia: Flour_Canister, Sub: Nut | Tunisia: Coffee_Canister
			(sugar show: setScript: 0)
			(flour show: setScript: 0)
			(coffee show: setScript: 0)
			(DisposeScript 363)
			(= local21 0)
		)
		(sugar
			(gEgo get: 9 put: 10 put: 11) ; Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Washer | Tunisia: Flour_Canister, Sub: Nut | Tunisia: Coffee_Canister
			(flour show: setScript: 0)
			(coffee show: setScript: 0)
			(sugar hide: setScript: (ScriptID 363 0)) ; hasSugarScript
			(= local21 1)
		)
		(flour
			(gEgo get: 10 put: 9 put: 11) ; Sub: Washer | Tunisia: Flour_Canister, Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Nut | Tunisia: Coffee_Canister
			(sugar show: setScript: 0)
			(coffee show: setScript: 0)
			(flour hide: setScript: (ScriptID 363 1)) ; hasFlourScript
			(= local21 1)
		)
		(coffee
			(gEgo get: 11 put: 9 put: 10) ; Sub: Nut | Tunisia: Coffee_Canister, Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Washer | Tunisia: Flour_Canister
			(sugar show: setScript: 0)
			(flour show: setScript: 0)
			(coffee hide: setScript: (ScriptID 363 2)) ; hasCoffeeScript
			(= local21 1)
		)
	)
)

(instance agentApartmentRm of Rm
	(properties
		picture 84
		north 85
		south 80
		vanishingX 174
		vanishingY -4
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 284 684 250 584 85 884 784 984)
		(Load rsSOUND 67)
		(gIceGlobalSound
			number: (proc0_5 67)
			owner: gGame
			priority: 1
			loop: -1
			play:
		)
		(self
			setRegions: 310 ; tunisia
			setFeatures:
				windowski
				kitchen
				kounter
				bed
				sink
				cabinet
				northWall
				door
		)
		(LoadMany rsSCRIPT 362 365 363 369 321)
		(fridge init:)
		(sugar init:)
		(flour init:)
		(coffee init:)
		(phone init: stopUpd:)
		(if (not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
			(card init: stopUpd:)
		)
		(if (not (gEgo has: 7)) ; Sub: Flare | Tunisia: Duct_Tape
			(tape init: setPri: 15)
		)
		(gAddToPics add: fridgeSide doit:)
		(switch gPrevRoomNum
			(north
				(= local20 (tunisia bagTimer:))
				(if (tunisia bagBound:)
					((ScriptID 310 4) init:) ; bagdad
					((ScriptID 310 6) init:) ; eClothes
				)
				(gEgo init:)
			)
			(else
				(gEgo view: 84 posn: 113 150 loop: 3 init:)
			)
		)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== (gEgo script:) stayHereScript)
				(return)
			)
			((and (or (& (tunisia flags:) $0001) (== local20 0)) (== newRoomNumber 80)) ; agentsBuildingRm
				(gEgo setScript: stayHereScript)
			)
			(else
				(gIceGlobalSound fade:)
				(super newRoom: newRoomNumber &rest)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around][/room]')
				(Print 84 0) ; "It's a one room apartment with a small kitchen. A window overlooks the street behind the apartment."
			)
			((Said 'eat/food')
				(if (== (tunisia fridgeIs:) 0)
					(proc0_40) ; "You don't see that."
				else
					(Print 84 1) ; "Which item?"
				)
			)
			((Said 'read/note')
				(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
					(Print 84 2) ; "After studying the note thoroughly, you conclude that a catering business by the name of "Bagdads Fast Foods" makes a twice daily delivery to the compound."
					(Print 84 3) ; "You futher note that both deliveries are at the exact same time each day."
					(Print 84 4) ; "Stacy's log file also reveals that one of the two guards will search the caterer and the food prior to entry. The guard then always accompanies the caterer inside."
					(SetScore tunisia 413 4 4)
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'load/gun')
				(if (gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
					(Print 84 5) ; "It's already loaded."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_F10))
					(Said 'shoot,fire,kill[/bagdad,man,gun]')
				)
				(cond
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 84 6) ; "You don't have a weapon."
					)
					((tunisia bagBound:)
						(Print 84 7) ; "You almost use the weapon to subdue the caterer, but decide to save your limited ammo for the compound guards."
					)
					(else
						(Print (proc0_41)) ; "That is not a good idea."
					)
				)
			)
			((Said 'read/card')
				(if (gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
					(Print 84 8 #icon 384 1 1) ; "A business card for Bagdad's Fast Food Catering service.  Another phone number has been written on it."
				else
					(Print 84 9) ; "You need to get it first."
				)
			)
			((Said 'talk/man,bagdad')
				(if (tunisia bagBound:)
					(Print 84 10) ; "He doesn't respond, for obvious reasons."
				else
					(Print 84 11) ; "You don't have time for idle chatter."
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo onControl: 1) 2)
			(gCurRoom newRoom: 80) ; agentsBuildingRm
		)
		(switch local20
			(0)
			(1
				(= local20 0)
				(self setScript: tossEverythingScript)
			)
			(10000)
			(else
				(-- local20)
			)
		)
	)
)

(instance tossEverythingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tunisia flags: (| (tunisia flags:) $0001))
				(if (or (gEgo has: 9) (gEgo has: 10) (gEgo has: 11)) ; Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Washer | Tunisia: Flour_Canister, Sub: Nut | Tunisia: Coffee_Canister
					(localproc_0 0)
				)
				(if (fridge script:)
					((ScriptID 362 0) cue:) ; openFridgeScript
				)
			)
			(1
				(self setScript: (ScriptID 365 0)) ; bagdadKnockScript
			)
			(2
				(DisposeScript 365)
				(Animate (gCast elements:) 0)
				(if (& (tunisia flags:) $0004)
					(self setScript: (ScriptID 321 0))
				else
					(self setScript: (ScriptID 369 0)) ; stacyInScript
					(= local22 1)
				)
			)
			(3
				(DisposeScript 369)
				(= local22 0)
				(= local20 10000)
				(tunisia flags: (& (tunisia flags:) $fffe))
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (== (tunisia fridgeIs:) 0))
			(self cue:)
		)
	)
)

(instance stayHereScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local22
					(Print 84 12) ; "Wait for the agent."
				else
					(Print 84 13) ; "You won't gain a thing by leaving now."
				)
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance phoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 984
					loop: (if (== (gEgo view:) 84) 1 else 2)
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				(phone cel: 1 forceUpd:)
				(gEgo setCycle: End self)
			)
			(2
				(Print 84 14 #edit @local0 20) ; "Number to dial: (ESC to hang up) (xx-xxx-xxxx)"
				(= seconds 3)
			)
			(3
				(cond
					((not (StrCmp @local0 {}))
						(self cue:)
					)
					((not (StrCmp @local0 {13-555-8097}))
						(if (not (& register $0001))
							(Print 84 15 #time 10) ; "After a couple of rings a voice on the other end says..."
							(Print 84 16) ; "Bagdads Fast Food Catering service, can I help you?"
							(User canInput: 1)
							(= seconds 10)
						else
							(Print 84 17) ; "Nobody answers. The caterer must be on his way."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					((not (StrCmp @local0 {03-120-1204}))
						(if (not (& register $0002))
							(Print 84 18 #time 10) ; "The voice on the other end says, "This is Basal!  Speak your business!""
							(User canInput: 1)
							(= seconds 10)
						else
							(Print 84 19) ; "Calling again would arouse suspicion."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					(else
						(Print 84 20 #time 10) ; "There is no answer."
						(gEgo setScript: putDownPhoneScript)
					)
				)
			)
			(4
				(Print 84 21) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (StrCmp @local0 {03-120-1204}))
				(if (Said 'talk[/man,guard]')
					(|= register $0002)
					(tunisia madeCall: 1)
					(Print 84 22) ; "You explain to the man on the other end that a new caterer will be making the delivery to the compound."
					(gGame changeScore: 2)
				else
					(Print 84 23) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 84 21) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
			((not (StrCmp @local0 {13-555-8097}))
				(if (or (Said 'talk[/man,bagdad,bagdad]') (Said 'order/food'))
					(|= register $0001)
					(Print 84 24) ; "You place an order and leave your phony name along with the address of the apartment."
					(Print 84 25) ; "The caterer thanks you for the order and hangs the phone up."
					(= local20 100)
					(gGame changeScore: 2)
				else
					(Print 84 23) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 84 21) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
		)
	)
)

(instance putDownPhoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 3 -1 self)
			)
			(1
				(phone cel: 0 forceUpd:)
				(gEgo setCycle: Beg self)
			)
			(2
				(gEgo
					view: (if (== (gEgo loop:) 1) 84 else 684)
					loop: 0
					setLoop: -1
					setCycle: Walk
					setScript: 0
				)
				(phone stopUpd:)
				(HandsOn)
			)
		)
	)
)

(instance windowski of RFeature
	(properties
		y 56
		x 159
		heading 180
		nsTop 40
		nsLeft 135
		nsBottom 67
		nsRight 183
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/window]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 26) ; "The window overlooks the street behind the apartment."
					)
					((GoToIfSaid self event 160 96 0 84 27))
					((Said 'look[<out]')
						(if (& (tunisia flags:) $0001)
							(Print 84 28) ; "The situation outside the compound is unchanged."
						else
							(tunisia bagTimer: local20)
							(gCurRoom newRoom: 85) ; apartmentWindowRm
						)
					)
				)
			)
		)
	)
)

(instance kitchen of RFeature
	(properties
		y 80
		x 285
		heading 225
		nsTop 64
		nsLeft 251
		nsBottom 97
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/kitchen]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 29) ; "The kitchen is small but adequate."
						(Print 84 30) ; "It's equipped with a counter, sink, refrigerator and stove."
					)
				)
			)
		)
	)
)

(instance sink of RFeature
	(properties
		y 82
		x 260
		heading 270
		nsTop 76
		nsLeft 254
		nsBottom 88
		nsRight 266
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/sink]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 31) ; "A typical kitchen sink."
					)
				)
			)
		)
	)
)

(instance cabinet of RFeature
	(properties
		y 54
		x 226
		heading 180
		nsTop 40
		nsLeft 209
		nsBottom 68
		nsRight 244
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/cabinet]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 32) ; "A typical kitchen cabinet."
					)
					((Said 'open')
						(Print 84 33) ; "Nothing in the cabinet is of interest to you."
					)
				)
			)
		)
	)
)

(instance kounter of RFeature
	(properties
		y 88
		x 232
		heading 225
		nsTop 75
		nsLeft 212
		nsBottom 101
		nsRight 233
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/counter]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 34) ; "You see a set of canisters on the counter."
					)
				)
			)
		)
	)
)

(instance fridge of Prop
	(properties
		y 142
		x 301
		heading 270
		view 284
		priority 9
		signal 16401
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/freezer]>') (Said '/top/freezer>'))
				(cond
					((TurnIfSaid self event))
					((Said 'look[<at]')
						(Print 84 35) ; "It appears to be an old "Frost Queen" icebox."
					)
					((Said 'look<in')
						(if (not (self cel:))
							(Print 84 36) ; "Open it up first."
						else
							(Print 84 37) ; "In the icebox you see:"
							(Print 84 38) ; "Various perishable food items that don't hold your interest."
							(Print 84 39) ; "You also see, a ketchup bottle, some milk, one butter dish and a block of cheese."
							(Print 84 40) ; ""Not very well stocked." you think."
						)
					)
					((Said 'close')
						(if (!= cel (self lastCel:))
							(Print 84 41) ; "It's already closed."
						else
							(self setScript: (ScriptID 362 1)) ; closeFridgeScript
						)
					)
					((Said 'look/top/freezer')
						(if (gEgo has: 7) ; Sub: Flare | Tunisia: Duct_Tape
							(proc0_36) ; "You see nothing special."
						else
							(Print 84 42) ; "On top of the icebox you see a roll of tape."
						)
					)
					((and (& (tunisia flags:) $0001) (Said 'open'))
						(Print 84 43) ; "This is no time to be thinking about food."
					)
					((GoToIfSaid self event 288 140 0 84 27))
					((Said 'open')
						(if cel
							(Print 84 44) ; "It's already open."
						else
							(self setScript: (ScriptID 362 0)) ; openFridgeScript
						)
					)
				)
			)
		)
	)
)

(instance fridgeSide of PV
	(properties
		y 142
		x 306
		view 284
		loop 3
		priority 10
		signal 16384
	)
)

(instance sugar of Prop
	(properties
		y 128
		x 239
		z 24
		heading 180
		view 284
		loop 1
		priority 9
		signal 16401
	)

	(method (cue)
		(localproc_0 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<sugar]>') (Said '[/canister<big]>'))
				(cond
					((Said 'drop,place,replace')
						(localproc_0 0)
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 45) ; "The large canister is labelled "Sugar"."
					)
					(
						(and
							(& (tunisia flags:) $0001)
							(or (Said '/canister<sugar') (Said '/canister<big'))
						)
						(Print 84 46) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty'))
						(Print 84 47) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 0 84 27))
					((Said 'get')
						(Print 84 48) ; "You lift the large canister from the counter."
						(if (not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
							(Print 84 49) ; "You immediately notice, it seems to be bottom-heavy."
						)
						(localproc_0 self)
					)
				)
			)
		)
	)
)

(instance flour of Prop
	(properties
		y 128
		x 247
		z 24
		heading 180
		view 284
		loop 1
		cel 1
		priority 9
		signal 16401
	)

	(method (cue)
		(localproc_0 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<flour]>') (Said '[/canister<medium]>'))
				(cond
					((Said 'drop,place,replace')
						(localproc_0 0)
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 50) ; "The middle sized canister is labelled "Flour"."
					)
					(
						(and
							(& (tunisia flags:) $0001)
							(or
								(Said '/canister<flour')
								(Said '/canister<medium')
							)
						)
						(Print 84 46) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty'))
						(Print 84 47) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 0 84 27))
					((Said 'get')
						(Print 84 51) ; "You lift the middle sized canister from the counter."
						(localproc_0 self)
					)
					((Said 'look<in/canister,canister')
						(Print 84 52) ; "You see the inside of the flour canister."
					)
				)
			)
		)
	)
)

(instance coffee of Prop
	(properties
		y 128
		x 255
		z 24
		heading 180
		view 284
		loop 1
		cel 2
		priority 9
		signal 16401
	)

	(method (cue)
		(localproc_0 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<coffee]>') (Said '[/canister<little]>'))
				(cond
					((Said 'drop,place,replace')
						(localproc_0 0)
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 53) ; "The small canister is labelled "Coffee"."
					)
					(
						(and
							(& (tunisia flags:) $0001)
							(or
								(Said '/canister<coffee')
								(Said '/canister<little')
							)
						)
						(Print 84 46) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty'))
						(Print 84 47) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 0 84 27))
					((Said 'get')
						(Print 84 54) ; "You lift the small canister from the counter."
						(localproc_0 self)
					)
					((Said 'look<in/canister,canister')
						(Print 84 55) ; "You see some coffee."
					)
				)
			)
		)
	)
)

(instance phone of Prop
	(properties
		y 59
		x 198
		view 984
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/call]>')
				(cond
					((TurnIfSaid self event))
					((Said 'look[<at]')
						(Print 84 56) ; "A phone, courtesy of the Tunisian Phone Company."
					)
					(
						(and
							(& (tunisia flags:) $0001)
							(or
								(Said 'get,dial,(pick<up)')
								(Said '(call<use)')
								(Said 'make/call<call')
							)
						)
						(Print 84 57) ; "You don't have time for phone calls."
					)
					(
						(or
							(Said 'get,call,dial,(pick<up)')
							(Said '(call<use)')
							(Said 'make/call<call')
						)
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 187 95 self
						)
					)
				)
			)
		)
	)

	(method (cue)
		(gEgo setScript: phoneScript)
	)
)

(instance card of View
	(properties
		y 57
		x 192
		view 284
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/card]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 58) ; "A business card for Bagdad's Fast Food catering service."
					)
					((GoToIfSaid self event 187 95 0 84 27))
					((Said 'get')
						(if (gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(proc0_35) ; "You already took that."
						else
							(Print 84 59) ; "You remove the business card from the wall."
							(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance tape of View
	(properties
		y 97
		x 301
		view 284
		loop 4
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/tape]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 60) ; "A handy roll of duct tape."
					)
					((GoToIfSaid self event 288 140 0 84 27))
					((Said 'get')
						(Print 84 61) ; "You pick up the tape."
						(gEgo get: 7) ; Sub: Flare | Tunisia: Duct_Tape
						(gGame changeScore: 1)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance bed of RFeature
	(properties
		y 106
		x 87
		nsTop 89
		nsLeft 67
		nsBottom 123
		nsRight 106
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bed]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 62) ; "A bed."
					)
					((Said 'sit')
						(Print 84 63) ; "This is no time for a break."
					)
				)
			)
		)
	)
)

(instance northWall of RFeature
	(properties
		y 59
		x 161
		nsTop 31
		nsLeft 73
		nsBottom 87
		nsRight 249
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/wall]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 64) ; "The north wall has a large window, a phone, and a cabinet."
						(if (not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(Print 84 65) ; "A business card has been attached to the wall next to the phone."
						)
					)
				)
			)
		)
	)
)

(instance door of RFeature
	(properties
		y 167
		x 112
		nsTop 145
		nsLeft 83
		nsBottom 189
		nsRight 141
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 84 66) ; "The apartment door."
					)
					((Said 'open')
						(Print 84 67) ; "Just walk over to it."
					)
				)
			)
		)
	)
)

