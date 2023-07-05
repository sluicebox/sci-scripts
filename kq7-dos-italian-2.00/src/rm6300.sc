;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6300)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm6300 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm6300 of KQRoom
	(properties
		picture 6300
		horizon -50
	)

	(method (init)
		(SetFlag 21)
		(super init:)
		(northExitF init:)
		(eastExitF init:)
		(westExitF init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 76 0 83 30 83 43 83 89 85 112 85 133 90 130 97 151 100 228 100 268 104 288 79 312 66 334 66 334 62 311 62 282 70 252 53 168 55 180 30 188 26 178 27 170 45 164 57 178 58 156 83 103 75 97 63 82 65 70 76 33 76
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 180 60 246 58 275 71 279 84 262 95 238 95 224 95 157 95 160 81
					yourself:
				)
		)
		(gEgo
			setScaler: Scaler 87 32 51 31
			view: 800
			setCycle: Walk
			normalize: 2
		)
		(dragonFly
			init:
			view: 6301
			setLoop: 0 1
			setCel: 0
			setPri: 120
			x: (Random 20 300)
			y: (Random 20 110)
			setCycle: Fwd
		)
		(bigFlowers init:)
		(whiteFlowers init:)
		(sunFlowers init:)
		(redFlowers init:)
		(gKqSound1 stop:)
		(Load rsSOUND 865 6305 6301 6303 6302)
		(if (!= (gKqMusic1 number:) 6200)
			(gKqMusic1 stop: number: 6200 setLoop: -1 play:)
		)
		(cond
			((== gPrevRoomNum 6050)
				(gCurRoom setScript: sNorthEntry)
			)
			((== gPrevRoomNum 6250)
				(if (IsFlag 217)
					(gCurRoom setScript: sFallingEntry)
				else
					(gCurRoom setScript: sEastEntry)
				)
			)
			((== gPrevRoomNum 6200)
				(gCurRoom setScript: sWestEntry)
			)
			(else
				(gEgo init:)
				(gCurRoom setScript: sWestEntry)
			)
		)
	)
)

