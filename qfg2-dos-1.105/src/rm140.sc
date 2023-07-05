;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use TargActor)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm140 0
	emblem 1
	swordGotten 2
	door 3
)

(local
	tooClose
	magicOpen
	oneSpell
	stupidQ
	niteTime
	anvilDelta
	betMade
	daggets
	daggoids
	anvilTries
	[str 100]
	[pts1 8] = [83 151 112 131 150 139 119 158]
	[pts2 8] = [70 141 96 123 139 132 99 154]
	[pts3 10] = [70 143 99 121 138 144 114 159 77 153]
)

(procedure (MoveAnvil &tmp anvilStrength)
	(if (< (++ anvilTries) 5)
		(= anvilStrength (if (IsFlag 164) 60 else 120))
		(gEgo setScript: moveAnvil 0 (TrySkill 0 anvilStrength)) ; strength
	else
		(gEgo setScript: (ScriptID 141 0) 0 1) ; busted
	)
)

(procedure (MoveTrap)
	(if (== (trapDoor cel:) 1)
		(chest hide:)
		(trapDoor setCel: 0 setPri: 1)
		(RedrawCast)
		(if ((gCurRoom obstacles:) contains: poly3)
			((gCurRoom obstacles:) delete: poly3)
		)
		(gCurRoom addObstacle: poly2)
		(HighPrint 140 0) ; "You close the trap door."
	else
		(trapDoor setCel: 1 setPri: 11)
		(chest show:)
		(RedrawCast)
		(HighPrint 140 1) ; "You open the trap door to reveal a hole in the floor. You can see Issur's strongbox inside the hole."
		(gCurRoom addObstacle: poly3)
	)
)

(procedure (BuyFromIssur invItem costCentimes qty canBuyMoreThanOnce canBuyMany &tmp rc)
	(= rc 0)
	(switch (Buy invItem costCentimes qty canBuyMoreThanOnce canBuyMany)
		(0
			(Say (ScriptID 141 5) 140 2) ; "Hey! You don't have the money for this. What do you think this is, a charity? Get some money or get lost!", Issur
		)
		(1
			(Say (ScriptID 141 5) 140 3) ; "Wait a minute! What do you think I am, a money changer? Your money is no good. You need to get this changed to dinars and centimes before you can buy anything.", Issur
		)
		(2
			(= rc 1)
		)
	)
	(return rc)
)

(instance shopWindow of TopWindow ; UNUSED
	(properties)
)

