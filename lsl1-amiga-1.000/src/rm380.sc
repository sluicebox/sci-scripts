;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	[local0 2]
	local2 = 1
	local3
	local4
	[local5 37] = [0 0 159 136 0 1 159 136 0 2 159 136 0 3 154 114 0 4 150 105 0 5 144 94 0 6 138 92 0 6 129 111 0 7 141 133 -32768]
	[local42 5] = [0 8 133 134 -32768]
	[local47 29] = [4 1 117 153 4 2 121 150 4 3 125 147 4 4 129 144 4 5 133 141 4 6 137 138 4 7 144 134 -32768]
	[local76 33] = [6 0 118 154 6 1 124 151 6 2 130 149 6 3 136 146 6 4 142 144 6 5 148 141 6 6 154 139 6 7 159 136 -32768]
)

(procedure (JetsOn)
	(= local2 1)
	(= local4 1)
	(aEve setLoop: 0 x: 85 y: 125 setCycle: Fwd)
	(if (== (gEgo view:) 381)
		(gEgo setLoop: 1 setCel: 0 setCycle: Fwd)
	)
	(gTheMusic2 number: 380 loop: -1 vol: 127 flags: 1 play:)
	(rimJet1 cycleSpeed: global101 setCycle: Fwd init:)
	(rimJet2 cycleSpeed: global101 setCycle: Fwd init:)
	(rimJet3 cycleSpeed: global101 setCycle: RandCycle init:)
	(aJet cycleSpeed: global101 setCycle: RandCycle init:)
	(bJet cycleSpeed: global101 setCycle: RandCycle init:)
	(cJet cycleSpeed: global101 setCycle: RandCycle init:)
	(dJet cycleSpeed: global101 setCycle: RandCycle init:)
	(eJet cycleSpeed: global101 setCycle: RandCycle init:)
)

(procedure (JetsOff)
	(= local2 6)
	(= local4 6)
	(aEve setLoop: 2 x: 85 y: 125 stopUpd:)
	(gTheMusic2 stop:)
	(if (== (gEgo view:) 381)
		(gEgo setLoop: 2 setCel: 0 setCycle: 0)
	)
	(rimJet1 dispose:)
	(rimJet2 dispose:)
	(rimJet3 dispose:)
	(aJet dispose:)
	(bJet dispose:)
	(cJet dispose:)
	(dJet dispose:)
	(eJet dispose:)
)

