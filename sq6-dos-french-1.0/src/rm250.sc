;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use SQRoom)
(use Talker)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm250 0
	festerTlkr 1
)

(local
	local0 = 1
	local1
	local2
)

(instance rm250 of SQRoom
	(properties
		noun 1
		picture 250
	)

	(method (init)
		(Load 140 252 253 255 256) ; WAVE
		(Load rsVIEW 251 2510 250 2501 2500)
		(super init:)
		(PalCycle 0 111 114 -1 10) ; Start
		(PalCycle 0 173 174 -1 10) ; Start
		(purpleNeon init:)
		(greenNeon init:)
		(monitor init:)
		(syringe init:)
		(fluidStorage init:)
		(stalks init:)
		(drawers init:)
		(tank init:)
		(antenna init:)
		(lobe init:)
		(blender init:)
		(fresh1 init:)
		(green init:)
		(airBag init:)
		(abby init:)
		(fester init: setScript: sFester)
		(ekg init: setCycle: Fwd)
		(airbag init: setCycle: Fwd)
		(abbey init: setCycle: Fwd)
		(fresh init: setCycle: Fwd)
		(drip init: setCycle: Fwd)
		(flies init: setCycle: Fwd)
		(lilgreen init: setCycle: Fwd)
		(gGSound1 number: 250 loop: -1 play:)
		(gTheIconBar select: (gTheIconBar at: 1) setupExit: 1)
		(gGame handsOn:)
	)

	(method (dispose)
		(gGSound1 fade:)
		(super dispose:)
	)
)

