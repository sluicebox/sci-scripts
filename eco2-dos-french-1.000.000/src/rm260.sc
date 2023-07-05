;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Climber)
(use Jungle)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
	humTalker 1
	cockTalker 2
	caciqueTalker 3
)

(local
	local0
	local1
	local2
	[local3 6]
	[local9 2]
	local11 = 100
	local12
	[local13 45] = [98 243 89 243 76 242 60 241 49 243 41 241 54 274 54 280 41 289 103 164 99 170 90 154 76 160 212 196 215 197 292 244 169 188 172 190 132 272 141 263 154 277 158 280 -1]
)

(instance rm260 of Rm
	(properties
		noun 6
		picture 260
		style 10
	)

	(method (dispose)
		((Jungle climbers:) dispose:)
		(Jungle climbers: 0)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(if (== gPrevRoomNum 240)
			(= style 14)
		)
		(LoadMany rsVIEW 0 6 7 205 5 2 265 1269)
		(Jungle climbers: (List new:))
		((Jungle climbers:) add: ctrl9 ctrl10 ctrl11 ctrl12 ctrl13 ctrl14)
		(crown init:)
		(sky init:)
		(hoatzin
			init:
			setScript: (if (gCurrentRegionFlags test: 3) agitation else sleeping)
		)
		(wPitcher setCel: (if (gCurrentRegionFlags test: 4) 255 else 0) init:)
		(rPitcher setCel: (if (gCurrentRegionFlags test: 5) 255 else 0) init:)
		(= local11 300)
		(humBird init: setCycle: Fwd)
		(cacique init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(cock init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(if (not (IsEcorderFlag 10))
			(emergentTree init:)
		)
		(self setScript: fromNest)
		(gEgo actions: egoActions)
		(super init: &rest)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			((= [local3 temp0] (localOrchid new:))
				init:
				x:
					(switch temp0
						(0 90)
						(1 170)
						(2 205)
						(3 300)
						(4 135)
						(5 55)
					)
				y:
					(switch temp0
						(0 60)
						(1 90)
						(2 95)
						(3 150)
						(4 160)
						(5 180)
					)
				setOnMeCheck:
					2
					(switch temp0
						(0
							((Polygon new:)
								type: PTotalAccess
								init: 89 50 106 56 106 70 94 73 86 54
								yourself:
							)
						)
						(1
							((Polygon new:)
								type: PTotalAccess
								init: 162 84 177 87 172 92 161 90
								yourself:
							)
						)
						(2
							((Polygon new:)
								type: PTotalAccess
								init: 179 100 199 89 219 94 223 100 205 99 182 109 171 109
								yourself:
							)
						)
						(3
							((Polygon new:)
								type: PTotalAccess
								init: 292 139 314 150 315 157 300 159 286 148
								yourself:
							)
						)
						(4
							((Polygon new:)
								type: PTotalAccess
								init: 140 120 139 148 130 164 144 173 160 167 167 179 166 189 156 189 155 181 141 181 126 176 128 164 118 162 128 152 128 113
								yourself:
							)
						)
						(5
							((Polygon new:)
								type: PTotalAccess
								init: 59 168 56 181 44 189 38 189 36 186 47 180 51 169
								yourself:
							)
						)
					)
			)
			(gTheDoits add: [local3 temp0])
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			((= [local9 temp0] (localEpiphyte new:))
				init:
				x: (if (not temp0) 230 else 65)
				y: (if (not temp0) 105 else 140)
				setOnMeCheck:
					2
					(switch temp0
						(0
							((Polygon new:)
								type: PTotalAccess
								init: 241 101 235 125 229 120 223 103 231 94
								yourself:
							)
						)
						(1
							((Polygon new:)
								type: PTotalAccess
								init: 30 135 59 132 68 143 78 137 99 139 98 148 86 151 57 147 46 152 28 145
								yourself:
							)
						)
					)
			)
			(gTheDoits add: [local9 temp0])
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance localOrchid of Orchid
	(properties)

	(method (doit)
		(if
			(and
				(not (self onMe: (humBird x:) (- (humBird y:) (humBird z:))))
				(not (IsEcorderFlag 11))
			)
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance localEpiphyte of Epiphyte
	(properties)

	(method (doit)
		(if
			(and
				(not (self onMe: (humBird x:) (- (humBird y:) (humBird z:))))
				(not (IsEcorderFlag 7))
			)
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance exitSouth of ExitFeature
	(properties
		nsTop 180
		nsLeft 128
		nsBottom 189
		nsRight 183
		cursor 10
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo setScript: toNest)
		)
	)
)

(instance crown of Feature
	(properties
		x 164
		y 10
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 1 81 36 24 104 5 132 12 157 0 233 10 230 17 269 20 310 65 318 98 307 118 275 109 278 76 251 86 235 67 250 49 218 37 195 57 76 57 58 84 32 91 40 101 67 93 71 103 50 125 14 126 19 109 1 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance emergentTree of Feature
	(properties
		y 200
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 78 36 25 158 1 266 20 307 61 316 117 148 142 0 117
					yourself:
				)
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 10))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (self perform: gWriteEcorderData theVerb 10)
			(self dispose:)
		)
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== ((gTheIconBar curInvIcon:) message:) 55)
				)
				(if (or (cacique onMe: param1 &rest) (cock onMe: param1 &rest))
					(return 0)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance sky of Feature
	(properties
		x 160
		y 9
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 145 0 0 319 0 319 149 265 131 212 151 204 149 219 114 249 106 274 107 307 118 317 100 309 65 269 20 231 17 233 10 157 1 132 12 103 5 37 24 4 80 3 99 19 109 14 126
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hoatzin of Prop
	(properties
		x 200
		y 172
		noun 5
		view 268
		loop 2
		signal 20480
		cycleSpeed 24
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 29))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 29))
			(switch theVerb
				(2 ; Talk
					(if (not (gCurrentRegionFlags test: 12))
						(gCurrentRegionFlags set: 12)
						(gGame points: 1)
					)
					(self setScript: hoatzinTalks)
				)
				(16 ; flowers
					(self setScript: humBirdTalk 0 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance wPitcher of Prop
	(properties
		x 197
		y 161
		noun 1
		view 265
		signal 16385
		cycleSpeed 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 186 155 193 151 200 151 206 160 189 163
					yourself:
				)
		)
		(super init:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 9))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (self perform: gWriteEcorderData theVerb 9))
			(= temp0 (gCurrentRegionFlags test: 4))
			(switch theVerb
				(4 ; Do
					(if (OneOf (gEgo script:) ctrl9 ctrl11)
						(if temp0
							(gMessager say: noun theVerb 3) ; "Adam has emptied all the water from this pitcher plant."
						else
							(gEgo setScript: tipWrongPitcher)
						)
					else
						(gMessager say: noun theVerb 8) ; "Adam can't reach the pitcher plant from here."
					)
				)
				(1 ; Look
					(if temp0
						(gMessager say: noun theVerb 3) ; "There's no more water in the pitcher plant."
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
)

(instance rPitcher of Prop
	(properties
		x 260
		y 161
		noun 2
		view 265
		loop 1
		signal 16385
		cycleSpeed 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 255 150 276 150 279 159 260 163 252 161 250 153
					yourself:
				)
		)
		(super init:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 9))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (self perform: gWriteEcorderData theVerb 9))
			(= temp0 (gCurrentRegionFlags test: 5))
			(switch theVerb
				(4 ; Do
					(if (OneOf (gEgo script:) ctrl9 ctrl11)
						(cond
							(temp0
								(gMessager say: noun theVerb 3) ; "There's no more water in the pitcher plant."
							)
							((not local2)
								(gEgo setScript: smellBad)
							)
							(else
								(gEgo setScript: tipRightPitcher)
							)
						)
					else
						(gMessager say: 1 theVerb 8) ; "Adam can't reach the pitcher plant from here."
					)
				)
				(1 ; Look
					(if temp0
						(gMessager say: noun theVerb 3) ; "There's no more water in the pitcher plant."
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
)

(instance humBird of Actor
	(properties
		x 198
		y 235
		z 100
		noun 7
		view 260
		loop 2
		cel 1
		signal 18432
		scaleSignal 1
		scaleX 100
		scaleY 100
		cycleSpeed 0
		moveSpeed 0
	)

	(method (doit)
		(if (not (IsEcorderFlag 28))
			(self perform: gCheckEcorderIcon self)
		)
		(if (and (not mover) (< (-- local11) 0))
			(= local11 (Random 40 200))
			(if (< [local13 (+= local12 2)] 0)
				(= local12 0)
			)
			(self setMotion: MoveTo [local13 local12] [local13 (+ local12 1)])
		)
		(if (> y 155)
			(if (< priority 14)
				(self setPri: 14)
			else
				(self setPri: -1)
			)
		)
		(super doit:)
	)

	(method (setHeading)
		(super setHeading: &rest)
		(= loop (if (< heading 180) 3 else 2))
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 28))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 19))
					(gCurrentRegionFlags set: 19)
					(gGame points: 1)
				)
				(self setScript: humBirdTalk 0 0)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cacique of Prop
	(properties
		x 115
		y 41
		noun 8
		view 260
		loop 1
		signal 16385
		scaleSignal 1
		scaleX 96
		scaleY 96
		detailLevel 3
	)

	(method (doit)
		(if (not (IsEcorderFlag 26))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 26))
			(super doVerb: theVerb)
		)
	)
)

