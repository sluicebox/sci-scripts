;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6350)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use PChase)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm6350 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm6350 of KQRoom
	(properties
		picture 6350
	)

	(method (init)
		(gGame handsOff:)
		(super init:)
		(if (not (IsFlag 213))
			(Load rsVIEW 6351)
			(Load 140 6351) ; WAVE
			(Load rsVIEW 6350)
		else
			(Load rsVIEW 6352)
		)
		(Load rsSOUND 6350)
		(gKqMusic1 number: 6350 loop: -1 play:)
		(if (not (IsFlag 213))
			(gEgo
				x: 169
				y: 7
				view: 6351
				setCel: 0
				setLoop: 0 1
				setScaler: Scaler 67 11 37 16
				init:
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 18 92 99 91 54 120 9 105
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 277 73 317 65 317 83 278 83
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 54 0 0 320 0 320 60 168 70
						yourself:
					)
			)
			(gEgo view: 6352 x: 260 y: 101 loop: 0 cel: 0 setScale: 0 init:)
		)
		(cond
			((not (IsFlag 213))
				(gCurRoom setScript: asleep)
			)
			((== gPrevRoomNum 23) ; selectGameRoom
				(if (IsFlag 211)
					(monsterSound number: 6356 loop: 1 play:)
					(nightMonster
						view: 6352
						loop: 1
						cel: 0
						x: 214
						y: 100
						init:
						setCycle: End
					)
					(gMouseDownHandler addToFront: awake)
					(gKeyDownHandler addToFront: awake)
					(gEgo
						posn: 163 100
						setScaler: Scaler 66 58 84 78
						normalize: 2
						setMotion: MoveTo 163 112
					)
					(gCurRoom setScript: awake 0 7)
				else
					(gEgo
						normalize: 6
						setScaler: Scaler 66 58 84 78
						setHeading: 180
					)
					(mySouthExit init:)
					(myEastExit init:)
					(myWestExit init:)
					(if (gEgo has: 68) ; Dream_Catcher
						(gEgo put: 68) ; Dream_Catcher
					)
					(ClearFlag 211)
					(ClearFlag 338)
					(gEgo enableHotspot:)
				)
				(gGame handsOn:)
			)
			(else
				(SetFlag 338)
				(gEgo disableHotspot:)
				(gCurRoom setScript: awake)
			)
		)
	)
)

(instance asleep of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(= local4 (gEgo moveSpeed:))
					(Load rsVIEW 6351)
					(Load 140 6352) ; WAVE
					(Load 140 6351) ; WAVE
					(= cycles 4)
				)
				(1
					(gEgo
						setCycle: 0
						moveSpeed: 10
						setMotion: MoveTo 179 37 self
					)
				)
				(2
					(gEgo
						setCycle: 0
						moveSpeed: 10
						setScaler: Scaler 179 67 115 37
						setMotion: MoveTo 206 88 self
					)
				)
				(3
					(gEgo
						view: 8132
						loop: 0
						cel: 0
						posn: 214 86
						setScaler: Scaler 77 76 86 85
						moveSpeed: local4
						setCycle: Osc 20
					)
					(for ((= local1 100)) (>= local1 50) ((-= local1 1))
						(Palette 2 0 255 local1) ; PalIntensity
						(FrameOut)
					)
					(= seconds 2)
				)
				(4
					(monsterSound number: 6351 loop: -1 play:)
					(= cycles 1)
				)
				(5
					(nightMonster
						init:
						show:
						cycleSpeed: (* (gEgo cycleSpeed:) 2)
						setCycle: End self
					)
				)
				(6
					(nightMonster setCycle: 0 setMotion: MoveTo 190 5 self)
				)
				(7
					(gEgo
						view: 6351
						loop: 0
						cel: 0
						posn: 206 88
						setScaler: Scaler 179 67 115 37
						moveSpeed: local4
						setCycle: End self
					)
				)
				(8
					(gEgo loop: 1 cel: 0 posn: 202 88 setCycle: End self)
				)
				(9
					(gEgo loop: 2 cel: 0 posn: 198 104 setCycle: End self)
				)
				(10
					(nightMonster setCycle: 0 setScript: chase)
					(= cycles 2)
				)
				(11
					(gEgo loop: 4 cel: 0 posn: 189 123 setCycle: End self)
				)
				(12
					(gEgo loop: 5 cel: 0 posn: 220 127 setCycle: End self)
				)
				(13
					(gEgo hide:)
				)
				(14
					(screamSound number: 6352 loop: 1 play: self)
				)
				(15
					(for ((= local1 50)) (<= local1 100) ((+= local1 1))
						(Palette 2 0 255 local1) ; PalIntensity
						(FrameOut)
					)
					(= seconds 2)
				)
				(16
					(gCurRoom newRoom: 6450)
				)
			)
		else
			(switch (= state newState)
				(0
					(for ((= local1 50)) (<= local1 100) ((+= local1 1))
						(Palette 2 0 255 local1) ; PalIntensity
						(FrameOut)
					)
					(= seconds 2)
				)
				(1
					(ClearFlag 539)
					(gCurRoom newRoom: 6450)
				)
			)
		)
	)
)

