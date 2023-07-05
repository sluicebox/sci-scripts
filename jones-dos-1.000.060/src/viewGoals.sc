;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 238)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use System)

(public
	viewGoals 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
	(= temp3 (param1 monStat:))
	(= temp4 (param1 hapStat:))
	(= temp5 (param1 eduStat:))
	(= temp6 (param1 carStat:))
	(= temp7 (param1 monGoal:))
	(= temp8 (param1 hapGoal:))
	(= temp9 (param1 eduGoal:))
	(= temp10 (param1 carGoal:))
	(if (> temp3 temp7)
		(= temp3 temp7)
	)
	(if (> temp4 temp8)
		(= temp4 temp8)
	)
	(if (> temp5 temp9)
		(= temp5 temp9)
	)
	(if (> temp6 temp10)
		(= temp6 temp10)
	)
	(= temp1 (+ temp3 temp4 temp5 temp6))
	(= temp2 (+ temp7 temp8 temp9 temp10))
	(if temp1
		(= temp0
			(+
				(* (/ (* temp1 50) temp2) 2)
				(/ (* (mod (* temp1 50) temp2) 2) temp2)
			)
		)
	else
		(= temp0 0)
	)
	(if (> temp0 100)
		(= temp0 100)
	)
	(return temp0)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance viewGoals of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0 temp1 temp2)
		(proc0_17 0)
		(= global509 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= temp2 global443)
		(= global443 1)
		(= prevTalker global413)
		(= global502 self)
		(= global413 (= client 0))
		(proc0_7)
		(self add: background therm1 fineTherm1 playerNumber1 percent1)
		(= local0 (localproc_0 ((ScriptID 1 2) at: 0))) ; players
		(therm1 cel: (/ local0 10))
		(fineTherm1 nsTop: (- 83 (* (therm1 cel:) 5)))
		(fineTherm1 cel: (/ (mod local0 10) 2))
		(percent1 value: local0)
		(if (> ((ScriptID 1 2) size:) 1) ; players
			(self add: therm2 fineTherm2 playerNumber2 percent2)
			(= local1 (localproc_0 ((ScriptID 1 2) at: 1))) ; players
			(therm2 cel: (/ local1 10))
			(fineTherm2 nsTop: (- 83 (* (therm2 cel:) 5)))
			(fineTherm2 cel: (/ (mod local1 10) 2))
			(percent2 value: local1)
		)
		(if (> ((ScriptID 1 2) size:) 2) ; players
			(self add: therm3 fineTherm3 playerNumber3 percent3)
			(= local2 (localproc_0 ((ScriptID 1 2) at: 2))) ; players
			(therm3 cel: (/ local2 10))
			(fineTherm3 nsTop: (- 83 (* (therm3 cel:) 5)))
			(fineTherm3 cel: (/ (mod local2 10) 2))
			(percent3 value: local2)
		)
		(if (> ((ScriptID 1 2) size:) 3) ; players
			(self add: therm4 fineTherm4 playerNumber4 percent4)
			(= local3 (localproc_0 ((ScriptID 1 2) at: 3))) ; players
			(therm4 cel: (/ local3 10))
			(fineTherm4 nsTop: (- 83 (* (therm4 cel:) 5)))
			(fineTherm4 cel: (/ (mod local3 10) 2))
			(percent4 value: local3)
		)
		(self add: exitButton)
		(switch ((ScriptID 1 2) size:) ; players
			(1
				(therm1 nsLeft: (+ (therm1 nsLeft:) 65))
				(fineTherm1 nsLeft: (+ (fineTherm1 nsLeft:) 65))
				(playerNumber1 nsLeft: (+ (playerNumber1 nsLeft:) 65))
				(percent1 nsLeft: (+ (percent1 nsLeft:) 65))
			)
			(2
				(therm1 nsLeft: (+ (therm1 nsLeft:) 42))
				(fineTherm1 nsLeft: (+ (fineTherm1 nsLeft:) 42))
				(playerNumber1 nsLeft: (+ (playerNumber1 nsLeft:) 42))
				(percent1 nsLeft: (+ (percent1 nsLeft:) 42))
				(therm2 nsLeft: (+ (therm2 nsLeft:) 42))
				(fineTherm2 nsLeft: (+ (fineTherm2 nsLeft:) 42))
				(playerNumber2 nsLeft: (+ (playerNumber2 nsLeft:) 42))
				(percent2 nsLeft: (+ (percent2 nsLeft:) 42))
				(if (((ScriptID 1 2) at: 1) playingAsJones:) ; players
					(playerNumber2 cel: 4)
				)
			)
			(3
				(therm1 nsLeft: (+ (therm1 nsLeft:) 20))
				(fineTherm1 nsLeft: (+ (fineTherm1 nsLeft:) 20))
				(playerNumber1 nsLeft: (+ (playerNumber1 nsLeft:) 20))
				(percent1 nsLeft: (+ (percent1 nsLeft:) 20))
				(therm2 nsLeft: (+ (therm2 nsLeft:) 20))
				(fineTherm2 nsLeft: (+ (fineTherm2 nsLeft:) 20))
				(playerNumber2 nsLeft: (+ (playerNumber2 nsLeft:) 20))
				(percent2 nsLeft: (+ (percent2 nsLeft:) 20))
				(therm3 nsLeft: (+ (therm3 nsLeft:) 20))
				(fineTherm3 nsLeft: (+ (fineTherm3 nsLeft:) 20))
				(playerNumber3 nsLeft: (+ (playerNumber3 nsLeft:) 20))
				(percent3 nsLeft: (+ (percent3 nsLeft:) 20))
			)
		)
		(self
			window: global59
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 15
		)
		(= temp1 (KeyMouse curItem:))
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList exitButton)
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
		(keyMouseList release:)
		(keyMouseList dispose:)
		(= global413 prevTalker)
		(= global502 prevDialog)
		(proc0_15 self 291)
		(self dispose:)
		(SetPort 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(= global509 1)
		(= global443 temp2)
		temp0
		(DisposeScript 238)
	)
)

