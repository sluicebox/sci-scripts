;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 291)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use desertReg)
(use ForwardCounter)
(use Motion)
(use System)

(public
	fakirsPitch 0
	haggleSP 1
	bargainSP 2
	buySP 3
	InitFakirP 4
)

(local
	fakirGone
	offerPrice = 50
	fakirScript
	fakirToY
	[fakirGenList 38] = [1 2 0 3 0 0 0 0 0 4 5 6 0 0 7 0 8 0 9 12 12 0 14 15 16 17 0 0 0 21 0 0 22 0 0 0 0 0]
	[fakirSpecList 10] = [23 '//dinar' 27 '//cent' 24 '//saurii,merchandise' 28 '//cost,cost,line' 0 0]
	[str1 30]
)

(procedure (InitFakirP)
	(gMiscSound number: 293 loop: -1 priority: 5 play:)
	(fakir init:)
	((ScriptID 660 1) init:) ; saurus
)

(instance fakirsPitch of Script
	(properties)

	(method (doit)
		(if (not (fakir tCount:))
			(super doit: &rest)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look')
				(event claimed: 0)
			)
			((Said 'no')
				(fakir tLoop: 2)
				(switch (++ gNoLevel)
					(1
						(Say fakir 291 0 291 1) ; "Was that "No, I want to buy a saurus," or "I know I want to buy a saurus?" You've really got to pronounce things clearly, you know. Or maybe you don't."
					)
					(2
						(Say fakir 291 2 291 3) ; "Let's get this story straight."
					)
					(3
						(Say fakir 291 4 291 5) ; "All right, let's try it this way. I've got the saurus for you, and you're looking for the words to say how much you want him. That's why you need the saurus, of course."
					)
					(else
						(Say fakir 291 6) ; "You know, I'd be willing to buy the saurus for you at this point, as long as it runs away with you on it."
						(= gNoLevel 0)
					)
				)
			)
			(
				(or
					(Said 'yes')
					(Said 'make/deal')
					(Said 'deal')
					(Said 'buy/saurii')
				)
				(gCurRoom setScript: haggleSP)
			)
			((Said 'bargain')
				(gCurRoom setScript: bargainSP)
			)
			((Said 'look,look,mount,ride,climb,climb,get,get')
				(event claimed: 0)
			)
			(else
				(event claimed: 1)
				(switch (++ gHuhLevel)
					(1
						(fakir tLoop: 3)
						(Say fakir 291 7) ; "Don't you know an answer when I'm questioning it? Let's get down to business, so I can do a business on you. I'm selling you a saurus, and you're trying to buy one, right?"
					)
					(2
						(fakir tLoop: 2)
						(Say fakir 291 8 291 9 291 10 291 11) ; "Wait, I think I hear an answer lurking in the curtains. You can't let those answers lurk, you know. It's bad for their health."
					)
					(3
						(fakir tLoop: 3)
						(Say fakir 291 12) ; "I've had tough customers before, but most speak better gibberish. For example, do you understand the phrase, "Do you want to buy a Saurus?""
					)
					(else
						(fakir tLoop: 2)
						(Say fakir 291 6) ; "You know, I'd be willing to buy the saurus for you at this point, as long as it runs away with you on it."
						(= gHuhLevel 0)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ gFakirVisits)
					(1
						(Say fakir self 291 13 291 14) ; "Ah, there you are! I've been looking for you."
					)
					(2
						(Say fakir self 291 15 291 16) ; "You know, you remind me of someone I didn't sell a saurus to. Nah, it couldn't be. Surely someone with your brains and looks needs a saurus."
					)
					(3
						(Say fakir self 291 17 291 18 291 19) ; "So they call you a Hero, eh? What kind of Hero are you, walking around like a nobody when you could be riding your noble steed across the desert sands."
					)
					(4
						(Say fakir self 291 20) ; "Hi, I'm Ali. Honest Ali Fakir. Welcome to Honest Ali Fakir's Used Saurus lot - where we always know a sucker when we see one. Pleased to meet you. Now about that deal we were going to make ..."
					)
					(else
						(Say fakir self 291 21 291 22 291 23 291 24) ; "That's it! I give up. I've tried to help you save the universe and you won't even buy my lousy saurus."
						(SetFlag 172) ; fLoseIfLeaves
					)
				)
			)
			(1
				(fakir loop: 4 cel: 0 setCycle: ForwardCounter 3 self)
			)
			(2
				(= fakirToY
					(if (< (gEgo y:) 137)
						(+ (gEgo y:) 12)
					else
						(- (gEgo y:) 12)
					)
				)
				(self
					changeState:
						(if (> gFakirVisits 3)
							301
						else
							(* gFakirVisits 100)
						)
				)
			)
			(100
				(HandsOff)
				(fakir
					illegalBits: 0
					ignoreActors:
					tLoop: -1
					setCycle: Walk
					setMotion: MoveTo 272 137 self
				)
				(Say fakir self 291 25) ; "I'm Ali Fakir. Honest Ali Fakir. Welcome to Honest Ali Fakir's Used Saurus Lot. "If we don't have the saurus you want, then you don't want one.""
			)
			(101
				(fakir setLoop: 6)
				(RedrawCast)
				(fakir
					caller: 0
					tLoop: -1
					setLoop: -1
					setMotion: MoveTo 146 137 self
				)
				(Say fakir 291 26) ; "Of course, even if you don't want one, I'll be happy to sell one to you."
			)
			(102
				(HandsOn)
				(fakir loop: 7 ignoreActors: 0)
				(RedrawCast)
				(fakir loop: 4 cel: 0 setCycle: ForwardCounter 2)
				(= seconds 4)
			)
			(103
				(fakir tLoop: 2)
				(Say fakir self 291 27) ; "You look like a man looking for a saurus. I have the finest saddle saurus you can find. A magnificent saddle saurus!"
			)
			(104
				(fakir tLoop: 3)
				(Say fakir self 291 28) ; "(If you ride one, that's exactly what you get.)"
			)
			(105
				(fakir loop: 4 cel: 0 setCycle: ForwardCounter 3)
				(= seconds 5)
			)
			(106
				(fakir tLoop: 2)
				(Say fakir self 291 29) ; "You never know when a saurus might come in handy. Why, just the other day, you were thinking to yourself: "Self," you thought, "if only I had someone to play pinochle with!" If you had a saurus, you still couldn't play pinochle."
			)
			(107
				(fakir tLoop: 3)
				(Say fakir self 291 30) ; "(You couldn't even pronounce it.)"
			)
			(108
				(fakir loop: 4 setCycle: ForwardCounter 3 self)
			)
			(109
				(fakir tLoop: 2)
				(Say fakir self 291 31) ; "It just goes to show you. And speaking of shows, have I got the saurus for you. The Saurus. That's where you look for synonyms. And speaking of sin, when it comes to sauruses, well, let's just keep your personal preferences a secret, shall we?"
			)
			(110
				(fakir tLoop: 3)
				(Say fakir self 291 32) ; "(They don't call it Saurus Rex for nothing.)"
			)
			(111
				(fakir loop: 4 setCycle: ForwardCounter 4 self)
			)
			(112
				(fakir setScript: puffEtc)
			)
			(200
				(HandsOff)
				(fakir
					illegalBits: 0
					ignoreActors:
					tLoop: -1
					setCycle: Walk
					setMotion: MoveTo 250 137 self
				)
				(Say fakir 291 33 291 34) ; "So you want to buy a saurus, eh? I'm Fakir, Honest Ali Fakir. Glad to meet you. You've come to the right place. Honest Ali Fakir's Used Saurus Lot - If you don't buy one here, you don't buy one."
			)
			(201
				(fakir setLoop: 6)
				(RedrawCast)
				(fakir setLoop: -1 setMotion: MoveTo 150 137 self)
			)
			(202
				(HandsOn)
				(fakir loop: 7 ignoreActors: 0)
				(RedrawCast)
				(fakir loop: 4 setCycle: ForwardCounter 5)
				(= seconds 4)
			)
			(203
				(fakir tLoop: 2)
				(Say fakir self 291 35) ; "At any rate, I'm here to sell you a saurus. I'll sell you a saurus, and I won't take "No" for an answer. I don't know the meaning of "No.""
			)
			(204
				(fakir tLoop: 3)
				(Say fakir self 291 36) ; "(I couldn't find it in The Saurus.)"
			)
			(205
				(fakir loop: 4 setCycle: ForwardCounter 5 self)
			)
			(206
				(fakir setScript: puffEtc)
			)
			(300
				(fakir tLoop: 2)
				(Say fakir self 291 37 291 38) ; "So you need to buy a saurus to travel in the desert. You're desperate. Hello, I'm Honest Ali Fakir. Pleased to meet you, Desperate. Have I got a saurus for you. I don't know, do you?"
			)
			(301
				(fakir loop: 4 setCycle: ForwardCounter 5 self)
			)
			(302
				(fakir tLoop: 2)
				(Say fakir self 291 39) ; "You DO want to buy a saurus, don't you?"
			)
			(303
				(fakir setScript: puffEtc)
			)
		)
	)
)

