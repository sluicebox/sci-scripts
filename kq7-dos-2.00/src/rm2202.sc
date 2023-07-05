;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2202)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n777)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2202 0
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	)
	(if (and (== argc 3) param3)
		(param3 cue:)
	)
)

(instance rm2202 of KQRoom
	(properties
		picture 2200
	)

	(method (init)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 306 130 319 114 318 99 282 109 263 108 269 118 216 130 171 119 162 102 132 99 116 103 94 97 63 93 51 96 94 100
					yourself:
				)
		)
		(Load rsMESSAGE 2200)
		(Load 140 922 4075 2202 871 3154 2261) ; WAVE
		(Load rsVIEW 2239 2209)
		(Load rsSOUND 2201)
		(myEastExit init:)
		(gKqMusic1 number: 2201 setLoop: -1 play: setVol: 0 fade: 127 25 10 0)
		(fakeKing view: 2239 loop: 0 cel: 0 x: 168 y: 105 init:)
		(gEgo
			posn: 360 118
			normalize: 1
			setScaler: Scaler 90 90 145 101
			init:
		)
		(king init: setCycle: Walk setScale: scaleX: 142 scaleY: 142)
		(self setScript: sStartFight)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(gKqSound1 fade:)
		(Palette 2 0 71 100) ; PalIntensity
		(Palette 2 104 235 100) ; PalIntensity
		(super dispose: &rest)
	)
)

(instance sStartFight of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 35) ; chapEndRm
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(king setMotion: PolyPath 279 125 self)
				)
				(1
					(king
						view: 2240
						loop: 1
						cel: 0
						setScale:
						scaleX: 128
						scaleY: 128
						setCycle: End
					)
					(gEgo setMotion: PolyPath 307 135)
					(fakeKing loop: 1 cel: 0 setCycle: End self)
					(gKqMusic1 stop:)
					(gKqSound1 number: 922 setLoop: 1 setVol: 127 play:)
				)
				(2
					(gKqMusic1 setLoop: -1 play:)
					(gauge init: setCycle: End)
					(king loop: 0 cel: 0 setCycle: End self)
				)
				(3
					((ScriptID 7001 0) client: king) ; kingTalker
					(gMessager say: 0 0 3 1 self 2200) ; "(FURIOUS)Impostor! You have destroyed us all!"
				)
				(4
					(king loop: 0 cel: 3 setCycle: Beg self)
					(gKqSound1 stop: number: 4075 setLoop: 1 setVol: 170 play:)
					(lava play:)
					(pebbles init: setCycle: End self)
				)
				(5
					(gEgo
						view: 2239
						loop: 6
						cel: 0
						x: 291
						y: 138
						setCycle: End
					)
					(king
						view: 2239
						loop: 4
						cel: 0
						x: 219
						y: 130
						setSpeed: 4
						setCycle: End self
					)
				)
				(6
					(king hide: dispose:)
					(gKqSound1 stop: number: 871 setLoop: -1 setVol: 170 play:)
					(fakeKing
						view: 2239
						loop: 5
						cel: 0
						x: 162
						y: 105
						cycleSpeed: 4
						setCycle: End self
					)
				)
				(7
					(if (> (gGame speedRating:) 165)
						(proc777_0 gThePlane 1 5)
					else
						(proc777_0 gThePlane 1 3)
					)
					(gKqSound1 number: 2202 setLoop: -1 play: setVol: 127)
					(= cycles 50)
				)
				(8
					(if (> (gGame speedRating:) 165)
						(localproc_0 1 2 self)
					else
						(localproc_0 1 4 self)
					)
				)
				(9
					(scream play:)
					(= ticks 85)
				)
				(10
					(gCurRoom drawPic: 999)
					(gEgo hide:)
					(fakeKing hide:)
					(gauge hide:)
					(= cycles 2)
				)
				(11
					(scream stop:)
					(gKqMusic1 stop:)
					(gKqSound1 stop:)
					(lava stop:)
					(= cycles 2)
				)
				(12
					(gCurRoom newRoom: 35) ; chapEndRm
				)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 330
		y 120
		view 2209
		loop 5
		signal 20513
	)
)

(instance fakeKing of Prop
	(properties
		x 146
		y 128
		view 2202
		cel 35
	)
)

(instance gauge of Prop
	(properties
		x 148
		y 72
		priority 97
		fixPriority 1
		view 2239
		loop 2
		cycleSpeed 22
	)
)

(instance pebbles of Prop
	(properties
		x 80
		y 47
		view 2239
		loop 3
	)
)

(instance scream of Sound
	(properties
		number 3154
		loop 0
	)
)

(instance lava of Sound
	(properties
		number 2261
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 136
		sightAngle 360
		approachX 318
		approachY 103
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 2350)
	)
)

