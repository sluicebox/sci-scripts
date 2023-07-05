;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
	local2
)

(instance rm700 of Room
	(properties
		noun 1
		picture 700
		style 14
		exitStyle 13
	)

	(method (init)
		(DoAudio 13 32) ; AudChannels
		(super init:)
		(LoadMany rsVIEW 701 7011 7012 7013 901)
		(gGkMusic1
			setLoop: -1
			number: 700
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(if (== (gGame detailLevel:) 3)
			(if (DoSound sndGET_AUDIO_CAPABILITY)
				(Load 140 701) ; WAVE
			)
			(gGkSound1 setLoop: -1 number: 701 flags: 5 play:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 27 121 55 127 54 134 40 134 28 131
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 3 122 3 141 142 141 144 120 236 136 248 145 282 145 273 135 249 125 212 125 151 116 164 102 154 102 108 107 76 100 76 95 69 95 69 101 44 116
					yourself:
				)
		)
		(gWalkHandler add: self)
		(gGame handsOff:)
		(moundEntry init:)
		(mound init:)
		(sky init:)
		(vista init:)
		(if (!= gPrevRoomNum 710)
			(self setScript: arrive)
		else
			(self setScript: comeOutOfMound)
		)
	)

	(method (dispose)
		(gGkSound1 flags: 1)
		(DoAudio 13 63) ; AudChannels
		(gEgo setScale: 0)
		(gWalkHandler delete: self)
		(DisposeScript 64935)
		(gGkMusic1 stop:)
		(gGkSound1 stop:)
		(super dispose:)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (== (self script:) comeOutOfMound))
				(gEgo inRect: 65 81 110 100)
			)
			(gCurRoom newRoom: 710)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) KEY_RETURN)
			(= local1 (event x:))
			(= local2 (event y:))
			(cond
				((and local0 (vista onMe: event))
					(gGame handsOff:)
					(gCurRoom setScript: goUpTrail)
					(event claimed: 1)
				)
				((and (not local0) (not (vista onMe: event)))
					(gGame handsOff:)
					(gCurRoom setScript: goDownTrail)
					(event claimed: 1)
				)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance goDownTrail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(1
				(gEgo
					setScaler: Scaler 70 100 132 118
					setCycle: 0
					setCycle: Fwd
					setLoop: 7 1
					ignoreActors:
					setMotion: MoveTo 145 125 self
				)
			)
			(2
				(gEgo setPri: 1 setMotion: MoveTo 120 163 self)
			)
			(3
				(gEgo
					setScaler: Scaler 43 22 145 99
					setMotion: MoveTo 133 143 self
				)
			)
			(4
				(gEgo
					normalize: 0 901
					ignoreActors:
					setMotion: MoveTo 103 140 self
				)
			)
			(5
				(gEgo setMotion: PolyPath 73 100)
			)
		)
	)
)

(instance goUpTrail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gEgo setMotion: PolyPath 103 140 self)
			)
			(1
				(gEgo
					setPri: 1
					setCycle: 0
					setCycle: Fwd
					setLoop: 4
					ignoreActors:
					setMotion: MoveTo 133 143 self
				)
				(= ticks 1)
			)
			(2
				(gEgo setMotion: MoveTo 120 163 self)
			)
			(3
				(gEgo
					setScaler: Scaler 50 90 132 118
					setMotion: MoveTo 145 125 self
				)
			)
			(4
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(5
				(gEgo normalize: 0 901 ignoreActors: setScaler: 0)
				(gEgo setMotion: PolyPath 73 100)
			)
		)
	)
)