(instance puffEtc of Script
	(properties)

	(method (changeState)
		(switch (Random 0 2)
			(0
				(fakir setLoop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(1
				(fakir setLoop: 3 cel: 0)
				(= cycles (Random 8 16))
			)
			(2
				(fakir setLoop: 4 setCycle: ForwardCounter (Random 2 5) self)
			)
		)
	)
)

(instance haggleSP of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DontMove 0)
	)

	(method (doit)
		(if (not (fakir tCount:))
			(super doit: &rest)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'no')
				(switch offerPrice
					(50
						(fakir tLoop: 3)
						(Say fakir 291 40 291 41) ; "Perhaps there is more a brain about you than I suspected."
						(= offerPrice 40)
					)
					(40
						(fakir tLoop: 2)
						(Say fakir 291 42) ; "You certainly know how to drive a hard bargain. Why don't we just agree at thirty for bridle, saddle, and saurus?"
						(= offerPrice 30)
					)
					(30
						(fakir tLoop: 2)
						(Say fakir 291 43) ; "Well, we certainly are going nowhere fast. I'm willing to make you my best offer. Twenty dinars and you ride away on a new (for you) saurus. What do you say?"
						(= offerPrice 20)
					)
					(20
						(fakir tLoop: 3)
						(Say fakir 291 44 291 45 291 46 291 47) ; "You know, you drive a hard bargain. I respect that in a man."
						(= offerPrice 10)
					)
					(10
						(fakir tLoop: 2)
						(Say fakir 291 48 291 49) ; "This is ridiculous. Here I am, a man of unquestionable integrity and dignity, forced to sell his sole remaining saurus for a mere fraction of its dubious value."
						(= offerPrice 5)
					)
					(else
						(fakir tLoop: 3)
						(Say fakir 291 50) ; "Well, that was going nowhere the long way."
						(fakirsPitch start: 303)
						(= next fakirsPitch)
						(self dispose:)
					)
				)
			)
			(
				(or
					(Said 'yes')
					(Said 'make/deal')
					(Said 'deal')
					(Said 'buy/saurii')
				)
				(gCurRoom setScript: buySP)
			)
			((Said 'bargain')
				(gCurRoom setScript: bargainSP)
			)
			(else
				(event claimed: 1)
				(switch (++ gHuhLevel)
					(1
						(fakir tLoop: 2)
						(Say fakir 291 51 291 52) ; "You know, you remind me of a saurus I once knew."
						(= offerPrice 40)
					)
					(2
						(fakir tLoop: 3)
						(Say fakir 291 53) ; "You wouldn't happen to be HARD OF HEARING, WOULD YOU?  SHALL WE AGREE UPON thirty dinars?"
						(= offerPrice 30)
					)
					(3
						(fakir tLoop: 3)
						(Say fakir 291 54) ; "I've had better luck trying to buy a Glow-in-the-dark-turban. I think I'll quit while I'ma behind."
						(fakirsPitch start: 303)
						(= next fakirsPitch)
						(self dispose:)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNoLevel 0)
				(= gHuhLevel 0)
				(fakir tLoop: 3)
				(Say fakir self 291 55 291 56 291 57) ; "Seeing as no one in his right mind would actually want a saurus, you won't mind that I have the right saurus for you."
			)
			(1
				(Say
					fakir
					(Format ; "All this for a mere %s dinars. What do you say?"
						@str1
						291
						58
						(switch offerPrice
							(50 {fifty})
							(40 {forty})
							(30 {thirty})
							(20 {twenty})
							(10 {ten})
							(5 {five})
						)
					)
				)
			)
		)
	)
)

