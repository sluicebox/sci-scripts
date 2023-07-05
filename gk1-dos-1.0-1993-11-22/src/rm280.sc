;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use n013)
(use GKNarrator)
(use sHRoom8)
(use Inset)
(use Talker)
(use Osc)
(use RandCycle)
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
	rm280 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
	local5
	local6
)

(instance rm280 of Room
	(properties
		noun 1
		picture 280
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(Load rsMESSAGE 280)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 144 246 146 242 105 124 104 86 111 69 124 46 129 19 130 12 125 20 97 1 97
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 134 110 211 107 211 122 131 123
					yourself:
				)
		)
		(SetFlag 213)
		(if (and (!= gPrevRoomNum 270) (!= gPrevRoomNum 50)) ; interrogation
			(gGkMusic1
				number: 270
				setLoop: -1
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(if (== gPrevRoomNum 50) ; interrogation
			(gEgo
				view: 282
				setLoop: 0
				cel: 8
				state: 2
				signal: (| (gEgo signal:) $1000)
				init:
				posn: 107 106
				ignoreActors: 1
				show:
			)
			(cazaunoux view: 281 setCel: 14 setLoop: 0 posn: 163 108)
			(= local0 1)
			(if (IsFlag 67)
				(gEgo setScript: lookAtTheBracelet)
				(ClearFlag 67)
			else
				(cazaunoux setScript: cazDoRandomStuff)
			)
		else
			(gEgo
				view: 275
				loop: 0
				cel: 0
				setCycle: StopWalk -1
				init:
				posn: 10 110
				state: 2
				ignoreActors: 1
				signal: (| (gEgo signal:) $1000)
				show:
			)
		)
		(candles init:)
		(chair init:)
		(coffeeTable init:)
		(candy init:)
		(boxOnTable init:)
		(leftPic init:)
		(madonna init:)
		(plant init:)
		(rightTable init:)
		(snakeScreen init:)
		(sofa init:)
		(tableLamp init:)
		(teaStuff init:)
		(wallCabinet init:)
		(cross init:)
		(myExitFeature init:)
		(leftCandleFlame init:)
		(cazaunoux init:)
		(gWalkHandler add: myExitFeature)
		(gWalkHandler add: self)
		(if (not (== gPrevRoomNum 50)) ; interrogation
			(gEgo setScript: comeInEgo)
			(gCurRoom setScript: comeInCaz)
		)
		(= gNarrator cazNarrator)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local0
					(gEgo setScript: standUp)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((myExitFeature onMe: gMouseX (- gMouseY 10))
				(if
					(and
						(== gTheCursor ((gTheIconBar at: 0) cursorView:))
						(gGame isHandsOn:)
					)
					(gGame setCursor: cazExitCursor 1)
					(= local3 1)
				)
			)
			((and local3 (gGame isHandsOn:))
				(gGame setCursor: ((gTheIconBar at: 0) cursorView:) 1)
				(= local3 0)
			)
		)
	)

	(method (dispose)
		(if (and (!= gNewRoomNum 270) (!= gNewRoomNum 50)) ; interrogation
			(gGkMusic1 fade:)
		)
		(gWalkHandler delete: self)
		(gWalkHandler delete: myExitFeature)
		(= gNarrator GKNarrator)
		(DisposeScript 64939)
		(super dispose:)
	)
)

