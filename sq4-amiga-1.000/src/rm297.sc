;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 297)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use User)
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
		(LoadMany rsVIEW 392 304)
		(self
			setFeatures: hole theSkulls theNest theRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 233 189 220 154 227 133 191 124 152 118 112 121 92 128 79 129 93 154 206 154 218 189
					yourself:
				)
		)
		(gEgo init: view: 392 normal: 0 setLoop: 1 x: 202 y: -20 setPri: 6)
		(if (IsFlag 37)
			(sp init: loop: 4 cel: 0 posn: 89 98 stopUpd:)
		)
		(super init:)
		(self setScript: fallScript)
	)

	(method (doit)
		(super doit:)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(not local91)
					(not (gEgo mover:))
					(IsFlag 37)
					(== (Random 1 3000) 50)
				)
				(= local91 1)
				(maharg init:)
			)
			((StepOn gEgo 1024)
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

(instance maharg of Prop
	(properties
		y 50
		description {helpless stranger}
		lookStr {It looks as though another unfortunate adventurer is suffering a similar fate!}
		view 304
		loop 3
		signal 2048
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd doit:)
	)

	(method (doit)
		(super doit:)
		(if (<= x 320)
			(self x: (+ x 3) y: (- y 1))
		else
			(self dispose:)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong stop:)
				(aSound number: 131 loop: 1 play:)
				(gEgo setCycle: MCyc @local0 self)
			)
			(1
				(aSound number: 129 play:)
				(gEgo setCycle: MCyc @local41 self)
			)
			(2
				(aSound number: 130 play:)
				(= cycles 10)
			)
			(3
				(gEgo
					view: 0
					normal: 1
					setLoop: -1
					loop: 2
					x: 157
					y: 127
					setCycle: StopWalk 4
					setPri: -1
					setStep: 3 2
				)
				(gLongSong number: 53 loop: -1 vol: 127 playBed:)
				(Animate (gCast elements:) 0)
				(if (not (IsFlag 32))
					(Print 297 0) ; "Hey! Those talon things hurt! You didn't much care for the landing either."
				)
				(= cycles 1)
			)
			(4
				(if (not (IsFlag 37))
					(sp init: setScript: spFallScript)
				)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spFallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 32)
					(self cue:)
				else
					(= cycles 75)
				)
			)
			(1
				(SetFlag 37)
				(spSound play:)
				(= cycles 3)
			)
			(2
				(sp setCycle: MCyc @local62 self)
			)
			(3
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
				(SetScore 55 5)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					setCycle: StopWalk 4
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
				(= seconds 3)
			)
			(5
				(gLongSong2 number: 143 loop: 0 play: self)
			)
			(6
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
			(3 ; Do
				(if (== ((gInventory at: 6) owner:) 297) ; gum
					(gEgo get: 6) ; gum
					(HandsOff)
					(gCurRoom setScript: searchBody)
				else
					(Print 297 2) ; "What else do you want? A bone marrow sample? You've already cleaned the guy's pockets."
				)
			)
			(5 ; Talk
				(Print 297 3) ; "Help! A giant branch has penetrated my vital organs and I can't get up!"
				(Print 297 4) ; "But, seriously. Did you actually think this guy has time to talk to you? He's busy being dead."
			)
			(11 ; Smell
				(Print 297 5) ; "At this moment the Sequel policeman has no distinct smell other than that of someone with less than exemplary personal hygiene habits. Give him a few days or so and he'll be quite aromatic, not to mention pumped up like a ball park frank!"
			)
			(10 ; Taste
				(Print 297 6) ; "Take it from someone who knows sick. Licking corpses is going way beyond just pushing the envelope of dementia. Grab the reins, pal."
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
			(3 ; Do
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
		sightAngle 45
		lookStr {You find yourself in a nest perched high above the irregular surface of this butte-laden planet.}
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(5 ; Talk
				(aSound number: 161 loop: 1 flags: 1 play:)
				(Print 297 7) ; "HELLO! hello. . hello. ."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSkulls of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {skulls}
		sightAngle 45
		onMeCheck 16384
		lookStr {The inedible portions of the pterodactyl's previous meals lie scattered about in the nest.}
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(5 ; Talk
				(Print 297 8) ; "I'm sure the skull would love to converse with you if it still bore the softer matter which once made it a complete and functional head."
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
		sightAngle 45
		onMeCheck 32
		lookStr {The huge nest is constructed of sticks (and assorted being parts) gathered from who knows where on this bleak, but pleasant, planet. It is then woven and cemented in place by a generous helping of pterodactyl saliva.}
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb)
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

