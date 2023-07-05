;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	local0 = 1
	[local1 2]
	local3 = 1
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1)
	(if param1
		(= local7 (gNarrator x:))
		(= local8 (gNarrator talkWidth:))
		(gNarrator x: 20 talkWidth: 100)
	else
		(gNarrator x: local7 talkWidth: local8)
	)
)

(procedure (localproc_1 param1)
	(if param1
		(= local7 (gNarrator x:))
		(= local8 (gNarrator talkWidth:))
		(gNarrator x: 200 talkWidth: 100)
	else
		(gNarrator x: local7 talkWidth: local8)
	)
)

(procedure (localproc_2)
	(return
		(cond
			((and (> (gEgo heading:) 45) (< (gEgo heading:) 135)) 0)
			((and (> (gEgo heading:) 134) (< (gEgo heading:) 225)) 2)
			((and (> (gEgo heading:) 224) (< (gEgo heading:) 315)) 1)
			((or (> (gEgo heading:) 314) (< (gEgo heading:) 45)) 3)
		)
	)
)

(instance rm550Messager of Kq6Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(if
			(= temp0
				(switch param1
					(59 gNarrator)
					(60 gNarrator)
				)
			)
			(return)
		else
			(super findTalker: param1)
		)
	)
)

(instance oceanSound of Sound
	(properties)
)

(instance rm550 of KQ6Room
	(properties
		noun 3
		picture 550
		horizon 0
		west 560
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(= local6 gMessager)
		(= gMessager rm550Messager)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 106 259 107 224 84 222 92 189 86 170 95 168 89 171 83 133 87 130 83 143 78 165 68 155 63 142 60 124 48 140 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 260 127 237 129 217 132 186 128 181 119 218 112 233 101 255 121
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 152 112 140 112 139 120 118 120 108 118 100 111 85 110 86 106 115 101 129 103 153 109
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 93 76 81 70 65 71 57 67 30 68 20 58 0 58 0 0 93 0 110 51 132 59 143 67
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 132 144 164 170 119 189 0 189 0 132 50 126 75 129 96 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 165 291 165 282 169 247 168 229 162 243 158 294 149 319 153
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 240 189 136 189 166 185 206 185
					yourself:
				)
		)
		(water1 init: setCycle: Fwd)
		(water2 init: setCycle: Fwd)
		(water3 init: setCycle: Fwd)
		(water4 init: setCycle: Fwd)
		(oceanSound number: 915 loop: -1 flags: 1 play:)
		(gGlobalSound2 number: 550 flags: 1 loop: -1 play:)
		(ocean1 init:)
		(ocean2 init:)
		(trees1 init:)
		(trees2 init:)
		(rocks init:)
		(nePath init:)
		(nwPath init:)
		(gEgo actions: egoDoVerb setScale: Scaler 100 70 190 53 setPri: -1)
		(if (and (IsFlag 25) (not (IsFlag 14)))
			(druid1 init: setScale: -1 gEgo)
			(druid2 init: setScale: -1 gEgo setScript: waitForCapture)
			(= local5 1)
		)
		(if (OneOf gPrevRoomNum 560 580)
			(self setScript: egoEnters)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $2000)
				(gGame handsOff:)
				(gCurRoom setScript: walkNorthScript)
			)
			((& temp0 $0010)
				(if (!= (gEgo view:) 308)
					(= temp1 (localproc_2))
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						view: 308
						setPri: 15
						setLoop: temp1
						setLoop: -1
					)
					(= local0 0)
				)
			)
			((& temp0 $0020)
				(if (not local9)
					(= local9 1)
					(gGlobalSound3 number: 922 loop: -1 flags: 1 play:)
				)
				(if local3
					(= local0 0)
					(= local3 0)
					(gMessager say: 4 3 6) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					(gEgo setMotion: 0)
				)
			)
			((& temp0 $0040)
				(if (!= (gEgo view:) 3081)
					(= temp1 (localproc_2))
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						view: 3081
						setPri: 15
						setLoop: temp1
						setLoop: -1
					)
				)
			)
			((& temp0 $0100)
				(if (not local4)
					(gEgo setMotion: 0)
					(repeat
						(gEgo posn: (- (gEgo x:) 1) (- (gEgo y:) 1))
						(breakif (& (gEgo onControl: 1) $0080))
					)
					(gMessager say: 4 3 6) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					(= local0 0)
					(= local4 1)
				else
					(gGame handsOff:)
					(self setScript: wateryDeathScr)
				)
			)
			((and (not (& temp0 $01f0)) (== (gEgo view:) 308) (not local0))
				(gGlobalSound3 fade:)
				(= local9 0)
				(gEgo reset: 3)
				(= local4 0)
				(= local0 1)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 560 580))
			(gGlobalSound2 stop: number: 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= gMessager local6)
		(super dispose:)
		(DisposeScript 939)
	)
)

