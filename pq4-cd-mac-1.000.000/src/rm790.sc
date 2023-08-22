;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm790 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm790 of Room
	(properties
		noun 23
		picture 790
		style 0
	)

	(method (init)
		(proc0_4 1)
		(gGame handsOff:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 305 130 291 130 210 126 165 125 109 115 103 119 132 121 132 124 105 124 105 127 170 135 183 141 305 141
					yourself:
				)
		)
		(LoadMany rsVIEW 7950 9059)
		(gGlobalSound0 number: 790 loop: -1 play: setVol: 90)
		(if (== gDay 2)
			(self setScript: val1Scr)
			(egoEnterScr register: 3)
			(box init:)
		else
			(LoadMany rsVIEW 7908 7909 7903 7904 7907)
			(gPqFlags set: 7)
			(self setScript: kathEnterScr)
			(egoEnterScr register: 4)
			((View new:)
				view: 7950
				loop: 2
				cel: 0
				x: 188
				y: 143
				z: 24
				priority: 200
				fixPriority: 1
				signal: 16384
				noun: 21
				init:
				yourself:
			)
		)
		(super init: &rest)
		(gEgo
			normalize: 9797
			posn: 87 122 0
			setPri: 5
			setScaler: Scaler 100 75 141 116
			init:
			setScript: egoEnterScr
		)
		(closet init:)
		(loveSeat init:)
		(coffeeTable init:)
		(hall init:)
		(farPic init:)
		(nearLamp init:)
		(nearPic init:)
		(ironShelf init:)
		(nearFlowers init:)
		(roundTable init:)
		(couch init:)
		(farFlowers init:)
		(uglyTable init:)
		(farLamp init:)
		(exitFeat init:)
		(gTheIconBar show: 0)
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
		(gGame doRemap: 2 245 85)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((exitFeat doit:) 0)
			((and (not (gEgo fixPriority:)) (< (gEgo y:) 123))
				(gEgo fixPriority: 1 priority: 5)
			)
			((and (gEgo fixPriority:) (>= (gEgo y:) 123))
				(gEgo fixPriority: 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound0 fade:)
		(kathBody actions: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance exitFeat of Feature
	(properties)

	(method (init)
		(self createPoly: 117 112 111 121 99 121 108 112)
		(super init: &rest)
	)

	(method (doit)
		(cond
			((not (self onMe: gEgo))
				(return 0)
			)
			((gEgo script:)
				(return 0)
			)
			(local0
				(gGame handsOff:)
				(gCurRoom setScript: cantLeaveScr 0 0)
			)
			((not (gCast contains: kath))
				(gGame handsOff:)
				(gCurRoom setScript: byeScr 0 1)
			)
			((== gDay 2)
				(gGame handsOff:)
				(gCurRoom setScript: byeScr 0 2)
			)
			((and (== gDay 3) (not (gEgo has: 26))) ; pills
				(gGame handsOff:)
				(gCurRoom setScript: cantLeaveScr 0 1)
			)
			((== gDay 3)
				(gGame handsOff:)
				(gCurRoom setScript: byeScr 0 3)
			)
			(else
				(gCurRoom newRoom: 780)
			)
		)
	)
)

(instance cantLeaveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(if register
					(gMessager say: 20 2 44 0) ; "John, please take the pills from the closet with you. I really can't stand the thought of them in the house."
				else
					(gMessager say: 0 0 26 1) ; "Detective, leaving now would be rude."
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance byeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= cycles 1)
					)
					(2
						(kath setCycle: End self)
					)
					(3
						(kath setCycle: End self)
					)
				)
			)
			(1
				(switch register
					(1
						(gMessager say: 4 2 27 0 self) ; "Bye, Uncle John."
					)
					(2
						(gMessager say: 0 0 27 4 self) ; "Thank you, John... thank you for coming by."
					)
					(3
						(gMessager say: 0 0 27 0 self) ; "John, I'm going to be gone for a couple of days. I'm taking Valerie to my mother's. I think she and I could both use some rest."
					)
				)
			)
			(2
				(gCurRoom newRoom: 780)
			)
		)
	)
)

