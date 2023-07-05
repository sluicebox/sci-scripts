;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm22 0
	skullTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 5] = [0 -7 -10 -8 999]
	[local12 3] = [0 11 999]
	[local15 3] = [0 12 999]
	[local18 4] = [0 9 13 999]
	[local22 6]
	[local28 5] = [0 -7 -10 -8 999]
)

(procedure (localproc_0) ; UNUSED
	(gMessager say: 6 0 38) ; MISSING MESSAGE
)

(instance skullTimer of Timer
	(properties)
)

(instance rm22 of Rm
	(properties
		noun 6
		picture 22
		style 0
	)

	(method (init)
		(= [local22 0] @local7)
		(= [local22 1] @local12)
		(= [local22 2] @local15)
		(= [local22 3] @local18)
		(= [local22 4] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 302 189 302 182 313 182 309 152 262 160 200 160 200 145 183 145 183 157 176 156 176 165 67 163 21 149 18 185 54 185 54 189
					yourself:
				)
		)
		(LoadMany rsVIEW 22 23 19 531 516 1022)
		(LoadMany rsSOUND 23 28 66)
		(super init:)
		(gLongSong number: 23 loop: -1 play:)
		(cond
			((IsFlag 336)
				(= global273 5)
			)
			((not (IsFlag 12))
				(= global273 0)
			)
			((not (IsFlag 290))
				(= global273 2)
			)
			((not (IsFlag 291))
				(= global273 2)
			)
			((not (IsFlag 336))
				(= global273 4)
			)
		)
		(if (not (IsFlag 173))
			(if (not (== global274 4))
				(= local2 221)
				(= local3 12)
				(feet init:)
			else
				(= local2 221)
				(= local3 109)
				(feet posn: 156 152 init:)
			)
			(hut posn: local2 local3 init:)
			(if (>= global273 5)
				(gateEyes init: setCycle: Fwd)
			)
			(skullTeller init: gate @local7 @local22 @local28)
			(gate init: actions: skullTeller approachVerbs: 4 2 27) ; Do, Talk, magicGem
		)
		(skull1 init: addToPic:)
		(skull2 init: addToPic:)
		(skull3 init: addToPic:)
		(skull4 init: addToPic:)
		(switch gPrevRoomNum
			(21
				(cond
					((< global274 3)
						(gCurRoom setScript: frogIn)
					)
					((== global274 4)
						(LoadMany rsSOUND 28)
						(hut setScript: flyAway)
					)
					(else
						(gCurRoom setScript: frogIn)
					)
				)
			)
			(else
				(self setScript: sEnterFromSouth)
			)
		)
		(skullEyes init: setScript: sRandomFlashingEyes)
		(roomF init:)
		(fence init:)
	)

	(method (dispose)
		(= global451 0)
		(super dispose:)
	)

	(method (cue)
		(if local0
			(gCurRoom newRoom: 21)
		)
		(if local1
			(= local1 0)
			(gate ignoreActors: 1 setScript: openGate)
		)
	)

	(method (newRoom newRoomNumber)
		(skullTimer dispose: delete:)
		(ClearFlag 171)
		(ClearFlag 287)
		(ClearFlag 172)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			(
				(and
					(>= (gEgo y:) 187)
					(not (== (gCurRoom script:) sExitSouth))
					(not (== (gCurRoom script:) sEnterFromSouth))
				)
				(HandsOff)
				(gCurRoom setScript: sExitSouth)
			)
			(script)
			((and (< (gEgo y:) 148) (== (hut y:) 122))
				(HandsOff)
				(ClearFlag 287)
				(ClearFlag 172)
				(= local0 1)
				(gEgo setHeading: 360 self)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Sleep
				(gMessager say: 6 52 0) ; "Now???"
			)
			(50 ; detectMagicSpell
				(gMessager say: 6 50 0) ; "The force of magic in this clearing is nearly overwhelming. The skull on the gatepost radiates magic slightly more strongly than the other skulls. The hut on chicken legs is "artifact-level" magic -- it makes your ears ring."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomF of Feature
	(properties
		x 159
		y 1
		z 100
		noun 8
		nsBottom 189
		nsRight 319
		sightAngle 40
	)
)

(instance fence of Feature
	(properties
		x 159
		y 23
		z 100
		noun 2
		nsTop 89
		nsBottom 158
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 3)
					(1
						(gMessager say: 2 1 4) ; "The sharp ends of the fence are covered with some nasty-looking green slime."
					)
					(2
						(gMessager say: 2 1 6) ; "You've seen one, you've seen them all, I say."
					)
					(3
						(gMessager say: 2 1 5) ; "Of course, most fences aren't poisoned on top!"
					)
				)
			)
			(4 ; Do
				(gMessager say: 2 4 0) ; "The green slime dripping off of the fence top makes you realize that climbing is not a good idea."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skull1 of View
	(properties
		x 100
		y 100
		noun 9
		view 23
		loop 4
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 9 1 0) ; "The skulls on top of the fence have eerily glowing eyes. The large skull on the fence seems to stare blankly at you."
		else
			(fence doVerb: theVerb &rest)
		)
	)
)