(instance cock of Prop
	(properties
		x 74
		y 46
		noun 10
		view 260
		loop 4
		signal 16385
		scaleSignal 1
		scaleX 76
		scaleY 76
		detailLevel 4
	)

	(method (doit)
		(if (not (IsEcorderFlag 31))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 31))
			(if (and (== theVerb 2) (not (gCurrentRegionFlags test: 29))) ; Talk
				(gCurrentRegionFlags set: 29)
				(gGame points: 1)
			)
			(super doVerb: theVerb)
		)
	)
)

(instance ctrl9 of Climber
	(properties
		myColor 512
		from3 2048
		access3 29696
	)

	(method (init)
		(= from3S ctrl9From3)
		(super init: &rest)
	)
)

(instance ctrl9From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(gEgo
						view: 261
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo 227 164 self
					)
				else
					(gEgo setScript: smellBad)
				)
			)
			(1
				(gEgo view: 205 setMotion: MoveTo 240 172 self)
			)
			(2
				(gEgo setMotion: MoveTo 250 172 self)
			)
			(3
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl10 of Climber
	(properties
		myColor 1024
		from1 2048
		from2 4096
		from3 8192
		from4 16384
		access1 512
	)

	(method (init)
		(= from1S ctrl10From1)
		(= from2S ctrl10From2)
		(= from3S ctrl10From3)
		(= from4S ctrl10From4)
		(super init: &rest)
	)
)