(instance chase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 6352)
				(monsterSound number: 6351 loop: 1 play:)
				(nightMonster
					posn: 197 110
					cycleSpeed: (+ (gEgo cycleSpeed:) 2)
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(nightMonster
					posn: 194 107
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(nightMonster
					posn: 194 104
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(3
				((gCurRoom script:) cue:)
				(self dispose:)
			)
		)
	)
)

(instance awake of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== state 11)
					(event type:)
					(not (nightMonster onMe: event))
					(< -10 ((gUser curEvent:) x:) 329)
					(< -10 ((gUser curEvent:) y:) 146)
				)
				(= local2 ((gUser curEvent:) x:))
				(= local3 ((gUser curEvent:) y:))
				(Load rsVIEW 6353)
				(Load rsVIEW 801)
				(Load rsSOUND 6357)
				(Load rsSCRIPT 64930)
				(gGame pragmaFail:)
				(gCurRoom setScript: sRun)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: awake)
		(gKeyDownHandler delete: awake)
		(DisposeScript 64930)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if register
						(self changeState: register)
					else
						(tapestry init: hide:)
						(= cycles 4)
					)
				)
				(1
					(tapestrySound number: 938 loop: 1 play:)
					(gEgo cel: 0 setCycle: End self)
				)
				(2
					(tapestrySound stop:)
					(tapestry show:)
					(= cycles 2)
				)
				(3
					(gEgo
						posn: 163 100
						setScaler: Scaler 66 58 84 78
						normalize: 2
						setMotion: MoveTo 163 112 self
					)
				)
				(4
					(gEgo setHeading: 360 self)
				)
				(5
					(gEgo
						view: 8063
						loop: 0
						cel: 0
						posn: 162 113
						setCycle: End self
					)
				)
				(6
					(tapestry dispose:)
					(gEgo loop: 0 setCycle: Beg self)
				)
				(7
					(gEgo
						posn: 163 112
						setScaler: Scaler 66 58 84 78
						normalize: 3
					)
					(Load rsSOUND 6355)
					(Load rsSOUND 6356)
					(= cycles 4)
				)
				(8
					(gEgo setHeading: 180 self)
				)
				(9
					(Load rsVIEW 6353)
					(= local0 1)
					(monsterSound number: 6356 loop: 1 play:)
					(nightMonster
						view: 6352
						loop: 1
						cel: 0
						x: 214
						y: 100
						setPri: (+ (gEgo priority:) 1)
						init:
					)
					(= seconds 2)
				)
				(10
					(gKqMusic1 number: 6355 loop: 1 play:)
					(nightMonster setCycle: CT 11 1 self)
				)
				(11
					(nightMonster
						view: 6353
						loop: 1
						cel: 0
						posn: 191 70
						setCycle: End
					)
					(gMouseDownHandler addToFront: awake)
					(gKeyDownHandler addToFront: awake)
					(gGame handsOn:)
				)
				(12
					(if (gCurRoom script:)
						(self dispose:)
					else
						(gCurRoom setScript: sRun)
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo
						posn: 163 112
						setScaler: Scaler 66 58 84 78
						normalize: 2
					)
					(= local0 1)
					(if (not (gCast contains: nightMonster))
						(nightMonster
							view: 6352
							loop: 1
							cel: 12
							x: 214
							y: 100
							init:
						)
					)
					(if (gCast contains: tapestry)
						(tapestry dispose:)
					)
					(ClearFlag 539)
					(gMouseDownHandler addToFront: awake)
					(gKeyDownHandler addToFront: awake)
					(gGame handsOn:)
				)
			)
		)
	)
)

