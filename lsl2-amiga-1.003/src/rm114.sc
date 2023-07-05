;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm114 0
)

(local
	work
	owesForSoda
	girlTalk
)

(instance rm114 of Rm
	(properties
		picture 114
		horizon 5
		south 14
	)

	(method (init)
		(Load rsVIEW 218)
		(Load rsVIEW 219)
		(if (gEgo has: 1) ; Dollar_Bill
			(Load rsVIEW 1)
		)
		(super init:)
		(gAddToPics add: aView1 aView2 aView3 aView4 doit:)
		(aSpigots setPri: 9 setCycle: Fwd init: hide:)
		(if ((gInventory at: 8) ownedBy: gCurRoomNum) ; Grotesque_Gulp
			(aGulpCup init: stopUpd:)
		)
		(aClerk stopUpd: init: setScript: girlScript)
		(aBigClerk view: 219 setLoop: 3 posn: 273 1038 setPri: 15 init:)
		(NormalEgo)
		(gEgo posn: 35 154 init:)
		(self setRegions: 200 setScript: rm114Script) ; rm200
	)
)

(instance rm114Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(if (and owesForSoda (gEgo has: 8)) ; Grotesque_Gulp
				(if (< state 8)
					(self changeState: 8)
				)
			else
				(gCurRoom newRoom: 14)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/coke,cup,(dispenser<coke),(dispenser<coke)')
				(if (not ((gInventory at: 8) ownedBy: gCurRoomNum)) ; Grotesque_Gulp
					(Print 114 0) ; "There's not one single cup left in the whole joint!"
				else
					(Print 114 1) ; "There's only one soda cup left in the place, the speciality of the house: a "Grotesque Gulp.""
					(Print 114 2) ; "GG's are legendary in the Los Angeles area -- it's the only soft drink served in a painted 32-gallon trash can!"
				)
			)
			(if (Said '/bucko,ticket,(dispenser<bucko)')
				(cond
					((gEgo has: 2) ; Lottery_Ticket
						(event claimed: 0)
						(return)
					)
					((not ((gInventory at: 2) ownedBy: gCurRoomNum)) ; Lottery_Ticket
						(Print 114 3) ; "There are no more tickets available here."
					)
					(else
						(Print 114 4) ; "You too can be rich and famous! Play the Lucky Life Lottery game! Luck-O Buck-O Tickets available here!"
					)
				)
			)
			(if (Said '/dispenser')
				(Print 114 5) ; "There are two machines here: a Luck-O Buck-O lottery ticket machine and a soda dispenser."
			)
			(if (Said '/agent,children,woman')
				(aBigClerk posn: 273 38 stopUpd:)
				(Timer setReal: aBigClerk 5)
				(HandsOff)
			)
			(if (Said '[/building,box,buffet,rack,building,airport]')
				(Print 114 6) ; "This Quikie Mart has many items for sale. A clerk lounges sleepily behind the counter near a lottery ticket machine. There is a soda dispenser near the front window."
			)
		)
		(if (Said 'talk/agent,children,woman')
			(girlScript cue:)
		)
		(if
			(and
				(gEgo has: 8) ; Grotesque_Gulp
				(or
					(Said 'return,drop/coke/rack<back')
					(Said 'return,drop/coke/back')
					(Said 'return,drop/coke<back')
					(Said 'return,drop/coke/dispenser')
				)
			)
			(Print 114 7) ; "You try as hard as you can, but you just can't force that soda back into the nozzles!"
		)
		(if
			(and
				(gEgo has: 8) ; Grotesque_Gulp
				(or
					(Said 'return,give,drop/coke/buffet')
					(Said 'return,give/coke')
					(Said 'return,give/coke/agent,woman')
				)
			)
			(Print 114 8) ; "Hey, you can't do that!" orders the clerk. "Once you pour 'em, you gotta keep 'em!"
		)
		(if
			(or
				(Said 'ask/agent,children,woman/ticket')
				(Said 'apply,play/(dispenser<bucko),bucko')
				(Said 'ask,get,buy/ticket')
			)
			(cond
				((not ((gInventory at: 2) ownedBy: gCurRoomNum)) ; Lottery_Ticket
					(Print 114 9) ; "Sorry, pardner," says the clerk, "we're all out of Luck-O Buck-Os for this week!"
				)
				((not (gEgo inRect: 0 105 90 120))
					(Print 114 10) ; "Move closer to the clerk to buy a ticket."
				)
				((gEgo has: 1) ; Dollar_Bill
					(self changeState: 12)
				)
				(else
					(Print 114 11) ; "May I have a free lottery ticket, please? I have no money!"
					(Print 114 12) ; "The clerk responds, "We ain't runnin' no charity here, cowboy. You wanna lottery ticket? You gotta pay for it.""
					(Print 114 13) ; ""That'll be a buck, please," she says."
				)
			)
		)
		(if (Said 'look/ticket')
			(cond
				((not (gEgo has: 2)) ; Lottery_Ticket
					(DontHave) ; "You don't have it."
				)
				((not (gEgo inRect: 0 105 90 120))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 114 14) ; "You show your lottery ticket to the clerk."
					(Print 114 15) ; "I donno if it's any good or not. We don't cash 'em; we just sell 'em!"
				)
			)
		)
		(if (Said 'get/cup')
			(if (not ((gInventory at: 8) ownedBy: gCurRoomNum)) ; Grotesque_Gulp
				(Print 114 0) ; "There's not one single cup left in the whole joint!"
			else
				(Print 114 16) ; "Perhaps you should use the soda dispenser."
			)
		)
		(if
			(or
				(Said 'drain,fill/cup,coke')
				(Said 'apply/dispenser<coke')
				(Said 'get/coke,coke')
			)
			(cond
				((not ((gInventory at: 8) ownedBy: gCurRoomNum)) ; Grotesque_Gulp
					(Print 114 0) ; "There's not one single cup left in the whole joint!"
				)
				((not (gEgo inRect: 110 128 170 138))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 1)
				)
			)
		)
		(if
			(or
				(Said 'give,finger/agent,children,woman')
				(Said 'finger,give/buck')
				(Said 'buy')
			)
			(cond
				((not owesForSoda)
					(Print 114 17) ; "Why pay? You don't owe any money."
				)
				((not (gEgo inRect: 0 105 90 120))
					(NotClose) ; "You're not close enough."
				)
				((gEgo has: 4) ; Million_Dollar_Bill
					(Print 114 18) ; "The clerk just laughs, "Do I look like I could break a million-dollar bill?""
				)
				((gEgo has: 2) ; Lottery_Ticket
					(Print 114 19) ; "I can't give you credit on that ticket, pardner." says the clerk. "You're gonna havta come up with some real money to pay for a soda like that!"
				)
				((gEgo has: 1) ; Dollar_Bill
					(Print 114 20) ; ""Here's a dollar for my 'Grotesque Gulp'" you offer."
					(Print 114 21) ; "The clerk responds, "We ain't runnin' no charity here, cowboy. You wanna soda? You gotta pay for it.""
					(Print 114 22) ; ""That'll be thirty-two bucks, please," she says."
					(Print 114 23) ; "That's a good value, Larry -- only a dollar a gallon! Too bad you only have one dollar on you."
				)
				((not (gEgo has: 6)) ; Wad_O__Dough
					(Print 114 24) ; "You have no money to give her."
				)
				(else
					(Print 114 25) ; ""Here's a hundred-dollar bill," you offer."
					(Print 114 26) ; "Ok, pardner," says the clerk. "Too bad we don't keep any change at this time of night!"
					(Print 114 27) ; ""But it's broad daylight," you protest!"
					(Print (Format @gString 114 28 gTritePhrase)) ; ""%s" she concludes."
					(gGame changeScore: 3)
					(= owesForSoda 0)
				)
			)
		)
		(if (Said '/condom')
			(Print 114 29) ; "You must obtain those in the "Land of the Lounge Lizards!""
		)
		(if (Said 'buy,open,(ask<for)/door,*')
			(Print 114 30) ; "You don't need to do that."
		)
	)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(1
				(HandsOff)
				(Ok) ; "Ok."
				(gEgo setMotion: MoveTo 155 133 self)
			)
			(2
				(gEgo setLoop: 3)
				(aSpigots show: setCycle: Fwd)
				(= seconds 6)
			)
			(3
				(Print 114 31) ; "A cup that large might take a long time to fill."
				(= seconds 6)
			)
			(4
				(Print 114 32) ; "A cup that large might take FOREVER to fill!"
				(= seconds 6)
			)
			(5
				(aSpigots hide:)
				(Print 114 33 #draw) ; "Finally, you top it off, while you carefully consider how you're going to pick it up."
				(= seconds 3)
			)
			(6
				(if (> gFilthLevel 4)
					(Print 114 34) ; "Ah, what the hell. This isn't real life... but merely an incredible simulation! You decide to put it in your pocket, along with everything else."
				else
					(Print 114 35) ; "Ah, shucks! This isn't real life... but merely an incredible simulation! You decide to put it in your pocket, along with everything else."
				)
				(gEgo
					view: 218
					setLoop: 3
					cel: 0
					setCycle: End self
					cycleSpeed: 2
				)
				(aGulpCup dispose:)
			)
			(7
				(NormalEgo 1)
				(gEgo get: 8) ; Grotesque_Gulp
				(gGame changeScore: 5)
				(= owesForSoda 1)
				(= state 0)
			)
			(8
				(= seconds (= cycles 0))
				(= gCurrentStatus 1000)
				(Print 114 36) ; "Suddenly the woman behind the counter comes to life!"
				(Print 114 37) ; "Hold it right there, pardner," she cries, "you ain' a gonna rustle no soda offn me!"
				(HandsOff)
				(aClerk setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(9
				(aClerk setCycle: CT 8 -1)
				(gEgo
					view: 219
					setLoop: 2
					cel: 0
					posn: 30 149
					illegalBits: 0
					setPri: 3
					cycleSpeed: 1
					setCycle: End self
					setMotion: MoveTo 23 184
				)
			)
			(10
				(gEgo stopUpd:)
				(aClerk stopUpd:)
				(= seconds 3)
			)
			(11
				(Print 114 38) ; "Yeeeee haaaaaa," screams the clerk, "you're one dead Coke sucker!"
				(Print 114 39) ; "Enunciate carefully, please!"
				(= gCurrentStatus 1001)
			)
			(12
				(HandsOff)
				(Print 114 40 #icon 1 0 0) ; "Here's my last dollar," you say, handing it to the cute clerk. "How about selling me one of those Luck-O Buck-O Lottery tickets?"
				(Print 114 41) ; "Ok, pardner," says the clerk, "here ya go. Just stick this here ticket in that machine on the end of the counter."
				(Print (Format @gString 114 42 gTritePhrase)) ; "Good luck!" she concludes. "%s"
				(gEgo put: 1 -1 setMotion: MoveTo (gEgo x:) 123 self) ; Dollar_Bill
			)
			(13
				(gEgo setMotion: MoveTo 42 123 self)
			)
			(14
				(gEgo loop: 3)
				(Print 114 43 #draw) ; "You insert the paper ticket into the Luck-O Buck-O machine."
				(= seconds 3)
			)
			(15
				(Print 114 44 #icon 218 0 2 #at -1 20 #dispose) ; "The Luck-O Buck-O Lottery machine's video display screen flashes, "Please enter your six numbers between 100 and 999 now.""
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #1})))
				)
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #2})))
				)
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #3})))
				)
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #4})))
				)
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #5})))
				)
				(for
					((= i 0))
					(or (< i 100) (> i 999))
					((= i (GetNumber {Pick #6})))
				)
				(cls)
				(for ((= i 0)) (< i 3) ((++ i))
					(Print 114 45 #icon 218 0 2) ; "Processing..."
				)
				(Print 114 46) ; "Out pops your Luck-O Buck-O lottery ticket. You take it and wonder, "Will I be a winner?""
				(gEgo get: 2) ; Lottery_Ticket
				(gGame changeScore: 3)
				(= state 0)
				(HandsOn)
			)
		)
	)
)

(instance girlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(User canInput: 0)
				(Print (Format @gString 114 47 gLaffer)) ; ""Hello, baby!" you tell her. %s"
				(aClerk setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(aClerk setLoop: 0 setCel: 0)
				(Print 114 48) ; "Hi, y'all," she replies in a charming drawl. "Ya shore have a white suit."
				(= seconds 3)
			)
			(3
				(Print 114 49) ; "You have always admired Southern girls."
				(User canInput: 1)
			)
			(4
				(User canInput: 0)
				(Print 114 50) ; "You vow to try again. "That's really a charming Southern accent," you say. "I'll bet you're from the South.""
				(aClerk setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(User canInput: 1)
				(aClerk setLoop: 0 setCel: 0)
				(Print 114 51) ; "Why, shucks," she replies, "you're right! Howdja know I was from Orange County?"
			)
			(6
				(User canInput: 0)
				(Print 114 52) ; "What do you say, baby?" you turn on your charm afterburner, "How's about you and me gettin' it on!"
				(aClerk setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(User canInput: 1)
				(Print 114 53) ; ""Gettin' it on what?" she asks."
				(aClerk setLoop: 0 setCel: 0)
				(= state 6)
				(-- state)
			)
		)
	)
)

(instance aBigClerk of Prop
	(properties)

	(method (cue)
		(Print 114 54) ; "You find Southern women sexy."
		(Print 114 55 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 273 1038)
		(HandsOn)
	)
)

(instance aView1 of PV
	(properties
		y 100
		x 40
		view 218
		cel 2
		priority 6
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 45
		x 167
		view 218
		loop 1
		priority 1
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 83
		x 59
		view 218
		cel 1
		priority 0
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 128
		x 140
		view 218
		priority 9
		signal 16384
	)
)

(instance aSpigots of Prop
	(properties
		y 107
		x 140
		view 218
		loop 2
	)
)

(instance aGulpCup of View
	(properties
		y 129
		x 140
		view 218
		cel 3
		priority 9
		signal 16384
	)
)

(instance aClerk of Prop
	(properties
		y 92
		x 53
		view 219
		priority 5
	)
)

