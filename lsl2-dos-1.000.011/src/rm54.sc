;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Door)
(use Airplane)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm54 0
)

(local
	bagNumber
	aPlane
	aBag
	aDoor
	aTraveler
)

(instance theSound of Sound
	(properties
		number 5
		loop -1
	)
)

(instance rm54 of Rm
	(properties
		picture 54
		horizon 5
		east 55
		west 53
	)

	(method (init)
		(Load rsVIEW 515)
		(Load rsVIEW 516)
		(super init:)
		((View new:)
			view: 516
			loop: 0
			cel: 0
			posn: 109 158
			setPri: 12
			addToPic:
		)
		(if ((gInventory at: 22) ownedBy: gCurRoomNum) ; Suitcase
			(Load rsVIEW 155)
			(Load rsSOUND 5)
			(Load rsFONT 7)
			(theSound init:)
			((= aBag (Act new:))
				view: 515
				setLoop: 0
				setCel: 0
				setPri: 5
				setStep: 2 1
				posn: 90 124
				illegalBits: 0
				ignoreActors:
				init:
				hide:
				setScript: bagScript
			)
		)
		((= aPlane (Airplane new:))
			view: 511
			setCel: 0
			startX: 306
			startY: 22
			endX: 222
			endY: 22
			init:
		)
		((= aTraveler (Act new:))
			view: 515
			setLoop: 3
			setPri: 2
			setStep: 1 1
			setCycle: Walk
			posn: 230 37
			illegalBits: 0
			ignoreActors:
			init:
			hide:
		)
		(cond
			((== gPrevRoomNum 53)
				(gEgo posn: 1 155)
			)
			((== gPrevRoomNum 55)
				(gEgo posn: 316 155)
			)
			(else
				(gEgo posn: 316 155)
			)
		)
		(NormalEgo)
		(gEgo init:)
		((= aDoor (AutoDoor new:))
			view: 515
			setLoop: 2
			posn: 15 157
			setPri: 11
			doorCtrl: 2
			doorBlock: 16384
			roomCtrl: 0
			msgLook:
				{The low blue gate leads back to the Customs Inspection area.}
			msgFunny: {Knock. Knock. (No one's there!)}
			init:
		)
		(self setRegions: 500 setScript: rm54Script) ; rm500
	)
)

(instance rm54Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and (not (gEgo has: 22)) (Said 'look/bag,baggage')) ; Suitcase
			(Print 54 0) ; "Luggage passes by on the nearby conveyor belt."
		)
		(if (Said 'look>')
			(if (Said '/belt,baggage,bag,belt')
				(Print 54 1) ; "Conveyors carrying luggage stretch off into the distance."
			)
			(if (Said '/man,cop')
				(Print 54 2) ; "He's sound asleep. Shhh! Don't wake him."
			)
			(if (Said '/art')
				(Print 54 3) ; "Gawd, is that symbolic, or what?!"
				(if (> gFilthLevel 10)
					(Print 54 4 #at -1 152) ; "(You fondly recall an old joke about a girl and her cherry.)"
				)
			)
			(if (Said '[/airport]')
				(Print 54 5) ; "A security guard snoozes beside his X-ray machine, allowing baggage to pass by uninspected."
			)
		)
		(if (or (Said 'awaken<up') (Said 'awaken,lagoon,hit,talk/man,cop'))
			(Print 54 6) ; "Zzzzzzz."
		)
		(if (Said 'carry,(get<up),get/bag,baggage')
			(cond
				((not ((gInventory at: 22) ownedBy: gCurRoomNum)) ; Suitcase
					(Print 54 7) ; "Where?"
				)
				((not (& (gEgo onControl:) $0008))
					(NotClose) ; "You're not close enough."
				)
				((> (gEgo distanceTo: aBag) 23)
					(Print 54 8) ; "You missed!"
				)
				(else
					(aBag hide:)
					(if (and (!= bagNumber 0) (!= bagNumber 8))
						(Print 54 9 #at -1 20 #draw) ; "You nimbly grab someone's suitcase from the moving belt, force it open, and discover inside..."
					)
					(switch bagNumber
						(0
							(Print 54 10) ; "Paul is dead."
						)
						(1
							(Print 54 11) ; "...a disassembled hunting rifle. You decide it is of no use to you."
						)
						(2
							(Print 54 12) ; "...some dirty underwear."
						)
						(3
							(Print 54 13) ; "...a dead cat."
							(Print 54 14) ; "YUCK!"
						)
						(4
							(Print 54 15) ; "...a pair of maces. You decide they are of no use to you."
						)
						(5
							(Print 54 16) ; "...a Tommy gun in a violin case. You decide it is of no use to you."
						)
						(6
							(Print 54 17) ; "...nothing of interest."
						)
						(7
							(Print 54 18) ; "...a computer. Searching through the disk storage box within, you discover a complete set of Sierra adventure games. You decide they are of no use to you."
							(Print 54 19) ; "...because you're having plenty of trouble with THIS game!"
						)
						(8
							(Print 54 20) ; "John 3:16"
						)
						(9
							(Print 54 17) ; "...nothing of interest."
						)
						(10
							(Print 54 21) ; "...some blue, pin-striped suits. You decide they are of no use to you."
						)
						(11
							(Print 54 22) ; "...a fully-automatic machine gun and some clips of ammo. You realize you have no use for this until you purchase "Police Quest II, The Vengeance.""
						)
						(12
							(self changeState: 1)
							(return)
						)
					)
					(Print 54 23 #at -1 20) ; "You sheepishly close it, return it to the conveyor, and wonder if anyone noticed you."
					(aBag show:)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gGame changeScore: 5)
				(aBag dispose:)
				(bagScript dispose:)
				(theSound play:)
				(Print 54 24 #at -1 20 #width 222 #font 7) ; "A BOMB!!"
				(gEgo get: 22) ; Suitcase
				(= gBombStatus 1)
				(HandsOff)
				(gEgo view: 155 setLoop: 1)
				(Print 54 25 #draw) ; "Let's see now," you think, "I'm holding a suitcase containing a ticking bomb. What shall I do?"
				(= seconds 3)
			)
			(2
				(Print 54 26) ; ""Say," you decide. ""I think I'll get this thing outside... and FAST!"
				(gEgo setMotion: MoveTo (gEgo x:) 154 self)
			)
			(3
				(gEgo
					setStep: 4 3
					setCycle: Walk
					setMotion: MoveTo 0 154 self
				)
			)
		)
	)
)

(instance travelerScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aTraveler posn: 230 37 show: setMotion: MoveTo 291 37 self)
			)
			(2
				(aTraveler setLoop: (if (== (aTraveler loop:) 3) 4 else 3))
				(self changeState: 0)
			)
		)
	)
)

(instance bagScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBag
					posn: 90 124
					setCel: bagNumber
					setLoop: 0
					show:
					setMotion: MoveTo 152 124 self
				)
			)
			(1
				(aBag setLoop: 1 setMotion: MoveTo 303 124 self)
			)
			(2
				(if (> (++ bagNumber) 12)
					(= bagNumber 0)
				)
				(aBag hide:)
				(self changeState: 0)
			)
		)
	)
)

