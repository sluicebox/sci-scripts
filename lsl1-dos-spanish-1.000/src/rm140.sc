;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Language)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	climbing
	gaveWarning
	madeComment
	[unused 17]
	moveTimer
)

(instance rm140 of LLRoom
	(properties
		picture 140
		north 150
	)

	(method (init)
		(LoadMany rsVIEW 140 142)
		(LoadMany rsSOUND 140 148)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(if (and (!= gTvChannel 7) (gEgo has: 6)) ; remoteControl
			(Load rsVIEW 141)
			(Load rsTEXT 141)
		)
		(pimp init:)
		(switch gPrevRoomNum
			(110
				(ClearFlag 27) ; fPimpStandingAside
				(gEgo posn: 20 155)
			)
			(150
				(HandsOff)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 145 10 187 266 187 266 148 208 148 208 138 266 138 258 116 205 116 205 122 199 122 67 0 319 0 319 189 0 189 0 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 153 156 226 156 226 179 203 179 153 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 48 164 92 164 92 180 48 180
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 62 0 194 122 194 128 164 140 0 140
							yourself:
						)
					setScript: sFromHooker
				)
				(if (IsFlag 27) ; fPimpStandingAside
					(pimp
						setLoop: 7
						setCel: 4
						setPri: 11
						approachX: 221
						approachY: 148
					)
				)
				(= gaveWarning 1)
			)
			(else
				(gEgo posn: 40 160)
			)
		)
		(gEgo init: illegalBits: $8000)
		(super init:)
		(if (IsFlag 42) ; fTVOn
			(gTheMusic
				loop: -1
				flags: 1
				number:
					(switch gTvChannel
						(0 141)
						(1 142)
						(2 143)
						(3 144)
						(4 145)
						(5 146)
						(6 147)
						(7 148)
					)
			)
			(if (or (!= gTvChannel 7) (and (== gTvChannel 7) (== gPrevRoomNum 110)))
				(gTheMusic play:)
			)
		else
			(gTheMusic fade: 90 15 5 0)
		)
		(pimp cycleSpeed: gHowFast approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
		(if (!= (pimp loop:) 7)
			(pimp setCycle: Fwd)
		)
		(tv init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(mooseTail cycleSpeed: gHowFast init: setScript: sTail)
		(moose init:)
		(boxes init:)
		(stairs init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(theDoorFeature init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(thePeephole init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(barrel1 init:)
		(barrel2 init:)
		(if (IsFlag 42) ; fTVOn
			(tvLights
				cycleSpeed: gHowFast
				init:
				setCel: 255
				approachVerbs: 3 4 10 11 2 ; Do, Inventory, Zipper, Taste/Smell, Look
			)
		)
		(cond
			((== gTvChannel 7)
				(pimp
					x: 235
					y: 146
					setLoop: 6
					setPri: 11
					approachX: 221
					approachY: 148
					setCycle: RandCycle
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 145 10 187 266 187 266 148 208 148 208 138 266 138 258 116 205 116 205 122 199 122 67 0 319 0 319 189 0 189 0 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 153 156 226 156 226 179 203 179 153 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 48 164 92 164 92 180 48 180
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 62 0 194 122 194 128 164 140 0 140
							yourself:
						)
				)
			)
			((not (IsFlag 27)) ; fPimpStandingAside
				(if (not (pimp script:))
					(pimp setScript: sPimp)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 145 10 187 91 187 267 187 267 135 259 124 197 124 169 140 0 140 0 0 319 0 319 189 0 189 0 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 153 156 226 156 226 179 203 179 153 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 48 164 92 164 92 180 48 180
							yourself:
						)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (< (gEgo y:) 116) (!= script sFromHooker))
			(gEgo setPri: 8)
			(if (not climbing)
				(= climbing 1)
				(HandsOff)
				(gEgo setMotion: PolyPath 66 0)
			)
		else
			(if (== (gEgo priority:) 8)
				(gEgo setPri: -1)
			)
			(= climbing 0)
		)
		(cond
			(script)
			((< (gEgo y:) 45)
				(HandsOff)
				(gCurRoom setScript: sToHooker)
			)
			((and (== (pimp loop:) 6) (gEgo inRect: 194 146 261 159))
				(if (not moveTimer)
					(Print 140 0 #at -1 20) ; "Hey, dude! Outta da way ah da teevee!!"
					(= moveTimer 300)
				else
					(-- moveTimer)
				)
			)
			(
				(and
					(== gaveWarning 0)
					(!= gTvChannel 7)
					(gEgo inRect: 180 116 270 136)
				)
				(= gaveWarning 1)
				(Print 140 1 #at -1 20) ; "The pimp growls, "You gots no bizness goin' up dese stairs, little man!""
			)
			(
				(and
					(== madeComment 0)
					(== gPrevRoomNum 150)
					(== (pimp loop:) 7)
					(> (gEgo y:) 138)
				)
				(= madeComment 1)
				(Print 140 2 #at -1 20) ; ""Pretty sweet stuff, eh, boy?" laughs the pimp."
				(ClearFlag 27) ; fPimpStandingAside
				(pimp setLoop: 7 setCel: 4 setCycle: Beg pimp)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 145 10 187 91 187 267 187 267 135 259 124 197 124 169 140 0 140 0 0 319 0 319 189 0 189 0 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 153 156 226 156 226 179 203 179 153 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 48 164 92 164 92 180 48 180
							yourself:
						)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf ; "The bar's storage room is almost empty. Its most significant feature is that big, mean-looking dude %s."
					140
					3
					(if (IsFlag 28) {watching TV} else {blocking the stairs}) ; fPimpWatchingTV
					(if (IsFlag 28) ; fPimpWatchingTV
						{viendo TV}
					else
						{bloqueando las escaleras}
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(UnLoad 131 141)
		(super newRoom: newRoomNumber)
	)
)

(instance sPimp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 25))
			)
			(1
				(pimp setLoop: 0 setCel: 0 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(2
				(if (== (pimp loop:) 7)
					(pimp setLoop: 1)
				)
				(pimp setCel: 0 setCycle: End self)
			)
			(3
				(pimp setCel: 0)
				(= seconds (Random 3 8))
			)
			(4
				(pimp setLoop: 1 setCel: 0 setCycle: End)
				(= seconds (Random 3 8))
			)
			(5
				(self start: (if (Random 0 1) 0 else 2) init:)
			)
		)
	)
)

(instance sToHooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 66 0 self)
			)
			(1
				(gCurRoom newRoom: 150)
			)
		)
	)
)

