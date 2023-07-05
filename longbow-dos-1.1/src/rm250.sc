;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	local0
	[local1 80]
	local81
	local82
	local83
	local84
	local85
	[local86 2]
	local88
	[local89 9] = [1250 0 1 3 1 2 1 2 0]
	[local98 8] = [1250 6 3 1 4 2 4 0]
	[local106 5] = [1250 11 2 1 0]
	[local111 14] = [1250 13 3 4 5 2 2 2 1 2 3 2 2 0]
	[local125 6] = [1250 24 2 2 1 0]
	[local131 11] = [1250 27 2 3 4 1 2 1 2 2 0]
	[local142 8] = [1250 35 1 2 3 2 2 0]
	[local150 7] = [1250 40 2 2 1 1 0]
	[local157 8] = [1250 145 2 2 2 2 2 0]
	[local165 6] = [1250 183 2 1 2 0]
	[local171 6] = [1250 164 2 1 2 0]
	[local177 4] = [1250 178 1 0]
	[local181 4] = [1250 179 1 0]
	[local185 6] = [1250 167 2 1 2 0]
	[local191 6] = [1250 170 2 1 2 0]
	[local197 4] = [1250 174 1 0]
	[local201 4] = [1250 175 1 0]
	[local205 4] = [1250 176 1 0]
	[local209 4] = [1250 152 1 0]
	[local213 4] = [1250 154 1 0]
	[local217 4] = [1250 155 1 0]
	[local221 4] = [1250 158 1 0]
	[local225 4] = [1250 159 1 0]
	[local229 4] = [1250 156 1 0]
	[local233 8] = [1250 157 1 0 1250 160 1 0]
	[local241 4] = [1250 161 1 0]
	[local245 5] = [1250 55 2 1 0]
	[local250 4] = [1250 57 1 0]
	[local254 5] = [1250 58 2 1 0]
	[local259 4] = [1250 60 1 0]
	[local263 6] = [1250 61 2 1 2 0]
	[local269 4] = [1250 64 1 0]
	[local273 11] = [1250 65 1 2 1 2 1 2 1 2 0]
	[local284 4] = [1250 73 1 0]
	[local288 8] = [1250 74 2 1 2 1 2 0]
	[local296 5] = [1250 89 1 2 0]
	[local301 4] = [1250 224 1 0]
	[local305 10] = [1250 79 2 1 2 2 2 1 2 0]
	[local315 6] = [1250 86 1 2 1 0]
	[local321 4] = [1250 91 1 0]
	[local325 4] = [1250 92 1 0]
	[local329 6] = [1250 93 2 1 2 0]
	[local335 4] = [1250 96 1 0]
	[local339 11] = [1250 97 1 2 1 2 2 1 2 2 0]
	[local350 4] = [1250 105 1 0]
	[local354 8] = [1250 106 1 2 2 1 2 0]
	[local362 4] = [1250 111 1 0]
	[local366 10] = [1250 112 2 1 2 1 2 1 1 0]
	[local376 4] = [1250 121 1 0]
	[local380 4] = [1250 122 1 0]
	[local384 4] = [1250 123 1 0]
	[local388 4] = [1250 124 1 0]
	[local392 4] = [1250 125 1 0]
	[local396 4] = [1250 126 1 0]
	[local400 5] = [1250 127 1 2 0]
	[local405 6] = [1250 129 2 1 2 0]
	[local411 4] = [1250 132 1 0]
	[local415 8] = [1250 133 1 0 1250 143 1 0]
	[local423 6] = [1250 134 2 1 2 0]
	[local429 5] = [1250 137 2 1 0]
	[local434 6] = [1250 139 2 1 2 0]
	[local440 4] = [1250 142 1 0]
	[local444 4] = [1250 143 1 0]
	[local448 4] = [1250 144 1 0]
	[local452 8] = [1250 44 2 1 3 2 1 0]
	[local460 8] = [1250 196 2 1 2 2 1 0]
	[local468 4] = [1250 190 1 0]
	[local472 7] = [1250 192 1 2 2 1 0]
	[local479 17] = [1250 187 1 0 1250 201 1 0 1250 202 1 0 1250 220 1 2 0]
	[local496 4] = [1250 225 1 0]
	[local500 9] = [253 0 2 4 21 37 19 27 10]
	[local509 9] = [-1 {Hob} 12 0 0 0 0 0 0]
	[local518 9] = [-1 {Hal} 11 0 0 0 0 0 0]
	[local527 27] = [-1 {Dicken} 13 0 0 0 0 0 0 -1 {Robin Hood} 0 0 0 0 0 0 0 -1 {Mel's Brook} 24 0 0 0 0 0 0]
	[local554 9] = [-1 {Ewe} 32 0 0 0 0 0 0]
)

(procedure (localproc_0 param1) ; UNUSED
	(switch param1
		(2
			(Say 1250 186 self) ; "Looks like smoke from the chimney."
		)
		(else
			(super doVerb: param1)
		)
	)
)

(instance rm250 of Rm
	(properties
		picture 250
		style 100
		horizon 105
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1250 223 1) ; "The widow's cottage sits in a small clearing."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(LoadMany rsVIEW 250 252 253 254)
		(gEgo actions: widowBlow)
		(super init:)
		(HandsOn)
		(cond
			((or (== gPrevRoomNum 270) (== gPrevRoomNum 179)) ; synop
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ (widow x:) 40)
								(- (widow y:) 4)
								(+ (widow x:) 28)
								(+ (widow y:) 4)
								(- (widow x:) 14)
								(+ (widow y:) 4)
								(- (widow x:) 25)
								(+ (widow y:) 11)
								(- (widow x:) 67)
								(+ (widow y:) 11)
								(- (widow x:) 83)
								(+ (widow y:) 5)
								(- (widow x:) 78)
								(- (widow y:) 2)
								(- (widow x:) 38)
								(- (widow y:) 13)
								(+ (widow x:) 28)
								(- (widow y:) 13)
							yourself:
						)
				)
				(NormalEgo 0 0 1)
				(= gDisguiseNum 0) ; outlaw
				(hal init:)
				(hob init:)
				(dicken init:)
				(widow loop: 2 init:)
				(= gEgoEdgeHit 2)
				(= global105 170)
				(= local0 boysSaved)
			)
			(
				(or
					(== gDay 1)
					(== gDay 2)
					(== gDay 3)
					(== gDay 4)
					(== gDay 7)
					(== gDay 9)
				)
				(if (and (== gDay 1) (not (IsFlag 45)))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(+ (widow x:) 40)
									(- (widow y:) 4)
									(+ (widow x:) 28)
									(+ (widow y:) 4)
									(- (widow x:) 14)
									(+ (widow y:) 4)
									(- (widow x:) 25)
									(+ (widow y:) 11)
									(- (widow x:) 61)
									(+ (widow y:) 11)
									(- (widow x:) 75)
									(+ (widow y:) 5)
									(- (widow x:) 67)
									(- (widow y:) 2)
									(- (widow x:) 38)
									(- (widow y:) 13)
									(+ (widow x:) 28)
									(- (widow y:) 13)
								yourself:
							)
					)
					(hal init:)
					(hob init:)
					(dicken init:)
					(= local0 firstTime)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(+ (widow x:) 40)
									(- (widow y:) 4)
									(+ (widow x:) 26)
									(+ (widow y:) 4)
									(- (widow x:) 28)
									(+ (widow y:) 4)
									(- (widow x:) 60)
									(- (widow y:) 4)
									(- (widow x:) 28)
									(- (widow y:) 9)
									(+ (widow x:) 26)
									(- (widow y:) 9)
								yourself:
							)
					)
					(= local0 handOut)
				)
				(widow loop: 0 init:)
			)
			((and (== gDay 5) (== gDisguiseNum 0) (not (IsFlag 111))) ; outlaw
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ (widow x:) 60)
								(- (widow y:) 4)
								(+ (widow x:) 50)
								(+ (widow y:) 4)
								(- (widow x:) 30)
								(+ (widow y:) 4)
								(- (widow x:) 40)
								(- (widow y:) 4)
								(- (widow x:) 30)
								(- (widow y:) 10)
								(+ (widow x:) 50)
								(- (widow y:) 10)
							yourself:
						)
				)
				(widow loop: 1 init:)
				(ScriptID 23) ; Tuck
				((ScriptID 23) ; Tuck
					posn: (+ (widow x:) 22) (- (widow y:) 3)
					loop: 2
					detailLevel: 2
					actions: tuckActions
					init:
				)
				(SetFlag 111)
				(= local0 boysBusted)
			)
			((== gDay 10)
				(if (not (IsFlag 52))
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(+ (widow x:) 25)
									(- (widow y:) 3)
									(+ (widow x:) 16)
									(+ (widow y:) 4)
									(- (widow x:) 15)
									(+ (widow y:) 4)
									(- (widow x:) 24)
									(- (widow y:) 3)
									(- (widow x:) 15)
									(- (widow y:) 12)
									(+ (widow x:) 16)
									(- (widow y:) 12)
								yourself:
							)
					)
					(widow loop: 2 init:)
					(SetFlag 52)
				)
				(= local0 handOut)
			)
			(else
				(= local0 handOut)
			)
		)
		(gSFX number: 151 loop: -1 play:)
		(cond
			((== local84 0)
				(gRgnMusic number: 905)
			)
			((and (or (== gDay 5) (== gDay 6)) (not (IsFlag 125)))
				(gRgnMusic number: 251)
			)
			(else
				(gRgnMusic number: 250)
			)
		)
		(gRgnMusic loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 299 118 261 129 220 123 157 134 71 107 89 103 69 95 161 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 61 124 49 135 0 144 0 123 29 120
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 114 0 96 28 99 38 107 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 101 276 85 260 86 249 73 319 64
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 132 189 186 175 272 141 294 135 319 135 319 189
					yourself:
				)
		)
		(switch gDisguiseNum
			(1 ; beggar
				(= local82 7)
			)
			(5 ; abbey monk
				(= local82 9)
			)
			(6 ; fens monk
				(= local82 8)
			)
			(4 ; yeoman
				(= local82 6)
			)
			(2 ; jewler (no rouge)
				(= local82 4)
			)
			(3 ; jewler (rouge)
				(= local82 5)
			)
			(else
				(= local82 1)
			)
		)
		(if (gCast contains: widow)
			(smoke init:)
			(lamb init:)
			(AddToFeatures
				roof
				theWoods
				eastWall
				midWall
				westWall
				door
				chimney
				rock
				stream
			)
		else
			(AddToFeatures
				roof
				theWoods
				eastWall
				midWall
				westWall
				door
				chimney
				rock
				stream
				noGoat
			)
		)
		(gEgo setScript: egoEnters)
		(gCurRoom setScript: local0)
	)

	(method (doit)
		(++ local81)
		(if (and (> (gGame detailLevel:) 2) (not (IsFlag 115)))
			(Palette palANIMATE 240 250 1)
			(cond
				((and local84 (== (mod local81 65) 0))
					(widow setCycle: End widow)
				)
				((and local83 (== (mod local81 90) 0))
					(lamb setCycle: End lamb)
				)
				((and local85 (== (mod local81 147) 0))
					(hal setCel: (if (hal cel:) 0 else 1))
				)
				((and local85 (== (mod local81 153) 0))
					(hob setCel: (if (hob cel:) 0 else 1))
				)
				((and local85 (== (mod local81 178) 0))
					(dicken setCel: (if (dicken cel:) 0 else 1))
				)
			)
		)
		(cond
			((gEgo script:))
			((and (IsFlag 110) (== gDay 9))
				(ClearFlag 110)
				(Converse 1 @local496 @local500 0) ; "'Tis good that you practice the Hand Code for you will have need of it."
			)
			((= gEgoEdgeHit (gEgo edgeHit:))
				(gEgo setScript: walkOut 0 gEgoEdgeHit)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gRgnMusic fade: 0 20 12 1)
		(gSFX stop:)
		(baaSound dispose:)
		(SetFlag 45)
		(super dispose:)
	)
)