(instance skull2 of View
	(properties
		x 143
		y 101
		noun 10
		view 23
		loop 5
		priority 14
		signal 16400
	)

	(method (init)
		(= global451 123)
		(PalVary pvCHANGE_TARGET 123)
		(AssertPalette 23)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 10 1 0) ; "The skulls on top of the fence have eerily glowing eyes. The large skull on the fence seems to stare blankly at you."
		else
			(fence doVerb: theVerb &rest)
		)
	)
)

(instance skull3 of View
	(properties
		x 239
		y 108
		noun 11
		view 23
		loop 6
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 11 1 0) ; "The skulls on top of the fence have eerily glowing eyes. The large skull on the fence seems to stare blankly at you."
		else
			(fence doVerb: theVerb &rest)
		)
	)
)

(instance skull4 of View
	(properties
		x 266
		y 98
		noun 12
		view 23
		loop 7
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 12 1 0) ; "The skulls on top of the fence have eerily glowing eyes. The large skull on the fence seems to stare blankly at you."
		else
			(fence doVerb: theVerb &rest)
		)
	)
)

(instance skullEyes of Prop
	(properties
		z -2
		view 23
		priority 11
		signal 16400
	)
)

(instance dirt of Prop
	(properties
		x 191
		y 159
		view 23
		loop 1
		cel 3
		priority 4
		signal 16400
		cycleSpeed 1
	)
)

(instance gateEyes of Prop
	(properties
		x 193
		y 121
		view 23
		loop 3
		priority 10
		signal 18448
		cycleSpeed 9
	)
)

