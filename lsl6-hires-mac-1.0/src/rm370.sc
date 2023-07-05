;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use n078)
(use fileScr)
(use n082)
(use LarryRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm370 of LarryRoom
	(properties
		noun 1
		picture 370
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 65 139 90 87 176 87 210 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 108 103 159 103 159 116 108 116
					yourself:
				)
		)
		(super init: &rest)
		(heat init: setCycle: Fwd)
		(coals init:)
		(cond
			((IsFlag 194)
				(bucket init: ignoreActors: 0 loop: 2 posn: 109 115 case: 15)
			)
			((and (IsFlag 215) (not (IsFlag 66)))
				(bucket init: ignoreActors: 0)
			)
		)
		(if (== global100 370)
			(UpdateScreenItem ((ScriptID 92 3) view: 1901)) ; larryTBust
			(SetFlag 74)
			(gEgo view: 353)
			(bucket init: ignoreActors: 0)
			(gGame changeScore: 8 215)
		)
		(if (and (IsFlag 215) (not (IsFlag 66)))
			(if (== (gEgo view:) 353)
				(gGame changeScore: 10 194)
			)
			(= local0 1)
			(burg init:)
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
		else
			(gGlobalSound1 fade:)
		)
		(if (and (IsFlag 66) (not (IsFlag 257)) (not (gEgo has: 5))) ; bracelet
			(bracelet init:)
		)
		(benchSeats init:)
		(if local0
			(= global170 gCurRoom)
		)
		(gEgo init: normalize: posn: 160 150)
		(self setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gCurRoom script:)
						((gCurRoom script:) cue:)
					)
					((gEgo script:)
						((gEgo script:) cue:)
					)
				)
				(= local2 gMouseX)
				(= local3 (- gMouseY 10))
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gEgo setScript: forwardScript)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo edgeHit:))
		(cond
			(script)
			((== temp0 3)
				(gCurRoom setScript: toMudBath)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(= global170 0)
		(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
		(super dispose:)
	)
)

(instance forwardScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gEgo setCycle: 0)
				(= cycles 2)
			)
			(1
				(= temp1 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(SetCursor 225 92)
				(if
					(Print
						width: 200
						font: gUserFont
						addTitle: 0 8 0 2 370
						addText: 0 8 0 1 50 1 370 ; "Do you really want to Fast Forward and miss everything (except the points)?"
						addIcon: 1911 0 0 0 0
						addButton: 0 9 8 0 1 50 33 370 ; "Oops"
						addButton: 1 8 8 0 1 140 33 370 ; "Yes"
						init:
					)
					(if global205
						(proc79_7)
					)
					(self cue:)
				else
					(Platform 0 2 1)
					(gGame setCursor: temp1)
					(= global170 gCurRoom)
					(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
					(self dispose:)
				)
			)
			(2
				(steamCartoon dispose:)
				(if (gCast contains: steamCloud)
					(steamCloud dispose:)
				)
				(cav dispose:)
				(burg dispose:)
				(bracelet init:)
				(gGlobalSound1 stop:)
				(bucket init: ignoreActors: 0 loop: 2 posn: 109 115 case: 15)
				(= cycles 2)
				(proc78_0)
			)
			(3
				(gTheIconBar enableIcon: (ScriptID 0 3) (ScriptID 0 6) show:) ; icon0, icon3
				(gGame handsOn:)
				(gWalkHandler delete: gCurRoom)
				(gEgo normalize: 353 2 ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance toMudBath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance steamCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(burg setCycle: CT 2 1)
				(SetFlag 66)
				(gMessager sayRange: 4 2 2 1 3 self) ; "Hi, Burgundy! I'm so glad to see you're really here."
			)
			(1
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: PolyPath 154 93 self)
			)
			(2
				(gEgo view: 371 loop: 0 setCel: 0 setCycle: End self)
				(burg setCycle: End)
			)
			(3
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo setScript: larryFidgets)
				(gTheIconBar enableIcon: (ScriptID 0 8) show:) ; icon5
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(gGlobalSound1 mute: 0 8)
				(gMessager sayRange: 4 2 2 4 6 self) ; "Yeah, but it's a DRY heat!"
			)
			(5
				(gGlobalSound1 mute: 0 9)
				(gMessager sayRange: 4 2 2 7 8 self) ; "And, we're alone!"
			)
			(6
				(gEgo setScript: 0)
				(gEgo setLoop: 1 setCel: 0)
				(cav
					init:
					setLoop: 0 1
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 105 170 self
				)
			)
			(7
				(gMessager say: 4 2 2 9 self) ; "Here they are now. Cavaricchi, is that you?"
			)
			(8
				(cav setMotion: MoveTo 105 110 self)
			)
			(9
				(gMessager say: 4 2 2 10 self) ; "Hi, Larry! Who's your friend?"
			)
			(10
				(burg setCycle: Beg self)
			)
			(11
				(burg setScript: burgGestures)
				(cav setMotion: MoveTo 104 91 self)
			)
			(12
				(gEgo setScript: larryFidgets)
				(cav view: 374 setCel: 0 setLoop: 6 1 setCycle: End self)
			)
			(13
				(cav setLoop: 2 1 setCel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(14
				(gMessager sayRange: 4 2 3 1 5 self) ; "Cavaricchi Vuarnet, meet Burgundy Bodine. Burg, this is Cav."
			)
			(15
				(cav setScript: cavGestures)
				(gGlobalSound1 mute: 0 4)
				(gMessager sayRange: 4 2 3 6 10 self) ; "But of course you did."
			)
			(16
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
			)
			(17
				(gGlobalSound1 mute: 0 7)
				(gMessager sayRange: 4 2 7 2 4 self) ; "You're right, Larry. Burgundy is a beautiful woman. Just look at how those delicate beads of perspiration glide down her shoulders, across her chest and disappear behind that totally unnecessary white towel."
			)
			(18
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
				(gGlobalSound1 mute: 0 6)
			)
			(19
				(cavGestures dispose:)
				(burgGestures dispose:)
				(gGame handsOff:)
				(burg loop: 1 setCel: 0 setCycle: End self)
			)
			(20
				(gGlobalSound1 mute: 0 5)
				(burg loop: 2 setCel: 0 setCycle: End self)
			)
			(21
				(gMessager sayRange: 4 2 8 2 7 self) ; "That's AN idea, Larry. Perhaps we'll do that later. But right now, I want to get to know Burgundy."
				(cav setScript: cavGestures)
				(burg setScript: burgGestures)
			)
			(22
				(gGame handsOn:)
				(gTheIconBar disableIcon: (ScriptID 0 3) show:) ; icon0
			)
			(23
				(gMessager say: 4 2 11 1 self) ; "How about a little steam, girls? Here. Let me pour a little water on the rocks."
			)
			(24
				(larryFidgets dispose:)
				(gGame handsOff:)
				(gEgo
					view: 371
					loop: 3
					setCel: 0
					setSpeed: 12
					setCycle: End self
				)
			)
			(25
				(gEgo
					view: 378
					setLoop: 0
					setCel: 0
					setPri: 140
					setCycle: End self
				)
				(heat dispose:)
				(bucket dispose:)
			)
			(26
				(gEgo view: 379 loop: 0 setCel: 0 setCycle: End self)
			)
			(27
				(sFx number: 374 loop: 1 play:)
				(gMessager say: 4 2 11 2 self) ; "Oops!"
			)
			(28
				(steamCloud
					view: 372
					loop: 0
					setCel: 0
					init:
					setPri: 199
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(29
				(cav dispose:)
				(burg dispose:)
				(steamCloud view: 375 setLoop: 0 setCel: 0 setCycle: Fwd)
				(gMessager say: 4 2 11 3 self) ; "Sorry. I spilled the whole bucket! Now it really IS steamy, isn't it?"
			)
			(30
				(if global205
					(proc79_7)
				)
				(gMessager say: 4 2 11 4 self) ; "Cav?"
			)
			(31
				(gMessager say: 4 2 11 5 self) ; "Burg?"
			)
			(32
				(if global205
					(proc79_7)
				)
				(steamCloud
					view: 376
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
				(bucket
					case: 15
					init:
					ignoreActors: 0
					setLoop: 2
					setCel: 0
					posn: 109 118
				)
			)
			(33
				(steamCloud setCycle: End self)
				(gMessager say: 4 2 11 6 self) ; "What the..."
			)
			(34)
			(35
				(gEgo normalize: 353 2 ignoreActors: 0)
				(bracelet init:)
				(steamCloud dispose:)
				(sFx number: 338 play:)
				(gGlobalSound1 stop:)
				(= ticks 10)
			)
			(36
				(gMessager say: 4 2 11 7 self) ; "(Doh!)"
			)
			(37
				(= global170 0)
				(gTheIconBar disableIcon: (ScriptID 0 8) show:) ; icon5
				(gMessager sayRange: 4 2 11 8 9 self) ; "Once again, Larry, the best man didn't win..."
			)
			(38
				(= cycles 2)
				(proc78_0)
			)
			(39
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: MoveTo 160 132 self)
			)
			(1
				(if (== (gEgo view:) 900)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(2
				(cond
					((== (gEgo view:) 900)
						(EgoDead 8 self)
					)
					(local0
						(gEgo normalize: 353 3)
						(SetFlag 25)
						(gCurRoom setScript: steamCartoon)
					)
					(else
						(SetFlag 25)
						(gEgo normalize: ignoreActors: 0)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
			(3
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance larryFidgets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 360))
			)
			(1
				(if (forwardScript client:)
					(self cue:)
				else
					(gEgo
						loop: 2
						setCel: 0
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(2
				(if (not (forwardScript client:))
					(gEgo setCel: 0)
				)
				(self init:)
			)
		)
	)
)

(instance larrySits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 154 93 self)
			)
			(1
				(gEgo
					view: 371
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo view: 371 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 setCel: 0)
				(gWalkHandler addToFront: gCurRoom)
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(gWalkHandler delete: gCurRoom)
				(gEgo
					view: 371
					setLoop: 3
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(if register
					(gEgo normalize: 353 2 setMotion: PolyPath 112 89 self)
				else
					(gEgo
						normalize: 353 2
						ignoreActors: 0
						setMotion: PolyPath local2 local3
					)
					(gGame handsOn:)
					(gTheIconBar enableIcon: (ScriptID 0 6) show:) ; icon3
					(self dispose:)
				)
			)
			(6
				(gEgo get: 5) ; bracelet
				(bracelet dispose:)
				(gGame changeScore: 12 195)
				(gMessager say: 7 5 0 0 self) ; "I'll be sure to return Burgundy's silver bracelet to her."
				(self dispose:)
			)
		)
	)
)

(instance getBracelet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 112 89 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo get: 5) ; bracelet
				(bracelet dispose:)
				(gGame changeScore: 12 195)
				(gMessager say: 7 5 0 0 self) ; "I'll be sure to return Burgundy's silver bracelet to her."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cavGestures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 320))
			)
			(1
				(cav
					loop: (if (Random 0 1) 3 else 5)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance burgGestures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 320))
			)
			(1
				(burg
					loop: (if (Random 0 1) 1 else 2)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance benchSeats of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 138 55 138 53 89 105 67 195 69 241 81 240 139 211 138 226 117 209 91 184 85 119 82 75 92 71 124 86 137
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: larrySits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance burg of Prop
	(properties
		noun 4
		x 129
		y 76
		view 373
		cel 1
		cycleSpeed 12
	)

	(method (cue)
		(if (gCast contains: bracelet)
			(burg setScript: burgGestures)
		else
			(burg setScript: doTheBracelet)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(switch (++ local1)
					(1
						(gMessager say: 4 2 7 1 steamCartoon) ; "Gee, girls, I've never been with TWO women before, especially two as beautiful as you two! Where do I begin?"
					)
					(2
						(gMessager say: 4 2 8 1 steamCartoon) ; "I've got an idea. Why don't one of you move over here to my left side. Then I can put an arm around both of you."
					)
					(3
						(cavGestures dispose:)
						(cav setLoop: 4 1 setCel: 0 setCycle: End)
						(gMessager say: 4 2 9) ; "Would you like me to turn down the temperature in here? Are either of you uncomfortable? Would you like to rearrange the seating here? Is anybody listening to me?"
					)
					(4
						(cav setScript: cavGestures)
						(burgGestures dispose:)
						(gMessager sayRange: 4 2 10 1 2 self) ; "Well, it sure is getting late. My, my. Look at the clock! Guess we may as well all turn in now."
					)
					(5
						(steamCartoon cue:)
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doTheBracelet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(burg view: 373 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(bracelet init:)
				(gMessager sayRange: 4 2 10 3 6 self) ; "Forget that, Honey. Let's talk more about you and me!"
			)
			(2
				(burg cue:)
				(self dispose:)
			)
		)
	)
)

(instance heat of Prop
	(properties
		noun 12
		x 135
		y 103
		priority 108
		fixPriority 1
		view 370
		cel 3
		signal 26657
		cycleSpeed 12
	)
)

(instance bucket of View
	(properties
		noun 11
		x 134
		y 89
		view 370
		loop 1
	)
)

(instance cav of Actor
	(properties
		noun 5
		x 100
		y 200
		view 374
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(burg doVerb: 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steamCloud of Prop
	(properties
		noun 10
		x 126
		y 106
		view 376
		cycleSpeed 12
	)
)

(instance bracelet of View
	(properties
		noun 7
		approachX 112
		approachY 89
		x 104
		y 73
		view 377
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(if (gCurRoom script:)
					((gCurRoom script:) register: 1 cue:)
					(return 1)
				else
					(gCurRoom setScript: getBracelet)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coals of Feature
	(properties
		noun 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 108 113 99 121 93 148 94 154 98 154 108 140 113 126 112
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sFx of Sound
	(properties
		flags 1
	)
)

(instance talkTimer of Timer ; UNUSED
	(properties)
)

