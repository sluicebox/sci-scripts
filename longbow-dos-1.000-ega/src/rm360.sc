;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
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
	[local11 4] = [1360 75 1 0]
	[local15 4] = [1360 0 1 0]
	[local19 8] = [1360 1 1 0 1360 2 1 0]
	[local27 4] = [1360 19 1 0]
	[local31 4] = [1360 31 1 0]
	[local35 4] = [1360 30 1 0]
	[local39 7] = [1360 24 1 2 1 2 0]
	[local46 5] = [1360 28 1 2 0]
	[local51 6] = [1360 39 1 2 2 0]
	[local57 4] = [1360 42 1 0]
	[local61 4] = [1360 54 1 0]
	[local65 4] = [1360 55 1 0]
	[local69 4] = [1360 57 1 0]
	[local73 4] = [1360 82 1 0]
	[local77 4] = [1360 83 1 0]
	[local81 5] = [1360 84 1 1 0]
	[local86 4] = [1360 65 1 0]
	[local90 4] = [1360 66 1 0]
	[local94 4] = [1360 67 1 0]
	[local98 4] = [1360 74 1 0]
	[local102 4] = [1360 68 1 0]
	[local106 8] = [1360 69 2 2 1 2 1 0]
	[local114 5] = [1360 76 1 1 0]
	[local119 4] = [1360 16 1 0]
	[local123 4] = [1360 17 1 0]
	[local127 4] = [1360 18 1 0]
	[local131 4] = [1360 32 1 0]
	[local135 8] = [1360 33 2 2 1 2 2 0]
	[local143 4] = [1360 38 1 0]
	[local147 6] = [1360 43 1 2 1 0]
	[local153 11] = [1360 46 2 1 2 2 1 2 1 2 0]
	[local164 7] = [1360 58 2 1 2 2 0]
	[local171 6] = [1360 62 2 1 2 0]
	[local177 7] = [1360 86 2 1 2 2 0]
	[local184 4] = [1360 90 1 0]
	[local188 9] = [44 0 2 3 26 37 20 25 20]
)

(instance rm360 of Rm
	(properties
		picture 360
		north 350
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 927)
		(LoadMany rsVIEW 362 39 361)
		(if (== gDisguiseNum 3) ; jewler (rouge)
			(SetFlag 162)
			(= local9 1)
			(= local6 1)
		)
		(gTheIconBar disable: 4)
		(gTheIconBar disable: 5)
		(AddToFeatures
			lobbWindow
			lobbShelfDoor
			lobbDoor
			lobbBoots
			lobbTopShelf
			lobbCloak
			lobbTools
			lobbStool
			lobbChest
			lobbFrontWall
			lobbLeftWall
			lobbRightWall
			lobbCeiling
			lobbFloor
			lobbBackWall
		)
		(openDoor init:)
		(if (or (!= (gRgnMusic number:) 362) (< (gRgnMusic vol:) 127))
			(gRgnMusic number: 362 loop: -1 play:)
		)
		(NormalEgo)
		(if (== gPrevRoomNum 350)
			(lobb init:)
			(gEgo posn: 131 142 init: illegalBits: 0 setScript: stepIn)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 191 148 209 163 195 172 179 160 185 154
						yourself:
					)
			)
			(HandsOn)
			(gEgo posn: 159 165 loop: 0 init:)
			(lobb posn: 195 165 loop: 1 init:)
			(SetIcon 0)
		)
		(gEgo observeControl: -32768)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 53 0 132 88 119 91 123 146 85 162 58 165 13 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 152 0 319 0 319 189 308 189 278 171 222 163 204 142 140 143
					yourself:
				)
		)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((< (gEgo y:) 146)
				(gEgo setScript: goOutside)
			)
			((> (gEgo y:) 185)
				(gEgo setMotion: 0 setScript: moveFromTheWall)
			)
			((and (== gDisguiseNum 3) (not local8)) ; jewler (rouge)
				(SetFlag 162)
				(= local8 1)
			)
			((and local8 (not local9))
				(= local9 1)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 927)
		(super dispose:)
	)
)

