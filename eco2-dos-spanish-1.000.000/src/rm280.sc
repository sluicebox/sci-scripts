;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Climber)
(use Jungle)
(use Talker)
(use Scaler)
(use MCyc)
(use Polygon)
(use Feature)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
	darterTalker 1
)

(local
	[local0 2]
	[local2 5]
	local7
	[local8 25] = [241 88 201 96 -15 201 87 199 107 -14 195 121 171 129 -15 168 123 167 133 -14 164 146 140 153 -1]
	[local33 27] = [103 168 -16 -8 107 185 142 187 -9 -12 145 183 137 106 -11 134 104 79 72 45 53 -10 38 53 -20 52 -1]
	[local60 25] = [9 0 103 168 9 1 96 171 9 2 96 175 9 3 97 180 9 4 101 183 9 5 107 185 -32768]
	local85 = -1
	local86
)

(instance rm280 of Eco2Room
	(properties
		noun 5
		picture 280
		style 10
		east 240
		west 290
	)

	(method (dispose)
		((Jungle climbers:) dispose:)
		(Jungle climbers: 0)
		(DisposeScript 942)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(switch gPrevRoomNum
			(290
				(= style 12)
				(self setScript: fromTreeBranch)
			)
			(else
				(= style 11)
				(if (< (gEgo y:) 100)
					(self setScript: fromNestTop)
					(lizard init:)
				else
					(self setScript: fromNestBottom)
					(hummingBird1 init: setCycle: Fwd)
					(hummingBird2 init: setCycle: Fwd)
					(hummingBird3 init: setCycle: Fwd)
					(= local7 1)
				)
			)
		)
		(Jungle climbers: (List new:))
		((Jungle climbers:)
			add: ctrl6 ctrl7 ctrl8 ctrl9 ctrl10 ctrl11 ctrl12 ctrl13 ctrl14
		)
		(super init: &rest)
		(lowerLimb init:)
		(backBranch init:)
		(frontBranch init:)
		(flowering init:)
		(liana init:)
		(aFlower init:)
		(darter init:)
		(canopy init:)
		(if (gEgo has: 4)
			(aFlower hide:)
		)
		(flower2 addToPic:)
		(flower3 addToPic:)
		(flower4 addToPic:)
		(flower5 addToPic:)
		(noClimbDown init:)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			((= [local2 temp0] (Epiphyte new:))
				init:
				x:
					(switch temp0
						(0 45)
						(1 155)
						(2 220)
						(3 305)
						(4 260)
					)
				y:
					(switch temp0
						(0 10)
						(1 50)
						(2 45)
						(3 110)
						(4 125)
					)
				setOnMeCheck:
					2
					(switch temp0
						(0
							((Polygon new:)
								type: PTotalAccess
								init: 0 30 0 17 18 7 86 0 104 6 101 19 90 24 54 20 37 22 14 36
								yourself:
							)
						)
						(1
							((Polygon new:)
								type: PTotalAccess
								init: 130 34 138 36 144 52 150 52 151 40 157 34 174 37 188 42 198 47 197 53 185 63 129 52 126 44
								yourself:
							)
						)
						(2
							((Polygon new:)
								type: PTotalAccess
								init: 229 44 221 53 212 47 214 38
								yourself:
							)
						)
						(3
							((Polygon new:)
								type: PTotalAccess
								init: 303 82 313 90 309 129 302 134 297 85
								yourself:
							)
						)
						(4
							((Polygon new:)
								type: PTotalAccess
								init: 252 118 267 118 273 127 253 127
								yourself:
							)
						)
					)
			)
			(gTheDoits add: [local2 temp0])
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			((= [local0 temp0] (Orchid new:))
				init:
				x: (if (not temp0) 280 else 225)
				y: (if (not temp0) 135 else 165)
				setOnMeCheck:
					2
					(switch temp0
						(0
							((Polygon new:)
								type: PTotalAccess
								init: 288 132 289 140 271 137 274 129
								yourself:
							)
						)
						(1
							((Polygon new:)
								type: PTotalAccess
								init: 207 151 223 162 243 163 268 173 269 178 260 182 254 170 243 173 231 164 222 170 215 162 197 162
								yourself:
							)
						)
					)
			)
			(gTheDoits add: [local0 temp0])
		)
	)
)

