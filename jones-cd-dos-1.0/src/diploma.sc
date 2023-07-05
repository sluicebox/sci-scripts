;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use Motion)
(use User)
(use System)

(public
	diploma 0
)

(local
	local0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance diploma of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 param2 &tmp temp0 temp1)
		(= global568 1)
		(if (not global518)
			(proc0_7)
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= local0 param2)
			(= client param1)
			(= prevDialog global502)
			(= global502 self)
			(= prevTalker global413)
			(= global413 0)
			(self window: global38 add: background theDiploma doneButton)
			(if (== (global302 playing:) 29)
				(self setScript: compScript)
			)
			(self
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: (client nsLeft:) (client nsTop:)
				open: 0 -1
			)
			(= temp1 (KeyMouse curItem:))
			(proc0_9 self keyMouseList doneButton)
			(KeyMouse setList: keyMouseList)
			(gASong loop: 1 play: 42 compScript)
			(if global534
				(theDiploma cel: 4 draw: cue:)
			)
			(User canControl: 1)
		else
			(KeyMouse setCursor: theItem)
		)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(KeyMouse curItem: temp1)
		(if global447
			(KeyMouse setCursor: temp1)
		)
		(keyMouseList release: dispose:)
		(= global413 prevTalker)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(SetPort 0)
		(proc0_17 0)
		(proc0_8)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(= global568 0)
		temp0
		(DisposeScript 230)
	)
)

(instance background of DIcon
	(properties
		view 607
		loop 1
		priority 10
	)
)

(instance doneButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
		loop 2
	)
)

(instance theDiploma of DCIcon
	(properties
		nsTop 15
		nsLeft 22
		view 607
		priority 15
		cycleSpeed 1
	)

	(method (draw)
		(if (or (not global534) (== cel 4))
			(super draw: &rest)
		)
	)

	(method (init)
		(if (not global534)
			(self setCycle: End self)
		)
	)

	(method (cue &tmp [temp0 5])
		(global502 add: diplomaText)
		(diplomaText draw:)
	)
)

(instance diplomaText of DText
	(properties)

	(method (draw &tmp [temp0 4] [temp4 50])
		(self setPort:)
		(= text (Format @temp4 230 0 700 local0)) ; "%s"
		(TextSize @[temp0 0] text 8 0)
		(Display
			text
			dsCOORD
			(- 97 (/ [temp0 3] 2))
			(- 77 (/ [temp0 2] 2))
			dsCOLOR
			0
			dsWIDTH
			150
			dsBACKGROUND
			-1
			dsFONT
			8
		)
		(self resetPort:)
	)
)

(instance compScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(switch state
				(2
					(= cycles 60)
				)
				(3
					(event message: KEY_x)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