(instance ctrl10From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 305 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 152 143 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 113 149 self)
			)
			(3
				(gEgo setMotion: MoveTo 98 162 self)
			)
			(4
				(gEgo setMotion: MoveTo 79 161 self)
			)
			(5
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl10From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 129 84 self
				)
			)
			(1
				(gEgo setLoop: 1 normalize: 0 setHeading: 270 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 4
					posn: 138 115
					setCel: 255
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 6
					setLoop: 2
					setCel: 0
					y: 95
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Rev
					setMotion: MoveTo 142 125 self
				)
			)
			(4
				(gEgo
					view: 7
					setLoop: 2
					posn: 145 150
					setPri: 13
					setCel: 255
					setCycle: Beg self
				)
			)
			(5
				(gEgo normalize: 0 setPri: 13 setHeading: 270 self)
			)
			(6
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 153 146 self
				)
			)
			(7
				(gEgo setMotion: MoveTo 113 149 self)
			)
			(8
				(gEgo setMotion: MoveTo 98 162 self)
			)
			(9
				(gEgo setMotion: MoveTo 79 161 self)
			)
			(10
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl10From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 174 110 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 7
					posn: 159 149
					setLoop: 6
					setCel: 255
					setCycle: Beg self
				)
			)
			(3
				(gEgo setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(4
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 153 146 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 113 149 self)
			)
			(6
				(gEgo setMotion: MoveTo 98 162 self)
			)
			(7
				(gEgo setMotion: MoveTo 79 161 self)
			)
			(8
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl10From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 7
					posn: 140 185
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo posn: 141 183 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo
					posn: 130 148
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 113 149 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 98 162 self)
			)
			(5
				(gEgo setMotion: MoveTo 79 161 self)
			)
			(6
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11 of Climber
	(properties
		myColor 2048
		from1 1024
		from2 512
		from3 16384
		from4 8192
		from5 4096
	)

	(method (init)
		(= from1S ctrl11From1)
		(= from2S ctrl11From2)
		(= from3S ctrl11From3)
		(= from4S ctrl11From4)
		(= from5S ctrl11From5)
		(super init: &rest)
	)
)

