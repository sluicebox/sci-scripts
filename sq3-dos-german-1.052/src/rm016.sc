;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm016 0
)

(procedure (localproc_0 param1 param2 param3 param4)
	(SaveSubLang)
	(if (< global598 16)
		(= param4 15)
	)
	(Display param1 dsWIDTH 310 dsCOORD param2 param3 dsFONT 600 dsCOLOR param4 dsALIGN alCENTER)
	(RestoreSubLang)
)

(procedure (localproc_1 param1 param2 param3 param4)
	(SaveSubLang)
	(if (< global598 16)
		(= param4 15)
	)
	(Display param1 dsCOORD param2 param3 dsFONT 600 dsCOLOR param4)
	(RestoreSubLang)
)

(instance rm016 of Rm
	(properties
		picture 161
		style 0
	)

	(method (init &tmp [temp0 50])
		(self setRegions: 701) ; travrg
		(HandsOff)
		(= global159 1)
		(TheMenuBar hide:)
		(SL disable:)
		(Load rsVIEW 40)
		(Load rsVIEW 42)
		(Load rsPIC 161)
		(Load rsPIC (LangSwitch 162 314))
		(Load rsPIC (LangSwitch 163 315))
		(Load rsPIC (LangSwitch 164 316))
		(super init:)
		(if (and ((gInventory at: 3) ownedBy: 14) ((gInventory at: 1) ownedBy: 14)) ; Reactor, Wire
			(= global136 4)
			(self setScript: ReactorIn)
		else
			(= global136 1)
			(self setScript: ReactorNotIn)
		)
		(= global193 1)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (event type:)
			(= global159 0)
			(event claimed: 1)
			(= global193 0)
			(gCurRoom newRoom: 14)
		)
	)
)

(instance ReactorNotIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 {ACCESS DENIED} 1 25 4)
				(localproc_0 {-----------} 1 31 2)
				(localproc_0
					{>> POWER CRITICALLY LOW <<\n\n_AUX. REACTOR NOT ON-LINE}
					1
					55
					12
				)
				(localproc_0
					{INSUFFICIENT POWER TO COMMENCE\n____WITH SYSTEMS CHECK}
					1
					85
					12
				)
				(localproc_0
					{USING STORED POWER\n___BELOW 10}
					1
					155
					14
				)
				(= seconds 5)
			)
			(1
				(= global159 0)
				(HandsOn)
				(= global193 0)
				(gCurRoom newRoom: 14)
			)
		)
	)
)

(instance ReactorIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 {SYSTEMS CHECK} 1 25 15)
				(localproc_0 {IN PROGRESS} 1 35 15)
				(localproc_0
					{>> POWER LEVEL NOMINAL <<\n\n___AUX. REACTOR ON-LINE}
					1
					55
					10
				)
				(= seconds 5)
			)
			(1
				(gCurRoom drawPic: (LangSwitch 164 316))
				(localproc_1 {AUXILIARY REACTOR:} 100 162 14)
				(diagFlash1 loop: 4 cel: 0 posn: 151 114 init: setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(localproc_1 {AUXILIARY REACTOR:} 100 162 2)
				(localproc_1 {NOMINAL} 212 162 10)
				(= seconds 3)
			)
			(3
				(gCurRoom drawPic: (LangSwitch 162 314))
				(diagFlash1 loop: 1 cel: 0 posn: 107 119 init: setCycle: Fwd)
				(diagFlash2 loop: 0 cel: 0 posn: 182 137 init: setCycle: Fwd)
				(localproc_1 {LANDING GEAR} 100 162 14)
				(= seconds 3)
			)
			(4
				(localproc_1 {LANDING GEAR} 100 162 2)
				(localproc_1 {NOMINAL} 212 162 10)
				(= seconds 3)
			)
			(5
				(diagFlash1 hide:)
				(diagFlash2 hide:)
				(if (== global135 4)
					(gCurRoom setScript: MotivIn)
				else
					(gCurRoom setScript: MotivNotIn)
				)
			)
		)
	)
)

(instance MotivIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: (LangSwitch 163 315))
				(diagArea loop: 2 posn: 239 108 setPri: 7 stopUpd:)
				(localproc_1 {WARP MOTIVATOR:} 89 150 14)
				(diagArea init: stopUpd:)
				(diagFlash1
					setLoop: 3
					cel: 0
					posn: 233 99
					setPri: 15
					show:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(1
				(localproc_1 {WARP MOTIVATOR } 89 150 2)
				(localproc_1 {NOMINAL} 100 162 10)
				(= seconds 4)
			)
			(2
				(= global159 0)
				(Print 16 0) ; "Looks like this bird's in good shape."
				(HandsOn)
				(= global193 0)
				(gCurRoom newRoom: 14)
			)
		)
	)
)

(instance MotivNotIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: (LangSwitch 163 315))
				(diagArea loop: 2 posn: 239 108 setPri: 7 stopUpd:)
				(= cycles 2)
			)
			(1
				(localproc_1 {WARP MOTIVATOR:} 89 150 14)
				(diagArea init: stopUpd:)
				(diagFlash1
					setLoop: 3
					cel: 0
					posn: 233 99
					setPri: 15
					show:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(2
				(diagEnlarge posn: 233 93 setLoop: 0 cel: 0 init:)
				(= seconds 1)
			)
			(3
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
					init:
					setCycle: 0
				)
				(diagEnlarge cel: (+ (diagEnlarge cel:) 1) posn: 218 102)
				(= cycles 3)
			)
			(4
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
				)
				(diagEnlarge cel: (+ (diagEnlarge cel:) 1) posn: 200 110)
				(= cycles 3)
			)
			(5
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
				)
				(diagEnlarge cel: (+ (diagEnlarge cel:) 1) posn: 172 119)
				(= cycles 3)
			)
			(6
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
				)
				(diagEnlarge cel: (+ (diagEnlarge cel:) 1) posn: 142 130)
				(= cycles 3)
			)
			(7
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
				)
				(diagEnlarge cel: (+ (diagEnlarge cel:) 1) posn: 101 145)
				(= cycles 3)
			)
			(8
				(diagFlash2
					posn: (diagEnlarge xLast:) (diagEnlarge yLast:)
					loop: 0
					cel: (diagEnlarge cel:)
				)
				(diagEnlarge
					setLoop: 1
					cel: 0
					posn: 47 184
					cycleSpeed: 2
					setCycle: Fwd
				)
				(= global186 1)
				(= cycles 3)
			)
			(9
				(diagFlash2 hide:)
				(= seconds 2)
			)
			(10
				(localproc_1 {WARP MOTIVATOR } 89 150 4)
				(localproc_1 {MALFUNCTION} 100 162 12)
				(localproc_1
					{UNIT NOT INSTALLED}
					89
					173
					14
				)
				(= seconds 7)
			)
			(11
				(= global159 0)
				(HandsOn)
				(= global193 0)
				(gCurRoom newRoom: 14)
			)
		)
	)
)

(instance diagFlash1 of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 40 ignoreActors: 1)
	)
)

(instance diagFlash2 of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 40 ignoreActors: 1)
	)
)

(instance diagArea of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 40 ignoreActors: 1)
	)
)

(instance diagEnlarge of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 42 ignoreActors: 1)
	)
)

