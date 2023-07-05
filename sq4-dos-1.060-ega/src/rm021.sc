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
	(gCurRoom drawPic: 803 42)
	(= temp0 (localproc_0 param1))
	(Display param1 dsCOLOR global131 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 0 dsALIGN alCENTER)
)

(procedure (localproc_2 param1 &tmp temp0) ; UNUSED
	(gCurRoom drawPic: 803 42)
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
				(= seconds 15)
			)
			(2
				(= start 3)
				(if (== local4 1)
					(gNarrator enable:)
					(HandsOff)
				)
				(= cycles 1)
			)
			(3
				(if (== local4 5)
					(= gQuit 1)
				else
					(= cycles 1)
				)
			)
			(4
				(localproc_1
					{Animators:\n\nJon Bock\nJane Cardinal\nJeff Crowe\nMark Crowe\nDesie Hartman\nEric Kasner\nJim Larsen\nNathan Larsen\nSuzi LivenGood\nCheryl Loyd\nMichael A. Milo\nGerald Moore\nCheryl Sweeney\nWillis Wong}
				)
				(= seconds 15)
			)
			(5
				(localproc_1
					{Background Artists:\n\nJon Bock\nJane Cardinal\nMark Crowe\nJennifer Shontz\nCheryl Sweeney}
				)
				(= seconds 8)
			)
			(6
				(localproc_1
					{Programmers:\n\nOliver Brelsford\nCarlos Escobar\nBrian K. Hughes\nMike Larsen\nRandy MacNeill\nScott Murphy\nDoug Oldfield\nRaoul Said\nJerry Shaw}
				)
				(= seconds 20)
			)
			(7
				(localproc_1
					{Composers:\n\nKen Allen\nRob Atesalp\nMark Seibert}
				)
				(= seconds 7)
			)
			(8
				(localproc_1
					{System Development:\n\nJeff Stephenson\nRobert E. Heitman\nPablo Ghenis\nDan Foy\nLarry Scott\nTerry McHenry\nJohn Rettig\nCorey Cole\nJ. Mark Hood\nEric Hart\nJohn Hartin\nMark Wilden}
				)
				(= seconds 15)
			)
			(9
				(localproc_1
					{Sound Effects:\n\nKen Allen\nRob Atesalp\nMark Seibert}
				)
				(= seconds 5)
			)
			(10
				(localproc_1 {Additional Material:\n\nJosh Mandel})
				(= seconds 3)
			)
			(11
				(localproc_1 {Quality Assurance:\n\nMike Harian\nDan Scott})
				(= seconds 3)
			)
			(12
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

