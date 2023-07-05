;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use Scaler)
(use ROsc)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
	Bouncer 1
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7 = -1
	local8 = -1
	local9
	local10
	local11
	local12
)

(instance rm330 of SQRoom
	(properties
		noun 1
		picture 330
	)

	(method (init)
		(self setRegions: 222) ; streetRgn
		(gEgo init: normalize: setScaler: Scaler 53 17 138 40)
		(= local8 (= local7 (gGSound1 vol:)))
		(super init:)
		(if (!= gPrevRoomNum 300)
			(if (not (IsFlag 26))
				(= local11 300)
			else
				(switch (proc0_8 0 2)
					(0
						(= local11 300)
					)
					(1
						(= local11 310)
					)
					(2
						(= local11 602)
					)
				)
			)
		else
			(= local11 (gGSound1 number:))
		)
		(if (IsFlag 8)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 15 132 15 138 134 138 161 122 221 138 319 138 319 96 300 96 299 108 286 113 274 113 266 102 259 95 234 93 229 92 222 91 211 88 193 86 177 83 120 86 125 102 118 107 106 104 84 111 60 108 29 100 29 103 50 108 41 126
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 237 99 245 101 244 107 235 105
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((= gPolygon (Polygon new:))
						type: PContainedAccess
						init: 15 132 15 138 134 138 161 122 221 138 319 138 319 96 300 96 299 108 286 113 274 113 266 102 259 95 233 91 226 88 262 64 239 60 209 92 177 83 120 86 125 102 118 107 106 104 84 111 60 108 29 100 29 103 50 108 41 126
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 237 99 249 101 248 107 231 105
						yourself:
					)
			)
		)
		(if local0
			(boothPoly init:)
			(gCurRoom addObstacle: boothPoly)
		)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(200
				(= local1 1)
				(= local9 1)
				(gEgo enterRoom: 37 103 61 116 self)
				(airCar cue:)
			)
			(300
				(= local1 1)
				(= local10 1)
				(gEgo enterRoom: 242 68 223 90 self)
			)
			(340
				(gEgo posn: 272 131)
				(gEgo normalize: 7)
				(self cue:)
			)
			(else
				(gEgo posn: 70 131)
				(airCar cue:)
				(airCar cue:)
				(gEgo normalize: 6)
				(self cue:)
			)
		)
		(PalCycle 0 124 127 -1 25) ; Start
		(PalCycle 0 104 108 -1 5) ; Start
		(Palette 2 64 78 60) ; PalIntensity
		(arcadeExit init:)
		(nightclubExit init:)
		(exit320 init: gTheExitSCursor approachVerbs: 10) ; ExitDown
		(exit340 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(notAnExit init: gTheExitNoneCursor)
		(signalLight init:)
		(airCar init: hide:)
		(if (<= 2 (proc0_8 1 3))
			(if (> (gGame detailLevel:) 2)
				(barrelFire init:)
			)
		else
			(barrelFire2 init:)
		)
		(bouncer init:)
		(window2 init: hide:)
		(if (IsFlag 28)
			(bouncer setScript: sStopRoger)
			(window2 show:)
		)
		(Load 140 337) ; WAVE
		(if (and (== 3 (proc0_8 1 4)) (not (gEgo has: 61))) ; Full_Tray
			(Load 140 336) ; WAVE
			(alleyThing init:)
		)
		(arcade init:)
		(barrelDebris init:)
		(closedDoor init: approachVerbs: 4) ; Do
		(graffiti init:)
		(leftShip init: approachVerbs: 4) ; Do
		(rightShip init: approachVerbs: 4) ; Do
		(light init:)
		(orions init:)
		(puddle init:)
		(sidewalk init:)
		(sidewalk2 init:)
		(signalStand init:)
		(street init:)
		(if (IsFlag 8)
			(bouncer dispose:)
			(window2 show: setCel: 1)
			(clubClosed init:)
		else
			(brokenWindow init:)
			(PalCycle 0 93 94 1 50) ; Start
			(PalCycle 0 218 220 -1 25) ; Start
		)
	)

	(method (cue)
		(= local1 0)
		(gGame handsOn:)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			(local1)
			((arcadeExit onMe: gEgo)
				(gCurRoom setScript: sExitToArcade)
			)
			((nightclubExit onMe: gEgo)
				(gCurRoom setScript: sExitToClub)
			)
		)
		(= local5 (GetDistance (gEgo x:) (gEgo y:) 55 110))
		(= local6 (GetDistance (gEgo x:) (gEgo y:) 219 87))
		(cond
			((and (<= local5 70) (> local7 -1))
				(if (> (= local12 local5) local7)
					(= local12 local7)
				)
				(if (== local9 1)
					(gGSound1 setVol: (- local7 local12))
				else
					(gGSound1
						number: 200
						loop: -1
						play:
						setVol: (- local7 local12)
					)
					(= local9 1)
				)
			)
			((and (<= local6 70) (not (IsFlag 28)) (> local7 -1))
				(if (> (= local12 local6) local7)
					(= local12 local7)
				)
				(if (== local10 1)
					(gGSound1 setVol: (- local7 local12))
				else
					(gGSound1
						number: local11
						loop: -1
						play:
						setVol: (- local7 local12)
					)
					(= local10 1)
				)
			)
			((> local7 -1)
				(= local9 0)
				(= local10 0)
				(gGSound1 setVol: 0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(PalVary 3) ; PalVaryKill
		(gEgo setScale: 0 normalize:)
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
			(3
				(window2 show:)
				(bouncer setScript: sCloseClub)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(switch local2
					(0
						(gMessager say: 0 theVerb 5 0 0 340) ; "Hey, take it easy. You're on R&R. You wouldn't be so anxious to use that if you were at work."
						(++ local2)
					)
					(1
						(gMessager say: 0 theVerb 0 0 0 340) ; "GIVE THE BROOM A REST!"
					)
				)
			)
			(1 ; Look
				(if (IsFlag 28)
					(gMessager say: 1 1 7) ; "Things have quieted a bit since that endodroid got loose. The arcade's still happening, but Orion's is real quiet."
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

(instance Bouncer of SmallTalker
	(properties
		talkView 331
		talkLoop 2
	)

	(method (init)
		(= client bouncer)
		(Load rsVIEW 331)
		(super init:)
	)
)

(instance sTalkBouncer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 182 90 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(if (IsFlag 28)
					(gMessager say: 18 2 4 0 self) ; "I told you the situation here, so beat it!"
				else
					(gMessager say: 18 2 0 0 self) ; "Hello, Mr. Bouncer."
				)
			)
			(3
				(super dispose:)
			)
		)
	)
)

(instance sCloseClub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 331 loop: 0 setCycle: End self)
			)
			(1
				(bouncer setScript: sStopRoger)
			)
		)
	)
)

