;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Climber)
(use Jungle)
(use Scaler)
(use MCyc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	local0 = 5
	[local1 25] = [1 5 130 112 1 3 124 118 1 4 122 124 1 5 128 134 1 6 128 146 1 7 125 168 -32768]
)

(instance rm290 of Eco2Room
	(properties
		noun 11
		picture 290
		style 10
		east 280
		tpX 299
		tpY 38
	)

	(method (init)
		(if (== gPrevRoomNum 280)
			(= style 11)
		)
		(LoadMany rsVIEW 205 5 2 11)
		(garden init:)
		(longhouse init:)
		(hut init:)
		(grove init:)
		(river init:)
		(waterfall init:)
		(frontFoliage init:)
		(leftTree init:)
		(fork init:)
		(liana init:)
		(highBranch init:)
		(backBranch init:)
		(floweringBranch init:)
		(bendingBranch init:)
		(breakingBranch init:)
		(sky init:)
		(mud init:)
		(smoke setCycle: Fwd init:)
		(pig init:)
		(drum init:)
		(Jungle climbers: (List new:))
		((Jungle climbers:) add: ctrl11 ctrl12 ctrl13 ctrl14)
		(gEgo
			init:
			setLoop: 1
			posn: 299 38
			normalize: 0
			scaleX: 115
			scaleY: 115
			scaleSignal: (| (gEgo scaleSignal:) $0005)
		)
		(super init: &rest)
		(gGame handsOn:)
		(if (not (gCurrentRegionFlags test: 7))
			(gCurrentRegionFlags set: 7)
			(gCurRoom setScript: drummerRuns)
			(gGame points: 5)
		else
			(gEgo setScript: ctrl14 0 999)
		)
	)

	(method (doit)
		(if (not (IsFlag 5))
			(Palette palANIMATE 72 78 8)
			(Palette palANIMATE 79 83 4)
			(Palette palANIMATE 84 87 8)
		)
		(super doit:)
	)

	(method (dispose)
		((Jungle climbers:) dispose:)
		(Jungle climbers: 0)
		(super dispose:)
	)
)

(instance exitEast of ExitFeature
	(properties
		nsTop 20
		nsLeft 310
		nsBottom 50
		nsRight 320
		cursor 11
		exitDir 2
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gGame handsOff:)
			(gEgo
				view: 205
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo 320 38
			)
		)
	)
)

(instance liana of Feature
	(properties
		x 85
		y 81
		noun 19
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 264 38 275 49 278 41 288 40 286 45 298 56 300 39 311 29 319 32 319 35 311 36 304 49 308 61 315 55 314 47 319 40 319 65 293 63 282 49 269 53 268 50 263 50 257 58 253 55 256 40
					yourself:
				)
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not (IsEcorderFlag 6))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 6))
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance garden of Feature
	(properties
		x 114
		y 68
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 88 64 160 56 157 60 115 80
					yourself:
				)
		)
		(super init:)
	)
)

(instance longhouse of Feature
	(properties
		x 53
		y 99
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 6 84 33 66 83 64 117 80 121 90 117 105 82 117 36 117
					yourself:
				)
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not (IsEcorderFlag 56))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 56))
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance hut of Feature
	(properties
		x 229
		y 92
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 211 88 221 83 231 83 243 90 239 103 227 106 212 101
					yourself:
				)
		)
		(super init:)
	)
)

(instance grove of Feature
	(properties
		x 160
		y 25
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 19 66 16 98 5 115 10 136 7 168 18 218 6 274 14 282 10 303 12 309 9 319 15 319 32 280 40 274 50 267 39 253 37 240 46 233 43 224 46 216 42 172 49 160 38 130 46 122 42 102 41 91 46 70 45 72 35 81 35 86 29 81 22 74 24 0 30
					yourself:
				)
		)
		(super init:)
	)
)

(instance river of Feature
	(properties
		x 286
		y 85
		noun 7
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 130 54 176 51 212 57 236 70 269 87 259 88 267 96 282 101 287 95 319 102 319 108 299 109 259 100 231 73 221 69 214 61 201 58 131 57
					yourself:
				)
		)
		(super init:)
	)
)

(instance waterfall of Feature
	(properties
		x 286
		y 90
		noun 14
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 263 88 268 87 280 76 304 71 309 74 290 81 284 87 288 97 274 98 264 94
					yourself:
				)
		)
		(super init:)
	)
)

