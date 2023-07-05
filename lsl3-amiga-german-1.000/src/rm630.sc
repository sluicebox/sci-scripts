;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Wander)
(use Follow)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm630 0
)

(instance rm630 of Rm
	(properties
		picture 630
		horizon 1
		east 640
	)

	(method (init)
		(Load rsVIEW 720)
		(Load rsVIEW 631)
		(Load rsVIEW gNormalEgoView)
		(Load rsSOUND 630)
		(Load rsSOUND 4)
		(Load rsSOUND 5)
		(Load rsSOUND 631)
		(Load rsSOUND 699)
		(Load rsSCRIPT 969)
		(Load rsSCRIPT 970)
		(super init:)
		(aGeneratorBottom init:)
		(aGeneratorTop init:)
		(aSwitch init:)
		(aLarry init:)
		(NormalEgo)
		(gEgo
			illegalBits: 0
			view: 632
			setLoop: 0
			setPri: 13
			cel: 0
			posn: 7 183
			init:
			baseSetter: SQ3Base
		)
		(self setScript: RoomScript)
		(= gEgoState 630)
		(gMusic number: 630 loop: gBgMusicLoops play:)
	)

	(method (newRoom newRoomNumber)
		(DisposeScript 970)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== gEgoState 630)
			(aLarry brLeft: (- (aLarry x:) 4) brRight: (+ (aLarry x:) 4))
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(Said
					'activate,cable,cable,cable,attach,(on<pull)[/cable,cable,cable,equipment,switch,handle]'
				)
				(if (== gEgoState 0)
					(ItIs) ; "It is."
				else
					(Print 630 0) ; "Good. Opposite thinking sometimes helps!"
				)
			)
			(
				(Said
					'deactivate,disconnect,drain,(off<pull),stop,pull,pull[/cable,cable,cable,equipment,switch,handle]'
				)
				(cond
					((!= gEgoState 630)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo inRect: 190 126 261 154))
						(NotClose) ; "You're not close enough."
					)
					((or (< (gEgo cel:) 6) (> (gEgo cel:) 9))
						(Print 630 1) ; "You must be upside down in order to reach the plug from where you are."
					)
					(else
						(RoomScript changeState: 6)
					)
				)
			)
			((Said 'get/cable,cable,cable')
				(Print 630 2) ; "You have no use for any part of the Anti-Gravity Generator."
			)
			((Said 'look,look>')
				(cond
					((Said '/cable,cable,cable')
						(if (== gEgoState 630)
							(Print 630 3) ; "A small wire attaches the Anti-Gravity Generator to an electrical outlet in the floor of the set."
						else
							(Print 630 4) ; "It's unplugged now!"
						)
					)
					((Said '/larry')
						(Print 630 5) ; "He looks out of this world!"
					)
					((Said '/equipment,equipment')
						(if (== gEgoState 630)
							(Print 630 6) ; "So that's how those guys do it! The "Acme Anti-Gravity Generator" has enough power to keep both you and Larry afloat! You wonder how much electricity is coursing through that small wire plugged into the floor of the set."
						else
							(Print 630 7) ; "It's lost all its attraction to you!"
						)
					)
					((Said '[/area]')
						(Print 630 8) ; "You are on the set of "Space Quest.""
						(if (== gEgoState 630)
							(Print 630 9) ; "A machine is working away down near the floor."
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 19 171 setCycle: End self)
			)
			(1
				(gEgo
					posn: 35 149
					setLoop: 1
					cel: 1
					setCycle: Fwd
					cycleSpeed: 4
					moveSpeed: 1
					setStep: 1 1
					setMotion: MoveTo 72 138 self
				)
			)
			(2
				(Printf 630 10 global304 global305) ; "%s" you shout. "Now what?"
				(gEgo
					observeControl: 8192
					baseSetter: SQ3Base
					setMotion: MoveTo 187 99 self
				)
				(aLarry setMotion: MoveTo 6 185 self)
			)
			(3
				(aLarry
					view: 631
					setLoop: 0
					cel: 0
					setMotion: MoveTo 18 173
					setCycle: End self
				)
			)
			(4
				(Print 630 11) ; ""We're weightless!!" Larry yells."
				(aLarry
					posn: 31 150
					setLoop: 1
					cel: 1
					setCycle: Fwd
					cycleSpeed: 4
					moveSpeed: 1
					setStep: 1 1
					setMotion: MoveTo 153 41 self
				)
				(HandsOn)
				(gEgo
					illegalBits: 0
					observeControl: -32768 8192
					baseSetter: SQ3Base
				)
			)
			(5
				(aLarry observeControl: -32768 16384 setMotion: Wander 22)
			)
			(6
				(Ok) ; "O.K."
				(HandsOff)
				(gGame changeScore: 40)
				(aSwitch setCycle: End self)
				(aLarry setMotion: MoveTo 148 (aLarry y:))
			)
			(7
				(aSwitch stopUpd:)
				(aGeneratorTop setCel: 0 stopUpd:)
				(gMusic number: 631 loop: 1 play:)
				(= cycles 22)
			)
			(8
				(Print 630 12) ; "Look, Larry," you cry, "I did it! The anti-gravity generator is unplugged!"
				(if (== gBgMusicLoops -1)
					(= seconds 2)
				else
					(= cycles 22)
				)
			)
			(9
				(= gEgoState 2)
				(Print 630 13) ; "Wait a minute, Patti!" Larry yells. "If there's no anti-gravity..."
				(gMusic number: 4 loop: 1 play:)
				(gEgo
					baseSetter: 0
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 3 4
					setMotion: MoveTo (gEgo x:) 152 self
				)
				(aLarry
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 3 4
					setMotion: MoveTo (aLarry x:) 152 self
				)
			)
			(10
				(gEgo posn: (gEgo x:) 181 loop: 2 cel: 0 setCycle: End)
			)
			(11
				(aLarry posn: (aLarry x:) 181 loop: 2 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(12
				(gEgo cycleSpeed: 1 loop: 3 cel: 0 setCycle: End)
				(aLarry cycleSpeed: 1 loop: 3 cel: 0 setCycle: End self)
			)
			(13
				(aLarry loop: 4 setCycle: Fwd)
				(gEgo loop: 4 setCycle: Fwd)
				(gMusic number: 5 loop: 1 play: self)
			)
			(14
				(= gEgoState 0)
				(NormalEgo 3)
				(NormalActor aLarry 3 720)
				(aLarry setMotion: Follow gEgo 28)
				(gMusic number: 699 loop: gBgMusicLoops play:)
				(Print 630 14) ; "Wow, Patti! That was a rough one. What's next?"
			)
		)
	)
)

(instance aGeneratorBottom of View
	(properties
		x 227
		y 149
		view 630
	)

	(method (init)
		(super init:)
		(self setPri: 5 ignoreActors: stopUpd:)
	)
)

(instance aGeneratorTop of Prop
	(properties
		x 235
		y 133
		view 630
		loop 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 6 setCycle: Fwd)
	)
)

(instance aSwitch of Prop
	(properties
		x 213
		y 153
		view 630
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 7 ignoreActors: stopUpd:)
	)
)

(instance aLarry of Actor
	(properties
		x -28
		y 184
		view 720
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setPri: 5 ignoreActors:)
	)
)

(instance SQ3Base of Code
	(properties)

	(method (doit &tmp w)
		(gEgo brBottom: (+ (gEgo y:) 1))
		(gEgo brTop: (- (gEgo brBottom:) (gEgo yStep:)))
		(gEgo brLeft: (- (gEgo x:) 18))
		(gEgo brRight: (+ (gEgo x:) 18))
	)
)

