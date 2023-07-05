;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 239)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	select1b 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 global374) ((++ temp0))
		(((ScriptID 1 2) at: temp0) playing: 1) ; players
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance select1b of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0)
		(proc0_17 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(= global413 0)
		(proc0_7)
		(= client 0)
		(self
			window: global59
			add: number1 number2 number3 number4
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 15 0 0 0 0 1
		)
		(Display 239 0 dsFONT 0 dsCOORD 33 20 dsCOLOR 0 dsBACKGROUND -1) ; "How Many Players?"
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList number1)
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
		(DisposeScript 239)
	)
)

(instance number1 of ErasableDIcon
	(properties
		state 35
		nsTop 55
		nsLeft 20
		loop 3
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global374 1)
		(localproc_0)
		(return temp0)
	)
)

(instance number2 of ErasableDIcon
	(properties
		state 35
		nsTop 55
		nsLeft 60
		loop 3
		cel 1
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global374 2)
		(localproc_0)
		(return temp0)
	)
)

(instance number3 of ErasableDIcon
	(properties
		state 35
		nsTop 55
		nsLeft 100
		loop 3
		cel 2
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global374 3)
		(localproc_0)
		(return temp0)
	)
)

(instance number4 of ErasableDIcon
	(properties
		state 35
		nsTop 55
		nsLeft 140
		loop 3
		cel 3
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global374 4)
		(localproc_0)
		(return temp0)
	)
)

