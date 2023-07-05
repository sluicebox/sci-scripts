;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm104 0
	StartMC 1
	StopMC 2
)

(local
	aSign
	aCameraMonitor
	aTV
	aMC
	aWheel
	aCameraman
	aLana
	aApplause
)

(procedure (StartMC)
	(aTV setLoop: 7 setCel: 0 cycleSpeed: 0 setCycle: Fwd)
	(aMC setCel: 0 cycleSpeed: 0 setCycle: Fwd)
)

(procedure (StopMC)
	(aMC setCel: 0 stopUpd:)
	(aTV setCel: 0 stopUpd:)
)

(instance mDrumRoll of Sound
	(properties
		number 9
		priority 100
		loop -1
	)
)

(instance mThemeSong of Sound
	(properties
		number 109
		priority 100
		loop -1
	)
)

(instance rm104 of Rm
	(properties
		picture 104
		horizon 1
	)

	(method (init)
		(Load rsVIEW 207)
		(Load rsVIEW 215)
		(Load rsVIEW 212)
		(Load rsVIEW 213)
		(Load rsVIEW 214)
		(Load rsVIEW 216)
		(Load rsSOUND 109)
		(Load rsSOUND 9)
		(super init:)
		(mDrumRoll init:)
		(mThemeSong init:)
		((= aApplause (Prop new:))
			view: 207
			setLoop: 5
			setCel: 0
			setPri: 15
			posn: 156 21
			init:
			stopUpd:
		)
		((= aSign (Prop new:))
			view: 214
			loop: 0
			cel: 0
			posn: 163 55
			priority: 2
			init:
			stopUpd:
		)
		((View new:)
			view: 214
			loop: 1
			cel: 0
			posn: 166 78
			setPri: 2
			ignoreActors:
			addToPic:
		)
		((= aMC (Prop new:))
			view: 207
			loop: 1
			cel: 0
			posn: 164 79
			setPri: 5
			ignoreActors:
			setCycle: Fwd
			init:
		)
		((View new:)
			view: 207
			loop: 0
			cel: 0
			posn: 164 94
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((= aCameraMonitor (Prop new:))
			view: 216
			loop: 0
			posn: 276 6
			setPri: 15
			ignoreActors:
			isExtra: 1
			setCycle: Fwd
			init:
		)
		((= aTV (Prop new:))
			view: 216
			loop: 7
			cel: 0
			posn: 49 52
			setPri: 15
			ignoreActors:
			setCycle: Fwd
			init:
		)
		((= aWheel (Prop new:))
			view: 213
			loop: 0
			cel: 0
			posn: 250 97
			setPri: 9
			ignoreActors:
			stopUpd:
			init:
		)
		((= aCameraman (Act new:))
			view: 212
			loop: 1
			posn: 90 132
			moveSpeed: 1
			cycleSpeed: 1
			init:
		)
		((= aLana (Act new:))
			name: {lana}
			view: 215
			loop: 0
			posn: 19 1092
			ignoreActors:
			setCycle: Walk
			illegalBits: 0
			init:
		)
		(gEgo
			view: 100
			setLoop: -1
			posn: 33 92
			setCycle: Walk
			init:
			illegalBits: 0
		)
		(HandsOff)
		(= gCurrentStatus 18)
		(self setScript: rm104Script)
	)
)

(instance rm104Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent))

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(Print 104 0) ; "Ladies and gentlemen, we've finally found him!" says the master of ceremonies. "Yes, we've found our last Lucky Life Lottery contestant of this week's show!"
				(Print 104 1) ; "And here he is now... Mr. Larry uh," he double-checks the teleprompter, "Laffer? Yeah, Mr. Larry Laffer!"
				(aApplause setCycle: Fwd)
				(= seconds 1)
			)
			(2
				(Print 104 2 #at -1 152) ; "(a little applause)"
				(StopMC)
				(gEgo setMotion: MoveTo 77 92 self)
			)
			(3
				(StartMC)
				(aApplause stopUpd:)
				(gEgo setMotion: MoveTo 99 92 self)
			)
			(4
				(Print 104 3) ; "Mr. Laffer, we don't have time for our normal introductory chit-chat. Just step right up to the wheel and give 'er a big spin!"
				(StopMC)
				(aMC setLoop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 144 98 self)
			)
			(6
				(Print 104 4) ; "Under his breath, the MC admonishes you: "(Hurry up, Laffer! We're already runnin' late because we couldn't find you!)""
				(aCameraman setMotion: MoveTo 222 132 setCycle: Walk)
				(gEgo setMotion: MoveTo 234 101 self)
				(= cycles 30)
			)
			(7
				(aMC setLoop: 1)
				(StopMC)
			)
			(8
				(mDrumRoll play:)
				(= seconds 2)
			)
			(9
				(Print 104 5) ; "Nervously, you reach for the wheel, knowing full well that the pleasure of America's 3-D, graphic, animated, adventure game players is riding on the luck of your pull!"
				(aCameraman stopUpd:)
				(gEgo
					view: 213
					loop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(aWheel cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(aTV setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: Fwd)
			)
			(10
				(gEgo
					view: 100
					loop: 0
					cel: 0
					cycleSpeed: 0
					setMotion: 0
					stopUpd:
				)
				(aTV setLoop: 3 cel: 0 cycleSpeed: 0)
				(= seconds 3)
			)
			(11
				(aWheel cycleSpeed: 1)
				(aTV cycleSpeed: 1)
				(= seconds 2)
			)
			(12
				(aTV setLoop: 4 cycleSpeed: 2)
				(aWheel cycleSpeed: 2)
				(= seconds 2)
			)
			(13
				(aWheel cycleSpeed: 4)
				(aTV cycleSpeed: 4)
				(= seconds 2)
			)
			(14
				(aTV setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End)
				(aWheel stopUpd:)
				(mDrumRoll dispose:)
				(mThemeSong play:)
				(aSign setCycle: Fwd)
				(aApplause setCycle: Fwd)
				(= seconds 4)
			)
			(15
				(StartMC)
				(gGame changeScore: 12)
				(= seconds 1)
			)
			(16
				(Print 104 6) ; "He did it! HE DID IT! He's won the big one!! Ladies and gentlemen, Larry Laffer just won the largest prize in the history of the Lottery -- a million dollars a year for life!!"
				(Print 104 7 #at -1 152) ; "(applause)"
				(Print 104 8 #at -1 152) ; "(tons o' applause)"
				(= seconds 3)
			)
			(17
				(Print 104 9) ; "Come on over here, Lucky Larry."
				(gEgo setCycle: Walk setMotion: MoveTo 149 98 self)
				(StopMC)
				(aTV setLoop: 5 setCycle: Fwd)
				(aCameraman setMotion: MoveTo 161 132)
			)
			(18
				(aApplause stopUpd:)
				(aSign stopUpd:)
				(aCameraman stopUpd:)
				(gEgo setMotion: MoveTo 149 95)
				(aTV setLoop: 6 stopUpd:)
				(aMC setLoop: 4 cel: 0 setCycle: End self)
				(Print 104 10 #draw) ; "Here comes lovely Lanna Light, the Lucky Life Lottery lady, with Larry Laffer's first year's winnings: the U. S. Treasury Department's first one million dollar bill!"
			)
			(19
				(aMC setLoop: 1 forceUpd:)
				(StopMC)
				(aLana posn: 19 92 setMotion: MoveTo 82 92 self)
			)
			(20
				(aLana setMotion: MoveTo 117 94 self)
				(gEgo loop: 1 stopUpd:)
			)
			(21
				(aLana setLoop: 1 setCel: 0 setCycle: 0)
				(gEgo setCycle: 0)
				(aCameraman setMotion: MoveTo 161 132)
				(= seconds 2)
			)
			(22
				(Print 104 11) ; ""On behalf of the Lucky Life Lottery, I'm pleased to present you our Grand Prize, one million dollars!" says the MC."
				(aLana setCel: 0 cycleSpeed: 1 setCycle: End)
				(gEgo
					view: 215
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(23
				(aLana stopUpd:)
				(gGame changeScore: 7)
				(gEgo get: 4) ; Million_Dollar_Bill
				(= seconds 3)
			)
			(24
				(Print 104 12) ; "Congratulations, Mr. Laffer," says the MC, "you're a lucky man! Too bad we don't have time for a speech!"
				(gEgo hide:)
				(aMC setLoop: 2 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(25
				(aMC setLoop: 1)
				(gEgo view: 100 loop: 0 show:)
				(StartMC)
				(= seconds 3)
			)
			(26
				(StopMC)
				(Print 104 13 #draw) ; "Let's hear it for him, ladies and gentlemen: Mr. Larry Laffer, the luckiest guy in Los Angeles!!"
				(Print 104 14 #at -1 152) ; "(even more applause)"
				(aTV setLoop: 5 setCycle: Fwd)
				(= seconds 3)
			)
			(27
				(Print 104 15) ; "The voiceover announcer says, "That's it for this week's show; be sure to tune in next time for the 'Lucky Life Lottery' show, live from Hollywood!""
				(Print 104 16) ; "Good night."
				(aTV setLoop: 6 setCycle: Fwd)
				(aSign setCycle: Fwd)
				(= seconds 5)
			)
			(28
				(mThemeSong stop:)
				(aSign stopUpd:)
				(aTV setLoop: 8)
				(Print 104 17 #draw) ; "The control room talkback speaker crackles, "Ok, kids, there's another one that's good enough for who it's for!""
				(Print 104 18) ; "Mr. Laffer, please exit through the door to the left; there will be plenty of reporters and photographers waiting for you!"
				(= seconds 2)
			)
			(29
				(gEgo
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 18 112 self
				)
			)
			(30
				(gEgo setMotion: MoveTo -12 112 self)
			)
			(31
				(Print 104 19) ; "Gee, Larry, things are finally beginning to go your way! First, you win a month-long ocean voyage with the lovely bachelorette, and now you win the biggest lottery prize in history."
				(= seconds 2)
			)
			(32
				(Print 104 20 #at -1 152) ; "(Something tells you this is too good to last!)"
				(gCurRoom newRoom: 101)
			)
		)
	)
)