(instance sRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gMessager say: 1 8 1 0 self) ; "(TERRIFIED)NO! NO!"
			)
			(2
				(gEgo view: 8283 loop: 0 cel: 0 setCycle: Osc 1)
				(nightMonster
					view: 6352
					setLoop: 1 1
					posn: 214 100
					setCycle: End
					moveSpeed: (/ (gEgo cycleSpeed:) 2)
					setMotion: PChase gEgo 0 self
				)
			)
			(3
				(nightMonster setMotion: 0 setCycle: End)
				(gEgo view: 6354 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(DisposeScript 64930)
				(gCurRoom setScript: killedByMonster)
			)
		)
	)
)

(instance killedByMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMouseDownHandler delete: awake)
				(gKeyDownHandler delete: awake)
				(EgoDead 47 self)
			)
			(1
				(nightMonster
					view: 6353
					loop: 1
					cel: (nightMonster lastCel:)
					posn: 191 70
				)
				(gEgo
					posn: 163 112
					setScaler: Scaler 66 58 84 78
					normalize: 2
				)
				(gGame handsOn:)
				(gCurRoom setScript: awake 0 11)
			)
		)
	)
)

(instance monsterFight of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gMouseDownHandler delete: awake)
					(gKeyDownHandler delete: awake)
					(Load rsVIEW 6353)
					(Load rsSOUND 6358)
					(secondMonster cycleSpeed: 12 init: hide:)
					(= cycles 2)
				)
				(1
					(monsterSound number: 6358 loop: 1 play:)
					(gEgo
						view: 6353
						loop: 0
						cel: 0
						scaleSignal: 0
						scaleX: 128
						scaleY: 128
						setCycle: End self
					)
				)
				(2
					(nightMonster view: 6353 loop: 1 cycleSpeed: 12)
					(secondMonster
						show:
						setPri: (gEgo priority:)
						setCycle: End self
					)
				)
				(3
					(Load rsSOUND 6359)
					(= cycles 2)
				)
				(4
					(secondMonster view: 6353 loop: 3 cel: 0 setCycle: End self)
					(nightMonster hide:)
					(gKqMusic1 number: 6359 loop: 1 play:)
				)
				(5
					(secondMonster loop: 4 cel: 0 setCycle: End self)
				)
				(6
					(nightMonster dispose:)
					(secondMonster dispose:)
					(gKqMusic1 number: 6350 loop: -1 play:)
					(gEgo setCycle: Beg self)
				)
				(7
					(gEgo
						normalize: 6
						setScaler: Scaler 66 58 84 78
						setHeading: 180 self
					)
				)
				(8
					(mySouthExit init:)
					(myEastExit init:)
					(myWestExit init:)
					(gEgo put: 68) ; Dream_Catcher
					(ClearFlag 211)
					(ClearFlag 338)
					(gEgo enableHotspot:)
					(gEgo deleteHotVerb: 83) ; Tapestry_of_Dreams
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo put: 68) ; Dream_Catcher
					(ClearFlag 211)
					(ClearFlag 338)
					(gEgo setScaler: Scaler 66 58 84 78 normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFallEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 332 (gEgo y:) self)
			)
			(1
				(screamSound number: 6352 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 6450)
			)
		)
	)
)

(instance sFallWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath -20 (gEgo y:) self)
			)
			(1
				(screamSound number: 6352 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 6450)
			)
		)
	)
)

(instance sFallSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(screamSound number: 6352 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 6450)
			)
		)
	)
)

(instance nightMonster of Actor
	(properties
		noun 1
		x 226
		y 25
		scaleX 0
		scaleY 0
		priority 25
		fixPriority 1
		view 6350
		signal 2049
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 81) ; Do, Exit, Dream_Catcher
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: sRun)
			)
			(81 ; Dream_Catcher
				(gGame handsOff:)
				(Load rsVIEW 6352)
				(gCurRoom setScript: monsterFight)
				(return 1)
			)
		)
	)
)

(instance secondMonster of Actor
	(properties
		x 186
		y 30
		scaleX 0
		scaleY 0
		priority 24
		fixPriority 1
		view 6353
		loop 2
		signal 2049
	)
)

(instance tapestry of Prop
	(properties
		x 97
		y 63
		view 6352
		loop 2
	)
)

(instance dreamSound of Sound ; UNUSED
	(properties)
)

(instance monsterSound of Sound
	(properties)
)

(instance screamSound of Sound
	(properties)
)

(instance tapestrySound of Sound
	(properties)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 309
		nsRight 319
		nsBottom 140
		approachX 319
		approachY 110
		exitDir 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sFallEast)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsRight 10
		nsBottom 140
		approachY 114
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sFallWest)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsTop 130
		nsRight 319
		nsBottom 140
		approachX 176
		approachY 140
		x 176
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sFallSouth)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)
)