(instance feet of Actor
	(properties
		x 156
		y 56
		noun 1
		view 22
		loop 2
		priority 1
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 0) ; "Those are the biggest chicken legs you've ever seen."
			)
			(4 ; Do
				(cond
					((IsFlag 287)
						(gMessager say: 1 4 3) ; "What's to climb?"
					)
					(local4
						(gMessager say: 1 4 2) ; "You have second thoughts, and you decide not to attempt such a potentially dangerous excursion."
					)
					(else
						(gMessager say: 1 4 1) ; "You have to get there, first."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wing1 of Actor
	(properties
		yStep 4
		view 22
		loop 8
		illegalBits 0
		xStep 6
	)
)

(instance wing2 of Actor
	(properties
		yStep 4
		view 22
		loop 9
		illegalBits 0
		xStep 6
	)
)

(instance hut of Actor
	(properties
		noun 5
		yStep 4
		view 22
		priority 2
		signal 24592
		illegalBits 0
		xStep 6
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 0) ; "The hut is a strange little house perched on chicken legs."
			)
			(2 ; Talk
				(cond
					((not local4)
						(gMessager say: 5 57 2) ; "The hut does not respond while the gate is closed."
					)
					((IsFlag 287)
						(gMessager say: 5 57 3) ; "Nothing happens."
					)
					((IsFlag 172)
						(gCurRoom setScript: setAllTheWay)
					)
					(else
						(gCurRoom setScript: sHutDown1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hutDoor of Actor
	(properties
		x 189
		y 83
		noun 4
		view 22
		loop 5
		priority 3
		signal 18448
		cycleSpeed 1
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not cel)
					(gMessager say: 4 1 17) ; "The door is open, but hardly inviting."
				else
					(gMessager say: 4 1 18) ; "The door of the hut is ornately decorated."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Actor
	(properties
		x 194
		y 158
		noun 3
		approachX 191
		approachY 162
		yStep 1
		view 23
		priority 2
		signal 2064
		illegalBits 0
		xStep 1
		moveSpeed 0
	)
)

(instance skullTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if (== (= temp0 (super showDialog:)) 12)
			(SetFlag 356)
		)
		(if (and (== temp0 -8) (not (IsFlag 291)))
			(gate setScript: makeTheDeal)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local4
						(gMessager say: 3 1 2) ; "The gate's gone."
					)
					((not local4)
						(if (< global273 5)
							(gMessager say: 3 1 16) ; "The large skull on the gate seems to stare vacantly at you."
						else
							(gMessager say: 3 1 14) ; "The eyes of the large skull on the gate flash merrily away at you."
						)
					)
				)
			)
			(4 ; Do
				(if (== global273 5)
					(gMessager say: 3 4 14) ; "Right!"
					(gate setScript: openGate)
				else
					(gMessager say: 3 4 15) ; "I won't let you in until I get a gem so I can see!"
				)
			)
			(27 ; magicGem
				(SolvePuzzle 656 10)
				(gCurRoom setScript: putEyes)
			)
			(2 ; Talk
				(if (== global273 5)
					(gCurRoom setScript: boneTalk)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(37 ; greenFur
				(gMessager say: 3 37) ; "I don't need the fur. I think the 'bald look' gives me a certain distinction, don't you?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance TP of Actor
	(properties
		x 138
		y 176
		view 531
		signal 24576
	)
)

(instance tpSound of Sound
	(properties
		number 28
	)
)

(instance tromp of Sound
	(properties
		number 66
	)
)

(instance openGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(gateEyes dispose:)
				(dirt init: setCel: 0 setLoop: 1)
				(gate startUpd:)
				(gEgo startUpd:)
				(self cue:)
			)
			(1
				(dirt setCel: 1)
				(gate
					moveSpeed: 6
					ignoreActors: 1
					setMotion: MoveTo (gate x:) 210 self
				)
			)
			(2
				(dirt setCel: 2)
				(gate setMotion: MoveTo (gate x:) 220 self)
			)
			(3
				(dirt setCel: 3)
				(gate setMotion: MoveTo (gate x:) 229 self)
			)
			(4
				(= local4 1)
				(dirt setCycle: 0 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance flyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 (hut x:))
				(= local3 (hut y:))
				(wing1
					ignoreActors:
					ignoreHorizon:
					setPri: 15
					setLoop: 3
					posn: (+ local2 3) (- local3 22)
					init:
					moveSpeed: 6
					setStep: 1 1
					setCycle: Fwd
				)
				(wing2
					ignoreActors:
					ignoreHorizon:
					setPri: 15
					setLoop: 4
					posn: (- local2 72) (- local3 20)
					init:
					moveSpeed: 6
					setStep: 1 1
					setCycle: Fwd
				)
				(hutDoor dispose:)
				(hut setPri: (- (gate priority:) 1))
				(if (gCast contains: gate)
					(gate addToPic:)
				)
				(if (gCast contains: dirt)
					(dirt addToPic:)
				)
				(if (gCast contains: gateEyes)
					(gateEyes addToPic:)
				)
				(TP init: setCel: 255 setCycle: CT 3 -1 self)
			)
			(1
				(gEgo posn: 138 176 init:)
				(TP setCycle: CT 1 -1 self)
				(tpSound number: 28 init: play:)
				(Face gEgo hut)
			)
			(2
				(TP dispose:)
				(= seconds 5)
			)
			(3
				(feet
					setStep: 1 1
					setPri: (- (hut priority:) 1)
					moveSpeed: 6
					ignoreActors: 1
					ignoreControl: -32768
					setMotion: MoveTo (feet x:) -200
				)
				(= ticks 10)
			)
			(4
				(gEgo loop: 3 forceUpd:)
				(hut
					ignoreActors:
					ignoreHorizon:
					setLoop: 0
					moveSpeed: 6
					setStep: 1 1
					setMotion: MoveTo local2 -200
				)
				(wing1 setMotion: MoveTo (wing1 x:) -200)
				(wing2 setMotion: MoveTo (wing2 x:) -200)
				(= seconds 12)
			)
			(5
				(SetFlag 173)
				(ClearFlag 287)
				(gMessager say: 6 0 20 1 self) ; "There goes Baba Yaga. Now you've REALLY made her soar!"
			)
			(6
				(gCurRoom newRoom: 600) ; EndGame
			)
		)
	)
)

(instance frogIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TP init: setCel: 255 setPri: 15 setCycle: CT 4 1 self)
			)
			(1
				(TP setCel: 4 setCycle: CT 9 1 self)
				(if (>= global274 3)
					(gEgo
						view: 0
						loop: 6
						posn: 138 176
						ignoreActors: 1
						init:
					)
					(NormalEgo)
				else
					(gEgo
						view: 531
						loop: 1
						setCel: 255
						posn: 138 176
						ignoreActors: 1
						init:
					)
				)
				(tpSound number: 28 init: play:)
			)
			(2
				(TP dispose:)
				(if (>= global274 3)
					(gEgo
						view: 0
						loop: 6
						posn: 138 176
						actions: egoActions
						ignoreActors: 1
						init:
					)
					(NormalEgo)
					(self changeState: 6)
				else
					(gMessager say: 6 0 36 0 self) ; "From a distance, you hear the witch intone:"
				)
			)
			(3
				(tpSound play:)
				(gEgo setCycle: Beg self)
				(= cycles 2)
			)
			(4
				(= ticks 6)
			)
			(5
				(NormalEgo)
				(gEgo loop: 3)
				(= cycles 10)
			)
			(6
				(HandsOn)
				(switch global274
					(2
						(gMessager say: 6 0 29) ; "As you contemplate the occurrences of the last few minutes, you conclude that you'd better find a mandrake root for Baba Yaga... and fast!"
						(SetFlag 326)
						(= global109 gDay)
					)
					(3
						(gMessager say: 6 0 22) ; "What an awful creature, to turn me into a FROG!, you say to yourself. Someday, I must return the favor."
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRandomFlashingEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1
						(skullEyes
							setLoop: 4
							setCel: 1
							posn: (skull1 x:) (- (skull1 y:) 1)
						)
					)
					(2
						(skullEyes
							setLoop: 5
							setCel: 1
							posn: (skull2 x:) (- (skull2 y:) 1)
						)
					)
					(3
						(skullEyes
							setLoop: 6
							setCel: 1
							posn: (skull3 x:) (- (skull3 y:) 1)
						)
					)
					(4
						(skullEyes
							setLoop: 7
							setCel: 1
							posn: (skull4 x:) (- (skull4 y:) 1)
						)
					)
				)
				(= ticks (Random 20 80))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance sEnterFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(gEgo
					init:
					actions: egoActions
					posn: 152 245
					setMotion: MoveTo 152 180 self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (not (IsFlag 12))
					(SetFlag 12)
					(gMessager say: 6 0 0 3 self) ; "Looking around, you get the feeling that this is not a very friendly place to be."
				else
					(= ticks 30)
				)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(Load rsVIEW 1022)
				(gate setScript: boneTalk)
				(self dispose:)
			)
		)
	)
)