(instance coffeeTable of Feature
	(properties
		noun 5
		x 206
		y 142
		z 10
	)

	(method (init)
		(self
			createPoly: 200 113 252 113 245 122 248 140 245 142 241 134 226 153 160 154 167 141 157 134 157 131
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 14) ; hickmanStuff
			(if (or (not (gCast contains: kath)) (== (kath script:) waitScr))
				(gMessager say: noun theVerb 19 0) ; "It's not a good idea to leave this without first telling Katherine about it."
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance couch of Feature
	(properties
		noun 7
		x 113
		y 124
	)

	(method (init)
		(self
			createPoly: 57 143 56 102 67 97 116 90 161 91 164 97 164 128 157 132 157 138 123 149
		)
		(super init: &rest)
	)
)

(instance hall of Feature
	(properties
		noun 8
		x 132
		y 83
	)

	(method (init)
		(self createPoly: 174 18 174 119 165 117 165 95 162 90 114 89 114 10)
		(super init: &rest)
	)
)

(instance farPic of Feature
	(properties
		noun 9
		x 251
		y 71
	)

	(method (init)
		(self createPoly: 233 29 267 28 267 71 233 72)
		(super init: &rest)
	)
)

(instance nearLamp of Feature
	(properties
		noun 10
		x 29
		y 138
	)

	(method (init)
		(self createPoly: 0 47 14 34 33 34 60 63 31 65 31 140 25 140 23 64 0 64)
		(super init: &rest)
	)
)

(instance nearPic of Feature
	(properties
		noun 11
		x 58
		y 71
	)

	(method (init)
		(self createPoly: 32 25 82 28 82 73 30 73)
		(super init: &rest)
	)
)

(instance ironShelf of Feature
	(properties
		noun 18
		x 6
		y 138
	)

	(method (init)
		(self createPoly: 0 30 8 32 18 140 0 138)
		(super init: &rest)
	)
)

(instance nearFlowers of Feature
	(properties
		noun 13
		x 81
		y 125
	)

	(method (init)
		(self
			createPoly: 72 125 71 118 73 113 65 105 74 101 83 96 94 97 97 100 87 111 90 116 89 121 84 125
		)
		(super init: &rest)
	)
)

(instance roundTable of Feature
	(properties
		noun 14
		x 82
		y 144
	)

	(method (init)
		(self
			createPoly: 78 144 79 131 70 131 61 128 62 125 69 122 84 122 99 124 100 128 90 131 83 131 84 144
		)
		(super init: &rest)
	)
)

(instance farFlowers of Feature
	(properties
		noun 15
		x 297
		y 94
	)

	(method (init)
		(self
			createPoly: 291 95 290 85 278 80 281 70 299 68 309 78 305 79 305 94
		)
		(super init: &rest)
	)
)

(instance uglyTable of Feature
	(properties
		noun 16
		x 297
		y 124
	)

	(method (init)
		(self
			createPoly: 280 120 282 100 277 94 285 92 316 92 314 109 313 123 291 128
		)
		(super init: &rest)
	)
)

(instance farLamp of Feature
	(properties
		noun 17
		x 285
		y 67
	)

	(method (init)
		(self
			createPoly: 282 70 282 57 271 57 270 54 279 36 291 36 300 57 289 57 287 68
		)
		(super init: &rest)
	)
)

(instance loveSeat of Feature
	(properties
		noun 6
		x 245
		y 124
	)

	(method (init)
		(self
			createPoly: 218 85 277 84 279 119 273 125 248 126 245 122 253 112 205 112 207 106 213 100
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gEgo script:))
				(gGame handsOff:)
				(gCurRoom setScript: sitDownScr)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sitDownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 215 131 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(gEgo
					view: 9059
					setScaler: 0
					setLoop: 1 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setScript: egoHandleScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoHandleScr of Script
	(properties)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(gGame handsOff:)
			(= local1 (event x:))
			(= local2 (event y:))
			(gCurRoom setScript: standUpScr)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance standUpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(if (not caller)
					(gGame handsOn:)
					(gEgo
						normalize: 9797
						setScript: 0
						setScaler: Scaler 100 75 141 116
					)
					(gEgo setMotion: PolyPath local1 local2)
				else
					(gEgo
						normalize: 9797
						setScript: 0
						setScaler: Scaler 100 75 141 116
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance box of View
	(properties
		noun 3
		x 185
		y 143
		z 10
		priority 200
		fixPriority 1
		view 7950
		signal 20480
	)
)

(instance kathTeller of Teller
	(properties
		sayNoun 22
		verb 5
	)

	(method (showCases)
		(super showCases: 23 (not (gPqFlags test: 33)) 25 (gPqFlags test: 33))
	)

	(method (sayMessage)
		(if (and (== gDay 2) (not (gPqFlags test: 33)) (== iconValue 23))
			(gGame handsOff:)
			(gCurRoom setScript: upsetScr)
		)
		(if (and (== gDay 2) (gPqFlags test: 33) (== iconValue 25))
			(gPqFlags set: 34)
		)
		(super sayMessage:)
	)
)

(instance kath of Actor
	(properties
		noun 20
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(cond
					((== gDay 3)
						(switch (++ local5)
							(1
								(gMessager say: noun theVerb 28 0) ; "Katherine, I wasn't informed about the time. I wanted to be there."
							)
							(2
								(gMessager say: noun theVerb 29 0) ; "Thanks for your concern, Katherine, but you don't need to worry about me. I should've called or..."
							)
							(3
								(gMessager say: noun theVerb 30 0) ; "Well, there's good news. Bob's name has been cleared of any wrongdoing or involvement with the Washington boy's death."
							)
							(4
								(gCurRoom setScript: talkScr)
							)
							(else
								(gMessager say: noun theVerb 32) ; "John, I sent Bob out there to be killed. It's all my fault."
							)
						)
					)
					(local5 0)
					(else
						(if (gPqFlags test: 33)
							(gMessager say: noun theVerb 40 0) ; "Katherine, I really need to ask you some questions. Can we try again?"
						else
							(gMessager say: noun theVerb 23 0) ; "Katherine, I've been assigned lead investigator on this case. I need to ask you some questions. Are you feeling up to it?"
						)
						(++ local5)
						(kathTeller init: kath 790)
						(kathBody actions: kathTeller)
					)
				)
			)
			((== theVerb 14) ; hickmanStuff
				(gGame handsOff:)
				(if (== gDay 2)
					(gGame points: 3)
				)
				(gCurRoom setScript: getVestScr)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local4)
						(gMessager say: 20 22 20) ; "Holster your weapon! Are you insane?"
						(++ local4)
					)
					(((ScriptID 32 0) doit: 20 22 21 1 790) ; ShootHandgun, "Deadly use of force was uncalled for. You will spend the rest of your life pondering your decision in a six foot by six foot cell."
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kathBody of Prop
	(properties
		x 141
		y 152
		view 794
		loop 2
	)

	(method (doVerb theVerb)
		(kath doVerb: theVerb &rest)
	)
)

(instance talkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 2 31 1 self) ; "Katherine, I know this is a rough time for you, but I need to ask you to think back to the night of the murder. Can you think of anything out of the ordinary happening that night."
			)
			(1
				(gMessager say: 20 2 31 2 self) ; "Any phone calls? Anything Bob might have said? Did he mention anyone, maybe a name you're unfamiliar with?"
			)
			(2
				(gMessager say: 20 2 31 3 self) ; "Bob and I had an argument... he went out, John. I don't know where he went, or if he saw anyone. Thing is, he didn't take our car."
			)
			(3
				(gMessager say: 20 2 31 4 self) ; "I don't think anyone picked him up. I mean, we started arguing and the whole thing just blew up. He was gone before I really had a chance to understand what happened."
			)
			(4
				(gMessager say: 20 2 31 5 self) ; "Can you tell me what you argued about?"
			)
			(5
				(gMessager say: 20 2 31 6 self) ; "We fought over his drinking. He... everything was manageable until he started taking sedatives to calm down from work."
			)
			(6
				(gMessager say: 20 2 31 7 self) ; "The combination made him mean... he'd yell at Valerie, me... for no reason. That's how he left when he went out that night. He'd been drinking and taking pills."
			)
			(7
				(if (not (gEgo has: 26)) ; pills
					(gMessager say: 20 2 31 8) ; "John, those pills are in the closet. I'd like it if you'd take them out of here."
					(gPqFlags set: 34)
				)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance val of Prop
	(properties
		noun 4
		x 105
		y 127
		view 7910
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(if (not (gCast contains: kath))
					(switch local6
						(0
							(++ local6)
							(gMessager say: noun theVerb 19 0) ; "Valerie, do you understand what's happened?"
						)
						(1
							(++ local6)
							(gMessager say: noun theVerb 38 0) ; "Valerie, can you remember anything that happened the night your dad went out and didn't come home?"
						)
						(2
							(++ local6)
							(gMessager say: noun theVerb 39 0) ; "Was your dad bringing a lot of work home, Val?"
							(gPqFlags set: 34)
						)
						(else
							(gMessager say: noun theVerb 3 0) ; "That's a nice dress you're wearing, Valerie."
						)
					)
				else
					(switch local6
						(0
							(++ local6)
							(gMessager say: noun theVerb 3 0) ; "That's a nice dress you're wearing, Valerie."
						)
						(else
							(gMessager say: noun theVerb 37 0) ; "You feeling OK, Valerie?"
						)
					)
				)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local3)
						(gMessager say: 4 22 20) ; "Holster your weapon, Carey! Valerie is an innocent child!"
						(++ local3)
					)
					(((ScriptID 32 0) doit: 4 22 22 1 790) ; ShootHandgun, "Your deadly aggression slaps you with a life sentence."
						(return 1)
					)
				)
			)
			((OneOf theVerb 74 30) ; candyBar, cigarette
				(if
					(or
						(not (gCast contains: kath))
						(== (kath script:) waitScr)
					)
					(gMessager say: noun theVerb 19)
				else
					(gMessager say: noun theVerb 3)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closet of Feature
	(properties
		noun 1
		nsLeft 92
		nsTop 32
		nsRight 111
		nsBottom 90
		sightAngle 40
		approachX 102
		approachY 126
		approachDist 70
		x 101
		y 61
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(switch gDay
				(2
					(cond
						(
							(and
								(gCast contains: kath)
								(== (kath script:) waitScr)
							)
							(gGame handsOff:)
							(gCurRoom setScript: whatchaDoinScr)
						)
						((gPqFlags test: 34)
							(gGame handsOff:)
							(gGame points: 5 88)
							(gCurRoom setScript: closetScr)
						)
						((gCast contains: kath)
							(gMessager say: 1 4 3) ; "John, I'd appreciate it if you wouldn't snoop around here like that. It makes me nervous!"
						)
						(else
							(gMessager say: 1 4 2) ; "You're not supposed to open that."
						)
					)
				)
				(3
					(if (gPqFlags test: 34)
						(gGame handsOff:)
						(gGame points: 5 88)
						(gCurRoom setScript: closetScr)
					else
						(gMessager say: 1 4 3) ; "John, I'd appreciate it if you wouldn't snoop around here like that. It makes me nervous!"
					)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance closetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo signal:) $0800)
					(self setScript: standUpScr self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					normalize: 9797
					setMotion:
						PolyPath
						(closet approachX:)
						(closet approachY:)
						self
				)
			)
			(2
				(gCurRoom setInset: closetInset)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closetInset of Inset
	(properties
		picture 795
		y 0
		disposeNotOnMe 1
	)

	(method (init)
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 6 show: 0)
		(Platform 0 2 1)
		(super init: &rest)
		(closetShelf init:)
		(clothes0 init:)
		(clothes1 init:)
		(clothes2 init:)
		(clothes3 init:)
		(clothes4 init:)
		(clothes5 init:)
		(clothes6 init:)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 109 (param1 x:) 211) (<= 0 (param1 y:) 145)))
	)

	(method (dispose)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
		(Platform 0 2 0)
	)
)

