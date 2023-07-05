;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	endGame 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2] = [0 10]
	local6
	local7
	[local8 24] = [10 5 45 3 50 2 65 7 50 3 40 3 65 5 55 4 40 2 65 5 45 3 60 1000]
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42 = 1
	local43 = 1
	local44 = 1
	local45 = 1
	local46 = -1
	local47 = -1
	[local48 2] = [30 0]
	local50
	[local51 4]
	[local55 16]
	[local71 16]
	[local87 16]
	[local103 16]
	[local119 16]
	local135
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(for ((= temp2 0)) (< temp2 359) ((+= temp2 param2))
		(= temp0 (+ 0 (CosMult temp2 (- (+ param1 (Random 0 30)) 15))))
		(= temp1 (+ 0 (SinMult temp2 (- (+ param1 (Random 0 30)) 15))))
		(if (- temp0 0)
			(cond
				((> temp0 (- 319 param3))
					(= temp1
						(/
							(+ (* (- 319 param3) (- temp1 0)) (* 0 (- temp0 0)))
							(- temp0 0)
						)
					)
					(= temp0 (- 319 param3))
				)
				((< temp0 (- 0 param3))
					(= temp1
						(/
							(+ (* (- 0 param3) (- temp1 0)) (* 0 (- temp0 0)))
							(- temp0 0)
						)
					)
					(= temp0 (- 0 param3))
				)
			)
		else
			(if (> temp0 (- 319 param3))
				(= temp0 (- 319 param3))
			)
			(if (< temp0 (- 0 param3))
				(= temp0 (- 0 param3))
			)
		)
		(if (- temp1 0)
			(cond
				((> temp1 (- 199 param4))
					(= temp0
						(/ (* (- (- 199 param4) 0) (- temp0 0)) (- temp1 0))
					)
					(= temp1 (- 199 param4))
				)
				((< temp1 (- 0 param4))
					(= temp0 (/ (* (- (- 0 param4) 0) (- temp0 0)) (- temp1 0)))
					(= temp1 (- 0 param4))
				)
			)
		else
			(if (> temp1 (- 199 param4))
				(= temp1 (- 199 param4))
			)
			(if (< temp1 (- 0 param4))
				(= temp1 (- 0 param4))
			)
		)
		(Graph
			grDRAW_LINE
			param4
			param3
			(+ param4 temp1)
			(+ param3 temp0)
			(cond
				((not (endingCartoon2 state:)) 31)
				((Random 0 1) 31)
				(else 30)
			)
			-1
			-1
		)
	)
	(= temp3 (- param4 param1))
	(= temp4 (+ param4 param1))
	(= temp5 (- param3 param1))
	(= temp6 (+ param3 param1))
	(if (< temp3 0)
		(= temp3 0)
	)
	(if (> temp3 200)
		(= temp3 200)
	)
	(if (< temp5 0)
		(= temp5 0)
	)
	(if (> temp6 320)
		(= temp6 320)
	)
	(Graph grREDRAW_BOX temp3 temp5 temp4 temp6)
)

(procedure (localproc_1 param1)
	(if local50
		(Graph grRESTORE_BOX local50)
		(Graph grUPDATE_BOX [local55 0] [local71 0] [local87 0] [local103 0] 1)
		(= local50 0)
	)
	(if (and [local119 param1] (> (endingCredits state:) 0))
		(Graph grRESTORE_BOX [local119 param1])
		(Graph grUPDATE_BOX 0 0 200 320 1)
		(= [local119 param1] 0)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp [temp0 2] [temp2 200])
	(localproc_1)
	(Format @temp2 92 0 param1 param2) ; "%s"
	(TextSize @[local51 0] @temp2 (if local135 99 else 104) param5)
	(= [local55 local135] [local51 0])
	(= [local71 local135] [local51 1])
	(= [local87 local135] [local51 2])
	(= [local103 local135] [local51 3])
	(if local135
		(+= [local87 local135] 3)
		(+= [local103 local135] 3)
	)
	(+= [local55 local135] (- param4 2))
	(+= [local71 local135] param3)
	(+= [local87 local135] (+ param4 2))
	(+= [local103 local135] param3)
	(if (not local135)
		(= local50 (Graph grSAVE_BOX [local55 0] [local71 0] [local87 0] [local103 0] 1))
	)
	(Display
		param1
		param2
		105
		(if local135 99 else 104)
		100
		param3
		param4
		102
		local135
		106
		param5
		121
	)
	(if (not local135)
		(Display param1 param2 105 103 100 param3 param4 102 15 106 param5 121)
	)
	(RedrawCast)
	(if local50
		(Graph
			grUPDATE_BOX
			[local55 local135]
			[local71 local135]
			(+ [local87 local135] 2)
			[local103 local135]
			1
		)
	)
)

(procedure (localproc_3 param1 param2 param3 param4)
	(= [local119 1] (Graph grSAVE_BOX param1 param2 param3 param4 1))
)