(instance sHutDown1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(hut posn: 221 24)
				(feet posn: 156 68)
				(= cycles 1)
			)
			(1
				(hut posn: 221 34)
				(feet posn: 156 78)
				(= cycles 1)
			)
			(2
				(hut posn: 221 45)
				(feet posn: 156 89)
				(= cycles 1)
			)
			(3
				(hut setLoop: 1 posn: 193 37)
				(feet hide:)
				(= cycles 5)
			)
			(4
				(hut setLoop: 0 posn: 221 61)
				(feet show: posn: 156 105)
				(= cycles 1)
			)
			(5
				(hut posn: 221 77)
				(feet posn: 156 121)
				(= cycles 1)
			)
			(6
				(hut posn: 221 86)
				(feet posn: 156 130)
				(= cycles 1)
			)
			(7
				(hut posn: 221 98)
				(feet posn: 156 142)
				(tromp number: 66 init: play:)
				(ShakeScreen 3)
				(HandsOn)
				(SetFlag 172)
				(self dispose:)
			)
		)
	)
)

(instance sHutDown2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gWaitCursor)
				(SolvePuzzle 657 7)
				(if (gEgo inRect: 156 115 238 151)
					(gEgo view: 516 setLoop: 1 setCel: 0 setPri: 1)
					(= local5 1)
				)
				(= cycles 5)
			)
			(1
				(if local5
					(gEgo setCel: 3)
				)
				(hut posn: 221 109)
				(feet posn: 156 152)
				(= cycles 3)
			)
			(2
				(if local5
					(gEgo setCel: 5)
				)
				(hut posn: 221 116)
				(= cycles 3)
			)
			(3
				(hut posn: 221 122 stopUpd:)
				(tromp number: 66 init: play:)
				(ShakeScreen 3)
				(= cycles 3)
			)
			(4
				(hutDoor init: cycleSpeed: 6 setCycle: End self)
			)
			(5
				(hutDoor stopUpd:)
				(if local5
					(EgoDead 157 158 3 7 516) ; "You really brought down the house! Too bad you were under it at the time."
				)
				(HandsOn)
				(SetFlag 287)
				(self dispose:)
			)
		)
	)
)