(instance sFester of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fester view: 251 loop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				(= local2 1)
				(= ticks (Random 500 800))
			)
			(2
				(if (Random 0 1)
					(self changeState: 3)
				else
					(self changeState: 7)
				)
			)
			(3
				(fester view: 251 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(4
				(= local2 0)
				(sound1 number: 255 loop: 0 play:)
				(fester cel: 7 setCycle: CT 20 1 self)
			)
			(5
				(sound1 number: 256 loop: 0 play:)
				(fester cel: 21 setCycle: End self)
			)
			(6
				(sound1 stop:)
				(= local2 1)
				(self changeState: 0)
			)
			(7
				(= local2 0)
				(fester view: 2510 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(8
				(sound1 number: 252 loop: 0 play:)
				(fester cel: 7 setCycle: CT 15 1 self)
			)
			(9
				(sound1 number: 253 loop: 0 play:)
				(fester cel: 16 setCycle: CT 22 1 self)
			)
			(10
				(fester cel: 23 setCycle: End self)
			)
			(11
				(sound1 stop:)
				(= local2 1)
				(self changeState: 0)
			)
		)
	)
)

(instance sFesterTakeModdie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sFester dispose:)
				(= local0 2)
				(if (fester cycler:)
					(fester setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(fester view: 251 loop: 0 cel: 0)
				(= cycles 1)
			)
			(2
				(gMessager sayRange: 2 122 0 1 10 self) ; "Hello there, Mr. Blatz. I think I have something you might be interested in."
			)
			(3
				(egoHand
					ignoreActors: 1
					setPri: 210
					moveSpeed: 1
					cel: 0
					init:
					setMotion: MoveTo 247 76 self
				)
			)
			(4
				(fester
					view: 253
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: CT 9 1 self
				)
			)
			(5
				(fester cel: 10 setCycle: End self)
				(egoHand ignoreActors: 1 moveSpeed: 1 setCycle: End self)
			)
			(6
				(egoHand setMotion: MoveTo 330 200 self)
			)
			(7
				(egoHand dispose:)
				(fester view: 254 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(fester view: 254 loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(gEgo get: 25 put: 16) ; Cyber_Jack, Callahan_Moddie
				(= ticks 120)
			)
			(10
				(gMessager sayRange: 2 122 0 12 13 self) ; "I'm glad you see it my way."
			)
			(11
				(gGame points: 3 483)
				(fester view: 251 loop: 0 cel: 0)
				(fester setScript: sFester)
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFesterTalks of Script ; UNUSED
	(properties)

	(method (doit)
		(if local2
			(self changeState: 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (Random 1 2))
				(sFester dispose:)
				(if (fester cycler:)
					(fester setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((== local0 2)
						(fester view: 2500 cel: 0 loop:)
					)
					((== local0 3)
						(fester view: 2501 cel: 0 loop:)
					)
					(else
						(fester view: 250 cel: 0 loop:)
					)
				)
				(= cycles 1)
			)
			(2
				(= local2 0)
				(if (not (IsFlag 61))
					(SetFlag 61)
					(gMessager say: 2 2 0 0 self) ; "Uh, hmm. (THROAT CLEARING NOISE)"
				else
					(gMessager say: 2 2 2 0 self) ; "Go ahead and look around, Pardner. I'll be glad to answer any questions you might have about my fine line of merchandise. Yes, siree. Have a look."
				)
			)
			(3
				(fester setScript: sFester)
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoHand of Actor
	(properties
		x 330
		y 200
		view 252
		signal 20513
	)
)

(instance fester of Actor
	(properties
		x 130
		y 101
		view 251
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (not (IsFlag 61))
					(SetFlag 61)
					(gMessager say: 2 2 0 0 self) ; "Uh, hmm. (THROAT CLEARING NOISE)"
				else
					(gMessager say: 2 2 2 0 self) ; "Go ahead and look around, Pardner. I'll be glad to answer any questions you might have about my fine line of merchandise. Yes, siree. Have a look."
				)
			)
			(1 ; Look
				(cond
					((not (IsFlag 62))
						(SetFlag 62)
						(gMessager say: 2 1 1) ; "Yikes! Can it be? Why, yes, it is. It's Fester, Fester Blatz. Former owner and proprietor of Fester's World O' Wonders, a cheesy little tourist trap on the desert planetoid of Phleebhut."
					)
					((== (gEgo has:) 25)
						(gMessager say: 2 1 3) ; MISSING MESSAGE
					)
					(else
						(gMessager say: 2 1) ; "The past few years have been no kinder to Fester than all the previous ones. He still has that nasal cavity-molded look with no discernible skeletal features."
					)
				)
			)
			(122 ; Callahan_Moddie
				(SetFlag 61)
				(if (not (gEgo has: 25)) ; Cyber_Jack
					(gCurRoom setScript: sFesterTakeModdie)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ekg of Actor
	(properties
		x 32
		y 93
		view 255
	)
)

(instance airbag of Actor
	(properties
		x 109
		y 115
		view 256
		loop 1
		cycleSpeed 9
	)

	(method (init)
		(self setPri: 200)
		(super init: &rest)
	)
)

(instance abbey of Actor
	(properties
		x 162
		y 114
		view 256
		loop 2
		cycleSpeed 9
	)

	(method (init)
		(self setPri: 100)
		(super init: &rest)
	)
)

(instance fresh of Actor
	(properties
		x 28
		y 112
		view 256
		loop 3
		cycleSpeed 9
	)

	(method (init)
		(self setPri: 200)
		(super init: &rest)
	)
)

(instance drip of Actor
	(properties
		x 40
		y 119
		view 256
		loop 5
		cycleSpeed 12
	)

	(method (init)
		(self setPri: 200)
		(super init: &rest)
	)
)

(instance flies of Actor
	(properties
		x 279
		y 78
		view 256
		cycleSpeed 10
	)

	(method (init)
		(self setPri: 150)
		(super init: &rest)
	)
)

(instance lilgreen of Actor
	(properties
		x 63
		y 117
		view 256
		loop 4
	)

	(method (init)
		(self setPri: 200)
		(super init: &rest)
	)
)

(instance fresh1 of Feature
	(properties
		noun 13
		sightAngle 40
		x 25
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 15 109 25 104 33 107 44 117 44 121 37 124 11 122 7 116 10 110
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance purpleNeon of Feature
	(properties
		noun 6
		sightAngle 40
		x 31
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 41 0 84 62 78 59 59 51 55 46 40 40 32 26 29 12 31 1 36
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance greenNeon of Feature
	(properties
		noun 4
		sightAngle 40
		x 131
		y 16
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 72 0 72 32 190 32 190 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance fluidStorage of Feature
	(properties
		noun 9
		sightAngle 40
		x 155
		y 66
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 40 120 98 178 98 189 95 190 39 163 35 135 36
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tank of Feature
	(properties
		noun 11
		sightAngle 40
		x 207
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 95 194 81 198 76 203 73 211 73 221 81 221 120 206 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance monitor of Feature
	(properties
		noun 7
		sightAngle 40
		x 31
		y 112
		z 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 9 100 16 86 44 84 54 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance syringe of Feature
	(properties
		noun 12
		sightAngle 40
		x 260
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 116 246 107 260 114 259 91 266 92 266 116 275 114 285 95 290 97 280 115 257 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stalks of Feature
	(properties
		noun 3
		sightAngle 40
		x 36
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 9 11 60 5 64 36 48 38 35 29 13 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance drawers of Feature
	(properties
		noun 10
		sightAngle 40
		x 88
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 38 109 99 68 99 68 38
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance antenna of Feature
	(properties
		noun 8
		sightAngle 40
		x 17
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 19 85 15 69 13 62 14 62 15 62 17 70 21 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lobe of Feature
	(properties
		noun 5
		sightAngle 40
		x 250
		y 39
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 25 231 38 226 47 267 54 273 41 275 28
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blender of Feature
	(properties
		noun 17
		sightAngle 40
		x 303
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 61 315 60 311 63 308 67 308 93 292 100 287 106 287 139 319 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance spider2 of Feature ; UNUSED
	(properties
		sightAngle 40
		x 194
		y 64
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 55 190 42 191 86 198 73
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance spider1 of Feature ; UNUSED
	(properties
		sightAngle 40
		x 113
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 38 117 45 117 99 109 99
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance spider3 of Feature ; UNUSED
	(properties
		sightAngle 40
		x 208
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 21 200 20 212 13 224 0 223 11 225 14 215 15 214 30 210 28 206 25 198 29 192 27
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance spider4 of Feature ; UNUSED
	(properties
		sightAngle 40
		x 313
		y 47
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 313 37 319 40 319 58 307 58
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance topBox of Feature ; UNUSED
	(properties
		sightAngle 40
		x 263
		y 33
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 17 214 56 274 67 306 59 312 34 300 26 305 8 294 1 291 20 279 18 281 0 228 0 228 15
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance green of Feature
	(properties
		noun 14
		sightAngle 40
		x 63
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 115 63 109 69 110 69 118 64 121
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance airBag of Feature
	(properties
		noun 15
		sightAngle 40
		x 108
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 100 105 119 108 126 119 115 124 91 120
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance abby of Feature
	(properties
		noun 16
		sightAngle 40
		x 160
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 107 141 118 148 123 173 124 179 122 180 118 167 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance festerTlkr of Talker
	(properties
		disposeWhenDone 0
	)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Morv Blatz})
			)
			(else
				(= name {Fester Blatz})
			)
		)
		(while 1
			(if (fester cycler:)
				(gCast doit:)
			else
				(break)
			)
			(gSounds eachElementDo: #check)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
		)
		(fester hide: setScript: 0)
		(cond
			((== local0 2)
				(super init: festerMouth2 festerBust2 festerEyes2)
			)
			((== local0 3)
				(super init: festerMouth3 festerBust3 festerEyes3)
			)
			(else
				(super init: festerMouth1 festerBust1 festerEyes1)
			)
		)
	)

	(method (dispose param1)
		(if param1
			(if (== (gCurRoom script:) sFesterTakeModdie)
				(fester show:)
			else
				(fester show: setScript: sFester)
			)
		)
		(super dispose: param1)
	)
)

(instance festerBust1 of Prop
	(properties
		x 130
		y 101
		view 250
	)
)

(instance festerMouth1 of Prop
	(properties
		x 129
		y 58
		view 250
		loop 1
	)
)

(instance festerEyes1 of Prop
	(properties
		x 137
		y 9
		view 250
		loop 2
	)
)

(instance festerBust2 of Prop
	(properties
		x 130
		y 101
		priority 139
		view 2500
	)
)

(instance festerMouth2 of Prop
	(properties
		x 131
		y 53
		view 2500
		loop 2
	)
)

(instance festerEyes2 of Prop
	(properties
		x 130
		y 9
		view 2500
		loop 1
	)
)

(instance festerBust3 of Prop
	(properties
		x 130
		y 101
		view 2501
	)
)

(instance festerMouth3 of Prop
	(properties
		x 129
		y 53
		view 2501
		loop 2
	)
)

(instance festerEyes3 of Prop
	(properties
		x 129
		y 9
		view 2501
		loop 1
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

(instance sound2 of Sound ; UNUSED
	(properties
		flags 1
	)
)