(procedure (localproc_4 param1 param2 param3 param4)
	(Graph grUPDATE_BOX param1 param2 param3 param4 1)
)

(instance joe of Act
	(properties)

	(method (cue)
		(funkyFades1
			init:
			posn: (+ (joe x:) 2) (joe y:)
			setPri: (- (joe priority:) 1)
			setCycle: Fwd
		)
		(joe
			view: 0
			illegalBits: 0
			ignoreActors: 1
			setLoop: 0
			cel: 1
			setPri: 13
		)
		((gCurRoom script:) cue:)
	)
)

(instance galahad of Act
	(properties
		y 59
		x 145
		view 384
	)

	(method (cue)
		(funkyFades2
			init:
			posn: (galahad x:) (galahad y:)
			setPri: (- (galahad priority:) 1)
			setCycle: Fwd
		)
		(galahad setLoop: 0 cel: 0)
		((gCurRoom script:) cue:)
	)
)

(instance galaHead of Prop
	(properties
		y 39
		x 145
		view 384
	)
)

(instance dougsRadDrawing of Act
	(properties
		xStep 1
	)
)

(instance prop1 of Prop
	(properties)
)

(instance prop2 of Prop
	(properties)
)

(instance galaWindow of SysWindow
	(properties
		color 14
		back 4
		title {Galahad}
		brTop 117
		brLeft 80
		brBottom 85
		brRight 170
	)
)

(instance endGame of Rm
	(properties
		picture 78
	)

	(method (init)
		(= local0 0)
		(MenuBar state: 0)
		(Load rsPIC 78)
		(Load rsVIEW 70)
		(Load rsVIEW 551)
		(Load rsVIEW 384)
		(Load rsVIEW 658)
		(Load rsVIEW 660)
		(Load rsVIEW 659)
		(Load rsVIEW 36)
		(Load rsPIC 301)
		(Load rsPIC 302)
		(Load rsPIC 303)
		(Load rsFONT 99)
		(Load rsSOUND (proc0_20 122))
		(Load rsVIEW 16)
		(Load rsSOUND 57)
		(Load rsVIEW 107)
		(Load rsVIEW 601)
		(Load rsPIC 101)
		(Load rsFONT 1)
		(Load rsFONT 103)
		(Load rsFONT 104)
		(Load rsSOUND (proc0_20 1))
		(Load rsPIC 7)
		(super init:)
		(joe init: posn: -5 106)
		(HandsOff)
		(= global109 6)
		(galahad init:)
		(proc0_13 113)
		(gAddToPics doit:)
		(gCurRoom setScript: endingCartoon1)
	)

	(method (doit)
		(super doit:)
		(SetCursor 999 0 500 500)
		(if (and (== (gRmMusic number:) 1) (== (gRmMusic prevSignal:) 20))
			(= local2 1)
		)
		(if (and (== local0 255) (or local2 (== (gRmMusic number:) 201)))
			(= local0 0)
			((gCurRoom script:) cue:)
		)
		(if (== (gRmMusic number:) (proc0_20 122))
			(if (gRmMusic prevSignal:)
				(= local1 (gRmMusic prevSignal:))
			)
			(if
				(and
					local0
					(or (and (<= local0 local1) (> local0 0)) (== local1 -1))
				)
				(= local0 0)
				((gCurRoom script:) cue:)
			)
		)
	)
)

(instance endingCartoon1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(joe
					setPri: 4
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 10 (joe y:) self
				)
			)
			(1
				(joe setMotion: MoveTo 70 76 self)
			)
			(2
				(gRmMusic number: (proc0_20 1) loop: -1 play:)
				(galahad setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(galaHead init: setPri: 15)
				(gTObj
					noTimer: 1
					actor: galaHead
					noWidth: 1
					tWindow: galaWindow
					tLoop: 1
					cSpeed: 0
					talkCue: self
				)
				(Talk 92 1) ; "My King! You have won the Grail!"
				(= seconds 3)
			)
			(5
				(= seconds 0)
				(gTObj endTalk:)
				(galaHead dispose:)
				(= cycles 2)
				(= seconds 1)
			)
			(6
				(localproc_2 92 2 160 50 150) ; "Aye, but rise, Sir Galahad, and draw near to your King at once! A great power is at work!"
				(= seconds 3)
			)
			(7
				(galahad setCycle: Beg)
				(= seconds 2)
			)
			(8
				(galahad
					setLoop: 2
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo (+ (joe x:) 24) (- (joe y:) 5) self
				)
			)
			(9
				(localproc_1)
				(galahad setLoop: 0 setCycle: 0 cel: 0)
				(joe setLoop: 0)
				(= cycles 3)
			)
			(10
				(joe setLoop: 0)
				(= cycles 2)
			)
			(11
				(funkyFades1
					init:
					posn: (joe x:) (joe y:)
					setPri: (- (joe priority:) 1)
					setCycle: Fwd
				)
				(funkyFades2
					init:
					posn: (galahad x:) (galahad y:)
					setPri: (- (galahad priority:) 1)
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(12
				(localproc_2 92 3 108 50 130) ; "The Grail has chosen to bring you home in your hour of desperate need!"
				(= seconds 2)
			)
			(13
				(funkyFades1 dispose:)
				(funkyFades2 dispose:)
				(galahad setLoop: 4 cycleSpeed: 1 cel: 1 setCycle: End self)
				(joe
					view: 36
					setLoop: 1
					cycleSpeed: 1
					cel: 1
					setCycle: End self
				)
			)
			(15
				(joe dispose:)
				(galahad dispose:)
				(= seconds 1)
			)
			(16
				(joe dispose:)
				(galahad dispose:)
				(= local0 255)
			)
			(17
				(= seconds 2)
			)
			(18
				(self dispose:)
				(gCurRoom setScript: endingCartoonChapel)
			)
		)
	)
)

