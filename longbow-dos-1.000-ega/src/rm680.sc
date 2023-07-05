;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	[local0 2]
	[local2 2] = [206 49]
	[local4 2] = [144 117]
	[local6 2] = [6 7]
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	[local18 4] = [1680 0 1 0]
	[local22 5] = [1680 24 1 2 0]
	[local27 4] = [1680 27 1 0]
	[local31 4] = [1680 28 1 0]
	[local35 4] = [1680 29 1 0]
	[local39 4] = [1680 31 1 0]
	[local43 4] = [1680 32 1 0]
	[local47 5] = [1680 34 1 2 0]
	[local52 4] = [1680 38 1 0]
	[local56 4] = [1680 39 1 0]
	[local60 4] = [1680 41 1 0]
	[local64 4] = [1680 42 1 0]
	[local68 4] = [1680 43 1 0]
	[local72 6] = [1680 44 2 1 2 0]
	[local78 4] = [1680 47 2 0]
	[local82 4] = [1680 49 2 0]
	[local86 4] = [1680 30 1 0]
	local90
)

(procedure (localproc_0)
	(cogito setCycle: Fwd)
	(SetMessageColor 32)
	(Say &rest 80 {Cogito} 67 160 142)
)

(procedure (localproc_1)
	(cogito setCycle: Beg)
	(SetMessageColor 0)
)

(procedure (localproc_2)
	(vocalis setCycle: Fwd)
	(SetMessageColor 32)
	(Say &rest 80 {Vocalis} 67 160 142)
)

(procedure (localproc_3)
	(vocalis setCycle: Beg)
	(SetMessageColor 0)
)

(procedure (localproc_4)
	(hilaris setCycle: Fwd)
	(SetMessageColor 32)
	(Say &rest 80 {Hilaris} 67 160 142)
)

(procedure (localproc_5)
	(hilaris setCycle: Beg)
	(SetMessageColor 0)
)

(procedure (localproc_6 &tmp temp0)
	(for ((= temp0 0)) (< temp0 2) ((++ temp0))
		((= [local0 temp0] (wave new:))
			x: [local2 temp0]
			y: [local4 temp0]
			loop: [local6 temp0]
			init:
		)
	)
)