(instance ctrl11From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 98 162 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 109 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 130 148 self)
			)
			(3
				(gEgo setMotion: MoveTo 157 145 self)
			)
			(4
				(gEgo setMotion: MoveTo 171 153 self)
			)
			(5
				(gEgo setMotion: MoveTo 178 165 self)
			)
			(6
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 240 172 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 228 167 self)
			)
			(2
				(gEgo view: 261 setLoop: 1 setMotion: MoveTo 178 165 self)
			)
			(3
				(gEgo normalize: 0)
				(if (!= (Jungle climbColor:) (client myColor:))
					(gEgo setHeading: 180 self)
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 7
					posn: 150 184
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 149 182 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo posn: 159 147 normalize: 0 setHeading: 135 self)
			)
			(3
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 171 153 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 178 165 self)
			)
			(5
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setScale: Scaler 89 81 110 103
					setMotion: MoveTo 173 110 self
				)
			)
			(1
				(gEgo
					view: 7
					setLoop: 6
					setCel: 255
					posn: 159 149
					setCycle: Beg self
				)
			)
			(2
				(gEgo setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 171 153 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 178 165 self)
			)
			(5
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11From5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 133 85 self
				)
			)
			(1
				(gEgo normalize: 0 setHeading: 270 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 4
					setCel: 255
					posn: 142 119
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 6
					setCel: 0
					setLoop: 2
					posn: 141 98
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 146 125 self
				)
			)
			(4
				(gEgo view: 7 setCel: 255 posn: 146 149 setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0 setHeading: 90 self)
			)
			(6
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 164 150 self
				)
			)
			(7
				(gEgo setMotion: MoveTo 171 153 self)
			)
			(8
				(gEgo setMotion: MoveTo 178 165 self)
			)
			(9
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12 of Climber
	(properties
		myColor 4096
		from1 16384
		from2 8192
		from3 2048
		from4 1024
		access3 2
	)

	(method (init)
		(= from1S ctrl12From1)
		(= from2S ctrl12From2)
		(= from3S ctrl12From3)
		(= from4S ctrl12From4)
		(super init: &rest)
	)
)

