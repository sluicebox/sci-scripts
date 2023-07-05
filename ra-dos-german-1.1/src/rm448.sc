;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 448)
(include sci.sh)
(use Main)
(use Door)
(use eRS)
(use ExitFeature)
(use PursuitRgn)
(use PChase)
(use Scaler)
(use PolyPath)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm448 0
)

(local
	local0
)

(instance rm448 of LBRoom
	(properties
		noun 14
		picture 448
		north 450
		south 440
		west 460
		vanishingX 150
		vanishingY 35
	)

	(method (init)
		(LoadMany rsVIEW 449 440 424 423 448 426 831)
		(LoadMany rsSOUND 444 443 445)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 138 0 190 35
		)
		(if (== gAct 5)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2448 0) doit: (gCurRoom obstacles:)) ; poly2448Code
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(switch gPrevRoomNum
			(north
				(gEgo x: 140 y: 111)
				(self setScript: sEnterNorth)
			)
			(south
				(gEgo x: 151 y: 162 edgeHit: EDGE_NONE setHeading: 0)
				(self setScript: sEnterSouth)
			)
			(west
				(gEgo x: 85 y: 130 edgeHit: EDGE_NONE setHeading: 90)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 146 130)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (== gAct 5)
			(if (or (IsFlag 39) (IsFlag 116))
				(chair setPri: 7 posn: 104 123)
				(transomWin cel: 3)
			)
			(chair init: stopUpd:)
		)
		(transomWin init: stopUpd:)
		(if (IsFlag 47)
			(westNoDoor init:)
		else
			(transomDoor init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		)
		(flag4 init:)
		(flag5 init:)
		(flag6 init:)
		(flag7 init:)
		(armor4 init:)
		(armor7 init:)
		(armor8 init:)
		(rearDoorway init:)
		(southExitFeature init:)
	)

	(method (dispose)
		(DisposeScript 2448)
		(gWalkHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(gEgo edgeHit: EDGE_LEFT)
				(self newRoom: west)
			)
			((StepOn gEgo 8)
				(self newRoom: north)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sOffChair)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (notify)
		(if (== gAct 5)
			(if (gCurRoom script:)
				((gCurRoom script:) next: sHeKills)
			else
				(gCurRoom setScript: sHeKills)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) $0040) ; direction
					(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
					(!= (event message:) JOY_NULL)
				)
				(event claimed: 1)
				(gCurRoom setScript: sOffChair)
			)
			((& (event type:) evMOVE)
				(super handleEvent: event)
			)
		)
	)
)

(instance sEnterWest of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo x: 230 y: 140 edgeHit: EDGE_NONE setMotion: MoveFwd 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo edgeHit: EDGE_NONE setHeading: 180 setMotion: MoveFwd 10 self)
			)
			(2
				(if (and (not (IsFlag 39)) (== gAct 5))
					((ScriptID 94 1) cue:) ; pursuitTimer
				)
				(gGame handsOn:)
				(self dispose:)
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
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHeKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if local0
					(self setScript: sOffChair self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(= cycles 1)
			)
			(3
				(gEgo setMotion: PolyPath 149 128 self)
			)
			(4
				(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				(oriley init: setScale: Scaler 138 0 190 35)
				(= cycles 1)
			)
			(5
				(oriley setCycle: Walk setMotion: PChase gEgo 12 self)
			)
			(6
				(Face gEgo oriley)
				(= cycles 2)
			)
			(7
				(oriley view: 424 cel: 0 setCycle: End self)
			)
			(8
				(noise number: 80 flags: 5 play:)
				(gEgo view: 858 setCycle: End self)
			)
			(9
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sMoveChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo ignoreActors: 1 illegalBits: 0)
				(= cycles 1)
			)
			(2
				(if (StepOn gEgo 16)
					(gEgo setMotion: MoveTo 112 135 self)
				else
					(gEgo setMotion: PolyPath 112 135 self)
				)
			)
			(3
				(= local0 1)
				(gEgo
					view: 449
					loop: 0
					cel: 0
					posn: 112 133
					ignoreActors: 0
					illegalBits: -32768
					setCycle: End self
				)
				(chair
					ignoreActors: 1
					setLoop: 2
					moveSpeed: (+ (gEgo moveSpeed:) 4)
					setMotion: MoveTo 104 123 self
				)
				(noise number: 443 flags: 5 play:)
			)
			(4 0)
			(5
				(gEgo
					normalize: (if (== gAct 5) 426 else 831)
					setScale: Scaler 138 0 190 35
					setMotion: MoveTo 121 122 self
				)
			)
			(6
				(gEgo
					view: 449
					loop: 1
					cel: 0
					posn: 107 124
					setPri: 9
					setCycle: End self
				)
				(chair setPri: 7 stopUpd:)
				(gWalkHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
			)
			(7
				(gGame handsOn:)
				(transomDoor approachVerbs: 0)
				(SetFlag 116)
				(southExitFeature dispose:)
				(rearDoorway sightAngle: 26505)
				(armor4 sightAngle: 26505)
				(armor7 sightAngle: 26505)
				(armor8 sightAngle: 26505)
				(flag4 sightAngle: 26505)
				(flag5 sightAngle: 26505)
				(flag6 sightAngle: 26505)
				(flag7 sightAngle: 26505)
				(self dispose:)
			)
		)
	)
)