(instance hal of Prop
	(properties
		x 91
		y 143
		view 254
		loop 2
		signal 16384
		detailLevel 2
	)

	(method (init)
		(= local85 1)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 173 1) ; "Hal is her eldest."
			)
			(3 ; Do
				(Say 1250 162 1) ; "The day I lay hands unwisely upon these healthy lads would be a day I rue."
			)
			(5 ; Talk
				(Converse 1 @local197 @local518 0 0) ; "We'll be in town often, so if you think of anything you need doing, you let us know."
			)
			(10 ; Longbow
				(Say 1250 163 1) ; "I don't threaten friends with my bow."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local201 @local518 0 0) ; "I'd not feel right taking that."
					)
					(0 ; bucks
						(Converse 1 @local205 @local518 0 0) ; "There must be poorer folk in greater need than us."
					)
					(else
						(super doVerb:)
					)
				)
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance hob of Prop
	(properties
		x 81
		y 148
		view 254
		loop 1
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 177 1) ; "Hob is the middle son."
			)
			(3 ; Do
				(Say 1250 162 1) ; "The day I lay hands unwisely upon these healthy lads would be a day I rue."
			)
			(5 ; Talk
				(Converse 1 @local177 @local509 0 0) ; "The merchants say the Saturday Fair coming will be the biggest fair yet."
			)
			(10 ; Longbow
				(Say 1250 163 1) ; "I don't threaten friends with my bow."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local181 @local509 0 0) ; "Thanks kindly, but I've a hunch Hal would thump me if I took your horn. I can tell by the way he's giving me the warning eye."
					)
					(0 ; bucks
						(gCurRoom setScript: giveHobBuck)
					)
					(else
						(super doVerb:)
					)
				)
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance dicken of Prop
	(properties
		x 66
		y 153
		view 254
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 180 1) ; "Dicken is her youngest."
			)
			(3 ; Do
				(Say 1250 162 1) ; "The day I lay hands unwisely upon these healthy lads would be a day I rue."
			)
			(5 ; Talk
				(self setScript: talkToDicky)
			)
			(10 ; Longbow
				(Say 1250 163 1) ; "I don't threaten friends with my bow."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(gCurRoom setScript: giveDickHorn)
					)
					(0 ; bucks
						(gCurRoom setScript: giveDickBuck)
					)
					(else
						(super doVerb:)
					)
				)
			)
			(else
				(super doVerb:)
			)
		)
	)
)

