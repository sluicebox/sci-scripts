;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 365)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm365 0
)

(procedure (PrintBambi)
	(gSystemWindow color: 12 back: 8)
	(Print &rest #at 195 20 #title {Bambi says} #width 115)
	(gSystemWindow color: 0 back: 8)
)

(procedure (PrintLarry)
	(gSystemWindow color: 9 back: 8)
	(Print &rest #at 10 111 #title {You say} #width 150)
	(gSystemWindow color: 0 back: 8)
)

(instance rm365 of Rm
	(properties
		picture 365
	)

	(method (init)
		(Load rsVIEW 366)
		(Load rsVIEW 725)
		(Load rsPIC 366)
		(Load rsPIC 99)
		(Load rsSOUND 11)
		(Load rsSOUND 365)
		(Load rsSOUND 8)
		(Load rsSOUND 9)
		(Load rsSOUND 261)
		(super init:)
		(SetFlag 52)
		(HandsOff)
		(SL disable:)
		(gTheMenuBar hide: state: 0)
		(aDoor init:)
		(aLid init:)
		(aBambi init:)
		(gAddToPics add: atpBed doit:)
		(self setScript: RoomScript)
		(gEgo
			view: 365
			loop: 3
			cel: 0
			setCycle: Walk
			illegalBits: 0
			posn: 115 112
			ignoreActors:
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aDoor setCycle: End self)
			)
			(2
				(gMusic stop:)
				(gSoundFX number: 11 loop: 1 play:)
				(aBambi cel: 1)
				(gEgo cel: 1)
				(aDoor stopUpd:)
				(= seconds 3)
			)
			(3
				(PrintBambi 365 0) ; "Here's a nice quiet spot where I'm sure we won't be disturbed. This old tanning machine has been broken since the late eighties."
				(= seconds 3)
			)
			(4
				(aBambi view: 393 setLoop: 1 setMotion: MoveTo 180 110 self)
			)
			(5
				(aBambi setLoop: 4 cel: 0 stopUpd:)
				(= seconds 3)
			)
			(6
				(gMusic number: 8 loop: -1 play:)
				(PrintBambi 365 1) ; "So?" she asks, "why don't you step over here to my casting couch and I'll audition you for a role in my new video!"
				(= seconds 3)
			)
			(7
				(Print 365 2 #at -1 144) ; "(Perhaps a "roll" would be more like it!)"
				(= seconds 3)
			)
			(8
				(gEgo view: 725 setLoop: 0 setMotion: MoveTo 166 110 self)
			)
			(9
				(PrintLarry 365 3) ; "Bambi, I may not be able to keep up with you aerobically, but remember: practice makes perfect!"
				(= seconds 3)
			)
			(10
				(aBambi hide:)
				(gEgo
					view: 366
					setLoop: 0
					posn: (aBambi x:) (- (aBambi y:) 20)
					setCycle: End self
				)
			)
			(11
				(gEgo
					viewer: egoHumpCycler
					posn: 201 94
					setLoop: 1
					setCycle: Fwd
				)
				(= seconds 7)
			)
			(12
				(PrintBambi 365 4) ; "You know, Larry: no pain, no gain!"
				(= seconds 5)
			)
			(13
				(Print 365 5) ; "Your energetic pre-aerobic warmup loosens the stuck lid of the defective tanning machine..."
				(= cycles 11)
			)
			(14
				(gSoundFX number: 365 loop: 1 play:)
				(aLid setCycle: End self)
			)
			(15
				(gCurRoom drawPic: 366 2)
				(aLid dispose:)
				(aDoor dispose:)
				(gEgo
					viewer: egoHumpCycler
					loop: 2
					setPri: 12
					cel: 0
					setCycle: Fwd
				)
				(aBambi
					posn: 187 75
					view: 366
					loop: 3
					setPri: 4
					cel: 0
					setCycle: Fwd
					show:
				)
				(gMusic number: 261 loop: -1 play:)
				(= seconds 5)
			)
			(16
				(PrintBambi 365 6) ; "Wow, Larry! You're the first man who's ever made me see lights!!"
				(= seconds 5)
			)
			(17
				(Print 365 7) ; "The brilliant glow of 1500 watts of ultraviolet-B heats your back as quickly as it cramps your style."
				(= seconds 3)
			)
			(18
				(PrintLarry 365 8) ; "Hey, Bambi," you cry, struggling to raise the lid, "how do you get this thing up?"
				(= seconds 3)
			)
			(19
				(PrintBambi 365 9) ; "That's YOUR problem, Larry. I'd just like to raise the lid of this tanning booth!"
				(gEgo viewer: 0 stopUpd:)
				(aBambi stopUpd:)
				(= seconds 3)
			)
			(20
				(PrintBambi 365 10) ; "Larry, help! It's stuck!!"
				(= seconds 3)
			)
			(21
				(PrintLarry 365 11) ; "No, it's not; I'm just having trouble moving with this lid on my back!"
				(= seconds 3)
			)
			(22
				(gMusic fade:)
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(23
				(Print 365 12) ; "Bambi slips out of the tanning machine, out the door, and out of your life, leaving you to ponder yet another of life's great mysteries..."
				(gMusic number: 9 loop: 1 play:)
				(Print 365 13) ; "...why is it so damned hard to get an even tan in a machine!"
				(= seconds 3)
			)
			(24
				(gSystemWindow color: gTextColor back: gBackgroundColor)
				(= gEgoState 0)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance aBambi of Actor
	(properties
		x 124
		y 108
		view 365
		loop 2
	)

	(method (init)
		(super init:)
		(self illegalBits: 0 setPri: 7 setCycle: Walk ignoreActors:)
	)
)

(instance aDoor of Prop
	(properties
		x 118
		y 62
		view 365
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 2 ignoreActors:)
	)
)

(instance aLid of Prop
	(properties
		x 235
		y 83
		view 365
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 12 ignoreActors:)
	)
)

(instance atpBed of PicView
	(properties
		x 199
		y 118
		view 365
		priority 4
		signal 16384
	)
)

(instance humpCycler of Code ; UNUSED
	(properties)

	(method (doit &tmp s)
		(cond
			((<= gFilthLevel 2)
				(gEgo stopUpd:)
				(aBambi stopUpd:)
			)
			((not (Random 0 9))
				(= s (Random 0 5))
				(gEgo cycleSpeed: s)
				(aBambi cycleSpeed: s)
			)
		)
	)
)

(instance egoHumpCycler of Code
	(properties)

	(method (doit &tmp cs)
		(cond
			((<= gFilthLevel 2)
				(gEgo stopUpd:)
				(aBambi stopUpd:)
			)
			((not (Random 0 9))
				(= cs (Random 0 5))
				(gEgo cycleSpeed: cs)
				(aBambi cycleSpeed: cs)
			)
		)
	)
)