(instance closetShelf of Feature
	(properties
		nsLeft 115
		nsTop 1
		nsRight 202
		nsBottom 27
		y 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 1 1 15 0) ; "This shelf is cleaner than most!"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance clothes0 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self createPoly: 122 37 117 56 119 144 139 144 137 54 130 36)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 5 0) ; "Lightweight jacket. Misses, size 8."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 5 0) ; "Wasn't this what you were looking for?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes1 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self createPoly: 150 40 139 55 142 142 155 142 155 53 158 48)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 6 0) ; "Denim jacket."
			)
			((== theVerb 4) ; Do
				(if (not (gEgo has: 26)) ; pills
					(gMessager say: noun theVerb 13 0) ; "Reaching into the pocket, you discover a prescription bottle."
					(gGame points: 2)
					(gEgo get: 26) ; pills
				else
					(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
				)
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 6 0) ; "This might be important, keep it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes2 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self createPoly: 159 46 156 53 157 142 166 140 158 118 157 99 164 44)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 7 0) ; "Valerie's winter coat."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 7 0) ; "These pills might have bearing on your case, keep them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes3 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self createPoly: 159 95 159 117 163 130 169 132 169 128 171 39 166 44)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 8 0) ; "Raincoat."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 8 0) ; "A good detective would keep these and research their importance."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes4 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self createPoly: 170 130 172 134 184 130 184 88 182 84 180 37 173 45)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 9 0) ; "Menswear."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 9 0) ; "Use your detective skills, Detective, keep these."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes5 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self
			createPoly: 182 66 184 85 183 130 180 140 188 142 186 134 189 80 195 74 185 42
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 10 0) ; "Weekend wear."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 10 0) ; "You've discovered these, now research their importance!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clothes6 of Feature
	(properties
		noun 2
		y 20
	)

	(method (init)
		(self
			createPoly: 196 74 190 79 188 135 198 136 199 79 198 47 193 54 194 64
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 11 0) ; "Winter sweater."
			)
			((== theVerb 4) ; Do
				(gMessager say: noun theVerb 12 0) ; "Reaching into the pocket, you discover... pocket lint."
			)
			((== theVerb 39) ; pills
				(gMessager say: noun theVerb 11 0) ; "A good detective takes clues where he can find them."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance valInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(val
					view: 7911
					setLoop: 0
					cel: 0
					posn: 157 130
					setPri: 120
					cycleSpeed: 4
					init:
					signal: (| (val signal:) $5000)
					setCycle: End self
				)
			)
			(1
				(val setLoop: 1 cel: 0 posn: 157 130 setCycle: End self)
			)
			(2
				(val
					view: 7912
					setLoop: 0
					cel: 0
					posn: 154 130
					setCycle: End self
				)
			)
			(3
				(val setLoop: 1 cel: 0 posn: 178 130 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance val1Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(val
					init:
					signal: (| (val signal:) $5000)
					setPri: 110
					setCycle: End self
				)
			)
			(2
				(val
					setLoop: 1
					cel: 0
					posn: 105 128
					setPri: 120
					setCycle: End self
				)
			)
			(3
				(val dispose:)
				(if (not (gPqFlags test: 30))
					(gMessager say: 4 0 33 0) ; "Mom! Uncle John's here!"
					(gPqFlags set: 30)
					(waitScr register: 30)
				else
					(gMessager say: 4 0 14 0) ; "Mom! Uncle John is back! Mom!"
					(waitScr register: 3)
				)
				(kath
					view: 790
					loop: 0
					cel: 0
					init:
					signal: (| (kath signal:) $5000)
					x: 155
					y: 145
					setPri: 129
					setScript: waitScr
				)
				(self dispose:)
			)
		)
	)
)

