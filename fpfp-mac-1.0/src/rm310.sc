;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	[local0 2]
	local2
	local3 = 1
)

(instance rm310 of FPRoom
	(properties
		noun 1
		picture 310
		style 100
		east 320
		south 240
		west 300
	)

	(method (init)
		(gEgo init: setScale: Scaler 75 48 182 41 normalize:)
		(switch gPrevRoomNum
			(south
				(gEgo x: 259)
				(if
					(and
						(== gPrevRoomNum 240)
						(or (== gCurPuzzle 14) (== gCurPuzzle 15))
					)
					(gCurRoom setScript: sEnterFromFire)
				else
					(gGame handsOn:)
				)
			)
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(west
				(= style 12)
				(if (<= (gEgo y:) 80)
					(self setScript: sEnterWest)
				else
					(gGame handsOn:)
				)
			)
			(500
				(self setScript: sEnterSouth)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 259 y: 175 setHeading: 0)
				(gGame handsOn:)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 299 116 248 126 211 132 200 129 184 118 170 116 145 118 152 110 112 103 162 72 53 71 36 80 17 67 74 35 77 25 0 10 0 0 319 0 319 114
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 248 172 252 189 69 189 67 172
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 30 172 45 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 292 142 319 142 319 189 267 189 260 171 286 170
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 70 9 70 32 85 17 99 0 102
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 17 31 39 20 52 23 30 35 yourself:)
		)
		(yardEntrance init: setOnMeCheck: 1 4)
		(bottomBuilding init: setOnMeCheck: 1 8)
		(westBuilding init: setOnMeCheck: 1 16)
		(tree init: setOnMeCheck: 1 32)
		(church init: setOnMeCheck: 1 64)
		(windMill init: setOnMeCheck: 1 128)
		(graveyard init: setOnMeCheck: 1 256)
		(stageCoach init: setOnMeCheck: 1 512)
		(coffin init: setOnMeCheck: 1 1024)
		(roses init: setOnMeCheck: 1 2048)
		(bushes init: setOnMeCheck: 1 4096)
		(belfry init: setOnMeCheck: 26505)
		(leftWindow init: setOnMeCheck: 26505)
		(rightWindow init: setOnMeCheck: 26505)
		(if (IsFlag 1)
			(windowLeft setCycle: Fwd init:)
			(windowRight setCycle: Fwd init:)
			(window1 setCycle: Fwd init:)
			(window2 setCycle: Fwd init:)
			(window3 setCycle: Fwd init:)
		)
		(churchDoor init: stopUpd: approachVerbs: 1 4) ; Look, Do
		(coffinLid init: stopUpd: approachVerbs: 4) ; Do
		(weatherVane stopUpd: init:)
		(windMillBlades cel: global129 setCycle: Fwd init:)
		(if (!= gCurPuzzle 14)
			(gGameMusic1
				number: 310
				flags: 1
				loop: -1
				play:
				setVol: (if (== (churchDoor doorState:) 2) 127 else 20)
			)
		)
		(windmillSound play:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 2)
				(gCurRoom setScript: sExitSouth)
			)
			((proc0_1 gEgo 8192)
				(gCurRoom setScript: sExitWest)
			)
		)
	)

	(method (dispose)
		(if (!= gCurPuzzle 14)
			(gGameMusic1 fade:)
		)
		(if (and (!= gNewRoomNum 320) (!= gCurPuzzle 14))
			(gGameMusic2 fade:)
		)
		(= global129 (windMillBlades cel:))
		(super dispose:)
	)
)

