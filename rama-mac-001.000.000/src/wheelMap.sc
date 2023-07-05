;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 356)
(include sci.sh)
(use Main)
(use AutoMapProp)

(public
	wheelMap 0
)

(instance wheelMap of AutoMapInset
	(properties
		picture 356
	)

	(method (positionAlterEgo param1)
		(switch gCurRoomNum
			(2010 ; wheelRgn1
				(param1 posn: 404 37)
			)
			(2011 ; wheelRgn2
				(param1 posn: 397 57)
			)
			(2012 ; wheelRgn3
				(param1 posn: 425 69)
			)
			(2013 ; wheelRgn4
				(param1 posn: 453 69)
			)
			(2014 ; wheelRgn5
				(param1 posn: 500 67)
			)
			(2015 ; wheelRgn6
				(param1 posn: 272 78)
			)
			(2016 ; wheelRgn7
				(param1 posn: 314 95)
			)
			(2017 ; wheelRgn8
				(param1 posn: 372 116)
			)
			(2018 ; wheelRgn9
				(param1 posn: 314 95)
			)
			(2020 ; wheelRgn11
				(param1 posn: 241 125)
			)
			(2021 ; wheelRgn12
				(param1 posn: 206 133)
			)
			(2022 ; wheelRgn13
				(param1 posn: 202 139)
			)
			(2023 ; wheelRgn14
				(param1 posn: 149 128)
			)
			(2024 ; wheelRgn15
				(param1 posn: 89 158)
			)
			(2025 ; wheelRgn16
				(param1 posn: 106 193)
			)
			(2026 ; wheelRgn17
				(param1 posn: 187 180)
			)
			(2027 ; wheelRgn18
				(param1 posn: 148 159)
			)
			(2028 ; wheelHubMonitor
				(param1 posn: 148 159)
			)
			(2029 ; trashBin
				(param1 posn: 453 79)
			)
			(2031 ; ruinCU
				(param1 posn: 272 78)
			)
			(2032 ; trayCU
				(param1 posn: 372 116)
			)
			(2033 ; valveCU
				(param1 posn: 372 116)
			)
			(2034 ; wheelRgn19
				(param1 posn: 156 155)
			)
			(2035 ; wheelRgn20
				(param1 posn: 147 151)
			)
			(2036 ; wheelRgn21
				(param1 posn: 138 158)
			)
			(2037 ; wheelRgn22
				(param1 posn: 141 165)
			)
			(2038 ; wheelRgn23
				(param1 posn: 155 163)
			)
			(2039 ; wheelHubLadder
				(param1 posn: 148 159)
			)
			(else
				(PrintDebug {No room defined for currentLocation})
				(param1 hide:)
			)
		)
	)
)

