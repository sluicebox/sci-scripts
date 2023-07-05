;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room250 0
)

(local
	local0
	local1
	[local2 200]
	local202
)

(procedure (localproc_0)
	(tree1 init:)
	(tree2 init:)
	(rock init:)
	(shed init:)
	(mushroom init:)
	(grass init:)
	(ground init:)
)

(instance Room250 of FRoom
	(properties
		lookStr {This place feels cool.}
		picture 250
		style 0
		horizon 65
		north 200
		south 300
		west 240
		invX 195
		invY 101
		friendX 170
		friendY 148
		northX 148
		northY 67
		southX 228
		southY 172
		westY 100
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(switch (gBremenStory state:)
			(4
				(Load rsSOUND 9)
			)
		)
		(super init:)
		(musicClient init: hide:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 173 249 173 249 147 308 146 308 113 241 108 229 103 198 102 180 95 161 88 160 72 158 64 152 57 159 2 103 2 107 60 71 63 43 66 0 70
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 102 49 110 57 132 71 156 124 167 124 173 0 173
					yourself:
				)
		)
		(localproc_0)
		(switch (gBremenStory state:)
			(4
				(Load rsSOUND 102)
				(= local1 ((gInventory at: 6) regActor:))
				(gEgo doCode: egoDo250)
				(local1
					view: 645
					doCode: doggieDo250
					normal: 0
					setCycle: Fwd
					selection: 0
					posn: friendX friendY
					init:
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gBremenStory state:)
			(4
				(gCurRoom setScript: enterBeforeDog)
			)
		)
	)

	(method (dispose)
		(switch (gBremenStory state:)
			(4
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(= global225 6)
			)
			(5
				(if (IsObject local1)
					(gEgo doCode: (gEgoTravCodeSet at: 2))
					(local1 selection: 0 doCode: (gFriendTravCodeSet at: 2))
				)
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(= global225 37)
			)
		)
		(super dispose: &rest)
	)
)

(instance dogSound of Sound
	(properties
		flags 1
		number 102
	)
)

(instance occasionalBark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 240))
			)
			(1
				(cond
					((and (local1 cel:) (> (gEgo x:) (local1 x:)))
						(local1
							view: 648
							cycleSpeed: 6
							setLoop: 1
							cel: 0
							setCycle: End
							setMotion:
								MoveTo
								(- (gCurRoom friendX:) 32)
								(gCurRoom friendY:)
								self
						)
					)
					((and (not (local1 cel:)) (< (gEgo x:) (local1 x:)))
						(local1
							view: 648
							cycleSpeed: 6
							setLoop: 0
							cel: 0
							setCycle: End
							setMotion:
								MoveTo
								(gCurRoom friendX:)
								(gCurRoom friendY:)
								self
						)
					)
					((local1 cel:)
						(local1 setLoop: 1 setCycle: End self)
					)
					(else
						(local1 setLoop: 0 setCycle: End self)
					)
				)
				(dogSound play:)
			)
			(2
				(cond
					((and (== (local1 view:) 648) (local1 loop:))
						(local1 view: 645 setLoop: 2 cel: 15 setCycle: Beg self)
					)
					((== (local1 view:) 648)
						(local1 view: 645 setLoop: 2 cel: 0 setCycle: End self)
					)
					(else
						(local1 setCycle: End self)
					)
				)
				(dogSound play:)
			)
			(3
				(cond
					((!= (local1 loop:) 2)
						(local1 setCycle: End self)
					)
					((local1 cel:)
						(local1 setLoop: 1 cel: 0 setCycle: End self)
					)
					(else
						(local1 setLoop: 0 cel: 0 setCycle: End self)
					)
				)
				(dogSound play:)
			)
			(4
				(if (local1 loop:)
					(local1 setLoop: 2 cel: 15)
				else
					(local1 setLoop: 2 cel: 0)
				)
				(if local202
					(self cue:)
				else
					(local1 setScript: self)
				)
			)
			(5
				(local1
					view: 647
					normal: 1
					setLoop: -1
					setCycle: StopWalk
					setMotion: NPFolDog gEgo 40
				)
				(self dispose:)
			)
		)
	)
)

(instance enterBeforeDog of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dogSound play:)
				(local1
					view: 648
					setLoop: 2
					cel: 0
					setStep: 8 2
					setCycle: End
					setMotion:
						MoveTo
						(- (gCurRoom friendX:) 32)
						(gCurRoom friendY:)
						self
				)
			)
			(1
				(dogSound play:)
				(local1
					cel: (local1 lastCel:)
					view: 645
					cycleSpeed: 3
					setLoop: 2
					setCycle: Beg self
				)
			)
			(2
				(dogSound play:)
				(local1
					view: 648
					cycleSpeed: 6
					setLoop: 0
					cel: 0
					setCycle: End
					setMotion: MoveTo (gCurRoom friendX:) (gCurRoom friendY:) self
				)
			)
			(3
				(dogSound play:)
				(local1
					view: 645
					cel: 0
					setLoop: 2
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(4
				(local1 cycleSpeed: 6)
				(proc10_13 1 local1 gEgo self 1 250 0)
			)
			(5
				(local1 setScript: occasionalBark)
				(self dispose:)
			)
		)
	)
)