(instance cazNarrator of Narrator
	(properties
		modeless 2
	)

	(method (init)
		(self
			fore: global220
			back: global214
			font: gUserFont
			talkWidth: 314
			x: 0
			y: 157
		)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(12 10)
				(else global220)
			)
		)
		(switch global180
			(1
				(cond
					((and (!= (gEgo view:) 283) local0)
						(= temp0 287)
						(= local6 (gEgo cycleSpeed:))
						(= local6 (gEgo cycleSpeed:))
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: 3
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
							setCycle: Fwd
						)
					)
					(
						(and
							(or
								(== (gEgo view:) 901)
								(== (gEgo view:) 900)
							)
							(== (gEgo loop:) 8)
							(== (gEgo view:) 901)
						)
						(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
							(= temp0 (+ (gEgo view:) 1000))
						else
							(if (== (gEgo view:) 900)
								(= temp0
									(+ (gEgo view:) 1010 (gEgo cel:))
								)
							else
								(= temp0
									(+ (gEgo view:) 1039 (gEgo cel:))
								)
							)
							(switch (Random 0 2)
								(0 1)
								(1
									(+= temp0 10)
								)
								(2
									(= temp0 (+ (gEgo view:) 1000))
								)
							)
						)
						(gEgo
							talking: 1
							oldView: (gEgo view:)
							oldLoop: (gEgo loop:)
							oldCel: (gEgo cel:)
							view: temp0
							setLoop: temp1 ; UNINIT
							setCel: 0
							ignoreActors:
							cycleSpeed: 14
						)
						(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
							(gEgo setCycle: ForRepeat)
						else
							(gEgo setCycle: Fwd)
						)
					)
				)
			)
			(12
				(if (OneOf (cazaunoux view:) 286 285 287)
					(if (== (cazaunoux script:) cazDoRandomStuff)
						(cazDoRandomStuff dispose:)
					)
					(= local4 1)
					(cazaunoux
						view: 287
						setLoop: 0
						setCel: 0
						setCycle: RandCycle (* (param1 size:) 3) 0 1
					)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(if local4
			(= local4 0)
			(cazaunoux setCel: 0 setCycle: 0)
			(if (and (not (gEgo script:)) (not (gCurRoom script:)))
				(cazaunoux setScript: cazDoRandomStuff)
			)
		)
		(if (gEgo talking:)
			(gEgo
				view: (gEgo oldView:)
				setLoop: (gEgo oldLoop:) 1
				setCel: (gEgo oldCel:)
				talking: 0
				setSpeed: local6
			)
			(if local0
				(gEgo setCycle: 0)
			else
				(gEgo setCycle: StopWalk -1)
			)
		)
		(super dispose:)
	)
)

