;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm1000 0
)

(instance rm1000 of KQRoom
	(properties
		picture 1000
	)

	(method (init)
		(super init:)
		(if (IsFlag 127)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 73 148 66 131 19 96 58 90 215 117 234 148
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 73 148 66 131 19 96 61 93 104 111 215 117 234 148
						yourself:
					)
			)
		)
		(SetFlag 21)
		(gEgo init: normalize: 1 setScaler: Scaler 100 56 134 93)
		(if (not (IsFlag 127))
			(Load 140 1002) ; WAVE
		)
		(switch gPrevRoomNum
			(35 ; chapEndRm
				(gEgo
					view: 8285
					setCycle: 0
					posn: 169 123
					setLoop: 1
					setCel: 4
				)
				(gilaTimer setReal: gilaTimer 45)
				(gila init:)
				(gEgo disableHotspot:)
				(self setScript: showFear)
			)
			(26
				(cond
					((== gChapter 1)
						(gEgo posn: 135 135)
						(self setScript: gilaComesOut)
					)
					((not (IsFlag 127))
						(gEgo
							view: 8285
							setCycle: 0
							posn: 169 123
							setLoop: 1
							setCel: 4
							disableHotspot:
						)
						(gilaTimer setReal: gilaTimer 45)
						(gila init:)
						(self setScript: showFear)
					)
					(else
						(self setScript: walkIn)
					)
				)
			)
			(1100
				(gEgo posn: 135 135)
				(cond
					((== gChapter 1)
						(gEgo disableHotspot:)
						(gila init: hide:)
						(self setScript: gilaComesOut)
					)
					((IsFlag 127)
						(self setScript: walkIn)
					)
					(else
						(gila init: hide:)
						(gilaTimer setReal: gilaTimer 45)
						(self setScript: gilaComesOut)
					)
				)
			)
			(3250
				(SetFlag 127)
				(gEgo posn: 48 95 normalize: 4)
				(self setScript: enterFromMaiden)
			)
			(else
				(gEgo posn: 182 109)
				(cond
					((and (not (IsFlag 127)) (> gChapter 1))
						(gEgo disableHotspot:)
						(gEgo posn: 195 125)
						(gilaTimer setReal: gilaTimer 45)
						(gila init:)
						(gGame handsOn:)
					)
					((not (IsFlag 127))
						(gEgo disableHotspot:)
						(gila init: hide:)
						(self setScript: gilaComesOut)
					)
				)
			)
		)
		(pillar1 init:)
		(pillar2 init:)
		(pillar3 init:)
		(pillar4 init:)
		(pearHull init:)
		(if
			(and
				(IsFlag 127)
				(or
					(and (== gValOrRoz -4) (not (IsFlag 340))) ; Val
					(and (== gValOrRoz -3) (not (IsFlag 341))) ; Roz
				)
			)
			(gilaHole init:)
		)
		(goNorth init:)
		(exitToSouth init:)
		(if (gCast contains: gila)
			(gKqMusic1
				number: 1009
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		else
			(gKqMusic1
				number: 1000
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(gWalkHandler add: self)
	)

	(method (doit)
		(super doit:)
		(if (and (not (IsFlag 127)) (< (gEgo x:) 125) (not script))
			(gEgo setMotion: 0)
			(self setScript: deathByGila)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (& (event type:) evMOVE) (> (gilaTimer seconds:) 0))
			(gilaTimer cue:)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(DisposeScript 64939)
		(gWalkHandler delete: self)
		(gKqMusic1 fade:)
		(gilaTimer seconds: 0 client: 0 delete: dispose:)
		(super dispose:)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 127))
					(gila init:)
					(if (== gChapter 3)
						(gilaTimer setReal: gilaTimer 45)
					)
					(gEgo setMotion: PolyPath 180 126 self)
				else
					(gEgo setMotion: PolyPath 129 125 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gilaComesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 1001)
				(Load rsVIEW 8285)
				(gEgo setMotion: PolyPath 180 126 self)
			)
			(1
				(proc11_3 gEgo pillar1)
				(gila
					show:
					view: 1001
					posn: 144 100
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(2
				(gila setLoop: 1 setCel: 0 setCycle: End self)
				(gEgo view: 8285 setLoop: 1 setCel: 0 setCycle: End)
				(gKqSound1 number: 1003 play:)
			)
			(3
				(gEgo get: 0) ; Golden_Comb
				(gila setCycle: CT 11 -1 self)
				(gKqSound1 number: 1002 play: self)
			)
			(4
				(gila setCycle: End)
			)
			(5
				(gila setCycle: CT 9 -1 self)
			)
			(6
				(if (== gChapter 1)
					(gGame handsOn:)
					(SetFlag 533)
					(gEgo enableHotspot:)
					(gCurRoom newRoom: 35) ; chapEndRm
				else
					(gEgo setCycle: Beg self)
				)
			)
			(7
				(gEgo normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deathByGila of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 1002) ; WAVE
				(Load 140 1003) ; WAVE
				(gilaTimer seconds: 0 client: 0 delete: dispose:)
				(proc11_3 gEgo pillar1 self)
			)
			(1
				(gKqMusic1 number: 1001 play:)
				(gila
					view: 1001
					setLoop: 1
					setCel: 6
					cycleSpeed: 12
					setCycle: CT 11 1 self
				)
			)
			(2
				(gKqSound1 number: 1002 setLoop: 1 play:)
				(gEgo view: 8283 setLoop: 0 setCel: 0 setCycle: End self)
				(gila setCycle: End self)
			)
			(3 0)
			(4
				(gKqSound1 number: 1003 play: self)
			)
			(5
				(EgoDead 39 self)
			)
			(6
				(gKqMusic1
					number: 1009
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(gila view: 1001 setLoop: 1 setCel: 0)
				(gilaTimer setReal: gilaTimer 45)
				(gEgo
					view: 8285
					setCycle: 0
					posn: 169 123
					setLoop: 1
					setCel: 4
				)
				(gCurRoom setScript: showFear)
			)
		)
	)
)