(instance rm680 of Rm
	(properties
		picture 680
		north 690
		east 630
		south 630
	)

	(method (init)
		(LoadMany rsSCRIPT 939 991)
		(LoadMany rsVIEW 22 620 15 19 20 585 674)
		(if (not (IsFlag 0))
			(localproc_6)
		)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 207 189 207 186 276 171 319 179 319 183 282 176 273 180 267 177 216 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 147 276 146 228 153 166 127 121 135 84 123 73 133 68 139 47 152 14 153 106 189 0 189
					yourself:
				)
		)
		(gSFX number: 581 loop: -1 play:)
		(gRgnMusic number: 24 loop: -1 play:)
		(cogito init:)
		(ineptus init:)
		(vocalis init:)
		(hilaris init:)
		(waterGate init:)
		(AddToFeatures malitia ieiunus deformis mooringPost water everything)
		(if (== (Monastery firstTimeEnter:) 0)
			(Monastery firstTimeEnter: 1)
			(fulk init:)
			(theBoat init:)
			(thePole init:)
			(NormalEgo)
			(gEgo posn: 95 182 loop: 3 cel: 0 init:)
			(gEgo setScript: stepInBoat)
		else
			(fulk
				view: 674
				setLoop: 5
				setCel: 0
				setPri: 10
				signal: 16
				x: 154
				y: 173
				init:
			)
			(theBoat
				view: 21
				setLoop: 1
				setCel: 1
				setPri: 6
				signal: 16
				posn: 177 157
				init:
			)
			(NormalEgo)
			(gEgo posn: 95 182 setPri: 10 signal: 16 loop: 3 cel: 0 init:)
			(thePole posn: 120 161 setPri: 8 init:)
			(gEgo setScript: (ScriptID 681 0)) ; talky
		)
		(gTheIconBar disable: 5)
	)

	(method (doit)
		(++ local10)
		(if (and (> (gGame detailLevel:) 2) (== (mod local10 5) 0))
			(Palette palANIMATE 225 255 -1)
		)
		(cond
			(
				(and
					(not local90)
					(or
						(and (Monastery waterDie:) (not local13))
						(and (== global115 2) (not local13))
					)
				)
				(= local90 1)
				local17
				(theBoat setMotion: 0)
				(gEgo setMotion: 0)
				(Monastery waterDie: 0)
				(gEgo setScript: monkKillBoat)
			)
			(
				(and
					(not local90)
					(not local9)
					(or (Monastery waterDie:) (== global115 2))
				)
				(= local90 1)
				local17
				(theBoat setMotion: 0)
				(gEgo setMotion: 0)
				(waterGate setCycle: 0)
				(Monastery waterDie: 0)
				(gEgo setScript: timesUp)
			)
			((gEgo script:) 0)
			(local13
				(cond
					((& (gEgo onControl: 1) $0004)
						(gEgo setScript: moveAway)
					)
					((& (gEgo onControl: 1) $0010)
						(gEgo setScript: egoDock)
					)
				)
			)
			((and (& (gEgo onControl: 1) $0002) (not local13))
				(gEgo setScript: egoGetsInBoat)
			)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				local13
				(== gTheCursor 2)
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(cond
				((and (ineptus onMe: event) (== local11 2))
					(event claimed: 1)
					(= local11 3)
					(gEgo setScript: raiseTheGrate)
				)
				((and (ieiunus onMe: event) (== local11 1))
					(event claimed: 1)
					(= local11 2)
					(gCurRoom setScript: (ScriptID 681 1)) ; youGotIeiunus
				)
				((and (cogito onMe: event) (== local11 0))
					(event claimed: 1)
					(= local11 1)
					(gCurRoom setScript: (ScriptID 681 3)) ; youGotCogito
				)
				(else
					(= local11 0)
					(if local13
						(cond
							((ineptus onMe: event)
								(event claimed: 1)
								(gCurRoom setScript: (ScriptID 681 2)) ; youGotIneptus
							)
							((ieiunus onMe: event)
								(event claimed: 1)
								(gCurRoom setScript: (ScriptID 681 1)) ; youGotIeiunus
							)
						)
					else
						0
					)
				)
			)
			(super handleEvent: event)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(DisposeScript 991)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance water of Feature
	(properties
		x 52
		y 110
		lookStr 20 ; "It looks deep enough to drown in."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 52 115 67 110 114 126 139 126 164 118 201 124 197 131 238 140 271 135 319 144 319 179 274 171 209 189 181 189 126 172 99 170 72 162 58 161 58 156 33 149 59 134
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance everything of Feature
	(properties
		x 160
		nsBottom 189
		nsRight 319
		sightAngle 180
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1680 21 1) ; "This small, secret dock has been built right into the massive walls of the fortress."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mooringPost of Feature
	(properties
		x 262
		y 184
		lookStr 22 ; "The mooring post is used to secure boats to the dock."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 262 178 274 173 270 168 276 164 280 167 277 171 290 176 273 184
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance malitia of Feature
	(properties
		x 20
		y 112
		approachX 87
		approachY 126
		lookStr 10 ; "What a malicious looking gargoyle this is."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gCurRoom setScript: (ScriptID 681 4)) ; youGotMalitia
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(switch local12
					(0
						(SetMessageColor 32)
						(Say 1680 11 80 {Malitia} 67 160 142) ; "You are as stupid as a sackful of hammers."
						1
						(SetMessageColor 0)
					)
					(1
						(SetMessageColor 32)
						(Say 1680 13 80 {Malitia} 67 160 142) ; "You have the brains of a bowl of porridge."
						1
						(SetMessageColor 0)
					)
					(2
						(SetMessageColor 32)
						(Say 1680 14 80 {Malitia} 67 160 142) ; "You are a vast pile of cow manure."
						1
						(SetMessageColor 0)
					)
				)
				(if (> (++ local12) 2)
					(= local12 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 20 82 42 80 54 91 54 99 43 111 24 112 14 104 13 91
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance ieiunus of Feature
	(properties
		x 106
		y 79
		approachX 126
		approachY 131
		lookStr 16 ; "This gargoyle has a lean and hungry look."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 106 33 109 45 118 44 137 68 115 71 110 77 106 79 95 71 90 59 93 46
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gCurRoom setScript: (ScriptID 681 1)) ; youGotIeiunus
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1680 17 80 {Ieiunus} 67 160 142) ; "If I were not stone, I would leap from here and devour you. You look delicious."
				1
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance deformis of Feature
	(properties
		x 111
		y 127
		approachX 126
		approachY 131
		lookStr 18 ; "What a particularly hideous gargoyle."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 111 100 139 100 149 117 141 125 117 127 108 115
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gCurRoom setScript: (ScriptID 681 7)) ; youGotDeformis
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1680 19 80 {Deformis} 67 160 142) ; "Do not look upon me! I am utterly deformed. A curse upon the stonecutter who gave me such a face!"
				1
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance cogito of Prop
	(properties
		x 36
		y 145
		approachX 69
		approachY 134
		lookStr 1 ; "This gargoyle has a thoughtful look."
		view 681
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(Say 1680 52 1) ; "This gargoyle may have shifted slightly at my touch, but it may have been a trick of the water."
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(gEgo setScript: cogitoTalks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ineptus of Prop
	(properties
		x 46
		y 78
		approachX 69
		approachY 134
		lookStr 4 ; "This is a foolish looking gargoyle."
		view 681
		loop 1
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gEgo setScript: viciouslyPullTongue)
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1680 5 80 {Ineptus} 67 160 142) ; "Duhhhh....garsh...what was the question?"
				1
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vocalis of Prop
	(properties
		x 80
		y 65
		approachX 87
		approachY 126
		lookStr 6 ; "Quite a mouth on that gargoyle."
		view 681
		loop 2
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gCurRoom setScript: (ScriptID 681 5)) ; youGotVocalis
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(gEgo setScript: vocalisTalks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hilaris of Prop
	(properties
		x 125
		y 95
		approachX 126
		approachY 131
		lookStr 8 ; "I'd say this gargoyle was sculpted by someone with a sense of humour."
		view 681
		loop 3
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if local13
					(gCurRoom setScript: (ScriptID 681 6)) ; youGotHilaris
				else
					(Say 1680 57 1) ; "I can't reach it from here."
				)
			)
			(5 ; Talk
				(gEgo setScript: hilarisTalks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterGate of Prop
	(properties
		x 72
		y 65
		view 681
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local15 0)
					(= local15 1)
					(gEgo setScript: askTheDwarf)
				else
					(Say 1680 36 1) ; "The metal grate is heavy, made of solid iron."
				)
			)
			(3 ; Do
				(Say 1680 37 1) ; "I can tell from here that I couldn't possibly raise that grate by force."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wave of Prop
	(properties
		view 681
		priority 1
		signal 16400
		cycleSpeed 18
		detailLevel 2
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance theBoat of Actor
	(properties
		x 231
		y 177
		lookStr 23 ; "It's a shallow draft boat, exactly the same as the one which brought me here."
		view 21
		loop 1
		cel 1
		priority 4
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(if local13
				(super doVerb: theVerb &rest)
			else
				(gEgo setScript: egoGetsInBoat)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (and local13 (not (gEgo script:)))
			(if (gEgo mover:)
				(self posn: (+ (gEgo x:) 68) (- (gEgo y:) 10))
			)
		else
			(super doit:)
		)
	)
)

(instance fulk of Actor
	(properties
		x 277
		y 189
		view 671
		loop 1
		cel 1
		signal 16384
	)

	(method (doit)
		(if (and local13 (not (gEgo script:)))
			(if (gEgo mover:)
				(self posn: (+ (gEgo x:) 45) (+ (gEgo y:) 6))
			)
		else
			(super doit:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo setScript: lookAtFulk)
			)
			(3 ; Do
				(Converse @local27 (Monastery tFULK:) 0 self) ; "Even though this boat terrifies me, I'll not leave it until we reach the shore of these fens."
			)
			(5 ; Talk
				(Converse @local31 (Monastery tFULK:) 0 self) ; "Please, let's leave at once! It's bad enough I must get in this flimsy boat."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (> (gMoney doit:) 0)
							(gEgo setScript: giveFulkMoney)
						)
					)
					(2 ; halfHeart
						(Converse @local86 (Monastery tFULK:) 0 self) ; "You are too generous. I could not take such a gift."
					)
					(14 ; amethyst
						(Converse @local39 (Monastery tFULK:) 0 self) ; "I am right fond of amethyst. Thank you."
						(gEgo put: 14) ; amethyst
					)
					(17 ; handScroll
						(Converse @local43 (Monastery tFULK:) 0 self) ; "You risked too much for that scroll to give it to me."
					)
				)
			)
		)
	)
)

(instance killMonk of Actor
	(properties
		x 124
		y 225
		view 128
		loop 3
		signal 16384
	)
)

(instance theRock of Actor
	(properties
		x 85
		y 9
		view 620
		loop 3
		priority 10
		signal 18448
		illegalBits 0
	)
)

(instance thePole of Actor
	(properties
		x 175
		y 181
		view 19
		loop 5
		priority 5
		signal 16384
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gEgo setScript: egoGetsInBoat)
		)
	)
)

