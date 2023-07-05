;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 609)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use SQRoom)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm609 0
)

(instance rm609 of SQRoom
	(properties
		picture 609
		horizon 88
		north 612
		east 610
	)

	(method (init)
		(ulence roomVer: 11891)
		(switch gPrevRoomNum
			(610
				(if (< (gEgo y:) 147)
					(gEgo y: 147)
				)
				(if (== (ulence status:) 99)
					(gEgo posn: 160 101)
					(self setScript: hideEgo)
				)
			)
			(612
				(if (< (gEgo x:) 175)
					(gEgo x: 151)
				else
					(gEgo x: 248)
				)
			)
			(else
				(gEgo x: 247 y: 105)
			)
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(hole init:)
		(ship1 init:)
		(ship2 init:)
		(tinysHut init:)
		(theSign init:)
		(super init:)
		(self
			setFeatures: ship2 tinysHut theSign
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 107 85 136 98 93 98 90 103 150 103 161 110 23 170 23 189 0 189 0 0 319 0 319 102 288 102 275 85 208 85 225 95 215 104 179 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 166 137 185 147 175 159 156 164 122 164 95 151 122 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 294 151 294 161 238 161 238 151
					yourself:
				)
		)
	)

	(method (doit)
		(if script 0)
		(super doit: &rest)
	)
)

(instance ship1 of View
	(properties
		x 136
		y 155
		description {ship1}
		sightAngle 45
		lookStr {This must be the Volkswagen of space ships. You wonder why anyone would bother to lock it!}
		view 609
		priority 11
		signal 24592
	)
)

(instance ship2 of Feature
	(properties
		x 305
		y 86
		nsTop 72
		nsLeft 292
		nsBottom 101
		nsRight 319
		description {ship2}
		sightAngle 45
		onMeCheck 16
		lookStr {This is the tail of a ship parked for business at the Ulence Flats Bar.}
	)
)

(instance tinysHut of Feature
	(properties
		x 69
		y 80
		nsTop 32
		nsLeft 3
		nsBottom 128
		nsRight 136
		description {tinysHut}
		sightAngle 45
		onMeCheck 2
		lookStr {This building is quite small. Maybe THIS is why it's called Tiny's.}
	)
)

(instance hole of View
	(properties
		x 268
		y 158
		nsTop 150
		nsLeft 243
		nsBottom 166
		nsRight 294
		description {hole}
		sightAngle 45
		lookStr {At the bottom of this excavation is a small craft almost totally buried in dirt. You remember barely making it back out when the engine died.}
		view 609
		loop 1
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 609 0) ; "There it is - good old dirt!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		x 145
		y 22
		nsLeft 100
		nsBottom 44
		nsRight 191
		description {sign}
		sightAngle 45
		onMeCheck 4
		lookStr {This announces that you've found the location of Tiny's Used Space Ships. Lucky you.}
	)
)

(instance hideEgo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 91 101 self)
			)
			(1
				((ScriptID 706 2) ; theBiker
					init:
					setPri: 4
					posn: 329 173
					setLoop: 1
					setMotion: MoveTo 280 173 self
				)
			)
			(2
				((ScriptID 706 2) setLoop: 7 setMotion: MoveTo 160 83 self) ; theBiker
			)
			(3
				((ScriptID 706 2) ; theBiker
					setLoop: 1
					posn: 146 76
					setMotion: MoveTo 71 76 self
				)
			)
			(4
				((ScriptID 706 2) hide: view: 633 setLoop: 1 posn: 343 83) ; theBiker
				(= seconds (Random 2 4))
			)
			(5
				((ScriptID 706 2) show: setMotion: MoveTo 247 83 self) ; theBiker
			)
			(6
				((ScriptID 706 2) ; theBiker
					posn: 244 85
					setLoop: 2
					setMotion: MoveTo 244 235 self
				)
			)
			(7
				(gLongSong fade:)
				(NormalEgo)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: StopWalk
					setMotion: MoveTo 160 101 self
				)
			)
			(8
				(gEgo setMotion: MoveTo 187 125 self)
			)
			(9
				(proc706_1)
				(HandsOn)
				(ulence status: 1)
				(self dispose:)
			)
		)
	)
)