(instance sky of Feature
	(properties
		x 160
		y 12
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 319 0 319 15 309 9 301 12 281 10 272 14 216 6 167 17 136 7 111 9 97 5 65 15 39 2 0 8
					yourself:
				)
		)
		(super init:)
	)
)

(instance mud of Feature
	(properties
		x 110
		y 133
		noun 13
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 62 122 84 115 101 118 98 126 88 129 62 130
					yourself:
				)
		)
		(super init:)
	)
)

(instance frontFoliage of Feature
	(properties
		x 125
		y 150
		noun 15
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 124 14 129 28 125 27 116 56 116 67 133 64 141 78 141 85 152 99 155 108 167 134 155 162 158 179 162 188 179 205 172 247 189 0 189
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftTree of Feature
	(properties
		x 50
		y 50
		noun 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 8 23 8 31 1 44 3 87 27 72 45 113 39 151 56 151 63 98 72 102 79 77 83 71 73 52 75 29 73 25 69 19 74 6 79 7 85 24 91 49 84 58 90 64 100 79 100 83 105 66 113 54 116 27 115 28 125 12 129 0 123
					yourself:
				)
		)
		(super init:)
	)
)

(instance fork of Feature
	(properties
		x 160
		y 89
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 109 86 130 77 154 90 165 89 167 76 184 72 196 88 206 107 196 133 162 156 107 152 98 144 130 127 178 132 130 121 108 123 95 110 124 99 158 114 177 114 190 106 158 102 151 96 143 98 118 92
					yourself:
				)
		)
		(super init:)
	)
)

