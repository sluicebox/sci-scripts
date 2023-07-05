;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm395 0
	blockTalker 1
)

(local
	local0
)

(instance rm395 of Room
	(properties
		noun 1
		picture 395
	)

	(method (init)
		(gGame handsOff:)
		(super init: &rest)
		(gGlobalSound0 number: 1026 loop: 1 play: lieutBlock)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 32 114 32 120 319 157 319 155 34 118 34 116 95 116 95 113
					yourself:
				)
		)
		(metzler init:)
		(maleCrowd init:)
		(femCrowd init:)
		(greg init:)
		(theWindow init:)
		(door init:)
		(lieutBlock init:)
		(gEgo
			view: 0
			setHeading: 225
			normalize: 0
			posn: 109 112
			setTalker: egoTalker
			setScaler: Scaler 74 39 137 113
			init:
		)
		(gWalkHandler addToFront: door)
		(gEgo setScript: entryScript)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo x:) 170)
				(self newRoom: 390)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: door)
		(super dispose:)
	)
)

(instance entryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 94 113 self)
			)
			(1
				(lieutBlock
					view: 300
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 113 115 self
				)
				(gEgo setHeading: 90)
			)
			(2
				(lieutBlock
					view: 301
					loop: 1
					cel: 0
					posn: 105 116
					setCycle: CT 8 1 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gMessager say: 2 2 2 0 self) ; "Carey, another body was brought in this morning, same MO. This time, it isn't an officer. It's a female, current status, Jane Doe. She was found in Griffith Park."
			)
			(5
				(gGame handsOn:)
				(= ticks 600)
			)
			(6
				(gEgo setScript: mayorCalls)
				(self dispose:)
			)
		)
	)
)

(instance mayorCalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 450)
			)
			(1
				(if local0
					(gMessager say: 3 2 3 2 self) ; "Detective Carey, please step forward."
				else
					(= local0 1)
					(gMessager say: 3 2 3 1 self) ; "Ladies and gentleman, I see Detective Carey has been kind enough to attend this session. Detective Carey, please step up front."
				)
			)
			(2
				(= ticks 450)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance blockBlocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 94 113 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(lieutBlock
					view: 301
					loop: 2
					cel: 0
					posn: 114 116
					setCycle: End self
				)
			)
			(3
				(lieutBlock loop: 3 cel: 0 setCycle: End self)
			)
			(4
				(gMessager sayRandom: 2 2 1 self)
			)
			(5
				(gGame handsOn:)
				(lieutBlock view: 301 loop: 1 cel: 8 posn: 105 116)
				(gEgo setScript: mayorCalls)
			)
		)
	)
)

(instance lieutBlock of Actor
	(properties
		noun 2
		x 140
		y 115
		view 300
		loop 1
		signal 16385
	)

	(method (cue)
		(gGlobalSound0 number: 1027 loop: -1 play:)
	)
)

(instance metzler of Feature
	(properties
		noun 5
		x 315
		y 171
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 319 153 289 153 291 144 297 130 299 128 306 124 314 119 319 112
				yourself:
			)
		)
	)
)

(instance maleCrowd of Feature
	(properties
		noun 5
		x 49
		y 126
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 48 96 52 96 53 98 54 105 58 109 60 117 56 117 45 119 40 118 39 113 40 107 45 104 45 101 47 98
				yourself:
			)
		)
	)
)

(instance femCrowd of Feature
	(properties
		noun 5
		x 131
		y 125
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 130 95 132 97 133 102 133 105 136 108 136 112 139 115 132 117 131 112 130 109 123 108 123 105 122 103 126 95
				yourself:
			)
		)
	)
)

(instance greg of Feature
	(properties
		noun 5
		x 254
		y 129
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 248 91 251 91 254 95 254 102 256 105 263 116 270 128 269 130 266 129 264 128 261 125 259 113 248 113 247 118 237 120 236 112 240 105 244 101 244 98 243 93
				yourself:
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 4
		x 242
		y 44
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 157 43 183 42 183 96 157 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 225 38 262 37 265 96 226 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 307 34 319 34 319 97 304 96
					yourself:
				)
		)
	)
)

(instance door of Feature
	(properties
		nsLeft 106
		nsTop 62
		nsRight 116
		nsBottom 104
		x 116
		y 83
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo setScript: blockBlocks)
		else
			(super doVerb: theVerb)
		)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOVE))
			(gEgo setScript: blockBlocks)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance blockTalker of Narrator
	(properties
		x 150
		y 15
		talkWidth 140
	)
)

(instance egoTalker of Narrator
	(properties
		x 10
		y 15
	)
)

