;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm037 0
)

(local
	[local0 9] = [154 146 210 169 212 184 147 209 -32768]
)

(instance rm037 of PQRoom
	(properties
		noun 1
		picture 37
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 162 0 185 16 180 7 169 32 161 44 171 146 138 155 120 169 120 196 120 230 120 223 98 279 80 299 93 298 105 319 107 319 88 278 73 219 94 221 107 195 114 173 102 164 103 126 83 116 86 156 107
					yourself:
				)
		)
		(super init:)
		(switch global207
			(914
				(car view: 914 posn: 133 189)
			)
			(104
				(car view: 104 posn: 20 200)
			)
			(105
				(car view: 105 posn: 88 164)
			)
		)
		(car addToPic:)
		(if (== global207 104)
			(doo addToPic:)
		)
		(NormalEgo)
		(if (== gPrevRoomNum 38)
			(self setScript: escape)
		else
			(self setScript: comeIn)
		)
		(bench init:)
		(deck init:)
		(flowers init:)
		(hangplant init:)
		(shops init:)
		(pLot init:)
		(plants init:)
		(rock init:)
		(theSign init:)
		(soupofday init:)
		(table init:)
		(tree init:)
		(umbrella init:)
		(gLongSong fade:)
		(gLongSong2 number: 915 loop: -1 flags: -1 play:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 8192)
				(self setScript: goIn)
			)
		)
	)

	(method (dispose)
		(gLongSong2 fade:)
		(DisposeScript 310)
		(DisposeScript 315)
		(super dispose:)
	)
)

(instance car of View
	(properties
		x 88
		y 164
		noun 15
		view 105
		priority 14
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (OneOf global211 33 74)
					(gMessager say: 16 4 5) ; "Leaving already? Jack's waiting for you inside. Better check in with him first."
				else
					(leav start: 0)
					(gCurRoom setScript: leav)
				)
			)
			(1 ; Look
				(switch global207
					(105
						(gMessager say: 15 1 1) ; "It's your sleek, sexy personal auto."
					)
					(104
						(gMessager say: 15 1 3) ; "It's your unmarked police car."
					)
					(else
						(gMessager say: 15 1 2) ; "It's your aging departmental-issue patrol car."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doo of View
	(properties
		x 103
		y 201
		z 8
		view 104
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb)
		(car doVerb: &rest)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 210 169 init: setMotion: MoveTo 144 137 self)
			)
			(1
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance escape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 123 83 init: setMotion: MoveTo 141 99 self)
			)
			(1
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance leav of Script
	(properties
		start 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 108 153 self)
			)
			(1
				(gEgo setMotion: DPath 154 146 210 169 212 184 147 209 self)
			)
			(2
				(if (OneOf global211 36 76)
					(++ global211)
				)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance goIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 123 83 self)
			)
			(1
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance bench of Feature
	(properties
		noun 10
		onMeCheck 2
	)
)

(instance deck of Feature
	(properties
		noun 12
		onMeCheck 4
	)
)

(instance flowers of Feature
	(properties
		noun 5
		onMeCheck 8
	)
)

(instance hangplant of Feature
	(properties
		noun 4
		onMeCheck 16
	)
)

(instance shops of Feature
	(properties
		noun 13
		onMeCheck 32
	)
)

(instance pLot of Feature
	(properties
		noun 14
		onMeCheck 64
	)
)

(instance plants of Feature
	(properties
		noun 6
		onMeCheck 128
	)
)

(instance rock of Feature
	(properties
		noun 7
		onMeCheck 256
	)
)

(instance theSign of Feature
	(properties
		noun 3
		onMeCheck 512
	)
)

(instance soupofday of Feature
	(properties
		noun 8
		onMeCheck 1024
	)
)

(instance table of Feature
	(properties
		noun 9
		onMeCheck 2048
	)
)

(instance tree of Feature
	(properties
		noun 2
		onMeCheck 4096
	)
)

(instance umbrella of Feature
	(properties
		noun 11
		onMeCheck 16384
	)
)