(instance background of DIcon
	(properties
		view 505
		priority 13
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 99
		nsTop 108
		nsLeft 143
		view 250
		priority 15
	)
)

(instance playerNumber1 of ErasableDIcon
	(properties
		state 1
		nsTop 90
		nsLeft 18
		view 505
		loop 3
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= local4 global302)
		(= global302 ((ScriptID 1 2) at: 0)) ; players
		(proc0_15 viewGoals 291)
		(= temp0 ((ScriptID 236) init: client 2)) ; select3
		(viewGoals draw:)
		(= global302 local4)
		(return temp0)
	)
)

(instance playerNumber2 of ErasableDIcon
	(properties
		state 1
		nsTop 90
		nsLeft 62
		view 505
		loop 3
		cel 1
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= local4 global302)
		(= global302 ((ScriptID 1 2) at: 1)) ; players
		(proc0_15 viewGoals 291)
		((ScriptID 236) init: 0 2) ; select3
		(viewGoals draw:)
		(= global302 local4)
		(return temp0)
	)
)

(instance playerNumber3 of ErasableDIcon
	(properties
		state 1
		nsTop 90
		nsLeft 106
		view 505
		loop 3
		cel 2
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= local4 global302)
		(= global302 ((ScriptID 1 2) at: 2)) ; players
		(proc0_15 viewGoals 291)
		((ScriptID 236) init: 0 2) ; select3
		(viewGoals draw:)
		(= global302 local4)
		(return temp0)
	)
)

(instance playerNumber4 of ErasableDIcon
	(properties
		state 1
		nsTop 90
		nsLeft 150
		view 505
		loop 3
		cel 3
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= local4 global302)
		(= global302 ((ScriptID 1 2) at: 3)) ; players
		(proc0_15 viewGoals 291)
		((ScriptID 236) init: 0 2) ; select3
		(viewGoals draw:)
		(= global302 local4)
		(return temp0)
	)
)

(instance therm1 of DIcon
	(properties
		nsTop 35
		nsLeft 21
		view 505
		loop 1
		priority 13
	)
)

(instance therm2 of DIcon
	(properties
		nsTop 35
		nsLeft 65
		view 505
		loop 1
		priority 13
	)
)

(instance therm3 of DIcon
	(properties
		nsTop 35
		nsLeft 109
		view 505
		loop 1
		priority 13
	)
)

(instance therm4 of DIcon
	(properties
		nsTop 35
		nsLeft 153
		view 505
		loop 1
		priority 13
	)
)

(instance fineTherm1 of DIcon
	(properties
		nsTop 83
		nsLeft 22
		view 505
		loop 2
		priority 13
	)
)

(instance fineTherm2 of DIcon
	(properties
		nsTop 83
		nsLeft 66
		view 505
		loop 2
		priority 13
	)
)

(instance fineTherm3 of DIcon
	(properties
		nsTop 83
		nsLeft 110
		view 505
		loop 2
		priority 13
	)
)

(instance fineTherm4 of DIcon
	(properties
		nsTop 83
		nsLeft 154
		view 505
		loop 2
		priority 13
	)
)

(instance percent1 of DText
	(properties
		nsTop 25
		nsLeft 14
	)

	(method (draw &tmp [temp0 10])
		(self setPort:)
		(Display
			(Format @temp0 238 0 value) ; "%3d~"
			dsFONT
			4
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
		)
		(self resetPort:)
	)
)

(instance percent2 of DText
	(properties
		nsTop 25
		nsLeft 58
	)

	(method (draw &tmp [temp0 10])
		(self setPort:)
		(Display
			(Format @temp0 238 0 value) ; "%3d~"
			dsFONT
			4
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
		)
		(self resetPort:)
	)
)

(instance percent3 of DText
	(properties
		nsTop 25
		nsLeft 102
	)

	(method (draw &tmp [temp0 10])
		(self setPort:)
		(Display
			(Format @temp0 238 0 value) ; "%3d~"
			dsFONT
			4
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
		)
		(self resetPort:)
	)
)

(instance percent4 of DText
	(properties
		nsTop 25
		nsLeft 146
	)

	(method (draw &tmp [temp0 10])
		(self setPort:)
		(Display
			(Format @temp0 238 0 value) ; "%3d~"
			dsFONT
			4
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
		)
		(self resetPort:)
	)
)

