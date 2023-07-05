;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2350)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use rm2400)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2350 0
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
)

(instance rm2350 of KQRoom
	(properties
		picture 2350
	)

	(method (init)
		(super init:)
		(= edgeS 250)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 47 95 68 107 87 110 93 120 100 121 129 136 152 174 260 195 273 195 232 123 203 118 199 118 193 117 184 115 170 112 160 108 148 107 144 103 98 95
					yourself:
				)
		)
		(Load rsVIEW 8443 2355 2350 2352 9010)
		(Load rsSOUND 850 801 838)
		(Load 140 850 801 838 23020) ; WAVE
		(Load 140 2301 2302 2458 2459 23010) ; WAVE
		(= gValOrRoz -3) ; Roz
		(door init:)
		(leftEye init:)
		(rightEye init:)
		(nose init:)
		(southExitF init:)
		(if (not (gEgo has: 60)) ; Fragrant_Flower
			(flower init:)
			(flow init:)
		)
		(if (IsFlag 385)
			(if (not (gEgo has: 60)) ; Fragrant_Flower
				(fallenRock init:)
			)
			(rock view: 2350 loop: 3 cel: 9 init:)
		else
			(if (not (gEgo has: 60)) ; Fragrant_Flower
				(theRock init:)
			)
			(rock init:)
		)
		(cond
			((== gChapter 4)
				(lGauge init:)
				(rGauge init:)
				(gEgo
					posn: 264 185
					setScaler: Scaler 100 90 139 78
					normalize: 3
					init:
				)
				(gCurRoom setScript: sChapFourCartoon)
			)
			((== gChapter 6)
				(gKqMusic1 number: 2350 setLoop: -1 play:)
				(cond
					((== gPrevRoomNum 2206)
						(gEgo
							posn: 30 85
							setScaler: Scaler 100 90 139 78
							normalize: 2
							init:
						)
						(gCurRoom setScript: sNorthEntryScript)
					)
					((== gPrevRoomNum 2400)
						(lGauge init:)
						(rGauge init:)
						(gEgo
							posn: 264 185
							setScaler: Scaler 100 90 139 78
							normalize: 3
							init:
						)
						(gCurRoom setScript: sSouthEntryScript)
					)
					(else
						(lGauge init:)
						(rGauge init:)
						(= local0 0)
						(gEgo
							posn: 142 125
							setScaler: Scaler 100 90 139 78
							normalize: 2
							init:
						)
						(gGame handsOn:)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (IsFlag 255)
			(ClearFlag 255)
			(if (not script)
				(lava init: setScript: lavaDeath)
			)
		)
	)

	(method (dispose)
		(scream stop:)
		(super dispose: &rest)
	)
)

(instance lavaDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gEgo setMotion: 0 setScript: faceLava)
				(= ticks 45)
			)
			(2
				(lava cel: 0 show: setCycle: End self)
				(gKqSound1 number: 2305 setLoop: 1 play: setVol: 127)
			)
			(3
				(PalVary 0 2351 3 100 104 246) ; PalVaryStart
				(= ticks 200)
			)
			(4
				(PalVary 3) ; PalVaryKill
				(EgoDead 40 self)
			)
			(5
				(gEgo setScript: 0 normalize:)
				(= local0 0)
				(= local1 0)
				(= local2 0)
				(= local3 1)
				(= local4 0)
				(Load rsSOUND 850 801 838)
				(lava cel: 0 hide:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance faceLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setCycle: 0 normalize:)
				(proc11_3 gEgo 55 110 self)
			)
			(1
				(proc2400_1)
				(gEgo setMotion: 0 cel: 0 setCycle: End self)
			)
			(2
				(scream setLoop: 1 play: setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance sChapFourCartoon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gKqSound1 stop:)
					(gGame handsOff:)
					(gCurRoom newRoom: 2202)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(trollKing init:)
					(gKqMusic1 stop: number: 2300 setLoop: -1 play:)
					(gEgo setMotion: PolyPath 142 128 self)
				)
				(1
					(trollKing
						view: 2353
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				)
				(2
					((ScriptID 7001 0) ; kingTalker
						mouth_x: -999
						mouth_y: -999
						clientCel: -2
						client: trollKing
					)
					(gMessager say: 0 0 2 1 self) ; "(IMPATIENT)We must hurry, Rosella!"
				)
				(3
					(trollKing setLoop: 1 setCycle: CT 19 1 self)
				)
				(4
					(gKqSound1 stop: number: 850 setLoop: 1 play:)
					(lGauge setCycle: End self)
				)
				(5
					(gKqSound1 stop: number: 850 setLoop: 1 play:)
					(lGauge cel: 4 setCycle: Beg self)
				)
				(6
					(trollKing cel: 20 setCycle: CT 26 1 self)
				)
				(7
					(door setCycle: End)
					(trollKing cel: 27 setCycle: CT 32 1 self)
					(gKqSound1 stop: number: 850 setLoop: 1 play:)
					(rGauge setCycle: End)
				)
				(8
					(trollKing cel: 32 setCycle: CT 25 -1 self)
					(gKqSound1 stop: number: 850 setLoop: 1 play:)
					(rGauge cel: 4 setCycle: Beg)
				)
				(9
					(door cel: 1 setCycle: Beg self)
				)
				(10
					(trollKing cel: 47 setCycle: CT 40 -1 self)
				)
				(11
					(trollKing cel: 40 setCycle: CT 47 1 self)
					(gKqSound1 stop: number: 850 setLoop: 1 play:)
				)
				(12
					(gKqSound1 stop: number: 850 setLoop: 1 play: self)
				)
				(13
					(gKqSound1 stop: number: 801 setLoop: 1 play: self)
					(lGauge dispose:)
					(rGauge dispose:)
				)
				(14
					(gKqSound1 stop: number: 838 setLoop: 1 play:)
					(door setLoop: 1 1 cel: 0 setCycle: End self)
				)
				(15
					(trollKing
						view: 9010
						posn: 70 95
						setScale:
						scaleX: 100
						scaleY: 100
						setLoop: 7
						setCel: 0
						setCycle: Fwd
						setMotion: MoveTo 30 80
					)
					(= cycles 1)
				)
				(16
					(trollKing posn: 60 90 setMotion: MoveTo 10 85)
					(gEgo setMotion: MoveTo 63 94 self)
				)
				(17
					(gEgo setMotion: MoveTo 30 85 self)
				)
				(18
					(gKqSound1 stop: number: 838 setLoop: 1 play:)
					(door setLoop: 1 1 cel: 9 setCycle: Beg self)
				)
				(19
					(gKqSound1 stop: number: 801 setLoop: 1 play: self)
				)
				(20
					(gGame handsOff:)
					(gCurRoom newRoom: 2202)
					(self dispose:)
				)
			)
		)
	)
)