(instance sStopRoger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bouncer view: 331 setLoop: 1 setCel: 0 hide:)
				(= cycles 100)
			)
			(1
				(gGame handsOn:)
				(= ticks 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(if (and (< 190 (gEgo x:) 240) (< (gEgo y:) 95))
					(= ticks 1)
				else
					(self changeState: 2)
				)
			)
			(4
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(- (bouncer x:) 13)
						(+ (bouncer y:) 2)
						self
				)
			)
			(5
				(proc0_4 gEgo bouncer self)
			)
			(6
				(bouncer show: setCycle: End self)
			)
			(7
				(gMessager say: 18 2 5 0 self) ; "Hold it right there, Pal. You don't want to go in there. Trust me. It's not a pretty sight, but then, neither are you. Nonetheless, it's bad news in there and I can't let you enter, so hit the pavement."
			)
			(8
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 5)
						self
				)
			)
			(9
				(gGame handsOn:)
				(= ticks 1)
			)
			(10
				(= cycles 1)
			)
			(11
				(if (and (< 190 (gEgo x:) 240) (< (gEgo y:) 95))
					(= cycles 1)
				else
					(self changeState: 10)
				)
			)
			(12
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(- (bouncer x:) 13)
						(+ (bouncer y:) 2)
						self
				)
			)
			(13
				(proc0_4 gEgo bouncer self)
			)
			(14
				(gMessager say: 18 2 4 0 self) ; "I told you the situation here, so beat it!"
			)
			(15
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 5)
						self
				)
			)
			(16
				(self changeState: 9)
			)
		)
	)
)

(instance sAlleyThingEnterLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setSpeed: 5)
				(= seconds (proc0_8 1 2))
			)
			(1
				(client setCycle: Walk)
				(client setMotion: MoveTo 150 110 self)
			)
			(2
				(client setMotion: MoveTo 269 105 self)
			)
			(3
				(client hide:)
				(alleyThingInCan init:)
			)
			(4
				(alleyThingInCan hide:)
				(alleyThingInCan dispose:)
				(client show:)
				(client setMotion: MoveTo 219 92 self)
			)
			(5
				(client setMotion: MoveTo 144 90 self)
			)
			(6
				(client setMotion: MoveTo 140 56 self)
			)
			(7
				(client setMotion: MoveTo 166 47 self)
			)
			(8
				(client dispose:)
			)
		)
	)
)