(instance canopy of Feature
	(properties
		y 200
		onMeCheck 1984
	)

	(method (onMe param1)
		(if (and (super onMe: param1 &rest) (not (liana onMe: param1 &rest)))
			(if
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== ((gTheIconBar curInvIcon:) message:) 55)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 8))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(self perform: gWriteEcorderData theVerb 8)
	)

	(method (init)
		(self setOnMeCheck: 1 onMeCheck)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance lowerLimb of Feature
	(properties
		x 267
		y 141
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 208 169 226 155 239 158 252 151 283 151 319 161 319 189 250 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance frontBranch of Feature
	(properties
		x 126
		y 80
		noun 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 39 12 50 33 45 48 36 54 43 74 53 75 63 96 73 128 110 117 121 88 108 49 68 45 75 34 75 0 68
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance backBranch of Feature
	(properties
		x 34
		y 44
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 209 30 242 14 288 14 319 29 319 41 273 59 236 57 208 67 194 58 208 54
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowering of Feature
	(properties
		x 55
		y 150
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 112 17 102 34 99 52 101 66 105 71 109 79 104 97 109 111 120 138 132 129 140 137 142 143 150 141 156 128 159 83 152 48 167 74 189 0 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance liana of Feature
	(properties
		x 85
		y 81
		noun 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 14 48 48 36 57 49 70 48 79 67 87 59 107 70 124 65 126 73 117 89 129 88 150 100 153 106 166 98 183 94 188 116 180 117 176 100 168 103 169 124 163 130 159 129 163 123 162 106 142 110 124 128 116 124 137 99 122 97 101 101 93 109 88 108 93 96 116 77 102 79 83 67 69 76 67 89 60 82 68 52 55 51 53 63 43 76 14 70
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

(instance noClimbDown of Feature
	(properties
		x 195
		y 180
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 188 151 213 144 215 189 153 189 162 175 187 172
					yourself:
				)
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 (event type:))
		(if
			(and
				(OneOf (gEgo script:) ctrl10 ctrl11)
				(self onMe: event)
				(OneOf ((gTheIconBar curIcon:) message:) 4 3)
				(or (== temp0 evMOUSEBUTTON) (and (== temp0 evKEYBOARD) (== (event message:) KEY_RETURN)))
				(not (event modifiers:))
			)
			(event claimed: 1)
			(gCurRoom setScript: snuffle)
		else
			(super handleEvent: event)
		)
	)
)

(instance exitEastTop of ExitFeature
	(properties
		nsTop 21
		nsLeft 310
		nsBottom 52
		nsRight 319
		cursor 11
		exitDir 2
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo setScript: toNestTop)
		)
	)
)

(instance exitEastBottom of ExitFeature
	(properties
		nsTop 150
		nsLeft 310
		nsBottom 189
		nsRight 319
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
				setMotion: MoveTo 320 170
			)
		)
	)
)

(instance exitWest of ExitFeature
	(properties
		nsTop 30
		nsBottom 60
		nsRight 10
		cursor 12
		exitDir 4
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gGame handsOff:)
			(gEgo
				view: 205
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo -5 39
			)
		)
	)
)