(instance sSouthEntryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(gEgo
					view: 836
					setLoop: 7 1
					cel: 0
					setMotion: MoveTo 142 125 self
				)
			)
			(1
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNorthEntryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gKqSound1 stop: number: 801 setLoop: 1 play: self)
			)
			(2
				(gKqSound1 stop: number: 838 setLoop: 1 play:)
				(door setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setMotion: MoveTo 63 90 self)
			)
			(4
				(gEgo setMotion: MoveTo 83 104 self)
			)
			(5
				(gKqSound1 stop: number: 838 setLoop: 1 play:)
				(door setLoop: 1 1 cel: 9 setCycle: Beg self)
			)
			(6
				(gKqSound1 stop: number: 801 setLoop: 1 play: self)
			)
			(7
				(lGauge init:)
				(rGauge init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSouthExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 264 185 self)
			)
			(1
				(gCurRoom newRoom: 2400)
				(gGame handsOff:)
				(self dispose:)
			)
		)
	)
)

(instance sLeftEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2355 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
				(lGauge setCycle: End self)
			)
			(2
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
				(lGauge cel: 4 setCycle: Beg self)
			)
			(3
				(cond
					((== local0 1)
						(= local1 1)
						(= cycles 1)
					)
					((== local0 3)
						(gCurRoom setScript: sRoseBlown)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRightEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2355 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
				(rGauge setCycle: End self)
			)
			(2
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
				(rGauge cel: 4 setCycle: Beg self)
			)
			(3
				(gEgo normalize: 3)
				(cond
					((and (== local0 2) (== local1 1))
						(= local2 2)
						(= cycles 1)
					)
					((== local0 3)
						(gCurRoom setScript: sRoseBlown)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 8443
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: CT 4
				)
				(= cycles 1)
			)
			(1
				(gEgo view: 8443 setCel: 4 setLoop: 0 setCycle: End self)
				(noseLever init: moveSpeed: 3 setMotion: MoveTo 63 54)
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
			)
			(2
				(noseLever moveSpeed: 6 setMotion: MoveTo 63 73 self)
				(gKqSound1 stop: number: 850 setLoop: 1 play:)
			)
			(3
				(noseLever dispose:)
				(gEgo normalize: 3)
				(if (== local0 3)
					(if (and (== local2 2) (== local1 1))
						(gCurRoom setScript: sToMechRoom)
					else
						(gCurRoom setScript: sRoseBlown)
					)
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sToMechRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lGauge dispose:)
				(rGauge dispose:)
				(gKqSound1 stop: number: 801 setLoop: 1 play: self)
			)
			(1
				(gKqSound1 stop: number: 838 setLoop: 1 play:)
				(door setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 63 94 self)
			)
			(3
				(gEgo setMotion: MoveTo 30 85 self)
			)
			(4
				(gKqSound1 stop: number: 838 setLoop: 1 play:)
				(door setLoop: 1 1 cel: 9 setCycle: Beg self)
			)
			(5
				(gKqSound1 stop: number: 801 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 2206)
				(gGame handsOff:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseBlown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rGauge dispose:)
				(lGauge dispose:)
				(steam init: setCycle: End)
				(gKqSound1 stop: number: 2301 setLoop: 1 play:)
				(scream setLoop: 1 play: setVol: 127)
				(gEgo view: 2354 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(steam dispose:)
				(gEgo dispose:)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(SetFlag 282)
				(gGame handsOff:)
				(gCurRoom newRoom: 2400)
				(self dispose:)
			)
		)
	)
)

(instance sRoseThinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (and (gEgo loop: 8) (gEgo cel: 6)))
					(gEgo normalize: 6)
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 2 46 0 1 self) ; "(THINKS TO HERSELF)That'll never work."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseDigs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 385)
				(gEgo setMotion: MoveTo 230 126 self)
			)
			(1
				(gEgo
					view: 2352
					loop: 1
					cel: 0
					x: 230
					y: 126
					setCycle: CT 8 1 self
				)
			)
			(2
				(gKqSound1 stop: number: 23010 setLoop: -1 play:)
				(gEgo cel: 9 setCycle: End self)
			)
			(3
				(gKqSound1 stop: number: 2302 setLoop: 1 play:)
				(theRock dispose:)
				(fallenRock init:)
				(SetFlag 256)
				(rock
					view: 2350
					x: 191
					y: 102
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseWithHands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2352 loop: 0 cel: 0 setCycle: CT 19)
				(= ticks 90)
			)
			(1
				(gKqSound1 stop: number: 2458 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo x: (theRock approachX:) normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseClimbsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 203 120 self)
			)
			(1
				(gEgo
					posn: 193 120
					view: 2352
					loop: 3
					cel: 1
					setCycle: End self
				)
			)
			(2
				(gEgo
					posn: 197 87
					loop: 5
					cel: 0
					cycleSpeed: 10
					setCycle: CT 9 1 self
				)
			)
			(3
				(flower dispose:)
				(flow dispose:)
				(gEgo get: 60) ; Fragrant_Flower
				(SetFlag 257)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					setScale:
					scaleX: 135
					scaleY: 135
					posn: 150 100
					setLoop: 6 1
					cel: 0
					setSpeed: 18
					setCycle: CT 5 1 self
				)
			)
			(5
				(gKqSound1 stop: number: 23020 setLoop: 1 play:)
				(gEgo cel: 5 setCycle: End self)
			)
			(6
				(gEgo
					setScaler: Scaler 100 90 139 78
					posn: 163 135
					normalize: 5
				)
				(fallenRock dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRoseReaches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 2354 setCel: 0 setLoop: 2 1 setCycle: End self)
			)
			(1
				(gKqSound1 stop: number: 2459 setLoop: 1 play: self)
			)
			(2
				(if (== (= local4 (Random 0 1)) 1)
					(gKqSound1 number: 2458 setLoop: 1 play:)
				)
				(= cycles 1)
			)
			(3
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance trollKing of Actor
	(properties
		x 75
		y 100
		view 2353
	)

	(method (init)
		(|= signal $0800)
		(super init: &rest)
	)
)