(instance sEnterFromFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
				(gEgo posn: 259 240)
			)
			(1
				(proc0_15 0 16)
				(gEgo setMotion: MoveTo 259 181 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 45) self
				)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 65 230 setMotion: MoveTo 65 175 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 0 (- (gEgo y:) 10) self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sEnterWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 8 setMotion: PolyPath 31 87 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 0)
				(keyForInset dispose:)
				(localSound number: 2311 play: self)
			)
			(1
				(gEgo get: 6 keyForInset) ; Church_Key
				(gGame points: 1)
				(= seconds 2)
			)
			(2
				(inDoorInset dispose:)
				(churchDoor setLoop: 0 show:)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWeatherVaneSpin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 7 15))
			)
			(1
				(if (== (= local2 (Random 0 11)) (weatherVane cel:))
					(+= local2 5)
				)
				(weatherVane
					setCycle:
						CT
						local2
						(if (> (weatherVane cel:) local2) 1 else -1)
						self
				)
				(if local3
					(weatherVaneSound play:)
				)
			)
			(2
				(weatherVane stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sOpenCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 0)
				(gMessager say: 24 4 6 1 self) ; "You slowly open the coffin."
			)
			(1
				(localSound number: 2700 play: self)
				(coffinLid setCycle: End self)
			)
			(2
				(windMillBlades stopUpd:)
			)
			(3
				(gMessager say: 24 4 6 2 3 self) ; "<Cough!> <Hack!> <Cough!>"
				(localSound number: 2949 play:)
			)
			(4
				(windMillBlades startUpd:)
				(localSound number: 2700 play:)
				(coffinLid setCycle: Beg self)
			)
			(5
				(coffinLid stopUpd:)
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBringUpInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(weatherVane setScript: 0)
				(gCast eachElementDo: #stopUpd)
				(= cycles 5)
			)
			(1
				(gCurRoom setInset: inDoorInset)
				(self dispose:)
			)
		)
	)
)

(instance churchDoor of Door
	(properties
		x 168
		y 110
		noun 2
		approachX 169
		approachY 125
		view 310
		loop 1
		priority 8
		lockedCase 1
		openSnd 2146
		closeSnd 2147
		openVerb 4
		forceClose 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((and (not (gEgo has: 6)) (== doorState 0)) ; Church_Key
						(gMessager say: noun 1 4) ; "You can't look through the keyhole; it's blocked."
					)
					((and (gEgo has: 6) (== doorState 0)) ; Church_Key
						(gMessager say: noun 1 3) ; "This looks just like the door where you stole that church key."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Do
				(if (== doorState 0)
					(candles init: setCycle: Fwd approachVerbs: 4) ; Do
				)
				(super doVerb: theVerb &rest)
			)
			(35 ; Church_Key
				(if (not locked)
					(= locked 1)
					(SetFlag 28)
					(gMessager say: noun 35 2) ; "You lock the Church door."
				else
					(= locked 0)
					(ClearFlag 28)
					(gMessager say: noun 35 1) ; "You unlock the Church door."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (== doorState 2)
			(SetFlag 23)
			(rightDoor init: approachVerbs: 4 1 setOnMeCheck: 26505) ; Do, Look
			(insideChurch init: setOnMeCheck: 1 16384)
			(if (!= gCurPuzzle 14)
				(gGameMusic1 fade: 127 10 16 0)
			)
		else
			(ClearFlag 23)
			(candles dispose:)
			(rightDoor dispose:)
			(insideChurch dispose:)
			(if (!= gCurPuzzle 14)
				(gGameMusic1 fade: 20 10 16 0)
			)
		)
	)

	(method (init)
		(if (or (gEgo has: 6) (>= gCurPuzzle 14)) ; Church_Key
			(self setLoop: 0)
		)
		(if (IsFlag 23)
			(churchDoor doorState: 2)
			(candles init: setCycle: Fwd approachVerbs: 4) ; Do
			(rightDoor init: approachVerbs: 4 1 setOnMeCheck: 26505) ; Do, Look
		else
			(churchDoor doorState: 0)
		)
		(super init:)
		(if (IsFlag 28)
			(churchDoor locked: 1)
		else
			(churchDoor locked: 0)
		)
	)
)

(instance windMillBlades of Prop
	(properties
		x 318
		y 7
		noun 9
		view 310
		loop 3
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance candles of Prop
	(properties
		x 170
		y 115
		z 30
		noun 20
		approachX 186
		approachY 117
		view 310
		loop 2
		priority 6
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 66)
					(gMessager say: noun 4 5) ; "You've already got as much wax as you'll need."
				else
					(gMessager say: noun 4 0) ; "You would never dream of stealing a candle from a church."
					(gEgo get: -1 4 2) ; Candle_Wax
					(gGame points: 1)
					(SetFlag 66)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance weatherVane of Prop
	(properties
		x 233
		y 153
		noun 18
		view 310
		loop 4
		priority 14
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: sWeatherVaneSpin)
		)
	)
)