(instance endingCartoonChapel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(dougsRadDrawing view: 384)
				(prop1 init: view: 107 loop: 0 cel: 1 posn: 180 107 stopUpd:)
				(prop2 init: view: 107 loop: 2 cel: 0 posn: 115 113)
				(gRmMusic stop:)
				(gCurRoom drawPic: 7 8)
				(proc0_13 258)
				(gAddToPics doit:)
				(= seconds 2)
			)
			(1
				(gRmMusic number: 57 loop: 1 play:)
				(joe
					init:
					illegalBits: 0
					posn: 121 168
					view: 36
					setLoop: 1
					cel: 4
					setCycle: Beg joe
				)
				(galahad
					init:
					illegalBits: 0
					posn: 145 163
					setLoop: 4
					cel: 2
					setPri: (- (joe priority:) 2)
					setCycle: Beg galahad
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(funkyFades1 dispose:)
				(funkyFades2 dispose:)
				(localproc_2 92 4 30 10 250) ; "The Grail has brought you here, Arthur. Only one god may rule in thy kingdom now. The altar of the Christ god awaits its vessel."
				(= seconds 4)
			)
			(5
				(joe setLoop: 0)
				(= seconds 1)
			)
			(6
				(joe
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 157 168 self
				)
			)
			(7
				(galahad setLoop: 3)
				(joe setMotion: MoveTo 171 158 self)
			)
			(8
				(joe setMotion: MoveTo 171 152 self)
			)
			(9
				(joe view: 70 setLoop: 1 setCycle: End self)
			)
			(10
				(= local0 0)
				(theGrail init:)
				(gRmMusic number: (proc0_20 122) loop: 1 play:)
				(joe setCycle: Beg self)
			)
			(11
				(joe view: 0 loop: 3)
				(= seconds 5)
			)
			(12
				(localproc_1)
				(localproc_2 92 5 30 15 250) ; "Cast down your eyes! The radiance of the Grail is too great for any man to see."
				(= local0 2)
			)
			(13
				(theGrail loop: 3 setCycle: Fwd)
				(joe view: 16 cycleSpeed: 1 loop: 1 cel: 0 setCycle: End)
				(= cycles 2)
			)
			(14
				(galahad view: 16 loop: 2 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 2)
			)
			(15
				(= local0 5)
			)
			(16
				(localproc_1)
				(if (!= global103 0)
					(localproc_0 30 20 183 119)
				)
				(= cycles 2)
			)
			(17
				(localproc_0 60 10 183 119)
				(= cycles 2)
			)
			(18
				(if (!= global103 0)
					(localproc_0 100 10 183 119)
				)
				(= cycles 2)
			)
			(19
				(localproc_0 200 5 183 119)
				(= cycles 2)
			)
			(20
				(prop2 setCycle: End self)
			)
			(21
				(= local0 10)
			)
			(22
				(theGrail dispose:)
				(gCurRoom drawPic: 7 7)
				(proc0_13 258)
				(gAddToPics doit:)
				(localproc_2 92 6 47 15 250) ; "Behold, Mithra has been driven away! And the Grail is gone!"
				(= seconds 2)
			)
			(23
				(joe setCycle: Beg self)
				(= cycles 2)
			)
			(24
				(galahad setCycle: Beg self)
			)
			(25
				(joe view: 0 setLoop: 1)
			)
			(26
				(galahad view: 384 setLoop: 3)
				(joe setLoop: 2)
				(= local0 20)
			)
			(27
				(self dispose:)
				(gCurRoom setScript: endingCartoon2)
			)
		)
	)
)

