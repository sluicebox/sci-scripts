;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
)

(instance rm650 of LarryRoom
	(properties
		picture 650
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 142 287 142 287 117 273 114 216 92 196 90 187 78 143 75 136 67 117 67 111 77 79 90 100 96 43 122 0 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 112 92 178 92 183 118 148 122 112 120
					yourself:
				)
		)
		(gEgo posn: 129 67 init: setHeading: 180 setSpeed: 6 normalize:)
		(thunderBird init:)
		(lamp init: stopUpd:)
		(glass init: stopUpd:)
		(glass1 init: stopUpd:)
		((ScriptID 0 8) enable:) ; icon5
		(super init: &rest)
		(gGlobalSound2 stop:)
		(gGlobalSound1
			number: 337
			play:
			setLoop: -1
			mute: 1 4
			mute: 1 5
			mute: 1 6
			mute: 1 7
			mute: 1 8
			mute: 1 9
		)
		(= global170 gCurRoom)
		(gCurRoom setScript: sDoThunder)
	)

	(method (cue)
		((gCurRoom script:) setScript: sForwardScript)
	)

	(method (dispose)
		(ClearFlag 74)
		(super dispose:)
	)
)

(instance sForwardScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp1 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(SetCursor 225 90)
				(Platform 0 4 3 6)
				(if
					(Print
						addTitle: 0 8 0 2 650
						addText: 0 8 0 1 0 2 650 ; "Fast Forward now? Just not into domination, eh, Larry?"
						addButton: 1 1 8 0 1 155 35 650 ; "Yes"
						addButton: 0 2 8 0 1 0 35 650 ; "Oops"
						init:
					)
					((ScriptID 1803 11) dispose:) ; Thunderbird
					((ScriptID 1800 1) dispose:) ; You
					(gGlobalSound1 stop:)
					(self cue:)
				else
					(gGame setCursor: temp1)
					((ScriptID 0 8) enable:) ; icon5
					(= global170 gCurRoom)
					(self dispose:)
				)
			)
			(1
				(if (not (IsFlag 254))
					(gGame changeScore: 20 254)
				)
				(if (not (gEgo has: 11)) ; collar
					(gEgo get: 11) ; collar
				)
				(= cycles 1)
			)
			(2
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(gGame hideControls:)
				(gCast eachElementDo: #hide)
				(DrawPic 98 6)
				(= cycles 1)
			)
			(3
				(Platform 0 4 2 6)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sDoThunder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Platform 0 4 3 6)
				(= seconds 3)
			)
			(1
				(SetFlag 92)
				(gMessager say: 0 0 1 1 self) ; "Thanks for coming, Larry. I'm so happy to see you again."
			)
			(2
				(gGlobalSound1 mute: 0 4)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 170 90 self
				)
			)
			(3
				(thunderBird cycleSpeed: 9 moveSpeed: 9 setCycle: End self)
			)
			(4
				(sfx number: 1033 play:)
				(gEgo setHeading: 315)
				(= cycles 5)
			)
			(5
				(door init: stopUpd:)
				(thunderBird
					view: 651
					loop: 0
					cel: 0
					x: 119
					y: 74
					setCycle: End self
				)
			)
			(6
				(gMessager say: 0 0 1 2 3 self) ; "Uh, nice room, Thunderbird. I've never seen a place quite like this before."
			)
			(7
				(gGlobalSound1 mute: 0 5)
				(gMessager say: 0 0 1 4 5 self) ; "(SWALLOWS) (Gulp!)"
			)
			(8
				(gEgo setMotion: PolyPath 136 139 self)
			)
			(9
				(gEgo setHeading: 180)
				(= cycles 5)
			)
			(10
				(gEgo
					view: 653
					setLoop: 0
					cel: 0
					posn: 136 139
					setPri: 14
					setSpeed: 11
					setCycle: 0
				)
				(UnLoad 128 900)
				(= cycles 5)
			)
			(11
				(gEgo setScript: sDrink)
				(thunderBird
					setLoop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 92 100
				)
			)
			(12
				(gGlobalSound1 mute: 0 6)
				(thunderBird loop: 2 cel: 0 setSpeed: 16 setCycle: CT 2 1 self)
			)
			(13
				(gGame changeScore: 20 254)
				(= ticks 180)
			)
			(14
				(thunderBird setCycle: End self)
			)
			(15
				(gEgo setScript: sDrink)
				(dress init: stopUpd:)
				(thunderBird
					view: 652
					setLoop: 0
					cel: 0
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: Walk
					setMotion: MoveTo 129 138 self
				)
			)
			(16)
			(17
				(= next sThunderMovesIn)
				(self dispose:)
			)
		)
	)
)

