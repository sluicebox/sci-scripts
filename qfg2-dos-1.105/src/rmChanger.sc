;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Flame)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rmChanger 0
)

(local
	waitASec
	[fencePrices 3] = [1000 2000 1500]
	[curPrices 3] = [1000 2000 1500]
	[fenceItems 3] = [53 57 56]
	[fenceNames 3] = [{teapot} {bowl} {silver dagger}]
	lastShown = -1
	yesNoState
	exNum
	[askList 38] = [0 20 21 22 1 1 1 1 1 1 1 23 24 1 25 26 1 1 27 28 29 30 31 32 33 34 1 1 1 35 1 1 36 1 1 1 1 1]
	[dinAsks 42] = [2 '//relation,relationship,couple' 3 '//favor' 4 '//night,evening' 5 '//jackal,dog' 6 '//goat,sheep' 7 '//need' 8 '//change,barter,rate' 9 '//benefit,loot' 10 '//dinar' 11 '//cent,brass' 12 '//evaluate' 13 '//ferrari,guildmaster,(man<fat)' 14 '//date,sex' 15 '//kiss,love' 18 '//job,labor,errand' 19 '//guard,man,guard,servant,friend,franc' 37 '//grease' 38 '//implement,(implement<thief)' 39 '//safe,armorer,(shop<weapon),someone' 40 '//anvil,trap' 0 0]
	[longString 201]
	saidOnce
)

(procedure (beHappy theScript)
	(Say dinarzad theScript 125 (Random 41 43))
)

(procedure (showPrice whichItem)
	(if (== [curPrices whichItem] [fencePrices whichItem])
		(Format ; "The %s is worth %d Dinars. I will give you %d Dinars for it."
			@longString
			120
			57
			[fenceNames whichItem]
			(/ [fencePrices whichItem] 50)
			(/ (+ [curPrices whichItem] 50) 100)
		)
	else
		(Format ; "The %s is worth %d Dinars. I would normally give you %d Dinars for it, but I will pay you %d Dinars because I like you."
			@longString
			120
			58
			[fenceNames whichItem]
			(/ [fencePrices whichItem] 50)
			(/ [fencePrices whichItem] 100)
			(/ (+ [curPrices whichItem] 50) 100)
		)
	)
	(return @longString)
)

(class DelayedEvent of Event
	(properties
		client 0
	)

	(method (new whoCares optEvnt &tmp event)
		(= event (super new:))
		(if argc
			(event client: whoCares)
			(if (>= argc 2)
				(event
					type: (optEvnt type:)
					message: (optEvnt message:)
					modifiers: (optEvnt modifiers:)
					y: (optEvnt y:)
					x: (optEvnt x:)
					claimed: (optEvnt claimed:)
				)
			else
				(GetEvent 32767 event)
			)
		)
		(return event)
	)

	(method (cue)
		(if client
			(client handleEvent: self)
		)
		(self dispose:)
	)
)

(class GoToDlyEvt of DelayedEvent
	(properties)

	(method (new)
		(HandsOff)
		(super new: &rest)
	)

	(method (cue)
		(HandsOn)
		(Parse (User inputLineAddr:) self)
		(super cue: &rest)
		(Parse (User inputLineAddr:) (User curEvent:))
	)
)