(instance endingCartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(joe dispose:)
				(galahad dispose:)
				(prop1 dispose:)
				(prop2 dispose:)
				(= global61 3)
				(gCurRoom drawPic: 101 8)
				(proc0_13 258)
				(gAddToPics doit:)
				(sparkles1 init: view: 601 loop: 7 posn: 191 23)
				(= local34 (shimmers1 new:))
				(= local35 (shimmers1 new:))
				(= local36 (shimmers1 new:))
				(= local37 (shimmers1 new:))
				(= local38 (shimmers1 new:))
				(= local39 (shimmers1 new:))
				(= local40 (shimmers1 new:))
				(= local41 (shimmers1 new:))
				(shimmers1 init:)
				(local34 init:)
				(local35 init:)
				(local36 init:)
				(local37 init:)
				(local38 init:)
				(local39 init:)
				(local40 init:)
				(local41 init:)
				(localproc_2 92 7 11 23 200) ; "It has become a healing force that spreads outward, touching every corner of your kingdom!"
				(UnLoad 133 local50)
				(= local50 0)
				(= local0 25)
			)
			(1
				(shimmers1 dispose:)
				(local34 dispose:)
				(local35 dispose:)
				(local36 dispose:)
				(local37 dispose:)
				(local38 dispose:)
				(local39 dispose:)
				(local40 dispose:)
				(local41 dispose:)
				(if (!= global103 0)
					(localproc_0 30 20 164 62)
				)
				(= cycles 2)
			)
			(2
				(localproc_0 60 10 164 62)
				(= cycles 2)
			)
			(3
				(if (!= global103 0)
					(localproc_0 100 10 164 62)
				)
				(= cycles 2)
			)
			(4
				(localproc_0 200 5 164 62)
				(= local0 30)
			)
			(5
				(prop1
					init:
					view: 601
					loop: 6
					posn: 130 170
					cycleSpeed: 2
					setPri: 10
					setCycle: Fwd
				)
				(prop2
					init:
					view: 601
					loop: 5
					posn: 185 187
					cycleSpeed: 2
					setPri: 10
					setCycle: Fwd
				)
				(if (== global103 0)
					(prop1 posn: 137 165)
					(prop2 posn: 188 181)
				)
				(= global61 (if (== global103 0) 0 else 2))
				(gCurRoom drawPic: 101 7)
				(proc0_13 258)
				(gAddToPics doit:)
				(localproc_2 92 7 11 23 200) ; "It has become a healing force that spreads outward, touching every corner of your kingdom!"
				(if (!= global103 0)
					(UnLoad 133 local50)
					(= local50 0)
					(= seconds 2)
				else
					(= seconds 5)
				)
			)
			(6
				(if (!= global103 0)
					(gCurRoom drawPic: 101 100)
					(proc0_13 258)
					(gAddToPics doit:)
				else
					(localproc_1)
				)
				(localproc_2 92 8 11 23 200) ; "The land returns to life. The lakes and rivers and wells fill once more with clean, fresh water."
				(if (== global103 0)
					(= seconds 7)
				else
					(self cue:)
				)
			)
			(18
				(= local0 40)
			)
			(7
				(if (!= global103 0)
					(UnLoad 133 local50)
					(= local50 0)
					(= global61 1)
					(gCurRoom drawPic: 101 7)
					(proc0_13 258)
					(gAddToPics doit:)
					(localproc_2 92 8 11 23 200) ; "The land returns to life. The lakes and rivers and wells fill once more with clean, fresh water."
					(UnLoad 133 local50)
					(= local50 0)
				)
				(prop1 posn: 137 165 cycleSpeed: 1)
				(prop2 posn: 188 181 cycleSpeed: 1)
				(sparkles1 cycleSpeed: 2 setCycle: Fwd)
				(sparkles4 init: view: 601 loop: 3 setPri: 15 posn: 213 176)
				(= local0 50)
			)
			(8
				(if (!= global103 0)
					(= global61 0)
					(gCurRoom drawPic: 101 7)
					(proc0_13 258)
					(gAddToPics doit:)
				else
					(localproc_1)
				)
				(localproc_2 92 9 33 41 120) ; "Camelot is healed!"
				(sparkles1
					loop: 4
					posn: 162 23
					cycleSpeed: 0
					cel: 0
					cycleSpeed: 1
					setCycle: Fwd
				)
				(sparkles2
					init:
					view: 601
					loop: 4
					cel: 1
					cycleSpeed: 1
					posn: 190 25
					setCycle: Fwd
				)
				(sparkles3
					init:
					view: 601
					loop: 4
					cel: 2
					cycleSpeed: 1
					posn: 207 36
					setCycle: Fwd
				)
				(sparkles5 init: view: 601 loop: 3 posn: 235 172)
				(sparkles6 init: view: 601 loop: 3 posn: 280 172)
				(dougsRadDrawing
					init:
					view: 601
					setLoop: 2
					setCycle: Fwd
					posn: -9 154
					moveSpeed: 1
					cycleSpeed: 1
					setPri: 0
					setMotion: MoveTo 150 154
				)
				(= local0 60)
			)
			(9
				(UnLoad 133 local50)
				(= local50 0)
				(prop1 dispose:)
				(prop2 dispose:)
				(sparkles1 dispose:)
				(sparkles2 dispose:)
				(sparkles3 dispose:)
				(sparkles4 dispose:)
				(sparkles5 dispose:)
				(sparkles6 dispose:)
				(swordDude1 init:)
				(swordDude2 init:)
				(swordDude3 init:)
				(= global61 0)
				(gCurRoom drawPic: 301 3)
				(proc0_13 258)
				(gAddToPics doit:)
				(dougsRadDrawing
					init:
					setMotion: 0
					setLoop: 0
					setCycle: 0
					view: 658
					posn: 284 86
				)
				(localproc_2 92 10 135 9 200) ; "You receive Gwenhyver's praise and adoration, as you have well earned."
				(= seconds 8)
			)
			(10
				(localproc_1)
				(dougsRadDrawing setCycle: Fwd)
				(localproc_2 92 11 116 7 250) ; "Your knights salute you and the joyous cries of the love and   gratitude of your people fills     the air."
				(= seconds 3)
			)
			(11
				(swordDude1 cel: -1 setCycle: End)
				(swordDude2 setMotion: MoveTo (swordDude2 x:) 116)
				(swordDude3 cel: -1 setCycle: End)
				(= local0 70)
			)
			(12
				(UnLoad 133 local50)
				(= local50 0)
				(dougsRadDrawing dispose:)
				(swordDude1 dispose:)
				(swordDude2 dispose:)
				(swordDude3 dispose:)
				(gCurRoom drawPic: 302 6)
				(proc0_13 256)
				(gAddToPics doit:)
				(eyes init: cycleSpeed: 1 view: 659 posn: 163 30 loop: 0)
				(mouth init: view: 659 posn: 164 44 loop: 1)
				(hand init: view: 659 posn: 196 62 loop: 2)
				(sparkles1 init: view: 659 posn: 107 125 cycleSpeed: 2 loop: 3)
				(sparkles2 init: view: 659 posn: 228 124 cycleSpeed: 2 loop: 3)
				(sparkles3 init: view: 659 posn: 202 37 cycleSpeed: 2 loop: 4)
				(sparkles4 init: view: 659 posn: 117 33 cycleSpeed: 2 loop: 4)
				(sparkles5 init: view: 659 posn: 229 77 cycleSpeed: 2 loop: 4)
				(sparkles6 init: view: 659 posn: 97 90 cycleSpeed: 2 loop: 4)
				(localproc_2 92 12 65 127 200) ; "And so you have won, through purity of spirit and heart, through skill and strength. No praise is too great."
				(= local33 1)
				(= seconds 14)
			)
			(13
				(localproc_1)
				(= local33 0)
				(= seconds 2)
			)
			(14
				(= local33 1)
				(localproc_2 92 13 65 127 200) ; "With peace and prosperity returned to your kingdom, you have the time to rest and enjoy the land you have saved."
				(= local0 80)
			)
			(15
				(= local33 0)
				(UnLoad 133 local50)
				(= local50 0)
				(sparkles4 dispose:)
				(sparkles5 dispose:)
				(sparkles6 dispose:)
				(gCurRoom drawPic: 303 8)
				(proc0_13 258)
				(gAddToPics doit:)
				(eyes init: view: 660 posn: 76 60 loop: 3)
				(mouth init: view: 660 posn: 78 77 loop: 4)
				(hand init: view: 660 posn: 222 139 loop: 0 cel: 0)
				(gwensEye init: view: 660 posn: 213 90 loop: 5)
				(sparkles1
					init:
					view: 660
					setLoop: 2
					posn: 130 155
					setPri: 9
					cycleSpeed: 1
				)
				(sparkles2
					init:
					view: 660
					setLoop: 2
					posn: 157 173
					setPri: 9
					cycleSpeed: 1
				)
				(sparkles3
					init:
					view: 660
					setLoop: 6
					posn: 185 160
					setPri: 11
					cycleSpeed: 1
				)
				(localproc_2 92 14 200 14 100) ; "But though your land is healed, your heart is not. Perhaps it never shall be."
				(= seconds 3)
			)
			(16
				(hand cycleSpeed: 2 setCycle: End self)
			)
			(17
				(sparkles3 setLoop: 7)
			)
			(19
				(localproc_1)
				(hand setCycle: Beg)
				(= local0 -1)
			)
			(20
				(self dispose:)
				(gCurRoom setScript: endingCredits)
			)
		)
	)
)

