;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use station)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm019 0
)

(instance rm019 of PQRoom
	(properties
		noun 2
		picture 19
	)

	(method (init)
		(gEgo init:)
		(self
			setRegions: 134 ; station
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 118 0 0 319 0 319 189 288 189 0 189 88 159 230 159 105 91 80 100 74 95
					yourself:
				)
		)
		(NDOOR init:)
		(BOARD init:)
		(SENSOR init:)
		(EXT init:)
		(Fountain init:)
		(super init:)
		(door init:)
		(switch gPrevRoomNum
			(21
				(gEgo posn: 217 132)
				(HandsOff)
				(self setScript: enterNarcotics)
			)
			(else
				(gEgo posn: 41 149)
				(self posn: 73 131 setScript: (ScriptID 896 1)) ; sWI
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((& temp0 $0002)
				(self posn: 41 149 setScript: (ScriptID 896 2) 0 18) ; sWO
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance enterNarcotics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 198 137 self)
			)
			(1
				(door startUpd: setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(3
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitNarcotics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 913 loop: 1 play: self)
			)
			(1
				(proc134_2 self)
			)
			(2
				(door startUpd: setCycle: End self)
				(NormalEgo -1 6)
			)
			(3
				(gEgo setMotion: MoveTo 242 127 self)
			)
			(4
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 206
		y 129
		noun 1
		approachX 198
		approachY 137
		view 155
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 21)
			(= cel (self lastCel:))
		)
		(self approachVerbs: 4 stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: exitNarcotics)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance NDOOR of Feature
	(properties
		x 213
		y 107
		noun 1
		nsTop 69
		nsLeft 198
		nsBottom 146
		nsRight 228
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance BOARD of Feature
	(properties
		x 175
		y 83
		noun 3
		nsTop 62
		nsLeft 160
		nsBottom 105
		nsRight 190
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance SENSOR of Feature
	(properties
		x 154
		y 48
		noun 4
		nsTop 45
		nsLeft 152
		nsBottom 52
		nsRight 157
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance EXT of Feature
	(properties
		x 123
		y 58
		noun 5
		nsTop 48
		nsLeft 117
		nsBottom 68
		nsRight 130
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Fountain of Feature
	(properties
		x 83
		y 74
		noun 6
		nsTop 59
		nsLeft 73
		nsBottom 90
		nsRight 94
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

