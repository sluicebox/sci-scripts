;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm37 0
)

(local
	work
	aBarber
	aChair
	talkedToBarber
)

(instance rm37 of Rm
	(properties
		picture 125
		south 31
	)

	(method (init)
		(Load rsVIEW gCurrentEgoView)
		(Load rsVIEW 232)
		(Load rsVIEW 303)
		(Load rsVIEW 302)
		(super init:)
		((= aChair (View new:))
			view: 232
			loop: 1
			cel: 0
			posn: 164 118
			setPri: 8
			ignoreActors:
			stopUpd:
			init:
		)
		((= aBarber (Act new:))
			view: 303
			setLoop: 0
			posn: 134 145
			setCycle: Walk
			observeControl: 16384 -32768
			moveSpeed: 6
			cycleSpeed: 3
			setMotion: Wander
			init:
		)
		(NormalEgo)
		(gEgo posn: 160 159 init:)
		(self setRegions: 7 300 setScript: rm37Script) ; rm7, rm300
	)
)

(instance rm37Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(if (== gCurrentEgoView 133)
				(if (< state 18)
					(self changeState: 18)
				)
			else
				(gCurRoom newRoom: 31)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/cup,cup,lagoon,water')
				(Print 37 0) ; "You can't see any from here."
			)
			(if (Said '/up,overhead')
				(Print 37 1) ; "You love the warm glow of florescent lights."
			)
			(if (Said '[/craft,cloud]')
				(Print 37 2) ; "Don't all barber shops look alike?"
			)
			(if (Said '/man')
				(Print 37 3) ; "He looks friendly enough."
			)
		)
		(if
			(or
				(Said 'bath,fix,yes,cut')
				(Said '(get<in)/barstool')
				(Said 'get/haircut,(cut<hair)')
			)
			(= talkedToBarber 1)
			(cond
				((not (gEgo inRect: 148 117 180 127))
					(Print 37 4) ; "Walk over to the front of the barber's chair and sit down."
				)
				((not ((gInventory at: 14) ownedBy: gCurRoomNum)) ; Wig
					(Print 37 5) ; "I'm sorry, Mister," says the barber rudely, "I have no more appointments left today!"
					(Print 37 6) ; "In fact, I'd appreciate it if you'd leave now before I have to call the Ship Police!"
				)
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				(else
					(self changeState: 2)
				)
			)
		)
		(if (Said 'talk/man')
			(= talkedToBarber 1)
			(if (not ((gInventory at: 14) ownedBy: gCurRoomNum)) ; Wig
				(Print 37 7) ; "You look much better to me, monsieur!"
			else
				(Print 37 8) ; "I have no time for idle conversation," responds the barber. "It's bad enough I have to talk to customers while I cut their hair, I certainly don't want to talk when I'm NOT cutting hair!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((gInventory at: 14) ownedBy: gCurRoomNum) ; Wig
					(= seconds 10)
				)
			)
			(1
				(if (not talkedToBarber)
					(Print 37 9) ; "Good day, Mister," says the barber. "May I help you?"
					(= seconds (Random 12 25))
					(= state 0)
				)
			)
			(2
				(= seconds (= cycles 0))
				(HandsOff)
				(Print 37 10 #at -1 20) ; ""Is there anything you can do for this hairline of mine," you ask the barber."
				(Print 37 11 #at -1 20) ; "But, of course, Mister," says the barber, "I've got exactly what you need."
				(Print 37 12 #at -1 20) ; "Just have a seat in the chair, please."
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 157 120 self
				)
				(aBarber
					setLoop: 1
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: End
					setMotion: 0
				)
			)
			(3
				(aChair hide:)
				(gEgo
					view: 232
					setLoop: 2
					cel: 0
					posn: 167 115
					setCycle: End self
				)
			)
			(4
				(aBarber setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(aBarber setLoop: 3 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(aBarber
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 166 117 self
					illegalBits: 0
				)
			)
			(8
				(aBarber setLoop: 5 setCycle: End self)
				(Print 37 13 #at -1 20 #draw) ; "Yes, I have exactly what you need," he tells you. "It's all the rage; the latest thing. You see it everywhere these days. In fact, guys make a lot of money with one of these!"
				(Print 37 14 #at -1 20) ; "I call it 'The Jimmy' model, and I'm sure you'll like it just fine!"
			)
			(9
				(aBarber setLoop: 6 setCycle: Fwd)
				(Print 37 15 #at -1 20 #draw) ; "He places "The Jimmy" carefully on your head."
				(= seconds 4)
			)
			(10
				(aBarber setLoop: 7 setCycle: End self)
			)
			(11
				(aBarber setLoop: 8 setCycle: Fwd)
				(= seconds 4)
			)
			(12
				(gEgo view: 302 setLoop: 0 cel: 0)
				(aBarber setLoop: 9 setCycle: CT 6 1 self)
			)
			(13
				(aBarber setCycle: End self setMotion: MoveTo 176 118)
			)
			(14
				(Print 37 16 #at -1 20) ; "Impeccable fit!" he cries, "And (for you) the price is right -- only $10,000.00!! But I like to consider it more of an investment than an expense!"
				(Print 37 17 #at -1 152) ; "(10K for a wig?)"
				(if (> gFilthLevel 4)
					(Print 37 18 #at -1 20) ; "Oh, what the hell -- it's not like it's your money; why not let those suckers who paid for all those Luck-o Buck-o tickets treat you to a new look!"
				else
					(Print 37 19 #at -1 20) ; "Oh, well, it's not like it's your money; why not let those suckers who paid for all those Luck-o Buck-o tickets treat you to a new look!"
				)
				(Print 37 20 #at -1 20) ; ""I'll take it," you tell him, and peel off a hundred hundreds from your rapidly depleting wad."
				(gEgo get: 14) ; Wig
				(gGame changeScore: 3)
				(= seconds 3)
			)
			(15
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(16
				(gEgo posn: 159 119)
				(= gCurrentEgoView 133)
				(NormalEgo 3)
				(aChair show:)
				(HandsOff)
				(= seconds 3)
			)
			(17
				(gEgo setMotion: MoveTo 159 199 self)
			)
			(18
				(Print (Format @gString 37 21 gTritePhrase)) ; "The barber bids you farewell with a sweet, "%s""
				(HandsOff)
				(gEgo setLoop: 3)
				(= cycles 20)
			)
			(19
				(Print 37 22 #at -1 20) ; "You catch a good look at yourself in the mirror and slip the wig into your inner jacket pocket. You tell the barber, "Thanks a lot, but I think I'll just save this until my cable channel application is approved!""
				(gEgo
					view: 302
					cycleSpeed: 2
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(20
				(= gCurrentEgoView 100)
				(NormalEgo 2)
			)
		)
	)
)