(instance rmChanger of Rm
	(properties
		picture 120
		style 6
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(if (== global61 2)
			(= global61 1)
		)
		(DisposeScript 947)
		(= gRoomExitDir 2)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 120 125 355)
		(Load rsTEXT 125)
		(Load rsSCRIPT 947)
		(if (or (== gTimeODay 7) (== gTimeODay 0))
			(= gSpellChecker gAllChecker)
			(= global61 2)
		else
			(= gSpellChecker moneySpells)
		)
		(super init:)
		(NormalEgo)
		(sconce1
			cel: (if (or (== gTimeODay 7) (== gTimeODay 0)) 1 else 0)
			init:
		)
		(sconce2
			cel: (if (or (== gTimeODay 7) (== gTimeODay 0)) 1 else 0)
			init:
		)
		(if (or (== gTimeODay 7) (== gTimeODay 0))
			(shutter init:)
		else
			(dinarzad init:)
			(theGuard init:)
			(flame1 init: setCycle: Fwd)
			(flame2 init: setCycle: Fwd)
		)
		(grill init:)
		(gAddToPics doit:)
		(gMouseDownHandler add: self)
		(self setScript: comeIn)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((gEgo edgeHit:)
				(self newRoom: 704) ; alleyRoom
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look/alley,passage')
				(if (or (== gTimeODay 7) (== gTimeODay 0))
					(HighPrint 120 0) ; "The alley through which you entered looks even darker than the dark alcove in which you now find yourself."
				else
					(HighPrint 120 1) ; "The alley through which you entered looks ominously dark compared to this well-lit alcove."
				)
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard,area,culdesac,alcove')
				)
				(if (or (== gTimeODay 7) (== gTimeODay 0))
					(HighPrint 120 2) ; "This small alcove at the end of the alley has a small window with an iron grate above it. The two oil sconces used for illumination are doused and there is no one about."
				else
					(HighPrint 120 3) ; "This small alcove at the end of the alley has a small window with an iron grate above it. Two oil sconces illuminate the guard standing nearby and the woman behind the window."
					(if (not (IsFlag 9)) ; fMoneyOnce
						(HighPrint 120 4) ; "You have found the Money Changer."
					)
				)
			)
		)
	)
)

