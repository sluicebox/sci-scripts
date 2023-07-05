;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use n339)
(use n802)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm331 0
	DB 1
	bartender 2
	smoke 3
	barSound 4
	head 5
	trap 6
	crusher 7
	bartenderScript 8
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 1
	local10 = 5
	local11 = 25
)

(procedure (localproc_0 param1)
	(if (Purchase param1)
		(HighPrint 331 68) ; "You thank the bartender and pay him for your beverage."
	else
		(localproc_1)
	)
)

(procedure (localproc_1)
	(HighPrint 331 69) ; "You inform the bartender that you seem to be temporarily strapped for funds."
	(HighPrint 331 70) ; "He says, "Hey Crusher! Get this deadbeat bum outta here!""
	(crusher setScript: (ScriptID 337 0)) ; crusherThrows
)

(instance barSound of Sound
	(properties
		number 44
	)
)

(instance rm331 of Rm
	(properties
		picture 331
		style 2
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 98)
		(super dispose:)
		(LoadMany 0 335 336 337 338 339)
	)

	(method (init)
		(Load rsPIC 400)
		(LoadMany rsVIEW 331 338 337 336 504)
		(LoadMany rsSOUND (SoundFX 43) (SoundFX 44))
		(LoadMany rsSCRIPT 339 335 336 337 338 802)
		(Load rsTEXT 257)
		(super init:)
		(gMouseHandler add: self)
		(self setLocales: 801)
		(SL enable:)
		(bartender init:)
		(crusher init:)
		(ClearFlag 113)
		(cond
			((or (>= global134 6) (and (> global134 0) (not (IsFlag 161))))
				(SetFlag 113)
			)
			((IsFlag 261)
				(= global134 6)
				(SetFlag 113)
			)
			((and (IsFlag 235) (== global134 3))
				(= global134 4)
			)
			((and (IsFlag 161) (<= global134 1))
				(= global134 2)
			)
			((== global134 3)
				(SetFlag 113)
			)
		)
		(if (not (IsFlag 113))
			(gCurRoom setFeatures: onPaper)
		)
		(gCurRoom
			setFeatures:
				onButcher
				onBaker
				onGoon
				onTrapDoor
				onTableBottom
				onTableTop
				onStool1
				onStool2
				onStool3
				onKeg1
				onKeg2
				onKeg3
				onFloor
		)
		(SetFlag 255)
		(ClearFlag 254)
		(= global337 0)
		(= global336 0)
		(= global338 0)
		(head init: stopUpd: hide:)
		(NormalEgo)
		(gEgo init:)
		(gAddToPics
			add: drag lfTap rtTap ctrStool rtStool guck puddle barb players
			eachElementDo: #init
			doit:
		)
		(if (not (IsFlag 113))
			(paper init: stopUpd:)
		)
		(smoke init: setPri: 4 setCycle: Fwd startUpd:)
		(ooze init: setPri: 7 setScript: oozeScript)
		(trap init: setPri: 5 ignoreActors: stopUpd:)
		(DB init: setPri: 9 posn: 159 68 stopUpd:)
		(barSound number: (SoundFX 44) init:)
		(switch gPrevRoomNum
			(330
				(gEgo posn: 156 188 setMotion: MoveTo 156 175)
			)
			(332
				(gEgo posn: 120 150 loop: 0)
			)
			(else
				(SetFlag 98)
				(gEgo posn: 156 188 setMotion: MoveTo 156 175)
			)
		)
		(if (not (IsFlag 98))
			(self setScript: rm331Script)
		)
	)

	(method (doit)
		(if (> (gEgo y:) 188)
			(gCurRoom newRoom: 330)
		)
		(if (> local5 0)
			(-- local5)
		)
		(cond
			((and (gEgo inRect: 171 140 291 183) (not local3))
				(= local3 1)
				(gEgo setScript: cardScript)
			)
			((and (not (gEgo inRect: 171 140 291 183)) local3)
				(= local3 0)
				(gEgo setScript: 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((!= (event type:) evSAID))
			((Said 'get,lockpick[<up]/note,note')
				(if (gEgo inRect: 128 106 171 130)
					(if (IsFlag 113)
						(HighPrint 331 0) ; "There's nothing there."
					else
						(paper hide:)
						(gEgo get: 10) ; note
						(SetFlag 113)
						(= local2 1)
						(++ global134)
						(SolvePuzzle 731 2)
						(HighPrint 331 1) ; "You pick up the note."
						(rm331Script changeState: 2)
					)
				else
					(HighPrint 331 2) ; "Where?"
				)
			)
			((Said 'look,read/note,note')
				(if local2
					(rm331Script changeState: 2)
				else
					(HighPrint 331 3) ; "You don't have anything like that to look at."
				)
			)
			((Said 'look>')
				(proc339_0 event)
			)
			((Said 'spit')
				(HighPrint 331 4) ; "The bartender frowns on customers who spit in his establishment."
			)
			((Said 'sat')
				(cond
					((gEgo inRect: 192 109 237 130)
						(proc339_2 1)
					)
					((gEgo inRect: 128 106 171 130)
						(if (IsFlag 254)
							(HighPrint 331 5) ; "You're already sitting down."
						else
							(gEgo setScript: (ScriptID 338 0)) ; sitDown
						)
					)
					(local0
						(HighPrint 331 6) ; "You're not close enough to a barstool."
					)
					(else
						(HighPrint 331 7) ; "Looks like the only place to sit is at the bar."
					)
				)
			)
			((Said 'run,walk,sneak')
				(if (IsFlag 254)
					(HighPrint 331 8) ; "Separate yourself from that stool first."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'get<up,down,off[/barstool,chair]') (Said 'stand[<up]'))
				(if (IsFlag 254)
					(cond
						((and (== global337 0) (== global336 0))
							(gEgo setScript: (ScriptID 338 1)) ; getDown
						)
						((and (== global337 0) (> global336 0))
							(HighPrint 331 9) ; "Wait for the drink you just ordered."
						)
						(else
							(HighPrint 331 10) ; "Go ahead and drink up, first. You paid for it!"
						)
					)
				else
					(HighPrint 331 11) ; "But you're not sitting down!"
				)
			)
			((Said 'show,make/sign[<thief]')
				(if local1
					(HighPrint 331 12) ; "You'd better talk to Crusher."
				else
					(HighPrint 331 13) ; "You'll have to get the bartender's attention first."
				)
			)
			((or (Said 'order,buy,get/drink') (Said 'ask//drink'))
				(if local1
					(if (not (IsFlag 254))
						(HighPrint 331 14) ; "The bartender bellows, "Sit down first!""
					else
						(HighPrint 331 15) ; "OK. What'll you have?"
					)
				else
					(HighPrint 331 13) ; "You'll have to get the bartender's attention first."
				)
			)
			((or (Said '[order,buy,get]/ale') (Said 'ask//ale'))
				(if local1
					(cond
						((not (IsFlag 254))
							(HighPrint 331 14) ; "The bartender bellows, "Sit down first!""
						)
						((> global337 0)
							(HighPrint 331 16) ; "Drink up before you order anything else!"
						)
						(else
							(= global336 1)
							(HighPrint 331 17) ; "The bartender says, "One well-aged house brew, coming up!""
							(bartenderScript changeState: 9)
						)
					)
				else
					(HighPrint 331 18) ; "You'll need the bartender's help on that one."
				)
			)
			(
				(or
					(Said '[order,buy,get]/sweat[<troll]')
					(Said 'ask//sweat[<troll]')
				)
				(if local1
					(cond
						((not (IsFlag 254))
							(HighPrint 331 14) ; "The bartender bellows, "Sit down first!""
						)
						((> global337 0)
							(HighPrint 331 16) ; "Drink up before you order anything else!"
						)
						(else
							(= global336 2)
							(HighPrint 331 19) ; "The bartender says, "One mug of my fine Troll's Sweat, coming up!""
							(bartenderScript changeState: 9)
						)
					)
				else
					(HighPrint 331 20) ; "Sounds potent, but you'd better go see the bartender if you want some."
				)
			)
			(
				(or
					(Said '[order,buy,get]/breath[<dragon]')
					(Said 'ask//breath[<dragon]')
				)
				(if local1
					(cond
						((not (IsFlag 254))
							(HighPrint 331 14) ; "The bartender bellows, "Sit down first!""
						)
						((> global337 0)
							(HighPrint 331 16) ; "Drink up before you order anything else!"
						)
						(else
							(= global336 3)
							(HighPrint 331 21) ; "The bartender is emphatic as he tells you, "If you want a mug of Dragon's Breath, house rules say it'll have to be cash up front!""
							(if (Purchase local11)
								(HighPrint 331 22) ; "You cough up the cash."
								(HighPrint 331 23) ; "Thanks, buddy!"
								(HighPrint 331 24) ; "Hey, Crusher! Our friend here wants Dragon's Breath!"
								(bartenderScript changeState: 9)
							else
								(= global336 0)
								(HighPrint 331 25) ; "You tell the bartender that you don't have enough working capital at this point in time."
								(HighPrint 331 26) ; "He says, "Too bad, buddy. You're missing a real treat, for sure!""
							)
						)
					)
				else
					(HighPrint 331 27) ; "Well then! Belly up to the bar and get some Dragon's Breath!"
				)
			)
			((Said 'pay')
				(if local1
					(HighPrint 331 28) ; "For what?"
				else
					(HighPrint 331 29) ; "The bartender can't reach your money. You're not close enough."
				)
			)
			((Said 'drink>')
				(cond
					((Said '/ale')
						(switch global337
							(0
								(HighPrint 331 30) ; "You'll need to buy one."
							)
							(1
								(++ global338)
								(gEgo setScript: (ScriptID 336 0)) ; drinkDown
							)
							(else
								(HighPrint 331 31) ; "That ain't beer!"
							)
						)
					)
					((Said '/sweat[<troll]')
						(switch global337
							(0
								(HighPrint 331 30) ; "You'll need to buy one."
							)
							(2
								(gEgo setScript: (ScriptID 336 0)) ; drinkDown
							)
							(else
								(HighPrint 331 32) ; "That isn't Troll's Sweat!"
							)
						)
					)
					((Said '/breath[<dragon]')
						(switch global337
							(0
								(HighPrint 331 30) ; "You'll need to buy one."
							)
							(3
								(gEgo setScript: (ScriptID 336 0)) ; drinkDown
							)
							(else
								(HighPrint 331 33) ; "That isn't Dragon's Breath!"
							)
						)
					)
					((Said '[/!*]')
						(switch global337
							(0
								(HighPrint 331 30) ; "You'll need to buy one."
							)
							(1
								(++ global338)
								(gEgo setScript: (ScriptID 336 0)) ; drinkDown
							)
							(else
								(gEgo setScript: (ScriptID 336 0)) ; drinkDown
							)
						)
					)
				)
			)
		)
	)
)

