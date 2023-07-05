;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 118)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm118 0
)

(local
	work
	seenMessage
	owesForSunscreen
	aClerk
)

(instance rm118 of Rm
	(properties
		picture 118
		horizon 5
	)

	(method (init)
		(Load rsVIEW 229)
		(Load rsVIEW 228)
		(super init:)
		((View new:)
			view: 228
			loop: 0
			cel: 0
			posn: 144 36
			setPri: 0
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 228
			loop: 0
			cel: 1
			posn: 144 83
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 228
			loop: 1
			cel: 0
			posn: 90 135
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 228
			loop: 1
			cel: 0
			posn: 171 135
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 228
			loop: 1
			cel: 1
			posn: 283 113
			setPri: 7
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 228
			loop: 1
			cel: 2
			posn: 279 136
			setPri: 6
			ignoreActors:
			addToPic:
		)
		(aBigClerk
			view: 229
			setLoop: 4
			posn: 273 1058
			setPri: 15
			setCycle: Fwd
			init:
		)
		((= aClerk (Prop new:))
			view: 229
			setLoop: 0
			setPri: 2
			posn: 261 107
			init:
		)
		(NormalEgo)
		(gEgo posn: 216 161 init:)
		(self setRegions: 200 setScript: rm118Script) ; rm200
	)
)

