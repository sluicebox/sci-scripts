;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Climber)
(use Jungle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm220 of Eco2Room
	(properties
		noun 11
		picture 220
		style 10
		west 200
	)

	(method (dispose)
		((Jungle climbers:) dispose:)
		(Jungle climbers: 0)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(gDirectionHandler add: self)
		(switch gPrevRoomNum
			(200
				(= style 12)
			)
			(240
				(= style 13)
			)
		)
		(Load rsMESSAGE 220)
		(if (not (gCurrentRegionFlags test: 9))
			(Load rsVIEW 5)
		)
		(Jungle climbers: (List new:))
		((Jungle climbers:) add: ctrl11 ctrl12 ctrl13 ctrl14)
		(trunk init:)
		(buttress init:)
		(othertree1 init:)
		(othertree2 init:)
		(felledtree init:)
		(campfire init: approachVerbs: (if (gCurrentRegionFlags test: 9) 0 else 4))
		(ground init:)
		(exitWest init:)
		(smoke init:)
		(LoadMany rsVIEW 1 6 7 205)
		(gEgo
			init:
			actions: (ScriptID 299 3) ; egoActions
			normalize: 0
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			setScale: Scaler 100 80 185 100
		)
		(super init: &rest)
		(if (not (gCurrentRegionFlags test: 1))
			(monkey init:)
			(= local4 1)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 88 0 0 319 0 319 189 0 189 0 183 269 183 293 170 293 118 257 123 237 138 216 134 183 134 183 137 195 137 195 150 154 158 116 157 102 150 68 150 53 137 13 126 17 120 60 120 60 115 14 115 17 102 29 98 32 88
					yourself:
				)
		)
		(gGame handsOn:)
		(if (== gPrevRoomNum 240)
			(gEgo
				posn: 169 31
				setPri: 14
				setLoop: 4
				setScript: ctrl14 0 999
				setHeading: 180
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(cond
			(
				(or
					(gEgo script:)
					(not
						(= temp0
							(OneOf
								(OnControl CONTROL (event x:) (event y:))
								16384
								8192
								4096
							)
						)
					)
					(not
						(and
							(OneOf ((gTheIconBar curIcon:) message:) 4 3)
							(or
								(== (= temp1 (event type:)) evMOUSEBUTTON)
								(and (== temp1 evKEYBOARD) (== (event message:) KEY_RETURN))
							)
							(not (event modifiers:))
						)
					)
				)
				(event claimed: 0)
				(return 0)
			)
			((not (gCurrentRegionFlags test: 0))
				(gEgo
					setScript: gnatAttack 0 (if (> (gEgo x:) 130) 1 else 0)
				)
				(event claimed: 1)
			)
			(else
				(ctrl11
					from1: (if (= temp2 (< (gEgo x:) 160)) 8192 else 4096)
					from2: (if temp2 4096 else 8192)
				)
				(gEgo setScript: ctrl11 0 999 handleEvent: event)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				local4
				(not (gEgo view:))
				(or (> (gEgo x:) 67) (< (gEgo y:) 135))
			)
			(= local4 0)
			(if (gCurRoom script:)
				((gCurRoom script:) dispose:)
			)
			(if (gEgo script:)
				(gEgo setScript: 0)
			)
			(monkey setScript: bananaSplits)
		)
	)
)

(instance trunk of Feature
	(properties
		x 155
		y 50
		noun 1
		approachX 149
		approachY 70
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if
				(or
					(== ((gTheIconBar curIcon:) message:) 1)
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== ((gTheIconBar curInvIcon:) message:) 55)
					)
				)
				(if (and (not (IsObject param1)) (monkey onMe: param1 &rest))
					(return 0)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 82 79 79 69 104 56 95 50 112 32 99 13 119 0 175 0 178 10 189 14 183 19 183 24 195 30 191 36 201 43 195 57 208 89 200 92 170 81 160 37 152 32 152 49 137 58 101 62 96 71
					yourself:
				)
		)
		(super init:)
		(gTheDoits add: self)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 4))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 4))
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance branch of Feature ; UNUSED
	(properties
		x 227
		y 134
		z 130
		noun 12
		nsLeft 207
		nsBottom 9
		nsRight 247
		approachX 227
		approachY 4
		approachDist 119
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 249 3 248 8 242 10 233 6 228 9 215 8 206 0 249 0
					yourself:
				)
		)
		(super init:)
	)
)

