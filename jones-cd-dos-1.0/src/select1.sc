;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 233)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	select1 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance select1 of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0 temp1)
		(SetMenu 258 112 0)
		(SetMenu 257 112 0)
		(if (= temp1 (DeviceInfo 5)) ; SaveDevice
			(Format @global603 233 0 temp1) ; "%c:"
			(StrCpy gLocales @global603)
		else
			(StrCpy gLocales {c:\5c})
		)
		(= global531 0)
		(proc0_17 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(= global413 0)
		(proc0_7)
		(= client 0)
		(self
			window: global38
			add: playGame restoreGame demonstration
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 -1 0 0 0 0 1
		)
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList playGame)
		(User canControl: 1)
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
		(keyMouseList release: dispose:)
		(= global502 prevDialog)
		(self dispose:)
		temp0
		(DisposeScript 233)
	)
)

(instance playGame of ErasableDIcon
	(properties
		state 163
		nsTop 17
		nsLeft 27
		view 10
		loop 1
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global531 1)
		(return temp0)
	)
)

(instance restoreGame of ErasableDIcon
	(properties
		state 163
		nsTop 47
		nsLeft 27
		view 10
		loop 1
		cel 2
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global529 1)
		(= global533 1)
		(SetMenu 258 112 1)
		(SetMenu 257 112 1)
		(return temp0)
	)
)

(instance demonstration of ErasableDIcon
	(properties
		state 163
		nsTop 77
		nsLeft 27
		view 10
		loop 1
		cel 1
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(SetMenu 258 112 1)
		(SetMenu 257 112 1)
		(((ScriptID 1 2) at: 0) playing: 29) ; players
		(= global527 1)
		(return temp0)
	)
)

