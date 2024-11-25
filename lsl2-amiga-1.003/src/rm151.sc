;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm151 0
)

(local
	talkedToBarber
)

(instance rm151 of Rm
	(properties
		picture 125
		horizon 5
		south 51
	)

	(method (init)
		(Load rsVIEW 507)
		(Load rsVIEW 232)
		(super init:)
		(aChair posn: 167 116 setPri: 8 init:)
		(aBarber setCycle: Walk illegalBits: $8000 init:)
		(aBigFace view: 507 setLoop: 9 posn: 36 1117 setPri: 15 init:)
		(NormalEgo 3)
		(gEgo posn: 160 159 init:)
		(self setRegions: 7 500 setScript: rm151Script) ; rm7, rm500
	)
)

(instance rm151Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 51)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
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
					(Print 151 0) ; "Walk over to the front of the barber's chair and sit down."
				)
				((!= gCurrentEgoView 149)
					(Print 151 1) ; "I'm sorry, sir," says the barber sweetly, "I have no more appointments left today!"
				)
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				(else
					(= gBlondHair 0)
					(self changeState: 2)
				)
			)
		)
		(if (Said 'look/man,woman,children')
			(aBigFace posn: 36 117 stopUpd:)
			(if (not gScoredRosella)
				(= gScoredRosella 1)
				(gGame changeScore: 3)
			)
			(Timer setReal: aBigFace 5)
			(HandsOff)
		)
		(if (Said 'talk/man,children,woman')
			(= talkedToBarber 1)
			(if (== gCurrentEgoView 100)
				(Print 151 2) ; "You look much better to me, sir!"
			else
				(Print 151 3) ; ""Just have a seat in the chair there," responds the barber."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((gInventory at: 21) ownedBy: gCurRoomNum) ; Hair_Rejuvenator
					(= seconds 10)
				)
			)
			(1
				(if (not talkedToBarber)
					(Print 151 4) ; "Good day, sir," says the female barber with the long, beautiful, blond hair. "May I help you in your quest?"
					(= seconds (Random 12 25))
					(= state 0)
				)
			)
			(2
				(= seconds (= cycles 0))
				(= gCurrentStatus 1009)
				(HandsOff)
				(Print 151 5) ; ""Could I just get a slight trim?" you ask. "My hair is ridiculously long!"
				(Print 151 6) ; "Oh, oh!" she replies, "I'll be happy to. Just plop it in my chair there, Goldilocks, I'll take care of those curly locks for you!"
				(Print 151 7) ; "Gosh, please be careful," you tell her, "I'd hate to lose my full head of hair. Just take a little off the back!"
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 157 120 self
				)
				(aBarber setMotion: MoveTo 185 119 self)
			)
			(3
				(gEgo hide:)
				(aChair view: 507 setLoop: 8 setCel: 255 setCycle: Beg)
			)
			(4
				(aBarber setMotion: MoveTo 179 113 self)
			)
			(5
				(aBarber
					setMotion: MoveTo 169 113 self
					illegalBits: 0
					ignoreActors:
				)
			)
			(6
				(aChair view: 507 setLoop: 4 setCycle: 0)
				(aBarber
					view: 507
					setLoop: 5
					posn: 165 86
					setCel: 0
					setCycle: End self
					setPri: 9
				)
			)
			(7
				(aChair stopUpd:)
				(aBarber setLoop: 6 cycleSpeed: 1 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(aBarber setLoop: 7 cel: 0 setCycle: End self)
			)
			(9
				(aChair view: 232 setLoop: 2 setCel: 255)
				(aBarber
					loop: 2
					setLoop: -1
					setPri: 7
					posn: 169 112
					setCycle: Walk
					ignoreActors: 0
				)
				(Print 151 8 #at -1 20 #draw) ; "All done," says the barber. "What do you think?"
				(= seconds 3)
			)
			(10
				(Print 151 9 #at -1 20) ; "MY HAIR!" you cry. "IT'S GONE!"
				(Print 151 10 #at -1 20) ; "She replies, "It serves you right; you should never trust a barber with longer, prettier, blonder hair than yours!""
				(= seconds 3)
			)
			(11
				(aChair setCycle: Beg self)
			)
			(12
				(= gCurrentEgoView 100)
				(gEgo view: 100 setLoop: -1 loop: 3 ignoreActors: 0 show:)
				(aChair view: 232 loop: 1 cel: 0)
				(= seconds 2)
			)
			(13
				(aChair stopUpd:)
				(aBarber stopUpd:)
				(Print 151 11 #draw) ; "Well, at least I look like my passport picture now," you sigh, "although that seems small consolation."
				(Print 151 12) ; "I'm sorry you're not satisfied," says the barber. "Here. Take a bottle of this month's special. When you have time, rub a teaspoon on your hair every day for a month. Soon your hair will be full and rich."
				(Print (Format @gString 151 13 gTritePhrase)) ; "But be careful," she concludes, "it's highly inflammatory. %s"
				(NormalEgo)
				(gGame changeScore: 3)
				(gEgo get: 21 setMotion: MoveTo 157 222 self) ; Hair_Rejuvenator
			)
		)
	)
)

(instance aBigFace of Prop
	(properties)

	(method (cue)
		(Print 151 14) ; "You find Daventry women sexy."
		(Print 151 15 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 36 1117)
		(Print 151 16 #at -1 20 #draw) ; ""By the way, have you played 'King's Quest IV' yet?" asks the barber."
		(Print 151 17) ; "Why, no, I haven't," you reply. "Is it good?"
		(Print 151 18 #at -1 20) ; "Well, I certainly think so," she concludes, "maybe it's just me!"
		(HandsOn)
	)
)

(instance aChair of Prop
	(properties
		view 232
		loop 1
		signal 16384
	)
)

(instance aBarber of Act
	(properties
		y 152
		x 144
		view 507
		loop 2
	)
)

