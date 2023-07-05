;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use ScaryTalker)
(use DText)
(use Str)
(use Actor)
(use System)

(public
	henryHelp 0
	tlkHenry 1
)

(local
	local0 = 8
	local1 = 10
	local2
)

(instance tlkHenry of ScaryTalker
	(properties
		x 0
		y 0
		talkWidth 213
		modeless 2
		view 9800
		priority 255
		textX 60
		textY -80
	)

	(method (init)
		(if global207
			(self dispose: 0)
			(= global207 1)
		else
			(= global207 1)
			(if (= scratch (IsFlag 121))
				(ClearFlag 121)
			)
			(if (global116 contains: (ScriptID 0 10)) ; fastForward
				((ScriptID 0 10) show:) ; fastForward
			else
				((ScriptID 0 10) init:) ; fastForward
			)
			(gGame handsOff:)
			(= local2 global209)
		)
		(DoAudio 12 0) ; AudMixCheck
		(= global112 -99)
		(super init: tMouth &rest)
	)

	(method (dispose param1)
		(DoAudio 12 1) ; AudMixCheck
		(= global207 0)
		(if (or (IsFlag 145) scratch)
			(SetFlag 121)
		)
		(= scratch 0)
		(if (global116 contains: (ScriptID 0 14)) ; exitButt
			((ScriptID 0 10) hide:) ; fastForward
		else
			((ScriptID 0 10) dispose:) ; fastForward
		)
		(super dispose: &rest)
		(if (and (or (not argc) param1) (== local2 global209))
			(gGame handsOn:)
		)
	)
)

(instance tMouth of Prop
	(properties
		x 53
		y 192
		view 9919
	)
)

