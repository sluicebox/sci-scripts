;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 609)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use eRS)
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
		horizon 92
		north 612
		east 610
	)

	(method (init)
		(ulence roomVer: 3591)
		(switch gPrevRoomNum
			(610
				(if (< (gEgo y:) 147)
					(gEgo y: 147)
				)
				(if (== (ulence status:) 99)
					(gEgo posn: 84 100)
					(self setScript: hideEgo)
				else
					(gLongSong2 number: 0 vol: 0 stop:)
				)
			)
			(612
				(cond
					((< (gEgo x:) 175)
						(gEgo x: 151)
					)
					((> (gEgo x:) 263)
						(gEgo x: 294)
					)
					(else
						(gEgo x: 248)
					)
				)
			)
			(else
				(gEgo x: 247 y: 110)
			)
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(ship1 init:)
		(hole init:)
		(super init:)
		(self
			setFeatures: ship2 tinysHut theSign
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 131 87 124 98 93 98 90 103 150 103 161 110 65 131 13 132 18 163 18 189 0 189 0 0 319 0 319 85 219 85 232 101 170 100 162 87
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 166 137 185 147 185 154 175 159 156 164 122 164 93 157 94 144 122 136
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 294 151 294 161 238 161 238 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 105 287 105 287 94 319 94
					yourself:
				)
		)
		((ScriptID 706 8) init: nsLeft: 0 nsTop: 0 nsBottom: 71 nsRight: 319) ; theDunes
		((ScriptID 706 7) init: nsLeft: 0 nsTop: 72 nsBottom: 189 nsRight: 318) ; theSand
	)

	(method (doit)
		(cond
			(script 0)
			((and (== (gEgo edgeHit:) 2) (< (gEgo y:) 100))
				(self setScript: exitRight)
			)
		)
		(super doit: &rest)
	)
)

(instance hideEgo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) ; theBiker
					init:
					posn: 329 173
					setLoop: 1
					setMotion: MoveTo -20 173 self
				)
			)
			(1
				((ScriptID 706 6) fade:) ; theBikeSound
				((ScriptID 706 1) hide: view: 633 setLoop: 1 posn: 343 83) ; theBiker
				(= seconds (Random 2 4))
			)
			(2
				((ScriptID 706 6) play:) ; theBikeSound
				((ScriptID 706 1) show: setPri: 4 setMotion: MoveTo 247 83 self) ; theBiker
			)
			(3
				((ScriptID 706 1) ; theBiker
					posn: 244 85
					setLoop: 2
					setMotion: MoveTo 244 235 self
				)
			)
			(4
				((ScriptID 706 6) fade:) ; theBikeSound
				(gLongSong2 fade:)
				(NormalEgo)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: StopWalk
					setMotion: MoveTo 160 101 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 187 125 self)
			)
			(6
				(Print 609 0) ; ""Boy, that was CLOSE", you think to yourself as you come out of hiding from behind Tiny's hut. Interesting how their bikes can go through the force field."
				(NormalEgo (gEgo loop:) 0)
				(HandsOn)
				(ulence status: 1)
				(self dispose:)
			)
		)
	)
)

(instance exitRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 613)
			)
		)
	)
)

(instance ship1 of View
	(properties
		x 136
		y 155
		description {space ship}
		sightAngle 90
		lookStr {This must be the Volkswagen of space ships. You wonder why anyone would bother to lock it!}
		view 609
		priority 11
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(Print 609 1) ; "This ship is not for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
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
		sightAngle 90
		lookStr {At the bottom of this excavation is a small craft almost totally buried in dirt. You remember barely making it back out when the engine died.}
		view 609
		loop 1
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(Print 609 2) ; "There it is - good old dirt!"
			)
			(10 ; Taste
				(Print 609 3) ; "Tastes like dirt."
			)
			(11 ; Smell
				(Print 609 4) ; "Smells like dirt."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		y 44
		nsLeft 100
		nsBottom 44
		nsRight 191
		description {sign}
		sightAngle 90
		onMeCheck 4
		lookStr {This announces that you've found the location of Tiny's Used Space Ships. Lucky you.}
	)
)

(instance ship2 of Feature
	(properties
		y 101
		nsTop 72
		nsLeft 292
		nsBottom 101
		nsRight 319
		description {space ship}
		sightAngle 90
		onMeCheck 16
		lookStr {This is the tail of a ship parked for business at the Ulence Flats Bar.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(Print 609 1) ; "This ship is not for sale."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tinysHut of Feature
	(properties
		y 128
		nsTop 32
		nsLeft 3
		nsBottom 128
		nsRight 136
		description {Tiny's Hut}
		sightAngle 90
		onMeCheck 2
		lookStr {This building is quite small. Maybe THIS is why it's called Tiny's.}
	)
)

