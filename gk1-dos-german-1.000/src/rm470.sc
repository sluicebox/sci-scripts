;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use n013)
(use GKEgo)
(use Inset)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Cursor)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm470 0
	waves 1
	patternOnGround 2
	leftPoliceTape 3
	rightPoliceTape 4
	topPoliceTape 5
	limo 6
	moveTheTape 7
	mosley 8
	writingCop 9
	deadBody 10
	polCar2 11
	ambulance 12
	ambulanceLights 13
	polCar2Lights 14
	coroner 15
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

(procedure (localproc_0 param1)
	(if (and (!= param1 mosleyHead) (gCast contains: mosleyHead))
		(mosleyHead dispose:)
	)
	(if (and (!= param1 limoWindow) (gCast contains: limoWindow))
		(limoWindow dispose:)
	)
	(if (and (!= param1 limo) (gCast contains: limo))
		(limo dispose:)
	)
	(if (and (!= param1 polCar2Lights) (gCast contains: polCar2Lights))
		(polCar2Lights dispose:)
	)
	(if (and (!= param1 ambulanceLights) (gCast contains: ambulanceLights))
		(ambulanceLights dispose:)
	)
	(if (and (!= param1 writingCop) (gCast contains: writingCop))
		(writingCop dispose:)
	)
	(if (and (!= param1 ambulance) (gCast contains: ambulance))
		(ambulance dispose:)
	)
	(if (and (!= param1 polCar2) (gCast contains: polCar2))
		(polCar2 dispose:)
	)
	(if (and (!= param1 mosley) (gCast contains: mosley))
		(mosley dispose:)
	)
	(if (and (!= param1 coroner) (gCast contains: coroner))
		(coroner dispose:)
	)
)

(instance rm470 of Room
	(properties
		noun 1
		picture 470
		style 14
		exitStyle 13
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(if (IsFlag 11)
					((Polygon new:)
						type: PContainedAccess
						init: 56 140 108 140 141 145 208 145 216 136 311 122 311 105 300 84 255 81 253 75 231 76 223 75 181 73 136 70 53 70 89 87 98 95 96 106 43 137 1 142 0 145 41 145
						yourself:
					)
				else
					((Polygon new:)
						type: PContainedAccess
						init: 56 140 108 140 141 145 208 145 216 136 311 122 311 105 300 84 255 81 253 75 231 76 223 75 202 87 160 95 134 86 89 87 98 95 99 107 95 116 44 138 42 144
						yourself:
					)
				)
		)
		(super init:)
		(Load rsMESSAGE 470)
		(Load rsVIEW 1)
		(Load rsVIEW 4772)
		(if (not (IsFlag 222))
			(= global212 (gGame currentSpeed:))
			(SetFlag 200)
		)
		(gGame handsOff:)
		(gEgo
			view: 4792
			setLoop: 3
			signal: (| $1000 (gEgo signal:))
			scaleSignal: (| $0004 (gEgo scaleSignal:))
			init:
			ignoreActors: 1
			setCycle: StopWalk -1
			posn: 169 180
			hide:
		)
		(if (not (IsFlag 222))
			(gEgo setSpeed: 6)
		)
		(lake init:)
		(road init:)
		(clayBank init:)
		(reflectorClose init:)
		(reflectorMid init:)
		(reflectorFar init:)
		(rightTree init:)
		(leftTree init:)
		(leftGrass init:)
		(middleGrass init:)
		(rightGrass init:)
		(cageGrass init:)
		(sand init:)
		(myExitFeature init:)
		(bloodSand init:)
		(waves init:)
		(if (not (IsFlag 11))
			(rightPoliceTape init:)
			(leftPoliceTape init:)
			(topPoliceTape init:)
			(polCar2 init:)
			(ambulance init:)
			(ambulanceLights init:)
			(polCar2Lights init:)
			((ScriptID 472 3) init:) ; kneelingCop
			(writingCop init:)
			(deadBody init: ignoreActors: 1)
			(mosley init: ignoreActors: 1)
			(coroner init:)
		)
		(patternOnGround init:)
		(gWalkHandler add: lake)
		(gWalkHandler add: road)
		(gWalkHandler add: myExitFeature)
		(if (and (<= gDay 3) (IsFlag 11) (not (== gPrevRoomNum 471)))
			(leftPoliceTape init:)
			(rightPoliceTape init:)
			(topPoliceTape init:)
		)
		(gGkMusic1
			number: 470
			setLoop: -1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(cond
			((== gPrevRoomNum 471)
				(gCurRoom setScript: afterTheCloseUp)
			)
			((not (IsFlag 11))
				(gCurRoom setScript: (ScriptID 472 0)) ; theOpeningCartoon
			)
			(else
				(gEgo
					show:
					posn: 169 180
					setScaler: Scaler 100 57 109 64
					setScript: comeHereAgain
				)
			)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 471)
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: lake)
		(gWalkHandler delete: road)
		(gWalkHandler delete: myExitFeature)
		(gEgo setScale: 0 scaleSignal: (& $fffb (gEgo scaleSignal:)))
		(DisposeScript 64939)
		(DisposeScript 64935)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((myExitFeature onMe: gMouseX (- gMouseY 10))
				(if (== gTheCursor ((gTheIconBar at: 0) cursorView:))
					(gGame setCursor: myExitCursor 1)
					(= local7 1)
				)
			)
			(local7
				(gGame setCursor: ((gTheIconBar at: 0) cursorView:) 1)
				(= local7 0)
			)
		)
	)
)