(instance henryHelp of Script
	(properties)

	(method (init param1 &tmp temp0 temp1)
		(if global207
			(tlkHenry dispose:)
		)
		64929
		64941
		(if (== global206 2)
			((ScriptID 26 1) state: 0) ; movieScr
		)
		(cond
			((> argc 1)
				(gMessager say: 0 0 [param1 0] [param1 1] [param1 2] 37)
				(return)
			)
			((!= param1 4)
				(if (== param1 37)
					(= param1 16)
				)
				(= gTextHelp textHelp)
				(if (or (and (== gChapter 7) (gGame script:)) (== param1 36))
					(if (!= local1 999)
						(= temp1 (Str new:))
						(Message msgGET 37 0 param1 0 1 (temp1 data:))
						(textHelp
							text: (temp1 data:)
							fore: 24
							back: 0
							font: 2207
							skip: 0
							y: 142
							setSize: 320
							setPri: 4000
							init: global116
						)
						(SetNowSeen textHelp)
						(textHelp
							x:
								(-
									160
									(/
										(-
											(textHelp nsRight:)
											(textHelp nsLeft:)
										)
										2
									)
								)
						)
						(UpdateScreenItem textHelp)
						(temp1 data: 0 dispose:)
					)
				else
					(gMessager say: 0 param1 0 1 self 37)
				)
			)
			((not (IsFlag 117))
				(SetFlag 117)
				(gMessager say: 0 0 1 1 self 37) ; "I am the official hintkeeper. I watch your every move. Ask me for a hint if you are hopelessly stuck. But use me sparingly, too many hints can spoil the game."
			)
			(else
				(switch gChapter
					(1
						(= local0 8)
						(cond
							((IsFlag 159)
								(= local1 7)
							)
							((IsFlag 118)
								(= local1 13)
							)
							((IsFlag 96)
								(= local1 6)
							)
							((IsFlag 158)
								(= local1 12)
							)
							((IsFlag 60)
								(= local1 5)
							)
							((IsFlag 90)
								(= local1 4)
							)
							((IsFlag 97)
								(= local1 3)
							)
							((IsFlag 93)
								(= local1 2)
							)
							((IsFlag 85)
								(= local1 11)
							)
							(else
								(= local1 10)
							)
						)
					)
					(2
						(= local0 9)
						(cond
							((IsFlag 163)
								(= local1 4)
							)
							((and (IsFlag 102) (IsFlag 417))
								(= local1 5)
							)
							((IsFlag 102)
								(= local1 3)
							)
							((IsFlag 162)
								(= local0 8)
								(= local1 3)
							)
							((IsFlag 71)
								(= local1 11)
							)
							(else
								(= local1 10)
							)
						)
					)
					(3
						(= local0 10)
						(cond
							((IsFlag 173)
								(= local0 8)
								(= local1 3)
							)
							((IsFlag 99)
								(= local1 21)
							)
							((and (IsFlag 172) (IsFlag 171))
								(= local1 19)
							)
							((and (== gCurRoomNum 33100) (not (IsFlag 172)))
								(= local1 20)
							)
							((IsFlag 171)
								(= local1 19)
							)
							((IsFlag 169)
								(= local1 18)
							)
							((and (IsFlag 166) (IsFlag 98))
								(= local1 17)
							)
							((and (not (IsFlag 166)) (IsFlag 98))
								(= local1 16)
							)
							((IsFlag 165)
								(= local1 15)
							)
							((and (IsFlag 104) (IsFlag 128))
								(= local1 12)
							)
							((and (IsFlag 104) (not (gEgo has: 4))) ; invPoker
								(= local1 6)
							)
							((and (IsFlag 104) (not (IsFlag 2)))
								(= local1 13)
							)
							((and (IsFlag 104) (not (IsFlag 6)))
								(= local1 7)
							)
							((and (IsFlag 104) (not (IsFlag 7)))
								(= local1 8)
							)
							((and (IsFlag 104) (not (IsFlag 27)))
								(= local1 14)
							)
							((and (IsFlag 104) (not (IsFlag 128)))
								(= local1 9)
							)
							((IsFlag 164)
								(= local1 5)
							)
							((and (IsFlag 324) (== gCurRoomNum 24100))
								(= local1 4)
							)
							((IsFlag 324)
								(= local1 3)
							)
							((IsFlag 231)
								(= local1 2)
							)
							(
								(and
									(not (IsFlag 231))
									(not (IsFlag 384))
									(== gCurRoomNum 28860)
								)
								(= local1 10)
							)
							(else
								(= local1 11)
							)
						)
					)
					(4
						(= local0 11)
						(cond
							((IsFlag 193)
								(= local1 13)
							)
							((IsFlag 204)
								(= local0 8)
								(= local1 10)
							)
							((IsFlag 205)
								(= local1 6)
							)
							((IsFlag 105)
								(= local1 12)
							)
							((IsFlag 189)
								(= local0 10)
								(= local1 15)
							)
							((IsFlag 187)
								(= local1 3)
							)
							((IsFlag 262)
								(= local1 4)
							)
							((IsFlag 184)
								(= local1 3)
							)
							((IsFlag 185)
								(= local1 2)
							)
							((IsFlag 176)
								(= local1 11)
							)
							(else
								(= local1 10)
							)
						)
					)
					(5
						(= local0 12)
						(cond
							((and (IsFlag 327) (not (IsFlag 15)))
								(= local1 12)
							)
							((IsFlag 215)
								(= local1 5)
							)
							((IsFlag 214)
								(= local1 4)
							)
							((IsFlag 115)
								(= local1 3)
							)
							((IsFlag 195)
								(= local0 10)
								(= local1 15)
							)
							((IsFlag 194)
								(= local1 11)
							)
							(else
								(= local1 10)
							)
						)
					)
					(6
						(= local0 13)
						(cond
							((IsFlag 413)
								(= local0 8)
								(= local1 10)
							)
							((IsFlag 206)
								(= local0 8)
								(= local1 3)
							)
							((IsFlag 99)
								(= local0 10)
								(= local1 21)
							)
							((IsFlag 218)
								(= local0 10)
								(= local1 19)
							)
							((IsFlag 116)
								(= local1 11)
							)
							(else
								(= local1 10)
							)
						)
					)
					(7
						(= local0 14)
						(cond
							((and (IsFlag 224) (gEgo has: 15)) ; invBeads
								(= local1 28)
							)
							((and (IsFlag 224) (gEgo has: 14)) ; invCrucifix
								(= local1 27)
							)
							((and (IsFlag 219) (gEgo has: 19)) ; invCutter
								(= local1 26)
							)
							((and (IsFlag 219) (gEgo has: 10)) ; invBrooch
								(= local1 29)
							)
							((IsFlag 219)
								(= local1 36)
							)
							((gEgo has: 18) ; invStone
								(= local1 25)
							)
							((IsFlag 213)
								(= local1 24)
							)
							((IsFlag 415)
								(= local1 23)
							)
							((IsFlag 414)
								(= local1 35)
							)
							((IsFlag 212)
								(= local1 34)
							)
							((and (== gCurRoomNum 40100) (not (IsFlag 212)))
								(= local1 22)
							)
							((IsFlag 157)
								(= local1 21)
							)
							((== gCurRoomNum 46780)
								(= local1 20)
							)
							((and (== gCurRoomNum 46790) (IsFlag 151))
								(= local1 19)
							)
							((and (IsFlag 150) (IsFlag 410))
								(= local1 18)
							)
							((and (IsFlag 150) (gEgo has: 17)) ; invXmasOrn
								(= local1 17)
							)
							((IsFlag 150)
								(= local1 33)
							)
							((not (IsFlag 145))
								(cond
									(
										(and
											(not (gEgo has: 10)) ; invBrooch
											(not (IsFlag 274))
											(not (gEgo has: 19)) ; invCutter
										)
										(= local1 10)
									)
									(
										(and
											(not (gEgo has: 19)) ; invCutter
											(not (gEgo has: 10)) ; invBrooch
										)
										(= local1 11)
									)
									(
										(and
											(not (IsFlag 254))
											(not (gEgo has: 15)) ; invBeads
											(not (gEgo has: 14)) ; invCrucifix
											(not
												(OneOf
													gCurRoomNum
													22100
													22200
													22300
													35110
													35120
													35130
													35140
													35150
												)
											)
										)
										(= local1 2)
									)
									(
										(and
											(not (gEgo has: 15)) ; invBeads
											(not (gEgo has: 14)) ; invCrucifix
											(not
												(OneOf
													gCurRoomNum
													22100
													22200
													22300
													35110
													35120
													35130
													35140
													35150
												)
											)
										)
										(= local0 8)
										(= local1 10)
									)
									(
										(and
											(not (gEgo has: 15)) ; invBeads
											(not (gEgo has: 14)) ; invCrucifix
										)
										(= local1 3)
									)
									((not (gEgo has: 17)) ; invXmasOrn
										(= local1 4)
									)
									(else
										(= local1 5)
									)
								)
							)
							((== gCurRoomNum 45950)
								(cond
									(
										(and
											(not (IsFlag 130))
											(not (IsFlag 227))
										)
										(= local1 12)
									)
									((not (IsFlag 130))
										(= local1 6)
									)
									(else
										(= local1 30)
									)
								)
							)
							(
								(and
									(not (gEgo has: 10)) ; invBrooch
									(not (gEgo has: 19)) ; invCutter
								)
								(= local1 13)
							)
							(
								(and
									(not (gEgo has: 15)) ; invBeads
									(not (gEgo has: 14)) ; invCrucifix
									(== gCurRoomNum 46980)
								)
								(= local1 8)
							)
							(
								(and
									(not (gEgo has: 15)) ; invBeads
									(not (gEgo has: 14)) ; invCrucifix
									(== gCurRoomNum 47180)
								)
								(= local1 14)
							)
							(
								(and
									(not (gEgo has: 15)) ; invBeads
									(not (gEgo has: 14)) ; invCrucifix
								)
								(= local1 7)
							)
							((and (not (gEgo has: 17)) (!= gCurRoomNum 46910)) ; invXmasOrn
								(= local1 9)
							)
							((not (gEgo has: 17)) ; invXmasOrn
								(= local1 15)
							)
							((not (gEgo has: 16)) ; invSpellBook
								(= local1 16)
							)
						)
					)
				)
				(= gTextHelp textHelp)
				(if (== gChapter 7)
					(if (!= local1 999)
						(= temp1 (Str new:))
						(Message msgGET 37 local0 0 local1 1 (temp1 data:))
						(textHelp
							text: (temp1 data:)
							fore: 24
							back: 0
							font: 2207
							skip: 0
							y: 142
							setSize: 320
							setPri: 4000
							init: global116
						)
						(SetNowSeen textHelp)
						(textHelp
							x:
								(-
									160
									(/
										(-
											(textHelp nsRight:)
											(textHelp nsLeft:)
										)
										2
									)
								)
						)
						(UpdateScreenItem textHelp)
						(temp1 data: 0 dispose:)
					)
				else
					(gMessager say: local0 0 local1 1 0 37)
				)
			)
		)
	)
)

(instance textHelp of DText
	(properties)
)