(instance rm380 of LLRoom
	(properties
		picture 380
	)

	(method (init)
		(LoadMany rsVIEW 381 382 380)
		(LoadMany rsSOUND 381 380)
		(if (not (IsFlag 6)) ; fEveHasApple
			(Load rsSOUND 384)
			(Load rsVIEW 803)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 0 203 -3 203 81 68 81 48 95 54 114 129 114 165 141 166 158 163 163 319 111
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 108 172 108 148 91 319 73
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 92 122 92 122 97 88 97
					yourself:
				)
		)
		(gEgo actions: egoActions)
		(gEHead actions: egoActions)
		(aEve
			cycleSpeed: global101
			moveSpeed: global101
			setCycle: Fwd
			approachVerbs: 3 4 10 11 5 2 ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
			init:
		)
		(if (== gPrevRoomNum 385)
			(larryClothes init: stopUpd:)
			(gEgo
				view: 381
				egoSpeed: (* 2 global101)
				setLoop: 1
				z: 0
				posn: 120 139
				init:
			)
			(if (IsFlag 17) ; fJetsOff
				(JetsOff)
			else
				(JetsOn)
			)
			(if (IsFlag 6) ; fEveHasApple
				(aEve
					cycleSpeed: (* 2 global101)
					moveSpeed: (* 2 global101)
					setLoop: 1
					setCel: 0
					posn: 84 126
				)
				(gTheMusic send: 3 78 1 send: 7 78 0 send: 10 78 0)
				(HandsOff)
				(gCurRoom setScript: sEveLeaves)
			else
				(gTheMusic send: 4 78 1 send: 9 78 1 send: 5 78 0)
			)
		else
			(if (IsFlag 17) ; fJetsOff
				(JetsOff)
			else
				(JetsOn)
			)
			(if (IsFlag 4) ; fDollFlies
				(aDoll cycleSpeed: global101 moveSpeed: global101 init:)
				(gEgo posn: 231 113)
				(gCurRoom setScript: sFlyingDoll)
			else
				(self setScript: sFromLivingroom)
			)
		)
		(towel init: stopUpd: approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
		(fStatue init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(fSpaButton init: approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
		(fHotels init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(fHotTub init:)
		(fLivingRoom init:)
		(fWaterfall init:)
		(gEgo init:)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (== local4 local2)
			(= local4 0)
			(Palette palANIMATE 64 71 -1)
		else
			(++ local4)
		)
		(cond
			(script)
			((and (gEgo mover:) (== (gEgo view:) 381))
				(HandsOff)
				(gCurRoom setScript: sGetDressed)
			)
			((SteppedOn gEgo 2)
				(if (< (gEgo y:) 100)
					(HandsOff)
					(self setScript: sToLivingroom)
				else
					(gCurRoom newRoom: 360)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 380 0) ; "An expansive rooftop garden bathes in the moonlight, while a luscious woman bathes in the nude!"
				(Print 380 1) ; "You can't believe your eyes. She's the girl of your dreams."
				(Print 380 2 #at -1 140) ; "(She's even wet!)"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb)
		(if (or (== theVerb 3) (== theVerb 10)) ; Do, Zipper
			(cond
				((not (IsFlag 2)) ; fComeOnIn
					(Print 380 3) ; "As much as you'd like to get undressed and join that young lady in her hot tub, you haven't been invited yet."
					(Print 380 4 #at -1 140) ; "(And you know about hotel security...)"
				)
				((not (IsFlag 7)) ; fEveKnowsLarry
					(Print 380 5) ; "Perhaps if you introduced yourself to her first..."
				)
				((!= (gEgo view:) 381)
					(gCurRoom setScript: sUndress)
					(return 1)
				)
				(else
					(gCurRoom setScript: sGetDressed)
					(return 1)
				)
			)
		)
	)
)

(instance sUndress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 75)
					(self dispose:)
				else
					(gEgo setMotion: PolyPath 159 136 self)
				)
			)
			(1
				(HandsOff)
				(Print 380 6) ; "Glancing around, you notice no changing facilities nearby. Oh, what the hell...."
				(gEgo
					egoSpeed: (+ 1 global101)
					view: 803
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(larryClothes init:)
				(= local3 1)
				(gEgo
					view: 381
					setLoop: 0
					setPri: 10
					setCel: 0
					setCycle: MCyc @local5 self
				)
			)
			(4
				(= local3 0)
				(sfxSplash play: self)
			)
			(5
				(gEgo
					view: 381
					setLoop: 0
					setPri: 10
					setCel: 7
					setCycle: MCyc @local42 self
				)
			)
			(6
				(gEgo view: 381 setPri: -1 x: 120 y: 139)
				(if (IsFlag 17) ; fJetsOff
					(gEgo setLoop: 2 setCel: 0 setCycle: 0)
				else
					(gEgo setLoop: 1 setCycle: Fwd)
				)
				(= seconds 3)
			)
			(7
				(Print 380 7) ; "Wasting no time, you execute your previously only pre-visualized spa hop, landing in the warm water. Oooh, does it feel good! It's nearly as stimulating as the beautiful naked woman next to you. With the warmth of the water soaking into your body, you quickly become quite relaxed."
				(fHotels approachVerbs: 0)
				(fStatue approachVerbs: 0)
				(fSpaButton approachVerbs: 0)
				(aEve approachVerbs: 0)
				(towel approachVerbs: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetDressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 381 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(1
				(gEgo
					egoSpeed: (+ 1 global101)
					view: 381
					setCycle: MCyc @local76 self
				)
			)
			(2
				(larryClothes dispose:)
				(gEgo
					view: 803
					setLoop: 1
					setCel: 255
					posn: 159 136
					setCycle: Beg self
				)
			)
			(3
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(4
				(HandsOn)
				(NormalEgo 3)
				(fSpaButton approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
				(fStatue approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
				(aEve approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
				(fHotels approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
				(towel approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
				(self dispose:)
			)
		)
	)
)

(instance sEveLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aEve setLoop: 1 setCel: 0 posn: 84 126 setCycle: CT 3 1 self)
			)
			(1
				(towel dispose:)
				(aEve setCycle: End self)
			)
			(2
				(aEve
					setLoop: 3
					setCel: 0
					cycleSpeed: global101
					moveSpeed: global101
					posn: 96 121
					setCycle: Walk
					setMotion: PolyPath 166 118 self
				)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo
					egoSpeed:
					cycleSpeed: global101
					moveSpeed: global101
					setLoop: 4
					setCel: 0
					posn: 117 153
					setCycle: MCyc @local47 self
				)
			)
			(5 0)
			(6
				(Print 380 8 #at -1 20) ; "Say, Larry!" smiles Eve, "You really ARE glad to see me!"
				(aEve setMotion: PolyPath 241 105)
				(= cycles 8)
			)
			(7
				(gEgo
					egoSpeed:
					setLoop: 5
					setCycle: Walk
					setMotion: PolyPath 230 113 self
				)
			)
			(8
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sToLivingroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 106)
					(gEgo setMotion: PolyPath 186 86 self)
				else
					(gEgo setMotion: PolyPath 240 110 self)
				)
			)
			(1
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sFromLivingroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 116)
					(gEgo posn: 186 84 setMotion: PolyPath 140 95 self)
				else
					(gEgo posn: 231 113 setMotion: PolyPath 205 120 self)
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sFlyingDoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(aDoll setCycle: Fwd setMotion: MoveTo -20 90)
				(gEgo egoSpeed: global101 setMotion: PolyPath 170 131 self)
			)
			(1
				(aDoll setMotion: MoveTo -35 90)
				(gTheMusic3 fade: self)
			)
			(2
				(NormalEgo 1)
				(HandsOn)
				(UnLoad 128 373)
				(UnLoad 132 372)
				(ClearFlag 4) ; fDollFlies
				(aDoll dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sfxSplash of Sound
	(properties
		flags 1
		number 384
	)
)

(instance aEve of Actor
	(properties
		x 85
		y 125
		description {Eve}
		sightAngle 40
		approachX 148
		approachY 128
		view 382
	)

	(method (doVerb theVerb)
		(if (== (gEgo view:) 381)
			(HandsOn)
			(gCurRoom newRoom: 385)
			(return)
		)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 2) ; fComeOnIn
						(Print 380 9) ; "You ask yourself, "Why am I standing here when I was invited into a spa with a woman like her?""
					)
					((IsFlag 7) ; fEveKnowsLarry
						(Print 380 10) ; "Hey, handsome, why don't you slip into the water with me, so we can REALLY get to know each other!"
						(Print 380 11 #at -1 140) ; "(Was she talking to you, Larry?)"
						(SetFlag 2) ; fComeOnIn
					)
					(else
						(Print 380 12) ; "A beautiful black woman relaxes in the penthouse suite's rooftop garden's spa. You begin to get the feeling that your evening in Lost Wages may be successful after all!"
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 2) ; fComeOnIn
						(Print 380 13) ; "Yes, of course I'd like to join you," you stammer. "In fact, I can think of nothing I'd like better!"
						(Print 380 14 #at -1 140) ; ""(If I could only figure out how to take off these clothes)," you think."
					)
					((IsFlag 7) ; fEveKnowsLarry
						(Print 380 15) ; "Well, uh," you stutter, "I've always felt it is a look that's right for me. `A man has to do what a man has to do,' I always say."
						(Print 380 16) ; "She smiles up at you, "I agree completely. I'm so tired of men who wear or say anything just to gain a woman's favors!""
						(Print 380 17) ; "Gee," you think, "I would never do that!"
						(Print 380 18) ; "To her, you say with a smile, "And I so love what YOU are wearing!""
						(Print 380 19) ; "She laughs, "And, a sense of humor! Larry, you are one special man. Why don't you slip into the water and we'll see if we can REALLY get to know each other!""
						(SetFlag 2) ; fComeOnIn
					)
					(else
						(Print 380 20) ; "Hey, Gorgeous! Allow me to introduce myself," you say. "My name is Larry; Larry Laffer."
						(Print 380 21) ; "Hello, yourself, Larry," she replies. "What an attractive leisure suit--I so miss them! It's refreshing to meet a man with so much self-confidence that he's willing to flaunt the fickle trends of fashion mores and deeply travel the road of his own secure masculinity."
						(Print 380 11 #at -1 140) ; "(Was she talking to you, Larry?)"
						(SetFlag 7) ; fEveKnowsLarry
					)
				)
			)
			(3 ; Do
				(Print 380 22) ; "There's not much you can do from out here."
			)
			(else
				(Print 380 23) ; "Perhaps if you establish eye contact first..."
			)
		)
	)
)

(instance aDoll of Actor
	(properties
		x 143
		y 95
		yStep 5
		view 373
		priority 8
		signal 16
		xStep 7
	)
)

(instance aJet of Prop
	(properties
		x 59
		y 147
		description {the jet}
		sightAngle 40
		view 380
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 380 24) ; "You wonder if there's any way to turn off those bubbles!"
			)
			(else
				(Print 380 25) ; "Doesn't that water look inviting?"
			)
		)
	)
)

(instance bJet of Prop
	(properties
		x 61
		y 166
		description {the bubble}
		sightAngle 40
		view 380
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance cJet of Prop
	(properties
		x 79
		y 156
		description {the bubbles}
		sightAngle 40
		view 380
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance dJet of Prop
	(properties
		x 101
		y 164
		description {the bubbles}
		sightAngle 40
		view 380
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance eJet of Prop
	(properties
		x 99
		y 148
		description {the bubbles}
		sightAngle 40
		view 380
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance rimJet1 of Prop
	(properties
		x 50
		y 127
		description {the bubbles}
		sightAngle 40
		view 380
		loop 1
		priority 7
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance rimJet2 of Prop
	(properties
		x 52
		y 126
		description {the bubbles}
		sightAngle 40
		view 380
		loop 2
		priority 7
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance rimJet3 of Prop
	(properties
		x 117
		y 131
		description {the bubbles}
		sightAngle 40
		view 380
		loop 3
		priority 7
		signal 16400
		detailLevel 4
	)

	(method (doVerb theVerb invItem)
		(aJet doVerb: theVerb invItem &rest)
	)
)

(instance towel of View
	(properties
		x 78
		y 109
		description {the towel}
		sightAngle 40
		approachX 80
		approachY 105
		lookStr {Behind her rests an expensive fluffy bath towel.}
		view 382
		loop 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance larryClothes of View
	(properties
		x 159
		y 136
		description {your leisure suit}
		lookStr {It's a good thing polyester doesn't wrinkle.}
		view 803
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== (gEgo view:) 381)
					(gCurRoom setScript: sGetDressed)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance fSpaButton of Feature
	(properties
		x 105
		y 189
		z 71
		nsTop 110
		nsLeft 98
		nsBottom 123
		nsRight 113
		description {the button}
		sightAngle 40
		approachX 101
		approachY 117
		lookStr {There's some sort of control button built into the surface of the spa's decking.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 17) ; fJetsOff
					(ClearFlag 17) ; fJetsOff
					(JetsOn)
					(Print 380 26) ; "Because you are such a wimp, you turn the bubblers back on."
				else
					(SetFlag 17) ; fJetsOff
					(JetsOff)
					(Print 380 27) ; "You coyly "happen" to step on the spa bubbler control switch."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fHotels of Feature
	(properties
		x 112
		y 49
		z 90
		nsTop 33
		nsLeft 59
		nsBottom 66
		nsRight 166
		description {the hotels}
		sightAngle 40
		approachX 84
		approachY 81
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 380 28) ; "Looking over at the next hotel, you see a window with its drapes wide open."
				(Print 380 29) ; "Say, look at that. There's an ugly girl getting undressed."
				(Print 380 30) ; "She's not really very pretty."
				(Print 380 31) ; "Well, she's not bad."
				(Print 380 32) ; "You know, she's looking better."
				(Print 380 33) ; "Say, she's pretty good."
				(Print 380 34) ; "Perhaps you could ignore some of her faults."
				(Print 380 35) ; "You may be in love!"
				(Print 380 36) ; "You ARE in love!"
				(Print 380 37) ; "Well, at least you're in lust!"
				(Print 380 38) ; "Pant, pant, pant, pant, pant."
			)
			(else
				(Print 380 39) ; "Say, what's that in that hotel window across the way?"
			)
		)
	)
)

(instance fStatue of Feature
	(properties
		x 112
		y 52
		nsTop 7
		nsLeft 79
		nsBottom 97
		nsRight 145
		description {the sculpture}
		sightAngle 40
		onMeCheck 4096
		approachX 126
		approachY 106
		lookStr {Look! Hooters on a stick!}
	)
)

(instance fHotTub of Feature
	(properties
		x 72
		y 146
		nsTop 124
		nsBottom 169
		nsRight 145
		description {the hot tub}
		sightAngle 40
		lookStr {The hot tub looks so warm and inviting.}
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 3) (== theVerb 10)) ; Do, Zipper
			(egoActions doVerb: theVerb invItem &rest)
			(return)
		)
		(switch theVerb
			(5 ; Talk
				(aEve doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fLivingRoom of Feature
	(properties
		x 258
		y 77
		nsTop 34
		nsLeft 204
		nsBottom 121
		nsRight 312
		description {the penthouse living room}
		sightAngle 40
		lookStr {You were in that very same living room only moments ago.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fWaterfall of Feature
	(properties
		x 160
		y 192
		nsTop 130
		nsBottom 191
		nsRight 319
		description {the waterfall}
		sightAngle 40
		onMeCheck 16
		lookStr {A lovely waterfall cascades down lava rockwork through a mass of exotic flora.}
	)
)