(instance aFlower of View
	(properties
		x 239
		y 177
		noun 6
		view 280
		signal 16385
		scaleSignal 1
		scaleX 84
		scaleY 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1) ; "A strong perfume wafts from a group of colorful flowers."
			)
			(4 ; Do
				(cond
					((gEgo has: 4)
						(gMessager say: 6 4 3) ; "Adam has enough fragrant flowers."
					)
					(local7
						(gEgo setScript: getFlowers)
					)
					(else
						(gMessager say: 6 4 4) ; "Adam will have to climb a long way around to get to those flowers."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flower2 of View
	(properties
		x 230
		y 179
		view 280
		cel 1
		signal 16384
		scaleSignal 1
		scaleX 84
		scaleY 84
	)

	(method (doVerb theVerb)
		(aFlower doVerb: theVerb)
	)
)

(instance flower3 of View
	(properties
		x 247
		y 180
		view 280
		signal 16384
		scaleSignal 1
		scaleX 92
		scaleY 92
	)

	(method (doVerb theVerb)
		(aFlower doVerb: theVerb)
	)
)

(instance flower4 of View
	(properties
		x 247
		y 181
		view 280
		cel 1
		signal 16384
		scaleSignal 1
		scaleX 92
		scaleY 92
	)

	(method (doVerb theVerb)
		(aFlower doVerb: theVerb)
	)
)

(instance flower5 of View
	(properties
		x 228
		y 173
		view 280
		cel 1
		signal 16384
		scaleSignal 1
		scaleX 106
		scaleY 106
	)

	(method (doVerb theVerb)
		(aFlower doVerb: theVerb)
	)
)

(instance ctrl6 of Climber
	(properties
		myColor 64
		from1 256
		access1 32384
	)

	(method (init)
		(exitWest init:)
		(= from1S ctrl6From1)
		(super init: &rest)
	)

	(method (dispose)
		(exitWest dispose:)
		(super dispose: &rest)
	)
)

(instance ctrl6From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 102 72 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 89 63 self)
			)
			(3
				(gEgo setMotion: MoveTo 80 67 self)
			)
			(4
				(gEgo setLoop: 5 setMotion: MoveTo 43 42 self)
			)
			(5
				(gEgo setPri: 14 setLoop: -1 setMotion: MoveTo 40 47 self)
			)
			(6
				(gEgo setMotion: MoveTo 22 50 self)
			)
			(7
				(gEgo normalize: 0 setHeading: 135)
				(self dispose:)
			)
		)
	)
)

(instance ctrl7 of Climber
	(properties
		myColor 128
		from1 256
		access1 32320
	)

	(method (init)
		(= from1S ctrl7From1)
		(super init: &rest)
	)
)

(instance ctrl7From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 7 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo posn: 101 29 normalize: 0 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance ctrl8 of Climber
	(properties
		myColor 256
		from1 512
		from2 64
		from3 128
		access1 31744
	)

	(method (init)
		(= from1S ctrl8From1)
		(= from2S ctrl8From2)
		(= from3S ctrl8From3)
		(super init: &rest)
	)
)

(instance ctrl8From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 140 100 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 129 101 self)
			)
			(3
				(gEgo setMotion: MoveTo 118 91 self)
			)
			(4
				(gEgo setMotion: MoveTo 116 70 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
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
				(gEgo
					view: 205
					setLoop: -1
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo 40 47 self
				)
			)
			(1
				(gEgo setLoop: 6 setMotion: MoveTo 46 41 self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 78 70 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 89 63 self)
			)
			(4
				(gEgo setMotion: MoveTo 102 72 self)
			)
			(5
				(gEgo setMotion: MoveTo 116 70 self)
			)
			(6
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 135)
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
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 7
					posn: 116 70
					setLoop: 7
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance ctrl9 of Climber
	(properties
		myColor 512
		from1 256
		from2 1024
		from3 4096
		access1 192
		access2 26624
	)

	(method (init)
		(= from1S ctrl9From1)
		(= from2S ctrl9From2)
		(= from3S ctrl9From3)
		(super init: &rest)
	)
)