(instance noseLever of Actor
	(properties
		x 63
		y 76
		view 2350
		loop 7
	)

	(method (init)
		(|= signal $0800)
		(super init: &rest)
		(self setPri: 99)
	)
)

(instance door of Prop
	(properties
		x 28
		y 94
		view 2350
	)

	(method (init)
		(super init: &rest)
		(self setPri: 90)
	)
)

(instance lGauge of Prop
	(properties
		x 43
		y 31
		view 2350
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance rGauge of Prop
	(properties
		x 76
		y 30
		view 2350
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance steam of Prop
	(properties
		x 70
		y 76
		view 2354
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance rock of Prop
	(properties
		x 191
		y 102
		view 2350
		loop 2
	)
)

(instance flower of Prop
	(properties
		x 214
		y 53
		view 2350
		loop 4
	)
)

(instance lava of Prop
	(properties
		x 19
		y 49
		priority 104
		fixPriority 1
		view 2211
		loop 1
	)
)

(instance leftEye of Feature
	(properties
		approachX 43
		approachY 95
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 32 42 32 39 41 49 48 62 40 55 31
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(++ local0)
				(gCurRoom setScript: sLeftEye)
			)
		)
	)
)

(instance rightEye of Feature
	(properties
		approachX 85
		approachY 95
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 32 76 37 82 46 94 43 96 34
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(++ local0)
				(gCurRoom setScript: sRightEye)
			)
		)
	)
)