(instance rm331Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(proc339_1 1 1)
			)
			(2
				(HighPrint 331 34) ; "You smooth out the piece of paper and read:"
				(cond
					((== global134 1)
						(HighPrint 331 35) ; "B. - He's starting to act suspicious. Better save this drop for emergencies. - B."
					)
					((== global134 3)
						(HighPrint 331 36) ; "B. - Meet me at the old archery range south of town at noon -- urgent! - B."
					)
					(else
						(HighPrint 331 37) ; "B. - That new adventurer is getting too nosy. Deal with him. - B."
						(HighPrint 331 38) ; "Oh, isn't that nice! Sounds like you're going to be invited to a card game."
						(= global134 6)
					)
				)
			)
		)
	)
)

(instance oozeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ooze stopUpd:)
				(= cycles (Random 30 90))
			)
			(1
				(= state -1)
				(ooze setCycle: End self)
			)
		)
	)
)

(instance bartender of Act
	(properties
		view 336
		loop 2
		illegalBits 0
	)

	(method (init)
		(self posn: 162 80 stopUpd:)
		(self setScript: bartenderScript)
		(super init:)
	)

	(method (doit)
		(cond
			((and (< (gEgo y:) 113) (not (IsFlag 254)) (not local0))
				(= local0 1)
				(bartenderScript changeState: 6)
			)
			((and (> (gEgo y:) 113) local0)
				(= local0 0)
				(bartenderScript changeState: 0)
			)
			((or local0 (IsFlag 254))
				(= local1 1)
			)
			((and (not local0) (not (IsFlag 254)))
				(= local1 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (MouseClaimed bartender event 3)
					(HighPrint 331 39) ; "The bartender looks tough from his crewcut to his boots. The only thing soft about him is his tattoo, which says "MAMA"."
				)
			)
			(evSAID
				(if local1
					(cond
						((Said 'yes,please')
							(if (> local5 0)
								(HighPrint 331 40) ; "Crusher, escort this squealer off the premises!"
								(crusher setScript: (ScriptID 337 0)) ; crusherThrows
							else
								(HighPrint 331 41) ; "Yes...what?"
							)
						)
						((Said 'no')
							(if (> local5 0)
								(HighPrint 331 42) ; "OK."
							else
								(HighPrint 331 43) ; "No...what?"
							)
						)
						((Said 'talk>')
							(cond
								((Said '/man,bartender')
									(HighPrint 331 44) ; "The bartender shows little interest in small talk."
								)
								((Said '/bum,barber')
									(HighPrint 331 45) ; "The drunken barber at the end of the bar isn't in any shape to talk, at least not coherently."
								)
							)
						)
						((Said 'ask>')
							(cond
								(
									(or
										(Said '//thief')
										(Said '//club<thief[<about]')
									)
									(HighPrint 331 46) ; "Hey! This is an honest establishment! You want me to ask Crusher?"
									(= local5 40)
								)
								((Said '//drink,cost')
									(HighPrint 331 47) ; "We've got some of the finest ale in the valley, only 1 silver."
									(HighPrint 331 48) ; "Our world-famous Troll's Sweat is always fresh and it's only 5 silvers."
									(HighPrint 331 49) ; "The Dragon's Breath is our specialty, and it's Crusher's personal favorite. It's very hard to come by, so it'll cost you 25 silver, cash up front."
								)
								((Said '//sweat[<troll,about]')
									(HighPrint 331 48) ; "Our world-famous Troll's Sweat is always fresh and it's only 5 silvers."
								)
								((Said '//ale')
									(HighPrint 331 47) ; "We've got some of the finest ale in the valley, only 1 silver."
								)
								((Said '//breath[<dragon,about]')
									(HighPrint 331 49) ; "The Dragon's Breath is our specialty, and it's Crusher's personal favorite. It's very hard to come by, so it'll cost you 25 silver, cash up front."
								)
								((Said '//mama,tattoo')
									(HighPrint 331 50) ; "Look buddy...don't get personal!"
								)
								((Said '//bouncer,goon,ogre')
									(HighPrint 331 51) ; "He don't like his personal affairs discussed. My advice is not to do anything that'll get him upset."
								)
								((Said '//*')
									(HighPrint 331 52) ; "This is a bar. I serve drinks. You want a drink, order one. You want answers to stupid questions, GET OUT!"
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance cardScript of Script
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'ask>')
						(cond
							((Said '//fish,trout,south,lake,river,water')
								(if local4
									(HighPrint 331 53) ; "The baker says, "There's a lake to the south which has a huge fish, but its pretty dangerous.""
									(= local4 0)
								else
									(HighPrint 331 54) ; "The butcher says, "There's a river to the south which has some good-sized trout."
									(= local4 1)
								)
							)
							((Said '//*')
								(HighPrint 331 55) ; "They don't seem to be paying any attention to you."
							)
						)
					)
					((Said 'talk/man,man,butcher,baker,player,gambler')
						(HighPrint 331 56) ; "These guys are so intent on their game that they don't want to open their mouths on any other subject."
					)
					((Said 'look/card,deck,player,butcher,baker')
						(HighPrint 331 57) ; "It looks like these guys aren't playing with a full deck."
					)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(= cycles (Random 20 40))
			)
			(1
				(HighPrint (Format @temp0 331 58 (Random 1 1000))) ; "Got any %d's?"
				(= cycles (Random 10 20))
			)
			(2
				(HighPrint 331 59) ; "Go FISH!"
				(self changeState: 0)
			)
		)
	)
)

(instance crusher of Act
	(properties
		view 338
	)

	(method (init)
		(super init:)
		(gKeyHandler add: self)
		(self posn: 92 153 stopUpd:)
	)

	(method (handleEvent event &tmp [temp0 10])
		(cond
			((super handleEvent: event))
			((not (gEgo inRect: 0 125 140 170)))
			((proc802_2 event (Format @temp0 257 global270))
				(if (and (not [gEgoStats 8]) (not [gEgoStats 9])) ; stealth, pick locks
					(HighPrint 331 60) ; "The bartender calls to Crusher: "Hey, he's not one of us! Take care of him!""
					(self setScript: (ScriptID 337 0)) ; crusherThrows
				else
					(self setScript: (ScriptID 337 1)) ; crusherEscorts
				)
			)
			((!= (event type:) evSAID))
			((Said 'show,make/sign[<thief]')
				(HighPrint 331 61) ; "Oh yeah? What's the password?"
			)
			((Said 'ask//thief,club')
				(HighPrint 331 62) ; "Uh oh! It looks like you got Crusher upset!"
				(self setScript: (ScriptID 337 0)) ; crusherThrows
			)
			((Said '[say,give,use]/password')
				(HighPrint 331 63) ; "Oh yeah? So what is it?"
			)
			((Said '[say]/swordfish')
				(HighPrint 331 64) ; "Good idea, but you're in the wrong movie."
				(self setScript: (ScriptID 337 0)) ; crusherThrows
			)
			((or (Said 'talk/man,goon,bouncer') (Said 'ask//*'))
				(switch local6
					(0
						(HighPrint 331 65) ; "The goon seems to be ignoring you."
					)
					(1
						(HighPrint 331 66) ; "As you ask him questions, the goon's eyes darken."
					)
					(2
						(HighPrint 331 67) ; "Uh oh! It looks like you got Crusher upset!"
						(self setScript: (ScriptID 337 0)) ; crusherThrows
					)
				)
				(++ local6)
			)
		)
	)
)

(instance bartenderScript of Script
	(properties)

	(method (doit)
		(cond
			((> local7 1)
				(-- local7)
				(if local8
					((ScriptID 331 2) ; bartender
						posn: ((ScriptID 331 2) x:) (- ((ScriptID 331 2) y:) 2) ; bartender, bartender
					)
				else
					((ScriptID 331 2) ; bartender
						posn: ((ScriptID 331 2) x:) (+ ((ScriptID 331 2) y:) 2) ; bartender, bartender
					)
				)
			)
			((== local7 1)
				(= local7 0)
				(self cue:)
				(if local8
					(= local8 0)
				else
					(= local8 1)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 20 80))
			)
			(1
				(= cycles 0)
				((ScriptID 331 2) ; bartender
					setCycle: Walk
					loop: 0
					setMotion: MoveTo 195 80 self
				)
			)
			(2
				((ScriptID 331 2) loop: (Random 2 3) stopUpd:) ; bartender
				(= cycles (Random 50 100))
			)
			(3
				((ScriptID 331 2) loop: 1 cel: -1 setMotion: MoveTo 124 80 self) ; bartender
			)
			(4
				((ScriptID 331 2) loop: (Random 2 3) stopUpd:) ; bartender
				(= cycles (Random 50 100))
			)
			(5
				(self changeState: 1)
			)
			(6
				(= cycles 0)
				(HandsOff)
				(if (> ((ScriptID 331 2) distanceTo: gEgo) 15) ; bartender
					((ScriptID 331 2) ; bartender
						loop:
							(if (< (gEgo x:) ((ScriptID 331 2) x:)) 1 else 0) ; bartender
						cel: -1
						setMotion:
							MoveTo
							(if (IsFlag 254)
								(+ (gEgo x:) 20)
							else
								(gEgo x:)
							)
							80
							self
					)
				else
					(self cue:)
				)
			)
			(7
				((ScriptID 331 2) loop: 2 stopUpd:) ; bartender
				(if (IsFlag 254)
					((ScriptID 331 5) setCel: 2) ; head
				)
				(= cycles 2)
			)
			(8
				(HighPrint 331 71) ; "Whaddaya want?"
				(if (IsFlag 254)
					(User canInput: 1)
				else
					(HandsOn)
				)
			)
			(9
				(if (== (gEgo loop:) 3)
					(gEgo loop: 2 cel: 0 stopUpd:)
					((ScriptID 331 5) show:) ; head
				)
				(switch global336
					(2
						((ScriptID 331 2) ; bartender
							setLoop: (if (IsFlag 255) 1 else 6)
							setCycle: Walk
							setMotion: MoveTo 124 80 self
						)
					)
					(else
						((ScriptID 331 2) ; bartender
							setLoop: (if (IsFlag 255) 0 else 5)
							setCycle: Walk
							setMotion: MoveTo 195 80 self
						)
					)
				)
			)
			(10
				(ClearFlag 255)
				((ScriptID 331 2) setLoop: 4 cel: 0 setPri: 5) ; bartender
				(= local7 7)
			)
			(11
				((ScriptID 331 2) cel: 1) ; bartender
				(= local7 8)
			)
			(12
				(switch global336
					(1
						(self cue:)
					)
					(2
						(self cue:)
					)
					(3
						((ScriptID 331 1) setScript: (ScriptID 335 0)) ; DB, breathScript
					)
				)
			)
			(13
				((ScriptID 331 2) ; bartender
					posn: (if (== global336 2) 124 else 195) 80
					setLoop: (if (== global336 2) 6 else 5)
					cel: 0
				)
				(= cycles 2)
			)
			(14
				((ScriptID 331 2) setLoop: 3) ; bartender
				(= cycles 20)
			)
			(15
				((ScriptID 331 2) ; bartender
					setLoop: (if (== global336 2) 5 else 6)
					setPri: -1
					setMotion:
						MoveTo
						(if (== global336 2)
							(+ (gEgo x:) 10)
						else
							(+ (gEgo x:) 20)
						)
						80
						self
				)
			)
			(16
				((ScriptID 331 2) ; bartender
					setLoop: (if (== global336 2) 0 else 1)
					cel: 0
				)
				(HighPrint 331 72) ; "There ya go!"
				(if (< global336 3)
					(switch global336
						(1
							(localproc_0 local9)
						)
						(2
							(localproc_0 local10)
						)
					)
				)
				(= global337 global336)
				(= global336 0)
				(= cycles 5)
			)
			(17
				(if (IsFlag 254)
					(gEgo loop: 3 cel: 0)
					((ScriptID 331 5) hide:) ; head
				)
				((ScriptID 331 2) setLoop: -1 setMotion: MoveTo 180 80 self) ; bartender
			)
			(18
				((ScriptID 331 2) loop: 2 stopUpd:) ; bartender
			)
		)
	)
)

(instance drag of PV
	(properties
		y 56
		x 160
		view 331
	)
)

(instance lfTap of PV
	(properties
		y 72
		x 125
		view 331
		cel 1
	)
)

(instance rtTap of PV
	(properties
		y 72
		x 195
		view 331
		cel 1
	)
)

(instance ctrStool of PV
	(properties
		y 111
		x 149
		view 331
		loop 3
	)
)

(instance rtStool of PV
	(properties
		y 113
		x 216
		view 331
		loop 3
	)
)

(instance guck of PV
	(properties
		y 89
		x 214
		view 331
		loop 3
		cel 3
		priority 8
	)
)

(instance puddle of PV
	(properties
		y 116
		x 222
		view 331
		loop 3
		cel 2
	)
)

(instance barb of PV
	(properties
		y 113
		x 108
		view 331
		loop 3
		cel 1
	)
)

(instance players of PV
	(properties
		y 172
		x 224
		view 331
		loop 5
	)
)

(instance paper of View
	(properties
		y 111
		x 145
		view 331
		cel 3
	)
)

(instance smoke of Prop
	(properties
		y 45
		x 160
		view 331
		loop 1
		cycleSpeed 1
	)
)

(instance ooze of Prop
	(properties
		y 91
		x 222
		view 331
		loop 4
		cycleSpeed 2
	)
)

(instance trap of Prop
	(properties
		y 155
		x 92
		view 331
		loop 2
		cycleSpeed 2
	)
)

(instance DB of Prop
	(properties
		view 337
		loop 3
		cel 12
		cycleSpeed 1
	)
)

(instance head of View
	(properties
		y 73
		x 150
		view 504
		loop 2
		cel 3
	)
)

(instance onPaper of RFeature
	(properties
		nsTop 108
		nsLeft 141
		nsBottom 113
		nsRight 148
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onPaper event 3)
				(HighPrint 331 73) ; "You see a crumpled piece of paper under the stool."
			)
		)
	)
)