(instance rm118Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0002)
			(if timer
				(timer dispose:)
			)
			(gCurRoom newRoom: 18)
		)
		(cond
			((not (& (gEgo onControl:) $0004))
				(= seenMessage 0)
			)
			((and owesForSunscreen (not seenMessage))
				(= seenMessage 1)
				(Print 118 0) ; "Nice guy! Trying to shoplift from this nice, young clerk."
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/brick,ceiling')
				(Print 118 1) ; "The walls are covered with many items, none of which you need."
			)
			(if (Said '/sign')
				(Print 118 2) ; "Just Say No!"
			)
			(if (Said '/buffet')
				(Print 118 3) ; "Behind the counter sits the epitome of the surfer culture."
			)
			(if (Said '/agent,children,man')
				(aBigClerk posn: 273 58)
				(HandsOff)
				(Timer setReal: aBigClerk 5)
			)
			(if (Said '/sale')
				(Print 118 4) ; "Something is always for sale here!"
			)
			(if (Said '/rack,bottle,buffet,cabinet')
				(cond
					((gEgo has: 9) ; Sunscreen
						(Print 118 5) ; "There is nothing more of interest here."
					)
					((not (gEgo inRect: 0 115 105 138))
						(Print 118 6) ; "There are shelves filled with sundries, but you see nothing that seems useful."
					)
					((not (gEgo has: 3)) ; Cruise_Ticket
						(Print 118 7) ; "You might be able to use some of that sunscreen."
					)
					(else
						(Print 118 8) ; "Say, a bottle of that sunscreen might be handy in the South Pacific!"
					)
				)
			)
			(if (Said '[/airport,building,building]')
				(Print 118 9) ; "By the sign on the druggist's counter, you presume the druggist is out. Only a clerk remains, and he doesn't look too bright."
			)
		)
		(if (Said 'get/lotion,(lotion<suntan)')
			(cond
				((not (gEgo inRect: 66 115 90 134))
					(NotClose) ; "You're not close enough."
				)
				((gEgo has: 9) ; Sunscreen
					(Print 118 10) ; "One bottle is enough!"
				)
				(else
					(if (gEgo has: 3) ; Cruise_Ticket
						(Print 118 11) ; "You grab a bottle of SPF 90 while you picture Bachelorette Barbara rubbing it all over you!"
					else
						(Print 118 12) ; "You take a bottle of sunscreen."
					)
					(= owesForSunscreen 1)
					(gEgo get: 9) ; Sunscreen
					(gEgo observeControl: 2)
				)
			)
		)
		(if
			(or
				(Said 'drop/lotion,(lotion<suntan)/rack<back')
				(Said 'drop,give/lotion,(lotion<suntan)/back')
				(Said 'drop,give/lotion,(lotion<suntan)<back')
				(Said 'return,drop/lotion,(lotion<suntan)')
			)
			(cond
				((not (gEgo inRect: 66 115 90 134))
					(Print 118 13) ; "Put it back where you got it."
				)
				((not (gEgo has: 9)) ; Sunscreen
					(DontHave) ; "You don't have it."
				)
				(else
					(Ok) ; "Ok."
					(= owesForSunscreen 0)
					(gEgo put: 9 gCurRoomNum) ; Sunscreen
					(gEgo ignoreControl: 2)
				)
			)
		)
		(if
			(or
				(Said 'give,finger/agent,children,man/buck')
				(Said 'give/buck')
				(Said 'buy')
			)
			(cond
				((not owesForSunscreen)
					(Print 118 14) ; "You don't owe for anything."
				)
				((not (gEgo inRect: 216 118 237 134))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 5)
				)
			)
		)
		(if (Said 'explore,explore/lotion,(lotion<suntan)')
			(Print 118 15) ; "You feel sure it's in here somewhere."
		)
		(if (Said '/condom')
			(Print 118 16) ; "You must obtain those in the "Land of the Lounge Lizards!""
		)
		(if (Said 'talk/man,lagoon,children,agent')
			(self changeState: 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 40))
			)
			(1
				(aClerk setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(aClerk setLoop: 0 cel: 0)
				(= seconds (Random 10 20))
				(= state 0)
			)
			(3
				(= cycles 0)
				(if (or (gEgo has: 4) (gEgo has: 6)) ; Million_Dollar_Bill, Wad_O__Dough
					(Print 118 17) ; "Hey, buddy!" you say, "Have you heard I'm now incredibly wealthy?"
				else
					(Print 118 18) ; ""Do you have anything here that costs a dollar or less?" you ask him."
				)
				(aClerk setLoop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(if (or (gEgo has: 4) (gEgo has: 6)) ; Million_Dollar_Bill, Wad_O__Dough
					(Print 118 19) ; "Gosh," he replies, "I'm so impressed."
				else
					(Print 118 20) ; ""Nope," he responds."
				)
				(self changeState: 2)
			)
			(5
				(= seconds (= cycles 0))
				(HandsOff)
				(Print 118 21) ; ""I'd like to pay for this," you tell the clerk."
				(cond
					((gEgo has: 4) ; Million_Dollar_Bill
						(Print 118 22) ; "Do you have change for a million-dollar bill?"
					)
					((gEgo has: 6) ; Wad_O__Dough
						(Print 118 23) ; "Do you have change for a hundred?"
					)
					((gEgo has: 1) ; Dollar_Bill
						(Print 118 24) ; "But all I have is a dollar."
					)
					(else
						(Print 118 25) ; "But I have no money," you whine. "Could you find it in your heart to let me have a little bottle of sunscreen to protect my skin from the ozone-depleted atmosphere?"
					)
				)
				(aClerk setLoop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(cond
					((gEgo has: 4) ; Million_Dollar_Bill
						(Print 118 26) ; "Yeah, sure," he says, "do I look like they'd trust me with a million in change?"
						(aClerk setLoop: 0)
					)
					((gEgo has: 6) ; Wad_O__Dough
						(Print 118 27) ; "No," he says, "But feel free to give me a big tip!"
						(Print 118 28) ; "But, of course, my good man," you tell him, suddenly putting on airs, "have a hundred; in fact, have two. Money means nothing to me!"
						(aClerk setLoop: 2 cycleSpeed: 1 cel: 0 setCycle: End)
					)
					(else
						(Print 118 29) ; "No way, dude!"
						(aClerk setLoop: 0)
					)
				)
				(= seconds 4)
			)
			(7
				(NormalEgo)
				(if (gEgo has: 6) ; Wad_O__Dough
					(Print 118 30) ; "Like, thanks, dude," he tells you, "now let me go back to sleep."
					(Print (Format @gString 118 31 gTritePhrase)) ; "He concludes with a familiar, "%s""
					(= owesForSunscreen 0)
					(if (not gScoredSunscreen)
						(= gScoredSunscreen 1)
						(gGame changeScore: 9)
					)
				else
					(Print 118 32) ; "Looks like you're out of luck here, Larry."
					(gEgo observeControl: 2)
				)
				(self changeState: 2)
			)
		)
	)
)

(instance aBigClerk of Prop
	(properties)

	(method (cue)
		(Print 118 33) ; "You find women sexy!"
		(Print 118 34 #at 75 155 #width 170) ; "(How you wish this were one!)"
		(self posn: 273 1058)
		(HandsOn)
	)
)