(instance dinarzad of Talker
	(properties
		x 179
		y 85
		description {the Money Changer}
		lookStr {The woman is very attractive with her dark, curly hair and lovely figure.  She smiles invitingly at you.}
		view 125
		signal 26624
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//dinarzad,woman,changer'
		title {Dinarzad:}
		color 1
		back 13
		msgFile 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(HighPrint 120 5) ; "She does look like a tasty morsel. "Maybe later," you think."
			)
			(9
				(self setScript: goToHer)
				(Say self 120 6) ; "Men! All talk and no action."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (showText what)
		(cond
			((== what 18)
				(cond
					((not (IsFlag 12)) ; fMoneyMission
						(= what 16)
					)
					((IsFlag 26) ; fWeaponRobbed
						(= what 17)
					)
					((IsFlag 13) ; fMoneyDone
						(= what 39)
					)
				)
			)
			((and (or (== what 39) (== what 40)) (not (IsFlag 39))) ; fMoneyRumor
				(= what 0)
			)
		)
		(super showText: what)
	)

	(method (atSpec which)
		(return [dinAsks which])
	)

	(method (atGen which)
		(return [askList which])
	)

	(method (handleEvent event &tmp theItem temp)
		(cond
			((and (>= lastShown 0) (or (Said 'ask/cost') (Said 'ask//cost')))
				(Say self (showPrice lastShown))
			)
			(
				(and
					(not
						(and
							(== (gEgo x:) 165)
							(== (gEgo y:) 113)
							(== (gEgo heading:) 45)
						)
					)
					(or
						(Said 'ask[/dinarzad]')
						(Said
							'barter,change,give,show,bargain,sell,fence,(hand[<above]),tell'
						)
					)
				)
				(= waitASec (GoToDlyEvt new: self event))
				(self setScript: goToHer waitASec)
			)
			((Said 'tell')
				(if (TrySkill 13 50) ; communication
					(Say dinarzad 120 7) ; "My, you certainly have a way with words. You might say you have a golden tongue."
				else
					(Say dinarzad 120 8) ; "That's all well and good, but I'd rather be conducting a little business, if there's any to be conducted."
				)
			)
			((Said 'ask//insertion')
				(Say self 120 9) ; "Sorry, my dear, but you'll need a bigger tool."
			)
			((super handleEvent: event))
			((Said 'look,look/hair,boob,ass,body,face,eye,lip,cheek')
				(HighPrint 120 10) ; "Nice."
			)
			((Said 'kiss/girl,woman,dinarzad,changer')
				(HighPrint 120 11) ; "She coyly evades your kiss."
			)
			((Said 'thank')
				(SayThanks self 120 12)
			)
			((or (Said 'give/bouquet') (Said 'give//bouquet'))
				(GiveFlowers self 120 13)
				(for ((= theItem 0)) (< theItem 3) ((++ theItem))
					(if
						(>
							(= temp (/ (* 11 [fencePrices theItem]) 10))
							[curPrices theItem]
						)
						(= [curPrices theItem] temp)
					)
				)
			)
			((Said 'kill,hit,attack,cut,grope,grab,grab,feel')
				(HighPrint 120 14) ; "You look at the dangerous-looking guard and think better of it."
			)
			((Said 'make,give,show/sign[<thief]')
				(cond
					((IsFlag 11) ; fMoneySign
						(MakeSign)
						(Say self 120 15) ; "Well, young Jackal, may fortune always favor you."
					)
					((MakeSign)
						(SolvePuzzle 694 3 2)
						(SetFlag 11) ; fMoneySign
						(= gMoneyDate (+ gDay 1))
						(Say self 120 16 120 17 120 18) ; "So you are a Jackal among the goats, then. I am very fond of those of the profession. This could be the start of a beautiful relationship."
					)
					((Random 0 1)
						(Say self 120 19) ; "That's a real cute sign, my little Hero, but these are business hours."
					)
					(else
						(Say self 120 20) ; "Is that a Thieves' sign, or are you just happy to see me?"
					)
				)
			)
			((Said 'barter,give,change,sell,(hand[<above])>')
				(cond
					((Said '/alm,alm,gold')
						(self setScript: changeLoot)
					)
					(
						(and
							(gEgo has: 53) ; Teapot
							(Said '/item,samovar,(pan,set,service<tea)')
						)
						(self setScript: sheBends self 0)
					)
					((and (gEgo has: 56) (Said '/dagger')) ; SilverDagger
						(self setScript: sheBends self 2)
					)
					((and (gEgo has: 57) (Said '/bowl')) ; Bowl
						(self setScript: sheBends self 1)
					)
					(else
						(event claimed: 1)
						(Say self 120 21) ; "Show me something worth exchanging."
					)
				)
			)
			((Said 'bargain>')
				(cond
					(
						(or
							(Said '/item,samovar,(pan,set,service<tea)')
							(Said '//item,samovar,(pan,set,service<tea)')
						)
						(= lastShown 0)
					)
					((or (Said '/dagger') (Said '//dagger'))
						(= lastShown 2)
					)
					((or (Said '/bowl') (Said '//bowl'))
						(= lastShown 1)
					)
				)
				(event claimed: 1)
				(cond
					((or (== lastShown -1) (not (gEgo has: [fenceItems lastShown])))
						(= lastShown -1)
						(Say self 120 22) ; "Show me something worth bargaining for."
					)
					((!= [fencePrices lastShown] [curPrices lastShown])
						(Say self 120 23 (showPrice lastShown)) ; "That's as far as I'll go, Hero."
					)
					((TrySkill 13 100) ; communication
						(= [curPrices lastShown] (/ (* 12 [fencePrices lastShown]) 10))
						(Say self 120 24 (showPrice lastShown)) ; "You drive a hard bargain. I can pay you an additional 20%, but no more."
					)
					(else
						(= [curPrices lastShown]
							(+ [fencePrices lastShown] (/ (* 5 [fencePrices lastShown]) 100))
						)
						(Say self 120 25 (showPrice lastShown)) ; "You're not very good at this, are you? But I'll give you an additional 5% more just because I happen to like dealing with you. You're such a card."
					)
				)
			)
			((Said 'show>')
				(cond
					(
						(and
							(gEgo has: 53) ; Teapot
							(Said '/item,samovar,(pan,set,service<tea)')
						)
						(= lastShown 0)
						(Say self (showPrice 0))
					)
					((and (gEgo has: 56) (Said '/dagger')) ; SilverDagger
						(= lastShown 2)
						(Say self (showPrice 2))
					)
					((and (gEgo has: 57) (Said '/bowl')) ; Bowl
						(= lastShown 1)
						(Say self (showPrice 1))
					)
					((Said '/alm,gold,dinar,cent,loot')
						(Say self 120 26) ; "That's nice of you to show me your money."
					)
					(else
						(event claimed: 1)
						(Say self 120 27) ; "Show me something more interesting."
					)
				)
			)
			((Said 'yes,yes')
				(switch yesNoState
					(0
						(HighPrint 120 28) ; "Dinarzad just smiles at you."
					)
					(3
						(beHappy)
					)
					(4
						(Say dinarzad 125 18) ; "At the noon of this night, you will take Sharki Darb to Rani Tarik. Then turn right into the unnamed alley. The first house on your right will be locked, but unbarred. You will find things of interest there, but know that there are those who sleep in the next room. Be wary, and if you are very good, we will both share your profits."
					)
					(5
						(if
							(or
								(gEgo has: 53) ; Teapot
								(gEgo has: 57) ; Bowl
								(gEgo has: 56) ; SilverDagger
							)
							(HighPrint 120 29) ; "You say, "Why yes, I have it right here." Dinarzad smiles and looks at you expectantly."
						else
							(HighPrint 120 30) ; "I'm sorry, but I never got the chance to get anything for you."
						)
					)
					(else
						(Say self 120 31) ; "Then hand me your money."
					)
				)
			)
			((Said 'no')
				(switch yesNoState
					(1
						(Say self 120 32) ; "What a pity. Perhaps another time, then."
					)
					(4
						(Say self 120 32) ; "What a pity. Perhaps another time, then."
					)
					(2
						(Say self 120 33) ; "Alas, my heart is broken."
					)
					(5
						(Say self 120 34) ; "I will give you a fair price for anything of value you can bring me."
					)
					(else
						(HighPrint 120 28) ; "Dinarzad just smiles at you."
					)
				)
			)
		)
		(if (== (event type:) evSAID)
			(= yesNoState 0)
		)
	)
)