(instance onButcher of RFeature
	(properties
		nsTop 126
		nsLeft 197
		nsBottom 144
		nsRight 215
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onButcher event 3)
				(if (IsFlag 254)
					(head setCel: 2)
				)
				(HighPrint 331 74) ; "The man on the west side of the table is wearing a blood-stained apron, like a butcher."
			)
		)
	)
)

(instance onBaker of RFeature
	(properties
		nsTop 117
		nsLeft 238
		nsBottom 145
		nsRight 252
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onBaker event 3)
				(if (IsFlag 254)
					(head setCel: 2)
				)
				(HighPrint 331 75) ; "The man on the east has on a baker's hat."
			)
		)
	)
)

(instance onGoon of RFeature
	(properties
		nsTop 108
		nsLeft 75
		nsBottom 140
		nsRight 93
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onGoon event 3)
				(HighPrint 331 76) ; "This goon looks really tough and mean. He's not someone to pick a fight with."
			)
		)
	)
)

(instance onTableTop of RFeature
	(properties
		nsTop 146
		nsLeft 196
		nsBottom 156
		nsRight 247
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTableTop event 3)
				(HighPrint 331 77) ; "Looks like some kind of card game."
			)
		)
	)
)

(instance onTrapDoor of RFeature
	(properties
		nsTop 139
		nsLeft 65
		nsBottom 155
		nsRight 96
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTrapDoor event 3)
				(HighPrint 331 78) ; "There appears to be a trapdoor beneath the goon, but he's blocking it very effectively."
			)
		)
	)
)