(instance sFromHooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 66 y: 2 setPri: 8 setMotion: MoveTo 113 46 self)
			)
			(1
				(gEgo setMotion: MoveTo 194 121 self)
			)
			(2
				(HandsOn)
				(= climbing 1)
				(self dispose:)
			)
		)
	)
)

(instance sDoChannel of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					view: 141
					setLoop: 0
					cycleSpeed: gHowFast
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(gTheMusic3 number: 140 play:)
				(if (not (IsFlag 42)) ; fTVOn
					(Print 140 4 #at -1 20) ; "You aim your remote control at the pimp's TV and click the power switch."
					(Points 93 3)
					(SetFlag 42) ; fTVOn
					(tvLights cycleSpeed: gHowFast init: setCycle: End)
				else
					(Print 140 5 #at -1 20) ; "You aim your remote control at the TV and click the channel selector."
					(++ gTvChannel)
				)
				(gTheMusic
					vol:
					loop: -1
					number:
						(switch gTvChannel
							(0 141)
							(1 142)
							(2 143)
							(3 144)
							(4 145)
							(5 146)
							(6 147)
							(7 148)
						)
					play:
				)
				(switch gTvChannel
					(1
						(UnLoad 132 141)
					)
					(2
						(UnLoad 132 142)
					)
					(3
						(UnLoad 132 143)
					)
					(4
						(UnLoad 132 144)
					)
					(5
						(UnLoad 132 145)
					)
					(6
						(UnLoad 132 146)
					)
					(7
						(UnLoad 132 147)
					)
				)
				(gEgo setCycle: Beg)
				(= seconds 3)
			)
			(3
				(if (< gTvChannel 7)
					(HandsOn)
				)
				(NormalEgo 2)
				(Print 141 (* 2 gTvChannel) #at -1 20)
				(= seconds 3)
			)
			(4
				(cond
					((== gTvChannel 4)
						(Print 141 (+ 1 (* 2 gTvChannel)) #at -1 20)
					)
					((== gTvChannel 7)
						(SetFlag 28) ; fPimpWatchingTV
						(+= state 1)
					)
					(else
						(GetFarText 141 (+ 1 (* 2 gTvChannel)) @temp0)
						(if 1
							(= global314 (Memory memALLOC_CRIT (StrLen @temp0)))
							(= global323 (Memory memALLOC_CRIT (StrLen @temp0)))
							(StrSplitInTwo global314 global323 @temp0)
							(Printf 140 6 global314 global323 67 -1 20) ; "Another boring %s"
							(Memory memFREE global314)
							(Memory memFREE global323)
						)
					)
				)
				(= seconds 3)
			)
			(5
				(Printf ; "The pimp seems vaguely interested in this program%s"
					140
					7
					(if (IsFlag 27) ; fPimpStandingAside
						{.}
					else
						{, but not interested enough to leave his post guarding the stairs.}
					)
					(if (IsFlag 27) ; fPimpStandingAside
						{.}
					else
						{, pero no lo bastante como para abandonar su puesto de guardia.}
					)
					67
					-1
					20
				)
				(self dispose:)
			)
			(6
				(pimp setScript: 0)
				(if (IsFlag 27) ; fPimpStandingAside
					(ClearFlag 27) ; fPimpStandingAside
					(++ state)
					(= cycles 1)
				else
					(pimp
						setLoop: 4
						setCel: 0
						cycleSpeed: (+ 3 gHowFast)
						setCycle: End self
					)
				)
			)
			(7
				(pimp
					setCel: 0
					setLoop: 5
					cycleSpeed: (+ 1 gHowFast)
					setCycle: End self
				)
			)
			(8
				(HandsOn)
				(pimp
					x: 235
					y: 146
					approachX: 221
					approachY: 148
					setCel: 0
					setLoop: 6
					setPri: 11
					setCycle: RandCycle
					cycleSpeed: gHowFast
				)
				(= seconds 3)
			)
			(9
				(Points 74 8)
				(Print 140 8 #at -1 20) ; "Well, well, Larry! It appears you've finally reached the pimp's cultural level."
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 10 145 10 187 266 187 266 148 208 148 208 138 266 138 258 116 205 116 205 122 199 122 67 0 319 0 319 189 0 189 0 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 153 156 226 156 226 179 203 179 153 175
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 48 164 92 164 92 180 48 180
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 62 0 194 122 194 128 164 140 0 140
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance sTail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mooseTail setCycle: RandCycle)
				(= seconds 3)
			)
			(1
				(mooseTail setCycle: 0 stopUpd:)
				(= seconds (Random 7 20))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sToBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: MoveTo 20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 110)
			)
		)
	)
)

