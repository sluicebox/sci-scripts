;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use WButton)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	security 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance security of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(if (>= global534 2)
				(Palette palUNSET_FLAG 8 16 1)
				(Palette palUNSET_FLAG 144 255 1)
			)
			(proc0_17 1)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 2)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
				(computerScript cue:)
			)
			(= global413 0)
			(background view: (if (== (global302 livesAt:) 2) 702 else 698))
			(self add: background exitButton)
			(if (== (global302 livesAt:) 2)
				(self add: relaxButton)
				(if ((global302 durables:) objectAtIndexQuan: 24)
					(self add: theColorTV)
				)
				(if ((global302 durables:) objectAtIndexQuan: 26)
					(self add: theStereo)
				)
				(if ((global302 durables:) objectAtIndexQuan: 31)
					(self add: theBooks)
				)
				(if ((global302 durables:) objectAtIndexQuan: 25)
					(self add: theVCR)
				)
			)
			(self
				window: global59
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 15
			)
			(gASong playBed: 34)
			(proc0_9 self keyMouseList exitButton)
			(KeyMouse setList: keyMouseList)
			(User canControl: 1)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(gASong fade:)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(keyMouseList release:)
		(keyMouseList dispose:)
		(= global502 prevDialog)
		(proc0_15 self 291)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 202)
	)
)

(instance background of DIcon
	(properties)
)

(instance relaxButton of ErasableDIcon
	(properties
		state 65
		nsTop 108
		nsLeft 9
		key 1
		view 250
		loop 3
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 global323)
		(= temp0 (super doit:))
		(gTimeKeep doit: 6)
		(if (== temp1 60)
			(proc104_1 202 0)
		else
			(if (not global465)
				(proc0_13 2)
			)
			(= global465 1)
			(global302 relax: (+ (global302 relax:) 3))
			(if (> (global302 relax:) 50)
				(global302 relax: 50)
			)
		)
		(return temp0)
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 99
		nsTop 108
		nsLeft 143
		key 120
		view 250
	)
)

(instance theColorTV of DIcon
	(properties
		nsTop 34
		nsLeft 137
		view 702
		cel 1
	)
)

(instance theStereo of DIcon
	(properties
		nsTop 43
		nsLeft 121
		view 702
		loop 1
		cel 4
	)
)

(instance theBooks of DIcon
	(properties
		nsTop 15
		nsLeft 120
		view 702
		cel 3
		priority 13
	)
)

(instance theVCR of DIcon
	(properties
		nsTop 64
		nsLeft 137
		view 702
		cel 2
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(switch state
				(2
					(if (and (< global323 60) (proc0_6 6) global408)
						(= cycles 60)
						(event message: (relaxButton key:))
						(if (-- global408)
							(-- state)
						)
					)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

