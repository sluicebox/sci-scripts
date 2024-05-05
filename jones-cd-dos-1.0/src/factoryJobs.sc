;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use WButton)
(use employment)
(use Interface)
(use KeyMouse)
(use System)

(public
	factoryJobs 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance factoryJobs of Dialog
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
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= client param1)
			(= global419 5)
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
					assemblyWorker
					secretary
					machinistsHelper
					executiveSecretary
					machinist
					departmentManager
					engineer
					generalManager
					exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: (client nsLeft:) (client nsTop:)
				open: 0 -1
			)
			(= temp1 (KeyMouse curItem:))
			(proc0_9 self keyMouseList assemblyWorker)
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
		(DisposeScript 221)
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
		nsTop 19
		nsLeft 40
		text {Factory Jobs Available:}
		shadowColor 107
	)
)

(instance janitor of JobDItem
	(properties
		nsTop 30
		nsLeft 25
		key 1
		text {Janitor____________|||}
		shadowColor 107
		indexNum 43
		basePrice 7
		dependibility 20
		jobNum 18
	)
)

(instance assemblyWorker of JobDItem
	(properties
		nsTop 38
		nsLeft 25
		key 2
		text {Assembly Worker____||||}
		shadowColor 107
		indexNum 50
		basePrice 8
		dependibility 30
		experience 30
		education 10
		jobNum 17
	)
)

(instance secretary of JobDItem
	(properties
		nsTop 46
		nsLeft 25
		key 3
		text {Secretary__________||}
		shadowColor 107
		indexNum 51
		basePrice 9
		dependibility 40
		experience 40
		education 14
		jobNum 19
		uniform 35
	)
)

(instance machinistsHelper of JobDItem
	(properties
		nsTop 54
		nsLeft 25
		key 4
		text {Machinist's Helper___|}
		shadowColor 107
		indexNum 52
		basePrice 10
		dependibility 40
		experience 40
		education 12
		jobNum 20
	)
)

(instance executiveSecretary of JobDItem
	(properties
		nsTop 62
		nsLeft 25
		key 5
		text {Executive Secretary ||}
		shadowColor 107
		indexNum 53
		basePrice 18
		dependibility 50
		experience 50
		education 15
		jobNum 21
		uniform 34
	)
)

(instance machinist of JobDItem
	(properties
		nsTop 70
		nsLeft 25
		key 6
		text {Machinist___________}
		shadowColor 107
		indexNum 54
		basePrice 19
		dependibility 50
		experience 50
		education 13
		jobNum 22
	)
)

(instance departmentManager of JobDItem
	(properties
		nsTop 78
		nsLeft 25
		key 7
		text {Department Manager }
		shadowColor 107
		indexNum 56
		basePrice 22
		dependibility 60
		experience 60
		education 14
		education2 13
		jobNum 23
		uniform 34
	)
)

(instance engineer of JobDItem
	(properties
		nsTop 86
		nsLeft 25
		key 8
		text {Engineer____________}
		shadowColor 107
		indexNum 55
		basePrice 23
		dependibility 60
		experience 60
		education 13
		education2 14
		jobNum 24
		uniform 34
	)
)

(instance generalManager of JobDItem
	(properties
		nsTop 94
		nsLeft 25
		key 10
		text {General Manager____||}
		shadowColor 107
		indexNum 57
		basePrice 25
		dependibility 70
		experience 70
		education 15
		education2 13
		jobNum 25
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