(instance lobbWindow of Feature
	(properties
		x 198
		y 106
		nsTop 78
		nsLeft 174
		nsBottom 114
		nsRight 226
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(SetMessageColor 20)
				(Say 1360 6 1) ; "The open window is handy for customers, but forces me to be careful in what I do."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Converse @local27 @local188 0) ; "Leave it as it is. After all, I am open for business."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbShelfDoor of Feature
	(properties
		x 130
		y 64
		nsTop 60
		nsLeft 107
		nsBottom 68
		nsRight 154
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1360 15 1) ; "They are simply odds and ends belonging to the cobbler."
			)
			(3 ; Do
				(Say 1360 20 1) ; "I wouldn't take Lobb's personal belongings."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbDoor of Feature
	(properties
		x 129
		y 113
		nsTop 87
		nsLeft 115
		nsBottom 139
		nsRight 144
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(SetMessageColor 20)
				(Say 1360 5 1) ; "The open door offers us little privacy from the street and reminds me to be cautious."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Converse @local27 @local188 0) ; "Leave it as it is. After all, I am open for business."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbCloak of Feature
	(properties
		x 158
		y 106
		nsTop 79
		nsLeft 152
		nsBottom 133
		nsRight 165
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1360 11 1) ; "Looks like his cloak."
			)
			(3 ; Do
				(Say 1360 20 1) ; "I wouldn't take Lobb's personal belongings."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbStool of Feature
	(properties
		x 131
		y 143
		nsTop 131
		nsLeft 224
		nsBottom 155
		nsRight 239
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1360 12 1) ; "'Tis a stool, as any fool can plainly see."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbBoots of Feature
	(properties
		x 47
		y 108
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2) ; Look
				(Say 1360 8 1) ; "These must be the boots and shoes of his customers."
			)
			((== theVerb 3) ; Do
				(Say 1360 21 1) ; "Those belong to Lobb's customers. I've no business touching them."
			)
			((== theVerb 4) ; Inventory
				(if (== invItem 0) ; bucks
					(Say 1360 56 1) ; "Now why would I want to put money in a shoe?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 47 94 63 94 102 89 102 98 64 108 47 107
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbTopShelf of Feature
	(properties
		x 47
		y 91
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Look
				(Say 1360 7 1) ; "The cobbler has various oils and salves for use in his leatherwork."
			)
			((== theVerb 3) ; Do
				(Say 1360 20 1) ; "I wouldn't take Lobb's personal belongings."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 47 78 100 77 101 85 62 90 46 91
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbTools of Feature
	(properties
		x 234
		y 128
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Look
				(Say 1360 10 1) ; "Those are the tools of the cobber's trade."
			)
			((== theVerb 3) ; Do
				(Say 1360 23 1) ; "Lobb needs his tools more than I."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 234 117 256 105 275 125 252 128
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbChest of Feature
	(properties
		x 53
		y 160
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Look
				(Say 1360 9 1) ; "His chest is old and battered, but quite sound."
			)
			((== theVerb 3) ; Do
				(Say 1360 22 1) ; "Only Lobb has the right to open that chest."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 53 135 80 124 96 124 99 148 78 160 52 157
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbFrontWall of Feature
	(properties
		x 89
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 13 1) ; "It's a very humble craftsman's hut."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 89 58 234 59 224 138 100 139 98 122 79 122 80 108 103 101 103 75 86 75
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbLeftWall of Feature
	(properties
		x 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 13 1) ; "It's a very humble craftsman's hut."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 1 29 3 84 58 82 73 44 75 42 111 76 110 75 124 47 134 50 158 4 187
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbRightWall of Feature
	(properties
		x 315
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 13 1) ; "It's a very humble craftsman's hut."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 315 180 260 148 285 129 258 100 234 112 236 63 317 1
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbCeiling of Feature
	(properties
		x 34
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 13 1) ; "It's a very humble craftsman's hut."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 34 0 303 1 240 58 87 56 36 1
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbFloor of Feature
	(properties
		x 27
		y 139
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 13 1) ; "It's a very humble craftsman's hut."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 27 173 52 160 79 160 110 141 216 141 216 159 273 163 299 174
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lobbBackWall of Feature
	(properties
		x 17
		y 178
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1360 14 1) ; "There's a single door in the back wall of Lobb's shop."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 17 180 308 178 316 185 9 187
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance openDoor of View
	(properties
		x 114
		y 84
		view 350
		loop 5
		priority 10
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(SetMessageColor 20)
				(Say 1360 5 1) ; "The open door offers us little privacy from the street and reminds me to be cautious."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Converse @local27 @local188 0) ; "Leave it as it is. After all, I am open for business."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobb of Actor
	(properties
		x 266
		y 162
		view 361
		loop 3
		cel 2
	)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(2 ; Look
					(if (gEgo has: 3) ; slipper
						(Say 1360 3 1) ; "I must decide if I can trust this cobbler. He looks an honest enough fellow, if looks can be trusted."
					else
						(Say 1360 4 1) ; "He's Lobb the Cobbler."
					)
				)
				(3 ; Do
					(gEgo setScript: handLobb)
				)
				(5 ; Talk
					(cond
						((and (== gDisguiseNum 1) (gEgo has: 15)) ; beggar, comb
							(Converse @local31 @local188 0 self) ; "There's nothing more to be said now. I bid you to leave Nottingham and seek out the Lady as soon as possible."
						)
						(
							(and
								(gEgo has: 3) ; slipper
								(== gDisguiseNum 1) ; beggar
								(not (IsFlag 8))
							)
							(or
								(and
									(== local3 1)
									(Converse @local35 @local188 0 self) ; "Move along, beggar. You'll frighten off my good customers."
								)
								(if (== local2 0)
									(Converse @local39 7 @local188 self) ; "Don't be fooled by this disguise. I'm Robin Hood and I've come as you asked."
									(= local2 1)
								)
								(if (== local2 1)
									(Converse @local46 7 @local188 self) ; "Listen, you sent word of grave tidings, that I must come to see you."
									(= local3 1)
								)
							)
						)
						((and (== gDisguiseNum 2) (== gDay 9)) ; jewler (no rouge)
							(cond
								((and (IsFlag 162) (== local7 0))
									(= local7 1)
									(Converse @local177 999 @local188) ; "Why you've changed the beard again."
								)
								((and (IsFlag 162) (== local7 1))
									(Converse @local184 @local188 0) ; "Not to be rude, my friend, but hadn't you best get on with your business in town?"
								)
								((and (not (IsFlag 138)) (gEgo has: 8)) ; rouge
									(SetFlag 138)
									(SetFlag 24)
									(lobb setScript: moveToRobin)
								)
								(else
									(Converse @local143 @local188 0 self) ; "You have my advice, to heed or ignore as you will."
								)
							)
						)
						((and (== gDisguiseNum 3) (== gDay 9)) ; jewler (rouge)
							(cond
								((and (== local1 0) (not (IsFlag 24)))
									(= local1 1)
									(SetFlag 24)
									(lobb setScript: moveCloseAndAway self)
								)
								((and (== local8 1) (== local6 0))
									(= local6 1)
									(if (== local5 0)
										(Converse @local51 5 @local188 self) ; "Will this serve me better to escape the Sheriff's vigilance?"
										(= local5 1)
									else
										(Converse @local57 @local188 0 self) ; "I'll pray for your safety and success."
									)
								)
								(else
									(Converse @local61 @local188 0 self) ; "There's nothing else I can do but pray for your success against the Sheriff."
								)
							)
						)
					)
				)
				(4 ; Inventory
					(cond
						((== invItem 0) ; bucks
							(cond
								((and (== gDay 3) (gEgo has: 15)) ; comb
									(Converse @local73 @local188 0) ; "Nay, keep it and use it to further our just cause."
								)
								((and (== gDay 3) (not (gEgo has: 15))) ; comb
									(Converse @local77 @local188 0) ; "Keep your money, beggar. Your boots are beyond my help."
								)
								((and (== gDay 9) (IsFlag 24))
									(Converse @local81 @local188 0) ; "You know I'll not take your money."
								)
								(else
									(Converse @local65 @local188 0) ; "But you've given me nothing to repair."
								)
							)
						)
						((== invItem 2) ; halfHeart
							(Converse @local69 @local188 0) ; "Lar! Such an emerald would buy my entire shop! Guard it well."
						)
						((== invItem 3) ; slipper
							(if (and (not (IsFlag 5)) (not (IsFlag 190)))
								(lobb setScript: goBackRoom self)
							else
								(lobb setScript: killRobinScript self)
							)
						)
						((== invItem 15) ; comb
							(Converse @local86 @local188 0) ; "Nay, nay, you must give it to the Lady, as I told you."
						)
						((== invItem 14) ; amethyst
							(Converse @local90 @local188 0) ; "If you had work for me, this would more than pay for it. But since you don't, I cannot take it."
						)
						((or (== invItem 10) (== invItem 18)) ; fireRing, waterRing
							(if (== gDay 9)
								(Converse @local94 @local188 0) ; "What a magnificent ring. Keep it hidden. There are many cutpurses and lightfingers in the streets."
							)
						)
						((== invItem 7) ; jewels
							(if (== gDay 9)
								(cond
									((== local4 1)
										(Converse @local98 @local188 0) ; "I pray for your success."
									)
									((not (IsFlag 24))
										(Converse @local102 @local188 0) ; "There's no use showing such fine jewelry to me, sir. I've neither money nor maid to merit it."
									)
									((IsFlag 24)
										(Converse @local106 999 @local188 self) ; "Ah, I see the scheme. The Sheriff's wife is well known for her love of jewels."
										(= local4 1)
									)
								)
							)
						)
						((and (== invItem 8) (== gDay 9)) ; rouge
							(Converse @local114 @local188 0) ; "This appears to be....aye, it's jeweler's rouge, for polishing metal and gems."
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance goOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (>= (gEgo x:) 136)
					(gEgo setMotion: MoveTo 130 146 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 135 130 self)
			)
			(2
				(gRgnMusic fade: 0 30 8 1)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance putOnRouge of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local11 4 0) ; "Excuse me a moment."
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stepIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face lobb gEgo)
				(gEgo setMotion: MoveTo 131 170 self)
			)
			(1
				(Face gEgo lobb self)
				(lobb setLoop: 1 setCel: 0 illegalBits: 0)
			)
			(2
				(cond
					((and (== gDisguiseNum 1) (not (IsFlag 19))) ; beggar
						(SetFlag 19)
						(Converse @local15 @local188 0) ; "Ah...may I help you?"
					)
					(
						(and
							(not (IsFlag 20))
							(or (== gDisguiseNum 2) (== gDisguiseNum 3)) ; jewler (no rouge), jewler (rouge)
						)
						(SetFlag 20)
						(Converse @local19 @local188 0) ; "Good day, sir. How may I serve you?"
					)
				)
				(gEgo illegalBits: $8000)
				(= ticks 12)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveFromTheWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local10 1)
				(Say 1360 2 self) ; "It would be rude of me to enter Lobb's back room without his permission."
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(2
				(HandsOn)
				(= local10 0)
				(self dispose:)
			)
		)
	)
)

(instance handLobb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo lobb self)
			)
			(1
				(cond
					((and (== gDay 3) (gEgo has: 3)) ; slipper
						(Converse @local119 @local188 0 self) ; "If you've something to give me, do so. Otherwise, keep your hands to yourself."
					)
					((and (== gDay 9) (not (IsFlag 24)))
						(Converse @local123 @local188 0 self) ; "Was there something you wanted to give me, good sir?"
					)
					(else
						(Converse @local127 @local188 0 self) ; "I'm not sure what you want of me."
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

(instance moveToRobin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo lobb self)
			)
			(1
				(Face lobb gEgo self)
			)
			(2
				(if (== local0 0)
					(Converse @local131 4 0 self) ; "Look closely, Lobb."
				else
					(self cue:)
				)
			)
			(3
				(if (> (gEgo distanceTo: lobb) 30)
					(lobb
						setCycle: Walk
						setMotion:
							PolyPath
							(+ (gEgo x:) 30)
							(gEgo y:)
							self
					)
				else
					(self cue:)
				)
			)
			(4
				(if (== local0 0)
					(= local0 1)
					(Converse @local135 4 @local188 self) ; "Lar! Robin, it's you! Were my vision better I would have known you at once."
				else
					(Converse @local143 @local188 0 self) ; "You have my advice, to heed or ignore as you will."
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveCloseAndAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face lobb gEgo self)
			)
			(1
				(Face gEgo lobb self)
			)
			(2
				(Converse @local147 5 @local188 self) ; "Good day to you, Lobb."
			)
			(3
				(if (> (gEgo distanceTo: lobb) 30)
					(lobb
						setCycle: Walk
						setMotion:
							PolyPath
							(+ (gEgo x:) 30)
							(gEgo y:)
							self
					)
				else
					(self cue:)
				)
			)
			(4
				(Face lobb gEgo self)
			)
			(5
				(Converse @local153 5 @local188 self) ; "Pardon me, sir. My mind must be as weak as my eyes, for I swear I've never seen you before."
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goBackRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: Walk
					setMotion: PolyPath (- (lobb x:) 25) (+ (lobb y:) 5) self
				)
			)
			(1
				(lobb view: 362 setLoop: 0 setCel: 0 setCycle: End)
				(gEgo view: 39 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(Converse @local164 7 @local188 self) ; "What a fine slipper. You, eh, were given this?"
				(SetScore 25)
			)
			(3
				(lobb setCel: 0 setCycle: End self)
			)
			(4
				(lobb setHeading: 180)
				(= ticks 12)
			)
			(5
				(lobb
					view: 361
					setLoop: 2
					setCel: 0
					setCycle: Walk
					setMotion: PolyPath (lobb x:) 190
				)
				(gEgo
					view: 36
					setLoop: 2
					setCel: 0
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) 180 self
				)
			)
			(6
				(SetFlag 8)
				(gEgo put: 3) ; slipper
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance killRobinScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (- (lobb x:) 10) (lobb y:) self)
			)
			(1
				(Face lobb gEgo self)
			)
			(2
				(lobb view: 362 setLoop: 0 setCel: 0 setCycle: End)
				(gEgo view: 39 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(lobb setLoop: 3 setCel: 1 setCycle: End self)
			)
			(4
				(Converse @local171 7 @local188 self) ; "This...this slipper! How did you come by it?"
			)
			(5
				(lobb view: 362 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(= gDeathNum 5)
				(gRgnMusic fade: 0 30 8 1)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