(instance buttress of Feature
	(properties
		x 155
		y 115
		noun 2
		approachX 137
		approachY 140
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if
				(or
					(== ((gTheIconBar curIcon:) message:) 1)
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== ((gTheIconBar curInvIcon:) message:) 55)
					)
				)
				(if (and (not (IsObject param1)) (monkey onMe: param1 &rest))
					(return 0)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 65 80 83 79 96 71 97 65 136 57 153 50 164 50 167 65 146 68 146 74 151 85 153 95 166 97 164 101 159 102 163 106 173 106 172 91 168 88 168 83 171 81 179 82 201 92 208 90 232 114 253 115 240 133 224 133 206 117 192 133 177 134 187 147 156 146 133 157 103 150 68 145 45 130 31 133 22 128 26 121 38 115 23 115 15 103 62 95
					yourself:
				)
		)
		(super init:)
		(gTheDoits add: self)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 5))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 5))
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(super dispose:)
		(gTheDoits delete: self)
	)
)

(instance othertree1 of Feature
	(properties
		x 28
		y 35
		noun 4
		approachX 28
		approachY 35
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 20 0 75 0 74 20 95 47 97 59 90 63 53 36 54 2 33 12 37 74 18 56
					yourself:
				)
		)
		(super init:)
	)
)

(instance othertree2 of Feature
	(properties
		x 300
		y 50
		noun 4
		approachX 300
		approachY 50
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 292 0 319 0 319 8 313 12 319 39 319 83 308 87 295 79 299 59 299 9
					yourself:
				)
		)
		(super init:)
	)
)

(instance felledtree of Feature
	(properties
		x 248
		y 102
		z 22
		noun 5
		approachX 248
		approachY 81
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 217 74 273 68 319 94 319 112 267 85 248 89 245 95 230 97 207 92 217 83
					yourself:
				)
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 48))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 48))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance campfire of Feature
	(properties
		x 260
		y 12
		noun 6
		nsTop 94
		nsLeft 237
		nsBottom 111
		nsRight 284
		approachX 262
		approachY 113
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (not (gCurrentRegionFlags test: 9))) ; Do
			(gCurrentRegionFlags set: 9)
			(self approachVerbs: 0)
			(gEgo setScript: hotFoot)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ground of Feature
	(properties
		x 161
		y 10
		noun 7
		approachX 161
		approachY 169
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 100 29 100 21 115 36 115 19 131 141 157 149 149 188 150 188 141 172 136 182 132 240 132 257 114 275 109 319 109 319 189 0 189
					yourself:
				)
		)
		(super init:)
	)
)

(instance exitWest of ExitFeature
	(properties
		nsTop 83
		nsBottom 183
		nsRight 12
		cursor 12
		exitDir 4
	)

	(method (doit)
		(if (and (OneOf (gTheCursor cel:) cursor 0) (not (gEgo script:)))
			(super doit: &rest)
		)
	)
)

(instance exitNorth of ExitFeature
	(properties
		nsTop 2
		nsLeft 110
		nsBottom 20
		nsRight 190
		cursor 13
		exitDir 1
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo setScript: toBirdsNest)
		)
	)
)

(instance smoke of Prop
	(properties
		x 257
		y 101
		noun 17
		view 220
		loop 6
		signal 16384
		cycleSpeed 20
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance monkey of Actor
	(properties
		x 83
		y 82
		noun 13
		view 80
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 22))
			(switch theVerb
				(2 ; Talk
					(= local4 0)
					(self setScript: bananaSplits)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 22))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (init)
		(super init:)
		(self setScript: monkeyShines)
	)
)

