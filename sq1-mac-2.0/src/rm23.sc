;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm23 0
)

(instance rm23 of SQRoom
	(properties
		lookStr {This appears to be the thoracic area of the spinal column of this meatless beast. Other than an obviously defective vertebra, you've got more sand and crud.}
		picture 23
		horizon 20
		north 20
		east 24
		south 26
		west 22
		walkOffTop 1
	)

	(method (init)
		(if (== global166 2)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 172 7 165 26 169 6 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 96 189 105 181 158 174 171 179 257 163 245 146 211 140 206 132 258 113 281 80 319 75 319 189
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 78 289 68 291 57 281 59 260 53 248 46 251 42 229 40 227 43 224 45 170 45 133 51 116 50 107 45 37 57 25 63 0 63 0 0 319 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 0 189 0 74 47 71 88 60 155 59 221 58 272 69 319 102
						yourself:
					)
			)
			(LoadMany rsVIEW 14 123 423 328)
			(LoadMany rsSOUND 408 407)
		)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(HandsOn)
			)
			(west
				(= style 12)
				(HandsOn)
			)
			(south
				(= style 14)
				(HandsOn)
			)
			(north
				(= style 13)
				(HandsOn)
			)
			(else
				(= style 10)
			)
		)
		(gEgo init:)
		(self setRegions: 704) ; keronaRegion
		(super init:)
		(bridge init: stopUpd:)
		(breaks init: cel: global182 stopUpd:)
		(if (IsFlag 56)
			(pod setPri: 0 loop: 2 cel: 1 posn: 91 170)
		)
		(if (not (IsFlag 57))
			(pod init: stopUpd:)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((and (== global166 1) (gEgo inRect: 61 52 68 72))
				(self setScript: bridgeBreaks)
			)
		)
		(super doit:)
	)
)

(instance bridgeBreaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bridge startUpd:)
				(gSoundEffects number: 408 loop: 1 play:)
				(breaks startUpd: cel: (++ global182))
				(= cycles 6)
			)
			(1
				(= register (gEgo loop:))
				(gEgo
					view: 14
					setLoop: (if (< 180 (gEgo heading:) 360) 1 else 2)
					cel: 0
					setCycle: CT 3 1
					setMotion: MoveFwd 14
				)
				(bridge y: 59)
				(breaks y: 59)
				(gEgo cel: 2)
				(= cycles 3)
			)
			(2
				(bridge y: 57)
				(breaks y: 57)
				(gEgo cel: 3)
				(= cycles 3)
			)
			(3
				(bridge y: 58)
				(breaks y: 58)
				(gEgo cel: 1)
				(= cycles 3)
			)
			(4
				(bridge y: 57)
				(breaks y: 57)
				(gEgo cel: 2)
				(= cycles 6)
			)
			(5
				(if (== global182 3)
					(client setScript: bridgeFalls)
				else
					(bridge stopUpd:)
					(breaks stopUpd:)
					(NormalEgo 0 1 61)
					(gEgo setPri: 14 loop: register)
					(gEgo setMotion: MoveFwd 32 self)
				)
			)
			(6
				(switch global182
					(1
						(Print 23 0) ; "I'd say that the widening of those cracks is an excellent indication that this thing is not a truly stable unit. And don't you hate the way it makes your brain bounce around like a handball in all that spare cranial space?"
					)
					(2
						(Print 23 1) ; "No doubt about it! There's going to be an accident (of one kind or another) on this shaky piece of calcium-rich matter."
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bridgeFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(breaks dispose:)
				(gSoundEffects number: 363 loop: 1 play:)
				(bridge
					setLoop: 4
					setCycle: End
					setMotion: MoveTo 67 101 bridge
				)
				(gEgo
					cel: 0
					setStep: 5 15
					setCycle: End
					setMotion: MoveTo 68 189 self
				)
			)
			(1
				(gSoundEffects number: 407 loop: 1 play:)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(2
				(EgoDead 948 0 0 23 2) ; "You've always got to push things to the limit, don't you? We warned you, but NO! YOU had to do it just one more time. Well, just wait 'til your father gets home!"
			)
		)
	)
)