(instance waitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(gGame handsOff: 1)
				(cond
					(
						(OneOf
							(gCurRoom script:)
							sitDownScr
							standUpScr
							cantLeaveScr
						)
						(self register: 3 init:)
					)
					(
						(or
							(== (gCurRoom script:) whatchaDoinScr)
							(< (gEgo x:) 185)
						)
						(egoEnterScr start: 2 register: 0)
						(gEgo setScript: egoEnterScr self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(2
				(kath cycleSpeed: 6 setCycle: End self)
			)
			(3
				(kath setLoop: 1 cel: 0 setCycle: End self)
				(if (not (gEgo mover:))
					(gEgo setHeading: 230)
				)
			)
			(4
				(kath
					view: 791
					setPri: 160
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(5
				(kath setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(kath view: 792 setLoop: 0 cel: 0 setCycle: End self)
			)
			(7
				(kathBody
					init:
					signal: (| (kathBody signal:) $5000)
					view: 794
					setLoop: 2
					cel: 0
					posn: (kath x:) (kath y:)
					setPri: 160
				)
				(kath
					view: 794
					setLoop: 0
					cel: 0
					x: (- (kathBody x:) 15)
					y: (kathBody y:)
					z: 54
					setPri: 160
					code: headCode
				)
				(= cycles 2)
			)
			(8
				(if (not (gPqFlags test: 33))
					(gMessager say: 20 2 33 0 self) ; "Hi, John, thanks for coming over."
				else
					(gMessager say: 20 2 14 0 self) ; "Hi, John... Thanks for coming back. I'm sorry I got so upset. I really don't know what I'm doing, everything is happening so fast."
				)
			)
			(9
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance headCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if
			(and
				(>
					(= temp0
						(GetAngle
							(param1 x:)
							(+ (param1 y:) 50)
							(gEgo x:)
							(gEgo y:)
						)
					)
					19
				)
				(< temp0 90)
			)
			(param1 cel: (- 10 (/ temp0 10)))
		)
	)
)

(instance upsetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gGame handsOff:)
				(kathBody actions: 0 dispose:)
				(kath
					view: 799
					setLoop: 0
					cel: 0
					posn: 144 142 0
					code: 0
					setCycle: End self
				)
			)
			(2
				(kath view: 7900 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gPqFlags set: 33)
				(gMessager say: 20 2 18 0 self) ; "John, how could you say that about Bob! I'm sorry... I, I can't talk about this right now..."
			)
			(5
				(kath
					view: 7901
					setLoop: 0
					cel: 0
					posn: (+ (kath x:) 11) (+ (kath y:) 1)
					setCycle: End self
				)
			)
			(6
				(kath
					view: 7902
					setLoop: 0
					cel: 0
					setPri: 129
					setCycle: End self
				)
			)
			(7
				(if (gCast contains: val)
					(= cycles 1)
				else
					(self setScript: valInScr self)
				)
			)
			(8
				(= local6 0)
				(self dispose:)
				(kath dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance whatchaDoinScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo signal:) $0800)
					(self setScript: standUpScr self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					normalize: 9797
					setMotion:
						PolyPath
						(closet approachX:)
						(closet approachY:)
						self
				)
			)
			(2
				(gMessager say: 1 0 1 0 self) ; "John, what are you doing?"
			)
			(3
				(waitScr seconds: 0 cycles: 0 cue:)
				(self dispose:)
			)
		)
	)
)