(instance putEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo use: 17) ; magicGem
				(= global273 5)
				(HandsOff)
				(if (and (== (gEgo x:) 191) (== (gEgo y:) 158))
					(self cue:)
				else
					(gEgo setMotion: PolyPath 191 162 self)
				)
			)
			(1
				(gEgo loop: 3 forceUpd:)
				(= cycles 2)
			)
			(2
				(gMessager say: 6 0 0 4 self) ; "You place the glowing gem inside the skull."
				(gateEyes init: setCycle: Fwd)
				(= global273 5)
			)
			(3
				(gEgo setMotion: MoveTo 200 175 self)
			)
			(4
				(NormalEgo)
				(gGame setCursor: gWaitCursor)
				(gEgo loop: 3 forceUpd:)
				(= cycles 2)
			)
			(5
				(SetFlag 336)
				(gEgo stopUpd:)
				(gate stopUpd:)
				(= cycles 2)
			)
			(6
				(gMessager say: 6 0 0 5 self) ; "I can see! I have eyes again!!"
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= ticks 10)
			)
			(8
				(gMessager say: 6 0 0 6 self) ; "Yeccchhh! Is THAT what you look like???"
			)
			(9
				(= ticks 10)
			)
			(10
				(gMessager say: 6 0 0 7 self) ; "Oh well! Have fun visiting Baba Yaga. And good luck....you'll need it!"
			)
			(11
				(if (not (IsFlag 11))
					(gMessager say: 6 0 28 1 self) ; "I hope you can remember the rhyme!"
				else
					(gMessager say: 6 0 33 1 self) ; "Bye!"
				)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo startUpd:)
				(gate startUpd:)
				(= local1 1)
				(skullTimer setReal: gCurRoom 2)
				(self dispose:)
			)
		)
	)
)