(instance sOnChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo ignoreActors: 1 illegalBits: 0)
				(= cycles 1)
			)
			(2
				(if (StepOn gEgo 16)
					(gEgo setMotion: MoveTo 121 122 self)
				else
					(gEgo setMotion: PolyPath 121 122 self)
				)
			)
			(3
				(gEgo
					view: 449
					loop: 1
					cel: 0
					posn: 107 124
					setPri: 9
					ignoreActors: 0
					illegalBits: -32768
					setCycle: End self
				)
			)
			(4
				(gGame handsOn:)
				(transomDoor approachVerbs: 0)
				(= local0 1)
				(southExitFeature dispose:)
				(gWalkHandler addToFront: gCurRoom)
				(gDirectionHandler addToFront: gCurRoom)
				(rearDoorway sightAngle: 26505)
				(armor4 sightAngle: 26505)
				(armor7 sightAngle: 26505)
				(armor8 sightAngle: 26505)
				(flag4 sightAngle: 26505)
				(flag5 sightAngle: 26505)
				(flag6 sightAngle: 26505)
				(flag7 sightAngle: 26505)
				(self dispose:)
			)
		)
	)
)

(instance sOffChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 449
					loop: 1
					cel: 8
					posn: 107 124
					setPri: 10
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					normalize: (if (== gAct 5) 426 else 831)
					posn: 121 122
					setScale: Scaler 138 0 190 35
				)
				(= local0 0)
				(gGame handsOn:)
				(transomDoor approachVerbs: 4 1 8) ; Do, Look, magnifier
				(southExitFeature init:)
				(gWalkHandler delete: gCurRoom)
				(gDirectionHandler delete: gCurRoom)
				(rearDoorway sightAngle: 40)
				(armor4 sightAngle: 40)
				(armor7 sightAngle: 40)
				(armor8 sightAngle: 40)
				(flag4 sightAngle: 40)
				(flag5 sightAngle: 40)
				(flag6 sightAngle: 40)
				(flag7 sightAngle: 40)
				(self dispose:)
			)
		)
	)
)

(instance sOpenTransom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= cycles 1)
				else
					(self setScript: sOnChair self)
				)
			)
			(1
				(gEgo
					loop: 2
					cel: 0
					posn: 104 112
					ignoreActors: 1
					illegalBits: 0
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(transomWin setCycle: End)
				(noise number: 445 flags: 5 play:)
			)
			(3
				(gEgo cel: 0)
				(transomWin stopUpd:)
				(= cycles 1)
			)
			(4
				(SetFlag 39)
				(PursuitRgn increaseTime:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseTransom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= cycles 1)
				else
					(self setScript: sOnChair self)
				)
			)
			(1
				(gEgo
					loop: 2
					cel: 9
					ignoreActors: 1
					illegalBits: 0
					posn: 104 112
					setCycle: CT 6 -1 self
				)
			)
			(2
				(gEgo setCycle: Beg self)
				(transomWin setCycle: Beg)
				(noise number: 445 flags: 5 play:)
			)
			(3
				(ClearFlag 39)
				(transomWin stopUpd:)
				(PursuitRgn decreaseTime:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 171
		y 199
		view 423
	)
)