(instance egoPushesPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 97 62
					view: 14
					setLoop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				(pod hide:)
				(gEgo setCycle: CT 6 1 self)
			)
			(2
				(pod show: setLoop: 1 cel: 0 setCycle: Fwd posn: 85 101)
				(gEgo setCycle: End)
				(if
					(and
						((ScriptID 704 3) inThisRoom:) ; spider
						((ScriptID 704 3) inRect: 70 160 120 205) ; spider
					)
					(client setScript: splatSpider)
				else
					(pod setMotion: MoveTo 91 170 self)
				)
			)
			(3
				(gSoundEffects number: 407 loop: 1 play:)
				(NormalEgo 0 1 61)
				(gEgo loop: 2 setPri: 14 heading: 180)
				(pod
					ignoreActors:
					setPri: 0
					cel: 0
					setLoop: 2
					setCycle: End self
				)
			)
			(4
				(pod stopUpd:)
				(SetFlag 56)
				(= seconds 5)
			)
			(5
				(Print 23 3) ; "If nothing else, it makes a pleasant thud."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance splatSpider of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 704 3) setMotion: MoveTo 94 183) ; spider
				(pod setMotion: MoveTo 94 125 self)
			)
			(1
				(gSoundEffects number: 407 loop: 1 play:)
				(NormalEgo 0 1 61)
				(gEgo loop: 2 setPri: 14 heading: 180)
				(pod hide:)
				((ScriptID 704 3) dispose:) ; spider
				(spiderBody init: stopUpd:)
				(spiderLegs init: setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(gSoundEffects number: 411 loop: 1 play:)
				(spiderLegs
					cycleSpeed: 30
					view: 328
					loop: 0
					cel: 0
					setCycle: End self
				)
				(spiderBody dispose:)
			)
			(3
				(gLongSong fade:)
				(SetFlag 57)
				(ClearFlag 55)
				(SetScore 5 148)
				(= global181 0)
				(spiderLegs dispose:)
				(= seconds 2)
			)
			(4
				(Print 23 4) ; "It was not known that you are a master of the protrusion toss! That was a fine effort."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bridge of Actor
	(properties
		x 59
		y 57
		description {bone bridge}
		lookStr {This genetically defective vertebra looks like it would be intolerant to much load bearing.}
		yStep 14
		view 123
		cel 2
		priority 13
		signal 18448
		cycleSpeed 4
		xStep 5
		moveSpeed 4
	)

	(method (cue)
		(gLongSong2 number: 412 loop: 1 play:)
	)
)

(instance breaks of Prop
	(properties
		x 59
		y 58
		z 1
		description {breaks}
		lookStr {What started out at one time as mere hairline fractures are now clearly cracks in the imperfect vertebral module.}
		view 123
		loop 3
		priority 13
		signal 16400
		cycleSpeed 4
	)
)

(instance pod of Actor
	(properties
		x 97
		y 62
		description {strange plant pod}
		approachX 97
		approachY 60
		yStep 6
		view 123
		priority 15
		signal 16
		cycleSpeed 6
		moveSpeed 2
	)

	(method (init)
		(super init: &rest)
		(cond
			((and (== global166 1) (not (IsFlag 56)))
				(self approachVerbs: 3 12) ; Do, Smell
				(= approachX 97)
				(= approachY 63)
			)
			((and (== global166 2) (IsFlag 56))
				(self approachVerbs: 12) ; Smell
				(= approachX 101)
				(= approachY 153)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 56)
					(Print 23 5) ; "It's the snapped spinal protrusion you dislodged - resulting in its present position on the sand."
				else
					(Print 23 6) ; "It must be a snapped spinal protrusion just sitting here, without, as yet, having succumbed to the nearly unresistable attraction of gravity."
				)
			)
			(3 ; Do
				(cond
					((IsFlag 56)
						(Print 23 7) ; "You've done all the relocation of this thing that your limited physique is capable of."
					)
					((!= global166 1)
						(Print 23 8) ; "I'll bet that if you COULD reach it from here, you WOULD pull that sucker down on your very own head."
					)
					(else
						(self approachVerbs:)
						(gCurRoom setScript: egoPushesPod)
					)
				)
			)
			(12 ; Smell
				(cond
					((IsFlag 56)
						(if (== global166 1)
							(Print 23 9) ; "Hmm. It smells like a smashed vertebral protrusion. Of course, you're not a leading expert on the subject, so you might want a second opinion."
						else
							(Print 23 10) ; "Hmm. It smells like a vertebral protrusion you once knew."
						)
					)
					((!= global166 1)
						(Print 23 11) ; "Not much to report aurally."
					)
					(else
						(Print 23 12) ; "Gee! I thought everybody knew what sun-dried gigundasaurus bone smelled like."
					)
				)
			)
			(11 ; Taste
				(Print 23 13) ; "It would be like licking a dehydrated peach pit."
			)
			(5 ; Talk
				(Print 23 14) ; "The only talking ribs you'll ever see are in fast-food commercials."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spiderBody of View
	(properties
		x 95
		y 182
		view 423
		loop 4
	)
)

(instance spiderLegs of Prop
	(properties
		x 95
		y 182
		view 423
		loop 5
		cel 3
		signal 16384
		cycleSpeed 3
	)
)

