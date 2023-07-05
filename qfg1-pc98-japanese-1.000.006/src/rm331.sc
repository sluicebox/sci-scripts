;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use Interface)
(use n813)
(use LoadMany)
(use Rev)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm331 0
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

(procedure (localproc_0 param1 &tmp temp0)
	(HandsOff)
	(gCast eachElementDo: #stopUpd)
	(crusher cycleSpeed: 1 setCycle: End)
	(if (<= (gEgo distanceTo: crusher) 25)
		(if (== (= temp0 (gEgo priority:)) (crusher priority:))
			(++ temp0)
		)
		(gEgo
			setPri: temp0
			setLoop: 1
			setCycle: Rev
			cycleSpeed: 1
			moveSpeed: 1
			ignoreActors: 1
			setMotion: MoveTo 125 150 param1
		)
	else
		(param1 cue:)
	)
)

(procedure (localproc_1 param1)
	(if (Purchase param1)
		(HighPrint 331 68) ; "You thank the bartender and pay him for your beverage."
	else
		(localproc_2)
	)
)

(procedure (localproc_2)
	(HighPrint 331 69) ; "You inform the bartender that you seem to be temporarily strapped for funds."
	(HighPrint 331 70) ; "He says, "Hey Crusher! Get this deadbeat bum outta here!""
	(crusher setScript: crusherThrows)
)

(procedure (localproc_3)
	(cond
		((Said '[<at,around][/!*,room,building,tavern,establishment]')
			(localproc_4 0 0)
		)
		((Said '/barrel,barrel')
			(if (IsFlag 254)
				(head setCel: 2)
			)
			(HighPrint 331 96 83) ; "From the size of the ancient oak kegs, you surmise that the drinking of large quantities of beverages is the main pastime in this establishment."
		)
		((Said '/dirt')
			(HighPrint 331 97) ; "As dirt goes, it's pretty dirty."
		)
		((Said '/ale,sweat,breath,drink,drink,beverage')
			(switch global337
				(0
					(HighPrint 331 98) ; "It's in the kegs."
				)
				(1
					(HighPrint 331 99) ; "Mighty frothy. Looks OK."
				)
				(2
					(HighPrint 331 100) ; "Looks lean, mean, and green."
				)
				(3
					(HighPrint 331 101) ; "The fumes hurt your eyes."
				)
			)
		)
		((Said '/bar,bar,spill,spill,cup')
			(if (IsFlag 254)
				(head setCel: 1)
			)
			(HighPrint 331 102) ; "It doesn't look like the bartender ever wipes up spills, and the glasses are truly filthy."
		)
		((Said '/bartender,boot,cut,crewcut,tattoo')
			(if (IsFlag 254)
				(if (> (bartender x:) (gEgo x:))
					(head setCel: 2)
				else
					(head setCel: 1)
				)
			)
			(HighPrint 331 39) ; "The bartender looks tough from his crewcut to his boots. The only thing soft about him is his tattoo, which says "MAMA"."
		)
		((or (Said '/bum,barber') (Said '/man/barstool'))
			(if (IsFlag 254)
				(head setCel: 1)
			)
			(HighPrint 331 80) ; "So this is where the barber goes to lunch! The guy's had so much liquid diet, he looks embalmed."
		)
		((Said '/gambler,table,player,butcher,baker')
			(if (IsFlag 254)
				(head setCel: 2)
			)
			(HighPrint 331 103) ; "The man on the west side of the table is wearing a blood-stained apron, like a butcher. The man on the east has on a baker's hat. They seem to be deeply involved in their game."
		)
		((Said '/card,game,cardgame')
			(if (not (gEgo inRect: 171 140 291 183))
				(HighPrint 331 104) ; "You can't see the game very well from where you are."
			else
				(HighPrint 331 105) ; "They seem to be using an "Old Maid" deck."
			)
		)
		((Said '/man')
			(HighPrint 331 106) ; "There are several."
		)
		((Said '/bouncer,goon')
			(if (IsFlag 254)
				(head setCel: 1)
			)
			(HighPrint 331 76) ; "This goon looks really tough and mean. He's not someone to pick a fight with."
		)
		((Said '/smoke,dragon')
			(HighPrint 331 107) ; "That's a mighty unusual keg, there."
		)
		((Said '<below/barstool')
			(cond
				((gEgo inRect: 128 106 171 130)
					(if (IsFlag 113)
						(HighPrint 331 86) ; "Nothing but a dirty floor."
					else
						(HighPrint 331 73) ; "You see a crumpled piece of paper under the stool."
					)
				)
				((gEgo inRect: 192 109 237 130)
					(HighPrint 331 108) ; "That looks mighty nasty!"
				)
				(else
					(HighPrint 331 86) ; "Nothing but a dirty floor."
				)
			)
		)
		((Said '/barstool')
			(if (gEgo inRect: 192 109 237 130)
				(localproc_5 0)
			else
				(HighPrint 331 109) ; "There are three bar stools at the bar."
			)
		)
		((Said '/goo')
			(if (gEgo inRect: 192 109 237 130)
				(HighPrint 331 82) ; "Not a pleasant sight!"
			else
				(NotClose)
			)
		)
		((or (Said '<up') (Said '/wall,ceiling,beam,forest'))
			(HighPrint 331 110) ; "It looks like something you'd expect to see in a tavern, but a lot dirtier."
		)
		((or (Said '<down') (Said '/floor'))
			(if (and (gEgo inRect: 128 106 171 130) (not (IsFlag 113)))
				(HighPrint 331 73) ; "You see a crumpled piece of paper under the stool."
			else
				(HighPrint 331 110) ; "It looks like something you'd expect to see in a tavern, but a lot dirtier."
			)
		)
		((Said '/chasm,door,trap')
			(HighPrint 331 78) ; "There appears to be a trapdoor beneath the goon, but he's blocking it very effectively."
		)
	)
)

(procedure (localproc_4 param1)
	(HighPrint 331 111) ; "The grimy window lets little light into this tavern. It smells like stale ale and other more unpleasant things. The floor is covered with dirt, and the bar with sticky beer."
	(HighPrint 331 112) ; "Smoke appears to be rising from the center cask behind the bar. To your right, two gamblers are playing cards."
	(if param1
		(HighPrint 331 113) ; "The bartender glares at you as you enter, and so does the ugly goon on the left. You get the impression that you are not welcome."
	)
)

(procedure (localproc_5)
	(HighPrint 331 114) ; "There seems to be something slimy spilled on top of the stool, and it is eating into the wood. You think perhaps you should sit on the next stool over."
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
	)

	(method (init)
		(Load rsPIC 400)
		(LoadMany rsVIEW 331 338 337 336 504)
		(LoadMany rsSOUND (SoundFX 43) (SoundFX 44))
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
		(dB init: setPri: 9 posn: 159 68 stopUpd:)
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
			((Said 'get,get,pick,lockpick[<up]/note,note')
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
			((Said 'look,look,read/note,note')
				(if local2
					(rm331Script changeState: 2)
				else
					(HighPrint 331 3) ; "You don't have anything like that to look at."
				)
			)
			((Said 'look,look>')
				(localproc_3 event)
			)
			((Said 'spit')
				(HighPrint 331 4) ; "The bartender frowns on customers who spit in his establishment."
			)
			((Said 'sat')
				(cond
					((gEgo inRect: 192 109 237 130)
						(localproc_5 1)
					)
					((gEgo inRect: 128 106 171 130)
						(if (IsFlag 254)
							(HighPrint 331 5) ; "You're already sitting down."
						else
							(gEgo setScript: sitDown)
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
			((or (Said 'walk,sneak') (Said 'run[/!*]'))
				(if (IsFlag 254)
					(HighPrint 331 8) ; "Separate yourself from that stool first."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(Said 'get,get<up,down,off[/barstool,chair]')
					(Said 'stand,stand[<up]')
				)
				(if (IsFlag 254)
					(cond
						((and (== global337 0) (== global336 0))
							(gEgo setScript: getDown)
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
			((Said 'show,make/sign,sign[<thief]')
				(if local1
					(HighPrint 331 12) ; "You'd better talk to Crusher."
				else
					(HighPrint 331 13) ; "You'll have to get the bartender's attention first."
				)
			)
			(
				(or
					(Said 'order,buy,get,get/drink,drink')
					(Said 'ask//drink,drink')
				)
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
			((or (Said '[order,buy,get,get]/ale') (Said 'ask//ale'))
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
					(Said '[order,buy,get,get]/sweat[<troll]')
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
					(Said '[order,buy,get,get]/breath[<dragon]')
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
			((Said 'drink,drink>')
				(cond
					((Said '/ale')
						(switch global337
							(0
								(HighPrint 331 30) ; "You'll need to buy one."
							)
							(1
								(++ global338)
								(gEgo setScript: drinkDown)
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
								(gEgo setScript: drinkDown)
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
								(gEgo setScript: drinkDown)
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
								(gEgo setScript: drinkDown)
							)
							(else
								(gEgo setScript: drinkDown)
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
				(localproc_4 1 1)
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
								(crusher setScript: crusherThrows)
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
						((Said 'talk,talk>')
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
								((Said '//drink,drink,cost')
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
							((Said '//fish,fish,trout,south,lake,river,water')
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
					((Said 'talk,talk/man,man,butcher,baker,player,gambler')
						(HighPrint 331 56) ; "These guys are so intent on their game that they don't want to open their mouths on any other subject."
					)
					((Said 'look,look/card,deck,player,butcher,baker')
						(HighPrint 331 57) ; "It looks like these guys aren't playing with a full deck."
					)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 30] temp30)
		(switch (= state newState)
			(0
				(= cycles (Random 20 40))
			)
			(1
				(HighPrint
					(Format @temp0 331 58 (= temp30 (Random 1 1000)) temp30) ; ""Got any %d's?"%"
				)
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

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (gEgo inRect: 0 125 140 170)))
			((!= (event type:) evSAID))
			((Said '[say]/blowfish')
				(if (and (not [gEgoStats 8]) (not [gEgoStats 9])) ; stealth, pick locks
					(HighPrint 331 60) ; "The bartender calls to Crusher: "Hey, he's not one of us! Take care of him!""
					(self setScript: crusherThrows)
				else
					(self setScript: crusherEscorts)
				)
			)
			((Said 'show,make/sign,sign[<thief]')
				(HighPrint 331 61) ; "Oh yeah? What's the password?"
			)
			((Said 'ask//thief,club')
				(HighPrint 331 62) ; "Uh oh! It looks like you got Crusher upset!"
				(self setScript: crusherThrows)
			)
			((Said '[say,give,use]/password')
				(HighPrint 331 63) ; "Oh yeah? So what is it?"
			)
			((Said '[say]/swordfish')
				(HighPrint 331 64) ; "Good idea, but you're in the wrong movie."
				(self setScript: crusherThrows)
			)
			((or (Said 'talk,talk/man,goon,bouncer') (Said 'ask//*'))
				(switch local6
					(0
						(HighPrint 331 65) ; "The goon seems to be ignoring you."
					)
					(1
						(HighPrint 331 66) ; "As you ask him questions, the goon's eyes darken."
					)
					(2
						(HighPrint 331 67) ; "Uh oh! It looks like you got Crusher upset!"
						(self setScript: crusherThrows)
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
					(bartender posn: (bartender x:) (- (bartender y:) 2))
				else
					(bartender posn: (bartender x:) (+ (bartender y:) 2))
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
				(bartender setCycle: Walk loop: 0 setMotion: MoveTo 195 80 self)
			)
			(2
				(bartender loop: (Random 2 3) stopUpd:)
				(= cycles (Random 50 100))
			)
			(3
				(bartender loop: 1 cel: -1 setMotion: MoveTo 124 80 self)
			)
			(4
				(bartender loop: (Random 2 3) stopUpd:)
				(= cycles (Random 50 100))
			)
			(5
				(self changeState: 1)
			)
			(6
				(= cycles 0)
				(HandsOff)
				(if (> (bartender distanceTo: gEgo) 15)
					(bartender
						loop: (if (< (gEgo x:) (bartender x:)) 1 else 0)
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
				(bartender loop: 2 stopUpd:)
				(if (IsFlag 254)
					(head setCel: 2)
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
				(User canInput: 0)
				(if (== (gEgo loop:) 3)
					(gEgo loop: 2 cel: 0 stopUpd:)
					(head show:)
				)
				(switch global336
					(2
						(bartender
							setLoop: (if (IsFlag 255) 1 else 6)
							setCycle: Walk
							setMotion: MoveTo 124 80 self
						)
					)
					(else
						(bartender
							setLoop: (if (IsFlag 255) 0 else 5)
							setCycle: Walk
							setMotion: MoveTo 195 80 self
						)
					)
				)
			)
			(10
				(ClearFlag 255)
				(bartender setLoop: 4 cel: 0 setPri: 5)
				(= local7 7)
			)
			(11
				(bartender cel: 1)
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
						(User canInput: 1)
						(dB setScript: breathScript)
					)
				)
			)
			(13
				(bartender
					posn: (if (== global336 2) 124 else 195) 80
					setLoop: (if (== global336 2) 6 else 5)
					cel: 0
				)
				(= cycles 2)
			)
			(14
				(bartender setLoop: 3)
				(= cycles 20)
			)
			(15
				(bartender
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
				(bartender setLoop: (if (== global336 2) 0 else 1) cel: 0)
				(HighPrint 331 72) ; "There ya go!"
				(User canInput: 1)
				(if (< global336 3)
					(switch global336
						(1
							(localproc_1 local9)
						)
						(2
							(localproc_1 local10)
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
					(head hide:)
				)
				(bartender setLoop: -1 setMotion: MoveTo 180 80 self)
			)
			(18
				(bartender loop: 2 stopUpd:)
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

(instance dB of Prop
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

(instance breathScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender setLoop: 6 setMotion: MoveTo 171 78 self)
			)
			(1
				(bartender
					view: 337
					setLoop: 0
					cel: 0
					posn: 169 78
					setCycle: CT 5 1 self
				)
			)
			(2
				(smoke hide:)
				(barSound number: (SoundFX 44) play:)
				(dB loop: 2 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(dB setCycle: CT 9 1)
				(bartender setCycle: End self)
			)
			(4
				(dB setCycle: End self)
			)
			(5
				(dB loop: 3 cel: 0 posn: 159 47)
				(self cue:)
			)
			(6
				(barSound number: (SoundFX 43) play:)
				(dB
					posn: (dB x:) (- (dB y:) 3)
					setCycle: CT (+ (dB cel:) 1) 1 self
				)
			)
			(7
				(if (!= (dB cel:) 12)
					(self changeState: 6)
				else
					(self cue:)
				)
			)
			(8
				(dB posn: 159 68 stopUpd:)
				(smoke show:)
				(bartender cel: 2 setCycle: Beg self)
			)
			(9
				(bartender view: 336 setLoop: 1 cel: 0 stopUpd:)
				(if (IsFlag 254)
					(gEgo loop: 3 cel: 0)
					(head hide:)
				)
				(= global336 0)
				(= global337 3)
				(HighPrint 331 72 83) ; "There ya go!"
				(self dispose:)
			)
		)
	)
)

(instance drinkDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: End)
				(= cycles 10)
			)
			(1
				(switch global337
					(1
						(switch global338
							(1
								(HighPrint 331 87) ; "This tastes as sour as it smells, and it burns your throat as you swallow it. Still, it isn't the worst beer you've ever drunk."
								(= cycles 5)
							)
							(2
								(HighPrint 331 88) ; "You know, that actually tasted fine! This really isn't such a bad place, after all, and the bartender reminds you of an old friend you used to know."
								(= cycles 5)
							)
							(3
								(HighPrint 331 89) ; "Suddenly, you don't feel so good..."
								(client setScript: tooDrunk)
							)
						)
					)
					(2
						(HighPrint 331 90) ; "Smells like Troll's Sweat. Tastes like Troll's Sweat. By golly, it IS Troll's Sweat...."
						(client setScript: tooDrunk)
					)
					(3
						(HighPrint 331 91) ; "You've never tasted anything like it before."
						(client setScript: breathDeath)
					)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= global337 0)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance tooDrunk of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg)
				(= cycles 15)
			)
			(1
				(gEgo loop: 6 cel: 0)
				(deadMug init:)
				(gAddToPics add: deadMug doit:)
				(= cycles 2)
			)
			(2
				(switch global337
					(1
						(HighPrint 331 92) ; "Too much beer."
					)
					(2
						(HighPrint 331 93) ; "...and one Troll's Sweat is too many."
					)
				)
				(= cycles 2)
			)
			(3
				(gEgo cycleSpeed: 2 setCycle: CT 6 1)
				(= cycles 25)
			)
			(4
				(gEgo cycleSpeed: 0 setCycle: End)
				(= cycles 20)
			)
			(5
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(6
				(SolvePuzzle 605 -5)
				(SetFlag 118)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance breathDeath of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 331 94) ; "Ohhhhhhhhh woooowwwwwww!!!"
				(gEgo loop: 5 cel: 0 cycleSpeed: 2 setCycle: CT 12 1 self)
			)
			(1
				(dust init:)
				(gAddToPics add: dust doit:)
				(gEgo setCycle: End self)
			)
			(2
				(EgoDead ; "Maybe you really shouldn't have tried the Dragon's Breath! Better luck next time, and we hope you saved your game."
					331
					95
					80
					{ Talk about a "fiery brew". %j\bc\de\c2\c6 \cb\a6\ca\b8\d6\b3\c5 \bb\b9\c0\de\c8}
					82
					331
					0
					0
				)
			)
		)
	)
)

(instance deadMug of PV
	(properties
		y 80
		x 165
		view 331
		cel 2
		priority 12
	)
)

(instance dust of PV
	(properties
		y 89
		x 149
		view 504
		loop 2
		cel 4
		priority 15
	)
)

(instance chair of Prop
	(properties
		y 149
		x 75
		view 338
		loop 2
	)
)

(instance crusherThrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: setCycle: End)
				(crusher
					ignoreActors:
					loop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(crusher cel: 2)
				(= cycles 3)
			)
			(3
				(crusher setCycle: End self)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 15)
				(SetFlag 117)
				(AdvanceTime 3)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance crusherEscorts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 self)
			)
			(1
				(gEgo setCycle: Walk)
				(chair init: ignoreActors: cycleSpeed: 1 setCycle: End self)
				(crusher
					ignoreActors:
					setLoop: 1
					setCel: 0
					setCycle: 0
					posn: 98 152
					stopUpd:
				)
			)
			(2
				(trap cycleSpeed: 2 setCycle: End self)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 15)
				(gCurRoom newRoom: 332)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 254)
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (> (gEgo x:) 149)
					(gEgo setMotion: MoveTo 163 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 134 (gEgo y:) self)
				)
			)
			(1
				(if (> (gEgo x:) 149)
					(gEgo setMotion: MoveTo 163 114 self)
				else
					(gEgo setMotion: MoveTo 134 114 self)
				)
			)
			(2
				(gEgo
					view: 504
					loop: (if (> (gEgo x:) 149) 1 else 0)
					posn: 149 111
					setPri: 9
				)
				(self cue:)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo loop: 2 cel: 0 stopUpd:)
				(head show: setPri: 8)
				(HandsOn)
				(User canControl: 0)
				(bartenderScript changeState: 6)
				(self dispose:)
			)
		)
	)
)

(instance getDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(head hide:)
				(gEgo loop: 1 cel: 7 setCycle: Beg self)
			)
			(1
				(NormalEgo)
				(gEgo
					loop: 2
					cel: 5
					illegalBits: -32768
					setCycle: Walk
					posn: 162 114
				)
				(ClearFlag 254)
				(bartenderScript changeState: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