(instance onTableBottom of RFeature
	(properties
		nsTop 163
		nsLeft 209
		nsBottom 170
		nsRight 237
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onTableBottom event 3)
				(HighPrint 331 79) ; "Someone has carved into the bottom of the table " G. MEISTER slept here"."
			)
		)
	)
)

(instance onStool1 of RFeature
	(properties
		nsTop 70
		nsLeft 101
		nsBottom 106
		nsRight 113
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onStool1 event 3)
				(if (IsFlag 254)
					(head setCel: 1)
				)
				(HighPrint 331 80) ; "So this is where the barber goes to lunch! The guy's had so much liquid diet, he looks embalmed."
			)
		)
	)
)

(instance onStool2 of RFeature
	(properties
		nsTop 85
		nsLeft 142
		nsBottom 107
		nsRight 152
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onStool2 event 3)
				(if (IsFlag 254)
					(HighPrint 331 81) ; "Yup, You're sitting on a stool."
				else
					(HighPrint 331 7) ; "Looks like the only place to sit is at the bar."
				)
			)
		)
	)
)

(instance onStool3 of RFeature
	(properties
		nsTop 87
		nsLeft 210
		nsBottom 116
		nsRight 226
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onStool3 event 3)
				(HighPrint 331 82) ; "Not a pleasant sight!"
			)
		)
	)
)

(instance onKeg1 of RFeature
	(properties
		nsTop 42
		nsLeft 114
		nsBottom 76
		nsRight 136
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg1 event 3)
				(HighPrint 331 83) ; "The world-famous Troll's Sweat is always fresh."
			)
		)
	)
)

(instance onKeg2 of RFeature
	(properties
		nsTop 12
		nsLeft 140
		nsBottom 76
		nsRight 175
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg2 event 3)
				(HighPrint 331 84) ; "Dragon's Breath is the house specialty, and it's Crusher's personal favorite."
			)
		)
	)
)

(instance onKeg3 of RFeature
	(properties
		nsTop 43
		nsLeft 180
		nsBottom 76
		nsRight 208
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onKeg3 event 3)
				(HighPrint 331 85) ; "Some of the finest ale in the valley."
			)
		)
	)
)

(instance onFloor of RFeature
	(properties
		nsTop 116
		nsLeft 106
		nsBottom 172
		nsRight 189
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onFloor event 3)
				(HighPrint 331 86) ; "Nothing but a dirty floor."
			)
		)
	)
)

