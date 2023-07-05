;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room205 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2] = [3 3]
)

(procedure (localproc_0)
	(window1 init:)
	(cans init:)
	(plates init:)
	(cups init:)
	(box init:)
	(shelf init:)
	(stump init:)
	(stool init:)
	(shed init:)
)

(instance Room205 of FRoom
	(properties
		picture 205
		style 0
	)

	(method (init)
		(self defeatEntrance: 1)
		(LoadMany rsSOUND 126 139 140)
		(super init:)
		(localproc_0)
		(gTheIconBar enable: show:)
		(= local1 ((gInventory at: 5) regActor:))
		(= local2 ((gInventory at: 7) regActor:))
		(= local3 ((gInventory at: 4) regActor:))
		(= local0 ((gInventory at: 6) regActor:))
		(local3 setUp:)
		(local1 setUp:)
		(local2 setUp:)
		(local0 setUp:)
		(gEgo
			x: 160
			y: 101
			loop: 2
			cel: 0
			setPri: 4
			normal: 0
			setMotion: 0
			setCycle: 0
			ignoreActors: 1
			init:
		)
		(Slim init:)
		(slimSit init:)
		(Jim setPri: 14 init:)
		(jimSit init:)
		(theBoys init:)
		(catTail setCycle: Fwd init:)
		(dogTail setCycle: Fwd init:)
		(donEars setCycle: Fwd init:)
		(roosHead setCycle: Fwd init:)
		(bDoor init:)
		(tDoor init:)
	)

	(method (enterSpecial)
		(gCurRoom setScript: thieves)
	)
)

(instance smallOcil of Cycle
	(properties)

	(method (doit)
		(if (!= (client cel:) (self nextCel: &rest))
			(client cel: (- 7 (client cel:)))
		)
	)
)

(instance smallOcil2 of Cycle
	(properties)

	(method (doit)
		(if (!= (client cel:) (self nextCel: &rest))
			(client cel: (- 7 (client cel:)))
		)
	)
)

(instance localSound of Sound
	(properties
		flags 1
		number 139
	)
)

(instance allAnimalsSound of Sound
	(properties
		flags 1
		number 126
	)
)