(instance comeInEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 282)
				(gEgo
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 96 111 self
				)
			)
			(1
				(gMessager say: 19 0 8 1) ; "(POLITE)Please be seated, Father."
				(gEgo
					posn: 107 106
					view: 282
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(= local0 1)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance comeInCaz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 281)
				(= cycles 1)
			)
			(1
				(cazaunoux
					ignoreActors: 1
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					cycleSpeed: (+ (gEgo cycleSpeed:) 1)
					moveSpeed: (+ (gEgo moveSpeed:) 1)
					setMotion: PolyPath 137 109 self
				)
			)
			(2
				(gMessager say: 19 0 8 2) ; "(IRISH)Thank you."
				(cazaunoux
					posn: 163 108
					view: 281
					setLoop: 0
					setCel: 0
					setPri: 5
					setCycle: End self
				)
			)
			(3
				(cazaunoux
					cycleSpeed: -1
					moveSpeed: -1
					setScript: cazDoRandomStuff
				)
				(gMessager say: 19 0 8 3) ; "Now what can I do for you?"
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 284 setCel: 0 setLoop: 0 setCycle: CT 4 1 self)
			)
			(1
				(gEgo normalize: 0 275 ignoreActors: 1)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 102 108 self)
			)
			(1
				(gEgo
					view: 282
					setCel: 3
					setLoop: 0 1
					posn: 107 106
					setCycle: End self
				)
			)
			(2
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance egoLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(gEgo setMotion: PolyPath 102 108 self)
				else
					(gEgo view: 284 setCel: 0 setLoop: 0 setCycle: End self)
				)
			)
			(1
				(= local0 0)
				(cazDoRandomStuff dispose:)
				(if (not local0)
					(Face gEgo cazaunoux self)
				else
					(self cue:)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 2 13 0 1 self) ; "(IRISH)Well, Madame, I must be going."
			)
			(4
				(gEgo view: 284 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(5
				(cazaunoux
					view: 2841
					setCel: 0
					setLoop: 0
					setPri: -1
					setCycle: End self
				)
			)
			(6
				(gMessager say: 2 13 0 2) ; "(SAYING GOODBYE)Of course, Father. I know how busy you must be tending your flock."
				(cazaunoux setCel: 0 setLoop: 1 setCycle: End self)
			)
			(7
				(cazaunoux setCel: 0 setLoop: 2 setCycle: End self)
			)
			(8
				(cazaunoux setCel: 0 setLoop: 3 setCycle: End self)
			)
			(9
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(gEgo
					normalize: 2 275
					ignoreActors: 1
					setMotion: PolyPath 9 105 self
				)
				(cazaunoux
					view: 253
					setCycle: StopWalk -1
					setMotion: PolyPath 9 105
				)
			)
			(11
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance talkToCaz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cazDoRandomStuff dispose:)
				(if local0
					(self cue:)
				else
					(self setScript: egoSitDown self)
				)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 18 11 local2 0 self)
			)
			(2
				(if (== local2 3)
					(= local2 1)
				else
					(++ local2)
				)
				(cazaunoux setScript: cazDoRandomStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateCaz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self cue:)
				else
					(gCurRoom setScript: egoSitDown)
				)
				(cazDoRandomStuff dispose:)
			)
			(1
				(if (IsFlag 221)
					(gMessager say: 18 10 7 0 self) ; "(IRISH PRIEST)Do you mind if I ask you a few more questions, Madame?"
				else
					(gMessager say: 18 10 6 0 self) ; "(IRISH PRIEST)Do you mind if I ask you a few questions, my child?"
				)
			)
			(2
				(SetFlag 221)
				(= global178 12)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance showCazSomething of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gNarrator GKNarrator)
				(if local0
					(= cycles 1)
				else
					(self setScript: egoSitDown self)
				)
				(cazDoRandomStuff dispose:)
			)
			(1
				(gGame handsOff:)
				(gMessager say: 18 0 0 1 self) ; "(IRISH)Does this mean anything to you?"
				(gEgo view: 282 setCel: 0 setLoop: 1 setCycle: End)
			)
			(2
				(gMessager say: 18 0 0 2) ; "(DISINTERESTED)No, Father, it does not."
				(cazaunoux
					view: 2821
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(cazaunoux view: 2821 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(cazaunoux view: 2821 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(cazaunoux view: 2821 setCel: 3 setLoop: 0 setCycle: Beg self)
				(gEgo view: 282 setCel: 7 setLoop: 1 setCycle: Beg self)
			)
			(6)
			(7
				(= gNarrator cazNarrator)
				(cazaunoux setScript: cazDoRandomStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTheBracelet of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 7) (not (gCurRoom inset:)) (> seconds 1))
			(= register 1)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (IsFlag 78)
					(= cycles 1)
				else
					(gMessager say: 19 0 11 1 self) ; "(HUSHED, FEARFUL)Here it is, mon p\8are! A true object of evil, if ever there was one!"
				)
			)
			(2
				(cazaunoux
					view: 286
					setCel: 0
					setLoop: 0
					setPri: 120
					setCycle: End self
				)
			)
			(3
				(cazaunoux setPri: -1)
				(if (IsFlag 78)
					(gMessager say: 19 0 12 1 self) ; "(HUSHED, FEARFUL)Here's the bracelet, Father!"
				else
					(gMessager sayRange: 19 0 11 2 8 self) ; "(IRISH PRIEST BUT PARTIALLY HIS OWN VOICE WRY)It radiates something, all right."
				)
			)
			(4
				(= gNarrator GKNarrator)
				(gEgo getPoints: 139 1)
				(cazaunoux view: 286 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
				(gEgo view: 286 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5)
			(6
				(gMessager say: 19 0 13 0 self) ; "(THESE LINES IRISH. DRAMATIC)Bless this bracelet of a snake, even though its vibes aren't great."
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 2 6 7 8 9)
				(braceletInset init: 0 rm280)
			)
			(7
				(= seconds 12)
			)
			(8
				(= gNarrator GKNarrator)
				(if (gCurRoom inset:)
					(= register 1)
					(braceletInset dispose:)
				)
				(gGame handsOff:)
				(= cycles 1)
			)
			(9
				(= gNarrator cazNarrator)
				(if register
					(gMessager say: 19 0 14 0 self) ; "(FIRM)AHEM. I think that's enough, Father."
				else
					(= cycles 1)
				)
			)
			(10
				(cazaunoux view: 286 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
				(gEgo view: 286 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(11)
			(12
				(cazaunoux
					view: 286
					setLoop: 0
					setCel: 12
					setPri: 120
					setCycle: Beg self
				)
			)
			(13
				(SetFlag 78)
				(cazaunoux setPri: -1 setScript: cazDoRandomStuff)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance useTheClay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 13) ; clay
				(if (gCurRoom inset:)
					(braceletInset dispose:)
				)
				(gGame handsOff:)
				(gMessager say: 20 28 0 1 self) ; "Gabriel has a thought about the clay...."
			)
			(1
				(gEgo view: 283 setCel: 0 setLoop: 0 setCycle: End self)
				(gMessager say: 20 28 0 2 self) ; "(IRISH PRIEST, DRAMATIC)Bless, oh, bless, this circlet of silver!"
			)
			(2)
			(3
				(gEgo view: 283 setCel: 0 setLoop: 1 setCycle: End self)
				(gMessager say: 20 28 0 3 self) ; "(IRISH)Take the curse, oh, take it...Wilbur!"
			)
			(4)
			(5
				(gEgo
					view: 283
					setCel: 0
					setLoop: 2
					getPoints: -999 2
					setCycle: End self
				)
				(gMessager sayRange: 20 28 0 4 5 self) ; "(DELIGHTED)A lovely blessing, mon p\8are!"
			)
			(6)
			(7
				(cazaunoux view: 286 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
				(gEgo view: 286 setCel: 0 setLoop: 2 get: 40 setCycle: End) ; braceMold
			)
			(8
				(cazaunoux
					view: 286
					setLoop: 0
					setCel: 12
					setPri: 120
					setCycle: Beg self
				)
			)
			(9
				(gMessager say: 20 28 0 6 self) ; "(RELIEVED)I feel so much better now."
			)
			(10
				(cazaunoux setPri: -1 setScript: cazDoRandomStuff)
				(SetFlag 421)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cazDoRandomStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cazaunoux
					view: 285
					loop: (Random 0 2)
					cel: 0
					cycleSpeed: 10
					setPri: 5
					setCycle: Osc 1 self
				)
			)
			(1
				(= seconds 8)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance braceletInset of Inset
	(properties
		view 75
		x 55
		y 29
		disposeNotOnMe 1
		noun 21
	)

	(method (init)
		(super init: &rest)
		(braceletFeature init:)
	)

	(method (dispose)
		(super dispose: &rest)
		(braceletFeature dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; clay
				(lookAtTheBracelet dispose:)
				(gCurRoom setScript: useTheClay)
				(gTheIconBar enable: 0 1 2 6 7 8 9)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (== (gEgo script:) lookAtTheBracelet)
			(lookAtTheBracelet doit:)
		)
	)
)

(instance cazaunoux of Actor
	(properties
		noun 18
		x 8
		y 97
		view 253
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(gEgo setScript: talkToCaz)
			)
			(10 ; Ask
				(gEgo setScript: interrogateCaz)
			)
			(43 ; braceMold_
				(gMessager say: noun theVerb 0 0) ; "Madame Cazaunoux wouldn't be pleased about that clay mold."
			)
			(42 ; braceRep_
				(gMessager say: noun theVerb 0 0) ; "Madame Cazaunoux would object to the copy of her secret family heirloom."
			)
			(49 ; phonePage
				(gMessager say: noun theVerb 0 0) ; "What would "Father MacLaughlin" be doing carrying around the Cazaunoux phone book page? Gabriel doesn't want to give himself away."
			)
			(17 ; murderPhoto
				(gMessager say: noun theVerb 0 0) ; "Madame Cazaunoux is paranoid and fearful enough without showing her that graphic photograph!"
			)
			(79 ; badge
				(gMessager say: noun theVerb 0 0) ; "(RRCC)Gabriel's already imitating a priest! One act at a time, please!"
			)
			(else
				(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(gEgo setScript: showCazSomething)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance leftCandleFlame of Prop
	(properties
		noun 8
		sightAngle 30
		x 64
		y 71
		view 280
		signal 4129
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle)
	)
)

(instance candles of Feature
	(properties
		noun 8
		sightAngle 20
		x 63
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 84 57 70 63 62 71 65 69 97 63 97
					yourself:
				)
		)
		(super init:)
	)
)

(instance chair of Feature
	(properties
		noun 3
		sightAngle 20
		x 91
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 106 73 78 83 70 103 72 104 84 113 88 114 103 97 109
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if local0
					(super doVerb: theVerb)
				else
					(gEgo setScript: egoSitDown)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coffeeTable of Feature
	(properties
		noun 5
		sightAngle 20
		x 166
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 196 112 148 113 137 120 135 109 142 101 200 101 206 108 204 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance candy of Feature
	(properties
		noun 7
		sightAngle 20
		x 216
		y 152
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 139 196 119 235 121 233 116 243 116 251 121 270 122 270 127 259 130 259 136 268 142 267 145 148 146
					yourself:
				)
		)
		(super init:)
	)
)

(instance boxOnTable of Feature
	(properties
		noun 15
		sightAngle 20
		x 151
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 106 141 101 151 97 163 99 165 103 153 108
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftPic of Feature
	(properties
		noun 10
		sightAngle 20
		x 52
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 42 25 66 19 65 85 42 93 yourself:)
		)
		(super init:)
	)
)

(instance madonna of Feature
	(properties
		noun 6
		sightAngle 20
		x 190
		y 34
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 21 221 21 220 59 214 60 212 66 157 66
					yourself:
				)
		)
		(super init:)
	)
)