(instance nose of Feature
	(properties
		approachX 70
		approachY 100
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 66 38 66 65 75 65 75 38 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(++ local0)
				(gCurRoom setScript: sNose)
			)
		)
	)
)

(instance theRock of Feature
	(properties
		noun 2
		sightAngle 369
		approachX 176
		approachY 124
		approachDist 2
		x 181
		y 119
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 75 46 ; Do, Exit, Shovel, Hammer_and_Chisel
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 88 202 82 230 78 248 85 248 95 238 101 218 97 201 97
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sRoseWithHands)
			)
			(75 ; Shovel
				(gCurRoom setScript: sRoseDigs)
			)
			(46 ; Hammer_and_Chisel
				(gCurRoom setScript: sRoseThinks)
			)
		)
	)
)

(instance fallenRock of Feature
	(properties
		approachX 207
		approachY 122
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 88 188 103 211 109 220 103 207 90 187 81 180 83
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sRoseClimbsUp)
			)
		)
	)
)

(instance flow of Feature
	(properties
		sightAngle 369
		approachX 190
		approachY 110
		approachDist 2
		x 200
		y 90
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 38 212 48 220 54 225 49
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sRoseReaches)
			)
		)
	)
)

(instance southExitF of ExitFeature
	(properties
		nsLeft 125
		nsTop 130
		nsRight 260
		nsBottom 156
		sightAngle 369
		approachX 190
		approachY 150
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 0 10 8 _approachVerbs: -1) ; Do, Exit, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: sSouthExit)
	)
)

(instance scream of Sound
	(properties
		number 4073
	)
)