(instance ctrl12From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					posn: 145 161
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 138 95 self
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 4
					setCel: 0
					posn: 138 115
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 205
					setLoop: 1
					setCycle: Walk
					posn: 129 84
					setMotion: MoveTo 118 84 self
				)
			)
			(5
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
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
				(gEgo view: 205 setMotion: MoveTo 156 123 self)
			)
			(1
				(gEgo view: 7 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					setLoop: 1
					posn: 157 121
					xStep: 4
					yStep: 6
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 138 115 self
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 4
					setCel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					posn: 129 84
					setMotion: MoveTo 118 84 self
				)
			)
			(5
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 161 147 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 147 144 self)
			)
			(3
				(gEgo setHeading: 0 self)
			)
			(4
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo
					view: 6
					posn: 147 124
					setCel: 0
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 138 95 self
				)
			)
			(6
				(gEgo
					view: 7
					setLoop: 4
					posn: 138 115
					setCel: 0
					setCycle: End self
				)
			)
			(7
				(gEgo
					posn: 129 84
					setLoop: 1
					normalize: 0
					setHeading: 270 self
				)
			)
			(8
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 118 84 self
				)
			)
			(9
				(gEgo normalize: 0 setPri: 13 setHeading: 180 self)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 98 162 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 109 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 130 148 self)
			)
			(3
				(gEgo setMotion: MoveTo 143 150 self)
			)
			(4
				(gEgo normalize: 0 setHeading: 0 self)
			)
			(5
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(gEgo
					view: 6
					setCel: 0
					posn: 143 125
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 138 95 self
				)
			)
			(7
				(gEgo
					view: 7
					setLoop: 4
					setCel: 0
					posn: 138 115
					setCycle: End self
				)
			)
			(8
				(gEgo
					view: 205
					setLoop: 1
					setCycle: Walk
					posn: 129 84
					setMotion: MoveTo 118 84 self
				)
			)
			(9
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13 of Climber
	(properties
		myColor 8192
		from1 4096
		from2 16384
		from3 2048
		from4 1024
		access3 512
	)

	(method (init)
		(= from1S ctrl13From1)
		(= from2S ctrl13From2)
		(= from3S ctrl13From3)
		(= from4S ctrl13From4)
		(super init: &rest)
	)
)

(instance ctrl13From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 129 84 self
				)
			)
			(1
				(gEgo setLoop: 1 normalize: 0 setHeading: 270 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 4
					posn: 138 115
					setCel: 255
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 6
					setCel: 0
					setLoop: 1
					xStep: 4
					yStep: 6
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setSpeed: 12
					setCycle: Rev
					setMotion: MoveTo 157 121 self
				)
			)
			(4
				(gEgo
					view: 7
					setLoop: 0
					setCel: 255
					setSpeed: 6
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					posn: 156 123
					setMotion: MoveTo 197 103 self
				)
			)
			(6
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(7
				(gGame handsOn:)
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
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					posn: 145 161
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 145 137 self
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 6
					posn: 145 161
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					posn: 157 120
					setScale: Scaler 89 81 120 103
					setMotion: MoveTo 197 103 self
				)
			)
			(5
				(gEgo normalize: 0 setScale: setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 305 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 159 149 self
				)
			)
			(2
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 6 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					posn: 173 110
					setScale: Scaler 89 81 110 103
					setMotion: MoveTo 197 103 self
				)
			)
			(5
				(gEgo normalize: 0 setScale: setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 98 162 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 113 149 self)
			)
			(3
				(gEgo setMotion: MoveTo 153 146 self)
			)
			(4
				(gEgo setMotion: MoveTo 159 149 self)
			)
			(5
				(gEgo normalize: 0 setHeading: 0 self)
			)
			(6
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(gEgo setLoop: 6 setCel: 0 setCycle: End self)
			)
			(8
				(gEgo posn: 174 110 normalize: 0 setHeading: 45 self)
			)
			(9
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 197 104 self
				)
			)
			(10
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14 of Climber
	(properties
		myColor 16384
		from1 8192
		from2 4096
		from3 1024
		from4 2048
		access4 512
	)

	(method (dispose)
		(exitSouth dispose:)
		(super dispose:)
	)

	(method (init)
		(= from1S ctrl14From1)
		(= from2S ctrl14From2)
		(= from3S ctrl14From3)
		(= from4S ctrl14From4)
		(exitSouth init:)
		(super init: &rest)
	)
)

