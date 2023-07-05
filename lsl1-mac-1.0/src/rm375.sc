;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm375 0
)

(local
	fireworkCounter
	colorCycle
	[sizeElem 4]
	fireworkNum
	sparkX
	sparkY
)

(procedure (FindSize theText)
	(TextSize @sizeElem theText 0 315)
	(return (/ (- 180 (- [sizeElem 2] [sizeElem 0])) 2))
)

(procedure (Credits theText &tmp margin c)
	(gTheIconBar disable:)
	(gCurRoom drawPic: 376 13)
	(gTheIconBar enable:)
	(= margin (FindSize theText))
	(= c [gColDRed (- (Random 130 147) 130)])
	(Display theText dsCOLOR c dsCOORD 1 margin dsWIDTH 318 dsFONT gBigFont dsALIGN alCENTER)
)

(procedure (KillFireWorks)
	(gTheMusic2 stop:)
	(gTheMusic3 stop:)
	(sfxFWExplode stop:)
	(sfxFWLaunch stop:)
	(firework1 dispose:)
	(firework2 dispose:)
	(firework3 dispose:)
	(firework4 dispose:)
	(firework5 dispose:)
	(firework6 dispose:)
)

(instance rm375 of LLRoom
	(properties)

	(method (init &tmp foo)
		(= foo JumpTo)
		(gGame setCursor: gTheCursor 1 310 190)
		(if (IsFlag 46)
			(gCurRoom drawPic: 720)
			(gCurRoom setScript: sCredits)
		else
			(gCurRoom drawPic: 376)
			(gTheMusic2 number: 374 loop: 1 flags: 1)
			(gTheMusic3 number: 374 loop: 1 flags: 1)
			(LoadMany rsSOUND 373 374 700)
			(HandsOff)
			(gCurRoom setScript: sEcstasy)
			(gEgo init: x: 100 y: 1000 stopUpd:)
		)
		(super init:)
		(gGame setCursor: gTheCursor 1 310 190)
	)
)

