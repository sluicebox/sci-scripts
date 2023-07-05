;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm400 0
)

(instance rm400 of LLRoom
	(properties
		lookStr {You are outside Lost Wages' finest instant marriage center, the "Quiki-Wed" Wedding Chapel, another in the vast conglomerate that has become the fabulous "Quiki" empire. An interesting form resides beneath that light pole.}
		picture 400
		north 410
		east 170
		west 300
	)

	(method (init)
		(LoadMany rsSOUND 301 400 401 801 802)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 254 137 310 137 310 145 254 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 128 258 131 207 131 196 134 162 135 92 131 36 131 36 134 63 134 63 138 0 138
					yourself:
				)
		)
		(gTheMusic3 loop: 1 flags: 1)
		(switch gPrevRoomNum
			(300
				(self style: 41)
			)
			(410
				(if (IsFlag 11)
					(self setScript: sWhereIsShe)
				else
					(HandsOff)
					(self setScript: sFromDoor)
				)
			)
			(170
				(gEgo init: y: 130)
			)
			(200 0)
			(else
				(gEgo posn: 160 140)
			)
		)
		(gEgo init:)
		(flasher init: stopUpd: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(quikiSign cycleSpeed: global101 setCycle: Fwd init:)
		(billionSign init:)
		(reflection cycleSpeed: global101 setCycle: Fwd init:)
		(bigFountain cycleSpeed: global101 setCycle: Fwd init:)
		(smallFountain cycleSpeed: global101 setCycle: Fwd init:)
		(flasherOpenSFX init:)
		(flasherCloseSFX init:)
		(super init:)
		(fountainSFX init: play:)
		(self setRegions: 700) ; sidewalk
		(doors init: stopUpd:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (== (flasher cel:) 0) (gEgo inRect: 250 130 300 140))
				(flasher setCycle: End flasher)
				(flasherOpenSFX play:)
			)
			((and (== (flasher cel:) 3) (not (gEgo inRect: 250 130 300 140)))
				(flasher setCycle: Beg flasher)
				(flasherCloseSFX play:)
			)
		)
	)
)

(instance sEnterDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0)
				(doors setCycle: End self)
				(gTheMusic3 number: 801 play:)
			)
			(1
				(gEgo setMotion: MoveTo 217 125 self)
			)
			(2
				(gTheMusic3 number: 802 play:)
				(doors setCycle: Beg self)
			)
			(3
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance sFromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doors cel: 3)
				(gEgo posn: 217 125 setMotion: MoveTo 217 135 self)
			)
			(1
				(gTheMusic3 number: 802 play:)
				(doors setCycle: Beg self)
			)
			(2
				(doors stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sWhereIsShe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doors cel: 3)
				(gEgo posn: 217 125 setMotion: MoveTo 217 135 self)
			)
			(1
				(doors setCycle: Beg self)
			)
			(2
				(Print 400 0 #at -1 20) ; ""Hey, where did she go??" you think?"
				(doors stopUpd:)
				(gEgo view: 811 setLoop: 0 setCel: 10 setCycle: End self)
			)
			(3
				(NormalEgo 2)
				(= cycles 1)
			)
			(4
				(ClearFlag 11)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sLookFlasher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(flasher x:)
							(flasher y:)
						)
						self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (!= (flasher cel:) 0)
					(Print 400 1) ; "Wait, it's not a guy in a trench coat! It's two midgets in a trench coat!! And, they have nothing to hide. What a town!"
				else
					(Print 400 2) ; "It's a guy wearing a trench coat."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fountainSFX of Sound
	(properties
		number 301
		loop -1
	)
)

(instance flasherOpenSFX of Sound
	(properties
		number 400
	)
)

(instance flasherCloseSFX of Sound
	(properties
		number 401
	)
)

(instance doors of Prop
	(properties
		x 216
		y 128
		description {the doors}
		sightAngle 40
		lookStr {"Through these doors walk the finest suckers in the world!"}
		view 400
		loop 4
		signal 16384
		cycleSpeed 1
	)

	(method (cue)
		(super cue:)
		(HandsOff)
		(gCurRoom setScript: sEnterDoor)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gEgo setMotion: PolyPath 217 131 self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bigFountain of Prop
	(properties
		x 78
		y 126
		description {the chapel fountain}
		sightAngle 40
		lookStr {Between the Casino and the Quiki-Wed Chapel a lovely fountain gurgles gently in this good night. Above it, a pair of cherubs frolic in a tasteful sculpture.}
		view 400
		loop 2
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 400 3) ; "You get a quick thrill by leaning over the gurgling waters to grab a little feel of sculpture!"
			)
			(11 ; Taste/Smell
				(Print 400 4) ; "You wonder if they sell reproductions of these fountains in the casino's gift shop?"
			)
			(10 ; Zipper
				(Print 400 5) ; "Did you ever think you may drink too much fluid?"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance smallFountain of Prop
	(properties
		x 9
		y 189
		description {the small fountain}
		sightAngle 40
		lookStr {Most of that fountain is in the next scene.}
		view 400
		loop 3
		priority 15
		signal 16
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance quikiSign of Prop
	(properties
		x 210
		y 40
		description {the Quiki-Wed sign}
		sightAngle 40
		lookStr {How romantic -- "Over 1 Billion Served!"}
		view 400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance billionSign of Feature
	(properties
		x 220
		y 128
		z 92
		nsTop 8
		nsLeft 170
		nsBottom 65
		nsRight 270
		description {the Quiki-Wed sign}
		sightAngle 40
		lookStr {How romantic -- "Over 1 Billion Served!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance reflection of Prop
	(properties
		x 78
		y 93
		description {the chapel fountain}
		view 400
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(bigFountain doVerb: theVerb invItem)
	)
)

(instance flasher of Person
	(properties
		x 276
		y 143
		description {the flasher}
		sightAngle 40
		approachX 251
		approachY 131
		view 402
		signal 16384
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(HandsOff)
				(gCurRoom setScript: sLookFlasher)
			)
			(5 ; Talk
				(if (!= (flasher cel:) 0)
					(Print 400 6) ; "Say," you ask them. "By any chance, are either of you two named `Shorty?'"
				else
					(Print 400 7) ; "You greet the stranger in the trench coat."
					(Print 400 8) ; ""Hey, Sonny! Come over here!!" he replies."
				)
				(Points 92 1)
			)
			(3 ; Do
				(Print 400 9 #at -1 120) ; "Gitchur hands off'n me!"
				(Print 400 9 #at -1 160) ; "Gitchur hands off'n me!"
			)
			(4 ; Inventory
				(Printf 400 10 ((Inv at: invItem) description:)) ; ""Hey, Sonny! Why don'chu jes' keep %s?" he says, ungratefully."
			)
			(10 ; Zipper
				(Print 400 11 #at -1 120) ; "Hey!"
				(Print 400 12 #at -1 160) ; "Who's the real weird-o around here?"
			)
			(11 ; Taste/Smell
				(Print 400 13) ; "You're sorry you asked to smell that trench coat!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