(instance sAlleyThingInCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 7)
				(client setLoop: 2)
				(client setCycle: End self)
			)
			(1
				(sfxSound setLoop: 0 number: 336 play:)
				(client cycleSpeed: 4)
				(client setLoop: 4)
				(client setCycle: ROsc (proc0_8 20 30) 0 1 self)
			)
			(2
				(client setLoop: 3)
				(client setCycle: End self)
			)
			(3
				(client cycleSpeed: 11)
				(client setLoop: 4)
				(client setCel: 0)
				(client setCycle: CT 3 1 self)
			)
			(4
				(client setCycle: ROsc 2 4 5 self)
			)
			(5
				(client setCel: 4)
				(= ticks 5)
			)
			(6
				(alleyThing cue:)
			)
		)
	)
)

(instance sBouncer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (proc0_8 20 50))
			)
			(1
				(client cycleSpeed: 12)
				(client setLoop: 0)
				(client setCycle: ROsc 1 (proc0_8 0 2) (proc0_8 3 5) self)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(if (and (< 170 (gEgo x:) 240) (< (gEgo y:) 110))
					(self changeState: 6)
				else
					(self changeState: 4)
				)
			)
			(4
				(client setLoop: 3)
				(client setCycle: Fwd)
				(= ticks (proc0_8 60 100))
			)
			(5
				(if (and (< 170 (gEgo x:) 240) (< (gEgo y:) 110))
					(self changeState: 6)
				else
					(self changeState: 0)
				)
			)
			(6
				(client cycleSpeed: 8)
				(client setLoop: 1)
				(client setCycle: End self)
			)
			(7
				(client setCycle: Beg self)
			)
			(8
				(client setLoop: 2)
				(client setCycle: Fwd)
				(= ticks 30)
			)
			(9
				(if (and (< 170 (gEgo x:) 240) (< (gEgo y:) 110))
					(self changeState: 7)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance sEnterAirCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
			)
			(1
				(if (< (gEgo x:) 170)
					(sfxSound loop: 0 number: 333 play:)
					(client cycleSpeed: 5)
					(client setCel: 0)
					(client show:)
					(client setCycle: End self)
				)
			)
			(2
				(client hide:)
			)
			(3
				(client hide:)
			)
			(4
				(client hide:)
			)
			(5
				(if (and (< (gEgo x:) 170) (< 40 (Random 1 100)))
					(sfxSound loop: 0 number: 333 play:)
					(client
						cycleSpeed: (proc0_8 4 6)
						show:
						setCel: 0
						setCycle: End self
					)
				)
			)
			(6
				(client hide:)
			)
			(7
				(self changeState: 5)
			)
		)
	)
)