(instance ctrl14From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 205 setMotion: MoveTo 157 120 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 6
					posn: 145 161
					setCel: 255
					setScale:
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 2
					posn: 145 137
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Rev
					setMotion: MoveTo 145 161 self
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 2
					posn: 145 184
					setPri: 13
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(gEgo normalize: 0 setPri: 13 setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 129 84 self
				)
			)
			(1
				(gEgo setLoop: 1 normalize: 0 setHeading: 270 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 4
					posn: 138 115
					setCel: 255
					setCycle: Beg self
				)
			)
			(3
				(gEgo
					view: 6
					setLoop: 2
					setCel: 0
					y: 95
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Rev
					setMotion: MoveTo 145 161 self
				)
			)
			(4
				(gEgo
					view: 7
					setLoop: 2
					posn: 145 184
					setPri: 13
					setCel: 255
					setCycle: Beg self
				)
			)
			(5
				(gEgo normalize: 0 setPri: 13 setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 98 162 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 109 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 130 148 self)
			)
			(3
				(gEgo normalize: 0 setHeading: 270 self)
			)
			(4
				(gEgo
					view: 7
					posn: 141 183
					setLoop: 4
					setCel: 255
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					posn: 140 185
					setLoop: 0
					setPri: 13
					setCel: 255
					setCycle: Beg self
				)
			)
			(6
				(gEgo
					posn: 145 184
					normalize: 0
					setPri: 13
					setHeading: 180 self
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 305 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 159 147 self
				)
			)
			(2
				(gEgo normalize: 0 setPri: 13 setHeading: 90 self)
			)
			(3
				(gEgo
					view: 7
					setLoop: 5
					posn: 149 182
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					setLoop: 1
					posn: 150 184
					setCel: 255
					setCycle: Beg self
				)
			)
			(5
				(gEgo
					normalize: 0
					setPri: 13
					posn: 145 185
					setHeading: 180 self
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toNest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					posn: 145 165
					setCycle: Rev
					yStep: 4
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setMotion: MoveTo 145 178 self
				)
			)
			(3
				(gCurRoom newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance fromNest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 7
					setLoop: 2
					setCel: 255
					posn: 145 185
					setPri: 13
					init:
					scaleX: 110
					scaleY: 110
					scaleSignal: (| (gEgo scaleSignal:) $0005)
					setScale:
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					setScript: ctrl14 0 999
					normalize: 0
					setPri: 13
					setHeading: 180 self
				)
			)
			(2
				(if (not (gCurrentRegionFlags test: 3))
					(gCurrentRegionFlags set: 3)
					(= local0 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tipWrongPitcher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurrentRegionFlags set: 4)
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 195 162 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 207 163 self)
			)
			(2
				(gEgo normalize: 0 setHeading: 270 self)
			)
			(3
				(gEgo view: 5 setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(4
				(wPitcher setCycle: CT 2 1 self)
				(if (> (gGame detailLevel:) 4)
					((= local1 (Prop new:))
						view: 265
						posn: 194 153
						loop: 2
						cel: 0
						setPri: 12
						cycleSpeed: 12
						init:
						setScript: frogGone
					)
				)
			)
			(5
				(wPitcher setCycle: End self)
				(sFX number: 270 play:)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 195 162 self
				)
			)
			(8
				(gEgo setMotion: MoveTo 178 165 self)
			)
			(9
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(10
				(gGame handsOn:)
				(client setScript: ctrl11 0 999)
			)
		)
	)
)

(instance tipRightPitcher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 5)
				(gCurrentRegionFlags set: 5)
				(gEgo
					view: 261
					setLoop: (if (< (gEgo x:) 222) 0 else 1)
					setCycle: Walk
					setMotion: MoveTo 222 164 self
				)
			)
			(1
				(gEgo
					view: 205
					setScale: Scaler 89 81 164 160
					setLoop: 6
					setMotion: MoveTo 231 160 self
				)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 243 157 self)
			)
			(3
				(gEgo view: 5 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(4
				(rPitcher setCycle: End self)
				(sFX number: 270 play:)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 231 160 self
				)
			)
			(7
				(Jungle setScript: 0)
				(gEgo setLoop: 5 setMotion: MoveTo 222 164 self)
			)
			(8
				(gEgo
					view: 261
					setLoop: 1
					setScale:
					setMotion: MoveTo 178 165 self
				)
			)
			(9
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(10
				(gGame handsOn:)
				(client setScript: ctrl11 0 999)
			)
		)
	)
)

(instance smellBad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 2 setLoop: 7 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gMessager say: 5 0 2 0 self) ; "Eeeerck. Ptui!"
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 4 normalize: 0 setScript: ctrl11 0 999)
			)
		)
	)
)