(instance thePrior of Actor
	(properties
		x 119
		y 225
		view 641
		loop 4
		signal 16384
	)
)

(instance viciouslyPullTongue of Script
	(properties)

	(method (init)
		(gEgo setPri: (+ (theBoat priority:) 4) signal: 2064)
		(fulk setPri: (+ (theBoat priority:) 4) signal: 16)
	)

	(method (doit)
		(gEgo x: (- (theBoat x:) 68) y: (+ (theBoat y:) 10) cel: 0)
		(fulk x: (- (theBoat x:) 23) y: (+ (theBoat y:) 16))
		(theBoat setLoop: 1 setCel: 1)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (theBoat x:) 126) (== (theBoat y:) 119))
					(self cue:)
				else
					(gEgo cel: 0 cycleSpeed: 18 setCycle: CT End self)
				)
			)
			(1
				(theBoat setMotion: MoveTo 126 119 self)
			)
			(2
				(gEgo
					view: 20
					setLoop: -1
					setLoop: 2
					setCel: 1
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 585
					setLoop: 2
					setCel: 0
					signal: (| (gEgo signal:) $0800)
				)
				(Say 1680 40 self) ; "Odd, this gargoyle's tongue feels a trifle loose, but nothing happens when I pull upon it."
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance stepInBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(thePole setPri: 5 signal: 16)
				(fulk
					view: 674
					illegalBits: 0
					setLoop: 3
					setCel: 0
					posn: 204 193
					moveSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(1
				(fulk
					setLoop: 5
					posn: 213 193
					setPri: (+ (theBoat priority:) 4)
					setCel: 4
					setCycle: CT 0 -1 self
				)
			)
			(2
				(Converse @local52 (Monastery tFULK:) 0 self) ; "Please let's go at once. As soon as they discover I'm gone, they'll come looking for us."
			)
			(3
				(gEgo setScript: fulkBoat)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsInBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri: 12
					signal: 16400
					setMotion: MoveTo 105 173 self
				)
			)
			(1
				(gEgo view: 19 setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(thePole dispose:)
				(gEgo posn: 101 167 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo
					view: -1
					view: 585
					setLoop: 2
					setCel: 0
					posn: 103 167
					illegalBits: 0
					setPri: (+ (theBoat priority:) 1)
				)
				(= ticks 6)
			)
			(4
				(fulk
					posn: (- (theBoat x:) 23) (+ (theBoat y:) 16)
					signal: 16384
				)
				(gEgo
					loop: 2
					illegalBits: 0
					posn: (- (theBoat x:) 68) (+ (theBoat y:) 10)
					setCel: 0
					setPri: 6
					setCycle: End self
				)
			)
			(5
				(theBoat
					setLoop: 1
					setCel: 1
					signal: (| (theBoat signal:) $0800)
				)
				(= ticks 6)
			)
			(6
				(= local13 1)
				(if (== local14 1)
					(= local14 0)
					(Converse @local56 8 0 self) ; "For a famous outlaw, you're rather indecisive."
				)
				(gEgo setScript: toTheGate)
				(self dispose:)
			)
		)
	)
)