(instance coffinLid of Prop
	(properties
		x 113
		y 48
		noun 24
		approachX 136
		approachY 72
		view 310
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sOpenCoffin)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance windowLeft of Prop
	(properties
		x 154
		y 87
		view 311
		loop 1
		priority 6
		signal 16
		detailLevel 2
	)
)

(instance windowRight of Prop
	(properties
		x 224
		y 97
		view 311
		loop 1
		cel 1
		detailLevel 2
	)
)

(instance window1 of Prop
	(properties
		x 254
		y 95
		view 311
		loop 2
		cel 1
		detailLevel 2
	)
)

(instance window2 of Prop
	(properties
		x 268
		y 89
		view 311
		loop 3
		detailLevel 2
	)
)

(instance window3 of Prop
	(properties
		x 281
		y 79
		view 311
		loop 4
		cel 1
		detailLevel 2
	)
)

(instance keyForInset of View
	(properties
		x 183
		y 98
		noun 10
		view 312
		cel 1
		priority 15
		signal 17
	)

	(method (init)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetKey)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance yardEntrance of Feature
	(properties
		x 22
		y 45
		noun 11
	)
)

(instance bottomBuilding of Feature
	(properties
		x 164
		y 180
		noun 4
	)
)

(instance westBuilding of Feature
	(properties
		x 7
		y 176
		noun 5
	)
)

(instance tree of Feature
	(properties
		x 77
		y 130
		noun 6
	)
)

(instance church of Feature
	(properties
		x 160
		y 80
		noun 7
	)
)

(instance windMill of Feature
	(properties
		x 304
		y 171
		noun 8
	)
)

(instance graveyard of Feature
	(properties
		x 22
		y 45
		noun 3
	)
)

(instance stageCoach of Feature
	(properties
		x 100
		y 42
		noun 12
	)
)

(instance coffin of Feature
	(properties
		x 124
		y 58
		noun 13
	)
)

(instance roses of Feature
	(properties
		x 135
		y 91
		noun 14
	)
)

(instance bushes of Feature
	(properties
		x 283
		y 94
		noun 15
	)
)

(instance belfry of Feature
	(properties
		x 181
		y 33
		noun 19
		nsTop 24
		nsLeft 173
		nsBottom 43
		nsRight 190
	)
)

(instance leftWindow of Feature
	(properties
		x 155
		y 64
		noun 21
		nsTop 39
		nsLeft 147
		nsBottom 90
		nsRight 163
	)
)

(instance rightWindow of Feature
	(properties
		x 224
		y 76
		noun 22
		nsTop 48
		nsLeft 215
		nsBottom 105
		nsRight 234
	)
)

(instance insideChurch of Feature
	(properties
		x 160
		y 111
		noun 23
	)
)

(instance rightDoor of Feature
	(properties
		x 196
		y 111
		noun 17
		nsTop 81
		nsLeft 190
		nsBottom 126
		nsRight 202
		sightAngle 40
		approachX 169
		approachY 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (or (gEgo has: 6) (>= gCurPuzzle 12)) ; Church_Key
					(gMessager say: noun 4 3) ; "What?  You want to steal something ELSE from the church?"
				else
					(gCurRoom setScript: sBringUpInset)
				)
			)
			(4 ; Do
				(self approachX: 175 approachY: 125)
				(churchDoor doVerb: 4)
			)
			(else
				(churchDoor doVerb: theVerb &rest)
			)
		)
	)
)

(instance inDoorInset of Inset
	(properties
		view 312
		x 134
		y 32
		priority 15
		disposeNotOnMe 1
		noun 16
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 6)) ; Church_Key
			(keyForInset init: stopUpd:)
		)
	)

	(method (dispose)
		(super dispose:)
		(weatherVane setScript: sWeatherVaneSpin)
		(windMillBlades setCycle: Fwd)
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

(instance windmillSound of FPSound
	(properties
		flags 1
		number 2325
		loop -1
	)
)

(instance weatherVaneSound of FPSound
	(properties
		flags 1
		number 2233
	)
)