(instance ctrl11 of Climber
	(properties
		myColor 2048
		from1 8192
		from2 4096
		access1 16384
		access2 16384
	)

	(method (init)
		(= from1S climbDownLeft)
		(= from2S climbDownRight)
		(super init: &rest)
	)

	(method (dispose)
		(= from1 8192)
		(= from2 4096)
		(super dispose:)
	)
)

(instance climbDownLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setPri: 11
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 112 65 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 102 68 self)
			)
			(2
				(gEgo setMotion: MoveTo 86 82 self)
			)
			(3
				(gEgo setMotion: MoveTo 68 82 self)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(gEgo
					view: 7
					posn: 60 116
					setLoop: 5
					setCel: 255
					setCycle: Beg self
				)
			)
			(6
				(gEgo setLoop: 1 setCel: 6 setCycle: Beg self)
			)
			(7
				(gEgo
					setLoop: 0
					normalize: 0
					setMotion: PolyPath 30 116 self
				)
			)
			(8
				(gEgo setScript: 0)
			)
		)
	)
)

(instance climbDownRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 3 setCel: 0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					posn: 178 58
					setCycle: Rev
					yStep: 4
					setMotion: MoveTo 183 110 self
				)
			)
			(3
				(gEgo view: 7 posn: 183 134 setCel: 6 setCycle: Beg self)
			)
			(4
				(gEgo
					setLoop: 3
					normalize: 0
					setMotion: PolyPath 200 140 self
				)
			)
			(5
				(self start: 0)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance ctrl12 of Climber
	(properties
		myColor 4096
		from1 2048
		from2 16384
		access2 8192
	)

	(method (init)
		(= from1S ctrl12From1)
		(= from2S ctrl12From2)
		(super init: &rest)
	)
)