(instance bargainSP of Script
	(properties)

	(method (doit)
		(if (not (fakir tCount:))
			(super doit: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fakir tLoop: 3)
				(if (TrySkill 13 30) ; communication
					(Say fakir self 291 59 291 60) ; "Let's see, my asking price was 50, your calling price 10, I raised you 2 clubs, you doubled, I redoubled, the stock market crashed, I doubted your double, you called me (just what, I'll never repeat), and we came to a gentlemen's agreement of 20 dinars."
					(= offerPrice 20)
				else
					(Say fakir self 291 61 291 62) ; "Let's see, my initial asking price was 50, you parried with 10, I gracefully riposted with 55, you countered with 20, I recountered with 60, you accounted, I encountered, we recounted and came up a couple short, so to make up the difference, we agreed upon whether the party of the first part is to pay the party of the second part part of the sums owing, but we tore up that contract and you are buying the Saurus for 50 dinars, COD."
					(= offerPrice 50)
				)
			)
			(1
				(client setScript: buySP)
			)
		)
	)
)

(instance buySP of HandsOffScript
	(properties)

	(method (changeState newState &tmp dinars)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 155 148 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= next fakirsPitch)
				(fakir tLoop: 3)
				(switch (Buy 0 (* offerPrice 100) 1 0 0 1)
					(1
						(if
							(>=
								(= dinars
									(+ [gInvNum 2] (/ [gInvNum 1] 100)) ; Dinar, Centime
								)
								5
							)
							(Say fakir self 291 63 291 64 291 65) ; "After all we've been through to come to an agreement, and you have the nerve not to have enough money."
							(= offerPrice
								(cond
									((< dinars 10) 5)
									((< dinars 20) 10)
									((< dinars 30) 20)
									((< dinars 40) 30)
									(else 40)
								)
							)
							(= next (ScriptID 291 1)) ; haggleSP
						else
							(Say fakir self 291 66 291 67 291 68 291 69) ; "Do you think you can cheat Honest Ali Fakir? You have to get up pretty early in the morning to do that, since I sleep in. I need my beauty rest."
						)
					)
					(0
						(if (>= (+ [gInvNum 2] (/ [gInvNum 1] 100)) 10) ; Dinar, Centime
							(Say fakir self 291 63 291 64 291 70) ; "After all we've been through to come to an agreement, and you have the nerve not to have enough money."
							(= next (ScriptID 291 1)) ; haggleSP
						else
							(Say fakir self 291 63 291 71) ; "After all we've been through to come to an agreement, and you have the nerve not to have enough money."
						)
					)
					(else
						(fakir tLoop: 2)
						(SetFlag 45) ; fBoughtSaurus
						(= next hiSaurusSP)
						(= cycles 1)
					)
				)
			)
			(3
				(if (== next fakirsPitch)
					(fakirsPitch start: 303)
				)
				(self dispose:)
			)
		)
	)
)