(instance endingCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				(gRmMusic number: 2 loop: -1 play:)
				(eyes dispose:)
				(gwensEye dispose:)
				(hand dispose:)
				(sparkles1 dispose:)
				(sparkles2 dispose:)
				(sparkles3 dispose:)
				(mouth dispose:)
				(= global61 1)
				(gCurRoom drawPic: 110 6)
				(proc0_13 258)
				(gAddToPics doit:)
				(localproc_3 87 130 150 190)
				(= local135 14)
				(localproc_2 92 15 136 90 200) ; "FINIS"
				(= seconds 4)
			)
			(1
				(localproc_1 1)
				(= seconds 2)
			)
			(2
				(localproc_3 25 70 180 250)
				(= local135 11)
				(localproc_2 92 16 114 30 320) ; "animators"
				(= local135 14)
				(localproc_2 92 17 78 60 290) ; "Douglas Herring"
				(localproc_2 92 18 78 78 290) ; "Kenn Nishiuye"
				(localproc_2 92 19 78 96 290) ; "Andy Hoyos"
				(localproc_2 92 20 78 114 290) ; "Jennifer Shontz"
				(localproc_2 92 21 78 132 290) ; "Peter Ledger"
				(localproc_4 25 70 180 250)
				(= seconds 8)
			)
			(3
				(localproc_1 1)
				(= seconds 1)
			)
			(4
				(localproc_3 45 75 190 250)
				(= local135 11)
				(localproc_2 92 22 81 50 200) ; "background artists"
				(= local135 14)
				(localproc_2 92 23 90 80 290) ; "Peter Ledger"
				(localproc_2 92 24 90 98 290) ; "Julian Ledger"
				(localproc_2 92 25 90 116 290) ; "Douglas Herring"
				(localproc_4 45 75 190 250)
				(= seconds 8)
			)
			(5
				(localproc_1 1)
				(= seconds 1)
			)
			(6
				(localproc_3 40 95 180 250)
				(= local135 11)
				(localproc_2 92 26 100 45 200) ; "programmers"
				(= local135 14)
				(localproc_2 92 27 100 75 290) ; "Bob Fischbach"
				(localproc_2 92 28 100 93 290) ; "Jerry Shaw"
				(localproc_2 92 29 100 111 290) ; "Eric Hart"
				(localproc_2 92 30 100 129 290) ; "Doug Oldfield"
				(localproc_4 40 95 180 250)
				(= seconds 8)
			)
			(7
				(localproc_1 1)
				(= seconds 1)
			)
			(8
				(localproc_3 7 55 200 260)
				(= local135 11)
				(localproc_2 92 31 60 8 200) ; "development system by"
				(= local135 14)
				(localproc_2 92 32 81 37 200) ; "Jeff Stephenson"
				(localproc_2 92 33 81 55 200) ; "Bob Heitman"
				(localproc_2 92 34 81 73 200) ; "Pablo Ghenis"
				(localproc_2 92 35 81 91 200) ; "John Hartin"
				(localproc_2 92 36 81 109 200) ; "Dan Foy"
				(localproc_2 92 37 81 127 200) ; "John Rettig"
				(localproc_2 92 38 81 145 200) ; "Corinna Abdul"
				(localproc_2 92 39 81 163 200) ; "Corey Cole"
				(localproc_4 10 55 200 260)
				(= seconds 15)
			)
			(9
				(localproc_1 1)
				(= seconds 1)
			)
			(10
				(localproc_3 60 75 120 250)
				(= local135 11)
				(localproc_2 92 40 80 65 200) ; "sound effects by"
				(= local135 14)
				(localproc_2 92 41 90 95 200) ; "Mark Seibert"
				(localproc_4 60 75 120 250)
				(= seconds 6)
			)
			(11
				(localproc_1 1)
				(= seconds 1)
			)
			(12
				(localproc_3 60 35 120 275)
				(= local135 11)
				(localproc_2 92 42 40 65 320) ; "camelot combat system by"
				(= local135 14)
				(localproc_2 92 25 80 95 200) ; "Douglas Herring"
				(localproc_4 60 35 120 275)
				(= seconds 6)
			)
			(13
				(localproc_1 1)
				(= seconds 1)
			)
			(14
				(localproc_3 60 75 120 250)
				(= local135 11)
				(localproc_2 92 43 80 65 200) ; "special thanks to"
				(= local135 14)
				(localproc_2 92 44 112 90 250) ; "Ellen Guon"
				(localproc_4 60 75 120 250)
				(= seconds 6)
			)
			(15
				(localproc_1 1)
				(= seconds 5)
			)
			(16
				(gRmMusic fade:)
				(= global59 SysWindow)
				(Print
					(Format @temp0 92 45 global210 global211 global212) ; "%3d/368 Skill Points %3d/293 Wisdom Points  %3d/358 Soul Points"
					80
					{Score}
					82
					999
					3
					0
					33
					4
					81
					{OK}
				)
				(localproc_1 1)
				(gRmMusic fade:)
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance eyes of Prop
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((< (endingCartoon2 state:) 15)
				(if (and (not cycler) (> cel 0))
					(self setCycle: Beg)
				)
				(if (and (not cycler) (not (Random 0 30)))
					(self setCycle: End)
				)
			)
			((and (not cycler) (not (Random 0 20)))
				(if (> cel 0)
					(self setCycle: Beg)
				else
					(self setCycle: End)
				)
			)
		)
	)
)