(instance rm140 of Rm
	(properties
		picture 140
		style 7
	)

	(method (init &tmp evt I)
		(LoadMany rsVIEW 140 301 47 145 141 272)
		(Load rsPIC 2)
		(LoadMany rsSCRIPT 141 972 951 969)
		(super init:)
		(if (== gPrevRoomNum 150)
			(while ((= evt (Event new:)) type:)
				(evt dispose:)
			)
			(evt dispose:)
		)
		(NormalEgo)
		(= niteTime gNight)
		(chest init: hide:)
		(trapDoor init:)
		(door init:)
		(anvil init:)
		(if (not (gEgo has: 25)) ; Bellows
			(emblem setPri: 15 init:)
		)
		(InitFeatures opening firepit swordOne swordTwo)
		(InitAddToPics
			(ScriptID 141 8) ; pendant
			(ScriptID 141 9) ; gShield
			(ScriptID 141 10) ; shrine
			(ScriptID 141 11) ; rShield
			(ScriptID 141 12) ; rack
			(ScriptID 141 13) ; lMace
			(ScriptID 141 14) ; dblAxe
			(ScriptID 141 15) ; lAxe
			(ScriptID 141 16) ; rSword
			(ScriptID 141 17) ; cleaver
			(ScriptID 141 18) ; rMace
			(ScriptID 141 19) ; saber
			(ScriptID 141 20) ; lSword
			(ScriptID 141 21) ; mail
			(ScriptID 141 22) ; plaque
		)
		(= global76 1)
		(poly1 points: @pts1 size: 4)
		(self addObstacle: poly1)
		(ClearFlag 115)
		(cond
			((== gPrevRoomNum 150)
				(= global61 0)
				(= gSpellChecker dayChecker)
				(fire init: setCycle: Fwd)
				(gEgo loop: 7 init: posn: 126 155)
				((ScriptID 141 5) posn: 90 143 init:) ; Issur
				(if (IsFlag 23)
					(SolvePuzzle 658 7 0)
				)
				(cond
					((and (IsFlag 38) (IsFlag 23))
						(gEgo get: 2 (* gWrestlingBet 2)) ; Dinar
						(ClearFlag 38)
						(gEgo setScript: bellowsScored)
					)
					((and (IsFlag 38) (not (IsFlag 23)))
						(Say (ScriptID 141 5) 140 4) ; "Ha! Easiest 10 dinars I ever made. Let me know if you want to try again.", Issur
						(ClearFlag 38)
						(if (== 0 (mod gEnter140 3))
							((ScriptID 141 5) setScript: (ScriptID 141 3)) ; Issur, IssurFlex
						)
					)
					((and (IsFlag 21) (IsFlag 23))
						(gEgo get: 2 (* gWrestlingBet 3)) ; Dinar
						(ClearFlag 38)
						(gEgo setScript: bellowsScored)
					)
					((and (IsFlag 21) (not (IsFlag 23)))
						(Say (ScriptID 141 5) 140 5) ; "Ha! Easiest way I know of to get 20 dinars. Let me know if you want to try again.", Issur
						(ClearFlag 38)
						(if (== 0 (mod gEnter140 3))
							((ScriptID 141 5) setScript: (ScriptID 141 3)) ; Issur, IssurFlex
						)
					)
					((IsFlag 23)
						(Say (ScriptID 141 5) 140 6) ; "Aw right. Anyone can get lucky. Here's your dough.", Issur
						(gEgo get: 2 (* 2 gWrestlingBet)) ; Dinar
					)
					(else
						(Say (ScriptID 141 5) 140 7) ; "Thanks, pal. Easy money.", Issur
						(++ gWrestlingBet)
					)
				)
			)
			((not niteTime)
				(= gSpellChecker dayChecker)
				(fire init: setCycle: Fwd)
				(gEgo loop: 1 init: posn: 278 146)
				((ScriptID 141 5) init:) ; Issur
				(self setScript: (ScriptID 141 6)) ; enterScript
			)
			(niteTime
				(SetFlag 115)
				(poly2 points: @pts2 size: 4)
				(poly3 points: @pts3 size: 5)
				(= gSpellChecker gAllChecker)
				(gEgo loop: 1 init: posn: 278 146)
				(SolvePuzzle 698 3 2)
				(gEgo setScript: (ScriptID 141 2)) ; sneakIn
			)
		)
		(gCSound
			number: (if (and niteTime (not (== gPrevRoomNum 150))) 260 else 140)
			loop: -1
			playBed:
		)
		(SetFlag 128)
	)

	(method (dispose)
		(++ gEnter140)
		(DisposeScript 141)
		(gCSound fade:)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(super dispose:)
	)

	(method (doit)
		(if (and niteTime (not gNight))
			(if (gTimers contains: (ScriptID 141 7)) ; bustTimer
				((ScriptID 141 7) dispose:) ; bustTimer
			)
			(gEgo setScript: (ScriptID 141 0) 0 1) ; busted
		)
		(if (& (gEgo onControl: 1) $0002)
			(if (IsFlag 114)
				(SetFlag 26)
			)
			(if (and niteTime (gTimers contains: (ScriptID 141 7))) ; bustTimer
				((ScriptID 141 7) dispose:) ; bustTimer
			)
			(= gRoomExitDir 3)
			(if (gCast contains: (ScriptID 141 5)) ; Issur
				((ScriptID 141 5) dispose:) ; Issur
			)
			(gCurRoom newRoom: 330) ; rmSPlazaFightersE
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/shop')
				)
				(HighPrint 140 8) ; "There are swords, shields and many other weapons on the wall. This shop seems well equipped to do business."
			)
			((and niteTime (Said 'throw/dagger,boulder'))
				(HighPrint 140 9) ; "There's no need to throw things around an empty shop."
			)
			((Said 'buy,barter/blade')
				(cond
					((not (gCast contains: (ScriptID 141 5))) ; Issur
						(HighPrint 140 10) ; "Wasn't the purpose of breaking in to steal something?"
					)
					((not (or (gEgo has: 4) (gEgo has: 24))) ; Sword, FineSword
						(HighPrint 140 11) ; "A pointless thought, since you do not have a sword to trade nor do you have the skill to use one."
					)
					((gEgo has: 24) ; FineSword
						(Say (ScriptID 141 5) 140 12) ; "A finer sword cannot be had than the one you've already purchased.", Issur
					)
					(else
						(self setScript: swordGotten 0 1)
					)
				)
			)
			((or (Said 'bargain//blade') (Said 'bargain[<for]/blade'))
				(cond
					((not (gCast contains: (ScriptID 141 5))) ; Issur
						(HighPrint 140 10) ; "Wasn't the purpose of breaking in to steal something?"
					)
					((not (or (gEgo has: 4) (gEgo has: 24))) ; Sword, FineSword
						(HighPrint 140 11) ; "A pointless thought, since you do not have a sword to trade nor do you have the skill to use one."
					)
					((gEgo has: 24) ; FineSword
						(Say (ScriptID 141 5) 140 12) ; "A finer sword cannot be had than the one you've already purchased.", Issur
					)
					((TrySkill 13 80) ; communication
						(self setScript: swordGotten 0 2)
					)
					(else
						(self setScript: swordGotten 0 3)
					)
				)
			)
			((or (Said 'bargain//dagger') (Said 'bargain[<for]/dagger'))
				(if (gCast contains: (ScriptID 141 5)) ; Issur
					(HighPrint 140 13) ; "Issur is not willing to change his price on his daggers."
				else
					(HighPrint 140 10) ; "Wasn't the purpose of breaking in to steal something?"
				)
			)
			((or (Said 'bargain//bellows') (Said 'bargain[<for]/bellows'))
				(cond
					((not (gCast contains: (ScriptID 141 5))) ; Issur
						(HighPrint 140 10) ; "Wasn't the purpose of breaking in to steal something?"
					)
					((gEgo has: 25) ; Bellows
						(Say (ScriptID 141 5) 140 14) ; "You have the bellows. What more do you want?", Issur
					)
					((not (IsFlag 21))
						(Say (ScriptID 141 5) 140 15) ; "You must need my bellows badly.", Issur
					)
					((TrySkill 13 80) ; communication
						(if (IsFlag 165)
							(Say (ScriptID 141 5) 140 16) ; "Well, since you put it that way, I guess you do need the bellows. I'll get it for you.", Issur
							(ClearFlag 21)
							(ClearFlag 38)
							(gEgo setScript: bellowsScored)
						else
							(Say (ScriptID 141 5) 140 17) ; "OK, OK. Since you are such a wimp, you only have to pay me 10 dinars if you lose at arm wrestling.", Issur
							(= betMade 1)
							(= gWrestlingBet 10)
							(SetFlag 38)
						)
					)
					(else
						(Say (ScriptID 141 5) 140 18) ; "Take it or leave it.", Issur
					)
				)
			)
			(
				(or
					(Said
						'tell[/issur,man,armorer,keeper,clerk]/elemental[<air]'
					)
					(Said 'tell[/issur,man,armorer,keeper,clerk]/bellows')
					(Said 'tell[<of]/bellows')
				)
				(cond
					((not (gCast contains: (ScriptID 141 5))) ; Issur
						(HighPrint 140 10) ; "Wasn't the purpose of breaking in to steal something?"
					)
					((gEgo has: 25) ; Bellows
						(Say (ScriptID 141 5) 140 19) ; "You told me the story already, and besides, you have the bellows. What else do you want?", Issur
					)
					((IsFlag 21)
						(Say (ScriptID 141 5) 140 20) ; "You have told me that story already!", Issur
					)
					((not (IsFlag 23))
						(if (TrySkill 13 50) ; communication
							(Say (ScriptID 141 5) 140 21) ; "Do tell. Well, if you want to use my bellows, then you've got to prove your worth. You'll have to defeat me at Arm Wrestling. You win, you get the bellows. You lose, I get 20 dinars.", Issur
							(= betMade 1)
							(= gWrestlingBet 20)
							(SetFlag 21)
						else
							(Say (ScriptID 141 5) 140 22) ; "That's a nice speech impediment you have there, but I don't know what you're saying.", Issur
						)
					)
				)
			)
			((Said 'tell')
				(Say (ScriptID 141 5) 140 23) ; "Big deal.", Issur
			)
			(
				(or
					(Said 'play[/wrestle[<arm,wrist]]')
					(Said '/wrestle[<arm,wrist]')
					(Said 'wrestle[<arm,wrist]')
					(Said 'defeat[/issur,man,keeper,clerk,armorer]')
					(Said 'put<down/alm,dinar')
					(Said 'bet,gamble')
					(Said 'make,place/bet')
					(Said 'try<again')
				)
				(cond
					((not (gCast contains: (ScriptID 141 5))) ; Issur
						(HighPrint 140 24) ; "There's no one to wrestle with. Wasn't the purpose of breaking in to steal something?"
					)
					((IsFlag 23)
						(Say (ScriptID 141 5) 140 25) ; "Go away. I've got better things to do than waste my time on you.", Issur
					)
					((not betMade)
						(cond
							((and (not (gCast contains: emblem)) (IsFlag 21))
								(Say (ScriptID 141 5) 140 26) ; "It will cost you another 20 dinar to wrestle me for the bellows.", Issur
								(= gWrestlingBet 20)
							)
							((IsFlag 24)
								(Say
									(ScriptID 141 5) ; Issur
									(Format @str 140 27 gWrestlingBet) ; "It'll cost you more to bet me this time. You'll have to put down %d Dinars."
								)
							)
							(else
								(Say (ScriptID 141 5) 140 28) ; "You want to wrestle, eh? Just to make it worth my while to put you in your place, why don't we make a little wager, say, 1 dinar? Put down your money and we'll play.", Issur
								(= gWrestlingBet 1)
							)
						)
						(= betMade 1)
					)
					(else
						(gEgo setScript: checkMoneyAndGo)
					)
				)
			)
			((and (Said 'hello') (gCast contains: (ScriptID 141 5))) ; Issur
				(Say (ScriptID 141 5) 140 29) ; "Yeah, whaddya want?", Issur
			)
			((Said 'make,give,show/sign[<thief]')
				(MakeSign)
				(if (gCast contains: (ScriptID 141 5)) ; Issur
					(gEgo setScript: (ScriptID 141 4)) ; thrownOut
				)
			)
			((Said 'grab,get/chest,box,strongbox,safe')
				(if (== (trapDoor cel:) 1)
					(HighPrint 140 30) ; "The strongbox is much too heavy to move."
				else
					(HighPrint 140 31) ; "You see no strongBox here."
				)
			)
			((Said 'grab')
				(HighPrint 140 32) ; "Issur's weapons and armor are very distinctive. You would not be able to use or sell them without being caught."
			)
		)
	)
)

