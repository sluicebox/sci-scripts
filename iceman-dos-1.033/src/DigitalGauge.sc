;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 816)
(include sci.sh)
(use Main)
(use n827)
(use System)

(class DigitalGauge of Code
	(properties
		theObj 0
		selector 0
		lastSelectorValue 0
		x 0
		y 0
		underBits 0
		port 0
	)

	(method (init param1 param2 &tmp [temp0 5] temp5)
		(if (>= argc 1)
			(= theObj param1)
			(if (>= argc 2)
				(= selector param2)
			)
		)
		(= temp5 (if (< global140 10) 15 else 12))
		(= port (GetPort))
		(= underBits
			(Display
				(Format @temp0 816 0 (proc827_0 theObj selector)) ; "%d"
				dsCOORD
				x
				y
				dsCOLOR
				temp5
				dsALIGN
				alRIGHT
				dsWIDTH
				25
				dsFONT
				100
				dsSAVEPIXELS
			)
		)
	)

	(method (doit &tmp [temp0 5] temp5 temp6 temp7)
		(if (!= lastSelectorValue (= temp5 (proc827_0 theObj selector)))
			(= temp6 (GetPort))
			(SetPort port)
			(Display 816 1 dsRESTOREPIXELS underBits)
			(= temp7 (if (< global140 10) 15 else 12))
			(= underBits
				(Display
					(Format @temp0 816 0 temp5) ; "%d"
					dsCOORD
					x
					y
					dsCOLOR
					temp7
					dsALIGN
					alRIGHT
					dsWIDTH
					25
					dsFONT
					100
					dsSAVEPIXELS
				)
			)
			(SetPort temp6)
			(= lastSelectorValue temp5)
		)
		(super doit:)
	)

	(method (dispose)
		(Display 816 1 dsRESTOREPIXELS underBits)
		(super dispose:)
	)
)

