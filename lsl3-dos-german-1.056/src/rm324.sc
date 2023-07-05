;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use FileSelector)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm324 0
)

(local
	talkCount
	humpCount
)

(instance rm324 of Rm
	(properties
		picture 323
	)

	(method (init)
		(Load rsVIEW 327)
		(Load rsVIEW 328)
		(Load rsSOUND 20)
		(Load rsSOUND 8)
		(Load rsSOUND 9)
		(Load rsSOUND 11)
		(Load rsSCRIPT 991)
		(Load rsPIC 99)
		(super init:)
		(gAddToPics add: atpProps doit:)
		(aSuzi init:)
		(aChair init:)
		(aDoorNorth init:)
		(aDoorSouth init:)
		(aPhone init:)
		(aTrapdoor init:)
		(self setScript: RoomScript)
		(= gEgoState 11)
		(= gNormalEgoView 708)
		(NormalEgo 0)
		(gEgo posn: 41 156 illegalBits: 0 init:)
		(HandsOff)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(= cycles 22)
			)
			(1
				(Print 324 0) ; "I'm back, Ms. Cheatem," you say. "And I'd like my divorce papers."
				(= seconds 3)
			)
			(2
				(Print 324 1) ; "Suzi's eyes widen as she spies your new outfit, "Ohhhhhhh, Larry! I had no idea you enjoyed cross-dressing too!""
				(Print 324 2 #at -1 144) ; "(What does she mean, "too?")"
				(= seconds 3)
			)
			(3
				(Print 324 3) ; ""You know, nothing turns me on like wearing mens' underwear!" she cries."
				(= seconds 3)
			)
			(4
				(Print 324 4) ; "You are stunned. You had no idea. Dazed, you head for the sofa."
				(gEgo
					ignoreActors:
					illegalBits: 0
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo (+ 40 (gEgo x:)) (gEgo y:) self
				)
			)
			(5
				(gEgo setMotion: MoveTo 115 134 self)
			)
			(6
				(Print 324 5) ; "Yes, yes," Suzi says, "do sit down, Mr. Laffer. Make yourself comfortable, Larry. You wouldn't mind if I called you Larry, would you?"
				(gEgo loop: 2)
				(aSuzi
					view: 327
					setPri: -1
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 232 125 self
				)
				(aChair view: 329 posn: 247 133 setLoop: 3 stopUpd:)
			)
			(7
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(8
				(Print 324 6) ; "No, Larry is fine, I suppose."
				(aSuzi setMotion: MoveTo 190 141 self)
			)
			(9
				(aSuzi setMotion: MoveTo 47 156 self)
				(= cycles 27)
			)
			(10
				(Print 324 7) ; "Allow me to assure our confidentiality, Larry," says Ms. Cheatem. "I hate for anyone to violate the privacy of my `attorney-client' relationships!"
			)
			(11
				(aDoorNorth setCycle: Beg)
				(aDoorSouth setCycle: Beg self)
				(gMusic fade:)
			)
			(12
				(gSoundFX number: 11 loop: 1 play:)
				(aDoorNorth stopUpd:)
				(aDoorSouth stopUpd:)
				(Print 324 8) ; ""Would you mind if I slip out of this hat?" you ask her."
				(aSuzi setMotion: MoveTo (+ 15 (gEgo x:)) 156 self)
			)
			(13
				(Print 324 9) ; ""Feel free to slip out of whatever you wish," Suzi replies."
				(aSuzi setMotion: MoveTo 148 133 self)
			)
			(14
				(Print 324 10) ; "You carefully remove the gigantic feathered hat from your head and place it at your feet. You may have come here expecting a divorce, but it looks like you're going to get more than `legalese'!"
				(gEgo
					cycleSpeed: 1
					setPri: 8
					view: 322
					cel: 0
					setCycle: End self
				)
				(aSuzi loop: 1)
				(gAddToPics add: atpHat doit:)
			)
			(15
				(Print 324 11) ; ""And now, it's time for me to get comfortable too," says Suzi."
				(= seconds 3)
			)
			(16
				(aSuzi
					cycleSpeed: 2
					view: 328
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(gMusic number: 8 loop: -1 play:)
			)
			(17
				(= seconds 3)
			)
			(18
				(Print 324 12) ; "So," says Suzi, "how do you like women in men's undergarments?"
				(= seconds 3)
			)
			(19
				(Print 324 13) ; "You reply, "Actually, I think I'd love you in mine!""
				(= seconds 3)
			)
			(20
				(Print 324 14) ; "Enough of this legalistic foreplay, Larry," she says. "What do you say we spend the rest of the afternoon `going through your briefs!'"
				(SetFlag 45)
				(gGame changeScore: 100)
				(aSuzi hide:)
				(gEgo
					view: 328
					setLoop: 2
					setCel: 0
					cycleSpeed: 3
					posn: 123 118
				)
				(gAddToPics add: atpSuziClothes doit:)
				(= cycles 22)
			)
			(21
				(gEgo setCycle: End self)
			)
			(22
				(= seconds 3)
			)
			(23
				(gEgo setCycle: Beg self)
			)
			(24
				(gEgo
					viewer: humpCycler
					posn: 123 118
					setLoop: 3
					setCycle: Fwd
				)
				(= cycles 0)
				(= seconds 3)
			)
			(25
				(if (> (++ humpCount) 1)
					(self cue:)
				else
					(aTrapdoor setMotion: MoveTo 152 6 self)
				)
			)
			(26
				(gMusic stop:)
				(gSoundFX number: 20 loop: -1 play:)
				(aPhone
					view: 323
					setPri: 13
					setStep: 1 1
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 146 6 self
				)
			)
			(27
				(gEgo viewer: 0 setCel: 0)
				(if (== humpCount 1)
					(Print 324 15) ; "Hey, Suzi!" you cry. "What's that?"
				)
				(= seconds 3)
			)
			(28
				(switch humpCount
					(1
						(Print 324 16) ; "Excuse me for a just a moment please; I seem to have a telephone call. May I put you on hold?"
					)
					(2
						(Print 324 17) ; "Oh, no," says Suzi. "I suppose I could have Roger hold my calls."
						(Print 324 18 #at -1 144) ; "(It would be nice if someone got to hold something around here!)"
					)
					(3
						(Print 324 19) ; "Not again!" cries Suzi. "I'm just SO busy!"
					)
					(4
						(Printf 324 20 global304 global305) ; ""%s" you cry. "If you're this busy, why don't I come again later!"%"
						(Print 324 21 #at -1 144) ; "(And you do mean that figuratively!)"
					)
				)
				(= cycles 12)
			)
			(29
				(aSuzi
					cycleSpeed: 0
					setLoop: 4
					cel: 0
					posn: 133 117
					setPri: 9
					setCycle: End self
					show:
				)
			)
			(30
				(aSuzi setLoop: 5 cel: 0 setCycle: End self)
				(aPhone setLoop: 6 setCel: 1 stopUpd:)
				(gSoundFX stop:)
				(= talkCount 0)
			)
			(31
				(aSuzi setLoop: 6 setCycle: Fwd)
				(if (== humpCount 4)
					(self changeState: 51)
				else
					(= cycles (Random 11 33))
				)
			)
			(32
				(aSuzi setCel: 1)
				(= cycles (Random 5 11))
				(if (> 3 (++ talkCount))
					(= state 30)
				)
			)
			(33
				(aSuzi setLoop: 5 setCel: 255 setCycle: Beg self)
			)
			(34
				(Print 324 22) ; "Now, dear," Suzi says to you, "where were we?"
				(aPhone setCel: 0 stopUpd:)
				(if (== humpCount 1)
					(aPhone setMotion: MoveTo (aPhone x:) -111)
				)
				(aSuzi setLoop: 4 setCel: 255 setCycle: Beg self)
				(gMusic number: 8 loop: -1 play:)
			)
			(35
				(aSuzi hide:)
				(gEgo viewer: humpCycler setCycle: Fwd)
				(= seconds 2)
			)
			(36
				(switch humpCount
					(1
						(Print 324 23) ; "You think to yourself, "I've had lawyers do this to me before, but this is the first time...""
						(self changeState: 24)
					)
					(2
						(Print 324 24) ; "Oh, no!" says Suzi. "I'd better write myself a note before that conversation slips my mind."
						(Print 324 25 #at -1 144) ; "(It would be nice if something started slipping around here!)"
					)
					(3
						(Print 324 26) ; "You've had just about all of this you can take!"
					)
				)
				(= seconds 2)
			)
			(37
				(gEgo viewer: 0 setCel: 0)
				(aSuzi setLoop: 4 cel: 0 setCycle: End self show:)
			)
			(38
				(aSuzi setLoop: 7 cel: 0 setCycle: End self)
				(aPhone setCel: 2 stopUpd:)
			)
			(39
				(aSuzi setLoop: 8 setCycle: Fwd)
				(= seconds 4)
			)
			(40
				(aSuzi setLoop: 7 setCel: 255 setCycle: Beg self)
			)
			(41
				(aSuzi setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(42
				(Print 324 27) ; "There. All done."
				(aPhone setLoop: 6 setCel: 0 setMotion: MoveTo (aPhone x:) -111)
				(if (< humpCount 3)
					(self changeState: 24)
				else
					(= seconds 2)
				)
			)
			(43
				(Print 324 28) ; "Oh, wait!" she says, "I'd better fax Roger a memo about that last conversation!"
				(= seconds 3)
			)
			(44
				(aSuzi setLoop: 9 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(45
				(gEgo viewer: humpCycler setCycle: Fwd)
				(aSuzi
					view: 323
					setLoop: 5
					setCel: 0
					posn: 141 102
					setPri: 15
					setStep: 4 4
					setMotion: MoveTo 215 74 self
				)
			)
			(46
				(aSuzi setCel: 1 setMotion: JumpTo 289 121 self)
			)
			(47
				(aSuzi setCel: 2 setStep: 5 5 setMotion: MoveTo 221 189 self)
			)
			(48
				(aSuzi setMotion: MoveTo 177 233 self)
			)
			(49
				(= seconds 2)
			)
			(50
				(aSuzi
					view: 328
					setLoop: 4
					cel: 0
					posn: 133 117
					setPri: 9
					hide:
				)
				(= seconds 2)
				(= state 23)
			)
			(51
				(PrintSplit 324 29) ; "Suzi covers the phone with her hand and whispers to you, "Sure, ok, good idea. Call me any time. As soon as I prepare your divorce papers, you may pick them up from Roger, my secretary. We must get together again soon. From what I've seen of you, I'd love to try to squeeze you into my...""
				(Print 324 30) ; "...agenda!"
				(gMusic number: 9 loop: 1 play:)
				(= gLawyerState 6)
				(= cycles 22)
			)
			(52
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= cycles 22)
			)
			(53
				(Print 324 31) ; "Wriggling your way out of her grasp, you grab your tall feathered hat from the floor and slip out her office door. The problem is: Suzi's docket is just too full!"
				(Print 324 32) ; "(Poor Larry. You've just experienced the agony of "clientus interruptus!")"
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance atpProps of PV
	(properties
		y 132
		x 240
		view 329
		loop 4
		priority 10
		signal 16384
	)
)

(instance atpHat of PV
	(properties
		y 138
		x 115
		view 328
		loop 1
		priority 14
		signal 16384
	)
)

(instance atpSuziClothes of PV
	(properties
		y 133
		x 148
		view 323
		loop 7
		priority 14
		signal 16384
	)
)

(instance aChair of Prop
	(properties
		y 133
		x 247
		view 329
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 4 stopUpd:)
	)
)

(instance aSuzi of Act
	(properties
		y 120
		x 242
		view 324
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: illegalBits: 0 setPri: 13 stopUpd:)
	)
)

(instance aPhone of Act
	(properties
		y -111
		x 146
		view 323
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			setLoop: 3
			setPri: 13
			setStep: 1 1
			setCycle: Fwd
		)
	)
)

(instance aTrapdoor of Act
	(properties
		y -4
		x 152
		view 323
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: setLoop: 4 setPri: 5 setStep: 1 1)
	)
)

(instance aDoorSouth of Prop
	(properties
		y 103
		x 20
		view 323
	)

	(method (init)
		(super init:)
		(self setCel: 255 setPri: 13 ignoreActors: stopUpd:)
	)
)

(instance aDoorNorth of Prop
	(properties
		y 95
		x 41
		view 323
		loop 1
	)

	(method (init)
		(super init:)
		(self setCel: 255 setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance humpCycler of Code
	(properties)

	(method (doit)
		(if (not (Random 0 9))
			(gEgo cycleSpeed: (Random 0 5))
		)
	)
)