(instance openChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (+ (chest x:) 34) (chest y:) self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 47 loop: 1 cel: 0 setCycle: End)
				(= cycles 10)
			)
			(3
				(cond
					(magicOpen
						(= magicOpen 0)
						(if (IsFlag 26)
							(HighPrint 140 33) ; "Unfortunately, it appears that someone has already stolen all of its contents. Now who would have done such a thing?"
						else
							(SolvePuzzle 699 3 2)
							(HighPrint 140 34) ; "You find 100 dinars and 500 centimes, which you happily put away."
							(SetFlag 26)
							(gEgo get: 2 100) ; Dinar
							(gEgo get: 1 500) ; Centime
						)
						(self changeState: 6)
					)
					((== (chest cel:) 2)
						(chest setCel: 1)
						(RedrawCast)
						(HighPrint 140 35) ; "You close and lock the strongbox."
						(self changeState: 6)
					)
					(register
						(gMiscSound number: 20 loop: 1 priority: 12 play: self)
					)
					(else
						(= seconds 3)
					)
				)
			)
			(4
				(chest setCel: 2)
				(= cycles 2)
			)
			(5
				(HighPrint 140 36) ; "You got it! The chest is now open."
				(if (IsFlag 26)
					(HighPrint 140 33) ; "Unfortunately, it appears that someone has already stolen all of its contents. Now who would have done such a thing?"
				else
					(SolvePuzzle 699 3 2)
					(HighPrint 140 34) ; "You find 100 dinars and 500 centimes, which you happily put away."
					(SetFlag 26)
					(gEgo get: 2 100) ; Dinar
					(gEgo get: 1 500) ; Centime
				)
				(self cue:)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(HandsOn)
				(NormalEgo)
				(gEgo setHeading: 315)
				(self dispose:)
			)
		)
	)
)