(instance highBranch of Feature
	(properties
		x 243
		y 62
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 165 52 189 39 207 51 235 42 241 47 256 36 272 42 273 50 281 38 319 29 319 66 291 62 274 74 259 74 253 54 233 64 218 57 199 67 189 57 176 71 158 71
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(return
			(if (and (== theVerb 4) (< (gEgo y:) 100)) ; Do
				0
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance backBranch of Feature
	(properties
		x 294
		y 150
		noun 9
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 203 116 228 129 259 137 262 147 251 150 248 163 291 178 296 174 319 189 245 189 204 173 202 151 196 135
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (gCast contains: jaguar)) ; Look
			(gMessager say: noun theVerb 2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance floweringBranch of Feature
	(properties
		x 294
		y 120
		noun 17
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 223 126 226 118 235 112 242 111 247 106 255 106 268 111 272 110 284 117 295 131 305 118 319 112 319 175 281 175 249 160 249 157 270 145 267 140 272 136 265 132 260 133 255 129 240 130 229 132
					yourself:
				)
		)
		(super init:)
	)
)

(instance drum of View
	(properties
		x 125
		y 90
		noun 2
		view 290
		priority 6
		signal 20496
	)

	(method (doit)
		(if (not (IsEcorderFlag 64))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 64))
			(if (and ((gEgo script:) isKindOf: Climber) (== theVerb 4)) ; Do
				((gEgo script:) findClimber: (Jungle climbColor:))
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jaguar of Actor
	(properties
		x 294
		y 192
		noun 12
		view 290
		loop 5
		priority 15
		signal 18448
		cycleSpeed 12
	)

	(method (doit)
		(if (not (IsEcorderFlag 32))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 32))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance smoke of Prop
	(properties
		x 71
		y 21
		z 60
		noun 18
		view 290
		loop 3
		priority 2
		signal 16400
		cycleSpeed 20
		detailLevel 2
	)
)

(instance breakingBranch of Prop
	(properties
		x 151
		y 98
		noun 1
		view 290
		loop 2
		signal 20481
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			((gEgo script:) findClimber: (Jungle climbColor:))
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bendingBranch of Prop
	(properties
		x 223
		y 102
		noun 8
		view 290
		loop 1
		cel 11
		priority 5
		signal 20497
	)

	(method (doVerb theVerb)
		(return
			(if (and (== theVerb 4) (< (gEgo y:) 100)) ; Do
				0
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ctrl4 of Climber
	(properties
		myColor 16
		from1 32
		access1 1984
	)

	(method (init)
		(= from1S getDrum)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance getDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: -1
					setPri: (+ (breakingBranch priority:) 1)
					setHeading: 315 self
				)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 7
					setMotion: MoveTo 153 90 self
				)
			)
			(2
				(gEgo setLoop: 5 setMotion: MoveTo 143 91 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 136 90 self)
			)
			(4
				(gEgo setMotion: MoveTo 131 90 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(gEgo view: 5 setLoop: 3 setCel: 0 setCycle: CT 3 1 self)
			)
			(7
				(gNarrator y: 20)
				(gMessager say: 2 4 0 0 self) ; "Adam puts his hand on the carved drum. He feels the branch lurch."
				(gNarrator y: -1)
			)
			(8
				(drum dispose:)
				(gGame points: 5)
				(gEgo setCycle: End)
				(= ticks 100)
			)
			(9
				((= register (Sound new:)) number: 295 loop: 1 play:)
				(gEgo
					view: 2
					setLoop: 3
					setCel: 0
					setSpeed: 10
					setPri: 2
					setCycle: End
				)
				(breakingBranch setCycle: End)
				(= ticks (* (gEgo cycleSpeed:) 4))
			)
			(10
				(register play:)
				(gEgo
					view: 11
					posn: 130 112
					setLoop: 1
					setCel: 5
					setCycle: MCyc @local1 self
				)
			)
			(11
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance ctrl5 of Climber
	(properties
		myColor 32
		from1 256
		from2 16
		access1 1728
	)

	(method (init)
		(= from1S ctrl5From1)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl5From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 45 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 6
					setScale: Scaler 73 68 116 102
					setMotion: MoveTo 200 104 self
				)
			)
			(2
				(gEgo setLoop: 1 setMotion: MoveTo 179 101 self)
			)
			(3
				(gEgo setLoop: 7 setMotion: MoveTo 173 96 self)
			)
			(4
				(gEgo setLoop: 1 setMotion: MoveTo 164 96 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl6 of Climber
	(properties
		myColor 64
		from1 256
		access1 1712
	)

	(method (init)
		(= from1S ctrl6From1)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl6From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 270 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 172 117 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 156 116 self)
			)
			(3
				(gEgo setMotion: MoveTo 149 111 self)
			)
			(4
				(gEgo setMotion: MoveTo 138 110 self)
			)
			(5
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl7 of Climber
	(properties
		myColor 128
		from1 256
		from2 512
		access1 1136
		access2 1024
	)

	(method (init)
		(= from1S ctrl7From1)
		(= from2S ctrl7From2)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl7From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 180 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 198 124 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 183 134 self)
			)
			(3
				(gEgo setMotion: MoveTo 163 133 self)
			)
			(4
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl7From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 198 124 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 183 134 self)
			)
			(3
				(gEgo setMotion: MoveTo 163 135 self)
			)
			(4
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl8 of Climber
	(properties
		myColor 256
		from1 32
		from2 64
		from3 128
		from4 512
		access1 16
		access4 1024
	)

	(method (init)
		(= from1S ctrl8From1)
		(= from2S ctrl8From2)
		(= from3S ctrl8From3)
		(= from4S ctrl8From4)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl8From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(1
				(gEgo view: 205 setCycle: Walk setMotion: MoveTo 173 96 self)
			)
			(2
				(gEgo setLoop: 4 setMotion: MoveTo 179 101 self)
			)
			(3
				(gEgo setLoop: 0 setMotion: MoveTo 200 104 self)
			)
			(4
				(gEgo setLoop: 5 setMotion: MoveTo 183 114 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(gEgo setScale:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl8From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 149 111 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 156 116 self)
			)
			(3
				(gEgo setMotion: MoveTo 172 117 self)
			)
			(4
				(gEgo setMotion: MoveTo 183 114 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl8From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 183 134 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 198 124 self)
			)
			(3
				(gEgo setMotion: MoveTo 183 114 self)
			)
			(4
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl8From4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 315 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: 6
					setCycle: Walk
					setScale: Scaler 83 73 132 114
					setMotion: MoveTo 249 142 self
				)
			)
			(2
				(gEgo setLoop: 7 setMotion: MoveTo 239 133 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 221 132 self)
			)
			(4
				(gEgo setMotion: MoveTo 183 114 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl9 of Climber
	(properties
		myColor 512
		from1 256
		from2 128
		from3 1024
		access1 112
	)

	(method (init)
		(= from1S ctrl9From1)
		(= from2S ctrl9From2)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl9From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: -1 setHeading: 135 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: 4
					setScale: Scaler 83 73 145 114
					setCycle: Walk
					setMotion: MoveTo 221 132 self
				)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 239 133 self)
			)
			(3
				(gEgo setLoop: 4 setMotion: MoveTo 249 142 self)
			)
			(4
				(gEgo setLoop: 5 setMotion: MoveTo 238 145 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl9From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: -1
					setScale: Scaler 83 73 145 114
					setHeading: 90 self
				)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setMotion: MoveTo 183 134 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 198 124 self)
			)
			(3
				(gEgo setMotion: MoveTo 221 132 self)
			)
			(4
				(gEgo setMotion: MoveTo 239 133 self)
			)
			(5
				(gEgo setLoop: 4 setMotion: MoveTo 249 142 self)
			)
			(6
				(gEgo setLoop: 5 setMotion: MoveTo 238 145 self)
			)
			(7
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl10 of Climber
	(properties
		myColor 1024
		from1 512
	)

	(method (init)
		(= from1S onAJag)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 2048 4096 8192 16384)
			(gMessager say: 8 4 0) ; "Adam can't reach the branch anymore."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance onAJag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gCast contains: jaguar))
				(if register
					(proc0_5 gEgo jaguar)
					(xke start: 2)
					(jaguar init: setScript: xke self)
				else
					(gEgo setLoop: -1 setHeading: 225 self)
				)
			)
			(1
				(if register
					(gMessager say: 12 4 0 0 self) ; "Do unto jaguars as you would have them do unto you."
				else
					(gEgo
						view: 205
						setLoop: 5
						setCycle: Walk
						setScale: Scaler 89 83 164 145
						setMotion: MoveTo 218 156 self
					)
				)
			)
			(2
				(if register
					(gEgo setScript: ctrl9 0 999)
					(self dispose:)
				else
					(gEgo setLoop: 4 setMotion: MoveTo 236 164 self)
				)
			)
			(3
				(self setScript: xke self)
			)
			(4
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 7
					setMotion: MoveTo 218 156 self
				)
			)
			(5
				(gEgo setLoop: 6 setMotion: MoveTo 238 145 self)
			)
			(6
				(gEgo normalize: 0)
				(proc0_5 gEgo jaguar self)
			)
			(7
				(gEgo setScript: ctrl9 0 999)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11 of Climber
	(properties
		myColor 2048
		from1 4096
	)

	(method (init)
		(gEgo setScript: walkAndFall)
	)

	(method (findClimber param1)
		(if (OneOf param1 16 32 64 128 256 512 1024)
			(gMessager say: 11 0 2) ; "Trying to fly again? Adam will have to find a way to climb there."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance walkAndFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 205
					setLoop: 1
					setPri: 15
					setCycle: Walk
					setScale:
					setMotion: MoveTo 257 40 self
				)
			)
			(1
				(gEgo setLoop: 5 setMotion: MoveTo 233 55 self)
			)
			(2
				(gEgo
					setLoop: -1
					setScale: Scaler 73 68 55 52
					setMotion: MoveTo 216 52 self
				)
			)
			(3
				(gEgo setScale: setMotion: MoveTo 201 61 self)
			)
			(4
				((= register (Sound new:)) number: 290 loop: 1 play:)
				(bendingBranch setCel: 1)
				(gEgo posn: 200 64 setLoop: 1 setCel: 3)
				(= ticks 30)
			)
			(5
				(gMessager say: 11 0 3 1 self) ; "Whoa!"
			)
			(6
				(register play:)
				(bendingBranch setCel: 2)
				(gEgo posn: 204 69 setLoop: 5 setCel: 4)
				(= ticks 40)
			)
			(7
				(bendingBranch setCel: 3)
				(gEgo posn: 203 72 setLoop: 2 setCel: 2)
				(= ticks 120)
			)
			(8
				(gEgo setLoop: 1 setMotion: MoveTo 198 72 self)
			)
			(9
				(gEgo setLoop: 5 setMotion: MoveTo 195 76 self)
			)
			(10
				(gEgo setLoop: 2 setMotion: MoveTo 195 88 self)
			)
			(11
				(gEgo setMotion: MoveTo 188 102 self)
			)
			(12
				(register number: 291 loop: 1 play:)
				(bendingBranch setCycle: End)
				(gEgo normalize: 0 setPri: 15 setHeading: 0)
				(= ticks 120)
			)
			(13
				(gEgo setHeading: 180)
				(= ticks 60)
				(gGame points: 5)
			)
			(14
				(gMessager say: 11 0 3 2 self) ; "Whew, that was close!"
			)
			(15
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 4
					setMotion: MoveTo 199 104 self
				)
			)
			(16
				(gEgo setLoop: 5 setMotion: MoveTo 185 114 self)
			)
			(17
				(gEgo normalize: 0 setHeading: 0 self)
			)
			(18
				(gGame handsOn:)
				((Jungle climbers:) release:)
				((Jungle climbers:)
					add: ctrl4 ctrl5 ctrl6 ctrl7 ctrl8 ctrl9 ctrl10
				)
				(gEgo setScript: ctrl8 0 999)
			)
		)
	)
)

(instance ctrl12 of Climber
	(properties
		myColor 4096
		from1 8192
		from2 2048
		access1 16384
	)

	(method (init)
		(= from1S ctrl12From1)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 16 32 64 128 256 512 1024)
			(gMessager say: 11 0 2) ; "Trying to fly again? Adam will have to find a way to climb there."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl12From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: 3
					setCycle: Walk
					setScale: Scaler 89 73 59 41
					setMotion: MoveTo 264 41 self
				)
			)
			(1
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 225)
				)
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
		access1 6144
	)

	(method (init)
		(= from1S ctrl13From1)
		(= from2S ctrl13From2)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 16 32 64 128 256 512 1024)
			(gMessager say: 11 0 2) ; "Trying to fly again? Adam will have to find a way to climb there."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)
)

