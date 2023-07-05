;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm116 0
)

(local
	swimsuitHere
	seenMessage
	owesForSwimsuit
	aClerk
	aBigHand
)

(instance rm116 of Rm
	(properties
		picture 116
		horizon 5
	)

	(method (init)
		(Load rsVIEW 225)
		(Load rsVIEW 226)
		(super init:)
		((View new:)
			ignoreActors:
			view: 225
			loop: 0
			cel: 0
			posn: 160 90
			setPri: 5
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 1
			cel: 0
			posn: 238 151
			setPri: 11
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 1
			cel: 1
			posn: 72 86
			setPri: 5
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 0
			posn: 85 119
			setPri: 8
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 0
			posn: 97 110
			setPri: 7
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 1
			posn: 74 130
			setPri: 9
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 1
			posn: 62 139
			setPri: 10
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 2
			posn: 257 135
			setPri: 9
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 2
			posn: 250 132
			setPri: 9
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 2
			posn: 239 125
			setPri: 8
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 2
			posn: 264 140
			setPri: 10
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 3
			posn: 216 109
			setPri: 6
			addToPic:
		)
		((View new:)
			ignoreActors:
			view: 225
			loop: 2
			cel: 3
			posn: 228 116
			setPri: 7
			addToPic:
		)
		(if (gEgo has: 4) ; Million_Dollar_Bill
			(Load rsVIEW 4)
			(= swimsuitHere 1)
			((View new:) view: 225 cel: 1 posn: 157 66 addToPic:)
		)
		(aBigClerk
			view: 226
			setLoop: 5
			posn: 273 1059
			setPri: 15
			setCycle: Fwd
			init:
		)
		((= aBigHand (Prop new:))
			view: 226
			setLoop: 4
			setCel: 0
			setPri: 15
			posn: 29 1188
			setCycle: Fwd
			cycleSpeed: 2
			ignoreActors:
			init:
		)
		((= aClerk (Act new:))
			view: 226
			setLoop: 3
			setCel: 0
			setPri: 9
			posn: 174 106
			ignoreActors:
			setCycle: Walk
			init:
		)
		(NormalEgo)
		(gEgo posn: 161 162 init:)
		(self setRegions: 200 setScript: rm116Script) ; rm200
	)
)

