;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use n402)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room200 0
)

(local
	local0
	local1
	local2
	local3
	[local4 200]
)

(procedure (localproc_0)
	(tree1 init:)
	(tree2 init:)
	(tree3 init:)
	(log init:)
	(road init:)
	(branch init:)
	(stump init:)
	(shed init:)
	(window1 init:)
	(roof init:)
	(grass init:)
	(rock init:)
	(pond init:)
	(plant init:)
)

(instance Room200 of FRoom
	(properties
		picture 200
		style 0
		horizon 45
		north 150
		south 250
		west 190
		invX 234
		invY 127
		northX 73
		northY 57
		southX 128
		southY 180
		westY 68
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(if (OneOf (gBremenStory state:) 8 9)
			(LoadMany rsVIEW 652 641 631 646 636)
		)
		(if (== (gBremenStory state:) 8)
			(Load rsSOUND 17)
		)
		(if (== (gBremenStory state:) 9)
			(Load rsSOUND 126)
			(self defeatEntrance: 1)
			(door cel: 1 init:)
			((= local2 ((gInventory at: 7) regActor:))
				view: 651
				setLoop: 1
				cel: 0
				posn: 150 110
				init:
			)
		else
			(door cel: 0 init:)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 230 131 229 139 212 139 209 131
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 218 118 221 124 178 124 178 118
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 100 0 269 0 319 -26 319 103 319 173 180 173 182 169 285 165 283 147 242 138 235 123 229 115 257 106 263 100 236 97 193 96 188 100 173 103 163 96 128 108 110 103 94 106 84 102 97 93 112 84 125 84 116 71 109 55 70 0
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 49 0 0 36 0 39 46 yourself:)
		)
		(localproc_0)
		(if (OneOf (gBremenStory state:) 9 8)
			(= local1 ((gInventory at: 5) regActor:))
			(= local3 ((gInventory at: 4) regActor:))
			(= local0 ((gInventory at: 6) regActor:))
			(= local2 ((gInventory at: 7) regActor:))
			(local1 normal: 0 setUp:)
			(local3 setUp:)
			(local0 setUp:)
			(local2 normal: 0)
		)
	)

	(method (enterSpecial)
		(self cue:)
	)

	(method (cue)
		(super cue:)
		(switch (gBremenStory state:)
			(8
				(gCurRoom setScript: enterWithBrems)
			)
			(9
				(gEgo posn: 198 96 setCycle: StopWalk init:)
				(gCurRoom setScript: enterThievesGone)
			)
		)
	)

	(method (dispose)
		(if defeatEntrance
			(self defeatEntrance: 0)
		)
		(super dispose: &rest)
	)
)

(instance lookInShack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 179 103 self)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 1)
			)
			(2
				(proc402_0)
				(= cycles 1)
			)
			(3
				((gEgo head:) setPri: -1)
				(Animate (gCast elements:) 1)
				(self dispose:)
			)
		)
	)
)

(instance enterWithBrems of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveFwd 20 self)
			)
			(1
				(local2
					view: 651
					setCycle: Walk
					posn: (gCurRoom westX:) (gCurRoom westY:)
					init:
					ignoreActors: 1
					setMotion: NPFollow gEgo 40
				)
				(= ticks 2)
			)
			(2
				(gEgo setMotion: PolyPath 65 88 self)
			)
			(3
				(gEgo setMotion: PolyPath 86 120)
				(local2 setMotion: PolyPath 65 88 self)
			)
			(4
				(proc10_13 1 local3 gEgo self 1 200 0)
			)
			(5
				(proc10_13 2 local1 gEgo self 1 200 1)
			)
			(6
				(proc10_13 3 local0 gEgo self 1 200 2)
			)
			(7
				(proc10_13 0 local2 gEgo self 1 200 3)
			)
			(8
				(proc10_13 0 local3 gEgo self 1 200 4)
			)
			(9
				(proc10_13 0 local1 gEgo self 1 200 5)
			)
			(10
				(proc10_13 0 local0 gEgo self 1 200 6)
			)
			(11
				(proc10_13 0 local2 gEgo self 1 200 7)
			)
			(12
				(gEgo setMotion: PolyPath 179 103)
				(local2 setMotion: PolyPath 157 118 self)
			)
			(13
				(gEgo setHeading: 0)
				(local2
					view: 652
					posn: 163 108
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(14
				(local1
					posn: 178 68
					view: 652
					setPri: 7
					setLoop: 1
					cel: 0
					init:
				)
				(local3
					posn: 160 59
					view: 652
					setPri: 8
					setLoop: 0
					cel: 0
					init:
				)
				(local2 posn: 163 108 view: 652 setLoop: 3 cel: 0)
				(= ticks 6)
			)
			(15
				(local3 setCycle: CT 2 1 self)
			)
			(16
				(local3 setPri: 5 setCycle: End self)
			)
			(17
				(local1 setCycle: CT 4 1 self)
			)
			(18
				(local1 setPri: 5 setCycle: End self)
			)
			(19
				(gGlobalMusic2 fade: 64 15 12 0)
				(gCurRoom newRoom: 205)
			)
		)
	)
)