(instance comeHereAgain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 175 145 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance afterTheCloseUp of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gGame handsOff:)
				(gEgo
					show:
					view: 4792
					setCel: 1
					setLoop: 8
					setCycle: StopWalk -1
					posn: 88 114
				)
				(mosley
					view: 4793
					setCel: 1
					setLoop: 8
					init:
					setCycle: StopWalk -1
					posn: 80 127
				)
				(limo setCel: 4 init:)
				(limoWindow setCel: 3 init:)
				(coroner init:)
				(polCar2 init:)
				(polCar2Lights init:)
				(ambulance init:)
				(ambulanceLights init:)
				(rightPoliceTape init:)
				(leftPoliceTape init:)
				(topPoliceTape init:)
				(writingCop
					view: 4711
					setCel: 0
					setLoop: 0
					init:
					posn: 215 120
					xStep: 4
				)
				(deadBody init:)
				(= cycles 1)
			)
			(1
				(gMessager sayRange: 11 0 1 12 15 self) ; "(TALKING TO A BEAUTIFUL WOMAN)Ahem. Good day, Miss Gedde."
			)
			(2
				(Face gEgo 0 0 0)
				(gGkSound1 number: 474 setLoop: 1 play:)
				(limoWindow cycleSpeed: 11 setCycle: Beg self)
			)
			(3
				(limoWindow dispose:)
				(gGkSound1 number: 472 setLoop: 1 play:)
				(limo setCel: 0 setLoop: 2 setPri: 100 setCycle: End self)
			)
			(4
				(limo dispose:)
				(gEgo view: 473 setCel: 6 setLoop: 3 setCycle: Beg self)
				(mosley view: 472 setCel: 3 setLoop: 5)
			)
			(5
				(gMessager sayRange: 11 0 1 16 21 self) ; "I'm in love."
			)
			(6
				(writingCop
					view: 2371
					setCel: 0
					setLoop: 1
					setLooper: Grooper
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 125 131 self
				)
			)
			(7
				(mosley setCel: 0 setLoop: 5)
				(= cycles 5)
			)
			(8
				(gMessager sayRange: 11 0 1 22 24 self) ; "We've about wrapped it up, Sir. It's another clean sweep."
			)
			(9
				(mosleyHead
					view: 472
					setCel: 0
					init:
					setPri: 130
					ignoreActors: 1
					setCycle: End self
				)
			)
			(10
				(gMessager sayRange: 11 0 1 25 26 self) ; "Nah. Just leave the tape up for a few days."
			)
			(11
				(mosleyHead dispose:)
				(mosley
					view: 4793
					setCycle: Walk
					setSpeed: 6
					ignoreActors: 1
					setMotion: PolyPath 134 127 self
				)
			)
			(12
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					setSpeed: 10
					setMotion: MoveTo 173 117 self
				)
				(writingCop setScript: takeTheBody)
				(mosley
					view: 4793
					setCycle: StopWalk -1
					setMotion: PolyPath 192 116 self
				)
			)
			(13
				(Face mosley leftPoliceTape)
			)
			(14
				(gMessager sayRange: 11 0 1 27 28 self) ; "Stick around and take notes for the book if you want--watch out for the muck and the water moccasins, though. I'll be back at the station. Stop by if you want to go over the case some more."
			)
			(15)
			(16
				(Face gEgo polCar2)
				(mosley
					view: 4793
					setCel: 0
					setLoop: 1
					setCycle: StopWalk -1
					setScaler: Scaler 90 40 109 64
					setMotion: MoveTo 130 77 self
				)
			)
			(17
				(gGkSound1 number: 476 play:)
				(mosley
					view: 479
					setCel: 0
					setLoop: 4
					setScale: 0
					posn: 125 80
					setCycle: End self
				)
			)
			(18
				(gGkSound1 number: 477 play:)
				(= cycles 5)
			)
			(19
				(if (== local5 1)
					(polCar2 setScript: takeOff)
				)
				(= local5 1)
				(gEgo setScaler: Scaler 100 57 109 64 setPri: -1 setSpeed: 6)
				(gKeyDownHandler delete: self)
				(SetFlag 65)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local3 100)) (>= local3 0) ((-= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(gCast eachElementDo: #dispose)
				(= cycles 15)
			)
			(100
				(if (gKeyDownHandler contains: takeTheBody)
					(gKeyDownHandler delete: takeTheBody)
				)
				(if (gKeyDownHandler contains: afterTheCloseUp)
					(gKeyDownHandler delete: afterTheCloseUp)
				)
				(if (gKeyDownHandler contains: putBodyAway)
					(gKeyDownHandler delete: putBodyAway)
				)
				(if (gKeyDownHandler contains: takeOff)
					(gKeyDownHandler delete: takeOff)
				)
				(waves init:)
				(patternOnGround init:)
				(leftPoliceTape init:)
				(rightPoliceTape init:)
				(topPoliceTape init:)
				(gEgo
					init:
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(for ((= local3 0)) (<= local3 100) ((+= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeTheBody of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(= cycles 6)
			)
			(1
				(leftPoliceTape setScript: moveTheTape)
				(writingCop
					view: 2371
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath 105 126 self
				)
				(coroner
					view: 4743
					setCel: 0
					setLoop: 0
					setCycle: Walk
					setScaler: Scaler 100 60 124 84
					ignoreActors: 1
					setMotion: MoveTo 140 123 self
				)
			)
			(2
				(writingCop
					setScale: 0
					view: 474
					setCel: 1
					setLoop: 4
					setCycle: CT 2 1 self
				)
			)
			(3
				(gGkSound1 number: 475 play:)
				(writingCop
					view: 474
					setCel: 2
					setLoop: 4
					setCycle: CT 9 1 self
				)
			)
			(4
				(deadBody setCel: 1)
				(writingCop view: 474 setCel: 10 setLoop: 4 setCycle: End self)
			)
			(5)
			(6
				(writingCop
					view: 2371
					setCycle: StopWalk -1
					setMotion: PolyPath 85 126 self
				)
			)
			(7
				(Face writingCop ambulance)
				(coroner
					view: 474
					setCel: 0
					setLoop: 1
					posn: 133 125
					setCycle: End self
				)
			)
			(8
				(writingCop view: 474 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(9
				(deadBody dispose:)
				(writingCop hide:)
				(coroner setCel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(writingCop show: setCycle: Beg self)
				(coroner view: 4740 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(11)
			(12
				(ambulance setScript: putBodyAway)
				(= seconds 3)
			)
			(13
				(writingCop
					view: 2371
					setLoop: 6
					setCycle: Walk
					setScaler: Scaler 100 60 124 84
					ignoreActors: 1
					setMotion: MoveTo 167 81 self
				)
			)
			(14
				(writingCop
					setCel: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 163 76 self
				)
			)
			(15
				(gGkSound2 number: 476 play:)
				(writingCop
					view: 479
					setCel: 0
					setLoop: 3
					posn: 165 79
					setScale: 0
					setCycle: End self
				)
			)
			(16
				(gKeyDownHandler delete: self)
				(gGkSound2 number: 477 play:)
				(if (== local5 1)
					(polCar2 setScript: takeOff)
				)
				(= local5 1)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local3 100)) (>= local3 0) ((-= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(localproc_0 writingCop)
				(= cycles 2)
			)
			(100
				(if (gKeyDownHandler contains: takeTheBody)
					(gKeyDownHandler delete: takeTheBody)
				)
				(if (gKeyDownHandler contains: afterTheCloseUp)
					(gKeyDownHandler delete: afterTheCloseUp)
				)
				(if (gKeyDownHandler contains: putBodyAway)
					(gKeyDownHandler delete: putBodyAway)
				)
				(if (gKeyDownHandler contains: takeOff)
					(gKeyDownHandler delete: takeOff)
				)
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(writingCop dispose:)
				(for ((= local3 0)) (<= local3 100) ((+= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance takeOff of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(polCar2Lights dispose:)
				(mosley dispose:)
				(writingCop hide:)
				(= cycles 1)
			)
			(1
				(gGkSound2 number: 472 play:)
				(polCar2
					view: 4703
					setCel: 0
					setLoop: 8
					posn: 112 83
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(polCar2
					view: 478
					setCel: 0
					setLoop: 0
					posn: 77 60
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(gKeyDownHandler delete: self)
				(ClearFlag 200)
				(ambulance dispose:)
				(polCar2 dispose:)
				(writingCop dispose:)
				(gGame handsOn:)
				(gEgo setSpeed: global212)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local3 100)) (>= local3 0) ((-= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(localproc_0 polCar2)
				(= cycles 2)
			)
			(100
				(if (gKeyDownHandler contains: takeTheBody)
					(gKeyDownHandler delete: takeTheBody)
				)
				(if (gKeyDownHandler contains: afterTheCloseUp)
					(gKeyDownHandler delete: afterTheCloseUp)
				)
				(if (gKeyDownHandler contains: putBodyAway)
					(gKeyDownHandler delete: putBodyAway)
				)
				(if (gKeyDownHandler contains: takeOff)
					(gKeyDownHandler delete: takeOff)
				)
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(polCar2 dispose:)
				(for ((= local3 0)) (<= local3 100) ((+= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putBodyAway of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gGkSound1 number: 478 setLoop: 1 play:)
				(coroner view: 4741 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(1
				(coroner
					setLoop: 2 1
					posn: 114 125
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 130 90 self
				)
			)
			(2
				(coroner
					setScale: 0
					view: 4742
					setCel: 0
					setLoop: 3
					setCycle: End self
				)
			)
			(3
				(ambulance setCel: 1)
				(coroner
					view: 4742
					setCel: 0
					setLoop: 4
					posn: 111 62
					setPri: 90
					setCycle: CT 3 1 self
				)
			)
			(4
				(gGkSound1 number: 477 play:)
				(coroner view: 4742 setCel: 4 setLoop: 4 setCycle: CT 8 1 self)
			)
			(5
				(gGkSound1 number: 477 play:)
				(coroner setCel: 9 setCycle: End self)
			)
			(6
				(afterTheCloseUp cue:)
				(coroner
					setCel: 0
					setLoop: 6 1
					posn: 120 90
					setCycle: Walk
					setSpeed: 5
					setMotion: MoveTo 81 84 self
				)
			)
			(7
				(gGkSound1 number: 476 play:)
				(coroner setCel: 0 setLoop: 5 setCycle: End self)
			)
			(8
				(coroner dispose:)
				(gGkSound2 number: 477 play:)
				(= cycles 5)
			)
			(9
				(ambulanceLights dispose:)
				(gGkSound1 number: 472 play:)
				(ambulance view: 4703 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(gKeyDownHandler delete: self)
				(ambulance hide:)
				(self dispose:)
			)
			(99
				(gKeyDownHandler delete: self)
				(for ((= local3 100)) (>= local3 0) ((-= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(localproc_0 ambulance)
				(= cycles 2)
			)
			(100
				(if (gKeyDownHandler contains: takeTheBody)
					(gKeyDownHandler delete: takeTheBody)
				)
				(if (gKeyDownHandler contains: afterTheCloseUp)
					(gKeyDownHandler delete: afterTheCloseUp)
				)
				(if (gKeyDownHandler contains: putBodyAway)
					(gKeyDownHandler delete: putBodyAway)
				)
				(if (gKeyDownHandler contains: takeOff)
					(gKeyDownHandler delete: takeOff)
				)
				(gEgo
					normalize: 0 4792
					ignoreActors: 1
					posn: 173 117
					setScaler: Scaler 100 57 109 64
					setPri: -1
					setSpeed: 6
				)
				(= cycles 1)
			)
			(101
				(ambulance dispose:)
				(for ((= local3 0)) (<= local3 100) ((+= local3 2))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(SetFlag 11)
				(SetFlag 65)
				(SetFlag 222)
				(ClearFlag 200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance moveTheTape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftPoliceTape
					setCel: 0
					setLoop: 0
					view: 4701
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(= seconds (Random 3 6))
			)
			(2
				(rightPoliceTape
					setCel: 0
					setLoop: 2
					view: 4701
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(= seconds (Random 3 6))
			)
			(4
				(topPoliceTape
					setCel: 0
					setLoop: 1
					view: 4701
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(5
				(= seconds (Random 3 6))
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance getSomeClay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 12 3 1 self) ; "Hmmm. Is that clay?"
			)
			(1
				(gEgo setMotion: PolyPath 289 103 self)
			)
			(2
				(gEgo
					view: 4751
					setCel: 0
					setLoop: 3
					setScale: 0
					setCycle: End self
				)
			)
			(3
				(gMessager say: 7 12 3 2 self) ; "Yuck!"
			)
			(4
				(gEgo
					normalize: 0 4792
					setScaler: Scaler 100 57 109 64
					ignoreActors: 1
					get: 13 ; clay
					getPoints: 128 1
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTheGrass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath local1 local2 self)
				(-= local2 15)
			)
			(1
				(gEgo
					view: 4751
					loop: 2
					cel: 0
					setScaler: Scaler 82 47 119 84
					setCycle: End self
				)
			)
			(2
				(cond
					((== local0 leftGrass)
						(grassInset init: self rm470 1)
					)
					((== local0 middleGrass)
						(grassInset init: self rm470 1)
					)
					((== local0 rightGrass)
						(grassInset init: self rm470 1)
					)
				)
				(gGame handsOn:)
				(gMessager say: 14 7 0 0) ; "It's very large grass."
			)
			(3
				(gGame handsOff:)
				(gEgo view: 4751 setCel: 6 setLoop: 2 setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(GKEgo normalize: 2 4792)
				(gEgo setScaler: Scaler 100 57 109 64 ignoreActors: 1)
				(self dispose:)
			)
		)
	)
)

(instance lookAtSand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath local1 local2 self)
				(-= local2 30)
			)
			(1
				(gEgo
					view: 4751
					loop: 2
					cel: 0
					setScaler: Scaler 82 64 119 84
					setCycle: End self
				)
			)
			(2
				(if local4
					(bloodSandInset init: self rm470)
					(gGame handsOn:)
				else
					(sandInset init: self rm470 1)
					(gGame handsOn:)
					(gMessager say: 16 7 0 0) ; "It's extremely big sand."
				)
			)
			(3
				(gGame handsOff:)
				(gEgo view: 4751 setCel: 6 setLoop: 2 setCycle: Beg self)
			)
			(4
				(= local4 0)
				(gGame handsOn:)
				(gEgo
					normalize: 2 4792
					setScaler: Scaler 100 57 109 64
					ignoreActors: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance walkOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 11 0 10 0) ; "Gabriel walks back to his motorcycle and returns to the main road."
				(gEgo setMotion: PolyPath 169 140 self)
			)
			(1
				(gGkMusic1 fade: 0 10 25 1)
				(gEgo setMotion: MoveTo 169 160 self)
			)
			(2
				(gCurRoom newRoom: 205)
				(self dispose:)
			)
		)
	)
)

(instance copyThePattern of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 169 124 self)
			)
			(1
				(Face gEgo patternOnGround self)
			)
			(2
				(gEgo
					view: 4751
					setCel: 0
					setLoop: 0
					setScale: 0
					setCycle: End self
				)
				(gMessager say: 10 15 5 0) ; "Hmmm. Let me try to get this down."
			)
			(3
				(gGkSound1 number: 15 setLoop: 1 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: Osc 2 self)
			)
			(4
				(gEgo view: 4751 setCel: 6 setLoop: 0 setCycle: Beg self)
			)
			(5
				(SetFlag 110)
				(gEgo getPoints: -999 2)
				(gGame handsOn:)
				(gEgo
					get: 31 ; sLakePatter
					normalize: 4 4792
					setScaler: Scaler 100 57 109 64
					ignoreActors: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTheCageMarks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 283 126 self)
			)
			(1
				(gEgo
					view: 4751
					setCel: 0
					setLoop: 2
					setScaler: Scaler 82 47 119 84
					setCycle: End self
				)
			)
			(2
				(gGame handsOn:)
				(cageInset init: self rm470 1)
				(gEgo getPoints: 141 1)
				(gMessager say: 9 4 0 0) ; "There are marks in the grass, as though some heavy wire object had been set there."
			)
			(3
				(gGame handsOff:)
				(gEgo view: 4751 setCel: 6 setLoop: 2 setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(gEgo
					normalize: 0 4792
					setScaler: Scaler 100 57 109 64
					ignoreActors: 1
				)
				(self dispose:)
			)
		)
	)
)

(instance grassInset of Inset
	(properties
		view 476
		x 43
		y 64
		disposeNotOnMe 1
		noun 14
	)

	(method (doVerb theVerb)
		(if (or (OneOf theVerb 7 9 6 8 12) (OneOf theVerb 3 4)) ; Look, Move, Open, Operate, Pickup, tweezers, magGlass
			(gMessager say: 14 theVerb 0 0)
		else
			(gDoVerbCode doit: 0 self)
		)
		(return 1)
	)

	(method (init)
		(if (> local1 225)
			(= local1 225)
		)
		(if (< local1 65)
			(= local1 65)
		)
		(if (> local2 59)
			(= local2 59)
		)
		(SetFlag 201)
		(self x: (-= local1 30) y: (-= local2 30))
		(= picture -2)
		(super init: &rest)
		(myMagFrame init: setPri: (+ (grassInset y:) 1))
		(plane setSize:)
		(UpdatePlane plane)
	)

	(method (dispose)
		(ClearFlag 201)
		(myMagFrame dispose:)
		(super dispose: &rest)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)
)

(instance cageInset of Inset
	(properties
		view 477
		x 168
		y 29
		disposeNotOnMe 1
		noun 14
	)

	(method (init)
		(SetFlag 201)
		(= picture -2)
		(super init: &rest)
		(cageMarks init:)
		(myMagFrame init: setPri: (+ (cageInset y:) 1))
		(if (not (IsFlag 40))
			(lakeScale init:)
		)
		(plane setSize:)
		(UpdatePlane plane)
	)

	(method (dispose)
		(ClearFlag 201)
		(cageMarks dispose:)
		(myMagFrame dispose:)
		(if (not (gEgo has: 24)) ; lakeScale
			(lakeScale dispose:)
		)
		(super dispose:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)

	(method (doVerb theVerb)
		(if (or (OneOf theVerb 7 9 6 8 12) (OneOf theVerb 3 4)) ; Look, Move, Open, Operate, Pickup, tweezers, magGlass
			(gMessager say: 14 theVerb 0 0)
		else
			(gDoVerbCode doit: 0 self)
		)
		(return 1)
	)
)

(instance cageMarks of Feature
	(properties
		noun 12
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 24 20 8 39 0 68 0 91 7 103 20 66 56 3 40
					yourself:
				)
		)
		(super init:)
	)
)

(instance sandInset of Inset
	(properties
		view 4771
		disposeNotOnMe 1
		noun 16
	)

	(method (init)
		(SetFlag 201)
		(if (> local2 59)
			(= local2 59)
		)
		(self x: (-= local1 30) y: (-= local2 30))
		(= picture -2)
		(super init: &rest)
		(myMagFrame init: setPri: (+ (sandInset y:) 1))
		(plane setSize:)
		(UpdatePlane plane)
	)

	(method (dispose)
		(ClearFlag 201)
		(myMagFrame dispose:)
		(super dispose:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)

	(method (doVerb theVerb)
		(if (or (OneOf theVerb 7 9 6 8 12) (OneOf theVerb 3 4)) ; Look, Move, Open, Operate, Pickup, tweezers, magGlass
			(gMessager say: 16 theVerb 0 0)
		else
			(gDoVerbCode doit: 0 self)
		)
		(return 1)
	)
)

(instance bloodSandInset of Inset
	(properties
		view 4772
		disposeNotOnMe 1
		noun 19
	)

	(method (init)
		(SetFlag 201)
		(if (> local2 59)
			(= local2 59)
		)
		(self x: (-= local1 30) y: (-= local2 30))
		(= picture -2)
		(super init: &rest)
		(myMagFrame init: setPri: (+ (bloodSandInset y:) 1))
		(plane setSize:)
		(UpdatePlane plane)
	)

	(method (dispose)
		(ClearFlag 201)
		(myMagFrame dispose:)
		(super dispose: &rest)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
	)
)

(instance coroner of Actor
	(properties
		x 98
		y 86
		view 470
		loop 2
	)
)

(instance mosley of Actor
	(properties
		x 192
		y 116
		view 472
		loop 5
	)
)

(instance polCar2 of Actor
	(properties
		x 153
		y 72
		view 470
		loop 5
	)
)

(instance ambulance of Actor
	(properties
		x 76
		y 51
		view 470
	)

	(method (init)
		(self setPri: 73)
		(super init:)
	)
)

(instance writingCop of Actor
	(properties
		x 145
		y 119
		view 4711
	)
)

(instance ambulanceLights of Prop
	(properties
		x 76
		y 51
		view 470
		loop 1
		signal 16417
	)

	(method (init)
		(super init:)
		(self setPri: 74 setCycle: Fwd)
	)
)

(instance polCar2Lights of Prop
	(properties
		x 153
		y 72
		view 470
		loop 6
		signal 16417
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)
)

(instance leftPoliceTape of Prop
	(properties
		noun 15
		x 37
		y 117
		view 4701
		signal 4129
	)

	(method (init)
		(super init:)
		(self setPri: 113)
		(if (not (== gPrevRoomNum 471))
			(self setScript: moveTheTape)
		)
	)
)

(instance rightPoliceTape of Prop
	(properties
		noun 15
		x 299
		y 69
		view 4701
		loop 2
		signal 4129
	)

	(method (init)
		(super init:)
		(self setPri: 150)
	)
)

(instance topPoliceTape of Prop
	(properties
		noun 15
		x 82
		y 94
		view 4701
		loop 1
		signal 4129
	)

	(method (init)
		(super init:)
	)
)

(instance limo of Prop
	(properties
		x 4
		y 86
		view 473
	)
)

(instance limoWindow of Prop
	(properties
		x 4
		y 86
		view 473
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 95)
	)
)

(instance deadBody of Prop
	(properties
		x 110
		y 121
		view 4700
	)
)

(instance mosleyHead of Prop
	(properties
		x 78
		y 96
		view 472
	)
)

(instance waves of Prop
	(properties
		noun 2
		sightAngle 20
		x 218
		y 55
		view 469
	)

	(method (init)
		(super init:)
		(self setPri: 1 setCycle: Fwd cycleSpeed: 10)
	)
)

(instance lakeScale of View
	(properties
		noun 13
		x 75
		y 52
		view 477
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: (+ (cageInset y:) 2))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; tweezers
				(= local6 1)
				(SetFlag 40)
				(gEgo get: 24 getPoints: 129 2) ; lakeScale
				(cageInset dispose:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance myMagFrame of View
	(properties
		view 1
		signal 4129
	)
)

(instance patternOnGround of View
	(properties
		noun 10
		sightAngle 20
		x 187
		y 119
		view 4700
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; sketchBook
				(if (IsFlag 402)
					(gMessager say: noun theVerb 6 0) ; "Gabriel's already done the best he could at copying those lines."
				else
					(SetFlag 402)
					(gEgo setScript: copyThePattern)
				)
			)
			(7 ; Look
				(gMessager say: noun theVerb 0 0) ; "There seems to be a pattern to the lines in the sand."
				(SetFlag 110)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lake of Feature
	(properties
		noun 2
		sightAngle 20
		x 247
		y 67
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 45 319 84 190 66 225 56 86 47 90 43
					yourself:
				)
		)
		(super init:)
	)
)

(instance road of Feature
	(properties
		noun 3
		sightAngle 20
		x 15
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 68 66 86 80 93 74 101 0 136
					yourself:
				)
		)
		(super init:)
	)
)

(instance clayBank of Feature
	(properties
		noun 7
		sightAngle 20
		x 267
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 85 303 92 305 98 274 92 242 83 232 74 249 76 262 80 266 83
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (IsFlag 128))
					(gEgo setScript: getSomeClay)
				else
					(gMessager say: noun theVerb 4 0) ; "Gabriel already took all the clay he needs."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance reflectorClose of Feature
	(properties
		noun 6
		sightAngle 20
		x 40
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 134 36 125 34 125 34 109 41 109 41 123 40 134
					yourself:
				)
		)
		(super init:)
	)
)

(instance reflectorMid of Feature
	(properties
		noun 6
		sightAngle 20
		x 74
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 72 85 72 80 70 80 70 71 75 71 75 85
					yourself:
				)
		)
		(super init:)
	)
)

(instance reflectorFar of Feature
	(properties
		noun 6
		sightAngle 20
		x 37
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 37 74 33 72 33 67 38 67 yourself:)
		)
		(super init:)
	)
)

(instance rightTree of Feature
	(properties
		noun 4
		sightAngle 20
		x 318
		y 117
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 122 293 77 247 48 223 52 162 22 204 22 221 41 265 33 257 20 319 21 314 32 277 33 271 46 319 75
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftTree of Feature
	(properties
		noun 4
		sightAngle 20
		x 46
		y 38
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 22 139 20 152 36 97 42 0 85
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftGrass of Feature
	(properties
		noun 8
		sightAngle 20
		x 85
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 145 68 130 142 138 142 145
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(= local0 leftGrass)
				(gEgo setScript: lookAtTheGrass)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(= local1 (event x:))
			(= local2 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance middleGrass of Feature
	(properties
		noun 8
		nsLeft 143
		nsTop 125
		nsRight 168
		nsBottom 136
		sightAngle 20
		x 157
		y 131
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(= local0 middleGrass)
				(gEgo setScript: lookAtTheGrass)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(= local1 (event x:))
			(= local2 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance rightGrass of Feature
	(properties
		noun 8
		sightAngle 20
		x 280
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 145 216 130 312 109 319 146
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(= local0 rightGrass)
				(gEgo setScript: lookAtTheGrass)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(= local1 (event x:))
			(= local2 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance cageGrass of Feature
	(properties
		noun 9
		sightAngle 20
		x 302
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 118 314 128 295 135 286 119
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(gEgo setScript: lookAtTheCageMarks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sand of Feature
	(properties
		noun 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 78 221 82 245 102 233 122 188 123 141 121 102 130 108 109 104 91
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(gEgo setScript: lookAtSand)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(= local1 (event x:))
			(= local2 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance myExitFeature of Feature
	(properties
		y 200
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 136 207 136 207 149 141 148
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 0 145 0 134 45 134 45 145
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: walkOff)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bloodSand of Feature
	(properties
		noun 18
		sightAngle 20
		x 138
		y 132
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 119 125 128 133 136 162 141 167 144 134 141 98 132 89 125 92 120
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 181 133 194 132 190 137 180 138
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; magGlass
				(= local4 1)
				(gEgo setScript: lookAtSand)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
		(if (== (event message:) JOY_DOWNRIGHT)
			(= local1 (event x:))
			(= local2 (event y:))
		)
		(super handleEvent: event &rest)
	)
)

(instance myExitCursor of Cursor
	(properties
		view 964
	)
)

