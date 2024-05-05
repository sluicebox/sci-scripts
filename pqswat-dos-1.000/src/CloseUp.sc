;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use ExitButton)
(use Plane)
(use Str)
(use Print)
(use System)

(class CloseUp of Plane
	(properties
		picture 50
		robotNum 0
		robotX -1
		robotY -1
		caller 0
		fadePal 0
		robot 0
		restoreM1 0
		restoreM2 0
		musicNum 0
		music2Num 0
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3)
		(if (gBackMusic handle:)
			(= restoreM1 1)
			(= musicNum (gBackMusic number:))
		)
		(if (gBackMusic2 handle:)
			(= restoreM2 1)
			(= music2Num (gBackMusic2 number:))
		)
		(if argc
			(= robotNum [param1 0])
			(if (> argc 1)
				(= robotX [param1 1])
				(if (> argc 2)
					(= robotY [param1 2])
					(if (> argc 3)
						(= caller [param1 3])
						(if (> argc 4)
							(= fadePal [param1 4])
						)
					)
				)
			)
		)
		(if (== robotX -1)
			(= robotX 180)
		)
		(if (== robotY -1)
			(= robotY 66)
		)
		(self
			setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
			back: 0
			picture: 0
			priority: 1000
			posn: 0 0
		)
		(super init:)
		(while ((= temp1 (Event new:)) type:)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(= temp2 0)
		(repeat
			(if (or (ResCheck 151 [param1 0]) (ResCheck 151 [param1 0])) ; VMD, VMD
				(= temp2 1)
				(break)
			else
				(repeat
					(= temp3
						(Print
							font: 20071
							addText: {_____Unable to load file.____}
							addButton: 0 { Retry } 15 20
							addButton: 1 { Continue } 60 20
							init:
						)
					)
					(if (OneOf temp3 0 1)
						(break)
					)
				)
				(if (== temp3 1)
					(= temp2 0)
					(break)
				)
			)
		)
		(if temp2
			(= temp0 (Str format: {%d.vmd} [param1 0]))
			(PlayVMD 0 (temp0 data:) 1024) ; Open
			(PlayVMD 1 174 95) ; Put
			(PlayVMD 21 0 0 639 359) ; Black
			(PlayVMD 14 3 7) ; WaitEvent
			(PlayVMD 6) ; Close
			(temp0 dispose:)
		)
		(self dispose:)
	)

	(method (doit)
		(super doit:)
		(if robot
			(robot doit:)
		)
	)

	(method (cue)
		(self dispose:)
	)

	(method (dispose)
		(proc4_5)
		(if restoreM1
			(gBackMusic number: musicNum play:)
		)
		(if restoreM2
			(gBackMusic2 number: music2Num play:)
		)
		(if caller
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees add: ((Cue new:) cuee: caller yourself:))
			(= caller 0)
		)
		(if fadePal
			(Palette 2 42 254 0) ; PalIntensity
			(FrameOut)
		)
		(super dispose:)
	)
)