(instance thieves of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBremenStory incState:)
				(Slim setCycle: End)
				(Jim setCycle: End)
				(= cycles 60)
			)
			(1
				(proc10_13 0 Slim Jim self 1 205 0)
			)
			(2
				(Jim setCycle: End self)
			)
			(3
				(proc10_13 0 Jim Slim self 1 205 1)
			)
			(4
				(Slim setCycle: Beg)
				(Jim setCycle: End self)
			)
			(5
				(proc10_13 0 Slim Jim self 1 205 2)
			)
			(6
				(Slim setCycle: End self)
			)
			(7
				(proc10_13 0 Jim Slim self 1 205 3)
			)
			(8
				(Jim setCycle: End)
				(Slim loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(proc10_13 0 local3 0 self 1 205 4)
			)
			(10
				(Jim setCycle: End self)
			)
			(11
				(proc10_13 0 local1 0 self 1 205 5)
			)
			(12
				(Slim setCycle: Beg self)
			)
			(13
				(proc10_13 0 local0 0 self 1 205 6)
			)
			(14
				(Jim setCycle: End self)
			)
			(15
				(proc10_13 0 local3 0 self 1 205 7)
			)
			(16
				(Slim setCycle: End self)
			)
			(17
				(proc10_13 0 local1 0 self 1 205 8)
			)
			(18
				(Jim setCycle: End self)
			)
			(19
				(proc10_13 0 local0 0 self 1 205 9)
			)
			(20
				(Slim setCycle: End self)
			)
			(21
				(proc10_13 0 local2 0 self 1 205 10)
			)
			(22
				(bDoor setScript: sAnimalSounds)
				(gGlobalMusic2 stop:)
				(gGlobalMusic number: 17 priority: 15 setLoop: -1 play:)
				(catTail hide:)
				(dogTail hide:)
				(donEars hide:)
				(roosHead hide:)
				(theBoys loop: 7 setCycle: Fwd)
				(jimSit dispose:)
				(Jim loop: 2 y: 109 cel: 0 setCycle: CT 3 1)
				(Slim loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(23
				(Jim setCycle: smallOcil)
				(Slim setCycle: smallOcil2)
				(= ticks 120)
			)
			(24
				(Jim cycleSpeed: 6 setCycle: End)
				(Slim cycleSpeed: 6 setCycle: End)
				(= cycles 10)
			)
			(25
				(theBoys loop: 2 cel: 0 setCycle: 0)
				(catTail show:)
				(dogTail show:)
				(donEars show:)
				(roosHead show:)
				(proc10_13 2 Slim Jim self 1 205 11)
			)
			(26
				(bowl init:)
				(Jim loop: 3 cel: 0 setCycle: End self)
			)
			(27
				(proc10_13 2 Jim Slim self 1 205 12)
			)
			(28
				(proc10_13 1 Slim Jim self 1 205 13)
			)
			(29
				(proc10_13 3 Jim Slim self 1 205 14)
			)
			(30
				(Jim setCycle: CT 4 -1)
				(Slim setCycle: CT 1 -1 self)
			)
			(31
				(proc10_13 2 Slim Jim self 1 205 15)
			)
			(32
				(proc10_13 3 Jim Slim self 1 205 16)
			)
			(33
				(Slim setCycle: CT 8 1 self)
			)
			(34
				(proc10_13 1 Slim Jim self 1 205 17)
			)
			(35
				(Jim setCycle: CT 10 1 self)
			)
			(36
				(proc10_13 2 Jim Slim self 1 205 18)
			)
			(37
				(proc10_13 1 Slim Jim self 1 205 19)
			)
			(38
				(slimSit dispose:)
				(Slim loop: 4 cel: 0 setCycle: End self)
			)
			(39
				(Slim setCycle: CT 9 -1)
				(Jim view: 662 loop: 0 cel: 0 setCycle: CT 12 1 self)
			)
			(40
				(localSound number: 139 play:)
				(bDoor setCycle: End)
				(Jim setCycle: End self)
			)
			(41
				(Slim setCycle: CT 12 1)
				(Jim loop: 1 cel: 0 setPri: 13 setCycle: End self)
			)
			(42
				(Jim
					setLoop: 2
					posn: 78 118
					moveSpeed: 3
					cycleSpeed: 3
					xStep: 6
					setCycle: Fwd
					setMotion: MoveTo -25 114 self
				)
			)
			(43
				(Slim view: 657 posn: 206 95 loop: 0 cel: 0 setCycle: End self)
			)
			(44
				(Slim
					posn: 196 115
					loop: 1
					cel: 0
					setCycle: Fwd
					setStep: 8 2
					setMotion: MoveTo 91 115 self
				)
			)
			(45
				(Slim
					posn: 94 115
					loop: 2
					setCel: 0
					cycleSpeed: 12
					setStep: 3 2
					setCycle: CT 1 1 self
				)
			)
			(46
				(localSound number: 140 play:)
				(Slim
					posn: 94 115
					loop: 2
					cycleSpeed: 12
					setStep: 3 2
					setCycle: CT 5 1 self
				)
			)
			(47
				(tDoor setCycle: End)
				(Slim setCycle: End self)
			)
			(48
				(Slim
					setCycle: Fwd
					posn: 30 118
					cycleSpeed: 6
					setLoop: 1
					cel: 2
					setStep: 8 2
					setMotion: MoveTo -20 118 self
				)
			)
			(49
				(Jim dispose:)
				(Slim dispose:)
				(= cycles 5)
			)
			(50
				(NormalEgo 5 global139)
				(gEgo normal: 1)
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance sAnimalSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allAnimalsSound play: self)
				(= seconds 4)
			)
			(1
				(allAnimalsSound play: self)
				(= seconds 4)
			)
			(2
				(allAnimalsSound play: self)
				(= seconds 4)
			)
			(3
				(allAnimalsSound play: self)
				(= seconds 4)
			)
			(4
				(allAnimalsSound play:)
				(self dispose:)
			)
		)
	)
)

(instance slimSit of View
	(properties
		x 206
		y 95
		view 655
		signal 16384
	)
)

(instance Slim of Tactor
	(properties
		x 206
		y 95
		description {It is Slim!}
		view 655
		loop 1
		signal 16384
		talkerID 10
	)

	(method (setUp)
		((= talkerObj slimTalkObj) setUp: slimBust slimEyes slimMouth)
	)
)

