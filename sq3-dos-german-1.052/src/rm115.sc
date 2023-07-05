;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use FileSelector)
(use Timer)
(use Game)
(use Actor)
(use System)

(public
	rm115 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm115 of Rm
	(properties
		picture 115
		style 0
	)

	(method (init)
		(HandsOff)
		(Load rsVIEW 801)
		(Load rsSOUND 93)
		(super init:)
		(self setScript: startShip)
	)
)

(instance startShip of Script
	(properties)

	(method (doit)
		(if (and (== (self state:) 1) (== (gLongSong prevSignal:) 20))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0
					(Display
						{You cut the engines to sub-lightspeed as\nyou near a seemingly habitable planet.}
						dsWIDTH
						250
						dsCOORD
						35
						(LangSwitch 140 140 115 115)
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						14
						dsSAVEPIXELS
					)
				)
				(Timer setReal: self 7)
			)
			(1)
			(2
				(Display 115 0 dsRESTOREPIXELS local0)
				(Timer setReal: self 2)
			)
			(3
				(spaceShip init:)
			)
			(4
				(Timer setReal: self 2)
			)
			(5
				(gCurRoom newRoom: 116)
			)
		)
	)
)

(instance spaceShip of Prop
	(properties
		view 52
		priority 13
	)

	(method (init)
		(super init:)
		(= local1 120)
		(= local2 6)
		(= local3 90)
		(= local4 5)
	)

	(method (doit)
		(super doit:)
		(if (< local1 local2)
			(self dispose:)
			(startShip cue:)
		else
			(-= local1 local2)
			(= local3 (mod (+ local3 local4 360) 360))
			(self
				posn:
					(+ 190 (CosMult local3 local1))
					(+ 50 (SinMult local3 local1))
			)
			(if (and (< local1 100) (< cel (self lastCel:)))
				(++ cel)
			)
			(self stopUpd:)
		)
	)
)

