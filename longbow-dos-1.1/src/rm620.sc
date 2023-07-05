;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use Osc)
(use PolyPath)
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
	rm620 0
	fenMonkVerb 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 4] = [1620 35 1 0]
	[local20 9] = [1620 7 2 1 2 1 2 2 0]
	[local29 4] = [1620 37 1 0]
	[local33 4] = [1620 22 1 0]
	[local37 4] = [1620 23 1 0]
	[local41 4] = [1620 24 1 0]
	[local45 4] = [1620 25 1 0]
	[local49 4] = [1620 26 1 0]
	[local53 4] = [1620 27 1 0]
	[local57 9] = [1620 28 1 1 1 1 1 1 0]
	[local66 4] = [1620 34 1 0]
	[local70 4] = [1620 38 1 0]
	[local74 4] = [1620 39 1 0]
	[local78 4] = [1620 42 1 0]
	[local82 4] = [1620 44 1 0]
	[local86 4] = [1620 45 1 0]
	[local90 4] = [1620 46 1 0]
	[local94 4] = [1620 47 1 0]
	[local98 4] = [1620 48 1 0]
	[local102 4] = [1620 49 1 0]
	[local106 4] = [1620 50 1 0]
	[local110 6] = [1620 14 1 2 2 0]
	[local116 4] = [1620 17 1 0]
	[local120 6] = [1620 18 1 2 2 0]
	[local126 4] = [1620 21 1 0]
	[local130 4] = [1620 51 1 0]
	[local134 4] = [1620 52 1 0]
	[local138 4] = [1620 53 1 0]
	[local142 7]
	[local149 7] = [141 270 49 233 244 122 33]
	[local156 7] = [178 156 179 183 167 170 169]
	[local163 18] = [42 0 2 4 24 41 23 29 29 57 0 2 4 33 28 31 35 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		((= [local142 temp0] (wave new:))
			x: [local149 temp0]
			y: [local156 temp0]
			init:
		)
	)
)

(instance rm620 of Rm
	(properties
		picture 620
		style 10
		south 610
	)

	(method (init)
		(super init:)
		(dieSound init:)
		(splashSound init:)
		(LoadMany rsVIEW 57 805 620 19 587 22 16)
		(= local15 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 145 319 189 210 134 188 132 175 132 105 112 105 126 135 126 135 132 96 135 53 132 5 133 8 150 107 156 153 143 186 154 0 172
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 92 139 129 136 134 145 94 153
					yourself:
				)
		)
		(if (not (IsFlag 0))
			(localproc_0)
		)
		(AddToFeatures
			bench
			reedsLeft
			reedsRight
			chainLeft
			chainRight
			gate
			entrance
			walls
			waters
		)
		((ScriptID 625 1) view: 620 loop: 4 cel: 0 posn: 141 124 init:) ; chip
		(cond
			((== gPrevRoomNum 630)
				(gSFX number: 581 loop: -1 play:)
				(gRgnMusic number: 585 loop: -1 play:)
				((ScriptID 625 1) view: 47 loop: 3 posn: 159 132) ; chip
				(gEgo setScript: backInside)
			)
			((OneOf gPrevRoomNum 610 700)
				(if (== gDisguiseNum 6) ; fens monk
					(gEgo setScript: glideIn)
				else
					(gEgo setScript: oops)
				)
			)
			(else
				(gEgo loop: 7 posn: 180 140 actions: wierdDoVerb init:)
				(NormalEgo)
			)
		)
	)

	(method (doit)
		(if (== (mod (++ local1) 5) 0)
			(Palette palANIMATE 226 255 -1)
		)
		(cond
			((gEgo script:) 0)
			((and (< (gEgo distanceTo: (ScriptID 625 1)) 20) (== local0 0)) ; chip
				(gEgo setScript: closeToGuard)
			)
			((<= (gEgo y:) 120)
				(gEgo setScript: egoToMap)
			)
			((& (gEgo onControl: 1) $0004)
				(gEgo setScript: getInBoat)
			)
			((& (gEgo onControl: 1) $0002)
				(gEgo setScript: moveAway)
			)
			((== global115 2)
				(= local9 1)
				(gEgo setScript: kinkyKill)
			)
			((Monastery backFromJewels:)
				(gTheIconBar disable: 5)
				(gEgo setScript: walkIntoMon)
			)
			((IsFlag 149)
				(gEgo setScript: wrongGemDeath)
			)
			(else
				(super doit: &rest)
			)
		)
	)

	(method (dispose)
		(gEgo actions: 0)
		(if (gCast contains: monk1)
			(monk1 dispose:)
		)
		(= gUseSortedFeatures local15)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance wierdDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 5) ; pipe
				(if (== local8 1)
					(Say 1620 54 1) ; "I've annoyed this Monk enough and I have yet to find a way past him."
				else
					(= local8 1)
					(gEgo setScript: blowHard)
					1
				)
			)
		)
	)
)

