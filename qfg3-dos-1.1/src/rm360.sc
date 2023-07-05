;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use GloryWindow)
(use Interface)
(use Print)
(use Talker)
(use IconBar)
(use GameControls)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm360 0
	anubisTalker 1
	desTalker 2
)

(local
	[local0 6] = [5 2 1 7 8 11]
	[local6 6] = [6 4 9 3 1 0]
	[local12 6] = [8 0 11 2 10 5]
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	[local27 3]
	[local30 3]
	local33
	local34
	local35
	[local36 200]
)

(procedure (localproc_0)
	(= local33 (Palette palSAVE))
	(DrawPic 360 9)
	(Palette palRESTORE local33)
	(Animate (gCast elements:) 1)
)

(procedure (localproc_1)
	(switch local34
		(0
			(return 60)
		)
		(1
			(return 61)
		)
		(2
			(return 62)
		)
		(else
			(return 63)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(switch
		(= temp0
			(+
				(= temp0 (+ (= temp0 (+ (= temp0 0) [local27 0])) [local27 1]))
				[local27 2]
			)
		)
		(3
			(return 68)
		)
		(4
			(return 67)
		)
		(5
			(return 66)
		)
		(else
			(return 65)
		)
	)
)

(procedure (localproc_3)
	(switch [local30 0]
		(keyObj
			(return 35)
		)
		(pentagram
			(return 36)
		)
		(sword
			(return 34)
		)
		(heart
			(return 37)
		)
		(cup
			(return 38)
		)
		(ankh
			(return 39)
		)
	)
)

(procedure (localproc_4)
	(switch [local30 1]
		(ringObj
			(return 48)
		)
		(keyObj
			(return 47)
		)
		(infinity
			(return 46)
		)
		(yinYang
			(return 44)
		)
		(raisedFist
			(return 43)
		)
		(hourglass
			(return 45)
		)
	)
)

(procedure (localproc_5)
	(switch [local30 2]
		(ringObj
			(return 50)
		)
		(pentagram
			(return 52)
		)
		(sword
			(return 54)
		)
		(cup
			(return 49)
		)
		(candle
			(return 53)
		)
		(ankh
			(return 51)
		)
	)
)

(procedure (localproc_6 &tmp temp0 temp1)
	(= temp1 (Message msgSIZE 360 2 6 local19 2))
	(= local22 (Memory memALLOC_NONCRIT temp1))
	(= temp1 (Message msgSIZE 360 2 6 local19 3))
	(= local23 (Memory memALLOC_NONCRIT temp1))
	(= temp1 (Message msgSIZE 360 2 6 local19 4))
	(= local24 (Memory memALLOC_NONCRIT temp1))
	(= temp1 (Message msgSIZE 360 2 6 local19 5))
	(= local25 (Memory memALLOC_NONCRIT temp1))
	(= temp1 (Message msgSIZE 360 2 6 local19 6))
	(= local26 (Memory memALLOC_NONCRIT temp1))
	(Message msgGET 360 2 6 local19 1 @local36)
	(Message msgGET 360 2 6 local19 2 local22)
	(Message msgGET 360 2 6 local19 3 local23)
	(Message msgGET 360 2 6 local19 4 local24)
	(Message msgGET 360 2 6 local19 5 local25)
	(Message msgGET 360 2 6 local19 6 local26)
	(myPrint addText: @local36 init:)
	(= temp0 gTheCursor)
	(quest init: show: dispose:)
	(while local35
		(myPrint addText: @local36 init:)
		(quest init: show: dispose:)
	)
	(Memory memFREE local22)
	(Memory memFREE local23)
	(Memory memFREE local24)
	(Memory memFREE local25)
	(Memory memFREE local26)
	(++ local21)
	(gGame setCursor: temp0)
	(choices cycles: 5)
)

(instance rm360 of Rm
	(properties
		noun 13
		picture 360
	)

	(method (init)
		(gLongSong fade:)
		(Palette palSET_FLAG 72 255 4)
		(ringObj init:)
		(keyObj init:)
		(pentagram init:)
		(infinity init:)
		(yinYang init:)
		(sword init:)
		(raisedFist init:)
		(heart init:)
		(cup init:)
		(hourglass init:)
		(candle init:)
		(ankh init:)
		(anubis init:)
		(gCast eachElementDo: #hide)
		(gLongSong3 number: 360 setLoop: -1 play: 127)
		(super init:)
		(self setScript: choices)
	)

	(method (doit)
		(super doit:)
		(Palette palANIMATE 72 255 1)
	)
)

(instance choices of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gMessager say: 2 6 10 0 self) ; "You feel yourself floating bodiless in this strange place."
			)
			(2
				(= seconds 2)
			)
			(3
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local0 temp0]) show:)
				)
				(localproc_0)
				(= cycles 5)
			)
			(4
				(gMessager say: 2 6 11 0 self) ; "A deep, strange voice speaks, "Choose that which you were.""
			)
			(5
				(HandsOn 1 4 6 5 8)
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 3 curIcon: (gTheIconBar at: 3))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			)
			(6
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local0 temp0]) hide:)
				)
				(local18 show:)
				(localproc_0)
				(= cycles 5)
			)
			(7
				(= cycles 20)
			)
			(8
				(gMessager say: 2 6 4 0 self) ; "The deep voice speaks again."
			)
			(9
				(localproc_6)
			)
			(10
				(gMessager say: 2 6 13 0 self) ; "The deep, strange voice speaks, "Choose that which you are.""
			)
			(11
				(local18 hide:)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local6 temp0]) show:)
				)
				(localproc_0)
				(= cycles 5)
			)
			(12
				(HandsOn 1 4 6 5 8)
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 3 curIcon: (gTheIconBar at: 3))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			)
			(13
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local6 temp0]) hide:)
				)
				(local18 show:)
				(localproc_0)
				(= cycles 5)
			)
			(14
				(= seconds 2)
			)
			(15
				(gMessager say: 2 6 14 0 self) ; "You hear the voice again."
			)
			(16
				(localproc_6)
			)
			(17
				(local18 hide:)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local12 temp0]) show:)
				)
				(localproc_0)
				(= cycles 5)
			)
			(18
				(gMessager say: 2 6 2 0 self) ; "You hear the voice intone, "Choose that which you will be.""
			)
			(19
				(HandsOn 1 4 6 5 8)
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 3 curIcon: (gTheIconBar at: 3))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			)
			(20
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((gCast at: [local12 temp0]) hide:)
				)
				(local18 show:)
				(localproc_0)
				(= cycles 5)
			)
			(21
				(= seconds 2)
			)
			(22
				(gMessager say: 2 6 14 0 self) ; "You hear the voice again."
			)
			(23
				(localproc_6)
			)
			(24
				(local18 hide:)
				(localproc_0)
				(= cycles 3)
			)
			(25
				(anubis show:)
				(localproc_0)
				(= cycles 3)
			)
			(26
				(gMessager say: 3 6 30 0 self) ; "Thy soul has been weighed."
			)
			(27
				(if
					(or
						(== [local27 0] 4)
						(== [local27 1] 4)
						(== [local27 2] 4)
					)
					(gCurRoom setScript: leave 0 0)
				else
					(gEgo addHonor: 30 solvePuzzle: 254 10)
					(self cue:)
				)
			)
			(28
				(gMessager say: 3 6 32 0 self) ; "Thou hast chosen thine own path, and by that path, ye shall be judged."
			)
			(29
				(gMessager say: 2 6 41 0 self) ; "The first is that which was."
			)
			(30
				([local30 0] show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(31
				(= seconds 2)
			)
			(32
				(gMessager say: 2 6 (localproc_3) 0 self)
			)
			(33
				([local30 0] hide:)
				(localproc_0)
				(= cycles 3)
			)
			(34
				(gMessager say: 2 6 40 0 self) ; "The second is that which is."
			)
			(35
				([local30 1] show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(36
				(= seconds 2)
			)
			(37
				(gMessager say: 2 6 (localproc_4) 0 self)
			)
			(38
				([local30 1] hide:)
				(localproc_0)
				(= cycles 3)
			)
			(39
				(gMessager say: 2 6 42 0 self) ; "The third is that which will be."
			)
			(40
				([local30 2] show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(41
				(= seconds 2)
			)
			(42
				(gMessager say: 2 6 (localproc_5) 0 self)
			)
			(43
				(= seconds 2)
			)
			(44
				(anubis hide:)
				([local30 2] hide:)
				(yinYang show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(45
				(switch gHeroType
					(0 ; Fighter
						(if
							(or
								(== [local30 0] sword)
								(== [local30 1] raisedFist)
								(== [local30 2] sword)
							)
							(gEgo solvePuzzle: 255 5)
							(gMessager say: 2 6 55 0 self) ; "You are one with yourself, and shall be what you have been. Your skills are in harmony with your nature."
						else
							(gMessager say: 2 6 57 0 self) ; "You are not what you most try to be. Though you live by the sword, you reject it. Yet it is only by accepting what you are that you shall triumph."
						)
					)
					(1 ; Magic User
						(if
							(or
								(== [local30 0] pentagram)
								(== [local30 1] infinity)
								(== [local30 2] pentagram)
							)
							(gEgo solvePuzzle: 255 5)
							(gMessager say: 2 6 55 0 self) ; "You are one with yourself, and shall be what you have been. Your skills are in harmony with your nature."
						else
							(gMessager say: 2 6 58 0 self) ; "You are in conflict between that which you are and that which you try to be. Though you are skilled in the magical arts, you deny that they are a part of you. Unless you gain balance within, you cannot attain balance without."
						)
					)
					(2 ; Thief
						(if
							(or
								(== [local30 0] keyObj)
								(== [local30 1] keyObj)
								(== [local30 1] ringObj)
								(== [local30 2] ringObj)
							)
							(gEgo solvePuzzle: 255 5)
							(gMessager say: 2 6 55 0 self) ; "You are one with yourself, and shall be what you have been. Your skills are in harmony with your nature."
						else
							(gMessager say: 2 6 56 0 self) ; "That which you are and that which you should be are not the same. Your life has been lived as a thief, but your desires and actions belie this. Your soul is in conflict, but it is only because you are greater than what you have tried to be."
						)
					)
					(else
						(if
							(or
								(== [local30 0] ankh)
								(== [local30 0] heart)
								(== [local30 1] yinYang)
								(== [local30 2] ankh)
							)
							(gEgo solvePuzzle: 255 5)
							(gMessager say: 2 6 55 0 self) ; "You are one with yourself, and shall be what you have been. Your skills are in harmony with your nature."
						else
							(gMessager say: 2 6 59 0 self) ; "Although you strive for harmony in the universe, there is disharmony within you. You deny by your choices the very person you have become. Unless you can truly believe in what you are, you will be powerless."
						)
					)
				)
			)
			(46
				(yinYang hide:)
				(localproc_0)
				(= cycles 5)
			)
			(47
				(= seconds 2)
			)
			(48
				(hourglass show: 1)
				(localproc_0)
				(= cycles 5)
			)
			(49
				(= seconds 1)
			)
			(50
				(cond
					(
						(or
							(== [local27 0] [local27 1])
							(== [local27 0] [local27 2])
						)
						(= local34 [local27 0])
					)
					((== [local27 1] [local27 2])
						(= local34 [local27 1])
					)
					(else
						(= local34 999)
					)
				)
				(if (!= local34 999)
					(gMessager say: 2 6 (localproc_1) 0 self)
				else
					(gMessager say: 2 6 64 0 self) ; "In your actions, you have defined yourself not by what you did, but what you did not do."
				)
			)
			(51
				(if (!= local34 999)
					(self cue:)
				else
					(gMessager say: 2 6 (localproc_2) 0 self)
				)
			)
			(52
				(hourglass hide:)
				(localproc_0)
				(= cycles 3)
			)
			(53
				(= seconds 2)
			)
			(54
				(anubis show:)
				(localproc_0)
				(= cycles 3)
			)
			(55
				(= seconds 1)
			)
			(56
				(gMessager say: 3 6 69 0 self) ; "Thou hast unleashed the Darkness."
			)
			(57
				(anubis hide:)
				(heart show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(58
				(gMessager say: 2 6 70 0 self) ; "Let the first part of thy path be guided by friendship."
			)
			(59
				(heart hide:)
				(sword show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(60
				(gMessager say: 2 6 71 0 self) ; "The Sword shall cross thy path, and bonds shall be cut asunder."
			)
			(61
				(sword hide:)
				(keyObj show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(62
				(gMessager say: 2 6 72 0 self) ; "Now thou art Opener of the Way and all thy heart has called shall draw near to thee."
			)
			(63
				(keyObj hide:)
				(pentagram show: 1)
				(localproc_0)
				(= cycles 3)
			)
			(64
				(switch gHeroType
					(0 ; Fighter
						(gMessager say: 2 6 73 0 self) ; "Seek ye now the highest tower to find the Door of Darkness.  Living stone shall block thy way then bridge thee to thy foe."
					)
					(1 ; Magic User
						(gMessager say: 2 6 74 0 self) ; "Seek thee now the highest tower to find the Door to Darkness."
					)
					(2 ; Thief
						(gMessager say: 2 6 75 0 self) ; "Seek ye now the highest tower, there to shut the Demon door."
					)
					(else
						(gMessager say: 2 6 76 0 self) ; "Seek ye now the highest tower to find the Door of Darkness. Living stone shall block thy way then bridge thee to thy foe."
					)
				)
			)
			(65
				(pentagram hide:)
				(anubis show:)
				(localproc_0)
				(= cycles 3)
			)
			(66
				(gMessager say: 3 6 77 0 self) ; "This is that which might yet be. Thy path is thine own to follow or not. Go forth now, bringer of the light."
			)
			(67
				(gCurRoom setScript: leave 0 1)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 12)
				(if register
					(self cue:)
				else
					(gMessager say: 3 6 31 0 self) ; "Thy soul is not in balance with the Truth. Ye have been judged."
				)
			)
			(1
				(anubis hide:)
				(gCurRoom drawPic: 0 10)
				(= seconds 3)
			)
			(2
				(gLongSong3 fade:)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance ringObj of Actor
	(properties
		x 75
		y 142
		noun 15
		view 361
		loop 2
		cel 2
	)

	(method (show)
		(if argc
			(= x 145)
			(= y 30)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= [local30 local20] self)
			(switch local20
				(0
					(= local19 20)
					(++ local20)
				)
				(1
					(= local19 21)
					(++ local20)
				)
				(else
					(= local19 29)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance keyObj of Actor
	(properties
		x 106
		y 57
		noun 5
		view 361
		loop 2
	)

	(method (show)
		(if argc
			(= x 150)
			(= y 18)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 6)
					(++ local20)
				)
				(else
					(= local19 17)
					(++ local20)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pentagram of Actor
	(properties
		x 213
		y 47
		noun 6
		view 361
		loop 2
		cel 1
	)

	(method (show)
		(if argc
			(= x 139)
			(= y 16)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 5)
					(++ local20)
				)
				(else
					(= local19 26)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance infinity of Actor
	(properties
		x 208
		y 137
		noun 14
		view 361
		loop 1
		cel 2
	)

	(method (show)
		(if argc
			(= x 133)
			(= y 23)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(= local19 19)
			(++ local20)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance yinYang of Actor
	(properties
		x 133
		y 90
		noun 8
		view 361
		cel 4
	)

	(method (show)
		(if argc
			(= x 134)
			(= y 14)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(= local19 18)
			(++ local20)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sword of Actor
	(properties
		x 230
		y 94
		noun 17
		view 361
		loop 2
		cel 3
	)

	(method (show)
		(if argc
			(= x 156)
			(= y 20)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 3)
					(++ local20)
				)
				(else
					(= local19 28)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance raisedFist of Actor
	(properties
		x 267
		y 73
		noun 7
		view 361
		cel 3
	)

	(method (show)
		(if argc
			(= x 144)
			(= y 9)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(= local19 15)
			(++ local20)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cup of Actor
	(properties
		x 137
		y 130
		noun 9
		view 361
		cel 2
	)

	(method (show)
		(if argc
			(= x 137)
			(= y 16)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 12)
					(++ local20)
				)
				(1
					(= local19 22)
					(++ local20)
				)
				(else
					(= local19 23)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance heart of Actor
	(properties
		x 21
		y 93
		noun 10
		view 361
		loop 1
	)

	(method (show)
		(if argc
			(= x 136)
			(= y 19)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(= local19 7)
			(++ local20)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hourglass of Actor
	(properties
		x 74
		y 38
		noun 11
		view 361
		loop 1
		cel 1
	)

	(method (show)
		(if argc
			(= x 146)
			(= y 15)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 9)
					(++ local20)
				)
				(else
					(= local19 16)
					(++ local20)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance candle of Actor
	(properties
		x 191
		y 59
		noun 12
		view 361
		cel 1
	)

	(method (show)
		(if argc
			(= x 153)
			(= y 19)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(= local19 24)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ankh of Actor
	(properties
		x 141
		y 34
		noun 4
		view 361
	)

	(method (show)
		(if argc
			(= x 144)
			(= y 13)
		)
		(super show:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(= [local30 local20] self)
		(if (== theVerb 4) ; Do
			(switch local20
				(0
					(= local19 8)
					(++ local20)
				)
				(else
					(= local19 25)
				)
			)
			(= local18 self)
			(HandsOff)
			(gLongSong2 number: 361 play: 127 setLoop: 1)
			(choices cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance anubis of Actor
	(properties
		x 10
		y 4
		noun 3
		view 361
		loop 4
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		(= window
			((GloryWindow new:)
				top: 0
				left: 30
				bottom: 175
				right: 295
				priority: -1
				yourself:
			)
		)
		(self add: upIcon aIcon bIcon cIcon xIcon eIcon)
		(super init: &rest)
	)
)

(instance aIcon of IconI
	(properties
		view 361
		loop 3
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= [local27 local21] 0)
		(quest state: (& (quest state:) $ffdf))
		(= local35 0)
	)

	(method (show &tmp [temp0 7])
		(= nsRight 240)
		(= nsBottom (+ nsTop 30))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local22 dsFONT gSmallFont dsCOORD 20 15 dsCOLOR 1 dsWIDTH 245)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 1)
		)
		(Display local22 dsFONT gSmallFont dsCOORD 20 15 dsCOLOR temp0 dsWIDTH 245)
	)
)

(instance bIcon of IconI
	(properties
		view 361
		loop 3
		cel 0
		nsTop 45
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= [local27 local21] 1)
		(quest state: (& (quest state:) $ffdf))
		(= local35 0)
	)

	(method (show &tmp [temp0 7])
		(= nsRight 240)
		(= nsBottom (+ nsTop 30))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local23 dsFONT gSmallFont dsCOORD 20 45 dsCOLOR 1 dsWIDTH 245)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 1)
		)
		(Display local23 dsFONT gSmallFont dsCOORD 20 45 dsCOLOR temp0 dsWIDTH 245)
	)
)

(instance cIcon of IconI
	(properties
		view 361
		loop 3
		cel 0
		nsTop 75
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= [local27 local21] 2)
		(quest state: (& (quest state:) $ffdf))
		(= local35 0)
	)

	(method (show &tmp [temp0 7])
		(= nsRight 240)
		(= nsBottom (+ nsTop 30))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local24 dsFONT gSmallFont dsCOORD 20 75 dsCOLOR 1 dsWIDTH 245)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 1)
		)
		(Display local24 dsFONT gSmallFont dsCOORD 20 75 dsCOLOR temp0 dsWIDTH 245)
	)
)

(instance xIcon of IconI
	(properties
		view 361
		loop 3
		cel 0
		nsTop 105
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= [local27 local21] 3)
		(quest state: (& (quest state:) $ffdf))
		(= local35 0)
	)

	(method (show &tmp [temp0 7])
		(= nsRight 240)
		(= nsBottom (+ nsTop 30))
		(Display local25 dsFONT gSmallFont dsCOORD 20 105 dsCOLOR 1 dsWIDTH 245)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 1)
		)
		(Display local25 dsFONT gSmallFont dsCOORD 20 105 dsCOLOR temp0 dsWIDTH 245)
	)
)

(instance eIcon of IconI
	(properties
		view 361
		loop 3
		cel 0
		nsTop 135
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= [local27 local21] 4)
		(quest state: (& (quest state:) $ffdf))
		(= local35 0)
	)

	(method (show &tmp [temp0 7])
		(= nsRight 240)
		(= nsBottom (+ nsTop 30))
		(Display local26 dsFONT gSmallFont dsCOORD 20 135 dsCOLOR 1 dsWIDTH 245)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
			(DrawCel view loop 1 nsLeft nsTop -1)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 1)
		)
		(Display local26 dsFONT gSmallFont dsCOORD 20 135 dsCOLOR temp0 dsWIDTH 245)
	)
)

(instance upIcon of IconI
	(properties
		view 361
		loop 3
		cel 2
		nsLeft 250
		nsTop 0
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local35 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft 250) (CelWide view loop cel)))
			(= nsTop 0)
			(= nsBottom (CelHigh view loop cel))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 3 nsLeft nsTop -1)
		else
			(DrawCel view loop 2 nsLeft nsTop -1)
		)
	)
)

(instance anubisTalker of Narrator
	(properties
		back 57
	)

	(method (doit)
		(Palette palANIMATE 72 255 1)
		(super doit:)
	)
)

(instance desTalker of Narrator
	(properties
		back 57
	)

	(method (doit)
		(Palette palANIMATE 72 255 1)
		(super doit:)
	)
)

(instance myPrint of Print
	(properties)

	(method (addText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (not dialog)
			(= dialog (myDialog new:))
		)
		(if (> argc 3)
			(= temp0 [param1 0])
			(= temp1 [param1 1])
			(= temp2 [param1 2])
			(= temp3 (if [param1 3] [param1 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 [param1 4])
				(if (>= argc 6)
					(= temp5 [param1 5])
					(if (>= argc 7)
						(= temp6 [param1 6])
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7)
					(dialog
						add:
							((DText new:)
								text: temp7
								font: font
								mode: mode
								setSize: width
								moveTo: (+ 4 temp4) (+ 4 temp5)
								yourself:
							)
						setSize:
					)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 [param1 1])
				(if (>= argc 3)
					(= temp5 [param1 2])
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen [param1 0]) 1)))
			(StrCpy temp7 [param1 0])
			(dialog
				add:
					((DText new:)
						text: temp7
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)
)

(instance myDialog of Dialog
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(Palette palANIMATE 72 255 1)
			(Animate (gCast elements:) 1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type:) 1)
					(temp0 type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)
)