(instance enterThievesGone of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc10_13 0 local3 gEgo self 1 200 8)
			)
			(2
				(proc10_13 0 local1 gEgo self 1 200 9)
			)
			(3
				(proc10_13 2 local0 gEgo self 1 200 10)
			)
			(4
				(proc10_13 0 local2 gEgo self 1 200 11)
			)
			(5
				(proc10_13 1 gEgo local2 self 1 200 12)
			)
			(6
				(proc10_13 2 local3 gEgo self 1 200 13)
			)
			(7
				(proc10_13 2 local1 gEgo self 1 200 14)
			)
			(8
				(proc10_13 1 local0 gEgo self 1 200 15)
			)
			(9
				(proc10_13 0 local2 gEgo self 1 200 16)
			)
			(10
				(proc10_13 0 local3 gEgo -1 0 200 17)
				(proc10_13 0 local3 gEgo self 1 200 18)
			)
			(11
				(proc10_13 0 local1 gEgo self 1 200 19)
			)
			(12
				(proc10_13 0 local0 gEgo self 1 200 20)
			)
			(13
				(proc10_13
					0
					local2
					gEgo
					self
					1
					(Format @local4 200 21 @global110) ; "Thank you, %s, for all your help."
				)
			)
			(14
				(proc10_13 0 local0 gEgo self 1 200 22)
			)
			(15
				(proc10_13
					0
					local1
					gEgo
					self
					1
					(Format @local4 200 23 @global110) ; "Thank you, %s."
				)
			)
			(16
				(proc10_13 0 local3 gEgo self 1 200 24)
			)
			(17
				(allAnimalsSing play:)
				(local2 setCycle: Fwd)
				(= cycles 25)
			)
			(18
				(gBremenStory done: 1)
				(gBremenStory incState:)
				(++ global145)
				(= global144 gBremenStory)
				(if (and (gGlobalMusic handle:) (== (gGlobalMusic number:) 17))
					(gGlobalMusic stop:)
					(gGlobalMusic number: 18 priority: 15 setLoop: 1 play:)
				)
				(self setScript: (ScriptID 91 2) self) ; DisplayEnd
			)
			(19
				(gEgo
					setMotion: PolyPath (gCurRoom westX:) (gCurRoom westY:) self
				)
			)
			(20
				(= global142 0)
				(if (== global144 global143)
					(= global143 0)
				)
				(gCurRoom newRoom: 190)
				(= global225 6)
				(self dispose:)
			)
		)
	)
)

(instance allAnimalsSing of Sound
	(properties
		flags 1
		number 126
		loop -1
	)
)

(instance door of Prop
	(properties
		x 219
		y 45
		description {Door}
		lookStr {The door is closed.}
		view 200
	)
)

(instance tree1 of Feature
	(properties
		x 35
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {You can see an apple tree.}
	)
)

(instance tree2 of Feature
	(properties
		x 14
		y 150
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {This is a pine tree.}
	)
)

(instance tree3 of Feature
	(properties
		x 298
		y 66
		description {Tree}
		sightAngle 90
		onMeCheck 8
		lookStr {You think this is an elm tree.}
	)
)

(instance log of Feature
	(properties
		x 246
		y 160
		description {Log}
		sightAngle 90
		onMeCheck 16
		lookStr {Someone dragged this log over here.}
	)
)

(instance road of Feature
	(properties
		x 62
		y 86
		description {Road}
		sightAngle 90
		onMeCheck 32
		lookStr {The road from the west ends here.}
	)
)

(instance branch of Feature
	(properties
		x 75
		y 35
		description {Branch}
		sightAngle 90
		onMeCheck 64
		lookStr {This branch has no leaves.}
	)
)

(instance stump of Feature
	(properties
		x 120
		y 107
		description {Stump}
		sightAngle 90
		onMeCheck 128
		lookStr {This stump is where a tree once grew.}
	)
)

(instance shed of Feature
	(properties
		x 209
		y 81
		description {Shed}
		sightAngle 90
		onMeCheck 256
		lookStr {This shed is old.}
	)
)

(instance window1 of Feature
	(properties
		x 176
		y 80
		description {Window}
		sightAngle 90
		onMeCheck 512
		lookStr {When you look in the window, you can see a table.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (gEgo script:))
					(gEgo setScript: lookInShack)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roof of Feature
	(properties
		x 240
		y 35
		description {Roof}
		sightAngle 90
		onMeCheck 1024
		lookStr {The roof has grass on it.}
	)
)

(instance grass of Feature
	(properties
		x 156
		y 120
		description {Grass}
		sightAngle 90
		onMeCheck 4096
		lookStr {The grass is green.}
	)
)

(instance rock of Feature
	(properties
		x 198
		y 140
		description {Rock}
		sightAngle 90
		onMeCheck 8192
		lookStr {The rock is gray.}
	)
)

(instance pond of Feature
	(properties
		x 50
		y 35
		description {Pond}
		sightAngle 90
		onMeCheck 16384
		lookStr {There is a small pond near here.}
	)
)

(instance plant of Feature
	(properties
		x 282
		y 109
		description {Plant}
		sightAngle 90
		onMeCheck -32768
		lookStr {This smells like root beer.}
	)
)