(instance fenMonkVerb of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(Say 1620 13 1) ; "The Monk blocks my way. Clearly I must somehow pass him to enter the Monastery."
			)
			(5
				(cond
					((== gPrevRoomNum 630)
						(Converse @local29 @local163 0) ; "I've told you, you can't leave without permission of the Prior and that's all there is to it."
					)
					((and (not (gEgo has: 5)) (== local7 0)) ; pipe
						(Converse 2 @local120 8 0 @local163 1) ; "Surely the token I've given will satisfy you."
						(= local7 1)
					)
					((and (not (gEgo has: 5)) (== local7 1)) ; pipe
						(Converse @local126 @local163 0) ; "Cease arguing! I must have all the tokens or you will not pass."
					)
					((== local5 0)
						(Converse 2 @local110 8 0 @local163 1) ; "I have business inside. Let me pass."
						(= local5 1)
					)
					(else
						(Converse @local116 @local163 0) ; "Nothing but the tokens will serve to make me stand aside, Brother."
					)
				)
			)
			(3
				(if local2
					(gEgo setScript: kinkyKill)
				else
					(= local2 1)
					(Converse @local37 @local163 0) ; "Touch me again and you're a dead man."
				)
			)
			(4
				(switch param2
					(0
						(Converse @local41 @local163 0) ; "You cannot buy your way past me, Brother."
					)
					(2
						(Converse @local45 @local163 0) ; "This is not one of the riddle stones. Be sure you turn it over to the Prior....IF I let you pass."
					)
					(14
						(Converse @local49 @local163 0) ; "This is not one of the riddle stones. Be sure you turn it over to the Prior....IF I let you pass."
					)
					(10
						(= local9 1)
						(gEgo setScript: kinkyKill)
					)
					(5
						(gEgo put: 5) ; pipe
						(Converse @local53 @local163 0) ; "This is the first token. I await the rest."
					)
					(6
						(if (gEgo has: 5) ; pipe
							(Converse @local66 @local163 0) ; "This is not the order of things, Brother. I must have the first token before you present this."
						else
							(gEgo setScript: riddleScript)
						)
					)
				)
			)
			(else
				(gDoVerbCode doit: param1 &rest)
			)
		)
	)
)

(instance entrance of Feature
	(properties
		x 150
		y 140
		nsTop 1
		nsLeft 117
		nsBottom 130
		nsRight 184
		sightAngle 90
	)
)

(instance walls of Feature
	(properties
		x 159
		nsBottom 139
		nsRight 319
		sightAngle 90
		lookStr 1 ; "It would take a well-equipped army to lay siege to walls such as these."
	)
)

(instance waters of Feature
	(properties
		x 159
		y 189
		sightAngle 90
		lookStr 2 ; "May the Blessed Lady protect us from this foul water."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 166 15 166 46 158 82 158 83 162 130 163 144 155 149 156 157 152 144 147 148 145 169 151 169 157 186 179 265 163 258 147 251 142 319 139 319 189 0 189
			yourself:
		)
		(super init:)
	)
)

(instance bench of Feature
	(properties
		x 111
		y 129
		nsTop 129
		nsLeft 94
		nsBottom 147
		nsRight 128
		sightAngle 90
		lookStr 3 ; "I suppose even these fighting Monks like to sit down now and then."
	)
)

