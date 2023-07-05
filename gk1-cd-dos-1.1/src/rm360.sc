;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Talker)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	local0 = 1
	local1
	local2 = 1
	local3 = 3
	local4
	local5
	local6
)

(instance rm360 of Room
	(properties
		noun 13
		picture 360
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 360)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 71 121 46 130 55 134 49 146 241 145 240 132 218 117 189 117 155 121
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 202 133 195 142 183 143 163 138 148 138 136 125 172 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 119 126 99 141 67 136 64 128 93 123
					yourself:
				)
		)
		(gEgo
			normalize:
			view: 900
			loop: 1
			cel: 0
			setCycle: StopWalk -1
			signal: (| (gEgo signal:) $1000)
			init:
			state: 2
			ignoreActors: 1
			posn: 218 109
			hide:
		)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1
				number: 209
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(exitFeature init:)
		(mantleFlowers init:)
		(statue init:)
		(headStatue init:)
		(lionRug init:)
		(roundPic init:)
		(table init:)
		(squarePic init:)
		(vase init:)
		(leftBooks init:)
		(rightBooks init:)
		(bookOnTable init:)
		(rightCandle init:)
		(leftCandle init:)
		(gabsChair init:)
		(maliasChair init:)
		(fire init:)
		(leftShadow init:)
		(rightShadow init:)
		(leftCandleFlame init:)
		(rightCandleFlame init:)
		(gWalkHandler add: exitFeature)
		(gWalkHandler add: self)
		(if (== gPrevRoomNum 50) ; interrogation
			(gEgo
				posn: 111 128
				view: 363
				setLoop: 0 1
				setCel: 11
				setCycle: 0
				show:
			)
			(malia posn: 149 135 view: 365 setLoop: 0 setCel: 0 init:)
			(if (IsFlag 264)
				(gCurRoom setScript: maliaKnowsTruth)
			)
			(= gNarrator mansionNarrator)
		else
			(ClearFlag 251)
			(Load rsVIEW 363)
			(Load rsVIEW 360)
			(gCurRoom setScript: egoEnters)
		)
		(Load rsVIEW 359)
		(Load rsVIEW 358)
		(if (== (gGame detailLevel:) 3)
			(DoAudio 13 20) ; AudChannels
			(if (DoSound sndGET_AUDIO_CAPABILITY)
				(Load 140 532) ; WAVE
			)
			(gGkSound2 number: 532 setLoop: -1 flags: 5 play:)
		)
	)

	(method (dispose)
		(DoAudio 13 63) ; AudChannels
		(gGkSound2 stop: flags: 1)
		(if (!= gNewRoomNum 50) ; interrogation
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: exitFeature)
		(gWalkHandler delete: self)
		(= gNarrator GKNarrator)
		(DisposeScript 64939)
		(DisposeScript 64956)
		(DisposeScript 64941)
		(DisposeScript 64938)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gEgo setScript: standUp)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mansionNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(5 19)
				(43 10)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					((== local0 0)
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(= local6 (gEgo cycleSpeed:))
						(= temp1 (gEgo cel:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: temp1
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
					(local2
						(= temp0 365)
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: 4
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: RandCycle (* (param1 size:) 3) 0 1
						)
					)
				)
			)
			(5
				(= local1 1)
				(if (IsFlag 264)
					(malia
						view: 361
						loop: 0
						cel: 0
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				else
					(malia
						view: 365
						loop: (Random 0 1)
						cel: 0
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local1
			(= local1 0)
			(malia cel: 0 setCycle: 0)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setCel: (gEgo oldCel:)
				cycleSpeed: local6
				talking: 0
			)
			(if local0
				(gEgo setLoop: (gEgo oldLoop:) 1 setCycle: 0)
			else
				(gEgo setLoop: (gEgo oldLoop:) setCycle: StopWalk -1)
			)
		)
		(super dispose:)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(butler init: setCycle: CT 6 1 self)
			)
			(1
				1
				(gMessager say: 16 0 11 1) ; "Ms. Gedde will be down shortly."
				(butler setCel: 7 setCycle: End self)
			)
			(2
				2
				(gEgo show: ignoreActors: 1 setMotion: MoveTo 128 127 self)
			)
			(3
				3
				(gEgo setMotion: PolyPath 114 134 self)
			)
			(4
				4
				(gEgo
					view: 363
					setLoop: 0
					setCel: 0
					posn: 111 128
					setCycle: End self
				)
				(gMessager say: 16 0 11 2) ; "Thank you."
			)
			(5
				5
				(butler loop: 1 cel: 0 setCycle: End self)
				(if (IsFlag 398)
					(self cue:)
				else
					(gEgo view: 363 loop: 1 cel: 0 setCycle: Osc 12 self)
				)
			)
			(6
				6
				(if (not (butler cycler:))
					(butler dispose:)
				)
			)
			(7
				7
				(if (gCast contains: butler)
					(butler dispose:)
				)
				(if (IsFlag 398)
					(= cycles 1)
				else
					(gEgo
						posn: 124 124
						setLoop: 2
						setCel: 0
						setPri: 130
						setCycle: End self
					)
				)
			)
			(8
				7
				(if (IsFlag 398)
					(self changeState: 13)
				else
					(= seconds 3)
				)
			)
			(9
				8
				(gEgo
					view: 364
					setLoop: 0
					setCel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(10
				9
				(gEgo
					normalize: 1 900
					posn: 121 124
					setMotion: PolyPath 63 126 self
				)
			)
			(11
				10
				(gEgo
					posn: 64 124
					view: 364
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(12
				11
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(13
				12
				(= seconds 4)
			)
			(14
				13
				(if (IsFlag 398)
					(gEgo
						view: 363
						setCel: 0
						setLoop: 1
						setCycle: ForwardCounter 10 self
					)
				else
					(gEgo
						view: 364
						setCel: 0
						setLoop: 3
						setCycle: ForwardCounter 2 self
					)
				)
			)
			(15
				14
				(malia
					ignoreActors: 1
					setLoop: -1
					setLooper: Grooper
					init:
					posn: 218 109
					setCycle: StopWalk -1
					setMotion: MoveTo 125 127 self
				)
			)
			(16
				15
				(gMessager say: 16 0 11 3) ; "What can I do for you, Detective?"
				(malia setMotion: PolyPath 141 133 self)
			)
			(17
				16
				(malia
					posn: 149 135
					view: 365
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(18
				17
				(malia setPri: 130 view: 365 setLoop: 0 setCel: 0 setCycle: 0)
				(if (IsFlag 398)
					(= cycles 1)
				else
					(gEgo loop: 4 cel: 0 setCycle: End self)
				)
			)
			(19
				18
				(if (IsFlag 398)
					(self cue:)
				else
					(gEgo
						normalize:
						ignoreActors: 1
						setMotion: PolyPath 114 132 self
					)
				)
			)
			(20
				19
				(if (IsFlag 398)
					(self cue:)
				else
					(gEgo
						posn: 111 128
						view: 363
						setLoop: 0 1
						setCel: 0
						setCycle: End self
					)
				)
			)
			(21
				20
				(SetFlag 398)
				(= gNarrator mansionNarrator)
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 363 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(1
				(gEgo normalize: 0 900 ignoreActors: 1 posn: 114 132)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 114 132 self)
			)
			(1
				(gEgo
					posn: 111 128
					view: 363
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showMaliaSomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 0)
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(if
					(OneOf
						local5
						116
						104
						31
						129
						115
						33
						4
						121
						120
						64
						122
						73
						74
						114
					)
					(self cue:)
				else
					(gEgo view: 363 setCel: 0 setLoop: 4 setCycle: End self)
				)
			)
			(2
				(if (OneOf local5 79 23 48 24)
					(gMessager say: 12 local5 0 0 self)
				else
					(gMessager say: 12 0 0 0 self) ; "Does this mean anything to you?"
				)
			)
			(3
				(if
					(OneOf
						local5
						116
						104
						31
						129
						115
						33
						4
						121
						120
						64
						122
						73
						74
						114
					)
					(self cue:)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(4
				(gEgo setCel: 11 setLoop: 0)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(gCurRoom setScript: sitDown)
					(self dispose:)
				)
			)
			(1
				(if (IsFlag 251)
					(gMessager say: 12 10 2 0 self) ; "Would you mind answering just a few more questions, Ma'am?"
				else
					(SetFlag 251)
					(gMessager say: 12 10 1 0 self) ; "Mind if I ask you a few questions, Ms. Gedde?"
				)
			)
			(2
				(= global178 5)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance leaveTheMansion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(local0
						(self setScript: standUp self)
					)
					((and (== (gEgo x:) 144) (== (gEgo y:) 132))
						(self cue:)
					)
					(else
						(gEgo setMotion: PolyPath 114 132 self)
					)
				)
			)
			(1
				(gGame handsOff:)
				(Face gEgo malia self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 4 13 0 1 self) ; "I should be going."
			)
			(4
				(malia
					setPri: -1
					view: 365
					setCel: 7
					setLoop: 2
					setCycle: Beg self
				)
			)
			(5
				(= gNarrator GKNarrator)
				(gEgo view: 369 setCel: 0 setLoop: 0 setCycle: End self)
				(malia hide:)
				(UpdateScreenItem gEgo)
				(gMessager say: 4 13 0 2) ; "All right."
			)
			(6
				(gEgo setCycle: ROsc 5 3 4 self)
			)
			(7
				(gEgo normalize:)
				(malia
					view: 362
					setLoop: 1
					show:
					setLooper: Grooper
					ignoreActors: 1
					posn: 141 133
					setCycle: StopWalk -1
					setMotion: PolyPath 200 120 self
				)
			)
			(8
				(butler
					view: 366
					setLoop: 0 1
					cel: 0
					init:
					setCycle: Walk
					setMotion: MoveTo 165 125 self
				)
				(Face malia gEgo)
			)
			(9
				(gEgo ignoreActors: 1 setMotion: PolyPath 135 125 self)
			)
			(10
				(gMessager say: 16 0 9 (Random 1 3) self)
			)
			(11
				(gMessager say: 16 0 8 (Random 1 3) self)
			)
			(12
				(gEgo setMotion: MoveTo 145 125)
				(= cycles 15)
			)
			(13
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance maliaKnowsTruth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(malia posn: 141 133 view: 362 loop: 8 cel: 1)
				(self cue:)
			)
			(1
				(gEgo getPoints: -999 2)
				(gMessager sayRange: 16 0 10 1 2 self) ; "I think you should go, Mr. Knight!"
			)
			(2
				(gEgo view: 363 loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(gEgo normalize: 0 900 ignoreActors: 1 posn: 114 132)
				(gMessager say: 16 0 10 5 self) ; "I've wasted enough time. I'll have Robert show you out."
			)
			(4
				(malia
					setPri: -1
					view: 362
					ignoreActors: 1
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 200 120 self
				)
			)
			(5
				(gMessager say: 16 0 10 6 self) ; "Robert!"
			)
			(6
				(butler
					view: 366
					setLoop: 0 1
					cel: 0
					init:
					posn: 218 109
					setCycle: Walk
					setMotion: MoveTo 155 125 self
				)
			)
			(7
				(gMessager say: 16 0 10 7 self) ; "Show MR. KNIGHT out, please."
			)
			(8
				(malia
					view: 362
					setCycle: StopWalk -1
					setMotion: MoveTo 195 115 self
				)
			)
			(9
				(malia setMotion: MoveTo 218 109 self)
			)
			(10
				(malia dispose:)
				(gEgo setMotion: MoveTo 120 130 self)
			)
			(11
				(= cycles 10)
			)
			(12
				(butler setCel: 0 setLoop: 1 setCycle: End self)
			)
			(13
				(= cycles 10)
			)
			(14
				(gMessager say: 16 0 10 9 self) ; "(ANGRY)I most certainly will."
				(butler setCel: 0 setLoop: 2 setCycle: End self)
			)
			(15)
			(16
				(SetFlag 107)
				(gGame handsOn:)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance talkToMalia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(self setScript: sitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(if (== local3 7)
					(= local3 3)
				)
				(= cycles 1)
			)
			(2
				(gMessager say: 12 11 local3 0 self)
			)
			(3
				(++ local3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance malia of Actor
	(properties
		noun 12
		x 195
		y 120
		view 362
		loop 1
		signal 4129
	)

	(method (doVerb theVerb)
		(= local5 theVerb)
		(switch theVerb
			(11 ; Talk
				(gEgo setScript: talkToMalia)
			)
			(10 ; Ask
				(gEgo setScript: interrogateMalia)
			)
			(17 ; murderPhoto
				(gMessager say: noun theVerb 0 0) ; "Gabriel is trying to impress the girl, not make her gag."
			)
			(else
				(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(gEgo setScript: showMaliaSomething)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance butler of Actor
	(properties
		x 181
		y 118
		view 360
	)
)

(instance fire of Prop
	(properties
		noun 6
		x 126
		y 118
		view 359
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)
)

(instance leftShadow of Prop
	(properties
		x 100
		y 129
		view 359
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 1 setCycle: RandCycle)
	)
)

(instance rightShadow of Prop
	(properties
		x 147
		y 131
		view 359
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 1 setCycle: RandCycle)
	)
)

(instance leftCandleFlame of Prop
	(properties
		noun 3
		sightAngle 30
		x 105
		y 67
		view 358
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)
)

(instance rightCandleFlame of Prop
	(properties
		noun 3
		sightAngle 30
		x 156
		y 74
		view 358
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 117 setCycle: RandCycle)
	)
)

(instance exitFeature of Feature
	(properties
		noun 4
		nsLeft 181
		nsTop 56
		nsRight 211
		nsBottom 114
		x 195
		y 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: leaveTheMansion)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mantleFlowers of Feature
	(properties
		noun 5
		nsLeft 109
		nsTop 77
		nsRight 148
		nsBottom 85
		sightAngle 20
		x 129
		y 82
	)
)

(instance statue of Feature
	(properties
		noun 7
		sightAngle 20
		x 271
		y 126
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 145 250 139 252 126 263 121 251 110 264 101 260 89 260 76 270 78 282 107 280 143
					yourself:
				)
		)
		(super init:)
	)
)

(instance headStatue of Feature
	(properties
		noun 9
		nsLeft 24
		nsTop 99
		nsRight 41
		nsBottom 122
		sightAngle 20
		x 34
		y 111
	)
)

(instance lionRug of Feature
	(properties
		noun 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 131 70 120 81 127 100 130 111 124 129 125 197 126 230 122 241 125 238 130 183 131 167 136 163 147 141 145 131 141 110 144 97 146 81 146
					yourself:
				)
		)
		(super init:)
	)
)

(instance roundPic of Feature
	(properties
		noun 14
		nsLeft 113
		nsTop 50
		nsRight 145
		nsBottom 75
		sightAngle 20
		x 128
		y 63
	)
)

(instance table of Feature
	(properties
		noun 15
		nsLeft 169
		nsTop 123
		nsRight 197
		nsBottom 139
		sightAngle 20
		x 186
		y 128
	)
)

(instance squarePic of Feature
	(properties
		noun 17
		nsLeft 78
		nsTop 52
		nsRight 99
		nsBottom 80
		sightAngle 20
		x 91
		y 69
	)
)

(instance vase of Feature
	(properties
		noun 18
		nsLeft 179
		nsTop 101
		nsRight 195
		nsBottom 122
		sightAngle 20
		x 187
		y 118
	)
)

(instance leftBooks of Feature
	(properties
		noun 1
		sightAngle 20
		x 26
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 49 62 59 65 111 0 142 yourself:)
		)
		(super init:)
	)
)

(instance rightBooks of Feature
	(properties
		noun 1
		sightAngle 20
		x 276
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 146 235 112 235 61 319 48
					yourself:
				)
		)
		(super init:)
	)
)

(instance bookOnTable of Feature
	(properties
		noun 2
		nsLeft 172
		nsTop 120
		nsRight 182
		nsBottom 125
		sightAngle 20
		x 177
		y 122
	)
)

(instance rightCandle of Feature
	(properties
		noun 3
		nsLeft 150
		nsTop 54
		nsRight 163
		nsBottom 82
		sightAngle 20
		x 158
		y 73
	)
)

(instance leftCandle of Feature
	(properties
		noun 3
		nsLeft 96
		nsTop 56
		nsRight 108
		nsBottom 82
		sightAngle 20
		x 104
		y 72
	)
)

(instance gabsChair of Feature
	(properties
		noun 8
		sightAngle 20
		x 90
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 95 101 109 112 110 109 126 99 129 81 129 68 100 79 95
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if local0
					(gMessager say: noun theVerb 12 0) ; "Gabriel's already using the chair."
				else
					(gEgo setScript: sitDown)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance maliasChair of Feature
	(properties
		noun 11
		sightAngle 20
		x 165
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 129 138 112 151 112 152 96 170 93 183 100 181 117 169 121 168 133 155 134
					yourself:
				)
		)
		(super init:)
	)
)