(instance sExitToArcade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 37 103 self)
			)
			(1
				(= local7 -1)
				(gGSound1 setVol: local8)
				(= ticks 1)
			)
			(2
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance sExitToClub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 240 70 self)
			)
			(1
				(= local7 -1)
				(gGSound1 setVol: local8)
				(= ticks 1)
			)
			(2
				(gCurRoom newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sSignalAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(if (== (client cel:) 10)
					(sfxSound number: 337 loop: 0 play:)
					(client setCycle: Beg self)
					(airCar cue:)
				else
					(sfxSound number: 337 loop: 0 play:)
					(client setCycle: End self)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sfxSound of Sound
	(properties)
)

(instance alleyThing of Actor
	(properties
		noun 17
		sightAngle 40
		x 94
		y 85
		view 355
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(self setScript: sAlleyThingEnterLeave)
		(self setScaler: Scaler 72 27 138 40)
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

(instance alleyThingInCan of Prop
	(properties
		noun 17
		sightAngle 40
		x 272
		y 104
		priority 80
		view 330
		signal 16385
	)

	(method (init)
		(self setScript: sAlleyThingInCan)
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

(instance airCar of Prop
	(properties
		noun 6
		x 226
		y 100
		view 338
		signal 20513
	)

	(method (init)
		(self setPri: 115)
		(self hide:)
		(self setScript: sEnterAirCar)
		(self setCel: 0)
		(super init:)
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

(instance barrelFire of Prop
	(properties
		noun 3
		sightAngle 40
		x 1
		y 137
		view 330
		cycleSpeed 8
	)

	(method (init)
		(self setCycle: RandCycle)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(26 ; ???
				(gMessager say: noun theVerb) ; "Haven't we taught you not to play with fire? Well, except for that one time in Space Quest 2, but that was very necessary."
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

(instance barrelFire2 of Prop
	(properties
		noun 3
		sightAngle 40
		x 278
		y 99
		view 330
		loop 1
		cycleSpeed 9
	)

	(method (init)
		(self setCycle: Fwd)
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

(instance bouncer of Prop
	(properties
		noun 18
		x 202
		y 86
		view 3300
		signal 20513
	)

	(method (init)
		(super init:)
		(self setScript: sBouncer)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gEgo setScript: sTalkBouncer)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance signalLight of Prop
	(properties
		noun 5
		x 163
		y 132
		view 336
		signal 20513
	)

	(method (init)
		(super init:)
		(self setScript: sSignalAction)
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

(instance window2 of View
	(properties
		noun 22
	)

	(method (init)
		(self view: 335 setLoop: 0 setCel: 0 setPri: 80 posn: 159 57)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== (self cel:) 1)
					(gMessager say: noun theVerb) ; "The endodroid didn't exactly make a tidy departure. The window's boarded up now."
				else
					(gMessager say: 15 theVerb) ; "The only way customers could see out of that place is to break some holes. That's some seriously dirty glass."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clubClosed of View
	(properties
		noun 23
	)

	(method (init)
		(self view: 335 setLoop: 0 setCel: 2 setPri: 83 posn: 188 69)
		(super init:)
	)
)

(instance arcade of Feature
	(properties
		noun 2
		sightAngle 40
		x 54
		y 65
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 130 0 0 106 0 108 51 106 98 82 107 62 107 44 103 44 109 36 124 13 131 6 128
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

(instance arcadeExit of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 115 67 107 57 106 44 110
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

(instance barrelDebris of Feature
	(properties
		noun 9
		sightAngle 40
		x 271
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 104 266 100 268 93 279 88 283 91 283 94 277 99 268 105
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

(instance brokenWindow of Feature
	(properties
		noun 15
		sightAngle 40
		x 172
		y 35
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 39 178 45 178 7 162 3
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

(instance closedDoor of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 308
		approachY 96
		x 308
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 92 297 50 319 50 319 92
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

(instance graffiti of Feature
	(properties
		noun 13
		sightAngle 40
		x 11
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 102 22 102 19 122 1 122
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

(instance leftShip of Feature
	(properties
		noun 14
		sightAngle 40
		approachX 125
		approachY 86
		x 122
		y 66
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 130 82 119 82 118 77 107 72 109 57 118 50 124 50 130 60 136 59 134 67 138 71 134 75
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

(instance light of Feature
	(properties
		noun 8
		sightAngle 40
		x 117
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 102 113 66 102 70 101 64 113 60 114 38 121 33 126 35 134 48 134 50 126 50 128 45 121 36 117 42 116 59 127 64 127 68 116 66 117 101
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

(instance orions of Feature
	(properties
		noun 4
		sightAngle 40
		x 237
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 0 319 0 319 49 296 49 296 91 296 92 248 93 185 80 177 75 184 65 181 62 177 64 171 60 156 59
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

(instance rightShip of Feature
	(properties
		noun 7
		sightAngle 40
		approachX 164
		approachY 84
		x 165
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 61 170 61 176 65 182 64 184 67 179 69 174 77 161 80 154 76 147 75
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

(instance puddle of Feature
	(properties
		noun 16
		sightAngle 40
		x 95
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 134 90 138 102 138 108 133 88 130
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

(instance sidewalk of Feature
	(properties
		noun 11
		sightAngle 40
		x 64
		y 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 138 12 131 37 123 44 110 56 107 83 108 105 99 116 102 32 138
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

(instance sidewalk2 of Feature
	(properties
		noun 11
		sightAngle 40
		x 243
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 318 122 182 95 168 80 178 77 194 82 245 94 318 94
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

(instance signalStand of Feature
	(properties
		noun 5
		sightAngle 40
		x 161
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 132 160 102 154 105 142 100 148 96 151 97 158 92 163 84 166 85 170 89 180 89 181 93 178 99 168 101 167 131
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

(instance street of Feature
	(properties
		noun 12
		sightAngle 40
		x 177
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 137 118 100 120 82 151 77 169 82 181 95 316 122 318 137 208 138 162 126 141 138
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

(instance nightclubExit of Feature
	(properties
		noun 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 82 232 89 232 85 201 80
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

(instance exit320 of ExitFeature
	(properties
		nextRoom 320
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 47 130 152 130 140 138 33 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit340 of ExitFeature
	(properties
		nextRoom 340
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 133 313 123 320 124 320 138 210 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance notAnExit of ExitFeature
	(properties
		noun 1
		x 133
		y 39
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 62 154 68 149 72 144 73 146 77 137 78 134 75 138 71 134 67 137 59 130 61 123 49 111 49 107 0 154 0 156 61
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance boothPoly of Polygon
	(properties)

	(method (init)
		(self type: 2)
		(super init: 96 125 80 119 105 110 120 118)
	)
)