(instance ctrl9From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 118 91 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 129 101 self)
			)
			(2
				(gEgo setMotion: MoveTo 140 100 self)
			)
			(3
				(gEgo setPri: 14 setMotion: MoveTo 156 109 self)
			)
			(4
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setPri: 14 setHeading: 180)
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
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 142 187 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 7 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo
					view: 6
					posn: 142 163
					setPri: 14
					setCel: 0
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 142 126 self
				)
			)
			(4
				(gEgo
					view: 7
					posn: 142 150
					setLoop: 6
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(gEgo posn: 156 109 normalize: 0 setPri: 14)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl9From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: 5
					setPri: 14
					setCycle: Walk
					setMotion: MoveTo 229 77 self
				)
			)
			(1
				(gEgo setLoop: 1 setMotion: MoveTo 212 76 self)
			)
			(2
				(gEgo setLoop: 5 setMotion: MoveTo 178 102 self)
			)
			(3
				(gEgo setLoop: -1 setMotion: MoveTo 156 109 self)
			)
			(4
				(gEgo setScale:)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setPri: 14 setHeading: 180)
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
		from2 2048
		access1 4544
		access2 24576
	)

	(method (init)
		(= from1S ctrl10From1)
		(= from2S ctrl10From2)
		(super init: &rest)
	)
)

(instance ctrl10From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 7
					posn: 142 150
					setLoop: 6
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 2
					setCel: 0
					posn: 142 126
					yStep: 4
					setPri: 14
					setCycle: Rev
					setMotion: MoveTo 142 163 self
				)
			)
			(3
				(gEgo
					view: 7
					posn: 142 187
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(gEgo normalize: 0)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo setHeading: 180)
				)
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
				(gEgo setHeading: 225 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 160 143 self
				)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 93 169 self)
			)
			(3
				(gEgo setMotion: MoveTo 97 179 self)
			)
			(4
				(gEgo setMotion: MoveTo 142 187 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl11 of Climber
	(properties
		myColor 2048
		from1 1024
		from2 8192
		access1 5056
		access2 16384
	)

	(method (init)
		(= from1S ctrl11From1)
		(= from2S ctrl11From2)
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
					setLoop: 5
					setMotion: MoveTo 142 187 self
				)
			)
			(1
				(gEgo setLoop: -1 setMotion: MoveTo 97 179 self)
			)
			(2
				(gEgo setMotion: MoveTo 93 169 self)
			)
			(3
				(gEgo setMotion: MoveTo 160 143 self)
			)
			(4
				(gEgo setLoop: 6 setMotion: MoveTo 172 130 self)
			)
			(5
				(gEgo setLoop: -1)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 225)
				)
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
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo
					view: 7
					posn: 191 90
					setLoop: 5
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 0
					setCel: 0
					yStep: 4
					setCycle: Rev
					setMotion: MoveTo 183 118 self
				)
			)
			(3
				(gEgo
					view: 7
					posn: 184 120
					setLoop: 1
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					scaleX: 111
					scaleY: 111
					normalize: 0
					setHeading: 225 self
				)
			)
			(5
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 172 130 self
				)
			)
			(6
				(gEgo scaleX: 115 scaleY: 115)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 225)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12 of Climber
	(properties
		myColor 4096
		from1 512
		access1 28096
	)

	(method (init)
		(= from1S ctrl12From1)
		(super init: &rest)
	)
)