(instance slimTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 656
	)
)

(instance slimBust of View
	(properties
		nsTop 28
		nsLeft 44
		view 656
		loop 6
	)
)

(instance slimEyes of Prop
	(properties
		nsTop 30
		nsLeft 46
		view 656
		loop 4
		cycleSpeed 36
	)
)

(instance slimMouth of Prop
	(properties
		nsTop 40
		nsLeft 43
		view 656
		loop 2
		cycleSpeed 12
	)
)

(instance jimSit of View
	(properties
		x 128
		y 109
		view 660
		signal 16384
	)
)

(instance Jim of Tactor
	(properties
		x 128
		y 85
		description {It is Slim!}
		view 660
		loop 1
		signal 16384
		talkerID 11
	)

	(method (init)
		((= talkerObj jimTalkObj) setUp: jimBust jimEyes jimMouth)
		(super init: &rest)
	)
)

(instance jimTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 661
	)
)

(instance jimBust of View
	(properties
		nsTop 10
		nsLeft 34
		view 661
		loop 6
	)
)

(instance jimEyes of Prop
	(properties
		nsTop 22
		nsLeft 37
		view 661
		loop 4
		cycleSpeed 36
	)
)

(instance jimMouth of Prop
	(properties
		nsTop 28
		nsLeft 35
		view 661
		loop 2
		cycleSpeed 12
	)
)

(instance bowl of View
	(properties
		x 140
		y 90
		view 660
		loop 4
	)
)

(instance theBoys of Prop
	(properties
		x 167
		y 76
		view 205
		loop 2
	)
)

(instance bDoor of Prop
	(properties
		x 105
		y 108
		view 205
	)
)

(instance tDoor of Prop
	(properties
		x 105
		y 80
		view 205
		loop 1
	)
)

(instance catTail of Prop
	(properties
		x 145
		y 70
		view 205
		loop 6
	)
)

(instance dogTail of Prop
	(properties
		x 169
		y 64
		view 205
		loop 3
	)
)

(instance donEars of Prop
	(properties
		x 180
		y 60
		view 205
		loop 4
	)
)

(instance roosHead of Prop
	(properties
		x 189
		y 66
		view 205
		loop 5
	)
)

(instance window1 of Feature
	(properties
		x 164
		y 80
		description {Window}
		sightAngle 90
		onMeCheck 4
		lookStr {You can see into the shed through the window.}
	)
)

(instance table of Feature ; UNUSED
	(properties
		x 169
		y 110
		description {Table}
		sightAngle 90
		onMeCheck 8
		lookStr {This table is made of wood.}
	)
)

(instance cans of Feature
	(properties
		x 215
		y 90
		description {Cans}
		sightAngle 90
		onMeCheck 16
		lookStr {The cans are full of food.}
	)
)

(instance plates of Feature
	(properties
		x 215
		y 83
		description {Plates}
		sightAngle 90
		onMeCheck 32
		lookStr {The plates sit on the shelf.}
	)
)

(instance cups of Feature
	(properties
		x 222
		y 80
		description {Cups}
		sightAngle 90
		onMeCheck 64
		lookStr {The cups hang under the shelf.}
	)
)

(instance box of Feature
	(properties
		x 224
		y 65
		description {Box}
		sightAngle 90
		onMeCheck 128
		lookStr {This box sits on top of the shelf.}
	)
)

(instance shelf of Feature
	(properties
		x 216
		y 74
		description {Shelf}
		sightAngle 90
		onMeCheck 256
		lookStr {Many things are on the shelf.}
	)
)

(instance stump of Feature
	(properties
		x 203
		y 124
		description {Stump}
		sightAngle 90
		onMeCheck 512
		lookStr {This stump is used as a stool.}
	)
)

(instance stool of Feature
	(properties
		x 125
		y 120
		description {Stool}
		sightAngle 90
		onMeCheck 1024
		lookStr {This box is used as a stool.}
	)
)

(instance shed of Feature
	(properties
		x 147
		y 60
		description {Shed}
		sightAngle 90
		onMeCheck 2048
		lookStr {This shed is made of wood.}
	)
)