(instance ctrl12From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (== (Jungle climbColor:) (client myColor:)))
				(gEgo setMotion: PolyPath 183 134 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 3
					setCel: 0
					setPri: 12
					scaleX: 112
					scaleY: 112
					setScale:
				)
				(if (not local2)
					(= local2 1)
					((= local0 (Actor new:))
						view: 223
						ignoreHorizon: 1
						ignoreActors: 1
						posn: 120 -30
						setStep: 16 12
						setPri: (+ (gEgo priority:) 1)
						setLoop: 4
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: MoveTo 200 50 self
					)
					(gEgo setCycle: End)
				else
					(+= state 3)
					(gEgo setCycle: End self)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(local0 setStep: 9 6 setMotion: MoveTo 325 40 self)
			)
			(4
				(local0 dispose:)
				(= cycles 2)
			)
			(5
				(gEgo
					view: 6
					setCel: 0
					posn: 183 110
					setCycle: Fwd
					yStep: 4
					setMotion:
						MoveTo
						(if register 178 else 185)
						(if register 58 else 48)
						self
				)
			)
			(6
				(if register
					(gEgo view: 7 posn: 178 82 setCel: 6 setCycle: Beg self)
				else
					(ctrl14From1 start: 3)
					(self dispose:)
				)
			)
			(7
				(gEgo normalize: 0 setPri: 12 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (== (Jungle climbColor:) (client myColor:)))
				(gEgo setLoop: -1 setHeading: 0 self)
			)
			(1
				(gEgo
					view: 7
					setPri: 12
					posn: 185 72
					setLoop: 7
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 3
					setCel: 0
					posn: 185 48
					setCycle: Rev
					yStep: 4
					setMotion:
						MoveTo
						(if register 178 else 183)
						(if register 58 else 110)
						self
				)
			)
			(3
				(if register
					(gEgo view: 7 posn: 178 82 setCel: 6 setCycle: Beg self)
				else
					(climbDownRight start: 3)
					(self dispose:)
				)
			)
			(4
				(gEgo normalize: 0 setPri: 12 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13 of Climber
	(properties
		myColor 8192
		from1 2048
		from2 16384
		access2 4096
	)

	(method (init)
		(= from1S ctrl13From1)
		(= from2S ctrl13From2)
		(super init: &rest)
	)
)

(instance ctrl13From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 60 116 self)
			)
			(1
				(gEgo view: 7 setLoop: 1 setCel: 0)
				(if (not local2)
					(= local2 1)
					((= local0 (Actor new:))
						view: 223
						ignoreHorizon: 1
						ignoreActors: 1
						posn: 120 -30
						setStep: 16 12
						setPri: (+ (gEgo priority:) 1)
						setLoop: 4
						cycleSpeed: 4
						init:
						setCycle: Fwd
						setMotion: MoveTo 30 50 self
					)
					(gEgo setCycle: End)
				else
					(+= state 3)
					(gEgo setCycle: End self)
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(local0 setStep: 9 6 setMotion: MoveTo -60 40 self)
			)
			(4
				(local0 dispose:)
				(= cycles 2)
			)
			(5
				(gEgo setLoop: 5 setCel: 0 setCycle: End self)
			)
			(6
				(gEgo
					view: 205
					posn: 68 82
					setPri: 11
					setLoop: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 86 78 self
				)
			)
			(7
				(gEgo setMotion: MoveTo 102 68 self)
			)
			(8
				(gEgo setMotion: MoveTo 112 62 self)
			)
			(9
				(gEgo setMotion: MoveTo 132 62 self)
			)
			(10
				(gEgo setLoop: -1)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setPri: 11 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(1
				(gEgo
					view: 205
					setPri: 11
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 42 self
				)
			)
			(2
				(gEgo setLoop: 6 setMotion: MoveTo 198 41 self)
			)
			(3
				(gEgo setLoop: 7 setPri: -1 setMotion: MoveTo 178 50 self)
			)
			(4
				(gEgo hide:)
				(= ticks (Max (* (gEgo cycleSpeed:) 3) 30))
			)
			(5
				(gEgo
					view: 1
					posn: 185 45
					setLoop: 0
					setPri: 10
					setStep: 2 1
					show:
					setMotion: MoveTo 132 62 self
				)
			)
			(6
				(gEgo setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(7
				(gEgo setLoop: 5 normalize: 0 setPri: 11)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14 of Climber
	(properties
		myColor 16384
		from1 4096
		from2 8192
		access1 2048
		access2 2048
	)

	(method (init)
		(= from1S ctrl14From1)
		(= from2S ctrl14From2)
		(exitNorth init:)
		(super init: &rest)
	)

	(method (dispose)
		(exitNorth dispose:)
		(super dispose:)
	)
)

(instance ctrl14From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 3 setCel: 0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo
					view: 6
					posn: 178 58
					setCycle: Fwd
					setMotion: MoveTo 185 48 self
				)
			)
			(3
				(gEgo
					view: 7
					posn: 185 72
					setLoop: 7
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo
					posn: 169 31
					setLoop: 3
					normalize: 0
					setPri: 13
					setHeading: 180
				)
				(self start: 0 dispose:)
			)
		)
	)
)

(instance ctrl14From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 45 self)
			)
			(1
				(gEgo
					view: 1
					setLoop: 6
					setCel: 0
					setStep: 2 1
					setCycle: End self
				)
			)
			(2
				(gEgo
					setLoop: 2
					setPri: 10
					setCycle: Walk
					setMotion: MoveTo 165 50 self
				)
			)
			(3
				(gEgo hide:)
				(= ticks (Max (* (gEgo cycleSpeed:) 3) 30))
			)
			(4
				(gEgo
					view: 205
					posn: 178 50
					setLoop: 4
					setStep: 3 2
					show:
					setMotion: MoveTo 198 41 self
				)
			)
			(5
				(gEgo setLoop: 5 setPri: 11 setMotion: MoveTo 194 39 self)
			)
			(6
				(gEgo setLoop: 1 setMotion: MoveTo 169 31 self)
			)
			(7
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setPri: 13 setHeading: 180)
				else
					(gEgo setLoop: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance hotFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: -1 setHeading: 0 self)
			)
			(1
				(gEgo view: 5 loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gMessager say: 6 4 6 0 self) ; "Ouch! Still warm!"
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance howl of Sound
	(properties
		number 205
	)
)