(instance egoDo250 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(if (or (== (gBremenStory state:) 4) (== (gBremenStory state:) 5))
					(switch (gEgo selection:)
						(0
							(proc10_13
								0
								gEgo
								local1
								-1
								1
								(Format @local2 250 1 @global110) ; "Hello, dog. I'm %s. The cat and the rooster sent me to look for you."
							)
							(proc10_13 0 local1 gEgo -1 0 250 2)
							(proc10_13 0 local1 gEgo -1 0 250 3)
							(proc10_13 0 local1 gEgo -1 0 250 4)
							(proc10_13 0 local1 gEgo -1 1 250 5)
							(gBremenStory incState:)
							((local1 client:) moveTo: gEgo)
							(gTheIconBar curInvIcon: (gInventory at: 6) show:)
							(if (gGame script:)
								(gGame setScript: 0)
								(gGlobalMusic2 stop:)
							)
							(musicClient setScript: bremenMusic)
							(if ((local1 script:) state:)
								(= local202 1)
							else
								(local1
									view: 647
									normal: 1
									setLoop: -1
									setCycle: StopWalk
									setMotion: NPFolDog gEgo 40
								)
								(local1 setScript: 0)
							)
						)
						(1
							(proc10_13 0 gEgo local1 -1 1 250 6)
							(proc10_13 2 local1 gEgo -1 0 250 7)
							(proc10_13 2 local1 gEgo -1 1 250 8)
						)
						(2
							(proc10_13 0 gEgo local1 -1 1 250 9)
							(proc10_13 0 local1 gEgo -1 1 250 10)
							(proc10_13 0 gEgo local1 -1 1 250 11)
							(proc10_13 0 local1 gEgo -1 1 250 12)
						)
						(3
							(proc10_13 0 gEgo local1 -1 0 250 13)
							(proc10_13 0 gEgo local1 -1 1 250 14)
							(proc10_13 0 local1 gEgo -1 0 250 15)
							(proc10_13 0 local1 gEgo -1 1 250 16)
						)
						(else
							(proc10_13 0 gEgo local1 -1 1 250 17)
							(proc10_13 0 local1 gEgo -1 1 250 18)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance bremenMusic of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (== (gGlobalMusic prevSignal:) -1))
			(= local0 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMusic number: 19 priority: 15 setLoop: 1 play:)
				(= local0 1)
			)
			(1
				(= global225 0)
				(gGlobalMusic stop:)
				(gGlobalMusic2 number: 37 setLoop: -1 play: self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance doggieDo250 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(if (or (== (gBremenStory state:) 4) (== (gBremenStory state:) 5))
					(switch (local1 selection:)
						(0
							(proc10_13 2 local1 gEgo -1 0 250 19)
							(proc10_13 2 local1 gEgo -1 1 250 20)
						)
						(1
							(proc10_13 3 local1 gEgo -1 0 250 21)
							(proc10_13 3 local1 gEgo -1 1 250 8)
						)
						(2
							(proc10_13 0 local1 gEgo -1 1 250 22)
						)
						(3
							(proc10_13 2 local1 gEgo -1 1 250 23)
						)
						(else
							(proc10_13 0 local1 gEgo -1 1 250 24)
						)
					)
				)
				(local1 incSel:)
			)
		)
	)
)

(instance tree1 of Feature
	(properties
		x 210
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {This tree is old and big.}
	)
)

(instance tree2 of Feature
	(properties
		x 17
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {This tree is tall.}
	)
)

(instance rock of Feature
	(properties
		x 236
		y 88
		description {Rock}
		sightAngle 90
		onMeCheck 8
		lookStr {This rock has small holes in it.}
	)
)

(instance shed of Feature
	(properties
		x 145
		y 51
		description {Shed}
		sightAngle 90
		onMeCheck 16
		lookStr {You can see a shed from here.}
	)
)

(instance mushroom of Feature
	(properties
		x 172
		y 102
		description {Mushroom}
		sightAngle 90
		onMeCheck 32
		lookStr {The mushroom smells like an old sock.}
	)
)

(instance grass of Feature
	(properties
		x 187
		y 114
		description {Grass}
		sightAngle 90
		onMeCheck 64
		lookStr {There is not much grass here.}
	)
)

(instance ground of Feature
	(properties
		x 126
		y 135
		description {Ground}
		sightAngle 90
		onMeCheck 128
		lookStr {The ground is hard under your shoes.}
	)
)

(instance musicClient of Prop
	(properties
		x 252
		y 36
		view 270
		loop 1
		cel 1
	)
)