(instance ctrl12From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setPri: 14
					setCycle: Walk
					setScale: Scaler 89 80 109 68
					setMotion: MoveTo 178 102 self
				)
			)
			(1
				(gEgo setLoop: 6 setMotion: MoveTo 212 76 self)
			)
			(2
				(gEgo setLoop: 0 setMotion: MoveTo 229 77 self)
			)
			(3
				(gEgo setLoop: 6 setMotion: MoveTo 250 67 self)
			)
			(4
				(gEgo normalize: 0 setPri: 14 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13 of Climber
	(properties
		myColor 8192
		from1 16384
		from2 2048
		access2 6080
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
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 245 37 self
				)
			)
			(1
				(gEgo setLoop: 5 setMotion: MoveTo 224 55 self)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 199 60 self)
			)
			(3
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
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
				(gEgo
					view: 205
					setLoop: -1
					scaleX: 111
					scaleY: 111
					setCycle: Walk
					setMotion: MoveTo 184 120 self
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 7
					scaleX: 101
					scaleY: 101
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 6
					posn: 183 118
					setLoop: 0
					setCel: 0
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 191 90 self
				)
			)
			(4
				(gEgo view: 7 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo posn: 199 60 normalize: 0)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo setHeading: 180)
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
		access1 8128
	)

	(method (init)
		(exitEastTop init:)
		(= from1S ctrl14From1)
		(super init: &rest)
	)

	(method (dispose)
		(exitEastTop dispose:)
		(super dispose:)
	)
)

(instance ctrl14From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 224 55 self
				)
			)
			(1
				(gEgo setLoop: 6 setMotion: MoveTo 245 37 self)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 272 32 self)
			)
			(3
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromNestTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 205
					posn: 316 35
					setLoop: -1
					scaleX: 101
					scaleY: 101
					scaleSignal: (| (gEgo scaleSignal:) $0005)
					init:
					setCycle: Walk
					setMotion: MoveTo 308 39 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 272 32 self)
			)
			(2
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(gEgo setScript: ctrl14 0 999)
				(self dispose:)
			)
		)
	)
)

(instance fromNestBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					posn: 310 164
					setPri: 14
					setLoop: -1
					scaleX: 101
					scaleY: 101
					scaleSignal: (| (gEgo scaleSignal:) $0005)
					init:
					setCycle: Walk
					setMotion: MoveTo 292 161 self
				)
			)
			(1
				(gEgo normalize: 0 setScript: holdIt)
				(= cycles 2)
			)
			(2
				(hummingBird1 loop: 2 setMotion: MoveTo -10 160 hummingBird1)
				(hummingBird2
					ignoreHorizon:
					setMotion: MoveTo -10 -10 hummingBird2
				)
				(hummingBird3 setMotion: MoveTo 100 205 hummingBird3)
				(= ticks 30)
			)
			(3
				(exitEastBottom init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromTreeBranch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 205
					posn: 13 46
					setLoop: -1
					scaleX: 111
					scaleY: 111
					scaleSignal: (| (gEgo scaleSignal:) $0005)
					init:
					setCycle: Walk
					setMotion: MoveTo 22 50 self
				)
			)
			(1
				(gEgo normalize: 0 setHeading: 135 self)
			)
			(2
				(gGame handsOn:)
				(gEgo setScript: ctrl6 0 999)
				(self dispose:)
			)
		)
	)
)

(instance toNestTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 272 31 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 308 39 self)
			)
			(2
				(gEgo setMotion: MoveTo 325 30 self)
			)
		)
	)
)

(instance holdIt of Script
	(properties)

	(method (init)
		(gWalkHandler add: self)
		(gTheIconBar walkIconItem: 0)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gTheIconBar walkIconItem: (gTheIconBar at: 0))
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event type:))
		(= temp1 ((gTheIconBar curIcon:) message:))
		(if (& (event type:) evMOVE)
			(event claimed: 1)
			(gMessager say: 5 3 1) ; "Since Adam can't fly there, he'll have to figure out the path."
		)
		(if (and (& temp0 $0040) (== temp1 3)) ; direction
			(if (== temp1 0)
				(event claimed: 0)
			else
				(gPMouse handleEvent: event)
				(return 1)
			)
		)
	)
)

