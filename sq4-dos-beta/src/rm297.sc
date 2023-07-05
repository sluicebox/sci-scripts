;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 297)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm297 0
)

(local
	[local0 41] = [0 2 202 19 0 2 198 28 0 3 194 35 0 2 191 55 0 3 188 69 0 2 185 90 0 3 182 104 0 2 178 125 0 3 175 141 0 6 169 106 -32768]
	[local41 21] = [0 6 166 88 0 5 159 99 0 4 158 132 0 5 156 124 0 6 157 127 -32768]
	[local62 29] = [0 0 75 9 0 0 77 32 0 0 78 56 0 0 78 77 0 1 84 79 0 2 89 103 0 3 89 98 -32768]
	local91
)

(instance rm297 of SQRoom
	(properties
		picture 297
	)

	(method (init &tmp [temp0 50])
		(LoadMany rsSOUND 129 130 131 134)
		(HandsOff)
		(Load rsVIEW 392)
		(self
			setFeatures: hole theSkulls theNest theRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 233 189 220 154 227 133 191 124 152 118 112 121 92 128 79 129 85 146 206 154 218 189
					yourself:
				)
		)
		(gEgo
			init:
			view: 392
			normal: 0
			loop: 1
			x: 202
			y: -20
			setPri: 6
			setScript: fallScript
		)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script
				(script doit:)
			)
			((and (not local91) (== (Random 1 6000) 50))
				(= local91 1)
				(gCurRoom setScript: fly)
			)
			((& (gEgo onControl: 1) $0400)
				(HandsOff)
				(gCurRoom setScript: exitNest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== script exitNest)
				(< (exitNest state:) 3)
				(== (gEgo edgeHit:) 3)
			)
			(= newRoomNumber 0)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance fly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(maharg
					init:
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 330 20 self
				)
			)
			(1
				(maharg dispose:)
				(self dispose:)
			)
		)
	)
)

(instance maharg of Actor
	(properties
		y 20
		description {helpless stranger}
		lookStr {*** It looks as though another unfortunate adventurer is the suffering the same fate as you!}
		view 304
		loop 3
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong number: 53 loop: -1 vol: 127 play:)
				(aSound number: 131 loop: 1 play:)
				(gEgo setCycle: MCyc @local0 self)
			)
			(2
				(aSound number: 129 play:)
				(gEgo setCycle: MCyc @local41 self)
			)
			(3
				(aSound number: 130 play:)
				(= cycles 10)
			)
			(4
				(gEgo
					view: 0
					normal: 1
					loop: 2
					x: 157
					y: 127
					setCycle: StopWalk 4
					setPri:
				)
				(HandsOn)
				(Animate (gCast elements:) 0)
				(Print 297 0) ; "Hey! Those talon things hurt! You didn't much care for the landing either."
				(sp init: setScript: spFallScript)
			)
		)
	)
)

(instance spFallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 75)
			)
			(1
				(spSound play:)
				(sp setCycle: MCyc @local62 self)
			)
			(2
				(spSound number: 134 vol: 127 play:)
				(sp stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance searchBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 105 130 self)
			)
			(1
				(gEgo
					normal: 0
					view: 304
					loop: 1
					cel: 0
					x: (- (gEgo x:) 5)
					cycleSpeed: 2
					setCycle: End
				)
				(= cycles 20)
			)
			(2
				(gEgo setCycle: Beg)
				(= cycles 20)
			)
			(3
				(Print 297 1) ; "Your frisking of the skewered Sequel Policeman turns up a paper-wrapped wad of used chewing gum."
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 2) self
				)
			)
			(4
				(HandsOn)
				(gEgo illegalBits: -32768)
				(client setScript: 0)
			)
		)
	)
)

(instance exitNest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 212 158 self)
			)
			(1
				(gEgo
					normal: 0
					view: 304
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: CT 10 1 self
				)
			)
			(2
				(gEgo setPri: 14 setCycle: End self)
			)
			(3
				(gLongSong2 number: 131 vol: 127 loop: 1 play:)
				(gEgo yStep: 20 setMotion: MoveTo (gEgo x:) 240 self)
			)
			(4
				(gEgo illegalBits: -32768)
				(gLongSong fade:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sp of Prop
	(properties
		x 75
		y -20
		description {dead Sequel Policeman}
		sightAngle 45
		lookStr {My, my! Rather than the Sequel Policeman penetrating the inner sanctum of the nest, the reverse obviously occurred.}
		view 304
		priority 6
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((gInventory at: 6) owner:) 297) ; paper_with_gum
					(gEgo get: 6) ; paper_with_gum
					(HandsOff)
					(gCurRoom setScript: searchBody)
				else
					(Print 297 2) ; "What else do want? A bone marrow sample? You've already cleaned the guy's pockets."
				)
			)
			(5 ; Talk
				(Print 297 3) ; "Help! A giant branch has penetrated my vital organs and I can't get up!"
				(Print 297 4) ; "But, seriously. Did you actually think this guy has time to talk to you? He's busy being dead."
			)
			(2 ; Smell
				(Print 297 5) ; "*** The policeman has no distinct smell, but in a week things might be different."
			)
			(3 ; Taste
				(Print 297 6) ; "*** Please, this is a family oriented game!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of Feature
	(properties
		x 211
		y 152
		nsTop 146
		nsLeft 200
		nsBottom 158
		nsRight 223
		description {hole}
		sightAngle 45
		lookStr {You notice a small breach in the side of the nest.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: exitNest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {buttes}
		lookStr {You find yourself in a nest perched high above the irregular surface of this butte-laden planet.}
	)
)

(instance theSkulls of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {skulls}
		onMeCheck 16384
		lookStr {The inedible portions of the pterodactyl's previous meals lie scattered about in the nest.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 297 7) ; "I'm sure the skull would love to converse with you if it still bore the softer matter which once made it a complete and functional head."
			)
			(4 ; Do
				(Print 297 8) ; "You have no use for the skulls, vertebras, bone shards, dried cartilage, jerkified tendons, and pecked-clean ligaments strewn about the nest."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theNest of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {nest}
		onMeCheck 32
		lookStr {The huge nest is constructed of sticks (and assorted being parts) gathered from who knows where on this bleak, but pleasant, planet. It is then woven and cemented in place by a generous helping of pterodactyl saliva.}
	)
)

(instance aSound of Sound
	(properties)
)

(instance spSound of Sound
	(properties
		number 131
		vol 85
	)
)