(instance chair of Actor
	(properties
		x 86
		y 133
		noun 3
		approachX 116
		approachY 121
		view 440
		loop 2
		signal 16384
		illegalBits 0
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local0
						(gCurRoom setScript: sOffChair)
					)
					((and (>= (chair x:) 104) (not local0))
						(gCurRoom setScript: sOnChair)
					)
					((>= (chair x:) 104)
						(gCurRoom setScript: sOffChair)
					)
					(else
						(gCurRoom setScript: sMoveChair)
					)
				)
			)
			(3 ; Walk
				(cond
					((and (>= (chair x:) 104) (not local0))
						(gCurRoom setScript: sOnChair)
					)
					((>= (chair x:) 104)
						(gCurRoom setScript: sOffChair)
					)
					(else
						(gCurRoom setScript: sMoveChair)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance transomDoor of Door
	(properties
		x 87
		y 100
		z -26
		noun 5
		approachX 117
		approachY 122
		view 448
		priority 8
		signal 4096
	)

	(method (initialize))

	(method (createPoly)
		(super createPoly: 94 119 108 120 88 131 80 125)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local0)
					(gMessager say: 5 4) ; "The door is locked. When you touch the doorknob, you get a heavy coating of dust all over the palm of your hand."
					(noise number: 48 loop: 1 flags: 5 play:)
				else
					(gCurRoom setScript: sOffChair)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance transomWin of Prop
	(properties
		x 88
		y 65
		noun 4
		view 448
		loop 1
	)

	(method (initialize))

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (>= (chair x:) 104))
						(gMessager say: 4 4 1) ; "The transom is too high for you to reach while standing on the floor."
					)
					((== (transomWin cel:) 0)
						(gCurRoom setScript: sOpenTransom)
					)
					(else
						(gCurRoom setScript: sCloseTransom)
					)
				)
			)
			(8 ; magnifier
				(if (= local0 0)
					(gMessager say: 4 8 0 0) ; "It's too high to view it with the magnifying glass."
				else
					(gMessager say: 4 8 2 0) ; "There's a thick coating of dust on the transom."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westNoDoor of Feature
	(properties
		x 92
		y 101
		noun 15
		nsTop 79
		nsLeft 88
		nsBottom 123
		nsRight 96
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 15 1 3 0) ; "The locked door that formerly occupied this space has been smashed open, allowing you to pass through."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance armor4 of Feature
	(properties
		x 107
		y 89
		noun 7
		nsTop 76
		nsLeft 101
		nsBottom 122
		nsRight 113
		sightAngle 40
	)
)

(instance armor7 of Feature
	(properties
		x 192
		y 100
		noun 8
		nsTop 77
		nsLeft 185
		nsBottom 123
		nsRight 200
		sightAngle 40
	)
)

(instance armor8 of Feature
	(properties
		x 212
		y 103
		noun 9
		nsTop 72
		nsLeft 202
		nsBottom 134
		nsRight 222
		sightAngle 40
	)
)

(class ArmorFlag of Feature
	(properties
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gMessager say: 1 8 0 0) ; "They're too high to look at with the magnifying glass."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flag4 of ArmorFlag
	(properties
		x 111
		y 51
		noun 10
		nsTop 43
		nsLeft 104
		nsBottom 60
		nsRight 119
	)
)

(instance flag5 of ArmorFlag
	(properties
		x 116
		y 67
		noun 11
		nsTop 61
		nsLeft 110
		nsBottom 74
		nsRight 122
	)
)

(instance flag6 of ArmorFlag
	(properties
		x 172
		y 66
		noun 12
		nsTop 59
		nsLeft 168
		nsBottom 74
		nsRight 177
	)
)

(instance flag7 of ArmorFlag
	(properties
		x 174
		y 50
		noun 13
		nsTop 43
		nsLeft 167
		nsBottom 58
		nsRight 181
	)
)

(instance rearDoorway of Feature
	(properties
		y 100
		noun 2
		nsTop 83
		nsLeft 126
		nsBottom 112
		nsRight 170
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 143
		nsLeft 74
		nsBottom 189
		nsRight 227
		cursor 11
		exitDir 3
		noun 17
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