(instance pimp of Person
	(properties
		x 208
		y 122
		description {the pimp}
		sightAngle 40
		approachX 197
		approachY 124
		lookStr {You can tell by his glazed stare, he's no rocket scientist!}
		view 142
		signal 18432
	)

	(method (cue)
		(super cue:)
		(sPimp start: (if (Random 0 1) 0 else 2))
		(pimp setScript: sPimp setPri: -1 approachX: 197 approachY: 124)
	)

	(method (doVerb theVerb invItem)
		(if (IsFlag 28) ; fPimpWatchingTV
			(Print 140 9) ; "The pimp ignores you. He's "totally engrossed" in something else right now."
		else
			(switch theVerb
				(3 ; Do
					(Print 140 10) ; "What? You want to pick a fight with the pimp? He's far too big, and you're far too wimpy."
				)
				(10 ; Zipper
					(Print 140 11 #at -1 20) ; "HEY! Waddayou crazy?!"
				)
				(11 ; Taste/Smell
					(Print 140 12) ; "He smells of wet fur."
				)
				(5 ; Talk
					(Print 140 13 #at -1 20) ; "If ya wanna go upstairs," he says in his scholarly voice, "ya gotta pays da price!"
					(Print 140 14 #at -1 20) ; "$200.00, cash up front, no refunds."
					(Print 140 15 #at -1 140) ; "(He certainly has a pleasing manner about him.)"
				)
				(4 ; Inventory
					(switch invItem
						(0 ; wallet
							(cond
								((IsFlag 28) ; fPimpWatchingTV
									(Print 140 16) ; "There is no need to pay the pimp; he's pleasantly distracted. Help yourself!"
								)
								((< gLarryDollars 200)
									(Print 140 17) ; "You'd love to pay the pimp his $200.00, but you just don't have enough money."
								)
								(else
									(= gaveWarning 1)
									(-= gLarryDollars 200)
									(Print 140 18 #at -1 20) ; "Thanks," he growls. "Remember, no refunds!"
									(if (IsFlag 35) ; fScoredHooker
										(Print 140 19 #at -1 20) ; "You mus' really like that stuff, eh, boy?"
									)
									(if (not (IsFlag 27)) ; fPimpStandingAside
										(SetFlag 27) ; fPimpStandingAside
										(pimp
											setLoop: 7
											setCel: 0
											setCycle: End
											setPri: 11
											approachX: 221
											approachY: 148
											setScript: 0
										)
									)
									((gCurRoom obstacles:) dispose:)
									(gCurRoom
										addObstacle:
											((Polygon new:)
												type: PBarredAccess
												init: 10 145 10 187 266 187 266 148 208 148 208 138 266 138 258 116 205 116 205 122 199 122 67 0 319 0 319 189 0 189 0 145
												yourself:
											)
											((Polygon new:)
												type: PBarredAccess
												init: 153 156 226 156 226 179 203 179 153 175
												yourself:
											)
											((Polygon new:)
												type: PBarredAccess
												init: 48 164 92 164 92 180 48 180
												yourself:
											)
											((Polygon new:)
												type: PBarredAccess
												init: 0 0 62 0 194 122 194 128 164 140 0 140
												yourself:
											)
									)
									(Print 140 20 #at -1 20) ; "Have a nice lay."
								)
							)
						)
						(6 ; remoteControl
							(Print 140 21) ; "The remote control's operation is far too sophisticated for his mental capabilities."
						)
						(4 ; ring
							(Print 140 22) ; "Save your ring in case you find your "true love," Larry!"
						)
						(16 ; ribbon
							(Print 140 23) ; "You'd never be able to tie his up with that ribbon, Larry."
						)
						(14 ; hammer
							(Print 140 24) ; "The pimp is far too big for you to attack, even using your hammer as a weapon."
							(Print 140 25 #at -1 140) ; "(Besides, you're a lover, not a fighter!)"
						)
						(11 ; pocketKnife
							(Print 140 26) ; "The pimp is far too big for you to attack, even using that pocket knife for a weapon."
							(Print 140 27 #at -1 140) ; "(Besides, you're a lover, not a fighter!"
						)
						(else
							(if 1
								(= global314
									(Memory
										memALLOC_CRIT
										(StrLen ((Inv at: invItem) description:))
									)
								)
								(= global323
									(Memory
										memALLOC_CRIT
										(StrLen ((Inv at: invItem) description:))
									)
								)
								(StrSplitInTwo
									global314
									global323
									((Inv at: invItem) description:)
								)
								(Printf 140 28 global314 global323) ; "The pimp isn't interested in %s. He prefers money."
								(Memory memFREE global314)
								(Memory memFREE global323)
							)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance moose of Feature
	(properties
		x 97
		y 129
		z 36
		nsTop 78
		nsLeft 80
		nsBottom 109
		nsRight 115
		description {the moose}
		sightAngle 40
		lookStr {And you thought that moosehead over Lefty's bar was stuffed!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 140 29) ; "It is not wise to fondle a moose!"
			)
			(10 ; Zipper
				(Print 140 30) ; "Jeez, Larry! Who has the bigger antlers, you or the moose?!"
			)
			(5 ; Talk
				(Print 140 31) ; ""How's Rocky?" you ask."
				(Print 140 32 #at -1 140) ; "(There is no reply.)"
			)
			(11 ; Taste/Smell
				(Print 140 33) ; "It smells like an old moosehide--because it IS an old moose's hide!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mooseTail of Prop
	(properties
		x 117
		y 156
		z 71
		description {the moose's tail}
		lookStr {And all this time you thought that moosehead over Lefty's bar was stuffed!}
		view 140
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 140 34) ; "Sorry, Larry! Wrong kind of tail!"
			)
			(else
				(moose doVerb: theVerb invItem)
			)
		)
	)
)

(instance tvLights of Prop
	(properties
		x 180
		y 133
		description {the television set}
		sightAngle 40
		approachX 228
		approachY 155
		view 140
		loop 1
		priority 13
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(tv doVerb: theVerb invItem)
	)
)

(instance theDoorFeature of Feature
	(properties
		x 1
		y 146
		nsTop 84
		nsBottom 142
		nsRight 34
		description {the door}
		sightAngle 40
		approachX 29
		approachY 146
		lookStr {It's the door from Lefty's bar. Its far side looks even better than this side.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sToBar)
			)
			(5 ; Talk
				(Print 140 35) ; ""Yeah? Wadd's da passwoid?" you say to the peephole in the door."
				(Print 140 36) ; "You love playing the part of the pimp in these little fantasies of yours, don't you?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tv of Feature
	(properties
		x 190
		y 173
		z 37
		nsTop 122
		nsLeft 167
		nsBottom 151
		nsRight 213
		description {the television set}
		sightAngle 40
		approachX 228
		approachY 155
	)

	(method (doVerb theVerb invItem &tmp [temp0 200])
		(switch theVerb
			(2 ; Look
				(if (IsFlag 42) ; fTVOn
					(switch gTvChannel
						(4
							(Print 141 (+ 1 (* 2 gTvChannel)) #at -1 20)
						)
						(7
							(Print 140 37) ; "Get your mind back on the game, Larry!"
						)
						(else
							(GetFarText 141 (+ 1 (* 2 gTvChannel)) @temp0)
							(if 1
								(= global314 (Memory memALLOC_CRIT (StrLen @temp0)))
								(= global323 (Memory memALLOC_CRIT (StrLen @temp0)))
								(StrSplitInTwo global314 global323 @temp0)
								(Printf 140 6 global314 global323 67 -1 20) ; "Another boring %s"
								(Memory memFREE global314)
								(Memory memFREE global323)
							)
						)
					)
				else
					(Print 140 38) ; "The television screen is blank; much like the pimp's mind."
				)
			)
			(3 ; Do
				(Print 140 39) ; "The television set's knobs are broken off. There's no way to turn it off or on, or even change channels."
			)
			(4 ; Inventory
				(switch invItem
					(6 ; remoteControl
						(cond
							((or (> (gEgo y:) 162) (< (gEgo x:) 183))
								(Print 140 40) ; "The remote control seems ineffectual from this angle."
							)
							((== gTvChannel 7)
								(Print 140 41) ; "Nah. He's having a good time!"
							)
							(else
								(HandsOff)
								(gCurRoom setScript: sDoChannel)
							)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boxes of Feature
	(properties
		x 244
		y 92
		nsTop 69
		nsLeft 194
		nsBottom 115
		nsRight 294
		description {some boxes}
		sightAngle 40
		lookStr {They're boxes, all right.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 140 42) ; "You briefly consider stacking all the boxes into a perilous tower, then dangerously climbing up them inch by inch to reach the top of the staircase, avoiding the pimp and making your way to the hooker that waits above."
				(Print 140 43) ; "Then you remember how clumsy you really are and decide you'd rather find a casino and gamble."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stairs of Feature
	(properties
		x 143
		y 14
		description {the staircase}
		sightAngle 180
		onMeCheck 4096
		approachX 197
		approachY 124
		lookStr {You wonder what palace of earthly delights resides above you.}
	)
)

(instance barrel1 of Feature
	(properties
		x 47
		y 120
		nsTop 104
		nsLeft 34
		nsBottom 137
		nsRight 61
		description {the barrel}
		sightAngle 40
		lookStr {That's how Lefty buys his fine wines!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 140 44) ; "You can't drink from these barrels; they're empty."
			)
			(11 ; Taste/Smell
				(Print 140 45) ; "It smells of stale malt and barley."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance barrel2 of Feature
	(properties
		x 144
		y 123
		nsTop 110
		nsLeft 126
		nsBottom 136
		nsRight 163
		description {the barrel}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(barrel1 doVerb: theVerb invItem)
	)
)

(instance thePeephole of Feature
	(properties
		x 12
		y 148
		z 38
		nsTop 108
		nsLeft 6
		nsBottom 113
		nsRight 18
		description {the peephole}
		sightAngle 40
		approachX 29
		approachY 146
		lookStr {How interesting. This door has a small peephole. You suspect it may be used to communicate with someone on the other side.}
	)

	(method (doVerb theVerb invItem)
		(theDoorFeature doVerb: theVerb invItem)
	)
)