(instance sEcstasy of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== colorCycle 2)
				(= colorCycle 0)
				(Palette palSET_FROM_RESOURCE 376 2)
			)
			(colorCycle
				(Palette palANIMATE 64 190 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= sparkX (Random 40 280))
				(= sparkY (Random 20 100))
				(= register (Random 140 180))
				(sfxFWLaunch play:)
				(launchFirework init: x: register setCel: 0 setCycle: End)
				(sparky
					init:
					show:
					x: register
					y: 185
					moveSpeed: (+ 1 global101)
					setMotion: sparkJump sparkX sparkY self
				)
			)
			(2
				(sparky hide:)
				(switch fireworkNum
					(0
						(firework1
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(sfxFWExplode play:)
					)
					(1
						(firework2
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(gTheMusic2 play:)
					)
					(2
						(firework3
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(gTheMusic3 play:)
					)
					(3
						(firework4
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(sfxFWExplode play:)
					)
					(4
						(firework5
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(gTheMusic2 play:)
					)
					(5
						(firework6
							cycleSpeed: (* 3 global101)
							init:
							x: sparkX
							y: sparkY
							setCel: 0
							setCycle: End
						)
						(gTheMusic3 play:)
					)
				)
				(= cycles (Random 1 4))
			)
			(3
				(= colorCycle 1)
				(if (< fireworkNum 6)
					(++ fireworkNum)
				else
					(= fireworkNum 0)
				)
				(= cycles 1)
			)
			(4
				(if (> fireworkCounter 30)
					(= colorCycle 2)
					(= cycles 1)
				else
					(++ fireworkCounter)
					(self start: 1 init:)
				)
			)
			(5
				(sfxFWExplode dispose:)
				(= seconds 5)
			)
			(6
				(KillFireWorks)
				(self dispose:)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Credits {Executive Producer\nKen Williams})
				(= seconds 3)
			)
			(2
				(Credits {Creative Director\nBill Davis})
				(= seconds 3)
			)
			(3
				(Credits {Director\nAl Lowe})
				(= seconds 3)
			)
			(4
				(Credits {Producer\nStuart Moulder})
				(= seconds 3)
			)
			(5
				(Credits {Game Designer\nAl Lowe})
				(= seconds 3)
			)
			(6
				(Credits {Art Designer\nWilliam Skirvin})
				(= seconds 3)
			)
			(7
				(Credits {Lead Programmer\nOliver Brelsford})
				(= seconds 3)
			)
			(8
				(Credits {Composer\nChris Braymen})
				(= seconds 3)
			)
			(9
				(Credits
					{Animators\nBarry Smith\nJennifer Shontz\nRoger Hardy Jr.\nWilliam D. Skirvin\nEric Apel\nRuss Truelove\nDesie Hartman}
				)
				(= seconds 3)
			)
			(10
				(Credits
					{Background Artists\nWilliam D. Skirvin\nJay Allan Friedmann\nJennifer Shontz\nJane Cardinal\nMaurice Morgan}
				)
				(= seconds 3)
			)
			(11
				(Credits
					{Macintosh Lead Programmer\nKrishnan Shankar\n\nMacintosh Systems Programmer\nRandy Moss\n\nQuality Assurance\nBill Hilton\nJason Hickingbottom }
				)
				(= seconds 6)
			)
			(12
				(Credits
					{Artist\nPhyllis Cucchiara\n\nMusic\nRobert Holmes }
				)
				(= seconds 3)
			)
			(13
				(Credits
					{Programmers\nOliver Brelsford\nMike Larsen\nAl Lowe}
				)
				(= seconds 3)
			)
			(14
				(Credits {Witty Text and Documentation\nJosh Mandel})
				(= seconds 3)
			)
			(15
				(Credits
					{Music Director\nMark Seibert\n\nTheme Song Composed by\nAl Lowe\n\nSound Effects\nChris Braymen\nMark Seibert\nand Orpheus Hanley}
				)
				(= seconds 3)
			)
			(16
				(Credits
					{System Programmers\nJ. Mark Hood\nJeff Stephenson\nBob Heitman\nPablo Ghenis\nDan Foy\nLarry Scott\nMark Wilden\nEric Hart\nChris Smith\nJohn Rettig}
				)
				(= seconds 3)
			)
			(17
				(Credits
					{Quality Assurance\nGary Cox\nRobin Bradley\nJudy Crites\nJoe Perry\nDave Clingman\nRoger Clendenning\nMike Pickhinke}
				)
				(= seconds 3)
			)
			(18
				(gCurRoom drawPic: 376 13)
				(= seconds 20)
			)
			(19
				(gTheMusic2 fade: 0 15 15 1 self)
			)
			(20
				(gCurRoom drawPic: 376 13)
				(Display
					{It's over!\nQuit!!\nGet a Life!!!}
					dsCOLOR
					gColWhite
					dsCOORD
					1
					30
					dsWIDTH
					318
					dsFONT
					gGiantFont
					dsALIGN
					alCENTER
				)
				(= seconds 3)
			)
			(21
				(= gQuit 1)
			)
		)
	)
)

(instance sfxFWExplode of Sound
	(properties
		flags 1
		number 374
	)
)

(instance sfxFWLaunch of Sound
	(properties
		flags 1
		number 373
	)
)

(instance sparkJump of JumpTo
	(properties)

	(method (doit)
		(if (>= (++ b-moveCnt) (client moveSpeed:))
			(= b-moveCnt 0)
			(super doit:)
		)
	)
)

(instance sparky of Actor
	(properties
		y 185
		yStep 5
		view 375
		signal 22528
		xStep 4
		moveSpeed 5
	)
)

(instance launchFirework of Prop
	(properties
		x 150
		y 189
		view 375
		signal 24576
	)
)

(instance firework1 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 1
		signal 24576
	)
)

(instance firework2 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 2
		signal 24576
	)
)

(instance firework3 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 3
		signal 24576
	)
)

(instance firework4 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 4
		signal 24576
	)
)

(instance firework5 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 5
		signal 24576
	)
)

(instance firework6 of Prop
	(properties
		x 61
		y 57
		view 375
		loop 6
		signal 24576
	)
)

