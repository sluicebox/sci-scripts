;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4081)
(include sci.sh)
(use Main)
(use n63002)
(use WynIniFile)
(use PolyEdit)
(use Cycle)
(use Jump)
(use Menu)
(use System)

(public
	curtisCubicleRoomCH1SR8 0
)

(instance curtisCubicleRoomCH1SR8 of WynDocuStore
	(properties
		exitRoom 4021
		postalWareRm 4061
	)

	(method (init)
		(super init: &rest)
		(= curFolder (gWynNet findItem: 6301 21 0 70 1))
		(self refresh:)
		(thePuzzle init:)
		(theWindow init:)
		(gGame handsOn: 1)
	)

	(method (handleEvent)
		(gGame handsOff:)
		(gCurRoom newRoom: 4051) ; curtisCubicleRoomCH1SR5
	)

	(method (slideDoors)
		(return 0)
	)
)

(class Letters of Prop
	(properties
		y 168
		view 3031
		selBG 0
	)

	(method (init)
		(|= signal $1000)
		(super init: gThePlane)
		(= cycleSpeed (Random 40 60))
		(self setCel: (Random 0 4) setCycle: RandCycle setPri: 2001)
	)

	(method (setRect)
		(super setRect: (- x 16) (- y 10) (+ x 16) (+ y 10))
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(self reverse:)
			(self setCycle: (if (> loop 7) 0 else RandCycle))
			(if selBG
				(selBG dispose:)
				(= selBG 0)
			)
			(if (not cycler)
				((= selBG (View new:))
					view: 3031
					loop: 7
					cel: 0
					init: plane
					posn: (- x 17) (- y 11)
					setPri: 2000
				)
			)
			(= cycleSpeed (Random 40 60))
			(Send new: thePuzzle 9)
		)
	)

	(method (locked)
		(return (not cycler))
	)

	(method (atRightLetter)
		(return (not cel))
	)

	(method (dispBG)
		(if selBG
			(selBG dispose:)
			(= selBG 0)
		)
	)

	(method (reverse)
		(self
			setLoop:
				(if (> loop 7)
					(- loop 8)
				else
					(+ loop 8)
				)
		)
		(self update:)
	)
)

(instance thePuzzle of Set
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		((= temp0 (Letters new:)) x: 225 loop: 0 init:)
		((= temp1 (Letters new:)) x: 263 loop: 1 init:)
		((= temp2 (Letters new:)) x: 302 loop: 2 init:)
		((= temp3 (Letters new:)) x: 340 loop: 3 init:)
		((= temp4 (Letters new:)) x: 379 loop: 4 init:)
		((= temp5 (Letters new:)) x: 417 loop: 5 init:)
		(self add: temp0 temp1 temp2 temp3 temp4 temp5)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (self allTrue: #locked)
			(if (not (self allTrue: #atRightLetter))
				(FrameOut)
				(if (Random 0 4)
					(proc63002_11 6301 16 0 60 1)
				else
					(proc63002_11 6301 16 0 59 1)
				)
			else
				(self eachElementDo: #dispBG)
				(for ((= temp0 1)) (<= temp0 6) ((++ temp0))
					(theWindow setCel: (mod temp0 2) update:)
					(FrameOut)
					(for ((= temp1 0)) (< temp1 30) ((++ temp1))
						(= temp2 (GetTime))
						(while (== temp2 (GetTime))
						)
					)
					(self eachElementDo: #reverse)
				)
				(SetFlag 55)
				(SetFlag 114)
				(self dispose:)
				(gGame handsOff:)
				(proc63002_8)
				(gCurRoom newRoom: 4051) ; curtisCubicleRoomCH1SR5
			)
		)
	)

	(method (dispose)
		(self release:)
		(super dispose:)
	)
)

(instance theWindow of View
	(properties
		x 174
		y 210
		view 3031
		loop 6
	)

	(method (init)
		(super init: gThePlane)
		(self setPri: 1999)
	)
)

