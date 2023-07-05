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
	(return
		(not (and (< 0 (param1 x:) 319) (< 0 (- (param1 y:) (param1 z:)) 189)))
	)
)

(procedure (localproc_1 param1)
	(switch param1
		(0
			(sugar show: setScript: 0)
			(flour show: setScript: 0)
			(coffee show: setScript: 0)
			(DisposeScript 363)
			(gEgo put: 9 put: 10 put: 11) ; Sub: Cotter_pin | Tunisia: Sugar_Canister, Sub: Washer | Tunisia: Flour_Canister, Sub: Nut | Tunisia: Coffee_Canister
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
		(gIceGlobalSound number: 67 owner: gGame priority: 1 loop: -1 play:)
		(self
			setRegions: 310 ; tunisia
			setFeatures:
				windowski
				sink
				kitchen
				kounter
				bed
				cabinet
				northWall
				door
		)
		(LoadMany rsSCRIPT 362 365 363 369 319)
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
				(gEgo
					view: 84
					posn: 113 150
					loop: 3
					observeControl: 16384
					init:
				)
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
				(Print 84 0) ; "It's a one-room apartment with a small kitchen. A window overlooks the street behind the apartment."
			)
			((Said 'examine/room,apartment')
				(Print 84 1) ; "Go ahead."
			)
			((Said 'eat/food')
				(if (== (tunisia fridgeIs:) 0)
					(proc0_40) ; "You don't see that."
				else
					(Print 84 2) ; "Which item?"
				)
			)
			((Said 'read/note,newspaper')
				(if (gEgo has: 14) ; Sub: Code_Book | Tunisia: Note
					(Print 84 3) ; "After studying the note thoroughly, you conclude that a catering business by the name of "Bagdad's Fast Foods" makes a twice-daily delivery to the compound."
					(Print 84 4) ; "You futher note that both deliveries are at the same time each day."
					(Print 84 5) ; "Stacy's log file also reveals that one of the two guards will search the caterer prior to entry. The guard then always accompanies the caterer inside."
					(SetScore tunisia 413 4 4)
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'load/gun')
				(if (gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
					(Print 84 6) ; "It's already loaded."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_F10))
					(Said 'shoot')
					(Said 'shoot,use,fire/gun')
					(Said 'kill,shoot/bagdad,man')
				)
				(cond
					((not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
						(Print 84 7) ; "You don't have a weapon."
					)
					((tunisia bagBound:)
						(Print 84 8) ; "You almost use the weapon to subdue the caterer but decide to save your limited ammo for the compound guards."
					)
					(else
						(proc0_41) ; "That is not a good idea."
					)
				)
			)
			((Said 'read/card[<business]')
				(if (gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
					(Print 84 9 #icon 384 1 1) ; "A business card for Bagdad's Fast Food Catering Service.  Another phone number has been written on it."
				else
					(Print 84 10) ; "You need to get it first."
				)
			)
			((Said 'talk/man,bagdad')
				(if (tunisia bagBound:)
					(Print 84 11) ; "He doesn't respond, for obvious reasons."
				else
					(Print 84 12) ; "You don't have time for idle chatter."
				)
			)
			((Said 'hit/man,bagdad[/gun<with]')
				(if (tunisia bagBound:)
					(Print 84 13) ; "He's not going anywhere, don't bother."
				else
					(event claimed: 0)
				)
			)
			((Said 'hide,adjust<in,below/gun/hat')
				(if (gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
					(proc0_39) ; "You don't need to do that."
				else
					(event claimed: 0)
				)
			)
			((Said 'untie/man,bagdad')
				(if (tunisia bagBound:)
					(Print 84 14) ; "That would jeopardize the mission."
				else
					(event claimed: 0)
				)
			)
			((Said 'throw/canister')
				(Print 84 15) ; "That would accomplish nothing."
			)
			((Said 'heist,get/man,money[/man<from]')
				(if (tunisia bagBound:)
					(Print 84 16) ; "This is not a robbery, Johnny!"
				else
					(event claimed: 0)
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
					(localproc_1 0)
				)
				(if (fridge script:)
					((ScriptID 362 0) cue:) ; openFridgeScript
				)
			)
			(1
				(self setScript: (ScriptID 365 0) self) ; bagdadKnockScript
			)
			(2
				(= cycles 2)
			)
			(3
				((ScriptID 365 1) dispose:) ; handsUpScript
				(DisposeScript 365)
				(Animate (gCast elements:) 0)
				(if (& (tunisia flags:) $0004)
					(self setScript: (ScriptID 319 0)) ; tooLateScript
				else
					(self setScript: (ScriptID 369 0)) ; stacyInScript
					(= local22 1)
				)
			)
			(4
				(DisposeScript 369)
				(= local22 0)
				(= local20 10000)
				(tunisia flags: (& (tunisia flags:) $fffe))
				(gEgo ignoreControl: 16384)
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
				(if (and local22 (localproc_0 (ScriptID 310 3))) ; agent
					(Print 84 17) ; "Wait for the agent."
				else
					(Print 84 18) ; "You won't gain a thing by leaving now."
				)
				(gEgo
					setMotion: stayMoveTo (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stayMoveTo of MoveTo
	(properties)

	(method (dispose)
		(if (and (IsObject caller) (caller client:))
			(caller cue:)
		)
		(super dispose:)
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
				(Print 84 19 #edit @local0 20) ; "Number to dial: (ESC to hang up) (xx-xxx-xxxx)"
				(= seconds 3)
			)
			(3
				(cond
					((not (StrCmp @local0 {}))
						(self cue:)
					)
					((not (StrCmp @local0 {13-555-8097}))
						(if (not (& register $0001))
							(Print 84 20 #time 10) ; "After a couple of rings, a voice on the other end says..."
							(Print 84 21) ; "Bagdad's Fast Food Catering Service, can I help you?"
							(User canInput: 1)
							(= seconds 10)
						else
							(Print 84 22) ; "Nobody answers."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					((not (StrCmp @local0 {03-120-1204}))
						(if (not (& register $0002))
							(Print 84 23 #time 10) ; "The voice on the other end says, "This is Basal!  Speak your business!""
							(User canInput: 1)
							(= seconds 10)
						else
							(Print 84 24) ; "Calling again would arouse suspicion."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					(else
						(Print 84 25 #time 10) ; "There is no answer."
						(gEgo setScript: putDownPhoneScript)
					)
				)
			)
			(4
				(Print 84 26) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (StrCmp @local0 {03-120-1204}))
				(if (Said 'talk[/man,guard,basal]')
					(|= register $0002)
					(tunisia madeCall: 1)
					(Print 84 27) ; "You explain to the man on the other end that a new caterer will be making the delivery to the compound."
					(gGame changeScore: 2)
				else
					(Print 84 28) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 84 26) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
			((not (StrCmp @local0 {13-555-8097}))
				(if (or (Said 'talk[/man,bagdad,bagdad]') (Said 'order/food'))
					(|= register $0001)
					(Print 84 29) ; "You place an order and leave your phony name along with the address of the apartment."
					(Print 84 30) ; "The caterer thanks you for the order and hangs the phone up."
					(= local20 200)
					(tunisia flags: (| (tunisia flags:) $0001))
					(gGame changeScore: 2)
				else
					(Print 84 28) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 84 26) ; "Click."
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
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 31) ; "The window overlooks the street behind the apartment."
					)
					((GoToIfSaid self event 160 96 0 84 32))
					((Said 'look[<out,through]')
						(if (& (tunisia flags:) $0001)
							(Print 84 33) ; "The situation outside the compound is unchanged."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 34) ; "The kitchen is small but adequate."
						(Print 84 35) ; "It's equipped with a counter, sink, refrigerator and stove."
					)
				)
			)
			((Said '/drawer>')
				(if (Said 'open,examine,look[<at,in]')
					(Print 84 36) ; "There's nothing of interest in the drawer."
				)
			)
			((Said '/stove>')
				(cond
					((Said 'open,examine,look[<at,in]')
						(Print 84 36) ; "There's nothing of interest in the drawer."
					)
					((Said 'use,turn<on,off')
						(proc0_39) ; "You don't need to do that."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 37) ; "A typical kitchen sink."
					)
					((Said 'look<below')
						(proc0_36) ; "You see nothing special."
					)
					((Said 'use')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
			((or (Said 'drink,use,turn<on/water') (Said 'wash/hand,feet'))
				(proc0_39) ; "You don't need to do that."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 38) ; "A typical kitchen cabinet."
					)
					((Said 'open,(look<in)')
						(Print 84 39) ; "Nothing in the cabinet is of interest to you."
					)
				)
			)
		)
	)
)

(instance kounter of RFeature
	(properties
		y 131
		x 244
		heading 180
		nsTop 98
		nsLeft 223
		nsBottom 131
		nsRight 266
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/counter]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,on]')
						(Print 84 40) ; "There are three canisters on the counter, labelled 'Sugar', 'Flour', and 'Coffee'."
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
			(
				(or
					(Said '[/freezer,(box<ice)]>')
					(Said '/top/freezer,(box<ice)>')
				)
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 41) ; "It appears to be an old "Frost Queen" icebox."
					)
					((Said 'examine,look<in')
						(if (not cel)
							(Print 84 42) ; "Open it first."
						else
							(Print 84 43) ; "In the icebox you see:"
							(Print 84 44) ; "Various perishable food items that don't hold your interest."
							(if (== (tunisia cheezIs:) 2)
								(Print 84 45) ; "You also see a ketchup bottle, some milk, and a butter dish."
							else
								(Print 84 46) ; "You also see a ketchup bottle, some milk, a butter dish, and a block of cheese."
							)
							(Print 84 47) ; ""Not very well-stocked," you think."
						)
					)
					((Said 'close')
						(if (!= cel (self lastCel:))
							(Print 84 48) ; "It's already closed."
						else
							(self setScript: (ScriptID 362 1)) ; closeFridgeScript
						)
					)
					((Said 'look/top/freezer,(box<ice)')
						(if (gEgo has: 7) ; Sub: Flare | Tunisia: Duct_Tape
							(proc0_36) ; "You see nothing special."
						else
							(Print 84 49) ; "On top of the icebox you see a roll of tape."
						)
					)
					(
						(and
							(or (tunisia bagBound:) (& (tunisia flags:) $0001))
							(Said 'open')
						)
						(Print 84 50) ; "This is no time to be thinking about food."
					)
					((and local21 (Said 'open'))
						(Print 84 51) ; "You'll have to put down the canister first."
					)
					((and cel (Said 'open'))
						(Print 84 52) ; "It's already open."
					)
					((GoToIfSaid self event self 12 'open' 84 32))
					((Said 'open')
						(HandsOff)
						(DisposeScript 363)
						(self setScript: (ScriptID 362 0)) ; openFridgeScript
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
		(localproc_1 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<sugar]>') (Said '[/canister<big]>'))
				(cond
					((Said 'drop,adjust,replace')
						(localproc_1 0)
					)
					((and local21 (Said '(get[<!*])/*'))
						(Print 84 53) ; "Put down the one you have first."
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 54) ; "The three canisters are labelled "Sugar", "Flour", and "Coffee"."
					)
					(
						(and
							(or (& (tunisia flags:) $0001) (tunisia bagBound:))
							(Said '/*')
						)
						(Print 84 55) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty,pour[<out]'))
						(Print 84 56) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 '(get[<!*])/*' 84 32))
					((Said '(get[<!*])/*')
						(Print 84 57) ; "You lift the large canister from the counter."
						(if (not (gEgo has: 8)) ; Sub: Device | Tunisia: Tranquilizer_Gun
							(Print 84 58) ; "You immediately notice that it seems to be bottom-heavy."
						)
						(localproc_1 self)
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
		(localproc_1 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<flour]>') (Said '[/canister<medium]>'))
				(cond
					((Said 'drop,adjust,replace')
						(localproc_1 0)
					)
					((and local21 (Said '(get[<!*])/*'))
						(Print 84 53) ; "Put down the one you have first."
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 54) ; "The three canisters are labelled "Sugar", "Flour", and "Coffee"."
					)
					(
						(and
							(or (& (tunisia flags:) $0001) (tunisia bagBound:))
							(Said '/*')
						)
						(Print 84 55) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty,pour[<out]'))
						(Print 84 56) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 '(get[<!*])/*' 84 32))
					((Said '(get[<!*])/*')
						(Print 84 59) ; "You lift the medium-sized canister from the counter."
						(localproc_1 self)
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
		(localproc_1 0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/canister<coffee]>') (Said '[/canister<little]>'))
				(cond
					((Said 'drop,adjust,replace')
						(localproc_1 0)
					)
					((and local21 (Said '(get[<!*])/*'))
						(Print 84 53) ; "Put down the one you have first."
					)
					(local21)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 54) ; "The three canisters are labelled "Sugar", "Flour", and "Coffee"."
					)
					(
						(and
							(or (& (tunisia flags:) $0001) (tunisia bagBound:))
							(Said '/*')
						)
						(Print 84 55) ; "You don't have time for that."
					)
					((or (Said 'open') (Said 'empty,pour[<out]'))
						(Print 84 56) ; "You'll need to get it first."
					)
					((GoToIfSaid self event self 15 '(get[<!*])/*' 84 32))
					((Said '(get[<!*])/*')
						(Print 84 60) ; "You lift the small canister from the counter."
						(localproc_1 self)
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 61) ; "A phone, courtesy of the Tunisian Phone Company."
					)
					((Said 'shoot')
						(Print 84 62) ; "That would be foolish."
					)
					(
						(and
							(& (tunisia flags:) $0001)
							(or
								(Said '(get[<!*]),dial,(pick<up)')
								(Said '(call<use)')
								(Said 'make/call<call')
								(Said 'call/guard,compound,bagdad')
							)
						)
						(Print 84 63) ; "You don't have time for phone calls."
					)
					(
						(or
							(Said '(get[<!*]),call,dial,(pick<up)')
							(Said '(call<use)')
							(Said 'make/call<call')
						)
						(if (User controls:)
							(HandsOff)
							(gEgo
								setAvoider: Avoid
								setMotion: MoveTo 187 95 self
							)
						else
							(Print 84 32) ; "You can't do that here and now."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 64) ; "A business card for Bagdad's Fast Food Catering Service."
					)
					((GoToIfSaid self event 187 95 0 84 32))
					((Said '(get[<!*])/*')
						(if (gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(proc0_35) ; "You already took that."
						else
							(Print 84 65) ; "You remove the business card from the wall."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 66) ; "A handy roll of duct tape."
					)
					((GoToIfSaid self event fridge 12 0 84 32))
					((Said '(get[<!*])/*')
						(Print 84 67) ; "You pick up the tape."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 68) ; "A bed."
					)
					((Said 'look<below,on')
						(proc0_36) ; "You see nothing special."
					)
					((Said 'sit')
						(Print 84 69) ; "This is no time for a break."
					)
					((Said 'rest')
						(Print 84 70) ; "Although it's a relaxing thought, you really don't have the time for slumber."
					)
					((Said 'make')
						(proc0_39) ; "You don't need to do that."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 71) ; "The north wall has a large window, a phone, and a cabinet."
						(if (not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(Print 84 72) ; "A business card has been attached to the wall next to the phone."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 84 73) ; "The apartment door."
					)
				)
			)
		)
	)
)