(instance ctrl13From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: 2
					setCycle: Walk
					setScale: Scaler 89 73 59 41
					setMotion: MoveTo 269 56 self
				)
			)
			(1
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 225)
				)
				(gEgo setLoop: -1 setScale:)
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
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 5
					setMotion: MoveTo 269 56 self
				)
			)
			(2
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14 of Climber
	(properties
		myColor 16384
		from1 8192
		access1 6144
	)

	(method (init)
		(= from1S ctrl14From1)
		(exitEast init:)
		(super init: &rest)
	)

	(method (findClimber param1)
		(if (OneOf param1 16 32 64 128 256 512 1024)
			(gMessager say: 11 0 2) ; "Trying to fly again? Adam will have to find a way to climb there."
			(Jungle climbColor: ((gEgo script:) myColor:))
		else
			(super findClimber: param1)
		)
	)

	(method (dispose)
		(exitEast dispose:)
		(super dispose:)
	)
)

(instance ctrl14From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 45 self)
			)
			(1
				(gEgo
					view: 205
					setCycle: Walk
					setLoop: 6
					setMotion: MoveTo 299 38 self
				)
			)
			(2
				(gEgo normalize: 0 setHeading: 225)
				(self dispose:)
			)
		)
	)
)

(instance drummerRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= register (Prop new:))
					view: 290
					posn: 173 122
					setLoop: 4
					setCel: 0
					setPri: 15
					cycleSpeed: 12
					init:
				)
				(gEgo setHeading: 225)
				(= seconds 3)
			)
			(1
				(register setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(register dispose:)
				(gEgo setScript: ctrl14 0 999)
				(self dispose:)
			)
		)
	)
)

