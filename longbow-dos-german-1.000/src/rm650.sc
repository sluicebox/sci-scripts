;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 11] = [1650 34 1 2 1 2 1 2 1 2 0]
	[local17 4] = [1650 50 1 0]
	[local21 4] = [1650 23 1 0]
	[local25 8] = [1650 42 1 2 1 2 1 0]
	[local33 6] = [1650 47 2 1 2 0]
	[local39 4] = [1650 29 1 0]
	[local43 8] = [1650 30 1 0 1650 31 1 0]
	[local51 4] = [1650 55 1 0]
	[local55 4] = [1650 56 1 0]
	[local59 4] = [1650 57 1 0]
	[local63 39] = [1650 58 1 0 1650 59 1 0 1650 60 2 1 2 1 2 0 1650 65 2 1 2 0 1650 68 2 1 2 2 0 1650 72 2 1 2 0 1650 75 1 0]
	[local102 8] = [1650 76 1 0 1650 77 1 0]
	[local110 4] = [1650 52 1 0]
	[local114 4] = [1650 53 1 0]
	[local118 4] = [1650 54 1 0]
	[local122 4] = [1650 78 1 0]
)

(instance rm650 of Rm
	(properties
		picture 650
	)

	(method (init)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 158 103 120 100 62 124 47 119 6 135 6 149 166 168 173 170 243 171 233 159 247 159 247 156 226 157 223 162 215 162 202 149 203 136 223 127 221 100 170 96
					yourself:
				)
		)
		(gEgo setScript: enterTheRoom)
		(= local4 0)
		(monk setCycle: Walk setAvoider: PAvoider posn: 0 145 init:)
		(if (Monastery gobletTipped:)
			(goblet setPri: 15 setCel: 5 init:)
		)
		(if (== (Monastery wherePrior:) 2)
			(thePrior init: setCycle: End)
			(Monastery noPriorExperience: 0)
			(goblet setPri: 15 init:)
		)
		(if (and (== (Monastery wherePrior:) 3) (not (IsFlag 83)))
			(scroll cel: 2 setPri: 15 x: 99 y: 168 z: 20 init:)
		)
		(AddToFeatures
			rack
			steps
			pDesk
			desk
			chest
			desk2
			candle
			fWindow
			sWindow
			floor
			walls
		)
	)

	(method (doit)
		(if (& (monk onControl:) $0002)
			(gEgo observeControl: 2)
		else
			(gEgo ignoreControl: 2)
		)
		(cond
			((and local2 (& (gEgo onControl:) $0004) (!= (gEgo mover:) 0))
				(gEgo setMotion: 0)
				(Say 1650 51) ; "I'd best wait until my 'brother' monk has gone his way before I follow."
			)
			((and local5 (& (gEgo onControl:) $0004))
				(gCurRoom newRoom: 630)
			)
			((and (== global115 2) (not (gEgo script:)))
				(gEgo setScript: burnedByFire)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 927)
		(super dispose:)
	)
)

