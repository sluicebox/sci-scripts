;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use fileScr)
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
		(gEgo
			posn: 129 67
			init:
			setSpeed: 6
			normalize: 900 2
			setHeading: 180
		)
		(thunderBird init:)
		(lamp init: setPri: 85 ignoreActors: 1)
		(glass init: ignoreActors: 1)
		(glass1 init: ignoreActors: 1)
		(door init: setPri: 50)
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
		(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
		(gCurRoom setScript: sDoThunder)
	)

	(method (cue)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(= global213 gTheCursor)
		(gGame setCursor: gNormalCursor)
		(SetCursor 225 90)
		(if
			(Print
				width: 200
				font: gUserFont
				addTitle: 0 8 0 2 650
				addText: 0 8 0 1 50 2 650 ; "Fast Forward now? Just not into domination, eh, Larry?"
				addIcon: 1911 0 0 0 0
				addButton: 0 2 8 0 1 50 33 650 ; "Oops"
				addButton: 1 1 8 0 1 120 33 650 ; "Yes"
				init:
			)
			(if global205
				(proc79_7)
			)
			(gGlobalSound1 number: 0 stop:)
			(if (not (IsFlag 254))
				(gGame changeScore: 20 254)
			)
			(if (not (gEgo has: 11)) ; collar
				(gEgo get: 11) ; collar
			)
			(gThePlane drawPic: -1 10)
			(gCurRoom newRoom: 620)
		else
			(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
			(= global170 gCurRoom)
		)
		(gGame setCursor: global213)
	)

	(method (dispose)
		(ClearFlag 74)
		((ScriptID 92 3) view: 1900) ; larryTBust
		(super dispose:)
	)
)

(instance sDoThunder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 92)
				(proc79_8 11)
				(= seconds 2)
			)
			(1
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
				(door setCycle: End self)
			)
			(4)
			(5
				(sfx number: 33 play:)
				(gEgo setHeading: 315 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(thunderBird
					view: 651
					loop: 0
					cel: 0
					x: 119
					y: 74
					setCycle: End self
				)
			)
			(8
				(gMessager sayRange: 0 0 1 2 3 self) ; "Uh, nice room, Thunderbird. I've never seen a place quite like this before."
			)
			(9
				(gGlobalSound1 mute: 0 5)
				(gMessager sayRange: 0 0 1 4 5 self) ; "(SWALLOWS) (Gulp!)"
			)
			(10
				(gEgo setMotion: PolyPath 136 139 self)
			)
			(11
				(gEgo setHeading: 180 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(gEgo
					view: 653
					setLoop: 0 1
					cel: 0
					posn: 136 139
					setPri: 199
					setSpeed: 11
					setCycle: 0
				)
				(UnLoad 128 900)
				(= cycles 5)
			)
			(14
				(gEgo setScript: sDrink)
				(thunderBird
					setLoop: 1 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 92 100
				)
			)
			(15
				(gGlobalSound1 mute: 0 6)
				(thunderBird loop: 2 cel: 0 setSpeed: 16 setCycle: CT 2 1 self)
			)
			(16
				(gGame changeScore: 20 254)
				(= ticks 180)
			)
			(17
				(thunderBird setCycle: CT 2 1 self)
			)
			(18
				(proc79_6 1430)
				(thunderBird setCycle: End self)
			)
			(19
				(gEgo setScript: sDrink)
				(dress init: ignoreActors: 1)
				(thunderBird
					view: 652
					setLoop: 0 1
					cel: 0
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: Walk
					setMotion: MoveTo 129 138 self
				)
			)
			(20)
			(21
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
				(gMessager sayRange: 0 0 1 6 8 self) ; "I can tell how much you enjoy your gold chains."
			)
			(1
				(gEgo view: 98)
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
				(gMessager sayRange: 0 0 1 9 10 self) ; "What? Uh, do I really need to wear this? It feels like a dog collar."
			)
			(4
				(thunderBird loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(sfx number: 572 play:)
				(thunderBird setCycle: End self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 0 0 1 11 self) ; "What have you gotten yourself into this time, Larry?!"
			)
			(8
				(= cycles 2)
			)
			(9
				(gMessager say: 0 0 1 12 self) ; "May I help you undress?"
			)
			(10
				(thunderBird loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(11
				(gMessager say: 0 0 1 13 self) ; "Well... I..."
				(thunderBird cel: 3)
				(SetFlag 74)
				(UpdateScreenItem ((ScriptID 92 3) view: 1901)) ; larryTBust
			)
			(12
				(gGlobalSound1 mute: 0 8 9)
				(sfx number: 654 play:)
				(thunderBird setCycle: End self)
			)
			(13
				(thunderBird
					view: 652
					setLoop: 0 1
					cel: 0
					posn: 129 138
					setCycle: Walk
					setMotion: MoveTo 119 128
				)
				(gEgo
					view: 657
					loop: 1
					setPri: 120
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
			)
			(4
				(thunderBird
					view: 652
					setLoop: 1 1
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
				(= cycles 2)
			)
			(7
				(Load rsVIEW 654)
				(gMessager say: 0 0 1 18 self) ; "LOUDER! I can't hear you!"
			)
			(8
				(gMessager say: 0 0 1 19 self) ; "WOOF!!"
			)
			(9
				(gMessager sayRange: 0 0 1 20 21 self) ; "Yes, that's right! You're the puppy dog and I'm the Mommy dog."
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo view: 654 loop: 0 cel: 0)
				(gGlobalSound1 number: 656 setLoop: -1 play:)
				(self setScript: sTableCrawl self)
			)
			(12
				(= global170 0)
				(gTheIconBar disableIcon: (ScriptID 0 8)) ; icon5
				(gGame hideControls:)
				(= cycles 2)
			)
			(13
				(gCast eachElementDo: #hide)
				(gEgo setScript: 0)
				(gThePlane drawPic: -1 10)
				(gGlobalSound1 fade:)
				(= ticks 90)
			)
			(14
				(Print font: gUserFont addText: 0 0 1 22 modeless: 2 init:) ; "A Few Hours Later..."
				(= ticks 360)
			)
			(15
				(Print modeless: 0)
				(if (Print dialog:)
					((Print dialog:) dispose:)
				)
				(= cycles 2)
			)
			(16
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sTableCrawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 1906)
				(= cycles 2)
			)
			(1
				(if (< (++ local0) 5)
					(UpdateScreenItem ((ScriptID 92 3) view: 1906 cel: 1)) ; larryTBust
				)
				(sfx number: 652 play:)
				(gEgo loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(sfx number: 903 play:)
				(UpdateScreenItem ((ScriptID 92 3) view: 1901 loop: 1)) ; larryTBust
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (>= local0 4)
					(self dispose:)
				else
					(self changeState: 1)
				)
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
				(glass show:)
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
		x 143
		y 109
		view 650
		loop 3
	)
)

(instance door of Prop
	(properties
		x 115
		y 73
		view 6500
	)
)

(instance dress of View
	(properties
		x 92
		y 100
		view 650
	)
)

(instance glass of View
	(properties
		x 138
		y 134
		priority 199
		fixPriority 1
		view 650
		loop 2
	)
)

(instance glass1 of View
	(properties
		x 123
		y 134
		priority 199
		fixPriority 1
		view 650
		loop 2
	)
)

(instance sfx of Sound
	(properties)
)