(instance widow of Prop
	(properties
		x 120
		y 149
		view 252
		signal 20480
		detailLevel 2
	)

	(method (init)
		(= local84 1)
		(if (== (self loop:) 0)
			(self setCycle: Fwd)
		)
		(super init:)
	)

	(method (cue)
		(self setCycle: Beg)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch gDay
					(1
						(Say 1250 49 1) ; "She's a handsome woman for her years, with wise and understanding eyes, and a keen wit."
					)
					(2
						(Say 1250 50 1) ; "There's a new strain in the Widow's face. I fear she worries about her sons."
					)
					(3
						(Say 1250 50 1) ; "There's a new strain in the Widow's face. I fear she worries about her sons."
					)
					(4
						(Say 1250 50 1) ; "There's a new strain in the Widow's face. I fear she worries about her sons."
					)
					(5
						(Say 1250 51 1) ; "It pains me to see such grief."
					)
					(6
						(if (IsFlag 25)
							(Say 1250 50 1) ; "There's a new strain in the Widow's face. I fear she worries about her sons."
						else
							(Say 1250 51 1) ; "It pains me to see such grief."
						)
					)
					(9
						(Say 1250 52 1) ; "It's a pleasure to see the Widow again."
					)
					(10
						(Say 1250 53 1) ; "Her fear and worry for Marian is almost as great as mine."
					)
					(else
						(Say 1250 52 1) ; "It's a pleasure to see the Widow again."
					)
				)
			)
			(3 ; Do
				(Say 1250 54 1) ; "There's nothing I wish to take from this good woman."
			)
			(5 ; Talk
				(switch gDay
					(1
						(cond
							((not (IsFlag 45))
								(SetFlag 45)
								(Converse 2 @local245 local82 0 @local500 1) ; "I've a mind to have a word or two with that friar of yours. He's rather fond of food for a holy man."
							)
							((IsFlag 66)
								(Converse 1 @local250 @local500 0) ; "Beggin' your pardon, Robin, but I'd best keep my mind on what I'm doing."
							)
							(else
								(SetFlag 66)
								(Converse 2 @local254 local82 0 @local500 1) ; "Was there something else you wanted?"
							)
						)
					)
					(2
						(if (IsFlag 66)
							(if (== gDisguiseNum 0) ; outlaw
								(Converse 1 @local259 @local500 0) ; "Pardon me, but I must keep my mind on my work."
							else
								(Converse 2 @local263 local82 0 @local500 1) ; "Aren't you going to Nottingham?"
							)
						else
							(SetFlag 66)
							(Converse 1 @local269 @local500 0) ; "Good day, Robin. The boys are in town, if you're looking for them."
						)
					)
					(5
						(Converse 1 @local284 @local500 0) ; "I cannot speak! Oh, my sons, my beautiful sons!"
						(SetFlag 66)
					)
					(6
						(if (not (IsFlag 25))
							(Converse 1 @local284 @local500 0) ; "I cannot speak! Oh, my sons, my beautiful sons!"
							(SetFlag 66)
						)
					)
					(7
						(switch gDisguiseNum
							(0 ; outlaw
								(cond
									(
										(and
											(not (IsFlag 42))
											(not (gEgo has: 4)) ; net
											(IsFlag 34)
										)
										(gEgo setScript: getNetAfterMary)
									)
									(
										(and
											(not (IsFlag 42))
											(not (gEgo has: 4)) ; net
											(not (IsFlag 34))
										)
										(SetFlag 66)
										(gEgo setScript: getTheNetJerk)
									)
									((IsFlag 34)
										(Converse 1 @local301 @local500 0) ; "'Tis always good to see you, Robin, but I'm sure you have more important tasks than wishing me good day."
									)
									((IsFlag 66)
										(Converse ; "I beg you, tell me more of speaking with the willows."
											2
											@local296
											local82
											0
											@local500
											1
										)
									)
									(else
										(SetFlag 66)
										(Converse ; "Good day, Robin. You'll be on your way to see Marian in the sacred grove, I believe?"
											2
											@local288
											local82
											0
											@local500
											1
										)
									)
								)
							)
							(6 ; fens monk
								(Converse 1 @local321 @local500 0) ; "I suppose you must be on some urgent mission, Robin, so I'll not detain you with idle chatter."
							)
							(5 ; abbey monk
								(Converse 1 @local321 @local500 0) ; "I suppose you must be on some urgent mission, Robin, so I'll not detain you with idle chatter."
							)
						)
					)
					(9
						(switch gDisguiseNum
							(0 ; outlaw
								(if (IsFlag 66)
									(Converse 1 @local325 @local500 0) ; "I would not dally here in this clearing today."
								else
									(SetFlag 66)
									(Converse 2 @local329 local82 0 @local500 1) ; "Robin, I'm pleased to see you safe. The forest is crawling with Sheriff's men."
								)
							)
							(6 ; fens monk
								(Converse 1 @local321 @local500 0) ; "I suppose you must be on some urgent mission, Robin, so I'll not detain you with idle chatter."
							)
							(5 ; abbey monk
								(Converse 1 @local321 @local500 0) ; "I suppose you must be on some urgent mission, Robin, so I'll not detain you with idle chatter."
							)
							(3 ; jewler (rouge)
								(Converse 1 @local335 @local500 0) ; "No point dallying here. If you mean to do something in that disguise, you best be off doing it."
							)
							(2 ; jewler (no rouge)
								(Converse 1 @local335 @local500 0) ; "No point dallying here. If you mean to do something in that disguise, you best be off doing it."
							)
							(4 ; yeoman
								(if (IsFlag 66)
									(Converse 1 @local350 @local500 0) ; "Not meaning to be rude, but I must keep my mind on my spinning."
								else
									(SetFlag 66)
									(Converse 2 @local354 local82 0 @local500 1) ; "Greetings madam. I wonder if--"
								)
							)
						)
					)
					(10
						(if (IsFlag 66)
							(Converse 1 @local362 @local500 0) ; "I cannot offer any help in a battle, but if there's need for me after, I'll be there."
						else
							(SetFlag 66)
							(Converse 2 @local366 local82 0 @local500 1) ; "Thank the Blessed Lady that you've come! Something terrible has happened to Marian."
						)
					)
					(else
						(Converse 1 @local250 @local500 0) ; "Beggin' your pardon, Robin, but I'd best keep my mind on what I'm doing."
					)
				)
			)
			(10 ; Longbow
				(Say 1250 119 1) ; "I don't threaten friends with my bow."
			)
			(4 ; Inventory
				(if (== (widow loop:) 1)
					(Say 1250 120 1) ; "She wants nothing but the safe return of her sons."
				else
					(switch invItem
						(1 ; horn
							(Converse 1 @local376 @local500 0) ; "Don't be absurd. I couldn't make a peep upon the thing."
						)
						(0 ; bucks
							(Converse 1 @local380 @local500 0) ; "We're doing well enough. Save your coins for those who truly need them."
						)
						(2 ; halfHeart
							(Converse 1 @local384 @local500 0) ; "That's the most precious thing you could ever possess, Robin. Never let it beyond your grasp."
						)
						(3 ; slipper
							(Converse 1 @local388 @local500 0) ; "Well, that's a fine looking slipper, isn't it?"
						)
						(15 ; comb
							(Converse 1 @local392 @local500 0) ; "This doesn't belong to me."
						)
						(14 ; amethyst
							(Converse 1 @local396 @local500 0) ; "What a lovely stone! Still, I'm sure you have more need of it than I would."
						)
						(12 ; puzzleBox
							(if (gEgo has: 10) ; fireRing
								(Converse 2 @local400 local82 0 @local500 1) ; "I've opened this box once, but it's locked itself again. If you'd like to have it..."
								(gEgo put: 12) ; puzzleBox
							else
								(Converse 2 @local405 local82 0 @local500 1) ; "Why it's a puzzle box. Do you know how to open it?"
							)
						)
						(10 ; fireRing
							(Converse 1 @local411 @local500 0) ; "There's the aura of powerful magic in this ring. Keep it safe and close, Robin."
						)
						(13 ; robes
							(Converse 1 @local415 @local500 0) ; "Hmmp. Their wool doesn't stand up to mine. Inferior work. Keep the silly thing."
						)
						(17 ; handScroll
							(Converse 2 @local423 local82 0 @local500 1) ; "Marian sent you for this, no doubt."
						)
						(16 ; fulkScroll
							(if (gEgo has: 10) ; fireRing
								(Converse 2 @local429 local82 0 @local500 1) ; "These are most amusing, may I keep them."
							else
								(Converse 2 @local434 local82 0 @local500 1) ; "Where on earth did you find these verses? They're filled with tree lore."
							)
						)
						(18 ; waterRing
							(Converse 1 @local440 @local500 0) ; "There's a gentle, but powerful magic working within this ring. Hold on to it."
						)
						(4 ; net
							(if (IsFlag 66)
								(Converse 1 @local444 @local500 0) ; "Don't seek to return it to me. That will avail you nothing. Take it into the forest."
							else
								(SetFlag 66)
								(Converse 1 @local448 @local500 0) ; "You've not used it yet? Well, I'm sure your wits will not fail you in finding its use."
							)
						)
						(else
							(super doVerb: theVerb)
						)
					)
				)
			)
		)
	)
)

