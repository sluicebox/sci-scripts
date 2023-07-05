;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 4] = [1320 0 1 0]
	[local11 4] = [1320 1 1 0]
	[local15 4] = [1320 3 1 0]
	[local19 5] = [1320 4 1 1 0]
	[local24 7] = [1320 6 2 1 2 1 0]
	[local31 5] = [1320 10 2 1 0]
	[local36 4] = [1320 12 1 0]
	[local40 9] = [327 0 3 4 15 31 12 21 21]
)

(procedure (localproc_0)
	(cond
		((and (!= gPrevRoomNum 330) (== global125 1)) ; fairArchery
			(if (IsFlag 164)
				(SetFlag 10)
				(gEgo setScript: beforeGoldenArrow)
			else
				(Say 1320 55 1) ; "If I draw an arrow here, I'll be dead before my fingers touch the string."
			)
		)
		((IsFlag 160)
			(Say 1320 55 1) ; "If I draw an arrow here, I'll be dead before my fingers touch the string."
		)
		((IsFlag 164)
			(ClearFlag 131)
			(gCurRoom newRoom: 330) ; fairArchery
		)
		(else
			(Say 1320 55 1) ; "If I draw an arrow here, I'll be dead before my fingers touch the string."
		)
	)
)

(procedure (localproc_1)
	(SetMessageColor 19)
	(Say &rest 80 {Roger})
	(SetMessageColor 0)
)

(procedure (localproc_2)
	(SetMessageColor 19)
	(Say &rest 80 {Giles})
	(SetMessageColor 0)
)

(procedure (localproc_3)
	(SetMessageColor 19)
	(Say &rest 80 {Jack})
	(SetMessageColor 0)
)

(procedure (localproc_4)
	(= local3 (Random 12 16))
	(= local4 (Random 10 16))
	(= local5 (Random 9 14))
	(leftFlag init:)
	(middleFlag init:)
	(rightFlag init:)
	(= local2 (Random 100 300))
)

(procedure (localproc_5)
	(gCast eachElementDo: #hide)
	(gCurRoom drawPic: 803)
)

(procedure (localproc_6)
	(gCurRoom drawPic: 320)
	(gEgo loop: 1 posn: 125 148)
	(guard1Roger loop: 3 setCel: 0 posn: 99 181)
	(guard2Jack loop: 3 setCel: 1 posn: 136 183)
	(guard3Giles loop: 3 setCel: 5 posn: 209 178)
	(adamBell posn: 165 166)
	(archer2 posn: 302 160)
	(gCast eachElementDo: #show)
)

(instance rm320 of Rm
	(properties
		picture 320
		style -32766
		south 280
	)

	(method (init)
		(if (== gPrevRoomNum 280)
			(= style 100)
		)
		(super init:)
		(if (== gPrevRoomNum 280)
			(gRgnMusic fade: 60 30 8 0)
		)
		(SetIcon 0)
		(localproc_4)
		(puckTarget init:)
		(AddToFeatures sheriffBox ladiesBox crowd1 crowd2 targetRight targetLeft)
		(if (== gPrevRoomNum 330) ; fairArchery
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 249 189 0 189 0 0 319 0 319 189 272 189 272 181 248 181 248 189
						yourself:
					)
			)
			(adamBell posn: 165 166 init:)
			(archer2 posn: 302 160 init:)
			(guard1Roger loop: 3 setCel: 0 setCycle: Walk posn: 99 181 init:)
			(guard2Jack loop: 3 setCel: 1 setCycle: Walk posn: 136 183 init:)
			(guard3Giles loop: 3 setCel: 5 setCycle: Walk posn: 209 178 init:)
			(cond
				((IsFlag 10)
					(gEgo loop: 1 posn: 125 148 init: setAvoider: PAvoider)
				)
				((IsFlag 131)
					(gEgo
						loop: 3
						posn: 260 185
						init:
						observeControl: 2 4 16
						setAvoider: PAvoider
					)
				)
				(else
					(= gRoomCount 43)
					(gEgo
						loop: 7
						posn: 239 170
						init:
						observeControl: 2 4 16
						setAvoider: PAvoider
					)
				)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 254 189 0 189 0 0 319 0 319 189 263 189 263 173 259 173 258 189
						yourself:
					)
			)
			(gEgo
				loop: 3
				posn: 265 187
				init:
				setCycle: Walk
				observeControl: 2 4 16
			)
			(if (< gRoomCount 42)
				(adamBell init:)
				(archer2 init:)
			)
			(guard1Roger setCycle: Walk init:)
			(guard2Jack setCycle: Walk init:)
			(guard3Giles setCycle: Walk init:)
		)
		(cond
			((> gRoomCount 42)
				(if (== gPrevRoomNum 330) ; fairArchery
					(gEgo setScript: leaveInHuff)
				else
					(gEgo setScript: tormentIsOver)
				)
			)
			((and (IsFlag 160) (== gPrevRoomNum 330)) ; fairArchery
				(gEgo setScript: kickOutPoorPlay)
			)
			((IsFlag 131)
				(cond
					((== (++ global148) 1)
						(gEgo setScript: forceOutComeIn)
					)
					((== global148 2)
						(gEgo setScript: afterToldMoveOut)
					)
					((== global148 3)
						(gEgo setScript: goToDeathMesg)
					)
				)
			)
			((< 31 gRoomCount 43)
				(gEgo setScript: tormentHasStarted)
			)
			((IsFlag 10)
				(gEgo setScript: goldenArrowAward)
			)
			((and (IsFlag 130) (< gRoomCount 31) (not (IsFlag 164)))
				(gEgo setScript: returnBeforeStarted)
			)
			((not (IsFlag 58))
				(gEgo setScript: stillHasScroll)
			)
			((not (IsFlag 130))
				(SetFlag 130)
				(gEgo setScript: firstEntWithNoScrol)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 65 1) ; "'Tis the enclosed archery field."
			)
			(3 ; Do
				(Say 1320 66 1) ; "These guards eye me closely. I've no chance to do anything on this field unless they allow it."
			)
			(4 ; Inventory
				(Say 1320 66 1) ; "These guards eye me closely. I've no chance to do anything on this field unless they allow it."
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (== (-- local2) 0)
			(localproc_4)
		)
		(cond
			((gEgo script:) 0)
			(
				(and
					(IsFlag 164)
					(< gRoomCount 31)
					(or (> (gEgo x:) 290) (> (gEgo y:) 185))
					(not (IsFlag 131))
					(not local0)
				)
				(= local0 1)
				(gEgo setScript: leaveAfterPaid)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gCurRoom setScript: 0)
		(gEgo setScript: 0)
		(DisposeScript 927)
		(super dispose:)
	)
)

