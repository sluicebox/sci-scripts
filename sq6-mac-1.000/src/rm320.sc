;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm320 of SQRoom
	(properties
		noun 1
		picture 320
	)

	(method (init)
		(self setRegions: 222) ; streetRgn
		(if (== gPrevRoomNum 250)
			(gEgo setPri: 102 1)
			(gEgo posn: -20 103)
		)
		(gEgo setScaler: Scaler 99 30 137 90 normalize: init:)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 21 120 0 123 0 127 39 122 47 125 55 133 81 130 96 126 109 121 133 119 136 136 159 136 159 126 200 126 200 120 248 120 248 117 319 117 319 107 238 107 229 104 229 98 234 93 248 93 248 91 232 91 212 97 208 105 190 105 174 102 146 101 147 105 159 105 159 107 21 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 74 118 93 118 93 120 74 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 39 118 55 118 55 120 39 120
					yourself:
				)
		)
		(if local0
			(boothPoly init:)
			(gCurRoom addObstacle: boothPoly)
		)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(330
				(= local1 1)
				(gEgo posn: 225 95)
				(gEgo normalize: 2)
				(self cue:)
			)
			(240
				(gEgo posn: 30 116)
				(gEgo normalize: 6)
				(self cue:)
			)
			(250
				(gEgo setPri: 102 1 setScript: sExitImp)
			)
			(else
				(gEgo posn: 290 115)
				(gEgo normalize: 1)
				(self cue:)
			)
		)
		(exitPoly330 init:)
		(exit330 init: (gTheExitNCursor new:) approachVerbs: 9) ; ExitUp
		(exit340 init: (gTheExitECursor new:) approachVerbs: 7) ; ExitRight
		(exit240 init: (gTheExitCursor new:) approachVerbs: 8) ; ExitLeft
		(eyesBlink init:)
		(puddles init:)
		(barrels init:)
		(closedBuilding init:)
		(hydrant init:)
		(dewDropInn init:)
		(poles init:)
		(implantSign init:)
		(skyline init:)
		(rearBuilding init:)
		(street init:)
		(openSign init:)
		(closedSign init:)
		(vacancySign init:)
		(toxicBarrels init:)
		(implants init: (gTheExitSCursor new:) approachVerbs: 10) ; ExitDown
		(implantStore init:)
		(implantSignFlash init: setCycle: Fwd)
		(vacancySignFlash init: setCycle: Fwd)
		(if (> (gGame detailLevel:) 2)
			(barrelFlame1 init: setCycle: RandCycle)
			(barrelFlame2 init: setCycle: RandCycle)
		)
		(cond
			((<= 2 (proc0_8 1 3))
				(if (> (gGame detailLevel:) 2)
					(smokeStack1 init: setCycle: RandCycle)
				)
			)
			((> (gGame detailLevel:) 2)
				(smokeStack2 init: setCycle: RandCycle)
			)
		)
		(if (<= 2 (proc0_8 1 3))
			(hooker init: setCycle: Fwd setScript: sHooker)
			(switch (proc0_8 1 6)
				(1
					(Load 140 34004) ; WAVE
					(Load 140 343) ; WAVE
					(alleyThing init:)
				)
				(2
					(if (> (gGame detailLevel:) 2)
						(pimp init: setCycle: Fwd)
					)
				)
				(3)
				(4
					(if (> (gGame detailLevel:) 2)
						(Load 140 34004) ; WAVE
						(Load 140 343) ; WAVE
						(alleyThing init:)
					)
				)
				(5
					(pimp init: setCycle: Fwd)
				)
				(6)
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(= local1 0)
		(gGame handsOn:)
	)

	(method (doit)
		(cond
			(script)
			(local1)
			((exitPoly330 onMe: gEgo)
				(gCurRoom setScript: sExitPoly330)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(sfxSound dispose:)
		(super dispose:)
	)

	(method (notify param1)
		(switch param1
			(1
				(= local0 1)
			)
			(2
				((self obstacles:) delete: boothPoly)
			)
		)
	)

	(method (newRoom)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(switch local2
					(0
						(gMessager say: 0 theVerb 4 0 0 340) ; "You're on R&R. Give it a rest."
						(++ local2)
					)
					(1
						(gMessager say: 0 theVerb 0 0 0 340) ; "GIVE THE BROOM A REST!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPimp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_4 gEgo pimp self)
			)
			(1
				(gMessager say: 21 1 0 0 self) ; "Hmmm. Those two look like people my mom warned me about. I think I should avoid them."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sExit330 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 248 91)
				(= local5 (gEgo x:))
				(= local6 (gEgo y:))
				(= local4 0)
				(= cycles 1)
			)
			(1
				(= cycles 10)
			)
			(2
				(if (and (== (gEgo x:) local5) (== (gEgo y:) local6))
					(+= local4 1)
				else
					(= local4 0)
					(= local5 (gEgo x:))
					(= local6 (gEgo y:))
				)
				(cond
					((and (== (gEgo y:) 91) (== (gEgo x:) 248))
						(self changeState: (+ state 1))
					)
					((< local4 10)
						(self changeState: (- state 1))
					)
					(else
						(self changeState: 4)
					)
				)
			)
			(3
				(gCurRoom newRoom: 330)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterImp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: 1)
				(gEgo setPri: 102 1)
				(gEgo setCycle: Fwd)
				(gEgo setLoop: 1 1)
				(gEgo setScaler: 0)
				(gEgo setMotion: MoveTo 122 117 self)
			)
			(1
				(gEgo ignoreActors: 0)
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sExitImp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: 1)
				(gEgo
					posn: 122 117
					setPri: 102 1
					setCycle: Fwd
					setLoop: 0 1
					setSpeed: 6
					setScaler: 0
				)
				(gEgo setMotion: MoveTo 152 103 self)
			)
			(1
				(gEgo normalize:)
				(gEgo setScaler: Scaler 99 30 137 90)
				(gEgo ignoreActors: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAlleyThingEnterLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setSpeed: 3)
				(= seconds (proc0_8 1 3))
			)
			(1
				(client setCycle: Walk)
				(client setMotion: MoveTo 118 118 self)
			)
			(2
				(client setMotion: MoveTo 118 127 self)
			)
			(3
				(client setMotion: MoveTo 159 123 self)
			)
			(4
				(client setMotion: MoveTo 179 135 self)
			)
			(5
				(client hide:)
				(alleyThingInCans init:)
			)
			(6
				(client x: 160 y: 133 show: setMotion: MoveTo 163 118 self)
			)
			(7
				(client setMotion: MoveTo 0 118 self)
			)
			(8
				(client dispose:)
			)
		)
	)
)