(instance chainLeft of Feature
	(properties
		x 124
		y 150
		lookStr 4 ; "The gate is raised and lowered by heavy chains."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 124 31 128 31 188 150 183 150
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance chainRight of Feature
	(properties
		x 242
		y 143
		lookStr 4 ; "The gate is raised and lowered by heavy chains."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 172 32 175 32 245 141 242 143
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance reedsLeft of Feature
	(properties
		x 77
		y 166
		lookStr 5 ; "It's nothing but swamp grass."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 142 18 136 56 136 93 141 99 147 132 142 156 150 147 157 139 157 128 163 82 161 77 157 45 158 16 166 0 165
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance reedsRight of Feature
	(properties
		x 138
		y 143
		lookStr 5 ; "It's nothing but swamp grass."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 207 132 242 122 319 122 319 138 254 143
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance gate of Feature
	(properties
		x 183
		y 145
		lookStr 6 ; "The gate which locks this door is lowered to serve as a landing as well."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 124 133 182 128 256 145 258 150 183 159 123 138
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance aroundTheGuard of Feature ; UNUSED
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 120 116 163 111 174 126 133 126
			yourself:
		)
		(super init:)
	)
)

(instance wave of Prop
	(properties
		view 620
		loop 1
		signal 16384
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

(instance monk1 of Actor
	(properties
		x 117
		y 187
		view 585
		loop 1
		signal 16384
		moveSpeed 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1620 41 1) ; "Everything in the Monk's bearing warns me that he is suspicious of me."
			)
			(3 ; Do
				(= local3 1)
				(gEgo setScript: getInBoat)
			)
			(5 ; Talk
				(Converse @local78 11 0) ; "Contemplate the virtues of silence, Brother."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(= local10 1)
						(self setScript: turnAndFace self)
					)
					(2 ; halfHeart
						(= local11 1)
						(self setScript: turnAndFace self)
					)
					(14 ; amethyst
						(self setScript: turnAndFace self)
						(= local12 1)
					)
					(5 ; pipe
						(= local13 1)
						(self setScript: turnAndFace self)
					)
					(10 ; fireRing
						(= local9 1)
						(gEgo setScript: getInBoat)
					)
					(6 ; gems
						(= local14 1)
						(self setScript: turnAndFace self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBoat of Actor
	(properties
		x 88
		y 167
		lookStr 36 ; "Aye, it's a boat."
		view 21
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(= local3 1)
			(gEgo setScript: getInBoat)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance whichOne of Actor
	(properties
		x 80
		y 7
		priority 12
		signal 18448
		moveSpeed 12
	)
)

(instance backInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 113 114
					actions: wierdDoVerb
					init:
					setMotion: MoveTo 142 125 self
				)
				(NormalEgo)
			)
			(1
				(= ticks 24)
			)
			(2
				(Converse @local20 8 @local163 self) ; "What do you seek, Brother?"
			)
			(3
				(gEgo setMotion: MoveTo 113 114 self)
			)
			(4
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance egoToMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 113 114 self)
			)
			(1
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance glideIn of Script
	(properties)

	(method (doit)
		(gEgo
			x: (+ (theBoat x:) 52)
			y: (+ (theBoat y:) 22)
			setPri: (+ (theBoat priority:) 4)
			ignoreActors: 1
		)
		(monk1
			x: (+ (theBoat x:) 29)
			y: (+ (theBoat y:) 20)
			setPri: (+ (theBoat priority:) 5)
			ignoreActors: 1
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 19
					setLoop: 2
					setCel: 0
					posn: 135 187
					actions: wierdDoVerb
					init:
				)
				(monk1 setCycle: End init:)
				(theBoat
					setCel: 0
					setLoop: 0
					ignoreActors: 1
					init:
					setMotion: MoveTo 177 142 self
				)
			)
			(1
				(dockSound play:)
				(gEgo setScript: getOutBoat)
				(self dispose:)
			)
		)
	)
)

(instance getOutBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 229 164
					ignoreActors: 1
					setCycle: End self
				)
			)
			(1
				(NormalEgo 7 16 17)
				(gEgo
					posn: 216 143
					setCycle: Walk
					setMotion: MoveTo 200 140 self
				)
			)
			(2
				(if (== global115 2)
					(= local9 1)
					(gEgo setScript: kinkyKill)
				else
					(self cue:)
				)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 4 5)
				(self dispose:)
			)
		)
	)
)

