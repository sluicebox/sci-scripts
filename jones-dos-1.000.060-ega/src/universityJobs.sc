;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use WButton)
(use employment)
(use Interface)
(use KeyMouse)
(use System)

(public
	universityJobs 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance universityJobs of Dialog
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
			(= global419 7)
			(if (== (global302 playing:) 29)
				(self setScript: JobScript -1)
				(JobScript cue:)
			)
			(self
				window: global59
				add:
					background
					jobsAvailable
					janitor
					teacher
					professor
					exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: (client nsLeft:) (client nsTop:)
				open: 0 15
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
		(proc0_15 self 291)
		(self dispose:)
		(proc0_17 0)
		(= global413 prevTalker)
		(if global519
			(global502 draw:)
			(proc206_1)
		)
		temp0
		(DisposeScript 220)
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
		nsTop 35
		nsLeft 34
		text {University Jobs Available:}
		shadowColor 107
	)
)

(instance janitor of JobDItem
	(properties
		nsTop 50
		nsLeft 25
		key 1
		text {Janitor            |}
		shadowColor 107
		indexNum 43
		basePrice 4
		jobNum 14
	)
)

(instance teacher of JobDItem
	(properties
		nsTop 60
		nsLeft 25
		key 2
		text {Teacher            }
		shadowColor 107
		indexNum 48
		basePrice 11
		dependibility 50
		experience 40
		education 16
		jobNum 15
		uniform 35
	)
)

(instance professor of JobDItem
	(properties
		nsTop 70
		nsLeft 25
		key 3
		text {Professor          }
		shadowColor 107
		indexNum 49
		basePrice 20
		dependibility 60
		experience 50
		education 19
		jobNum 16
		uniform 35
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 99
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