(instance sAlleyThingInCans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfxSound loop: 0 number: 34004 play:)
				(client cycleSpeed: 7 setLoop: 1 setCycle: ROsc 2 0 2 self)
			)
			(1
				(client cycleSpeed: 11 setCycle: CT 4 1 self)
			)
			(2
				(client cycleSpeed: 10 setCycle: ROsc 2 5 7 self)
			)
			(3
				(sfxSound loop: 0 number: 34004 play:)
				(client cycleSpeed: 20 setCycle: CT 17 1 self)
			)
			(4
				(sfxSound loop: 0 number: 343 play:)
				(client cycleSpeed: 5 setCycle: CT 19 1 self)
			)
			(5
				(sfxSound loop: 0 number: 343 play:)
				(client setCel: 17 cycleSpeed: 5 setCycle: CT 19 1 self)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(alleyThing cue:)
				(client hide: dispose:)
			)
		)
	)
)

(instance sEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(client
					cycleSpeed: (proc0_8 10 15)
					setCycle: Osc (proc0_8 2 4) self
				)
			)
			(2
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sHooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 300 900))
			)
			(1
				(switch (proc0_8 0 3)
					(0
						(self setScript: sHookerTossHair)
					)
					(1
						(hooker setCycle: End)
						(= ticks (proc0_8 50 300))
					)
					(2
						(hooker setCel: 0 setLoop: 2 setCycle: End self)
					)
					(3
						(hooker setCycle: End)
						(= ticks (proc0_8 50 300))
					)
				)
			)
			(2
				(hooker setCel: 0 setLoop: 3 setCycle: Fwd)
				(self changeState: 0)
			)
		)
	)
)