(instance monkeyShines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(howl play:)
				(client setCycle: End self)
			)
			(2
				(if (< (++ register) 3)
					(-= state 2)
				)
				(self cue:)
			)
			(3
				(howl stop:)
				(= ticks 6)
			)
			(4
				(client cel: 0)
				(= seconds (Random 6 10))
				(= state 0)
			)
		)
	)
)

(instance bananaSplits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 1)
				(= cycles 2)
			)
			(1
				(gMessager say: 13 2 0 0 self) ; "Human! Tree-cutter! Get away from me or I'll bite you!"
			)
			(2
				(gCurrentRegionFlags set: 1)
				(client setLoop: 7 setCel: 2 setCycle: CT 5 1 self)
			)
			(3
				(client setLoop: 6 setCel: 0 setCycle: End self)
			)
			(4
				(= ticks (monkey cycleSpeed:))
			)
			(5
				(client posn: 66 94)
				(= ticks (monkey cycleSpeed:))
			)
			(6
				(client posn: 54 104)
				(= ticks (monkey cycleSpeed:))
			)
			(7
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance toBirdsNest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: -1 setHeading: 270 self)
			)
			(1
				(gEgo
					view: 205
					ignoreHorizon:
					setCycle: Walk
					setMotion: MoveTo 146 14 self
				)
			)
			(2
				(gEgo normalize: 0 setPri: 14 setHeading: 0 self)
			)
			(3
				(gEgo view: 7 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 6
					posn: 146 -7
					setCycle: Fwd
					setMotion: MoveTo 146 -25 self
				)
			)
			(5
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance gnatAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(if register 183 else 60)
						(if register 134 else 116)
						self
				)
			)
			(1
				(gGameSound2 number: 220 loop: -1 play:)
				((= local0 (Actor new:))
					view: 223
					ignoreHorizon: 1
					ignoreActors: 1
					posn: 120 -30
					setStep: 16 12
					setPri: (+ (gEgo priority:) 1)
					setLoop: 4
					cycleSpeed: 4
					init:
					setCycle: Fwd
					setMotion:
						MoveTo
						(if register 157 else 24)
						(if register 89 else 73)
						self
				)
				(gEgo
					view: 7
					setLoop: (if register 3 else 1)
					setCel: 0
					cycleSpeed: 9
					setCycle: End
				)
			)
			(2
				(gEgo
					view: 223
					setLoop: (if register 3 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(= ticks 6)
			)
			(4
				(gEgo setCycle: CT 5 -1 self)
			)
			(5
				(= ticks 6)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(if (not (gCurrentRegionFlags test: 20))
					(gNarrator y: 20)
					(gMessager say: 11 0 7 1) ; "Ouch! That really bugs me!"
					(gNarrator y: -1)
				)
				(gCurrentRegionFlags set: 20)
				(local0
					setStep: 9 6
					setMotion: MoveTo (if register 325 else -60) 40 self
				)
				(= ticks 60)
			)
			(8
				(gEgo setSpeed: global136 normalize: 0 setHeading: 180)
			)
			(9
				(local0 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gGameSound2 stop:)
		(super dispose:)
	)
)

(instance gnatsRepelled of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(if register 183 else 60)
						(if register 134 else 116)
						self
				)
			)
			(1
				((= local0 (Actor new:))
					view: 223
					ignoreHorizon: 1
					ignoreActors: 1
					posn: 120 -30
					setStep: 16 12
					setPri: (+ (gEgo priority:) 1)
					setLoop: 4
					cycleSpeed: 4
					init:
					setCycle: Fwd
					setMotion: MoveTo (if register 200 else 30) 50 self
				)
				(gEgo
					view: 7
					setLoop: (if register 3 else 1)
					setCel: 0
					cycleSpeed: 9
					setCycle: End
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(local0
					setStep: 9 6
					setMotion: MoveTo (if register 325 else -60) 40 self
				)
			)
			(4
				(local0 dispose:)
				(if register
					(ctrl12From1 start: 2)
				else
					(ctrl13From1 start: 2)
				)
				(gEgo setScript: (if register ctrl12 else ctrl13) 0 999)
				((gEgo script:)
					setScript: (if register ctrl12From1 else ctrl13From1)
				)
			)
		)
	)
)