(instance kathEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kath
					view: 7908
					init:
					signal: (| (kath signal:) $5000)
					setLoop: 0
					cel: 0
					posn: 151 123
					setPri: 110
					setCycle: End self
				)
			)
			(1
				(kath setLoop: 1 cel: 0 posn: 149 123 setCycle: End self)
			)
			(2
				(kath
					view: 7909
					setLoop: 0
					cel: 0
					posn: 147 123
					setPri: 160
					setCycle: End self
				)
			)
			(3
				(kath
					view: 7903
					setLoop: 0
					cel: 0
					posn: 145 154
					setCycle: End self
				)
			)
			(4
				(kath
					view: 7904
					setLoop: 0
					cel: 0
					posn: 148 153
					setCycle: End self
				)
			)
			(5
				(kath
					view: 7907
					setLoop: 1
					cel: 0
					setPri: 160
					x: 133
					y: 195
					z: 100
				)
				(kathBody
					init:
					signal: (| (kath signal:) $5000)
					view: 7907
					setLoop: 0
					setPri: 160
					x: 141
					y: 151
				)
				(= cycles 2)
			)
			(6
				(gMessager say: 20 2 34 0 self) ; "It's nice of you to stop by, John. I'm sorry you missed the funeral..."
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance egoEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(gEgo setMotion: MoveTo 134 120 self)
			)
			(2
				(gEgo setMotion: PolyPath 212 128 self)
			)
			(3
				(gEgo setPri: -1 setHeading: 235 self)
			)
			(4
				(if register
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoArm of Prop
	(properties
		priority 200
		fixPriority 1
		view 9791
		loop 1
	)
)

(instance getVestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo signal:) $0800)
					(= register 1)
					(self setScript: standUpScr self)
				else
					(= register 0)
					(= cycles 1)
				)
			)
			(1
				(if register
					(gEgo heading: 235 normalize: 9797 5)
				)
				(= cycles 2)
			)
			(2
				(gEgo setMotion: PolyPath 238 133 self)
			)
			(3
				(gEgo setHeading: 235 self)
			)
			(4
				(gEgo view: 9790 setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setLoop: 1 1 cel: 0 setCycle: CT 2 1 self)
				(egoArm
					init:
					posn: (- (gEgo x:) 1) (gEgo y:)
					setPri: 200
					setCycle: CT 2 1
				)
			)
			(6
				(egoArm dispose:)
				(gEgo cel: 3)
				((View new:)
					view: 7950
					loop: 1
					cel: 0
					x: 229
					y: 143
					z: 4
					setPri: 199
					signal: 26657
					noun: 19
					init:
					yourself:
				)
				(= cycles 2)
			)
			(7
				(gEgo put: 4 790 get: 5 cel: 5 setCycle: End self) ; hickmanStuff, vest
			)
			(8
				(gEgo normalize: 9797)
				(if (== gDay 3)
					(gMessager say: 20 14 0 0 self) ; "Katherine, these are Bob's personal effects. They were released by the Deputy Coroner."
				else
					(= cycles 2)
				)
			)
			(9
				(if (== gDay 3)
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(10
				(gMessager say: 20 14 0 0 self) ; "Katherine, these are Bob's personal effects. They were released by the Deputy Coroner."
			)
			(11
				(gMessager say: 3 0 16 1 self) ; "John, this was Bob's Kevlar vest. I'd like you to have it... maybe it will keep you safe."
			)
			(12
				(kath
					view: 795
					setLoop: 0
					cel: 0
					posn: (kathBody x:) (kathBody y:)
					z: 0
					code: 0
					setPri: (+ (box priority:) 1)
					setCycle: End self
				)
				(kathBody hide:)
			)
			(13
				(kath view: 796 setLoop: 0 cel: 0 setCycle: End self)
			)
			(14
				(gEgo
					view: 9034
					setLoop: 1
					cel: 0
					x: (- (gEgo x:) 1)
					setCycle: CT 5 1 self
				)
			)
			(15
				(gMessager say: 3 0 16 2) ; "Thank you, Katherine."
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
				(kath
					view: 797
					setLoop: 0
					cel: 0
					setPri: 160
					setCycle: End self
				)
			)
			(16
				(gEgo x: (+ (gEgo x:) 1) normalize: 9797)
			)
			(17
				(kath view: 798 setLoop: 0 cel: 0 setCycle: End self)
			)
			(18
				(self setScript: valInScr self)
			)
			(19
				(kathBody
					init:
					signal: (| (kathBody signal:) $5000)
					view: 794
					setLoop: 2
					cel: 0
					posn: (kath x:) (kath y:)
					setPri: 160
					show:
				)
				(kath
					view: 794
					setLoop: 0
					cel: 0
					posn: (- (kathBody x:) 15) (kathBody y:)
					z: 54
					setPri: 160
					code: headCode
				)
				(gPqFlags set: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