(instance tuckActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 ; Look
					(Say 1250 203 1) ; "I can read the unspoken message in his eyes. I must save her sons."
					1
				)
				(3 ; Do
					(Say 1250 204 1) ; "Tuck has nothing need to take."
					1
				)
				(5 ; Talk
					(Converse 1 @local479 15 0 0) ; "You go ahead. The widow needs my comfort for a short while yet."
					1
				)
			)
		)
	)
)

(instance lamb of Prop
	(properties
		x 242
		y 122
		view 250
		signal 16449
		detailLevel 2
	)

	(method (init)
		(= local83 1)
		(super init:)
	)

	(method (cue)
		(baaSound play:)
		(self cycleSpeed: (Random 6 24) setCycle: Beg)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 151 1) ; "That's a mean-looking old ewe."
			)
			(3 ; Do
				(Converse 1 @local209 @local554 0 0) ; "Touch me and I'll give you such a bleating."
			)
			(5 ; Talk
				(gCurRoom setScript: mouthyLamb)
			)
			(10 ; Longbow
				(Say 1250 153 1) ; "I doubt that old ewe would be worth the arrow. Mutton from that wouldn't be worth eating."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Converse 1 @local213 @local554 0 0) ; "Give it to a sheep? What a woolly-brained thought."
					)
					(0 ; bucks
						(Converse 1 @local217 @local554 0 0) ; "Would that be advance payment on a tunic?"
					)
					(2 ; halfHeart
						(Converse 1 @local213 @local554 0 0) ; "Give it to a sheep? What a woolly-brained thought."
					)
					(14 ; amethyst
						(Converse 1 @local213 @local554 0 0) ; "Give it to a sheep? What a woolly-brained thought."
					)
					(12 ; puzzleBox
						(Converse 1 @local213 @local554 0 0) ; "Give it to a sheep? What a woolly-brained thought."
					)
					(10 ; fireRing
						(Converse 1 @local213 @local554 0 0) ; "Give it to a sheep? What a woolly-brained thought."
					)
					(3 ; slipper
						(Converse 1 @local229 @local554 0 0) ; "Doesn't fit her."
					)
					(15 ; comb
						(Converse 1 @local233 @local554 0 0) ; "That would be a good way to get fleeced."
					)
					(13 ; robes
						(Converse 1 @local221 @local554 0 0) ; "Just what I need, more wool."
					)
					(17 ; handScroll
						(Converse 1 @local225 @local554 0 0) ; "Is that made of sheepskin? You beast!"
					)
					(16 ; fulkScroll
						(Converse 1 @local225 @local554 0 0) ; "Is that made of sheepskin? You beast!"
					)
					(4 ; net
						(Converse 1 @local241 @local554 0 0) ; "As if I need a net to catch a bad tempered sheep."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getTheNetJerk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local288 local82 0 @local500 1 self) ; "Good day, Robin. You'll be on your way to see Marian in the sacred grove, I believe?"
			)
			(1
				(Converse 2 @local305 1 0 @local500 1 self) ; "I must give thanks for the safe return of my sons."
			)
			(2
				(gEgo setMotion: PolyPath (widow x:) (+ (widow y:) 10) self)
			)
			(3
				(widow setCycle: 0)
				(Face gEgo widow)
				(= ticks 12)
			)
			(4
				(Converse 2 @local315 1 0 @local500 1 self) ; "A golden net! For what prey?"
			)
			(5
				(widow setCycle: Fwd)
				(gEgo get: 4) ; net
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getNetAfterMary of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local305 1 0 @local500 1 self) ; "I must give thanks for the safe return of my sons."
			)
			(1
				(gEgo setMotion: PolyPath (widow x:) (+ (widow y:) 10) self)
			)
			(2
				(widow setCycle: 0)
				(Face gEgo widow)
				(= ticks 12)
			)
			(3
				(Converse 2 @local315 1 0 @local500 1 self) ; "A golden net! For what prey?"
			)
			(4
				(widow setCycle: Fwd)
				(gEgo get: 4) ; net
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(HandsOff)
				(switch gEgoEdgeHit
					(1
						(if (> global104 130)
							(= global104 129)
						)
						(gEgo
							posn: global104 240
							init:
							setMotion: PolyPath global104 184 self
						)
					)
					(2
						(gEgo
							posn: 1 global105
							init:
							setMotion:
								PolyPath
								26
								(if (< global105 170) 170 else global105)
								self
						)
					)
					(3
						(if (< global104 180)
							(gEgo
								posn: 65 107
								init:
								setMotion: PolyPath 65 112 self
							)
						else
							(gEgo
								posn: 265 107
								init:
								setMotion: PolyPath 268 112 self
							)
						)
					)
					(4
						(if (> global105 137)
							(= global105 136)
						)
						(if (< global105 106)
							(= global105 106)
						)
						(gEgo
							posn: 318 global105
							init:
							setMotion: PolyPath 298 (+ global105 5) self
						)
					)
					(else
						(gEgo
							posn: 1 185
							loop: 3
							init:
							setMotion: PolyPath 26 185 self
						)
					)
				)
			)
			(1
				(if (IsFlag 179)
					(ClearFlag 179)
					(Say 1250 201) ; "Thank the Blessed Virgin! The sprite's spell has worn off!"
					(Say 1250 202) ; "The forest has shrunk to normal size again."
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(2
				(switch gDay
					(3
						(if (and (not (IsFlag 66)) (== gDisguiseNum 1)) ; beggar
							(SetFlag 66)
							(Converse 2 @local273 local82 0 @local500 1 self) ; "Charity madam? A crust of bread for a poor old beggar?"
						else
							(self cue:)
						)
					)
					(9
						(if
							(and
								(not (IsFlag 66))
								(or (== gDisguiseNum 3) (== gDisguiseNum 2)) ; jewler (rouge), jewler (no rouge)
							)
							(SetFlag 66)
							(Converse 2 @local339 local82 0 @local500 1 self) ; "How are you this fine morning, m'lady?"
						else
							(self cue:)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(NormalEgo)
				(local0 cue:)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(3
						(= temp1 240)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(if (!= register 1)
					(gEgo
						ignoreActors: 1
						setMotion: PolyPath temp0 temp1 self
					)
				else
					(self cue:)
				)
			)
			(1
				(HandsOn)
				(if (and (IsFlag 46) (IsFlag 44) (== gDay 1))
					(self cue:)
				else
					(gCurRoom newRoom: 220) ; forest
					(self dispose:)
				)
			)
			(2
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803)
				(= ticks 60)
			)
			(3
				(gCurRoom style: 8 newRoom: 160)
				(self dispose:)
			)
		)
	)
)

(instance handOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Face gEgo widow)
				(= ticks 18)
			)
			(2
				(Converse 3 @local89 local82 0 @local500 1 @local518 2 self) ; "Ah, it's the good Widow and her three fine sons, Hal, Hob, and Dicken."
			)
			(3
				(Converse ; "We're going to town today, Master, if there's anything you need."
					4
					@local98
					local82
					0
					@local500
					1
					@local509
					2
					@local527
					3
					self
				)
			)
			(4
				(Converse 2 @local106 local82 0 @local518 2 self) ; "Don't worry. We'll keep the whelp under control."
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance boysBusted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo
					setMotion: PolyPath (+ (widow x:) 10) (+ (widow y:) 30) self
				)
			)
			(2
				(Face gEgo widow)
				(= ticks 18)
			)
			(3
				(Converse 3 @local452 2 0 15 1 @local500 2 self) ; "Robin! I was about to go for you. What luck that you've come."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance boysSaved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo
					setMotion: PolyPath (+ (widow x:) 10) (+ (widow y:) 30) self
				)
			)
			(2
				(Face gEgo widow)
				(= ticks 18)
			)
			(3
				(if (== gPrevRoomNum 179) ; synop
					(Converse ; "You're all so brave. I can hardly believe you're here. It seems a miracle."
						4
						@local131
						local82
						0
						@local500
						1
						@local518
						2
						@local509
						3
						self
					)
				else
					(Converse ; "I made a fine monk. You should have seen us!"
						5
						@local111
						3
						0
						@local500
						1
						@local518
						2
						@local509
						3
						@local527
						4
						self
					)
				)
			)
			(4
				(if (== gPrevRoomNum 179) ; synop
					(Converse 3 @local142 3 0 @local500 1 @local509 2 self) ; "The joy upon your face is payment enough."
				else
					(self cue:)
				)
			)
			(5
				(gEgo setMotion: PolyPath (widow x:) (+ (widow y:) 10) self)
			)
			(6
				(Face gEgo widow)
				(gEgo get: 4) ; net
				(= ticks 12)
			)
			(7
				(gSFX number: 916 loop: 1 play:)
				(+= gScore 50)
				((ScriptID 0 1) doit:) ; statLine
				(= ticks 6)
			)
			(8
				(if (== gPrevRoomNum 179) ; synop
					(Converse 2 @local150 3 0 @local500 1 self) ; "This golden net is my gift."
				else
					(Converse 2 @local125 3 0 @local500 1 self) ; "This golden net is my gift. Use it well, and it will lead you to wisdom. Use it wisely, and the forest itself will protect you."
				)
			)
			(9
				(AddOutlaws 3)
				(hal setCycle: End)
				(hob setCycle: End)
				(dicken setCycle: End)
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 30) (+ (gEgo y:) 15)
				)
				(= ticks 120)
			)
			(10
				(gEgo setMotion: 0 setCycle: 0)
				(gCast eachElementDo: #hide)
				(DrawPic 803 8 1 0)
				(= ticks 18)
			)
			(11
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance mouthyLamb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local157 @local500 0 @local554 1 self) ; "It's about time someone asked my opinion around here."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToDicky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local165 @local500 0 @local527 1 self) ; "I'm not afraid of no Sheriff's men. If they grab me, I'll--"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveHobBuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local171 @local500 0 @local509 1 self) ; "There's this cock fight I wanted to bet on--"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveDickBuck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local185 @local500 0 @local527 1 self) ; "Aw, what's the use? I know mum won't let me keep it. Here take it back."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveDickHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local191 @local500 0 @local527 1 self) ; "I can really have your horn?! Just like a real outlaw?!"
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tuckChill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(or
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 3)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 6)
					)
					(gEgo view: 10 loop: 0)
				else
					(gEgo view: 10 loop: 1)
				)
				(= ticks 60)
			)
			(1
				(Converse 1 @local468 15 0 self) ; "Robin, wait, if I may be so bold."
			)
			(2
				(= ticks 30)
			)
			(3
				(Converse 2 @local472 2 0 15 1 self) ; "Aye, Tuck?"
			)
			(4
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance widowChill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(or
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 3)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 6)
					)
					(gEgo view: 10 loop: 0)
				else
					(gEgo view: 10 loop: 1)
				)
				(= ticks 30)
			)
			(1
				(Converse 2 @local460 2 0 @local500 1 self) ; "Hold, Robin!"
			)
			(2
				(NormalEgo)
				(SetFlag 185)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance widowBlow of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(cond
					(
						(and
							(== gDay 5)
							(gCast contains: (ScriptID 23)) ; Tuck
							(not local88)
						)
						(= local88 1)
						(gEgo setScript: tuckChill)
						1
					)
					((== gDay 5)
						(Say 1250 188 1) ; "I told Tuck I'd not wind the horn here, so I will not."
						1
					)
					((and (== gDay 6) (not (IsFlag 25)))
						(Say 1250 189 1) ; "I'll not disturb the Widow in her grief and worry by winding my horn here."
						1
					)
					((IsFlag 185)
						(Say 1250 191 1) ; "I'll respect the Widow's wish that I not blow my horn here."
						1
					)
					((gCast contains: widow)
						(gEgo setScript: widowChill)
						1
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 175
		y 20
		view 250
		loop 2
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doVerb)
		(super doVerb:)
	)
)