(instance xke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jaguar init: setCycle: Fwd setMotion: MoveTo 257 164 self)
				(gEgo setHeading: 90)
				(= seconds 3)
			)
			(1
				(gEgo view: 2 setLoop: 4 setCel: 0 setCycle: End)
			)
			(2
				(jaguar setLoop: 6 setCycle: CT 1 1)
				((= register (Sound new:)) number: 298 loop: 1 play: self)
			)
			(3
				(jaguar setCycle: Beg self)
			)
			(4
				(jaguar setLoop: 5 setScript: idle)
				(self dispose:)
			)
		)
	)
)

(instance idle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: (if (client cel:) 0 else 1))
				(= seconds (Random 5 10))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance pigScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 180))
			)
			(1
				(pig loop: 7 cel: 0 setCycle: End self)
			)
			(2
				(= ticks (Random 60 240))
			)
			(3
				(pig loop: 8 cel: 0 setCycle: End self)
			)
			(4
				(= ticks (Random 60 180))
			)
			(5
				(pig loop: 9 cel: 0 setCycle: End self)
			)
			(6
				(= ticks (Random 60 180))
			)
			(7
				(pig loop: 10 cel: 0 setCycle: End self)
			)
			(8
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance pig of Prop
	(properties
		x 115
		y 146
		view 290
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self setScript: pigScr)
	)
)