(instance toTheGate of Script
	(properties)

	(method (doit)
		(gEgo
			x: (- (theBoat x:) 68)
			y: (+ (theBoat y:) 10)
			setPri: (+ (theBoat priority:) 4)
			signal: 2064
		)
		(fulk
			x: (- (theBoat x:) 23)
			y: (+ (theBoat y:) 16)
			setPri: (+ (theBoat priority:) 4)
			signal: 16
		)
		(theBoat setLoop: 1 setCel: 1)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fulk posn: (- (theBoat x:) 23) (+ (theBoat y:) 16))
				(gEgo
					code: egoCode
					posn: (- (theBoat x:) 68) (+ (theBoat y:) 10)
				)
				(theBoat
					illegalBits: 0
					xStep: 2
					yStep: 2
					setMotion:
						MoveTo
						(+ (theBoat x:) 10)
						(- (theBoat y:) 15)
						self
				)
			)
			(1
				(theBoat
					setPri: 4
					signal: (| (theBoat signal:) $0010)
					setMotion: MoveTo 141 121 self
				)
				(gEgo
					view: 585
					setLoop: 2
					cel: 0
					setPri: -32768
					signal: (| (gEgo signal:) $0810)
					setCycle: End
				)
				(= local16 1)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance split of Script
	(properties)

	(method (doit)
		(gEgo
			x: (- (theBoat x:) 68)
			y: (+ (theBoat y:) 10)
			setPri: (theBoat priority:)
			signal: 18448
			illegalBits: 0
		)
		(fulk
			x: (- (theBoat x:) 23)
			y: (+ (theBoat y:) 16)
			setPri: (theBoat priority:)
			signal: 16400
			illegalBits: 0
		)
		(theBoat setPri: 1 signal: (| (theBoat signal:) $4010) illegalBits: 0)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local9 1)
				(SetScore 100)
				(gEgo setCycle: End self)
			)
			(1
				(fulk posn: (- (theBoat x:) 23) (+ (theBoat y:) 16))
				(gEgo cel: 0 posn: (- (theBoat x:) 68) (+ (theBoat y:) 10))
				(theBoat setMotion: MoveTo 107 106 self)
			)
			(2
				(gCurRoom newRoom: 690)
			)
		)
	)
)