(instance givePear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gilaTimer seconds: 0 client: 0 delete: dispose:)
				(Load rsVIEW 1005)
				(self cue:)
			)
			(1
				(gEgo
					posn: 148 140
					view: 1005
					setLoop: 4
					setCel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(gila
					view: 1005
					setLoop: 1
					setCel: 0
					posn: 150 135
					cycleSpeed: 12
					setCycle: Osc 1 self
				)
			)
			(3
				(gila setLoop: 2 setCel: 0 posn: 155 135 setCycle: CT 17 1 self)
				(gKqSound1 number: 1005 setLoop: 1 play:)
			)
			(4
				(gEgo setCel: 4 setCycle: CT 13 1 self)
			)
			(5
				(gila setCycle: End self)
				(gKqSound1 number: 1006 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(6 0)
			(7
				(gKqSound1 number: 1010 setLoop: 1 play:)
				(gEgo normalize: 1 put: 20 posn: 195 125) ; Prickly_Pear
				(gila
					setLoop: 3
					setCel: 0
					setPri: 33
					posn: 202 111
					setCycle: End self
				)
				(gKqMusic1 fade:)
			)
			(8
				(gila dispose:)
				(= cycles 2)
			)
			(9
				(SetFlag 127)
				(gEgo enableHotspot:)
				(gKqMusic1
					number: 1000
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(gCurRoom obstacles: 148)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 73 148 66 131 19 96 58 90 215 117 234 148
							yourself:
						)
				)
				(gilaHole init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 40 self)
			)
			(1
				(gKqSound1 number: 1002 setLoop: 1 play: self)
			)
			(2
				(gEgo
					view: (if (== gValOrRoz -4) 8025 else 8385) ; Val
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(if (== gValOrRoz -4) ; Val
					(SetFlag 340)
				else
					(SetFlag 341)
				)
				(gilaHole dispose:)
				(if (== gValOrRoz -4) ; Val
					(gEgo posn: 91 111 normalize: 6)
				else
					(gEgo posn: 86 113 normalize: 6)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 801)
				(proc11_3 gEgo gila self)
			)
			(1
				(gEgo
					normalize:
					view:
						(if (== gValOrRoz -4) ; Val
							(if (IsFlag 127) 800 else 801)
						else
							836
						)
					setMotion: PolyPath 146 157 self
				)
			)
			(2
				(gEgo enableHotspot: setHeading: 135 self)
			)
			(3
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance walkAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 135 150 self)
			)
			(1
				(gCurRoom newRoom: 1100)
			)
		)
	)
)