(instance openingScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== global273 1) (== global273 2))
					(self cue:)
				else
					(= global273 1)
					(gMessager say: 6 0 34 1 self) ; "Baba Yaga does not welcome strangers! You have to deal with me before you can enter."
				)
			)
			(1
				(= seconds 10)
			)
			(2
				(if (== global273 2)
					(self cue:)
				else
					(= global273 2)
					(gMessager say: 6 0 31 1 self) ; "Baba Yaga is one tough magic user. If you're so stupid that you want to enter, perhaps we can make a deal."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance boneTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setHeading: 360 self)
			)
			(1
				(gate stopUpd:)
				(gEgo stopUpd:)
				(= ticks 60)
			)
			(2
				(switch global273
					(0
						(= global273 1)
						(gEgo setScript: doTheIntro)
					)
					(2
						(if (IsFlag 290)
							(gate setScript: makeTheDeal)
						else
							(gate setScript: hearTheDeal)
						)
					)
					(3
						(gMessager say: 6 0 30 1 self) ; "So you're back! Changed your mind about making a little deal, hero?"
						(= global273 2)
						(gate setScript: makeTheDeal)
					)
					(4
						(gate setScript: respondToQuestion)
					)
					(else
						(if (and (IsFlag 11) (gEgo has: 21)) ; mandrake
							(gMessager say: 6 0 21) ; "So you made it back, did you? She is expecting you."
							(gate setScript: openGate)
						else
							(gMessager say: 6 0 27) ; "You again?? Do you really want to go back in there?"
							(gate setScript: openGate)
						)
					)
				)
			)
			(3
				(if (== global273 2)
					(self changeState: 2)
				else
					(if (and (> global273 4) (> register 0) (< register 3))
						(-= state 2)
					)
					(= seconds 2)
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gate startUpd:)
				(gEgo startUpd:)
				(NormalEgo)
				(HandsOn)
				(if (and (gEgo has: 21) (IsFlag 336)) ; mandrake
					(gate setScript: openGate)
				)
				(self dispose:)
			)
		)
	)
)

(instance setAllTheWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gMessager say: 5 57 19 1 self) ; "You hear a voice in your head asking, 'What is the rhyme?'"
				(gGame setCursor: 999 1 140 80)
			)
			(2
				(if (IsFlag 356)
					(switch
						(Print
							addText: 6 0 23 1 0 0 22 ; "You tell a rhyme about:"
							addButton: 0 6 0 23 9 0 18 22 ; "I'm not sure"
							addButton: 1 6 0 23 2 0 36 22 ; "Beauty"
							addButton: 2 6 0 23 3 0 54 22 ; "The alien From Venus"
							addButton: 3 6 0 23 4 0 72 22 ; "Hut of Brown"
							init:
						)
						(0
							(HandsOn)
							(self dispose:)
						)
						(1
							(gMessager say: 6 0 4 1 self) ; "You tell the hut: For Beauty I am not a star, There are others finer by far. But my face, I don't mind it, Because at least I'm behind it.  It's people in FRONT that I jar!"
						)
						(2
							(gMessager say: 6 0 6 1 self) ; "You tell the hut: There once was an alien from Venus, Whose body was shaped like a..."
						)
						(3
							(gMessager say: 6 0 5 1 self) ; "You tell the hut: Hut of Brown, Now sit down!"
							(gCurRoom setScript: sHutDown2)
						)
					)
				else
					(switch
						(Print
							addText: 6 0 23 5 0 0 22 ; "You tell a rhyme about:"
							addButton: 0 6 0 23 9 0 18 22 ; "I'm not sure"
							addButton: 1 6 0 23 6 0 36 22 ; "Beauty"
							addButton: 2 6 0 23 7 0 54 22 ; "The alien From Venus"
							init:
						)
						(0
							(HandsOn)
							(self dispose:)
						)
						(1
							(gMessager say: 6 0 4 0 self) ; "You tell the hut: For Beauty I am not a star, There are others finer by far. But my face, I don't mind it, Because at least I'm behind it.  It's people in FRONT that I jar!"
						)
						(2
							(gMessager say: 6 0 6 0 self) ; "You tell the hut: There once was an alien from Venus, Whose body was shaped like a..."
						)
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance doTheIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 0 34 1 self) ; "Baba Yaga does not welcome strangers! You have to deal with me before you can enter."
			)
			(1
				(= global273 2)
				(gMessager say: 6 0 31 1 self) ; "Baba Yaga is one tough magic user. If you're so stupid that you want to enter, perhaps we can make a deal."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance hearTheDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 6 0 35 1 self) ; "All the other skulls have glowing eyes. But me?....noooo! I don't need lovely glowing eyes! Just open and close the gate, that's all I'm good for."
			)
			(1
				(gMessager say: 6 0 37 1 self) ; "But if you can give me a glowing gem for my eyes, then I'll let you in the gate."
			)
			(2
				(self setScript: makeTheDeal)
			)
		)
	)
)