(instance plant of Feature
	(properties
		noun 13
		sightAngle 20
		x 240
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 95 232 88 246 88 249 104 233 104
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightTable of Feature
	(properties
		noun 17
		sightAngle 20
		x 221
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 94 212 83 231 82 237 87 228 96 217 97 213 101
					yourself:
				)
		)
		(super init:)
	)
)

(instance snakeScreen of Feature
	(properties
		noun 9
		sightAngle 20
		x 255
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 41 242 37 256 42 271 38 270 103 256 106 248 101 246 91 238 85
					yourself:
				)
		)
		(super init:)
	)
)

(instance sofa of Feature
	(properties
		noun 4
		sightAngle 20
		x 148
		y 76
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 123 81 135 66 154 66 177 73 201 71 214 81 205 98 204 102 200 102 199 99 135 99 136 103 131 103
					yourself:
				)
		)
		(super init:)
	)
)

(instance tableLamp of Feature
	(properties
		noun 11
		sightAngle 20
		x 220
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 72 210 70 216 59 224 59 230 71 225 72 224 85 215 84
					yourself:
				)
		)
		(super init:)
	)
)

(instance teaStuff of Feature
	(properties
		noun 14
		sightAngle 20
		x 187
		y 112
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 94 192 95 193 99 202 101 197 107 178 106 175 103
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallCabinet of Feature
	(properties
		noun 16
		sightAngle 20
		x 59
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 102 62 91 74 94 77 111 58 121 40 120
					yourself:
				)
		)
		(super init:)
	)
)

(instance cross of Feature
	(properties
		noun 12
		sightAngle 20
		x 76
		y 52
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 71 46 80 45 78 66 73 66 yourself:)
		)
		(super init:)
	)
)

(instance myExitFeature of Feature
	(properties
		noun 2
		sightAngle 20
		x 3
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 39 122 0 145 0 49 37 45 yourself:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gEgo setScript: egoLeave)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance braceletFeature of Feature
	(properties
		noun 20
		y 31
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 41 6 21 53 14 103 17 137 23 140 45 124 63 74 67 22 64
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; clay
				(lookAtTheBracelet dispose:)
				(gCurRoom setScript: useTheClay)
				(gTheIconBar enable: 0 1 2 6 7 8 9)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cazExitCursor of Cursor
	(properties
		view 964
	)
)