(instance sNorthEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 1)
				(gEgo
					moveSpeed: 14
					setScaler: Scaler 74 32 51 31
					init:
					posn: 190 33
					setMotion: PolyPath 181 62 self
				)
			)
			(1
				(= next sDance)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEastEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 2)
				(gEgo init: x: 311 y: 65 setMotion: PolyPath 280 83 self)
			)
			(1
				(= next sDance)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWestEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local5 4)
				(gEgo init: x: 10 y: 80 setMotion: PolyPath 50 91 self)
			)
			(1
				(= next sDance)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFallingEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 1)
				(gEgo
					posn: 271 78
					view: 4313
					loop: 3
					cel: 5
					init:
					setScale:
					scaleX: 153
					scaleY: 153
					setCycle: CT 13
				)
				(= ticks 120)
			)
			(1
				(gKqSound1 stop: number: 865 setLoop: 1 play:)
				(gEgo cel: 14 setCycle: End self)
			)
			(2
				(gEgo normalize: 2 setScale: scaleX: 100 scaleY: 100)
				(= cycles 1)
			)
			(3
				(gMessager say: 3 8 1 1 self) ; "What in heaven's name was that? I've never seen a creature so swift."
			)
			(4
				(ClearFlag 217)
				(= next sDance)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValNorthExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					moveSpeed: 14
					setScaler: Scaler 74 32 51 31
					setMotion: PolyPath 190 33 self
				)
			)
			(1
				(gEgo dispose:)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 6050)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValEastExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 332 72 self)
			)
			(1
				(gCurRoom newRoom: 6250)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValWestExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -9 89 self)
			)
			(1
				(gCurRoom newRoom: 6200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDance of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gKqSound1 stop:)
					(dragonFly
						show:
						view: 6301
						setCel: 0
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo (Random 120 150) (Random 60 90)
					)
					(cond
						((and (== local6 1) (== local5 4))
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 4
							)
						)
						((and (== local6 1) (== local5 2))
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 5
							)
						)
						(
							(or
								(and (== local6 1) (== local5 1))
								(and (== local6 1) (== local7 1))
							)
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 2
							)
						)
						((== local7 1)
							(gEgo
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 2
							)
						)
						((== local5 4)
							(gEgo
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 4
							)
						)
						((== local5 2)
							(gEgo
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 5
							)
						)
						((== local5 1)
							(gEgo
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 0
							)
						)
						(else
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 2
							)
						)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(dragonFly
						setLoop: 0
						setCel: 0
						setCycle: Fwd
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
					)
				)
				(1
					(= local6 1)
					(dragonFly hide:)
					(gEgo
						view: 6302
						x: (- (gEgo x:) 25)
						cycleSpeed: 14
						setScale:
						scaleX: 132
						scaleY: 132
						loop: 0
						cel: 0
						setCycle: End self
					)
					(gKqMusic1 fade: 90 2 10 0)
					(gKqSound1 stop: number: 6301 setLoop: 1 play:)
				)
				(2
					(dragonFly
						show:
						view: 6301
						setCel: 0
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo (Random 120 150) (Random 60 90)
					)
					(gKqMusic1 fade: 127 2 10 0)
					(= local6 0)
					(cond
						((== local5 4)
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 4
							)
						)
						((== local5 2)
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 5
							)
						)
						((or (== local5 1) (== local7 1))
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 2
							)
						)
						((== local7 1)
							(gEgo
								x: (+ (gEgo x:) 25)
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 1
							)
						)
						(else
							(gEgo
								setScale:
								scaleX: 100
								scaleY: 100
								normalize: 2
							)
						)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sValaniceSmellsAir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(gEgo
					view: 6303
					setLoop: 0
					setCel: 0
					setScale:
					scaleX: 132
					scaleY: 132
					setCycle: End self
				)
				(gKqSound1 stop: number: 6302 setLoop: 1 play:)
			)
			(1
				(gEgo
					x: (+ local1 9)
					setScale:
					scaleX: 100
					scaleY: 100
					normalize: 5
				)
				(gMessager say: 1 8 1 1 self) ; "Mmmmmmm!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValaniceLooksAtDragon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 (gEgo x:))
				(= local3 (dragonFly x:))
				(if (> local1 local3)
					(gEgo setScale: scaleX: 100 scaleY: 100 normalize: 1)
				else
					(gEgo setScale: scaleX: 100 scaleY: 100 normalize: 0)
				)
				(gKqSound1 stop: number: 6301 setLoop: 1 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 2 8 1 1 self) ; "(CHARMED)Oh my! Aren't you the sweetest little things?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sValaniceHoldsOutHand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqMusic1 fade: 90 2 10 0)
				(dragonFly setCycle: Fwd setMotion: PolyPath 46 53)
				(gEgo setCycle: Walk setMotion: PolyPath 137 87 self)
			)
			(1
				(= ticks 90)
			)
			(2
				(gEgo
					view: 6304
					setLoop: 0
					setCel: 0
					cycleSpeed: 9
					setScale:
					scaleX: 140
					scaleY: 140
					setCycle: End self
				)
				(oneDragonFly
					init:
					setLoop: 1
					setCel: 0
					setPri: 200
					setCycle: End
				)
				(gKqSound1 stop: number: 6303 setLoop: 1 play:)
			)
			(3
				(oneDragonFly dispose:)
				(dragonFly setCycle: Fwd)
				(gEgo
					view: 6304
					setLoop: 0
					setCel: 7
					cycleSpeed: 9
					setScale:
					scaleX: 140
					scaleY: 140
					setCycle: Beg self
				)
			)
			(4
				(gEgo setScale: scaleX: 100 scaleY: 100 normalize: 5)
				(gKqMusic1 fade: 127 2 10 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAmbrosiaOnDragon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gKqMusic1 fade: 127 2 10 0)
					(oneDragonFly dispose:)
					(dragonFly setCycle: Fwd)
					(gEgo setScale: scaleX: 100 scaleY: 100 normalize: 5)
					(= cycles 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(dragonFly setCycle: Fwd setMotion: MoveTo 94 90)
					(gEgo setCycle: Walk setMotion: PolyPath 131 100 self)
				)
				(1
					(= ticks 90)
				)
				(2
					(gEgo
						view: 6305
						setCel: 0
						setLoop: 0
						setScale: 0
						scaleX: 128
						scaleY: 128
						setCycle: CT 6 1
					)
					(oneDragonFly
						init:
						view: 6305
						x: 99
						y: 92
						setLoop: 1
						setCel: 0
						setCycle: End self
					)
				)
				(3
					(= ticks 20)
				)
				(4
					(gKqMusic1 fade: 10 2 10 0)
					(gKqSound1 stop: number: 6305 setLoop: -1 play:)
					(gEgo
						view: 6305
						setCel: 7
						setScale:
						scaleX: 132
						scaleY: 132
						setCycle: CT 26 1 self
					)
				)
				(5
					(= ticks 3460)
				)
				(6
					(gKqMusic1 fade: 127 2 10 0)
					(oneDragonFly
						init:
						view: 6305
						posn: 112 72
						loop: 2
						cel: 0
						setCycle: End self
					)
					(gKqSound1 number: 6303 setLoop: 1 play:)
					(gEgo
						view: 6305
						cel: 26
						setScale:
						scaleX: 132
						scaleY: 132
						setCycle: CT 30 1
					)
				)
				(7
					(oneDragonFly dispose:)
					(dragonFly setCycle: Fwd)
					(gEgo setScale: scaleX: 100 scaleY: 100 normalize: 5)
					(= cycles 1)
				)
				(8
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance dragonFly of Actor
	(properties
		noun 2
		view 6301
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 76) ; Do, Exit, Ambrosia
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== local0 0)
					(gCurRoom setScript: sValaniceLooksAtDragon)
					(= local0 1)
				else
					(gCurRoom setScript: sValaniceHoldsOutHand)
				)
			)
			(76 ; Ambrosia
				(gCurRoom setScript: sAmbrosiaOnDragon)
				(return 1)
			)
		)
	)
)