(instance comeOutOfMound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(truck
					view: 7013
					loop: 0
					cel: 0
					posn: 309 145
					brLeft: 280
					brTop: 142
					brBottom: 144
					brRight: 282
					init:
					setPri: 7
				)
				(driver init:)
				(gEgo
					normalize: 0 901
					init:
					posn: 74 99
					setScaler: Scaler 43 22 145 99
					setMotion: MoveTo 92 108 self
				)
			)
			(1
				(= local0 0)
				(gEgo setMotion: PolyPath 103 140 self)
			)
			(2
				(gEgo
					setPri: 1
					setCycle: 0
					setCycle: Fwd
					setLoop: 4 1
					ignoreActors:
					setMotion: MoveTo 133 143 self
				)
				(= ticks 1)
			)
			(3
				(gEgo setMotion: MoveTo 120 163 self)
			)
			(4
				(gEgo
					setScaler: Scaler 50 90 132 118
					setMotion: MoveTo 145 125 self
				)
			)
			(5
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(6
				(gEgo normalize: 0 901 ignoreActors: setScaler: 0)
				(gEgo setMotion: PolyPath 210 131 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance arrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 220)
				(gGame setCursor: myInvisCursor 1)
				(SetFlag 220)
				(= seconds 3)
			)
			(1
				(if (== (gGame printLang:) 49)
					(theDayNum init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (== (gGame printLang:) 49)
					(dayPeriod init: setCycle: End self)
				else
					(self cue:)
				)
			)
			(3
				(theDay init: setCycle: End self)
			)
			(4
				(if (== (gGame printLang:) 49)
					(self cue:)
				else
					(theDayNum init: setCycle: End self)
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(gMessager say: 7 0 4 0 self) ; "And then the wheel went round and round, I could not find my way. Twelve and three and turn the key, I heard the madman say...."
			)
			(7
				(theDay dispose:)
				(theDayNum dispose:)
				(dayPeriod dispose:)
				(= cycles 3)
			)
			(8
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(= cycles 5)
			)
			(9
				(truck init: cycleSpeed: 12 setCycle: End self)
				(gGkSound2 number: 703 setLoop: -1 play:)
			)
			(10
				(= seconds 4)
			)
			(11
				(truck loop: 1 cel: 0 posn: 312 74 setCycle: End self)
			)
			(12
				(truck loop: 2 cel: 0 cycleSpeed: 14 setCycle: End self)
			)
			(13
				(gGkSound2 stop:)
				(truck
					view: 7013
					loop: 0
					cel: 0
					posn: 309 145
					brLeft: 280
					brTop: 142
					brBottom: 144
					brRight: 282
					setPri: 7
					ignoreActors:
				)
				(driver init:)
				(gEgo
					view: 7011
					loop: 0
					cel: 1
					x: 273
					y: 143
					state: (| (gEgo state:) $0002)
					init:
					setPri: 14
					ignoreActors:
					setSpeed: 10
					setCycle: End self
				)
			)
			(14
				(gEgo loop: 1 cel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(15
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(16
				(gEgo setCycle: Beg self)
			)
			(17
				(gEgo view: 901 normalize: 1 901 posn: 265 140)
				(= cycles 3)
			)
			(18
				(gEgo posn: 265 140 setMotion: MoveTo 213 131 self)
			)
			(19
				(gEgo
					view: 7012
					loop: 0
					cel: 0
					setSpeed: 10
					setCycle: End self
				)
				(gMessager say: 7 0 1 1 self) ; "(GABE ARRIVES IN AFRICA AND IS LOOKING OVER THE SNAKE MOUND TRIBAL HOME OF TETELO'S PEOPLE. HE IS WHISPERING TO HIMSELF HERE WITH AWE AND FEAR)Wheel-within-a-wheel!"
			)
			(20 1)
			(21
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(22
				(gMessager say: 7 0 1 2 self) ; "(RRCC. DIDN'T FIND THESE ON TAPES. CREDITED AS MARK HAMILL)You want I stay here, right? It's a long walk back to the city."
			)
			(23
				(gEgo loop: 2 cel: 0 setCycle: End)
				(gMessager say: 7 0 1 3 self) ; "(TO DRIVER. DISTRACTED)Yeah. Sure. Wait here, please."
			)
			(24
				(gEgo view: 901 normalize: 7 901)
				(gMessager sayRange: 7 0 1 4 5 self) ; "(ALMOST TO HIMSELF, LOOKING AT SNAKE MOUND AGAIN)I may be awhile, though."
			)
			(25
				(ClearFlag 220)
				(gGame handsOn:)
			)
		)
	)
)

(instance theDayNum of Prop
	(properties
		x 252
		y 31
		view 375
		loop 9
	)

	(method (init)
		(= x (proc13_6 75 275 250 252 252))
		(= y (proc13_6 115 110 52 31 31 31))
		(self setPri: 190)
		(super init:)
	)
)

(instance theDay of Prop
	(properties
		x 76
		y 68
		view 375
	)

	(method (init)
		(= x (proc13_6 136 61 45 76 76))
		(= y (proc13_6 58 68 50 68 68))
		(self setPri: 190)
		(super init:)
	)
)

(instance dayPeriod of Prop
	(properties
		x 70
		y 115
		view 375
		loop 11
	)

	(method (init)
		(super init: &rest)
		(self setPri: 160)
	)
)

(instance truck of Prop
	(properties
		noun 5
		x 305
		y 69
		view 701
	)
)

(instance driver of Feature
	(properties
		noun 6
		nsLeft 305
		nsTop 97
		nsRight 319
		nsBottom 108
		y 150
	)
)

(instance moundEntry of Feature
	(properties
		noun 2
		nsLeft 65
		nsTop 86
		nsRight 82
		nsBottom 100
		sightAngle 40
		approachX 73
		approachY 100
		approachDist 10
		x 73
		y 122
	)
)

(instance mound of Feature
	(properties
		noun 4
		nsTop 53
		nsRight 186
		nsBottom 100
		sightAngle 40
		x 100
		y 100
	)
)

(instance sky of Feature
	(properties
		noun 3
		nsTop 23
		nsRight 319
		nsBottom 40
		sightAngle 40
		x 150
		y 40
	)
)

(instance vista of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 120 155 120 167 108 186 99 191 74 238 48 163 21 319 22 319 148 148 148
					yourself:
				)
		)
		(super init:)
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

