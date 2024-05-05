;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 218)
(include sci.sh)
(use Main)
(use WButton)
(use employment)
(use Interface)
(use KeyMouse)
(use System)

(public
	clothingJobs 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance clothingJobs of Dialog
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
			(proc0_17 1)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= client param1)
			(= global419 9)
			(if (== (global302 playing:) 29)
				(self setScript: JobScript -1)
				(JobScript cue:)
			)
			(self
				window: global59
				add:
					background
					jobsAvailable
					salesPerson
					assistManager
					manager
					exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: (client nsLeft:) (client nsTop:)
				open: 0 15
			)
			(= temp1 (KeyMouse curItem:))
			(proc0_9 self keyMouseList salesPerson)
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
		(DisposeScript 218)
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
		nsLeft 32
		text {QT Clothing Jobs Available:}
		shadowColor 107
	)
)

(instance salesPerson of JobDItem
	(properties
		nsTop 50
		nsLeft 25
		key 1
		text {Salesperson________||}
		shadowColor 107
		indexNum 47
		basePrice 7
		dependibility 30
		experience 30
		jobNum 8
		uniform 35
	)
)

(instance assistManager of JobDItem
	(properties
		nsTop 60
		nsLeft 25
		key 2
		text {Assistant Manager__}
		shadowColor 107
		indexNum 45
		basePrice 9
		dependibility 40
		experience 40
		education 14
		jobNum 9
		uniform 34
	)
)

(instance manager of JobDItem
	(properties
		nsTop 70
		nsLeft 25
		key 3
		text {Manager___________|}
		shadowColor 107
		indexNum 46
		basePrice 12
		dependibility 50
		experience 50
		education 15
		jobNum 10
		uniform 34
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

