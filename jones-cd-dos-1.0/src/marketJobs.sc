;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use WButton)
(use employment)
(use Interface)
(use KeyMouse)
(use System)

(public
	marketJobs 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance marketJobs of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1)
		(if (not global518)
			(gASong pause: 0)
			(= prevTalker global413)
			(= global413 0)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= client param1)
			(= global419 3)
			(if (== (global302 playing:) 29)
				(self setScript: JobScript -1)
				(JobScript cue:)
			)
			(self
				window: global38
				add:
					background
					jobsAvailable
					janitor
					checker
					butcher
					assistManager
					manager
					exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: (client nsLeft:) (client nsTop:)
				open: 0 -1
			)
			(= temp1 (KeyMouse curItem:))
			(proc0_9 self keyMouseList janitor)
			(KeyMouse setList: keyMouseList)
		else
			(KeyMouse setCursor: theItem)
			(= global519 1)
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
		(keyMouseList release:)
		(keyMouseList dispose:)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(proc0_17 0)
		(= global413 prevTalker)
		(if global519
			(global502 draw:)
			(proc206_1)
		)
		temp0
		(DisposeScript 223)
	)
)

(instance background of DIcon
	(properties
		view 706
		cel 1
	)
)

(instance jobsAvailable of WButton
	(properties
		state 0
		nsTop 30
		nsLeft 22
		text {Black's Market Jobs Available:}
		shadowColor 107
	)
)

(instance janitor of JobDItem
	(properties
		nsTop 45
		nsLeft 25
		key 1
		text {Janitor            |}
		shadowColor 107
		indexNum 43
		basePrice 6
		jobNum 31
	)
)

(instance checker of JobDItem
	(properties
		nsTop 55
		nsLeft 25
		key 2
		text {Checker            |}
		shadowColor 107
		indexNum 60
		basePrice 8
		dependibility 20
		experience 20
		jobNum 32
	)
)

(instance butcher of JobDItem
	(properties
		nsTop 65
		nsLeft 25
		key 3
		text {Butcher           ||||}
		shadowColor 107
		indexNum 61
		basePrice 12
		dependibility 30
		experience 30
		education 10
		jobNum 33
	)
)

(instance assistManager of JobDItem
	(properties
		nsTop 75
		nsLeft 25
		key 4
		text {Assistant Manager  }
		shadowColor 107
		indexNum 45
		basePrice 15
		dependibility 40
		experience 40
		education 14
		jobNum 34
		uniform 35
	)
)

(instance manager of JobDItem
	(properties
		nsTop 85
		nsLeft 25
		key 5
		text {Manager           |}
		shadowColor 107
		indexNum 46
		basePrice 18
		dependibility 50
		experience 50
		education 15
		jobNum 35
		uniform 34
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		view 250
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global433 -2)
		(return temp0)
	)
)