(instance hiSaurusSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 291 72) ; "You pay the man his money."
				(fakir tLoop: 2 setScript: 0)
				(Say fakir self 291 73) ; "Just a minute and I'll introduce your saurus to you."
			)
			(1
				(ClearFlag 172) ; fLoseIfLeaves
				(gEgo setLoop: -1 setMotion: MoveTo 213 146)
				(fakir
					setScript: 0
					setLoop: 5
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 135 138 self
				)
			)
			(2
				((ScriptID 290 3) setCycle: End self) ; gate
				(gEgo setMotion: MoveTo 211 146 self)
			)
			(3
				((ScriptID 290 3) stopUpd:) ; gate
				(fakir loop: 4 cel: 0)
				((ScriptID 660 1) ; saurus
					illegalBits: 0
					ignoreActors:
					posn: -30 146
					setCycle: Walk
					setMotion: MoveTo 174 146 self
				)
			)
			(4
				(gEgo setHeading: 270)
			)
			(5
				(gEgo hide:)
				((ScriptID 660 1) ; saurus
					view: 297
					loop: 0
					cel: 0
					posn: 174 146
					cycleSpeed: 0
					setCycle: CT 5 1 self
				)
				((ScriptID 290 1) ; saurus1
					setScript: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo -30 ((ScriptID 290 1) y:) ; saurus1
				)
			)
			(6
				(gSpareSound number: 292 loop: 1 play: self)
				((ScriptID 660 1) setCycle: End) ; saurus
			)
			(7
				(if (gCast contains: (ScriptID 290 2)) ; saurus2
					((ScriptID 290 2) ; saurus2
						setScript: 0
						setLoop: 1
						setCycle: Fwd
						setMotion: MoveTo -30 ((ScriptID 290 2) y:) ; saurus2
					)
				)
				(SolvePuzzle 618 7)
				(gEgo get: 50) ; Saurus
				(= cycles 2)
			)
			(8
				(fakir tLoop: 2)
				(Say fakir self 291 74 291 75 291 76) ; "Ah, true love at first sight. And what a sight for saurus eyes."
			)
			(9
				(fakir
					setLoop: 1
					ignoreActors:
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo (- (fakir x:) 25) (fakir y:) self
				)
				(gEgo posn: 210 146 show:)
				((ScriptID 660 1) ignoreActors: 0 posn: 168 146 view: 11 cel: 2) ; saurus
				((ScriptID 290 1) dispose:) ; saurus1
				((ScriptID 290 2) dispose:) ; saurus2
			)
			(10
				(fakir setMotion: MoveTo -32 126 self)
				((ScriptID 290 3) setCycle: Beg) ; gate
			)
			(11
				(SetFlag 173) ; fGuardWillDoIt
				(gCurRoom notify:)
				(gMiscSound fade:)
				(MakeSaurusPoly)
				((ScriptID 290 3) stopUpd:) ; gate
				(fakir dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fakir of Talker
	(properties
		x 148
		y 141
		description {the familiar-looking little fellow}
		lookStr {You'd Bet Your Life that you've seen this guy before.}
		view 292
		loop 4
		xStep 4
		tLoop 2
		talkSpeed 0
		myName '//fakir,ali,man,merchant,merchant'
		title {Ali Fakir:}
		color 1
		back 11
		msgFile 292
	)

	(method (showText what)
		(Face gEgo self)
		(= fakirScript (fakir script:))
		(fakir setScript: 0)
		(= tLoop (Random 2 3))
		(switch what
			(12
				(self showMany: what 13)
			)
			(17
				(self showMany: what 20)
			)
			(24
				(self showMany: what 26)
			)
			(9
				(self showMany: what 11)
			)
			(else
				(self messages: 292 what)
			)
		)
	)

	(method (atSpec which)
		(return [fakirSpecList which])
	)

	(method (atGen which)
		(return [fakirGenList which])
	)

	(method (endTalk)
		(super endTalk: &rest)
		(if fakirScript
			(fakir setScript: fakirScript)
		else
			(fakir cel: 0)
		)
	)
)