(instance getInBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 216 143 self)
			)
			(1
				(gEgo setLoop: 0 setCel: 3)
				(= ticks 6)
			)
			(2
				(gEgo view: 19 posn: 229 164 setCycle: End self)
			)
			(3
				(if (or (== local6 1) (== local4 1) (== local9 1))
					(gEgo setScript: murderHim)
				else
					(= ticks 6)
				)
			)
			(4
				(if (== local3 1)
					(Converse @local70 11 0) ; "What possesses you, Brother? I've just brought you here. Please get out."
					(= local4 1)
				)
				(= local6 1)
				(gEgo setScript: getOutBoat)
			)
		)
	)
)

(instance oops of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 351 20)
				(HandsOff)
				(= register (Random 0 9))
				(gEgo
					view: 587
					loop: 0
					cel: 0
					x: 20
					y: 166
					signal: (| (gEgo signal:) $1000)
					init:
					setCycle: Osc 2
					setMotion: MoveTo 204 166 self
				)
			)
			(1
				(Converse @local16 @local163 0 self) ; "Brothers, it's an outlaw! Kill him!"
			)
			(2
				(whichOne
					view: 620
					loop: (if (== register 3) 5 else 3)
					init:
					setMotion: JumpTo 189 125 self
				)
			)
			(3
				(whichOne setMotion: JumpTo 186 168)
				(gEgo
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 1)
					setCycle: End self
				)
				(dieSound number: (if (== register 3) 351 else 20) play:)
			)
			(4
				(if (== register 3)
					(whichOne setCycle: Fwd)
				)
				(= seconds 5)
			)
			(5
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance murderHim of Script
	(properties)

	(method (doit)
		(gEgo x: (+ (theBoat x:) 52) y: (+ (theBoat y:) 22))
		(monk1 x: (+ (theBoat x:) 29) y: (+ (theBoat y:) 20))
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk1 ignoreActors: 1 setCycle: Beg)
				(theBoat
					ignoreActors: 1
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 162 152 self
				)
			)
			(1
				(gEgo setScript: monkSwings)
			)
		)
	)
)

(instance monkSwings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk1
					view: 585
					posn: 188 168
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(dieSound play:)
				(gEgo view: 22 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
			)
			(2
				(splashSound play:)
				(gEgo setCycle: End self)
			)
			(3
				(cond
					((== local4 1)
						(= gDeathNum 19)
						(Converse @local33 11 0 self) ; "Some people never listen."
					)
					((== local9 1)
						(= gDeathNum 20)
						(Converse @local98 @local163 0 self) ; "Quick thinking, Brother? No thief can escape from us."
					)
					(else
						(= gDeathNum 35)
						(Converse @local74 @local163 0 self) ; "Good work, Brother! I thought he behaved too oddly to be one of us."
					)
				)
			)
			(4
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance moveAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(= ticks 6)
			)
			(1
				(Say 1620 40) ; "Nothing under heaven would convince me to step into this murky water and drown."
				(cond
					((< (gEgo x:) 120)
						(if (< (gEgo y:) 110)
							(gEgo
								setMotion:
									PolyPath
									(+ (gEgo x:) 10)
									(+ (gEgo y:) 10)
									self
							)
						else
							(gEgo
								setMotion:
									PolyPath
									(+ (gEgo x:) 10)
									(- (gEgo y:) 10)
									self
							)
						)
					)
					((< (gEgo y:) 110)
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 10)
								(+ (gEgo y:) 10)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 10)
								(- (gEgo y:) 10)
								self
						)
					)
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 4 5)
				(self dispose:)
			)
		)
	)
)