(instance rack of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 228 1 228 96 173 92 173 1
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo setScript: goDoIt 0 1)
			)
			(3 ; Do
				(Say 1650 1) ; "I'd better look carefully before I take something. I may not get a second chance if the Monks become suspicious."
			)
			(4 ; Inventory
				(switch invItem
					(17 ; handScroll
						(Say 1650 2) ; "Do I look that stupid?"
					)
					(16 ; fulkScroll
						(Say 1650 2) ; "Do I look that stupid?"
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance steps of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 167 62 167 92 154 100 137 98 137 90 150 62
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 3) ; "They're steps for use in reaching scrolls at the top of the rack."
			)
			(3 ; Do
				(Say 1650 4) ; "I should check all the scrolls within reach first, lest I draw unwanted attention to myself."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pDesk of Feature
	(properties
		y 167
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 35 140 39 137 155 150 155 158 35 145
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((Monastery noPriorExperience:)
						(Say 1650 5) ; "Someone has been studying here."
					)
					((== (Monastery wherePrior:) 2)
						(Say 1650 6) ; "That seems to be the Prior's personal desk."
					)
					((not (IsFlag 83))
						(Say 1650 7) ; "As I hoped! He's left the scroll behind."
					)
					(else
						(Say 1650 8) ; "There's nothing of interest to me on the Prior's desk now."
					)
				)
			)
			(3 ; Do
				(cond
					((Monastery noPriorExperience:)
						(Say 1650 9) ; "I'd best not disturb anything."
					)
					((== (Monastery wherePrior:) 2)
						(Say 1650 10) ; "Not with the Prior there. Most unwise."
					)
					((IsFlag 83)
						(Say 1650 11) ; "There's nothing else of interest to me on this desk."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; handScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(16 ; fulkScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 49 93 100 79 112 90 112 100 64 119 47 115 48 93
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 13) ; "It's a scribe's desk."
			)
			(3 ; Do
				(Say 1650 14) ; "There's nothing of use to me here."
			)
			(4 ; Inventory
				(switch invItem
					(17 ; handScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(16 ; fulkScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk2 of Feature
	(properties
		y 132
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 254 127 251 154 226 154 214 141 211 128 228 116 237 116
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 13) ; "It's a scribe's desk."
			)
			(3 ; Do
				(Say 1650 14) ; "There's nothing of use to me here."
			)
			(4 ; Inventory
				(switch invItem
					(17 ; handScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(16 ; fulkScroll
						(Say 1650 12) ; "I hardly think I should display that which I'm trying to steal."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance candle of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 123 53 124 62 118 71 117 95 112 98 111 76 105 68 110 67 111 42 114 42
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 15) ; "It's no wonder Monks go blind if they have no more light than this to work with at night."
			)
			(3 ; Do
				(Say 1650 16) ; "Not a very practical thing to carry around."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of Feature
	(properties
		y 160
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 270 152 275 157 274 167 236 164 237 147 242 142 248 141 255 141
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 17) ; "It's a sturdy chest."
			)
			(3 ; Do
				(gEgo setScript: openChest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 115 88 227 96 227 135 274 168 35 144 34 120
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 18) ; "What an uninteresting wooden floor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fWindow of Feature
	(properties
		y 172
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 57 0 42 22 33 57 35 145 92 153 181 160 263 167 289 167 293 77 290 32 280 9 271 0 293 0 300 11 308 47 303 181 160 174 16 152 13 43 15 29 34 0
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 19) ; "A view of the fens. How inspiring."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sWindow of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 235 113 236 56 239 39 247 31 255 29 264 31 271 38 274 45 277 57 275 131
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (& (gEgo onControl:) $0008)
					(Say 1650 20) ; "Nothing to be seen from here but the dreary mists of the fens and dark shadow of the forest beyond."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {the walls}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 21) ; "More dank stone walls."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance thePrior of Actor
	(properties
		x 93
		y 162
		view 643
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1650 22) ; "The Prior is engrossed in studying a small scroll."
			)
			(5 ; Talk
				(gEgo setScript: talkToPrior)
			)
			(3 ; Do
				(Say 1650 79) ; "That would be sure to annoy him and to no good purpose."
			)
			(4 ; Inventory
				(Say 1650 80) ; "I'd be wiser to distract him as little as possible until I'm sure of what I need to do."
			)
		)
	)
)

(instance monk of Actor
	(properties
		x 200
		y 101
		view 16
		loop 3
	)

	(method (doVerb theVerb invItem)
		(if (< (monk x:) 34)
			(walls doVerb: theVerb &rest)
		else
			(= local1 monk)
			(switch theVerb
				(2 ; Look
					(Say 1650 33) ; "One of my fellow 'brothers'."
				)
				(5 ; Talk
					(Converse @local110 11) ; "Silence is better than talk, Brother."
				)
				(3 ; Do
					(Converse @local114 11) ; "Keep your hands to yourself, Brother."
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(Converse @local118 11) ; "Have you forgotten our vows of Poverty and Obedience? You should have turned this money over to the Prior."
						)
						(2 ; halfHeart
							(Converse @local51 11) ; "That is a fine piece of emerald! The Prior will be most glad to have it."
							(gEgo put: 2 -1) ; halfHeart
							(SetScore -200)
							(gEgo setScript: ripsOff 0 1)
						)
						(14 ; amethyst
							(Converse @local55 11) ; "That is a fine bit of amethyst! The Prior will be most glad to have it."
							(gEgo put: 14 -1) ; amethyst
							(SetScore -50)
							(gEgo setScript: ripsOff 0 2)
						)
						(17 ; handScroll
							(gEgo setScript: giveItBack 0 1)
						)
						(16 ; fulkScroll
							(Converse @local63 11) ; "The Prior was studying this. A waste of his time, I suspect, but I shall return it to his desk."
							(gEgo put: 16 -1) ; fulkScroll
							(gEgo setScript: ripsOff 0 4)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
		)
	)
)

(instance monk2 of Actor
	(properties
		y 145
		view 128
	)

	(method (doVerb theVerb invItem)
		(if (< (monk2 x:) 34)
			(walls doVerb: theVerb &rest)
		else
			(= local1 monk2)
			(switch theVerb
				(2 ; Look
					(Say 1650 33) ; "One of my fellow 'brothers'."
				)
				(5 ; Talk
					(Converse @local110 11) ; "Silence is better than talk, Brother."
				)
				(3 ; Do
					(Converse @local114 11) ; "Keep your hands to yourself, Brother."
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(Converse @local118 11) ; "Have you forgotten our vows of Poverty and Obedience? You should have turned this money over to the Prior."
						)
						(2 ; halfHeart
							(Converse @local51 11) ; "That is a fine piece of emerald! The Prior will be most glad to have it."
							(gEgo put: 2 -1) ; halfHeart
							(SetScore -200)
							(gEgo setScript: ripsOff 0 1)
						)
						(14 ; amethyst
							(Converse @local55 11) ; "That is a fine bit of amethyst! The Prior will be most glad to have it."
							(gEgo put: 14 -1) ; amethyst
							(SetScore -50)
							(gEgo setScript: ripsOff 0 2)
						)
						(17 ; handScroll
							(gEgo setScript: giveItBack 0 1)
						)
						(16 ; fulkScroll
							(Converse @local63 11) ; "The Prior was studying this. A waste of his time, I suspect, but I shall return it to his desk."
							(gEgo put: 16 -1) ; fulkScroll
							(gEgo setScript: ripsOff 0 4)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
		)
	)
)

(instance scroll of Prop
	(properties
		x 113
		y 152
		view 643
		loop 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1650 32) ; "It's a ragged scroll covered with what looks to be lines of verse."
			)
			(3 ; Do
				(gEgo setScript: getScroll)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goblet of Prop
	(properties
		x 123
		y 189
		z 36
		view 643
		loop 4
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== (Monastery wherePrior:) 2)
					(Say 1650 24) ; "I see the Prior is indulging in a bit of wine."
				else
					(Say 1650 25) ; "It's a good thing I was careful to knock over the goblet in such a way that the scroll wasn't damaged."
				)
			)
			(3 ; Do
				(if (== (Monastery wherePrior:) 2)
					(gEgo setScript: goDoIt 0 0)
				else
					(Say 1650 26) ; "Let 'His Worship' clean it up himself."
				)
			)
			(4 ; Inventory
				(switch invItem
					(14 ; amethyst
						(if (not (Monastery gobletTipped:))
							(gEgo setScript: dropStone)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: PAvoider)
				(gEgo setMotion: PolyPath 244 171 self)
			)
			(1
				(Face gEgo chest)
				(= cycles 3)
			)
			(2
				(Say 1650 27) ; "It's locked!"
				(HandsOn)
				(gEgo setAvoider: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterTheRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo posn: 6 145 init: setMotion: PolyPath 72 147 self)
			)
			(1
				(= local5 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockOverGoblet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk setScript: 0)
				(Face gEgo thePrior)
				(thePrior setCycle: Beg self)
			)
			(1
				(scrollSound play:)
				(if (Monastery firstTimeTalk:)
					(Converse @local25 8 (Monastery tPRIOR:) self) ; "Would Your Grace care for more wine. I--"
				else
					(Converse @local39 8 0 self) ; "Allow me to refill your goblet, Your Worship."
				)
			)
			(2
				(thePrior setCycle: End self)
			)
			(3
				(scrollSound play:)
				(goblet setScript: tipGoblet self)
			)
			(4
				(if (Monastery firstTimeTalk:)
					(Converse @local33 8 (Monastery tPRIOR:) self) ; "By the Trinity! You're the most worthless new recruit I've ever had!"
				else
					(Converse @local43 (Monastery tPRIOR:) 0 self) ; "You stupid, clumsy, worthless---phagh! Clean up this mess! I'm going to my tower to wash out my robe."
				)
			)
			(5
				(thePrior setScript: priorLeave self)
			)
			(6
				(if (not (Monastery firstTimeTalk:))
					(Say 1650 31) ; "Aye....clumsy as a fox, 'Your Worship'."
				)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tipGoblet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thePrior ignoreActors: 1)
				(gEgo setMotion: PolyPath 132 165 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo posn: 126 151 view: 20 loop: 0 cel: 0)
				(= ticks 6)
			)
			(3
				(gEgo setCycle: End)
				(goblet setCycle: End self)
			)
			(4
				(spillSound play:)
				(thePrior loop: 1 cel: 0)
				(scroll init:)
				(= ticks 6)
			)
			(5
				(scroll posn: 106 145)
				(thePrior setCycle: CT 1 1 self)
			)
			(6
				(scroll posn: 99 148)
				(thePrior setCycle: CT 2 1 self)
			)
			(7
				(thePrior setCycle: End)
				(scroll setCycle: End self)
			)
			(8
				(scroll y: 168 z: 20)
				(NormalEgo)
				(gEgo setMotion: PolyPath 128 150 self)
			)
			(9
				(scrollSound play:)
				(gEgo setHeading: 180 self)
			)
			(10
				(Monastery gobletTipped: 1)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance priorLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(thePrior
					setAvoider: PAvoider
					view: 641
					setCycle: Walk
					setMotion: PolyPath -10 145 self
				)
			)
			(1
				(Monastery wherePrior: 3)
				(thePrior dispose:)
				(self dispose:)
			)
		)
	)
)

(instance talkToPrior of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo thePrior)
				(thePrior setCycle: Beg self)
			)
			(1
				(scrollSound play:)
				(if (Monastery firstTimeTalk:)
					(Converse @local6 8 (Monastery tPRIOR:) self) ; "Pardon me..."
					(Monastery firstTimeTalk: 0)
				else
					(Converse @local21 (Monastery tPRIOR:) 0 self) ; "Don't bother me again, I'm working."
				)
			)
			(2
				(thePrior setCycle: End self)
			)
			(3
				(scrollSound play:)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance getScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 109 163 self)
			)
			(1
				(gEgo view: 20 loop: 1 cel: 0)
				(= ticks 6)
			)
			(2
				(gEgo get: 16 setCycle: End self) ; fulkScroll
				(scroll hide:)
			)
			(3
				(NormalEgo)
				(gEgo setMotion: MoveTo 110 160 self)
			)
			(4
				(SetScore 150 83)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dropStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(thePrior signal: 16384)
				(gEgo setMotion: PolyPath 132 165 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo posn: 122 149 view: 20 loop: 0 cel: 0)
				(= cycles 3)
			)
			(3
				(gEgo setCycle: CT 1 1 self)
			)
			(4
				(gEgo setCycle: CT 0 -1 self)
			)
			(5
				(thePrior loop: 1)
				(scroll setPri: 15 init:)
				(thePrior setCycle: End)
				(scroll setCycle: End)
				(gEgo
					view: 16
					setCycle: Walk
					setMotion: PolyPath 128 150 self
				)
			)
			(6
				(scrollSound play:)
				(gEgo setHeading: 180 self)
			)
			(7
				(Converse @local17 (Monastery tPRIOR:) 0 self) ; "What was that? What did you drop into my wine? You're trying to poison me! BROTHERS! Kill him!"
			)
			(8
				(monk2
					setLoop: 2
					setCycle: Walk
					init:
					setMotion: PolyPath 41 147 self
				)
				(if (< (monk y:) 145)
					(monk setScript: 0)
					(monk setMotion: PolyPath 108 140 self)
				)
			)
			(9
				(= cycles 2)
			)
			(10
				(= gDeathNum 22)
				(gCurRoom newRoom: 170) ; robinDeath
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance burnedByFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk setScript: 0)
				(monk2 setScript: 0)
				(thePrior setScript: 0)
				(= gDeathNum 20)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 65 114 self)
			)
			(2
				((= local3 ((ScriptID 625 1) new:)) ; chip
					view: 16
					setLoop: 0
					cel: 0
					posn: 19 138
					init:
					setAvoider: PAvoider
					setCycle: Walk
					setMotion: PolyPath 61 134 self
				)
			)
			(3
				(Converse @local122 11 0 self) ; "That ring! You're the thief the Abbott wants!"
			)
			(4
				(local3 view: 585 setLoop: 3 setCel: 0 setCycle: End)
				(= cycles 2)
			)
			(5
				(dieSound play:)
				(gEgo view: 22 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance ripsOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monk setScript: 0)
				(monk2 setScript: 0)
				(thePrior setScript: 0)
				(local1
					setAvoider: PAvoider
					setMotion:
						PolyPath
						(+ (gEgo x:) 20)
						(+ (gEgo y:) 15)
						self
				)
			)
			(1
				(switch register
					(1
						(local1 setMotion: PolyPath 6 145 self)
					)
					(2
						(local1 setMotion: PolyPath 6 145 self)
					)
					(3
						(local1 setMotion: PolyPath 200 101 self)
					)
					(4
						(local1 setScript: putItBack self)
					)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putItBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setMotion: MoveTo 109 163 self)
			)
			(1
				(local1 view: 20 loop: 1 cel: 0)
				(= cycles 3)
			)
			(2
				(local1 setCycle: End self)
				(scroll show:)
			)
			(3
				(local1 view: 16 loop: 3 setCycle: Walk)
				(local1 setMotion: PolyPath 6 145 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance giveItBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 133 154 self)
			)
			(1
				(if register
					(Converse @local59 11 0 self) ; "That belongs in the scribes' room, Brother. I shall see that it is returned."
				else
					(Converse @local102 (Monastery tPRIOR:) 0 self) ; "Do I look like a librarian? Put it back where it belongs and stop bothering me."
				)
			)
			(2
				(gEgo setMotion: MoveTo 218 110 self)
			)
			(3
				(if register
					(gEgo setScript: ripsOff 0 3)
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOn)
				(gEgo put: 17 -1) ; handScroll
				(self dispose:)
			)
		)
	)
)

(instance goDoIt of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
				(HandsOff)
			)
			(1
				(= temp0 (if register 190 else 140))
				(= temp1 (if register 97 else 140))
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(2
				(if register
					((ScriptID 660) doit:) ; scrolls
					(HandsOn)
				else
					(gEgo setScript: knockOverGoblet)
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance scrollSound of Sound
	(properties
		flags 1
		number 633
	)
)

(instance spillSound of Sound
	(properties
		flags 1
		number 634
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

