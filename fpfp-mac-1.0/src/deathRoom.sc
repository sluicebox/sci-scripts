;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use DCIcon)
(use Motion)
(use System)

(public
	deathRoom 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance deathRoom of FPRoom
	(properties
		picture 780
		style 10
	)

	(method (init)
		(gGame setCursor: 999 1)
		(super init:)
		(self setScript: sDie)
	)
)

(instance sDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic1 fade:)
				(gGameMusic2 fade:)
				(= cycles 10)
			)
			(1
				(gGame handsOff:)
				(gTheIconBar disable: 4 8)
				(proc0_9 0)
				(= local0 (+ global122 1))
				(gMessager say: 3 0 local0 0 self)
			)
			(2
				(= local6 909)
				(gGame setCursor: 999 1)
				(switch local0
					(1
						(= local3 35)
						(= local4 150)
						(= local5 112)
						(= local1 900)
						(= local2 0)
					)
					(2
						(= local3 12)
						(= local4 65)
						(= local5 89)
						(= local1 900)
						(= local2 0)
					)
					(3
						(= local3 12)
						(= local4 143)
						(= local5 80)
						(= local1 900)
						(= local2 1)
					)
					(4
						(= local3 36)
						(= local4 146)
						(= local5 90)
						(= local1 900)
						(= local2 1)
					)
					(5
						(= local3 24)
						(= local4 112)
						(= local5 123)
						(= local1 901)
						(= local2 0)
						(= local6 902)
					)
					(6
						(= local3 12)
						(= local4 128)
						(= local5 113)
						(= local1 901)
						(= local2 1)
					)
					(7
						(= local3 12)
						(= local4 95)
						(= local5 100)
						(= local1 902)
						(= local2 0)
						(= local6 906)
					)
					(8
						(= local3 30)
						(= local4 70)
						(= local5 66)
						(= local1 902)
						(= local2 1)
					)
					(9
						(= local3 24)
						(= local4 140)
						(= local5 65)
						(= local1 903)
						(= local2 0)
					)
					(10
						(= local3 35)
						(= local4 90)
						(= local5 60)
						(= local1 903)
						(= local2 1)
					)
					(11
						(= local3 12)
						(= local4 95)
						(= local5 105)
						(= local1 904)
						(= local2 0)
					)
					(12
						(= local3 36)
						(= local4 145)
						(= local5 125)
						(= local1 904)
						(= local2 0)
					)
					(13
						(= local3 24)
						(= local4 135)
						(= local5 93)
						(= local1 904)
						(= local2 1)
						(= local6 904)
					)
					(14
						(= local3 24)
						(= local4 145)
						(= local5 90)
						(= local1 905)
						(= local2 0)
					)
					(15
						(= local3 12)
						(= local4 110)
						(= local5 110)
						(= local1 905)
						(= local2 1)
					)
					(16
						(= local3 24)
						(= local4 105)
						(= local5 80)
						(= local1 906)
						(= local2 0)
						(= local6 905)
					)
					(17
						(= local3 12)
						(= local4 125)
						(= local5 88)
						(= local1 180)
						(= local2 0)
						(= local6 907)
					)
					(18
						(= local3 12)
						(= local4 125)
						(= local5 110)
						(= local1 180)
						(= local2 1)
					)
					(19
						(= local3 12)
						(= local4 130)
						(= local5 85)
						(= local1 180)
						(= local2 2)
						(= local6 906)
					)
					(20
						(= local3 24)
						(= local4 143)
						(= local5 100)
						(= local1 900)
						(= local2 0)
					)
					(21
						(= local3 24)
						(= local4 140)
						(= local5 115)
						(= local1 180)
						(= local2 3)
					)
					(22
						(= local3 24)
						(= local4 130)
						(= local5 113)
						(= local1 180)
						(= local2 4)
						(= local6 905)
					)
				)
				(theIcon1 view: local1 loop: local2 setSize:)
				(repeat
					(deathMusic number: local6 play:)
					(theIcon1 cel: 0)
					(= global134 20)
					(gSystemWindow color: 0 back: 20)
					(switch
						(Print
							font: gUserFont
							addText: 1 0 0 local0 0 0
							addIcon: (theIcon1 yourself:) 0 0 0 local3
							addButton: 1 2 0 0 1 local4 (- local5 40) 99 ; "Restore"
							addButton: 2 2 0 0 2 local4 (- local5 20) 99 ; "Restart"
							addButton: 3 2 0 0 3 local4 local5 99 ; "Quit"
							init:
						)
						(1
							(= global134 34)
							(gSystemWindow color: 0 back: 34)
							(deathMusic stop:)
							(gGame restore:)
						)
						(2
							(= global134 34)
							(gSystemWindow color: 0 back: 34)
							(deathMusic stop:)
							(gGame restart:)
						)
						(3
							(if (== gPrevRoomNum 28) ; speedRoom
								(if (== global122 21)
									(= global122 1)
								else
									(++ global122)
								)
								(theIcon1 cel: 0)
								(deathMusic fade:)
								(= global134 34)
								(gSystemWindow color: 0 back: 34)
								(gCurRoom init:)
							else
								(deathMusic stop:)
								(= gQuit 1)
							)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance theIcon1 of DCIcon
	(properties
		view 900
		cycleSpeed 15
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance deathMusic of FPSound
	(properties
		flags 1
	)
)

