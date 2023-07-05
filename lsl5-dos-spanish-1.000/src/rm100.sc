;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use eRS)
(use Interface)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	letter
	letterX
	[string 100]
	[underBs 12]
	cycleThemColors
)

(procedure (TypeIt &tmp [ltr 6] char theUnders)
	(= char (StrAt @string letter))
	(Format @ltr {%c} char)
	(= theUnders
		(Display
			@ltr
			dsCOORD
			letterX
			160
			dsCOLOR
			gColWhite
			dsWIDTH
			7
			dsALIGN
			alLEFT
			dsFONT
			gMonoFont
			dsSAVEPIXELS
		)
	)
	(if (< (proc0_28 21 21 24 21 21) letter (proc0_28 29 29 32 29 29))
		(= [underBs (- letter (proc0_28 22 22 25 22 22))] theUnders)
	else
		(UnLoad 133 theUnders)
	)
	(+= letterX 7)
	(if (== 32 char)
		(-= letterX 2)
	)
)

(instance rm100 of LLRoom
	(properties
		picture 100
		style 10
	)

	(method (init)
		(gTheIconBar disable:)
		(User canInput: 0)
		(LoadMany rsPIC 105)
		(LoadMany rsVIEW 105 106 107 108 109)
		(LoadMany rsSOUND 101 102 103 104 105)
		(gTheMusic number: 100 setLoop: -1 flags: 1 play:)
		(StrCpy @string {Passionate Patti Does PittsbuA Little Undercover Work})
		(super init:)
		(HandsOff)
		(gTheIconBar disable: 8)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(SetFFRoom 120)
		(self setScript: sCartoon)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(not (& (gTheIconBar state:) $0004))
				(!= (event message:) KEY_ESCAPE)
				(!= (event message:) KEY_ALT_a)
				(!= (event message:) KEY_ALT_r)
				(!= (event message:) KEY_ALT_t)
			)
			(if
				(Print ; "Throughout this game, you can "Zap" ahead by clicking this Fast Forward button, which is now hidden at the top of your screen."
					100
					0
					80
					{Fast Forward}
					82
					990
					11
					0
					106
					81
					{Really? Show Me!}
					1
					81
					{Oops}
					0
				)
				(gTheIconBar
					curIcon: (gTheIconBar at: 5)
					handleEvent: (event type: evKEYBOARD message: KEY_ESCAPE yourself:)
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)
)

(instance sCartoon of Script
	(properties)

	(method (doit)
		(super doit:)
		(if cycleThemColors
			(Palette palANIMATE 24 31 -1)
			(Palette palANIMATE 240 254 -1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(larry init:)
				(patti init:)
				(blankPanel init:)
				(glue init:)
				(gCurRoom drawPic: 105 10)
				(= seconds 3)
			)
			(2
				(gTheIconBar enable:)
				(User canInput: 1)
				(gTheIconBar enable: 8)
				(larry setCycle: End self)
			)
			(3
				(broomUp play:)
				(larry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(4
				(broomUp play:)
				(larry setCel: 0 setCycle: End self)
			)
			(5
				(glue setPri: 0)
				(larry setLoop: 3 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(brush init:)
				(larry setLoop: 4 setCel: 0 setCycle: End self)
			)
			(8
				(blankPanel dispose:)
				(larry view: 108 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(9
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(10
				(larry
					setLoop: 1
					setCel: 0
					x: (+ (larry x:) 20)
					setCycle: End self
				)
			)
			(11
				(larry setLoop: 2 setCel: 0 setCycle: End self)
			)
			(12
				(= cycleThemColors 1)
				(= seconds 5)
			)
			(13
				(patti setCycle: Walk setMotion: MoveTo 15 140 self)
			)
			(14
				(patti setMotion: MoveTo 335 140)
				(= letter 0)
				(= letterX 3)
				(larry setScript: sLarryCartoon)
				(= cycles 1)
			)
			(15
				(TypeIt)
				(typewriter play:)
				(if (< (++ letter) (proc0_28 29 29 32 29 29))
					(= cycles (Random 3 5))
					(-- state)
				else
					(= cycles 10)
				)
			)
			(16
				(Display
					{}
					dsRESTOREPIXELS
					[underBs (- (-- letter) (proc0_28 22 22 25 22 22))]
				)
				(backSpace play:)
				(if (> letter (proc0_28 22 22 25 22 22))
					(= cycles 4)
					(-- state)
				else
					(= letterX (proc0_28 153 153 169 153 153))
					(= letter (proc0_28 29 29 32 29 29))
					(= cycles 10)
				)
			)
			(17
				(TypeIt)
				(typewriter play:)
				(if (< (++ letter) (StrLen @string))
					(-- state)
					(= cycles (Random 3 5))
				else
					(= cycles 10)
				)
			)
			(18
				(= ticks 270)
			)
			(19
				(gCurRoom newRoom: 110)
				(self dispose:)
			)
		)
	)
)

(instance sLarryCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(larry setLoop: 4 setCel: 0 setCycle: ForwardCounter 4 self)
			)
			(1
				(larry
					view: 106
					setLoop: 4
					setCel: 0
					posn: 268 133
					setCycle: CT 3 1 self
					setMotion: MoveTo 263 133 self
				)
			)
			(2)
			(3
				(glue dispose:)
				(larry setCycle: CT 5 1 self)
			)
			(4
				(footInBucket play:)
				(larry setCycle: End self)
			)
			(5
				(larry
					setLoop: 0
					setCel: 0
					x: (- (larry x:) 5)
					setCycle: CT 4 1 self
				)
			)
			(6
				(glueStretch play:)
				(larry setCycle: End self)
			)
			(7
				(larry setCycle: Beg self)
			)
			(8
				(larry setLoop: 1 setCel: 0 setCycle: ForwardCounter 2 self)
			)
			(9
				(larry setLoop: 2 setCel: 0 setCycle: ForwardCounter 2 self)
			)
			(10
				(larry setLoop: 3 setCel: 0 setCycle: End self)
			)
			(11
				(larry
					view: 107
					setLoop: 0
					setCel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(12
				(glueStretch play:)
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance larry of Actor
	(properties
		x 230
		y 132
		view 105
		loop 1
		signal 16384
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance patti of Actor
	(properties
		x -16
		y 140
		view 109
		signal 16384
		cycleSpeed 10
		xStep 5
		moveSpeed 10
	)
)

(instance blankPanel of View
	(properties
		x 223
		y 108
		view 108
		loop 3
		signal 16385
	)
)

(instance glue of View
	(properties
		x 251
		y 132
		view 105
		signal 16385
	)
)

(instance brush of View
	(properties
		x 256
		y 132
		view 105
		cel 1
		signal 16385
	)
)

(instance footInBucket of Sound
	(properties
		number 101
	)
)

(instance typewriter of Sound
	(properties
		number 102
	)
)

(instance broomUp of Sound
	(properties
		number 103
	)
)

(instance glueStretch of Sound
	(properties
		number 104
	)
)

(instance backSpace of Sound
	(properties
		number 105
	)
)