(instance kinkyKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						PolyPath
						(+ ((ScriptID 625 1) x:) 5) ; chip
						(+ ((ScriptID 625 1) y:) 10) ; chip
						self
				)
			)
			(1
				(if local9
					(Converse @local102 @local163 0 self) ; "You were a fool to wear that ring here, thief! The Abbot wants you dead and he shall get his wish."
					(= gDeathNum 20)
				else
					(= gDeathNum 19)
					(Converse @local33 @local163 0 self) ; "Some people never listen."
				)
			)
			(2
				((ScriptID 625 1) ; chip
					view: 585
					loop: 0
					cel: 0
					x: 151
					y: 129
					setCycle: End self
				)
			)
			(3
				(dieSound number: 588 play:)
				(gEgo view: 22 setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance blowHard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 3 0) self) ; pipeIt
			)
			(1
				(Converse @local106 11 0 self) ; "Are you daft? You have no cause to blow the reed here."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 4 5)
				(self dispose:)
			)
		)
	)
)

(instance riddleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 6) ; gems
				(Converse @local57 @local163 0 self) ; "I accept your tokens, Brother. Now, you must prove your knowledge of the lore of the gemstones."
			)
			(1
				((ScriptID 621 0) doit:) ; gems_room
				(self dispose:)
			)
		)
	)
)

(instance wrongGemDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local130 @local163 2 self) ; "Bad choice, stranger, whoever you were."
			)
			(1
				(gEgo setMotion: PolyPath 152 137 self)
			)
			(2
				((ScriptID 625 1) ; chip
					view: 585
					loop: 0
					cel: 1
					setCycle: CT 2 1 self
				)
			)
			(3
				((ScriptID 625 1) setCycle: CT 3 1 self) ; chip
			)
			(4
				(dieSound number: 588 play:)
				(gEgo
					view: 22
					loop: 1
					cel: 0
					posn: 160 135
					setCycle: CT 4 1 self
				)
			)
			(5
				(gCurRoom style: 10)
				(= ticks 6)
			)
			(6
				(= gDeathNum 21)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance walkIntoMon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local134 @local163 2 self) ; "Welcome in, Brother."
			)
			(1
				((ScriptID 625 1) ; chip
					view: 16
					setCycle: Walk
					setMotion:
						PolyPath
						(- ((ScriptID 625 1) x:) 30) ; chip
						((ScriptID 625 1) y:) ; chip
						self
				)
			)
			(2
				(Face (ScriptID 625 1) gEgo self) ; chip
			)
			(3
				(gEgo setMotion: PolyPath 151 115 self)
			)
			(4
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance closeToGuard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(SetMessageColor 29)
				(gEgo setMotion: 0)
				(Converse 1 @local138 11 0 self) ; "Stand back. You may not pass unitl you've proven yourself to be one of us."
			)
			(1
				(SetMessageColor 0)
				(gEgo setMotion: PolyPath 200 140 self)
			)
			(2
				(Face gEgo (ScriptID 625 1) self) ; chip
			)
			(3
				(HandsOn)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance turnAndFace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo monk1)
				(= ticks 30)
			)
			(1
				(cond
					((== local10 1)
						(Converse @local82 11 0) ; "I cannot take it. You must turn over all money to the Prior."
						(= local10 0)
					)
					((== local11 1)
						(Converse @local86 11 0) ; "Something that precious must be given to the Prior."
						(= local11 0)
					)
					((== local12 1)
						(Converse @local86 11 0) ; "Something that precious must be given to the Prior."
						(= local12 0)
					)
					((== local13 1)
						(Converse @local90 11 0) ; "Why should you give this to me?"
						(= local13 0)
					)
					((== local14 1)
						(Converse @local94 11 0) ; "How do you expect to enter without this?"
						(= local14 0)
					)
				)
			)
			(2
				(= ticks 30)
				(self dispose:)
			)
		)
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

(instance splashSound of Sound
	(properties
		flags 1
		number 930
	)
)

(instance dockSound of Sound
	(properties
		flags 1
		number 23
	)
)