(instance showFear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 90)
			)
			(1
				(gila
					view: 1001
					setLoop: 1
					setCel: 0
					posn: 144 100
					setCycle: CT 11 1 self
				)
			)
			(2
				(gila setCycle: End self)
				(gKqSound1 number: 1002 setLoop: 1 play:)
			)
			(3
				(gila setCycle: CT 11 -1 self)
				(gEgo setCycle: Beg self)
			)
			(4 0)
			(5
				(gila setCycle: CT 9 -1)
				(gEgo
					posn: 169 124
					view: 8025
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo posn: 180 125 normalize: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromMaiden of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 50 105 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gila of Prop
	(properties
		x 144
		y 100
		view 1001
		signal 4129
	)

	(method (init)
		(super init:)
		(self setHotspot: 9998 setPri: 47)
		(if (!= gChapter 1)
			(self view: 1001 setLoop: 1 setCel: 0 posn: 144 100)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: deathByGila)
			)
			(50 ; Prickly_Pear
				(gCurRoom setScript: givePear)
			)
			(else
				(gCurRoom setScript: deathByGila)
			)
		)
	)
)

(instance pillar1 of View
	(properties
		x 20
		y 46
		view 1003
	)
)

(instance pillar2 of View
	(properties
		x 56
		y 26
		view 1003
		loop 1
	)
)

(instance pillar3 of View
	(properties
		x 124
		y 34
		view 1003
		loop 2
	)
)

(instance pillar4 of View
	(properties
		x 243
		y 7
		view 1003
		loop 3
	)
)

(instance pearHull of View
	(properties
		x 126
		y 113
		view 1011
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance gilaHole of Feature
	(properties
		sightAngle 360
		approachX 101
		approachY 111
		y 200
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 10 ; Do, Exit
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 25 110 42 137 57 141 54 135 38 109 24
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: lookAtHole)
			)
		)
	)
)

(instance goNorth of ExitFeature
	(properties
		nsTop 16
		nsRight 63
		nsBottom 106
		sightAngle 20
		approachX 34
		approachY 100
		x 15
		y 50
		exitDir 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (gCast contains: gila))
			(gCurRoom setScript: deathByGila)
			(event claimed: 1)
			(return)
		)
		(super handleEvent: event)
	)

	(method (doVerb)
		(gCurRoom newRoom: 3250)
	)
)

(instance exitToSouth of ExitFeature
	(properties
		nsLeft 60
		nsTop 129
		nsRight 230
		nsBottom 150
		sightAngle 20
		approachX 114
		approachY 128
		x 128
		y 135
		exitDir 7
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 setHotspot: 10 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOVE) (gCast contains: gila))
			(= approachX (gEgo x:))
			(= approachY (gEgo y:))
			(= sightAngle 360)
		)
		(super handleEvent: event)
	)

	(method (doVerb)
		(if (gCast contains: gila)
			(gCurRoom setScript: runAway)
		else
			(gCurRoom setScript: walkAway)
		)
	)
)

(instance gilaTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (gCurRoom script:)) (not (gEgo script:)))
			(gCurRoom setScript: deathByGila)
		else
			(self setReal: self 20)
		)
	)
)