(instance sheriffBox of Feature
	(properties
		x 46
		y 76
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 40 68 72 66 79 40 79 69 105 66 155 0 156
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 34 1) ; "The Sheriff and his wife sit in their private booth. They look most anxious to see their own champion win. No doubt they've bet heavily upon him."
			)
			(10 ; Longbow
				(localproc_0)
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

(instance ladiesBox of Feature
	(properties
		x 300
		y 36
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 302 36 300 46 290 55 291 68 273 66 274 90 232 80 232 54 249 35
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 35 1) ; "The noble ladies of the town have turned out to watch the archery tournament."
			)
			(10 ; Longbow
				(localproc_0)
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

(instance crowd1 of Feature
	(properties
		x 205
		y 46
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 198 42 211 34 225 32 240 46 231 54 232 80 164 65 165 50 189 31
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 36 1) ; "A boisterous crowd has turned out today."
			)
			(10 ; Longbow
				(localproc_0)
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

(instance crowd2 of Feature
	(properties
		x 295
		y 63
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 50 319 96 274 88 273 66 292 66 291 55 307 37
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 36 1) ; "A boisterous crowd has turned out today."
			)
			(10 ; Longbow
				(localproc_0)
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

(instance targetLeft of Feature
	(properties
		x 65
		y 62
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 63 64 72 64 72 71 67 71 62 70 61 66 64 64
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 33 1) ; "The butts are set for the Tournament."
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance targetRight of Feature
	(properties
		x 137
		y 61
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 137 61 139 63 139 68 135 69 128 68 128 64 132 61
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 33 1) ; "The butts are set for the Tournament."
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance closeUpArrow of View
	(properties
		x 90
		y 83
		view 330
		loop 6
	)
)

(instance puckTarget of View
	(properties
		x 97
		y 68
		view 325
		loop 1
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 33 1) ; "The butts are set for the Tournament."
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance adamBell of View
	(properties
		x 153
		y 180
		view 325
		loop 2
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 30 1) ; "I recognize Adam Bell, so-called Champion of Nottingham. I've heard he looses his shafts in bed with the same fervor as upon the archery field."
			)
			(5 ; Talk
				(if (IsFlag 164)
					(gEgo setScript: talkAdamConv)
				else
					(Say 1320 61 1) ; "I cannot speak to him from here and the guards won't let me onto the field."
				)
			)
			(10 ; Longbow
				(localproc_0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (IsFlag 164)
							(gMoney put:)
							(gEgo setScript: moneyConv)
						else
							(super doVerb: theVerb &rest)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance archer2 of View
	(properties
		x 303
		y 158
		view 325
		loop 2
		cel 1
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 31 1) ; "I know him not, but he has the look of a serious archer."
			)
			(5 ; Talk
				(if (IsFlag 164)
					(SetMessageColor 21)
					(Say 1320 38 80 {Archer}) ; "Pray talk not to me, yeoman. I must concentrate upon my shooting for Adam Bell will be a hard man to beat."
					(SetMessageColor 0)
				else
					(Say 1320 61 1) ; "I cannot speak to him from here and the guards won't let me onto the field."
				)
			)
			(10 ; Longbow
				(localproc_0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (IsFlag 164)
							(gMoney put:)
							(SetMessageColor 21)
							(Say 1320 51 80 {Archer}) ; "Thanks, but I mean to win that Golden Arrow."
							(SetMessageColor 0)
						else
							(super doVerb: theVerb &rest)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftFlag of Prop
	(properties
		x 52
		y 56
		view 333
		priority 1
		signal 16
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: local3)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1320 56 1) ; "The pennants flutter brightly in the wind."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middleFlag of Prop
	(properties
		x 203
		y 29
		lookStr {The pennants flutter brightly in the wind.}
		view 333
		loop 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: local4)
	)
)

(instance rightFlag of Prop
	(properties
		x 272
		y 30
		lookStr {The pennants flutter brightly in the wind.}
		view 333
		loop 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd cycleSpeed: local5)
	)
)

(instance guard1Roger of Actor
	(properties
		x 240
		y 185
		view 750
		signal 1
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(2 ; Look
				(Say 1320 32 1) ; "Stupid, arrogant and ugly. A typical example of a Sheriff's man."
			)
			(3 ; Do
				(if (not local6)
					(= local6 1)
					(localproc_1 1320 39 1) ; "Lay a hand on me, dog, and you'll hang tomorrow."
				else
					(localproc_1 1320 62 1) ; "One warning is enough."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (IsFlag 58)
							(cond
								((== (= temp0 (gMoney doit:)) 0))
								((IsFlag 164)
									(localproc_1 1320 46 self) ; "That's right generous of you."
								)
								((== temp0 4)
									(SetFlag 164)
									(gEgo
										ignoreControl: 4
										setScript: letPuckGoIn
									)
								)
								((> temp0 4)
									(localproc_1 1320 46 self) ; "That's right generous of you."
									(SetFlag 164)
									(gEgo
										ignoreControl: 4
										setScript: letPuckGoIn
									)
								)
								(else
									(localproc_1 1320 44 self) ; "Not enough."
								)
							)
						else
							(localproc_1 1320 43 self) ; "If you want to enter, come back later. You're too early."
						)
					)
					(17 ; handScroll
						(localproc_1 1320 52 self) ; "Eh? Do I look like a scribe?"
					)
				)
			)
			(5 ; Talk
				(cond
					((not (IsFlag 58))
						(localproc_1 1320 40 self) ; "Come back later. You're too early."
					)
					((and (not (IsFlag 164)) (IsFlag 58))
						(localproc_1 1320 41 self) ; "Pay up or move on!"
					)
					(else
						(localproc_1 1320 42 self) ; "If you're looking for trouble, we can give it to you."
					)
				)
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance guard2Jack of Actor
	(properties
		x 290
		y 185
		view 750
		loop 2
		cel 1
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 32 1) ; "Stupid, arrogant and ugly. A typical example of a Sheriff's man."
			)
			(3 ; Do
				(localproc_3 1320 64 self) ; "Stay back."
			)
			(5 ; Talk
				(cond
					((not (IsFlag 58))
						(localproc_3 1320 40 self) ; "Come back later. You're too early."
					)
					((and (not (IsFlag 164)) (IsFlag 58))
						(localproc_3 1320 41 self) ; "Pay up or move on!"
					)
					(else
						(localproc_3 1320 42 self) ; "If you're looking for trouble, we can give it to you."
					)
				)
			)
			(10 ; Longbow
				(localproc_0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(cond
							((not (IsFlag 164))
								(localproc_3 1320 47 self) ; "You need to pay Roger, not me."
							)
							((> (gMoney doit:) 0)
								(localproc_3 1320 59 self) ; "Nice a'you to give money away, Patch"
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
					)
					(17 ; handScroll
						(localproc_3 1320 54 self) ; "Take your wares elsewhere."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance guard3Giles of Actor
	(properties
		x 256
		y 175
		view 750
		loop 2
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1320 32 1) ; "Stupid, arrogant and ugly. A typical example of a Sheriff's man."
			)
			(3 ; Do
				(localproc_2 1320 63 self) ; "Keep your distance, knave."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(cond
							((not (IsFlag 164))
								(localproc_2 1320 47 self) ; "You need to pay Roger, not me."
							)
							((> (gMoney doit:) 0)
								(localproc_2 1320 48 self) ; "Sure, I'll take your money."
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
					)
					(17 ; handScroll
						(localproc_2 1320 53 self) ; "I don't want that."
					)
				)
			)
			(5 ; Talk
				(cond
					((not (IsFlag 58))
						(localproc_2 1320 40 self) ; "Come back later. You're too early."
					)
					((and (not (IsFlag 164)) (IsFlag 58))
						(localproc_2 1320 41 self) ; "Pay up or move on!"
					)
					(else
						(localproc_2 1320 42 self) ; "If you're looking for trouble, we can give it to you."
					)
				)
			)
			(10 ; Longbow
				(localproc_0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leaveInHuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1320 60 self) ; "I've no desire to see Adam Bell receive the Golden Arrow after my humiliating defeat."
			)
			(1
				(NormalEgo)
				(gEgo setMotion: MoveTo 325 180 self)
			)
			(2
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance stillHasScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(Converse 1 @local7 6 2 self) ; "I wish to enter the tournament."
			)
			(2
				(localproc_1 1320 13 self) ; "You, One-Eye? That's a joke."
			)
			(3
				(localproc_1 1320 14 self) ; "You're too early anyway. Come back and repeat your jest later, and I'll consider letting you enter."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firstEntWithNoScrol of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(localproc_1 1320 15 self) ; "Hold, yeoman. We've new rules for this Tournament. There's an entrance fee of one penny. Pay up or move on."
			)
			(2
				(Converse 1 @local11 6 2 self) ; "What new larceny is this? The Tournament has always been open to all comers without fee."
			)
			(3
				(localproc_1 1320 16 self) ; "Well, now it's open to all comers with a penny in their hands. Pay up or move on!"
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance returnBeforeStarted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(localproc_1 1320 17 self) ; "Well, One-Eye? Feel like wasting your money to shoot against these good archers?"
			)
			(2
				(localproc_1 1320 18 self) ; "Better hurry, the tournament starts soon."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeHimOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch global148
					(2
						(localproc_1 1320 24 self) ; "I told you to move on, knave!"
					)
					(3
						(gEgo setScript: goToDeathMesg)
					)
					(else
						(localproc_1 1320 20 self) ; "We told you to move on."
					)
				)
			)
			(1
				(SetFlag 131)
				(gEgo setMotion: PolyPath (gEgo x:) 200 self)
				(guard1Roger setMotion: MoveTo (- (gEgo x:) 10) 200)
				(guard2Jack setMotion: MoveTo (+ (gEgo x:) 30) 200)
			)
			(2
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance afterToldMoveOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(client setScript: takeHimOut)
			)
		)
	)
)

(instance goToDeathMesg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_1 1320 25 self) ; "All right, I've had enough of you! Grab him, men!"
			)
			(1
				(guard1Roger
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(+ (gEgo y:) 10)
						self
				)
			)
			(2
				(Face guard1Roger gEgo self)
			)
			(3
				(localproc_2 1320 26 self) ; "Look, he's got a good eye under this patch!"
			)
			(4
				(localproc_3 1320 27 self) ; "I know that face! It's ROBIN HOOD!!!"
			)
			(5
				(localproc_1 1320 28 self) ; "To the gallows with him!"
			)
			(6
				(= gDeathNum 34)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance goldenArrowAward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(self cue:)
			)
			(1
				(localproc_6)
				(= ticks 6)
			)
			(2
				(gEgo setMotion: PolyPath 90 128 self)
			)
			(3
				(Converse 2 @local24 6 0 12 1 self) ; "You shoot uncommon well, Puck of Barnesdale. I could use a man such as you in my service."
			)
			(4
				(closeUpArrow setPri: 15 init:)
				(= cycles 3)
			)
			(5
				(Converse 2 @local31 6 0 12 1 self) ; "Here is your prize, then. Be off with you, ingrate."
			)
			(6
				(AddRansom 10000)
				(closeUpArrow hide:)
				(localproc_5)
				(= ticks 6)
			)
			(7
				(gCurRoom drawPic: 803 -32762)
				(HandsOn)
				(SetIcon 0)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance moneyConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 21)
				(Say 1320 49 self 80 {Adam Bell}) ; "You seek to bribe ME? The Champion of Nottingham? Phagh, I would not accept such a pittance. Have you no gold?"
				(SetMessageColor 0)
			)
			(1
				(Converse 1 @local36 6 2 self) ; "Nay."
			)
			(2
				(SetMessageColor 21)
				(Say 1320 50 self 80 {Adam Bell}) ; "Then don't bother me."
				(SetMessageColor 0)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance letPuckGoIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard3Giles setMotion: MoveTo 275 166)
				(guard1Roger setMotion: MoveTo 170 173)
				(guard2Jack setMotion: MoveTo 303 183 self)
			)
			(1
				(gEgo ignoreControl: 4)
				(guard2Jack setMotion: MoveTo 293 172)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(localproc_1 1320 45 self) ; "All right, take the center lane."
			)
			(2
				(guard3Giles signal: (| (guard3Giles signal:) $4001))
				(guard1Roger signal: (| (guard1Roger signal:) $0001))
				(guard2Jack signal: (| (guard2Jack signal:) $4001))
				(gEgo setMotion: MoveTo 252 173 self)
			)
			(3
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 319 189 264 172 242 157 221 155 218 168 199 174 183 189
							yourself:
						)
				)
				(= ticks 6)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance kickOutPoorPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 131)
				(localproc_1 1320 57 self) ; "'At's it for you, Patch. Off the grounds with you."
			)
			(1
				(gEgo setMotion: PolyPath 280 178 self)
			)
			(2
				(gEgo setMotion: PolyPath 319 179)
				(guard3Giles setMotion: MoveTo 295 178 self)
			)
			(3
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance forceOutComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(localproc_1 1320 23 self) ; "Leave the grounds or we'll throw you out!"
			)
			(2
				(= ticks 300)
			)
			(3
				(client setScript: takeHimOut)
			)
		)
	)
)

