;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom3 0
)

(local
	local0
	local1
)

(instance sHRoom3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 240 135 245 130 236 123 211 123 194 112 153 112 66 112 66 114 145 114 119 138 63 137 51 146 235 149
							yourself:
						)
				)
				((ScriptID 800 2) doit: 840) ; xDrawThePic
				(gGkMusic1
					number: 341
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(keypad init:)
				(bed init:)
				(bedTable init:)
				(litScreen init: approachVerbs: 13) ; Walk
				(veve init:)
				(rug init:)
				(smallVase init:)
				(tallVase init:)
				(offeringTable init:)
				(door2 init:)
				(gWalkHandler add: litScreen)
				(keyPad2 init: approachVerbs: 8 123) ; Operate, hounfourKey
				(door1 init: setCel: 5)
				(if (not (IsFlag 350))
					(SetFlag 350)
					(screen init:)
					(wall init:)
					(self setScript: sEnterFirst)
					(gEgo
						normalize: 1
						init:
						state: 2
						setScaler: Scaler 100 85 120 111
						posn: 230 126
						setMotion: MoveTo 205 124 script
					)
				else
					(self setScript: sEnter)
					(gEgo
						normalize: 1
						posn: 230 126
						init:
						setScaler: Scaler 100 85 120 111
						setMotion: MoveTo 205 124 script
					)
					(shadowEgo init:)
				)
			)
			(1
				(if (gWalkHandler contains: litScreen)
					(gWalkHandler delete: litScreen)
				)
				(RemapColors 0) ; Off
				(= cycles 1)
			)
			(2
				(gGkMusic1 fade:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				0
			)
			(1
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(2
				(gMessager say: 10 0 1 1 self 803) ; "The room smells of Malia's perfume."
			)
			(3
				(gMessager say: 10 0 1 2 self 803) ; "Someone's coming!"
			)
			(4
				(gEgo
					view: 841
					setCel: 0
					setLoop: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(5
				(malia
					init:
					fixPriority: 1
					priority: 0
					setScaler: Scaler 100 81 115 109
					ignoreActors: 1
				)
				(gGkSound1 number: 811 play:)
				(door2 setCycle: End self)
			)
			(6
				(RemapColors 2 254 80 0) ; ByPercent
				(RemapColors 2 253 80 0) ; ByPercent
				(malia
					fixPriority: 0
					setCycle: StopWalk -1
					setCel: 0
					setLoop: -1
					setLooper: Grooper
					setMotion: MoveTo 191 118 self
				)
			)
			(7
				(malia setMotion: PolyPath 153 118 self)
			)
			(8
				(Face malia 153 100 self)
			)
			(9
				(malia view: 843 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(10
				(gGkSound1 setLoop: 1 number: 841 play:)
				(= cycles 6)
			)
			(11
				(wall dispose:)
				(screen dispose:)
				(candles init: setCycle: RandCycle)
				(malia setCel: 0 setLoop: 1 setCycle: End self)
			)
			(12
				(malia view: 8431 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(13
				(gMessager say: 10 0 1 3 self 803) ; "(PRAYING)Tetelo, come to me. Your daughter requests an audience!"
			)
			(14
				(malia
					posn: 120 117
					setSpeed: 12
					view: 844
					setCel: 0
					setLoop: 0
					setCycle: End
				)
				(gGkSound1 setLoop: 1 number: 554 play:)
				(tetelo init: setCycle: End self)
			)
			(15
				(gMessager say: 10 0 1 4 self 803) ; "(SPIRIT VOICE--DARK, UNEARTHLY)What is it you seek, child?"
			)
			(16
				(gMessager say: 10 0 1 5 self 803) ; "(PLEADING)Tetelo, I beg you again--for my sake--spare Gabriel's life!"
			)
			(17
				(gMessager say: 10 0 1 6 self 803) ; "(DISDAINFUL)Do not protect or mourn that one. He will only betray you!"
			)
			(18
				(gMessager say: 10 0 1 7 self 803) ; "(NAIVE)Gabriel would never betray me!"
			)
			(19
				(gMessager say: 10 0 1 8 self 803) ; "(BITTER)He will! As Gunter betrayed me. Blinded by the light, he will despise your darkness!"
			)
			(20
				(gMessager say: 10 0 1 9 self 803) ; "(SCARED, BUT FIRM)No! I don't believe that! You were betrayed, but Gabriel is different. I...I cannot serve you any longer. Choose another. I cannot go on!"
			)
			(21
				(tetelo setCel: 0 setLoop: 2 setCycle: End)
				(gMessager say: 10 0 1 10 self 803) ; "(ANGRY, BITTER)Hah! So you say, because you are drawn to the light. What you do not know is that the light will never have you--you only corrupt it when you draw near!"
			)
			(22
				(gMessager say: 10 0 1 11 self 803) ; "(BEING FIRM)I don't believe you. This way...this life is too painful. I MUST be free of it!"
			)
			(23
				(gMessager say: 10 0 1 12 self 803) ; "(ENDING CONVERSATION)You can never be free! You will see, my daughter. What I have told you is true. You will see!"
			)
			(24
				(tetelo dispose:)
				(malia setCel: 0 setLoop: 3 setCycle: End self)
				(gMessager say: 10 0 1 13 self 803) ; "Wait! I won't go through with it! I won't!"
			)
			(25 0)
			(26
				(gMessager say: 10 0 1 14 0 803) ; "(WHISPERED)I won't!"
				(malia
					setSpeed: 8
					posn: 153 120
					setCel: 0
					setLoop: 4
					setCycle: End self
				)
			)
			(27
				(malia dispose:)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gGkSound1 number: 812 play:)
				(door2 setCycle: Beg self)
			)
			(28
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(29
				(RemapColors 2 254 85 0) ; ByPercent
				(gEgo normalize: 1)
				(shadowEgo init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(2
				(RemapColors 2 254 80 0) ; ByPercent
				(RemapColors 2 253 80 0) ; ByPercent
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo 194 100 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo hide:)
				(dupe init: setCycle: End self)
			)
			(3
				(if register
					(gMessager say: 20 8 14 0 self 800) ; "It's locked."
				else
					(gMessager say: 20 123 31 0 self 800) ; "The door doesn't respond to the key card. Malia must have some other way of opening it."
				)
			)
			(4
				(dupe setCycle: Beg self)
			)
			(5
				(gEgo show:)
				(dupe dispose:)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToHounfour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 219 126 self)
			)
			(1
				(gEgo
					view: 801
					setSpeed: 12
					setCel: 0
					setLoop: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 802 play:)
			)
			(3
				(door1 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 811 play:)
			)
			(4
				(gEgo normalize: 0 setMotion: PolyPath 232 128 self)
			)
			(5
				(if (not (Random 0 2))
					(gEgo
						view: 802
						setSpeed: 12
						setCel: 0
						setLoop: 1
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(client cue:)
			)
		)
	)
)

(instance dupe of Prop
	(properties
		x 194
		y 112
		view 801
		loop 2
		cel 3
	)
)

(instance door1 of Prop
	(properties
		noun 4
		modNum 800
		x 247
		y 125
		priority 1
		fixPriority 1
		view 840
		signal 16417
	)
)

(instance door2 of Prop
	(properties
		noun 1
		modNum 803
		x 178
		y 63
		priority 1
		fixPriority 1
		view 847
		signal 16417
	)
)

(instance shadowEgo of View
	(properties
		priority 118
		fixPriority 1
		view 846
		signal 20513
		scaleSignal 1
	)

	(method (doit)
		(super doit:)
		(if (gEgo inRect: 60 105 134 120)
			(cond
				(local1
					(= local1 0)
					(self
						x: (gEgo x:)
						y: (gEgo y:)
						scaleX: (gEgo scaleX:)
						scaleY: (gEgo scaleY:)
						setCel: (gEgo cel:)
						setLoop: (gEgo loop:)
						show:
					)
				)
				((== (gEgo view:) 900)
					(self
						x: (gEgo x:)
						y: (gEgo y:)
						scaleX: (gEgo scaleX:)
						scaleY: (gEgo scaleY:)
						setCel: (gEgo cel:)
						setLoop: (gEgo loop:)
					)
				)
			)
		else
			(if (not local1)
				(= local1 1)
				(self hide:)
			)
			(self x: 3000)
		)
	)
)

(instance malia of Actor
	(properties
		x 191
		y 105
		view 362
		loop 8
		cel 2
		signal 16417
	)
)

(instance wall of View
	(properties
		x 136
		y 61
		priority 1
		fixPriority 1
		view 840
		loop 1
		cel 1
	)
)

(instance tetelo of Prop
	(properties
		x 101
		y 92
		priority 117
		fixPriority 1
		view 844
		loop 1
		signal 16417
		cycleSpeed 12
	)

	(method (doit)
		(super doit:)
		(RemapColors 2 253 (Random 85 90) 0) ; ByPercent
		(UpdateScreenItem self)
	)
)

(instance candles of Prop
	(properties
		x 148
		y 90
		view 840
		loop 2
		cel 2
	)
)

(instance screen of View
	(properties
		x 64
		y 58
		priority 8
		view 840
		loop 1
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 228
		nsTop 80
		nsRight 237
		nsBottom 92
		sightAngle 40
		approachX 232
		approachY 86
		x 232
		y 127
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom3 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyPad2 of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 200
		nsTop 76
		nsRight 212
		nsBottom 92
		sightAngle 40
		approachX 194
		approachY 112
		x 206
		y 112
		z 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom3 setScript: sTryDoor 0 1)
				(return 1)
			)
			(123 ; hounfourKey
				(sHRoom3 setScript: sTryDoor)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bedTable of Feature
	(properties
		noun 5
		modNum 803
		nsLeft 40
		nsTop 119
		nsRight 59
		nsBottom 139
		sightAngle 40
		approachX 49
		approachY 129
		x 49
		y 129
	)
)

(instance litScreen of Feature
	(properties
		noun 4
		modNum 803
		nsLeft 61
		nsTop 56
		nsRight 135
		nsBottom 120
		sightAngle 40
		approachX 107
		approachY 112
		x 98
		y 88
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (gEgo inRect: 60 105 134 120)
					(gMessager say: 4 13 3 0 0 803) ; "Behind the screen is a small Voodoo shrine."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(13 ; Walk
				(if (not local0)
					(gMessager say: 4 13 3 0 0 803) ; "Behind the screen is a small Voodoo shrine."
					(= local0 1)
					(gWalkHandler delete: litScreen)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance veve of Feature
	(properties
		noun 7
		modNum 803
		nsLeft 135
		nsTop 61
		nsRight 164
		nsBottom 93
		sightAngle 40
		approachX 149
		approachY 77
		x 149
		y 77
	)
)

(instance bed of Feature
	(properties
		noun 3
		modNum 803
		sightAngle 20
		x 75
		y 117
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 86 43 93 51 86 57 91 63 81 64 106 77 110 115 110 117 100 119 110 126 106 128 95 131 124 117 134 40 134
					yourself:
				)
		)
		(super init:)
	)
)

(instance rug of Feature
	(properties
		noun 2
		modNum 803
		sightAngle 20
		x 171
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 137 142 116 201 116 223 138
					yourself:
				)
		)
		(super init:)
	)
)

(instance smallVase of Feature
	(properties
		noun 9
		modNum 803
		sightAngle 20
		x 218
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 75 220 80 225 84 222 87 213 87 209 84 212 80 212 75
					yourself:
				)
		)
		(super init:)
	)
)

(instance tallVase of Feature
	(properties
		noun 6
		modNum 803
		sightAngle 20
		x 260
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 137 250 122 255 110 251 102 249 94 257 97 256 93 266 93 267 96 271 93 273 104 269 113 271 125 269 137
					yourself:
				)
		)
		(super init:)
	)
)

(instance offeringTable of Feature
	(properties
		noun 8
		modNum 803
		sightAngle 20
		x 149
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 85 140 94 141 77 143 77 145 91 149 86 152 89 152 83 154 76 157 76 157 87 163 87 163 95 167 98 166 101 165 113 159 111 157 101 136 101
					yourself:
				)
		)
		(super init:)
	)
)

