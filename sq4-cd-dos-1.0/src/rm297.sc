;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 297)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use User)
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
		(LoadMany rsVIEW 392 304)
		(Load rsSCRIPT 942)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 233 189 220 154 227 133 191 124 152 118 112 121 92 128 79 129 93 154 206 154 218 189
					yourself:
				)
		)
		(hole init:)
		(theSkulls init:)
		(theNest init:)
		(theRoom init:)
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

(instance maharg of Sq4Prop
	(properties
		y 50
		view 304
		loop 3
		signal 2048
		lookStr 1 ; "It looks as though another unfortunate adventurer is suffering a similar fate!"
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
				(= cycles 1)
			)
			(4
				(if (not (IsFlag 32))
					(gNarrator say: 2) ; "Hey! Those talon things hurt! You didn't much care for the landing either."
				)
				(= cycles 1)
			)
			(5
				(if (not (IsFlag 37))
					(sp init: setScript: spFallScript)
				)
				(= cycles 1)
			)
			(6
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
					cycleSpeed: 18
					setCycle: End
				)
				(= cycles 20)
			)
			(2
				(gEgo setCycle: Beg)
				(= cycles 20)
			)
			(3
				(gNarrator say: 3) ; "You frisk the skewered Sequel Policeman and turn up a paper-wrapped wad of used chewing gum."
				(SetScore 55 5)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 6
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
					cycleSpeed: 12
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
				(gLongSong2 number: 143 loop: 0 setVol: 127 play: self)
			)
			(6
				(gLongSong fade: self)
			)
			(7
				(gEgo illegalBits: -32768)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sp of Sq4Prop
	(properties
		x 75
		y -20
		sightAngle 45
		view 304
		priority 6
		signal 16400
		lookStr 4 ; "My, my! Rather than the Sequel Policeman penetrating the inner sanctum of the nest, the reverse obviously occurred."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 4) ; "My, my! Rather than the Sequel Policeman penetrating the inner sanctum of the nest, the reverse obviously occurred."
			)
			(4 ; Do
				(if (== ((gInventory at: 6) owner:) 297) ; gum
					(gEgo get: 6) ; gum
					(HandsOff)
					(gCurRoom setScript: searchBody)
				else
					(gNarrator say: 5) ; "What do you want? A bone marrow sample? You've already cleaned the guy's pockets."
				)
			)
			(2 ; Talk
				(tRogNar say: 1) ; "Help! A giant branch has penetrated my vital organs and I can't get up!"
				(gNarrator say: 6) ; "Seriously, do you actually think this guy has time to talk to you? He's too busy being dead."
			)
			(6 ; Smell
				(gNarrator say: 7) ; "Right now the Sequel policeman has no distinct smell. But give him a few days and he'll be quite aromatic, not to mention plumped up like a ball park frank!"
			)
			(7 ; Taste
				(gNarrator say: 8) ; "Take it from someone who knows sick. Licking corpses is going way beyond simple dementia. Grab a grip, pal."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of Sq4Feature
	(properties
		x 211
		y 152
		nsTop 146
		nsLeft 200
		nsBottom 158
		nsRight 223
		sightAngle 45
		lookStr 9 ; "You notice a small breach in the side of the nest."
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

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		lookStr 10 ; "You find yourself in a nest perched high above the irregular surface of this butte-laden planet."
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(2 ; Talk
				(if (not (gCurRoom script:))
					(gCurRoom setScript: sEcho)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sEcho of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0)
				(= cycles 2)
			)
			(1
				(gEgo view: 297 cel: 0)
				(= ticks 30)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(tRogNar say: 2 self) ; "HELLLLLOOOO!"
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo 3 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theSkulls of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 16384
		lookStr 11 ; "The inedible portions of the pterodactyl's previous meals lie scattered about in the nest."
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(2 ; Talk
				(gNarrator say: 12) ; "The skull would love to converse with you if it still bore the soft fleshy matter which once made it a functional head."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theNest of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck 32
		lookStr 13 ; "The huge nest is constructed of sticks and assorted being parts gathered from this bleak, planet. It is then cemented in place by a generous helping of pterodactyl saliva. Ugh!"
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

(instance tRogNar of Sq4Narrator
	(properties
		noun 7
		modNum 297
		disposeWhenDone 0
		talkerNum 7
	)
)

