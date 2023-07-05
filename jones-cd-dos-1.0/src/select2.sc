;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use System)

(public
	select2 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance select2 of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0)
		(proc0_17 0)
		(SetMenu 258 112 1)
		(SetMenu 257 112 1)
		(Palette palUNSET_FLAG 8 16 1)
		(Palette palUNSET_FLAG 144 255 1)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(= global413 (= client (= global507 0)))
		(proc0_7)
		(self
			window: global38
			add:
				background
				playerNumber
				firstPlayer
				secondPlayer
				thirdPlayer
				fourthPlayer
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 -1 0 0 0 0 1
		)
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList firstPlayer)
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
		(keyMouseList release:)
		(= global502 prevDialog)
		(keyMouseList dispose:)
		(self dispose:)
		temp0
		(DisposeScript 235)
	)

	(method (draw &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if
				(or
					(not ((self at: temp0) isKindOf: ErasableDIcon))
					(& ((self at: temp0) state:) $0001)
				)
				((self at: temp0) draw:)
			)
		)
	)
)

(instance background of DIcon
	(properties
		view 500
		priority 12
	)
)

(instance playerNumber of DIcon
	(properties
		nsTop 1
		nsLeft 42
		view 499
		loop 1
		priority 13
	)

	(method (init)
		(super init: &rest)
		(if (not global535)
			(= nsLeft 43)
		)
	)
)

(instance firstPlayer of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 6
		view 250
		loop 7
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(proc0_15 select2 294)
		((ScriptID 236 0) init: 0 0) ; select3
		(global502 draw:)
		(select2 advance:)
		(KeyMouse advance:)
		(((ScriptID 1 2) at: global507) whichBody: 0) ; players
		(++ global507)
		(self erase: enable: 0)
		(select2 add: firstDim)
		(firstDim init: 1 setSize: draw:)
		(if (== global507 global374)
			(= state 2)
		else
			(playerNumber cel: global507 draw:)
		)
		(dialogKeyMouse delete: self)
		(return temp0)
	)
)

(instance secondPlayer of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 52
		view 250
		loop 7
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(proc0_15 select2 294)
		((ScriptID 236 0) init: 0 0) ; select3
		(global502 draw:)
		(select2 advance:)
		(KeyMouse advance:)
		(((ScriptID 1 2) at: global507) whichBody: 1) ; players
		(++ global507)
		(self erase: enable: 0)
		(select2 add: secondDim)
		(secondDim init: 1 setSize: draw:)
		(if (== global507 global374)
			(= state 2)
		else
			(playerNumber cel: global507 draw:)
		)
		(dialogKeyMouse delete: self)
		(return temp0)
	)
)

(instance thirdPlayer of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 98
		view 250
		loop 7
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(proc0_15 select2 294)
		((ScriptID 236 0) init: 0 0) ; select3
		(global502 draw:)
		(select2 advance:)
		(KeyMouse advance:)
		(((ScriptID 1 2) at: global507) whichBody: 2) ; players
		(++ global507)
		(self erase: enable: 0)
		(select2 add: thirdDim)
		(thirdDim init: 1 setSize:)
		(thirdDim draw:)
		(if (== global507 global374)
			(= state 2)
		else
			(playerNumber cel: global507 draw:)
		)
		(dialogKeyMouse delete: self)
		(return temp0)
	)
)

(instance fourthPlayer of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 144
		view 250
		loop 7
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(proc0_15 select2 294)
		((ScriptID 236 0) init: 0 0) ; select3
		(global502 draw:)
		(select2 advance:)
		(KeyMouse advance:)
		(((ScriptID 1 2) at: global507) whichBody: 3) ; players
		(++ global507)
		(self erase: enable: 0)
		(select2 add: fourthDim)
		(fourthDim init: 1 setSize: draw:)
		(if (== global507 global374)
			(= state 2)
		else
			(playerNumber cel: global507 draw:)
		)
		(dialogKeyMouse delete: self)
		(return temp0)
	)
)

(instance firstDim of DIcon
	(properties
		nsTop 14
		nsLeft 1
		view 499
		priority 14
	)
)

(instance secondDim of DIcon
	(properties
		nsTop 14
		nsLeft 47
		view 499
		cel 1
		priority 14
	)
)

(instance thirdDim of DIcon
	(properties
		nsTop 14
		nsLeft 93
		view 499
		cel 2
		priority 14
	)
)

(instance fourthDim of DIcon
	(properties
		nsTop 14
		nsLeft 139
		view 499
		cel 3
		priority 14
	)
)