(instance sHookerTossHair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hooker setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(hooker setCel: 0 setLoop: 1)
				(= ticks (proc0_8 2 400))
			)
			(2
				(hooker setCycle: End self)
			)
			(3
				(sHooker cue:)
				(self dispose:)
			)
		)
	)
)

(instance sExitPoly330 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 248 91 self)
			)
			(1
				(gCurRoom newRoom: 330)
				(self dispose:)
			)
		)
	)
)

(instance alleyThing of Actor
	(properties
		noun 22
		sightAngle 40
		x -20
		y 116
		view 355
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(self setScript: sAlleyThingEnterLeave)
		(self setScaler: Scaler 103 30 137 90)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alleyThingInCans of Prop
	(properties
		noun 22
		sightAngle 40
		x 188
		y 139
		view 3200
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(self setScript: sAlleyThingInCans)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eyesBlink of Prop
	(properties
		x 279
		y 102
		view 3200
		signal 16385
	)

	(method (init)
		(super init:)
		(self setScript: sEyesBlink)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance implantSignFlash of Prop
	(properties
		noun 18
		x 113
		y 73
		view 320
		loop 5
		signal 16417
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(4 ; Do
				(gMessager say: noun 1) ; "Now, there's an interesting-sounding business name. You wonder what they sell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vacancySignFlash of Prop
	(properties
		noun 9
		x 71
		y 8
		priority 70
		fixPriority 1
		view 320
		loop 4
		cycleSpeed 50
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(4 ; Do
				(gMessager say: noun 1) ; "There's only one way to find out if they mean what they say."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrelFlame1 of Prop
	(properties
		x 207
		y 92
		view 320
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrelFlame2 of Prop
	(properties
		x 72
		y 100
		view 320
		loop 2
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smokeStack1 of Prop
	(properties
		noun 2
		x 241
		y 22
		view 320
		loop 1
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smokeStack2 of Prop
	(properties
		noun 2
		x 31
		y 17
		view 320
		loop 3
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hooker of Prop
	(properties
		noun 20
		x 9
		y 134
		view 321
		loop 3
		signal 16417
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(proc0_4 gEgo pimp)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pimp of Prop
	(properties
		noun 21
		x 27
		y 130
		view 3210
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(1 ; Look
				(gEgo setScript: sPimp)
			)
			(else
				(proc0_4 gEgo pimp)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrels of Feature
	(properties
		noun 10
		sightAngle 40
		x 69
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 72 87 67 87 67 97 72 99 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 205 91 210 91 210 85 207 80 205 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closedBuilding of Feature
	(properties
		noun 3
		sightAngle 40
		x 279
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 101 239 48 249 45 256 35 254 32 254 27 263 25 269 18 275 17 268 8 261 8 255 0 319 0 319 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hydrant of Feature
	(properties
		noun 6
		sightAngle 40
		x 286
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 125 276 113 272 110 278 105 281 100 286 98 294 101 294 106 292 107 300 110 295 114 298 125 285 127
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dewDropInn of Feature
	(properties
		noun 8
		sightAngle 40
		x 46
		y 66
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 133 0 40 17 40 17 0 24 0 24 6 33 0 50 0 25 12 25 35 71 38 80 41 87 47 92 53 91 57 89 59 92 62 92 64 17 64 17 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun 1) ; "It's the Dew Beam Inn, but I'm sure they accept pedestrians also. The door hinges aren't exactly overheated from a steady flow of eager patrons."
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poles of Feature
	(properties
		noun 17
		sightAngle 40
		x 44
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 65 43 120 46 120 46 65
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 82 65 82 122 85 122 85 65
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance implantSign of Feature
	(properties
		noun 18
		sightAngle 40
		x 115
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 69 100 66 102 62 106 53 112 52 119 60 124 61 131 60 137 80 99 89
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(4 ; Do
				(gMessager say: noun 1) ; "Now, there's an interesting-sounding business name. You wonder what they sell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance implantStore of Feature
	(properties
		noun 4
		sightAngle 40
		x 139
		y 53
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 5 73 22 69 22 69 28 74 30 72 100 155 102 204 93 206 70 209 61 206 52 202 24 205 21 205 11 153 5
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(4 ; Do
				(gMessager say: noun 1) ; "Now, there's an establishment still in operation. With this climate, it's no wonder that people might need to track down replacement parts for even the most organic of the population. Hmmmm, I wonder if ... nah, never mind."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance skyline of Feature
	(properties
		noun 2
		sightAngle 40
		x 139
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 278 0 278 48 0 48 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rearBuilding of Feature
	(properties
		noun 19
		sightAngle 40
		x 216
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 25 217 28 241 50 241 90 205 92 209 60
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closedSign of Feature
	(properties
		noun 3
		sightAngle 40
		x 280
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 81 272 76 272 65 303 72 303 100 261 100 261 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vacancySign of Feature
	(properties
		noun 9
		sightAngle 40
		x 78
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 51 2 105 2 104 10 51 10 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance street of Feature
	(properties
		noun 7
		sightAngle 40
		x 177
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 107 161 107 190 100 200 101 206 96 228 91 231 94 227 102 238 110 319 110 319 117 246 117 238 120 230 107 214 108 208 122 195 115 178 109 167 113 162 129 144 128 127 131 122 117 36 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toxicBarrels of Feature
	(properties
		noun 5
		sightAngle 40
		x 201
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 138 160 134 160 134 165 124 168 112 175 112 177 110 181 110 188 113 190 116 194 115 205 119 206 124 209 122 212 115 215 109 224 107 232 108 237 121 246 118 253 122 256 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openSign of Feature
	(properties
		noun 9
		sightAngle 40
		x 9
		y 180
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 1 0 1 1 1 39 17 39 17 0 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puddles of Feature
	(properties
		noun 16
		sightAngle 40
		x 70
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 115 68 111 72 110 74 115 73 116 67 116
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 200 108 194 111 189 110 184 110 177 107 179 105 181 105 190 106 195 107 199 107
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 211 105 206 108 205 104 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 210 101 206 100 205 100 203 102 206 102
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 218 101 214 102 212 100 217 100
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 226 102 223 102 221 100 224 100
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit240 of ExitFeature
	(properties
		approachY 127
		y 100
		nextRoom 240
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 24 0 24 43 16 55 16 130 0 134
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance implants of ExitFeature
	(properties
		noun 4
		approachX 151
		approachY 103
		y 75
		nextRoom 250
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 90 138 80 136 73 157 73 157 106 96 106
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(4 ; Do
				(gMessager say: noun 1) ; "Now, there's an establishment still in operation. With this climate, it's no wonder that people might need to track down replacement parts for even the most organic of the population. Hmmmm, I wonder if ... nah, never mind."
			)
			(10 ; ExitDown
				(gEgo setScript: sEnterImp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 10)
	)
)

(instance exit340 of ExitFeature
	(properties
		nsLeft 314
		nsTop 101
		nsRight 320
		nsBottom 117
		approachX 318
		approachY 115
		nextRoom 340
		message 7
	)
)

(instance exit330 of ExitFeature
	(properties
		approachX 231
		approachY 95
		nextRoom 330
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 88 227 75 247 75 247 98 242 98 232 88
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(= local1 1)
		(super handleEvent: event)
	)

	(method (cue)
		(super doVerb: 9)
	)
)

(instance exitPoly330 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 89 236 98 241 98 232 89
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance boothPoly of Polygon
	(properties)

	(method (init)
		(self type: 2)
		(super init: 176 110 176 106 219 106 219 110)
	)
)

(instance sfxSound of Sound
	(properties)
)