(instance fulkBoat of Script
	(properties)

	(method (doit)
		(fulk
			x: (- (theBoat x:) 23)
			y: (+ (theBoat y:) 16)
			setPri: (+ (theBoat priority:) 4)
			signal: 16
		)
		(thePole x: (- (theBoat x:) 57) y: (+ (theBoat y:) 4))
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(thePole setPri: 5 signal: 16)
				(theBoat
					setLoop: 1
					setCel: 1
					moveSpeed: 6
					setMotion: MoveTo 177 157 self
				)
			)
			(1
				(Face gEgo fulk self)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance raiseTheGrate of Script
	(properties)

	(method (doit)
		(gEgo
			x: (- (theBoat x:) 68)
			y: (+ (theBoat y:) 10)
			cel: 0
			setPri: (+ (theBoat priority:) 4)
			signal: 2064
		)
		(fulk
			x: (- (theBoat x:) 23)
			y: (+ (theBoat y:) 16)
			setPri: (+ (theBoat priority:) 4)
			signal: 16
		)
		(theBoat setLoop: 1 setCel: 1)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (theBoat x:) 130) (== (theBoat y:) 119))
					(self cue:)
				else
					(theBoat setMotion: MoveTo 130 119 self)
				)
			)
			(1
				(gEgo setScript: blowTheJoint)
			)
		)
	)
)

