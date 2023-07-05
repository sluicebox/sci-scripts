;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	rm98 0
)

(local
	local0
)

(instance rm98 of Rm
	(properties
		picture 121
		style 5
	)

	(method (init)
		(HandsOff)
		(Load rsVIEW 54)
		(Load rsPIC 201)
		(Load rsPIC 202)
		(Load rsPIC 203)
		(Load rsPIC 204)
		(Load rsPIC 205)
		(Load rsPIC 206)
		(Load rsPIC 207)
		(Load rsSOUND 93)
		(spaceShip init:)
		(super init:)
		(self setScript: startShip)
	)
)

(instance startShip of Script
	(properties)

	(method (doit)
		(if (and (== (self state:) 3) (== (gLongSong prevSignal:) 10))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0
					(Display
						{You enter a blackness like no other you\nhave ever experienced. All sense of time\nand speed are lost.}
						dsWIDTH
						250
						dsCOORD
						35
						80
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(Timer setReal: self 10)
			)
			(1
				(Display 98 0 dsRESTOREPIXELS local0)
				(= local0
					(Display
						{Suddenly...}
						dsWIDTH
						250
						dsCOORD
						35
						95
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(Timer setReal: self 3)
			)
			(2
				(Display 98 0 dsRESTOREPIXELS local0)
				(= local0
					(Display
						{A bright light becomes visible in the\ndistance. It grows larger as your ship\nraces toward it. Finally you are hurled\nout of the blackness into a parallel universe.}
						dsWIDTH
						250
						dsCOORD
						35
						70
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(Timer setReal: self 10)
			)
			(3)
			(4
				(Display 98 0 dsRESTOREPIXELS local0)
				(spaceShip show:)
				(gCurRoom overlay: 201 5)
				(Timer setCycle: self 1)
			)
			(5
				(gCurRoom overlay: 202 5)
				(Timer setCycle: self 1)
			)
			(6
				(gCurRoom overlay: 203 5)
				(Timer setCycle: self 1)
			)
			(7
				(gCurRoom overlay: 204 5)
				(Timer setCycle: self 1)
			)
			(8
				(gCurRoom overlay: 205 5)
				(Timer setCycle: self 1)
			)
			(9
				(gCurRoom overlay: 206 5)
				(Timer setCycle: self 1)
			)
			(10
				(gCurRoom overlay: 207 5)
				(Timer setCycle: self 1)
			)
			(11
				(if (< (spaceShip cel:) (spaceShip lastCel:))
					(spaceShip
						setCel: (+ (spaceShip cel:) 1)
						posn: (spaceShip x:) (- (spaceShip y:) 2)
					)
					(-- state)
					(Timer setCycle: self 1)
				else
					(self cue:)
				)
			)
			(12
				(spaceShip hide:)
				(Timer setReal: self 2)
			)
			(13
				(gCurRoom newRoom: 115)
			)
		)
	)
)

(instance spaceShip of Prop
	(properties
		view 54
		priority 15
	)

	(method (init)
		(super init:)
		(self posn: 154 100 hide:)
	)
)

