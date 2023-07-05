;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	[local0 4]
	local4
)

(procedure (localproc_0 param1)
	(TextSize @local0 param1 0 315)
	(return (/ (- 180 (- [local0 2] [local0 0])) 2))
)

(procedure (localproc_1 param1 &tmp temp0)
	(gTheIconBar disable:)
	(gCurRoom drawPic: 803 13)
	(= temp0 (localproc_0 param1))
	(Display param1 dsCOLOR global136 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 0 dsALIGN alCENTER)
)

(procedure (localproc_2 param1 &tmp temp0) ; UNUSED
	(gCurRoom drawPic: 803 13)
	(= temp0 (localproc_0 param1))
	(Display param1 dsCOLOR global149 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 7 dsALIGN alCENTER)
)

(instance rm021 of SQRoom
	(properties
		picture 21
	)

	(method (init)
		(super init:)
		(Load rsSOUND 823)
		(Load rsVIEW 24)
		(LoadMany rsPIC 803 21)
		(Load rsFONT 0)
		(p1 init: setCycle: Fwd)
		(p2 init: setCycle: Fwd)
		(p3 init: setCycle: Fwd)
		(proc0_14 4)
		(if (!= gPrevRoomNum 540)
			(self setRegions: 707) ; intro
		)
		(switch gPrevRoomNum
			(20
				(gLongSong number: 823 loop: -1 play:)
				(self setScript: rmScript)
			)
			(540
				(self setScript: endScript 0 450)
			)
			(else
				(gLongSong number: 823 loop: -1 play:)
				(self setScript: rmScript)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 700)
				(= cycles 2)
			)
			(1
				(while (and (-- register) (== gNewRoomNum gCurRoomNum))
					(if (== register 100)
						(gLongSong fade:)
					)
					(User doit:)
					(Palette palANIMATE 176 207 1)
					(Animate (gCast elements:) 1)
				)
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(while (-- register)
					(Palette palANIMATE 176 207 1)
					(Animate (gCast elements:) 1)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 6)
				(= cycles 10)
			)
			(1
				(localproc_1
					{"So many unanswered questions. The future will be most interesting for Roger - if he can stay out of trouble long enough to see it. We're glad you could help Roger get through it all. Thank you for playing Space Quest IV. We hope it's been as entertaining as you have."}
				)
				(= seconds 1)
			)
			(2
				(gTheIconBar enable:)
				(= seconds 15)
			)
			(3
				(= start 3)
				(if (== local4 1)
					(gTheIconBar enable:)
					(HandsOff)
				)
				(= cycles 1)
			)
			(4
				(if (== local4 5)
					(= gQuit 1)
				else
					(= cycles 1)
				)
			)
			(5
				(localproc_1
					{Animators:\n\nJon Bock\nJane Cardinal\nJeff Crowe\nMark Crowe\nDesie Hartman\nEric Kasner\nJim Larsen\nNathan Larsen\nSuzi LivenGood\nCheryl Loyd\nGerald Moore\nCheryl Sweeney\nWillis Wong}
				)
				(= seconds 1)
			)
			(6
				(gTheIconBar enable:)
				(= seconds 15)
			)
			(7
				(localproc_1 {Video Digitization\n\nBob Ballew})
				(= seconds 1)
			)
			(8
				(gTheIconBar enable:)
				(= seconds 3)
			)
			(9
				(localproc_1
					{Background Artists:\n\nJon Bock\nJane Cardinal\nMark Crowe\nCheryl Sweeney}
				)
				(= seconds 1)
			)
			(10
				(gTheIconBar enable:)
				(= seconds 8)
			)
			(11
				(localproc_1
					{Programmers:\n\nOliver Brelsford\nCarlos Escobar\nBrian K. Hughes\nMike Larsen\nRandy MacNeill\nScott Murphy\nDoug Oldfield\nRaoul Said\nJerry Shaw}
				)
				(= seconds 1)
			)
			(12
				(gTheIconBar enable:)
				(= seconds 20)
			)
			(13
				(localproc_1
					{Composers:\n\nKen Allen\nRob Atesalp\nMark Seibert}
				)
				(= seconds 1)
			)
			(14
				(gTheIconBar enable:)
				(= seconds 7)
			)
			(15
				(localproc_1
					{System Development:\n\nJeff Stephenson\nRobert E. Heitman\nDan Foy\nLarry Scott\nJ. Mark Hood\nEric Hart\nMark Wilden\nChad Bye\nChris Smith\nTerry McHenry\nKen Koch\nJohn Rettig\nJohn Crane\nSteven Coallier\nRandy Moss}
				)
				(= seconds 1)
			)
			(16
				(gTheIconBar enable:)
				(= seconds 15)
			)
			(17
				(localproc_1
					{Sound Effects:\n\nKen Allen\nRob Atesalp\nMark Seibert}
				)
				(= seconds 1)
			)
			(18
				(gTheIconBar enable:)
				(= seconds 5)
			)
			(19
				(localproc_1 {Additional Material:\n\nJosh Mandel})
				(= seconds 1)
			)
			(20
				(gTheIconBar enable:)
				(= seconds 3)
			)
			(21
				(localproc_1
					{Quality Assurance:\n\nRobin Bradley\nMike Brosius\nRoger Clendenning\nGary Cox\nMike Harian\nMike Pickhinke\nDan Scott\n}
				)
				(= seconds 1)
			)
			(22
				(gTheIconBar enable:)
				(= seconds 5)
			)
			(23
				(localproc_1
					{Amiga Conversion Team:\n\n(Lead Programmer)\nSteven Coallier\n(Not-So-Lead Programmer)\nChristopher Carr}
				)
				(= seconds 1)
			)
			(24
				(gTheIconBar enable:)
				(= seconds 7)
			)
			(25
				(localproc_1 {Sound Programming:\n\nEric Hart})
				(= seconds 1)
			)
			(26
				(gTheIconBar enable:)
				(= seconds 4)
			)
			(27
				(localproc_1
					{Amiga System Developement:\n\nJohn Crane\nRandy Moss\nJohn Rettig\nSteven Coallier}
				)
				(= seconds 1)
			)
			(28
				(gTheIconBar enable:)
				(= seconds 10)
			)
			(29
				(localproc_1 {Amiga Producer:\n\nStuart Moulder})
				(= seconds 1)
			)
			(30
				(gTheIconBar enable:)
				(= seconds 4)
			)
			(31
				(localproc_1
					{Amiga Art Conversion:\n\nPhyllis Cucchiara\nTerrence Falls\nRichard Powell\nNathan Larsen}
				)
				(= seconds 1)
			)
			(32
				(gTheIconBar enable:)
				(= seconds 7)
			)
			(33
				(localproc_1
					{Amiga Music and Sound Effects:\n\nAubrey Hodges\nRobert Holmes}
				)
				(= seconds 1)
			)
			(34
				(gTheIconBar enable:)
				(= seconds 3)
			)
			(35
				(++ local4)
				(self init:)
			)
		)
	)
)

(instance p1 of Prop
	(properties
		x 155
		y 81
		view 24
		cycleSpeed 1
	)
)

(instance p2 of Prop
	(properties
		x 214
		y 86
		view 24
		loop 1
		cel 2
		cycleSpeed 1
	)
)

(instance p3 of Prop
	(properties
		x 85
		y 146
		view 24
		loop 2
		cel 2
		cycleSpeed 1
	)
)