(instance tormentHasStarted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(localproc_1 1320 19 self) ; "The tournament's started. Leave the shooting area at once."
			)
			(2
				(HandsOn)
				(= ticks 300)
			)
			(3
				(client setScript: takeHimOut)
			)
		)
	)
)

(instance tormentIsOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(= ticks 24)
			)
			(1
				(localproc_1 1320 29 self) ; "You're too late, One-Eye. Adam Bell has won the Golden Arrow."
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tooLateToComeIn of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 234 181 self)
			)
			(1
				(guard2Jack setMotion: MoveTo 210 175)
				(guard3Giles setMotion: MoveTo 243 171)
				(guard1Roger setMotion: MoveTo 199 182 self)
			)
			(2
				(localproc_5)
				(= cycles 5)
			)
			(3
				(gCurRoom drawPic: 803 -32762)
				(= cycles 10)
			)
			(4
				(Say 1320 58 67 60 50) ; "With the coming of dusk, the Fair was closed and I made my way through the gates before I could be trapped within the city walls for the night."
				(self cue:)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance leaveAfterPaid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 131)
				(gEgo setMotion: PolyPath 265 (gEgo y:) self)
			)
			(1
				(Face gEgo guard1Roger)
				(Face guard1Roger gEgo)
				(= ticks 30)
			)
			(2
				(localproc_1 1320 21 self) ; "Here now, if you leave the Tournament, don't come back. You're out for good!"
			)
			(3
				(localproc_1 1320 22 self) ; "And you don't get your fee back neither!"
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkAdamConv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 21)
				(Say 1320 2 80 {Adam Bell}) ; "You should leave now, patch. Even with two eyes, you couldn't hope to beat me."
				(SetMessageColor 0)
				(self cue:)
			)
			(1
				(Converse @local15 6 0 self) ; "I'll let my bow speak for me."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance beforeGoldenArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(localproc_5)
				(= seconds 5)
			)
			(1
				(Converse 1 @local19 @local40 0 self) ; "Puck of Barnesdale has won the Golden Arrow!"
			)
			(2
				(gEgo setScript: goldenArrowAward)
			)
		)
	)
)

(instance sExitEast of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 335 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 280)
			)
		)
	)
)