(instance gwensEye of Prop
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not cycler) (> cel 0))
			(self setCycle: Beg)
		)
		(if (and (not cycler) (not (Random 0 20)))
			(self setCycle: End)
		)
	)
)

(instance mouth of Prop
	(properties)

	(method (init)
		(super init:)
		(if (< (endingCartoon2 state:) 15)
			(= cycleSpeed 2)
		else
			(= cycleSpeed 1)
		)
	)

	(method (doit)
		(super doit:)
		(if (< (endingCartoon2 state:) 15)
			(cond
				((and local33 (not cycler))
					(cond
						((> cel 0)
							(if (Random 0 1)
								(self cycleSpeed: 2)
							else
								(self cycleSpeed: 1)
							)
							(if (not (Random 0 3))
								(self setCycle: CT 1 -1)
							else
								(self setCycle: Beg)
							)
						)
						((not (Random 0 3))
							(self setCycle: CT 1 1)
						)
						(else
							(self setCycle: End)
						)
					)
				)
				((not local33)
					(= cel 2)
				)
			)
		else
			(if (and local6 (not cycler) (not local7))
				(if (not cel)
					(self setCycle: End)
				else
					(self setCycle: Beg)
					(-- local6)
				)
			)
			(if (and (not local6) (not local7))
				(= local7 [local8 local32])
				(= local6 [local8 (++ local32)])
				(++ local32)
			)
			(if local7
				(-- local7)
			)
		)
	)
)