(instance openTrap of Script
	(properties)

	(method (changeState newState &tmp success)
		(switch (= state newState)
			(0
				(cond
					((not (IsFlag 114))
						(HighPrint 140 37) ; "You'll have to get the anvil out of the way first."
						(self dispose:)
					)
					((trapDoor onMe: gEgo)
						(HighPrint 140 38) ; "There's something heavy preventing the trap door from opening..."
						(HighPrint 140 39) ; "Oh, it's you! Stand somewhere else."
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(+ (trapDoor x:) 42)
								(+ (trapDoor y:) 4)
								self
						)
					)
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(if ((gCurRoom obstacles:) contains: poly2)
					((gCurRoom obstacles:) delete: poly2)
				)
				(gEgo view: 47 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(MoveTrap)
				(= cycles 3)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(gEgo setHeading: 315)
				(self dispose:)
			)
		)
	)
)

(instance moveAnvil of Script
	(properties)

	(method (dispose)
		(NormalEgo)
		(super dispose:)
	)

	(method (changeState newState &tmp xChange yChange)
		(= xChange (+ anvilDelta anvilDelta))
		(= yChange anvilDelta)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (anvil x:) 28) (+ (anvil y:) 9) self
				)
				(= anvilDelta (if (IsFlag 114) 1 else -1))
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(if ((gCurRoom obstacles:) contains: poly1)
					((gCurRoom obstacles:) delete: poly1)
				)
				(if ((gCurRoom obstacles:) contains: poly2)
					((gCurRoom obstacles:) delete: poly2)
				)
				(gEgo view: 47 setLoop: 5 setCel: 2)
				(= cycles 3)
			)
			(3
				(if register
					(= register 3)
					(= cycles 5)
				else
					(HighPrint 140 40) ; "The anvil is so heavy you can't even budge it. Better work on those muscle-building exercises."
					(gEgo
						setMotion: PolyPath (+ (gEgo x:) 15) (gEgo y:)
					)
					(HandsOn)
					(gCurRoom addObstacle: poly1)
					(self dispose:)
				)
			)
			(4
				(anvil posn: (+ (anvil x:) xChange) (+ (anvil y:) yChange))
				(gEgo setCel: 3)
				(if (IsFlag 114)
					(gEgo
						posn: (+ (gEgo x:) xChange) (+ (gEgo y:) yChange)
					)
					(= cycles 1)
				else
					(= cycles 5)
				)
			)
			(5
				(gEgo setCel: 2)
				(if (IsFlag 114)
					(= cycles 5)
				else
					(gEgo
						posn: (+ (gEgo x:) xChange) (+ (gEgo y:) yChange)
					)
					(= cycles 1)
				)
			)
			(6
				(cond
					((-- register)
						(*= anvilDelta 2)
						(self changeState: 4)
					)
					((IsFlag 114)
						(ClearFlag 114)
						(gCurRoom addObstacle: poly1)
						(HighPrint 140 41) ; "You've returned the anvil to its original position to hide your illicit activity."
						(HandsOn)
						(self dispose:)
					)
					(else
						(SetFlag 114)
						(gCurRoom addObstacle: poly2)
						(HighPrint 140 42) ; "You move the anvil aside. Now you can get to the trapdoor."
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance bellowsScored of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 165)
					(= seconds 3)
				else
					(Say (ScriptID 141 5) self 140 43) ; "All right, you can have the stupid bellows. See if I care.", Issur
				)
			)
			(1
				(SolvePuzzle 609 7)
				(HighPrint 140 44) ; "He gets the bellows down for you and throws them at you."
				(= betMade 0)
				(emblem dispose:)
				(SetFlag 85)
				(gEgo get: 25) ; Bellows
				(self dispose:)
			)
		)
	)
)

