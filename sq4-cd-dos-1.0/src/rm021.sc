;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use RandCycle)
(use LoadMany)
(use Motion)
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

(procedure (localproc_1 param1 &tmp temp0) ; UNUSED
	(gCurRoom drawPic: 803 13)
	(= temp0 (localproc_0 param1))
	(proc816_2 21 0 temp0)
	(Display param1 dsCOLOR global131 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 0 dsALIGN alCENTER)
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
		(p1 init: setCycle: RandCycle)
		(p2 init: setCycle: Fwd)
		(p3 init: setCycle: Fwd)
		(proc0_14 4)
		(if (!= gPrevRoomNum 540)
			(self setRegions: 707) ; intro
		)
		(switch gPrevRoomNum
			(20
				(gLongSong number: 823 loop: 1 play:)
				(self setScript: newRmScript)
			)
			(540
				(self setScript: endScript 0 450)
			)
			(else
				(gLongSong number: 823 loop: 1 play:)
				(self setScript: newRmScript)
			)
		)
	)
)

(instance rmScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 700)
				(= cycles 2)
			)
			(1
				(if (and (-- register) (== gNewRoomNum gCurRoomNum))
					(Palette palANIMATE 176 207 1)
					(if (== register 100)
						(gLongSong fade:)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance newRmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(Palette palANIMATE 176 207 1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(gLongSong fade: self)
			)
			(2
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
				(gTheIconBar disable:)
				(= seconds 1)
			)
			(1
				(Palette palANIMATE 176 207 1)
				(Animate (gCast elements:) 1)
				(if (-- register)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 6)
				(= cycles 10)
			)
			(3
				(tCredits talkerNum: 99 noun: 99 nMsgType: 3 say: 1 self) ; "So many unanswered questions. The future should prove most interesting for Roger - if he can stay out of trouble long enough to reach it. We're glad you could help Roger get through it all. Thank you for playing Space Quest IV."
			)
			(4
				(tCredits talkerNum: 97 nMsgType: 1 say: 3 self) ; "Programmers:   Scott Murphy  Doug Oldfield  Dan Carver  Neil Matz  Bob Andrews  Max Deardorff  Oliver Brelsford  Carlos Escobar  Brian K. Hughes  Randy MacNeill  Doug Oldfield  Raoul Said  Jerry Shaw"
			)
			(5
				(tCredits talkerNum: 97 noun: 97 nMsgType: 1 say: 1 self) ; "Artists:   Jon Bock  Jane Cardinal  Jeff Crowe  Mark Crowe  Max Deardorff  Desie Hartman  Eric Kasner  Jim Larsen  Nathan Larsen  Suzi LivenGood  Cheryl Loyd  Michael A. Milo  Gerald Moore  Cheryl Sweeney  Willis Wong  Dana Dean  Don Waller  Karin A. Young"
			)
			(6
				(tCredits say: 4 self) ; "Music and Sound Effects:   Ken Allen  Rob Atesalp  Mark Seibert  Rick Spurgeon  Orpheus Hanley  Aubrey Hodges   with special thanks to  Veronica Oldfield"
			)
			(7
				(tCredits say: 5 self) ; "System Development:   Jeff Stephenson  Robert E. Heitman  Pablo Ghenis  Dan Foy  Larry Scott  Terry McHenry  J. Mark Hood  Eric Hart  Mark Wilden  Ken Koch  Chris Smith  Jack Magne  Martin Peters"
			)
			(8
				(tCredits say: 7 self) ; "Additional Material:   Josh Mandel"
			)
			(9
				(tCredits say: 8 self) ; "Quality Assurance:   Bill Hilton  Matt Genesi  Mike Harian  Dan Scott"
			)
			(10
				(tCredits say: 9 self) ; "Voices:  GARY OWENS - Narrator JEFF BENDER - Roger Wilco STUART MOULDER - Roger Wilco Jr. BARRY SMITH - Monochrome Boy,  Alien Bar Patron, 'Hz So Good' Salesbot KELLI SPURGEON - Zondra JANE JENSEN - Maebot DICK ROBERTS - 'Big and Tall' Salesbot SCOTT MURPHY - Sludge Vohaul, The Mustard MARK SEIBERT - Sequel Police #1, Garbage Can Man ORPHEUS HANLEY - Sequel Police #2 JOSH MANDEL - Monolith Burger Manager NEIL MATZ - The Pickle MAX DEARDORFF - The Lettuce BILL HILTON - The PermaBuns VANA BAKER - The Mayonnaise BILL SHOCKLEY - The Ketchup"
			)
			(11
				(if (== local4 5)
					(= gQuit 1)
				else
					(if (>= (++ local4) 1)
						(gTheIconBar enable:)
						(HandsOff)
					)
					(= cycles 1)
				)
			)
			(12
				(= start 4)
				(self init:)
			)
		)
	)
)

(instance p1 of Sq4Prop
	(properties
		x 155
		y 81
		view 24
		cycleSpeed 4
	)
)

(instance p2 of Sq4Prop
	(properties
		x 214
		y 86
		view 24
		loop 1
		cel 2
		cycleSpeed 3
	)
)

(instance p3 of Sq4Prop
	(properties
		x 85
		y 146
		view 24
		loop 2
		cel 2
		cycleSpeed 3
	)
)

(instance tCredits of Sq4Narrator
	(properties
		noun 97
		modeless 1
		talkerNum 97
		nMsgType 1
	)

	(method (display param1 &tmp temp0)
		(= temp0 (localproc_0 param1))
		(= ticks (Max 240 (/ ticks 2)))
		(Display param1 dsCOLOR global131 dsCOORD 3 temp0 dsWIDTH 315 dsFONT 0 dsALIGN alCENTER)
	)

	(method (dispose)
		(= returnVal 0)
		(gCurRoom drawPic: 803 13)
		(super dispose: &rest)
	)
)