(instance sThunderMovesIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 92)
				(gMessager say: 0 0 1 6 8 self) ; "I can tell how much you enjoy your gold chains."
			)
			(1
				(gEgo hide:)
				(gGlobalSound1 mute: 0 7)
				(thunderBird
					view: 653
					loop: 1
					cel: 0
					posn: 136 139
					setSpeed: 9
					setCycle: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(sfx number: 572 play:)
				(gEgo get: 11) ; collar
				(thunderBird setCycle: End self)
			)
			(3
				(gMessager say: 0 0 1 9 10 self) ; "What? Uh, do I really need to wear this? It feels like a dog collar."
			)
			(4
				(thunderBird loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(sfx number: 572 play:)
				(thunderBird setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(gMessager say: 0 0 1 11 self) ; "What have you gotten yourself into this time, Larry?!"
			)
			(8
				(= seconds 3)
			)
			(9
				((ScriptID 1800 1) modeless: 1) ; You
				(gMessager say: 0 0 1 12 13 self) ; "May I help you undress?"
				(thunderBird loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(10)
			(11
				(SetFlag 74)
				((ScriptID 1800 1) modeless: 0) ; You
				(gGlobalSound1 mute: 0 8 9)
				(= cycles 5)
			)
			(12
				(sfx number: 654 play:)
				(thunderBird setCycle: End self)
			)
			(13
				(thunderBird
					view: 652
					setLoop: 0
					cel: 0
					posn: 129 138
					setCycle: Walk
					setMotion: MoveTo 119 128
				)
				(gEgo
					view: 657
					loop: 1
					setPri: 12
					cel: 0
					setCycle: End self
					show:
				)
			)
			(14
				(gMessager say: 0 0 1 14 self) ; "(ANGRILY) Say! What the hell kind of date is this, anyway?"
			)
			(15
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(16
				(= next sAssumeThePosition)
				(self dispose:)
			)
		)
	)
)

(instance sAssumeThePosition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 15 self) ; "(FORCEFULLY) Down on your hands and knees, dog!"
				(gGlobalSound1 number: 338 loop: 1 play:)
			)
			(1
				(gEgo
					loop: 3
					cel: 0
					posn: 144 105
					setPri: -1
					setCycle: End self
				)
			)
			(2
				(gMessager say: 0 0 1 16 self) ; "Sit, boy! Sit up!! Speak!"
			)
			(3
				(gMessager say: 0 0 1 17 self) ; "Woof."
				(sfx number: 650 play:)
			)
			(4
				(thunderBird
					view: 652
					setLoop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 133 120 self
				)
			)
			(5
				(thunderBird
					view: 656
					loop: 1
					cel: 0
					posn: 134 121
					setCycle: End self
				)
			)
			(6
				(thunderBird hide:)
				(lamp dispose:)
				(gEgo view: 656 loop: 0 cel: 0 setSpeed: 6 posn: 142 105)
				(= cycles 5)
			)
			(7
				(Load rsVIEW 654)
				(gMessager say: 0 0 1 18 self) ; "LOUDER! I can't hear you!"
			)
			(8
				(sfx number: 657 play:)
				(gMessager say: 0 0 1 19 self) ; "WOOF!!"
			)
			(9
				(gMessager say: 0 0 1 20 21 self) ; "Yes, that's right! You're the puppy dog and I'm the Mommy dog."
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo view: 654 loop: 0 cel: 0 setScript: sTableCrawl)
				(gGlobalSound1 number: 656 setLoop: -1 play:)
			)
			(12
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
				(gGame hideControls:)
				(= cycles 2)
			)
			(13
				(gCast eachElementDo: #hide)
				(gEgo setScript: 0)
				(sTableCrawl dispose:)
				(SetPort 0 0 190 320 10 0)
				(DrawPic 98 6)
				(gGlobalSound1 fade:)
				(= ticks 180)
			)
			(14
				(gMessager say: 0 0 1 22 self) ; "A Few Hours Later..."
				(= ticks 180)
			)
			(15)
			(16
				(Platform 0 4 2 6)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sTableCrawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ local0)
				(sfx number: 652 play: self)
				(gEgo loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(sfx number: 903 play:)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (== local0 4)
					(sAssumeThePosition cue:)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glass hide:)
				(gEgo setCycle: End self)
			)
			(1
				(= cycles (Random 60 120))
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(glass show: stopUpd:)
				(sDoThunder cue:)
				(self dispose:)
			)
		)
	)
)

(instance thunderBird of Actor
	(properties
		x 118
		y 74
		view 655
	)
)

(instance lamp of Prop
	(properties
		x 142
		y 105
		view 650
		loop 3
		signal 16385
	)
)

(instance door of View
	(properties
		x 118
		y 74
		view 650
		loop 1
		signal 1
	)
)

(instance dress of View
	(properties
		x 92
		y 100
		view 650
		signal 16385
	)
)

(instance glass of View
	(properties
		x 137
		y 134
		view 650
		loop 2
		priority 14
		signal 16400
	)
)

(instance glass1 of View
	(properties
		x 123
		y 134
		view 650
		loop 2
		priority 14
		signal 16400
	)
)

(instance sfx of Sound
	(properties)
)