(instance swordGotten of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(if (BuyFromIssur 24 10000 0 0)
							(gEgo use: 4) ; Sword
							(+= gSwordBonus 10)
							(SkillUsed 15 25) ; experience
						)
					)
					(2
						(if (BuyFromIssur 24 8000 0 0)
							(gEgo use: 4) ; Sword
							(+= gSwordBonus 10)
							(SkillUsed 15 25) ; experience
						)
					)
					(3
						(if (BuyFromIssur 24 10000 0 0)
							(gEgo use: 4) ; Sword
							(+= gSwordBonus 10)
							(SkillUsed 15 25) ; experience
						)
					)
					(4
						(if (BuyFromIssur 5 500 0 1 1)
							(= daggets [gInvNum 5]) ; Dagger
						)
					)
				)
				(self cue:)
			)
			(1
				(switch register
					(1
						(if (gEgo has: 24) ; FineSword
							(HighPrint 140 45) ; "Having traded in your old sword and paid 100 dinars, you now have one of Issur's swords. For all his bragging, he does make a fine weapon."
						)
					)
					(2
						(if (gEgo has: 24) ; FineSword
							(HighPrint 140 46) ; "With your skill in fast talking, you manage to bargain him down to 80 dinars. Having traded in your old sword and paid the money, you now have one of Issur's swords. For all his bragging, he does make a fine weapon."
						)
					)
					(3
						(if (gEgo has: 24) ; FineSword
							(HighPrint 140 47) ; "He seemed thoroughly unimpressed by your bargaining skill. Having traded in your old sword and paid 100 dinars, you now have one of Issur's swords. For all his bragging, he does make a fine weapon."
						)
					)
					(4
						(if (> daggets daggoids)
							(HighPrint 140 48) ; "Issur seems to make a well-balanced dagger, even if he does make you pay for the quality."
							(= daggoids [gInvNum 5]) ; Dagger
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance yourWorthy of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say (ScriptID 141 5) self 140 49) ; "You have shown yourself worthy by defeating me at arm wrestling. Let me get them for you.", Issur
			)
			(1
				(SolvePuzzle 609 7)
				(HighPrint 140 50) ; "He gets the bellows down for you and tosses them to you."
				(emblem dispose:)
				(SetFlag 85)
				(gEgo get: 25) ; Bellows
				(self dispose:)
			)
		)
	)
)

