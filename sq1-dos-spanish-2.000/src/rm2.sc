;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use DScript)
(use RandCycle)
(use DCIcon)
(use Sound)
(use Game)

(public
	rm2 0
)

(local
	[local0 3]
)

(procedure (localproc_0 param1 param2 param3 &tmp [temp0 303])
	(gGame setCursor: gNormalCursor 1)
	(switch
		(Print
			{Thank you for playing Space Quest I. As usual, you've been most entertaining.}
			67
			100
			60
			106
			81
			{Restore}
			1
			106
			81
			{Restart}
			2
			106
			81
			{Quit}
			3
			82
			param1
			param2
			param3
		)
		(1
			(gGame restore:)
			(Sound pause: 0)
		)
		(2
			(gGame restart:)
			(Sound pause: 0)
		)
		(3
			(= gQuit 1)
		)
		(else
			(Sound pause: 0)
		)
	)
	(gTheIconBar disable: hide:)
	(gGame setCursor: gWaitCursor 0)
)

(instance babbleIcon of DCIcon
	(properties)

	(method (init)
		((= cycler (RandCycle new:)) init: self 20)
	)
)

(instance rm2 of Rm
	(properties
		picture 2
		style -32759
	)

	(method (init)
		(babbleIcon view: 946 cycleSpeed: (* (+ gHowFast 1) 4))
		(Palette palSET_FROM_RESOURCE 999)
		(gTheIconBar disable:)
		(gLongSong flags: 0)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gGame setCursor: gWaitCursor 0)
		(self setScript: finalCredits)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(Sound pause: 1)
			(gTheIconBar disable:)
			(gGame setCursor: gNormalCursor 1 160 100)
			(localproc_0 0 2 0)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong flags: 1 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance finalCredits of DScript
	(properties)

	(method (init)
		(super init: &rest)
		(= clrByKey 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self
					save1:
						(Display
							{International Producer:\n\nSabine Duvall\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(1
				(self restore:)
				(= cycles 2)
			)
			(2
				(self
					save1:
						(Display
							{International Programming:\n\nGary Kamigawachi\nSean Mooney\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(3
				(self restore:)
				(= cycles 2)
			)
			(4
				(self
					save1:
						(Display
							{International Quality Assurance:\n\nGordon B. Owens\nRoger Pyle\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(5
				(self restore:)
				(= cycles 2)
			)
			(6
				(self
					save1:
						(Display
							{Spanish Translator:\n\nJose Ignacio Piquero De Lafuente\nErnesto F. Maquieira}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(7
				(self restore:)
				(= cycles 2)
			)
			(8
				(self
					save1:
						(Display
							{Animators:\n\nDouglas Herring\nVasken Nokhoudian\nNathan Larsen\nArturo Sinclair\nDeena Krutak\nDesie Hartman\nJerry Jessurun\nRussell Truelove\nDiana R. Wilson\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 15)
			)
			(9
				(self restore:)
				(= cycles 3)
			)
			(10
				(self
					save1:
						(Display
							{Background Artists:\n\nDouglas Herring\nNathan Larsen\nArturo Sinclair\nEric Kasner\nWillis Wong\nJay Allan Friedmann\nJennifer Shontz\nAndy Hoyos\nJane Cardinal\nMaurice F. Morgan\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 15)
			)
			(11
				(self restore:)
				(= cycles 3)
			)
			(12
				(self
					save1:
						(Display
							{Programmers:\n\nJerry Shaw\nRandy MacNeill\nDave Jamriska\nHugh Diedrichs\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(13
				(self restore:)
				(= cycles 2)
			)
			(14
				(self
					save1:
						(Display
							{Amiga Implentation:\n\nSteve Coallier\nJerry Shaw\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(15
				(self restore:)
				(= cycles 3)
			)
			(16
				(self
					save1:
						(Display
							{Amiga Quality Assurance:\n\nRobin Bradley\nMax DearDorff\n\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 12)
			)
			(17
				(self restore:)
				(= cycles 3)
			)
			(18
				(self
					save1:
						(Display
							{Music Director:\n\nMark Seibert\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 8)
			)
			(19
				(self restore:)
				(= cycles 3)
			)
			(20
				(self
					save1:
						(Display
							{System Development:\n\nChris Smith\nJeff Stephenson\nRobert E. Heitman\nPablo Ghenis\nDan Foy\nLarry Scott\nJ. Mark Hood\nMark Wilden\nEric Hart\nChad Bye\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 15)
			)
			(21
				(self restore:)
				(= cycles 3)
			)
			(22
				(self
					save1:
						(Display
							{Sound Effects:\n\nKen Allen\nMark Seibert\nOrpheus Hanley\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(23
				(self restore:)
				(= cycles 3)
			)
			(24
				(self
					save1:
						(Display
							{Additional Written Material:\n\nBridget McKenna\nGano Haine\nJerry Shaw\n}
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(25
				(self restore:)
				(= cycles 3)
			)
			(26
				(self
					save1:
						(Display
							{Space Quest 1 Theme Based on the\nOriginal Composition by Mark Crowe }
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(27
				(self restore:)
				(= cycles 3)
			)
			(28
				(self
					save1:
						(Display
							{Quality Assurance:\n\nSharon Simmons }
							dsALIGN
							alCENTER
							dsFONT
							4
							dsWIDTH
							200
							dsCOLOR
							global142
							dsCOORD
							60
							20
							dsSAVEPIXELS
						)
				)
				(= seconds 10)
			)
			(29
				(self restore:)
				(= cycles 3)
			)
			(30
				(gGame setCursor: gTheCursor (HaveMouse))
				(localproc_0 0 2 0)
			)
		)
	)
)

