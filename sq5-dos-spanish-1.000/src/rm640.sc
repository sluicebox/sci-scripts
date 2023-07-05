;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use AnimDialog)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm640 0
	floTalker 13
	myRogTalker 15
	sUseComm 20
)

(local
	local0
	local1
	local2
)

(instance theMusic3 of Sound
	(properties)
)

(instance rm640 of Rm
	(properties
		noun 8
		picture 103
	)

	(method (init)
		(LoadMany rsMESSAGE number)
		(LoadMany rsVIEW 0)
		(bigShroom init: setOnMeCheck: 1 (bigShroom onMeCheck:))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 84 108 115 115 149 126 216 138 233 151 260 145 319 145 319 131 301 126 285 129 266 126 253 123 285 116 319 118 319 95 281 98 277 105 257 115 230 115 241 105 214 105 202 103 255 101 271 100 269 98 256 93 203 100 182 98 158 106 142 108 114 98 93 104
					yourself:
				)
		)
		(= style
			(switch gPrevRoomNum
				(620 11)
				(else -32758)
			)
		)
		(gEgo edgeHit: 0)
		(super init:)
		(NormalEgo 18)
		(if (== gPrevRoomNum 620)
			(if (IsFlag 91)
				(self setScript: sEnterHigh)
			else
				(self setScript: sEnterLow)
			)
		else
			(self setScript: sFrom660)
		)
	)

	(method (doit)
		(if (not script)
			(cond
				((& (= local0 (gEgo onControl: 1)) $0008)
					(gCurRoom setScript: sExitLow)
				)
				((& local0 $0004)
					(gCurRoom setScript: sExitHigh)
				)
				(
					(and
						(IsFlag 29)
						(not (IsFlag 99))
						(== global142 1)
						(< (gEgo x:) 162)
					)
					(gCurRoom setScript: sAmbush)
				)
			)
		)
		(super doit:)
	)
)

(instance sFrom660 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vinew init:)
				(bea
					init:
					view: 560
					loop: 6
					cel: 0
					x: 118
					y: 112
					illegalBits: 0
					ignoreActors: 1
				)
				(gEgo
					init:
					view: 559
					setCycle: 0
					cel: 6
					x: 96
					y: 146
					priority: 1
					setLoop: 0
					signal: 16
					setCycle: Fwd
					setScript: sBreath
				)
				(= seconds 2)
			)
			(1
				(gEgo moveSpeed: 0 setLoop: 0 setMotion: MoveTo 96 139 self)
			)
			(2
				(gEgo setCycle: 0 setLoop: 1 cel: 0 x: 95 y: 100)
				(= seconds 5)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(= cycles 2)
			)
			(5
				(bigPukeHead init:)
				(bigPukeBody init:)
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gCurRoom drawPic: 103 9)
				(= seconds 1)
			)
			(6
				(NormalEgo 18)
				(gEgo
					setPri: -1
					setLoop: -1
					setCycle: Walk
					moveSpeed: 6
					setMotion: MoveTo 128 108 self
					setScale: Scaler 97 71 159 100
				)
			)
			(7
				(gEgo setHeading: 180)
				(= seconds 1)
			)
			(8
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(puker1 init: setCycle: End self)
				(puker2 init: setCycle: End self)
				(puker3 init: setCycle: End self)
			)
			(9 0)
			(10 0)
			(11
				(roger init:)
				(bea dispose:)
				(gEgo dispose:)
				(= seconds 1)
			)
			(12
				(bigPukeHead setCel: 1)
				(= seconds 2)
			)
			(13
				(bigPukeHead setCel: 0)
				(= seconds 1)
			)
			(14
				(theMusic3 number: 519 setLoop: 1 play:)
				(if (IsFlag 99)
					(gSq5Music2 number: 260 setLoop: 1 play:)
					(pukeWall init: setCycle: End self)
					(roger
						posn: 124 111
						view: 23
						setLoop: 0
						cel: 15
						setScale: Scaler 97 71 159 100
						setCycle: Beg self
					)
				else
					(pukeWall init: setCycle: CT 6 1 self)
				)
			)
			(15
				(if (not (IsFlag 99))
					(EgoDead 30) ; "Some space hero you are! Sheesh, you couldn't adventure yourself out of a damp cellulose container without third-part intervention!"
				)
			)
			(16
				(SetFlag 104)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sAmbush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 stop:)
				(gSq5Music1 priority: 2 number: 35 setLoop: -1 play:)
				(gEgo setMotion: PolyPath 120 101 self)
			)
			(1
				(bea init: cel: 4 x: 169 y: 64)
				(= ticks 15)
			)
			(2
				(gMessager say: 4 0 0 0 self) ; "|f8|HIYAAAAA!"
			)
			(3
				(bea cel: 5 x: 167 y: 65)
				(= ticks 15)
			)
			(4
				(bea cel: 6 x: 170 y: 64)
				(= ticks 15)
			)
			(5
				(bea cel: 7 x: 159 y: 62)
				(= ticks 15)
			)
			(6
				(bea cel: 8 x: 146 y: 64)
				(= ticks 15)
			)
			(7
				(bea cel: 8 x: 135 y: 77)
				(= ticks 15)
			)
			(8
				(bea cel: 8 x: 127 y: 94)
				(= ticks 15)
			)
			(9
				(bea dispose:)
				(theMusic3 number: 5041 setLoop: 1 play: self)
				(gEgo view: 560 setLoop: 4 cel: 0 setCycle: End self)
			)
			(10
				(theMusic3 number: 102 setLoop: 1 play:)
				(gEgo setLoop: 1 posn: 105 106 setCycle: Osc 3 self)
			)
			(11
				(gEgo setLoop: 2 cycleSpeed: 10 setCycle: End self)
			)
			(12
				(= seconds 1)
			)
			(13
				(gEgo
					setPri: 1
					moveSpeed: 30
					setStep: 7 7
					setMotion: MoveTo 102 122 self
				)
			)
			(14
				(= seconds 1)
			)
			(15
				(gEgo
					setLoop: 5
					posn: 102 123
					moveSpeed: 3
					setMotion: MoveTo 102 146 self
				)
			)
			(16
				(SetFlag 104)
				(gEgo setCycle: Osc 3 self)
			)
			(17
				(gCurRoom newRoom: 660)
			)
		)
	)
)