(instance checkMoneyAndGo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (CheckFunds (* gWrestlingBet 100))
					(0
						(Say (ScriptID 141 5) 140 51) ; "You need to have the money before you go wagering!", Issur
						(self dispose:)
					)
					(1
						(Say (ScriptID 141 5) 140 52) ; "I don't have any use for foreign coin, go see the money changer.", Issur
						(self dispose:)
					)
					(else
						(GiveMoney (* gWrestlingBet 100))
						(= cycles 2)
					)
				)
			)
			(1
				(SetFlag 24)
				(gCurRoom newRoom: 150)
				(self dispose:)
			)
		)
	)
)

(instance theDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 242 136 self)
			)
			(1
				(if (== (door cel:) 2)
					(door setCycle: Beg self)
				else
					(door setCycle: End self)
				)
			)
			(2
				(gEgo setMotion: MoveTo 212 133 self)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance aWin of SysWindow ; UNUSED
	(properties
		back 11
	)
)

(instance fire of Prop
	(properties
		x 50
		y 79
		noun '/fire'
		description {the intensely hot fire}
		lookStr {The fiercely flickering fire needs another faggot of firewood.}
		view 145
		loop 5
	)
)

(instance door of TargActor
	(properties
		x 285
		y 138
		noun '/door'
		description 'the&door&in&the&courtyard'
		lookStr {It is the only door to the shop.}
		view 140
		loop 6
		illegalBits 0
	)

	(method (openMe)
		(if (== (door cel:) 0)
			(HighPrint 140 53) ; "Silly you, the door is already open."
		else
			(door setCycle: Beg)
		)
		(return 1)
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doit)
		(if (and (== (door cel:) 2) (< (gEgo distanceTo: door) 40))
			(gEgo setMotion: 0 posn: (- (gEgo x:) 6) (- (gEgo y:) 6))
			(HighPrint 140 54) ; "Open the door if you want out."
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((gCast contains: (ScriptID 141 5)) ; Issur
						(Say (ScriptID 141 5) 140 55) ; "Leave the door alone!", Issur
					)
					((== (door cel:) 0)
						(HighPrint 140 56) ; "It's open already."
					)
					(else
						(self setScript: theDoor)
					)
				)
			)
			(3
				(cond
					((gCast contains: (ScriptID 141 5)) ; Issur
						(Say (ScriptID 141 5) 140 55) ; "Leave the door alone!", Issur
					)
					((== (door cel:) 2)
						(HighPrint 140 57) ; "It's closed already."
					)
					(else
						(self setScript: theDoor)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of TargActor
	(properties
		x 92
		y 150
		noun '/chasm,chest,box,strongbox,safe'
		description {the wooden strongbox}
		view 140
		loop 3
		cel 1
		signal 16400
		illegalBits 0
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'search,look/chasm,chest,box,strongbox,safe')
				(HighPrint 140 58) ; "Issur's strongbox is in this hole in the floor."
			)
			((Said 'unlock,lockpick/lock,chest,box,strongbox,safe')
				(cond
					((== (chest cel:) 2)
						(HighPrint 140 59) ; "Not much point in that! The chest is already open."
					)
					((not (self passedChecks: 2)))
					((not (CanPickLocks))
						(HighPrint 140 60) ; "You don't have the skill or the tools."
					)
					((TrySkill 9 75 gLockPickBonus) ; pick locks
						(self setScript: openChest 0 1)
					)
					(else
						(HighPrint 140 61) ; "The lock is too tricky for you. You'll have to keep practicing."
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 140 58) ; "Issur's strongbox is in this hole in the floor."
			)
			(7
				(if (not niteTime)
					(HighPrint 140 62) ; "Not in the middle of the day!"
				else
					(HighPrint 140 30) ; "The strongbox is much too heavy to move."
				)
			)
			(5
				(HighPrint 140 30) ; "The strongbox is much too heavy to move."
			)
			(2
				(if (== (chest cel:) 2)
					(HighPrint 140 63) ; "The strongbox is already open."
				else
					(HighPrint 140 64) ; "You can't open the strongbox. It's locked."
				)
			)
			(3
				(if (== (chest cel:) 2)
					(self setScript: openChest 0 1)
				else
					(HighPrint 140 65) ; "The strongbox is already closed."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (openMe)
		(if (== (chest cel:) 2)
			(HighPrint 140 63) ; "The strongbox is already open."
		else
			(= magicOpen 1)
			(= oneSpell 1)
			(chest setCel: 2)
			(RedrawCast)
			(HighPrint 140 36) ; "You got it! The chest is now open."
		)
		(return 1)
	)

	(method (doit)
		(if (and oneSpell (not (gEgo script:)))
			(= oneSpell 0)
			(self setScript: openChest 0 1)
		)
		(super doit:)
	)
)

(instance trapDoor of TargActor
	(properties
		x 92
		y 150
		noun '/trap,(door<trap)'
		description {the trap door}
		view 140
		loop 5
		priority 1
		signal 16400
		illegalBits 0
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (Said 'lift/trap,(door<trap)')
			(self doVerb: 2)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (IsFlag 114)
					(HighPrint 140 66) ; "The small wooden trap door is now accessible."
				else
					(HighPrint 140 67) ; "You can just see the small wooden trap door underneath the anvil."
				)
			)
			(7
				(HighPrint 140 68) ; "The trap door is securely attached to the floor."
			)
			(2
				(if (== (trapDoor cel:) 1)
					(HighPrint 140 69) ; "The trap door is already open."
				else
					(gEgo setScript: openTrap)
				)
			)
			(3
				(if (== (trapDoor cel:) 1)
					(gEgo setScript: openTrap)
				else
					(HighPrint 140 70) ; "The trap door is already closed."
				)
			)
			(5
				(gEgo setScript: openTrap)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (openMe &tmp openStatus)
		(= openStatus 0)
		(cond
			((not niteTime)
				(HighPrint 140 71) ; "You don't think Issur would appreciate that."
			)
			((== (trapDoor cel:) 1)
				(HighPrint 140 72) ; "That's funny -- your Open spell doesn't seem to work on an already open door. Oh, yeah, that's right -- it isn't supposed to. You resolve to be more diligent about your studies in the future."
			)
			((not (IsFlag 114))
				(HighPrint 140 37) ; "You'll have to get the anvil out of the way first."
			)
			((self onMe: gEgo)
				(HighPrint 140 38) ; "There's something heavy preventing the trap door from opening..."
				(HighPrint 140 39) ; "Oh, it's you! Stand somewhere else."
			)
			(else
				(self setScript: setTrapPoly)
				(= openStatus 1)
			)
		)
		(return openStatus)
	)
)

(instance anvil of TargActor
	(properties
		x 93
		y 150
		noun '/anvil'
		description {the anvil}
		view 140
		loop 4
		priority 10
		signal 16400
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (handleEvent event &tmp anvilStrength)
		(cond
			(
				(or
					(Said 'grease/anvil,floor')
					(Said 'use,put,pour/grease[/anvil,floor]')
				)
				(cond
					((IsFlag 164)
						(HighPrint 140 73) ; "The anvil is oiled."
					)
					((not (gEgo has: 42)) ; Oil
						(HighPrint 140 74) ; "An interesting idea, but you don't have any oil."
					)
					((> (gEgo distanceTo: anvil) 80)
						(HighPrint 140 75) ; "Try going over to the anvil first."
					)
					(niteTime
						(HighPrint 140 76) ; "You spread some oil around the base of the anvil."
						(SetFlag 164)
					)
					(else
						(HighPrint 140 77) ; "You surreptitiously spread some oil around the base of the anvil, making sure Issur isn't watching."
						(SetFlag 164)
					)
				)
			)
			((Said 'replace,(put<back)/anvil')
				(= anvilStrength (if (IsFlag 164) 60 else 120))
				(cond
					((== (trapDoor cel:) 1)
						(HighPrint 140 78) ; "You can't move the anvil -- the trap door is in your way."
					)
					((IsFlag 114)
						(MoveAnvil)
					)
					(else
						(HighPrint 140 79) ; "The anvil is in its proper place."
					)
				)
			)
			((Said 'force,slide/anvil')
				(cond
					((not niteTime)
						(HighPrint 140 71) ; "You don't think Issur would appreciate that."
					)
					((== (trapDoor cel:) 1)
						(HighPrint 140 78) ; "You can't move the anvil -- the trap door is in your way."
					)
					(else
						(MoveAnvil)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 140 80) ; "Issur's heavy iron anvil doubles as a table for arm-wrestling."
			)
			(7
				(HighPrint 140 81) ; "You think it would take all your strength to even move the anvil. Taking it is out of the question."
			)
			(5
				(cond
					((not niteTime)
						(HighPrint 140 71) ; "You don't think Issur would appreciate that."
					)
					((== (trapDoor cel:) 1)
						(HighPrint 140 78) ; "You can't move the anvil -- the trap door is in your way."
					)
					(else
						(MoveAnvil)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (openMe)
		(HighPrint 140 82) ; "The anvil, not being a door, is unaffected by your spell."
		(return 0)
	)
)

(instance emblem of View
	(properties
		x 277
		y 52
		noun '/bellows'
		description {Saul's bellows}
		lookStr {It looks very much like Saul's Bellows.  It is the emblem of the iron worker's trade.}
		view 140
		loop 2
		cel 3
		priority 15
	)

	(method (init)
		(if (<= 0 gTimeODay 4)
			(= palette 1)
		else
			(= palette 2)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7)
			(cond
				((gEgo has: 25) ; Bellows
					(if (gCast contains: (ScriptID 141 5)) ; Issur
						(Say (ScriptID 141 5) 140 83) ; "You have the bellows. What else do you want?", Issur
					else
						(HighPrint 140 84) ; "You have the bellows."
					)
				)
				((IsFlag 23)
					(gEgo setScript: yourWorthy)
				)
				((not (gCast contains: (ScriptID 141 5))) ; Issur
					(HighPrint 140 85) ; "The bellows are not in here."
				)
				((not (IsFlag 22))
					(Say (ScriptID 141 5) 140 86) ; "Why would you need my bellows? What's the story, bub?", Issur
				)
				(else
					(Say (ScriptID 141 5) 140 87) ; "You'll have to wrestle me for them.", Issur
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance firepit of Feature
	(properties
		x 56
		y 76
		noun '/alcove,chimney,(place<fire)'
		nsTop 45
		nsLeft 27
		nsBottom 107
		nsRight 86
		description {the alcove with a fire in it}
		lookStr {The weaponer works up a sweat when he is heating his metals.}
	)
)

(instance opening of Feature
	(properties
		x 280
		y 110
		noun '/opening'
		nsTop 78
		nsLeft 259
		nsBottom 142
		nsRight 302
		description {the doorway into the plaza}
		lookStr {It's the only way out.}
	)
)

(instance swordOne of Feature
	(properties
		x 197
		y 74
		noun '/blade<little'
		nsTop 70
		nsLeft 173
		nsBottom 78
		nsRight 221
		description {the small sword on the rack}
		lookStr {The smaller sword on the rack looks to be of fine workmanship.}
	)
)

(instance swordTwo of Feature
	(properties
		x 192
		y 82
		noun '/blade<big'
		nsTop 79
		nsLeft 165
		nsBottom 86
		nsRight 220
		description {the large sword on the rack}
		lookStr {The larger sword on the rack looks to be made for one of the giants of the desert brigands.}
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance dayChecker of Code
	(properties)

	(method (doit spellNum)
		(if (== spellNum 24)
			(return 1)
		else
			(HighPrint 140 88) ; "You'd better not. Issur would get upset."
			(return 0)
		)
	)
)

(instance setTrapPoly of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((gCurRoom obstacles:) contains: poly2)
					((gCurRoom obstacles:) delete: poly2)
				)
				(trapDoor setCel: 1 setPri: 11)
				(chest show:)
				(RedrawCast)
				(HighPrint 140 1) ; "You open the trap door to reveal a hole in the floor. You can see Issur's strongbox inside the hole."
				(= cycles 1)
			)
			(1
				(gCurRoom addObstacle: poly3)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