(instance frogGone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client posn: 208 166)
				(= ticks 6)
			)
			(2
				(client posn: 221 185)
				(= ticks 6)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance sleeping of Script
	(properties)

	(method (doit)
		(if (and local0 (< state 4))
			(= ticks (= seconds 0))
			(self changeState: 4)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= ticks 24)
			)
			(3
				(client setCel: 0)
				(if (not local0)
					(= state -1)
				)
				(self cue:)
			)
			(4
				(gGame handsOff:)
				(client setLoop: 1 setCel: 0)
				(= ticks 50)
			)
			(5
				(client setCel: 1)
				(= ticks 50)
			)
			(6
				(client setCel: 2)
				(= ticks 60)
			)
			(7
				(client setLoop: 0 setCel: 0 cycleSpeed: 6 setCycle: Fwd)
				(gGameSound2 number: 272 loop: 1 play: self)
				(= ticks 120)
			)
			(8
				(= ticks 20)
			)
			(9
				(gGameSound2 play: self)
			)
			(10
				(= ticks 20)
			)
			(11
				(gGameSound2 play: self)
			)
			(12
				(client setCycle: End self)
			)
			(13
				(gMessager say: 5 0 1 0 self) ; "The end of the world is coming!!"
			)
			(14
				(gGame handsOn:)
				(client setScript: agitation)
			)
		)
	)
)

(instance agitation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client setLoop: 3 cycleSpeed: 18 setCycle: Fwd)
					(= ticks (Random 60 120))
				else
					(client setLoop: 3 setCycle: 0 stopUpd:)
					(-= state 1)
					(= seconds 4)
				)
			)
			(1
				(client setLoop: 1 setCycle: Fwd)
				(= ticks (Random 40 80))
			)
			(2
				(client setLoop: 3 setCycle: Rev)
				(= ticks (Random 60 120))
			)
			(3
				(client setLoop: 1 setCycle: Rev)
				(= ticks (Random 40 80))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance hoatzinTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCurrentRegionFlags test: 16)
					(self cue:)
				else
					(gMessager say: 5 2 6 1 self) ; "What's the matter?"
				)
			)
			(1
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client setLoop: 0 setCel: 0 cycleSpeed: 6 setCycle: Fwd)
					(= ticks 40)
				else
					(self cue:)
				)
			)
			(2
				(if (gCurrentRegionFlags test: 16)
					(gMessager say: 5 2 0 0 self) ; "Doom, doom, and destruction! What are you still doing here?"
				else
					(gCurrentRegionFlags set: 16)
					(gMessager say: 5 2 6 2 8 self) ; "Don't you see it? The great cloud is hanging over the forest and soon it will fall. Fly, you idiot. Take wing!"
				)
			)
			(3
				(gGame handsOn:)
				(client setScript: agitation)
			)
		)
	)
)

(instance humBirdTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gMessager say: 5 16 0 0 self) ; "Phew! Those stink."
				else
					(gMessager say: 7 2 0 0 self) ; "Ugh, I can't stand that hoatzin! He smells terrible and he's raving!"
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 16) ; flowers
			(if (OneOf (gEgo script:) ctrl9 ctrl11)
				(if (not (gCurrentRegionFlags test: 32))
					(gCurrentRegionFlags set: 32)
					(gGame points: 5)
				)
				(gMessager say: 11 16 2) ; "Adam holds the flowers to his nose like a gas mask."
				(= local2 1)
				(gEgo view: 261 setLoop: 0 setCycle: 0 looper: 0)
			else
				(gMessager say: 11 16) ; "Adam holds the fragrant blossoms up to his nose."
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance humTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self
			x: (+ (humBird x:) 20)
			y: (- (humBird y:) (+ (humBird z:) 10))
			font: gUserFont
		)
		(super init:)
	)
)

(instance cockTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (cock x:) 20) y: (- (cock y:) 10) font: gUserFont)
		(super init:)
	)
)

(instance caciqueTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init &tmp [temp0 20])
		(self x: (+ (cacique x:) 20) y: (- (cacique y:) 10) font: gUserFont)
		(super init:)
	)
)