(instance rm116Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 16)
		)
		(cond
			((not (& (gEgo onControl:) $0004))
				(= seenMessage 0)
			)
			((and owesForSwimsuit (not seenMessage))
				(= seenMessage 1)
				(Print 116 0) ; ""Molto Lira's" sophisticated, computerized, automatic, shoplifting prevention devices keep this door locked while customers carry merchandise for which they have not paid."
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (and (== swimsuitHere 1) (Said '/brick,sign'))
				(Print 116 1) ; "Swimsuits 1/2-PRICE!"
			)
			(if (Said '/rack,bikini,(bra<bathing),job')
				(cond
					((not (gEgo inRect: 137 88 182 96))
						(Print 116 2) ; "There is a rack of swimsuits against the rear wall."
					)
					((gEgo has: 5) ; Swimsuit
						(Print 116 3) ; "The rest of these suits appear to be too generously cut in the crotch region for a guy like you!"
					)
					((!= swimsuitHere 1)
						(Print 116 4) ; "There's nothing in this place that you could afford!"
					)
					(else
						(Print 116 5) ; "Wait a minute; these swimsuits are marked down to half-price, only $100,000.00. With your new-found wealth, you could afford that little, blue, bikini job hanging there."
					)
				)
			)
			(if (Said '/bra')
				(Print 116 6) ; "Never in your life have you seen a man's suit that required a home mortgage!"
				(Print 116 7) ; "Isn't a million, five a little steep, even if the suit IS imported?"
			)
			(if (Said '/art,ceiling')
				(Print 116 8) ; "Evidently, while decorating this store, cost was no object."
				(Print 116 9 #at -1 152) ; "(And also, no help!)"
			)
			(if (Said '/finger')
				(Print 116 10) ; "It appears that you are boring the beautiful lady."
			)
			(if (Said '/brick')
				(Print 116 11) ; "Along the right and left walls are rows of expensive, Italian, hand-made virgin-wool suits."
				(Print 116 12) ; "From the prices here, they should have been hand-knit by virgins!"
			)
			(if (Said '/art')
				(Print 116 13) ; "What ARE they doing?"
			)
			(if (Said '/buffet,finger,woman,agent')
				(aBigClerk posn: 159 59 stopUpd:)
				(Print 116 14 #draw) ; "Behind an unbelievably beautiful, imported, Italian-marble counter stands an unbelievably beautiful, imported, Italian clerk."
				(Timer setReal: aBigClerk 5)
				(HandsOff)
			)
			(if (Said '[/airport,building,building,look,ceiling,carpet]')
				(if (gEgo has: 5) ; Swimsuit
					(Print 116 15) ; "There's nothing else here you can afford."
				else
					(Print 116 16) ; "This place may be over-priced, but at least it's gaudy!"
					(if (== swimsuitHere 1)
						(Print 116 17) ; "There is a sale sign on the rear wall."
					)
				)
			)
		)
		(if (Said 'get/bikini,(bra<bathing),job')
			(cond
				((not (gEgo inRect: 137 88 182 96))
					(Print 116 18) ; "There are swimsuits for sale on the rack at the rear of the store. Why not walk over there?"
				)
				((gEgo has: 5) ; Swimsuit
					(Print 116 19) ; "At these prices, one's enough!"
				)
				((!= swimsuitHere 1)
					(Print 116 20) ; "Nah. No way!"
				)
				(else
					(Print 116 21) ; "You select a reasonably tight Spandex job in blue. Although it's cut a little tight, perhaps that may work to your advantage on the ship. In fact, this may be the beginning of a whole new image for you, Larry!"
					(= owesForSwimsuit 1)
					(gEgo get: 5) ; Swimsuit
					(gGame changeScore: 5)
					(gEgo observeControl: 2)
				)
			)
		)
		(if
			(or
				(Said 'give,finger/agent,children,woman/buck')
				(Said 'give,finger/buck')
				(Said 'buy')
			)
			(cond
				((not owesForSwimsuit)
					(Print 116 22) ; "Presently, you don't owe any money."
				)
				((not (gEgo inRect: 120 130 192 140))
					(Print 116 23) ; "I'm sorry," says the dark-haired, Italian beauty, "I'm only allowed to accept purchases across the front of this counter!"
				)
				(else
					(self changeState: 7)
				)
			)
		)
		(if (Said 'get/bra')
			(Print 116 24) ; "You don't have $1,500,000!"
		)
		(if (Said 'talk/woman,children,agent')
			(if (or (gEgo has: 4) (gEgo has: 6)) ; Million_Dollar_Bill, Wad_O__Dough
				(Print 116 25) ; "Hey, my little Latino bambino!" you say, "Have I told you I'm now incredibly wealthy?"
				(Print 116 26) ; "You're sure to endear yourself instantly to her with that pseudo-bi-lingualism."
				(Print 116 27) ; "Oh?" she replies, "How many shipping lines do you own?"
				(Print 116 28 #at -1 152) ; "(Ouch.)"
			else
				(Print 116 29) ; ""Hey, baby, you don't look like a California girl!" you tell her."
				(Print 116 30) ; "She successfully ignores you."
			)
		)
	)

	(method (changeState newState &tmp work)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(aClerk
					setLoop: 1
					setMotion: MoveTo 138 106 self
					setCycle: Walk
				)
			)
			(2
				(aClerk setCel: 0)
				(= seconds (Random 10 20))
			)
			(3
				(aClerk setLoop: 3 setCel: 0 setCycle: Fwd cycleSpeed: 2)
				(if (> gMachineSpeed 30)
					(aBigHand setCel: 0 setCycle: Fwd posn: 29 188)
				)
				(= seconds (Random 5 10))
			)
			(4
				(aClerk setLoop: 2 setCel: 0 setCycle: End self cycleSpeed: 0)
				(aBigHand posn: 29 1188)
			)
			(5
				(aClerk
					setLoop: 0
					cycleSpeed: 1
					setMotion: MoveTo 174 106 self
					setCycle: Walk
				)
			)
			(6
				(= state 0)
				(aClerk setCel: 0)
				(= seconds (Random 20 30))
			)
			(7
				(= swimsuitHere (= seconds 0))
				(HandsOff)
				(Print 116 31 #icon 4 0 0) ; "Excuse me, miss," you say hesitantly. "Do you have change for a million?"
				(aBigHand hide:)
				(if (< (= work (gEgo x:)) 138)
					(= work 138)
				)
				(if (> work 174)
					(= work 174)
				)
				(aClerk
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo work 106 self
				)
			)
			(8
				(aClerk setLoop: 2 setCel: 2)
				(Print 116 32 #draw) ; "Bella bueno," she smiles, "but, of course. But, is that trivial, little, clearance item all you are going to purchase today?"
				(= seconds 3)
			)
			(9
				(Print 116 33) ; "Yes, ma'am," you reply, handing over your lottery winnings. "I've only got a million on me!"
				(gEgo put: 4 -1) ; Million_Dollar_Bill
				(= seconds 3)
			)
			(10
				(Print 116 34) ; "All right, that will be $106,500.00 including tax, your change is $893,500.00."
				(= seconds 2)
			)
			(11
				(Print 116 35) ; "That's one hundred dollars..."
				(= seconds 2)
			)
			(12
				(Print 116 36) ; "two hundred dollars..."
				(= seconds 2)
			)
			(13
				(Print 116 37) ; "three hundred dollars..."
				(= seconds 2)
			)
			(14
				(Print 116 38) ; "four hundred dollars..."
				(= seconds 2)
			)
			(15
				(Print 116 39) ; "five hundred dollars..."
				(Print 116 40) ; "STOP! Don't count any more," you shout, "I don't have THAT long before my ship leaves!!"
				(= seconds 2)
			)
			(16
				(Print (Format @gString 116 41 gTritePhrase)) ; "Very well, sir," she concludes. "%s"
				(Print 116 42) ; "How did you know she was going to say that?!"
				(= cycles 6)
			)
			(17
				(Print 116 43) ; "You pocket your new, gigantic wad of hundred-dollar bills."
				(NormalEgo)
				(gEgo get: 6) ; Wad_O__Dough
				(= owesForSwimsuit 0)
				(gGame changeScore: 3)
			)
		)
	)
)

(instance aBigClerk of Prop
	(properties)

	(method (cue)
		(Print 116 44) ; "You find Italian women sexy."
		(Print 116 45 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 273 1059)
		(HandsOn)
	)
)