(instance noGoat of Feature
	(properties
		y 130
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 272 117 250 125 224 120 223 92 240 103 252 106 272 101
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 205 1) ; "The sheep pen is empty."
			)
			(3 ; Do
				(Say 1250 206 1) ; "The ewe is gone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roof of Feature
	(properties
		y 85
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 276 99 252 105 243 104 222 91 183 97 176 92 166 94 88 76 91 70 82 65 108 51 129 26 168 25 168 19 186 20 187 24 212 24 262 89
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 207 1) ; "The roof is thatched."
			)
			(3 ; Do
				(Say 1250 208 1) ; "I've no need for thatching. I live in a cave."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWoods of Feature
	(properties
		y 25
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 81 80 0 80 0 0 319 0 319 106 263 89 212 23 133 27 109 49 81 65
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 209 1) ; "The forest surrounds and hides the cottage."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eastWall of Feature
	(properties
		y 130
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 221 117 161 127 161 92 178 93 185 99 222 94
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 210 1) ; "The widow has a simple stone cottage."
			)
			(3 ; Do
				(Say 1250 211 1) ; "It's solidly built. But I could tell that from looking at it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance midWall of Feature
	(properties
		y 115
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 160 127 129 119 131 87 160 93
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 210 1) ; "The widow has a simple stone cottage."
			)
			(3 ; Do
				(Say 1250 211 1) ; "It's solidly built. But I could tell that from looking at it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westWall of Feature
	(properties
		y 100
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 120 116 92 106 93 101 83 96 83 69 89 71 85 75 120 85
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 210 1) ; "The widow has a simple stone cottage."
			)
			(3 ; Do
				(Say 1250 211 1) ; "It's solidly built. But I could tell that from looking at it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		y 120
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 129 86 128 121 120 118 120 84
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 212 1) ; "The cottage has a very small door."
			)
			(3 ; Do
				(Say 1250 213 1) ; "I would not be so bold as to enter without being invited."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chimney of Feature
	(properties
		y 30
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 187 24 168 25 168 19 185 20
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 214 1) ; "'Tis the chimney."
			)
			(3 ; Do
				(Say 1250 215 1) ; "I can't reach it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock of Feature
	(properties
		y 130
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 48 125 38 127 32 121 0 121 0 112 8 105 21 104 34 108
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 216 1) ; "A boulder is of no great interest."
			)
			(3 ; Do
				(Say 1250 217 1) ; "Rather heavy to carry around."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stream of Feature
	(properties
		y 150
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 273 93 319 107 319 145 214 189 156 189 265 147 294 144 308 129 297 107
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1250 218 1) ; "She has a small, clean brook in this clearing."
			)
			(3 ; Do
				(Say 1250 219 1) ; "I've no need for water now."
			)
			(5 ; Talk
				(Say 1250 220) ; "It's a babbling brook. Listen..."
				(SetMessageColor 24)
				(Say 1250 221) ; "A mind is a terrible thing to lose. No, wait, I meant, it's a terrible waste to lose a mind. No, what I really meant was....what was I saying?"
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(if (== invItem 18) ; waterRing
					(Say 1250 222 1) ; "Nothing in this water responds to the water ring. It must not possess any water spirits."
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

(instance baaSound of Sound
	(properties
		flags 1
		number 936
	)
)