(instance getFlowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 270 181 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 253 183 self)
			)
			(2
				(gEgo view: 5 setLoop: 1 setCel: 0 setCycle: CT 3 1 self)
			)
			(3
				(gGame points: 5)
				(gMessager say: 6 4 0 0 self) ; "Adam picks a few of the heavily perfumed flowers."
				(gEgo get: 4)
				(aFlower hide:)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 270 181 self
				)
			)
			(6
				(gEgo setMotion: MoveTo 292 161 self)
			)
			(7
				(gGame handsOn:)
				(gEgo normalize: 0 setHeading: 180 setScript: holdIt)
				(self dispose:)
			)
		)
	)
)

(instance snuffle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= register (Sound new:)) number: 297 loop: 1 play: self)
			)
			(1
				(gMessager say: 5 0 2 0 self) ; "A strange snuffling sound below makes Adam hesitate."
				(register dispose:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hummingBird1 of Actor
	(properties
		x 232
		y 167
		view 260
		loop 3
		priority 15
		signal 26640
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(self dispose:)
	)
)

(instance hummingBird2 of Actor
	(properties
		x 267
		y 173
		view 260
		loop 2
		priority 15
		signal 26640
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(self dispose:)
	)
)

(instance hummingBird3 of Actor
	(properties
		x 252
		y 158
		view 260
		loop 2
		signal 26624
		cycleSpeed 0
		moveSpeed 0
	)

	(method (cue)
		(self dispose:)
	)
)

(instance lizardMoveScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if local86
					(= local86 0)
					(lizard cycleSpeed: 3 setCycle: Walk)
				)
				(= temp0 (WordAt register (++ local85)))
				(= state -1)
				(= cycles 2)
				(cond
					((== temp0 -1)
						(= state 1)
					)
					((== temp0 -10)
						(lizard
							setLoop: 7
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -8)
						(lizard
							setLoop: 8
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -15)
						(lizard
							setLoop: 11
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -14)
						(lizard
							setLoop: 12
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -13)
						(lizard
							setLoop: 13
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -12)
						(lizard
							setLoop: 14
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -11)
						(lizard
							setLoop: 15
							posn:
								(WordAt register (++ local85))
								(WordAt register (++ local85))
						)
					)
					((== temp0 -16)
						(= local86 1)
						(lizard cycleSpeed: 5 setCycle: MCyc @local60 self)
						(= cycles 0)
					)
					((== temp0 -9)
						(lizard setPri: 14)
					)
					(else
						(lizard
							setMotion:
								MoveTo
								temp0
								(WordAt register (++ local85))
								self
						)
						(= cycles 0)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= local85 -1)
	)
)

(instance lizardScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: lizardMoveScr self @local8)
			)
			(1
				(= ticks 40)
			)
			(2
				(lizard posn: 126 164)
				(self setScript: lizardMoveScr self @local33)
			)
			(3
				(lizard dispose:)
			)
		)
	)
)

(instance lizard of Actor
	(properties
		x 270
		y 97
		noun 9
		view 280
		loop 7
		signal 18432
	)

	(method (init)
		(super init: &rest)
		(self setSpeed: 3 setCycle: Walk setScript: lizardScr)
	)
)

(instance darterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 300 520))
				(= register 2)
			)
			(1
				(gGameSound2 number: 274 loop: 1 play:)
				(client setCycle: End self)
				(if (and (-- register) (Random 0 1))
					(-- state)
				)
			)
			(2
				(= register 0)
				(client cel: 0)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance darter of Prop
	(properties
		x 25
		y 163
		noun 11
		view 280
		loop 1
		priority 15
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setScript: darterScr)
	)

	(method (doit)
		(if (not (IsEcorderFlag 30))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 30))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 33))
					(gCurrentRegionFlags set: 33)
					(gGame points: 1)
				)
				(if (and (gCurrentRegionFlags test: 6) (not (gCurrentRegionFlags test: 7)))
					(gMessager say: noun theVerb 5) ; "The Grove People! They say that One From Outside is coming!"
				else
					(super doVerb: theVerb &rest)
				)
			else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance darterTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (darter x:) 20) y: (- (darter y:) 10) font: gUserFont)
		(super init:)
	)
)