(instance myConv of Conversation ; UNUSED
	(properties)
)

(instance trees2 of Feature
	(properties
		noun 5
		onMeCheck 7680
	)
)

(instance ocean1 of Feature
	(properties
		noun 4
		onMeCheck 240
	)
)

(instance ocean2 of Feature
	(properties
		noun 4
		onMeCheck 256
	)
)

(instance trees1 of Feature
	(properties
		noun 5
		onMeCheck 2
	)
)

(instance rocks of Feature
	(properties
		noun 2
		onMeCheck 12
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 10 0 0 0) ; "Mysterious-looking volcanic rocks dot this island."
			)
			((OneOf theVerb 2 5) ; Talk, Do
				(gMessager say: noun theVerb 0 0 0 0)
			)
			(else
				(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
			)
		)
	)
)

(instance nePath of Feature
	(properties
		noun 7
		onMeCheck 8192
	)
)

(instance nwPath of Feature
	(properties
		noun 8
		onMeCheck 16384
	)
)

(instance druid1 of Actor
	(properties
		x 68
		y 105
		view 553
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setCycle: StopWalk -1)
	)
)

(instance druid2 of Actor
	(properties
		x 131
		y 82
		view 553
		loop 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self setCycle: StopWalk -1)
	)
)

(instance water1 of Prop
	(properties
		x 217
		y 136
		noun 4
		view 550
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance water2 of Prop
	(properties
		x 278
		y 172
		noun 4
		view 550
		loop 1
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance water3 of Prop
	(properties
		x 291
		y 89
		noun 4
		view 550
		loop 2
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance water4 of Prop
	(properties
		x 279
		y 110
		noun 4
		view 550
		loop 3
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)
)

(instance walkNorthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 138 58 self)
			)
			(1
				(gEgo setMotion: PolyPath 122 47 self)
			)
			(2
				(gEgo setHeading: 45 self)
			)
			(3
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(580
						(gEgo
							init:
							posn: 126 55
							setMotion: PolyPath 127 87 self
						)
					)
					(else
						(gEgo
							init:
							posn: 1 95
							setMotion: PolyPath 40 95 self
						)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance waitForCapture of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not state) (not (gCurRoom script:)))
			(gGame handsOff:)
			(gCurRoom setScript: captured)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
		)
	)
)

(instance captured of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 315 self)
			)
			(1
				(localproc_0 1)
				(gMessager say: 1 0 2 1 self) ; "Great gods! Did you see that? That man just appeared from nowhere!"
				(localproc_0 0)
			)
			(2
				(localproc_1 1)
				(gMessager say: 1 0 2 2 self) ; "Perhaps he was sent by the spirits! I see no boat."
				(localproc_1 0)
			)
			(3
				(localproc_0 1)
				(gMessager say: 1 0 2 3 self) ; "He's an intruder, no matter how he got here. Grab him!"
				(localproc_0 0)
			)
			(4
				(druid1
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 3)
						self
					setCycle: Walk
				)
				(druid2
					setMotion:
						MoveTo
						(+ (gEgo x:) 24)
						(+ (gEgo y:) 4)
						self
					setCycle: Walk
				)
			)
			(5
				(druid1 dispose:)
				(druid2 dispose:)
				(gEgo
					normal: 0
					view: 554
					cycleSpeed: 10
					cel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(6
				(gMessager say: 1 0 2 4 self) ; "Not again! Look, I'll leave. It's no problem...."
			)
			(7
				(localproc_0 1)
				(gMessager say: 1 0 2 5 self) ; "I think not. Let's go."
				(localproc_0 0)
			)
			(8
				(gEgo
					view: 5806
					setLoop: 0
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 126 85 self
				)
			)
			(9
				(gEgo setMotion: PolyPath 150 66 self)
			)
			(10
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance wateryDeathScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 3 9 0 self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs."
			)
			(1
				(gCurRoom walkOffEdge: 1)
				(gGlobalSound3 stop: number: 921 loop: 1 play:)
				(gEgo
					normal: 0
					view: 269
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: Osc
				)
				(if (> (gEgo y:) 137)
					(gEgo setMotion: PolyPath 267 220 self)
				else
					(gEgo setMotion: PolyPath 340 118 self)
				)
			)
			(2
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; map
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