(instance sExitLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 91)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sExitHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 91)
				(gEgo edgeHit: 0)
				(gEgo setMotion: MoveTo 340 108 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sEnterHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 18)
				(gEgo
					init:
					ignoreActors: 1
					posn: 311 108
					setScale: Scaler 97 71 159 100
					setScript: sBreath
					setMotion: PolyPath 251 120 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 18)
				(gEgo
					init:
					ignoreActors: 1
					setScale: Scaler 97 71 159 100
					setScript: sBreath
					posn: 350 135
					setMotion: MoveTo 288 135 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bea of Actor
	(properties
		x 169
		y 64
		view 560
		cel 4
		priority 10
		signal 16
	)
)

(instance bigPukeBody of View
	(properties
		x 163
		y 106
		view 561
		loop 5
		priority 15
		signal 16
	)
)

(instance bigPukeHead of View
	(properties
		x 277
		y 125
		view 561
		loop 6
	)
)

(instance puker3 of Actor
	(properties
		x 83
		y 115
		view 561
		loop 7
		signal 16384
	)
)

(instance puker1 of Actor
	(properties
		x 163
		y 117
		view 561
		loop 10
	)
)

(instance puker2 of Actor
	(properties
		x 145
		y 129
		view 561
		loop 9
	)
)

(instance roger of Actor
	(properties
		x 120
		y 112
		view 560
		loop 3
	)
)

(instance pukeWall of Actor
	(properties
		x 115
		y 104
		view 561
		loop 4
		priority 9
		signal 16
	)
)

(instance vinew of Actor
	(properties
		x 97
		y 135
		view 559
		loop 3
	)
)

(instance floTalker of ChoiceTalker
	(properties
		x 10
		y 15
		view 1008
		signal 16
		talkWidth 180
		keepWindow 1
		textX 100
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(super init: floBust floEyes floMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floBust of Prop
	(properties
		view 1008
	)
)

(instance floEyes of Prop
	(properties
		nsTop 33
		nsLeft 39
		view 1008
		loop 2
		signal 16384
	)
)

(instance floMouth of Prop
	(properties
		nsTop 43
		nsLeft 45
		view 1008
		loop 1
		signal 16384
	)
)

(instance bigShroom of Feature
	(properties
		x 55
		y 33
		noun 2
		onMeCheck 256
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (if (or (== global142 0) (IsFlag 104)) 5 else 6))
				(gEgo view: 553 loop: 8 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 setLoop: 1 play:)
			)
			(1
				(floTalker
					normal: 0
					keepWindow: 1
					curNoun: local2
					curVerb: 0
					curCase: 4
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982)
				(gMessager say: local2 0 4 0 self)
			)
			(3
				(floTalker normal: 1 keepWindow: 0)
				(= local1
					(switch (floTalker whichSelect:)
						(1 1)
						(2 2)
						(3 3)
					)
				)
				(gMessager say: local2 0 local1 0 self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo 18)
				(gEgo setHeading: 180)
				(if (not (and (== local1 1) (== local2 5)))
					(gGame handsOn:)
					(self dispose:)
				else
					(= seconds 1)
				)
			)
			(6
				(gEgo view: 6 setLoop: 0 cel: 15 setCycle: Beg self)
			)
			(7
				(gEgo dispose:)
				(= seconds 2)
			)
			(8
				(gGame handsOn:)
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance sBreath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 550 setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= seconds (Random 2 4))
			)
		)
	)
)

(instance myRogTalker of Talker
	(properties
		x 10
		y 25
		view 556
		loop 5
		talkWidth 150
		back 5
		textX 120
		textY 2
	)

	(method (init)
		(= font gUserFont)
		(super init: rogBust 0 rogMouth &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance rogBust of Prop
	(properties
		view 556
	)
)

(instance rogMouth of Prop
	(properties
		nsTop 18
		nsLeft 43
		view 556
		loop 2
	)
)