(instance hand of Prop
	(properties)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(< (endingCartoon2 state:) 15)
				(not cycler)
				(not (Random 0 40))
			)
			(if (> cel 0)
				(self setCycle: Beg)
			else
				(self setCycle: End)
			)
		)
	)
)

(instance sparkles1 of Prop
	(properties)

	(method (init)
		(super init:)
		(if (not (< (endingCartoon2 state:) 9))
			(self setCycle: Fwd)
		)
	)

	(method (doit)
		(super doit:)
		(if (< (-- local3) 0)
			(= local3 24)
		)
		(if (and (not (< (endingCartoon2 state:) 15)) (not local3))
			(if (not local3)
				(+= x (* local42 2))
				(+= y (* local43 1))
			)
			(if (< y 153)
				(= y 153)
				(= local43 1)
			)
			(if (> y 175)
				(= y 175)
				(= local43 -1)
			)
			(if (< x 94)
				(= x 94)
				(= local42 1)
			)
			(if (> x 277)
				(= x 277)
				(= local42 -1)
			)
			(if
				(and
					(< (GetDistance x y (sparkles2 x:) (sparkles2 y:)) 4)
					(< (- y (sparkles2 y:)) (- x (sparkles2 x:)))
				)
				(if (< x (sparkles2 x:))
					(= local42 -1)
					(= local44 1)
				else
					(= local42 1)
					(= local44 -1)
				)
				(if (not (Random 0 4))
					(if (< y (sparkles2 y:))
						(= local43 -1)
						(= local45 1)
					else
						(= local43 1)
						(= local45 -1)
					)
				)
			)
			(if
				(and
					(< (GetDistance x y (sparkles3 x:) (sparkles3 y:)) 5)
					(< (- y (sparkles3 y:)) (- x (sparkles3 x:)))
				)
				(if (< x (sparkles3 x:))
					(= local42 -1)
					(= local46 1)
				else
					(= local42 1)
					(= local46 -1)
				)
				(if (not (Random 0 4))
					(if (< y (sparkles3 y:))
						(= local43 -1)
						(= local47 1)
					else
						(= local43 1)
						(= local47 -1)
					)
				)
			)
			(if (== local42 1)
				(= loop 2)
			else
				(= loop 1)
			)
		)
	)
)

(instance sparkles2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(if (not (< (endingCartoon2 state:) 15))
			(if (== local3 12)
				(+= x (* local44 1))
				(+= y (* local45 2))
			)
			(if (< y 153)
				(= y 153)
				(= local45 1)
			)
			(if (> y 175)
				(= y 175)
				(= local45 -1)
			)
			(if (< x 94)
				(= x 94)
				(= local44 1)
			)
			(if (> x 277)
				(= x 277)
				(= local44 -1)
			)
			(if
				(and
					(< (GetDistance x y (sparkles1 x:) (sparkles1 y:)) 4)
					(< (- y (sparkles1 y:)) (- x (sparkles1 x:)))
				)
				(if (< x (sparkles1 x:))
					(= local44 -1)
					(= local42 1)
				else
					(= local44 1)
					(= local42 -1)
				)
				(if (not (Random 0 4))
					(if (< y (sparkles1 y:))
						(= local45 -1)
						(= local43 1)
					else
						(= local45 1)
						(= local43 -1)
					)
				)
			)
			(if
				(and
					(< (GetDistance x y (sparkles3 x:) (sparkles3 y:)) 5)
					(< (- y (sparkles3 y:)) (- x (sparkles3 x:)))
				)
				(if (< x (sparkles3 x:))
					(= local44 -1)
					(= local46 1)
				else
					(= local44 1)
					(= local46 -1)
				)
				(if (not (Random 0 4))
					(if (< y (sparkles3 y:))
						(= local45 -1)
						(= local47 1)
					else
						(= local45 1)
						(= local47 -1)
					)
				)
			)
			(if (== local44 1)
				(= loop 2)
			else
				(= loop 1)
			)
		)
	)
)