(instance makeTheDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(IsFlag 292)
				(SetFlag 290)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 3)
			)
			(1
				(switch
					(Print
						addText: 6 0 23 8 0 0 22 ; "Well, is it a deal or isn't it?"
						addButton: 0 6 0 23 9 0 18 22 ; "I'm not sure"
						addButton: 1 6 0 23 10 0 36 22 ; "Yes"
						addButton: 2 6 0 23 11 0 54 22 ; "No"
						init:
					)
					(0
						(gMessager say: 6 0 26 1) ; "No gem, no entry. That's the deal."
						(= global273 3)
					)
					(1
						(SetFlag 291)
						(= global273 4)
						(gMessager say: 6 0 24 1) ; "All I ask for is a little gem or jewel that glows in the dark. You're the big hero, so go find one."
						(SolvePuzzle 655 2)
					)
					(2
						(gMessager say: 6 0 25 1) ; "Fine. Be that way!"
						(= global273 3)
					)
				)
				(= seconds 3)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance respondToQuestion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(IsFlag 292)
				(SetFlag 290)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 3)
			)
			(1
				(switch
					(Print
						addText: 6 0 32 1 0 0 22 ; "Did you get my glowing gem?? Give it to me! I mean... Please give it to me."
						addButton: 0 6 0 23 9 0 36 22 ; "I'm not sure"
						addButton: 1 6 0 23 10 0 54 22 ; "Yes"
						addButton: 2 6 0 23 11 0 72 22 ; "No"
						init:
					)
					(0
						(gMessager say: 6 0 26 1) ; "No gem, no entry. That's the deal."
						(= global273 3)
					)
					(1
						(if (gEgo has: 17) ; magicGem
							(SolvePuzzle 656 10)
							(gCurRoom setScript: putEyes)
						else
							(gMessager say: 6 0 26 1) ; "No gem, no entry. That's the deal."
						)
					)
					(2
						(gMessager say: 6 0 25 1) ; "Fine. Be that way!"
						(= global273 3)
					)
				)
				(= seconds 3)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance skullTalker of Talker
	(properties
		x 10
		y 10
		view 1022
		talkWidth 260
		textX 15
		textY 110
		blinkSpeed 10
	)

	(method (init)
		(= global451 2022)
		(PalVary pvCHANGE_TARGET 2022)
		(AssertPalette 1022)
		(= font gUserFont)
		(if (IsFlag 336)
			(super init: skullBust bigEyes skullTalkerMouth &rest)
		else
			(super init: skullBust 0 skullTalkerMouth &rest)
		)
	)
)

(instance skullBust of Prop
	(properties
		view 1022
	)
)

(instance skullTalkerMouth of Prop
	(properties
		nsTop 58
		nsLeft 35
		view 1022
		loop 1
	)
)

(instance bigEyes of Prop
	(properties
		nsTop 39
		nsLeft 38
		view 1022
		loop 2
		cycleSpeed 12
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 40) ; mushroom
			(gMessager say: 3 40) ; "This place already looks like a nightmare. Eating magic mushrooms would likely make it even worse."
			(return 1)
		else
			(return 0)
		)
	)
)

(instance sBlink of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= ticks (Random 30 90))
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= ticks (Random 30 90))
			)
			(4
				(self init:)
			)
		)
	)
)