(instance blowTheJoint of Script
	(properties)

	(method (dispose)
		(secretSound dispose:)
		(gateSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ineptus setCycle: End)
				(gEgo
					view: 20
					setLoop: -1
					setLoop: 4
					setCel: 1
					setCycle: CT 3 1 self
				)
			)
			(1
				(secretSound play:)
				(= cycles 2)
			)
			(2
				(Say 1680 55 self) ; "Ah! Now I've found the means to loosen this fool's tongue!"
			)
			(3
				(Say 1680 56) ; "And this is the hidden counterweight to raise the grate!"
				(waterGate setCycle: End self)
				(gateSound play:)
			)
			(4
				(gEgo
					view: 585
					setLoop: 2
					setCel: 0
					signal: (| (gEgo signal:) $0800)
					setScript: split
				)
				(gateSound stop:)
				(self dispose:)
			)
		)
	)
)

(instance moveAway of Script
	(properties)

	(method (doit)
		(theBoat
			x: (+ (gEgo x:) 68)
			y: (- (gEgo y:) 10)
			setPri: (theBoat priority:)
			signal: 18448
			illegalBits: 0
		)
		(fulk
			x: (+ (gEgo x:) 45)
			y: (+ (gEgo y:) 6)
			setPri: (theBoat priority:)
			signal: 16400
			illegalBits: 0
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local60 (Monastery tFULK:) 0) ; "There's only a wall here. The water goes no further. Please, return to the gate and let's leave at once!"
				(gEgo
					cel: 0
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(HandsOn)
				(= local8 0)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance egoDock of Script
	(properties)

	(method (doit)
		(theBoat
			x: (+ (gEgo x:) 68)
			y: (- (gEgo y:) 10)
			setPri: (theBoat priority:)
			signal: 18448
			illegalBits: 0
		)
		(fulk
			x: (+ (gEgo x:) 45)
			y: (+ (gEgo y:) 6)
			setPri: (theBoat priority:)
			signal: 16400
			illegalBits: 0
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Converse @local64 (Monastery tFULK:) 0 self) ; "There's no safety anywhere else! We must escape through this grate or they'll kill us."
			)
			(1
				(gEgo
					cel: 0
					setCycle: End
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(2
				(HandsOn)
				(= local8 0)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance timesUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local13
					(gEgo setScript: priorKillBoat self)
				else
					(gEgo setScript: monkKillDock self)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance monkKillDock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(killMonk
					init:
					setCycle: Walk
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 10)
						self
				)
			)
			(1
				(Face killMonk gEgo self)
			)
			(2
				(Converse @local68 11 self) ; "I thought I might find you here!"
			)
			(3
				(killMonk view: 585 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(dieSound number: 588 play:)
				(gEgo view: 22 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(5
				(if (= global115 2)
					(= gDeathNum 20)
					(gCurRoom newRoom: 170) ; robinDeath
				else
					(EgoDead 680 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance monkKillBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(killMonk
					init:
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(1
				(Converse @local68 11 8 self) ; "I thought I might find you here!"
			)
			(2
				(killMonk view: 585 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(dieSound number: 588 play:)
				(gEgo view: 22 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(4
				(if (= global115 2)
					(= gDeathNum 20)
					(gCurRoom newRoom: 170) ; robinDeath
				else
					(EgoDead 680 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance priorKillBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(thePrior init: setCycle: Walk setMotion: MoveTo 116 180 self)
			)
			(1
				(Converse @local72 8 (Monastery tPRIOR:) self) ; "As I suspected, you've trapped yourself. Will you surrender or--"
			)
			(2
				(thePrior setHeading: 310 self)
			)
			(3
				(Converse @local78 8 (Monastery tPRIOR:) self) ; "Vocalis, speak!"
			)
			(4
				(SetMessageColor 32)
				(Say 1680 48 self 80 {Vocalis} 67 160 142) ; "Aye, Master."
				(SetMessageColor 0)
			)
			(5
				(Converse @local82 8 (Monastery tPRIOR:) self) ; "Call death down upon the head of yonder sinner."
			)
			(6
				(gEgo setScript: moveAndShake)
			)
		)
	)
)

(instance moveAndShake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(vocalis signal: 16384 setCycle: End self)
				(secretSound number: 19 play:)
			)
			(1
				(ShakeScreen 3)
				(= ticks 66)
			)
			(2
				(theBoat signal: 16384 illegalBits: 0)
				(gEgo signal: 16384 illegalBits: 0)
				(waterGate signal: 16384)
				(fulk signal: 16384 illegalBits: 0)
				(ineptus signal: 16384)
				(hilaris signal: 16384)
				(cogito signal: 16384)
				(vocalis signal: 16384)
				(theRock
					setLoop: 3
					setCel: 0
					x: (+ (gEgo x:) 6)
					y: (- (gEgo y:) 119)
					init:
					signal: 18432
					illegalBits: 0
					setMotion:
						JumpTo
						(+ (gEgo x:) 6)
						(- (gEgo y:) 47)
						self
				)
			)
			(3
				(dieSound number: 20 play:)
				(gEgo
					view: 22
					setLoop: -1
					setLoop: 1
					setCel: 0
					setCycle: CT 4 1
				)
				(= cycles 2)
			)
			(4
				(theRock setMotion: JumpTo (gEgo x:) (gEgo y:) self)
			)
			(5
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance askTheDwarf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local15 1)
				(Say 1680 33 self) ; "The metal grate is heavy and solid, yet there must be a way to raise it. Perhaps I should ask the dwarf."
			)
			(1
				(Converse @local47 8 (Monastery tFULK:) self) ; "Fulk, how did they raise the grate?"
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance lookAtFulk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1680 26 self) ; "He looks truly frightened, far more so than before."
			)
			(1
				(Converse @local22 8 (Monastery tFULK:) self) ; "What troubles you so, my friend? You were so brave before."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance giveFulkMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 25 96)
				(Converse @local35 (Monastery tFULK:) 0 self) ; "You are too kind. Thank you, but please, let us leave here!"
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance cogitoTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_0 1680 3 self) ; "Do not bother me. I am thinking about weighty imponderables."
			)
			(1
				(localproc_1)
				(= ticks 6)
			)
			(2
				(cogito signal: (| (cogito signal:) $0001))
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance vocalisTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_2 1680 7 self) ; "When I howl, the rocks listen and the stones obey. Beware of my Voice, for it is the Voice of Death."
			)
			(1
				(localproc_3)
				(= ticks 6)
			)
			(2
				(vocalis signal: (| (vocalis signal:) $0001))
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance hilarisTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_4 1680 9 self) ; "Hahaha...are...heheheh...are we....hah hah hooheee...are we having fun yet? Hahahaheeeeeeee...."
			)
			(1
				(localproc_5)
				(= ticks 6)
			)
			(2
				(hilaris signal: (| (hilaris signal:) $0001))
				(HandsOn)
				(gTheIconBar disable: 5 4)
				(self dispose:)
			)
		)
	)
)

(instance BackWalk of Rev
	(properties)

	(method (doit)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(instance egoCode of Code
	(properties)

	(method (doit)
		(if (gEgo mover:)
			(cond
				((gEgo script:) 0)
				(
					(and
						(< 0 (gEgo heading:) 180)
						(!= (gEgo cycler:) BackWalk)
					)
					(gEgo setCycle: BackWalk)
				)
				(
					(and
						(< 180 (gEgo heading:) 360)
						(or
							(== (gEgo cycler:) BackWalk)
							(not (gEgo cycler:))
						)
					)
					(gEgo setCycle: Walk)
				)
			)
		)
	)
)

(instance gateSound of Sound
	(properties
		flags 1
		number 673
		loop -1
	)
)

(instance dieSound of Sound
	(properties
		flags 1
	)
)

(instance secretSound of Sound
	(properties
		flags 1
		number 21
	)
)