(instance sparkles3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(cond
			((not (< (endingCartoon2 state:) 17))
				(if (== local3 21)
					(+= x (* local46 3))
					(+= y (* local47 1))
				)
				(if (< y 153)
					(= y 153)
					(= local47 1)
				)
				(if (> y 175)
					(= y 175)
					(= local47 -1)
				)
				(if (< x 94)
					(= x 94)
					(= local46 1)
				)
				(if (> x 277)
					(= x 277)
					(= local46 -1)
				)
				(if
					(and
						(< (GetDistance x y (sparkles1 x:) (sparkles1 y:)) 4)
						(< (- y (sparkles1 y:)) (- x (sparkles1 x:)))
					)
					(if (< x (sparkles1 x:))
						(= local46 -1)
						(= local42 1)
					else
						(= local46 1)
						(= local42 -1)
					)
					(if (not (Random 0 4))
						(if (< y (sparkles1 y:))
							(= local47 -1)
							(= local43 1)
						else
							(= local47 1)
							(= local43 -1)
						)
					)
				)
				(if
					(and
						(< (GetDistance x y (sparkles2 x:) (sparkles2 y:)) 5)
						(< (- y (sparkles2 y:)) (- x (sparkles2 x:)))
					)
					(if (< x (sparkles2 x:))
						(= local46 -1)
						(= local44 1)
					else
						(= local46 1)
						(= local44 -1)
					)
					(if (not (Random 0 4))
						(if (< y (sparkles2 y:))
							(= local47 -1)
							(= local45 1)
						else
							(= local47 1)
							(= local45 -1)
						)
					)
				)
			)
			((not (< (endingCartoon2 state:) 15))
				(switch (hand cel:)
					(0
						(self posn: 185 160)
					)
					(3
						(self posn: 184 163)
					)
					(else
						(self posn: 185 162)
					)
				)
			)
		)
		(if (and (== (endingCartoon2 state:) 17) (< x 175))
			(endingCartoon2 cue:)
		)
	)
)

(instance sparkles4 of Prop
	(properties)

	(method (init)
		(super init:)
		(if (not (< (endingCartoon2 state:) 9))
			(self setCycle: Fwd)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< (endingCartoon2 state:) 9) (not cycler) (not (Random 0 5)))
			(self cel: -1 setCycle: End)
		)
	)
)

(instance sparkles5 of Prop
	(properties)

	(method (init)
		(super init:)
		(if (not (< (endingCartoon2 state:) 9))
			(self setCycle: Fwd)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< (endingCartoon2 state:) 9) (not cycler) (not (Random 0 10)))
			(self cel: -1 setCycle: End)
		)
	)
)

(instance sparkles6 of Prop
	(properties)

	(method (init)
		(super init:)
		(if (not (< (endingCartoon2 state:) 9))
			(self setCycle: Fwd)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< (endingCartoon2 state:) 9) (not cycler) (not (Random 0 10)))
			(self cel: -1 setCycle: End)
		)
	)
)

(instance shimmers1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 551 posn: 500 500 setPri: 14)
	)

	(method (doit)
		(super doit:)
		(if (not cycler)
			(self posn: 500 500)
			(if (< (Random 1 3) 3)
				(self
					cel: -1
					posn:
						(+ 170 (CosMult (Random 1 359) (Random 0 57)))
						(+ 50 (SinMult (Random 1 359) (Random 0 57)))
					loop: (Random 0 4)
					setCycle: End
				)
			)
		)
	)
)

(instance theGrail of Prop
	(properties
		y 122
		x 182
		view 107
		cel 2
	)
)

(instance funkyFades1 of Prop
	(properties
		view 36
	)
)

(instance funkyFades2 of Prop
	(properties
		view 36
	)
)

(instance swordDude1 of Prop
	(properties
		y 100
		x 162
		view 658
		loop 1
	)
)

(instance swordDude2 of Act
	(properties
		y 126
		x 196
		yStep 4
		view 658
		loop 2
	)

	(method (init)
		(super init:)
		(self setLoop: loop)
	)
)

(instance swordDude3 of Prop
	(properties
		y 113
		x 238
		view 658
		loop 3
	)
)

