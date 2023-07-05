;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use System)

(public
	Room240 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(tree1 init:)
	(tree2 init:)
	(wallNear init:)
	(wallFar init:)
	(rock init:)
	(flowers init:)
)

(instance Room240 of FRoom
	(properties
		lookStr {This place is warm.}
		picture 240
		style 0
		horizon 70
		north 190
		east 250
		west 230
		invX 102
		invY 115
		friendX 189
		friendY 107
		northX 123
		northY 10
		eastX 320
		eastY 133
		westY 145
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((not (gCast contains: local1)) 0)
			(local0 0)
			(
				(and
					(not (gSnowStory selected:))
					(or
						(> (gEgo x:) 305)
						(< (gEgo x:) 15)
						(< (gEgo y:) 82)
					)
				)
				(gCurRoom setScript: encourage)
			)
		)
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 174 319 174 319 199 0 199
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 -26 85 -26 78 63 80 97 117 100 117 110 76 118 59 124 31 123 0 126
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 119 292 118 274 123 225 113 222 94 211 84 207 84 207 76 223 71 224 66 207 61 128 60 130 -26 319 -26
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 89 171 220 149 293 173 80 173
					yourself:
				)
		)
		(localproc_0)
		(= local1 ((gInventory at: 10) regActor:))
		(if (not (proc10_18))
			(gSnowStory selectCode: snowSelect)
			(if (and (== (gSnowStory state:) 0) (not (proc10_18)))
				(gEgo doCode: egoDo240)
				(Load rsSOUND 13)
				(local1
					view: 670
					loop: 0
					cel: 0
					posn: friendX friendY
					setLoop: -1
					normal: 0
					doCode: snowDo240
					selection: 0
					init:
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (and (not (proc10_18)) (== (gSnowStory state:) 0))
			(gCurRoom setScript: enterBeforeStory)
		)
	)

	(method (dispose)
		(if (== (gSnowStory state:) 1)
			(gEgo doCode: (gEgoTravCodeSet at: 4))
			(local1 doCode: (gFriendTravCodeSet at: 4))
		)
		(if (== (gEgo doCode:) egoDo240)
			(gEgo doCode: 0)
		)
		(gSnowStory selectCode: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
		)
		(= global225 15)
		(super dispose: &rest)
	)
)

(instance enterBeforeStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setCycle: Fwd)
				(= cycles 25)
			)
			(1
				(local1 setCycle: 0)
				(proc10_13 3 local1 gEgo self 1 240 0)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance encourage of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(Face gEgo local1)
				(= cycles 1)
			)
			(2
				(proc10_13 3 local1 gEgo self 1 240 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance storySelect of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSnowStory selected: 1 incState:)
				(= global143 gSnowStory)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 13 priority: 15 setLoop: -1 play:)
				(self setScript: (ScriptID 91 1) self) ; DisplayStart
			)
			(1
				(proc10_13 0 local1 gEgo self 1 240 2)
			)
			(2
				((local1 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 10) show:)
				(local1 hide: view: 672 loop: 0 normal: 1 setCycle: StopWalk)
				(local1 show: setMotion: NPFollow gEgo 40)
				(= cycles 1)
			)
			(3
				(gEgo selection: 0)
				(local1 selection: 0)
				(self dispose:)
			)
		)
	)
)

(instance snowSelect of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: storySelect)
	)
)

(instance egoDo240 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gSnowStory state:)
					(0
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo local1 -1 1 240 3)
								(proc10_13 3 local1 gEgo -1 0 240 4)
								(proc10_13 1 local1 gEgo -1 0 240 5)
								(proc10_13 3 local1 gEgo -1 1 240 6)
							)
							(1
								(proc10_13 1 gEgo local1 -1 1 240 7)
								(proc10_13 2 local1 gEgo -1 1 240 8)
							)
							(2
								(proc10_13 2 gEgo local1 -1 1 240 9)
								(proc10_13 2 local1 gEgo -1 1 240 10)
								(proc10_13 0 local1 gEgo -1 1 240 11)
							)
							(else
								(proc10_13 2 gEgo local1 -1 1 240 12)
								(proc10_13 0 local1 gEgo -1 1 240 13)
								(proc10_13 3 local1 gEgo -1 1 240 14)
								(proc10_13 0 local1 gEgo -1 1 240 15)
							)
						)
					)
					(1
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo local1 -1 1 240 16)
								(proc10_13 0 local1 gEgo -1 1 240 17)
							)
							(1
								(proc10_13 2 gEgo local1 -1 1 240 18)
								(proc10_13 0 local1 gEgo -1 1 240 19)
							)
							(2
								(proc10_13 0 gEgo local1 -1 1 240 20)
								(proc10_13 0 local1 gEgo -1 1 240 21)
							)
							(else
								(proc10_13 0 gEgo local1 -1 1 240 22)
								(proc10_13 0 local1 gEgo -1 1 240 23)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance snowDo240 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gSnowStory state:)
					(0
						(switch (local1 selection:)
							(0
								(proc10_13 3 local1 gEgo -1 1 240 24)
							)
							(1
								(proc10_13 3 local1 gEgo -1 1 240 25)
							)
							(2
								(proc10_13 0 local1 gEgo -1 1 240 26)
							)
							(else
								(proc10_13 0 local1 gEgo -1 1 240 27)
							)
						)
					)
					(1
						(switch (local1 selection:)
							(0
								(proc10_13 0 local1 gEgo -1 1 240 28)
							)
							(1
								(proc10_13 0 local1 gEgo -1 1 240 29)
							)
							(2
								(proc10_13 2 local1 gEgo -1 1 240 30)
							)
							(else
								(proc10_13 0 local1 gEgo -1 1 240 31)
							)
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
		x 16
		y 58
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {This tree is very old.}
	)
)

(instance tree2 of Feature
	(properties
		x 237
		y 63
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {This is a pine tree.}
	)
)

(instance wallFar of Feature
	(properties
		x 63
		y 50
		description {Wall}
		sightAngle 90
		onMeCheck 16
		lookStr {You can see the wall of the town very far away.}
	)
)

(instance rock of Feature
	(properties
		x 61
		y 106
		description {Rock}
		sightAngle 90
		onMeCheck 32
		lookStr {The rock feels smooth to your touch.}
	)
)

(instance flowers of Feature
	(properties
		x 243
		y 127
		description {Flowers}
		sightAngle 90
		onMeCheck 64
		lookStr {The flowers smell nice.}
	)
)

(instance wallNear of Feature
	(properties
		x 172
		y 140
		description {Wall}
		sightAngle 90
		onMeCheck 8
		lookStr {This wall is high and has spikes on the top.}
	)
)