(instance grill of Feature
	(properties
		x 184
		y 41
		noun '/grate,iron,grillwork,(labor<grate)'
		nsTop 31
		nsLeft 168
		nsBottom 51
		nsRight 200
		description {intricate iron grillwork}
		lookStr {The iron grillwork looks intricately wrought.}
	)
)

(instance theGuard of PicView
	(properties
		x 83
		y 110
		noun '/guard'
		description {the dangerous looking guard}
		view 355
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(HighPrint 120 35) ; "Franc, the guard, Marks you with his glare. You suspect he would give no Quarter in a fight. He would likely Pound you into Ruble."
			(HighPrint 120 36) ; "In any case, he has no Dime to speak to you (to Coin a phrase). To fight him would make no Cents. Better leave him a Loan for a Change."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sconce1 of PicView
	(properties
		x 140
		y 47
		noun '/grease,sconce,holder,lamp'
		description {a sconce}
		view 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (or (== gTimeODay 7) (== gTimeODay 0))
				(HighPrint 120 37) ; "The two oil sconces are not lit."
			else
				(HighPrint 120 38) ; "The flickering flames in the two oil sconces eerily illuminate this alcove."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sconce2 of PicView
	(properties
		x 234
		y 59
		noun '/grease,sconce,holder,lamp'
		description {a sconce}
		view 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (or (== gTimeODay 7) (== gTimeODay 0))
				(HighPrint 120 37) ; "The two oil sconces are not lit."
			else
				(HighPrint 120 38) ; "The flickering flames in the two oil sconces eerily illuminate this alcove."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flame1 of Flame
	(properties
		x 140
		y 41
		noun '/flame,torch'
		view 120
		loop 1
		priority 13
		signal 16
	)
)

(instance flame2 of Flame
	(properties
		x 234
		y 53
		noun '/flame,torch'
		view 120
		loop 1
		priority 13
		signal 16
	)
)

(instance shutter of PicView
	(properties
		x 185
		y 88
		noun '/window,shutter'
		description {a shutter}
		lookStr {The shutter covers the window.  It looks like the business is not in business at the moment.}
		view 120
		loop 3
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 6 189 init: setMotion: MoveTo 77 164 self)
			)
			(1
				(if (or (== gTimeODay 7) (== gTimeODay 0))
					(self dispose:)
				else
					(dinarzad setCycle: End self)
				)
			)
			(2
				(cond
					((and (IsFlag 12) (IsFlag 13) (not (IsFlag 39))) ; fMoneyMission, fMoneyDone, fMoneyRumor
						(SetFlag 39) ; fMoneyRumor
						(Say dinarzad self 120 39 120 40) ; "Rumor has it that a thief broke into the Metal Worker's house the other night.  There will be extra guards patrolling the streets tonight. It will be a good night to sleep in."
					)
					((or (IsFlag 13) (IsFlag 12)) ; fMoneyDone, fMoneyMission
						(beHappy self)
					)
					(
						(and
							(IsFlag 11) ; fMoneySign
							(== gDay gMoneyDate)
							(>= gTimeODay 4)
							(not (IsFlag 13)) ; fMoneyDone
						)
						(SetFlag 12) ; fMoneyMission
						(Say dinarzad self 120 41 120 42 120 43 120 44) ; "If you are interested, and I think you will be, I do have a job for you."
						(= yesNoState 4)
					)
					((IsFlag 10) ; fMoneyTwice
						(beHappy self)
					)
					((IsFlag 9) ; fMoneyOnce
						(SetFlag 10) ; fMoneyTwice
						(= yesNoState 2)
						(Say dinarzad self 120 45) ; "Ah, the sunshine returns to our corner of the alley. Would you like me to be of service to you?"
					)
					(else
						(SetFlag 9) ; fMoneyOnce
						(= yesNoState 1)
						(Say dinarzad self 120 46 120 47) ; "So, we have a stranger to our fair land. Welcome, Traveler from afar. Come closer, that you might find all that you seek here."
					)
				)
			)
			(3
				(dinarzad loop: 1 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance changeLoot of HandsOffScript
	(properties)

	(method (changeState newState &tmp exTax exCents [str 50])
		(switch (= state newState)
			(0
				(if (not (= exNum [gInvNum 17])) ; Gold
					(HighPrint 120 48) ; "As you search through your pouch, you discover that you have no more coins from Spielburg to exchange."
				else
					(Format @str 120 49 exNum) ; "You have %d gold coins from Spielburg. How many will you exchange?"
					(if (> (= exNum (GetNumber @str exNum)) [gInvNum 17]) ; Gold
						(= exNum [gInvNum 17]) ; Gold
						(Format @str 120 50 exNum) ; "But that would be cheating! You only have %d gold coins, and can only Peso much."
						(HighPrint @str)
						(self changeState: 0)
					)
				)
				(if (>= exNum 1)
					(dinarzad loop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
				else
					(self changeState: 5)
				)
			)
			(1
				(= cycles 8)
			)
			(2
				(dinarzad setLoop: 3 cel: 2 setCycle: Beg self)
			)
			(3
				(gMiscSound number: 120 loop: 0 priority: 5 play:)
				(dinarzad cycleSpeed: 0)
				(SolvePuzzle 604 7)
				(Say dinarzad self 120 51) ; "Here you are. I just love intimate exchanges like this."
			)
			(4
				(gEgo use: 17 exNum) ; Gold
				(if (< (= exTax (/ exNum 5)) 10)
					(= exTax 10)
				)
				(if (> exTax 50)
					(= exTax 50)
				)
				(= exNum (/ (= exCents (* exNum (- 100 exTax))) 100))
				(gEgo get: 2 exNum) ; Dinar
				(self dispose:)
			)
			(5
				(Say dinarzad self 120 52) ; "Oh, is your pouch deflated? I'm so sorry. Well, I hope you can come again soon."
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance goToHer of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 165 113 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sheBends of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gEgo has: [fenceItems register]))
					(self changeState: 20)
				else
					(dinarzad loop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
				)
			)
			(1
				(= cycles 6)
			)
			(2
				(dinarzad loop: 3 cel: 2 setCycle: Beg self)
			)
			(3
				(SolvePuzzle 695 3 2)
				(gMiscSound number: 120 loop: 0 priority: 5 play:)
				(dinarzad cycleSpeed: 0)
				(HighPrint (Format @longString 120 53 [fenceNames register])) ; "Dinarzad takes the %s and hands you the money."
				(gEgo use: [fenceItems register])
				(gEgo get: 2 (/ (+ [curPrices register] 50) 100)) ; Dinar
				(= lastShown -1)
				(if (and (not (IsFlag 26)) (not saidOnce)) ; fWeaponRobbed
					(= saidOnce 1)
					(Say dinarzad self 120 54) ; "By the way, you might like to know where a certain someone (who shall be nameless, yet for whom I have little love) conceals his safe."
				else
					(= cycles 1)
				)
			)
			(4
				(self dispose:)
			)
			(20
				(Say dinarzad self 120 55) ; "Why do you offer that which you do not have?"
			)
			(21
				(self dispose:)
			)
		)
	)
)

(instance moneySpells of Code
	(properties)

	(method (doit spellNum)
		(if (OneOf spellNum 20 23 29)
			(return 1)
		else
			(HighPrint 120 56) ; "You'd better not. Franc, the guard, looks like he would Pound you into Ruble if you tried that."
			(return 0)
		)
	)
)