(instance oneDragonFly of Actor
	(properties
		x 101
		y 61
		view 6304
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 120)
	)
)

(instance bigFlowers of Feature
	(properties
		noun 1
		approachX 255
		approachY 61
		x 246
		y 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 39 231 22 245 5 252 0 273 2 284 17 281 33 258 25
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sValaniceSmellsAir)
				(self setHotspot: 0)
			)
		)
	)
)

(instance whiteFlowers of Feature
	(properties
		noun 1
		approachX 91
		approachY 74
		x 94
		y 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 91 45 90 47 87 47 86 50 82 51 78 47 82 43 84 43 82 40 82 36 86 34 88 34 91 31 96 35 100 38 94 38 92 40 95 41 96 45 94 46
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sValaniceSmellsAir)
				(self setHotspot: 0)
			)
		)
	)
)

(instance sunFlowers of Feature
	(properties
		noun 1
		approachX 135
		approachY 77
		x 135
		y 77
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 57 133 63 123 65 119 62 126 57 135 53 141 51 152 57 144 60 140 57
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sValaniceSmellsAir)
				(self setHotspot: 0)
			)
		)
	)
)

(instance redFlowers of Feature
	(properties
		noun 1
		approachX 135
		approachY 77
		x 135
		y 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 37 118 17 137 13 161 15 153 40
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sValaniceSmellsAir)
				(self setHotspot: 0)
			)
		)
	)
)

(instance northExitF of ExitFeature
	(properties
		nsRight 320
		nsBottom 20
		approachX 163
		approachY 55
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 0 10 8 _approachVerbs: -1) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sValNorthExit)
	)
)

(instance westExitF of ExitFeature
	(properties
		nsRight 12
		nsBottom 99
		sightAngle 362
		approachX -9
		approachY 89
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 0 10 8 _approachVerbs: -1) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sValWestExit)
	)
)

(instance eastExitF of ExitFeature
	(properties
		nsLeft 297
		nsRight 320
		nsBottom 80
		approachX 332
		approachY 72
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 0 10 8 _approachVerbs: -1) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sValEastExit)
	)
)

